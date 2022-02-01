package com.tencent.mtt.tkd.views.audio;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.views.audioview.AudioViewController;

@HippyController(name="tkdAudioView")
public class TkdAudioViewController
  extends AudioViewController
{
  public static final String CLASS_NAME = "tkdAudioView";
  
  public View createViewImpl(Context paramContext)
  {
    return new TkdAudioView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.audio.TkdAudioViewController
 * JD-Core Version:    0.7.0.1
 */