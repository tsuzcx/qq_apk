package com.tencent.tav.extractor.wrapper;

import com.tencent.tav.extractor.AssetExtractor;
import java.util.HashMap;

public class ExtractorWrapperPool
{
  private static final HashMap<String, ExtractorWrapper> extractorHashMap = new HashMap();
  
  public static void clear()
  {
    try
    {
      extractorHashMap.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean contains(String paramString)
  {
    try
    {
      boolean bool = extractorHashMap.containsKey(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void fillIn(String paramString, AssetExtractor paramAssetExtractor)
  {
    try
    {
      paramString = get(paramString);
      paramString.checkAndLoad(paramAssetExtractor);
      paramAssetExtractor.setSize(paramString.getVideoSize());
      paramAssetExtractor.setDuration(paramString.getDuration());
      paramAssetExtractor.setPreferRotation(paramString.getPreferRotation());
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static ExtractorWrapper get(String paramString)
  {
    try
    {
      ExtractorWrapper localExtractorWrapper2 = (ExtractorWrapper)extractorHashMap.get(paramString);
      ExtractorWrapper localExtractorWrapper1 = localExtractorWrapper2;
      if (localExtractorWrapper2 == null) {
        localExtractorWrapper1 = new ExtractorWrapper(paramString);
      }
      extractorHashMap.put(paramString, localExtractorWrapper1);
      return localExtractorWrapper1;
    }
    finally {}
  }
  
  public static void load(AssetExtractor paramAssetExtractor)
  {
    try
    {
      get(paramAssetExtractor.getSourcePath()).checkAndLoad(paramAssetExtractor);
      return;
    }
    finally
    {
      paramAssetExtractor = finally;
      throw paramAssetExtractor;
    }
  }
  
  public static void load(String paramString)
  {
    try
    {
      AssetExtractor localAssetExtractor = new AssetExtractor();
      localAssetExtractor.setDataSource(paramString);
      get(paramString).checkAndLoad(localAssetExtractor);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void put(ExtractorWrapper paramExtractorWrapper)
  {
    try
    {
      extractorHashMap.put(paramExtractorWrapper.getVideoPath(), paramExtractorWrapper);
      return;
    }
    finally
    {
      paramExtractorWrapper = finally;
      throw paramExtractorWrapper;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.extractor.wrapper.ExtractorWrapperPool
 * JD-Core Version:    0.7.0.1
 */