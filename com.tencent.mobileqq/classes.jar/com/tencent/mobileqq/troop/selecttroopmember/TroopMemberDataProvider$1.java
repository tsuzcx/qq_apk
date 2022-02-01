package com.tencent.mobileqq.troop.selecttroopmember;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.HashMap;

class TroopMemberDataProvider$1
  extends Handler
{
  TroopMemberDataProvider$1(TroopMemberDataProvider paramTroopMemberDataProvider) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack == null);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack.c();
        return;
        paramMessage = this.a;
        paramMessage.jdField_a_of_type_Double += TroopMemberDataProvider.jdField_b_of_type_Double;
      } while ((this.a.jdField_a_of_type_Double >= 90.0D) || (this.a.jdField_b_of_type_Int <= 0));
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack.a((int)this.a.jdField_a_of_type_Double, String.format(HardCodeUtil.a(2131715470), new Object[] { Integer.valueOf(Math.min((int)(this.a.jdField_b_of_type_Int * this.a.jdField_a_of_type_Double / 100.0D), this.a.jdField_b_of_type_Int)), Integer.valueOf(this.a.jdField_b_of_type_Int) }));
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3), 800L);
      return;
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack.d();
      }
      TroopMemberDataProvider.a(this.a);
      return;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack == null) || (!(paramMessage.obj instanceof HashMap)));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack.a((HashMap)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider.1
 * JD-Core Version:    0.7.0.1
 */