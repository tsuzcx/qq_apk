package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;
import tencent.im.login.GetLocalPhone.LocalPhoneCodeData;

public abstract class LocalPhoneGatewayCallback
  implements GatewayCallback
{
  private int a;
  private int b;
  private boolean c;
  private int d;
  private List<GetLocalPhone.LocalPhoneCodeData> e;
  
  public LocalPhoneGatewayCallback(int paramInt)
  {
    this.a = paramInt;
    this.e = new ArrayList();
  }
  
  public abstract void a(int paramInt, Exception paramException);
  
  public void a(Exception paramException)
  {
    try
    {
      boolean bool = a();
      QLog.e("LocalPhoneGatewayCallback", 1, new Object[] { "onChangeNetworkError : ", paramException.getMessage() });
      if (!bool)
      {
        QLog.d("LocalPhoneGatewayCallback", 1, "not finish request");
        return;
      }
      if (!this.c)
      {
        QLog.e("LocalPhoneGatewayCallback", 1, "no success request");
        a(-100002, paramException);
        return;
      }
      QLog.e("LocalPhoneGatewayCallback", 1, "onChangeNetworkError getTokenFinish");
      a(this.e);
      return;
    }
    finally {}
  }
  
  public abstract void a(List<GetLocalPhone.LocalPhoneCodeData> paramList);
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl)
  {
    this.d += 1;
    if (this.d > 5)
    {
      QLog.e("LocalPhoneGatewayCallback", 1, "onRedirect time out of max time");
      b(-100000, new Exception("onRedirect time out"));
      return;
    }
    QLog.d("LocalPhoneGatewayCallback", 1, "redirect");
    GateWayVerifyManager.a().a(paramSelfPhoneUrl, this);
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, String paramString)
  {
    if (paramSelfPhoneUrl == null) {}
    try
    {
      QLog.e("LocalPhoneGatewayCallback", 1, "onResponse, but urlBean is null");
      b(-100001, new Exception("urlBean is null"));
      return;
    }
    finally {}
    this.c = true;
    GetLocalPhone.LocalPhoneCodeData localLocalPhoneCodeData = new GetLocalPhone.LocalPhoneCodeData();
    localLocalPhoneCodeData.str_code_data.set(paramString);
    localLocalPhoneCodeData.int32_channel_id.set(paramSelfPhoneUrl.int32_channel_id.get());
    this.e.add(localLocalPhoneCodeData);
    boolean bool = a();
    QLog.d("LocalPhoneGatewayCallback", 1, new Object[] { "onResponse, current success request count: ", Integer.valueOf(this.b), " totalCount : ", Integer.valueOf(this.a), " request channelId : ", Integer.valueOf(paramSelfPhoneUrl.int32_channel_id.get()) });
    if (bool) {
      a(this.e);
    }
  }
  
  public boolean a()
  {
    this.b += 1;
    return this.b >= this.a;
  }
  
  public void b(int paramInt, Exception paramException)
  {
    try
    {
      boolean bool = a();
      QLog.e("LocalPhoneGatewayCallback", 1, new Object[] { "onGetTokenError : ", paramException.getMessage() });
      if (!bool)
      {
        QLog.e("LocalPhoneGatewayCallback", 1, "not finish request");
        return;
      }
      if (!this.c)
      {
        QLog.e("LocalPhoneGatewayCallback", 1, "no success request");
        a(paramInt, paramException);
        return;
      }
      QLog.e("LocalPhoneGatewayCallback", 1, "onGetTokenError getTokenFinish");
      a(this.e);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LocalPhoneGatewayCallback
 * JD-Core Version:    0.7.0.1
 */