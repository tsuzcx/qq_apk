import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.statistics.ReportController;

public class jdl
  implements DialogInterface.OnClickListener
{
  public jdl(VideoController paramVideoController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "CliOper", "", "", "0x8006994", "0x8006994", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jdl
 * JD-Core Version:    0.7.0.1
 */