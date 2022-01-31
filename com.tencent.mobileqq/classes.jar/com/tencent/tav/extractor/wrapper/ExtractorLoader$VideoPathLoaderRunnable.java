package com.tencent.tav.extractor.wrapper;

import com.tencent.tav.extractor.AssetExtractor;

class ExtractorLoader$VideoPathLoaderRunnable
  implements Runnable
{
  private String videoPath;
  
  ExtractorLoader$VideoPathLoaderRunnable(String paramString)
  {
    this.videoPath = paramString;
  }
  
  public void run()
  {
    if (!ExtractorWrapperPool.contains(this.videoPath))
    {
      AssetExtractor localAssetExtractor = new AssetExtractor();
      localAssetExtractor.setDataSource(this.videoPath);
      ExtractorWrapper localExtractorWrapper = new ExtractorWrapper(this.videoPath);
      localExtractorWrapper.checkAndLoad(localAssetExtractor);
      ExtractorWrapperPool.put(localExtractorWrapper);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.extractor.wrapper.ExtractorLoader.VideoPathLoaderRunnable
 * JD-Core Version:    0.7.0.1
 */