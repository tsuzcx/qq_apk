package com.tencent.mobileqq.kandian.biz.video.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;

public class ReadInJoyPullToZoomListView
  extends ReadInJoyBaseListView
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new ReadInJoyPullToZoomListView.1();
  private static boolean e = false;
  float jdField_a_of_type_Float = -1.0F;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ReadInJoyPullToZoomListView.OnTopCallback jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyPullToZoomListView$OnTopCallback;
  private ReadInJoyPullToZoomListView.ScalingRunnalable jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyPullToZoomListView$ScalingRunnalable;
  float jdField_b_of_type_Float = -1.0F;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  float jdField_c_of_type_Float = 1.401F;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  float jdField_d_of_type_Float = 1.235F;
  boolean jdField_d_of_type_Boolean;
  protected int e;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int g;
  
  public ReadInJoyPullToZoomListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyPullToZoomListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_e_of_type_Int = 0;
  }
  
  public ReadInJoyPullToZoomListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_e_of_type_Int = 0;
  }
  
  private void a(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, localLayoutParams);
    }
    c();
    d();
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null)
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setTextColor(-1);
      localTextView.setText(HardCodeUtil.a(2131713048));
      localTextView.setGravity(17);
      localTextView.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = DisplayUtil.a(getContext(), 52.0F);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localTextView, localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetTextView = localTextView;
    }
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setTextColor(1728053247);
      localTextView.setTextSize(1, 12.0F);
      localTextView.setGravity(17);
      localTextView.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = DisplayUtil.a(getContext(), 58.0F);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localTextView, localLayoutParams);
      this.jdField_c_of_type_AndroidWidgetTextView = localTextView;
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if ((localObject != null) && (this.jdField_a_of_type_AndroidViewView != null) && (((FrameLayout)localObject).getBottom() > 0) && (this.jdField_a_of_type_AndroidViewView.getBottom() > 0))
    {
      int i = this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom();
      int j = this.jdField_a_of_type_AndroidViewView.getBottom();
      boolean bool;
      if (i <= j) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool != this.jdField_f_of_type_Boolean)
      {
        this.jdField_f_of_type_Boolean = bool;
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyPullToZoomListView$OnTopCallback;
        if (localObject != null)
        {
          ((ReadInJoyPullToZoomListView.OnTopCallback)localObject).a(this.jdField_f_of_type_Boolean);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("checkIsTopFixed(): mFixed=");
            ((StringBuilder)localObject).append(this.jdField_f_of_type_Boolean);
            QLog.i("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      if ((QLog.isColorLevel()) && (jdField_e_of_type_Boolean))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkIsTopFixed(): titleBarBottom=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("， headerBottom=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("， fixed = ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", mTopFixed=");
        ((StringBuilder)localObject).append(this.jdField_f_of_type_Boolean);
        QLog.d("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void f()
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 8))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = getResources().getDrawable(2130839404);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      ((Animatable)localObject).start();
    }
  }
  
  private void g()
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void h()
  {
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void j()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      b(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyPullToZoomListView$ScalingRunnalable.a(300L);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyPullToZoomListView$ScalingRunnalable = new ReadInJoyPullToZoomListView.ScalingRunnalable(this);
  }
  
  public void addHeaderView(View paramView)
  {
    a(paramView);
    super.addHeaderView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    a(paramView);
    super.addHeaderView(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramObject, paramBoolean);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    e();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    e();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            this.jdField_a_of_type_Float = paramMotionEvent.getY();
            if ((QLog.isColorLevel()) && (jdField_e_of_type_Boolean)) {
              QLog.w("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_CANCEL xxxx");
            }
          }
        }
        else
        {
          this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY() - this.jdField_e_of_type_Int);
          if (this.jdField_a_of_type_Float == -1.0F) {
            this.jdField_a_of_type_Float = paramMotionEvent.getY();
          }
          if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() >= this.jdField_f_of_type_Int)
          {
            localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
            float f1 = paramMotionEvent.getY();
            float f2 = this.jdField_a_of_type_Float;
            float f3 = this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom();
            i = this.jdField_f_of_type_Int;
            f2 = (f1 - f2 + f3) / i;
            f1 = this.jdField_b_of_type_Float;
            f2 = (f2 - f1) / 2.0F + f1;
            if ((f1 <= 1.0D) && (f2 < f1))
            {
              ((ViewGroup.LayoutParams)localObject).height = i;
              this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
              return super.onTouchEvent(paramMotionEvent);
            }
            this.jdField_b_of_type_Float = Math.min(Math.max(f2, 1.0F), this.jdField_c_of_type_Float);
            ((ViewGroup.LayoutParams)localObject).height = ((int)(this.jdField_f_of_type_Int * this.jdField_b_of_type_Float));
            if (((ViewGroup.LayoutParams)localObject).height <= this.g) {
              this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            if (this.jdField_b_of_type_Float >= this.jdField_d_of_type_Float)
            {
              f();
              this.jdField_d_of_type_Boolean = true;
            }
            else
            {
              g();
              this.jdField_d_of_type_Boolean = false;
            }
            if ((QLog.isColorLevel()) && (jdField_e_of_type_Boolean))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("onTouchEvent(): ACTION_MOVE, f = ");
              ((StringBuilder)localObject).append(f2);
              ((StringBuilder)localObject).append(", mLastScale=");
              ((StringBuilder)localObject).append(this.jdField_b_of_type_Float);
              ((StringBuilder)localObject).append(", mEnterRefreshDefer=");
              ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
              QLog.d("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
            }
            this.jdField_a_of_type_Float = paramMotionEvent.getY();
            return true;
          }
          this.jdField_a_of_type_Float = paramMotionEvent.getY();
        }
      }
      else
      {
        if ((QLog.isColorLevel()) && (jdField_e_of_type_Boolean))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onTouchEvent(): ACTION_UP <=====  mEnterRefreshDefer=");
          ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
          QLog.i("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
        }
        j();
        i();
      }
    }
    else
    {
      this.jdField_e_of_type_Int = ((int)paramMotionEvent.getRawY());
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyPullToZoomListView$ScalingRunnalable.a) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyPullToZoomListView$ScalingRunnalable.a();
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() / this.jdField_f_of_type_Int);
      if ((QLog.isColorLevel()) && (jdField_e_of_type_Boolean))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTouchEvent(): ACTION_DOWN ==>  mLastScale = ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Float);
        ((StringBuilder)localObject).append("， mHeaderMaxHeight = ");
        ((StringBuilder)localObject).append(this.g);
        QLog.i("Q.readinjoy.video.PullToZoomListView", 2, ((StringBuilder)localObject).toString());
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setHeaderViewSize(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new AbsListView.LayoutParams(paramInt1, paramInt2);
    }
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_f_of_type_Int = paramInt2;
    this.g = ((int)(this.jdField_f_of_type_Int * this.jdField_c_of_type_Float));
  }
  
  public void setOnTopCallback(ReadInJoyPullToZoomListView.OnTopCallback paramOnTopCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewReadInJoyPullToZoomListView$OnTopCallback = paramOnTopCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyPullToZoomListView
 * JD-Core Version:    0.7.0.1
 */