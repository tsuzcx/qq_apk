package com.tencent.mobileqq.uniformdownload.util;

final class UniformDownloadUtil$1
  implements Runnable
{
  UniformDownloadUtil$1(String paramString, IGetFileInfoCallBack paramIGetFileInfoCallBack) {}
  
  public void run()
  {
    UniformDownloadUtil.FileInfo localFileInfo = UniformDownloadUtil.a(this.jdField_a_of_type_JavaLangString);
    IGetFileInfoCallBack localIGetFileInfoCallBack = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIGetFileInfoCallBack;
    if ((localIGetFileInfoCallBack != null) && (localFileInfo != null)) {
      localIGetFileInfoCallBack.a(localFileInfo.jdField_a_of_type_JavaLangString, localFileInfo.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.1
 * JD-Core Version:    0.7.0.1
 */