package com.tencent.mobileqq.troop.widget;

import ajrx;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;

public class AvatarWallViewPager
  extends RelativeLayout
{
  protected float a;
  protected int a;
  protected Context a;
  protected Drawable a;
  public Handler a;
  protected ViewPager.SimpleOnPageChangeListener a;
  public View a;
  protected LinearLayout.LayoutParams a;
  protected LinearLayout a;
  public AvatarWallViewPager.RollViewPager a;
  public AvatarWallViewPagerAdapter a;
  protected boolean a;
  protected View[] a;
  protected float b;
  protected int b;
  protected Drawable b;
  private boolean b;
  protected float c;
  public int c = 4000;
  protected float d;
  public int d;
  
  public AvatarWallViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AvatarWallViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 500;
    this.jdField_a_of_type_AndroidOsHandler = new ajrx(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  protected View a()
  {
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams == null)
    {
      int i = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 6.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(i, i);
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = TroopUtils.a(getResources(), Color.parseColor("#80ffffff"), getResources().getDrawable(2130841314));
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = TroopUtils.a(getResources(), Color.parseColor("#ffffffff"), getResources().getDrawable(2130841314));
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
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    d();
    addView(this.jdField_a_of_type_AndroidViewView, new RelativeLayout.LayoutParams(-1, -1));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    localLayoutParams.rightMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
    localLayoutParams.bottomMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 11.0F);
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
    if (j == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarWallViewPager", 2, "startRoll error, the count of avatars is 0...");
      }
    }
    for (;;)
    {
      return;
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
        this.d = 1;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager$RollViewPager.setCurrentItem(this.d, false);
        e();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("AvatarWallViewPager", 2, "startRoll is called successfully");
        return;
        f();
      }
    }
  }
  
  public void c()
  {
    f();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#33000000"));
    }
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(), this.c);
  }
  
  protected void f()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
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
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener = paramSimpleOnPageChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPager
 * JD-Core Version:    0.7.0.1
 */