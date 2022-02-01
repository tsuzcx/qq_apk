package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomDialog;

class BaseAuthorityAccountView$6
  implements DialogInterface.OnClickListener
{
  BaseAuthorityAccountView$6(BaseAuthorityAccountView paramBaseAuthorityAccountView, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ThreadManager.executeOnSubThread(new BaseAuthorityAccountView.DelAccountRunnable(this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView, this.jdField_a_of_type_JavaLangString));
      return;
    }
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView.a != null))
    {
      this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView.a.dismiss();
      this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.6
 * JD-Core Version:    0.7.0.1
 */