package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.decoupleim.ThirdPartyLoginBlockUtilImpl;
import com.tencent.mobileqq.app.decoupleim.ThirdPartyLoginBlockUtilImpl.LoginViewOpenSDKCb;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspLftInfo;
import tencent.im.login.GatewayVerify.RspTipsInfo;

public class NotifyLoginAction
  extends BaseLoginAction
{
  private ThirdPartyLoginBlockUtilImpl.LoginViewOpenSDKCb a;
  
  public static int a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.d("NotifyLoginAction", 1, "getTipsScenesId tlvData is null");
      return 0;
    }
    try
    {
      GatewayVerify.RspBody localRspBody = new GatewayVerify.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      if (localRspBody.msg_rsp_lft_info.uint32_lft_forbid_area.get() != 1)
      {
        QLog.d("NotifyLoginAction", 1, "getTipsScenesId not area im");
        return 0;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("getTipsScenesId scene_id=");
      paramArrayOfByte.append(localRspBody.msg_rsp_tips_info.uint32_scene_id.get());
      QLog.d("NotifyLoginAction", 1, paramArrayOfByte.toString());
      int i = localRspBody.msg_rsp_tips_info.uint32_scene_id.get();
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("NotifyLoginAction", 1, "getTipsScenesId error: ", paramArrayOfByte);
    }
    return 0;
  }
  
  public void a()
  {
    super.a();
    if (this.a != null)
    {
      ThirdPartyLoginBlockUtilImpl.a().b();
      this.a = null;
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, AppRuntime paramAppRuntime, LoginErrorInfo paramLoginErrorInfo)
  {
    if (!TextUtils.isEmpty(paramLoginErrorInfo.c))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("type", 8);
      if (paramLoginErrorInfo.d == 40)
      {
        ReportController.a(paramAppRuntime, "dc00898", "", "", "0X800AC0B", "0X800AC0B", 0, 0, "", "", "", "");
        this.a = new ThirdPartyLoginBlockUtilImpl.LoginViewOpenSDKCb(paramQBaseActivity);
        if (ThirdPartyLoginBlockUtilImpl.a().a(paramLoginErrorInfo.g, paramQBaseActivity, paramLoginErrorInfo.i, paramLoginErrorInfo.j, this.a)) {
          return;
        }
        localIntent.putExtra("msg", paramLoginErrorInfo.b);
        localIntent.putExtra("errorver", paramLoginErrorInfo.f);
        localIntent.putExtra("tlverror", paramLoginErrorInfo.g);
        localIntent.putExtra("errortitle", paramLoginErrorInfo.h);
        localIntent.putExtra("is_need_login_with_mask", paramLoginErrorInfo.k);
        localIntent.putExtra("title", paramLoginErrorInfo.h);
        if (a(paramLoginErrorInfo.g) == 1)
        {
          localIntent.putExtra("uin", paramLoginErrorInfo.i);
          localIntent.putExtra("passwd", paramLoginErrorInfo.j);
          localIntent.putExtra("is_from_login", true);
          localIntent.putExtra("keyTipsScenesId", 1);
        }
      }
      else
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append(paramLoginErrorInfo.b);
        paramAppRuntime.append(" ");
        paramAppRuntime.append(paramLoginErrorInfo.c);
        localIntent.putExtra("msg", paramAppRuntime.toString());
      }
      localIntent.putExtra("loginalias", paramLoginErrorInfo.a);
      localIntent.putExtra("loginret", paramLoginErrorInfo.d);
      localIntent.putExtra("errorUrl", paramLoginErrorInfo.c);
      localIntent.putExtra("expiredSig", paramLoginErrorInfo.e);
      localIntent.putExtra("keyFromLoginView", true);
      RouteUtils.a(paramQBaseActivity, localIntent, "/base/notification");
      return;
    }
    if (paramLoginErrorInfo.d == 2008)
    {
      DialogUtil.a(paramQBaseActivity, 230, HardCodeUtil.a(2131904285), HardCodeUtil.a(2131904281), "OK", null, new NotifyLoginAction.1(this), null).show();
      QQToast.makeText(paramQBaseActivity, 2131890109, 0).show();
      return;
    }
    DialogUtil.a(paramQBaseActivity, 230, HardCodeUtil.a(2131904275), paramLoginErrorInfo.b, new NotifyLoginAction.2(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.NotifyLoginAction
 * JD-Core Version:    0.7.0.1
 */