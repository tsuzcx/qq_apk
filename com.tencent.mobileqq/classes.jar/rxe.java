import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

class rxe
  implements sbt
{
  rxe(rwy paramrwy) {}
  
  public void D_() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    rwy.a(this.a).removeMessages(7);
    rxq localrxq = rwy.a(this.a);
    Object localObject;
    if ((paramViewHolder instanceof rxo))
    {
      localObject = (rxo)paramViewHolder;
      if ((localrxq != null) && (localrxq.jdField_a_of_type_Rur != null)) {
        localrxq.jdField_a_of_type_Rur.d(false);
      }
      if ((((rxo)localObject).c >= this.a.getItemCount() - 5) && (rwy.a(this.a) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() holder.position = " + ((rxo)localObject).c + ", getCount() = " + this.a.getItemCount() + ", 推荐视频列表提前预拉取");
        }
        rwy.a(this.a).d();
      }
    }
    if (((paramViewHolder instanceof rxt)) && (((rxt)paramViewHolder).a == 6))
    {
      rwy.a(this.a);
      rwy.a(this.a, null);
    }
    boolean bool;
    rgi localrgi;
    if ((paramViewHolder instanceof rxq))
    {
      localObject = (rxy)paramViewHolder;
      rwy.a(this.a, (rxq)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() videoInfo = " + rwy.a(this.a).jdField_a_of_type_Sar.a.b());
      }
      if ((rwy.a(this.a) != null) && (rwy.a(this.a).jdField_a_of_type_Sar != null)) {
        rwy.a(this.a).a(rwy.a(this.a).jdField_a_of_type_Sar.a);
      }
      if (rwy.d(this.a)) {
        break label730;
      }
      rwy.a(this.a).jdField_a_of_type_Rur.a(false, rwy.e(this.a));
      rwy.c(this.a, true);
      bool = false;
      if ((rwy.a(this.a) != null) && (rwy.a(this.a).jdField_a_of_type_Sar != null) && (!rwy.a()))
      {
        localrgi = new rgi();
        if (rwy.a(this.a) == null) {
          break label763;
        }
        localrgi.b = rwy.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    label730:
    label763:
    for (int i = rwy.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; i = -1)
    {
      och.b(rwy.a(this.a).jdField_a_of_type_Sar.a, i, 7, -1, localrgi, rwy.a(this.a).g);
      if (rwy.f(this.a))
      {
        TraceCompat.beginSection("playVideo");
        this.a.a((rxy)localObject);
        TraceCompat.endSection();
        rwy.d(this.a, false);
      }
      for (;;)
      {
        if (rwy.a(this.a) != null) {
          rwy.a(this.a).a(rwy.a(this.a).jdField_a_of_type_Sar.a);
        }
        rwy.a(this.a, rwy.a(this.a), localrxq, bool);
        rwy.a(this.a, System.currentTimeMillis());
        if ((rwy.a(this.a) != null) && (!AppSetting.c))
        {
          rwy.a(this.a).removeMessages(0);
          rwy.a(this.a).sendEmptyMessageDelayed(0, 3000L);
        }
        VideoFeedsAccessibilityHelper.a(paramViewHolder);
        if (rwy.a(this.a) != null) {
          rwy.a(this.a).a(rwy.a(this.a));
        }
        if (rwy.a(this.a) != null)
        {
          rwy.a(this.a, rwy.a(this.a).a, false);
          rwy.a(this.a, rwy.a(this.a).b, false);
        }
        if ((paramViewHolder instanceof rxy))
        {
          rwy.a(this.a, ((rxy)paramViewHolder).a, true);
          rwy.a(this.a, ((rxy)paramViewHolder).b, true);
          rwy.a(this.a, (rxy)paramViewHolder);
        }
        return;
        rwy.a(this.a).jdField_a_of_type_Rur.d(true);
        bool = true;
        break;
        rwy.d(this.a, true);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    rwy.e(this.a, paramBoolean);
    if ((paramViewHolder instanceof rxq)) {
      ((rxq)paramViewHolder).jdField_a_of_type_Rur.f(rwy.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxe
 * JD-Core Version:    0.7.0.1
 */