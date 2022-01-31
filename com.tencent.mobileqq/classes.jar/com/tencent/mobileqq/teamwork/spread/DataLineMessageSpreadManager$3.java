package com.tencent.mobileqq.teamwork.spread;

import ayhh;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.TimerTask;

public class DataLineMessageSpreadManager$3
  extends TimerTask
{
  public DataLineMessageSpreadManager$3(ayhh paramayhh) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.this$0.a;
      if (l2 >= 950L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DataLineMessageSpreadManager", 1, "lastInsertTime[" + this.this$0.a + "],now[" + l1 + "], dur[" + l2 + "],timeOut start check!");
        }
        i = ayhh.a(this.this$0).size() - 1;
        while (i >= 0)
        {
          localMessageRecord = (MessageRecord)ayhh.a(this.this$0).get(i);
          this.this$0.a((DataLineMsgRecord)localMessageRecord);
          i -= 1;
        }
        this.this$0.a = 0L;
        ayhh.a(this.this$0).clear();
      }
      while (!QLog.isColorLevel())
      {
        int i;
        MessageRecord localMessageRecord;
        return;
      }
      QLog.i("DataLineMessageSpreadManager", 1, "lastInsertTime[" + this.this$0.a + "],now[" + l1 + "], dur[" + l2 + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.3
 * JD-Core Version:    0.7.0.1
 */