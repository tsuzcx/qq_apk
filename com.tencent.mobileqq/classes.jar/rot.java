import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rot
  implements View.OnClickListener
{
  rot(roq paramroq) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)this.a.a);
    bcef.b(roq.a(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rot
 * JD-Core Version:    0.7.0.1
 */