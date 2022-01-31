package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.io.File;

public class HairDecolor
  extends VideoFilterBase
{
  private static String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 maskCoordinate;\nvarying vec2 maskYYCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureLUT;\nuniform sampler2D inputImageTextureMask;\nuniform sampler2D inputImageTextureYY;\nuniform float alpha;\nuniform float isBlack;\nfloat maskYY = 1.0;\n\nvoid main() {\n  vec4 textureColor = texture2D(inputImageTexture, maskCoordinate);\n  vec4 newColor = textureColor;\n  float maskColor = texture2D(inputImageTextureMask, maskCoordinate).r;\n  \n  if (isBlack < 0.5) {\n    maskYY = texture2D(inputImageTextureYY, maskYYCoordinate).r;\n  } else if (isBlack < 1.5){\n    maskYY = 1.0 - texture2D(inputImageTextureYY, maskYYCoordinate).r;\n  }\n\n  if (maskColor > 0.001 && maskYY > 0.001 ) {\n    highp float blueColor = textureColor.b * 63.0;\n    highp vec2 quad1; quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n    lowp vec4 newColor1 = texture2D(inputImageTextureLUT, texPos1);\n    lowp vec4 newColor2 = texture2D(inputImageTextureLUT, texPos2);\n    newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, newColor, alpha * maskYY * maskColor);\n  }\n  gl_FragColor = vec4(newColor.rgb, textureColor.w);\n}\n";
  public static final String LOOKUP_TABLE_FILE_NAME = "hair.lut";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 maskCoordinate;\nvarying vec2 maskYYCoordinate;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    maskCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    maskYYCoordinate = inputTextureCoordinate;\n}";
  private float YYtype;
  private int genderType = 0;
  private boolean isLUTLegal = true;
  private boolean isYYLegal = true;
  private StickerItem item;
  private VideoFilterBase mCopyFilter = new VideoFilterBase(BaseFilter.getFragmentShader(0));
  private String mDataPath;
  private String mLutName;
  private int[] mPartIndex;
  private String maskYYName;
  
  public HairDecolor(StickerItem paramStickerItem, String paramString1, String paramString2, float paramFloat)
  {
    super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 maskCoordinate;\nvarying vec2 maskYYCoordinate;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    maskCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    maskYYCoordinate = inputTextureCoordinate;\n}", FRAGMENT_SHADER);
    this.mDataPath = paramString1;
    this.mLutName = paramStickerItem.hairLutName;
    this.item = paramStickerItem;
    this.mPartIndex = paramStickerItem.activeParts;
    this.maskYYName = paramString2;
    this.genderType = paramStickerItem.genderType;
    this.YYtype = paramFloat;
    initParams();
  }
  
  public HairDecolor(String paramString1, String paramString2)
  {
    super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 maskCoordinate;\nvarying vec2 maskYYCoordinate;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    maskCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    maskYYCoordinate = inputTextureCoordinate;\n}", FRAGMENT_SHADER);
    this.mDataPath = paramString1;
    this.mLutName = paramString2;
    this.YYtype = 2.0F;
    initParams();
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.mCopyFilter.ApplyGLSLFilter();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.mCopyFilter.clearGLSLSelf();
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
  
  public boolean getLUTLegal()
  {
    return this.isLUTLegal;
  }
  
  public boolean getYYLegal()
  {
    return (this.isYYLegal) || (this.YYtype > 1.5F);
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    setTexCords(new float[] { 0.5F, 0.0F, 0.5F, 0.3F, 0.0F, 0.0F, 0.5F, 0.6F, 0.0F, 1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.5F, 0.6F, 1.0F, 0.0F, 0.5F, 0.3F, 0.5F, 0.0F });
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
    setCoordNum(11);
  }
  
  public void initParams()
  {
    Object localObject3 = null;
    Object localObject1 = this.mDataPath + File.separator + this.mLutName;
    Object localObject2;
    if ((this.mLutName == null) || (!FileUtils.exists((String)localObject1)))
    {
      localObject1 = getBitmap(this.mDataPath + File.separator + "hair.lut");
      localObject2 = localObject1;
      if (!BitmapUtils.isLegal((Bitmap)localObject1))
      {
        this.isLUTLegal = false;
        localObject2 = null;
      }
      localObject1 = getBitmap(this.mDataPath + File.separator + this.maskYYName);
      if (BitmapUtils.isLegal((Bitmap)localObject1)) {
        break label236;
      }
      this.isYYLegal = false;
      localObject1 = localObject3;
    }
    label236:
    for (;;)
    {
      addParam(new UniformParam.TextureBitmapParam("inputImageTextureLUT", localObject2, 33986, true));
      addParam(new UniformParam.TextureBitmapParam("inputImageTextureYY", (Bitmap)localObject1, 33987, true));
      addParam(new UniformParam.TextureParam("inputImageTextureMask", 0, 33988));
      addParam(new UniformParam.FloatParam("alpha", 1.0F));
      addParam(new UniformParam.FloatParam("isBlack", this.YYtype));
      return;
      localObject1 = getBitmap((String)localObject1);
      break;
    }
  }
  
  public boolean isInCurPart(int paramInt)
  {
    if ((this.mPartIndex == null) || (paramInt < 0)) {
      return true;
    }
    int[] arrayOfInt = this.mPartIndex;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label45;
      }
      if (arrayOfInt[i] == paramInt) {
        break;
      }
      i += 1;
    }
    label45:
    return false;
  }
  
  public Frame render(Frame paramFrame, PointF[] paramArrayOfPointF1, PointF[] paramArrayOfPointF2, int paramInt)
  {
    if ((getLUTLegal()) && (getYYLegal()))
    {
      Frame localFrame = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      setPositions(new float[] { paramArrayOfPointF2[0].x, paramArrayOfPointF2[0].y, paramArrayOfPointF2[1].x, paramArrayOfPointF2[1].y, paramArrayOfPointF1[0].x, paramArrayOfPointF1[0].y, paramArrayOfPointF2[2].x, paramArrayOfPointF2[2].y, paramArrayOfPointF1[1].x, paramArrayOfPointF1[1].y, paramArrayOfPointF2[3].x, paramArrayOfPointF2[3].y, paramArrayOfPointF1[3].x, paramArrayOfPointF1[3].y, paramArrayOfPointF2[2].x, paramArrayOfPointF2[2].y, paramArrayOfPointF1[2].x, paramArrayOfPointF1[2].y, paramArrayOfPointF2[1].x, paramArrayOfPointF2[1].y, paramArrayOfPointF2[0].x, paramArrayOfPointF2[0].y });
      setMask(paramInt);
      RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, -1, 0.0D, paramFrame);
      localFrame.unlock();
    }
    return paramFrame;
  }
  
  public void setMask(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTextureMask", paramInt, 33988));
  }
  
  public void updateAlpha(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("alpha", paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.HairDecolor
 * JD-Core Version:    0.7.0.1
 */