package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import ayts;
import aytt;
import bguq;
import zps;

public class AvatarWallViewPager
  extends RelativeLayout
{
  protected float a;
  protected int a;
  protected Context a;
  protected Drawable a;
  public Handler a;
  protected LinearLayout.LayoutParams a;
  protected LinearLayout a;
  public AvatarWallPagerAdapter a;
  public AvatarWallViewPager.RollViewPager a;
  protected AvatarWallViewPager.RollerChangeListener a;
  protected boolean a;
  protected View[] a;
  protected float b;
  protected int b;
  protected Drawable b;
  protected boolean b;
  protected float c;
  protected int c;
  protected boolean c;
  protected float d;
  public int d = this.jdField_b_of_type_Int;
  protected boolean d;
  public int e = this.jdField_c_of_type_Int;
  public int f;
  
  public AvatarWallViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AvatarWallViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 500;
    this.jdField_c_of_type_Int = 4000;
    this.jdField_a_of_type_AndroidOsHandler = new ayts(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  protected View a(boolean paramBoolean)
  {
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams == null)
    {
      int i = zps.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(i, i);
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = i;
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.rightMargin = i;
    }
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = bguq.a(getResources(), Color.parseColor("#CC12B7F5"), getResources().getDrawable(2130843683));
      }
      localView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
      if (!paramBoolean) {
        break label157;
      }
    }
    label157:
    for (Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;; localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
    {
      localView.setBackgroundDrawable(localDrawable);
      return localView;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bguq.a(getResources(), Color.parseColor("#66FFFFFF"), getResources().getDrawable(2130843683));
      break;
    }
  }
  
  protected View a(boolean paramBoolean, int paramInt)
  {
    View localView2 = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a(paramBoolean, paramInt);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = a(paramBoolean);
    }
    return localView1;
  }
  
  protected LinearLayout a()
  {
    return new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
  }
  
  protected RelativeLayout.LayoutParams a()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = zps.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    return localLayoutParams;
  }
  
  protected AvatarWallViewPager.RollViewPager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a() <= 1)) {}
    while (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(), this.e);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Int = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop();
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager = new AvatarWallViewPager.RollViewPager(this, this.jdField_a_of_type_AndroidContentContext);
    addView(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager, new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(getResources().getColor(17170445));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(17);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, a());
    AvatarWallViewPager.RollViewPager localRollViewPager = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager;
    AvatarWallViewPager.RollerChangeListener localRollerChangeListener = new AvatarWallViewPager.RollerChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollerChangeListener = localRollerChangeListener;
    localRollViewPager.setOnPageChangeListener(localRollerChangeListener);
    new aytt(this, this.jdField_a_of_type_AndroidContentContext, new LinearInterpolator()).a();
  }
  
  protected void d()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (j > 1)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[j - 2];
      int i = 0;
      if (i < j - 2)
      {
        Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView;
        if (i == 0)
        {
          bool = true;
          label51:
          localObject[i] = a(bool, i);
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if (i != 0) {
            break label96;
          }
        }
        label96:
        for (boolean bool = true;; bool = false)
        {
          ((LinearLayout)localObject).addView(a(bool, i));
          i += 1;
          break;
          bool = false;
          break label51;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollerChangeListener.jdField_a_of_type_Int = 0;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter = null;
    }
  }
  
  public void setAdapter(AvatarWallPagerAdapter paramAvatarWallPagerAdapter)
  {
    if (paramAvatarWallPagerAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter = paramAvatarWallPagerAdapter;
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager.setAdapter(paramAvatarWallPagerAdapter.a());
      d();
    }
  }
  
  public void setDotLayoutParams(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramLayoutParams);
    }
  }
  
  public void setScrollInterpolator(Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {
      new aytt(this, this.jdField_a_of_type_AndroidContentContext, paramInterpolator).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager
 * JD-Core Version:    0.7.0.1
 */