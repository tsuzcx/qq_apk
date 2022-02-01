package com.tencent.mobileqq.ocr;

import android.content.Context;
import android.view.OrientationEventListener;

class OcrCamera$1
  extends OrientationEventListener
{
  OcrCamera$1(OcrCamera paramOcrCamera, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {
      this.a.b = 0;
    }
    do
    {
      return;
      this.a.b = ((paramInt + 45) / 90 * 90);
    } while (this.a.b >= 0);
    this.a.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.1
 * JD-Core Version:    0.7.0.1
 */