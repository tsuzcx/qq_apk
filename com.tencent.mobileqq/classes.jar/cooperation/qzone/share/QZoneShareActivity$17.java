package cooperation.qzone.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.QZoneShareData;

class QZoneShareActivity$17
  implements DialogInterface.OnClickListener
{
  QZoneShareActivity$17(QZoneShareActivity paramQZoneShareActivity, Activity paramActivity, QZoneShareData paramQZoneShareData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    QZoneShareActivity.access$800(this.this$0, this.val$activity, this.val$shareData, false);
    this.val$activity.setResult(0, this.this$0.getIntent());
    this.val$activity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.17
 * JD-Core Version:    0.7.0.1
 */