import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.dataline.activities.PrinterOptionActivity;

public class cq
  implements CompoundButton.OnCheckedChangeListener
{
  public cq(PrinterOptionActivity paramPrinterOptionActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      PrinterOptionActivity.a(this.a).setVisibility(0);
      PrinterOptionActivity.a(this.a).setText(2131625800);
      return;
    }
    if (PrinterOptionActivity.b(this.a))
    {
      PrinterOptionActivity.a(this.a).setVisibility(0);
      PrinterOptionActivity.a(this.a).setText(2131625780);
      return;
    }
    PrinterOptionActivity.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     cq
 * JD-Core Version:    0.7.0.1
 */