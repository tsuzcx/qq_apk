package com.tencent.tbs.one.impl.policy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.Factory;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.MixedCancellableJob;
import com.tencent.tbs.one.impl.base.ProcessLock;
import com.tencent.tbs.one.impl.base.ProgressiveCallback;
import com.tencent.tbs.one.impl.base.ThreadUtils;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.common.DEPSConfig.ComponentConfig;
import com.tencent.tbs.one.impl.common.PathService;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import com.tencent.tbs.one.impl.debug.DebuggerImpl;
import com.tencent.tbs.one.impl.policy.builtin.BuiltinComponentInstallationJob;
import com.tencent.tbs.one.impl.policy.builtin.BuiltinDEPSInstallationJob;
import com.tencent.tbs.one.impl.policy.online.OnlineComponentInstallationJob;
import com.tencent.tbs.one.impl.policy.online.OnlineDEPSInstallationJob;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class PolicyManagerImpl
  extends PolicyManager
{
  private static final long AUTO_UPDATE_INTERVAL = 86400000L;
  private static final int DELAY_MILLISECOND = 10000;
  private DebuggerImpl mDebugger;
  private final Object mDebuggerLock = new Object();
  private String mDefaultLocalRepositoryPath;
  private String mDefaultOnlineServiceUrl;
  private String[] mDefaultSharableApplicationPackages;
  private Set<String> mDisabledComponentNames;
  private final Runnable mIdleRunnable = new PolicyManagerImpl.1(this);
  private String mLocalRepositoryPath;
  private OnlineServiceImpl mOnlineService;
  private final Object mOnlineServiceLock = new Object();
  private String mOnlineServiceUrl;
  private String[] mSharableApplicationPackages;
  private SharedPreferences mSharedPreferences;
  
  public PolicyManagerImpl(Context paramContext, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    super(paramContext, paramString1);
    this.mDefaultLocalRepositoryPath = paramString2;
    this.mDefaultOnlineServiceUrl = paramString3;
    this.mDefaultSharableApplicationPackages = paramArrayOfString;
    this.mSharedPreferences = paramContext.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", new Object[] { paramString1 }), 4);
    if (!this.mSharedPreferences.contains("last_update_time")) {
      updateLastUpdateTime();
    }
    this.mDisabledComponentNames = this.mSharedPreferences.getStringSet("disabled_component_names", new HashSet());
    Logging.i("[%s] Disabled components {%s} from preferences", new Object[] { paramString1, TextUtils.join(", ", this.mDisabledComponentNames) });
    scheduleIdleTask();
  }
  
  private File getIncompleteUpdateFlagFile()
  {
    return new File(getCategoryDirectory(), "incomplete-update");
  }
  
  private String getLocalRepository()
  {
    if (this.mLocalRepositoryPath == null)
    {
      Object localObject = getDelegate();
      if (localObject == null) {
        break label54;
      }
      localObject = ((TBSOneDelegate)localObject).shouldOverrideLocalRepositoryPath(getCategory(), this.mDefaultLocalRepositoryPath);
      if (localObject == null) {
        break label43;
      }
      this.mLocalRepositoryPath = ((String)localObject);
    }
    for (;;)
    {
      return this.mLocalRepositoryPath;
      label43:
      this.mLocalRepositoryPath = this.mDefaultLocalRepositoryPath;
      continue;
      label54:
      this.mLocalRepositoryPath = this.mDefaultLocalRepositoryPath;
    }
  }
  
  private void markCategoryInUse()
  {
    File localFile = PathService.getInUseCategoryFlagFile(PathService.getProcessDirectory(PathService.getDataRootDirectory(getCallerContext()), Process.myPid()), getCategory());
    FileUtils.mkdirsAnywayWithWarning(localFile.getParentFile());
    if (!localFile.exists()) {
      FileUtils.createFileWithWarning(localFile);
    }
  }
  
  private void scheduleIdleTask()
  {
    Handler localHandler = ThreadUtils.getCoreThreadHandler();
    localHandler.removeCallbacks(this.mIdleRunnable);
    localHandler.postDelayed(this.mIdleRunnable, 10000L);
  }
  
  private void updateInUseComponentNames(String paramString)
  {
    markCategoryInUse();
    HashSet localHashSet = new HashSet(Arrays.asList(getInUseComponentNames()));
    localHashSet.add(paramString);
    paramString = this.mSharedPreferences.edit();
    paramString.putStringSet("in_use_component_names", localHashSet);
    paramString.apply();
  }
  
  private void updateLastUpdateTime()
  {
    SharedPreferences.Editor localEditor = this.mSharedPreferences.edit();
    localEditor.putLong("last_update_time", System.currentTimeMillis());
    localEditor.apply();
  }
  
  private boolean verifyComponentAvailability(String paramString, TBSOneCallback paramTBSOneCallback)
  {
    if (this.mDisabledComponentNames.contains(paramString))
    {
      if (paramTBSOneCallback != null) {
        paramTBSOneCallback.onError(501, "The component has disabled");
      }
      return false;
    }
    return true;
  }
  
  public void configure(String paramString, Object paramObject)
  {
    super.configure(paramString, paramObject);
    if (paramString.equals("permanent_version")) {
      setAutoUpdateEnabled(false);
    }
  }
  
  public void createIncompleteUpdateFlag()
  {
    File localFile = getIncompleteUpdateFlagFile();
    if (!localFile.exists()) {
      FileUtils.createFileWithWarning(localFile);
    }
  }
  
  public void deleteIncompleteUpdateFlag()
  {
    File localFile = getIncompleteUpdateFlagFile();
    if (localFile.exists()) {
      FileUtils.deleteFileWithWarning(localFile);
    }
  }
  
  public void doUpdate(Bundle paramBundle)
  {
    getOnlineService().update(paramBundle, new PolicyManagerImpl.2(this));
  }
  
  public TBSOneDebugger getDebugger()
  {
    synchronized (this.mDebuggerLock)
    {
      if (this.mDebugger == null) {
        this.mDebugger = new DebuggerImpl(getCategory());
      }
      DebuggerImpl localDebuggerImpl = this.mDebugger;
      return localDebuggerImpl;
    }
  }
  
  public String[] getInUseComponentNames()
  {
    return (String[])this.mSharedPreferences.getStringSet("in_use_component_names", new HashSet()).toArray(new String[0]);
  }
  
  public int getInUseDEPSVersion()
  {
    return this.mSharedPreferences.getInt("in_use_deps_version", -1);
  }
  
  public int[] getInstalledVersionCodesOfComponent(String paramString)
  {
    paramString = getComponentDirectory(paramString);
    int[] arrayOfInt;
    int j;
    int i;
    File localFile;
    if (paramString.exists())
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        arrayOfInt = new int[paramString.length];
        int m = paramString.length;
        j = 0;
        i = 0;
        if (j < m)
        {
          localFile = paramString[j];
          if ((!localFile.isDirectory()) || (!InstallationUtils.isArchiveComplete(localFile))) {
            break label136;
          }
        }
      }
    }
    label136:
    for (;;)
    {
      try
      {
        int n = Integer.parseInt(localFile.getName());
        int k = i + 1;
        arrayOfInt[i] = n;
        i = k;
      }
      catch (Exception localException)
      {
        Logging.e("[%s] Failed to parse installed version from path %s", new Object[] { getCategory(), localFile.getAbsolutePath() });
        continue;
      }
      j += 1;
      break;
      return Arrays.copyOfRange(arrayOfInt, 0, i);
      return new int[0];
    }
  }
  
  public File getLatestDEPSFile()
  {
    return PathService.getLatestDEPSFile(getCategoryDirectory());
  }
  
  public TBSOneOnlineService getOnlineService()
  {
    if (!useOnlineService()) {
      return null;
    }
    synchronized (this.mOnlineServiceLock)
    {
      if (this.mOnlineService == null) {
        this.mOnlineService = new OnlineServiceImpl(this);
      }
      OnlineServiceImpl localOnlineServiceImpl = this.mOnlineService;
      return localOnlineServiceImpl;
    }
  }
  
  public String getOnlineServiceUrl()
  {
    if (this.mOnlineServiceUrl == null)
    {
      Object localObject = getDelegate();
      if (localObject == null) {
        break label54;
      }
      localObject = ((TBSOneDelegate)localObject).shouldOverrideOnlineServiceUrl(getCategory(), this.mDefaultOnlineServiceUrl);
      if (localObject == null) {
        break label43;
      }
      this.mOnlineServiceUrl = ((String)localObject);
    }
    for (;;)
    {
      return this.mOnlineServiceUrl;
      label43:
      this.mOnlineServiceUrl = this.mDefaultOnlineServiceUrl;
      continue;
      label54:
      this.mOnlineServiceUrl = this.mDefaultOnlineServiceUrl;
    }
  }
  
  public SharedPreferences getPreferences()
  {
    return this.mSharedPreferences;
  }
  
  public String[] getSharableApplicationPackages()
  {
    if (this.mSharableApplicationPackages == null)
    {
      Object localObject = getDelegate();
      if (localObject == null) {
        break label54;
      }
      localObject = ((TBSOneDelegate)localObject).shouldOverrideSharableApplicationPackages(getCategory(), this.mDefaultSharableApplicationPackages);
      if (localObject == null) {
        break label43;
      }
      this.mSharableApplicationPackages = ((String[])localObject);
    }
    for (;;)
    {
      return this.mSharableApplicationPackages;
      label43:
      this.mSharableApplicationPackages = this.mDefaultSharableApplicationPackages;
      continue;
      label54:
      this.mSharableApplicationPackages = this.mDefaultSharableApplicationPackages;
    }
  }
  
  public CancellableJob<InstallationResult<File>> installComponent(Bundle paramBundle, DEPSConfig.ComponentConfig paramComponentConfig, ProgressiveCallback<InstallationResult<File>> paramProgressiveCallback)
  {
    TBSOneManager.Policy localPolicy = getPolicy();
    if (localPolicy == TBSOneManager.Policy.BUILTIN_ONLY) {
      return super.installComponent(paramBundle, paramComponentConfig, paramProgressiveCallback);
    }
    Logging.i("[%s] Installing component %s, version: %d, policy: %s", new Object[] { getCategory(), paramComponentConfig.getName(), Integer.valueOf(paramComponentConfig.getVersionCode()), localPolicy });
    File localFile = getInstallationDirectory(paramComponentConfig.getName(), paramComponentConfig.getVersionCode());
    FileUtils.mkdirsAnywayWithWarning(localFile.getParentFile());
    Object localObject = null;
    if (localPolicy == TBSOneManager.Policy.AUTO) {
      localObject = newComponentInstallationJob(TBSOneManager.Policy.AUTO, paramComponentConfig, localFile, paramBundle);
    }
    for (;;)
    {
      paramBundle = new ExclusiveComponentInstallationJob(getCallerContext(), paramComponentConfig, (CancellableJob)localObject, localFile);
      paramBundle.start(paramProgressiveCallback);
      return paramBundle;
      if (localPolicy == TBSOneManager.Policy.LOCAL_ONLY) {
        localObject = newComponentInstallationJob(TBSOneManager.Policy.LOCAL_ONLY, paramComponentConfig, localFile, paramBundle);
      } else if (localPolicy == TBSOneManager.Policy.ONLINE) {
        localObject = newComponentInstallationJob(TBSOneManager.Policy.ONLINE, paramComponentConfig, localFile, paramBundle);
      } else if (localPolicy == TBSOneManager.Policy.BUILTIN_FIRST) {
        localObject = new MixedCancellableJob(new CancellableJob[] { newComponentInstallationJob(TBSOneManager.Policy.BUILTIN_ONLY, paramComponentConfig, localFile, paramBundle), newComponentInstallationJob(TBSOneManager.Policy.AUTO, paramComponentConfig, localFile, paramBundle) });
      } else if (localPolicy == TBSOneManager.Policy.LOCAL_FIRST) {
        localObject = new MixedCancellableJob(new CancellableJob[] { newComponentInstallationJob(TBSOneManager.Policy.LOCAL_ONLY, paramComponentConfig, localFile, paramBundle), newComponentInstallationJob(TBSOneManager.Policy.AUTO, paramComponentConfig, localFile, paramBundle) });
      }
    }
  }
  
  public void installComponent(String paramString, Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    updateInUseComponentNames(paramString);
    if (verifyComponentAvailability(paramString, paramTBSOneCallback)) {
      super.installComponent(paramString, paramBundle, paramTBSOneCallback);
    }
  }
  
  public CancellableJob<InstallationResult<DEPSConfig>> installDEPS(Bundle paramBundle, ProgressiveCallback<InstallationResult<DEPSConfig>> paramProgressiveCallback)
  {
    TBSOneManager.Policy localPolicy = getPolicy();
    if (localPolicy == TBSOneManager.Policy.BUILTIN_ONLY) {
      return super.installDEPS(paramBundle, paramProgressiveCallback);
    }
    Object localObject1 = getCategory();
    Logging.i("[%s] Installing DEPS, policy: %s", new Object[] { localObject1, localPolicy });
    File localFile = PathService.getDEPSFile(getCategoryDirectory());
    if ((localPolicy == TBSOneManager.Policy.BUILTIN_FIRST) && (localFile.exists())) {}
    try
    {
      localObject2 = DEPSConfig.parse(localFile);
      localObject3 = DEPSConfig.parse(PathService.getDEPSFileInNativeLibraryDirectory(PathService.getNativeLibraryDirectory(getCallerContext()), (String)localObject1));
      if (((DEPSConfig)localObject2).getVersionCode() < ((DEPSConfig)localObject3).getVersionCode())
      {
        Logging.i("[%s] clear old deps,old DEPS Version=%s,new DEPS Version=%s", new Object[] { localObject1, String.valueOf(((DEPSConfig)localObject2).getVersionCode()), String.valueOf(((DEPSConfig)localObject3).getVersionCode()) });
        FileUtils.deleteFileWithWarning(localFile);
      }
      if (isUpdateAvailable())
      {
        Logging.i("[%s] Applying the last update", new Object[] { localObject1 });
        Context localContext = getCallerContext();
        InstallationUtils.cleanProcDirectory(localContext);
        localObject2 = tryAcquireUpdateLock();
        if (localObject2 == null) {
          break label417;
        }
        localObject3 = ProcessLock.tryAcquire(PathService.getProcessLockFile(localFile));
        if (localObject3 == null) {
          break label393;
        }
        if (!isUpdateAvailable()) {
          break label369;
        }
        if (InstallationUtils.isCategoryBeingUsedByOtherProcesses(localContext, (String)localObject1)) {
          break label345;
        }
      }
    }
    catch (TBSOneException localTBSOneException)
    {
      for (;;)
      {
        int i;
        try
        {
          Object localObject2;
          Object localObject3;
          FileUtils.renameOrCopyFile(getLatestDEPSFile(), localFile);
          ((ProcessLock)localObject3).releaseQuietly();
          ((ProcessLock)localObject2).releaseQuietly();
          i = getIntConfiguration("permanent_version", -1);
          localObject1 = null;
          if (localPolicy != TBSOneManager.Policy.AUTO) {
            break label441;
          }
          localObject1 = newDEPSInstallationJob(TBSOneManager.Policy.AUTO, i, localFile, paramBundle);
          paramBundle = new ExclusiveDEPSInstallationJob((CancellableJob)localObject1, localFile);
          paramBundle.start(new PolicyManagerImpl.3(this));
          paramBundle.start(paramProgressiveCallback);
          return paramBundle;
          localTBSOneException = localTBSOneException;
          localTBSOneException.printStackTrace();
        }
        catch (IOException localIOException)
        {
          Logging.e("[%s] Failed to apply the last update", new Object[] { localObject1, localIOException });
          continue;
        }
        label345:
        Logging.i("[%s] %s the category is being used by other processes", new Object[] { localObject1, "Early out for applying the last update," });
        continue;
        label369:
        Logging.i("[%s] %s the last update has applied by another process", new Object[] { localObject1, "Early out for applying the last update," });
        continue;
        label393:
        Logging.i("[%s] %s the DEPS installation lock is busy", new Object[] { localObject1, "Early out for applying the last update," });
        continue;
        label417:
        Logging.i("[%s] %s the update lock is busy", new Object[] { localObject1, "Early out for applying the last update," });
        continue;
        label441:
        if (localPolicy == TBSOneManager.Policy.LOCAL_ONLY) {
          localObject1 = newDEPSInstallationJob(TBSOneManager.Policy.LOCAL_ONLY, i, localFile, paramBundle);
        } else if (localPolicy == TBSOneManager.Policy.ONLINE) {
          localObject1 = newDEPSInstallationJob(TBSOneManager.Policy.ONLINE, i, localFile, paramBundle);
        } else if (localPolicy == TBSOneManager.Policy.BUILTIN_FIRST) {
          localObject1 = new MixedCancellableJob(new CancellableJob[] { newDEPSInstallationJob(TBSOneManager.Policy.BUILTIN_ONLY, i, localFile, paramBundle), newDEPSInstallationJob(TBSOneManager.Policy.AUTO, i, localFile, paramBundle) });
        } else if (localPolicy == TBSOneManager.Policy.LOCAL_FIRST) {
          localObject1 = new MixedCancellableJob(new CancellableJob[] { newDEPSInstallationJob(TBSOneManager.Policy.LOCAL_ONLY, i, localFile, paramBundle), newDEPSInstallationJob(TBSOneManager.Policy.AUTO, i, localFile, paramBundle) });
        }
      }
    }
  }
  
  public void installDependency(Bundle paramBundle, String paramString, TBSOneCallback<File> paramTBSOneCallback)
  {
    if (verifyComponentAvailability(paramString, paramTBSOneCallback)) {
      super.installDependency(paramBundle, paramString, paramTBSOneCallback);
    }
  }
  
  public boolean isComponentInstalled(String paramString)
  {
    Object localObject = getComponentDirectory(paramString);
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      return false;
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        File localFile = PathService.getDEPSFile(getCategoryDirectory());
        if ((localFile == null) || (!localFile.exists()))
        {
          Logging.i("deps file = %s", new Object[] { localFile });
          return false;
        }
        int j;
        try
        {
          paramString = DEPSConfig.parse(localFile).getComponentConfig(paramString).getDependencies();
          if (paramString != null)
          {
            j = paramString.length;
            i = 0;
            for (;;)
            {
              if (i >= j) {
                break label144;
              }
              boolean bool = isComponentInstalled(paramString[i]);
              if (!bool) {
                break;
              }
              i += 1;
            }
          }
          j = localObject.length;
        }
        catch (TBSOneException paramString)
        {
          Logging.e("parse config file %s failed,exception=", new Object[] { localFile.getAbsolutePath(), paramString.toString() });
          return false;
        }
        label144:
        int i = 0;
        while (i < j)
        {
          paramString = localObject[i];
          if ((paramString.isDirectory()) && (InstallationUtils.isArchiveComplete(paramString))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean isUpdateAvailable()
  {
    boolean bool2 = getLatestDEPSFile().exists();
    if (!getIncompleteUpdateFlagFile().exists()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Logging.i("[%s] Checking update availability, exists: %b, complete: %b", new Object[] { getCategory(), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void loadComponent(String paramString, Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    updateInUseComponentNames(paramString);
    if (verifyComponentAvailability(paramString, paramTBSOneCallback)) {
      super.loadComponent(paramString, paramBundle, paramTBSOneCallback);
    }
  }
  
  public CancellableJob<InstallationResult<File>> newComponentInstallationJob(TBSOneManager.Policy paramPolicy, DEPSConfig.ComponentConfig paramComponentConfig, File paramFile, Bundle paramBundle)
  {
    Context localContext = getCallerContext();
    String str = getCategory();
    paramComponentConfig.getName();
    switch (PolicyManagerImpl.6.$SwitchMap$com$tencent$tbs$one$TBSOneManager$Policy[paramPolicy.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return new BuiltinComponentInstallationJob(localContext, str, paramComponentConfig, paramFile, paramBundle, getLocalRepository());
    case 2: 
      return new PolicyManagerImpl.5(this, localContext, getLocalRepository(), paramComponentConfig.getUrl(), paramFile, paramComponentConfig.getVersionCode());
    case 3: 
      return new OnlineComponentInstallationJob(localContext, str, paramComponentConfig, paramFile, paramBundle);
    }
    return Factory.newAutoComponentInstallationJob(this, paramComponentConfig, paramFile, paramBundle);
  }
  
  public CancellableJob<InstallationResult<DEPSConfig>> newDEPSInstallationJob(TBSOneManager.Policy paramPolicy, int paramInt, File paramFile, Bundle paramBundle)
  {
    Context localContext = getCallerContext();
    String str = getCategory();
    switch (PolicyManagerImpl.6.$SwitchMap$com$tencent$tbs$one$TBSOneManager$Policy[paramPolicy.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return new BuiltinDEPSInstallationJob(localContext, str, paramFile);
    case 2: 
      return new PolicyManagerImpl.4(this, localContext, getLocalRepository(), paramFile);
    case 3: 
      return new OnlineDEPSInstallationJob(localContext, str, getOnlineServiceUrl(), paramFile);
    }
    return Factory.newAutoDEPSInstallationJob(this, paramInt, paramFile, paramBundle);
  }
  
  protected void onDEPSLoaded(InstallationResult<DEPSConfig> paramInstallationResult)
  {
    super.onDEPSLoaded(paramInstallationResult);
    SharedPreferences.Editor localEditor = this.mSharedPreferences.edit();
    localEditor.putInt("in_use_deps_version", ((DEPSConfig)paramInstallationResult.result).getVersionCode());
    localEditor.apply();
  }
  
  public void populateDEPSExtra(InstallationResult<DEPSConfig> paramInstallationResult)
  {
    if (paramInstallationResult.source != InstallationResult.Source.ONLINE) {
      return;
    }
    HashSet localHashSet = new HashSet();
    if ((paramInstallationResult.extra instanceof JSONObject))
    {
      String str = getCategory();
      JSONObject localJSONObject1 = (JSONObject)paramInstallationResult.extra;
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("SWITCH");
      Iterator localIterator;
      Object localObject;
      if (localJSONObject2 != null)
      {
        localIterator = localJSONObject2.keys();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (localJSONObject2.optInt((String)localObject, 0) == 1) {
            localHashSet.add(localObject);
          }
        }
      }
      localJSONObject2 = localJSONObject1.optJSONObject("RESET");
      if (localJSONObject2 != null)
      {
        paramInstallationResult = (DEPSConfig)paramInstallationResult.result;
        localIterator = localJSONObject2.keys();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (localJSONObject2.optInt((String)localObject, 0) == 1)
          {
            DEPSConfig.ComponentConfig localComponentConfig = paramInstallationResult.getComponentConfig((String)localObject);
            if (localComponentConfig != null)
            {
              localObject = getInstallationDirectory((String)localObject, localComponentConfig.getVersionCode());
              if (((File)localObject).exists())
              {
                InstallationUtils.createIncompleteFlag((File)localObject);
                Logging.i("[%s] Reset component %s", new Object[] { str, ((File)localObject).getAbsolutePath() });
              }
              else
              {
                Logging.e("[%s] Failed to reset component, %s does not exist", new Object[] { str, ((File)localObject).getAbsolutePath() });
              }
            }
            else
            {
              Logging.e("[%s] Failed to reset component %s, no component config", new Object[] { str, localObject });
            }
          }
        }
      }
      if (localJSONObject1.optInt("ULOG") == 1) {
        StatisticReport.reportLog();
      }
    }
    this.mDisabledComponentNames = localHashSet;
    Logging.i("[%s] Disabled components {%s} from server", new Object[] { getCategory(), TextUtils.join(", ", this.mDisabledComponentNames) });
    paramInstallationResult = this.mSharedPreferences.edit();
    paramInstallationResult.putStringSet("disabled_component_names", localHashSet);
    paramInstallationResult.apply();
  }
  
  public void setAutoUpdateEnabled(boolean paramBoolean)
  {
    super.setAutoUpdateEnabled(paramBoolean);
    if (paramBoolean) {
      scheduleIdleTask();
    }
  }
  
  public ProcessLock tryAcquireUpdateLock()
  {
    return ProcessLock.tryAcquire(PathService.getProcessLockFile(getLatestDEPSFile()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.PolicyManagerImpl
 * JD-Core Version:    0.7.0.1
 */