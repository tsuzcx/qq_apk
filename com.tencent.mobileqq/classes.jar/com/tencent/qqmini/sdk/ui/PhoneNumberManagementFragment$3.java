package com.tencent.qqmini.sdk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONObject;

class PhoneNumberManagementFragment$3
  implements DialogInterface.OnClickListener
{
  PhoneNumberManagementFragment$3(PhoneNumberManagementFragment paramPhoneNumberManagementFragment, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QMLog.d("PhoneNumberManagementFragment", " click positiveButton");
    if (PhoneNumberManagementFragment.access$000(this.this$0) != null)
    {
      paramDialogInterface = PhoneNumberManagementFragment.access$000(this.this$0).optJSONObject(this.val$position);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.optString("purePhoneNumber");
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).delPhoneNumber(PhoneNumberManagementFragment.access$200(this.this$0), paramDialogInterface, new PhoneNumberManagementFragment.3.1(this, paramDialogInterface));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.PhoneNumberManagementFragment.3
 * JD-Core Version:    0.7.0.1
 */