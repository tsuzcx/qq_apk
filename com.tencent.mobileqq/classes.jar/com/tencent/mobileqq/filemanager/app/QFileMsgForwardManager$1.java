package com.tencent.mobileqq.filemanager.app;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.msgforward.QFileMsgForwardRequest;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class QFileMsgForwardManager$1
  implements Runnable
{
  QFileMsgForwardManager$1(QFileMsgForwardManager paramQFileMsgForwardManager, QFileMsgForwardRequest paramQFileMsgForwardRequest) {}
  
  public void run()
  {
    boolean bool1 = NetworkUtil.isNetworkAvailable(null);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isNetworkAvailable:");
      ((StringBuilder)localObject1).append(bool1);
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    }
    String str1 = this.a.a();
    String str2 = this.a.b();
    int i = this.a.a();
    Object localObject2 = this.a.a();
    if ((localObject2 != null) && (!((HashMap)localObject2).isEmpty()))
    {
      QFileMsgForwardManager.QFileUploadRequest localQFileUploadRequest = new QFileMsgForwardManager.QFileUploadRequest(this.this$0, str1, this.a, (HashMap)localObject2);
      Iterator localIterator1 = ((HashMap)localObject2).keySet().iterator();
      long l2 = 0L;
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((HashMap)localObject2).get((String)localIterator1.next())).iterator();
        long l1 = l2;
        localObject1 = localObject2;
        boolean bool2 = bool1;
        for (;;)
        {
          bool1 = bool2;
          localObject2 = localObject1;
          l2 = l1;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject2 = (MessageRecord)localIterator2.next();
          if ((FileManagerUtil.a((MessageRecord)localObject2)) && (QFileMsgForwardManager.a(this.this$0, (MessageRecord)localObject2)))
          {
            QFileMsgForwardManager.FileUploadTask localFileUploadTask = QFileMsgForwardManager.a(this.this$0, str2, i, str1, (MessageRecord)localObject2);
            if (localFileUploadTask != null)
            {
              localQFileUploadRequest.a(localFileUploadTask);
              if (!bool2) {
                localFileUploadTask.a.a("", true);
              }
              localObject2 = ((MessageRecord)localObject2).getExtInfoFromExtStr("_m_ForwardSize");
              l2 = l1;
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                l2 = l1 + Long.valueOf((String)localObject2).longValue();
              }
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("addMultiRequest : createUploadTask failed. forwardMsgSeq[");
              ((StringBuilder)localObject1).append(str1);
              ((StringBuilder)localObject1).append("] toUin[");
              ((StringBuilder)localObject1).append(str2);
              ((StringBuilder)localObject1).append("] toType[");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append("] ");
              QLog.i("FileMultiMsgManager<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
              this.a.a(1, new ArrayList(), new ArrayList());
            }
          }
          else
          {
            l2 = l1;
          }
          l1 = l2;
        }
      }
      if (localQFileUploadRequest.a() > 0)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("addMultiRequest : forwardMsgSeq[");
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append("] toUin[");
          ((StringBuilder)localObject1).append(str2);
          ((StringBuilder)localObject1).append("] toType[");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append("] uploadCount[");
          ((StringBuilder)localObject1).append(localQFileUploadRequest.a());
          ((StringBuilder)localObject1).append("]");
          QLog.i("FileMultiMsgManager<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = new DecimalFormat("0.00");
        double d = l2;
        Double.isNaN(d);
        localObject1 = ((DecimalFormat)localObject1).format(d / 1024.0D / 1024.0D);
        ReportController.b(QFileMsgForwardManager.a(this.this$0), "dc00898", "", "", "0X8009ABE", "0X8009ABE", 0, 0, "", "", (String)localObject1, "");
        QFileMsgForwardManager.a(this.this$0).put(str1, localQFileUploadRequest);
        localQFileUploadRequest.a();
        return;
      }
      this.a.a(0, new ArrayList(), new ArrayList());
      return;
    }
    this.a.a(0, new ArrayList(), new ArrayList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.1
 * JD-Core Version:    0.7.0.1
 */