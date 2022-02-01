package com.tencent.mobileqq.tritonaudio;

import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/tritonaudio/InnerAudioPlugin$GameAudioStateChangeListener;", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioStateChangeListener;", "audioId", "", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "(ILcom/tencent/mobileqq/triton/script/Argument;)V", "evaluateAudioError", "", "what", "evaluateAudioState", "state", "", "onCanPlay", "onEnded", "onError", "errCode", "onPause", "onPlay", "onSeeked", "onSeeking", "onStop", "onTimeUpdate", "onWaiting", "TritonAudio_release"}, k=1, mv={1, 1, 16})
public final class InnerAudioPlugin$GameAudioStateChangeListener
  implements IAudioStateChangeListener
{
  private final Argument arguments;
  private final int audioId;
  
  public InnerAudioPlugin$GameAudioStateChangeListener(int paramInt, @NotNull Argument paramArgument)
  {
    this.audioId = paramInt;
    this.arguments = paramArgument;
  }
  
  private final void evaluateAudioError(int paramInt)
  {
    int i;
    if (paramInt != -1010) {
      if (paramInt != -1007) {
        if ((paramInt != -1004) && (paramInt != -110)) {
          if (paramInt != 1)
          {
            if ((paramInt == 100) || (paramInt == 200)) {
              break label92;
            }
            i = paramInt;
          }
        }
      }
    }
    switch (paramInt)
    {
    default: 
      i = -1;
      break;
      i = 10002;
      break;
      label92:
      i = 10001;
      break;
      i = 10003;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("audioId", this.audioId);
    localJSONObject.put("state", "error");
    localJSONObject.put("errCode", i);
    String str;
    if (i == 10001) {
      str = "系统错误";
    } else {
      str = "未知错误, 请复用InnerAudioContext实例、及时释放无用实例";
    }
    localJSONObject.put("errMsg", str);
    this.arguments.subscribe("onAudioStateChange", localJSONObject.toString());
  }
  
  private final void evaluateAudioState(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("audioId", this.audioId);
    localJSONObject.put("state", paramString);
    this.arguments.subscribe("onAudioStateChange", localJSONObject.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.InnerAudioPlugin.GameAudioStateChangeListener
 * JD-Core Version:    0.7.0.1
 */