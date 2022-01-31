import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.av.utils.PstnUtils;

class jzf
  implements DialogInterface.OnClickListener
{
  jzf(jzd paramjzd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.finish();
    PstnUtils.a(this.a.a.app, this.a.a, 1, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzf
 * JD-Core Version:    0.7.0.1
 */