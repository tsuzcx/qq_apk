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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack != null) && ((paramMessage.obj instanceof HashMap))) {
            this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack.a((HashMap)paramMessage.obj);
          }
        }
        else
        {
          paramMessage = this.a;
          paramMessage.jdField_a_of_type_Double += TroopMemberDataProvider.jdField_b_of_type_Double;
          if ((this.a.jdField_a_of_type_Double < 90.0D) && (this.a.jdField_b_of_type_Int > 0))
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack != null)
            {
              paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack;
              i = (int)this.a.jdField_a_of_type_Double;
              String str = HardCodeUtil.a(2131715392);
              double d1 = this.a.jdField_b_of_type_Int;
              double d2 = this.a.jdField_a_of_type_Double;
              Double.isNaN(d1);
              paramMessage.a(i, String.format(str, new Object[] { Integer.valueOf(Math.min((int)(d1 * d2 / 100.0D), this.a.jdField_b_of_type_Int)), Integer.valueOf(this.a.jdField_b_of_type_Int) }));
            }
            this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3), 800L);
          }
        }
      }
      else
      {
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack.d();
        }
        TroopMemberDataProvider.a(this.a);
      }
    }
    else if (this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberTroopMemberDataProvider$DataNotifyCallBack.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider.1
 * JD-Core Version:    0.7.0.1
 */