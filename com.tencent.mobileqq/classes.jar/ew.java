import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ew
  implements View.OnClickListener
{
  ew(es parames, PrinterItemMsgRecord paramPrinterItemMsgRecord, Context paramContext) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if (2131365358 == paramView.getId())
    {
      ex localex = new ex(this);
      ey localey = new ey(this);
      bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131693340), this.jdField_a_of_type_AndroidContentContext.getString(2131693319), 2131690580, 2131693359, localex, localey).show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ew
 * JD-Core Version:    0.7.0.1
 */