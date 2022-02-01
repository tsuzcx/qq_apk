import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

class roa
  implements rsp
{
  roa(rnu paramrnu) {}
  
  public void D_() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    rnu.a(this.a).removeMessages(7);
    rol localrol = rnu.a(this.a);
    Object localObject;
    if ((paramViewHolder instanceof roj))
    {
      localObject = (roj)paramViewHolder;
      if ((localrol != null) && (localrol.jdField_a_of_type_Rln != null)) {
        localrol.jdField_a_of_type_Rln.d(false);
      }
      if ((((roj)localObject).c >= this.a.getItemCount() - 5) && (rnu.a(this.a) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() holder.position = " + ((roj)localObject).c + ", getCount() = " + this.a.getItemCount() + ", 推荐视频列表提前预拉取");
        }
        rnu.a(this.a).d();
      }
    }
    if (((paramViewHolder instanceof roo)) && (((roo)paramViewHolder).a == 6))
    {
      rnu.a(this.a);
      rnu.a(this.a, null);
    }
    boolean bool;
    qxb localqxb;
    if ((paramViewHolder instanceof rol))
    {
      localObject = (rot)paramViewHolder;
      rnu.a(this.a, (rol)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() videoInfo = " + rnu.a(this.a).jdField_a_of_type_Rrm.a.b());
      }
      if ((rnu.a(this.a) != null) && (rnu.a(this.a).jdField_a_of_type_Rrm != null)) {
        rnu.a(this.a).a(rnu.a(this.a).jdField_a_of_type_Rrm.a);
      }
      if (rnu.d(this.a)) {
        break label730;
      }
      rnu.a(this.a).jdField_a_of_type_Rln.a(false, rnu.e(this.a));
      rnu.c(this.a, true);
      bool = false;
      if ((rnu.a(this.a) != null) && (rnu.a(this.a).jdField_a_of_type_Rrm != null) && (!rnu.a()))
      {
        localqxb = new qxb();
        if (rnu.a(this.a) == null) {
          break label763;
        }
        localqxb.b = rnu.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    label730:
    label763:
    for (int i = rnu.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; i = -1)
    {
      odr.b(rnu.a(this.a).jdField_a_of_type_Rrm.a, i, 7, -1, localqxb, rnu.a(this.a).g);
      if (rnu.f(this.a))
      {
        TraceCompat.beginSection("playVideo");
        this.a.a((rot)localObject);
        TraceCompat.endSection();
        rnu.d(this.a, false);
      }
      for (;;)
      {
        if (rnu.a(this.a) != null) {
          rnu.a(this.a).a(rnu.a(this.a).jdField_a_of_type_Rrm.a);
        }
        rnu.a(this.a, rnu.a(this.a), localrol, bool);
        rnu.a(this.a, System.currentTimeMillis());
        if ((rnu.a(this.a) != null) && (!AppSetting.c))
        {
          rnu.a(this.a).removeMessages(0);
          rnu.a(this.a).sendEmptyMessageDelayed(0, 3000L);
        }
        VideoFeedsAccessibilityHelper.a(paramViewHolder);
        if (rnu.a(this.a) != null) {
          rnu.a(this.a).a(rnu.a(this.a));
        }
        if (rnu.a(this.a) != null)
        {
          rnu.a(this.a, rnu.a(this.a).a, false);
          rnu.a(this.a, rnu.a(this.a).b, false);
        }
        if ((paramViewHolder instanceof rot))
        {
          rnu.a(this.a, ((rot)paramViewHolder).a, true);
          rnu.a(this.a, ((rot)paramViewHolder).b, true);
          rnu.a(this.a, (rot)paramViewHolder);
        }
        return;
        rnu.a(this.a).jdField_a_of_type_Rln.d(true);
        bool = true;
        break;
        rnu.d(this.a, true);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    rnu.e(this.a, paramBoolean);
    if ((paramViewHolder instanceof rol)) {
      ((rol)paramViewHolder).jdField_a_of_type_Rln.f(rnu.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     roa
 * JD-Core Version:    0.7.0.1
 */