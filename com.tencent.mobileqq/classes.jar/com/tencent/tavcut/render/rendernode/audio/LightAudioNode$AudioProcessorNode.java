package com.tencent.tavcut.render.rendernode.audio;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioFrame;
import org.light.AudioOutput;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/rendernode/audio/LightAudioNode$AudioProcessorNode;", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "audioReader", "Lorg/light/AudioOutput;", "(Lorg/light/AudioOutput;)V", "audioMixer", "Lcom/tencent/tav/decoder/AudioMixer;", "getAudioMixer", "()Lcom/tencent/tav/decoder/AudioMixer;", "getAudioReader", "()Lorg/light/AudioOutput;", "processAudioPCM", "Ljava/nio/ByteBuffer;", "time", "Lcom/tencent/tav/coremedia/CMTime;", "pcmBuffer", "audioInfo", "Lcom/tencent/tav/decoder/AudioInfo;", "release", "", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
final class LightAudioNode$AudioProcessorNode
  implements TAVAudioProcessorNode.TAVAudioProcessorEffect
{
  public static final LightAudioNode.AudioProcessorNode.Companion a = new LightAudioNode.AudioProcessorNode.Companion(null);
  @NotNull
  private final AudioMixer b;
  @NotNull
  private final AudioOutput c;
  
  public LightAudioNode$AudioProcessorNode(@NotNull AudioOutput paramAudioOutput)
  {
    this.c = paramAudioOutput;
    this.b = new AudioMixer();
  }
  
  @NotNull
  public ByteBuffer processAudioPCM(@Nullable CMTime paramCMTime, @Nullable ByteBuffer paramByteBuffer, @Nullable AudioInfo paramAudioInfo)
  {
    paramCMTime = this.c.copyNextSample();
    paramByteBuffer = null;
    if (paramCMTime != null) {
      paramCMTime = paramCMTime.data;
    } else {
      paramCMTime = null;
    }
    if (paramCMTime != null) {
      paramCMTime.order(ByteOrder.LITTLE_ENDIAN);
    }
    paramAudioInfo = this.b;
    if (paramAudioInfo != null) {
      paramByteBuffer = paramAudioInfo.processBytes(paramCMTime, 1.0F, 1.0F, 1.0F);
    }
    Intrinsics.checkExpressionValueIsNotNull(paramByteBuffer, "audioMixer?.processBytes…FAULT_PITCH\n            )");
    return paramByteBuffer;
  }
  
  public void release()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((AudioMixer)localObject).release();
    }
    localObject = this.c;
    if (localObject != null) {
      ((AudioOutput)localObject).release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.rendernode.audio.LightAudioNode.AudioProcessorNode
 * JD-Core Version:    0.7.0.1
 */