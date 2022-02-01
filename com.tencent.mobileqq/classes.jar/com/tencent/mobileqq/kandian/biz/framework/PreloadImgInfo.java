package com.tencent.mobileqq.kandian.biz.framework;

import android.util.Pair;
import java.net.URL;

public class PreloadImgInfo
{
  public Pair<Integer, Integer> a;
  public URL a;
  
  public static PreloadImgInfo a(URL paramURL, Pair<Integer, Integer> paramPair)
  {
    PreloadImgInfo localPreloadImgInfo = new PreloadImgInfo();
    localPreloadImgInfo.jdField_a_of_type_JavaNetURL = paramURL;
    localPreloadImgInfo.jdField_a_of_type_AndroidUtilPair = paramPair;
    return localPreloadImgInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.PreloadImgInfo
 * JD-Core Version:    0.7.0.1
 */