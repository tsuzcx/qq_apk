import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.PrinterSubOptionActivity;
import com.dataline.activities.PrinterSubOptionActivity.PrinterItemAdapter;
import com.dataline.data.PrinterManager;
import com.tencent.mobileqq.app.DataLineHandler;
import java.util.List;

public class cq
  implements View.OnClickListener
{
  public cq(PrinterSubOptionActivity.PrinterItemAdapter paramPrinterItemAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131365561);
    cp localcp;
    if (paramView != null)
    {
      localcp = (cp)this.a.a.b.get(((Integer)paramView.getTag()).intValue());
      if (localcp.jdField_a_of_type_Long == 0L) {
        break label143;
      }
    }
    label143:
    for (paramView = this.a.a.a.a.a(localcp.jdField_a_of_type_Long);; paramView = this.a.a.a.a.b(localcp.jdField_a_of_type_JavaLangString))
    {
      this.a.a.a.a.a = paramView;
      paramView = new Intent();
      paramView.putExtra("sPrinterName", localcp.jdField_a_of_type_JavaLangString);
      paramView.putExtra("sPrintDin", localcp.jdField_a_of_type_Long);
      this.a.a.setResult(-1, paramView);
      this.a.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     cq
 * JD-Core Version:    0.7.0.1
 */