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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;

public class AvatarWallViewPager
  extends RelativeLayout
{
  protected float a;
  protected int a;
  protected Context a;
  protected Drawable a;
  protected Handler a;
  protected LinearLayout.LayoutParams a;
  protected LinearLayout a;
  protected AvatarWallPagerAdapter a;
  protected AvatarWallViewPager.RollViewPager a;
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
  protected int d;
  protected boolean d;
  protected int e = this.jdField_c_of_type_Int;
  protected int f;
  
  public AvatarWallViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AvatarWallViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 500;
    this.jdField_c_of_type_Int = 4000;
    this.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new AvatarWallViewPager.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  protected View a(boolean paramBoolean)
  {
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams == null)
    {
      int i = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(i, i);
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
      ((LinearLayout.LayoutParams)localObject).leftMargin = i;
      ((LinearLayout.LayoutParams)localObject).rightMargin = i;
    }
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = BizTroopUtil.a(getResources(), Color.parseColor("#CC12B7F5"), getResources().getDrawable(2130843874));
      }
    }
    else if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BizTroopUtil.a(getResources(), Color.parseColor("#66FFFFFF"), getResources().getDrawable(2130843874));
    }
    localView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    if (paramBoolean) {
      localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    } else {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    localView.setBackgroundDrawable((Drawable)localObject);
    return localView;
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
    localLayoutParams.bottomMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    return localLayoutParams;
  }
  
  protected AvatarWallViewPager.RollViewPager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollViewPager;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a() <= 1) {
        return;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
        localHandler.sendMessageDelayed(localHandler.obtainMessage(), this.e);
      }
    }
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
    new AvatarWallViewPager.RollScroller(this, this.jdField_a_of_type_AndroidContentContext, new LinearInterpolator()).a();
  }
  
  protected void d()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (i > 1)
    {
      int j = i - 2;
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[j];
      i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView;
        boolean bool;
        if (i == 0) {
          bool = true;
        } else {
          bool = false;
        }
        localObject[i] = a(bool, i);
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        if (i == 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((LinearLayout)localObject).addView(a(bool, i));
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager$RollerChangeListener.jdField_a_of_type_Int = 0;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallPagerAdapter;
    if (localObject != null)
    {
      ((AvatarWallPagerAdapter)localObject).a();
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
      new AvatarWallViewPager.RollScroller(this, this.jdField_a_of_type_AndroidContentContext, paramInterpolator).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager
 * JD-Core Version:    0.7.0.1
 */