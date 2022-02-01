import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class okq
  implements bkzq
{
  okq(okn paramokn, QQAppInterface paramQQAppInterface, Context paramContext, Uri paramUri, SessionInfo paramSessionInfo, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    case 0: 
      aftr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramView = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
      if (paramView != null) {
        paramView.putString("LastScreenShotUri", null).apply();
      }
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    aftr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null);
    this.jdField_a_of_type_Bkzi.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okq
 * JD-Core Version:    0.7.0.1
 */