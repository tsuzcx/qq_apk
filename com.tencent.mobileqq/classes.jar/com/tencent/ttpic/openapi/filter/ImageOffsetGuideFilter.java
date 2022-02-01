package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.view.RendererUtils;

public class ImageOffsetGuideFilter
  extends BaseFilter
{
  private float xOffset = 0.0F;
  
  public ImageOffsetGuideFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  private void updatePosition()
  {
    float f2 = this.xOffset;
    float f1 = f2 - 0.16F;
    f2 += 0.16F;
    setPositions(new float[] { f1, -1.0F, f1, 1.0F, f2, 1.0F, f2, -1.0F });
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    float f = this.xOffset;
    if (f < 0.0F)
    {
      if (f <= -1.0F) {
        return;
      }
      updatePosition();
      GlUtil.setBlendMode(true);
      super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
      GlUtil.setBlendMode(false);
    }
  }
  
  public void initFrame(Frame paramFrame)
  {
    Bitmap localBitmap = BitmapUtils.decodeSampleBitmapFromAssets(AEModule.getContext(), "raw/guide_line.png", 1);
    paramFrame.setTextureId(RendererUtils.createTexture(localBitmap));
    paramFrame.width = localBitmap.getWidth();
    paramFrame.height = localBitmap.getHeight();
  }
  
  public void setxOffset(float paramFloat)
  {
    this.xOffset = (-paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.ImageOffsetGuideFilter
 * JD-Core Version:    0.7.0.1
 */