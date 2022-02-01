package com.tencent.tbs.one.impl;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.ThreadUtils;
import com.tencent.tbs.one.impl.policy.PolicyManager;
import java.io.File;

public class TBSOneManagerImpl
  extends TBSOneManager
{
  private static final String LOG_TAG = "TBSOne";
  private String mCategory;
  private boolean mIsRunning;
  private final Object mPolicyLock = new Object();
  private PolicyManager mPolicyManager;
  
  public TBSOneManagerImpl(Context paramContext, String paramString)
  {
    Factory.initializeOnce(paramContext);
    Logging.i("[%s] Initializing %s (%s)", new Object[] { paramString, "0.0.1", "20200701212732" });
    this.mCategory = paramString;
    this.mPolicyManager = Factory.newPolicyManager(paramContext, paramString);
  }
  
  private void ensurePolicy()
  {
    synchronized (this.mPolicyLock)
    {
      this.mIsRunning = true;
      return;
    }
  }
  
  public void configure(String paramString, Object paramObject)
  {
    Logging.i("[%s] Configuring %s = %s", new Object[] { this.mCategory, paramString, paramObject });
    this.mPolicyManager.configure(paramString, paramObject);
  }
  
  public TBSOneDebugger getDebugger()
  {
    return this.mPolicyManager.getDebugger();
  }
  
  public int[] getInstalledVersionCodesOfComponent(String paramString)
  {
    return this.mPolicyManager.getInstalledVersionCodesOfComponent(paramString);
  }
  
  public TBSOneComponent getLoadedComponent(String paramString)
  {
    return this.mPolicyManager.getLoadedComponent(paramString);
  }
  
  public TBSOneOnlineService getOnlineService()
  {
    ensurePolicy();
    return this.mPolicyManager.getOnlineService();
  }
  
  public void installComponent(String paramString, Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    Logging.i("[%s] Installing component %s,Options %s", new Object[] { this.mCategory, paramString, paramBundle });
    ensurePolicy();
    ThreadUtils.runOnCoreThread(new TBSOneManagerImpl.2(this, paramString, paramBundle, paramTBSOneCallback));
  }
  
  public void installComponent(String paramString, TBSOneCallback<File> paramTBSOneCallback)
  {
    installComponent(paramString, null, paramTBSOneCallback);
  }
  
  public boolean isComponentInstalled(String paramString)
  {
    return this.mPolicyManager.isComponentInstalled(paramString);
  }
  
  public void loadComponentAsync(String paramString, Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    Logging.i("[%s] Loading component %s asynchronously", new Object[] { this.mCategory, paramString });
    ensurePolicy();
    ThreadUtils.runOnCoreThread(new TBSOneManagerImpl.3(this, paramString, paramBundle, paramTBSOneCallback));
  }
  
  public void loadComponentAsync(String paramString, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    loadComponentAsync(paramString, null, paramTBSOneCallback);
  }
  
  public TBSOneComponent loadComponentSync(String paramString)
  {
    return loadComponentSync(paramString, null);
  }
  
  public TBSOneComponent loadComponentSync(String paramString, Bundle paramBundle)
  {
    Logging.i("[%s] Loading component %s synchronously", new Object[] { this.mCategory, paramString });
    if (ThreadUtils.runningOnCoreThread()) {
      throw new RuntimeException("TBSOneManager.loadComponentSync must not be called on TBSOne thread.");
    }
    ensurePolicy();
    SyncCallback localSyncCallback = new SyncCallback();
    ThreadUtils.runOnCoreThread(new TBSOneManagerImpl.4(this, paramString, paramBundle, localSyncCallback));
    localSyncCallback.waitFroResult();
    if (localSyncCallback.getErrorCode() != 0) {
      throw new TBSOneException(localSyncCallback.getErrorCode(), localSyncCallback.getDescription());
    }
    return (TBSOneComponent)localSyncCallback.getResult();
  }
  
  public void setAutoUpdateEnabled(boolean paramBoolean)
  {
    String str2 = this.mCategory;
    if (paramBoolean) {}
    for (String str1 = "Enabling";; str1 = "Disabling")
    {
      Logging.i("[%s] %s auto update", new Object[] { str2, str1 });
      this.mPolicyManager.setAutoUpdateEnabled(paramBoolean);
      return;
    }
  }
  
  public void setDelegate(TBSOneDelegate paramTBSOneDelegate)
  {
    Logging.i("[%s] Setting delegate %s", new Object[] { this.mCategory, paramTBSOneDelegate });
    ThreadUtils.runOnCoreThread(new TBSOneManagerImpl.1(this, paramTBSOneDelegate));
  }
  
  public void setPolicy(TBSOneManager.Policy paramPolicy)
  {
    Logging.i("[%s] Setting policy %s", new Object[] { this.mCategory, paramPolicy });
    synchronized (this.mPolicyLock)
    {
      if (this.mIsRunning)
      {
        Log.println(5, "TBSOne", Log.getStackTraceString(new Throwable("TBSOneManager.setPolicy should be called before doing any other operations.")));
        return;
      }
      this.mPolicyManager.setPolicy(paramPolicy);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.TBSOneManagerImpl
 * JD-Core Version:    0.7.0.1
 */