package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import android.os.Process;
import aslp;
import aslq;
import ayvc;
import azmj;
import badt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

public final class TeamWorkUtils$1
  implements Runnable
{
  public TeamWorkUtils$1(String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3, int paramInt, String paramString4) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    aslp localaslp = new aslp(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, 1, -5020, 3276804, ayvc.a());
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 42);
    ((Bundle)localObject).putString("key_action_DATA", badt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, 1));
    ((Bundle)localObject).putString("key_a_action_DATA", this.c);
    localaslp.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.d.length(), (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaslp);
    aslq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X8009FD0", "0X8009FD0", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.1
 * JD-Core Version:    0.7.0.1
 */