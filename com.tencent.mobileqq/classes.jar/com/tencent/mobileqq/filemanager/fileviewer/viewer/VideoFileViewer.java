package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.DragContainerLayout;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.DragView.OnGestureChangeListener;

public class VideoFileViewer
  extends FileBrowserViewBase
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float = 0.0F;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private DragContainerLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout;
  private VideoPlayParam jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam = null;
  private BaseVideoView jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
  private DragView.OnGestureChangeListener jdField_a_of_type_ComTencentWidgetDragView$OnGestureChangeListener = new VideoFileViewer.5(this);
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean = false;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_c_of_type_Boolean = false;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  
  public VideoFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private String a(long paramLong)
  {
    long l1 = paramLong / 1000L;
    paramLong = l1 / 86400L;
    long l2 = l1 % 86400L;
    l1 = l2 / 3600L;
    long l3 = l2 % 3600L;
    l2 = l3 / 60L;
    l3 %= 60L;
    StringBuilder localStringBuilder;
    if (paramLong > 0L)
    {
      str = String.format("%02d:%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTick 161 [");
        localStringBuilder.append(str);
        localStringBuilder.append("]");
        QLog.d("#@#@", 1, localStringBuilder.toString());
      }
      return str;
    }
    if (l1 > 0L)
    {
      str = String.format("%02d:%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTick 167 [");
        localStringBuilder.append(str);
        localStringBuilder.append("]");
        QLog.d("#@#@", 1, localStringBuilder.toString());
      }
      return str;
    }
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTick 174 [");
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      QLog.d("#@#@", 1, localStringBuilder.toString());
    }
    return str;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public BaseVideoView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: VideoFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131560842, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373004));
      this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362661));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380494));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373128));
      this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376496));
      this.h.setText(HardCodeUtil.a(2131716011));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373127));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131372862));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372821));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370792));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378891));
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363336));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366800));
    }
  }
  
  public void a(long paramLong)
  {
    this.f.setText(a(paramLong));
  }
  
  public void a(long paramLong, View.OnLongClickListener paramOnLongClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)QQVideoViewFactory.b(this.jdField_a_of_type_AndroidAppActivity, paramLong, null, null));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13, -1);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout = new DragContainerLayout(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout.setContainerLongClickListener(paramOnLongClickListener);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout.addView(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView);
      int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().widthPixels;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout.setGestureChangeListener(this.jdField_a_of_type_ComTencentWidgetDragView$OnGestureChangeListener);
      paramOnLongClickListener = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout, 0, paramOnLongClickListener);
      paramOnLongClickListener = this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam;
      if (paramOnLongClickListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(paramOnLongClickListener);
      }
    }
  }
  
  @TargetApi(16)
  public void a(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT > 16)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setBackground(paramDrawable);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener != null) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    localRelativeLayout.setBackgroundColor(Color.parseColor("#D8DAE0"));
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130844378, 0, 0);
    localTextView.setText(paramString2);
    localTextView.setTextSize(12.0F);
    localTextView.setTextColor(Color.parseColor("#83889A"));
    localTextView.setPadding(0, 15, 0, 0);
    localRelativeLayout.addView(localTextView, -2, -2);
    ((RelativeLayout.LayoutParams)localTextView.getLayoutParams()).addRule(13);
    if (FileUtil.a(paramString1))
    {
      paramString2 = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      paramString2.setText("用QQ浏览器打开");
      paramString2.setContentDescription("用qq浏览器打开");
      paramString2.setTextSize(12.0F);
      paramString2.setTextColor(Color.parseColor("#12B7F5"));
      paramString2.setOnClickListener(new VideoFileViewer.2(this, paramString1));
      localRelativeLayout.addView(paramString2, -2, -2);
      paramString1 = (RelativeLayout.LayoutParams)paramString2.getLayoutParams();
      paramString1.addRule(13);
      paramString1.addRule(12);
      paramString1.setMargins(0, 0, 0, 40);
      paramString2.setLayoutParams(paramString1);
    }
    double d1 = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay().getWidth();
    Double.isNaN(d1);
    int i = (int)(d1 * 0.75D);
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, -1, i);
    ((RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams()).addRule(13);
    b(false);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.e.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(4);
    this.f.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new VideoFileViewer.3(this));
  }
  
  public void b(long paramLong)
  {
    this.e.setText(a(paramLong));
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      this.g.setOnClickListener(paramOnClickListener);
      this.h.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && (!this.jdField_d_of_type_Boolean)) {
      bool = true;
    } else {
      bool = false;
    }
    super.b(bool);
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    RelativeLayout localRelativeLayout = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.removeAllViews();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView = this.h;
    if (localTextView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
  }
  
  @TargetApi(11)
  public void d()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(2500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new VideoFileViewer.4(this));
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130845893);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691139));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130845891);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691142));
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (Build.VERSION.SDK_INT >= 11))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 4;
      }
      localTextView.setVisibility(i);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(1.0F);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    int j = 0;
    int i;
    if ((paramBoolean) && (!this.jdField_d_of_type_Boolean)) {
      i = 1;
    } else {
      i = 0;
    }
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (i != 0) {
      i = j;
    } else {
      i = 8;
    }
    localLinearLayout.setVisibility(i);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void g(boolean paramBoolean)
  {
    int j = 0;
    int i;
    if ((paramBoolean) && (!this.jdField_d_of_type_Boolean)) {
      i = 1;
    } else {
      i = 0;
    }
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (i != 0) {
      i = j;
    } else {
      i = 8;
    }
    localRelativeLayout.setVisibility(i);
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(500L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setRepeatMode(1);
      localRotateAnimation.setStartTime(-1L);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localRotateAnimation);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFileViewer.1(this));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2)
      {
        float f3 = Math.abs(f1 - this.jdField_a_of_type_Float);
        float f4 = Math.abs(f2 - this.jdField_b_of_type_Float);
        paramView = new StringBuilder();
        paramView.append("absX[");
        paramView.append(f3);
        paramView.append("] --- absY[");
        paramView.append(f4);
        paramView.append("]，mPressDownY[");
        paramView.append(this.jdField_b_of_type_Float);
        paramView.append("]，currTouchY【");
        paramView.append(f2);
        paramView.append("】");
        QLog.i("FileBrowserViewBase", 1, paramView.toString());
        if (f3 > f4)
        {
          f2 = this.jdField_a_of_type_Float;
          if (f1 - f2 > 20.0F)
          {
            QLog.i("FileBrowserViewBase", 1, "<--  左滑");
            return true;
          }
          if (f1 - f2 < -20.0F)
          {
            QLog.i("FileBrowserViewBase", 1, "-->  右滑");
            return true;
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer
 * JD-Core Version:    0.7.0.1
 */