package com.tencent.mobileqq.miniapp;

import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MiniAppManager
  implements IEventReceiver
{
  private static volatile MiniAppManager g;
  private Map<String, IApp> a = new LinkedHashMap();
  private Map<String, MiniAppOptions> b = new HashMap();
  private MiniAppManager.MiniAppReceiver c = new MiniAppManager.MiniAppReceiver(this);
  private MiniAppLauncher d = new MiniAppLauncher();
  private MiniAppInfoManager e = new MiniAppInfoManager();
  private SparseArray<IDownloader> f;
  
  private MiniAppManager()
  {
    StoryDispatcher.a().registerSubscriber("MiniAppManager", this.c);
  }
  
  private MiniAppInfo a(String paramString, int paramInt1, MiniAppInfo paramMiniAppInfo, int paramInt2, boolean paramBoolean, MiniAppInfoCallback paramMiniAppInfoCallback, int paramInt3)
  {
    if ((paramMiniAppInfo != null) && (this.e.a(paramMiniAppInfo, paramInt2, paramInt3)))
    {
      if ((paramMiniAppInfoCallback != null) && (paramMiniAppInfoCallback.b != null)) {
        paramMiniAppInfoCallback.a(paramMiniAppInfoCallback.b.get(), true, paramMiniAppInfo);
      }
      return paramMiniAppInfo;
    }
    if ((paramMiniAppInfo != null) && (paramInt2 == 1) && (this.e.a(paramMiniAppInfo)))
    {
      paramString = (IApp)this.a.get(paramMiniAppInfo.p);
      if (paramString != null) {
        paramString.a(paramMiniAppInfo);
      }
      if ((paramMiniAppInfoCallback != null) && (paramMiniAppInfoCallback.b != null)) {
        paramMiniAppInfoCallback.a(paramMiniAppInfoCallback.b.get(), true, paramMiniAppInfo);
      }
      return paramMiniAppInfo;
    }
    if ((paramMiniAppInfo != null) && (paramInt2 == 2) && (this.e.b(paramMiniAppInfo)))
    {
      paramString = (IApp)this.a.get(paramMiniAppInfo.p);
      if (paramString != null) {
        paramString.a(paramMiniAppInfo);
      }
      if ((paramMiniAppInfoCallback != null) && (paramMiniAppInfoCallback.b != null)) {
        paramMiniAppInfoCallback.a(paramMiniAppInfoCallback.b.get(), true, paramMiniAppInfo);
      }
      return paramMiniAppInfo;
    }
    if (paramBoolean)
    {
      if ((paramInt2 != 1) && (paramInt2 != 2))
      {
        if ((paramMiniAppInfoCallback != null) && (paramMiniAppInfoCallback.b != null))
        {
          paramMiniAppInfoCallback.a(paramMiniAppInfoCallback.b.get(), false, null);
          return null;
        }
      }
      else
      {
        Object localObject = paramMiniAppInfo;
        if (paramMiniAppInfo == null)
        {
          paramString = new MiniAppInfo(paramString, paramInt1);
          paramMiniAppInfo = (IApp)this.a.get(paramString.p);
          localObject = paramString;
          if (paramMiniAppInfo != null)
          {
            paramMiniAppInfo.a(paramString);
            localObject = paramString;
          }
        }
        this.e.a((MiniAppInfo)localObject, paramInt2, paramMiniAppInfoCallback);
      }
      return null;
    }
    if ((paramMiniAppInfoCallback != null) && (paramMiniAppInfoCallback.b != null)) {
      paramMiniAppInfoCallback.a(paramMiniAppInfoCallback.b.get(), false, null);
    }
    return null;
  }
  
  public static MiniAppManager a()
  {
    if (g == null) {
      try
      {
        if (g == null) {
          g = new MiniAppManager();
        }
      }
      finally {}
    }
    return g;
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "runApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    Intent localIntent = new Intent(paramActivity, MiniAppActivity.class);
    localIntent.putExtra("key_appid", paramString);
    localIntent.putExtra("key_appType", paramInt);
    localIntent.putExtra("key_options", paramMiniAppOptions);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.setFlags(268435456);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130772434, 2130772007);
  }
  
  private void a(IApp paramIApp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "downloadApp. cacheKey=", paramIApp.b.p });
    }
    MiniAppManager.GetAppPkgUrlCallback localGetAppPkgUrlCallback = new MiniAppManager.GetAppPkgUrlCallback(this);
    a(paramIApp.b.a, paramIApp.b.b, 2, true, localGetAppPkgUrlCallback);
  }
  
  private void a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    paramMiniAppActivity = this.d.a(paramMiniAppActivity, paramString, paramInt);
    if (paramMiniAppActivity == null)
    {
      a(paramString, paramInt, 1000);
      return;
    }
    String str = MiniAppInfo.a(paramString, paramInt);
    this.a.put(str, paramMiniAppActivity);
    this.b.put(str, paramMiniAppOptions);
    a(paramString, paramInt, 1, true, new MiniAppManager.GetAppInfoCallback(this));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131904696), 0).show();
    QLog.e("MiniAppManager", 1, new Object[] { "onInitFailed. errorCode=", Integer.valueOf(paramInt2), ", appId=", paramString, ", appType=", Integer.valueOf(paramInt1) });
    a(paramString, paramInt1);
    b(MiniAppInfo.a(paramString, paramInt1));
  }
  
  private void b(IApp paramIApp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "launchApp. cacheKey=", paramIApp.b.p });
    }
    this.d.a(paramIApp, (MiniAppOptions)this.b.get(paramIApp.b.p));
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "removeMiniApp. cacheKey=", paramString });
    }
    IApp localIApp = (IApp)this.a.remove(paramString);
    if (localIApp != null) {
      localIApp.d();
    }
    this.b.remove(paramString);
  }
  
  public IDownloader a(String paramString)
  {
    if (this.f == null) {
      this.f = new SparseArray();
    }
    int i = IDownloader.a(paramString);
    if (i > 0)
    {
      IDownloader localIDownloader = (IDownloader)this.f.get(i);
      paramString = localIDownloader;
      if (localIDownloader == null)
      {
        paramString = new AKOfflineDownloader();
        this.f.put(i, paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public MiniAppInfo a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, MiniAppInfoCallback paramMiniAppInfoCallback)
  {
    return a(paramString, paramInt1, paramInt2, paramBoolean, paramMiniAppInfoCallback, 0);
  }
  
  public MiniAppInfo a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, MiniAppInfoCallback paramMiniAppInfoCallback, int paramInt3)
  {
    if (paramMiniAppInfoCallback == null) {
      return this.e.a(MiniAppInfo.a(paramString, paramInt1), paramInt2, paramInt3, true);
    }
    return a(paramString, paramInt1, this.e.a(MiniAppInfo.a(paramString, paramInt1), paramInt2, paramInt3, false), paramInt2, paramBoolean, paramMiniAppInfoCallback, paramInt3);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.e.a.put(paramMiniAppInfo.p, paramMiniAppInfo);
  }
  
  void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "stopApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    paramString = (IApp)this.a.get(MiniAppInfo.a(paramString, paramInt));
    if ((paramString != null) && (paramString.c())) {
      paramString.b();
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppManager
 * JD-Core Version:    0.7.0.1
 */