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
    if ((TextUtils.isEmpty(this.a.f)) || (this.a.h))
    {
      localObject = this.a;
      ((OCRReqContext)localObject).f = PicOrcUtils.a(((OCRReqContext)localObject).c);
      this.a.h = false;
    }
    if (!PicOcrServiceImpl.access$200(this.this$0).isEmpty())
    {
      localObject = this.this$0.getCacheOcrResult(this.a.f);
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("requestOcr cacheRsp:");
          localStringBuilder.append(((PicOcrRspResult)localObject).toString());
          QLog.e("PicOcrServiceImpl", 2, localStringBuilder.toString());
        }
        this.b.a((PicOcrRspResult)localObject);
        return;
      }
    }
    PicOcrServiceImpl.access$300(this.this$0, this.b, this.a);
    if (this.a.a())
    {
      this.this$0.uploadOcrPic(this.b, this.a);
      this.b.a();
      return;
    }
    this.b.onUpdate(100, false, new PicOcrRspResult());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.PicOcrServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */