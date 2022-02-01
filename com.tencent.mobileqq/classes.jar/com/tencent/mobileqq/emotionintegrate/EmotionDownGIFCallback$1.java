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
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((DownCallBack.DownResult)localObject1).jdField_b_of_type_JavaLangString != null))
    {
      localObject1 = new PicResult();
      ((PicResult)localObject1).jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      Object localObject2 = this.a;
      ((PicResult)localObject1).jdField_a_of_type_JavaLangObject = localObject2;
      ((PicResult)localObject1).jdField_a_of_type_Boolean = ((DownCallBack.DownResult)localObject2).jdField_a_of_type_Boolean;
      if (this.a.jdField_a_of_type_Int != 0)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo == null)
        {
          localObject2 = new PicInfoInterface.ErrInfo();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a.jdField_b_of_type_Int);
          localStringBuilder.append("_");
          localStringBuilder.append(this.a.jdField_a_of_type_JavaLangString);
          ((PicInfoInterface.ErrInfo)localObject2).jdField_b_of_type_JavaLangString = localStringBuilder.toString();
          ((PicInfoInterface.ErrInfo)localObject2).jdField_a_of_type_JavaLangString = "onDownload";
          this.a.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = ((PicInfoInterface.ErrInfo)localObject2);
        }
        ((PicResult)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = this.a.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
      }
      this.this$0.a(this.a.jdField_a_of_type_Int, (PicResult)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback.1
 * JD-Core Version:    0.7.0.1
 */