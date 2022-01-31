package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.VideoMaterial.FaceImageLayer;
import com.tencent.ttpic.util.FaceOffUtil;
import java.io.File;
import java.util.List;
import java.util.Map;

public class FaceAverageBackgroundFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = " precision mediump float;\n varying lowp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n         gl_FragColor = texture2D(inputImageTexture2, textureCoordinate);\n }";
  private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  private VideoMaterial.FaceImageLayer mFaceLayer = null;
  private FaceItem mItem = null;
  private Bitmap materialBitmap = null;
  private int materialImageHeight = 0;
  private int materialImageWidth = 0;
  
  public FaceAverageBackgroundFilter(String paramString, VideoMaterial.FaceImageLayer paramFaceImageLayer)
  {
    super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", " precision mediump float;\n varying lowp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n         gl_FragColor = texture2D(inputImageTexture2, textureCoordinate);\n }", null);
    this.dataPath = paramString;
    this.mFaceLayer = paramFaceImageLayer;
    initParams();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    float f2 = this.materialImageHeight / this.height;
    float f1 = this.materialImageWidth / f2;
    f2 = this.materialImageHeight / f2;
    f2 = (f1 - this.width) / 2.0F / f1;
    float f3 = (f1 - this.width) / 2.0F / f1;
    float f4 = (f1 - this.width) / 2.0F / f1;
    addAttribParam("inputTextureCoordinate", new float[] { f3, 0.0F, f2, 1.0F, 1.0F - (f1 - this.width) / 2.0F / f1, 1.0F, 1.0F - f4, 0.0F });
  }
  
  public void initParams()
  {
    if ((this.materialBitmap == null) && (this.mFaceLayer != null)) {
      this.materialBitmap = FaceOffUtil.getFaceBitmap(this.dataPath + File.separator + this.mFaceLayer.imagePath);
    }
    if (this.materialBitmap != null)
    {
      this.materialImageWidth = this.materialBitmap.getWidth();
      this.materialImageHeight = this.materialBitmap.getHeight();
    }
    addParam(new Param.TextureBitmapParam("inputImageTexture2", this.materialBitmap, 33986, true));
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceAverageBackgroundFilter
 * JD-Core Version:    0.7.0.1
 */