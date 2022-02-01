package cooperation.qlink;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class QlinkShareJumpActivity$7
  implements DialogInterface.OnDismissListener
{
  QlinkShareJumpActivity$7(QlinkShareJumpActivity paramQlinkShareJumpActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QlinkShareJumpActivity.a(this.a))
    {
      QlinkShareJumpActivity.a(this.a, false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkShareJumpActivity.7
 * JD-Core Version:    0.7.0.1
 */