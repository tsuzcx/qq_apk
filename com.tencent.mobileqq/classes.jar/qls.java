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

class qls
  implements qrn
{
  qls(qlp paramqlp) {}
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    qlp.a(this.a).removeMessages(7);
    qmf localqmf = qlp.a(this.a);
    Object localObject;
    if ((paramViewHolder instanceof qmd))
    {
      localObject = (qmd)paramViewHolder;
      if ((localqmf != null) && (localqmf.jdField_a_of_type_Qjo != null)) {
        localqmf.jdField_a_of_type_Qjo.c(false);
      }
      if ((((qmd)localObject).c >= this.a.getItemCount() - 5) && (qlp.a(this.a) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() holder.position = " + ((qmd)localObject).c + ", getCount() = " + this.a.getItemCount() + ", 推荐视频列表提前预拉取");
        }
        qlp.a(this.a).d();
      }
    }
    if (((localqmf instanceof qmo)) && (qlp.a(this.a) != null)) {
      qlp.a(this.a).a((qmo)localqmf);
    }
    if (((paramViewHolder instanceof qmi)) && (((qmi)paramViewHolder).a == 6))
    {
      qlp.a(this.a);
      qlp.a(this.a, null);
    }
    boolean bool;
    qca localqca;
    if ((paramViewHolder instanceof qmf))
    {
      localObject = (qmp)paramViewHolder;
      qlp.a(this.a, (qmf)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() videoInfo = " + qlp.a(this.a).jdField_a_of_type_Qql.a.b());
      }
      if ((qlp.a(this.a) != null) && (qlp.a(this.a).jdField_a_of_type_Qql != null)) {
        qlp.a(this.a).a(qlp.a(this.a).jdField_a_of_type_Qql.a);
      }
      if (qlp.c(this.a)) {
        break label875;
      }
      qlp.a(this.a).jdField_a_of_type_Qjo.a(false, qlp.d(this.a));
      qlp.c(this.a, true);
      bool = false;
      if ((qlp.a(this.a) != null) && (qlp.a(this.a).jdField_a_of_type_Qql != null) && (!qlp.e(this.a)))
      {
        localqca = new qca();
        if (qlp.a(this.a) == null) {
          break label908;
        }
        localqca.b = qlp.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    label908:
    for (int i = qlp.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; i = -1)
    {
      npu.b(qlp.a(this.a).jdField_a_of_type_Qql.a, i, 7, -1, localqca, qlp.a(this.a).g);
      if (qlp.f(this.a))
      {
        TraceCompat.beginSection("playVideo");
        this.a.a((qmp)localObject);
        TraceCompat.endSection();
        qlp.d(this.a, false);
      }
      for (;;)
      {
        if (qlp.a(this.a) != null) {
          qlp.a(this.a).a(qlp.a(this.a).jdField_a_of_type_Qql.a);
        }
        qlp.a(this.a, qlp.a(this.a), localqmf, bool);
        qlp.a(this.a, System.currentTimeMillis());
        if ((qlp.a(this.a) != null) && (!AppSetting.d))
        {
          qlp.a(this.a).removeMessages(0);
          qlp.a(this.a).sendEmptyMessageDelayed(0, 3000L);
        }
        VideoFeedsAccessibilityHelper.a(paramViewHolder);
        if (qlp.a(this.a) != null) {
          qlp.a(this.a).a(qlp.a(this.a));
        }
        if (qlp.a(this.a) != null)
        {
          if (qlp.a(this.a).a != null) {
            qlp.a(this.a).a.setActive(false);
          }
          if (qlp.a(this.a).b != null) {
            qlp.a(this.a).b.setActive(false);
          }
          if (qlp.a(this.a).c != null) {
            qlp.a(this.a).c.setActive(false);
          }
        }
        if ((paramViewHolder instanceof qmp))
        {
          if (((qmp)paramViewHolder).a != null)
          {
            ((qmp)paramViewHolder).a.setActive(true);
            ((qmp)paramViewHolder).a.b();
          }
          if (((qmp)paramViewHolder).b != null)
          {
            ((qmp)paramViewHolder).b.setActive(true);
            ((qmp)paramViewHolder).b.b();
          }
          if (((qmp)paramViewHolder).c != null)
          {
            ((qmp)paramViewHolder).c.setActive(true);
            ((qmp)paramViewHolder).c.b();
          }
          qlp.a(this.a, (qmp)paramViewHolder);
        }
        return;
        label875:
        qlp.a(this.a).jdField_a_of_type_Qjo.c(true);
        bool = true;
        break;
        qlp.d(this.a, true);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    qlp.e(this.a, paramBoolean);
    if ((paramViewHolder instanceof qmf)) {
      ((qmf)paramViewHolder).jdField_a_of_type_Qjo.e(qlp.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qls
 * JD-Core Version:    0.7.0.1
 */