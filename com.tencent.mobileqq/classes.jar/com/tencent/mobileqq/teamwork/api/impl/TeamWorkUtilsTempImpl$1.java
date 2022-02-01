package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Bundle;
import android.os.Process;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;

class TeamWorkUtilsTempImpl$1
  implements Runnable
{
  TeamWorkUtilsTempImpl$1(TeamWorkUtilsTempImpl paramTeamWorkUtilsTempImpl, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3, int paramInt, String paramString4) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    localObject1 = new UniteGrayTipParam((String)localObject1, (String)localObject1, this.b, 1, -5020, 3276804, MessageCache.a());
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_action", 42);
    ((Bundle)localObject2).putString("key_action_DATA", this.this$0.getTroopFormGrayParameter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, 1));
    ((Bundle)localObject2).putString("key_a_action_DATA", this.c);
    int i = this.jdField_a_of_type_Int;
    ((UniteGrayTipParam)localObject1).a(i, this.d.length() + i, (Bundle)localObject2);
    localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject1);
    UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X8009FD0", "0X8009FD0", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsTempImpl.1
 * JD-Core Version:    0.7.0.1
 */