import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mgy
  implements View.OnClickListener
{
  public mgy(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void onClick(View paramView)
  {
    bdla.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "Clk_video", 0, 0, this.a.b, "", "", "");
    this.a.d(2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mgy
 * JD-Core Version:    0.7.0.1
 */