package com.tencent.mobileqq.troop.data;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopFeedsDataManager$1
  extends Handler
{
  TroopFeedsDataManager$1(TroopFeedsDataManager paramTroopFeedsDataManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            if (i != 6) {
              return;
            }
            TroopFeedsDataManager.d(this.a);
            this.a.notifyObservers(Integer.valueOf(103));
            return;
          }
          TroopFeedsDataManager.c(this.a);
          this.a.notifyObservers(Integer.valueOf(1010));
          return;
        }
        this.a.d = ((List)paramMessage.obj);
        TroopFeedsDataManager.b(this.a);
        this.a.notifyObservers(Integer.valueOf(105));
        if (QLog.isColorLevel()) {
          QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, "end auto pull down feed");
        }
      }
      else
      {
        this.a.d = ((List)paramMessage.obj);
        TroopFeedsDataManager.a(this.a);
        this.a.notifyObservers(Integer.valueOf(101));
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("end load feed: ");
          paramMessage.append(System.currentTimeMillis());
          QLog.d("TroopFeedsDataManager", 2, paramMessage.toString());
        }
      }
    }
    else
    {
      this.a.d = ((List)paramMessage.obj);
      this.a.a(1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.1
 * JD-Core Version:    0.7.0.1
 */