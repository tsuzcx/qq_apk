package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalLabelLayout;
import java.util.ArrayList;
import java.util.List;

public class SavorTagIcon
  extends HorizontalLabelLayout
  implements View.OnClickListener
{
  private static final String[] p = { "#C6DAF7", "#FFCCC5", "#D9CAF7", "#B6ECD1" };
  String a;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  List<InterestTagInfo> j;
  TextView k;
  OnTagClickListener l;
  boolean m = true;
  float n;
  
  public SavorTagIcon(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public SavorTagIcon(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SavorTagIcon(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  protected void a()
  {
    List localList = this.j;
    if ((localList != null) && (localList.size() != 0))
    {
      float f1 = this.n;
      this.i = ((int)(f1 * 12.0F));
      this.g = ((int)(f1 * 12.0F));
      return;
    }
    this.i = ((int)(this.n * 12.0F));
    this.g = 0;
  }
  
  public void a(String paramString, int paramInt, List<InterestTagInfo> paramList, OnTagClickListener paramOnTagClickListener)
  {
    this.l = paramOnTagClickListener;
    this.b = paramInt;
    this.a = paramString;
    paramOnTagClickListener = p;
    paramString = paramOnTagClickListener[0];
    paramInt = this.b;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4) {
            paramString = paramOnTagClickListener[3];
          }
        }
        else {
          paramString = paramOnTagClickListener[2];
        }
      }
      else {
        paramString = paramOnTagClickListener[1];
      }
    }
    else {
      paramString = paramOnTagClickListener[0];
    }
    try
    {
      this.d = Color.parseColor(paramString);
    }
    catch (Exception paramString)
    {
      if (QLog.isDevelopLevel()) {
        paramString.printStackTrace();
      }
    }
    a(paramList);
  }
  
  public void a(List<InterestTagInfo> paramList)
  {
    int i1 = this.j.size();
    int i2 = 1;
    if (i1 > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.j.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.j.addAll(paramList);
    }
    if (this.j.size() <= 0) {
      i2 = 0;
    }
    if (i1 != i2)
    {
      a();
      setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
      paramList = this.k.getLayoutParams();
      if ((paramList instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramList).bottomMargin = this.g;
      }
    }
    c();
  }
  
  protected void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SavorTagIcon", 4, "initView");
    }
    removeAllViews();
    this.n = getResources().getDisplayMetrics().density;
    if (this.n < 0.01F) {
      this.n = 1.0F;
    }
    float f1 = this.n;
    this.h = ((int)(f1 * 12.0F));
    this.i = ((int)(f1 * 12.0F));
    this.f = ((int)(f1 * 12.0F));
    this.e = ((int)(f1 * 12.0F));
    a();
    setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
    this.b = 0;
    this.a = "";
    this.j = new ArrayList(2);
    this.c = getResources().getDimensionPixelSize(2131299660);
    this.k = ((TextView)LayoutInflater.from(getContext()).inflate(2131627589, null));
    FrameLayout.LayoutParams localLayoutParams = e();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.topMargin = this.h;
    localLayoutParams.bottomMargin = this.i;
    addView(this.k, localLayoutParams);
  }
  
  protected void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SavorTagIcon", 4, "refreshView");
    }
    int i2 = this.j.size();
    int i1 = getChildCount() - 1;
    Object localObject1;
    if (i1 > i2) {
      while (i1 > i2)
      {
        localObject1 = getChildAt(i1);
        ((View)localObject1).setOnClickListener(null);
        removeView((View)localObject1);
        i1 -= 1;
      }
    }
    Object localObject2;
    if (i1 < i2) {
      while (i1 < i2)
      {
        localObject1 = LayoutInflater.from(getContext()).inflate(2131627585, null);
        localObject2 = e();
        ((ViewGroup.MarginLayoutParams)localObject2).width = -2;
        ((ViewGroup.MarginLayoutParams)localObject2).height = -2;
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = this.f;
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = this.e;
        addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        i1 += 1;
      }
    }
    if (i2 > 0)
    {
      localObject1 = new StringBuilder(this.a);
      ((StringBuilder)localObject1).append('(');
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append(')');
      this.k.setText(((StringBuilder)localObject1).toString());
    }
    else
    {
      this.k.setText(this.a);
    }
    int i3 = this.j.size();
    for (i1 = 0; i1 < i3; i1 = i2)
    {
      i2 = i1 + 1;
      localObject1 = getChildAt(i2);
      if (localObject1 == null)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("refreshView child is null, index = ");
          ((StringBuilder)localObject1).append(String.valueOf(i2));
          QLog.i("SavorTagIcon", 4, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        localObject2 = (InterestTagInfo)this.j.get(i1);
        if (localObject2 == null)
        {
          if (QLog.isDevelopLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("refreshView item is null, index = ");
            ((StringBuilder)localObject1).append(String.valueOf(i1));
            QLog.i("SavorTagIcon", 4, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          String str = ((InterestTagInfo)localObject2).tagName;
          i1 = this.d;
          try
          {
            i1 = Color.parseColor(((InterestTagInfo)localObject2).tagBgColor);
          }
          catch (Exception localException1)
          {
            if (QLog.isDevelopLevel()) {
              localException1.printStackTrace();
            }
            i1 = this.d;
          }
          GradientDrawable localGradientDrawable = new GradientDrawable();
          localGradientDrawable.setColor(i1);
          localGradientDrawable.setCornerRadius(this.c);
          try
          {
            i1 = Color.parseColor(((InterestTagInfo)localObject2).tagTextColor);
          }
          catch (Exception localException2)
          {
            if (QLog.isDevelopLevel()) {
              localException2.printStackTrace();
            }
            i1 = -1;
          }
          TextView localTextView = (TextView)((View)localObject1).findViewById(2131448897);
          if (localTextView != null)
          {
            localTextView.setText(str);
            localTextView.setTextColor(i1);
          }
          ((View)localObject1).setBackgroundDrawable(localGradientDrawable);
          ((View)localObject1).setTag(localObject2);
          if (this.l != null) {
            ((View)localObject1).setOnClickListener(this);
          }
        }
      }
    }
  }
  
  public boolean d()
  {
    Rect localRect = new Rect();
    int i3 = getChildCount();
    int i1 = 0;
    while ((i1 < i3 - 1) && (i3 > 1))
    {
      int i2 = i1 + 1;
      View localView = getChildAt(i2);
      i1 = i2;
      if (localView.getGlobalVisibleRect(localRect))
      {
        double d1 = localRect.bottom - localRect.top;
        double d2 = localView.getMeasuredHeight();
        Double.isNaN(d2);
        i1 = i2;
        if (d1 >= d2 * 0.5D) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String getContentsDesc()
  {
    if ((this.j != null) && (this.a != null))
    {
      StringBuilder localStringBuilder = new StringBuilder(HardCodeUtil.a(2131910978));
      localStringBuilder.append(this.a);
      localStringBuilder.append(this.j.size());
      localStringBuilder.append("个");
      int i1 = 0;
      while (i1 < this.j.size())
      {
        localStringBuilder.append(",");
        localStringBuilder.append(((InterestTagInfo)this.j.get(i1)).tagName);
        i1 += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == null) {
      localObject = null;
    } else {
      localObject = paramView.getTag();
    }
    if ((localObject instanceof InterestTagInfo))
    {
      OnTagClickListener localOnTagClickListener = this.l;
      if (localOnTagClickListener != null) {
        localOnTagClickListener.a(paramView, this.b, (InterestTagInfo)localObject);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((getContext() instanceof NearbyPeopleProfileActivity)) {
      ((NearbyPeopleProfileActivity)getContext()).setInterceptTouchFlag(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setRightArrowVisible(boolean paramBoolean)
  {
    if (paramBoolean == this.m) {
      return;
    }
    this.m = paramBoolean;
    if (this.m)
    {
      this.k.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130839446, 0);
      return;
    }
    this.k.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.k.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.SavorTagIcon
 * JD-Core Version:    0.7.0.1
 */