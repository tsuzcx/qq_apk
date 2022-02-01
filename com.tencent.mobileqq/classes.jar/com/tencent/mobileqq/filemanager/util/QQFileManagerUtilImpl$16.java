package com.tencent.mobileqq.filemanager.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

final class QQFileManagerUtilImpl$16
  implements Runnable
{
  QQFileManagerUtilImpl$16(String paramString1, BaseQQAppInterface paramBaseQQAppInterface, int paramInt, String paramString2) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a)) {
      return;
    }
    try
    {
      Thread.sleep(500L);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.b.getCurrentAccountUin());
    ((StringBuilder)localObject1).append("BatProcessTips");
    localObject1 = ((StringBuilder)localObject1).toString();
    SharedPreferences localSharedPreferences = this.b.getApplication().getSharedPreferences((String)localObject1, 0);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append("_LastShowTime");
    String str = ((StringBuilder)localObject1).toString();
    long l1 = localSharedPreferences.getLong(str, 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < 86400000L)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("lastShowTime[");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append("],today has notify user!return!");
        QLog.i("updateBatProcessTips<FileAssistant>", 4, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject2 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getMsgList(this.b, this.a, this.c);
    if ((localObject2 != null) && (((List)localObject2).size() != 0))
    {
      localObject1 = this.b.getCurrentAccountUin();
      int i = ((List)localObject2).size() - 1;
      label468:
      label472:
      int k;
      for (int j = 1; i >= 0; j = k)
      {
        Object localObject3 = (MessageRecord)((List)localObject2).get(i);
        if ((((MessageRecord)localObject3).msgtype != -2005) || (((MessageRecord)localObject3).isSend())) {
          break;
        }
        if (((MessageRecord)localObject3).senderuin.equalsIgnoreCase((String)localObject1) == true) {
          return;
        }
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateBatProcessTips count[");
          localStringBuilder.append(j);
          localStringBuilder.append("]");
          QLog.d("FileManagerUtil<FileAssistant>", 4, localStringBuilder.toString());
        }
        if (j >= 4)
        {
          localObject1 = (MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1);
          i = QQFileManagerUtilImpl.a(this.b, (MessageForFile)localObject1).nFileType;
          if (i != 0)
          {
            if (i != 9)
            {
              if (i == 2) {
                break label468;
              }
              if ((i != 3) && (i != 6) && (i != 7))
              {
                localObject1 = "3";
                break label472;
              }
            }
            localObject1 = "1";
            break label472;
          }
          localObject1 = "0";
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("bat_process_tips_last_file_type", localObject1);
          ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).insertAIOGrayTips(this.b, this.a, this.d, this.c, -3013, (Map)localObject2, BaseApplication.getContext().getString(2131889573), -1L, -1L, -1L);
          localSharedPreferences.edit().putLong(str, l2);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("lastShowTime[");
            ((StringBuilder)localObject1).append(l1);
            ((StringBuilder)localObject1).append("],[");
            ((StringBuilder)localObject1).append(QQFileManagerUtilImpl.t(this.a));
            ((StringBuilder)localObject1).append("]add new grayTips!");
            QLog.i("updateBatProcessTips<FileAssistant>", 4, ((StringBuilder)localObject1).toString());
          }
          FileManagerReporter.a("0X800506B");
          return;
        }
        long l3 = ((MessageRecord)localObject3).time * 1000L;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("lastShowTime[");
          ((StringBuilder)localObject3).append(l1);
          ((StringBuilder)localObject3).append("],time[");
          ((StringBuilder)localObject3).append(l3);
          ((StringBuilder)localObject3).append("]");
          QLog.i("updateBatProcessTips<FileAssistant>", 4, ((StringBuilder)localObject3).toString());
        }
        k = j;
        if (l3 > l1) {
          k = j + 1;
        }
        i -= 1;
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("lastShowTime[");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append("],msgRecd null,return");
      QLog.i("updateBatProcessTips<FileAssistant>", 4, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.16
 * JD-Core Version:    0.7.0.1
 */