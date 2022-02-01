import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.MultiVideoEnterPageActivity;

public class mgs
  implements DialogInterface.OnClickListener
{
  public mgs(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mru.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mgs
 * JD-Core Version:    0.7.0.1
 */