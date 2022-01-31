import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.PrinterSubOptionActivity;
import java.util.List;

class cu
  implements View.OnClickListener
{
  cu(ct paramct) {}
  
  public void onClick(View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131298408);
    cs localcs;
    if (paramView != null)
    {
      localcs = (cs)this.a.a.b.get(((Integer)paramView.getTag()).intValue());
      if (localcs.jdField_a_of_type_Long == 0L) {
        break label143;
      }
    }
    label143:
    for (paramView = this.a.a.a.a.a(localcs.jdField_a_of_type_Long);; paramView = this.a.a.a.a.b(localcs.jdField_a_of_type_JavaLangString))
    {
      this.a.a.a.a.a = paramView;
      paramView = new Intent();
      paramView.putExtra("sPrinterName", localcs.jdField_a_of_type_JavaLangString);
      paramView.putExtra("sPrintDin", localcs.jdField_a_of_type_Long);
      this.a.a.setResult(-1, paramView);
      this.a.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     cu
 * JD-Core Version:    0.7.0.1
 */