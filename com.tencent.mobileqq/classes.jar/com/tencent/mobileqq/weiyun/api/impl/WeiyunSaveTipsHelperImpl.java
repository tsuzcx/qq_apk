package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.weiyun.utils.PreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class WeiyunSaveTipsHelperImpl
  implements IWeiyunSaveTipsHelper
{
  private static final String TAG = "WeiyunSaveTipsFactory";
  
  private static void queryNeedVerifyPwd(AppInterface paramAppInterface, Activity paramActivity)
  {
    paramAppInterface = (IQQFileEngine)paramAppInterface.getRuntimeService(IQQFileEngine.class, "all");
    if (paramAppInterface.hasQueriedVerifyPassword() == true)
    {
      paramAppInterface.queryNeedVerifyPwd();
      return;
    }
    if (NetworkUtil.isNetSupport(MobileQQ.sMobileQQ))
    {
      ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).enterCloudFileBrowser(paramActivity);
      return;
    }
    FMToastUtil.a(MobileQQ.sMobileQQ.getString(2131892102));
  }
  
  public void showTopTips(AppInterface paramAppInterface, Activity paramActivity, int paramInt)
  {
    if (paramAppInterface != null)
    {
      if (paramActivity == null) {
        return;
      }
      ThreadManager.getUIHandler().postDelayed(new WeiyunSaveTipsHelperImpl.1(this, paramActivity, paramInt, paramAppInterface), 1000L);
    }
  }
  
  public void startWeiyunDisk(AppInterface paramAppInterface, Activity paramActivity, Context paramContext)
  {
    int i = PreferenceUtils.a(paramContext, paramAppInterface.getCurrentAccountUin());
    if (i == 1)
    {
      String str = PreferenceUtils.b(paramContext, paramAppInterface.getCurrentAccountUin());
      i = PreferenceUtils.c(paramContext, paramAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(str))
      {
        ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).startWeiYunMiniApp(paramActivity, str, i, null);
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("can not to start WeiYun Mini app, apkgUrl = ");
      paramContext.append(str);
      paramContext.append(", version = ");
      paramContext.append(i);
      QLog.w("WeiyunSaveTipsFactory", 2, paramContext.toString());
      queryNeedVerifyPwd(paramAppInterface, paramActivity);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("can not to start WeiYun Mini app, weiYunGrayConfig = ");
    paramContext.append(i);
    QLog.w("WeiyunSaveTipsFactory", 2, paramContext.toString());
    queryNeedVerifyPwd(paramAppInterface, paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunSaveTipsHelperImpl
 * JD-Core Version:    0.7.0.1
 */