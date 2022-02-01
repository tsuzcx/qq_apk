package com.tencent.mobileqq.emoticonview.relateemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

public class RelatedEmoLinearLayout
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private RelatedEmoLinearLayout.CheckForLongPress jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoLinearLayout$CheckForLongPress;
  private boolean jdField_a_of_type_Boolean;
  
  public RelatedEmoLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RelatedEmoLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RelatedEmoLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  View a(float paramFloat1, float paramFloat2)
  {
    int i = super.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = super.getChildAt(i);
      float f1 = super.getScrollX() + paramFloat1 - localView.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localView.getTop();
      if ((f1 >= 0.0F) && (f1 <= localView.getWidth()) && (f2 >= 0.0F) && (f2 < localView.getHeight()) && (localView.getVisibility() == 0)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoLinearLayout$CheckForLongPress != null)) {
        removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoLinearLayout$CheckForLongPress);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidViewView.performClick();
      }
      this.jdField_a_of_type_AndroidViewView = null;
      continue;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.2F);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoLinearLayout$CheckForLongPress == null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoLinearLayout$CheckForLongPress = new RelatedEmoLinearLayout.CheckForLongPress(this, paramMotionEvent);
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoLinearLayout$CheckForLongPress.a();
        postDelayed(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoLinearLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
        continue;
        super.setPressed(false);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoLinearLayout$CheckForLongPress != null) {
          removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmoLinearLayout$CheckForLongPress);
        }
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
        }
        this.jdField_a_of_type_AndroidViewView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoLinearLayout
 * JD-Core Version:    0.7.0.1
 */