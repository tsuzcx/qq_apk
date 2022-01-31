import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class lwt
  implements DialogInterface.OnClickListener
{
  lwt(lws paramlws) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    lwq.a(this.a.a, false);
    if (paramInt == 1)
    {
      awqx.b(null, "CliOper", "", "", "0X800A563", "0X800A563", 0, 0, "", "", "", "");
      this.a.a.c();
      if (!mjg.a(lwq.a(this.a.a))) {
        lwq.a(this.a.a).a(lwq.a(this.a.a));
      }
    }
    while (paramInt != 0)
    {
      return;
      lwq.a(this.a.a).b(lwq.a(this.a.a));
      return;
    }
    lwq.a(this.a.a, lwq.a(this.a.a).a().v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lwt
 * JD-Core Version:    0.7.0.1
 */