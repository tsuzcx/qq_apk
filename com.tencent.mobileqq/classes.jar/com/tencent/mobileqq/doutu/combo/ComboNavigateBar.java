package com.tencent.mobileqq.doutu.combo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import asak;
import asal;
import asam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ComboNavigateBar
  extends LinearLayout
  implements View.OnClickListener, Animation.AnimationListener
{
  protected Animation a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  asak jdField_a_of_type_Asak;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = true;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  
  public ComboNavigateBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Drawable a(View paramView, asam paramasam)
  {
    paramView = paramView.getLayoutParams();
    paramView.width = paramasam.jdField_a_of_type_Int;
    paramView.height = paramasam.b;
    return paramasam.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private boolean a()
  {
    asam localasam = asal.a();
    if (localasam == null)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.e.setImageDrawable(a(this.e, localasam));
    return true;
  }
  
  private boolean a(ImageView paramImageView, int paramInt)
  {
    asam localasam = asal.a(paramInt);
    if (localasam == null)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    paramImageView.setImageDrawable(a(paramImageView, localasam));
    return true;
  }
  
  private boolean b()
  {
    asam localasam = asal.b();
    if (localasam == null)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(this.jdField_a_of_type_AndroidWidgetImageView, localasam));
    return true;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (getVisibility() == 0))
    {
      clearAnimation();
      startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.e = ((ImageView)findViewById(2131362362));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362356));
    this.b = ((ImageView)findViewById(2131362357));
    this.c = ((ImageView)findViewById(2131362358));
    this.d = ((ImageView)findViewById(2131362359));
    setVisibility(8);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.jdField_a_of_type_AndroidViewAnimationAnimation)) {
      setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setCountNum()
  {
    int k = this.jdField_a_of_type_Asak.jdField_a_of_type_Int;
    int j = k / 10;
    int i;
    if (j != 0)
    {
      i = j % 10;
      j /= 10;
    }
    for (;;)
    {
      if (j != 0) {
        j %= 100;
      }
      for (;;)
      {
        b();
        a();
        this.d.setVisibility(0);
        a(this.d, k % 10);
        if (j == 0)
        {
          if (i == 0)
          {
            this.c.setVisibility(8);
            this.b.setVisibility(8);
            return;
          }
          this.c.setVisibility(0);
          this.b.setVisibility(8);
          a(this.c, i);
          return;
        }
        this.c.setVisibility(0);
        this.b.setVisibility(0);
        a(this.c, i);
        a(this.b, j);
        return;
        j = 0;
      }
      i = 0;
    }
  }
  
  public void setInfo(asak paramasak)
  {
    this.jdField_a_of_type_Asak = paramasak;
    this.jdField_a_of_type_Boolean = true;
    String str = paramasak.jdField_a_of_type_JavaLangString;
    int i = paramasak.jdField_a_of_type_Int;
    setCountNum();
    if (this.jdField_a_of_type_Boolean == true)
    {
      setVisibility(0);
      setOnClickListener(this);
      return;
    }
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboNavigateBar
 * JD-Core Version:    0.7.0.1
 */