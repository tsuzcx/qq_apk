package com.tencent.mobileqq.gallery.picocr;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class PicOcrManager$3
  implements Runnable
{
  PicOcrManager$3(PicOcrManager paramPicOcrManager, PicOcrManager.OCRReqContext paramOCRReqContext, PicOcrObserver paramPicOcrObserver) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.d)) || (this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.a))
    {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.d = PicOrcUtils.a(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.b);
      this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.a = false;
    }
    if (!PicOcrManager.a(this.this$0).isEmpty())
    {
      PicOcrRspResult localPicOcrRspResult = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.d);
      if (localPicOcrRspResult != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicOcrManager", 2, "requestOcr cacheRsp:" + localPicOcrRspResult.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver.a(localPicOcrRspResult);
        return;
      }
    }
    PicOcrManager.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver, this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext);
    if (this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.a())
    {
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver, this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext);
      this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver.onUpdate(100, false, new PicOcrRspResult());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.3
 * JD-Core Version:    0.7.0.1
 */