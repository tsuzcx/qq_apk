package com.tencent.tav.extractor.wrapper;

import com.tencent.tav.extractor.AssetExtractor;

class ExtractorLoader$ExtractorLoaderRunnable
  implements Runnable
{
  private AssetExtractor extractor;
  
  ExtractorLoader$ExtractorLoaderRunnable(AssetExtractor paramAssetExtractor)
  {
    this.extractor = paramAssetExtractor;
  }
  
  public void run()
  {
    if (!ExtractorWrapperPool.contains(this.extractor.getSourcePath()))
    {
      ExtractorWrapper localExtractorWrapper = new ExtractorWrapper(this.extractor.getSourcePath());
      localExtractorWrapper.checkAndLoad(this.extractor);
      ExtractorWrapperPool.put(localExtractorWrapper);
      this.extractor = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.extractor.wrapper.ExtractorLoader.ExtractorLoaderRunnable
 * JD-Core Version:    0.7.0.1
 */