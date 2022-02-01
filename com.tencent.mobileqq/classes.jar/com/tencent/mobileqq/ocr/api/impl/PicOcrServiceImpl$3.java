package com.tencent.mobileqq.ocr.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.gallery.picocr.PicOrcUtils;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class PicOcrServiceImpl$3
  implements Runnable
{
  PicOcrServiceImpl$3(PicOcrServiceImpl paramPicOcrServiceImpl, OCRReqContext paramOCRReqContext, PicOcrObserver paramPicOcrObserver) {}
  
  public void run()
  {
    Object localObject;
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.d)) || (this.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.a))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext;
      ((OCRReqContext)localObject).d = PicOrcUtils.a(((OCRReqContext)localObject).b);
      this.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.a = false;
    }
    if (!PicOcrServiceImpl.access$200(this.this$0).isEmpty())
    {
      localObject = this.this$0.getCacheOcrResult(this.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.d);
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("requestOcr cacheRsp:");
          localStringBuilder.append(((PicOcrRspResult)localObject).toString());
          QLog.e("PicOcrServiceImpl", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver.a((PicOcrRspResult)localObject);
        return;
      }
    }
    PicOcrServiceImpl.access$300(this.this$0, this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver, this.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.a())
    {
      this.this$0.uploadOcrPic(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver, this.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext);
      this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver.onUpdate(100, false, new PicOcrRspResult());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.PicOcrServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */