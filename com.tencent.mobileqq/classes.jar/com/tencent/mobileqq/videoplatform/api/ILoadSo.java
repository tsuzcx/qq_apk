package com.tencent.mobileqq.videoplatform.api;

public abstract interface ILoadSo
{
  public static final String SONAME_CKEYGENERATORV2 = "ckeygeneratorV2";
  public static final String SONAME_CKGUARD = "ckguard";
  public static final String SONAME_DOWNLOADPROXY = "DownloadProxy";
  public static final String SONAME_TPCORE_MASTER = "TPCore-master";
  
  public abstract boolean isCkeygeneratorV2Load();
  
  public abstract boolean isCkguardLoad();
  
  public abstract boolean isDownProxyLoad();
  
  public abstract boolean isTPCoreLoad();
  
  public abstract boolean loadDownProxySync();
  
  public abstract void loadSo(LoadSoCallback paramLoadSoCallback);
  
  public abstract boolean loadTPCoreSync();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.api.ILoadSo
 * JD-Core Version:    0.7.0.1
 */