package cooperation.qqreader.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForceUserUpdateActivity$7
  implements View.OnClickListener
{
  ForceUserUpdateActivity$7(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ForceUserUpdateActivity.7
 * JD-Core Version:    0.7.0.1
 */