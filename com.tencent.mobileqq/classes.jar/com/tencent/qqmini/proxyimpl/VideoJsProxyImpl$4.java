package com.tencent.qqmini.proxyimpl;

import bkrw;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;

public class VideoJsProxyImpl$4
  implements Runnable
{
  public VideoJsProxyImpl$4(bkrw parambkrw, String paramString, LocalMediaInfo paramLocalMediaInfo, long paramLong, int paramInt) {}
  
  public void run()
  {
    bkrw.a(this.this$0, "正在获取视频封面，请稍后");
    boolean bool = bkrw.a(this.this$0, bkrw.a(this.this$0, this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    QLog.d("VideoJsPlugin", 2, "saveThumbnail : " + bool);
    bkrw.a(this.this$0);
    bkrw.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */