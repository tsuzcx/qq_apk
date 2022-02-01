package com.tencent.mobileqq.loginwelcome;

import android.content.Context;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.IPUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqBodySelfPhone;
import tencent.im.login.GatewayVerify.ReqBodySelfPhoneCheckV4;
import tencent.im.login.GatewayVerify.SelfPhoneToken;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

public class MultiGatewayCallback
  implements GatewayCallback
{
  private String a;
  private IGatewayEntrance b;
  private int c;
  private int d;
  private boolean e;
  private final GatewayVerify.ReqBody f;
  private int g;
  
  public MultiGatewayCallback(Context paramContext, String paramString, int paramInt, IGatewayEntrance paramIGatewayEntrance)
  {
    this.a = paramString;
    this.b = paramIGatewayEntrance;
    this.c = paramInt;
    this.f = new GatewayVerify.ReqBody();
    this.f.msg_req_self_phone.msg_req_check_phone_v4.str_msg_id.set(this.a);
    paramString = IPUtils.a();
    if ((!NetworkUtil.isWifiConnected(paramContext)) && (paramString != null)) {
      this.f.msg_req_self_phone.msg_req_check_phone_v4.str_cell_ip.set(paramString);
    }
    this.f.msg_req_self_phone.msg_req_check_phone_v4.setHasFlag(true);
    this.f.msg_req_self_phone.setHasFlag(true);
    this.f.setHasFlag(true);
  }
  
  private void b()
  {
    byte[] arrayOfByte = this.f.toByteArray();
    this.b.a(arrayOfByte);
  }
  
  public void a(Exception paramException)
  {
    try
    {
      boolean bool = a();
      QLog.e("MultiGatewayCallback", 1, new Object[] { "onChangeNetworkError : ", paramException.getMessage() });
      if (!bool)
      {
        QLog.d("MultiGatewayCallback", 1, "not finish request");
        return;
      }
      if (!this.e)
      {
        QLog.e("MultiGatewayCallback", 1, "no success request");
        this.b.a(paramException);
        return;
      }
      b();
      return;
    }
    finally {}
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl)
  {
    this.g += 1;
    if (this.g > 5)
    {
      QLog.e("MultiGatewayCallback", 1, "onRedirect time out of max time");
      b(-100000, new Exception("onRedirect time out"));
      return;
    }
    QLog.d("MultiGatewayCallback", 1, "redirect");
    GateWayVerifyManager.a().a(paramSelfPhoneUrl, this);
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, String paramString)
  {
    if (paramSelfPhoneUrl == null) {}
    try
    {
      QLog.e("MultiGatewayCallback", 1, "onResponse, but urlBean is null");
      b(-100001, new Exception("urlBean is null"));
      return;
    }
    finally {}
    this.e = true;
    boolean bool = a();
    GatewayVerify.SelfPhoneToken localSelfPhoneToken = new GatewayVerify.SelfPhoneToken();
    QLog.d("MultiGatewayCallback", 1, new Object[] { "onResponse, current success request count: ", Integer.valueOf(this.d), " totalCount : ", Integer.valueOf(this.c), " request channelId : ", Integer.valueOf(paramSelfPhoneUrl.int32_channel_id.get()) });
    localSelfPhoneToken.str_token.set(paramString);
    localSelfPhoneToken.int32_channel_id.set(paramSelfPhoneUrl.int32_channel_id.get());
    this.f.msg_req_self_phone.msg_req_check_phone_v4.rpt_self_phone_token.add(localSelfPhoneToken);
    if (bool) {
      b();
    }
  }
  
  public boolean a()
  {
    this.d += 1;
    return this.d >= this.c;
  }
  
  public void b(int paramInt, Exception paramException)
  {
    try
    {
      boolean bool = a();
      QLog.e("MultiGatewayCallback", 1, new Object[] { "onGetTokenError : ", paramException.getMessage() });
      if (!bool)
      {
        QLog.e("MultiGatewayCallback", 1, "not finish request");
        return;
      }
      if (!this.e)
      {
        QLog.e("MultiGatewayCallback", 1, "no success request");
        this.b.a(paramInt, paramException);
        return;
      }
      b();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.MultiGatewayCallback
 * JD-Core Version:    0.7.0.1
 */