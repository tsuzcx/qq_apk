package com.tencent.mobileqq.widget.presseffect;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;

public class PressEffectSelectorDrawable
  extends StateListDrawable
{
  public PressEffectSelectorDrawable(int paramInt1, int paramInt2)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(paramInt1);
    addState(new int[] { 16842919 }, localColorDrawable);
    localColorDrawable = new ColorDrawable(paramInt2);
    addState(new int[] { 16842921 }, localColorDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.presseffect.PressEffectSelectorDrawable
 * JD-Core Version:    0.7.0.1
 */