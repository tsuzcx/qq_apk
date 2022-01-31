package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import android.os.Process;
import aqax;
import aqay;
import awao;
import awqx;
import axfs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

public final class TeamWorkUtils$2
  implements Runnable
{
  public TeamWorkUtils$2(String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface, String paramString4, String paramString5, int paramInt, String paramString6) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    Object localObject2;
    if (this.jdField_a_of_type_JavaLangString.equals(this.b))
    {
      localObject1 = this.c;
      localObject2 = new aqax((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.d, 0, -5020, 3276804, awao.a());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 42);
      localBundle.putString("key_a_action_DATA", this.e);
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!this.jdField_a_of_type_JavaLangString.equals(this.b)) {
        break label220;
      }
      localObject1 = this.c;
      label104:
      localBundle.putString("key_action_DATA", axfs.a(localQQAppInterface, (String)localObject1, 0));
      ((aqax)localObject2).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.f.length(), localBundle);
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aqax)localObject2);
      aqay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!this.jdField_a_of_type_JavaLangString.equals(this.b)) {
        break label228;
      }
    }
    label220:
    label228:
    for (Object localObject1 = this.c;; localObject1 = this.b)
    {
      awqx.b((QQAppInterface)localObject2, "dc00898", "", (String)localObject1, "0X8009FD0", "0X8009FD0", 0, 0, "", "", "", "");
      return;
      localObject1 = this.b;
      break;
      localObject1 = this.b;
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.2
 * JD-Core Version:    0.7.0.1
 */