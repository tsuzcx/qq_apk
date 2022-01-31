package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletPayJsPlugin$QWalletPayJsPluginResultReceiver
  extends ResultReceiver
{
  private AppInterface mApp;
  protected QWalletPayJsPlugin mJsPlugin;
  
  public QWalletPayJsPlugin$QWalletPayJsPluginResultReceiver(QWalletPayJsPlugin paramQWalletPayJsPlugin, Handler paramHandler, AppInterface paramAppInterface)
  {
    super(paramHandler);
    this.mJsPlugin = paramQWalletPayJsPlugin;
    this.mApp = paramAppInterface;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPayJsHandler", 2, "resultCode = " + paramInt + " resultData = " + paramBundle);
    }
    if ((this.mJsPlugin == null) || (paramBundle == null)) {
      return;
    }
    String str = "";
    if (paramInt == 0) {}
    try
    {
      Object localObject = paramBundle.getString("grapH5CommonHbResult");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramBundle = new JSONObject((String)localObject);
        localObject = QWalletPayJsPlugin.access$000(paramBundle.optJSONObject("detail"));
        paramBundle.remove("detail");
        paramBundle.put("detail_data", localObject);
      }
      for (paramBundle = paramBundle.toString();; paramBundle = ((JSONObject)localObject).toString())
      {
        QWalletPayJsPlugin.access$100(this.mJsPlugin, paramBundle);
        return;
        localObject = new JSONObject();
        paramBundle = paramBundle.getString("detail");
        if (!TextUtils.isEmpty(paramBundle))
        {
          paramBundle = QWalletPayJsPlugin.access$000(new JSONObject(paramBundle));
          paramBundle.remove("retcode");
          paramBundle.remove("retmsg");
          ((JSONObject)localObject).put("detail_data", paramBundle);
        }
        ((JSONObject)localObject).put("retcode", 0);
        ((JSONObject)localObject).put("retmsg", "ok");
      }
      localObject = new JSONObject();
      for (;;)
      {
        try
        {
          paramBundle = paramBundle.getString("retmsg");
          if (TextUtils.isEmpty(paramBundle)) {
            continue;
          }
          ((JSONObject)localObject).put("retmsg", new JSONObject(paramBundle).optString("err_msg"));
          ((JSONObject)localObject).put("retcode", paramInt);
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          continue;
        }
        paramBundle = ((JSONObject)localObject).toString();
        break;
        ((JSONObject)localObject).put("retmsg", "error when grap hb");
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        paramBundle = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin.QWalletPayJsPluginResultReceiver
 * JD-Core Version:    0.7.0.1
 */