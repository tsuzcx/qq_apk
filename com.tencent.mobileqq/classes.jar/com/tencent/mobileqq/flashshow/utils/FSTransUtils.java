package com.tencent.mobileqq.flashshow.utils;

import android.app.Application;
import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.flashshow.application.FSApplication;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.QCircleVideoSdkInitListener;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudMeta.StUser;

public class FSTransUtils
{
  public static String a()
  {
    return ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
  }
  
  public static void a(QCircleVideoSdkInitListener paramQCircleVideoSdkInitListener)
  {
    HostDataTransUtils.initVideoSdk(new FSTransUtils.1(paramQCircleVideoSdkInitListener));
  }
  
  public static FeedCloudMeta.StUser b()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(a());
    localStUser.nick.set(HostDataTransUtils.getAccountNickName(a()));
    return localStUser;
  }
  
  public static String c()
  {
    return QUA.getQUA3();
  }
  
  public static boolean d()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion();
  }
  
  public static String e()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getSubVersion();
  }
  
  public static Context f()
  {
    return FSApplication.APP.getApplicationContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSTransUtils
 * JD-Core Version:    0.7.0.1
 */