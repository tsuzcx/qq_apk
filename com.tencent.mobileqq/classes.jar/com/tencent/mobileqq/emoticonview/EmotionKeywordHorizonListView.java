package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.emotionintegrate.EmotionKeywordLayout;
import com.tencent.widget.HorizontalListView;

public class EmotionKeywordHorizonListView
  extends HorizontalListView
{
  public static final int TYPE_EMOTION_KEYWORD = 0;
  public static final int TYPE_ZHITU = 1;
  public int mType = 0;
  private EmotionKeywordHorizonListView.HorizonListViewTouchListener touchListener;
  
  public EmotionKeywordHorizonListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmotionKeywordHorizonListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EmotionKeywordHorizonListView.HorizonListViewTouchListener localHorizonListViewTouchListener = this.touchListener;
    if (localHorizonListViewTouchListener != null) {
      localHorizonListViewTouchListener.touchEventActionChanged(paramMotionEvent.getAction());
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (((localView instanceof EmotionKeywordLayout)) && (((EmotionKeywordLayout)localView).c)) {
        return localView.onTouchEvent(paramMotionEvent);
      }
      i += 1;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsFromRightToLeft(boolean paramBoolean)
  {
    this.isFromRightToLeft = paramBoolean;
    invalidate();
  }
  
  public void setTouchListener(EmotionKeywordHorizonListView.HorizonListViewTouchListener paramHorizonListViewTouchListener)
  {
    this.touchListener = paramHorizonListViewTouchListener;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView
 * JD-Core Version:    0.7.0.1
 */