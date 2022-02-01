package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import java.util.Vector;

class ColorNickManager$4
  extends CallBacker
{
  ColorNickManager$4(ColorNickManager paramColorNickManager) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramLong == 27L)
    {
      paramInt2 = Integer.parseInt(paramString1.substring("groupnickitem.".length(), paramString1.length()));
      ColorNickManager.a(this.a).removeElement(Integer.valueOf(paramInt2));
      if (paramInt1 == 0) {
        this.a.a(paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickManager.4
 * JD-Core Version:    0.7.0.1
 */