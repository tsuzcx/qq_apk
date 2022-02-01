import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class mgz
  implements DialogInterface.OnClickListener
{
  mgz(mgx parammgx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.a.a.c();
    mgv.a(this.a.a, false);
    if (paramInt == 1)
    {
      bcst.b(null, "CliOper", "", "", "0X800A565", "0X800A565", 0, 0, "", "", "", "");
      mgv.a(this.a.a);
    }
    while (paramInt != 0) {
      return;
    }
    mgv.a(this.a.a, mgv.a(this.a.a).a().w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mgz
 * JD-Core Version:    0.7.0.1
 */