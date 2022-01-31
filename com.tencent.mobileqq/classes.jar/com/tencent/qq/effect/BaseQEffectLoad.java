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
    paramQEffectData.vertex = QEffectUtils.loadShaderFile(paramString1 + "/" + paramQEffectData.vertex);
    paramQEffectData.fragment = QEffectUtils.loadShaderFile(paramString1 + "/" + paramQEffectData.fragment);
    return paramQEffectData;
  }
  
  public static QEffectData analyzeLottieData(QEffectData paramQEffectData, String paramString)
  {
    paramQEffectData.src = paramString;
    paramString = new File(new File(paramString).getParentFile().getAbsolutePath() + File.separator + "images/");
    if (paramString.exists()) {
      paramQEffectData.images = (paramString.getAbsolutePath() + "/");
    }
    return paramQEffectData;
  }
  
  public void load(Context paramContext, IQEffect paramIQEffect, QEffectData paramQEffectData)
  {
    switch (paramQEffectData.resType)
    {
    case 2: 
    default: 
      return;
    case 1: 
      loadFromFile(paramContext, paramIQEffect, paramQEffectData.src);
      return;
    }
    loadFromResource(paramContext, paramIQEffect, paramQEffectData.resId);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qq.effect.BaseQEffectLoad
 * JD-Core Version:    0.7.0.1
 */