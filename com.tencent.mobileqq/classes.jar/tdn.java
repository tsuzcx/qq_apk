import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;

public class tdn
  implements DialogInterface.OnClickListener
{
  public tdn(NotifyPCActiveActivity paramNotifyPCActiveActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BaseApplicationImpl.getApplication().setPCActiveNotice(null, null, null, null);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tdn
 * JD-Core Version:    0.7.0.1
 */