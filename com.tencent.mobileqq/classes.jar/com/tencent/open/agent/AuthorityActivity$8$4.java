package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import org.json.JSONObject;

class AuthorityActivity$8$4
  implements DialogInterface.OnClickListener
{
  AuthorityActivity$8$4(AuthorityActivity.8 param8, SdkAuthorize.AuthorizeResponse paramAuthorizeResponse, JSONObject paramJSONObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$8.a.a(this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse.ret.get(), this.jdField_a_of_type_OrgJsonJSONObject.toString(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.8.4
 * JD-Core Version:    0.7.0.1
 */