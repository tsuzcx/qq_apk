package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.ScrollView;

public class QwScrollView
  extends ScrollView
{
  private QwScrollView.OnQwScrollListener jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplQwScrollView$OnQwScrollListener;
  private boolean jdField_a_of_type_Boolean = false;
  
  public QwScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QwScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QwScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    QwScrollView.OnQwScrollListener localOnQwScrollListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplQwScrollView$OnQwScrollListener;
    if (localOnQwScrollListener != null) {
      localOnQwScrollListener.a(Boolean.valueOf(this.jdField_a_of_type_Boolean), this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QwScrollView.OnQwScrollListener localOnQwScrollListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplQwScrollView$OnQwScrollListener;
    if (localOnQwScrollListener != null) {
      localOnQwScrollListener.a(this, paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 2) {
      this.jdField_a_of_type_Boolean = true;
    } else if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_Boolean = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnQwScrollListener(QwScrollView.OnQwScrollListener paramOnQwScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendViewImplQwScrollView$OnQwScrollListener = paramOnQwScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.QwScrollView
 * JD-Core Version:    0.7.0.1
 */