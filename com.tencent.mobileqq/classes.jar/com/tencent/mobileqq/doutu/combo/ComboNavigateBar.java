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
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ComboNavigateBar
  extends LinearLayout
  implements View.OnClickListener, Animation.AnimationListener
{
  ComboObject a;
  protected Animation b = null;
  protected Animation c = null;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private BaseQQAppInterface i;
  private boolean j = true;
  private String k = "";
  
  public ComboNavigateBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Drawable a(View paramView, ComboResource.ImageObject paramImageObject)
  {
    paramView = paramView.getLayoutParams();
    paramView.width = paramImageObject.a;
    paramView.height = paramImageObject.b;
    return paramImageObject.c;
  }
  
  private boolean a(ImageView paramImageView, int paramInt)
  {
    ComboResource.ImageObject localImageObject = ComboResource.a(paramInt, this.i.getApplicationContext());
    if (localImageObject == null)
    {
      this.j = false;
      return false;
    }
    paramImageView.setImageDrawable(a(paramImageView, localImageObject));
    return true;
  }
  
  private boolean b()
  {
    ComboResource.ImageObject localImageObject = ComboResource.a(this.i.getApplicationContext());
    if (localImageObject == null)
    {
      this.j = false;
      return false;
    }
    ImageView localImageView = this.h;
    localImageView.setImageDrawable(a(localImageView, localImageObject));
    return true;
  }
  
  private boolean c()
  {
    ComboResource.ImageObject localImageObject = ComboResource.b(this.i.getApplicationContext());
    if (localImageObject == null)
    {
      this.j = false;
      return false;
    }
    ImageView localImageView = this.d;
    localImageView.setImageDrawable(a(localImageView, localImageObject));
    return true;
  }
  
  public void a()
  {
    if ((this.c != null) && (getVisibility() == 0))
    {
      clearAnimation();
      startAnimation(this.c);
    }
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.i = paramBaseQQAppInterface;
    this.h = ((ImageView)findViewById(2131427947));
    this.d = ((ImageView)findViewById(2131427941));
    this.e = ((ImageView)findViewById(2131427942));
    this.f = ((ImageView)findViewById(2131427943));
    this.g = ((ImageView)findViewById(2131427944));
    setVisibility(8);
    this.c = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.c.setDuration(500L);
    this.c.setAnimationListener(this);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.c)) {
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
    int i1 = this.a.b;
    int n = i1 / 10;
    int m;
    if (n != 0)
    {
      m = n % 10;
      n /= 10;
    }
    else
    {
      m = 0;
    }
    if (n != 0) {
      n %= 100;
    } else {
      n = 0;
    }
    c();
    b();
    this.g.setVisibility(0);
    a(this.g, i1 % 10);
    if (n == 0)
    {
      if (m == 0)
      {
        this.f.setVisibility(8);
        this.e.setVisibility(8);
        return;
      }
      this.f.setVisibility(0);
      this.e.setVisibility(8);
      a(this.f, m);
      return;
    }
    this.f.setVisibility(0);
    this.e.setVisibility(0);
    a(this.f, m);
    a(this.e, n);
  }
  
  public void setInfo(ComboObject paramComboObject)
  {
    this.a = paramComboObject;
    this.j = true;
    String str = paramComboObject.a;
    int m = paramComboObject.b;
    setCountNum();
    if (this.j == true)
    {
      setVisibility(0);
      setOnClickListener(this);
      return;
    }
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboNavigateBar
 * JD-Core Version:    0.7.0.1
 */