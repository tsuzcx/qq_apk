package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.Arrays;
import java.util.List;

public class TTV6SmoothMultiFaceMaskFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n \n uniform sampler2D inputImageTexture; \n uniform sampler2D inputImageTexture2; \n vec3 rgb2hsv(lowp vec3 c) { \n   lowp vec4 K = vec4(0.0, -0.33333, 0.66667, -1.0);\n   highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n   highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n   highp float d = q.x - min(q.w, q.y);\n   highp float e = 1.0e-10;\n   float s = 0.0;\n   lowp vec3 hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), s, q.x);\n   return hsv;\n } \n void main() { \n   lowp vec3 srcColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n   lowp vec4 faceMask = texture2D(inputImageTexture2, textureCoordinate2);\n   lowp vec3 resColor;\n   float opacity;\n   \n     vec3 hsvSpace = rgb2hsv(srcColor.rgb);\n     float hue = hsvSpace.x;\n     float value = hsvSpace.z;\n     opacity = 1.0;\n     float white = srcColor.r + srcColor.g + srcColor.b;\n     if ((0.18 <= hue && hue <= 0.89) || value <= 0.2) { opacity = 0.0;\n     } \n     if (0.16 < hue && hue < 0.18) { opacity = min(opacity, (hue - 0.16) * 50.0);\n     } \n     if (0.89 < hue && hue < 0.91) { opacity = min(opacity, (0.91 - hue) * 50.0);\n     } \n     if (0.2 < value && value < 0.3) { opacity = min(opacity, (0.3 - value) * 10.0);\n     } \n     resColor = vec3(faceMask.r , faceMask.r, min(opacity, faceMask.r));\n   \n   gl_FragColor = vec4(resColor, faceMask.r);\n }\n";
  private static final int MAX_FACE = 5;
  private static final String VERTEX_SHADER = "attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n void main() { \n   textureCoordinate = position.xy * 0.5 + 0.5;\n   textureCoordinate2 = inputTextureCoordinate.xy;\n   gl_Position = position;\n }\n";
  private float[] faceVertices = new float[FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_4_SMOOTH * 3 * 2 * 5];
  private List<Float> itemFacePoints = Arrays.asList(FaceOffUtil.COSMETIC_MODEL_IMAGE_FACEPOINTS);
  private float[] texVertices = new float[FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_4_SMOOTH * 3 * 2 * 5];
  private int[] texture = new int[1];
  
  public TTV6SmoothMultiFaceMaskFilter()
  {
    super("attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinate2;\n void main() { \n   textureCoordinate = position.xy * 0.5 + 0.5;\n   textureCoordinate2 = inputTextureCoordinate.xy;\n   gl_Position = position;\n }\n", "precision highp float;\nvarying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n \n uniform sampler2D inputImageTexture; \n uniform sampler2D inputImageTexture2; \n vec3 rgb2hsv(lowp vec3 c) { \n   lowp vec4 K = vec4(0.0, -0.33333, 0.66667, -1.0);\n   highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n   highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n   highp float d = q.x - min(q.w, q.y);\n   highp float e = 1.0e-10;\n   float s = 0.0;\n   lowp vec3 hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), s, q.x);\n   return hsv;\n } \n void main() { \n   lowp vec3 srcColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n   lowp vec4 faceMask = texture2D(inputImageTexture2, textureCoordinate2);\n   lowp vec3 resColor;\n   float opacity;\n   \n     vec3 hsvSpace = rgb2hsv(srcColor.rgb);\n     float hue = hsvSpace.x;\n     float value = hsvSpace.z;\n     opacity = 1.0;\n     float white = srcColor.r + srcColor.g + srcColor.b;\n     if ((0.18 <= hue && hue <= 0.89) || value <= 0.2) { opacity = 0.0;\n     } \n     if (0.16 < hue && hue < 0.18) { opacity = min(opacity, (hue - 0.16) * 50.0);\n     } \n     if (0.89 < hue && hue < 0.91) { opacity = min(opacity, (0.91 - hue) * 50.0);\n     } \n     if (0.2 < value && value < 0.3) { opacity = min(opacity, (0.3 - value) * 10.0);\n     } \n     resColor = vec3(faceMask.r , faceMask.r, min(opacity, faceMask.r));\n   \n   gl_FragColor = vec4(resColor, faceMask.r);\n }\n");
    initParams();
  }
  
  private void initFaceTexCoords()
  {
    FaceOffUtil.initFaceTexCoords4Smooth(FaceOffUtil.getFacePoints4Smooth(FaceOffUtil.genPoints(this.itemFacePoints)), 800, 1067, this.texVertices);
    int i = 1;
    while (i < 5)
    {
      float[] arrayOfFloat = this.texVertices;
      System.arraycopy(arrayOfFloat, 0, arrayOfFloat, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_4_SMOOTH * 3 * 2 * i, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_4_SMOOTH * 3 * 2);
      i += 1;
    }
    setTexCords(this.texVertices);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    Object localObject = this.texture;
    GlUtil.glGenTextures(localObject.length, (int[])localObject, 0);
    localObject = BitmapUtils.decodeSampleBitmapFromAssets(AEModule.getContext(), "realtimeBeauty/smooth_mask.png", 1);
    if (BitmapUtils.isLegal((Bitmap)localObject)) {
      GlUtil.loadTexture(this.texture[0], (Bitmap)localObject);
    }
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.texture[0], 33986));
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    int[] arrayOfInt = this.texture;
    GlUtil.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    initFaceTexCoords();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public void updateParam(List<List<PointF>> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      int j = Math.min(5, paramList.size());
      setCoordNum(FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_4_SMOOTH * 3 * j);
      Arrays.fill(this.faceVertices, -2.0F);
      int i = 0;
      while (i < j)
      {
        Object localObject = null;
        try
        {
          List localList = VideoMaterial.copyList((List)paramList.get(i));
          localObject = localList;
        }
        catch (Exception localException)
        {
          label81:
          double d1;
          double d2;
          int k;
          break label81;
        }
        if (localObject != null)
        {
          localObject = FaceOffUtil.getFacePoints4Smooth((List)localObject);
          d1 = this.width;
          d2 = this.mFaceDetScale;
          Double.isNaN(d1);
          k = (int)(d1 * d2);
          d1 = this.height;
          d2 = this.mFaceDetScale;
          Double.isNaN(d1);
          FaceOffUtil.initFacePositions4Smooth((List)localObject, k, (int)(d1 * d2), this.faceVertices, FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_4_SMOOTH * 3 * 2 * i);
        }
        i += 1;
      }
      setPositions(this.faceVertices);
    }
    else
    {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTV6SmoothMultiFaceMaskFilter
 * JD-Core Version:    0.7.0.1
 */