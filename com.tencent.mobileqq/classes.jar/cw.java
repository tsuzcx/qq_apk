import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.PrinterSubOptionActivity;
import java.util.List;

class cw
  implements View.OnClickListener
{
  cw(cv paramcv) {}
  
  public void onClick(View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131364021);
    cu localcu;
    if (paramView != null)
    {
      localcu = (cu)this.a.a.b.get(((Integer)paramView.getTag()).intValue());
      if (localcu.jdField_a_of_type_Long == 0L) {
        break label143;
      }
    }
    label143:
    for (paramView = this.a.a.a.a.a(localcu.jdField_a_of_type_Long);; paramView = this.a.a.a.a.b(localcu.jdField_a_of_type_JavaLangString))
    {
      this.a.a.a.a.a = paramView;
      paramView = new Intent();
      paramView.putExtra("sPrinterName", localcu.jdField_a_of_type_JavaLangString);
      paramView.putExtra("sPrintDin", localcu.jdField_a_of_type_Long);
      this.a.a.setResult(-1, paramView);
      this.a.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cw
 * JD-Core Version:    0.7.0.1
 */