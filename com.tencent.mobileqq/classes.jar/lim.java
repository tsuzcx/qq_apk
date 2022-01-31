import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.random.RandomController;

public class lim
  implements DialogInterface.OnClickListener
{
  public lim(RandomController paramRandomController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RandomController.a(this.a) == 1) {
      awqx.b(null, "CliOper", "", "", "0X80053B5", "0X80053B5", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.b();
      RandomController.d(this.a, false);
      return;
      if (RandomController.a(this.a) == 2) {
        awqx.b(null, "CliOper", "", "", "0X80053C1", "0X80053C1", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lim
 * JD-Core Version:    0.7.0.1
 */