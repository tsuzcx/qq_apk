package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TenpayPlugin$QWalletPayJsPluginResultReceiver
  extends ResultReceiver
{
  private AppInterface mApp;
  protected NativePlugin.JSContext mJsPlugin;
  
  public TenpayPlugin$QWalletPayJsPluginResultReceiver(NativePlugin.JSContext paramJSContext, Handler paramHandler, AppInterface paramAppInterface)
  {
    super(paramHandler);
    this.mJsPlugin = paramJSContext;
    this.mApp = paramAppInterface;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("TenpayPlugin", 2, "resultCode = " + paramInt + " resultData = " + paramBundle);
    }
    if ((this.mJsPlugin == null) || (paramBundle == null)) {
      return;
    }
    if (paramInt == 0) {
      try
      {
        localObject = paramBundle.getString("grapH5CommonHbResult");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramBundle = new JSONObject((String)localObject);
          localObject = TenpayPlugin.access$000(paramBundle.optJSONObject("detail"));
          paramBundle.remove("detail");
          paramBundle.put("detail_data", localObject);
        }
        for (;;)
        {
          this.mJsPlugin.evaluateCallback(true, paramBundle, "");
          return;
          localObject = new JSONObject();
          paramBundle = paramBundle.getString("detail");
          if (!TextUtils.isEmpty(paramBundle))
          {
            paramBundle = TenpayPlugin.access$000(new JSONObject(paramBundle));
            paramBundle.remove("retcode");
            paramBundle.remove("retmsg");
            ((JSONObject)localObject).put("detail_data", paramBundle);
          }
          ((JSONObject)localObject).put("retcode", 0);
          ((JSONObject)localObject).put("retmsg", "ok");
          paramBundle = (Bundle)localObject;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          paramBundle = null;
        }
      }
    }
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getString("retmsg");
        if (TextUtils.isEmpty(paramBundle)) {
          break label277;
        }
        ((JSONObject)localObject).put("retmsg", new JSONObject(paramBundle).optString("err_msg"));
        ((JSONObject)localObject).put("retcode", paramInt);
        paramBundle = (Bundle)localObject;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        paramBundle = (Bundle)localObject;
      }
      break;
      label277:
      ((JSONObject)localObject).put("retmsg", "error when grap hb");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.QWalletPayJsPluginResultReceiver
 * JD-Core Version:    0.7.0.1
 */