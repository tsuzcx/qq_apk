package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.qphone.base.util.QLog;

class EmotionDownGIFCallback$1
  implements Runnable
{
  EmotionDownGIFCallback$1(EmotionDownGIFCallback paramEmotionDownGIFCallback, DownCallBack.DownResult paramDownResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionDownGIFCallback", 1, "onDownload");
    }
    if ((this.a != null) && (this.a.jdField_b_of_type_JavaLangString != null))
    {
      PicResult localPicResult = new PicResult();
      localPicResult.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localPicResult.jdField_a_of_type_JavaLangObject = this.a;
      localPicResult.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_Boolean;
      if (this.a.jdField_a_of_type_Int != 0)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo == null)
        {
          PicInfoInterface.ErrInfo localErrInfo = new PicInfoInterface.ErrInfo();
          localErrInfo.jdField_b_of_type_JavaLangString = (this.a.jdField_b_of_type_Int + "_" + this.a.jdField_a_of_type_JavaLangString);
          localErrInfo.jdField_a_of_type_JavaLangString = "onDownload";
          this.a.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = localErrInfo;
        }
        localPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = this.a.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
      }
      this.this$0.a(this.a.jdField_a_of_type_Int, localPicResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */