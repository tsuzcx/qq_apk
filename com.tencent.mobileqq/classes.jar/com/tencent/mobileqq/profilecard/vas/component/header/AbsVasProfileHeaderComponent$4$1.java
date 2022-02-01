package com.tencent.mobileqq.profilecard.vas.component.header;

import android.os.Message;
import azpu;
import azpx;
import bkgm;
import com.tencent.mobileqq.data.Card;

public class AbsVasProfileHeaderComponent$4$1
  implements Runnable
{
  public AbsVasProfileHeaderComponent$4$1(azpx paramazpx, Card paramCard) {}
  
  public void run()
  {
    if (azpu.b(this.jdField_a_of_type_Azpx.a) == null) {
      return;
    }
    boolean bool = azpu.a(this.jdField_a_of_type_Azpx.a, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, this.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet, this.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo, this.jdField_a_of_type_ComTencentMobileqqDataCard.cardId);
    Message localMessage = azpu.c(this.jdField_a_of_type_Azpx.a).obtainMessage(13, Boolean.valueOf(bool));
    azpu.d(this.jdField_a_of_type_Azpx.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.4.1
 * JD-Core Version:    0.7.0.1
 */