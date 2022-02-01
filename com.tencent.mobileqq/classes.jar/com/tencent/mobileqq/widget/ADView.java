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
  protected int A = 2;
  protected int B = 0;
  protected boolean C = true;
  public final String D = "ADView";
  protected boolean E = true;
  private boolean a = false;
  private ADView.WeakHandler b = new ADView.WeakHandler(this);
  protected int v = 2130837706;
  protected int w = this.v;
  protected LinearLayout x;
  protected WorkSpaceView y = null;
  protected float z = getResources().getDisplayMetrics().density;
  
  public ADView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ADView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
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
        localObject2 = (ViewGroup)this.x.getChildAt(paramInt1);
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
        paramInt1 = i;
        if (paramInt1 < this.x.getChildCount() - 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("@newcard ");
          ((StringBuilder)localObject2).append(this.x.getChildAt(paramInt1).getClass());
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
        RelativeLayout localRelativeLayout = (RelativeLayout)this.x.getChildAt(paramInt1);
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
    this.x = new LinearLayout(paramContext);
    addView(this.x, new LinearLayout.LayoutParams(-1, -1));
    setOrientation(1);
  }
  
  public void a(View paramView, int paramInt)
  {
    paramInt = this.x.getChildCount();
    boolean bool = true;
    Object localObject;
    if (paramInt == 0)
    {
      this.x.setPadding(0, 0, 0, 0);
      RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
      localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      localObject = new LinearLayout(getContext());
      this.y = new WorkSpaceView(getContext());
      setCircle(this.E);
      this.y.setOnScreenChangeListener(new ADView.1(this, (LinearLayout)localObject));
      this.y.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.y.setId(100000);
      localRelativeLayout.addView(this.y, localLayoutParams);
      a((LinearLayout)localObject);
      localRelativeLayout.addView((View)localObject);
      this.x.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -1));
    }
    else
    {
      localObject = (ViewGroup)this.x.getChildAt(0);
      this.y = ((WorkSpaceView)((ViewGroup)localObject).getChildAt(0));
      localObject = (LinearLayout)((ViewGroup)localObject).getChildAt(1);
      bool = false;
    }
    try
    {
      this.y.addView(paramView, this.y.getChildCount());
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
    localLayoutParams.setMargins(0, 0, 0, (int)(this.z * 6.0F));
    paramLinearLayout.setGravity(16);
    paramLinearLayout.setBackgroundResource(2130841361);
    float f = this.z;
    paramLinearLayout.setPadding((int)(4.0F * f), 0, (int)(f * 2.0F), 0);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  protected void a(LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    ImageView localImageView = new ImageView(getContext());
    int i = this.B;
    LinearLayout.LayoutParams localLayoutParams;
    if (i > 0)
    {
      float f1 = i;
      float f2 = this.z;
      localLayoutParams = new LinearLayout.LayoutParams((int)(f1 * f2), (int)(i * f2));
    }
    else
    {
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    }
    int j = (int)(this.A * this.z);
    i = 0;
    localLayoutParams.setMargins(0, 0, j, 0);
    localImageView.setLayoutParams(localLayoutParams);
    try
    {
      localImageView.setImageDrawable(getContext().getResources().getDrawable(this.w));
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
    localImageView.setImageResource(this.v);
    paramLinearLayout.addView(localImageView);
    if (paramLinearLayout.getChildCount() <= 1) {
      i = 4;
    }
    paramLinearLayout.setVisibility(i);
  }
  
  public ViewGroup e(int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.x.getChildAt(paramInt);
    if (localRelativeLayout != null) {
      return (WorkSpaceView)localRelativeLayout.getChildAt(0);
    }
    return null;
  }
  
  public boolean getCircle()
  {
    return this.E;
  }
  
  public boolean getIsCloseADView()
  {
    return this.a;
  }
  
  public void i()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.x.getChildAt(0);
    if (localRelativeLayout == null) {
      return;
    }
    ((WorkSpaceView)localRelativeLayout.getChildAt(0)).removeAllViews();
    this.x.removeAllViews();
  }
  
  public void j()
  {
    this.b.removeMessages(0);
    try
    {
      PushBanner localPushBanner = (PushBanner)this.y.getChildAt(this.y.getCurrentScreen()).getTag();
      i = localPushBanner.d * 1000;
      setContentDescription(localPushBanner.p);
    }
    catch (Exception localException)
    {
      int i;
      label49:
      break label49;
    }
    i = 5000;
    this.b.sendEmptyMessageDelayed(0, i);
  }
  
  public void k()
  {
    this.b.sendEmptyMessage(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.C)
    {
      int i = paramMotionEvent.getAction();
      if (i == 0) {
        getParent().requestDisallowInterceptTouchEvent(true);
      } else if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setCircle(boolean paramBoolean)
  {
    WorkSpaceView localWorkSpaceView = this.y;
    if (localWorkSpaceView != null) {
      localWorkSpaceView.setCircle(paramBoolean);
    }
    this.E = paramBoolean;
  }
  
  public void setIsCloseADView(boolean paramBoolean)
  {
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ADView
 * JD-Core Version:    0.7.0.1
 */