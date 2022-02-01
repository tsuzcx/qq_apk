package dov.com.tencent.mobileqq.activity.richmedia;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;

class QzoneEditPicturePartScheduleDelete$2
  implements DialogInterface.OnClickListener
{
  QzoneEditPicturePartScheduleDelete$2(QzoneEditPicturePartScheduleDelete paramQzoneEditPicturePartScheduleDelete) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ((QzoneEditPicturePartManager)this.a.a).e(true);
    QzoneEditPicturePartScheduleDelete.a(this.a).setSelected(true);
    ((QzoneEditPicturePartManager)this.a.a).c(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPicturePartScheduleDelete.2
 * JD-Core Version:    0.7.0.1
 */