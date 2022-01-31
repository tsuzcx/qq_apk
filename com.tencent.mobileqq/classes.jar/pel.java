import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.widgets.ShareResultDialog;

public class pel
  implements View.OnClickListener
{
  public pel(ShareResultDialog paramShareResultDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog, -2);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     pel
 * JD-Core Version:    0.7.0.1
 */