package com.tencent.tavcut.render.rendernode.audio;

import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.light.AudioOutput;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/rendernode/audio/LightAudioNode;", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode;", "audioReader", "Lorg/light/AudioOutput;", "(Lorg/light/AudioOutput;)V", "createAudioProcessor", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "getIdentifier", "", "AudioProcessorNode", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class LightAudioNode
  implements TAVAudioProcessorNode
{
  public static final LightAudioNode.Companion a = new LightAudioNode.Companion(null);
  private final AudioOutput b;
  
  public LightAudioNode(@NotNull AudioOutput paramAudioOutput)
  {
    this.b = paramAudioOutput;
  }
  
  @NotNull
  public TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor()
  {
    return (TAVAudioProcessorNode.TAVAudioProcessorEffect)new LightAudioNode.AudioProcessorNode(this.b);
  }
  
  @NotNull
  public String getIdentifier()
  {
    return "LightAudioNode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.rendernode.audio.LightAudioNode
 * JD-Core Version:    0.7.0.1
 */