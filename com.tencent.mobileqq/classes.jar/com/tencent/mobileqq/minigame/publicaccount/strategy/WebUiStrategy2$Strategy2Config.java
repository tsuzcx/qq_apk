package com.tencent.mobileqq.minigame.publicaccount.strategy;

import android.content.Context;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;

public final class WebUiStrategy2$Strategy2Config
{
  public static final float ITEM_HEIGHT_WIDTH_RATE = 0.911F;
  public static final int ITEM_MARGIN_LEFT = 15;
  private static final String TAG = "Strategy2Config";
  public static final int VIEWPAGER_PADDING_RIGHT = 30;
  public static int arkViewWidth;
  public static int viewPagerItemHeight;
  public static int viewPagerItemMarginLeft;
  public static float viewPagerWidth;
  
  public static void init(Context paramContext)
  {
    int i = DisplayUtil.a(paramContext).a;
    int j = DisplayUtil.a(paramContext, 30.0F);
    viewPagerItemMarginLeft = DisplayUtil.a(paramContext, 15.0F);
    int k = viewPagerItemMarginLeft;
    arkViewWidth = i - k * 2 - j;
    viewPagerItemHeight = (int)(arkViewWidth * 0.911F);
    viewPagerWidth = (i - k) * 1.0F / i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.strategy.WebUiStrategy2.Strategy2Config
 * JD-Core Version:    0.7.0.1
 */