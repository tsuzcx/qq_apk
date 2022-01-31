package com.tencent.open.agent;

import ajya;
import android.os.SystemClock;
import android.text.TextUtils;
import aqgj;
import bddd;
import bdod;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.PassData;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSelectPermissionFragment$4$1
  implements Runnable
{
  public OpenSelectPermissionFragment$4$1(bddd parambddd, boolean paramBoolean, SdkAuthorize.AuthorizeResponse paramAuthorizeResponse, int paramInt) {}
  
  public void run()
  {
    long l;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null))
    {
      l = OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bddd.a);
      aqgj.a("KEY_AUTHORIZE_REQUEST", OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bddd.a).a().a(String.valueOf(l)), true);
      this.jdField_a_of_type_Bddd.a.a(this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.openid.get());
      this.jdField_a_of_type_Bddd.a.a(this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.openid.get(), this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.encrytoken.get());
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.ret.get());
        localJSONObject.put("openid", this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.openid.get());
        localJSONObject.put("access_token", this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.access_token.get());
        localJSONObject.put("pay_token", this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.pay_token.get());
        localJSONObject.put("expires_in", this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.expires_in.get());
        localJSONObject.put("pf", this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.pf.get());
        localJSONObject.put("pfkey", this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.pfkey.get());
        localJSONObject.put("msg", this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.msg.get());
        localJSONObject.put("login_cost", OpenSelectPermissionFragment.c(this.jdField_a_of_type_Bddd.a));
        localJSONObject.put("query_authority_cost", OpenSelectPermissionFragment.d(this.jdField_a_of_type_Bddd.a));
        localJSONObject.put("authority_cost", SystemClock.elapsedRealtime() - OpenSelectPermissionFragment.e(this.jdField_a_of_type_Bddd.a));
        if (this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.sendinstall.has()) {
          localJSONObject.put("sendinstall", this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.sendinstall.get());
        }
        if ((this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.installwording.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.installwording.get()))) {
          localJSONObject.put("installwording", this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.installwording.get());
        }
        if ((this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.passDataResp.has()) && (this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.passDataResp.size() > 0))
        {
          Iterator localIterator = this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.passDataResp.get().iterator();
          while (localIterator.hasNext())
          {
            SdkAuthorize.PassData localPassData = (SdkAuthorize.PassData)localIterator.next();
            localJSONObject.put(localPassData.key.get(), localPassData.value.get());
            continue;
            this.jdField_a_of_type_Bddd.a.a();
          }
        }
      }
      catch (JSONException localJSONException) {}
      for (;;)
      {
        return;
        this.jdField_a_of_type_Bddd.a.a(this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.ret.get(), localJSONException.toString(), null, null);
      }
    }
    if ((this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.msg.get()))) {
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bddd.a, this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.msg.get() + ajya.a(2131707858) + this.jdField_a_of_type_Int, false);
    }
    for (;;)
    {
      l = OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bddd.a);
      aqgj.a("KEY_AUTHORIZE_REQUEST", OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bddd.a).a().a(String.valueOf(l)), false);
      break;
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_Bddd.a, ajya.a(2131707868) + this.jdField_a_of_type_Int, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.4.1
 * JD-Core Version:    0.7.0.1
 */