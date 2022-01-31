import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class tdi
  implements DialogInterface.OnClickListener
{
  tdi(tdh paramtdh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new tdj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tdi
 * JD-Core Version:    0.7.0.1
 */