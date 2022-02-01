package dov.com.tencent.mobileqq.activity.richmedia;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class QzoneRightButton$5
  implements DialogInterface.OnClickListener
{
  QzoneRightButton$5(QzoneRightButton paramQzoneRightButton) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QzoneRightButton.a(this.a).p = true;
    QzoneRightButton.b(this.a).setSelected(true);
    QzoneRightButton.a(this.a).c(3002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneRightButton.5
 * JD-Core Version:    0.7.0.1
 */