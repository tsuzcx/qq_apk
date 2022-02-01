package com.tencent.mobileqq.troop.widget;

import android.graphics.Color;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManager;

final class HotChatPostItemView$1
  implements URLDrawable.URLDrawableListener
{
  HotChatPostItemView$1(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, String paramString, URLDrawable paramURLDrawable, float paramFloat, int paramInt4) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(Color.parseColor("#e7e7e7"));
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (this.d != 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(this.d);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(Color.parseColor("#e7e7e7"));
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    if ((this.jdField_a_of_type_Int != 0) && (this.b != 0) && (this.c != 0))
    {
      ThreadManager.post(new HotChatPostItemView.1.1(this), 5, null, true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(HotChatPostItemView.a(this.jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_Float));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.HotChatPostItemView.1
 * JD-Core Version:    0.7.0.1
 */