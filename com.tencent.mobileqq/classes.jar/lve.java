import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.random.RandomController;

public class lve
  implements DialogInterface.OnClickListener
{
  public lve(RandomController paramRandomController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RandomController.a(this.a) == 2) {
      azmj.b(null, "CliOper", "", "", "0X8005729", "0X8005729", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.c();
      return;
      if (RandomController.a(this.a) == 1) {
        azmj.b(null, "CliOper", "", "", "0X8005727", "0X8005727", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lve
 * JD-Core Version:    0.7.0.1
 */