package com.tencent.mobileqq.listentogether;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

final class ListenTogetherUtils$1
  implements DialogInterface.OnClickListener
{
  ListenTogetherUtils$1(int paramInt1, String paramString1, String paramString2, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 1)
    {
      ((ListenTogetherHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int);
      paramDialogInterface.dismiss();
      if (this.jdField_b_of_type_Int == 1) {
        paramDialogInterface = "clk_openframe_open";
      } else {
        paramDialogInterface = "clk_joinbar_open";
      }
      if (this.jdField_a_of_type_Int == 1) {
        bool1 = true;
      }
      ListenTogetherUtils.a(bool1, paramDialogInterface, this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramInt == 0)
    {
      paramDialogInterface.dismiss();
      if (this.jdField_b_of_type_Int == 1) {
        paramDialogInterface = "clk_openframe_cancel";
      } else {
        paramDialogInterface = "clk_joinbar_cancel";
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_Int == 1) {
        bool1 = true;
      }
      ListenTogetherUtils.a(bool1, paramDialogInterface, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherUtils.1
 * JD-Core Version:    0.7.0.1
 */