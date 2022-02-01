package cooperation.qqreader.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SimpleStyledDialog$2
  implements View.OnClickListener
{
  SimpleStyledDialog$2(SimpleStyledDialog paramSimpleStyledDialog) {}
  
  public void onClick(View paramView)
  {
    if (SimpleStyledDialog.a(this.a))
    {
      if (SimpleStyledDialog.b(this.a)) {
        this.a.dismiss();
      }
      if (SimpleStyledDialog.b(this.a) != null) {
        SimpleStyledDialog.b(this.a).onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.view.SimpleStyledDialog.2
 * JD-Core Version:    0.7.0.1
 */