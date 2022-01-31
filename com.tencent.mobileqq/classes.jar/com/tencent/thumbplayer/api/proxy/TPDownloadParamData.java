package com.tencent.thumbplayer.api.proxy;

import java.util.ArrayList;
import java.util.Map;

public class TPDownloadParamData
{
  private String[] bakUrl;
  private String base;
  private int clipCount = 1;
  private int clipNo = 1;
  private String currentFormat;
  private int currentFormatID;
  private int dlType;
  private String downloadFileID;
  private int endTimeMS;
  private Map<String, String> extInfoMap;
  private boolean extraParam;
  private long fileDuration;
  private String fileMD5;
  private long fileSize;
  private Map<String, Integer> formatInfo;
  private int fp2p;
  private boolean isCharge;
  private boolean isOffline = false;
  private String linkVid;
  private String m3u8;
  private boolean needEncryptCache;
  private String playDefinition;
  private long preloadDuration;
  private long preloadSize;
  private String savePath;
  private int starTimeMS;
  private int testid;
  private long tm;
  public String url;
  private ArrayList<String> urlCdnidList;
  private ArrayList<String> urlCookieList;
  private int urlExpireTime;
  private ArrayList<String> urlHostList;
  private String vid;
  
  public TPDownloadParamData() {}
  
  public TPDownloadParamData(int paramInt)
  {
    this(null, paramInt);
  }
  
  public TPDownloadParamData(String paramString)
  {
    this(paramString, 0);
  }
  
  public TPDownloadParamData(String paramString, int paramInt)
  {
    this.downloadFileID = paramString;
    this.dlType = paramInt;
  }
  
  public String[] getBakUrl()
  {
    return this.bakUrl;
  }
  
  public String getBase()
  {
    return this.base;
  }
  
  public int getClipCount()
  {
    return this.clipCount;
  }
  
  public int getClipNo()
  {
    return this.clipNo;
  }
  
  public String getCurrentFormat()
  {
    return this.currentFormat;
  }
  
  public int getCurrentFormatID()
  {
    return this.currentFormatID;
  }
  
  public int getDlType()
  {
    return this.dlType;
  }
  
  public String getDownloadFileID()
  {
    return this.downloadFileID;
  }
  
  public int getEndTimeMS()
  {
    return this.endTimeMS;
  }
  
  public Map<String, String> getExtInfoMap()
  {
    return this.extInfoMap;
  }
  
  public long getFileDuration()
  {
    return this.fileDuration;
  }
  
  public String getFileMD5()
  {
    return this.fileMD5;
  }
  
  public long getFileSize()
  {
    return this.fileSize;
  }
  
  public Map<String, Integer> getFormatInfo()
  {
    return this.formatInfo;
  }
  
  public int getFp2p()
  {
    return this.fp2p;
  }
  
  public String getLinkVid()
  {
    return this.linkVid;
  }
  
  public String getM3u8()
  {
    return this.m3u8;
  }
  
  public String getPlayDefinition()
  {
    return this.playDefinition;
  }
  
  public long getPreloadDuration()
  {
    return this.preloadDuration;
  }
  
  public long getPreloadSize()
  {
    return this.preloadSize;
  }
  
  public String getSavePath()
  {
    return this.savePath;
  }
  
  public int getStarTimeMS()
  {
    return this.starTimeMS;
  }
  
  public int getTestid()
  {
    return this.testid;
  }
  
  public long getTm()
  {
    return this.tm;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public ArrayList<String> getUrlCdnidList()
  {
    return this.urlCdnidList;
  }
  
  public ArrayList<String> getUrlCookieList()
  {
    return this.urlCookieList;
  }
  
  public int getUrlExpireTime()
  {
    return this.urlExpireTime;
  }
  
  public ArrayList<String> getUrlHostList()
  {
    return this.urlHostList;
  }
  
  public String getVid()
  {
    return this.vid;
  }
  
  public boolean isCharge()
  {
    return this.isCharge;
  }
  
  public boolean isExtraParam()
  {
    return this.extraParam;
  }
  
  public boolean isNeedEncryptCache()
  {
    return this.needEncryptCache;
  }
  
  public boolean isOffline()
  {
    return this.isOffline;
  }
  
  public void setBakUrl(String[] paramArrayOfString)
  {
    this.bakUrl = paramArrayOfString;
  }
  
  public void setBase(String paramString)
  {
    this.base = paramString;
  }
  
  public void setCharge(boolean paramBoolean)
  {
    this.isCharge = paramBoolean;
  }
  
  public void setClipCount(int paramInt)
  {
    this.clipCount = paramInt;
  }
  
  public void setClipNo(int paramInt)
  {
    this.clipNo = paramInt;
  }
  
  public void setCurrentFormat(String paramString)
  {
    this.currentFormat = paramString;
  }
  
  public void setCurrentFormatID(int paramInt)
  {
    this.currentFormatID = paramInt;
  }
  
  public void setDlType(int paramInt)
  {
    this.dlType = paramInt;
  }
  
  public void setDownloadFileID(String paramString)
  {
    this.downloadFileID = paramString;
  }
  
  public void setEndTimeMS(int paramInt)
  {
    this.endTimeMS = paramInt;
  }
  
  public void setExtInfoMap(Map<String, String> paramMap)
  {
    this.extInfoMap = paramMap;
  }
  
  public void setExtraParam(boolean paramBoolean)
  {
    this.extraParam = paramBoolean;
  }
  
  public void setFileDuration(long paramLong)
  {
    this.fileDuration = paramLong;
  }
  
  public void setFileMD5(String paramString)
  {
    this.fileMD5 = paramString;
  }
  
  public void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public void setFormatInfo(Map<String, Integer> paramMap)
  {
    this.formatInfo = paramMap;
  }
  
  public void setFp2p(int paramInt)
  {
    this.fp2p = paramInt;
  }
  
  public void setLinkVid(String paramString)
  {
    this.linkVid = paramString;
  }
  
  public void setM3u8(String paramString)
  {
    this.m3u8 = paramString;
  }
  
  public void setNeedEncryptCache(boolean paramBoolean)
  {
    this.needEncryptCache = paramBoolean;
  }
  
  public void setOffline(boolean paramBoolean)
  {
    this.isOffline = paramBoolean;
  }
  
  public void setPlayDefinition(String paramString)
  {
    this.playDefinition = paramString;
  }
  
  public void setPreloadDuration(long paramLong)
  {
    this.preloadDuration = paramLong;
  }
  
  public void setPreloadSize(long paramLong)
  {
    this.preloadSize = paramLong;
  }
  
  public void setSavePath(String paramString)
  {
    this.savePath = paramString;
  }
  
  public void setStarTimeMS(int paramInt)
  {
    this.starTimeMS = paramInt;
  }
  
  public void setTestid(int paramInt)
  {
    this.testid = paramInt;
  }
  
  public void setTm(long paramLong)
  {
    this.tm = paramLong;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setUrlCdnidList(ArrayList<String> paramArrayList)
  {
    this.urlCdnidList = paramArrayList;
  }
  
  public void setUrlCookieList(ArrayList<String> paramArrayList)
  {
    this.urlCookieList = paramArrayList;
  }
  
  public void setUrlExpireTime(int paramInt)
  {
    this.urlExpireTime = paramInt;
  }
  
  public void setUrlHostList(ArrayList<String> paramArrayList)
  {
    this.urlHostList = paramArrayList;
  }
  
  public void setVid(String paramString)
  {
    this.vid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.proxy.TPDownloadParamData
 * JD-Core Version:    0.7.0.1
 */