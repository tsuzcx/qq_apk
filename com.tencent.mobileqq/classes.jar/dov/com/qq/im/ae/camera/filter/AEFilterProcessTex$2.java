package dov.com.qq.im.ae.camera.filter;

import bojl;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;

public class AEFilterProcessTex$2
  implements Runnable
{
  public AEFilterProcessTex$2(bojl parambojl, boolean paramBoolean) {}
  
  public void run()
  {
    if (bojl.a(this.this$0) != null)
    {
      bojl.a(this.this$0).switchFilterOn(111, this.a);
      if (this.a) {
        bojl.a(this.this$0).setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 0);
      }
    }
    else
    {
      return;
    }
    bojl.a(this.this$0).setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.filter.AEFilterProcessTex.2
 * JD-Core Version:    0.7.0.1
 */