import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class mhv
  implements DialogInterface.OnClickListener
{
  mhv(mht parammht) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.a.a.c();
    mhr.a(this.a.a, false);
    if (paramInt == 1)
    {
      bdll.b(null, "CliOper", "", "", "0X800A565", "0X800A565", 0, 0, "", "", "", "");
      mhr.a(this.a.a);
    }
    while (paramInt != 0) {
      return;
    }
    mhr.a(this.a.a, mhr.a(this.a.a).a().w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhv
 * JD-Core Version:    0.7.0.1
 */