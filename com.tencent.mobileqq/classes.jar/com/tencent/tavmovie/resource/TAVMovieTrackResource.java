package com.tencent.tavmovie.resource;

import android.text.TextUtils;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;

public class TAVMovieTrackResource
  extends TAVMovieResource
{
  private transient Asset asset;
  private String filePath;
  
  public TAVMovieTrackResource(Asset paramAsset)
  {
    this.asset = paramAsset;
    reloadAVAsset();
  }
  
  public TAVMovieTrackResource(String paramString)
  {
    this.filePath = paramString;
    loadAVAssetImpl();
  }
  
  private void loadAVAssetImpl()
  {
    if (!TextUtils.isEmpty(this.filePath))
    {
      this.asset = new URLAsset(this.filePath);
      this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.asset.getDuration());
      this.naturalSize = this.asset.getNaturalSize();
      this.status = TAVMovieResource.TAVMovieResourceStatus.TAVMovieResourceStatusAvailable;
      return;
    }
    this.status = TAVMovieResource.TAVMovieResourceStatus.TAVMovieResourceStatusError;
  }
  
  private void reloadAVAsset()
  {
    if (this.asset != null)
    {
      this.filePath = this.asset.getSourcePath();
      this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.asset.getDuration());
      this.naturalSize = this.asset.getNaturalSize();
      this.status = TAVMovieResource.TAVMovieResourceStatus.TAVMovieResourceStatusAvailable;
    }
  }
  
  public TAVMovieTrackResource clone()
  {
    TAVMovieTrackResource localTAVMovieTrackResource = new TAVMovieTrackResource(this.filePath);
    localTAVMovieTrackResource.cloneFrom(this);
    return localTAVMovieTrackResource;
  }
  
  public TAVResource convertToResource()
  {
    Object localObject;
    if (this.asset == null) {
      localObject = null;
    }
    TAVAssetTrackResource localTAVAssetTrackResource;
    do
    {
      do
      {
        do
        {
          return localObject;
          localTAVAssetTrackResource = new TAVAssetTrackResource(this.asset);
          localObject = localTAVAssetTrackResource;
        } while (this.timeRange == null);
        localObject = localTAVAssetTrackResource;
      } while (this.timeRange.getDurationUs() <= 0L);
      localTAVAssetTrackResource.setSourceTimeRange(this.timeRange);
      localObject = localTAVAssetTrackResource;
    } while (this.timeEffect == null);
    float f = this.timeEffect.getSpeed();
    if (f == 0.0F)
    {
      localTAVAssetTrackResource.setSourceTimeRange(this.timeEffect.getSourceTimeRange());
      localTAVAssetTrackResource.setScaledDuration(this.timeEffect.getTimeRange().getDuration());
      return localTAVAssetTrackResource;
    }
    localTAVAssetTrackResource.setSourceTimeRange(getTimeRange());
    localTAVAssetTrackResource.setScaledDuration(getTimeRange().getDuration().divide(f));
    return localTAVAssetTrackResource;
  }
  
  public TAVMovieTrackResource dataClone()
  {
    TAVMovieTrackResource localTAVMovieTrackResource = new TAVMovieTrackResource(this.asset);
    localTAVMovieTrackResource.cloneFrom(this);
    return localTAVMovieTrackResource;
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public void loadAVAsset()
  {
    if ((this.asset == null) && (this.status != TAVMovieResource.TAVMovieResourceStatus.TAVMovieResourceStatusError)) {
      loadAVAssetImpl();
    }
  }
  
  public void setAsset(Asset paramAsset)
  {
    this.asset = paramAsset;
    reloadAVAsset();
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.resource.TAVMovieTrackResource
 * JD-Core Version:    0.7.0.1
 */