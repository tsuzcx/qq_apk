package com.tencent.mobileqq.listentogether;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

final class ListenTogetherUtils$2
  implements DialogInterface.OnClickListener
{
  ListenTogetherUtils$2(BaseChatPie paramBaseChatPie, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 1)
    {
      if (ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString)) {
        ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 3, false, null);
      }
      paramDialogInterface.dismiss();
      if (this.jdField_a_of_type_Int == 1) {
        bool1 = true;
      }
      ListenTogetherUtils.a(bool1, "clk_joinframe_join", this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (paramInt == 0)
    {
      paramDialogInterface.dismiss();
      bool1 = bool2;
      if (this.jdField_a_of_type_Int == 1) {
        bool1 = true;
      }
      ListenTogetherUtils.a(bool1, "clk_joinframe_cancel", this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherUtils.2
 * JD-Core Version:    0.7.0.1
 */