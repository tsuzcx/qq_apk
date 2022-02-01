package com.tencent.superplayer.config;

import android.util.SparseArray;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;

class RequestRootGroup
{
  public static final int APP_ID_KUAIBAO = 570303;
  public static final int APP_ID_MOBILE_QQ = 170303;
  public static final int APP_ID_QQBROWSER = 160303;
  public static final int SCENE_ID_KV = 104;
  private static SparseArray<String> sRequestMap = new SparseArray();
  
  static
  {
    sRequestMap.put(170303, "mobileqq");
    sRequestMap.put(570303, "kuaibao");
    sRequestMap.put(160303, "qqbrowser");
  }
  
  public static String getRequestRootGroup()
  {
    return (String)sRequestMap.get(SuperPlayerSDKMgr.getPlatform(), "default");
  }
  
  public static boolean needRequest()
  {
    return sRequestMap.get(SuperPlayerSDKMgr.getPlatform(), null) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.config.RequestRootGroup
 * JD-Core Version:    0.7.0.1
 */