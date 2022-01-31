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
import anoo;
import anop;
import anoq;
import com.tencent.mobileqq.app.QQAppInterface;

public class ComboNavigateBar
  extends LinearLayout
  implements View.OnClickListener, Animation.AnimationListener
{
  protected Animation a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  anoo jdField_a_of_type_Anoo;
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
  
  private Drawable a(View paramView, anoq paramanoq)
  {
    paramView = paramView.getLayoutParams();
    paramView.width = paramanoq.jdField_a_of_type_Int;
    paramView.height = paramanoq.b;
    return paramanoq.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private boolean a()
  {
    anoq localanoq = anop.a();
    if (localanoq == null)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.e.setImageDrawable(a(this.e, localanoq));
    return true;
  }
  
  private boolean a(ImageView paramImageView, int paramInt)
  {
    anoq localanoq = anop.a(paramInt);
    if (localanoq == null)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    paramImageView.setImageDrawable(a(paramImageView, localanoq));
    return true;
  }
  
  private boolean b()
  {
    anoq localanoq = anop.b();
    if (localanoq == null)
    {
      this.jdField_a_of_type_Boolean = false;
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(this.jdField_a_of_type_AndroidWidgetImageView, localanoq));
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
    this.e = ((ImageView)findViewById(2131362245));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362239));
    this.b = ((ImageView)findViewById(2131362240));
    this.c = ((ImageView)findViewById(2131362241));
    this.d = ((ImageView)findViewById(2131362242));
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
  }
  
  public void setCountNum()
  {
    int k = this.jdField_a_of_type_Anoo.jdField_a_of_type_Int;
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
  
  public void setInfo(anoo paramanoo)
  {
    this.jdField_a_of_type_Anoo = paramanoo;
    this.jdField_a_of_type_Boolean = true;
    String str = paramanoo.jdField_a_of_type_JavaLangString;
    int i = paramanoo.jdField_a_of_type_Int;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboNavigateBar
 * JD-Core Version:    0.7.0.1
 */