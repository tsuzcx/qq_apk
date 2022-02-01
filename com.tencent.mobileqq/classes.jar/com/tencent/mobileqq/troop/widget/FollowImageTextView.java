package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class FollowImageTextView
  extends LinearLayout
{
  private FollowImageTextView.FirstTextView a;
  private TextView b;
  private LinearLayout c;
  private LinearLayout d;
  private ImageView e;
  private CharSequence f = "";
  private int g = 2147483647;
  private boolean h = true;
  private FollowImageTextView.TextLineHelper i;
  private FollowImageTextView.OnTextLineChangeListener j;
  private int k = 10;
  
  public FollowImageTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public FollowImageTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public FollowImageTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  @RequiresApi(api=21)
  public FollowImageTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private void a()
  {
    boolean bool2 = this.h;
    if (this.g < 2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.h = bool1;
    if (this.h)
    {
      this.a.setMaxLines(1);
      this.a.setEllipsize(TextUtils.TruncateAt.END);
    }
    else
    {
      this.a.setMaxLines(this.g - 1);
      this.a.setEllipsize(null);
    }
    this.a.setText(this.f);
    boolean bool1 = this.h;
    if (((bool2 ^ bool1)) && (bool1))
    {
      FollowImageTextView.OnTextLineChangeListener localOnTextLineChangeListener = this.j;
      if (localOnTextLineChangeListener != null) {
        localOnTextLineChangeListener.a(1);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    setOrientation(1);
    this.c = new LinearLayout(paramContext);
    this.c.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.c.setOrientation(0);
    addView(this.c);
    this.a = new FollowImageTextView.FirstTextView(this, paramContext);
    this.a.setId(2131441541);
    this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.c.addView(this.a);
    this.d = new LinearLayout(paramContext);
    this.d.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.d.setOrientation(0);
    this.d.setVisibility(8);
    addView(this.d);
    this.b = new TextView(paramContext);
    this.b.setId(2131441542);
    this.b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.b.setSingleLine(true);
    this.b.setEllipsize(TextUtils.TruncateAt.END);
    this.b.setIncludeFontPadding(false);
    this.d.addView(this.b);
    this.e = new ImageView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    localLayoutParams.leftMargin = ((int)(this.k * f1 + 0.5F));
    this.e.setLayoutParams(localLayoutParams);
    this.e.setVisibility(8);
    this.c.addView(this.e);
  }
  
  private void a(boolean paramBoolean)
  {
    int m = this.d.getVisibility();
    if (((paramBoolean) && (m == 0)) || ((!paramBoolean) && (m == 8))) {
      return;
    }
    if (paramBoolean)
    {
      this.d.setVisibility(0);
      this.c.removeView(this.e);
      this.d.addView(this.e);
      return;
    }
    this.d.setVisibility(8);
    this.d.removeView(this.e);
    this.c.addView(this.e);
  }
  
  private FollowImageTextView.TextLineHelper getHelper()
  {
    if (this.i == null) {
      this.i = new FollowImageTextView.TextLineHelper(this);
    }
    return this.i;
  }
  
  public ImageView getFollowImageView()
  {
    return this.e;
  }
  
  public CharSequence getText()
  {
    return this.f;
  }
  
  public void setAllChildOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
    this.b.setOnClickListener(paramOnClickListener);
    this.e.setOnClickListener(paramOnClickListener);
  }
  
  public void setAllChildOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.a.setOnTouchListener(paramOnTouchListener);
    this.b.setOnTouchListener(paramOnTouchListener);
    this.e.setOnTouchListener(paramOnTouchListener);
  }
  
  public void setAllChildTag(Object paramObject)
  {
    this.a.setTag(paramObject);
    this.b.setTag(paramObject);
    this.e.setTag(paramObject);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.a.setContentDescription(paramCharSequence);
    this.b.setContentDescription(paramCharSequence);
  }
  
  public void setFollowImageResource(int paramInt)
  {
    this.e.setImageResource(paramInt);
  }
  
  public void setFollowImageVisibility(int paramInt)
  {
    this.e.setVisibility(paramInt);
  }
  
  public void setFollowImageWH(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    this.e.setLayoutParams(localLayoutParams);
  }
  
  public void setMaxLines(int paramInt)
  {
    this.g = paramInt;
    a();
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.a.setMaxWidth(paramInt);
    this.b.setMaxWidth(paramInt);
  }
  
  public void setOnTextLineChangeListener(FollowImageTextView.OnTextLineChangeListener paramOnTextLineChangeListener)
  {
    this.j = paramOnTextLineChangeListener;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (TextUtils.equals(this.f, paramCharSequence)) {
      return;
    }
    this.f = paramCharSequence;
    a();
  }
  
  public void setTextColor(int paramInt)
  {
    this.a.setTextColor(paramInt);
    this.b.setTextColor(paramInt);
  }
  
  public void setTextSize(float paramFloat)
  {
    this.a.setTextSize(paramFloat);
    this.b.setTextSize(paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.a.setTextSize(paramInt, paramFloat);
    this.b.setTextSize(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.FollowImageTextView
 * JD-Core Version:    0.7.0.1
 */