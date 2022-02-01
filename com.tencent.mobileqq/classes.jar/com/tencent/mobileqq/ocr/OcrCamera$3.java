package com.tencent.mobileqq.ocr;

import android.hardware.Camera.Size;
import java.util.Comparator;

class OcrCamera$3
  implements Comparator<Camera.Size>
{
  OcrCamera$3(OcrCamera paramOcrCamera) {}
  
  public int a(Camera.Size paramSize1, Camera.Size paramSize2)
  {
    int i = paramSize1.height * paramSize1.width;
    int j = paramSize2.height * paramSize2.width;
    if (j < i) {
      return 1;
    }
    if (j > i) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.3
 * JD-Core Version:    0.7.0.1
 */