package cooperation.troop_homework.outer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopHWRecordBaseActivity$1
  implements View.OnClickListener
{
  TroopHWRecordBaseActivity$1(TroopHWRecordBaseActivity paramTroopHWRecordBaseActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.a.a)
      {
        this.a.setResult(0);
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop_homework.outer.TroopHWRecordBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */