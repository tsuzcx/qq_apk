import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.MultiVideoEnterPageActivity;

public class mis
  implements DialogInterface.OnClickListener
{
  public mis(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mtq.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mis
 * JD-Core Version:    0.7.0.1
 */