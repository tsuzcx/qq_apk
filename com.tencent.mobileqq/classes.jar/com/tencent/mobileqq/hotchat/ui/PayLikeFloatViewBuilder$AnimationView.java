package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import aqel;
import com.tencent.mobileqq.app.QQAppInterface;

public class PayLikeFloatViewBuilder$AnimationView
  extends TextView
{
  protected AnimationDrawable a;
  protected aqel a;
  protected QQAppInterface a;
  
  public PayLikeFloatViewBuilder$AnimationView(Context paramContext, QQAppInterface paramQQAppInterface, aqel paramaqel)
  {
    super(paramContext);
    super.setGravity(17);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aqel = paramaqel;
    if (super.getVisibility() == 0) {
      setVisibility(0);
    }
  }
  
  public void a()
  {
    super.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames())
      {
        Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getFrame(i);
        if (localDrawable != null) {
          localDrawable.setCallback(null);
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setCallback(null);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.getNumberOfFrames() != 20))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = new AnimationDrawable();
      Drawable[] arrayOfDrawable = this.jdField_a_of_type_Aqel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (arrayOfDrawable == null) {
        return;
      }
      int i = 0;
      while (i < 20)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(arrayOfDrawable[i], 50);
        i += 1;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(false);
      super.setCompoundDrawablesWithIntrinsicBounds(null, this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable, null, null);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
  }
  
  public void setVisibility(int paramInt)
  {
    if (super.getVisibility() != paramInt) {
      super.setVisibility(paramInt);
    }
    if (paramInt == 0)
    {
      b();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder.AnimationView
 * JD-Core Version:    0.7.0.1
 */