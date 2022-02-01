package com.tencent.mtt.hippy.views.audioview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;

@HippyController(name="AudioView")
public class AudioViewController
  extends HippyGroupController<AudioView>
{
  public static final String ACATION_PAUSE = "pause";
  public static final String ACATION_PLAY = "play";
  public static final String ACATION_RELEASE = "release";
  public static final String ACATION_SEEKTO = "seek";
  public static final String ACATION_STOP = "stop";
  
  public View createViewImpl(Context paramContext)
  {
    return new AudioView(paramContext);
  }
  
  public void dispatchFunction(AudioView paramAudioView, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      super.dispatchFunction(paramAudioView, paramString, paramHippyArray);
      return;
      if (!paramString.equals("play")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("pause")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("release")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("seek")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("stop")) {
        break;
      }
      i = 4;
      break;
      if ((paramHippyArray.getObject(0) != null) && (!TextUtils.isEmpty(paramHippyArray.getString(0)))) {
        paramAudioView.setAudioPlayUrl(paramHippyArray.getString(0));
      }
      paramAudioView.playAudio();
      continue;
      paramAudioView.pauseAudio();
      continue;
      paramAudioView.releaseAudio();
      continue;
      if ((paramHippyArray.getObject(0) != null) && (paramHippyArray.getInt(0) > 0))
      {
        paramAudioView.seekTo(paramHippyArray.getInt(0));
        continue;
        paramAudioView.stopAudio();
      }
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="autoPlay")
  public void setAutoPlay(AudioView paramAudioView, boolean paramBoolean)
  {
    paramAudioView.setAudioAutoPlay(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onPlayComplete")
  public void setOnPlayComplete(AudioView paramAudioView, boolean paramBoolean)
  {
    paramAudioView.setOnPlayComplete(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="setOnPlayError")
  public void setOnPlayError(AudioView paramAudioView, boolean paramBoolean)
  {
    paramAudioView.setOnPlayError(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onPlayPause")
  public void setOnPlayPause(AudioView paramAudioView, boolean paramBoolean)
  {
    paramAudioView.setOnPlayPause(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onPlayProgress")
  public void setOnPlayProgress(AudioView paramAudioView, boolean paramBoolean)
  {
    paramAudioView.setOnPlayProgress(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onPlayResume")
  public void setOnPlayResume(AudioView paramAudioView, boolean paramBoolean)
  {
    paramAudioView.setOnPlayResume(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onPlayStart")
  public void setOnPlayStart(AudioView paramAudioView, boolean paramBoolean)
  {
    paramAudioView.setOnPlayStart(paramBoolean);
  }
  
  @HippyControllerProps(defaultString="", defaultType="string", name="src")
  public void setUrl(AudioView paramAudioView, String paramString)
  {
    paramAudioView.setAudioPlayUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.audioview.AudioViewController
 * JD-Core Version:    0.7.0.1
 */