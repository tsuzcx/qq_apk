package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import apsa;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.EmotionKeywordLayout;
import com.tencent.widget.HorizontalListView;

public class EmotionKeywordHorizonListView
  extends HorizontalListView
{
  public int a;
  private apsa a;
  
  public EmotionKeywordHorizonListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
  }
  
  public EmotionKeywordHorizonListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Apsa != null) {
      this.jdField_a_of_type_Apsa.a(paramMotionEvent.getAction());
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
      if (((localView instanceof EmojiStickerManager.EmotionKeywordLayout)) && (((EmojiStickerManager.EmotionKeywordLayout)localView).a)) {
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
  
  public void setTouchListener(apsa paramapsa)
  {
    this.jdField_a_of_type_Apsa = paramapsa;
  }
  
  public void setType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView
 * JD-Core Version:    0.7.0.1
 */