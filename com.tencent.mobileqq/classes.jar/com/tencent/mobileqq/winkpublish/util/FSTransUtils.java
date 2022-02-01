package com.tencent.mobileqq.winkpublish.util;

import android.content.Context;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import cooperation.qzone.QUA;

public class FSTransUtils
{
  public static String a()
  {
    return ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
  }
  
  public static void a(SDKInitListener paramSDKInitListener)
  {
    QQVideoPlaySDKManager.initSDKAsync(e(), new FSTransUtils.1(paramSDKInitListener));
  }
  
  public static String b()
  {
    return QUA.getQUA3();
  }
  
  public static boolean c()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion();
  }
  
  public static String d()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getSubVersion();
  }
  
  public static Context e()
  {
    return HostUIHelper.getInstance().getHostApplicationContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.FSTransUtils
 * JD-Core Version:    0.7.0.1
 */