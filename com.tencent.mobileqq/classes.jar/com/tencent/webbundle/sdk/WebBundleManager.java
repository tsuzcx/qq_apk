package com.tencent.webbundle.sdk;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebBundleManager
  implements WebBundle.PreloadStateListener
{
  private static final String DEFAULT_BIZ_ID = "webBundle";
  private static final String TAG = "WebBundle.WebBundleManager";
  private static HashMap<String, WebBundleManager> sInstanceMap = new HashMap();
  private WebBundleConfig config;
  private boolean isInit;
  private String mBizid = "webBundle";
  private final HashMap<String, Integer> mPreloadFailCntMap = new HashMap();
  private final HashMap<String, ArrayList<WebBundle>> mPreloadedPool = new HashMap();
  private WebBundle mPreloadingOne = null;
  private IWebBundleRuntime runtime;
  
  private WebBundleManager(String paramString)
  {
    this.mBizid = paramString;
  }
  
  public static WebBundleManager getInstance()
  {
    return getInstance("webBundle");
  }
  
  public static WebBundleManager getInstance(String paramString)
  {
    Object localObject = (WebBundleManager)sInstanceMap.get(paramString);
    if (localObject == null) {
      try
      {
        WebBundleManager localWebBundleManager = (WebBundleManager)sInstanceMap.get(paramString);
        localObject = localWebBundleManager;
        if (localWebBundleManager == null)
        {
          localObject = new WebBundleManager(paramString);
          sInstanceMap.put(paramString, localObject);
        }
        return localObject;
      }
      finally {}
    }
    return localObject;
  }
  
  @Nullable
  private String getNextPreloadUrl()
  {
    if (this.mPreloadingOne != null) {
      return null;
    }
    Object localObject = this.config;
    if (localObject != null)
    {
      localObject = ((WebBundleConfig)localObject).getPreloadUrlList().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ((getPreloadedCount(str) < this.config.getPreloadWebViewCount()) && (getPreloadFailedCount(str) < 2)) {
          return str;
        }
      }
    }
    return null;
  }
  
  private int getPreloadFailedCount(String paramString)
  {
    paramString = (Integer)this.mPreloadFailCntMap.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  private int getPreloadedCount(String paramString)
  {
    paramString = (ArrayList)this.mPreloadedPool.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.size();
  }
  
  private int getPreloadingCount(String paramString)
  {
    if (this.mPreloadingOne == null) {
      return 0;
    }
    return 1;
  }
  
  private void onPreloadFailed(WebBundle paramWebBundle)
  {
    String str = paramWebBundle.getPreloadUrl();
    if (this.mPreloadingOne == paramWebBundle) {
      this.mPreloadingOne = null;
    }
    log(3, "WebBundle.WebBundleManager", new String[] { "on webbundle preload failed. preloading = ", String.valueOf(getPreloadingCount(str)), ", preloaded = ", String.valueOf(getPreloadedCount(str)), ", preloadUrl = ", str });
    Integer localInteger = (Integer)this.mPreloadFailCntMap.get(str);
    paramWebBundle = localInteger;
    if (localInteger == null) {
      paramWebBundle = Integer.valueOf(0);
    }
    this.mPreloadFailCntMap.put(str, Integer.valueOf(paramWebBundle.intValue() + 1));
    triggerPreload();
  }
  
  private void onPreloadSuccess(WebBundle paramWebBundle)
  {
    String str = paramWebBundle.getPreloadUrl();
    if (this.mPreloadingOne == paramWebBundle) {
      this.mPreloadingOne = null;
    }
    ArrayList localArrayList2 = (ArrayList)this.mPreloadedPool.get(str);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.mPreloadedPool.put(str, localArrayList1);
    }
    localArrayList1.add(paramWebBundle);
    log(3, "WebBundle.WebBundleManager", new String[] { "on webbundle preload success. preloading = ", String.valueOf(getPreloadingCount(str)), ", preloaded = ", String.valueOf(getPreloadedCount(str)), ", preloadUrl = ", str });
    this.mPreloadFailCntMap.put(str, Integer.valueOf(0));
    triggerPreload();
  }
  
  public final void destroy()
  {
    ThreadManager.checkMainThread("destroy");
    log(3, "WebBundle.WebBundleManager", "destroy webbundle.");
    if (this.isInit)
    {
      Object localObject1 = this.mPreloadingOne;
      if (localObject1 != null) {
        ((WebBundle)localObject1).forceStop("destroy");
      }
      localObject1 = this.mPreloadedPool.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (ArrayList)this.mPreloadedPool.get(localObject2);
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        while (localIterator.hasNext()) {
          ((WebBundle)localIterator.next()).destroy();
        }
        ((ArrayList)localObject2).clear();
      }
      this.mPreloadFailCntMap.clear();
      this.isInit = false;
      this.config.reset();
      this.config = null;
      this.runtime.destroy();
      this.runtime = null;
    }
    HybridIdleTaskHelper.getInstance().removeIdleTask(this.mBizid.hashCode());
    sInstanceMap.remove(this.mBizid);
  }
  
  @Nullable
  public final WebBundle getAvailableWebBundle(@NotNull Context paramContext, @NotNull String paramString)
  {
    boolean bool = this.isInit;
    Object localObject2 = null;
    if (!bool) {
      return null;
    }
    ThreadManager.checkMainThread("getAvailableWebBundle");
    ArrayList localArrayList = (ArrayList)this.mPreloadedPool.get(paramString);
    log(3, "WebBundle.WebBundleManager", new String[] { "get available webbundle. preloading = ", String.valueOf(getPreloadingCount(paramString)), ", preloaded = ", String.valueOf(getPreloadedCount(paramString)), ", preloadUrl = ", paramString });
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        localObject1 = (WebBundle)localArrayList.remove(0);
        ((WebBundle)localObject1).resetContext(paramContext);
      }
    }
    this.mPreloadFailCntMap.put(paramString, Integer.valueOf(0));
    triggerPreload(500L);
    return localObject1;
  }
  
  public final WebBundleConfig getConfig()
  {
    return this.config;
  }
  
  public final IWebBundleRuntime getRuntime()
  {
    return this.runtime;
  }
  
  public final void init(@NotNull IWebBundleRuntime paramIWebBundleRuntime, @NotNull WebBundleConfig paramWebBundleConfig)
  {
    try
    {
      boolean bool = this.isInit;
      if (bool) {
        return;
      }
      if (paramWebBundleConfig.isValidate())
      {
        this.runtime = paramIWebBundleRuntime;
        this.config = paramWebBundleConfig;
        this.isInit = true;
        log(3, "WebBundle.WebBundleManager", "init webbundle success.");
        return;
      }
      throw new IllegalArgumentException("invalid webbundle config.");
    }
    finally {}
  }
  
  public boolean isInit()
  {
    return this.isInit;
  }
  
  public final void log(int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    if (this.config == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.mBizid);
    localStringBuilder.append("]");
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    if (this.config.isLogPrintEnabled()) {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt == 6) {
              Log.e(paramString1, paramString2);
            }
          }
          else {
            Log.w(paramString1, paramString2);
          }
        }
        else {
          Log.i(paramString1, paramString2);
        }
      }
      else {
        Log.d(paramString1, paramString2);
      }
    }
    if (this.config.getLogListener() != null) {
      this.config.getLogListener().log(paramInt, paramString1, paramString2);
    }
  }
  
  public final void log(int paramInt, @NotNull String paramString, String... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    log(paramInt, paramString, localStringBuilder.toString());
  }
  
  public void onStateChange(@NotNull WebBundle paramWebBundle, @NotNull WebBundle.WebBundlePreloadState paramWebBundlePreloadState)
  {
    ThreadManager.checkMainThread("onStateChange");
    if (paramWebBundlePreloadState == WebBundle.WebBundlePreloadState.SUCCESS)
    {
      onPreloadSuccess(paramWebBundle);
      return;
    }
    if (paramWebBundlePreloadState == WebBundle.WebBundlePreloadState.FAILED) {
      onPreloadFailed(paramWebBundle);
    }
  }
  
  public final boolean openWebViewWithWebBundle(@NotNull Activity paramActivity, @NotNull String paramString1, @NotNull JSONObject paramJSONObject, @Nullable Intent paramIntent, @NotNull String paramString2)
  {
    if (!this.isInit) {
      return false;
    }
    ThreadManager.checkMainThread("openWebViewWithWebBundle");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setComponent(new ComponentName(paramActivity.getPackageName(), this.config.getCarrierActivityClass().getName()));
    localIntent.putExtra("preload_url", paramString2);
    localIntent.putExtra("real_url", paramString1);
    localIntent.putExtra("bundle_data", paramJSONObject.toString());
    paramActivity.startActivity(localIntent);
    return true;
  }
  
  public final void preload(@NotNull Context paramContext)
  {
    if (!this.isInit) {
      return;
    }
    ThreadManager.checkMainThread("preload");
    String str = getNextPreloadUrl();
    if (str == null) {
      return;
    }
    log(3, "WebBundle.WebBundleManager", new String[] { "start to preload webbundle. preloading = ", String.valueOf(getPreloadingCount(str)), ", preloaded = ", String.valueOf(getPreloadedCount(str)), ". preloadUrl = ", str });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "preloadView");
      localJSONObject.put("url", "preloadAllPage");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    paramContext = new WebBundle(paramContext, this.mBizid);
    paramContext.startPreload(str, localJSONObject, this);
    this.mPreloadingOne = paramContext;
  }
  
  public final void triggerPreload()
  {
    triggerPreload(0L);
  }
  
  public final void triggerPreload(long paramLong)
  {
    ThreadManager.getUiHandler().postDelayed(new WebBundleManager.1(this), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.webbundle.sdk.WebBundleManager
 * JD-Core Version:    0.7.0.1
 */