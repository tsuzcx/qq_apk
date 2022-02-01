package com.tencent.mobileqq.uniformdownload.data;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader;
import com.tencent.qphone.base.util.QLog;

public class DownloadInstContextMgr$DownloadInstContext
{
  public final int a;
  final long jdField_a_of_type_Long;
  final Bundle jdField_a_of_type_AndroidOsBundle;
  public UniformDownloader a;
  public String a;
  public final int b;
  
  public DownloadInstContextMgr$DownloadInstContext(Bundle paramBundle, int paramInt1, UniformDownloader paramUniformDownloader, long paramLong, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloader = paramUniformDownloader;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramUniformDownloader.a();
    this.b = paramInt2;
    QLog.i("DownloadInstContextMgr", 1, "[UniformDL] new DownloadInst.[ mUDID:[" + this.jdField_a_of_type_Long + "] url:" + this.jdField_a_of_type_JavaLangString + " ]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr.DownloadInstContext
 * JD-Core Version:    0.7.0.1
 */