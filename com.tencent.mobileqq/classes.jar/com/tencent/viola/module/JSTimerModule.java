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
    if (this.handler != null) {
      this.handler.removeCallbacksAndMessages(null);
    }
    if ((this.timeoutMap != null) && (this.timeoutMap.size() > 0)) {
      this.timeoutMap.clear();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    String str;
    int i;
    do
    {
      do
      {
        return false;
      } while (paramMessage.getData() == null);
      str = paramMessage.getData().getString("callback");
      i = paramMessage.arg1;
    } while (getViolaInstance() == null);
    try
    {
      paramMessage = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("timerId", i);
      paramMessage.put("ret", 0);
      paramMessage.put("data", localJSONObject);
      ViolaBridgeManager.getInstance().execJSFuncByName(str, paramMessage.toString());
      return false;
    }
    catch (JSONException paramMessage)
    {
      ViolaLogUtils.e("JSTimerModule", "handleMessage JSONException e:" + paramMessage.getMessage());
    }
    return false;
  }
  
  @JSMethod(uiThread=false)
  public void setTimeout(@NonNull String paramString, @IntRange(from=0L) int paramInt)
  {
    ViolaLogUtils.d("JSTimerModule", "functId:" + paramString + " delay:" + paramInt);
    this.timerCount += 1;
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", paramString);
    localBundle.putInt("delay", paramInt);
    localMessage.setData(localBundle);
    localMessage.arg1 = this.timerCount;
    localMessage.obj = Integer.valueOf(this.timerCount);
    this.timeoutMap.put(Integer.valueOf(this.timerCount), localMessage.obj);
    this.handler.sendMessageDelayed(localMessage, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.module.JSTimerModule
 * JD-Core Version:    0.7.0.1
 */