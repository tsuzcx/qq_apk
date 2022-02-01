package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;

class TabLayoutCompat$TabView
  extends LinearLayout
{
  private TabLayoutCompat.Tab b;
  private TextView c;
  private ImageView d;
  private View e;
  private TextView f;
  private ImageView g;
  private int h = 2;
  
  public TabLayoutCompat$TabView(TabLayoutCompat paramTabLayoutCompat, Context paramContext)
  {
    super(paramContext);
    if (paramTabLayoutCompat.i != 0) {
      setBackgroundDrawable(paramContext.getResources().getDrawable(paramTabLayoutCompat.i));
    }
    ViewCompat.setPaddingRelative(this, paramTabLayoutCompat.a, paramTabLayoutCompat.b, paramTabLayoutCompat.c, paramTabLayoutCompat.d);
    setGravity(17);
    setOrientation(1);
    setClickable(true);
  }
  
  private float a(Layout paramLayout, int paramInt, float paramFloat)
  {
    return paramLayout.getLineWidth(paramInt) * (paramFloat / paramLayout.getPaint().getTextSize());
  }
  
  private void a(@Nullable TextView paramTextView, @Nullable ImageView paramImageView)
  {
    Object localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((TabLayoutCompat.Tab)localObject1).c();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.b;
    if (localObject2 != null) {
      localObject2 = ((TabLayoutCompat.Tab)localObject2).e();
    } else {
      localObject2 = null;
    }
    Object localObject3 = this.b;
    if (localObject3 != null) {
      localObject3 = ((TabLayoutCompat.Tab)localObject3).i();
    } else {
      localObject3 = null;
    }
    int j = 0;
    if (paramImageView != null)
    {
      if (localObject1 != null)
      {
        paramImageView.setImageDrawable((Drawable)localObject1);
        paramImageView.setVisibility(0);
        setVisibility(0);
      }
      else
      {
        paramImageView.setVisibility(8);
        paramImageView.setImageDrawable(null);
      }
      paramImageView.setContentDescription((CharSequence)localObject3);
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2) ^ true;
    if (paramTextView != null)
    {
      if (bool)
      {
        paramTextView.setText((CharSequence)localObject2);
        paramTextView.setVisibility(0);
        setVisibility(0);
      }
      else
      {
        paramTextView.setVisibility(8);
        paramTextView.setText(null);
      }
      paramTextView.setContentDescription((CharSequence)localObject3);
    }
    if (paramImageView != null)
    {
      paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
      int i = j;
      if (bool)
      {
        i = j;
        if (paramImageView.getVisibility() == 0) {
          i = this.a.c(8);
        }
      }
      if (i != paramTextView.bottomMargin)
      {
        paramTextView.bottomMargin = i;
        paramImageView.requestLayout();
      }
    }
  }
  
  void a()
  {
    a(null);
    setSelected(false);
  }
  
  void a(@Nullable TabLayoutCompat.Tab paramTab)
  {
    if (paramTab != this.b)
    {
      this.b = paramTab;
      b();
    }
  }
  
  final void b()
  {
    TabLayoutCompat.Tab localTab = this.b;
    if (localTab != null) {
      localObject1 = localTab.b();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      Object localObject2 = ((View)localObject1).getParent();
      if (localObject2 != this)
      {
        if (localObject2 != null) {
          ((ViewGroup)localObject2).removeView((View)localObject1);
        }
        addView((View)localObject1);
      }
      this.e = ((View)localObject1);
      localObject2 = this.c;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = this.d;
      if (localObject2 != null)
      {
        ((ImageView)localObject2).setVisibility(8);
        this.d.setImageDrawable(null);
      }
      this.f = ((TextView)((View)localObject1).findViewById(16908308));
      if (this.f != null) {
        if (Build.VERSION.SDK_INT >= 16) {
          this.h = this.f.getMaxLines();
        } else {
          this.h = -1;
        }
      }
      this.g = ((ImageView)((View)localObject1).findViewById(16908294));
    }
    else
    {
      localObject1 = this.e;
      if (localObject1 != null)
      {
        removeView((View)localObject1);
        this.e = null;
      }
      this.f = null;
      this.g = null;
    }
    Object localObject1 = this.e;
    boolean bool = true;
    if (localObject1 == null)
    {
      if (this.d == null)
      {
        localObject1 = new ImageView(getContext());
        ((ImageView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(48, 48));
        addView((View)localObject1, 0);
        this.d = ((ImageView)localObject1);
      }
      if (this.c == null)
      {
        localObject1 = new TextView(getContext());
        ((TextView)localObject1).setMaxLines(2);
        ((TextView)localObject1).setGravity(1);
        ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView((View)localObject1);
        this.c = ((TextView)localObject1);
        if (Build.VERSION.SDK_INT >= 16) {
          this.h = this.c.getMaxLines();
        } else {
          this.h = -1;
        }
      }
      localObject1 = this.c;
      ((TextView)localObject1).setTextAppearance(((TextView)localObject1).getContext(), this.a.e);
      if (this.a.f != null) {
        this.c.setTextColor(this.a.f);
      }
      a(this.c, this.d);
    }
    else
    {
      if ((TabLayoutCompat.c(this.a)) && (this.a.f != null))
      {
        localObject1 = this.f;
        if (localObject1 != null)
        {
          ((TextView)localObject1).setTextAppearance(((TextView)localObject1).getContext(), this.a.e);
          this.f.setTextColor(this.a.f);
        }
      }
      if ((this.f != null) || (this.g != null)) {
        a(this.f, this.g);
      }
    }
    if ((localTab == null) || (!localTab.h())) {
      bool = false;
    }
    setSelected(bool);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = this.a.getTabMaxWidth();
    int i = paramInt1;
    if (m > 0) {
      if (k != 0)
      {
        i = paramInt1;
        if (j <= m) {}
      }
      else
      {
        i = View.MeasureSpec.makeMeasureSpec(this.a.j, -2147483648);
      }
    }
    super.onMeasure(i, paramInt2);
    if (this.c != null)
    {
      getResources();
      float f2 = this.a.g;
      j = this.h;
      Object localObject = this.d;
      k = 1;
      float f1;
      if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
      {
        paramInt1 = 1;
        f1 = f2;
      }
      else
      {
        localObject = this.c;
        f1 = f2;
        paramInt1 = j;
        if (localObject != null)
        {
          f1 = f2;
          paramInt1 = j;
          if (((TextView)localObject).getLineCount() > 1)
          {
            f1 = this.a.h;
            paramInt1 = j;
          }
        }
      }
      f2 = this.c.getTextSize();
      m = this.c.getLineCount();
      if (Build.VERSION.SDK_INT >= 16) {
        j = this.c.getMaxLines();
      } else {
        j = -1;
      }
      if ((f1 != f2) || ((j >= 0) && (paramInt1 != j)))
      {
        j = k;
        if (this.a.l == 1)
        {
          j = k;
          if (f1 > f2)
          {
            j = k;
            if (m == 1)
            {
              localObject = this.c.getLayout();
              if (localObject != null)
              {
                j = k;
                if (a((Layout)localObject, 0, f1) <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) {}
              }
              else
              {
                j = 0;
              }
            }
          }
        }
        if (j != 0)
        {
          this.c.setTextSize(0, f1);
          this.c.setMaxLines(paramInt1);
          super.onMeasure(i, paramInt2);
        }
      }
    }
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    if (this.b != null)
    {
      int i = 0;
      if (!bool) {
        playSoundEffect(0);
      }
      TabLayoutCompat.Tab localTab = TabLayoutCompat.a(this.a);
      if (TabLayoutCompat.a(this.a) == this.b) {
        i = 1;
      }
      this.b.f();
      if ((TabLayoutCompat.b(this.a) != null) && (i == 0)) {
        TabLayoutCompat.b(this.a).a(this.b, localTab, 1);
      }
      return true;
    }
    return bool;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    int i;
    if (isSelected() != paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    super.setSelected(paramBoolean);
    if ((i != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16)) {
      sendAccessibilityEvent(4);
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((TextView)localObject).setSelected(paramBoolean);
    }
    localObject = this.d;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(paramBoolean);
    }
    localObject = this.e;
    if (localObject != null) {
      ((View)localObject).setSelected(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabLayoutCompat.TabView
 * JD-Core Version:    0.7.0.1
 */