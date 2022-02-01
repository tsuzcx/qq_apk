package com.tencent.mobileqq.kandian.biz.video.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.playfeeds.VideoPlayDianZanHandler;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import java.net.MalformedURLException;
import java.net.URL;

public class VideoFeedsWithColumnViewHolder
  extends VideoFeedsViewHolder
  implements View.OnClickListener
{
  public View I;
  public KanDianUrlRoundCornerImageView J;
  public TextView K;
  public TextView L;
  public TextView M;
  
  public VideoFeedsWithColumnViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130848162;
    }
    return 2130843998;
  }
  
  private void a(boolean paramBoolean, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setRepeatCount(1);
    localScaleAnimation.setRepeatMode(2);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setAnimationListener(new VideoFeedsWithColumnViewHolder.2(this, paramImageView, paramBoolean));
    paramImageView.startAnimation(localScaleAnimation);
  }
  
  private void d(View paramView)
  {
    paramView = b(paramView);
    if ((paramView != null) && (this.R != null) && (paramView.mVideoColumnInfo != null) && (!paramView.mVideoColumnInfo.h))
    {
      this.M.setSelected(false);
      this.M.setText(HardCodeUtil.a(2131913478));
      Object localObject = paramView.mVideoColumnInfo;
      ((VideoColumnInfo)localObject).g += 1;
      VideoFeedsHelper.a(this.L, paramView.mVideoColumnInfo.g, HardCodeUtil.a(2131913484), "0");
      paramView.mVideoColumnInfo.h = true;
      if ((paramView instanceof BaseArticleInfo)) {
        ReadInJoyLogicEngine.a().c(paramView);
      }
      localObject = Message.obtain();
      ((Message)localObject).obj = this;
      ((Message)localObject).arg1 = paramView.mVideoColumnInfo.b;
      ((Message)localObject).what = 1;
      this.S.sendMessageDelayed((Message)localObject, 3000L);
      VideoFeedsHelper.a(this.R.i(), paramView.mVideoColumnInfo.p);
      VideoFeedsHelper.a(RIJQQAppInterfaceUtil.a(), paramView.mVideoColumnInfo.b, true, paramView.mVideoColumnInfo.d);
      RIJFrameworkReportManager.e(paramView, 2);
    }
  }
  
  private void e(View paramView)
  {
    if (paramView != null)
    {
      if (this.R == null) {
        return;
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = b(paramView);
      if ((localAbsBaseArticleInfo != null) && (this.R != null) && (localAbsBaseArticleInfo.mVideoColumnInfo != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.n != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.n.a != 3))
      {
        VideoFeedsHelper.a(this.R.i(), localAbsBaseArticleInfo.mVideoColumnInfo.n);
      }
      else
      {
        paramView = VideoHandler.a(paramView);
        if (paramView != null) {
          this.R.g().a(paramView.a(), localAbsBaseArticleInfo, false, false);
        }
      }
      RIJFrameworkReportManager.e(localAbsBaseArticleInfo, 1);
    }
  }
  
  private void f(View paramView)
  {
    if (paramView == null) {
      return;
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = b(paramView);
    if (localAbsBaseArticleInfo != null)
    {
      if (localAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return;
      }
      int i;
      if (localAbsBaseArticleInfo.mSocialFeedInfo.i == 1) {
        i = 1;
      } else {
        i = 0;
      }
      SocializeFeedsInfo localSocializeFeedsInfo;
      if (i != 0)
      {
        localSocializeFeedsInfo = localAbsBaseArticleInfo.mSocialFeedInfo;
        localSocializeFeedsInfo.h -= 1;
      }
      else
      {
        localSocializeFeedsInfo = localAbsBaseArticleInfo.mSocialFeedInfo;
        localSocializeFeedsInfo.h += 1;
      }
      VideoFeedsHelper.a(this.p, localAbsBaseArticleInfo.mSocialFeedInfo.h, HardCodeUtil.a(2131913479));
      localAbsBaseArticleInfo.mSocialFeedInfo.i = (i ^ 0x1);
      a(i ^ 0x1, (ImageView)paramView);
      paramView = RIJQQAppInterfaceUtil.a();
      if (paramView != null) {
        ((VideoPlayDianZanHandler)paramView.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_DIANZAN)).a(localAbsBaseArticleInfo, i ^ 0x1);
      }
      if ((localAbsBaseArticleInfo instanceof BaseArticleInfo)) {
        ReadInJoyLogicEngine.a().c(localAbsBaseArticleInfo);
      }
      RIJFrameworkReportManager.a(localAbsBaseArticleInfo.mAlgorithmID, i ^ 0x1);
    }
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = super.a(paramInt, paramViewGroup);
    this.I = ((ViewStub)paramViewGroup.findViewById(2131449503)).inflate();
    this.I.setId(2131449503);
    this.J = ((KanDianUrlRoundCornerImageView)this.I.findViewById(2131436325));
    this.K = ((TextView)this.I.findViewById(2131448335));
    this.L = ((TextView)this.I.findViewById(2131448778));
    this.M = ((TextView)this.I.findViewById(2131448777));
    paramViewGroup.findViewById(2131449500).setVisibility(0);
    this.J.setCorner(ViewUtils.dpToPx(2.0F));
    this.I.setOnClickListener(this);
    this.M.setOnClickListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.e.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = ViewUtils.dip2px(0.0F);
      this.e.setLayoutParams(localLayoutParams);
    }
    this.w.setPadding(ViewUtils.dpToPx(1.0F), this.w.getPaddingTop(), this.w.getPaddingRight(), this.w.getPaddingBottom());
    this.p.setVisibility(0);
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = b(this.M);
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mVideoColumnInfo != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.b == paramInt)) {
      VideoFeedsHelper.a(this.M, 8, 600);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    this.f.setVisibility(8);
    this.H.setVisibility(8);
    this.e.setTextColor(Color.parseColor("#797E8E"));
    int i = paramAbsBaseArticleInfo.mVideoPlayCount;
    int j = 0;
    if (i == 0)
    {
      this.e.setVisibility(8);
    }
    else
    {
      this.e.setVisibility(0);
      ReadInJoyNickNameTextView localReadInJoyNickNameTextView = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoFeedsHelper.c(paramAbsBaseArticleInfo.mVideoPlayCount));
      localStringBuilder.append(HardCodeUtil.a(2131913480));
      localReadInJoyNickNameTextView.setText(localStringBuilder.toString());
    }
    i = 2130843998;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      i = paramAbsBaseArticleInfo.mSocialFeedInfo.i;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      i = a(bool);
      j = paramAbsBaseArticleInfo.mSocialFeedInfo.h;
    }
    this.l.setImageResource(i);
    VideoFeedsHelper.a(this.p, j, HardCodeUtil.a(2131913482));
  }
  
  public void a(VideoColumnInfo paramVideoColumnInfo)
  {
    if (paramVideoColumnInfo == null)
    {
      this.I.setVisibility(8);
      return;
    }
    this.I.setVisibility(0);
    try
    {
      a(this.J, new URL(paramVideoColumnInfo.d));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
    Object localObject;
    if (!TextUtils.isEmpty(paramVideoColumnInfo.c))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramVideoColumnInfo.c);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    this.K.setText((CharSequence)localObject);
    VideoFeedsHelper.a(this.L, paramVideoColumnInfo.g, HardCodeUtil.a(2131913481), "0");
    if (paramVideoColumnInfo.h)
    {
      this.M.setVisibility(8);
      return;
    }
    this.M.setVisibility(0);
    this.M.setSelected(true);
    this.M.setText(HardCodeUtil.a(2131913483));
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    ((VideoFeedsWithColumnViewHolder)paramMessage.obj).a(paramMessage.arg1);
    return true;
  }
  
  public void onClick(View paramView)
  {
    VideoHandler.b(paramView);
    int i = paramView.getId();
    if (i != 2131435495)
    {
      if (i != 2131448777)
      {
        if (i != 2131449503) {
          return;
        }
        e(paramView);
        return;
      }
      d(paramView);
      return;
    }
    RIJUserLevelModule.getInstance().doActionsByUserLevel(this.N, 3, new VideoFeedsWithColumnViewHolder.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsWithColumnViewHolder
 * JD-Core Version:    0.7.0.1
 */