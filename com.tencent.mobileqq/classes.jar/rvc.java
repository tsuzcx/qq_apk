import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;

class rvc
  implements rzt
{
  rvc(ruw paramruw) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    ruw.a(this.a).removeMessages(7);
    rvn localrvn = ruw.a(this.a);
    Object localObject;
    if ((paramViewHolder instanceof rvl))
    {
      localObject = (rvl)paramViewHolder;
      if ((localrvn != null) && (localrvn.jdField_a_of_type_Rsn != null)) {
        localrvn.jdField_a_of_type_Rsn.d(false);
      }
      if ((((rvl)localObject).c >= this.a.getItemCount() - 5) && (ruw.a(this.a) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() holder.position = " + ((rvl)localObject).c + ", getCount() = " + this.a.getItemCount() + ", 推荐视频列表提前预拉取");
        }
        ruw.a(this.a).d();
      }
    }
    if (((paramViewHolder instanceof rvq)) && (((rvq)paramViewHolder).a == 6))
    {
      ruw.a(this.a);
      ruw.a(this.a, null);
    }
    boolean bool;
    rdz localrdz;
    if ((paramViewHolder instanceof rvn))
    {
      localObject = (rvv)paramViewHolder;
      ruw.a(this.a, (rvn)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() videoInfo = " + ruw.a(this.a).jdField_a_of_type_Ryo.a.b());
      }
      VideoReport.setElementParams(((rvv)localObject).itemView, new pil().a(((rvv)localObject).jdField_a_of_type_Ryo.a).a("area", "list").a());
      if ((ruw.a(this.a) != null) && (ruw.a(this.a).jdField_a_of_type_Ryo != null)) {
        ruw.a(this.a).a(ruw.a(this.a).jdField_a_of_type_Ryo.a);
      }
      if (ruw.d(this.a)) {
        break label766;
      }
      ruw.a(this.a).jdField_a_of_type_Rsn.a(false, ruw.e(this.a));
      ruw.c(this.a, true);
      bool = false;
      if ((ruw.a(this.a) != null) && (ruw.a(this.a).jdField_a_of_type_Ryo != null) && (!ruw.a()))
      {
        localrdz = new rdz();
        if (ruw.a(this.a) == null) {
          break label799;
        }
        localrdz.b = ruw.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    label799:
    for (int i = ruw.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; i = -1)
    {
      ofe.b(ruw.a(this.a).jdField_a_of_type_Ryo.a, i, 7, -1, localrdz, ruw.a(this.a).g);
      if (ruw.f(this.a))
      {
        TraceCompat.beginSection("playVideo");
        this.a.a((rvv)localObject);
        TraceCompat.endSection();
        ruw.d(this.a, false);
      }
      for (;;)
      {
        if (ruw.a(this.a) != null) {
          ruw.a(this.a).a(ruw.a(this.a).jdField_a_of_type_Ryo.a);
        }
        ruw.a(this.a, ruw.a(this.a), localrvn, bool);
        ruw.a(this.a, System.currentTimeMillis());
        if ((ruw.a(this.a) != null) && (!AppSetting.c))
        {
          ruw.a(this.a).removeMessages(0);
          ruw.a(this.a).sendEmptyMessageDelayed(0, 3000L);
        }
        VideoFeedsAccessibilityHelper.a(paramViewHolder);
        if (ruw.a(this.a) != null) {
          ruw.a(this.a).a(ruw.a(this.a));
        }
        if (ruw.a(this.a) != null)
        {
          ruw.a(this.a, ruw.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
          ruw.a(this.a, ruw.a(this.a).b, false);
        }
        if ((paramViewHolder instanceof rvv))
        {
          ruw.a(this.a, ((rvv)paramViewHolder).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, true);
          ruw.a(this.a, ((rvv)paramViewHolder).b, true);
          ruw.a(this.a, (rvv)paramViewHolder);
        }
        return;
        label766:
        ruw.a(this.a).jdField_a_of_type_Rsn.d(true);
        bool = true;
        break;
        ruw.d(this.a, true);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    ruw.e(this.a, paramBoolean);
    if ((paramViewHolder instanceof rvn)) {
      ((rvn)paramViewHolder).jdField_a_of_type_Rsn.f(ruw.a(this.a));
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void y_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvc
 * JD-Core Version:    0.7.0.1
 */