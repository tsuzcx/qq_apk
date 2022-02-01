import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.PoiMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nju
  implements View.OnClickListener
{
  public nju(PoiMapActivity paramPoiMapActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nju
 * JD-Core Version:    0.7.0.1
 */