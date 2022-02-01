package cooperation.qlink;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

class QlinkStandardDialogActivity$8
  implements DialogInterface.OnClickListener
{
  QlinkStandardDialogActivity$8(QlinkStandardDialogActivity paramQlinkStandardDialogActivity, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.c.app.getApp().getApplicationContext(), 1, this.a, null, 3002, 14, this.b, null, null, HardCodeUtil.a(2131901576), null);
    localIntent.putExtra("_FROM_QLINK_", true);
    this.c.startActivity(localIntent);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.c, localIntent);
    paramDialogInterface.dismiss();
    this.c.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity.8
 * JD-Core Version:    0.7.0.1
 */