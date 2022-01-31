import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class rwc
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bcgo.a().a(rwb.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rwc
 * JD-Core Version:    0.7.0.1
 */