package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;

class OcrCamera$8
  implements Runnable
{
  OcrCamera$8(OcrCamera paramOcrCamera, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((OcrCamera)localObject).h = false;
    ((OcrCamera)localObject).i = true;
    if (((OcrCamera)localObject).c != null) {
      this.this$0.c.a();
    }
    if (this.a) {
      localObject = ((IOCR)QRoute.api(IOCR.class)).savePreviewImage(this.b, OcrCamera.d(this.this$0), OcrCamera.e(this.this$0), OcrCamera.f(this.this$0), this.this$0.e, this.this$0.f, this.this$0.r, true);
    } else {
      localObject = ((IOCR)QRoute.api(IOCR.class)).savePreviewImage(this.b, OcrCamera.g(this.this$0), OcrCamera.h(this.this$0), OcrCamera.f(this.this$0), this.this$0.e, this.this$0.f);
    }
    if (this.this$0.c != null) {
      this.this$0.c.a((String)localObject);
    }
    OcrCamera.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.8
 * JD-Core Version:    0.7.0.1
 */