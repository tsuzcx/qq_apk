import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class skj
  implements DialogInterface.OnClickListener
{
  skj(int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    smp.b(112, 2, 0);
    smn.a(117, this.a, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skj
 * JD-Core Version:    0.7.0.1
 */