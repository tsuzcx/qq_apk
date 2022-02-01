package com.tencent.viola.module;

import android.os.Handler;
import android.os.Message;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Map;
import org.json.JSONObject;

class V8JSTimerModule$TimerHandler
  extends Handler
{
  public V8JSTimerModule$TimerHandler(V8JSTimerModule paramV8JSTimerModule) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    try
    {
      localObject1 = (V8JSTimerModule.TimerParam)paramMessage.obj;
      if (localObject1 == null) {
        return;
      }
      this.this$0.timeoutMap.remove(Integer.valueOf(((V8JSTimerModule.TimerParam)localObject1).timerId));
      paramMessage = ((V8JSTimerModule.TimerParam)localObject1).v8Function;
      if (paramMessage == null) {
        return;
      }
      int i = ((V8JSTimerModule.TimerParam)localObject1).timerId;
      Object localObject2 = this.this$0.getViolaInstance();
      if (!((V8JSTimerModule.TimerParam)localObject1).v8Function.isReleased())
      {
        if (localObject2 == null) {
          return;
        }
        localObject2 = ((V8JSTimerModule.TimerParam)localObject1).v8Function.getRuntime();
        if ((localObject2 != null) && (!((V8)localObject2).isReleased()))
        {
          localObject1 = new JSONObject();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("timerId", i);
          ((JSONObject)localObject1).put("ret", 0);
          ((JSONObject)localObject1).put("data", localJSONObject);
          localObject2 = new V8Array((V8)localObject2);
          ((V8Array)localObject2).push(((JSONObject)localObject1).toString());
          paramMessage.call(null, (V8Array)localObject2);
          ((V8Array)localObject2).close();
          paramMessage.close();
          return;
        }
        ViolaLogUtils.d("JSTimerModule", "v8 runtime has release");
      }
      return;
    }
    catch (Exception paramMessage)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleMessage Exception e:");
      ((StringBuilder)localObject1).append(paramMessage.getMessage());
      ViolaLogUtils.e("JSTimerModule", ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.module.V8JSTimerModule.TimerHandler
 * JD-Core Version:    0.7.0.1
 */