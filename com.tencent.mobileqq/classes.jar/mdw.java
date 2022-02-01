import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mdw
  implements View.OnClickListener
{
  mdw(mdu parammdu) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a().a().av = true;
    mvk.a(this.a.a);
    mdu.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mdw
 * JD-Core Version:    0.7.0.1
 */