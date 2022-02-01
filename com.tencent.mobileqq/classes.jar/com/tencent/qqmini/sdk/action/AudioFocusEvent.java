package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class AudioFocusEvent
  implements Action<Boolean>
{
  public static final int FOCUS_GAIN = 1;
  public static final int FOCUS_LOSS = 2;
  private static final String TAG = "UpdateUIEvent";
  private int what;
  
  public static AudioFocusEvent obtain(int paramInt)
  {
    AudioFocusEvent localAudioFocusEvent = new AudioFocusEvent();
    localAudioFocusEvent.what = paramInt;
    return localAudioFocusEvent;
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    int i = this.what;
    if (i != 1)
    {
      if (i == 2) {
        paramBaseRuntime.handleFocusLoss();
      }
    }
    else {
      paramBaseRuntime.handleFocusGain();
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.AudioFocusEvent
 * JD-Core Version:    0.7.0.1
 */