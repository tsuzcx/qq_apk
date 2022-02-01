package com.tencent.mobileqq.shortvideo.camera2;

import android.util.Size;
import java.util.Comparator;

class Camera2Control$CompareSizesByArea
  implements Comparator<Size>
{
  public int a(Size paramSize1, Size paramSize2)
  {
    return Long.signum(paramSize1.getWidth() * paramSize1.getHeight() - paramSize2.getWidth() * paramSize2.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control.CompareSizesByArea
 * JD-Core Version:    0.7.0.1
 */