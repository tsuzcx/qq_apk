import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class mjy
  implements DialogInterface.OnClickListener
{
  mjy(mjs parammjs) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mjs.a(this.a, false);
    if (paramInt == 1)
    {
      azqs.b(null, "CliOper", "", "", "0X800A563", "0X800A563", 0, 0, "", "", "", "");
      this.a.c();
      if (!mww.a(mjs.a(this.a))) {
        mjs.a(this.a).a(mjs.a(this.a));
      }
    }
    while (paramInt != 0)
    {
      return;
      mjs.a(this.a).b(mjs.a(this.a));
      return;
    }
    mjs.a(this.a, mjs.a(this.a).a().v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mjy
 * JD-Core Version:    0.7.0.1
 */