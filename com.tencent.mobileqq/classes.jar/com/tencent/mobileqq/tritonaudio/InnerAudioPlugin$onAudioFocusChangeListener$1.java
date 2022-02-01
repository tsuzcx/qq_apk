package com.tencent.mobileqq.tritonaudio;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.DefaultImpls;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "focusChange", "", "onAudioFocusChange"}, k=3, mv={1, 1, 16})
final class InnerAudioPlugin$onAudioFocusChangeListener$1
  implements AudioManager.OnAudioFocusChangeListener
{
  InnerAudioPlugin$onAudioFocusChangeListener$1(InnerAudioPlugin paramInnerAudioPlugin) {}
  
  public final void onAudioFocusChange(int paramInt)
  {
    LogDelegate localLogDelegate = InnerAudioPlugin.access$getLogger$p(this.this$0);
    if (localLogDelegate != null) {
      LogDelegate.DefaultImpls.printLog$default(localLogDelegate, LogDelegate.Level.INFO, "[audio]InnerAudioPlugin", "onAudioFocusChange focusChange=" + paramInt, null, 8, null);
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case -2: 
      this.this$0.handleFocusLoss();
      return;
    case 1: 
      this.this$0.handleFocusGain();
      return;
    }
    InnerAudioPlugin.access$handleAbandonFocus(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.InnerAudioPlugin.onAudioFocusChangeListener.1
 * JD-Core Version:    0.7.0.1
 */