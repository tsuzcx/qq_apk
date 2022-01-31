package com.tencent.mobileqq.vashealth;

import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class SportRemoteCommond
  extends RemoteCommand
{
  public SportRemoteCommond()
  {
    super("running_plugin_cmd");
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramOnInvokeFinishLinstener != null) && ((paramOnInvokeFinishLinstener instanceof QQAppInterface))) {}
    for (paramOnInvokeFinishLinstener = (QQAppInterface)paramOnInvokeFinishLinstener;; paramOnInvokeFinishLinstener = null)
    {
      switch (paramBundle.getInt("CommondType"))
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
              if (paramOnInvokeFinishLinstener == null) {
                break;
              }
              paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.getHandler(Conversation.class);
            } while (paramOnInvokeFinishLinstener == null);
            try
            {
              Message localMessage = paramOnInvokeFinishLinstener.obtainMessage(1134043);
              long l = paramBundle.getLong("runningState");
              paramBundle = paramBundle.getString("cookieUrl");
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("runningState", l);
              localJSONObject.put("cookieUrl", paramBundle);
              localMessage.obj = localJSONObject;
              paramOnInvokeFinishLinstener.sendMessage(localMessage);
              return null;
            }
            catch (JSONException paramBundle)
            {
              return null;
            }
          } while (!QLog.isColorLevel());
          QLog.e("SportRemoteCommond", 2, "showRunningBar null");
          return null;
        } while (paramOnInvokeFinishLinstener == null);
        paramBundle = paramOnInvokeFinishLinstener.getHandler(Conversation.class);
      } while (paramBundle == null);
      paramBundle.sendMessageDelayed(paramBundle.obtainMessage(1134044), 1000L);
      paramBundle.sendMessageDelayed(paramBundle.obtainMessage(1134040), 1000L);
      paramBundle.sendMessageDelayed(paramBundle.obtainMessage(1134050), 1000L);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SportRemoteCommond
 * JD-Core Version:    0.7.0.1
 */