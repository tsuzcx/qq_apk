package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.util.FrameUtil;
import java.io.File;

public class ComicEffectFilter
  extends BaseFilter
  implements AEFilterI
{
  public static final String ANIMATION_FRAGMENT1_SHADER = "varying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform lowp float width;\nuniform lowp float height;\nuniform lowp float threshold;\nuniform lowp float edgeStrength;\nhighp vec3 brightness = vec3(0.2125, 0.7154, 0.0721);\nhighp float rgb2gray(highp vec4 color) {\n    return dot(color.rgb,brightness);\n}\nhighp float pixel_operator(highp float dx, highp float dy) {\n    return rgb2gray(texture2D(inputImageTexture, textureCoordinate+vec2(dx,dy)));\n}\nhighp float sobel_filter()\n{\n    highp float dx = 1.0 / width; \n    highp float dy = 1.0 / height; \n    highp float s00 = pixel_operator(-dx, dy);\n    highp float s10 = pixel_operator(-dx, 0.0);\n    highp float s20 = pixel_operator(-dx, -dy);\n    highp float s01 = pixel_operator(0.0, dy);\n    highp float s21 = pixel_operator(0.0, -dy);\n    highp float s02 = pixel_operator(dx, dy);\n    highp float s12 = pixel_operator(dx, 0.0);\n    highp float s22 = pixel_operator(dx, -dy);\n    highp float s11 = pixel_operator(0.0, 0.0);\n    highp float sx = s00 + 2.0 * s10 + s20 - (s02 + 2.0 * s12 + s22);\n    highp float sy = s00 + 2.0 * s01 + s02 - (s20 + 2.0 * s21 + s22);\n    highp float dist = length(vec2(sx, sy) * edgeStrength);\n    return dist;\n}\nlowp vec3 rgb2hsv(lowp vec3 c) {\n  lowp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n  highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n  highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n  highp float d = q.x - min(q.w, q.y);\n  highp float e = 1.0e-10;\n  lowp vec3 hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n  return hsv;\n}\nvoid main() {\nhighp vec4 outputColor = texture2D(inputImageTexture, textureCoordinate);\nhighp float graylevel = sobel_filter();\nhighp float mag = 1.0 - graylevel;\n  lowp vec3 hsv = rgb2hsv(outputColor.rgb);\n  mediump float p2_left = (0.18 - clamp(hsv.x, 0.16, 0.18)) / 0.02;\n  mediump float p2_right = 1.0 - (0.91 - clamp(hsv.x, 0.89, 0.91)) / 0.02;\n  mediump float p2_value = 1.0 - (0.3 - clamp(hsv.z, 0.2, 0.3)) / 0.1;\n  mediump float p2 = min(max(p2_left, p2_right), p2_value);\nhighp float autoThreshold = step(0.99,p2);\nmag = step(threshold*(1.0 - autoThreshold), mag);\nhighp vec4 textureColor = vec4(vec3(mag), 1.0);\nhighp vec4 tempColor1;\nhighp float alpha;\n     if(1.0-textureColor.r > 0.6)\n       alpha = 0.6;\n     else\n       alpha = 1.0-textureColor.r;\n  tempColor1 = mix(outputColor, textureColor ,1.0-textureColor.r);\ngl_FragColor = vec4(tempColor1.rgb,outputColor.a);\n}\n";
  public static final String LOOKUP_TABLE_FILE_NAME = "filterEffect.lut";
  private static final String TAG = ComicEffectFilter.class.getSimpleName();
  private Frame mAcgColorFrame = new Frame();
  private boolean mAlreadyRenderInSingleFrame = false;
  private AvgColorFilter mAvgColorFilter = new AvgColorFilter();
  private String mComicLutFilter;
  private BaseFilter mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private String mDataPath;
  private DotFilter mDotFilter = new DotFilter();
  private Frame mDotFrame = new Frame();
  private GPUImageLookupFilter mGpuImageLookupFilter = new GPUImageLookupFilter();
  private Frame mGpuLookupFrame = new Frame();
  private StickerItem mItem;
  
  public ComicEffectFilter(StickerItem paramStickerItem, String paramString)
  {
    super("varying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform lowp float width;\nuniform lowp float height;\nuniform lowp float threshold;\nuniform lowp float edgeStrength;\nhighp vec3 brightness = vec3(0.2125, 0.7154, 0.0721);\nhighp float rgb2gray(highp vec4 color) {\n    return dot(color.rgb,brightness);\n}\nhighp float pixel_operator(highp float dx, highp float dy) {\n    return rgb2gray(texture2D(inputImageTexture, textureCoordinate+vec2(dx,dy)));\n}\nhighp float sobel_filter()\n{\n    highp float dx = 1.0 / width; \n    highp float dy = 1.0 / height; \n    highp float s00 = pixel_operator(-dx, dy);\n    highp float s10 = pixel_operator(-dx, 0.0);\n    highp float s20 = pixel_operator(-dx, -dy);\n    highp float s01 = pixel_operator(0.0, dy);\n    highp float s21 = pixel_operator(0.0, -dy);\n    highp float s02 = pixel_operator(dx, dy);\n    highp float s12 = pixel_operator(dx, 0.0);\n    highp float s22 = pixel_operator(dx, -dy);\n    highp float s11 = pixel_operator(0.0, 0.0);\n    highp float sx = s00 + 2.0 * s10 + s20 - (s02 + 2.0 * s12 + s22);\n    highp float sy = s00 + 2.0 * s01 + s02 - (s20 + 2.0 * s21 + s22);\n    highp float dist = length(vec2(sx, sy) * edgeStrength);\n    return dist;\n}\nlowp vec3 rgb2hsv(lowp vec3 c) {\n  lowp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n  highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n  highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n  highp float d = q.x - min(q.w, q.y);\n  highp float e = 1.0e-10;\n  lowp vec3 hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n  return hsv;\n}\nvoid main() {\nhighp vec4 outputColor = texture2D(inputImageTexture, textureCoordinate);\nhighp float graylevel = sobel_filter();\nhighp float mag = 1.0 - graylevel;\n  lowp vec3 hsv = rgb2hsv(outputColor.rgb);\n  mediump float p2_left = (0.18 - clamp(hsv.x, 0.16, 0.18)) / 0.02;\n  mediump float p2_right = 1.0 - (0.91 - clamp(hsv.x, 0.89, 0.91)) / 0.02;\n  mediump float p2_value = 1.0 - (0.3 - clamp(hsv.z, 0.2, 0.3)) / 0.1;\n  mediump float p2 = min(max(p2_left, p2_right), p2_value);\nhighp float autoThreshold = step(0.99,p2);\nmag = step(threshold*(1.0 - autoThreshold), mag);\nhighp vec4 textureColor = vec4(vec3(mag), 1.0);\nhighp vec4 tempColor1;\nhighp float alpha;\n     if(1.0-textureColor.r > 0.6)\n       alpha = 0.6;\n     else\n       alpha = 1.0-textureColor.r;\n  tempColor1 = mix(outputColor, textureColor ,1.0-textureColor.r);\ngl_FragColor = vec4(tempColor1.rgb,outputColor.a);\n}\n");
    this.mItem = paramStickerItem;
    this.mDataPath = paramString;
    this.mComicLutFilter = this.mItem.comicLutFilter;
    paramStickerItem = this.mDataPath + File.separator + this.mComicLutFilter;
    if ((this.mComicLutFilter == null) || (!FileUtils.exists(paramStickerItem))) {}
    for (paramStickerItem = getBitmap(this.mDataPath + File.separator + "filterEffect.lut");; paramStickerItem = getBitmap(paramStickerItem))
    {
      this.mGpuImageLookupFilter.addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", paramStickerItem, 33986, true));
      initParams();
      return;
    }
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {}
    for (paramString = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), 2147483647, 2147483647);; paramString = BitmapUtils.decodeSampledBitmapFromFile(paramString, 2147483647, 2147483647))
    {
      String str = paramString;
      if (!BitmapUtils.isLegal(paramString)) {
        str = null;
      }
      return str;
    }
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return paramFrame;
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    this.mAcgColorFrame.bindFrame(-1, paramInt2, paramInt3, 0.0D);
    FrameUtil.clearFrame(this.mAcgColorFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramInt2, paramInt3);
    this.mAvgColorFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mAcgColorFrame);
    this.mGpuLookupFrame.bindFrame(-1, paramInt2, paramInt3, 0.0D);
    FrameUtil.clearFrame(this.mGpuLookupFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramInt2, paramInt3);
    super.RenderProcess(this.mAcgColorFrame.getTextureId(), paramInt2, paramInt3, -1, 0.0D, this.mGpuLookupFrame);
    this.mDotFrame.bindFrame(-1, paramInt2, paramInt3, 0.0D);
    FrameUtil.clearFrame(this.mDotFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramInt2, paramInt3);
    this.mGpuImageLookupFilter.RenderProcess(this.mGpuLookupFrame.getTextureId(), paramInt2, paramInt3, -1, 0.0D, this.mDotFrame);
    this.mDotFilter.RenderProcess(this.mDotFrame.getTextureId(), paramInt2, paramInt3, -1, 0.0D, paramFrame);
  }
  
  public void apply()
  {
    this.mGpuImageLookupFilter.apply();
    this.mAvgColorFilter.apply();
    this.mCopyFilter.apply();
    this.mDotFilter.apply();
    super.apply();
  }
  
  public void clearGLSLSelf()
  {
    this.mAvgColorFilter.clearGLSLSelf();
    this.mCopyFilter.clearGLSLSelf();
    this.mDotFilter.clearGLSLSelf();
    this.mDotFrame.clear();
    this.mGpuLookupFrame.clear();
    this.mAcgColorFrame.clear();
    this.mGpuImageLookupFilter.clearGLSLSelf();
    super.clearGLSLSelf();
  }
  
  public int getOrderMode()
  {
    if (this.mItem != null) {
      return this.mItem.comicOrderMode;
    }
    return 0;
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("width", 720.0F));
    addParam(new UniformParam.FloatParam("height", 1080.0F));
    addParam(new UniformParam.FloatParam("threshold", 0.7F));
    addParam(new UniformParam.FloatParam("edgeStrength", 1.5F));
  }
  
  public boolean isAlreadyRenderInSingleFrame()
  {
    return this.mAlreadyRenderInSingleFrame;
  }
  
  public boolean isRenderReady()
  {
    return true;
  }
  
  public void reset()
  {
    this.mAlreadyRenderInSingleFrame = false;
  }
  
  public void setAdjustParam(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.FloatParam("width", paramInt1));
    addParam(new UniformParam.FloatParam("height", paramInt2));
  }
  
  public void setAlreadyRenderInSingleFrame(boolean paramBoolean)
  {
    this.mAlreadyRenderInSingleFrame = paramBoolean;
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo, int paramInt1, int paramInt2)
  {
    setAdjustParam(paramInt1, paramInt2);
    this.mAvgColorFilter.setAdjustParam(paramInt1, paramInt2);
    this.mDotFilter.setAdjustParam(paramInt1, paramInt2);
  }
  
  public void updatePreview(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.ComicEffectFilter
 * JD-Core Version:    0.7.0.1
 */