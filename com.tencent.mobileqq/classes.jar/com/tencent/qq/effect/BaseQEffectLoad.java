package com.tencent.qq.effect;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.utils.QEffectUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BaseQEffectLoad
  implements IQEffectLoad
{
  public static QEffectData analyzeGLSLData(QEffectData paramQEffectData, String paramString1, String paramString2)
  {
    paramQEffectData.src = paramString2;
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("/");
    paramString2.append(paramQEffectData.vertex);
    paramQEffectData.vertex = QEffectUtils.loadShaderFile(paramString2.toString());
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("/");
    paramString2.append(paramQEffectData.fragment);
    paramQEffectData.fragment = QEffectUtils.loadShaderFile(paramString2.toString());
    return paramQEffectData;
  }
  
  public static QEffectData analyzeLottieData(QEffectData paramQEffectData, String paramString)
  {
    paramQEffectData.src = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new File(paramString).getParentFile().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("images/");
    paramString = new File(localStringBuilder.toString());
    if (paramString.exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.getAbsolutePath());
      localStringBuilder.append("/");
      paramQEffectData.images = localStringBuilder.toString();
    }
    return paramQEffectData;
  }
  
  public void load(Context paramContext, IQEffect paramIQEffect, QEffectData paramQEffectData)
  {
    int i = paramQEffectData.resType;
    if (i != 1)
    {
      if (i != 3) {
        return;
      }
      loadFromResource(paramContext, paramIQEffect, paramQEffectData.resId);
      return;
    }
    loadFromFile(paramContext, paramIQEffect, paramQEffectData.src);
  }
  
  public void loadFromAsset(Context paramContext, IQEffect paramIQEffect, String paramString) {}
  
  public void loadFromFile(Context paramContext, IQEffect paramIQEffect, String paramString)
  {
    try
    {
      paramIQEffect.complete(new BitmapDrawable(BitmapFactory.decodeStream(new FileInputStream(paramString))));
      return;
    }
    catch (FileNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void loadFromResource(Context paramContext, IQEffect paramIQEffect, int paramInt)
  {
    if (paramContext != null) {
      paramIQEffect.complete(paramContext.getResources().getDrawable(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.BaseQEffectLoad
 * JD-Core Version:    0.7.0.1
 */