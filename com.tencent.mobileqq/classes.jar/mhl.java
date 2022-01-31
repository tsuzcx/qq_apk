import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class mhl
  implements DialogInterface.OnClickListener
{
  mhl(mhf parammhf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mhf.a(this.a, false);
    if (paramInt == 1)
    {
      axqw.b(null, "CliOper", "", "", "0X800A563", "0X800A563", 0, 0, "", "", "", "");
      this.a.c();
      if (!muf.a(mhf.a(this.a))) {
        mhf.a(this.a).a(mhf.a(this.a));
      }
    }
    while (paramInt != 0)
    {
      return;
      mhf.a(this.a).b(mhf.a(this.a));
      return;
    }
    mhf.a(this.a, mhf.a(this.a).a().v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mhl
 * JD-Core Version:    0.7.0.1
 */