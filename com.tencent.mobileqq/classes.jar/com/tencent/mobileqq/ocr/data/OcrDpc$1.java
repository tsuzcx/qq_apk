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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDpcPullFinished, hasChanged=");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.ocr.dpc", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.OcrDpc.1
 * JD-Core Version:    0.7.0.1
 */