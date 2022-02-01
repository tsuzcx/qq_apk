package com.tencent.mobileqq.uniformdownload.util;

final class UniformDownloadUtil$2
  implements Runnable
{
  UniformDownloadUtil$2(String paramString, UniformDownloadUtil.GetApkNameCallback paramGetApkNameCallback) {}
  
  public void run()
  {
    String str = UniformDownloadUtil.a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilUniformDownloadUtil$GetApkNameCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilUniformDownloadUtil$GetApkNameCallback.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil.2
 * JD-Core Version:    0.7.0.1
 */