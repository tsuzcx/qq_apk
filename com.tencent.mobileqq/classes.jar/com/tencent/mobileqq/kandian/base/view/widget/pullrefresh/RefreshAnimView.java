package com.tencent.mobileqq.kandian.base.view.widget.pullrefresh;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;

public class RefreshAnimView
  extends RelativeLayout
{
  private long jdField_a_of_type_Long = 100L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LottieComposition jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition;
  private RefreshEyeView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView;
  
  public RefreshAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(paramContext, 2131562707, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370480));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376349));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView = ((RefreshEyeView)findViewById(2131376343));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView.b();
    ThreadManager.excute(new RefreshAnimView.1(this, paramContext), 64, null, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView.b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView.setScaleX(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView.setScaleY(1.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(double paramDouble)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView.setWaveHeightPercent(paramDouble);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RefreshAnimView.2(this), paramLong);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setAnimationListener(new RefreshAnimView.3(this, paramString, paramBoolean));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView.startAnimation(localScaleAnimation);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView.a();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshEyeView.setVisibility(0);
    }
  }
  
  public void setRefreshBarStayTimeMS(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshAnimView
 * JD-Core Version:    0.7.0.1
 */