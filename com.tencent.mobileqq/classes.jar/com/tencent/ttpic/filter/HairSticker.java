package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.StickerItem;

public class HairSticker
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 maskYYCoordinate;\nvarying vec2 stickerCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureSticker;\nuniform sampler2D inputImageTextureMask;\nuniform sampler2D inputImageTextureYY;\n\nuniform float isBlack; \nfloat maskYY = 1.0;\n\nuniform int blendMode;\n\nvec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 vOne = vec3(1.0, 1.0, 1.0);\n     vec3 vZero = vec3(0.0, 0.0, 0.0);\n     //revert pre multiply\n     if(texColor.a > 0.0){\n        texColor.rgb = texColor.rgb / texColor.a;\n     }\n     vec3 resultFore = texColor.rgb;\n     if (blendMode <= 1 || blendMode > 12){ //default, since used most, put on top\n\n     } else if (blendMode == 2) {  //multiply\n         resultFore = canvasColor.rgb * texColor.rgb;\n     } else if (blendMode == 3){    //screen\n         resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n     } else if (blendMode == 4){    //overlay\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (canvasColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (canvasColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (canvasColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 5){    //hardlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (texColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 6){    //softlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n         if (texColor.r >= 0.5) {\n             resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n         }\n     } else if (blendMode == 7){    //divide\n         resultFore = vOne;\n         if (texColor.r > 0.0) {\n             resultFore.r = canvasColor.r / texColor.r;\n         }\n         if (texColor.g > 0.0) {\n             resultFore.g = canvasColor.g / texColor.g;\n         }\n         if (texColor.b > 0.0) {\n             resultFore.b = canvasColor.b / texColor.b;\n         }\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 8){    //add\n         resultFore = canvasColor.rgb + texColor.rgb;\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 9){    //substract\n         resultFore = canvasColor.rgb - texColor.rgb;\n         resultFore = max(vZero, resultFore);\n     } else if (blendMode == 10){   //diff\n         resultFore = abs(canvasColor.rgb - texColor.rgb);\n     } else if (blendMode == 11){   //darken\n         resultFore = min(canvasColor.rgb, texColor.rgb);\n     } else if (blendMode == 12){   //lighten\n         resultFore = max(canvasColor.rgb, texColor.rgb);\n     }\n     //pre multiply for glBlendFunc\n     vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n\n     resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0);\n\n     return resultColor;\n }\n\nvoid main() {\n  vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n  vec4 newColor = canvasColor;\n  float maskColor = texture2D(inputImageTextureMask, canvasCoordinate).r;\n  \n  if (isBlack < 0.5) {\n    maskYY = texture2D(inputImageTextureYY, maskYYCoordinate).r;\n  } else if (isBlack < 1.5) {\n    maskYY = 1.0 - texture2D(inputImageTextureYY, maskYYCoordinate).r;\n  }\n  \n  \n  \n  if (maskColor > 0.001 && maskYY > 0.001) {\n    vec4 texColor = texture2D(inputImageTextureSticker, stickerCoordinate);\n    newColor = mix(newColor, blendColor(texColor, canvasColor), maskColor * maskYY);\n  }\n\n  gl_FragColor = newColor;\n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 inputGrayTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 maskYYCoordinate;\nvarying vec2 stickerCoordinate;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    stickerCoordinate = inputTextureCoordinate;\n    maskYYCoordinate = inputGrayTextureCoordinate;\n}";
  private float YYtype;
  private boolean isStickerReady = false;
  private boolean isYYLegal = true;
  private StickerItem item;
  private int lastIndex = -1;
  private VideoFilterBase mCopyFilter = new VideoFilterBase(BaseFilter.getFragmentShader(0));
  private String maskYYPath;
  private int[] texture = new int[1];
  
  public HairSticker(StickerItem paramStickerItem, String paramString, float paramFloat)
  {
    super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 inputGrayTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 maskYYCoordinate;\nvarying vec2 stickerCoordinate;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    stickerCoordinate = inputTextureCoordinate;\n    maskYYCoordinate = inputGrayTextureCoordinate;\n}", "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 maskYYCoordinate;\nvarying vec2 stickerCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureSticker;\nuniform sampler2D inputImageTextureMask;\nuniform sampler2D inputImageTextureYY;\n\nuniform float isBlack; \nfloat maskYY = 1.0;\n\nuniform int blendMode;\n\nvec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 vOne = vec3(1.0, 1.0, 1.0);\n     vec3 vZero = vec3(0.0, 0.0, 0.0);\n     //revert pre multiply\n     if(texColor.a > 0.0){\n        texColor.rgb = texColor.rgb / texColor.a;\n     }\n     vec3 resultFore = texColor.rgb;\n     if (blendMode <= 1 || blendMode > 12){ //default, since used most, put on top\n\n     } else if (blendMode == 2) {  //multiply\n         resultFore = canvasColor.rgb * texColor.rgb;\n     } else if (blendMode == 3){    //screen\n         resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n     } else if (blendMode == 4){    //overlay\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (canvasColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (canvasColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (canvasColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 5){    //hardlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (texColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 6){    //softlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n         if (texColor.r >= 0.5) {\n             resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n         }\n     } else if (blendMode == 7){    //divide\n         resultFore = vOne;\n         if (texColor.r > 0.0) {\n             resultFore.r = canvasColor.r / texColor.r;\n         }\n         if (texColor.g > 0.0) {\n             resultFore.g = canvasColor.g / texColor.g;\n         }\n         if (texColor.b > 0.0) {\n             resultFore.b = canvasColor.b / texColor.b;\n         }\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 8){    //add\n         resultFore = canvasColor.rgb + texColor.rgb;\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 9){    //substract\n         resultFore = canvasColor.rgb - texColor.rgb;\n         resultFore = max(vZero, resultFore);\n     } else if (blendMode == 10){   //diff\n         resultFore = abs(canvasColor.rgb - texColor.rgb);\n     } else if (blendMode == 11){   //darken\n         resultFore = min(canvasColor.rgb, texColor.rgb);\n     } else if (blendMode == 12){   //lighten\n         resultFore = max(canvasColor.rgb, texColor.rgb);\n     }\n     //pre multiply for glBlendFunc\n     vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n\n     resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0);\n\n     return resultColor;\n }\n\nvoid main() {\n  vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n  vec4 newColor = canvasColor;\n  float maskColor = texture2D(inputImageTextureMask, canvasCoordinate).r;\n  \n  if (isBlack < 0.5) {\n    maskYY = texture2D(inputImageTextureYY, maskYYCoordinate).r;\n  } else if (isBlack < 1.5) {\n    maskYY = 1.0 - texture2D(inputImageTextureYY, maskYYCoordinate).r;\n  }\n  \n  \n  \n  if (maskColor > 0.001 && maskYY > 0.001) {\n    vec4 texColor = texture2D(inputImageTextureSticker, stickerCoordinate);\n    newColor = mix(newColor, blendColor(texColor, canvasColor), maskColor * maskYY);\n  }\n\n  gl_FragColor = newColor;\n}\n");
    this.item = paramStickerItem;
    this.maskYYPath = paramString;
    this.YYtype = paramFloat;
    initParams();
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.mCopyFilter.ApplyGLSLFilter();
    GLES20.glGenTextures(this.texture.length, this.texture, 0);
  }
  
  public void clearGLSLSelf()
  {
    this.mCopyFilter.clearGLSLSelf();
    GLES20.glDeleteTextures(this.texture.length, this.texture, 0);
    super.clearGLSLSelf();
  }
  
  public Bitmap getBitmap(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {
      return BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), 2147483647, 2147483647);
    }
    return BitmapUtils.decodeSampledBitmapFromFile(paramString, 2147483647, 2147483647);
  }
  
  public StickerItem getItem()
  {
    return this.item;
  }
  
  public String getItemID()
  {
    if (this.item != null) {
      return this.item.id;
    }
    return null;
  }
  
  public int getNextFrame(int paramInt)
  {
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    if (BitmapUtils.isLegal(localBitmap))
    {
      GlUtil.loadTexture(this.texture[0], localBitmap);
      return this.texture[0];
    }
    return -1;
  }
  
  public boolean getYYLegal()
  {
    return (this.isYYLegal) || (this.YYtype > 1.5F);
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    setGrayCords(new float[] { 0.5F, 0.0F, 0.5F, 0.3F, 0.0F, 0.0F, 0.5F, 0.6F, 0.0F, 1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.5F, 0.6F, 1.0F, 0.0F, 0.5F, 0.3F, 0.5F, 0.0F });
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
    setCoordNum(11);
  }
  
  public void initParams()
  {
    Bitmap localBitmap2 = getBitmap(this.maskYYPath);
    Bitmap localBitmap1 = localBitmap2;
    if (!BitmapUtils.isLegal(localBitmap2))
    {
      this.isYYLegal = false;
      localBitmap1 = null;
    }
    addParam(new UniformParam.IntParam("blendMode", this.item.blendMode));
    addParam(new UniformParam.TextureParam("inputImageTextureSticker", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTextureMask", 0, 33987));
    addParam(new UniformParam.TextureBitmapParam("inputImageTextureYY", localBitmap1, 33988, true));
    addParam(new UniformParam.FloatParam("isBlack", this.YYtype));
  }
  
  public boolean isInCurPart(int paramInt)
  {
    if ((this.item.activeParts == null) || (paramInt < 0)) {
      return true;
    }
    int[] arrayOfInt = this.item.activeParts;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label51;
      }
      if (arrayOfInt[i] == paramInt) {
        break;
      }
      i += 1;
    }
    label51:
    return false;
  }
  
  public Frame render(Frame paramFrame, PointF[] paramArrayOfPointF1, PointF[] paramArrayOfPointF2, float[] paramArrayOfFloat, int paramInt)
  {
    if ((this.isStickerReady) && (getYYLegal()))
    {
      setMask(paramInt);
      Frame localFrame = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      setPositions(new float[] { paramArrayOfPointF2[0].x, paramArrayOfPointF2[0].y, paramArrayOfPointF2[1].x, paramArrayOfPointF2[1].y, paramArrayOfPointF1[0].x, paramArrayOfPointF1[0].y, paramArrayOfPointF2[2].x, paramArrayOfPointF2[2].y, paramArrayOfPointF1[1].x, paramArrayOfPointF1[1].y, paramArrayOfPointF2[3].x, paramArrayOfPointF2[3].y, paramArrayOfPointF1[3].x, paramArrayOfPointF1[3].y, paramArrayOfPointF2[2].x, paramArrayOfPointF2[2].y, paramArrayOfPointF1[2].x, paramArrayOfPointF1[2].y, paramArrayOfPointF2[1].x, paramArrayOfPointF2[1].y, paramArrayOfPointF2[0].x, paramArrayOfPointF2[0].y });
      setTexCords(paramArrayOfFloat);
      RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, -1, 0.0D, paramFrame);
      localFrame.unlock();
    }
    return paramFrame;
  }
  
  public void setMask(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTextureMask", paramInt, 33987));
  }
  
  public void stopRender()
  {
    this.lastIndex = -1;
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo, int paramInt1, int paramInt2)
  {
    updateTextureParams(paramInt2);
  }
  
  public void updateTextureParams(int paramInt)
  {
    if (paramInt == this.lastIndex) {
      return;
    }
    int i = getNextFrame(paramInt);
    if (i <= 0)
    {
      this.isStickerReady = false;
      return;
    }
    this.isStickerReady = true;
    addParam(new UniformParam.TextureParam("inputImageTextureSticker", i, 33986));
    this.lastIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.HairSticker
 * JD-Core Version:    0.7.0.1
 */