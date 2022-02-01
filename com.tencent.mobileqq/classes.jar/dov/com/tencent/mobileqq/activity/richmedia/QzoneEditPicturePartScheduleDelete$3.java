package dov.com.tencent.mobileqq.activity.richmedia;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class QzoneEditPicturePartScheduleDelete$3
  implements DialogInterface.OnClickListener
{
  QzoneEditPicturePartScheduleDelete$3(QzoneEditPicturePartScheduleDelete paramQzoneEditPicturePartScheduleDelete) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((QzoneEditPicturePartManager)this.a.a).e(false);
    QzoneEditPicturePartScheduleDelete.a(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPicturePartScheduleDelete.3
 * JD-Core Version:    0.7.0.1
 */