import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.dataline.activities.PrinterOptionActivity;

public class ej
  implements CompoundButton.OnCheckedChangeListener
{
  public ej(PrinterOptionActivity paramPrinterOptionActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      PrinterOptionActivity.a(this.a).setVisibility(0);
      PrinterOptionActivity.a(this.a).setText(2131691376);
      return;
    }
    if (PrinterOptionActivity.b(this.a))
    {
      PrinterOptionActivity.a(this.a).setVisibility(0);
      PrinterOptionActivity.a(this.a).setText(2131691356);
      return;
    }
    PrinterOptionActivity.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ej
 * JD-Core Version:    0.7.0.1
 */