import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.dataline.activities.PrinterOptionActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class cx
  implements CompoundButton.OnCheckedChangeListener
{
  public cx(PrinterOptionActivity paramPrinterOptionActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      PrinterOptionActivity.a(this.a).setVisibility(0);
      PrinterOptionActivity.a(this.a).setText(2131691252);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (PrinterOptionActivity.b(this.a))
      {
        PrinterOptionActivity.a(this.a).setVisibility(0);
        PrinterOptionActivity.a(this.a).setText(2131691232);
      }
      else
      {
        PrinterOptionActivity.a(this.a).setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cx
 * JD-Core Version:    0.7.0.1
 */