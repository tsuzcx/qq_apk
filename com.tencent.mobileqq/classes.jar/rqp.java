import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;

public class rqp
  implements DialogInterface.OnClickListener
{
  public rqp(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ReportController.b(this.a.a, "dc00898", "", "", "0X80081B9", "0X80081B9", 1, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.a.a, "dc00898", "", "", "0X80081B9", "0X80081B9", 1, 1, "", "", "", "");
    this.a.b(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rqp
 * JD-Core Version:    0.7.0.1
 */