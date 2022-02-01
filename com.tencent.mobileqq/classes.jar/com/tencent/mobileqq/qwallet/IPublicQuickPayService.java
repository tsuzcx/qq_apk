package com.tencent.mobileqq.qwallet;

import android.content.Context;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Service(process={""})
public abstract interface IPublicQuickPayService
  extends IRuntimeService
{
  public abstract boolean publicQuickPay(String paramString, JSONObject paramJSONObject, Context paramContext, IPublicQuickPayService.QQWalletPayCompletionImp paramQQWalletPayCompletionImp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.IPublicQuickPayService
 * JD-Core Version:    0.7.0.1
 */