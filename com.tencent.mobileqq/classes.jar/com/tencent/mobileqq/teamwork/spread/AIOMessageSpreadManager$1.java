package com.tencent.mobileqq.teamwork.spread;

import android.text.TextUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

class AIOMessageSpreadManager$1
  implements Runnable
{
  AIOMessageSpreadManager$1(AIOMessageSpreadManager paramAIOMessageSpreadManager, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    if (QLog.isDebugVersion()) {
      QLog.i("AIOMessageSpreadManager", 1, "SubThread Process Start");
    }
    if (!AIOMessageSpreadManager.a(this.this$0, this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "config return false!");
      }
      return;
    }
    Object localObject1 = this.a;
    if ((localObject1 instanceof MessageForText))
    {
      localObject1 = this.this$0;
      AIOMessageSpreadManager.a((AIOMessageSpreadManager)localObject1, new TeamWorkTextMsgTipsProcessor(AIOMessageSpreadManager.a((AIOMessageSpreadManager)localObject1), this.a, AIOMessageSpreadManager.b(this.this$0)));
      if (QLog.isDebugVersion()) {
        QLog.i("AIOMessageSpreadManager", 1, "message is MessageForText");
      }
    }
    else if ((localObject1 instanceof MessageForFile))
    {
      if (QLog.isDebugVersion()) {
        QLog.i("AIOMessageSpreadManager", 1, "message is MessageForFile");
      }
      localObject1 = this.this$0;
      AIOMessageSpreadManager.a((AIOMessageSpreadManager)localObject1, new BuddyFileAIOMsgTips(AIOMessageSpreadManager.a((AIOMessageSpreadManager)localObject1), this.a, AIOMessageSpreadManager.b(this.this$0)));
    }
    else
    {
      if (!(localObject1 instanceof MessageForTroopFile)) {
        break label880;
      }
      if (QLog.isDebugVersion()) {
        QLog.i("AIOMessageSpreadManager", 1, "message is MessageForTroopFile");
      }
      localObject1 = this.this$0;
      AIOMessageSpreadManager.a((AIOMessageSpreadManager)localObject1, new TroopFileAIOMsgTips(AIOMessageSpreadManager.a((AIOMessageSpreadManager)localObject1), this.a, AIOMessageSpreadManager.b(this.this$0)));
    }
    if (!AIOMessageSpreadManager.c(this.this$0).b())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("file[");
        ((StringBuilder)localObject1).append(AIOMessageSpreadManager.c(this.this$0).a());
        ((StringBuilder)localObject1).append("] is not support!");
        QLog.i("AIOMessageSpreadManager", 1, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject2 = AIOMessageSpreadManager.c(this.this$0).a();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("recv new File name is :");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.i("AIOMessageSpreadManager", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject3 = AIOMessageSpreadManager.b(this.this$0).a(AIOMessageSpreadManager.c(this.this$0));
    boolean bool = QLog.isDebugVersion();
    int j = 0;
    Object localObject4;
    if (bool)
    {
      localObject1 = new StringBuilder();
      k = localObject3.length;
      i = 0;
      while (i < k)
      {
        ((StringBuilder)localObject1).append(localObject3[i]);
        ((StringBuilder)localObject1).append(",");
        i += 1;
      }
      if (((StringBuilder)localObject1).length() > 0) {
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("getConfig keyWords:");
      ((StringBuilder)localObject4).append(((StringBuilder)localObject1).toString());
      QLog.i("AIOMessageSpreadManager", 1, ((StringBuilder)localObject4).toString());
    }
    int k = localObject3.length;
    int i = 0;
    while (i < k)
    {
      localObject1 = localObject3[i];
      if (((String)localObject2).contains((CharSequence)localObject1))
      {
        i = 1;
        break label533;
      }
      i += 1;
    }
    localObject1 = "";
    i = j;
    label533:
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("keyWord[");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("] find!");
        QLog.i("AIOMessageSpreadManager", 1, ((StringBuilder)localObject2).toString());
      }
      localObject3 = AIOMessageSpreadManager.b(this.this$0).b(AIOMessageSpreadManager.c(this.this$0));
      localObject2 = AIOMessageSpreadManager.b(this.this$0).c(AIOMessageSpreadManager.c(this.this$0));
      if ((TextUtils.isEmpty((CharSequence)localObject3)) && (QLog.isColorLevel()))
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("tips is null! return, tips[");
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append("], link[");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append("]");
        QLog.i("AIOMessageSpreadManager", 1, ((StringBuilder)localObject4).toString());
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append("。");
      ((StringBuilder)localObject4).append((String)localObject2);
      localObject3 = ((StringBuilder)localObject4).toString();
      if ((!(AIOMessageSpreadManager.c(this.this$0) instanceof BuddyFileAIOMsgTips)) && (!(AIOMessageSpreadManager.c(this.this$0) instanceof TroopFileAIOMsgTips)))
      {
        if ((AIOMessageSpreadManager.c(this.this$0) instanceof TeamWorkTextMsgTipsProcessor))
        {
          localObject4 = this.this$0;
          AIOMessageSpreadManager.a((AIOMessageSpreadManager)localObject4, this.a, (String)localObject3, (String)localObject2, "text_keyword", AIOMessageSpreadManager.b((AIOMessageSpreadManager)localObject4).a((String)localObject1));
        }
      }
      else {
        AIOMessageSpreadManager.a(this.this$0, this.a, (String)localObject3, (String)localObject2, "keyword", null);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOMessageSpreadManager", 1, "keyWords not find!");
    }
    if (!(AIOMessageSpreadManager.c(this.this$0) instanceof TeamWorkTextMsgTipsProcessor)) {
      AIOMessageSpreadManager.c(this.this$0).a(new AIOMessageSpreadManager.1.1(this, (String)localObject2));
    }
    return;
    label880:
    if (QLog.isDebugVersion()) {
      QLog.i("AIOMessageSpreadManager", 1, "message is unknown");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.1
 * JD-Core Version:    0.7.0.1
 */