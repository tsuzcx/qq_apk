package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.Float1sParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.filter.blurmaskfilter.OptimGaussianMaskFilter;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;

public class DepthMaskFilter
  extends VideoFilterBase
{
  private static final String FACE_POINTS = "facePoints";
  private static final String FRAGMENT_SHADER = "precision highp float;\n varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n\n uniform highp float maxDepthVal;\n uniform highp float minDepthVal;\n \n void main() {\n     highp vec3 originVec3 =    texture2D(inputImageTexture, textureCoordinate).rgb;\n     highp vec3 depth3 =      texture2D(inputImageTexture2, textureCoordinate).rgb;\n     \n    float gray = depth3.r ;\n    \n    //v1版本\n//    gray = (gray - minDepthVal) / (maxDepthVal - minDepthVal);\n//    if (gray > 1.0) gray = 1.0;\n//    if (gray < 0.0) gray = 0.0;\n//\n//    gray = gray - 0.2;\n//    if(gray < 0.0) gray = 0.0;\n\n    //v2版本\n    float r = gray * 255.0 / 180.0;\n    gray = gray * r * r;\n    if (gray > 1.0) {\n        gray = 1.0;\n    }\n    \n//    gray = 1.0 - gray;\n    \n//    if (gray < 0.2) gray = 0.0;\n    \n    \n    highp vec3 finalColor = originVec3 * gray + (1.0 - gray);\n\n    gl_FragColor = vec4(finalColor, texture2D(inputImageTexture, textureCoordinate).a);\n}";
  private static final String TAG = "DepthMaskFilter";
  private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n\n varying vec2 textureCoordinate;\n \n void main(void) {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n }";
  private static final int[] sTEXTURE_ID = { 33987, 33988, 33989, 33990, 33991, 33992 };
  private static final String[] sTEXTURE_NAME = { "inputMaterialTexture1", "inputMaterialTexture2", "inputMaterialTexture3", "inputMaterialTexture4", "inputMaterialTexture5", "inputMaterialTexture6" };
  private Frame mBlurMaskCache;
  private float mBlurStrength;
  private Frame mMaskFrame;
  private int[] mMaskTexture;
  private OptimGaussianMaskFilter mOptimGaussFilter;
  private float[] mTextureSize;
  
  public DepthMaskFilter(String paramString1, String paramString2, int paramInt, float paramFloat) {}
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GlUtil.createEtcTexture(this.mMaskTexture);
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    GLES20.glDeleteTextures(this.mMaskTexture.length, this.mMaskTexture, 0);
    if (this.mOptimGaussFilter != null) {
      this.mOptimGaussFilter.clear();
    }
    if (this.mMaskFrame != null) {
      this.mMaskFrame.clear();
    }
    if (this.mBlurMaskCache != null) {
      this.mBlurMaskCache.clear();
    }
  }
  
  public void initParams(int paramInt)
  {
    addParam(new UniformParam.FloatParam("progress", 0.0F));
    addParam(new UniformParam.FloatParam("minDepthVal", 0.0F));
    addParam(new UniformParam.FloatParam("maxDepthVal", 1.0F));
    addParam(new UniformParam.FloatsParam("faceDetectImageSize", this.mTextureSize));
    addParam(new UniformParam.Float1sParam("facePoints", new float[0]));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    int i = 0;
    while ((i < paramInt) && (i < sTEXTURE_ID.length))
    {
      String str = sTEXTURE_NAME[i];
      LogUtils.i("DepthMaskFilter", "init texture :" + str);
      addParam(new UniformParam.TextureParam(str, 0, sTEXTURE_ID[i]));
      i += 1;
    }
  }
  
  public void setDepthMask(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void setDepthMask(Bitmap paramBitmap)
  {
    if (BitmapUtils.isLegal(paramBitmap)) {
      try
      {
        GlUtil.loadTexture(this.mMaskTexture[0], paramBitmap);
        if (this.mBlurStrength > 0.0F)
        {
          int i = paramBitmap.getWidth();
          int j = paramBitmap.getHeight();
          if (this.mOptimGaussFilter == null)
          {
            this.mOptimGaussFilter = new OptimGaussianMaskFilter(false, this.mBlurStrength, false);
            this.mOptimGaussFilter.applyFilterChain(true, paramBitmap.getWidth(), paramBitmap.getHeight());
            this.mOptimGaussFilter.updateVideoSize(paramBitmap.getWidth(), paramBitmap.getHeight());
            this.mBlurMaskCache = new Frame();
            this.mMaskFrame = new Frame();
            this.mMaskFrame.bindFrame(this.mMaskTexture[0], i, j, 0.0D);
          }
          setDepthMask(this.mOptimGaussFilter.RenderProcess(this.mMaskFrame, this.mBlurMaskCache).getTextureId());
          return;
        }
        setDepthMask(this.mMaskTexture[0]);
        return;
      }
      catch (Exception paramBitmap)
      {
        LogUtils.e("DepthMaskFilter", "loadTexture Exception:" + paramBitmap.getMessage());
      }
    }
  }
  
  public void setPixelRange(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 2)) {
      return;
    }
    addParam(new UniformParam.FloatParam("minDepthVal", paramArrayOfFloat[0] / 255.0F));
    addParam(new UniformParam.FloatParam("maxDepthVal", paramArrayOfFloat[1] / 255.0F));
  }
  
  public void updateCurTime(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("progress", paramFloat));
  }
  
  public void updateFacePoints(float[] paramArrayOfFloat)
  {
    addParam(new UniformParam.Float1sParam("facePoints", VideoMaterialUtil.flipYPoints(paramArrayOfFloat, (int)(this.height * this.mFaceDetScale))));
  }
  
  public void updatePreview(Object paramObject)
  {
    super.updatePreview(paramObject);
  }
  
  public void updateTexutre(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.TextureParam(sTEXTURE_NAME[paramInt1], paramInt2, sTEXTURE_ID[paramInt1]));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.mTextureSize[0] = ((float)(paramInt1 * paramDouble));
    this.mTextureSize[1] = ((float)(paramInt2 * paramDouble));
    addParam(new UniformParam.FloatsParam("faceDetectImageSize", this.mTextureSize));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.DepthMaskFilter
 * JD-Core Version:    0.7.0.1
 */