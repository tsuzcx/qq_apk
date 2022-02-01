package com.tencent.mobileqq.listentogether;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.Map;

class ListenTogetherManager$12
  implements DialogInterface.OnClickListener
{
  ListenTogetherManager$12(ListenTogetherManager paramListenTogetherManager, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a();
      paramDialogInterface.dismiss();
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b();
      paramDialogInterface.dismiss();
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager;
      ListenTogetherManager.a(paramDialogInterface, (ListenTogetherSession)ListenTogetherManager.a(paramDialogInterface).get(ListenTogetherUtils.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.12
 * JD-Core Version:    0.7.0.1
 */