package com.tencent.mobileqq.emoticonview;

public abstract class AbstractEmoticonPanelHelper
{
  public static final int ON_ATTACHEDTOWINDOW = 9;
  public static final int ON_DESTORY = 8;
  public static final int ON_DETACHEDFROMWINDOW = 10;
  public static final int ON_HIDE = 4;
  public static final int ON_INIT_AFTER = 2;
  public static final int ON_INIT_BEFORE = 1;
  public static final int ON_PAGE_SELECTED = 3;
  public static final int ON_PAUSE = 7;
  public static final int ON_RESUME = 6;
  public static final int ON_SHOW = 5;
  protected final EmoticonPanelController mPanelController;
  
  public AbstractEmoticonPanelHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    this.mPanelController = paramEmoticonPanelController;
  }
  
  public abstract String getTag();
  
  public void initAfter() {}
  
  public void initBefore() {}
  
  public abstract int[] interestedIn();
  
  public void onAttachedToWindow() {}
  
  public void onDestory() {}
  
  public void onDetachedFromWindow() {}
  
  public void onHide(boolean paramBoolean) {}
  
  public void onPageSelected(int paramInt) {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onShow() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
 * JD-Core Version:    0.7.0.1
 */