import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.random.RandomController;

public class lii
  implements DialogInterface.OnClickListener
{
  public lii(RandomController paramRandomController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RandomController.a(this.a) == 1) {
      awqx.b(null, "CliOper", "", "", "0X80053B4", "0X80053B4", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.a.c();
      RandomController.d(this.a, false);
      return;
      if (RandomController.a(this.a) == 2) {
        awqx.b(null, "CliOper", "", "", "0X80053C0", "0X80053C0", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lii
 * JD-Core Version:    0.7.0.1
 */