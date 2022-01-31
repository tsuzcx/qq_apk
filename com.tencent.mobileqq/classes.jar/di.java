import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class di
  implements View.OnClickListener
{
  public di(PrinterSessionAdapter paramPrinterSessionAdapter, PrinterItemMsgRecord paramPrinterItemMsgRecord, Context paramContext) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if (2131375572 == paramView.getId())
    {
      paramView = new dj(this);
      dk localdk = new dk(this);
      DialogUtil.b(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131427500), this.jdField_a_of_type_AndroidContentContext.getString(2131427526), 2131433015, 2131427501, paramView, localdk).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     di
 * JD-Core Version:    0.7.0.1
 */