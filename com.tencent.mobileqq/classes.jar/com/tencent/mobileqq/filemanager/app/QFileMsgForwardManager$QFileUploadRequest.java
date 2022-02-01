package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.msgforward.QFileMsgForwardRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class QFileMsgForwardManager$QFileUploadRequest
{
  String a;
  QFileMsgForwardRequest b;
  int c;
  List<QFileMsgForwardManager.FileUploadTask> d;
  List<QFileMsgForwardManager.FileUploadTask> e;
  List<QFileMsgForwardManager.FileUploadTask> f;
  List<QFileMsgForwardManager.FileUploadTask> g;
  List<QFileMsgForwardManager.FileUploadTask> h;
  HashMap<String, ArrayList<MessageRecord>> i;
  
  QFileMsgForwardManager$QFileUploadRequest(String paramString, QFileMsgForwardRequest paramQFileMsgForwardRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    this.a = paramQFileMsgForwardRequest;
    this.b = paramHashMap;
    this.c = 0;
    Object localObject;
    this.i = localObject;
    this.e = new ArrayList();
    this.d = new ArrayList();
    this.f = new ArrayList();
    this.g = new ArrayList();
    this.h = new ArrayList();
  }
  
  void a()
  {
    c();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((QFileMsgForwardManager.FileUploadTask)localIterator.next()).a();
    }
    this.c = 1;
  }
  
  void a(QFileMsgForwardManager.FileUploadTask paramFileUploadTask)
  {
    if (paramFileUploadTask != null) {
      this.e.add(paramFileUploadTask);
    }
  }
  
  void b()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((QFileMsgForwardManager.FileUploadTask)localIterator.next()).b();
    }
    this.c = 5;
  }
  
  void c()
  {
    int m = this.e.size();
    int k = 10;
    if (10 > m) {
      k = this.e.size();
    }
    ArrayList localArrayList = new ArrayList(k);
    m = 0;
    while (m < k)
    {
      QFileMsgForwardManager.FileUploadTask localFileUploadTask = (QFileMsgForwardManager.FileUploadTask)this.e.get(m);
      this.d.add(localFileUploadTask);
      localArrayList.add(localFileUploadTask);
      m += 1;
    }
    this.e.removeAll(localArrayList);
  }
  
  int d()
  {
    return this.e.size();
  }
  
  void e()
  {
    int m = this.f.size();
    int n = this.h.size();
    int i1 = this.g.size();
    Object localObject = this.d.iterator();
    int k = 0;
    if (((Iterator)localObject).hasNext())
    {
      QFileMsgForwardManager.FileUploadTask localFileUploadTask = (QFileMsgForwardManager.FileUploadTask)((Iterator)localObject).next();
      if ((localFileUploadTask.g == 2) || (localFileUploadTask.g == 3) || (localFileUploadTask.g == 4)) {
        ((Iterator)localObject).remove();
      }
      if (localFileUploadTask.g == 2) {
        this.f.add(localFileUploadTask);
      }
      for (;;)
      {
        k += 1;
        break;
        if (localFileUploadTask.g == 3)
        {
          this.h.add(localFileUploadTask);
        }
        else
        {
          if (localFileUploadTask.g != 4) {
            break;
          }
          this.g.add(localFileUploadTask);
        }
      }
    }
    c();
    if (QLog.isColorLevel())
    {
      int i2 = this.d.size();
      int i3 = this.e.size();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("request update, forwardSeq[ ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("] removeCount[");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append("] leftCount[");
      ((StringBuilder)localObject).append(i2 + i3);
      ((StringBuilder)localObject).append("] finishCount[");
      ((StringBuilder)localObject).append(m + n + i1);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QFileMsgForwardManager.FileUploadTask)((Iterator)localObject).next()).a();
    }
    if ((this.d.size() <= 0) && (this.e.size() <= 0))
    {
      this.c = 5;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("all task upload finish , remove multi request: forwardSeq[ ");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("]");
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      QFileMsgForwardManager.a(this.j, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.QFileUploadRequest
 * JD-Core Version:    0.7.0.1
 */