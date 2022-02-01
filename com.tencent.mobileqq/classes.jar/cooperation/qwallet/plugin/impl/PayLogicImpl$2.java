package cooperation.qwallet.plugin.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;

class PayLogicImpl$2
  implements DialogInterface.OnClickListener
{
  PayLogicImpl$2(PayLogicImpl paramPayLogicImpl, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if ((!TextUtils.isEmpty(this.val$url)) && (BaseActivity.sTopActivity != null))
      {
        Intent localIntent = new Intent(BaseActivity.sTopActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", this.val$url);
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        PayLogicImpl.access$000(this.this$0).startActivity(localIntent);
      }
      paramDialogInterface.dismiss();
      this.this$0.end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.PayLogicImpl.2
 * JD-Core Version:    0.7.0.1
 */