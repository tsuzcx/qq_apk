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
import com.tencent.biz.pubaccount.util.VideoPlayDianZanHandler;
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
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import java.net.MalformedURLException;
import java.net.URL;

public class VideoFeedsWithColumnViewHolder
  extends VideoFeedsViewHolder
  implements View.OnClickListener
{
  public KanDianUrlRoundCornerImageView a;
  public View f;
  public TextView j;
  public TextView k;
  public TextView l;
  
  public VideoFeedsWithColumnViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    super(paramContext, paramVideoHandler);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130846610;
    }
    return 2130843042;
  }
  
  private void a(View paramView)
  {
    paramView = a(paramView);
    if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler != null) && (paramView.mVideoColumnInfo != null) && (!paramView.mVideoColumnInfo.jdField_a_of_type_Boolean))
    {
      this.l.setSelected(false);
      this.l.setText(HardCodeUtil.a(2131716027));
      Object localObject = paramView.mVideoColumnInfo;
      ((VideoColumnInfo)localObject).jdField_c_of_type_Int += 1;
      VideoFeedsHelper.a(this.k, paramView.mVideoColumnInfo.jdField_c_of_type_Int, HardCodeUtil.a(2131716033), "0");
      paramView.mVideoColumnInfo.jdField_a_of_type_Boolean = true;
      if ((paramView instanceof BaseArticleInfo)) {
        ReadInJoyLogicEngine.a().b(paramView);
      }
      localObject = Message.obtain();
      ((Message)localObject).obj = this;
      ((Message)localObject).arg1 = paramView.mVideoColumnInfo.jdField_a_of_type_Int;
      ((Message)localObject).what = 1;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler.sendMessageDelayed((Message)localObject, 3000L);
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(), paramView.mVideoColumnInfo.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
      VideoFeedsHelper.a(RIJQQAppInterfaceUtil.a(), paramView.mVideoColumnInfo.jdField_a_of_type_Int, true, paramView.mVideoColumnInfo.jdField_c_of_type_JavaLangString);
      RIJFrameworkReportManager.e(paramView, 2);
    }
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
  
  private void b(View paramView)
  {
    if (paramView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler == null) {
        return;
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramView);
      if ((localAbsBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler != null) && (localAbsBaseArticleInfo.mVideoColumnInfo != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_Int != 3))
      {
        VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a(), localAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
      }
      else
      {
        paramView = VideoHandler.a(paramView);
        if (paramView != null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().a(paramView.a(), localAbsBaseArticleInfo, false, false);
        }
      }
      RIJFrameworkReportManager.e(localAbsBaseArticleInfo, 1);
    }
  }
  
  private void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramView);
    if (localAbsBaseArticleInfo != null)
    {
      if (localAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return;
      }
      int i;
      if (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_Int == 1) {
        i = 1;
      } else {
        i = 0;
      }
      SocializeFeedsInfo localSocializeFeedsInfo;
      if (i != 0)
      {
        localSocializeFeedsInfo = localAbsBaseArticleInfo.mSocialFeedInfo;
        localSocializeFeedsInfo.b -= 1;
      }
      else
      {
        localSocializeFeedsInfo = localAbsBaseArticleInfo.mSocialFeedInfo;
        localSocializeFeedsInfo.b += 1;
      }
      VideoFeedsHelper.a(this.d, localAbsBaseArticleInfo.mSocialFeedInfo.b, HardCodeUtil.a(2131716028));
      localAbsBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_Int = (i ^ 0x1);
      a(i ^ 0x1, (ImageView)paramView);
      paramView = RIJQQAppInterfaceUtil.a();
      if (paramView != null) {
        ((VideoPlayDianZanHandler)paramView.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_DIANZAN)).a(localAbsBaseArticleInfo, i ^ 0x1);
      }
      if ((localAbsBaseArticleInfo instanceof BaseArticleInfo)) {
        ReadInJoyLogicEngine.a().b(localAbsBaseArticleInfo);
      }
      RIJFrameworkReportManager.a(localAbsBaseArticleInfo.mAlgorithmID, i ^ 0x1);
    }
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = super.a(paramInt, paramViewGroup);
    this.f = ((ViewStub)paramViewGroup.findViewById(2131380546)).inflate();
    this.f.setId(2131380546);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)this.f.findViewById(2131369324));
    this.j = ((TextView)this.f.findViewById(2131379579));
    this.k = ((TextView)this.f.findViewById(2131379904));
    this.l = ((TextView)this.f.findViewById(2131379903));
    paramViewGroup.findViewById(2131380543).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setCorner(ViewUtils.b(2.0F));
    this.f.setOnClickListener(this);
    this.l.setOnClickListener(this);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = ViewUtils.a(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setLayoutParams(localLayoutParams);
    }
    this.c.setPadding(ViewUtils.b(1.0F), this.c.getPaddingTop(), this.c.getPaddingRight(), this.c.getPaddingBottom());
    this.d.setVisibility(0);
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = a(this.l);
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mVideoColumnInfo != null) && (localAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int == paramInt)) {
      VideoFeedsHelper.a(this.l, 8, 600);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setTextColor(Color.parseColor("#797E8E"));
    int i = paramAbsBaseArticleInfo.mVideoPlayCount;
    int m = 0;
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(0);
      ReadInJoyNickNameTextView localReadInJoyNickNameTextView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoFeedsHelper.c(paramAbsBaseArticleInfo.mVideoPlayCount));
      localStringBuilder.append(HardCodeUtil.a(2131716029));
      localReadInJoyNickNameTextView.setText(localStringBuilder.toString());
    }
    i = 2130843042;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      i = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_Int;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      i = a(bool);
      m = paramAbsBaseArticleInfo.mSocialFeedInfo.b;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(i);
    VideoFeedsHelper.a(this.d, m, HardCodeUtil.a(2131716031));
  }
  
  public void a(VideoColumnInfo paramVideoColumnInfo)
  {
    if (paramVideoColumnInfo == null)
    {
      this.f.setVisibility(8);
      return;
    }
    this.f.setVisibility(0);
    try
    {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView, new URL(paramVideoColumnInfo.jdField_c_of_type_JavaLangString));
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
    }
    Object localObject;
    if (!TextUtils.isEmpty(paramVideoColumnInfo.b))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramVideoColumnInfo.b);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    this.j.setText((CharSequence)localObject);
    VideoFeedsHelper.a(this.k, paramVideoColumnInfo.jdField_c_of_type_Int, HardCodeUtil.a(2131716030), "0");
    if (paramVideoColumnInfo.jdField_a_of_type_Boolean)
    {
      this.l.setVisibility(8);
      return;
    }
    this.l.setVisibility(0);
    this.l.setSelected(true);
    this.l.setText(HardCodeUtil.a(2131716032));
  }
  
  public boolean a()
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
    VideoHandler.a(paramView);
    int i = paramView.getId();
    if (i != 2131368583)
    {
      if (i != 2131379903)
      {
        if (i != 2131380546) {
          return;
        }
        b(paramView);
        return;
      }
      a(paramView);
      return;
    }
    RIJUserLevelModule.getInstance().doActionsByUserLevel(this.jdField_a_of_type_AndroidContentContext, 3, new VideoFeedsWithColumnViewHolder.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsWithColumnViewHolder
 * JD-Core Version:    0.7.0.1
 */