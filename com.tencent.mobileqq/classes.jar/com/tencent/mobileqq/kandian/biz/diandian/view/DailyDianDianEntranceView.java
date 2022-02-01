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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.diandian.DailyFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager;
import com.tencent.mobileqq.kandian.biz.reddot.OnEntryIconRefreshListener;
import com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyColorBandEntranceButton;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.qphone.base.util.QLog;

public class DailyDianDianEntranceView
  extends FrameLayout
  implements View.OnClickListener, OnEntryIconRefreshListener
{
  private Context a;
  private ReadInJoyColorBandEntranceButton b;
  private ClipDianDianTouchAreaLayout c;
  private VideoFeedsFirstVideoRecommendationManager d;
  private View.OnClickListener e;
  
  public DailyDianDianEntranceView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public DailyDianDianEntranceView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    Object localObject = LayoutInflater.from(this.a).inflate(2131629134, this, true);
    this.b = ((ReadInJoyColorBandEntranceButton)((View)localObject).findViewById(2131432581));
    this.c = ((ClipDianDianTouchAreaLayout)((View)localObject).findViewById(2131432582));
    this.c.setTouchWidget(this.b, 0);
    this.b.setOnVideoCoverClickListener(this);
    int j = DailyFeedsDiandianEntranceManager.a().c();
    RecommendFeedsDiandianEntranceManager.getInstance().setDailyMode(j);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init | DailyFeedsDiandianEntranceManager daily feeds entryMode : ");
    ((StringBuilder)localObject).append(j);
    QLog.d("DailyDianDianEntranceView", 1, ((StringBuilder)localObject).toString());
    int i;
    if (j == 1)
    {
      i = ReadInJoyHelper.K();
      if (i != 3)
      {
        if (i != 4)
        {
          this.d = new VideoFeedsFirstVideoRecommendationManager(this.b, getContext());
          this.d.a(1);
          i = 2130844182;
        }
        else
        {
          i = 2130851410;
        }
      }
      else {
        i = 2130851374;
      }
    }
    else if (j == 3)
    {
      i = 2130851372;
    }
    else
    {
      i = 2130851373;
    }
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3) {
          return;
        }
        this.b.setClickAnimMode(2);
        this.c.setVisibility(0);
        this.b.setVisibility(0);
        this.b.getRefreshIcon().setVisibility(0);
        this.b.setDefaultIconBigMode(70, 70);
        this.b.setDefaultDrawable(getResources().getDrawable(i));
        return;
      }
      if (!RIJShowKanDianTabSp.c()) {
        return;
      }
      this.b.setClickAnimMode(1);
      this.b.setDefaultIconBigMode(80, 80);
    }
    this.c.setVisibility(0);
    this.b.setVisibility(0);
    this.b.setDefaultDrawable(getResources().getDrawable(i));
  }
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource != null)
    {
      if (this.b == null) {
        return;
      }
      int i = DailyFeedsDiandianEntranceManager.a().c();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEntryIconRefresh | entryMode ");
      ((StringBuilder)localObject).append(i);
      QLog.d("DailyDianDianEntranceView", 1, ((StringBuilder)localObject).toString());
      if (i != 0)
      {
        if (i == 2) {
          return;
        }
        this.b.setDataSource(paramIEntranceButtonDataSource);
        localObject = this.b;
        if ((localObject != null) && (((ReadInJoyColorBandEntranceButton)localObject).getVisibility() == 0)) {
          if (paramIEntranceButtonDataSource != null)
          {
            this.b.a(paramIEntranceButtonDataSource);
            paramIEntranceButtonDataSource = new StringBuilder();
            paramIEntranceButtonDataSource.append("onEntryIconRefresh | addRedDot entryMode ");
            paramIEntranceButtonDataSource.append(i);
            QLog.d("DailyDianDianEntranceView", 1, paramIEntranceButtonDataSource.toString());
          }
          else
          {
            this.b.setNotMsg();
            paramIEntranceButtonDataSource = new StringBuilder();
            paramIEntranceButtonDataSource.append("onEntryIconRefresh | setNotMsg entryMode ");
            paramIEntranceButtonDataSource.append(i);
            QLog.d("DailyDianDianEntranceView", 1, paramIEntranceButtonDataSource.toString());
          }
        }
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", RecommendFeedsDiandianEntranceManager.getInstance().getReportR5Str(1, 41505), false);
      }
    }
  }
  
  public void b(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource != null)
    {
      if (this.b == null) {
        return;
      }
      QLog.d("DailyDianDianEntranceView", 1, "onAccountChange");
      this.b.a();
      ReadInJoyColorBandEntranceButton localReadInJoyColorBandEntranceButton = this.b;
      if ((localReadInJoyColorBandEntranceButton != null) && (localReadInJoyColorBandEntranceButton.getVisibility() == 0))
      {
        if (paramIEntranceButtonDataSource != null)
        {
          this.b.a(paramIEntranceButtonDataSource);
          return;
        }
        this.b.setNotMsg();
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.b, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setStartDelay(500L);
    localObjectAnimator.setDuration(400L);
    localObjectAnimator.start();
  }
  
  public void onClick(View paramView)
  {
    paramView = this.e;
    if (paramView != null) {
      paramView.onClick(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.view.DailyDianDianEntranceView
 * JD-Core Version:    0.7.0.1
 */