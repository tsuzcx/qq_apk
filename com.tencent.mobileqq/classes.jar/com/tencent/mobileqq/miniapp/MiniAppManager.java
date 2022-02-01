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
  private static volatile MiniAppManager jdField_a_of_type_ComTencentMobileqqMiniappMiniAppManager;
  private SparseArray<IDownloader> jdField_a_of_type_AndroidUtilSparseArray;
  private MiniAppInfoManager jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager = new MiniAppInfoManager();
  private MiniAppLauncher jdField_a_of_type_ComTencentMobileqqMiniappMiniAppLauncher = new MiniAppLauncher();
  private MiniAppManager.MiniAppReceiver jdField_a_of_type_ComTencentMobileqqMiniappMiniAppManager$MiniAppReceiver = new MiniAppManager.MiniAppReceiver(this);
  private Map<String, IApp> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private Map<String, MiniAppOptions> b = new HashMap();
  
  private MiniAppManager()
  {
    StoryDispatcher.a().registerSubscriber("MiniAppManager", this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppManager$MiniAppReceiver);
  }
  
  private MiniAppInfo a(String paramString, int paramInt1, MiniAppInfo paramMiniAppInfo, int paramInt2, boolean paramBoolean, MiniAppInfoCallback paramMiniAppInfoCallback, int paramInt3)
  {
    if ((paramMiniAppInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager.a(paramMiniAppInfo, paramInt2, paramInt3)))
    {
      if ((paramMiniAppInfoCallback != null) && (paramMiniAppInfoCallback.a != null)) {
        paramMiniAppInfoCallback.a(paramMiniAppInfoCallback.a.get(), true, paramMiniAppInfo);
      }
      return paramMiniAppInfo;
    }
    if ((paramMiniAppInfo != null) && (paramInt2 == 1) && (this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager.a(paramMiniAppInfo)))
    {
      paramString = (IApp)this.jdField_a_of_type_JavaUtilMap.get(paramMiniAppInfo.h);
      if (paramString != null) {
        paramString.a(paramMiniAppInfo);
      }
      if ((paramMiniAppInfoCallback != null) && (paramMiniAppInfoCallback.a != null)) {
        paramMiniAppInfoCallback.a(paramMiniAppInfoCallback.a.get(), true, paramMiniAppInfo);
      }
      return paramMiniAppInfo;
    }
    if ((paramMiniAppInfo != null) && (paramInt2 == 2) && (this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager.b(paramMiniAppInfo)))
    {
      paramString = (IApp)this.jdField_a_of_type_JavaUtilMap.get(paramMiniAppInfo.h);
      if (paramString != null) {
        paramString.a(paramMiniAppInfo);
      }
      if ((paramMiniAppInfoCallback != null) && (paramMiniAppInfoCallback.a != null)) {
        paramMiniAppInfoCallback.a(paramMiniAppInfoCallback.a.get(), true, paramMiniAppInfo);
      }
      return paramMiniAppInfo;
    }
    if (paramBoolean)
    {
      if ((paramInt2 != 1) && (paramInt2 != 2))
      {
        if ((paramMiniAppInfoCallback != null) && (paramMiniAppInfoCallback.a != null))
        {
          paramMiniAppInfoCallback.a(paramMiniAppInfoCallback.a.get(), false, null);
          return null;
        }
      }
      else
      {
        Object localObject = paramMiniAppInfo;
        if (paramMiniAppInfo == null)
        {
          paramString = new MiniAppInfo(paramString, paramInt1);
          paramMiniAppInfo = (IApp)this.jdField_a_of_type_JavaUtilMap.get(paramString.h);
          localObject = paramString;
          if (paramMiniAppInfo != null)
          {
            paramMiniAppInfo.a(paramString);
            localObject = paramString;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager.a((MiniAppInfo)localObject, paramInt2, paramMiniAppInfoCallback);
      }
      return null;
    }
    if ((paramMiniAppInfoCallback != null) && (paramMiniAppInfoCallback.a != null)) {
      paramMiniAppInfoCallback.a(paramMiniAppInfoCallback.a.get(), false, null);
    }
    return null;
  }
  
  public static MiniAppManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqMiniappMiniAppManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqMiniappMiniAppManager == null) {
          jdField_a_of_type_ComTencentMobileqqMiniappMiniAppManager = new MiniAppManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqMiniappMiniAppManager;
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
    paramActivity.overridePendingTransition(2130772342, 2130772004);
  }
  
  private void a(IApp paramIApp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "downloadApp. cacheKey=", paramIApp.a.h });
    }
    MiniAppManager.GetAppPkgUrlCallback localGetAppPkgUrlCallback = new MiniAppManager.GetAppPkgUrlCallback(this);
    a(paramIApp.a.jdField_a_of_type_JavaLangString, paramIApp.a.jdField_a_of_type_Int, 2, true, localGetAppPkgUrlCallback);
  }
  
  private void a(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt, MiniAppOptions paramMiniAppOptions)
  {
    paramMiniAppActivity = this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppLauncher.a(paramMiniAppActivity, paramString, paramInt);
    if (paramMiniAppActivity == null)
    {
      a(paramString, paramInt, 1000);
      return;
    }
    String str = MiniAppInfo.a(paramString, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramMiniAppActivity);
    this.b.put(str, paramMiniAppOptions);
    a(paramString, paramInt, 1, true, new MiniAppManager.GetAppInfoCallback(this));
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "removeMiniApp. cacheKey=", paramString });
    }
    IApp localIApp = (IApp)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (localIApp != null) {
      localIApp.c();
    }
    this.b.remove(paramString);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131706848), 0).a();
    QLog.e("MiniAppManager", 1, new Object[] { "onInitFailed. errorCode=", Integer.valueOf(paramInt2), ", appId=", paramString, ", appType=", Integer.valueOf(paramInt1) });
    a(paramString, paramInt1);
    a(MiniAppInfo.a(paramString, paramInt1));
  }
  
  private void b(IApp paramIApp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "launchApp. cacheKey=", paramIApp.a.h });
    }
    this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppLauncher.a(paramIApp, (MiniAppOptions)this.b.get(paramIApp.a.h));
  }
  
  public IDownloader a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    int i = IDownloader.a(paramString);
    if (i > 0)
    {
      IDownloader localIDownloader = (IDownloader)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      paramString = localIDownloader;
      if (localIDownloader == null)
      {
        paramString = new AKOfflineDownloader();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramString);
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
      return this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager.a(MiniAppInfo.a(paramString, paramInt1), paramInt2, paramInt3, true);
    }
    return a(paramString, paramInt1, this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager.a(MiniAppInfo.a(paramString, paramInt1), paramInt2, paramInt3, false), paramInt2, paramBoolean, paramMiniAppInfoCallback, paramInt3);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfoManager.jdField_a_of_type_JavaUtilMap.put(paramMiniAppInfo.h, paramMiniAppInfo);
  }
  
  void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppManager", 2, new Object[] { "stopApp. appId=", paramString, ", appType=", Integer.valueOf(paramInt) });
    }
    paramString = (IApp)this.jdField_a_of_type_JavaUtilMap.get(MiniAppInfo.a(paramString, paramInt));
    if ((paramString != null) && (paramString.a())) {
      paramString.b();
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppManager
 * JD-Core Version:    0.7.0.1
 */