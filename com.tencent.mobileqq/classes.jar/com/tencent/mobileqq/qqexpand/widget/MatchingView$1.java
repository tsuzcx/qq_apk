package com.tencent.mobileqq.qqexpand.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.mini.ui.RoundImageView;

class MatchingView$1
  implements DecodeTaskCompletionListener
{
  MatchingView$1(MatchingView paramMatchingView, String paramString) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString))
    {
      paramString = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetMatchingView.getResources(), paramBitmap);
      MatchingView.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetMatchingView).setImageDrawable(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.MatchingView.1
 * JD-Core Version:    0.7.0.1
 */