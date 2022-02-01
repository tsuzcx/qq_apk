package dov.com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QzoneRightButton$2
  implements View.OnClickListener
{
  QzoneRightButton$2(QzoneRightButton paramQzoneRightButton) {}
  
  public void onClick(View paramView)
  {
    StoryReportor.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!QzoneRightButton.a(this.a).p) {
      QzoneRightButton.b(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QzoneRightButton.a(this.a).p = false;
      QzoneRightButton.b(this.a).setSelected(false);
      QzoneRightButton.a(this.a).c(3003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneRightButton.2
 * JD-Core Version:    0.7.0.1
 */