package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.mobileqq.kandian.biz.pts.util.ProteusCDNUtils;
import com.tencent.qphone.base.util.QLog;

class StyleLoaderHelper$DummyCallback$1
  implements Runnable
{
  StyleLoaderHelper$DummyCallback$1(StyleLoaderHelper.DummyCallback paramDummyCallback, String paramString, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check style config param: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" code: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d("TemplateFactory", 1, localStringBuilder.toString());
    int i = this.jdField_a_of_type_Int;
    if (i == 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersStyleLoaderHelper$DummyCallback.a(this.jdField_a_of_type_JavaLangString, i);
    }
    ProteusCDNUtils.a(StyleLoaderHelper.DummyCallback.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersStyleLoaderHelper$DummyCallback), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.StyleLoaderHelper.DummyCallback.1
 * JD-Core Version:    0.7.0.1
 */