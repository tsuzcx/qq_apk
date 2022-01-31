import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class skm
  implements DialogInterface.OnClickListener
{
  skm(int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    sms.b(112, 2, 0);
    smq.a(117, this.a, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skm
 * JD-Core Version:    0.7.0.1
 */