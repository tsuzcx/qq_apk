import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class jyc
  implements View.OnClickListener
{
  public jyc(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "Clk_video", 0, 0, this.a.b, "", "", "");
    this.a.c(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyc
 * JD-Core Version:    0.7.0.1
 */