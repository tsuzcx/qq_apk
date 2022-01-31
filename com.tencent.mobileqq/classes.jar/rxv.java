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

class rxv
  implements DialogInterface.OnClickListener
{
  rxv(rxu paramrxu, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ApolloConstant.I + "&actionId=" + this.jdField_a_of_type_Int + "&_bid=2282";
    Intent localIntent = new Intent(this.jdField_a_of_type_Rxu.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramDialogInterface);
    this.jdField_a_of_type_Rxu.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
    VipUtils.a(this.jdField_a_of_type_Rxu.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_view", ApolloUtil.b(this.jdField_a_of_type_Rxu.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + this.jdField_a_of_type_Int, "1" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rxv
 * JD-Core Version:    0.7.0.1
 */