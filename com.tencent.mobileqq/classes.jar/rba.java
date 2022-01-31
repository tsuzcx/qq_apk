import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

class rba
  implements rgv
{
  rba(raw paramraw) {}
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    raw.a(this.a).removeMessages(7);
    rbn localrbn = raw.a(this.a);
    Object localObject;
    if ((paramViewHolder instanceof rbl))
    {
      localObject = (rbl)paramViewHolder;
      if ((localrbn != null) && (localrbn.jdField_a_of_type_Qyv != null)) {
        localrbn.jdField_a_of_type_Qyv.c(false);
      }
      if ((((rbl)localObject).c >= this.a.getItemCount() - 5) && (raw.a(this.a) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() holder.position = " + ((rbl)localObject).c + ", getCount() = " + this.a.getItemCount() + ", 推荐视频列表提前预拉取");
        }
        raw.a(this.a).d();
      }
    }
    if (((localrbn instanceof rbs)) && (raw.a(this.a) != null)) {
      raw.a(this.a).a((rbs)localrbn);
    }
    if (((paramViewHolder instanceof rbq)) && (((rbq)paramViewHolder).a == 6))
    {
      raw.a(this.a);
      raw.a(this.a, null);
    }
    boolean bool;
    qlw localqlw;
    if ((paramViewHolder instanceof rbn))
    {
      localObject = (rbt)paramViewHolder;
      raw.a(this.a, (rbn)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() videoInfo = " + raw.a(this.a).jdField_a_of_type_Rfs.a.b());
      }
      if ((raw.a(this.a) != null) && (raw.a(this.a).jdField_a_of_type_Rfs != null)) {
        raw.a(this.a).a(raw.a(this.a).jdField_a_of_type_Rfs.a);
      }
      if (raw.c(this.a)) {
        break label767;
      }
      raw.a(this.a).jdField_a_of_type_Qyv.a(false, raw.d(this.a));
      raw.c(this.a, true);
      bool = false;
      if ((raw.a(this.a) != null) && (raw.a(this.a).jdField_a_of_type_Rfs != null) && (!raw.e(this.a)))
      {
        localqlw = new qlw();
        if (raw.a(this.a) == null) {
          break label800;
        }
        localqlw.b = raw.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    label800:
    for (int i = raw.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; i = -1)
    {
      ntd.b(raw.a(this.a).jdField_a_of_type_Rfs.a, i, 7, -1, localqlw, raw.a(this.a).g);
      if (raw.f(this.a))
      {
        TraceCompat.beginSection("playVideo");
        this.a.a((rbt)localObject);
        TraceCompat.endSection();
        raw.d(this.a, false);
      }
      for (;;)
      {
        if (raw.a(this.a) != null) {
          raw.a(this.a).a(raw.a(this.a).jdField_a_of_type_Rfs.a);
        }
        raw.a(this.a, raw.a(this.a), localrbn, bool);
        raw.a(this.a, System.currentTimeMillis());
        if ((raw.a(this.a) != null) && (!AppSetting.c))
        {
          raw.a(this.a).removeMessages(0);
          raw.a(this.a).sendEmptyMessageDelayed(0, 3000L);
        }
        VideoFeedsAccessibilityHelper.a(paramViewHolder);
        if (raw.a(this.a) != null) {
          raw.a(this.a).a(raw.a(this.a));
        }
        if (raw.a(this.a) != null)
        {
          raw.a(this.a, raw.a(this.a).a, false);
          raw.a(this.a, raw.a(this.a).b, false);
        }
        if ((paramViewHolder instanceof rbt))
        {
          raw.a(this.a, ((rbt)paramViewHolder).a, true);
          raw.a(this.a, ((rbt)paramViewHolder).b, true);
          raw.a(this.a, (rbt)paramViewHolder);
        }
        return;
        label767:
        raw.a(this.a).jdField_a_of_type_Qyv.c(true);
        bool = true;
        break;
        raw.d(this.a, true);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    raw.e(this.a, paramBoolean);
    if ((paramViewHolder instanceof rbn)) {
      ((rbn)paramViewHolder).jdField_a_of_type_Qyv.e(raw.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rba
 * JD-Core Version:    0.7.0.1
 */