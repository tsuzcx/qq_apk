import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

public class lcr
  implements DialogInterface.OnClickListener
{
  public lcr(VideoController paramVideoController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.b(null, "CliOper", "", "", "0x8006994", "0x8006994", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lcr
 * JD-Core Version:    0.7.0.1
 */