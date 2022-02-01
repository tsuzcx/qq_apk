package com.tencent.mobileqq.kandian.biz.ugc.upload;

import com.tencent.qphone.base.util.QLog;

class RIJUgcImageUploader$1$1$1
  implements Runnable
{
  RIJUgcImageUploader$1$1$1(RIJUgcImageUploader.1.1 param1, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      QLog.i(RIJUgcImageUploader.jdField_a_of_type_JavaLangString, 1, "uploadImage success");
      RIJUgcImageUploader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadRIJUgcImageUploader$1$1.a.this$0).a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    String str = RIJUgcImageUploader.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uploadImage failed, errCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.i(str, 1, localStringBuilder.toString());
    RIJUgcImageUploader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadRIJUgcImageUploader$1$1.a.this$0).a(this.jdField_a_of_type_Int, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcImageUploader.1.1.1
 * JD-Core Version:    0.7.0.1
 */