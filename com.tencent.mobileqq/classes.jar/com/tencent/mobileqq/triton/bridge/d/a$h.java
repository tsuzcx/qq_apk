package com.tencent.mobileqq.triton.bridge.d;

import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class a$h
  implements IAudioStateChangeListener
{
  private ITTJSRuntime a;
  private int b;
  
  public a$h(a parama, int paramInt, ITTJSRuntime paramITTJSRuntime)
  {
    this.b = paramInt;
    this.a = paramITTJSRuntime;
  }
  
  private void a(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = -1;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioId", this.b);
      localJSONObject.put("state", "error");
      localJSONObject.put("errCode", i);
      Object localObject2;
      if ((i == 10001) || (i == -1))
      {
        localObject2 = new StringBuilder();
        if (i != 10001) {
          break label233;
        }
      }
      label233:
      for (Object localObject1 = "系统错误";; localObject1 = "未知错误")
      {
        localJSONObject.put("errMsg", (String)localObject1 + ", 请复用InnerAudioContext实例、及时释放无用实例");
        localObject1 = this.c;
        localObject2 = this.a;
        ((c)localObject1).a((ITTJSRuntime)localObject2, "onAudioStateChange", localJSONObject.toString());
        return;
        i = 10002;
        break;
        i = 10001;
        break;
        i = 10003;
        break;
      }
      return;
    }
    finally
    {
      TTLog.b("[audio] AudioPlugin", "evaluateAudioError exception:", localThrowable);
    }
  }
  
  private void a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("audioId", this.b);
      localJSONObject.put("state", paramString);
      this.c.a(this.a, "onAudioStateChange", localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void onCanPlay()
  {
    a("canplay");
  }
  
  public void onEnded()
  {
    a("ended");
  }
  
  public void onError(int paramInt)
  {
    a(paramInt);
  }
  
  public void onPause()
  {
    a("pause");
  }
  
  public void onPlay()
  {
    a("play");
  }
  
  public void onSeeked()
  {
    a("seeked");
  }
  
  public void onSeeking()
  {
    a("seeking");
  }
  
  public void onStop()
  {
    a("stop");
  }
  
  public void onTimeUpdate()
  {
    a("timeUpdate");
  }
  
  public void onWaiting()
  {
    a("waiting");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.d.a.h
 * JD-Core Version:    0.7.0.1
 */