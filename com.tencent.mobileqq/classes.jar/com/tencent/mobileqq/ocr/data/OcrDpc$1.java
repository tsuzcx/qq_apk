package com.tencent.mobileqq.ocr.data;

import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.qphone.base.util.QLog;

final class OcrDpc$1
  implements DPCObserver
{
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean) {
      OcrDpc.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.dpc", 2, "onDpcPullFinished, hasChanged=" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.OcrDpc.1
 * JD-Core Version:    0.7.0.1
 */