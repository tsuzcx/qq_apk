import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class tbw
  implements View.OnClickListener
{
  public tbw(PermisionPrivacyActivity paramPermisionPrivacyActivity, boolean paramBoolean1, SharedPreferences paramSharedPreferences, boolean paramBoolean2) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      paramView = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      paramView.putBoolean("plate_of_king_red_dot_" + this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity.app.c(), true);
      paramView.apply();
      if (this.b) {
        PermisionPrivacyActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity).setRightIcon(null);
      }
    }
    paramView = IndividuationUrlHelper.a("gameIconSetupH5Url");
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity.app.getApp(), QQBrowserActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("vasUsePreWebview", true);
    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity.app.getApp(), paramView, -1L, localIntent, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbw
 * JD-Core Version:    0.7.0.1
 */