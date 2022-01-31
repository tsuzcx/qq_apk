package dov.com.qq.im.ae.camera.filter;

import bkov;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;

public class AEFilterProcessTex$2
  implements Runnable
{
  public AEFilterProcessTex$2(bkov parambkov, boolean paramBoolean) {}
  
  public void run()
  {
    if (bkov.a(this.this$0) != null)
    {
      bkov.a(this.this$0).switchFilterOn(111, this.a);
      if (this.a) {
        bkov.a(this.this$0).setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 0);
      }
    }
    else
    {
      return;
    }
    bkov.a(this.this$0).setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.filter.AEFilterProcessTex.2
 * JD-Core Version:    0.7.0.1
 */