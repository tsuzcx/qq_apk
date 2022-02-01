import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.MultiVideoEnterPageActivity;

public class mgx
  implements DialogInterface.OnClickListener
{
  public mgx(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    msa.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mgx
 * JD-Core Version:    0.7.0.1
 */