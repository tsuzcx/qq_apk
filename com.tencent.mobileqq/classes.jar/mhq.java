import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mhq
  implements View.OnClickListener
{
  public mhq(QavPanel paramQavPanel) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.a != null)) {
      this.a.a.a.a(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhq
 * JD-Core Version:    0.7.0.1
 */