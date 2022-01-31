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

public class rgq
  implements View.OnClickListener
{
  public rgq(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    paramView = AddFriendVerifyActivity.a(this.a).getText().toString().trim();
    if (TextUtils.isEmpty(paramView))
    {
      if (!this.a.isFinishing())
      {
        paramView = new QQAnonymousDialog(this.a);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText("请输入答案");
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845946);
        paramView.a();
      }
      return;
    }
    if (paramView.length() > 90)
    {
      paramView = new Dialog(this.a, 2131624515);
      paramView.setContentView(2130971460);
      ((TextView)paramView.findViewById(2131362758)).setText(this.a.getString(2131434767));
      ((ProgressBar)paramView.findViewById(2131362757)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131374062)).setImageResource(2130838748);
      paramView.show();
      return;
    }
    this.a.a(paramView, true);
    if (NetworkUtil.d(this.a))
    {
      AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), paramView, this.a.getIntent().getIntExtra("stat_option", 0));
      return;
    }
    QQToast.a(this.a, 1, 2131434794, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rgq
 * JD-Core Version:    0.7.0.1
 */