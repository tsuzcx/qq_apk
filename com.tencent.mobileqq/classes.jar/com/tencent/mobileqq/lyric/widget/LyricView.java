package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import awqq;
import com.tencent.mobileqq.R.styleable;

public class LyricView
  extends FrameLayout
{
  protected awqq a;
  protected LyricViewInternal a;
  protected LyricViewScroll a;
  protected boolean a;
  protected boolean b = true;
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ModuleLyricView, 0, 0);
    this.jdField_a_of_type_Awqq = new awqq();
    this.jdField_a_of_type_Awqq.a(paramContext);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(16, false);
    paramContext.recycle();
  }
  
  public LyricViewInternal a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal;
  }
  
  public LyricViewScroll a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.a(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.a(paramInt4 - paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b)
    {
      a(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public void setIsDealTouchEvent(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricView
 * JD-Core Version:    0.7.0.1
 */