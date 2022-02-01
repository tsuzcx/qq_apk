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
    if (paramThumbTask == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramThumbTask.jdField_a_of_type_JavaLangString, paramThumbTask);
    if (QLog.isColorLevel())
    {
      paramThumbTask = new StringBuilder();
      paramThumbTask.append("addDownloadingTask : MapDowloadingTask currentSize[");
      paramThumbTask.append(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      paramThumbTask.append("]");
      QLog.i("ThumbDownloadManager", 2, paramThumbTask.toString());
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ThumbDownloadManager.2(this, paramString));
  }
  
  private boolean a(long paramLong, String paramString1, String paramString2)
  {
    paramString2 = FileManagerUtil.g(paramString2);
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
    if (this.b.contains(paramString2)) {
      return false;
    }
    return !FileUtil.a(paramString1);
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
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("removeDownloadingTask : MapDowloadingTask currentSize[");
      paramString.append(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      paramString.append("]");
      QLog.i("ThumbDownloadManager", 2, paramString.toString());
    }
  }
  
  private void c(String paramString)
  {
    if (!this.b.remove(paramString))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeDownloadingList : ListDownloadTask remove task fail, thumbUrl[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("ThumbDownloadManager", 2, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("removeDownloadingList : ListDownloadTask currentSize[");
      paramString.append(this.b.size());
      paramString.append("]");
      QLog.i("ThumbDownloadManager", 2, paramString.toString());
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ThumbDownloadManager.1(this, paramLong, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.ThumbDownloadManager
 * JD-Core Version:    0.7.0.1
 */