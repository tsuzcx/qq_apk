import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sue
  implements View.OnClickListener
{
  sue(sud paramsud) {}
  
  public void onClick(View paramView)
  {
    sud.a(true, -1, sud.a(this.a));
    if (sud.a(this.a) != null) {
      sud.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sue
 * JD-Core Version:    0.7.0.1
 */