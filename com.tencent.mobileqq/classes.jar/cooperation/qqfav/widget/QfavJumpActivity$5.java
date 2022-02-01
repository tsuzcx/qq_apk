package cooperation.qqfav.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class QfavJumpActivity$5
  implements DialogInterface.OnDismissListener
{
  QfavJumpActivity$5(QfavJumpActivity paramQfavJumpActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QfavJumpActivity.a(this.a))
    {
      QfavJumpActivity.a(this.a, false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity.5
 * JD-Core Version:    0.7.0.1
 */