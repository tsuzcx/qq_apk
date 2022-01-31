import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.random.RandomController;

public class lvb
  implements DialogInterface.OnClickListener
{
  public lvb(RandomController paramRandomController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RandomController.a(this.a) == 1) {
      azqs.b(null, "CliOper", "", "", "0X80053B4", "0X80053B4", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.c();
      RandomController.d(this.a, false);
      return;
      if (RandomController.a(this.a) == 2) {
        azqs.b(null, "CliOper", "", "", "0X80053C0", "0X80053C0", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lvb
 * JD-Core Version:    0.7.0.1
 */