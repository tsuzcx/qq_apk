package com.tencent.mobileqq.hotpic;

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
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class HotVideoMongoliaRelativeLayout
  extends RelativeLayout
  implements View.OnTouchListener
{
  public static final String a;
  public static final String b;
  public static final String c = HardCodeUtil.a(2131705641);
  public static final String d = HardCodeUtil.a(2131705642);
  final float jdField_a_of_type_Float = 1.777778F;
  public int a;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker = null;
  public View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public Size a;
  public CircleProgressView a;
  private HotVideoData jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData = null;
  HotVideoMongoliaRelativeLayout.InnerOnClickListener jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$InnerOnClickListener;
  private HotVideoMongoliaRelativeLayout.OnVideoControlStateListener jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVideoControlStateListener;
  private HotVideoMongoliaRelativeLayout.OnVidoeControlListener jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVidoeControlListener;
  HotVideoMongoliaRelativeLayout.PresenceInterface jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface;
  public HotVideoMongoliaRelativeLayout.VideoInfo a;
  boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131705643);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131705639);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSize = null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVideoControlStateListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVideoControlStateListener.c(paramInt2);
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
  
  private void a(HotVideoMongoliaRelativeLayout.PresenceInterface paramPresenceInterface, HotVideoMongoliaRelativeLayout.VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface = paramPresenceInterface;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo = paramVideoInfo;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(this);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = VideoBaseItem.a(getContext());
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
      FrameLayout localFrameLayout = (FrameLayout)findViewById(2131378326);
      localFrameLayout.removeAllViews();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.jdField_a_of_type_Int, -1);
      localFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      label97:
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(0));
    }
  }
  
  private void g()
  {
    QLog.d("HotVideoRelativeLayout", 2, "mVideoTitle is" + this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$VideoInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377763));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377762));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131381399);
    this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView = ((CircleProgressView)findViewById(2131366003));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373501));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(10000);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131381280));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381279));
    f();
    b(2);
    setOnTouchListener(this);
    setOnClickListener(new HotVideoMongoliaRelativeLayout.1(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new HotVideoMongoliaRelativeLayout.2(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new HotVideoMongoliaRelativeLayout.3(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(7, this);
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(8, this);
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
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVideoControlStateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVideoControlStateListener.a(paramString);
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
      i = 2130838163;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getContext().getResources().getDrawable(i));
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label81;
      }
    }
    label74:
    label81:
    for (String str = HardCodeUtil.a(2131705644);; str = HardCodeUtil.a(2131705645))
    {
      localImageView.setContentDescription(str);
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(paramBoolean);
      }
      return;
      i = 2130838164;
      break;
    }
  }
  
  public boolean a()
  {
    return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
  }
  
  public boolean a(HotVideoMongoliaRelativeLayout.PresenceInterface paramPresenceInterface, HotVideoMongoliaRelativeLayout.VideoInfo paramVideoInfo)
  {
    a(paramPresenceInterface, paramVideoInfo);
    g();
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface == null) {}
    while (this.jdField_a_of_type_Int != 5) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(9, this);
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
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a(0, this);
      a(HotPicPageView.jdField_a_of_type_Boolean);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.b();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVidoeControlListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVidoeControlListener.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$PresenceInterface = null;
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVidoeControlListener = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVideoControlStateListener != null) && (this.jdField_a_of_type_Int != 0))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVideoControlStateListener.c(0);
      if (QLog.isColorLevel()) {
        QLog.i("HotVideoRelativeLayout", 2, "HotVideoCtl onDetachedFromWindow OnStateChanged(PLAY_STATE_PREVIEW)");
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVideoControlStateListener = null;
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
        if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$InnerOnClickListener != null) && (!this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$InnerOnClickListener.onClick(paramView);
        }
      }
      else if (paramMotionEvent.getAction() == 3) {
        QLog.d("HotVideoRelativeLayout", 2, "event have been intercepted");
      }
    }
  }
  
  public void setControlStateListener(HotVideoMongoliaRelativeLayout.OnVideoControlStateListener paramOnVideoControlStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVideoControlStateListener = paramOnVideoControlStateListener;
  }
  
  public void setHotVideoData(HotVideoData paramHotVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoData = paramHotVideoData;
  }
  
  public void setOnClickListener(HotVideoMongoliaRelativeLayout.InnerOnClickListener paramInnerOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$InnerOnClickListener = paramInnerOnClickListener;
  }
  
  public void setVidoeControlListener(HotVideoMongoliaRelativeLayout.OnVidoeControlListener paramOnVidoeControlListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$OnVidoeControlListener = paramOnVidoeControlListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout
 * JD-Core Version:    0.7.0.1
 */