import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class mia
  implements DialogInterface.OnClickListener
{
  mia(mhy parammhy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.a.a.c();
    mhw.a(this.a.a, false);
    if (paramInt == 1)
    {
      bdla.b(null, "CliOper", "", "", "0X800A565", "0X800A565", 0, 0, "", "", "", "");
      mhw.a(this.a.a);
    }
    while (paramInt != 0) {
      return;
    }
    mhw.a(this.a.a, mhw.a(this.a.a).a().w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mia
 * JD-Core Version:    0.7.0.1
 */