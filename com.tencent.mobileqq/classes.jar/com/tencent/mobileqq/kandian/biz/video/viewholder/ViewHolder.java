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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
import com.tencent.mobileqq.utils.NetworkUtil;
import java.net.URL;
import java.util.List;

public abstract class ViewHolder
  implements Handler.Callback, OnUIChangeListener
{
  protected Context N;
  protected View.OnClickListener O;
  public int P;
  public View Q;
  protected VideoHandler R;
  protected ViewHolder.VideoUIHandler S;
  
  public ViewHolder(Context paramContext, VideoHandler paramVideoHandler)
  {
    this.N = paramContext;
    this.R = paramVideoHandler;
  }
  
  protected static void a(VideoHandler paramVideoHandler, AbsBaseArticleInfo paramAbsBaseArticleInfo, VideoColumnInfo paramVideoColumnInfo, int paramInt, String paramString)
  {
    int j = paramVideoHandler.g().c();
    String str = RIJFeedsType.k(paramAbsBaseArticleInfo);
    int i;
    if (paramAbsBaseArticleInfo.hasChannelInfo()) {
      i = paramAbsBaseArticleInfo.mChannelInfoId;
    } else {
      i = 0;
    }
    boolean bool = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText);
    paramVideoHandler = new VideoR5.Builder(RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), 0, i, bool ^ true, NetworkUtil.isWifiConnected(paramVideoHandler.i()), str, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.n(paramAbsBaseArticleInfo), 409409, paramAbsBaseArticleInfo));
    paramVideoHandler.k(paramAbsBaseArticleInfo.innerUniqueID).a(j).d(paramAbsBaseArticleInfo.mStrategyId).g(VideoReporter.b).h(409409).j(paramAbsBaseArticleInfo.mVideoAdsJumpType).k(paramAbsBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(RIJFeedsType.i(paramAbsBaseArticleInfo))).b(paramAbsBaseArticleInfo.videoReportInfo).S(paramInt).r(paramString).f(paramAbsBaseArticleInfo);
    if (paramVideoColumnInfo != null) {
      paramVideoHandler.Z(paramVideoColumnInfo.b);
    }
    PublicAccountReportUtils.a(null, "", "0X8007625", "0X8007625", 0, 0, "2", "", "", paramVideoHandler.b().a(), false);
  }
  
  public abstract View a(int paramInt, ViewGroup paramViewGroup);
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.O = paramOnClickListener;
  }
  
  protected void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    a(paramKandianUrlImageView, paramURL, false);
  }
  
  protected void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean)
  {
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, this.N, paramBoolean);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2) {}
  
  public void a(ViewHolder.VideoUIHandler paramVideoUIHandler)
  {
    this.S = paramVideoUIHandler;
    this.S.a.add(this);
  }
  
  protected final AbsBaseArticleInfo b(View paramView)
  {
    return VideoHandler.a(this.R, paramView);
  }
  
  protected final PlayableItem c(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof PlayableItem))) {
      return (PlayableItem)paramView.getTag();
    }
    return null;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder
 * JD-Core Version:    0.7.0.1
 */