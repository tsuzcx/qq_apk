import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.statistics.ReportController;

public class jea
  implements DialogInterface.OnClickListener
{
  public jea(VideoController paramVideoController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "CliOper", "", "", "0x8006994", "0x8006994", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jea
 * JD-Core Version:    0.7.0.1
 */