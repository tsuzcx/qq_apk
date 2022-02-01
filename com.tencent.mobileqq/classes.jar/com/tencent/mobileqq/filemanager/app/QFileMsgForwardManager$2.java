package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.msgforward.QFileMsgForwardRequest;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class QFileMsgForwardManager$2
  implements Runnable
{
  QFileMsgForwardManager$2(QFileMsgForwardManager paramQFileMsgForwardManager, String paramString) {}
  
  public void run()
  {
    QFileMsgForwardManager.QFileUploadRequest localQFileUploadRequest;
    if (QFileMsgForwardManager.b(this.this$0).containsKey(this.a)) {
      localQFileUploadRequest = (QFileMsgForwardManager.QFileUploadRequest)QFileMsgForwardManager.b(this.this$0).remove(this.a);
    } else {
      localQFileUploadRequest = null;
    }
    if (localQFileUploadRequest == null) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = localQFileUploadRequest.i.keySet().iterator();
    for (;;)
    {
      boolean bool = ((Iterator)localObject).hasNext();
      int i = 0;
      if (!bool) {
        break;
      }
      String str = (String)((Iterator)localObject).next();
      ArrayList localArrayList3 = (ArrayList)localQFileUploadRequest.i.get(str);
      while (i < localArrayList3.size())
      {
        MessageRecord localMessageRecord = (MessageRecord)localArrayList3.get(i);
        if (FileManagerUtil.a(localMessageRecord)) {
          if (String.valueOf(2).equalsIgnoreCase(localMessageRecord.getExtInfoFromExtStr("_m_ForwardFileStatus")))
          {
            localQFileUploadRequest.b.a(str, localArrayList3, localMessageRecord, i);
            localArrayList2.add(localMessageRecord);
          }
          else
          {
            localArrayList1.add(localMessageRecord);
          }
        }
        i += 1;
      }
    }
    if (localQFileUploadRequest.g.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeForwardRequest : remove upload request forwardSeq = [");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("] resultCode[1]");
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      localQFileUploadRequest.b.a(1, localArrayList1, localArrayList2);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeForwardRequest : remove upload request forwardSeq = [");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("] resultCode[0]");
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    localQFileUploadRequest.b.a(0, localArrayList1, localArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.2
 * JD-Core Version:    0.7.0.1
 */