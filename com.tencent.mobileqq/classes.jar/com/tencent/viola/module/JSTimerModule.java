package com.tencent.viola.module;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JSTimerModule
  extends BaseModule
  implements Handler.Callback, Destroyable
{
  public static final String CALLBACK = "callback";
  public static final String DELAY = "delay";
  public static final String METHOD_CLEARTIMEOUT = "clearTimeout";
  public static final String METHOD_SETTIMEOUT = "setTimeout";
  public static final String MODULE_NAME = "jsTimer";
  public static final int MSG_TIMEOUT = 1;
  public static final String TIMERID = "timerId";
  public final String TAG = "JSTimerModule";
  private Handler handler = new Handler(this);
  public Map<Integer, Object> timeoutMap = new HashMap();
  private int timerCount = 0;
  
  @JSMethod(uiThread=false)
  public void clearTimeout(@IntRange(from=0L) int paramInt)
  {
    this.handler.removeMessages(1, this.timeoutMap.get(Integer.valueOf(paramInt)));
  }
  
  public void destroy()
  {
    Object localObject = this.handler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.timeoutMap;
    if ((localObject != null) && (((Map)localObject).size() > 0)) {
      this.timeoutMap.clear();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    if (paramMessage.getData() == null) {
      return false;
    }
    Object localObject = paramMessage.getData().getString("callback");
    int i = paramMessage.arg1;
    if (getViolaInstance() != null) {
      try
      {
        paramMessage = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("timerId", i);
        paramMessage.put("ret", 0);
        paramMessage.put("data", localJSONObject);
        ViolaBridgeManager.getInstance().execJSFuncByName(null, (String)localObject, paramMessage.toString());
        return false;
      }
      catch (JSONException paramMessage)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMessage JSONException e:");
        ((StringBuilder)localObject).append(paramMessage.getMessage());
        ViolaLogUtils.e("JSTimerModule", ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  @JSMethod(uiThread=false)
  public void setTimeout(@NonNull String paramString, @IntRange(from=0L) int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("functId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" delay:");
    ((StringBuilder)localObject).append(paramInt);
    ViolaLogUtils.d("JSTimerModule", ((StringBuilder)localObject).toString());
    this.timerCount += 1;
    localObject = Message.obtain();
    ((Message)localObject).what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", paramString);
    localBundle.putInt("delay", paramInt);
    ((Message)localObject).setData(localBundle);
    int i = this.timerCount;
    ((Message)localObject).arg1 = i;
    ((Message)localObject).obj = Integer.valueOf(i);
    this.timeoutMap.put(Integer.valueOf(this.timerCount), ((Message)localObject).obj);
    this.handler.sendMessageDelayed((Message)localObject, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.module.JSTimerModule
 * JD-Core Version:    0.7.0.1
 */