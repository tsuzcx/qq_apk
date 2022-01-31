import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.CallbackWaitingActivityExt;

class jtn
  implements DialogInterface.OnClickListener
{
  jtn(jti paramjti) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jtn
 * JD-Core Version:    0.7.0.1
 */