package com.tencent.mobileqq.teamwork.spread;

import android.text.TextUtils;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;

class DataLineMessageSpreadManager$1
  implements Runnable
{
  DataLineMessageSpreadManager$1(DataLineMessageSpreadManager paramDataLineMessageSpreadManager, DataLineMsgRecord paramDataLineMsgRecord) {}
  
  public void run()
  {
    if (QLog.isDebugVersion()) {
      QLog.i("DataLineMessageSpreadManager", 1, "SubThread Process Start");
    }
    if (!DataLineMessageSpreadManager.a(this.this$0, this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DataLineMessageSpreadManager", 1, "config return false!");
      }
      return;
    }
    if (this.a.msgtype == -2005)
    {
      if (QLog.isDebugVersion()) {
        QLog.i("DataLineMessageSpreadManager", 1, "message is MessageForFile");
      }
      Object localObject1 = this.this$0;
      DataLineMessageSpreadManager.a((DataLineMessageSpreadManager)localObject1, new BuddyFileDataLineMsgTips(DataLineMessageSpreadManager.a((DataLineMessageSpreadManager)localObject1), this.a, DataLineMessageSpreadManager.b(this.this$0)));
      if (!DataLineMessageSpreadManager.c(this.this$0).b())
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("file[");
          ((StringBuilder)localObject1).append(DataLineMessageSpreadManager.c(this.this$0).a());
          ((StringBuilder)localObject1).append("] is not support!");
          QLog.i("DataLineMessageSpreadManager", 1, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      Object localObject3 = DataLineMessageSpreadManager.c(this.this$0).a();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("recv new File name is :");
        ((StringBuilder)localObject1).append((String)localObject3);
        QLog.i("DataLineMessageSpreadManager", 1, ((StringBuilder)localObject1).toString());
      }
      String[] arrayOfString = DataLineMessageSpreadManager.b(this.this$0).a(DataLineMessageSpreadManager.c(this.this$0));
      int i = arrayOfString.length;
      int k = 0;
      localObject1 = "";
      int j;
      Object localObject2;
      if (i == 0)
      {
        j = 1;
        localObject2 = localObject1;
      }
      else
      {
        if (QLog.isDebugVersion())
        {
          localObject2 = new StringBuilder();
          j = arrayOfString.length;
          i = 0;
          while (i < j)
          {
            ((StringBuilder)localObject2).append(arrayOfString[i]);
            ((StringBuilder)localObject2).append(",");
            i += 1;
          }
          if (((StringBuilder)localObject2).length() > 0) {
            ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getConfig keyWords:");
          localStringBuilder.append(((StringBuilder)localObject2).toString());
          QLog.i("DataLineMessageSpreadManager", 1, localStringBuilder.toString());
        }
        int m = arrayOfString.length;
        i = 0;
        for (;;)
        {
          j = k;
          localObject2 = localObject1;
          if (i >= m) {
            break label433;
          }
          localObject2 = arrayOfString[i];
          if (((String)localObject3).contains((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            break;
          }
          i += 1;
        }
      }
      label433:
      if (j != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("keyWord[");
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("] find!");
          QLog.i("DataLineMessageSpreadManager", 1, ((StringBuilder)localObject1).toString());
        }
        localObject2 = DataLineMessageSpreadManager.b(this.this$0).b(DataLineMessageSpreadManager.c(this.this$0));
        localObject1 = DataLineMessageSpreadManager.b(this.this$0).c(DataLineMessageSpreadManager.c(this.this$0));
        if ((TextUtils.isEmpty((CharSequence)localObject2)) && (QLog.isColorLevel()))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("tips is null! return, tips[");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("], link[");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("]");
          QLog.i("DataLineMessageSpreadManager", 1, ((StringBuilder)localObject3).toString());
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("。");
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject2 = ((StringBuilder)localObject3).toString();
        if ((DataLineMessageSpreadManager.c(this.this$0) instanceof BuddyFileDataLineMsgTips)) {
          DataLineMessageSpreadManager.a(this.this$0, this.a, (String)localObject2, (String)localObject1, "keyword", null);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DataLineMessageSpreadManager", 1, "keyWords not find!");
      }
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("DataLineMessageSpreadManager", 1, "message is unknown");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.1
 * JD-Core Version:    0.7.0.1
 */