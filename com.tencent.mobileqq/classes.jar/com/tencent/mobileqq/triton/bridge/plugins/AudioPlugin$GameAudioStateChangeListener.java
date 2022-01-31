package com.tencent.mobileqq.triton.bridge.plugins;

import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class AudioPlugin$GameAudioStateChangeListener
  implements IAudioStateChangeListener
{
  private int audioId;
  private ITTJSRuntime jsRuntime;
  
  public AudioPlugin$GameAudioStateChangeListener(AudioPlugin paramAudioPlugin, int paramInt, ITTJSRuntime paramITTJSRuntime)
  {
    this.audioId = paramInt;
    this.jsRuntime = paramITTJSRuntime;
  }
  
  private void evaluateAudioError(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("audioId", this.audioId);
        localJSONObject.put("state", "error");
        localJSONObject.put("errCode", i);
        if ((i == 10001) || (i == -1))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          if (i == 10001)
          {
            str = "系统错误";
            localJSONObject.put("errMsg", str + ", 请复用InnerAudioContext实例、及时释放无用实例");
          }
        }
        else
        {
          this.this$0.evaluateSubscribeJs(this.jsRuntime, "onAudioStateChange", localJSONObject.toString());
          return;
        }
        String str = "未知错误";
        continue;
        i = 10002;
      }
      catch (Throwable localThrowable)
      {
        TTLog.e("[audio] AudioPlugin", "evaluateAudioError exception:", localThrowable);
        return;
      }
      continue;
      i = 10001;
      continue;
      i = 10003;
      continue;
      i = -1;
    }
  }
  
  private void evaluateAudioState(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("audioId", this.audioId);
      localJSONObject.put("state", paramString);
      this.this$0.evaluateSubscribeJs(this.jsRuntime, "onAudioStateChange", localJSONObject.toString());
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
    evaluateAudioState("canplay");
  }
  
  public void onEnded()
  {
    evaluateAudioState("ended");
  }
  
  public void onError(int paramInt)
  {
    evaluateAudioError(paramInt);
  }
  
  public void onPause()
  {
    evaluateAudioState("pause");
  }
  
  public void onPlay()
  {
    evaluateAudioState("play");
  }
  
  public void onSeeked()
  {
    evaluateAudioState("seeked");
  }
  
  public void onSeeking()
  {
    evaluateAudioState("seeking");
  }
  
  public void onStop()
  {
    evaluateAudioState("stop");
  }
  
  public void onTimeUpdate()
  {
    evaluateAudioState("timeUpdate");
  }
  
  public void onWaiting()
  {
    evaluateAudioState("waiting");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.plugins.AudioPlugin.GameAudioStateChangeListener
 * JD-Core Version:    0.7.0.1
 */