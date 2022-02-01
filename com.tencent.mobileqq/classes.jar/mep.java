import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mep
  implements View.OnClickListener
{
  public mep(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mep
 * JD-Core Version:    0.7.0.1
 */