import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;

class rqf
  implements DialogInterface.OnClickListener
{
  rqf(rqd paramrqd, int paramInt, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ApolloConstant.I + "&actionId=" + this.jdField_a_of_type_Int + "&_bid=2282";
    Intent localIntent = new Intent(this.jdField_a_of_type_Rqd.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramDialogInterface);
    this.jdField_a_of_type_Rqd.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
    paramDialogInterface = this.jdField_a_of_type_Rqd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = ApolloUtil.b(this.jdField_a_of_type_Rqd.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 0;; paramInt = 1)
    {
      VipUtils.a(paramDialogInterface, "cmshow", "Apollo", "level_alert_view", i, paramInt, new String[] { "" + this.jdField_a_of_type_Int, "1" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rqf
 * JD-Core Version:    0.7.0.1
 */