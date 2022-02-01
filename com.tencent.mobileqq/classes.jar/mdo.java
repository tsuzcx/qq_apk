import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mdo
  implements View.OnClickListener
{
  public mdo(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mdo
 * JD-Core Version:    0.7.0.1
 */