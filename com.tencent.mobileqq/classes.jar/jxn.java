import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class jxn
  implements View.OnClickListener
{
  public jxn(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "Clk_video", 0, 0, this.a.b, "", "", "");
    this.a.c(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxn
 * JD-Core Version:    0.7.0.1
 */