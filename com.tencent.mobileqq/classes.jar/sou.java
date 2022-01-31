import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;

class sou
  implements DialogInterface.OnClickListener
{
  sou(sot paramsot) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.a.a != null) && (this.a.a.a.isShowing()) && (this.a.a.a.getWindow() != null)) {
      this.a.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sou
 * JD-Core Version:    0.7.0.1
 */