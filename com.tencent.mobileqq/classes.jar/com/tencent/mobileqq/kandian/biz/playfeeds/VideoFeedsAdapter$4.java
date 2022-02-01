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
    this.a.h = paramBaseVideoItemHolder;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCenterViewChanged() videoInfo = ");
      ((StringBuilder)localObject).append(this.a.h.az.c.q());
      QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    VideoReport.setElementParams(paramBaseVideoItemHolder.itemView, new RIJDtParamBuilder().a(paramBaseVideoItemHolder.az.c).a("area", "list").c());
    if ((VideoFeedsAdapter.j(this.a) != null) && (this.a.h.az != null)) {
      VideoFeedsAdapter.j(this.a).a(this.a.h.az.c);
    }
    boolean bool;
    if (!this.a.i)
    {
      this.a.h.aA.a(false, VideoFeedsAdapter.k(this.a));
      this.a.i = true;
      bool = false;
    }
    else
    {
      this.a.h.aA.b(true);
      bool = true;
    }
    if ((this.a.h != null) && (this.a.h.az != null) && (!VideoFeedsAdapter.v()))
    {
      localObject = new ReportInfo.VideoExtraRepoerData();
      int i;
      if (this.a.e != null)
      {
        ((ReportInfo.VideoExtraRepoerData)localObject).b = this.a.e.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        i = this.a.e.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      }
      else
      {
        i = -1;
      }
      VideoReporter.b(this.a.h.az.c, i, 7, -1, (ReportInfo.VideoExtraRepoerData)localObject, VideoFeedsAdapter.l(this.a).l);
    }
    if (VideoFeedsAdapter.m(this.a))
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
    if (this.a.b != null) {
      this.a.b.a(this.a.h.az.c);
    }
    VideoFeedsAdapter.n(this.a).a(this.a.h, bool);
    VideoFeedsAdapter.a(this.a, System.currentTimeMillis());
    if ((this.a.x != null) && (!AppSetting.e))
    {
      this.a.x.removeMessages(0);
      this.a.x.sendEmptyMessageDelayed(0, 3000L);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.a.x.removeMessages(7);
    Object localObject2 = this.a.h;
    Object localObject1;
    if ((paramViewHolder instanceof BaseItemHolder))
    {
      localObject1 = (BaseItemHolder)paramViewHolder;
      if ((localObject2 != null) && (((BaseVideoItemHolder)localObject2).aA != null)) {
        ((BaseVideoItemHolder)localObject2).aA.b(false);
      }
      if ((((BaseItemHolder)localObject1).Z >= this.a.getItemCount() - 5) && (this.a.a != null))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onCenterViewChanged() holder.position = ");
          ((StringBuilder)localObject2).append(((BaseItemHolder)localObject1).Z);
          ((StringBuilder)localObject2).append(", getCount() = ");
          ((StringBuilder)localObject2).append(this.a.getItemCount());
          ((StringBuilder)localObject2).append(", 推荐视频列表提前预拉取");
          QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, ((StringBuilder)localObject2).toString());
        }
        this.a.a.a();
      }
    }
    if (((paramViewHolder instanceof FooterItemHolder)) && (((FooterItemHolder)paramViewHolder).X == 6))
    {
      VideoFeedsAdapter.g(this.a);
      this.a.h = null;
    }
    if ((paramViewHolder instanceof BaseVideoItemHolder)) {
      a((BaseVideoItemHolder)paramViewHolder);
    }
    VideoFeedsAccessibilityHelper.a.a(paramViewHolder);
    if (VideoFeedsAdapter.h(this.a) != null) {
      VideoFeedsAdapter.h(this.a).a(this.a.h);
    }
    if (VideoFeedsAdapter.i(this.a) != null)
    {
      localObject1 = this.a;
      VideoFeedsAdapter.a((VideoFeedsAdapter)localObject1, VideoFeedsAdapter.i((VideoFeedsAdapter)localObject1).aE, false);
      localObject1 = this.a;
      VideoFeedsAdapter.a((VideoFeedsAdapter)localObject1, VideoFeedsAdapter.i((VideoFeedsAdapter)localObject1).aF, false);
    }
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      localObject1 = this.a;
      paramViewHolder = (VideoItemHolder)paramViewHolder;
      VideoFeedsAdapter.a((VideoFeedsAdapter)localObject1, paramViewHolder.aE, true);
      VideoFeedsAdapter.a(this.a, paramViewHolder.aF, true);
      VideoFeedsAdapter.a(this.a, paramViewHolder);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    VideoFeedsAdapter.b(this.a, paramBoolean);
    if ((paramViewHolder instanceof BaseVideoItemHolder)) {
      ((BaseVideoItemHolder)paramViewHolder).aA.d(VideoFeedsAdapter.o(this.a));
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.4
 * JD-Core Version:    0.7.0.1
 */