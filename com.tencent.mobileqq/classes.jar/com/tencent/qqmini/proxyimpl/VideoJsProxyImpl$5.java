package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;

class VideoJsProxyImpl$5
  implements Runnable
{
  VideoJsProxyImpl$5(VideoJsProxyImpl paramVideoJsProxyImpl, LocalMediaInfo paramLocalMediaInfo, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    QZLog.i("VideoJsPlugin", 1, "start copy from " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
    String str = ((IMiniAppFileManager)VideoJsProxyImpl.a(this.this$0).getManager(IMiniAppFileManager.class)).getTmpPath(this.jdField_a_of_type_JavaLangString);
    if (str.contains(" "))
    {
      QLog.w("VideoJsPlugin", 1, "wrong copy path " + str);
      str = ((IMiniAppFileManager)VideoJsProxyImpl.a(this.this$0).getManager(IMiniAppFileManager.class)).getWxFilePath(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
      VideoJsProxyImpl.a(this.this$0, str, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.fileSize, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      return;
    }
    File localFile = new File(str);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (FileUtils.copyFile(new File(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path), localFile))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = str;
      VideoJsProxyImpl.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, this.jdField_a_of_type_Boolean);
      return;
    }
    QLog.w("VideoJsPlugin", 1, "copy file failed");
    str = ((IMiniAppFileManager)VideoJsProxyImpl.a(this.this$0).getManager(IMiniAppFileManager.class)).getWxFilePath(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
    VideoJsProxyImpl.a(this.this$0, str, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.fileSize, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */