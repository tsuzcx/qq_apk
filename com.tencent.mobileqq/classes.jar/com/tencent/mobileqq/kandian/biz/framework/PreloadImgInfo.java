package com.tencent.mobileqq.kandian.biz.framework;

import android.util.Pair;
import java.net.URL;

public class PreloadImgInfo
{
  public URL a;
  public Pair<Integer, Integer> b;
  
  public static PreloadImgInfo a(URL paramURL, Pair<Integer, Integer> paramPair)
  {
    PreloadImgInfo localPreloadImgInfo = new PreloadImgInfo();
    localPreloadImgInfo.a = paramURL;
    localPreloadImgInfo.b = paramPair;
    return localPreloadImgInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.PreloadImgInfo
 * JD-Core Version:    0.7.0.1
 */