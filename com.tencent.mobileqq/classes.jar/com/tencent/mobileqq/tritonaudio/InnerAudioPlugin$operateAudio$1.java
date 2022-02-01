package com.tencent.mobileqq.tritonaudio;

import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.tritonaudio.inneraudio.AudioPlayerManager;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class InnerAudioPlugin$operateAudio$1
  implements Runnable
{
  InnerAudioPlugin$operateAudio$1(InnerAudioPlugin paramInnerAudioPlugin, Argument paramArgument) {}
  
  public final void run()
  {
    int i = this.$arguments.getParams().optInt("audioId", -1);
    Object localObject = this.$arguments.getParams().optString("operationType");
    if (localObject == null) {
      return;
    }
    switch (((String)localObject).hashCode())
    {
    default: 
    case 106440182: 
      if (((String)localObject).equals("pause"))
      {
        localObject = InnerAudioPlugin.access$getAudioPlayerManager$p(this.this$0);
        if (localObject != null)
        {
          ((AudioPlayerManager)localObject).pauseMusic(i);
          return;
        }
      }
      break;
    case 3540994: 
      if (((String)localObject).equals("stop"))
      {
        localObject = InnerAudioPlugin.access$getAudioPlayerManager$p(this.this$0);
        if (localObject != null)
        {
          ((AudioPlayerManager)localObject).stopMusic(i);
          return;
        }
      }
      break;
    case 3526264: 
      if (((String)localObject).equals("seek"))
      {
        localObject = InnerAudioPlugin.access$getAudioPlayerManager$p(this.this$0);
        if (localObject != null)
        {
          ((AudioPlayerManager)localObject).seekTo(i, (float)this.$arguments.getParams().optDouble("currentTime"));
          return;
        }
      }
      break;
    case 3443508: 
      if ((((String)localObject).equals("play")) && (!InnerAudioPlugin.access$isActivityPaused$p(this.this$0)))
      {
        localObject = InnerAudioPlugin.access$getAudioPlayerManager$p(this.this$0);
        if (localObject != null) {
          ((AudioPlayerManager)localObject).playMusic(i);
        }
        if (!InnerAudioPlugin.access$getMixWithOther$p(this.this$0)) {
          InnerAudioPlugin.access$execAudioFocus(this.this$0, true);
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.InnerAudioPlugin.operateAudio.1
 * JD-Core Version:    0.7.0.1
 */