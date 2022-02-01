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
    this.e.a("0X8004855", 1);
    Object localObject = this.e;
    ((QQProxyForQlink)localObject).a(QQProxyForQlink.c((QQProxyForQlink)localObject).mPeerUin, this.a);
    localObject = new Bundle();
    ((Bundle)localObject).putStringArrayList("string_filepaths", this.a);
    ((Bundle)localObject).putBoolean("STRING_CONTINUE_SEND_TO_", true);
    QQProxyForQlink.a(this.b, this.c, (Bundle)localObject);
    paramDialogInterface.dismiss();
    if (this.d) {
      this.b.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink.2
 * JD-Core Version:    0.7.0.1
 */