package dov.com.tencent.mobileqq.activity.richmedia;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QzoneEditPicturePartComment$1
  implements CompoundButton.OnCheckedChangeListener
{
  QzoneEditPicturePartComment$1(QzoneEditPicturePartComment paramQzoneEditPicturePartComment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QzoneEditPicturePartComment.a(this.a).e = paramBoolean;
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPicturePartComment.1
 * JD-Core Version:    0.7.0.1
 */