package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;
import java.util.Comparator;

class GLLittleBoyManager$4
  implements Comparator<GLLittleBoy>
{
  GLLittleBoyManager$4(GLLittleBoyManager paramGLLittleBoyManager) {}
  
  public int compare(GLLittleBoy paramGLLittleBoy1, GLLittleBoy paramGLLittleBoy2)
  {
    int i = (int)paramGLLittleBoy1.getCurrentDrawRegionSize().centerY();
    paramGLLittleBoy1.mCurrentCenterY = i;
    int j = (int)paramGLLittleBoy2.getCurrentDrawRegionSize().centerY();
    paramGLLittleBoy2.mCurrentCenterY = j;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager.4
 * JD-Core Version:    0.7.0.1
 */