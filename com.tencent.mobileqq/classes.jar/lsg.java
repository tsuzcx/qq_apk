import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.random.RandomController;

public class lsg
  implements DialogInterface.OnClickListener
{
  public lsg(RandomController paramRandomController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RandomController.a(this.a) == 2) {
      bcst.b(null, "CliOper", "", "", "0X8005729", "0X8005729", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.c();
      return;
      if (RandomController.a(this.a) == 1) {
        bcst.b(null, "CliOper", "", "", "0X8005727", "0X8005727", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lsg
 * JD-Core Version:    0.7.0.1
 */