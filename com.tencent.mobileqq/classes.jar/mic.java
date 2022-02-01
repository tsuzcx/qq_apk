import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class mic
  implements DialogInterface.OnClickListener
{
  mic(mhw parammhw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mhw.a(this.a, false);
    if (paramInt == 1)
    {
      bdla.b(null, "CliOper", "", "", "0X800A563", "0X800A563", 0, 0, "", "", "", "");
      this.a.c();
      if (!mvk.a(mhw.a(this.a))) {
        mhw.a(this.a).a(mhw.a(this.a));
      }
    }
    while (paramInt != 0)
    {
      return;
      mhw.a(this.a).b(mhw.a(this.a));
      return;
    }
    mhw.a(this.a, mhw.a(this.a).a().w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mic
 * JD-Core Version:    0.7.0.1
 */