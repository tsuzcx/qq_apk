package com.tencent.tbs.one.impl.policy;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.ProgressiveCallback;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.common.DEPSConfig.ComponentConfig;
import com.tencent.tbs.one.impl.common.PathService;
import com.tencent.tbs.one.impl.common.ReceiverConfig;
import com.tencent.tbs.one.impl.loader.ComponentImpl;
import com.tencent.tbs.one.impl.loader.ComponentLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PolicyManager
{
  private volatile boolean mAutoUpdateEnabled = false;
  private Context mCallerContext;
  private String mCategory;
  private File mCategoryDirectory;
  private Map<String, Object> mConfigurations = new ConcurrentHashMap();
  private DEPSConfig mDEPSConfig;
  private CancellableJob<DEPSConfig> mDEPSInstallationJob;
  private TBSOneDelegate mDelegate;
  private EventEmitterImpl mEventEmitter = new EventEmitterImpl(this);
  private Map<String, ComponentLoader> mLoaders = new ConcurrentHashMap();
  private volatile TBSOneManager.Policy mPolicy = TBSOneManager.Policy.AUTO;
  private Map<String, List<ReceiverConfig>> mReceiverConfigs = new ConcurrentHashMap();
  
  public PolicyManager(Context paramContext, String paramString)
  {
    this.mCallerContext = paramContext;
    this.mCategory = paramString;
    this.mCategoryDirectory = PathService.getCategoryDirectory(PathService.getDataRootDirectory(paramContext), paramString);
    FileUtils.mkdirsAnywayWithWarning(this.mCategoryDirectory);
    FileUtils.mkdirsAnywayWithWarning(PathService.getComponentsDirectory(this.mCategoryDirectory));
  }
  
  private ComponentLoader getOrCreateLoader(String paramString)
  {
    ComponentLoader localComponentLoader2 = (ComponentLoader)this.mLoaders.get(paramString);
    ComponentLoader localComponentLoader1 = localComponentLoader2;
    if (localComponentLoader2 == null)
    {
      localComponentLoader1 = new ComponentLoader(this, paramString);
      this.mLoaders.put(paramString, localComponentLoader1);
    }
    return localComponentLoader1;
  }
  
  public void configure(String paramString, Object paramObject)
  {
    this.mConfigurations.put(paramString, paramObject);
  }
  
  public void doUpdate(Bundle paramBundle) {}
  
  public Map<String, ComponentLoader> getAllLoaders()
  {
    return this.mLoaders;
  }
  
  public boolean getBooleanConfiguration(String paramString, boolean paramBoolean)
  {
    paramString = this.mConfigurations.get(paramString);
    if ((paramString instanceof Boolean)) {
      paramBoolean = ((Boolean)paramString).booleanValue();
    }
    return paramBoolean;
  }
  
  public Context getCallerContext()
  {
    return this.mCallerContext;
  }
  
  public String getCategory()
  {
    return this.mCategory;
  }
  
  public File getCategoryDirectory()
  {
    return this.mCategoryDirectory;
  }
  
  public File getComponentDirectory(String paramString)
  {
    return PathService.getComponentDirectory(this.mCategoryDirectory, paramString);
  }
  
  public File getComponentsDirectory()
  {
    return PathService.getComponentsDirectory(this.mCategoryDirectory);
  }
  
  public Object getConfiguration(String paramString)
  {
    return this.mConfigurations.get(paramString);
  }
  
  public DEPSConfig getDEPSConfig()
  {
    return this.mDEPSConfig;
  }
  
  File getDEPSFile()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mDelegate != null)
    {
      String str = this.mDelegate.shouldOverrideFilePath(this.mCategory, null, -1, "DEPS");
      localObject1 = localObject2;
      if (str != null) {
        localObject1 = new File(str);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = PathService.getDEPSFileInNativeLibraryDirectory(PathService.getNativeLibraryDirectory(this.mCallerContext), this.mCategory);
    }
    return localObject2;
  }
  
  public TBSOneDebugger getDebugger()
  {
    return null;
  }
  
  public TBSOneDelegate getDelegate()
  {
    return this.mDelegate;
  }
  
  public EventEmitterImpl getEventEmitter()
  {
    return this.mEventEmitter;
  }
  
  public File getInstallationDirectory(String paramString, int paramInt)
  {
    return PathService.getComponentInstallationDirectory(this.mCategoryDirectory, paramString, paramInt);
  }
  
  public int[] getInstalledVersionCodesOfComponent(String paramString)
  {
    return new int[] { -1 };
  }
  
  public int getIntConfiguration(String paramString, int paramInt)
  {
    paramString = this.mConfigurations.get(paramString);
    if ((paramString instanceof Integer)) {
      paramInt = ((Integer)paramString).intValue();
    }
    return paramInt;
  }
  
  public ComponentImpl getLoadedComponent(String paramString)
  {
    paramString = (ComponentLoader)this.mLoaders.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.getComponent();
  }
  
  public ComponentLoader getLoader(String paramString)
  {
    return (ComponentLoader)this.mLoaders.get(paramString);
  }
  
  public TBSOneOnlineService getOnlineService()
  {
    return null;
  }
  
  public TBSOneManager.Policy getPolicy()
  {
    return this.mPolicy;
  }
  
  public List<ReceiverConfig> getRegisteredReceiverConfigs(String paramString)
  {
    return (List)this.mReceiverConfigs.get(paramString);
  }
  
  public CancellableJob<InstallationResult<File>> installComponent(Bundle paramBundle, DEPSConfig.ComponentConfig paramComponentConfig, ProgressiveCallback<InstallationResult<File>> paramProgressiveCallback)
  {
    Logging.i("[%s] Installing component %s, version: %d", new Object[] { this.mCategory, paramComponentConfig.getName(), Integer.valueOf(paramComponentConfig.getVersionCode()) });
    paramBundle = getInstallationDirectory(paramComponentConfig.getName(), paramComponentConfig.getVersionCode());
    FileUtils.mkdirsAnywayWithWarning(paramBundle);
    paramProgressiveCallback.onCompleted(InstallationResult.make(InstallationResult.Source.BUILTIN, paramBundle));
    return null;
  }
  
  public void installComponent(String paramString, Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    getOrCreateLoader(paramString).install(paramBundle, paramTBSOneCallback);
  }
  
  public CancellableJob<InstallationResult<DEPSConfig>> installDEPS(Bundle paramBundle, ProgressiveCallback<InstallationResult<DEPSConfig>> paramProgressiveCallback)
  {
    Logging.i("[%s] Installing DEPS", new Object[] { this.mCategory });
    paramBundle = getDEPSFile();
    if (!paramBundle.exists())
    {
      paramProgressiveCallback.onError(105, "Failed to find DEPS file " + paramBundle.getAbsolutePath(), null);
      return null;
    }
    try
    {
      paramBundle = DEPSConfig.parse(paramBundle);
      paramProgressiveCallback.onCompleted(InstallationResult.make(InstallationResult.Source.BUILTIN, paramBundle));
      return null;
    }
    catch (TBSOneException paramBundle)
    {
      paramProgressiveCallback.onError(paramBundle.getErrorCode(), paramBundle.getMessage(), paramBundle.getCause());
    }
    return null;
  }
  
  public void installDependency(Bundle paramBundle, String paramString, TBSOneCallback<File> paramTBSOneCallback)
  {
    getOrCreateLoader(paramString).install(paramBundle, paramTBSOneCallback);
  }
  
  public boolean isAutoUpdateEnabled()
  {
    return this.mAutoUpdateEnabled;
  }
  
  public boolean isComponentInstalled(String paramString)
  {
    return true;
  }
  
  public void loadComponent(String paramString, Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    getOrCreateLoader(paramString).load(paramBundle, paramTBSOneCallback);
  }
  
  public void loadDEPS(Bundle paramBundle, ProgressiveCallback<DEPSConfig> paramProgressiveCallback)
  {
    String str = this.mCategory;
    Logging.i("[%s] Loading DEPS", new Object[] { str });
    if (this.mDEPSConfig != null)
    {
      Logging.i("[%s] Loaded DEPS#%d", new Object[] { str, Integer.valueOf(this.mDEPSConfig.getVersionCode()) });
      if (paramProgressiveCallback != null) {
        paramProgressiveCallback.onCompleted(this.mDEPSConfig);
      }
      return;
    }
    if (this.mDEPSInstallationJob == null) {
      this.mDEPSInstallationJob = new PolicyManager.1(this, paramBundle);
    }
    this.mDEPSInstallationJob.start(paramProgressiveCallback);
  }
  
  protected void onDEPSLoaded(InstallationResult<DEPSConfig> paramInstallationResult)
  {
    Logging.i("[%s] Finished loading DEPS#%d from %s", new Object[] { this.mCategory, Integer.valueOf(((DEPSConfig)paramInstallationResult.result).getVersionCode()), paramInstallationResult.source });
    this.mDEPSConfig = ((DEPSConfig)paramInstallationResult.result);
  }
  
  public void registerReceiverConfig(ReceiverConfig paramReceiverConfig)
  {
    String str = paramReceiverConfig.getEventName();
    List localList = (List)this.mReceiverConfigs.get(str);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.mReceiverConfigs.put(str, localObject);
    }
    ((List)localObject).add(paramReceiverConfig);
  }
  
  public void setAutoUpdateEnabled(boolean paramBoolean)
  {
    this.mAutoUpdateEnabled = paramBoolean;
  }
  
  public void setDelegate(TBSOneDelegate paramTBSOneDelegate)
  {
    this.mDelegate = paramTBSOneDelegate;
  }
  
  public void setPolicy(TBSOneManager.Policy paramPolicy)
  {
    this.mPolicy = paramPolicy;
  }
  
  public boolean useBuiltinOnly()
  {
    return this.mPolicy == TBSOneManager.Policy.BUILTIN_ONLY;
  }
  
  public boolean useOnlineService()
  {
    return (this.mPolicy != TBSOneManager.Policy.BUILTIN_ONLY) && (this.mPolicy != TBSOneManager.Policy.LOCAL_ONLY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.PolicyManager
 * JD-Core Version:    0.7.0.1
 */