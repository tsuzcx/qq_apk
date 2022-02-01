package com.tencent.mobileqq.vashealth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class PathTraceManager$7
  extends Handler
{
  PathTraceManager$7(PathTraceManager paramPathTraceManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      try
      {
        paramMessage = (JSONObject)paramMessage.obj;
        String str = paramMessage.getString("callback");
        if (this.a.a != null)
        {
          HealthPathTracePlugin localHealthPathTracePlugin = (HealthPathTracePlugin)this.a.a.get();
          if (localHealthPathTracePlugin != null)
          {
            localHealthPathTracePlugin.callJs(str, new String[] { paramMessage.toString() });
            return;
          }
        }
      }
      catch (Exception paramMessage) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.PathTraceManager.7
 * JD-Core Version:    0.7.0.1
 */