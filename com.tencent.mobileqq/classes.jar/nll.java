import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nll
  implements View.OnClickListener
{
  public nll(GuessPictureStageView paramGuessPictureStageView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nll
 * JD-Core Version:    0.7.0.1
 */