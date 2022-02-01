import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ryf
  implements View.OnClickListener
{
  public ryf(EditVideoFragment paramEditVideoFragment) {}
  
  public void onClick(View paramView)
  {
    if ((EditVideoFragment.b(this.a) != null) && (EditVideoFragment.b(this.a).isShowing())) {
      EditVideoFragment.b(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryf
 * JD-Core Version:    0.7.0.1
 */