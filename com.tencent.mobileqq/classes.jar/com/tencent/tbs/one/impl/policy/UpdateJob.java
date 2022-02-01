package com.tencent.tbs.one.impl.policy;

import android.os.Bundle;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.common.DEPSConfig.ComponentConfig;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UpdateJob
  extends CancellableJob<Void>
{
  private boolean mErrorOccurred;
  private Bundle mOptions;
  private PolicyManagerImpl mPolicyManager;
  private Map<String, CancellableJob> mRunningJobs = new ConcurrentHashMap();
  
  public UpdateJob(PolicyManagerImpl paramPolicyManagerImpl, Bundle paramBundle)
  {
    this.mPolicyManager = paramPolicyManagerImpl;
    this.mOptions = paramBundle;
  }
  
  private void cancelInternal()
  {
    Iterator localIterator = this.mRunningJobs.values().iterator();
    while (localIterator.hasNext()) {
      ((CancellableJob)localIterator.next()).cancel();
    }
    this.mRunningJobs.clear();
  }
  
  private boolean collectComponentConfigs(DEPSConfig paramDEPSConfig, String paramString, Set<DEPSConfig.ComponentConfig> paramSet)
  {
    DEPSConfig.ComponentConfig localComponentConfig = paramDEPSConfig.getComponentConfig(paramString);
    if (localComponentConfig != null)
    {
      paramString = localComponentConfig.getDependencies();
      if (paramString != null)
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          if (!collectComponentConfigs(paramDEPSConfig, paramString[i], paramSet)) {
            return false;
          }
          i += 1;
        }
      }
      paramSet.add(localComponentConfig);
      return true;
    }
    fail(309, "Failed to get info for component " + paramString, null);
    return false;
  }
  
  private void onComponentInstalled(String paramString)
  {
    this.mRunningJobs.remove(paramString);
    if ((!this.mErrorOccurred) && (this.mRunningJobs.size() <= 0))
    {
      Logging.i("[%s] Finished updating", new Object[] { this.mPolicyManager.getCategory() });
      finish(null);
    }
  }
  
  private void onDEPSLoaded(Bundle paramBundle, DEPSConfig paramDEPSConfig)
  {
    this.mRunningJobs.remove("DEPS");
    if (paramDEPSConfig.getVersionCode() == this.mPolicyManager.getInUseDEPSVersion()) {
      fail(506, "Failed to request the latest DEPS which different from current", null);
    }
    for (;;)
    {
      return;
      Object localObject1 = this.mPolicyManager.getInUseComponentNames();
      if ((localObject1 == null) || (localObject1.length <= 0))
      {
        fail(507, "No in-use components", null);
        return;
      }
      Object localObject2 = new HashSet();
      int j = localObject1.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label111;
        }
        if (!collectComponentConfigs(paramDEPSConfig, localObject1[i], (Set)localObject2)) {
          break;
        }
        i += 1;
      }
      label111:
      localObject1 = ((Set)localObject2).iterator();
      for (paramDEPSConfig = paramBundle; ((Iterator)localObject1).hasNext(); paramDEPSConfig = paramBundle)
      {
        DEPSConfig.ComponentConfig localComponentConfig = (DEPSConfig.ComponentConfig)((Iterator)localObject1).next();
        localObject2 = localComponentConfig.getName();
        i = localComponentConfig.getVersionCode();
        Logging.i("[%s] Updating component %s#%d", new Object[] { this.mPolicyManager.getCategory(), localObject2, Integer.valueOf(i) });
        paramBundle = paramDEPSConfig;
        if (paramDEPSConfig == null) {
          paramBundle = new Bundle();
        }
        paramBundle.putInt("info_from", 1);
        paramDEPSConfig = this.mPolicyManager.installComponent(paramBundle, localComponentConfig, new UpdateJob.2(this, (String)localObject2, i));
        this.mRunningJobs.put(localObject2, paramDEPSConfig);
      }
    }
  }
  
  public void cancel()
  {
    super.cancel();
    cancelInternal();
  }
  
  public void fail(int paramInt, String paramString, Throwable paramThrowable)
  {
    Logging.w("Failed to update, error: [%d] %s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.mErrorOccurred = true;
    cancelInternal();
    File localFile = this.mPolicyManager.getLatestDEPSFile();
    if (localFile.exists()) {
      FileUtils.deleteFileWithWarning(localFile);
    }
    super.fail(paramInt, paramString, paramThrowable);
  }
  
  public void run()
  {
    Logging.i("[%s] Requesting the latest DEPS", new Object[] { this.mPolicyManager.getCategory() });
    PolicyManagerImpl localPolicyManagerImpl = this.mPolicyManager;
    String str = localPolicyManagerImpl.getCategory();
    Object localObject = localPolicyManagerImpl.getLatestDEPSFile();
    if (((File)localObject).exists()) {
      FileUtils.deleteFileWithWarning((File)localObject);
    }
    localObject = localPolicyManagerImpl.newDEPSInstallationJob(TBSOneManager.Policy.AUTO, -1, (File)localObject, this.mOptions);
    ((CancellableJob)localObject).start(new UpdateJob.1(this, str, localPolicyManagerImpl));
    this.mRunningJobs.put("DEPS", localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.UpdateJob
 * JD-Core Version:    0.7.0.1
 */