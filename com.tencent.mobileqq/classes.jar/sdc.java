import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.statistics.ReportController;

public class sdc
  implements View.OnClickListener
{
  public sdc(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.a.k();
    ReportController.b(this.a.app, "CliOper", "", "", "0X800568E", "0X800568E", this.a.k, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sdc
 * JD-Core Version:    0.7.0.1
 */