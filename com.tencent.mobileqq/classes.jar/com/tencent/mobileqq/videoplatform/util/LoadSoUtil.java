package com.tencent.mobileqq.videoplatform.util;

import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.imp.LoadSoImp;

public class LoadSoUtil
{
  private static ILoadSo sLoader = new LoadSoImp();
  
  public static boolean isCkeygeneratorV2Load()
  {
    return sLoader.isCkeygeneratorV2Load();
  }
  
  public static boolean isCkguardLoad()
  {
    return sLoader.isCkguardLoad();
  }
  
  public static boolean isDownProxyLoad()
  {
    return sLoader.isDownProxyLoad();
  }
  
  public static boolean isTPCoreLoad()
  {
    return sLoader.isTPCoreLoad();
  }
  
  public static boolean loadDownProxySync()
  {
    return sLoader.loadDownProxySync();
  }
  
  public static void loadSo(LoadSoCallback paramLoadSoCallback)
  {
    sLoader.loadSo(paramLoadSoCallback);
  }
  
  public static boolean loadTPCoreSync()
  {
    return sLoader.loadTPCoreSync();
  }
  
  public static void setLoadSoImp(ILoadSo paramILoadSo)
  {
    sLoader = paramILoadSo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.util.LoadSoUtil
 * JD-Core Version:    0.7.0.1
 */