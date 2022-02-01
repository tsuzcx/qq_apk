package com.tencent.tavkit.composition.resource;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

public class TAVAssetTrackResource
  extends TAVResource
{
  private Asset asset;
  
  public TAVAssetTrackResource(Asset paramAsset)
  {
    this.asset = paramAsset;
    this.duration = paramAsset.getDuration();
    this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramAsset.getDuration());
  }
  
  public TAVAssetTrackResource(String paramString)
  {
    this(new URLAsset(paramString));
  }
  
  public TAVResource clone()
  {
    TAVAssetTrackResource localTAVAssetTrackResource = new TAVAssetTrackResource(this.asset);
    localTAVAssetTrackResource.sourceTimeRange = this.sourceTimeRange.clone();
    localTAVAssetTrackResource.scaledDuration = this.scaledDuration.clone();
    localTAVAssetTrackResource.duration = this.duration.clone();
    return localTAVAssetTrackResource;
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    AssetTrack localAssetTrack = (AssetTrack)tracksForType(paramInt1).get(paramInt2);
    TrackInfo localTrackInfo = new TrackInfo();
    localTrackInfo.setTrack(localAssetTrack);
    localTrackInfo.setSelectedTimeRange(getSourceTimeRange());
    localTrackInfo.setScaleToDuration(getScaledDuration());
    return localTrackInfo;
  }
  
  public List<AssetTrack> tracksForType(int paramInt)
  {
    if (this.asset != null) {
      return this.asset.tracksWithMediaType(paramInt);
    }
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVAssetTrackResource
 * JD-Core Version:    0.7.0.1
 */