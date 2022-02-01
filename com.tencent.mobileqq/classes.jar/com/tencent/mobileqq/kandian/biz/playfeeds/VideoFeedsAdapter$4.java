package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdExposureManager;
import com.tencent.mobileqq.kandian.base.view.widget.ListEventListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.FooterItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;

class VideoFeedsAdapter$4
  implements ListEventListener
{
  VideoFeedsAdapter$4(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  private void a(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder = paramBaseVideoItemHolder;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCenterViewChanged() videoInfo = ");
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a.e());
      QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    VideoReport.setElementParams(paramBaseVideoItemHolder.itemView, new RIJDtParamBuilder().a(paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a).a("area", "list").a());
    if ((VideoFeedsAdapter.a(this.a) != null) && (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null)) {
      VideoFeedsAdapter.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a);
    }
    boolean bool;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(false, VideoFeedsAdapter.a(this.a));
      this.a.jdField_a_of_type_Boolean = true;
      bool = false;
    }
    else
    {
      this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(true);
      bool = true;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder != null) && (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (!VideoFeedsAdapter.e()))
    {
      localObject = new ReportInfo.VideoExtraRepoerData();
      int i;
      if (this.a.jdField_a_of_type_AndroidAppActivity != null)
      {
        ((ReportInfo.VideoExtraRepoerData)localObject).b = this.a.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        i = this.a.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      }
      else
      {
        i = -1;
      }
      VideoReporter.b(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a, i, 7, -1, (ReportInfo.VideoExtraRepoerData)localObject, VideoFeedsAdapter.a(this.a).g);
    }
    if (VideoFeedsAdapter.b(this.a))
    {
      TraceCompat.beginSection("playVideo");
      this.a.a(paramBaseVideoItemHolder);
      TraceCompat.endSection();
      VideoFeedsAdapter.a(this.a, false);
    }
    else
    {
      VideoFeedsAdapter.a(this.a, true);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.a);
    }
    VideoFeedsAdapter.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder, bool);
    VideoFeedsAdapter.a(this.a, System.currentTimeMillis());
    if ((this.a.jdField_a_of_type_AndroidOsHandler != null) && (!AppSetting.d))
    {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    Object localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
    Object localObject1;
    if ((paramViewHolder instanceof BaseItemHolder))
    {
      localObject1 = (BaseItemHolder)paramViewHolder;
      if ((localObject2 != null) && (((BaseVideoItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate != null)) {
        ((BaseVideoItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(false);
      }
      if ((((BaseItemHolder)localObject1).c >= this.a.getItemCount() - 5) && (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter$AdapterEventListener != null))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onCenterViewChanged() holder.position = ");
          ((StringBuilder)localObject2).append(((BaseItemHolder)localObject1).c);
          ((StringBuilder)localObject2).append(", getCount() = ");
          ((StringBuilder)localObject2).append(this.a.getItemCount());
          ((StringBuilder)localObject2).append(", 推荐视频列表提前预拉取");
          QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, ((StringBuilder)localObject2).toString());
        }
        this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter$AdapterEventListener.a();
      }
    }
    if (((paramViewHolder instanceof FooterItemHolder)) && (((FooterItemHolder)paramViewHolder).a == 6))
    {
      VideoFeedsAdapter.f(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder = null;
    }
    if ((paramViewHolder instanceof BaseVideoItemHolder)) {
      a((BaseVideoItemHolder)paramViewHolder);
    }
    VideoFeedsAccessibilityHelper.a.a(paramViewHolder);
    if (VideoFeedsAdapter.a(this.a) != null) {
      VideoFeedsAdapter.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder);
    }
    if (VideoFeedsAdapter.a(this.a) != null)
    {
      localObject1 = this.a;
      VideoFeedsAdapter.a((VideoFeedsAdapter)localObject1, VideoFeedsAdapter.a((VideoFeedsAdapter)localObject1).a, false);
      localObject1 = this.a;
      VideoFeedsAdapter.a((VideoFeedsAdapter)localObject1, VideoFeedsAdapter.a((VideoFeedsAdapter)localObject1).b, false);
    }
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      localObject1 = this.a;
      paramViewHolder = (VideoItemHolder)paramViewHolder;
      VideoFeedsAdapter.a((VideoFeedsAdapter)localObject1, paramViewHolder.a, true);
      VideoFeedsAdapter.a(this.a, paramViewHolder.b, true);
      VideoFeedsAdapter.a(this.a, paramViewHolder);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    VideoFeedsAdapter.b(this.a, paramBoolean);
    if ((paramViewHolder instanceof BaseVideoItemHolder)) {
      ((BaseVideoItemHolder)paramViewHolder).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.c(VideoFeedsAdapter.c(this.a));
    }
  }
  
  public void aC_() {}
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.4
 * JD-Core Version:    0.7.0.1
 */