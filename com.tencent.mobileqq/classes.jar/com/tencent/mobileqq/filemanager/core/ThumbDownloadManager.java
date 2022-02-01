package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ThumbDownloadManager
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HttpThumbDownloader.ThumbEventCallback jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback = new ThumbDownloadManager.4(this);
  private LinkedHashMap<String, ThumbDownloadManager.ThumbTask> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<ThumbDownloadManager.ThumbTask> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  public ThumbDownloadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ThumbDownloadManager.3(this));
  }
  
  private void a(ThumbDownloadManager.ThumbTask paramThumbTask)
  {
    if (paramThumbTask == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramThumbTask.jdField_a_of_type_JavaLangString, paramThumbTask);
    } while (!QLog.isColorLevel());
    QLog.i("ThumbDownloadManager", 2, "addDownloadingTask : MapDowloadingTask currentSize[" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + "]");
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ThumbDownloadManager.2(this, paramString));
  }
  
  private boolean a(long paramLong, String paramString1, String paramString2)
  {
    paramString2 = FileManagerUtil.h(paramString2);
    if (!a(paramString1, paramString2)) {
      return false;
    }
    ThumbDownloadManager.ThumbTask localThumbTask = new ThumbDownloadManager.ThumbTask();
    localThumbTask.b = paramString1;
    localThumbTask.jdField_a_of_type_JavaLangString = paramString2;
    localThumbTask.jdField_a_of_type_Long = paramLong;
    this.b.add(paramString2);
    this.jdField_a_of_type_JavaUtilList.add(localThumbTask);
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (this.b.contains(paramString2)) {}
    while (FileUtil.b(paramString1)) {
      return false;
    }
    return true;
  }
  
  private void b(ThumbDownloadManager.ThumbTask paramThumbTask)
  {
    if (paramThumbTask == null) {
      return;
    }
    new HttpThumbDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramThumbTask.jdField_a_of_type_Long, paramThumbTask.b, paramThumbTask.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback);
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("ThumbDownloadManager", 2, "removeDownloadingTask : MapDowloadingTask currentSize[" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + "]");
    }
  }
  
  private void c(String paramString)
  {
    if (!this.b.remove(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.i("ThumbDownloadManager", 2, "removeDownloadingList : ListDownloadTask remove task fail, thumbUrl[" + paramString + "]");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("ThumbDownloadManager", 2, "removeDownloadingList : ListDownloadTask currentSize[" + this.b.size() + "]");
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ThumbDownloadManager.1(this, paramLong, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager
 * JD-Core Version:    0.7.0.1
 */