package dov.com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

class QzoneEditPicturePartSave$1
  implements View.OnClickListener
{
  QzoneEditPicturePartSave$1(QzoneEditPicturePartSave paramQzoneEditPicturePartSave) {}
  
  public void onClick(View paramView)
  {
    QZLog.d("QzoneEditPicturePartSav", 2, "onClick save button");
    this.a.a.a(9);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPicturePartSave.1
 * JD-Core Version:    0.7.0.1
 */