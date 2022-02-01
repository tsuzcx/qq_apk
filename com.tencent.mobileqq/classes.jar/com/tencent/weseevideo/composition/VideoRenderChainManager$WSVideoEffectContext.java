package com.tencent.weseevideo.composition;

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
    VideoRenderChainManager.access$600(this.this$0).setEffects(VideoRenderChainManager.access$500(this.this$0));
    return VideoRenderChainManager.access$600(this.this$0);
  }
  
  public TAVVideoEffect getSourceVideoEffect()
  {
    VideoRenderChainManager.access$200(this.this$0).setEffects(VideoRenderChainManager.access$100(this.this$0));
    return VideoRenderChainManager.access$200(this.this$0);
  }
  
  public TAVVideoMixEffect getVideoMixEffect()
  {
    VideoRenderChainManager.access$400(this.this$0).setEffects(VideoRenderChainManager.access$300(this.this$0));
    return VideoRenderChainManager.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.composition.VideoRenderChainManager.WSVideoEffectContext
 * JD-Core Version:    0.7.0.1
 */