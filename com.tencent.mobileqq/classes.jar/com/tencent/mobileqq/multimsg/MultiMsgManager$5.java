package com.tencent.mobileqq.multimsg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

class MultiMsgManager$5
  implements Runnable
{
  MultiMsgManager$5(MultiMsgManager paramMultiMsgManager, QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.a.getMessageFacade().a(this.b, this.c, this.d);
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)localObject).structingMsg.mMsgAction)))
    {
      localObject = MultiMsgManager.a().a(this.a, this.d);
      if (localObject != null)
      {
        int i = ((List)localObject).size();
        int j = MultiMsgManager.a().a((Collection)localObject);
        localObject = new HashMap();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.e ^ true);
        localStringBuilder.append("");
        ((HashMap)localObject).put("result", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        ((HashMap)localObject).put("msgCount", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(j);
        localStringBuilder.append("");
        ((HashMap)localObject).put("picCount", localStringBuilder.toString());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.getCurrentAccountUin(), "multiMsgSend", this.e, 30000L, 0L, (HashMap)localObject, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.5
 * JD-Core Version:    0.7.0.1
 */