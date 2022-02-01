import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.PrinterSubOptionActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class db
  implements View.OnClickListener
{
  db(da paramda) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (TextView)paramView.findViewById(2131364269);
    cz localcz;
    if (localObject != null)
    {
      localcz = (cz)this.a.a.b.get(((Integer)((TextView)localObject).getTag()).intValue());
      if (localcz.jdField_a_of_type_Long == 0L) {
        break label150;
      }
    }
    label150:
    for (localObject = this.a.a.a.a.a(localcz.jdField_a_of_type_Long);; localObject = this.a.a.a.a.b(localcz.jdField_a_of_type_JavaLangString))
    {
      this.a.a.a.a.a = ((dj)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("sPrinterName", localcz.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("sPrintDin", localcz.jdField_a_of_type_Long);
      this.a.a.setResult(-1, (Intent)localObject);
      this.a.a.finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     db
 * JD-Core Version:    0.7.0.1
 */