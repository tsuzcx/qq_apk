package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Bundle;
import android.os.Process;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

class TeamWorkUtilsTempImpl$2
  implements Runnable
{
  TeamWorkUtilsTempImpl$2(TeamWorkUtilsTempImpl paramTeamWorkUtilsTempImpl, String paramString1, String paramString2, String paramString3, AppInterface paramAppInterface, String paramString4, String paramString5, QQAppInterface paramQQAppInterface, int paramInt, String paramString6) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    if (this.jdField_a_of_type_JavaLangString.equals(this.b)) {
      localObject1 = this.c;
    } else {
      localObject1 = this.b;
    }
    Object localObject2 = new UniteGrayTipParam((String)localObject1, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin(), this.d, 0, -5020, 3276804, MessageCache.a());
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", 42);
    localBundle.putString("key_a_action_DATA", this.e);
    TeamWorkUtilsTempImpl localTeamWorkUtilsTempImpl = this.this$0;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_JavaLangString.equals(this.b)) {
      localObject1 = this.c;
    } else {
      localObject1 = this.b;
    }
    localBundle.putString("key_action_DATA", localTeamWorkUtilsTempImpl.getTroopFormGrayParameter(localQQAppInterface, (String)localObject1, 0));
    int i = this.jdField_a_of_type_Int;
    ((UniteGrayTipParam)localObject2).a(i, this.f.length() + i, localBundle);
    Object localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject2);
    UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_JavaLangString.equals(this.b)) {
      localObject1 = this.c;
    } else {
      localObject1 = this.b;
    }
    ReportController.b((AppRuntime)localObject2, "dc00898", "", (String)localObject1, "0X8009FD0", "0X8009FD0", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsTempImpl.2
 * JD-Core Version:    0.7.0.1
 */