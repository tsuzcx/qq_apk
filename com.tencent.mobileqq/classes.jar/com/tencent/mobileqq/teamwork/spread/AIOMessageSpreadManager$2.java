package com.tencent.mobileqq.teamwork.spread;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigBean.TeamworkKeyWords;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AIOMessageSpreadManager$2
  implements Runnable
{
  AIOMessageSpreadManager$2(AIOMessageSpreadManager paramAIOMessageSpreadManager, ChatMessage paramChatMessage, String paramString1, TencentDocTipsConfigBean.TeamworkKeyWords paramTeamworkKeyWords, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject1 = AIOMessageSpreadManager.a(this.this$0).getMessageFacade().a(this.a.frienduin, this.a.istroop, this.a.uniseq);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("cant find cache msg,uniseq:");
        ((StringBuilder)localObject1).append(this.a.uniseq);
        QLog.e("AIOMessageSpreadManager", 1, ((StringBuilder)localObject1).toString());
      }
      localObject2 = this.a;
    }
    HashMap localHashMap = new HashMap();
    localObject1 = this.b;
    if (((String)localObject1).contains("%s"))
    {
      Object localObject3 = this.c;
      if (localObject3 != null) {
        try
        {
          localObject3 = String.format(this.b, new Object[] { ((TencentDocTipsConfigBean.TeamworkKeyWords)localObject3).a, this.c.a });
          localObject1 = localObject3;
          localHashMap.put("tim_aio_file_tips", localObject3);
          localObject1 = localObject3;
          localHashMap.put("tim_aio_file_link", String.format(this.d, new Object[] { this.c.a }));
          localObject1 = localObject3;
        }
        catch (Exception localException)
        {
          QLog.e("AIOMessageSpreadManager", 2, localException.toString());
        }
      }
    }
    localHashMap.put("tim_aio_file_tips", this.b);
    localHashMap.put("tim_aio_file_link", this.d);
    localHashMap.put("tim_aio_file_msg_uiniseq", String.valueOf(((MessageRecord)localObject2).uniseq));
    localHashMap.put("tim_aio_tips_type", this.e);
    TencentDocTipsConfigBean.TeamworkKeyWords localTeamworkKeyWords = this.c;
    if (localTeamworkKeyWords != null)
    {
      localHashMap.put("tim_aio_tips_template_id", String.valueOf(localTeamworkKeyWords.b));
      localHashMap.put("tim_aio_tips_template_type", String.valueOf(this.c.c));
      localHashMap.put("tim_aio_tips_keyword", String.valueOf(this.c.a));
      localHashMap.put("tim_aio_tips_type", String.valueOf(this.c.c));
    }
    long l = AIOMessageSpreadManager.a(this.this$0).getFileManagerDataCenter().a(((MessageRecord)localObject2).frienduin, AIOMessageSpreadManager.a(this.this$0).getCurrentAccountUin(), ((MessageRecord)localObject2).istroop, -3016, localHashMap, (String)localObject1, ((MessageRecord)localObject2).msgUid, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).time);
    if (QLog.isDebugVersion())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("insertGaryTips:");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append("findMsg:");
      ((StringBuilder)localObject1).append(localObject2.hashCode());
      QLog.i("AIOMessageSpreadManager", 1, ((StringBuilder)localObject1).toString());
    }
    ((MessageRecord)localObject2).saveExtInfoToExtStr("tim_aio_gary_uniseq", String.valueOf(l));
    AIOMessageSpreadManager.a(this.this$0).getMessageFacade().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, "extStr", ((MessageRecord)localObject2).getExtInfoString());
    AIOMessageSpreadManager.a(this.this$0).getMessageFacade().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, "extLong", Integer.valueOf(((MessageRecord)localObject2).extLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.2
 * JD-Core Version:    0.7.0.1
 */