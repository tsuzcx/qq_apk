package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.biz.ui.CenteredImageSpan;

class NativeAwesomeCommentView$2
  implements Drawable.Callback
{
  NativeAwesomeCommentView$2(NativeAwesomeCommentView paramNativeAwesomeCommentView, SpannableString paramSpannableString) {}
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    paramDrawable = new CenteredImageSpan(paramDrawable);
    this.jdField_a_of_type_AndroidTextSpannableString.setSpan(paramDrawable, 0, 1, 17);
    NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeAwesomeCommentView).setText(this.jdField_a_of_type_AndroidTextSpannableString);
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAwesomeCommentView.2
 * JD-Core Version:    0.7.0.1
 */