package com.tencent.mobileqq.kandian.biz.channel.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.PageTransformer;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;

public class RollViewPager
  extends ViewPager
{
  private static String g = "BannerAdapter";
  protected int a;
  protected float b;
  protected float c;
  protected float d;
  protected float e;
  protected IBannerAdapter f;
  private int h;
  private float i = 1.0F;
  private float j = 1.0F;
  private RollViewPager.OnTouchStateChangeListener k;
  private RollViewPager.OnUserFling l;
  private ViewPager.PageTransformer m;
  
  public RollViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RollViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RollViewPager);
    this.i = paramAttributeSet.getFloat(1, 1.0F);
    this.j = paramAttributeSet.getFloat(0, 1.0F);
    paramAttributeSet.recycle();
    this.a = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    int i1 = getCurrentItem();
    if (this.m != null)
    {
      int n = paramInt;
      if (paramInt < 0) {
        n = getChildCount();
      }
      this.m.transformPage(paramView, n - i1);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = Math.abs(f1 - this.d);
    float f4 = Math.abs(f2 - this.e);
    int n = paramMotionEvent.getAction();
    boolean bool1 = false;
    boolean bool2 = false;
    if (n != 0)
    {
      if (n != 1) {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n == 261) {
              break label312;
            }
            return false;
          }
        }
        else
        {
          if (this.h <= 1)
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            bool1 = bool2;
          }
          else
          {
            if ((f3 < f4) && (Math.abs(f2 - this.c) > this.a)) {
              getParent().requestDisallowInterceptTouchEvent(false);
            } else {
              getParent().requestDisallowInterceptTouchEvent(true);
            }
            if ((f3 > f4) && (Math.abs(f1 - this.b) > this.a))
            {
              bool1 = super.dispatchTouchEvent(paramMotionEvent);
            }
            else
            {
              requestDisallowInterceptTouchEvent(false);
              bool1 = bool2;
            }
          }
          this.d = f1;
          this.e = f2;
          return bool1;
        }
      }
      requestDisallowInterceptTouchEvent(false);
      bool2 = super.dispatchTouchEvent(paramMotionEvent);
      if ((Math.abs(f1 - this.b) < this.a) && (Math.abs(f2 - this.c) < this.a))
      {
        requestDisallowInterceptTouchEvent(false);
        performClick();
      }
      else
      {
        paramMotionEvent = this.l;
        if (paramMotionEvent != null) {
          paramMotionEvent.d();
        }
        bool1 = bool2;
      }
      paramMotionEvent = this.k;
      bool2 = bool1;
      if (paramMotionEvent == null) {
        break label376;
      }
      paramMotionEvent.a(1);
      return bool1;
    }
    label312:
    this.h = this.f.c();
    requestDisallowInterceptTouchEvent(true);
    this.d = f1;
    this.b = f1;
    this.e = f2;
    this.c = f2;
    RollViewPager.OnTouchStateChangeListener localOnTouchStateChangeListener = this.k;
    if (localOnTouchStateChangeListener != null) {
      localOnTouchStateChangeListener.a(0);
    }
    bool2 = super.dispatchTouchEvent(paramMotionEvent);
    label376:
    return bool2;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      TroopTechReportUtils.a("avatarWallViewPager", "ote_pointerindex_out_of_range", paramMotionEvent.toString(), "", "", "");
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (this.i == 1.0F)
    {
      f1 = this.j;
      if (f1 != 1.0F)
      {
        paramInt2 = (int)(paramInt1 * f1);
        getLayoutParams().height = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        setMeasuredDimension(paramInt1, paramInt2);
        return;
      }
    }
    float f1 = this.i;
    if ((f1 != 1.0F) && (this.j == 1.0F))
    {
      paramInt1 = (int)(paramInt2 * f1);
      getLayoutParams().width = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      setMeasuredDimension(paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      TroopTechReportUtils.a("avatarWallViewPager", "te_pointerindex_out_of_range", paramMotionEvent.toString(), "", "", "");
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    super.setAdapter(paramPagerAdapter);
    this.f = ((IBannerAdapter)paramPagerAdapter);
  }
  
  public void setOnTouchStateChangeListener(RollViewPager.OnTouchStateChangeListener paramOnTouchStateChangeListener)
  {
    this.k = paramOnTouchStateChangeListener;
  }
  
  public void setOnUserFling(RollViewPager.OnUserFling paramOnUserFling)
  {
    this.l = paramOnUserFling;
  }
  
  public void setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    this.m = paramPageTransformer;
    super.setPageTransformer(paramBoolean, paramPageTransformer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.RollViewPager
 * JD-Core Version:    0.7.0.1
 */