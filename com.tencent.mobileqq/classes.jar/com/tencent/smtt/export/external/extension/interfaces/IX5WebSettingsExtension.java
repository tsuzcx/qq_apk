package com.tencent.smtt.export.external.extension.interfaces;

import java.util.List;
import java.util.Map;

public abstract interface IX5WebSettingsExtension
{
  public static final int PicModel_NORMAL = 1;
  public static final int PicModel_NetNoPic = 3;
  public static final int PicModel_NoPic = 2;
  
  public abstract void customDiskCachePathEnabled(boolean paramBoolean, String paramString);
  
  public abstract boolean getBlockLocalAddressEnable();
  
  public abstract boolean getPageSolarEnableFlag();
  
  public abstract boolean isFitScreen();
  
  public abstract boolean isReadModeWebView();
  
  public abstract boolean isWapSitePreferred();
  
  public abstract boolean isWebViewInBackground();
  
  public abstract void setARModeEnable(boolean paramBoolean);
  
  public abstract void setAcceptCookie(boolean paramBoolean);
  
  public abstract void setAdditionalHttpHeaders(Map<String, String> paramMap);
  
  public abstract void setAutoDetectToOpenFitScreenEnabled(boolean paramBoolean);
  
  public abstract void setAutoRecoredAndRestoreScaleEnabled(boolean paramBoolean);
  
  public abstract void setBlockLocalAddressEnable(boolean paramBoolean);
  
  public abstract void setContentCacheEnable(boolean paramBoolean);
  
  public abstract void setDayOrNight(boolean paramBoolean);
  
  public abstract void setDisplayCutoutEnable(boolean paramBoolean);
  
  public abstract void setEnableUnderLine(boolean paramBoolean);
  
  public abstract void setFirstScreenDetect(boolean paramBoolean);
  
  public abstract void setFirstScreenSoftwareTextureDraw(boolean paramBoolean);
  
  public abstract void setFitScreen(boolean paramBoolean);
  
  public abstract void setForcePinchScaleEnabled(boolean paramBoolean);
  
  public abstract void setFramePerformanceRecordEnable(boolean paramBoolean);
  
  public abstract boolean setHttpDnsDomains(List<String> paramList);
  
  public abstract void setImageScanEnable(boolean paramBoolean);
  
  public abstract void setImgAsDownloadFile(boolean paramBoolean);
  
  public abstract void setIsViewSourceMode(boolean paramBoolean);
  
  public abstract void setJSPerformanceRecordEnable(boolean paramBoolean);
  
  public abstract void setJavaScriptOpenWindowsBlockedNotifyEnabled(boolean paramBoolean);
  
  public abstract void setOnContextMenuEnable(boolean paramBoolean);
  
  public abstract void setOnlyDomTreeBuild(boolean paramBoolean);
  
  public abstract void setPageCacheCapacity(int paramInt);
  
  public abstract void setPageSolarEnableFlag(boolean paramBoolean);
  
  public abstract void setPicModel(int paramInt);
  
  public abstract void setPreFectch(boolean paramBoolean);
  
  public abstract void setPreFectchEnableWhenHasMedia(boolean paramBoolean);
  
  public abstract void setReadModeWebView(boolean paramBoolean);
  
  public abstract void setRecordRequestEnabled(boolean paramBoolean);
  
  public abstract void setRememberScaleValue(boolean paramBoolean);
  
  public abstract void setSelectionColorEnabled(boolean paramBoolean);
  
  public abstract void setShouldRequestFavicon(boolean paramBoolean);
  
  public abstract void setShouldTrackVisitedLinks(boolean paramBoolean);
  
  public abstract void setSmartFullScreenEnabled(boolean paramBoolean);
  
  public abstract void setTbsARShareType(int paramInt);
  
  public abstract void setTextDecorationUnlineEnabled(boolean paramBoolean);
  
  public abstract void setUseQProxy(boolean paramBoolean);
  
  public abstract void setWapSitePreferred(boolean paramBoolean);
  
  public abstract void setWebViewInBackground(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension
 * JD-Core Version:    0.7.0.1
 */