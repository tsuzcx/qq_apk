package com.tencent.mobileqq.doutu;

import android.view.View;
import android.widget.ProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import java.util.HashMap;

class DoutuEmotionAdapter$1
  implements URLDrawableDownListener
{
  DoutuEmotionAdapter$1(DoutuEmotionAdapter paramDoutuEmotionAdapter) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof DoutuEmotionAdapter.ViewHolder)))
    {
      paramView = (DoutuEmotionAdapter.ViewHolder)paramView;
      if (paramView.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      }
      if (this.a.a == null) {
        this.a.a = new HashMap();
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData.pic_md5 != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData.pic_down_url != null)) {
        this.a.a.put(paramView.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData.pic_md5, paramView.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData.pic_down_url);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */