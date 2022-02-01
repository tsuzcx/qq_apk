package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import nuw;
import org.json.JSONException;
import org.json.JSONObject;

class IVOfflinePluginImpl$1
  implements nuw
{
  IVOfflinePluginImpl$1(IVOfflinePluginImpl paramIVOfflinePluginImpl) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(IVOfflinePluginImpl.access$000(this.this$0), 2, "checkOfflineUp, param = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 9)
    {
      try
      {
        localObject = new JSONObject(paramString);
        paramString = (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject;
          localJSONException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(IVOfflinePluginImpl.access$000(this.this$0), 2, "checkUp loaded err:" + paramString);
          }
          paramString = null;
        }
      }
      localObject = IVOfflinePluginImpl.access$100(this.this$0).obtainMessage();
      ((Message)localObject).arg1 = 3;
      ((Message)localObject).obj = paramString;
      IVOfflinePluginImpl.access$100(this.this$0).sendMessage((Message)localObject);
    }
    while (paramInt != -1) {
      return;
    }
    paramString = IVOfflinePluginImpl.access$100(this.this$0).obtainMessage();
    paramString.arg1 = 2;
    IVOfflinePluginImpl.access$100(this.this$0).sendMessage(paramString);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl.1
 * JD-Core Version:    0.7.0.1
 */