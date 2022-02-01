package com.tencent.mobileqq.emoticonview;

public abstract class AbstractEmoticonPanelHelper<T extends IEmoticonPanelController>
{
  public static final int ON_ATTACHEDTOWINDOW = 9;
  public static final int ON_DESTORY = 8;
  public static final int ON_DETACHEDFROMWINDOW = 10;
  public static final int ON_HIDE = 4;
  public static final int ON_INIT_AFTER = 2;
  public static final int ON_INIT_BEFORE = 1;
  public static final int ON_ITEM_TAB_CLICK = 13;
  public static final int ON_PAGE_SELECTED = 3;
  public static final int ON_PAUSE = 7;
  public static final int ON_PULL_DOWN = 11;
  public static final int ON_PULL_UP = 12;
  public static final int ON_RESUME = 6;
  public static final int ON_SHOW = 5;
  public static final int ON_SHOW_PAGE_FINISH = 14;
  protected T mPanelController;
  
  public AbstractEmoticonPanelHelper(T paramT)
  {
    this.mPanelController = paramT;
  }
  
  public abstract String getTag();
  
  public void initAfter() {}
  
  public void initBefore() {}
  
  public abstract int[] interestedIn();
  
  public void onAttachedToWindow() {}
  
  public void onDestory() {}
  
  public void onDetachedFromWindow() {}
  
  public void onHide(boolean paramBoolean) {}
  
  public void onItemTabClick(int paramInt) {}
  
  public void onPageSelected(int paramInt) {}
  
  public void onPause() {}
  
  public void onPullDown() {}
  
  public void onPullUp() {}
  
  public void onResume() {}
  
  public void onShow() {}
  
  public void onShowPageFinish() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
 * JD-Core Version:    0.7.0.1
 */