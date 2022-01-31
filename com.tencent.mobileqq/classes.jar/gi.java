import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;

class gi
  implements View.OnClickListener
{
  gi(ge paramge, PrinterItemMsgRecord paramPrinterItemMsgRecord, Context paramContext) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if (2131364990 == paramView.getId())
    {
      paramView = new gj(this);
      gk localgk = new gk(this);
      bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131693914), this.jdField_a_of_type_AndroidContentContext.getString(2131693893), 2131690596, 2131693933, paramView, localgk).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     gi
 * JD-Core Version:    0.7.0.1
 */