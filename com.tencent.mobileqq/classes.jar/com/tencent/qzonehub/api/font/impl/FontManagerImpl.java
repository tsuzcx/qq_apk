package com.tencent.qzonehub.api.font.impl;

import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.earlydownload.EarlyDownLoadListener;
import com.tencent.qzonehub.api.font.IFontManager;
import cooperation.qzone.font.DefaultBarrageEffectInfo;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.font.DefaultSuperFontInfo;
import cooperation.qzone.font.FontInterface.FullTypeResult;
import cooperation.qzone.font.FontInterface.TrueTypeResult;
import cooperation.qzone.font.FontManager;

public class FontManagerImpl
  implements IFontManager
{
  public boolean ETEngineLoaded()
  {
    return FontManager.getInstance().ETEngineLoaded();
  }
  
  public DefaultBarrageEffectInfo getDefaultBarrageEffectInfo(long paramLong)
  {
    return FontManager.getInstance().getDefaultBarrageEffectInfo(paramLong);
  }
  
  public DefaultFontInfo getDefaultFont(long paramLong)
  {
    return FontManager.getInstance().getDefaultFont(paramLong);
  }
  
  public DefaultSuperFontInfo getDefaultSuperFont(long paramLong)
  {
    return FontManager.getInstance().getDefaultSuperFont(paramLong);
  }
  
  public ETEngine getETEngine()
  {
    return FontManager.getInstance().getETEngine();
  }
  
  public String getFullTypeFont(int paramInt, String paramString1, String paramString2, FontInterface.FullTypeResult paramFullTypeResult)
  {
    return FontManager.getInstance().getFullTypeFont(paramInt, paramString1, paramString2, paramFullTypeResult);
  }
  
  public String getTrueTypeFont(int paramInt, String paramString1, String paramString2, boolean paramBoolean, FontInterface.TrueTypeResult paramTrueTypeResult)
  {
    return FontManager.getInstance().getTrueTypeFont(paramInt, paramString1, paramString2, paramBoolean, paramTrueTypeResult);
  }
  
  public void setDefaultBarrageEffect(long paramLong, DefaultBarrageEffectInfo paramDefaultBarrageEffectInfo)
  {
    FontManager.getInstance().setDefaultBarrageEffect(paramLong, paramDefaultBarrageEffectInfo);
  }
  
  public void setDefaultFont(long paramLong, DefaultFontInfo paramDefaultFontInfo)
  {
    FontManager.getInstance().setDefaultFont(paramLong, paramDefaultFontInfo);
  }
  
  public void setDefaultSuperFont(long paramLong, DefaultSuperFontInfo paramDefaultSuperFontInfo)
  {
    FontManager.getInstance().setDefaultSuperFont(paramLong, paramDefaultSuperFontInfo);
  }
  
  public void startFontSoDownload(EarlyDownLoadListener paramEarlyDownLoadListener)
  {
    FontManager.getInstance().startFontSoDownload(paramEarlyDownLoadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.font.impl.FontManagerImpl
 * JD-Core Version:    0.7.0.1
 */