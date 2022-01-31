package com.tencent.mobileqq.hotpic;

import ahwv;
import ajya;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aram;
import aran;
import arao;
import arap;
import araq;
import arar;
import aras;
import arat;
import arbp;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class HotVideoMongoliaRelativeLayout
  extends RelativeLayout
  implements View.OnTouchListener
{
  public static final String a;
  public static final String b;
  public static final String c = ajya.a(2131705625);
  public static final String d = ajya.a(2131705626);
  final float jdField_a_of_type_Float = 1.777778F;
  public int a;
  public ahwv a;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  public View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  arap jdField_a_of_type_Arap;
  private araq jdField_a_of_type_Araq;
  private arar jdField_a_of_type_Arar;
  public aras a;
  public arat a;
  public CircleProgressView a;
  private HotVideoData jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData;
  boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131705627);
    jdField_b_of_type_JavaLangString = ajya.a(2131705623);
  }
  
  public HotVideoMongoliaRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HotVideoMongoliaRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HotVideoMongoliaRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Araq != null) {
        this.jdField_a_of_type_Araq.c(paramInt2);
      }
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      continue;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      continue;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      continue;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      continue;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      continue;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  private void a(aras paramaras, arat paramarat)
  {
    this.jdField_a_of_type_Aras = paramaras;
    this.jdField_a_of_type_Arat = paramarat;
    this.jdField_a_of_type_Aras.a(this);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = arbp.a(getContext());
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        b(-11);
        return;
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label97;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
    }
    for (;;)
    {
      FrameLayout localFrameLayout = (FrameLayout)findViewById(2131376347);
      localFrameLayout.removeAllViews();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.jdField_a_of_type_Arat.jdField_a_of_type_Int, -1);
      localFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      label97:
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(0));
    }
  }
  
  private void g()
  {
    QLog.d("HotVideoRelativeLayout", 2, "mVideoTitle is" + this.jdField_a_of_type_Arat.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375836));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375835));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131379013);
    this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView = ((CircleProgressView)findViewById(2131365344));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131371952));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(10000);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378937));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378936));
    f();
    b(2);
    setOnTouchListener(this);
    setOnClickListener(new aram(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aran(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new arao(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aras == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 6)
      {
        this.jdField_a_of_type_Aras.a(7, this);
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    this.jdField_a_of_type_Aras.a(8, this);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
  }
  
  public void a(ValueAnimator paramValueAnimator)
  {
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
      this.jdField_b_of_type_AndroidViewView.setAlpha(f);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Araq != null) {
      this.jdField_a_of_type_Araq.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (!paramBoolean) {
        break label74;
      }
      i = 2130837751;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getContext().getResources().getDrawable(i));
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label81;
      }
    }
    label74:
    label81:
    for (String str = ajya.a(2131705628);; str = ajya.a(2131705629))
    {
      localImageView.setContentDescription(str);
      if (this.jdField_a_of_type_Aras != null) {
        this.jdField_a_of_type_Aras.a(paramBoolean);
      }
      return;
      i = 2130837752;
      break;
    }
  }
  
  public boolean a()
  {
    return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
  }
  
  public boolean a(aras paramaras, arat paramarat)
  {
    a(paramaras, paramarat);
    g();
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aras == null) {}
    while (this.jdField_a_of_type_Int != 5) {
      return;
    }
    this.jdField_a_of_type_Aras.a(9, this);
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    if (!a())
    {
      ThreadManager.getUIHandler().post(new HotVideoMongoliaRelativeLayout.4(this, paramInt));
      return;
    }
    a(this.jdField_a_of_type_Int, paramInt);
    QLog.d("HotVideoRelativeLayout", 2, "updatePlayStatus currentStatus is " + this.jdField_a_of_type_Int + " laterStatus is " + paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Aras != null))
    {
      this.jdField_a_of_type_Aras.a(0, this);
      a(HotPicPageView.jdField_a_of_type_Boolean);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aras != null) {
      this.jdField_a_of_type_Aras.b();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Arar != null) {
      this.jdField_a_of_type_Arar.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Aras != null) {
      this.jdField_a_of_type_Aras.a();
    }
    this.jdField_a_of_type_Aras = null;
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
    this.jdField_a_of_type_Arar = null;
    if ((this.jdField_a_of_type_Araq != null) && (this.jdField_a_of_type_Int != 0))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Araq.c(0);
      if (QLog.isColorLevel()) {
        QLog.i("HotVideoRelativeLayout", 2, "HotVideoCtl onDetachedFromWindow OnStateChanged(PLAY_STATE_PREVIEW)");
      }
      this.jdField_a_of_type_Araq = null;
      return;
    }
    b(-11);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    HotPicPageView.jdField_b_of_type_Boolean = true;
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
        QLog.d("HotVideoRelativeLayout", 2, "onTouch event down");
        return true;
        this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      }
    }
    if (paramMotionEvent.getAction() == 2)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
      if (Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity()) > 300.0F) {
        this.jdField_a_of_type_Boolean = true;
      }
      QLog.d("HotVideoRelativeLayout", 2, "onTouch event down" + this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity());
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        if ((this.jdField_a_of_type_Arap != null) && (!this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_Arap.onClick(paramView);
        }
      }
      else if (paramMotionEvent.getAction() == 3) {
        QLog.d("HotVideoRelativeLayout", 2, "event have been intercepted");
      }
    }
  }
  
  public void setControlStateListener(araq paramaraq)
  {
    this.jdField_a_of_type_Araq = paramaraq;
  }
  
  public void setHotVideoData(HotVideoData paramHotVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData = paramHotVideoData;
  }
  
  public void setOnClickListener(arap paramarap)
  {
    this.jdField_a_of_type_Arap = paramarap;
  }
  
  public void setVidoeControlListener(arar paramarar)
  {
    this.jdField_a_of_type_Arar = paramarar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout
 * JD-Core Version:    0.7.0.1
 */