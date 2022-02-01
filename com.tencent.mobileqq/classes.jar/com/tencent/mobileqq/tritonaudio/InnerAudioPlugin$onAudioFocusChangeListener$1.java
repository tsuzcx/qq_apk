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
    if (localLogDelegate != null)
    {
      LogDelegate.Level localLevel = LogDelegate.Level.INFO;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAudioFocusChange focusChange=");
      localStringBuilder.append(paramInt);
      LogDelegate.DefaultImpls.printLog$default(localLogDelegate, localLevel, "[audio]InnerAudioPlugin", localStringBuilder.toString(), null, 8, null);
    }
    if (paramInt != -2)
    {
      if (paramInt != -1)
      {
        if (paramInt != 1) {
          return;
        }
        this.this$0.handleFocusGain();
        return;
      }
      InnerAudioPlugin.access$handleAbandonFocus(this.this$0);
      return;
    }
    this.this$0.handleFocusLoss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.InnerAudioPlugin.onAudioFocusChangeListener.1
 * JD-Core Version:    0.7.0.1
 */