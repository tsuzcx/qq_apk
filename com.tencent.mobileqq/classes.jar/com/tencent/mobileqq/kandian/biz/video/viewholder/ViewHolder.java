package com.tencent.mobileqq.kandian.biz.video.viewholder;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.api.OnUIChangeListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.net.URL;
import java.util.List;

public abstract class ViewHolder
  implements Handler.Callback, OnUIChangeListener
{
  public int a;
  protected Context a;
  protected View.OnClickListener a;
  protected VideoHandler a;
  protected ViewHolder.VideoUIHandler a;
  public View g;
  
  public ViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler = paramVideoHandler;
  }
  
  protected static void a(VideoHandler paramVideoHandler, AbsBaseArticleInfo paramAbsBaseArticleInfo, VideoColumnInfo paramVideoColumnInfo, int paramInt, String paramString)
  {
    int j = paramVideoHandler.a().a();
    String str = RIJFeedsType.c(paramAbsBaseArticleInfo);
    int i;
    if (paramAbsBaseArticleInfo.hasChannelInfo()) {
      i = paramAbsBaseArticleInfo.mChannelInfoId;
    } else {
      i = 0;
    }
    boolean bool = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText);
    paramVideoHandler = new VideoR5.Builder(RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), 0, i, bool ^ true, NetworkUtil.isWifiConnected(paramVideoHandler.a()), str, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), 409409, paramAbsBaseArticleInfo));
    paramVideoHandler.j(paramAbsBaseArticleInfo.innerUniqueID).a(j).d(paramAbsBaseArticleInfo.mStrategyId).g(VideoReporter.a).h(409409).j(paramAbsBaseArticleInfo.mVideoAdsJumpType).k(paramAbsBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(RIJFeedsType.g(paramAbsBaseArticleInfo))).a(paramAbsBaseArticleInfo.videoReportInfo).R(paramInt).q(paramString).f(paramAbsBaseArticleInfo);
    if (paramVideoColumnInfo != null) {
      paramVideoHandler.Y(paramVideoColumnInfo.a);
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007625", "0X8007625", 0, 0, "2", "", "", paramVideoHandler.a().a(), false);
  }
  
  public abstract View a(int paramInt, ViewGroup paramViewGroup);
  
  protected final PlayableItem a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof PlayableItem))) {
      return (PlayableItem)paramView.getTag();
    }
    return null;
  }
  
  protected final AbsBaseArticleInfo a(View paramView)
  {
    return VideoHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler, paramView);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  protected void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    a(paramKandianUrlImageView, paramURL, false);
  }
  
  protected void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean)
  {
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidContentContext, paramBoolean);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2) {}
  
  public void a(ViewHolder.VideoUIHandler paramVideoUIHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler = paramVideoUIHandler;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler.a.add(this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder
 * JD-Core Version:    0.7.0.1
 */