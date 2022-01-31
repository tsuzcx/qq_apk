import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class mhg
  implements DialogInterface.OnClickListener
{
  mhg(mha parammha) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mha.a(this.a, false);
    if (paramInt == 1)
    {
      axqy.b(null, "CliOper", "", "", "0X800A563", "0X800A563", 0, 0, "", "", "", "");
      this.a.c();
      if (!muc.a(mha.a(this.a))) {
        mha.a(this.a).a(mha.a(this.a));
      }
    }
    while (paramInt != 0)
    {
      return;
      mha.a(this.a).b(mha.a(this.a));
      return;
    }
    mha.a(this.a, mha.a(this.a).a().v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mhg
 * JD-Core Version:    0.7.0.1
 */