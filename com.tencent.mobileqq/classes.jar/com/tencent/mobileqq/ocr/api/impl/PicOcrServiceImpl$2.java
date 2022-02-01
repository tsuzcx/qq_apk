package com.tencent.mobileqq.ocr.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class PicOcrServiceImpl$2
  implements UpCallBack
{
  PicOcrServiceImpl$2(PicOcrServiceImpl paramPicOcrServiceImpl, PicOcrObserver paramPicOcrObserver, OCRReqContext paramOCRReqContext) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult != null)
    {
      int i = paramSendResult.a;
      if (QLog.isColorLevel())
      {
        paramSendResult = new StringBuilder();
        paramSendResult.append("upCallBack res:");
        paramSendResult.append(i);
        QLog.d("PicOcrServiceImpl", 2, paramSendResult.toString());
      }
      if (-1 == i)
      {
        paramSendResult = this.a;
        if (paramSendResult != null) {
          paramSendResult.onUpdate(100, false, new PicOcrRspResult());
        }
      }
      if ((-1 == i) || (i == 0))
      {
        if (!this.b.f.equals(this.b.g)) {
          ThreadManager.excute(new PicOcrServiceImpl.2.1(this), 64, null, true);
        }
        HashMap localHashMap = new HashMap();
        if (i == 0) {
          paramSendResult = "0";
        } else {
          paramSendResult = "1";
        }
        localHashMap.put("param_upload", paramSendResult);
        localHashMap.put("param_md5", this.b.f);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actUploadProcessState", true, 0L, 0L, localHashMap, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.PicOcrServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */