package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.pluginshare.ITenCookie;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletCommonJsPlugin$MyResultRecevicer
  extends ResultReceiver
{
  protected QWalletCommonJsPlugin mJsPlugin;
  
  public QWalletCommonJsPlugin$MyResultRecevicer(QWalletCommonJsPlugin paramQWalletCommonJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.mJsPlugin = paramQWalletCommonJsPlugin;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resultCode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" resultData = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.i("QWalletCommonJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mJsPlugin != null)
    {
      if (paramBundle == null) {
        return;
      }
      paramBundle = paramBundle.getString("detail");
      if ((TextUtils.isEmpty(QWalletCommonJsPlugin.mParamForGarpHb)) && (!TextUtils.isEmpty(QWalletCommonJsPlugin.mListid))) {
        QWalletCommonJsPlugin.mParamForGarpHb = ((ITenCookie)QRoute.api(ITenCookie.class)).getTempArgs(QWalletCommonJsPlugin.mListid);
      }
      if (paramInt == 0)
      {
        localObject = new JSONObject();
        try
        {
          if (!TextUtils.isEmpty(QWalletCommonJsPlugin.mParamForGarpHb)) {
            ((JSONObject)localObject).put("param", QWalletCommonJsPlugin.mParamForGarpHb);
          }
          if (!TextUtils.isEmpty(paramBundle)) {
            ((JSONObject)localObject).put("detail", paramBundle);
          }
          paramBundle = ((JSONObject)localObject).toString();
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
      else
      {
        paramBundle = "";
      }
      QWalletCommonJsPlugin.access$400(this.mJsPlugin, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.MyResultRecevicer
 * JD-Core Version:    0.7.0.1
 */