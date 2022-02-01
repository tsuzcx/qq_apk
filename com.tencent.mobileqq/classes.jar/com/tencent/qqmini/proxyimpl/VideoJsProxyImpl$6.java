package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class VideoJsProxyImpl$6
  implements FFmpegExecuteResponseCallback
{
  VideoJsProxyImpl$6(VideoJsProxyImpl paramVideoJsProxyImpl, long paramLong1, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt, String paramString2, long paramLong2) {}
  
  public void onFailure(String paramString)
  {
    paramString = paramString.split("\n");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFailure: ");
      localStringBuilder.append(str);
      QLog.w("VideoJsPlugin", 1, localStringBuilder.toString());
      i += 1;
    }
    if (this.jdField_a_of_type_JavaLangString.contains("-vf"))
    {
      VideoJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplVideoJsProxyImpl, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, false);
      return;
    }
    paramString = ((IMiniAppFileManager)VideoJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplVideoJsProxyImpl).getManager(IMiniAppFileManager.class)).getWxFilePath(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
    VideoJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplVideoJsProxyImpl, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.fileSize, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("compress finish ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.d("VideoJsPlugin", 2, localStringBuilder.toString());
    }
  }
  
  public void onProgress(String paramString)
  {
    if (paramString.length() >= 90)
    {
      if (paramString.length() > 150) {
        return;
      }
      paramString = new Scanner(paramString).findWithinHorizon(VideoJsProxyImpl.a(), 0);
      if (paramString != null)
      {
        paramString = paramString.split(":");
        if (paramString.length <= 2) {}
      }
    }
    try
    {
      int i = Integer.parseInt(paramString[0]);
      int j = Integer.parseInt(paramString[1]);
      double d = Double.parseDouble(paramString[2]);
      i = (int)((float)(TimeUnit.HOURS.toMillis(i) + TimeUnit.MINUTES.toMillis(j) + (d * 1000.0D)) * 100.0F / (float)this.jdField_b_of_type_Long);
      if (i < 100)
      {
        paramString = this.jdField_a_of_type_ComTencentQqminiProxyimplVideoJsProxyImpl;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131716051));
        localStringBuilder.append(i);
        localStringBuilder.append("%");
        VideoJsProxyImpl.a(paramString, localStringBuilder.toString());
      }
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "compress start");
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("compress success ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("VideoJsPlugin", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_JavaLangString.contains("-vf"))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      paramString.mediaWidth /= this.jdField_a_of_type_Int;
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      paramString.mediaHeight /= this.jdField_a_of_type_Int;
    }
    paramString = ((IMiniAppFileManager)VideoJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplVideoJsProxyImpl).getManager(IMiniAppFileManager.class)).getWxFilePath(this.jdField_b_of_type_JavaLangString);
    VideoJsProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplVideoJsProxyImpl, paramString, new File(this.jdField_b_of_type_JavaLangString).length(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */