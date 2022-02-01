package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.os.Handler;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class IVOfflinePluginImpl$1
  implements AsyncBack
{
  IVOfflinePluginImpl$1(IVOfflinePluginImpl paramIVOfflinePluginImpl) {}
  
  public void loaded(String paramString, int paramInt)
  {
    Object localObject1;
    StringBuilder localStringBuilder1;
    if (QLog.isColorLevel())
    {
      localObject1 = IVOfflinePluginImpl.access$000(this.this$0);
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("checkOfflineUp, param = ");
      localStringBuilder1.append(paramString);
      localStringBuilder1.append(" code = ");
      localStringBuilder1.append(paramInt);
      QLog.i((String)localObject1, 2, localStringBuilder1.toString());
    }
    if (paramInt == 9)
    {
      localStringBuilder1 = null;
      Object localObject2;
      try
      {
        localObject1 = new JSONObject(paramString);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject2 = localStringBuilder1;
        if (QLog.isColorLevel())
        {
          localObject2 = IVOfflinePluginImpl.access$000(this.this$0);
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("checkUp loaded err:");
          localStringBuilder2.append(paramString);
          QLog.i((String)localObject2, 2, localStringBuilder2.toString());
          localObject2 = localStringBuilder1;
        }
      }
      paramString = IVOfflinePluginImpl.access$100(this.this$0).obtainMessage();
      paramString.arg1 = 3;
      paramString.obj = localObject2;
      IVOfflinePluginImpl.access$100(this.this$0).sendMessage(paramString);
      return;
    }
    if (paramInt == -1)
    {
      paramString = IVOfflinePluginImpl.access$100(this.this$0).obtainMessage();
      paramString.arg1 = 2;
      IVOfflinePluginImpl.access$100(this.this$0).sendMessage(paramString);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl.1
 * JD-Core Version:    0.7.0.1
 */