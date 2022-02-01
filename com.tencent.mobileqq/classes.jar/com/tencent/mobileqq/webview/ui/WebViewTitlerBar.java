package com.tencent.mobileqq.webview.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.utils.ValueAnimation;

public class WebViewTitlerBar
{
  TextView a;
  ImageView b;
  TextView c;
  TextView d;
  ImageView e;
  View f;
  Activity g;
  ImageView h;
  String i = null;
  CustomWebView j = null;
  FrameLayout k;
  RelativeLayout l;
  FrameLayout m;
  View n;
  int o = 255;
  public View.OnClickListener p = null;
  boolean q = false;
  
  public WebViewTitlerBar(Activity paramActivity, CustomWebView paramCustomWebView, ViewGroup paramViewGroup)
  {
    this.g = paramActivity;
    this.j = paramCustomWebView;
    a(paramViewGroup);
    a();
  }
  
  void a()
  {
    this.k = ((FrameLayout)this.f.findViewById(2131431304));
    this.l = ((RelativeLayout)this.f.findViewById(2131431316));
    this.m = ((FrameLayout)this.f.findViewById(2131431314));
    this.a = ((TextView)this.f.findViewById(2131436227));
    this.a.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    this.a.setMaxEms(9);
    this.b = ((ImageView)this.f.findViewById(2131436224));
    this.c = ((TextView)this.f.findViewById(2131436180));
    this.d = ((TextView)this.f.findViewById(2131436211));
    this.e = ((ImageView)this.f.findViewById(2131436194));
    this.n = this.f.findViewById(2131429675);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.q) {
      this.q = false;
    }
    if (paramInt2 == 0)
    {
      this.f.getBackground().mutate().setAlpha(paramInt1);
      this.o = paramInt1;
      return;
    }
    int i1 = this.o;
    if (i1 == paramInt1) {
      return;
    }
    a(i1, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      this.f.getBackground().mutate().setAlpha(paramInt2);
      return;
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new WebViewTitlerBar.3(this, paramInt2));
    localValueAnimation.setDuration(paramInt3);
    this.q = true;
    this.f.startAnimation(localValueAnimation);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.c.setOnClickListener(paramOnClickListener);
  }
  
  public void a(View paramView)
  {
    try
    {
      this.l.removeAllViews();
      this.l.addView(paramView, new RelativeLayout.LayoutParams(-2, -1));
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  void a(ViewGroup paramViewGroup)
  {
    this.f = LayoutInflater.from(this.g).inflate(2131629667, paramViewGroup, true);
  }
  
  public void a(ImageView paramImageView)
  {
    this.h = paramImageView;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    TextView localTextView = this.c;
    if (localTextView != null)
    {
      localTextView.setText(paramCharSequence);
      this.c.setVisibility(0);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = TextUtils.isEmpty(paramString2);
    int i1 = 0;
    if (!bool)
    {
      this.d.setText(paramString2);
      this.d.setVisibility(0);
      this.d.bringToFront();
      this.e.setImageResource(0);
      this.e.setBackgroundColor(0);
      this.e.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    try
    {
      int i2 = Color.parseColor(paramString3);
      i1 = i2;
    }
    catch (Exception paramString2)
    {
      label79:
      break label79;
    }
    this.d.setTextColor(i1);
    if (paramString1 != null)
    {
      this.i = paramString1.trim();
      b(new WebViewTitlerBar.2(this));
      return;
    }
    this.i = null;
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.e;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localImageView.setVisibility(i1);
  }
  
  public ImageView b()
  {
    return this.e;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.a.setText(paramCharSequence);
  }
  
  public void b(boolean paramBoolean)
  {
    TextView localTextView = this.c;
    if (localTextView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 4;
      }
      localTextView.setVisibility(i1);
    }
  }
  
  public CharSequence c()
  {
    TextView localTextView = this.d;
    if (localTextView != null) {
      return localTextView.getText();
    }
    return null;
  }
  
  public void c(View.OnClickListener paramOnClickListener)
  {
    this.e.setOnClickListener(paramOnClickListener);
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView = this.d;
    if (localTextView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localTextView.setVisibility(i1);
    }
  }
  
  public View d()
  {
    return this.f;
  }
  
  public TextView e()
  {
    return this.c;
  }
  
  public TextView f()
  {
    return this.a;
  }
  
  public TextView g()
  {
    return this.d;
  }
  
  public ImageView h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewTitlerBar
 * JD-Core Version:    0.7.0.1
 */