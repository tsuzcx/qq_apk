import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class cv
  implements View.OnClickListener
{
  public cv(PrinterDefaultActivity paramPrinterDefaultActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cv
 * JD-Core Version:    0.7.0.1
 */