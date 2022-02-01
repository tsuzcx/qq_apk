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
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;

public class ADView
  extends LinearLayout
{
  protected float a;
  private ADView.WeakHandler jdField_a_of_type_ComTencentMobileqqWidgetADView$WeakHandler = new ADView.WeakHandler(this);
  protected WorkSpaceView a;
  public final String a;
  private boolean jdField_a_of_type_Boolean = false;
  protected LinearLayout b;
  protected boolean e = true;
  protected boolean f = true;
  protected int g = 2130837682;
  protected int h = this.g;
  protected int i = 2;
  protected int j = 0;
  
  public ADView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = null;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaLangString = "ADView";
    a(paramContext);
  }
  
  public ADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = null;
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
    int k = 0;
    for (;;)
    {
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("@newcard TABINDEX ");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append("page");
        ((StringBuilder)localObject1).append(paramInt2);
        QZLog.i("removeFromWorkSpace", ((StringBuilder)localObject1).toString());
        localObject2 = (ViewGroup)this.b.getChildAt(paramInt1);
        localObject1 = (WorkSpaceView)((ViewGroup)localObject2).getChildAt(0);
        ((WorkSpaceView)localObject1).removeViewAt(paramInt2);
        localObject2 = (LinearLayout)((ViewGroup)localObject2).getChildAt(1);
        ((LinearLayout)localObject2).removeViewAt(paramInt2);
        if (((LinearLayout)localObject2).getChildCount() <= 1) {
          break label210;
        }
        paramInt1 = 0;
        ((LinearLayout)localObject2).setVisibility(paramInt1);
        if (paramInt2 > 0)
        {
          ((WorkSpaceView)localObject1).a(paramInt2 - 1);
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        paramInt1 = k;
        if (paramInt1 < this.b.getChildCount() - 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("@newcard ");
          ((StringBuilder)localObject2).append(this.b.getChildAt(paramInt1).getClass());
          QZLog.i("ADView", ((StringBuilder)localObject2).toString());
          paramInt1 += 1;
          continue;
        }
        QZLog.i("ADView", 2, "@newcard  ", localException);
      }
      return;
      label210:
      paramInt1 = 4;
    }
  }
  
  public void a(int paramInt1, int paramInt2, View paramView)
  {
    for (;;)
    {
      try
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)this.b.getChildAt(paramInt1);
        paramInt1 = 0;
        WorkSpaceView localWorkSpaceView = (WorkSpaceView)localRelativeLayout.getChildAt(0);
        localWorkSpaceView.removeView(paramView);
        paramView = (LinearLayout)localRelativeLayout.getChildAt(1);
        paramView.removeViewAt(paramInt2);
        if (paramView.getChildCount() > 1)
        {
          paramView.setVisibility(paramInt1);
          if (paramInt2 > 0) {
            localWorkSpaceView.a(paramInt2 - 1);
          }
          return;
        }
      }
      catch (Exception paramView)
      {
        return;
      }
      paramInt1 = 4;
    }
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
    paramInt = this.b.getChildCount();
    boolean bool = true;
    Object localObject;
    if (paramInt == 0)
    {
      this.b.setPadding(0, 0, 0, 0);
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      localObject = new LinearLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = new WorkSpaceView(getContext());
      setCircle(this.f);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setOnScreenChangeListener(new ADView.1(this, (LinearLayout)localObject));
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.setId(100000);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView, localLayoutParams);
      a((LinearLayout)localObject);
      localRelativeLayout.addView((View)localObject);
      this.b.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -1));
    }
    else
    {
      localObject = (ViewGroup)this.b.getChildAt(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView = ((WorkSpaceView)((ViewGroup)localObject).getChildAt(0));
      localObject = (LinearLayout)((ViewGroup)localObject).getChildAt(1);
      bool = false;
    }
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
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 100000);
    localLayoutParams.addRule(14, 100000);
    localLayoutParams.setMargins(0, 0, 0, (int)(this.jdField_a_of_type_Float * 6.0F));
    paramLinearLayout.setGravity(16);
    paramLinearLayout.setBackgroundResource(2130840589);
    float f1 = this.jdField_a_of_type_Float;
    paramLinearLayout.setPadding((int)(4.0F * f1), 0, (int)(f1 * 2.0F), 0);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  protected void a(LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    ImageView localImageView = new ImageView(getContext());
    int k = this.j;
    LinearLayout.LayoutParams localLayoutParams;
    if (k > 0)
    {
      float f1 = k;
      float f2 = this.jdField_a_of_type_Float;
      localLayoutParams = new LinearLayout.LayoutParams((int)(f1 * f2), (int)(k * f2));
    }
    else
    {
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    }
    int m = (int)(this.i * this.jdField_a_of_type_Float);
    k = 0;
    localLayoutParams.setMargins(0, 0, m, 0);
    localImageView.setLayoutParams(localLayoutParams);
    try
    {
      localImageView.setImageDrawable(getContext().getResources().getDrawable(this.h));
      if (paramBoolean) {
        localImageView.setEnabled(true);
      } else {
        localImageView.setEnabled(false);
      }
    }
    catch (Exception localException)
    {
      label145:
      break label145;
    }
    localImageView.setImageResource(this.g);
    paramLinearLayout.addView(localImageView);
    if (paramLinearLayout.getChildCount() <= 1) {
      k = 4;
    }
    paramLinearLayout.setVisibility(k);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetADView$WeakHandler.removeMessages(0);
    try
    {
      PushBanner localPushBanner = (PushBanner)this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView.a()).getTag();
      k = localPushBanner.a * 1000;
      setContentDescription(localPushBanner.n);
    }
    catch (Exception localException)
    {
      int k;
      label49:
      break label49;
    }
    k = 5000;
    this.jdField_a_of_type_ComTencentMobileqqWidgetADView$WeakHandler.sendEmptyMessageDelayed(0, k);
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetADView$WeakHandler.sendEmptyMessage(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e)
    {
      int k = paramMotionEvent.getAction();
      if (k == 0) {
        getParent().requestDisallowInterceptTouchEvent(true);
      } else if ((k == 1) || (k == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setCircle(boolean paramBoolean)
  {
    WorkSpaceView localWorkSpaceView = this.jdField_a_of_type_ComTencentMobileqqWidgetWorkSpaceView;
    if (localWorkSpaceView != null) {
      localWorkSpaceView.setCircle(paramBoolean);
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