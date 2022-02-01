package com.tencent.mobileqq.qwallet.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.IPublicQuickPayService.QQWalletPayCompletionImp;
import org.json.JSONException;
import org.json.JSONObject;

class PublicQuickPayServiceImpl$1
  extends ResultReceiver
{
  PublicQuickPayServiceImpl$1(PublicQuickPayServiceImpl paramPublicQuickPayServiceImpl, Handler paramHandler, Context paramContext, IPublicQuickPayService.QQWalletPayCompletionImp paramQQWalletPayCompletionImp, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    String str = paramBundle.getString("result");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        paramInt = new JSONObject(str).optInt("resultCode", -2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    } else {
      paramInt = -2;
    }
    if ((paramInt == -3) || (paramInt == -4) || (paramInt == -6)) {
      PublicQuickPayServiceImpl.access$000(this.d, this.a);
    }
    PublicQuickPayServiceImpl.access$100(this.d, this.b, paramInt, paramBundle.getString("retmsg"), paramBundle.getString("payTime"), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.PublicQuickPayServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */