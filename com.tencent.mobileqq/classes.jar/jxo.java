import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;

public class jxo
  implements View.OnClickListener
{
  public jxo(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void onClick(View paramView)
  {
    QAVGroupConfig.Report.c();
    ReportController.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "Clk_call", 0, 0, this.a.b, "", "", "");
    this.a.c(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxo
 * JD-Core Version:    0.7.0.1
 */