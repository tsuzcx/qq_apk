package com.tencent.mobileqq.teamwork.spread;

import android.text.TextUtils;
import bedf;
import bedi;
import bedl;
import bedn;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;

public class DataLineMessageSpreadManager$1
  implements Runnable
{
  public DataLineMessageSpreadManager$1(bedn parambedn, DataLineMsgRecord paramDataLineMsgRecord) {}
  
  public void run()
  {
    int k = 0;
    if (QLog.isDebugVersion()) {
      QLog.i("DataLineMessageSpreadManager", 1, "SubThread Process Start");
    }
    if (!bedn.a(this.this$0, this.a)) {
      if (QLog.isColorLevel()) {
        QLog.i("DataLineMessageSpreadManager", 1, "config return false!");
      }
    }
    label179:
    label596:
    do
    {
      String str2;
      String[] arrayOfString;
      String str1;
      int i;
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            if (this.a.msgtype != -2005) {
              break;
            }
            if (QLog.isDebugVersion()) {
              QLog.i("DataLineMessageSpreadManager", 1, "message is MessageForFile");
            }
            bedn.a(this.this$0, new bedi(bedn.a(this.this$0), this.a, bedn.a(this.this$0)));
            if (bedn.a(this.this$0).a()) {
              break label179;
            }
          } while (!QLog.isColorLevel());
          QLog.i("DataLineMessageSpreadManager", 1, "file[" + bedn.a(this.this$0).a() + "] is not support!");
          return;
        } while (!QLog.isDebugVersion());
        QLog.i("DataLineMessageSpreadManager", 1, "message is unknown");
        return;
        str2 = bedn.a(this.this$0).a();
        if (QLog.isColorLevel()) {
          QLog.i("DataLineMessageSpreadManager", 1, "recv new File name is :" + str2);
        }
        arrayOfString = bedn.a(this.this$0).a(bedn.a(this.this$0));
        str1 = "";
        if (arrayOfString.length != 0) {
          break;
        }
        i = 1;
        localObject = str1;
        if (i == 0) {
          break label596;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DataLineMessageSpreadManager", 1, "keyWord[" + (String)localObject + "] find!");
        }
        str1 = bedn.a(this.this$0).a(bedn.a(this.this$0));
        localObject = bedn.a(this.this$0).b(bedn.a(this.this$0));
        if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
          QLog.i("DataLineMessageSpreadManager", 1, "tips is null! return, tips[" + str1 + "], link[" + (String)localObject + "]");
        }
        str1 = str1 + "。" + (String)localObject;
      } while (!(bedn.a(this.this$0) instanceof bedi));
      bedn.a(this.this$0, this.a, str1, (String)localObject, "keyword", null);
      return;
      if (QLog.isDebugVersion())
      {
        localObject = new StringBuilder();
        j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          ((StringBuilder)localObject).append(arrayOfString[i]).append(",");
          i += 1;
        }
        if (((StringBuilder)localObject).length() > 0) {
          ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
        }
        QLog.i("DataLineMessageSpreadManager", 1, "getConfig keyWords:" + ((StringBuilder)localObject).toString());
      }
      int m = arrayOfString.length;
      int j = 0;
      for (;;)
      {
        i = k;
        localObject = str1;
        if (j >= m) {
          break;
        }
        localObject = arrayOfString[j];
        if (str2.contains((CharSequence)localObject))
        {
          i = 1;
          break;
        }
        j += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.i("DataLineMessageSpreadManager", 1, "keyWords not find!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.1
 * JD-Core Version:    0.7.0.1
 */