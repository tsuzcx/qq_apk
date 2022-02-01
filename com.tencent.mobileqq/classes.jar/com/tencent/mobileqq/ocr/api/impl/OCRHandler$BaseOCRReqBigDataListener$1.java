package com.tencent.mobileqq.ocr.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class OCRHandler$BaseOCRReqBigDataListener$1
  implements Runnable
{
  OCRHandler$BaseOCRReqBigDataListener$1(OCRHandler.BaseOCRReqBigDataListener paramBaseOCRReqBigDataListener, NetResp paramNetResp) {}
  
  public void run()
  {
    Object localObject = this.a;
    int i;
    if ((localObject != null) && (((NetResp)localObject).mResult == 0))
    {
      i = 0;
    }
    else
    {
      if (this.a == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.ocr.OCRHandlerImpl", 2, "BaseOCRReqBigListener.onResp(), resp is null");
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BaseOCRReqBigListener.onResp(), mResult=");
        ((StringBuilder)localObject).append(this.a.mResult);
        ((StringBuilder)localObject).append(",mErrCode=");
        ((StringBuilder)localObject).append(this.a.mErrCode);
        ((StringBuilder)localObject).append(",mHttpCode=");
        ((StringBuilder)localObject).append(this.a.mHttpCode);
        ((StringBuilder)localObject).append(",mErrDesc=");
        ((StringBuilder)localObject).append(this.a.mErrDesc);
        QLog.i("Q.ocr.OCRHandlerImpl", 2, ((StringBuilder)localObject).toString());
      }
      i = -10;
    }
    OCRHandler localOCRHandler = this.b.a;
    Intent localIntent = OCRHandler.BaseOCRReqBigDataListener.a(this.b);
    localObject = this.a;
    if (localObject != null) {
      localObject = ((NetResp)localObject).mRespData;
    } else {
      localObject = null;
    }
    OCRHandler.a(localOCRHandler, i, localIntent, (byte[])localObject, OCRHandler.BaseOCRReqBigDataListener.b(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.OCRHandler.BaseOCRReqBigDataListener.1
 * JD-Core Version:    0.7.0.1
 */