import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class mjw
  implements DialogInterface.OnClickListener
{
  mjw(mju parammju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.a.a.c();
    mjs.a(this.a.a, false);
    if (paramInt == 1)
    {
      azqs.b(null, "CliOper", "", "", "0X800A565", "0X800A565", 0, 0, "", "", "", "");
      mjs.a(this.a.a);
    }
    while (paramInt != 0) {
      return;
    }
    mjs.a(this.a.a, mjs.a(this.a.a).a().v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mjw
 * JD-Core Version:    0.7.0.1
 */