import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class osh
  implements View.OnClickListener
{
  osh(osg paramosg) {}
  
  public void onClick(View paramView)
  {
    oqj.a(osg.a(this.a), 1000, null);
    ubb.a((Activity)osg.a(this.a), osg.a(this.a), osg.a(this.a).a(), osg.a(this.a).e(), false, oqi.b(osg.a(this.a)), new oml());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osh
 * JD-Core Version:    0.7.0.1
 */