package com.tencent.mobileqq.teamwork.spread;

import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.TimerTask;

class DataLineMessageSpreadManager$3
  extends TimerTask
{
  DataLineMessageSpreadManager$3(DataLineMessageSpreadManager paramDataLineMessageSpreadManager) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.this$0.a;
      Object localObject1;
      if (l2 >= 950L)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("lastInsertTime[");
          ((StringBuilder)localObject1).append(this.this$0.a);
          ((StringBuilder)localObject1).append("],now[");
          ((StringBuilder)localObject1).append(l1);
          ((StringBuilder)localObject1).append("], dur[");
          ((StringBuilder)localObject1).append(l2);
          ((StringBuilder)localObject1).append("],timeOut start check!");
          QLog.i("DataLineMessageSpreadManager", 1, ((StringBuilder)localObject1).toString());
        }
        int i = DataLineMessageSpreadManager.a(this.this$0).size() - 1;
        while (i >= 0)
        {
          localObject1 = (MessageRecord)DataLineMessageSpreadManager.a(this.this$0).get(i);
          this.this$0.a((DataLineMsgRecord)localObject1);
          i -= 1;
        }
        this.this$0.a = 0L;
        DataLineMessageSpreadManager.a(this.this$0).clear();
      }
      else if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("lastInsertTime[");
        ((StringBuilder)localObject1).append(this.this$0.a);
        ((StringBuilder)localObject1).append("],now[");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append("], dur[");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("]");
        QLog.i("DataLineMessageSpreadManager", 1, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.3
 * JD-Core Version:    0.7.0.1
 */