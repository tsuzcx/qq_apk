package dov.com.qq.im.ae.camera.filter;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;

class AEFilterProcessTex$3
  implements Runnable
{
  AEFilterProcessTex$3(AEFilterProcessTex paramAEFilterProcessTex, boolean paramBoolean) {}
  
  public void run()
  {
    if (AEFilterProcessTex.a(this.this$0) != null)
    {
      AEFilterProcessTex.a(this.this$0).switchAbilityInLightNode("ai.segmentation.bg.enable", this.a);
      AEFilterProcessTex.a(this.this$0).switchAbilityInLightNode("stroke.segmentFollowFace", true);
      if (this.a) {
        AEFilterProcessTex.a(this.this$0).setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 0);
      }
    }
    else
    {
      return;
    }
    AEFilterProcessTex.a(this.this$0).setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.filter.AEFilterProcessTex.3
 * JD-Core Version:    0.7.0.1
 */