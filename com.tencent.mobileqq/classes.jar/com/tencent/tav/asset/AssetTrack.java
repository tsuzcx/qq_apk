package com.tencent.tav.asset;

import android.graphics.Matrix;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AssetTrack<Segment extends AssetTrackSegment>
{
  public static final int PersistentTrackID_Invalid = -1;
  protected WeakReference<Asset> asset;
  protected List<String> availableMetadataFormats;
  protected List<String> availableTrackAssociationTypes;
  protected List<MetadataItem> commonMetadata;
  protected boolean enabled = true;
  protected float estimatedDataRate;
  protected int mediaType;
  protected CGSize naturalSize;
  protected int naturalTimeScale;
  protected float nominalFrameRate = 30.0F;
  protected int preferredRotation = 0;
  protected Matrix preferredTransform;
  protected float preferredVolume = 1.0F;
  protected List<Segment> segments = new ArrayList();
  protected String sourcePath;
  protected CMTimeRange timeRange;
  protected long totalSampleDataLength;
  protected int trackID;
  
  AssetTrack() {}
  
  AssetTrack(Asset paramAsset, int paramInt1, int paramInt2, CMTimeRange paramCMTimeRange)
  {
    this.trackID = paramInt1;
    this.mediaType = paramInt2;
    this.timeRange = paramCMTimeRange;
    if ((paramAsset != null) && (paramInt1 < paramAsset.getTrackCount()))
    {
      this.asset = new WeakReference(paramAsset);
      this.nominalFrameRate = ExtractorUtils.getFrameRate(paramAsset.getTrackFormat(paramInt1));
      this.naturalSize = paramAsset.getNaturalSize();
      this.sourcePath = paramAsset.getSourcePath();
    }
    createAssetTrackSegments(paramAsset);
  }
  
  public List<AssetTrack> associatedTracksOfType(String paramString)
  {
    return null;
  }
  
  protected void createAssetTrackSegments(Asset paramAsset)
  {
    if (this.segments == null) {
      this.segments = new ArrayList();
    }
    if ((paramAsset != null) && (paramAsset.getTrackCount() > this.trackID))
    {
      paramAsset = new AssetTrackSegment(this.timeRange, this.timeRange);
      this.segments.add(paramAsset);
    }
  }
  
  public Asset getAsset()
  {
    if (this.asset != null) {
      return (Asset)this.asset.get();
    }
    return null;
  }
  
  public List<String> getAvailableMetadataFormats()
  {
    return this.availableMetadataFormats;
  }
  
  public List<String> getAvailableTrackAssociationTypes()
  {
    return this.availableTrackAssociationTypes;
  }
  
  public List<MetadataItem> getCommonMetadata()
  {
    return this.commonMetadata;
  }
  
  public CMTime getDuration()
  {
    if (this.timeRange != null) {
      return this.timeRange.getDuration();
    }
    return CMTime.CMTimeZero;
  }
  
  public float getEstimatedDataRate()
  {
    return this.estimatedDataRate;
  }
  
  public int getMediaType()
  {
    return this.mediaType;
  }
  
  public CGSize getNaturalSize()
  {
    return this.naturalSize;
  }
  
  public int getNaturalTimeScale()
  {
    return this.naturalTimeScale;
  }
  
  public float getNominalFrameRate()
  {
    return this.nominalFrameRate;
  }
  
  public int getPreferredRotation()
  {
    return this.preferredRotation;
  }
  
  public Matrix getPreferredTransform()
  {
    return this.preferredTransform;
  }
  
  public float getPreferredVolume()
  {
    return this.preferredVolume;
  }
  
  public List<Segment> getSegments()
  {
    return this.segments;
  }
  
  public String getSourcePath()
  {
    return this.sourcePath;
  }
  
  public CMTimeRange getTimeRange()
  {
    if ((this.timeRange == null) || (this.timeRange == CMTimeRange.CMTimeRangeInvalid)) {
      this.timeRange = new CMTimeRange(CMTime.CMTimeZero, getDuration());
    }
    return this.timeRange;
  }
  
  public long getTotalSampleDataLength()
  {
    return this.totalSampleDataLength;
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
  
  public boolean hasMediaCharacteristic(String paramString)
  {
    return false;
  }
  
  public boolean isEnabled()
  {
    return this.enabled;
  }
  
  public List<MetadataItem> metadataForFormat(String paramString)
  {
    return null;
  }
  
  public CMTime samplePresentationTimeForTrackTime(CMTime paramCMTime)
  {
    if ((this.asset != null) && (this.asset.get() != null))
    {
      AssetExtractor localAssetExtractor = ((Asset)this.asset.get()).getExtractor();
      if (localAssetExtractor != null)
      {
        localAssetExtractor.seekTo(paramCMTime.getTimeUs(), 2);
        if (localAssetExtractor.getSampleTime() > paramCMTime.getTimeUs()) {
          localAssetExtractor.seekTo(paramCMTime.getTimeUs(), 0);
        }
        return TimeUtil.us2CMTime(localAssetExtractor.getSampleTime());
      }
    }
    return null;
  }
  
  public AssetTrackSegment segmentForTrackTime(CMTime paramCMTime)
  {
    if (this.segments != null)
    {
      Iterator localIterator = this.segments.iterator();
      while (localIterator.hasNext())
      {
        AssetTrackSegment localAssetTrackSegment = (AssetTrackSegment)localIterator.next();
        if (localAssetTrackSegment != null)
        {
          CMTimeRange localCMTimeRange = localAssetTrackSegment.getTimeMapping().getTarget();
          if ((localCMTimeRange != null) && (localCMTimeRange.containsTime(paramCMTime))) {
            return localAssetTrackSegment;
          }
        }
      }
    }
    return null;
  }
  
  void setPreferredRotation(int paramInt)
  {
    this.preferredRotation = paramInt;
  }
  
  void setPreferredTransform(Matrix paramMatrix)
  {
    this.preferredTransform = paramMatrix;
  }
  
  void setPreferredVolume(float paramFloat)
  {
    this.preferredVolume = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.asset.AssetTrack
 * JD-Core Version:    0.7.0.1
 */