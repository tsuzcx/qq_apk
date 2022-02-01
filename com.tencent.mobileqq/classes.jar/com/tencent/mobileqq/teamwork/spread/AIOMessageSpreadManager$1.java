package com.tencent.mobileqq.teamwork.spread;

import android.text.TextUtils;
import bdkg;
import bdkh;
import bdki;
import bdkm;
import bdko;
import bdkt;
import bdku;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

public class AIOMessageSpreadManager$1
  implements Runnable
{
  public AIOMessageSpreadManager$1(bdkg parambdkg, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    if (QLog.isDebugVersion()) {
      QLog.i("AIOMessageSpreadManager", 1, "SubThread Process Start");
    }
    if (!bdkg.a(this.this$0, this.a)) {
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
        bdkg.a(this.this$0, new bdkt(bdkg.a(this.this$0), this.a, bdkg.a(this.this$0)));
        if (QLog.isDebugVersion()) {
          QLog.i("AIOMessageSpreadManager", 1, "message is MessageForText");
        }
      }
      for (;;)
      {
        if (bdkg.a(this.this$0).a()) {
          break label294;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AIOMessageSpreadManager", 1, "file[" + bdkg.a(this.this$0).a() + "] is not support!");
        return;
        if ((this.a instanceof MessageForFile))
        {
          if (QLog.isDebugVersion()) {
            QLog.i("AIOMessageSpreadManager", 1, "message is MessageForFile");
          }
          bdkg.a(this.this$0, new bdkm(bdkg.a(this.this$0), this.a, bdkg.a(this.this$0)));
        }
        else
        {
          if (!(this.a instanceof MessageForTroopFile)) {
            break label279;
          }
          if (QLog.isDebugVersion()) {
            QLog.i("AIOMessageSpreadManager", 1, "message is MessageForTroopFile");
          }
          bdkg.a(this.this$0, new bdku(bdkg.a(this.this$0), this.a, bdkg.a(this.this$0)));
        }
      }
    } while (!QLog.isDebugVersion());
    QLog.i("AIOMessageSpreadManager", 1, "message is unknown");
    return;
    label294:
    String str = bdkg.a(this.this$0).a();
    if (QLog.isColorLevel()) {
      QLog.i("AIOMessageSpreadManager", 1, "recv new File name is :" + str);
    }
    Object localObject2 = bdkg.a(this.this$0).a(bdkg.a(this.this$0));
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
        localObject2 = bdkg.a(this.this$0).a(bdkg.a(this.this$0));
        str = bdkg.a(this.this$0).b(bdkg.a(this.this$0));
        if ((TextUtils.isEmpty((CharSequence)localObject2)) && (QLog.isColorLevel())) {
          QLog.i("AIOMessageSpreadManager", 1, "tips is null! return, tips[" + (String)localObject2 + "], link[" + str + "]");
        }
        localObject2 = (String)localObject2 + "。" + str;
        if (((bdkg.a(this.this$0) instanceof bdkm)) || ((bdkg.a(this.this$0) instanceof bdku)))
        {
          bdkg.a(this.this$0, this.a, (String)localObject2, str, "keyword", null);
          return;
          i += 1;
          break label455;
        }
        if (!(bdkg.a(this.this$0) instanceof bdkt)) {
          break;
        }
        bdkg.a(this.this$0, this.a, (String)localObject2, str, "text_keyword", bdkg.a(this.this$0).a((String)localObject1));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "keyWords not find!");
      }
      if ((bdkg.a(this.this$0) instanceof bdkt)) {
        break;
      }
      bdkg.a(this.this$0).a(new bdkh(this, str));
      return;
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.1
 * JD-Core Version:    0.7.0.1
 */