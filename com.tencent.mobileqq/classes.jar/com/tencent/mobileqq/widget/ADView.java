package com.tencent.mobileqq.widget;

import alac;
import alad;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.qphone.base.util.QLog;

public class ADView
  extends LinearLayout
{
  protected float a;
  private alad jdField_a_of_type_Alad = new alad(this);
  public WorkSpaceView a;
  private boolean jdField_a_of_type_Boolean;
  protected LinearLayout b;
  protected boolean e = true;
  public int f;
  public boolean f;
  public int g = this.jdField_f_of_type_Int;
  protected int h = 2;
  protected int i;
  
  public ADView(Context paramContext)
  {
    super(paramContext);
    this.jdField_f_of_type_Int = 2130837545;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_f_of_type_Boolean = true;
    a(paramContext);
  }
  
  public ADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_f_of_type_Int = 2130837545;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_f_of_type_Boolean = true;
    a(paramContext);
  }
  
  public ViewGroup a(int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.b.getChildAt(paramInt);
    if (localRelativeLayout != null) {
      return (WorkSpaceView)localRelativeLayout.getChildAt(0);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = 0;
    LinearLayout localLinearLayout = (LinearLayout)this.b.getChildAt(paramInt1);
    WorkSpaceView localWorkSpaceView = (WorkSpaceView)localLinearLayout.getChildAt(0);
    localWorkSpaceView.removeViewAt(paramInt2);
    localLinearLayout = (LinearLayout)localLinearLayout.getChildAt(1);
    localLinearLayout.removeViewAt(paramInt2);
    if (localLinearLayout.getChildCount() > 1) {}
    for (paramInt1 = j;; paramInt1 = 4)
    {
      localLinearLayout.setVisibility(paramInt1);
      if (paramInt2 > 0) {
        localWorkSpaceView.a(paramInt2 - 1);
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, View paramView)
  {
    int j = 0;
    try
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.b.getChildAt(paramInt1);
      WorkSpaceView localWorkSpaceView = (WorkSpaceView)localRelativeLayout.getChildAt(0);
      localWorkSpaceView.removeView(paramView);
      paramView = (LinearLayout)localRelativeLayout.getChildAt(1);
      paramView.removeViewAt(paramInt2);
      if (paramView.getChildCount() > 1) {}
      for (paramInt1 = j;; paramInt1 = 4)
      {
        paramView.setVisibility(paramInt1);
        if (paramInt2 > 0) {
          localWorkSpaceView.a(paramInt2 - 1);
        }
        return;
      }
      return;
    }
    catch (Exception paramView) {}
  }
  
  public void a(Context paramContext)
  {
    setPadding(0, 0, 0, 0);
    this.b = new LinearLayout(paramContext);
    addView(this.b, new LinearLayout.LayoutParams(-1, -1));
    setOrientation(1);
  }
  
  public void a(View paramView, int paramInt)
  {
    Object localObject;
    if (this.b.getChildCount() == 0)
    {
      this.b.setPadding(0, 0, 0, 0);
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      localObject = new LinearLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = new WorkSpaceView(getContext());
      setCircle(this.jdField_f_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setOnScreenChangeListener(new alac(this, (LinearLayout)localObject));
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setId(100000);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView, localLayoutParams);
      a((LinearLayout)localObject);
      localRelativeLayout.addView((View)localObject);
      this.b.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -1));
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.addView(paramView, this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildCount());
        a((LinearLayout)localObject, bool);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent.banner", 4, "addViewToWorkspace");
        }
        return;
      }
      catch (Exception paramView) {}
      localObject = (ViewGroup)this.b.getChildAt(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = ((WorkSpaceView)((ViewGroup)localObject).getChildAt(0));
      localObject = (LinearLayout)((ViewGroup)localObject).getChildAt(1);
    }
  }
  
  public void a(LinearLayout paramLinearLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 100000);
    localLayoutParams.addRule(14, 100000);
    localLayoutParams.setMargins(0, 0, 0, (int)(6.0F * this.jdField_a_of_type_Float));
    paramLinearLayout.setGravity(16);
    paramLinearLayout.setBackgroundResource(2130839305);
    paramLinearLayout.setPadding((int)(4.0F * this.jdField_a_of_type_Float), 0, (int)(2.0F * this.jdField_a_of_type_Float), 0);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  protected void a(LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    localImageView = new ImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams;
    if (this.i > 0)
    {
      localLayoutParams = new LinearLayout.LayoutParams((int)(this.i * this.jdField_a_of_type_Float), (int)(this.i * this.jdField_a_of_type_Float));
      localLayoutParams.setMargins(0, 0, (int)(this.h * this.jdField_a_of_type_Float), 0);
      localImageView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      try
      {
        localImageView.setImageDrawable(getContext().getResources().getDrawable(this.g));
        if (!paramBoolean) {
          continue;
        }
        localImageView.setEnabled(true);
      }
      catch (Exception localException)
      {
        localImageView.setImageResource(this.jdField_f_of_type_Int);
        continue;
        int j = 4;
        continue;
      }
      paramLinearLayout.addView(localImageView);
      if (paramLinearLayout.getChildCount() <= 1) {
        continue;
      }
      j = 0;
      paramLinearLayout.setVisibility(j);
      return;
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      break;
      localImageView.setEnabled(false);
    }
  }
  
  public boolean b()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void h()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.b.getChildAt(0);
    if (localRelativeLayout == null) {
      return;
    }
    ((WorkSpaceView)localRelativeLayout.getChildAt(0)).removeAllViews();
    this.b.removeAllViews();
  }
  
  public void i()
  {
    this.jdField_a_of_type_Alad.removeMessages(0);
    try
    {
      PushBanner localPushBanner = (PushBanner)this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a()).getTag();
      j = localPushBanner.a;
      setContentDescription(localPushBanner.n);
      j *= 1000;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j = 5000;
      }
    }
    this.jdField_a_of_type_Alad.sendEmptyMessageDelayed(0, j);
  }
  
  public void j()
  {
    this.jdField_a_of_type_Alad.sendEmptyMessage(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int j;
    if (this.e)
    {
      j = paramMotionEvent.getAction();
      if (j != 0) {
        break label32;
      }
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label32:
      if ((j == 1) || (j == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setCircle(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setCircle(paramBoolean);
    }
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setIsCloseADView(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ADView
 * JD-Core Version:    0.7.0.1
 */