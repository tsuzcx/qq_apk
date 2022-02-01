package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

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
  protected ViewPager.SimpleOnPageChangeListener a;
  protected AvatarWallViewPager.RollViewPager a;
  protected AvatarWallViewPagerAdapter a;
  protected boolean a;
  protected View[] a;
  protected float b;
  protected int b;
  protected Drawable b;
  protected boolean b;
  protected float c;
  private boolean c = true;
  protected float d;
  private boolean d = false;
  
  public AvatarWallViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AvatarWallViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new AvatarWallViewPager.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  protected View a()
  {
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams == null)
    {
      int i = ViewUtils.a(6.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(i, i);
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = ViewUtils.a(7.0F);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BizTroopUtil.a(getResources(), Color.parseColor("#80ffffff"), getResources().getDrawable(2130843874));
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = BizTroopUtil.a(getResources(), Color.parseColor("#ffffffff"), getResources().getDrawable(2130843874));
      if (ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.waitAppRuntime(null)))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      }
    }
    localView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    localView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    return localView;
  }
  
  protected LinearLayout a()
  {
    return new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Int = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager = new AvatarWallViewPager.RollViewPager(this, this.jdField_a_of_type_AndroidContentContext);
    addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager, new RelativeLayout.LayoutParams(-1, -1));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    localLayoutParams.rightMargin = ViewUtils.a(13.0F);
    localLayoutParams.bottomMargin = ViewUtils.a(10.0F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(getResources().getColor(17170445));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(5);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.setOnPageChangeListener(new AvatarWallViewPager.RollerChangeListener(this));
    new AvatarWallViewPager.RollScroller(this, this.jdField_a_of_type_AndroidContentContext, new LinearInterpolator()).a();
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a();
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarWallViewPager", 2, "startRoll error, the count of avatars is 0...");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (j > 1)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[j];
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i] = a();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ArrayOfAndroidViewView[i]);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[0].setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.setCurrentItem(this.jdField_b_of_type_Int, false);
      d();
    }
    else
    {
      e();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarWallViewPager", 2, "startRoll is called successfully");
    }
  }
  
  public void c()
  {
    e();
  }
  
  protected void d()
  {
    this.c = false;
    if (this.d)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(), 4000L);
    }
  }
  
  protected void e()
  {
    this.c = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.d = true;
    if (!this.c)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(), 4000L);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.d = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void setAdapter(AvatarWallViewPagerAdapter paramAvatarWallViewPagerAdapter)
  {
    if (paramAvatarWallViewPagerAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter = paramAvatarWallViewPagerAdapter;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.setAdapter(paramAvatarWallViewPagerAdapter);
    }
  }
  
  public void setOnPageChangeListener(ViewPager.SimpleOnPageChangeListener paramSimpleOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener = paramSimpleOnPageChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPager
 * JD-Core Version:    0.7.0.1
 */