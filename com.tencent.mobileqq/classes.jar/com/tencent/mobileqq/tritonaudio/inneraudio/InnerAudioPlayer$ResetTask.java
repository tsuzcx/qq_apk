package com.tencent.mobileqq.tritonaudio.inneraudio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer$ResetTask;", "Ljava/lang/Runnable;", "targetId", "", "targetPath", "", "(Lcom/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer;ILjava/lang/String;)V", "run", "", "TritonAudio_release"}, k=1, mv={1, 1, 16})
public final class InnerAudioPlayer$ResetTask
  implements Runnable
{
  private final int targetId;
  private final String targetPath;
  
  public InnerAudioPlayer$ResetTask(int paramInt, String paramString)
  {
    this.targetId = paramString;
    Object localObject;
    this.targetPath = localObject;
  }
  
  public void run()
  {
    if ((this.this$0.getAudioId() == this.targetId) && (this.this$0.getAudioPath() != null) && (Intrinsics.areEqual(this.this$0.getAudioPath(), this.targetPath))) {
      this.this$0.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer.ResetTask
 * JD-Core Version:    0.7.0.1
 */