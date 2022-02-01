package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import org.json.JSONObject;

class OpenAuthorityFragment$8$2
  implements DialogInterface.OnClickListener
{
  OpenAuthorityFragment$8$2(OpenAuthorityFragment.8 param8, preAuth.PreAuthResponse paramPreAuthResponse, JSONObject paramJSONObject) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment$8.a.a(this.jdField_a_of_type_ComTencentQconnProtofilePreAuth$PreAuthResponse.ret.get(), this.jdField_a_of_type_OrgJsonJSONObject.toString(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.8.2
 * JD-Core Version:    0.7.0.1
 */