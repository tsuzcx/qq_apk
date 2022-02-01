package com.tencent.qcircle.weseevideo.composition;

import com.tencent.tavkit.component.effectchain.IVideoEffectContext;
import com.tencent.tavkit.component.effectchain.VideoEffectProxy;
import com.tencent.tavkit.component.effectchain.VideoMixEffectProxy;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;

class VideoRenderChainManager$WSVideoEffectContext
  implements IVideoEffectContext
{
  private VideoRenderChainManager$WSVideoEffectContext(VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public TAVVideoEffect getGlobalVideoEffect()
  {
    VideoRenderChainManager.access$800(this.this$0).setEffects(VideoRenderChainManager.access$700(this.this$0));
    return VideoRenderChainManager.access$800(this.this$0);
  }
  
  public TAVVideoEffect getSourceVideoEffect()
  {
    VideoRenderChainManager.access$400(this.this$0).setEffects(VideoRenderChainManager.access$300(this.this$0));
    return VideoRenderChainManager.access$400(this.this$0);
  }
  
  public TAVVideoMixEffect getVideoMixEffect()
  {
    VideoRenderChainManager.access$600(this.this$0).setEffects(VideoRenderChainManager.access$500(this.this$0));
    return VideoRenderChainManager.access$600(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.WSVideoEffectContext
 * JD-Core Version:    0.7.0.1
 */