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
    int j = this.b.size();
    int i = 10;
    if (10 > j) {
      i = this.b.size();
    }
    ArrayList localArrayList = new ArrayList(i);
    j = 0;
    while (j < i)
    {
      QFileMsgForwardManager.FileUploadTask localFileUploadTask = (QFileMsgForwardManager.FileUploadTask)this.b.get(j);
      this.jdField_a_of_type_JavaUtilList.add(localFileUploadTask);
      localArrayList.add(localFileUploadTask);
      j += 1;
    }
    this.b.removeAll(localArrayList);
  }
  
  void d()
  {
    int j = this.c.size();
    int k = this.e.size();
    int m = this.d.size();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      QFileMsgForwardManager.FileUploadTask localFileUploadTask = (QFileMsgForwardManager.FileUploadTask)((Iterator)localObject).next();
      if ((localFileUploadTask.b == 2) || (localFileUploadTask.b == 3) || (localFileUploadTask.b == 4)) {
        ((Iterator)localObject).remove();
      }
      if (localFileUploadTask.b == 2) {
        this.c.add(localFileUploadTask);
      }
      for (;;)
      {
        i += 1;
        break;
        if (localFileUploadTask.b == 3)
        {
          this.e.add(localFileUploadTask);
        }
        else
        {
          if (localFileUploadTask.b != 4) {
            break;
          }
          this.d.add(localFileUploadTask);
        }
      }
    }
    c();
    if (QLog.isColorLevel())
    {
      int n = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = this.b.size();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("request update, forwardSeq[ ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] removeCount[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("] leftCount[");
      ((StringBuilder)localObject).append(n + i1);
      ((StringBuilder)localObject).append("] finishCount[");
      ((StringBuilder)localObject).append(j + k + m);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QFileMsgForwardManager.FileUploadTask)((Iterator)localObject).next()).a();
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() <= 0) && (this.b.size() <= 0))
    {
      this.jdField_a_of_type_Int = 5;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("all task upload finish , remove multi request: forwardSeq[ ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("]");
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.QFileUploadRequest
 * JD-Core Version:    0.7.0.1
 */