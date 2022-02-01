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
    if (!AIOMessageSpreadManager.a(this.this$0, this.a)) {
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "config return false!");
      }
    }
    label279:
    do
    {
      return;
      if ((this.a instanceof MessageForText))
      {
        AIOMessageSpreadManager.a(this.this$0, new TeamWorkTextMsgTipsProcessor(AIOMessageSpreadManager.a(this.this$0), this.a, AIOMessageSpreadManager.a(this.this$0)));
        if (QLog.isDebugVersion()) {
          QLog.i("AIOMessageSpreadManager", 1, "message is MessageForText");
        }
      }
      for (;;)
      {
        if (AIOMessageSpreadManager.a(this.this$0).a()) {
          break label294;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AIOMessageSpreadManager", 1, "file[" + AIOMessageSpreadManager.a(this.this$0).a() + "] is not support!");
        return;
        if ((this.a instanceof MessageForFile))
        {
          if (QLog.isDebugVersion()) {
            QLog.i("AIOMessageSpreadManager", 1, "message is MessageForFile");
          }
          AIOMessageSpreadManager.a(this.this$0, new BuddyFileAIOMsgTips(AIOMessageSpreadManager.a(this.this$0), this.a, AIOMessageSpreadManager.a(this.this$0)));
        }
        else
        {
          if (!(this.a instanceof MessageForTroopFile)) {
            break label279;
          }
          if (QLog.isDebugVersion()) {
            QLog.i("AIOMessageSpreadManager", 1, "message is MessageForTroopFile");
          }
          AIOMessageSpreadManager.a(this.this$0, new TroopFileAIOMsgTips(AIOMessageSpreadManager.a(this.this$0), this.a, AIOMessageSpreadManager.a(this.this$0)));
        }
      }
    } while (!QLog.isDebugVersion());
    QLog.i("AIOMessageSpreadManager", 1, "message is unknown");
    return;
    label294:
    String str = AIOMessageSpreadManager.a(this.this$0).a();
    if (QLog.isColorLevel()) {
      QLog.i("AIOMessageSpreadManager", 1, "recv new File name is :" + str);
    }
    Object localObject2 = AIOMessageSpreadManager.a(this.this$0).a(AIOMessageSpreadManager.a(this.this$0));
    Object localObject1;
    if (QLog.isDebugVersion())
    {
      localObject1 = new StringBuilder();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject1).append(localObject2[i]).append(",");
        i += 1;
      }
      if (((StringBuilder)localObject1).length() > 0) {
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      }
      QLog.i("AIOMessageSpreadManager", 1, "getConfig keyWords:" + ((StringBuilder)localObject1).toString());
    }
    int j = localObject2.length;
    int i = 0;
    label455:
    if (i < j)
    {
      localObject1 = localObject2[i];
      if (!str.contains((CharSequence)localObject1)) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOMessageSpreadManager", 1, "keyWord[" + (String)localObject1 + "] find!");
        }
        localObject2 = AIOMessageSpreadManager.a(this.this$0).a(AIOMessageSpreadManager.a(this.this$0));
        str = AIOMessageSpreadManager.a(this.this$0).b(AIOMessageSpreadManager.a(this.this$0));
        if ((TextUtils.isEmpty((CharSequence)localObject2)) && (QLog.isColorLevel())) {
          QLog.i("AIOMessageSpreadManager", 1, "tips is null! return, tips[" + (String)localObject2 + "], link[" + str + "]");
        }
        localObject2 = (String)localObject2 + "。" + str;
        if (((AIOMessageSpreadManager.a(this.this$0) instanceof BuddyFileAIOMsgTips)) || ((AIOMessageSpreadManager.a(this.this$0) instanceof TroopFileAIOMsgTips)))
        {
          AIOMessageSpreadManager.a(this.this$0, this.a, (String)localObject2, str, "keyword", null);
          return;
          i += 1;
          break label455;
        }
        if (!(AIOMessageSpreadManager.a(this.this$0) instanceof TeamWorkTextMsgTipsProcessor)) {
          break;
        }
        AIOMessageSpreadManager.a(this.this$0, this.a, (String)localObject2, str, "text_keyword", AIOMessageSpreadManager.a(this.this$0).a((String)localObject1));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "keyWords not find!");
      }
      if ((AIOMessageSpreadManager.a(this.this$0) instanceof TeamWorkTextMsgTipsProcessor)) {
        break;
      }
      AIOMessageSpreadManager.a(this.this$0).a(new AIOMessageSpreadManager.1.1(this, str));
      return;
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.1
 * JD-Core Version:    0.7.0.1
 */