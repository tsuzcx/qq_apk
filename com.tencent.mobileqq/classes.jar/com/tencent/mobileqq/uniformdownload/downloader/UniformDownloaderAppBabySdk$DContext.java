package com.tencent.mobileqq.uniformdownload.downloader;

import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderAppBabyListener;
import com.tencent.qphone.base.util.QLog;

class UniformDownloaderAppBabySdk$DContext
{
  int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  IUniformDownloaderAppBabyListener jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener;
  Object jdField_a_of_type_JavaLangObject = new Object();
  final String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  Object jdField_b_of_type_JavaLangObject = new Object();
  long jdField_c_of_type_Long;
  Object jdField_c_of_type_JavaLangObject = new Object();
  
  UniformDownloaderAppBabySdk$DContext(UniformDownloaderAppBabySdk paramUniformDownloaderAppBabySdk, long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Int = -1;
  }
  
  long a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      long l = this.jdField_c_of_type_Long;
      return l;
    }
  }
  
  void a(int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      String str = UniformDownloaderAppBabySdk.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] setStatus:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" -> ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("url:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.i(str, 1, localStringBuilder.toString());
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
  }
  
  void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Long = paramLong;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk.DContext
 * JD-Core Version:    0.7.0.1
 */