package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import java.io.File;

public class SimpleEffectVideoFilter
  extends VideoFilterBase
{
  public static final String LOOKUP_TABLE_FILE_NAME = "filterEffect.lut";
  private String mDataPath;
  private String mLutName;
  
  public SimpleEffectVideoFilter(String paramString)
  {
    this(paramString, null, 1.0F);
  }
  
  public SimpleEffectVideoFilter(String paramString1, String paramString2, float paramFloat)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.LOOKUP_ALPHA));
    this.mDataPath = paramString1;
    this.mLutName = paramString2;
    initParams();
    setAdjustParam(1.0F - paramFloat);
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
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("alpha", 0.0F));
    Object localObject = this.mDataPath + File.separator + this.mLutName;
    if ((this.mLutName == null) || (!FileUtils.exists((String)localObject))) {}
    for (localObject = getBitmap(this.mDataPath + File.separator + "filterEffect.lut");; localObject = getBitmap((String)localObject))
    {
      addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", (Bitmap)localObject, 33986, true));
      return;
    }
  }
  
  public void setAdjustParam(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("alpha", paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.SimpleEffectVideoFilter
 * JD-Core Version:    0.7.0.1
 */