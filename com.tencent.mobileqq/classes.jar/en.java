import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.PrinterSubOptionActivity;
import java.util.List;

class en
  implements View.OnClickListener
{
  en(em paramem) {}
  
  public void onClick(View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131363964);
    el localel;
    if (paramView != null)
    {
      localel = (el)this.a.a.b.get(((Integer)paramView.getTag()).intValue());
      if (localel.jdField_a_of_type_Long == 0L) {
        break label143;
      }
    }
    label143:
    for (paramView = this.a.a.a.a.a(localel.jdField_a_of_type_Long);; paramView = this.a.a.a.a.b(localel.jdField_a_of_type_JavaLangString))
    {
      this.a.a.a.a.a = paramView;
      paramView = new Intent();
      paramView.putExtra("sPrinterName", localel.jdField_a_of_type_JavaLangString);
      paramView.putExtra("sPrintDin", localel.jdField_a_of_type_Long);
      this.a.a.setResult(-1, paramView);
      this.a.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     en
 * JD-Core Version:    0.7.0.1
 */