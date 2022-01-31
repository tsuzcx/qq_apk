package dov.com.qq.im.AECamera.View;

import bgyy;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;

public class AEFilterProcessTex$1
  implements Runnable
{
  public AEFilterProcessTex$1(bgyy parambgyy, boolean paramBoolean) {}
  
  public void run()
  {
    if (bgyy.a(this.this$0) != null)
    {
      bgyy.a(this.this$0).switchFilterOn(111, this.a);
      if (this.a) {
        bgyy.a(this.this$0).setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 0);
      }
    }
    else
    {
      return;
    }
    bgyy.a(this.this$0).setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.AEFilterProcessTex.1
 * JD-Core Version:    0.7.0.1
 */