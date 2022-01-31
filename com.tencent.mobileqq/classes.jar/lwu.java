import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class lwu
  implements DialogInterface.OnClickListener
{
  lwu(lws paramlws) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.a.a.c();
    lwq.a(this.a.a, false);
    if (paramInt == 1)
    {
      awqx.b(null, "CliOper", "", "", "0X800A565", "0X800A565", 0, 0, "", "", "", "");
      lwq.a(this.a.a);
    }
    while (paramInt != 0) {
      return;
    }
    lwq.a(this.a.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lwu
 * JD-Core Version:    0.7.0.1
 */