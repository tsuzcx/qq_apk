package com.tencent.mobileqq.gallery.picocr;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

class PicOcrManager$2
  implements UpCallBack
{
  PicOcrManager$2(PicOcrManager paramPicOcrManager, PicOcrObserver paramPicOcrObserver, PicOcrManager.OCRReqContext paramOCRReqContext) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    HashMap localHashMap;
    if (paramSendResult != null)
    {
      int i = paramSendResult.a;
      if (QLog.isColorLevel()) {
        QLog.d("PicOcrManager", 2, "upCallBack res:" + i);
      }
      if ((-1 == i) && (this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver != null)) {
        this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver.onUpdate(100, false, new PicOcrRspResult());
      }
      if ((-1 == i) || (i == 0))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.d.equals(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.e)) {
          ThreadManager.excute(new PicOcrManager.2.1(this), 64, null, true);
        }
        localHashMap = new HashMap();
        if (i != 0) {
          break label170;
        }
      }
    }
    label170:
    for (paramSendResult = "0";; paramSendResult = "1")
    {
      localHashMap.put("param_upload", paramSendResult);
      localHashMap.put("param_md5", this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.d);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actUploadProcessState", true, 0L, 0L, localHashMap, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.2
 * JD-Core Version:    0.7.0.1
 */