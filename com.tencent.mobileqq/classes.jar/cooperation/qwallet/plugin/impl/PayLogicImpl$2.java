package cooperation.qwallet.plugin.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;

class PayLogicImpl$2
  implements DialogInterface.OnClickListener
{
  PayLogicImpl$2(PayLogicImpl paramPayLogicImpl, String paramString, QBaseActivity paramQBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (!TextUtils.isEmpty(this.val$url))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("url", this.val$url);
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        RouteUtils.a(this.val$activity, localIntent, "/base/browser");
      }
      paramDialogInterface.dismiss();
      this.this$0.end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.PayLogicImpl.2
 * JD-Core Version:    0.7.0.1
 */