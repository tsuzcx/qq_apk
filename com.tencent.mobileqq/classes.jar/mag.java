import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mqq.app.BaseActivity;

class mag
  implements DialogInterface.OnClickListener
{
  mag(maf parammaf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    maf.a(this.a, null);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mag
 * JD-Core Version:    0.7.0.1
 */