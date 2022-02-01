package com.tencent.qcircle.shadow.core.runtime.skin.entity;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.qcircle.shadow.core.runtime.skin.loader.ContextHolder;

public class AttrFactory
{
  private static final String TAG;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SKIN");
    localStringBuilder.append(AttrFactory.class.getSimpleName());
    TAG = localStringBuilder.toString();
  }
  
  public static SkinAttr createAttr(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt == 0) {
      return null;
    }
    try
    {
      SkinAttr localSkinAttr = createAttrByName(paramString1);
      if (localSkinAttr != null) {
        localSkinAttr.setBaseValue(paramString1, paramString2, ContextHolder.getContext().getResources().getResourceTypeName(paramInt), paramInt);
      }
      return localSkinAttr;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  private static SkinAttr createAttrByName(String paramString)
  {
    int i = paramString.hashCode();
    if (i != -1240751833)
    {
      if (i != -289402411)
      {
        if ((i == 424945759) && (paramString.equals("BackgroundAttr")))
        {
          i = 2;
          break label70;
        }
      }
      else if (paramString.equals("SrcAttr"))
      {
        i = 1;
        break label70;
      }
    }
    else if (paramString.equals("TextColorAttr"))
    {
      i = 0;
      break label70;
    }
    i = -1;
    label70:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return null;
        }
        return new BackgroundAttr();
      }
      return new SrcAttr();
    }
    return new TextColorAttr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.skin.entity.AttrFactory
 * JD-Core Version:    0.7.0.1
 */