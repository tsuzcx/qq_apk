package com.tencent.tav.asset;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class Asset<Track extends AssetTrack>
  implements AsynchronousKeyValueLoading
{
  public static final String TAG = "Asset";
  private boolean canContainFragments;
  private boolean composable;
  private boolean containsFragments;
  private CMTime duration = CMTime.CMTimeZero;
  private boolean exportable;
  protected HashMap<String, Object> extraInfo = new HashMap();
  protected AssetExtractor extractor;
  private int extractorRetryCount = 3;
  private boolean hasProtectedContent;
  private String lyrics;
  private MediaFormat mediaFormat;
  private int mirror = 0;
  protected CGSize naturalSize;
  private CMTime overallDurationHint;
  private boolean playable;
  protected int preferRotation = 0;
  private float preferredRate = 1.0F;
  private Matrix preferredTransform;
  protected float preferredVolume = 1.0F;
  private boolean providesPreciseDurationAndTiming;
  private boolean readable;
  protected int trackCount = 0;
  protected int trackIndex = 0;
  protected List<Track> tracks;
  
  protected Asset() {}
  
  protected Asset(@NonNull String paramString)
  {
    this.extractor = new AssetExtractor();
    this.extractor.setDataSource(paramString);
    tryInitMembers();
    createTracks();
  }
  
  protected Asset(@NonNull URL paramURL) {}
  
  private void initMembers()
  {
    this.trackCount = this.extractor.getTrackCount();
    this.duration = getDuration();
    this.naturalSize = ExtractorUtils.getVideoSize(this.extractor);
    this.preferRotation = ExtractorUtils.getPreferRotation(this.extractor);
    if (this.preferRotation != 0)
    {
      this.preferredTransform = new Matrix();
      int i;
      for (;;)
      {
        i = this.preferRotation;
        if (i >= 0) {
          break;
        }
        this.preferRotation = (i + 4);
      }
      this.preferRotation = (i % 4);
      DecoderUtils.getRotationMatrix(this.preferredTransform, this.preferRotation, this.naturalSize.width, this.naturalSize.height);
    }
  }
  
  private void tryInitMembers()
  {
    int i = this.extractorRetryCount;
    this.extractorRetryCount = (i - 1);
    if (i <= 0) {
      return;
    }
    try
    {
      initMembers();
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Asset: initMembers failed, path = ");
      localStringBuilder2.append(getSourcePath());
      Logger.e("Asset", localStringBuilder2.toString(), localException);
      trySleep(100);
      tryInitMembers();
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("tryInitMembers: try count = ");
    localStringBuilder1.append(3 - this.extractorRetryCount);
    Logger.v("Asset", localStringBuilder1.toString());
  }
  
  private void trySleep(int paramInt)
  {
    long l = paramInt;
    try
    {
      Thread.sleep(l);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("Asset", "tryInitMembers: Thread.sleep(100) ", localException);
    }
  }
  
  public void cancelLoading() {}
  
  @TargetApi(16)
  protected void createTracks()
  {
    int j = this.extractor.getTrackCount();
    if (this.tracks == null) {
      this.tracks = new ArrayList();
    }
    int i = 0;
    while (i < j)
    {
      localObject = this.extractor.getTrackFormat(i).getString("mime");
      int k;
      if (((String)localObject).startsWith("video/"))
      {
        k = this.trackIndex;
        this.trackIndex = (k + 1);
        localObject = new AssetTrack(this, k, 1, new CMTimeRange(CMTime.CMTimeZero, getVideoDuration()));
        ((AssetTrack)localObject).setPreferredTransform(this.preferredTransform);
        ((AssetTrack)localObject).setPreferredRotation(this.preferRotation);
        this.tracks.add(localObject);
      }
      else if (((String)localObject).startsWith("audio/"))
      {
        k = this.trackIndex;
        this.trackIndex = (k + 1);
        localObject = new AssetTrack(this, k, 2, new CMTimeRange(CMTime.CMTimeZero, getAudioDuration()));
        ((AssetTrack)localObject).setPreferredVolume(this.preferredVolume);
        this.tracks.add(localObject);
      }
      i += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Asset createTracks finish, has track count: ");
    ((StringBuilder)localObject).append(this.tracks);
    Logger.d("Asset", ((StringBuilder)localObject).toString());
  }
  
  protected CMTime getAudioDuration()
  {
    return TimeUtil.us2CMTime(this.extractor.getAudioDuration());
  }
  
  public CMTime getDuration()
  {
    try
    {
      if ((this.duration == null) || (this.duration.equalsTo(CMTime.CMTimeZero)))
      {
        CMTime localCMTime2 = getVideoDuration();
        localCMTime1 = localCMTime2;
        if (CMTime.CMTimeZero.equalsTo(localCMTime2)) {
          localCMTime1 = getAudioDuration();
        }
        this.duration = localCMTime1;
      }
      CMTime localCMTime1 = this.duration;
      return localCMTime1;
    }
    finally {}
  }
  
  public HashMap<String, Object> getExtraInfo()
  {
    return this.extraInfo;
  }
  
  public AssetExtractor getExtractor()
  {
    try
    {
      AssetExtractor localAssetExtractor = this.extractor;
      return localAssetExtractor;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getLyrics()
  {
    return this.lyrics;
  }
  
  public MediaFormat getMediaFormat()
  {
    return this.mediaFormat;
  }
  
  public CGSize getNaturalSize()
  {
    return this.naturalSize;
  }
  
  public CMTime getOverallDurationHint()
  {
    return this.overallDurationHint;
  }
  
  public int getPreferRotation()
  {
    return this.preferRotation;
  }
  
  public float getPreferredRate()
  {
    return this.preferredRate;
  }
  
  public Matrix getPreferredTransform()
  {
    return this.preferredTransform;
  }
  
  public float getPreferredVolume()
  {
    return this.preferredVolume;
  }
  
  public String getSourcePath()
  {
    try
    {
      if (this.extractor != null)
      {
        String str = this.extractor.getSourcePath();
        return str;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getTrackCount()
  {
    return this.trackCount;
  }
  
  public MediaFormat getTrackFormat(int paramInt)
  {
    try
    {
      if (this.extractor != null)
      {
        MediaFormat localMediaFormat = this.extractor.getTrackFormat(paramInt);
        return localMediaFormat;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<Track> getTracks()
  {
    return this.tracks;
  }
  
  protected CMTime getVideoDuration()
  {
    return TimeUtil.us2CMTime(this.extractor.getDuration());
  }
  
  public boolean isCanContainFragments()
  {
    return this.canContainFragments;
  }
  
  public boolean isComposable()
  {
    return this.composable;
  }
  
  public boolean isContainsFragments()
  {
    return this.containsFragments;
  }
  
  public boolean isExportable()
  {
    return this.exportable;
  }
  
  public boolean isHasProtectedContent()
  {
    return this.hasProtectedContent;
  }
  
  public boolean isPlayable()
  {
    return this.playable;
  }
  
  public boolean isProvidesPreciseDurationAndTiming()
  {
    return this.providesPreciseDurationAndTiming;
  }
  
  public boolean isReadable()
  {
    return this.readable;
  }
  
  public void putExtraInfoKeyValue(String paramString, Object paramObject)
  {
    this.extraInfo.put(paramString, paramObject);
  }
  
  public void selectTrack(int paramInt)
  {
    try
    {
      if (this.extractor != null) {
        this.extractor.selectTrack(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public AssetTrack trackWithTrackID(int paramInt)
  {
    Object localObject = this.tracks;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AssetTrack localAssetTrack = (AssetTrack)((Iterator)localObject).next();
        if ((localAssetTrack != null) && (localAssetTrack.getTrackID() == paramInt)) {
          return localAssetTrack;
        }
      }
    }
    return null;
  }
  
  public List<AssetTrack> tracksWithMediaCharacteristic(String paramString)
  {
    return null;
  }
  
  public List<AssetTrack> tracksWithMediaType(int paramInt)
  {
    if (this.tracks != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.tracks.iterator();
      while (localIterator.hasNext())
      {
        AssetTrack localAssetTrack = (AssetTrack)localIterator.next();
        if ((localAssetTrack != null) && (localAssetTrack.getMediaType() == paramInt)) {
          localArrayList.add(localAssetTrack);
        }
      }
      return localArrayList;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.asset.Asset
 * JD-Core Version:    0.7.0.1
 */