package com.tencent.mobileqq.uniformdownload.core;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr;
import com.tencent.mobileqq.uniformdownload.data.UDFileInfo;
import com.tencent.qphone.base.util.QLog;

class UniformDownloadMgr$5
  implements Runnable
{
  UniformDownloadMgr$5(UniformDownloadMgr paramUniformDownloadMgr, Bundle paramBundle, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", UDFileInfo.a(this.jdField_a_of_type_JavaLangString, 4));
    QLog.d("UniformDownloadMgr_Impl", 1, "【UniformDL-startDownloadNoSzie】 fileSize: " + this.jdField_a_of_type_AndroidOsBundle.getLong("_filesize_from_dlg", 0L));
    this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    UniformDownloadMgr.a(this.this$0).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.5
 * JD-Core Version:    0.7.0.1
 */