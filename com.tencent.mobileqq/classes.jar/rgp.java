import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;

public class rgp
  implements View.OnClickListener
{
  public rgp(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getWindow().setSoftInputMode(2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).clearFocus();
    }
    paramView = AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).getText().toString();
    if (TextUtils.isEmpty(paramView))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.isFinishing())
      {
        paramView = new QQAnonymousDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText("请输入答案");
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843243);
        paramView.a();
      }
      return;
    }
    if (!paramView.equals(this.jdField_a_of_type_JavaLangString))
    {
      AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).setVisibility(0);
      return;
    }
    AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).setVisibility(8);
    if (paramView.length() > 90)
    {
      paramView = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 2131624515);
      paramView.setContentView(2130971460);
      ((TextView)paramView.findViewById(2131362758)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131434767));
      ((ProgressBar)paramView.findViewById(2131362757)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131374062)).setImageResource(2130838748);
      paramView.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).getText().toString(), true);
    if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))
    {
      AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity), AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).getText().toString(), this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getIntent().getIntExtra("stat_option", 0));
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1, 2131434794, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rgp
 * JD-Core Version:    0.7.0.1
 */