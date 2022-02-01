import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class mgy
  implements DialogInterface.OnClickListener
{
  mgy(mgx parammgx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mgv.a(this.a.a, false);
    if (paramInt == 1)
    {
      bcst.b(null, "CliOper", "", "", "0X800A563", "0X800A563", 0, 0, "", "", "", "");
      this.a.a.c();
      if (!mue.a(mgv.a(this.a.a))) {
        mgv.a(this.a.a).a(mgv.a(this.a.a));
      }
    }
    while (paramInt != 0)
    {
      return;
      mgv.a(this.a.a).b(mgv.a(this.a.a));
      return;
    }
    mgv.a(this.a.a, mgv.a(this.a.a).a().w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mgy
 * JD-Core Version:    0.7.0.1
 */