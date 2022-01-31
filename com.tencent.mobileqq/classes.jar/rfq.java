import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class rfq
  implements View.OnClickListener
{
  public rfq(AddFriendVerifyActivity paramAddFriendVerifyActivity, StringBuffer paramStringBuffer, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_JavaLangStringBuffer.toString();
    int i = 0;
    String str;
    if (i < AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).size())
    {
      str = ((EditText)AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).get(i)).getText().toString().trim();
      if (!"".equals(str)) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131434456), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, "", "", "", "");
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.f)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(this.jdField_a_of_type_Int, this.b);
        return;
        paramView = paramView.replaceFirst("\\$\\{answer\\}", Matcher.quoteReplacement(str));
        i += 1;
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(paramView, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rfq
 * JD-Core Version:    0.7.0.1
 */