package com.tencent.mobileqq.teamwork.spread;

import bajc;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.TimerTask;

public class AIOMessageSpreadManager$3
  extends TimerTask
{
  public AIOMessageSpreadManager$3(bajc parambajc) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.this$0.a;
      if (l2 >= 950L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOMessageSpreadManager", 1, "lastInsertTime[" + this.this$0.a + "],now[" + l1 + "], dur[" + l2 + "],timeOut start check!");
        }
        i = bajc.a(this.this$0).size() - 1;
        while (i >= 0)
        {
          localMessageRecord = (MessageRecord)bajc.a(this.this$0).get(i);
          this.this$0.a((ChatMessage)localMessageRecord);
          i -= 1;
        }
        this.this$0.a = 0L;
        bajc.a(this.this$0).clear();
      }
      while (!QLog.isColorLevel())
      {
        int i;
        MessageRecord localMessageRecord;
        return;
      }
      QLog.i("AIOMessageSpreadManager", 1, "lastInsertTime[" + this.this$0.a + "],now[" + l1 + "], dur[" + l2 + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.3
 * JD-Core Version:    0.7.0.1
 */