import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;

class rqg
  implements DialogInterface.OnClickListener
{
  rqg(rqd paramrqd, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.jdField_a_of_type_Rqd.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Rqd.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramDialogInterface);
    VipUtils.a(this.jdField_a_of_type_Rqd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "activity_alert_view", ApolloUtil.b(this.jdField_a_of_type_Rqd.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + this.jdField_a_of_type_Int, "1" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rqg
 * JD-Core Version:    0.7.0.1
 */