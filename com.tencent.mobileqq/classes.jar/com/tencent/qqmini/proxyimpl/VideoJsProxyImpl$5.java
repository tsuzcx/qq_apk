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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("start copy from ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
    QZLog.i("VideoJsPlugin", 1, ((StringBuilder)localObject1).toString());
    localObject1 = ((IMiniAppFileManager)VideoJsProxyImpl.a(this.this$0).getManager(IMiniAppFileManager.class)).getTmpPath(this.jdField_a_of_type_JavaLangString);
    if (((String)localObject1).contains(" "))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("wrong copy path ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.w("VideoJsPlugin", 1, ((StringBuilder)localObject2).toString());
      localObject1 = ((IMiniAppFileManager)VideoJsProxyImpl.a(this.this$0).getManager(IMiniAppFileManager.class)).getWxFilePath(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
      VideoJsProxyImpl.a(this.this$0, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.fileSize, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      return;
    }
    Object localObject2 = new File((String)localObject1);
    if (((File)localObject2).exists()) {
      ((File)localObject2).delete();
    }
    if (FileUtils.copyFile(new File(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path), (File)localObject2))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      ((LocalMediaInfo)localObject2).path = ((String)localObject1);
      VideoJsProxyImpl.a(this.this$0, (LocalMediaInfo)localObject2, this.jdField_a_of_type_Boolean);
      return;
    }
    QLog.w("VideoJsPlugin", 1, "copy file failed");
    localObject1 = ((IMiniAppFileManager)VideoJsProxyImpl.a(this.this$0).getManager(IMiniAppFileManager.class)).getWxFilePath(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
    VideoJsProxyImpl.a(this.this$0, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.fileSize, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */