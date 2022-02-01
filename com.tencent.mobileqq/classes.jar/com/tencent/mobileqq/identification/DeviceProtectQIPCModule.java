package com.tencent.mobileqq.identification;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.WtloginManagerImpl;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.tools.util;

public class DeviceProtectQIPCModule
  extends QIPCModule
{
  private static volatile DeviceProtectQIPCModule a;
  
  public DeviceProtectQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static DeviceProtectQIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new DeviceProtectQIPCModule("DeviceProtectQIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  private EIPCResult a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("DeviceProtectQIPCModule", 1, "handleGetDeviceInfo error: QQAppInterface is null");
      return EIPCResult.createResult(-102, null);
    }
    Bundle localBundle = new Bundle();
    for (;;)
    {
      Object localObject6;
      try
      {
        paramAppRuntime = (WtloginManagerImpl)paramAppRuntime.getManager(1);
        localObject4 = "";
        Object localObject7;
        String str;
        Object localObject2;
        Object localObject3;
        Object localObject5;
        if (paramAppRuntime != null)
        {
          localObject7 = BaseApplication.getContext();
          str = util.buf_to_string(paramAppRuntime.getGUID());
          localObject6 = UserAction.getQIMEI();
          localObject1 = String.valueOf(AppSetting.d());
          localObject2 = "Android";
          localObject3 = Build.BRAND;
          localObject5 = Build.MODEL;
          paramAppRuntime = (AppRuntime)localObject4;
          if (HwNetworkUtil.getSystemNetwork((Context)localObject7) == 1) {
            paramAppRuntime = HwNetworkUtil.getCurrentWifiBSSID((Context)localObject7);
          }
        }
        else
        {
          QLog.e("DeviceProtectQIPCModule", 1, "handleGetDeviceInfo error: wtLoginManager is null");
          str = "";
          paramAppRuntime = str;
          localObject1 = paramAppRuntime;
          localObject2 = localObject1;
          localObject3 = localObject2;
          localObject5 = localObject3;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("guid:");
          ((StringBuilder)localObject6).append(str);
          ((StringBuilder)localObject6).append("qimei:");
          ((StringBuilder)localObject6).append((String)localObject4);
          ((StringBuilder)localObject6).append("subappid:");
          ((StringBuilder)localObject6).append((String)localObject1);
          ((StringBuilder)localObject6).append("platform:");
          ((StringBuilder)localObject6).append((String)localObject2);
          ((StringBuilder)localObject6).append("brand:");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((StringBuilder)localObject6).append("model:");
          ((StringBuilder)localObject6).append((String)localObject5);
          ((StringBuilder)localObject6).append("bssid:");
          ((StringBuilder)localObject6).append(paramAppRuntime);
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("handleGetDeviceInfo info: ");
          ((StringBuilder)localObject7).append(localObject6);
          QLog.d("DeviceProtectQIPCModule", 1, ((StringBuilder)localObject7).toString());
          localBundle.putString("guid", str);
          localBundle.putString("qimei", (String)localObject4);
          localBundle.putString("subappid", (String)localObject1);
          localBundle.putString("platform", (String)localObject2);
          localBundle.putString("brand", (String)localObject3);
          localBundle.putString("model", (String)localObject5);
          localBundle.putString("bssid", paramAppRuntime);
          paramAppRuntime = EIPCResult.createResult(0, localBundle);
          return paramAppRuntime;
        }
      }
      catch (Exception paramAppRuntime)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleGetDeviceInfo error: ");
        ((StringBuilder)localObject1).append(paramAppRuntime.getMessage());
        QLog.e("DeviceProtectQIPCModule", 1, ((StringBuilder)localObject1).toString());
        return EIPCResult.createResult(-102, null);
      }
      Object localObject4 = localObject6;
    }
  }
  
  private void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("DeviceProtectQIPCModule", 1, "handleGetGuidInfo error: QQAppInterface is null");
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    try
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("guid", util.buf_to_string(((WtloginManager)paramAppRuntime.getManager(1)).getGUID()));
      QLog.d("DeviceProtectQIPCModule", 1, "handleGetGuidInfo success");
      callbackResult(paramInt, EIPCResult.createResult(0, (Bundle)localObject));
      return;
    }
    catch (Exception paramAppRuntime)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetGuidInfo error: ");
      ((StringBuilder)localObject).append(paramAppRuntime.getMessage());
      QLog.e("DeviceProtectQIPCModule", 1, ((StringBuilder)localObject).toString());
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ("ACTION_GET_DEVICE_INFO".equals(paramString)) {
      return a(paramBundle);
    }
    if ("ACTION_GET_GUID_INFO".equals(paramString)) {
      a(paramBundle, paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.DeviceProtectQIPCModule
 * JD-Core Version:    0.7.0.1
 */