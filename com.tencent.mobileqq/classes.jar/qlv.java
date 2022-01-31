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

class qlv
  implements qrq
{
  qlv(qls paramqls) {}
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    qls.a(this.a).removeMessages(7);
    qmi localqmi = qls.a(this.a);
    Object localObject;
    if ((paramViewHolder instanceof qmg))
    {
      localObject = (qmg)paramViewHolder;
      if ((localqmi != null) && (localqmi.jdField_a_of_type_Qjr != null)) {
        localqmi.jdField_a_of_type_Qjr.c(false);
      }
      if ((((qmg)localObject).c >= this.a.getItemCount() - 5) && (qls.a(this.a) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() holder.position = " + ((qmg)localObject).c + ", getCount() = " + this.a.getItemCount() + ", 推荐视频列表提前预拉取");
        }
        qls.a(this.a).d();
      }
    }
    if (((localqmi instanceof qmr)) && (qls.a(this.a) != null)) {
      qls.a(this.a).a((qmr)localqmi);
    }
    if (((paramViewHolder instanceof qml)) && (((qml)paramViewHolder).a == 6))
    {
      qls.a(this.a);
      qls.a(this.a, null);
    }
    boolean bool;
    qcd localqcd;
    if ((paramViewHolder instanceof qmi))
    {
      localObject = (qms)paramViewHolder;
      qls.a(this.a, (qmi)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "onCenterViewChanged() videoInfo = " + qls.a(this.a).jdField_a_of_type_Qqo.a.b());
      }
      if ((qls.a(this.a) != null) && (qls.a(this.a).jdField_a_of_type_Qqo != null)) {
        qls.a(this.a).a(qls.a(this.a).jdField_a_of_type_Qqo.a);
      }
      if (qls.c(this.a)) {
        break label875;
      }
      qls.a(this.a).jdField_a_of_type_Qjr.a(false, qls.d(this.a));
      qls.c(this.a, true);
      bool = false;
      if ((qls.a(this.a) != null) && (qls.a(this.a).jdField_a_of_type_Qqo != null) && (!qls.e(this.a)))
      {
        localqcd = new qcd();
        if (qls.a(this.a) == null) {
          break label908;
        }
        localqcd.b = qls.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      }
    }
    label908:
    for (int i = qls.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);; i = -1)
    {
      npx.b(qls.a(this.a).jdField_a_of_type_Qqo.a, i, 7, -1, localqcd, qls.a(this.a).g);
      if (qls.f(this.a))
      {
        TraceCompat.beginSection("playVideo");
        this.a.a((qms)localObject);
        TraceCompat.endSection();
        qls.d(this.a, false);
      }
      for (;;)
      {
        if (qls.a(this.a) != null) {
          qls.a(this.a).a(qls.a(this.a).jdField_a_of_type_Qqo.a);
        }
        qls.a(this.a, qls.a(this.a), localqmi, bool);
        qls.a(this.a, System.currentTimeMillis());
        if ((qls.a(this.a) != null) && (!AppSetting.d))
        {
          qls.a(this.a).removeMessages(0);
          qls.a(this.a).sendEmptyMessageDelayed(0, 3000L);
        }
        VideoFeedsAccessibilityHelper.a(paramViewHolder);
        if (qls.a(this.a) != null) {
          qls.a(this.a).a(qls.a(this.a));
        }
        if (qls.a(this.a) != null)
        {
          if (qls.a(this.a).a != null) {
            qls.a(this.a).a.setActive(false);
          }
          if (qls.a(this.a).b != null) {
            qls.a(this.a).b.setActive(false);
          }
          if (qls.a(this.a).c != null) {
            qls.a(this.a).c.setActive(false);
          }
        }
        if ((paramViewHolder instanceof qms))
        {
          if (((qms)paramViewHolder).a != null)
          {
            ((qms)paramViewHolder).a.setActive(true);
            ((qms)paramViewHolder).a.b();
          }
          if (((qms)paramViewHolder).b != null)
          {
            ((qms)paramViewHolder).b.setActive(true);
            ((qms)paramViewHolder).b.b();
          }
          if (((qms)paramViewHolder).c != null)
          {
            ((qms)paramViewHolder).c.setActive(true);
            ((qms)paramViewHolder).c.b();
          }
          qls.a(this.a, (qms)paramViewHolder);
        }
        return;
        label875:
        qls.a(this.a).jdField_a_of_type_Qjr.c(true);
        bool = true;
        break;
        qls.d(this.a, true);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    qls.e(this.a, paramBoolean);
    if ((paramViewHolder instanceof qmi)) {
      ((qmi)paramViewHolder).jdField_a_of_type_Qjr.e(qls.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlv
 * JD-Core Version:    0.7.0.1
 */