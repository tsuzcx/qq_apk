package cooperation.qlink;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import java.util.ArrayList;

class QQProxyForQlink$2
  implements DialogInterface.OnClickListener
{
  QQProxyForQlink$2(QQProxyForQlink paramQQProxyForQlink, ArrayList paramArrayList, Activity paramActivity, int paramInt, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_CooperationQlinkQQProxyForQlink.a("0X8004855", 1);
    this.jdField_a_of_type_CooperationQlinkQQProxyForQlink.a(QQProxyForQlink.a(this.jdField_a_of_type_CooperationQlinkQQProxyForQlink).mPeerUin, this.jdField_a_of_type_JavaUtilArrayList);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("string_filepaths", this.jdField_a_of_type_JavaUtilArrayList);
    localBundle.putBoolean("STRING_CONTINUE_SEND_TO_", true);
    QQProxyForQlink.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, localBundle);
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink.2
 * JD-Core Version:    0.7.0.1
 */