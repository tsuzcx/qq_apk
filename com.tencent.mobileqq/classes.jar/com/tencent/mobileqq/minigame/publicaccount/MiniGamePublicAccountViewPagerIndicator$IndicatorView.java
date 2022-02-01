package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.Nullable;
import bgtn;
import java.lang.reflect.Array;

class MiniGamePublicAccountViewPagerIndicator$IndicatorView
  extends View
{
  private static final int HEIGHT;
  private static final int NORMAL_COLOR = Color.parseColor("#D0D8F2");
  private static final int NORMAL_WIDTH = bgtn.b(14.0F);
  private static final int SELECTED_COLOR = Color.parseColor("#3857FF");
  private static final int SELECTED_WIDTH = bgtn.b(32.0F);
  private static final int SPACE;
  
  static
  {
    HEIGHT = bgtn.b(2.0F);
    SPACE = bgtn.b(2.5F);
  }
  
  public MiniGamePublicAccountViewPagerIndicator$IndicatorView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MiniGamePublicAccountViewPagerIndicator$IndicatorView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MiniGamePublicAccountViewPagerIndicator$IndicatorView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private int getCurrentColor(float paramFloat)
  {
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, 3 });
    arrayOfInt[0][0] = ((SELECTED_COLOR & 0xFF0000) >> 16);
    arrayOfInt[0][1] = ((SELECTED_COLOR & 0xFF00) >> 8);
    arrayOfInt[0][2] = (SELECTED_COLOR & 0xFF);
    arrayOfInt[1][0] = ((NORMAL_COLOR & 0xFF0000) >> 16);
    arrayOfInt[1][1] = ((NORMAL_COLOR & 0xFF00) >> 8);
    arrayOfInt[1][2] = (NORMAL_COLOR & 0xFF);
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
    paramContext = new LinearLayout.LayoutParams(NORMAL_WIDTH, HEIGHT);
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
      i = SELECTED_COLOR;
      setBackgroundColor(i);
      localLayoutParams = getLayoutParams();
      if (!paramBoolean) {
        break label44;
      }
    }
    label44:
    for (int i = SELECTED_WIDTH;; i = NORMAL_WIDTH)
    {
      localLayoutParams.width = i;
      setLayoutParams(localLayoutParams);
      return;
      i = NORMAL_COLOR;
      break;
    }
  }
  
  public void update(float paramFloat)
  {
    setBackgroundColor(getCurrentColor(paramFloat));
    int i = (int)(SELECTED_WIDTH + (NORMAL_WIDTH - SELECTED_WIDTH) * paramFloat);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = i;
    setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountViewPagerIndicator.IndicatorView
 * JD-Core Version:    0.7.0.1
 */