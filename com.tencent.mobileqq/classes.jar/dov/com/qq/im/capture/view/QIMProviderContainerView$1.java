package dov.com.qq.im.capture.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.AbsQIMCaptureController;
import java.util.HashMap;

class QIMProviderContainerView$1
  implements View.OnClickListener
{
  QIMProviderContainerView$1(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374434)
    {
      MusicProviderView localMusicProviderView = (MusicProviderView)QIMProviderContainerView.a(this.a).get(Integer.valueOf(104));
      if ((localMusicProviderView != null) && (!localMusicProviderView.c()))
      {
        QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131709787), 0).a();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      int i = ((Integer)paramView.getTag()).intValue();
      if (QLog.isColorLevel()) {
        QLog.i("ProviderContainerView", 2, "onclick, index: " + i);
      }
      this.a.a(i, 0, null, false);
      if (QIMProviderContainerView.a(this.a) == null) {
        break;
      }
      QIMProviderContainerView.a(this.a).a();
      break;
      StoryReportor.a("clk_effect", StoryReportor.b(CaptureReportUtil.a), 0, false, new String[0]);
      continue;
      StoryReportor.a("clk_filter", StoryReportor.b(CaptureReportUtil.a), 0, false, new String[0]);
      continue;
      StoryReportor.a("clk_music", StoryReportor.b(CaptureReportUtil.a), 0, false, new String[0]);
      continue;
      StoryReportor.a("clk_face", StoryReportor.b(CaptureReportUtil.a), 0, false, new String[0]);
      continue;
      StoryReportor.a("clk_beauty", StoryReportor.b(CaptureReportUtil.a), 0, false, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView.1
 * JD-Core Version:    0.7.0.1
 */