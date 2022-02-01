package dov.com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QzoneEditPicturePartScheduleDelete$1
  implements View.OnClickListener
{
  QzoneEditPicturePartScheduleDelete$1(QzoneEditPicturePartScheduleDelete paramQzoneEditPicturePartScheduleDelete) {}
  
  public void onClick(View paramView)
  {
    StoryReportor.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!this.a.a().g()) {
      QzoneEditPicturePartScheduleDelete.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a().e(false);
      QzoneEditPicturePartScheduleDelete.a(this.a).setSelected(false);
      this.a.a().c(3003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPicturePartScheduleDelete.1
 * JD-Core Version:    0.7.0.1
 */