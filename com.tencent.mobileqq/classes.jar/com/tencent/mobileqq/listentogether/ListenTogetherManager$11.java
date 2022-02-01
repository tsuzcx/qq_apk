package com.tencent.mobileqq.listentogether;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.Map;

class ListenTogetherManager$11
  implements DialogInterface.OnClickListener
{
  ListenTogetherManager$11(ListenTogetherManager paramListenTogetherManager, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a();
      paramDialogInterface.dismiss();
    }
    while (paramInt != 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.b();
    paramDialogInterface.dismiss();
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager, (ListenTogetherSession)ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager).get(ListenTogetherUtils.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.11
 * JD-Core Version:    0.7.0.1
 */