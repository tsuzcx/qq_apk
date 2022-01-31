package com.tencent.tav.extractor.wrapper;

import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.AssetExtractor;
import java.io.File;

public class ExtractorWrapper
{
  private long duration;
  private long lastUpdateTime;
  private int preferRotation;
  private String videoPath;
  private CGSize videoSize;
  
  public ExtractorWrapper(String paramString)
  {
    this.videoPath = paramString;
  }
  
  private boolean exit()
  {
    return (!TextUtils.isEmpty(this.videoPath)) && (new File(this.videoPath).exists());
  }
  
  private void loadWith(AssetExtractor paramAssetExtractor)
  {
    this.duration = paramAssetExtractor.getDuration();
    this.videoSize = paramAssetExtractor.getSize();
    this.preferRotation = paramAssetExtractor.getPreferRotation();
    this.lastUpdateTime = new File(this.videoPath).lastModified();
  }
  
  private boolean needReload()
  {
    return this.lastUpdateTime != new File(this.videoPath).lastModified();
  }
  
  void checkAndLoad(AssetExtractor paramAssetExtractor)
  {
    if ((exit()) && (needReload())) {
      loadWith(paramAssetExtractor);
    }
  }
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public int getPreferRotation()
  {
    return this.preferRotation;
  }
  
  public String getVideoPath()
  {
    return this.videoPath;
  }
  
  public CGSize getVideoSize()
  {
    return this.videoSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.extractor.wrapper.ExtractorWrapper
 * JD-Core Version:    0.7.0.1
 */