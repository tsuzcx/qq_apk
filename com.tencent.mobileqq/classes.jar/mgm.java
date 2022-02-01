import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mgm
  implements View.OnClickListener
{
  mgm(mgj parammgj) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a != null) {
      this.a.a.a.j();
    }
    bdla.b(null, "CliOper", "", "", "0X8005DF3", "0X8005DF3", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mgm
 * JD-Core Version:    0.7.0.1
 */