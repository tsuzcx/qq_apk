import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class mhx
  implements DialogInterface.OnClickListener
{
  mhx(mhr parammhr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mhr.a(this.a, false);
    if (paramInt == 1)
    {
      bdll.b(null, "CliOper", "", "", "0X800A563", "0X800A563", 0, 0, "", "", "", "");
      this.a.c();
      if (!mvd.a(mhr.a(this.a))) {
        mhr.a(this.a).a(mhr.a(this.a));
      }
    }
    while (paramInt != 0)
    {
      return;
      mhr.a(this.a).b(mhr.a(this.a));
      return;
    }
    mhr.a(this.a, mhr.a(this.a).a().w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhx
 * JD-Core Version:    0.7.0.1
 */