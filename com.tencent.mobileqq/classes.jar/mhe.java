import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class mhe
  implements DialogInterface.OnClickListener
{
  mhe(mhc parammhc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.a.a.c();
    mha.a(this.a.a, false);
    if (paramInt == 1)
    {
      bcef.b(null, "CliOper", "", "", "0X800A565", "0X800A565", 0, 0, "", "", "", "");
      mha.a(this.a.a);
    }
    while (paramInt != 0) {
      return;
    }
    mha.a(this.a.a, mha.a(this.a.a).a().w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhe
 * JD-Core Version:    0.7.0.1
 */