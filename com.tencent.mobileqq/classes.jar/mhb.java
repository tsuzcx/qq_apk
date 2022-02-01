import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class mhb
  implements DialogInterface.OnClickListener
{
  mhb(mgv parammgv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mgv.a(this.a, false);
    if (paramInt == 1)
    {
      bcst.b(null, "CliOper", "", "", "0X800A563", "0X800A563", 0, 0, "", "", "", "");
      this.a.c();
      if (!mue.a(mgv.a(this.a))) {
        mgv.a(this.a).a(mgv.a(this.a));
      }
    }
    while (paramInt != 0)
    {
      return;
      mgv.a(this.a).b(mgv.a(this.a));
      return;
    }
    mgv.a(this.a, mgv.a(this.a).a().w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhb
 * JD-Core Version:    0.7.0.1
 */