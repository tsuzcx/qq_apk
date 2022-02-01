package com.tencent.mobileqq.hotpic;

import avdh;
import avdm;
import com.tencent.qphone.base.util.QLog;

public class PresenceInterfaceImpl$4$1
  implements Runnable
{
  public PresenceInterfaceImpl$4$1(avdm paramavdm) {}
  
  public void run()
  {
    avdh.a(this.a.jdField_a_of_type_Avdh, true);
    avdh.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    this.a.jdField_a_of_type_Avdh.a.b(-11);
    QLog.d("PresenceInterfaceImpl", 2, "saveUserPermission false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.4.1
 * JD-Core Version:    0.7.0.1
 */