package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.handler.ITroopTokenHandler;

class BindGroupFragment$4
  implements DialogInterface.OnClickListener
{
  BindGroupFragment$4(BindGroupFragment paramBindGroupFragment, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      BindGroupFragment.a(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment, HardCodeUtil.a(2131701335));
      ((ITroopTokenHandler)BindGroupFragment.a(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment).getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).a(Integer.valueOf(BindGroupFragment.a(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment)).intValue(), Integer.valueOf(BindGroupFragment.b(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment)).intValue(), Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), BindGroupFragment.c(this.jdField_a_of_type_ComTencentOpenAgentBindGroupFragment));
      return;
    }
    if (paramInt == 0) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupFragment.4
 * JD-Core Version:    0.7.0.1
 */