package com.tencent.mobileqq.structmsg.widget;

import aikd;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;

public class CountdownTextView
  extends TextView
{
  private CountDownTimer.CountDownTimerListener jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer$CountDownTimerListener;
  private CountDownTimer jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer = new CountDownTimer();
  
  public CountdownTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CountdownTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CountdownTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    CountDownTimer localCountDownTimer = this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer;
    if (localCountDownTimer != null) {
      localCountDownTimer.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer$CountDownTimerListener);
    }
  }
  
  public void a(long paramLong, CountdownTextView.TimerCallback paramTimerCallback)
  {
    CountDownTimer localCountDownTimer = this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer;
    if (localCountDownTimer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer$CountDownTimerListener = new aikd(this, paramLong, paramTimerCallback);
      localCountDownTimer.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer$CountDownTimerListener);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.widget.CountdownTextView
 * JD-Core Version:    0.7.0.1
 */