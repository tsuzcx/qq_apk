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
    Object localObject1 = this.a;
    localObject1 = new UniteGrayTipParam((String)localObject1, (String)localObject1, this.b, 1, -5020, 3276804, MessageCache.c());
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_action", 42);
    ((Bundle)localObject2).putString("key_action_DATA", this.this$0.getTroopFormGrayParameter(this.c, this.a, 1));
    ((Bundle)localObject2).putString("key_a_action_DATA", this.d);
    int i = this.e;
    ((UniteGrayTipParam)localObject1).a(i, this.f.length() + i, (Bundle)localObject2);
    localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.c, (UniteGrayTipParam)localObject1);
    UniteGrayTipMsgUtil.a(this.c, (MessageForUniteGrayTip)localObject2);
    ReportController.b(this.c, "dc00898", "", this.a, "0X8009FD0", "0X8009FD0", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsTempImpl.1
 * JD-Core Version:    0.7.0.1
 */