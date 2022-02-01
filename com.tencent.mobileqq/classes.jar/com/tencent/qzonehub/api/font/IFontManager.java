package com.tencent.qzonehub.api.font;

import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.earlydownload.EarlyDownLoadListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.font.DefaultBarrageEffectInfo;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.font.DefaultSuperFontInfo;
import cooperation.qzone.font.FontInterface.FullTypeResult;
import cooperation.qzone.font.FontInterface.TrueTypeResult;

@QAPI(process={"all"})
public abstract interface IFontManager
  extends QRouteApi
{
  public abstract boolean ETEngineLoaded();
  
  public abstract DefaultBarrageEffectInfo getDefaultBarrageEffectInfo(long paramLong);
  
  public abstract DefaultFontInfo getDefaultFont(long paramLong);
  
  public abstract DefaultSuperFontInfo getDefaultSuperFont(long paramLong);
  
  public abstract ETEngine getETEngine();
  
  public abstract String getFullTypeFont(int paramInt, String paramString1, String paramString2, FontInterface.FullTypeResult paramFullTypeResult);
  
  public abstract String getTrueTypeFont(int paramInt, String paramString1, String paramString2, boolean paramBoolean, FontInterface.TrueTypeResult paramTrueTypeResult);
  
  public abstract void setDefaultBarrageEffect(long paramLong, DefaultBarrageEffectInfo paramDefaultBarrageEffectInfo);
  
  public abstract void setDefaultFont(long paramLong, DefaultFontInfo paramDefaultFontInfo);
  
  public abstract void setDefaultSuperFont(long paramLong, DefaultSuperFontInfo paramDefaultSuperFontInfo);
  
  public abstract void startFontSoDownload(EarlyDownLoadListener paramEarlyDownLoadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.font.IFontManager
 * JD-Core Version:    0.7.0.1
 */