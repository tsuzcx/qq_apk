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
  int jdField_a_of_type_Int;
  QFileMsgForwardRequest jdField_a_of_type_ComTencentMobileqqFilemanagerDataMsgforwardQFileMsgForwardRequest;
  String jdField_a_of_type_JavaLangString;
  HashMap<String, ArrayList<MessageRecord>> jdField_a_of_type_JavaUtilHashMap;
  List<QFileMsgForwardManager.FileUploadTask> jdField_a_of_type_JavaUtilList;
  List<QFileMsgForwardManager.FileUploadTask> b;
  List<QFileMsgForwardManager.FileUploadTask> c;
  List<QFileMsgForwardManager.FileUploadTask> d;
  List<QFileMsgForwardManager.FileUploadTask> e;
  
  QFileMsgForwardManager$QFileUploadRequest(String paramString, QFileMsgForwardRequest paramQFileMsgForwardRequest, HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    this.jdField_a_of_type_JavaLangString = paramQFileMsgForwardRequest;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataMsgforwardQFileMsgForwardRequest = paramHashMap;
    this.jdField_a_of_type_Int = 0;
    Object localObject;
    this.jdField_a_of_type_JavaUtilHashMap = localObject;
    this.b = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
    this.d = new ArrayList();
    this.e = new ArrayList();
  }
  
  int a()
  {
    return this.b.size();
  }
  
  void a()
  {
    c();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QFileMsgForwardManager.FileUploadTask)localIterator.next()).a();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  void a(QFileMsgForwardManager.FileUploadTask paramFileUploadTask)
  {
    if (paramFileUploadTask != null) {
      this.b.add(paramFileUploadTask);
    }
  }
  
  void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((QFileMsgForwardManager.FileUploadTask)localIterator.next()).b();
    }
    this.jdField_a_of_type_Int = 5;
  }
  
  void c()
  {
    if (10 <= this.b.size()) {}
    ArrayList localArrayList;
    for (int i = 10;; i = this.b.size())
    {
      localArrayList = new ArrayList(i);
      int j = 0;
      while (j < i)
      {
        QFileMsgForwardManager.FileUploadTask localFileUploadTask = (QFileMsgForwardManager.FileUploadTask)this.b.get(j);
        this.jdField_a_of_type_JavaUtilList.add(localFileUploadTask);
        localArrayList.add(localFileUploadTask);
        j += 1;
      }
    }
    this.b.removeAll(localArrayList);
  }
  
  void d()
  {
    int j = this.c.size();
    int k = this.e.size();
    int m = this.d.size();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    QFileMsgForwardManager.FileUploadTask localFileUploadTask;
    if (localIterator.hasNext())
    {
      localFileUploadTask = (QFileMsgForwardManager.FileUploadTask)localIterator.next();
      if ((localFileUploadTask.b == 2) || (localFileUploadTask.b == 3) || (localFileUploadTask.b == 4)) {
        localIterator.remove();
      }
      if (localFileUploadTask.b == 2)
      {
        this.c.add(localFileUploadTask);
        i += 1;
      }
    }
    for (;;)
    {
      break;
      if (localFileUploadTask.b == 3)
      {
        this.e.add(localFileUploadTask);
        i += 1;
      }
      else if (localFileUploadTask.b == 4)
      {
        this.d.add(localFileUploadTask);
        i += 1;
        continue;
        c();
        if (QLog.isColorLevel())
        {
          int n = this.jdField_a_of_type_JavaUtilList.size();
          int i1 = this.b.size();
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "request update, forwardSeq[ " + this.jdField_a_of_type_JavaLangString + "] removeCount[" + i + "] leftCount[" + (n + i1) + "] finishCount[" + (m + (j + k)) + "]");
        }
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((QFileMsgForwardManager.FileUploadTask)localIterator.next()).a();
        }
        if ((this.jdField_a_of_type_JavaUtilList.size() <= 0) && (this.b.size() <= 0))
        {
          this.jdField_a_of_type_Int = 5;
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "all task upload finish , remove multi request: forwardSeq[ " + this.jdField_a_of_type_JavaLangString + "]");
          }
          QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager, this.jdField_a_of_type_JavaLangString);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.QFileUploadRequest
 * JD-Core Version:    0.7.0.1
 */