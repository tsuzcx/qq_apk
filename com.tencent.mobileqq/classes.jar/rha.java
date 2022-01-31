import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class rha
  implements DialogInterface.OnClickListener
{
  public rha(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      long l = Long.valueOf(this.a.app.getCurrentAccountUin()).longValue();
      this.a.showDialog(2);
      this.a.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(l, Long.valueOf(this.a.jdField_a_of_type_JavaLangString).longValue(), 1);
      return;
    }
    QQToast.a(this.a, 2131434794, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rha
 * JD-Core Version:    0.7.0.1
 */