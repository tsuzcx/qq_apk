package com.tencent.mobileqq.tritonaudio;

import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import com.tencent.mobileqq.tritonaudio.inneraudio.AudioPlayerManager;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class InnerAudioPlugin$setAudioState$1
  implements Runnable
{
  InnerAudioPlugin$setAudioState$1(InnerAudioPlugin paramInnerAudioPlugin, Argument paramArgument) {}
  
  public final void run()
  {
    try
    {
      int i = this.$arguments.getParams().optInt("audioId", -1);
      Object localObject1;
      if (this.$arguments.getParams().has("src"))
      {
        localObject1 = this.$arguments.getParams().getString("src");
        localObject2 = InnerAudioPlugin.access$getAudioPlayerManager$p(this.this$0);
        if (localObject2 != null) {
          ((AudioPlayerManager)localObject2).setMusicPath(i, (String)localObject1);
        }
      }
      else
      {
        boolean bool;
        if (this.$arguments.getParams().has("autoplay"))
        {
          bool = this.$arguments.getParams().getBoolean("autoplay");
          localObject1 = InnerAudioPlugin.access$getAudioPlayerManager$p(this.this$0);
          if (localObject1 != null) {
            ((AudioPlayerManager)localObject1).setAutoplay(i, bool);
          }
        }
        else
        {
          double d;
          if (this.$arguments.getParams().has("startTime"))
          {
            d = this.$arguments.getParams().getDouble("startTime");
            localObject1 = InnerAudioPlugin.access$getAudioPlayerManager$p(this.this$0);
            if (localObject1 != null) {
              ((AudioPlayerManager)localObject1).setStartTime(i, (float)d);
            }
          }
          else if (this.$arguments.getParams().has("loop"))
          {
            bool = this.$arguments.getParams().getBoolean("loop");
            localObject1 = InnerAudioPlugin.access$getAudioPlayerManager$p(this.this$0);
            if (localObject1 != null) {
              ((AudioPlayerManager)localObject1).setLoop(i, bool);
            }
          }
          else if (this.$arguments.getParams().has("volume"))
          {
            d = this.$arguments.getParams().getDouble("volume");
            localObject1 = InnerAudioPlugin.access$getAudioPlayerManager$p(this.this$0);
            if (localObject1 != null)
            {
              ((AudioPlayerManager)localObject1).setVolume(i, (float)d);
              return;
            }
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = InnerAudioPlugin.access$getLogger$p(this.this$0);
      if (localObject2 != null) {
        ((LogDelegate)localObject2).printLog(LogDelegate.Level.ERROR, "[audio]InnerAudioPlugin", "setAudioState exception:", (Throwable)localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.InnerAudioPlugin.setAudioState.1
 * JD-Core Version:    0.7.0.1
 */