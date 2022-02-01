package com.tencent.mobileqq.profilecard.vas.component.header;

import android.os.Message;
import baik;
import bain;
import blhq;
import com.tencent.mobileqq.data.Card;

public class AbsVasProfileHeaderComponent$4$1
  implements Runnable
{
  public AbsVasProfileHeaderComponent$4$1(bain parambain, Card paramCard) {}
  
  public void run()
  {
    if (baik.b(this.jdField_a_of_type_Bain.a) == null) {
      return;
    }
    boolean bool = baik.a(this.jdField_a_of_type_Bain.a, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, this.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet, this.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo, this.jdField_a_of_type_ComTencentMobileqqDataCard.cardId);
    Message localMessage = baik.c(this.jdField_a_of_type_Bain.a).obtainMessage(13, Boolean.valueOf(bool));
    baik.d(this.jdField_a_of_type_Bain.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.4.1
 * JD-Core Version:    0.7.0.1
 */