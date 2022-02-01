package com.tencent.mobileqq.utils.dialogutils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQCustomMenuLayout
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView a;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private int e;
  private int f;
  private int g;
  private float h;
  private TextPaint i;
  private int j = 0;
  private boolean k;
  private boolean l;
  
  public QQCustomMenuLayout(Context paramContext)
  {
    super(paramContext);
    Object localObject = paramContext.getResources();
    this.g = ((Resources)localObject).getDisplayMetrics().widthPixels;
    this.h = ((Resources)localObject).getDisplayMetrics().density;
    int m = this.g;
    float f1 = this.h;
    this.g = (m - (int)(f1 * 10.0F));
    if (f1 >= 2.0F) {
      m = 20;
    } else {
      m = 12;
    }
    this.i = new TextPaint(1);
    this.i.density = ((Resources)localObject).getDisplayMetrics().density;
    this.i.setTextSize(TypedValue.applyDimension(2, 15.0F, ((Resources)localObject).getDisplayMetrics()));
    this.a = new ImageView(paramContext);
    this.a.setVisibility(8);
    this.a.setImageResource(2130839068);
    this.a.setContentDescription(HardCodeUtil.a(2131907861));
    this.a.setBackgroundDrawable(null);
    this.a.setOnClickListener(this);
    localObject = this.a;
    f1 = m;
    float f2 = this.h;
    ((ImageView)localObject).setPadding((int)(f1 * f2), (int)(f2 * 10.0F), (int)(f1 * f2), (int)(f2 * 10.0F));
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.a, 0);
    this.c = new ImageView(paramContext);
    this.c.setBackgroundResource(2130839053);
    if (!AppSetting.e) {
      this.c.setContentDescription("leftIcon");
    }
    this.c.setVisibility(8);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.c, 1);
    this.d = new ImageView(paramContext);
    this.d.setBackgroundResource(2130839053);
    if (!AppSetting.e) {
      this.d.setContentDescription("rightIcon");
    }
    this.d.setVisibility(8);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.d, 2);
    this.b = new ImageView(paramContext);
    this.b.setVisibility(8);
    this.b.setImageResource(2130839075);
    this.b.setContentDescription(HardCodeUtil.a(2131907847));
    this.b.setBackgroundDrawable(null);
    this.b.setOnClickListener(this);
    paramContext = this.b;
    f2 = this.h;
    paramContext.setPadding((int)(f1 * f2), (int)(f2 * 10.0F), (int)(f1 * f2), (int)(f2 * 10.0F));
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    this.b.setLayoutParams(paramContext);
    addView(this.b, 3);
  }
  
  private int b()
  {
    int i2 = getChildCount();
    int m = 0;
    onMeasure(0, 0);
    int i1;
    for (int n = 0; m < i2; n = i1)
    {
      View localView = getChildAt(m);
      i1 = n;
      if (localView != null)
      {
        i1 = n;
        if (localView.getVisibility() != 8)
        {
          Object localObject;
          if ((localView instanceof TextView))
          {
            localObject = (TextView)localView;
            i1 = (int)Layout.getDesiredWidth(((TextView)localObject).getText(), this.i);
            if (QLog.isDevelopLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("child  TextView text ");
              localStringBuilder.append(((TextView)localObject).getText());
              localStringBuilder.append(" measureWidth = ");
              localStringBuilder.append(i1);
              localStringBuilder.append(" padding = ");
              localStringBuilder.append(localView.getPaddingLeft());
              QLog.d("QQCustomMenuLayout", 4, localStringBuilder.toString());
            }
            n = n + i1 + this.j;
          }
          else
          {
            int i3 = localView.getMeasuredWidth();
            i1 = n + i3;
            n = i1;
            if (QLog.isDevelopLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("child  nonTextView measureWidth = ");
              ((StringBuilder)localObject).append(i3);
              QLog.d("QQCustomMenuLayout", 4, ((StringBuilder)localObject).toString());
              n = i1;
            }
          }
          i1 = n + localView.getPaddingLeft() + localView.getPaddingRight();
        }
      }
      m += 1;
    }
    return n;
  }
  
  private void c()
  {
    if (this.e > 3)
    {
      localImageView = this.a;
      if ((localImageView != null) && (localImageView.getVisibility() != 0)) {
        this.a.setVisibility(0);
      }
    }
    else
    {
      localImageView = this.a;
      if ((localImageView != null) && (localImageView.getVisibility() != 8)) {
        this.a.setVisibility(8);
      }
    }
    if (this.f < getChildCount() - 4)
    {
      localImageView = this.b;
      if ((localImageView != null) && (localImageView.getVisibility() != 0)) {
        this.b.setVisibility(0);
      }
    }
    else
    {
      localImageView = this.b;
      if ((localImageView != null) && (localImageView.getVisibility() != 8)) {
        this.b.setVisibility(8);
      }
    }
    ImageView localImageView = this.c;
    if ((localImageView != null) && (this.a != null) && (localImageView.getVisibility() != this.a.getVisibility())) {
      this.c.setVisibility(this.a.getVisibility());
    }
    localImageView = this.d;
    if ((localImageView != null) && (this.b != null) && (localImageView.getVisibility() != this.b.getVisibility())) {
      this.d.setVisibility(this.b.getVisibility());
    }
  }
  
  public void a()
  {
    int n;
    for (int m = -1;; m = n)
    {
      n = b();
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("totalWidth = ");
        localStringBuilder.append(n);
        localStringBuilder.append(" startPosition = ");
        localStringBuilder.append(this.e);
        localStringBuilder.append(" endPosition = ");
        localStringBuilder.append(this.f);
        QLog.d("QQCustomMenuLayout", 4, localStringBuilder.toString());
      }
      int i1 = this.g;
      if ((n <= i1) || (m == n))
      {
        c();
        return;
      }
      setMinimumWidth(i1);
      if (this.k) {
        this.f -= 2;
      } else if (this.l) {
        this.e += 2;
      } else {
        this.f -= 2;
      }
      if (this.f < 0) {
        this.f = 0;
      }
      m = this.e;
      i1 = this.f;
      if (m > i1) {
        this.e = i1;
      }
      a(this.e, this.f);
      c();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int m = 2;
    while (m < getChildCount() - 2)
    {
      if ((m >= paramInt1) && (m <= paramInt2)) {
        getChildAt(m).setVisibility(0);
      } else {
        getChildAt(m).setVisibility(8);
      }
      m += 1;
    }
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView, getChildCount() - 2);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    addView(paramView, localLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    addView(paramView);
  }
  
  public void onClick(View paramView)
  {
    int m;
    int n;
    if (paramView == this.a)
    {
      m = this.e;
      if (m > 3)
      {
        this.k = false;
        this.l = true;
        this.f = (m - 2);
        this.e = 2;
        m = this.e;
        n = this.f;
        if (m > n) {
          this.e = n;
        }
        a(this.e, this.f);
        this.b.setVisibility(0);
        this.d.setVisibility(0);
        this.a.setVisibility(8);
        this.c.setVisibility(8);
        a();
        this.l = false;
      }
    }
    else if (this.e < getChildCount() - 4)
    {
      this.l = false;
      this.k = true;
      this.e = (this.f + 2);
      this.f = (getChildCount() - 3);
      m = this.e;
      n = this.f;
      if (m > n) {
        this.e = n;
      }
      a(this.e, this.f);
      this.a.setVisibility(0);
      this.c.setVisibility(0);
      this.b.setVisibility(8);
      this.d.setVisibility(8);
      a();
      this.k = false;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuLayout
 * JD-Core Version:    0.7.0.1
 */