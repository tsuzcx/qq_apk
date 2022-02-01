package com.tencent.mobileqq.profilecard.vas.component.header;

import android.os.Message;
import ayyb;
import ayye;
import bjng;
import com.tencent.mobileqq.data.Card;

public class AbsVasProfileHeaderComponent$4$1
  implements Runnable
{
  public AbsVasProfileHeaderComponent$4$1(ayye paramayye, Card paramCard) {}
  
  public void run()
  {
    if (ayyb.b(this.jdField_a_of_type_Ayye.a) == null) {
      return;
    }
    boolean bool = ayyb.a(this.jdField_a_of_type_Ayye.a, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, this.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet, this.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo, this.jdField_a_of_type_ComTencentMobileqqDataCard.cardId);
    Message localMessage = ayyb.c(this.jdField_a_of_type_Ayye.a).obtainMessage(13, Boolean.valueOf(bool));
    ayyb.d(this.jdField_a_of_type_Ayye.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.4.1
 * JD-Core Version:    0.7.0.1
 */