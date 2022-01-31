import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsOptView;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

class pzw
  implements qfs
{
  pzw(pzs parampzs) {}
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    pzs.a(this.a).removeMessages(7);
    qag localqag = pzs.a(this.a);
    Object localObject;
    if ((paramViewHolder instanceof qae))
    {
      localObject = (qae)paramViewHolder;
      if ((localqag != null) && (localqag.jdField_a_of_type_Pxs != null)) {
        localqag.jdField_a_of_type_Pxs.c(false);
      }
      if ((((qae)localObject).c >= this.a.getItemCount() - 5) && (pzs.a(this.a) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() holder.position = " + ((qae)localObject).c + ", getCount() = " + this.a.getItemCount() + ", 推荐视频列表提前预拉取");
        }
        pzs.a(this.a).d();
      }
    }
    if (((localqag instanceof qap)) && (pzs.a(this.a) != null)) {
      pzs.a(this.a).a((qap)localqag);
    }
    if (((paramViewHolder instanceof qaj)) && (((qaj)paramViewHolder).a == 6))
    {
      pzs.a(this.a);
      pzs.a(this.a, null);
    }
    boolean bool;
    pqh localpqh;
    if ((paramViewHolder instanceof qag))
    {
      localObject = (qaq)paramViewHolder;
      pzs.a(this.a, (qag)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() videoInfo = " + pzs.a(this.a).jdField_a_of_type_Qeq.a.b());
      }
      if ((pzs.a(this.a) != null) && (pzs.a(this.a).jdField_a_of_type_Qeq != null)) {
        pzs.a(this.a).a(pzs.a(this.a).jdField_a_of_type_Qeq.a);
      }
      if (pzs.c(this.a)) {
        break label875;
      }
      pzs.a(this.a).jdField_a_of_type_Pxs.a(false, pzs.d(this.a));
      pzs.c(this.a, true);
      bool = false;
      if ((pzs.a(this.a) != null) && (pzs.a(this.a).jdField_a_of_type_Qeq != null) && (!pzs.e(this.a)))
      {
        localpqh = new pqh();
        if (pzs.a(this.a) == null) {
          break label908;
        }
        localpqh.b = pzs.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    label908:
    for (int i = pzs.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; i = -1)
    {
      new.b(pzs.a(this.a).jdField_a_of_type_Qeq.a, i, 7, -1, localpqh, pzs.a(this.a).g);
      if (pzs.f(this.a))
      {
        TraceCompat.beginSection("playVideo");
        this.a.a((qaq)localObject);
        TraceCompat.endSection();
        pzs.d(this.a, false);
      }
      for (;;)
      {
        if (pzs.a(this.a) != null) {
          pzs.a(this.a).a(pzs.a(this.a).jdField_a_of_type_Qeq.a);
        }
        pzs.a(this.a, pzs.a(this.a), localqag, bool);
        pzs.a(this.a, System.currentTimeMillis());
        if ((pzs.a(this.a) != null) && (!AppSetting.c))
        {
          pzs.a(this.a).removeMessages(0);
          pzs.a(this.a).sendEmptyMessageDelayed(0, 3000L);
        }
        VideoFeedsAccessibilityHelper.a(paramViewHolder);
        if (pzs.a(this.a) != null) {
          pzs.a(this.a).a(pzs.a(this.a));
        }
        if (pzs.a(this.a) != null)
        {
          if (pzs.a(this.a).a != null) {
            pzs.a(this.a).a.setActive(false);
          }
          if (pzs.a(this.a).b != null) {
            pzs.a(this.a).b.setActive(false);
          }
          if (pzs.a(this.a).c != null) {
            pzs.a(this.a).c.setActive(false);
          }
        }
        if ((paramViewHolder instanceof qaq))
        {
          if (((qaq)paramViewHolder).a != null)
          {
            ((qaq)paramViewHolder).a.setActive(true);
            ((qaq)paramViewHolder).a.b();
          }
          if (((qaq)paramViewHolder).b != null)
          {
            ((qaq)paramViewHolder).b.setActive(true);
            ((qaq)paramViewHolder).b.b();
          }
          if (((qaq)paramViewHolder).c != null)
          {
            ((qaq)paramViewHolder).c.setActive(true);
            ((qaq)paramViewHolder).c.b();
          }
          pzs.a(this.a, (qaq)paramViewHolder);
        }
        return;
        label875:
        pzs.a(this.a).jdField_a_of_type_Pxs.c(true);
        bool = true;
        break;
        pzs.d(this.a, true);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    pzs.e(this.a, paramBoolean);
    if ((paramViewHolder instanceof qag)) {
      ((qag)paramViewHolder).jdField_a_of_type_Pxs.e(pzs.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzw
 * JD-Core Version:    0.7.0.1
 */