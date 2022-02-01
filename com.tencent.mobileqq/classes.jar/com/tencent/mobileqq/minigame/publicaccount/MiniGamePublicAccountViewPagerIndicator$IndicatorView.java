package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import java.lang.reflect.Array;

class MiniGamePublicAccountViewPagerIndicator$IndicatorView
  extends View
{
  private static final int HEIGHT = ViewUtils.b(2.0F);
  private static final int SPACE = ViewUtils.b(2.5F);
  private MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig mConfig;
  
  public MiniGamePublicAccountViewPagerIndicator$IndicatorView(Context paramContext, MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig paramIndicatorViewConfig)
  {
    super(paramContext);
    this.mConfig = paramIndicatorViewConfig;
    init(paramContext);
  }
  
  private int getCurrentColor(float paramFloat)
  {
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, 3 });
    arrayOfInt[0][0] = ((this.mConfig.selectedColor & 0xFF0000) >> 16);
    arrayOfInt[0][1] = ((this.mConfig.selectedColor & 0xFF00) >> 8);
    arrayOfInt[0][2] = (this.mConfig.selectedColor & 0xFF);
    arrayOfInt[1][0] = ((this.mConfig.normalColor & 0xFF0000) >> 16);
    arrayOfInt[1][1] = ((this.mConfig.normalColor & 0xFF00) >> 8);
    arrayOfInt[1][2] = (this.mConfig.normalColor & 0xFF);
    int[] arrayOfInt1 = new int[3];
    int i = 0;
    while (i < 3)
    {
      arrayOfInt1[i] = ((int)(arrayOfInt[0][i] + (arrayOfInt[1][i] - arrayOfInt[0][i]) * paramFloat));
      i += 1;
    }
    return Color.rgb(arrayOfInt1[0], arrayOfInt1[1], arrayOfInt1[2]);
  }
  
  private void init(Context paramContext)
  {
    paramContext = new LinearLayout.LayoutParams(this.mConfig.normalWidth, HEIGHT);
    paramContext.gravity = 17;
    paramContext.leftMargin = SPACE;
    paramContext.rightMargin = SPACE;
    setLayoutParams(paramContext);
    setClickable(false);
    setFocusable(false);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = this.mConfig.selectedColor;
      setBackgroundColor(i);
      localLayoutParams = getLayoutParams();
      if (!paramBoolean) {
        break label56;
      }
    }
    label56:
    for (int i = this.mConfig.selectedWidth;; i = this.mConfig.normalWidth)
    {
      localLayoutParams.width = i;
      setLayoutParams(localLayoutParams);
      return;
      i = this.mConfig.normalColor;
      break;
    }
  }
  
  public void update(float paramFloat)
  {
    setBackgroundColor(getCurrentColor(paramFloat));
    int i = (int)(this.mConfig.selectedWidth + (this.mConfig.normalWidth - this.mConfig.selectedWidth) * paramFloat);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = i;
    setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountViewPagerIndicator.IndicatorView
 * JD-Core Version:    0.7.0.1
 */