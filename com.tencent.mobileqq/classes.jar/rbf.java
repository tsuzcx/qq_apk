import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rbf
  implements View.OnClickListener
{
  rbf(rbe paramrbe) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (rbe.a(this.a) != null) {
      rbe.a(this.a).a(paramView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbf
 * JD-Core Version:    0.7.0.1
 */