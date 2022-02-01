package com.tencent.mobileqq.extendfriend;

import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginDownloader.OnPluginDownLoadListener;

class ExtendFriendManager$5
  implements PluginDownloader.OnPluginDownLoadListener
{
  int jdField_a_of_type_Int = 0;
  
  ExtendFriendManager$5(ExtendFriendManager paramExtendFriendManager) {}
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExtendFriendManager", 4, "preDownloadExpandPlugin: onDownloadProgress " + paramString + " " + paramInt1 + " / " + paramInt2);
    }
    while ((!QLog.isColorLevel()) || ((paramInt1 * 100 / paramInt2 <= this.jdField_a_of_type_Int + 10) && (paramInt1 != paramInt2))) {
      return;
    }
    this.jdField_a_of_type_Int = Math.min(100, paramInt1 * 100 / paramInt2 / 10 + 10);
    QLog.d("ExtendFriendManager", 4, "preDownloadExpandPlugin: onDownloadProgress " + paramString + " " + paramInt1 + " / " + paramInt2);
  }
  
  public void a(String paramString)
  {
    QLog.e("ExtendFriendManager", 1, "preDownloadExpandPlugin: onDownloadCheckInvalid " + paramString);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "preDownloadExpandPlugin: recordPluginStartupTime " + paramString1 + " " + paramString2 + " " + paramLong);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "preDownloadExpandPlugin: onDownloadFinish " + paramString);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "preDownloadExpandPlugin: onDownloadBegin " + paramString);
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "preDownloadExpandPlugin: onDownloadCancel " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.5
 * JD-Core Version:    0.7.0.1
 */