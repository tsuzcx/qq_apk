package com.tencent.mobileqq.kandian.biz.diandian.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.base.view.widget.ClipDianDianTouchAreaLayout;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.diandian.DailyFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager;
import com.tencent.mobileqq.kandian.biz.reddot.OnEntryIconRefreshListener;
import com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyColorBandEntranceButton;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class DailyDianDianEntranceView
  extends FrameLayout
  implements View.OnClickListener, OnEntryIconRefreshListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ClipDianDianTouchAreaLayout jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout;
  private VideoFeedsFirstVideoRecommendationManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager;
  private ReadInJoyColorBandEntranceButton jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton;
  
  public DailyDianDianEntranceView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  public DailyDianDianEntranceView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  private void b()
  {
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562703, this, true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton = ((ReadInJoyColorBandEntranceButton)((View)localObject).findViewById(2131366278));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout = ((ClipDianDianTouchAreaLayout)((View)localObject).findViewById(2131366279));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton, 0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.setOnVideoCoverClickListener(this);
    int j = DailyFeedsDiandianEntranceManager.a().a();
    RecommendFeedsDiandianEntranceManager.getInstance().setDailyMode(j);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init | DailyFeedsDiandianEntranceManager daily feeds entryMode : ");
    ((StringBuilder)localObject).append(j);
    QLog.d("DailyDianDianEntranceView", 1, ((StringBuilder)localObject).toString());
    int i;
    if (j == 1)
    {
      i = ReadInJoyHelper.e();
      if (i != 3)
      {
        if (i != 4)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager = new VideoFeedsFirstVideoRecommendationManager(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton, getContext());
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager.a(1);
          i = 2130843228;
        }
        else
        {
          i = 2130849704;
        }
      }
      else {
        i = 2130849669;
      }
    }
    else if (j == 3)
    {
      i = 2130849667;
    }
    else
    {
      i = 2130849668;
    }
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.setClickAnimMode(2);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.setDefaultIconBigMode(70, 70);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.setDefaultDrawable(getResources().getDrawable(i));
        return;
      }
      if (!RIJShowKanDianTabSp.c()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.setClickAnimMode(1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.setDefaultIconBigMode(80, 80);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetClipDianDianTouchAreaLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.setDefaultDrawable(getResources().getDrawable(i));
  }
  
  public DailyDianDianEntranceView a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public void a()
  {
    VideoFeedsFirstVideoRecommendationManager localVideoFeedsFirstVideoRecommendationManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager;
    if (localVideoFeedsFirstVideoRecommendationManager != null) {
      localVideoFeedsFirstVideoRecommendationManager.c();
    }
  }
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton == null) {
        return;
      }
      int i = DailyFeedsDiandianEntranceManager.a().a();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEntryIconRefresh | entryMode ");
      ((StringBuilder)localObject).append(i);
      QLog.d("DailyDianDianEntranceView", 1, ((StringBuilder)localObject).toString());
      if (i != 0)
      {
        if (i == 2) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.setDataSource(paramIEntranceButtonDataSource);
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton;
        if ((localObject != null) && (((ReadInJoyColorBandEntranceButton)localObject).getVisibility() == 0)) {
          if (paramIEntranceButtonDataSource != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.a(paramIEntranceButtonDataSource);
            paramIEntranceButtonDataSource = new StringBuilder();
            paramIEntranceButtonDataSource.append("onEntryIconRefresh | addRedDot entryMode ");
            paramIEntranceButtonDataSource.append(i);
            QLog.d("DailyDianDianEntranceView", 1, paramIEntranceButtonDataSource.toString());
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.setNotMsg();
            paramIEntranceButtonDataSource = new StringBuilder();
            paramIEntranceButtonDataSource.append("onEntryIconRefresh | setNotMsg entryMode ");
            paramIEntranceButtonDataSource.append(i);
            QLog.d("DailyDianDianEntranceView", 1, paramIEntranceButtonDataSource.toString());
          }
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", RecommendFeedsDiandianEntranceManager.getInstance().getReportR5Str(1, 41505), false);
      }
    }
  }
  
  public void b(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton == null) {
        return;
      }
      QLog.d("DailyDianDianEntranceView", 1, "onAccountChange");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.a();
      ReadInJoyColorBandEntranceButton localReadInJoyColorBandEntranceButton = this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton;
      if ((localReadInJoyColorBandEntranceButton != null) && (localReadInJoyColorBandEntranceButton.getVisibility() == 0))
      {
        if (paramIEntranceButtonDataSource != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.a(paramIEntranceButtonDataSource);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton.setNotMsg();
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setStartDelay(500L);
    localObjectAnimator.setDuration(400L);
    localObjectAnimator.start();
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (paramView != null) {
      paramView.onClick(this.jdField_a_of_type_ComTencentMobileqqKandianBizReddotReadInJoyColorBandEntranceButton);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.view.DailyDianDianEntranceView
 * JD-Core Version:    0.7.0.1
 */