package com.tencent.mobileqq.widget;

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
import azum;
import bemw;
import bemx;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;

public class ADView
  extends LinearLayout
{
  protected float a;
  private bemx jdField_a_of_type_Bemx = new bemx(this);
  public WorkSpaceView a;
  public final String a;
  private boolean jdField_a_of_type_Boolean;
  protected LinearLayout b;
  protected boolean e = true;
  public boolean f = true;
  protected int g = 2130837578;
  protected int h = this.g;
  protected int i = 2;
  protected int j;
  
  public ADView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaLangString = "ADView";
    a(paramContext);
  }
  
  public ADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaLangString = "ADView";
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
    try
    {
      QZLog.i("removeFromWorkSpace", "@newcard TABINDEX " + paramInt1 + "page" + paramInt2);
      Object localObject = (ViewGroup)this.b.getChildAt(paramInt1);
      WorkSpaceView localWorkSpaceView = (WorkSpaceView)((ViewGroup)localObject).getChildAt(0);
      localWorkSpaceView.removeViewAt(paramInt2);
      localObject = (LinearLayout)((ViewGroup)localObject).getChildAt(1);
      ((LinearLayout)localObject).removeViewAt(paramInt2);
      if (((LinearLayout)localObject).getChildCount() > 1) {}
      for (paramInt1 = 0;; paramInt1 = 4)
      {
        ((LinearLayout)localObject).setVisibility(paramInt1);
        if (paramInt2 > 0) {
          localWorkSpaceView.a(paramInt2 - 1);
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      paramInt1 = 0;
      while (paramInt1 < this.b.getChildCount() - 1)
      {
        QZLog.i("ADView", "@newcard " + this.b.getChildAt(paramInt1).getClass());
        paramInt1 += 1;
      }
      QZLog.i("ADView", 2, "@newcard  ", localException);
    }
  }
  
  public void a(int paramInt1, int paramInt2, View paramView)
  {
    int k = 0;
    try
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.b.getChildAt(paramInt1);
      WorkSpaceView localWorkSpaceView = (WorkSpaceView)localRelativeLayout.getChildAt(0);
      localWorkSpaceView.removeView(paramView);
      paramView = (LinearLayout)localRelativeLayout.getChildAt(1);
      paramView.removeViewAt(paramInt2);
      if (paramView.getChildCount() > 1) {}
      for (paramInt1 = k;; paramInt1 = 4)
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
  
  protected void a(Context paramContext)
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
      setCircle(this.f);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setOnScreenChangeListener(new bemw(this, (LinearLayout)localObject));
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
  
  protected void a(LinearLayout paramLinearLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 100000);
    localLayoutParams.addRule(14, 100000);
    localLayoutParams.setMargins(0, 0, 0, (int)(6.0F * this.jdField_a_of_type_Float));
    paramLinearLayout.setGravity(16);
    paramLinearLayout.setBackgroundResource(2130840320);
    paramLinearLayout.setPadding((int)(4.0F * this.jdField_a_of_type_Float), 0, (int)(2.0F * this.jdField_a_of_type_Float), 0);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  protected void a(LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    localImageView = new ImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams;
    if (this.j > 0)
    {
      localLayoutParams = new LinearLayout.LayoutParams((int)(this.j * this.jdField_a_of_type_Float), (int)(this.j * this.jdField_a_of_type_Float));
      localLayoutParams.setMargins(0, 0, (int)(this.i * this.jdField_a_of_type_Float), 0);
      localImageView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      try
      {
        localImageView.setImageDrawable(getContext().getResources().getDrawable(this.h));
        if (!paramBoolean) {
          continue;
        }
        localImageView.setEnabled(true);
      }
      catch (Exception localException)
      {
        localImageView.setImageResource(this.g);
        continue;
        int k = 4;
        continue;
      }
      paramLinearLayout.addView(localImageView);
      if (paramLinearLayout.getChildCount() <= 1) {
        continue;
      }
      k = 0;
      paramLinearLayout.setVisibility(k);
      return;
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      break;
      localImageView.setEnabled(false);
    }
  }
  
  public boolean c()
  {
    return this.f;
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
    this.jdField_a_of_type_Bemx.removeMessages(0);
    try
    {
      azum localazum = (azum)this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a()).getTag();
      k = localazum.a;
      setContentDescription(localazum.n);
      k *= 1000;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int k = 5000;
      }
    }
    this.jdField_a_of_type_Bemx.sendEmptyMessageDelayed(0, k);
  }
  
  public void j()
  {
    this.jdField_a_of_type_Bemx.sendEmptyMessage(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int k;
    if (this.e)
    {
      k = paramMotionEvent.getAction();
      if (k != 0) {
        break label32;
      }
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label32:
      if ((k == 1) || (k == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setCircle(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setCircle(paramBoolean);
    }
    this.f = paramBoolean;
  }
  
  public void setIsCloseADView(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ADView
 * JD-Core Version:    0.7.0.1
 */