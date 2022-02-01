package com.tencent.mobileqq.identification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQIdentiferLegacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class FaceLoginHelper
{
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, FaceLoginHelper.IConfInterface paramIConfInterface)
  {
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    YTAGReflectLiveCheckInterface.getLiveCheckType(paramContext.getApplicationContext(), new FaceLoginHelper.2(paramInt, localAtomicBoolean, paramString1, paramString2, paramString3, paramLong, paramIConfInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, oidb_0x5e1.RspBody paramRspBody, FaceSecureCheck.SecureCheckResponse paramSecureCheckResponse, Runnable paramRunnable)
  {
    if (((oidb_0x5e1.UdcUinData)paramRspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() == 0)
    {
      if (TextUtils.isEmpty(paramString))
      {
        QQToast.a(paramActivity, paramActivity.getString(2131698848), 0).a();
        paramRunnable.run();
        return;
      }
      if ((paramSecureCheckResponse == null) || (!paramSecureCheckResponse.bool_sec_pass.get()))
      {
        if (System.currentTimeMillis() - LoginStaticField.a >= 60000L)
        {
          LoginVerifyServlet.a(paramQQAppInterface, new FaceLoginHelper.1(paramString, paramActivity, paramRunnable));
          return;
        }
        paramRspBody = new Intent();
        paramRspBody.putExtra("keyFrom", "f_SetFaceData");
        paramQQAppInterface = paramString;
        if (paramString == null) {
          paramQQAppInterface = "";
        }
        paramRspBody.putExtra("phone_num", paramQQAppInterface);
        RouteUtils.a(paramActivity, paramRspBody, "/base/login/authDevVerifyCode", 11);
        return;
      }
      paramQQAppInterface = new Intent(paramActivity, QQIdentiferLegacyActivity.class);
      paramQQAppInterface.putExtra("platformAppId", 101810106);
      paramQQAppInterface.putExtra("srcAppId", 101810106);
      paramQQAppInterface.putExtra("srcOpenId", paramSecureCheckResponse.str_openid.get());
      paramQQAppInterface.putExtra("key", paramSecureCheckResponse.str_tmpkey.get());
      paramQQAppInterface.putExtra("method", "setFaceData");
      paramQQAppInterface.putExtra("serviceType", 2);
      paramActivity.startActivityForResult(paramQQAppInterface, 21);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(paramActivity, paramActivity.getString(2131698843), 0).a();
      paramRunnable.run();
      return;
    }
    PublicFragmentActivity.a(paramActivity, DeleteFaceFragment.class, 12);
  }
  
  private static void b(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, FaceLoginHelper.IConfInterface paramIConfInterface)
  {
    QLog.d("FaceLoginHelper", 1, new Object[] { "start sendPacket appid : ", Integer.valueOf(paramInt) });
    if (paramInt != 0)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("srcAppId", paramInt);
      localBundle.putString("key", paramString1);
      localBundle.putString("lightInfo", paramString4);
      localBundle.putString("method", paramString2);
      localBundle.putString("uin", paramString3);
      localBundle.putLong("nonce", paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("FaceLoginHelper", 1, "sendPacket" + paramString4);
      }
      QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_app_conf", localBundle, new FaceLoginHelper.3(paramIConfInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceLoginHelper
 * JD-Core Version:    0.7.0.1
 */