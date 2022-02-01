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

class shq
  implements slx
{
  shq(shl paramshl) {}
  
  private void a(swm paramswm)
  {
    shl.a(this.a, paramswm);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() videoInfo = " + shl.a(this.a).jdField_a_of_type_Skq.a.b());
    }
    VideoReport.setElementParams(paramswm.itemView, new pti().a(paramswm.jdField_a_of_type_Skq.a).a("area", "list").a());
    if ((shl.a(this.a) != null) && (shl.a(this.a).jdField_a_of_type_Skq != null)) {
      shl.a(this.a).a(shl.a(this.a).jdField_a_of_type_Skq.a);
    }
    boolean bool;
    rqg localrqg;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      shl.a(this.a).jdField_a_of_type_Sfc.a(false, shl.a(this.a));
      this.a.jdField_a_of_type_Boolean = true;
      bool = false;
      if ((shl.a(this.a) != null) && (shl.a(this.a).jdField_a_of_type_Skq != null) && (!shl.a()))
      {
        localrqg = new rqg();
        if (this.a.jdField_a_of_type_AndroidAppActivity == null) {
          break label469;
        }
        localrqg.b = this.a.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    label469:
    for (int i = this.a.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; i = -1)
    {
      omx.b(shl.a(this.a).jdField_a_of_type_Skq.a, i, 7, -1, localrqg, shl.a(this.a).g);
      if (shl.b(this.a))
      {
        TraceCompat.beginSection("playVideo");
        this.a.a(paramswm);
        TraceCompat.endSection();
        shl.a(this.a, false);
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_Sib != null) {
          this.a.jdField_a_of_type_Sib.a(shl.a(this.a).jdField_a_of_type_Skq.a);
        }
        shl.a(this.a).a(shl.a(this.a), bool);
        shl.a(this.a, System.currentTimeMillis());
        if ((this.a.jdField_a_of_type_AndroidOsHandler != null) && (!AppSetting.c))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
        }
        return;
        shl.a(this.a).jdField_a_of_type_Sfc.d(true);
        bool = true;
        break;
        shl.a(this.a, true);
      }
    }
  }
  
  public void A_() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    swm localswm = shl.a(this.a);
    if ((paramViewHolder instanceof swj))
    {
      swj localswj = (swj)paramViewHolder;
      if ((localswm != null) && (localswm.jdField_a_of_type_Sfc != null)) {
        localswm.jdField_a_of_type_Sfc.d(false);
      }
      if ((localswj.c >= this.a.getItemCount() - 5) && (this.a.jdField_a_of_type_Shw != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() holder.position = " + localswj.c + ", getCount() = " + this.a.getItemCount() + ", 推荐视频列表提前预拉取");
        }
        this.a.jdField_a_of_type_Shw.d();
      }
    }
    if (((paramViewHolder instanceof swp)) && (((swp)paramViewHolder).a == 6))
    {
      shl.h(this.a);
      shl.a(this.a, null);
    }
    if ((paramViewHolder instanceof swm)) {
      a((swm)paramViewHolder);
    }
    VideoFeedsAccessibilityHelper.a(paramViewHolder);
    if (shl.a(this.a) != null) {
      shl.a(this.a).a(shl.a(this.a));
    }
    if (shl.a(this.a) != null)
    {
      shl.a(this.a, shl.a(this.a).a, false);
      shl.a(this.a, shl.a(this.a).b, false);
    }
    if ((paramViewHolder instanceof swu))
    {
      shl.a(this.a, ((swu)paramViewHolder).a, true);
      shl.a(this.a, ((swu)paramViewHolder).b, true);
      shl.a(this.a, (swu)paramViewHolder);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    shl.b(this.a, paramBoolean);
    if ((paramViewHolder instanceof swm)) {
      ((swm)paramViewHolder).jdField_a_of_type_Sfc.f(shl.c(this.a));
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shq
 * JD-Core Version:    0.7.0.1
 */