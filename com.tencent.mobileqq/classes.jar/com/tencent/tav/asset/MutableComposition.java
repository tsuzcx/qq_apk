package com.tencent.tav.asset;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MutableComposition
  extends Composition<MutableCompositionTrack>
{
  public MutableComposition()
  {
    setNaturalSize(new CGSize(0.0F, 0.0F));
  }
  
  private int getCorrectTrackID(int paramInt)
  {
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext()) {
      if (((MutableCompositionTrack)localIterator.next()).getTrackID() == paramInt)
      {
        i = 1;
        break label42;
      }
    }
    int i = 0;
    label42:
    if ((i == 0) && (paramInt > 0)) {
      return paramInt;
    }
    if (paramInt == -1)
    {
      paramInt = this.trackIndex;
      this.trackIndex = (paramInt + 1);
      return paramInt;
    }
    if (this.trackIndex >= paramInt)
    {
      paramInt = this.trackIndex;
      this.trackIndex = (paramInt + 1);
      return paramInt;
    }
    this.trackIndex = paramInt;
    return this.trackIndex;
  }
  
  public MutableCompositionTrack addMutableTrackWithMediaType(int paramInt1, int paramInt2)
  {
    MutableCompositionTrack localMutableCompositionTrack = new MutableCompositionTrack(paramInt1, getCorrectTrackID(paramInt2));
    localMutableCompositionTrack.setNaturalSize(getNaturalSize());
    this.tracks.add(localMutableCompositionTrack);
    this.trackCount += 1;
    return localMutableCompositionTrack;
  }
  
  public CGSize getNaturalSize()
  {
    if (this.naturalSize.equals(CGSize.CGSizeZero))
    {
      Iterator localIterator = this.tracks.iterator();
      while (localIterator.hasNext())
      {
        CompositionTrack localCompositionTrack = (CompositionTrack)localIterator.next();
        if (localCompositionTrack.enabled) {
          return localCompositionTrack.getNaturalSize();
        }
      }
    }
    return this.naturalSize;
  }
  
  public int getPreferRotation()
  {
    if (this.preferRotation == 0)
    {
      Iterator localIterator = this.tracks.iterator();
      while (localIterator.hasNext())
      {
        CompositionTrack localCompositionTrack = (CompositionTrack)localIterator.next();
        if (localCompositionTrack.enabled) {
          return localCompositionTrack.getPreferredRotation();
        }
      }
    }
    return this.preferRotation;
  }
  
  @NonNull
  public List<MutableCompositionTrack> getTracks()
  {
    return this.tracks;
  }
  
  public void insertEmptyTimeRange(CMTimeRange paramCMTimeRange)
  {
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext()) {
      ((MutableCompositionTrack)localIterator.next()).insertEmptyTimeRange(paramCMTimeRange);
    }
  }
  
  public boolean insertTimeRange(CMTimeRange paramCMTimeRange, Asset paramAsset, CMTime paramCMTime)
  {
    if ((paramCMTimeRange.getDuration().value > 0L) && (paramAsset != null))
    {
      if (paramAsset.getTrackCount() == 0) {
        return false;
      }
      Object localObject = paramAsset.getTracks();
      paramAsset = new ArrayList();
      int i = 0;
      for (;;)
      {
        int j = ((List)localObject).size();
        int k = 1;
        if (i >= j) {
          break;
        }
        AssetTrack localAssetTrack = (AssetTrack)((List)localObject).get(i);
        j = i;
        MutableCompositionTrack localMutableCompositionTrack;
        while (j < this.tracks.size())
        {
          localMutableCompositionTrack = (MutableCompositionTrack)this.tracks.get(j);
          if (localMutableCompositionTrack.getMediaType() == localAssetTrack.getMediaType())
          {
            if (!localMutableCompositionTrack.insertTimeRange(paramCMTimeRange, localAssetTrack, paramCMTime)) {
              return false;
            }
            paramAsset.add(Integer.valueOf(localMutableCompositionTrack.getTrackID()));
            j = k;
            break label170;
          }
          j += 1;
        }
        j = 0;
        label170:
        if (j == 0)
        {
          j = localAssetTrack.getMediaType();
          k = this.trackIndex;
          this.trackIndex = (k + 1);
          localMutableCompositionTrack = addMutableTrackWithMediaType(j, k);
          if (!localMutableCompositionTrack.insertTimeRange(paramCMTimeRange, localAssetTrack, paramCMTime)) {
            return false;
          }
          paramAsset.add(Integer.valueOf(localMutableCompositionTrack.getTrackID()));
        }
        i += 1;
      }
      paramCMTime = this.tracks.iterator();
      while (paramCMTime.hasNext())
      {
        localObject = (MutableCompositionTrack)paramCMTime.next();
        if (!paramAsset.contains(Integer.valueOf(((MutableCompositionTrack)localObject).getTrackID()))) {
          ((MutableCompositionTrack)localObject).insertEmptyTimeRange(paramCMTimeRange);
        }
      }
      return true;
    }
    return false;
  }
  
  @Nullable
  public MutableCompositionTrack mutableTrackCompatibleWithTrack(AssetTrack paramAssetTrack)
  {
    if ((paramAssetTrack != null) && (paramAssetTrack.getAsset() != null))
    {
      MutableCompositionTrack localMutableCompositionTrack = new MutableCompositionTrack(paramAssetTrack.getMediaType(), getCorrectTrackID(-1));
      localMutableCompositionTrack.insertTimeRange(paramAssetTrack.getTimeRange(), paramAssetTrack, CMTime.CMTimeZero);
      localMutableCompositionTrack.setPreferredTransform(paramAssetTrack.getPreferredTransform());
      localMutableCompositionTrack.setPreferredRotation(paramAssetTrack.getPreferredRotation());
      localMutableCompositionTrack.setPreferredVolume(paramAssetTrack.getPreferredVolume());
      return localMutableCompositionTrack;
    }
    return null;
  }
  
  public void removeTimeRange(CMTimeRange paramCMTimeRange)
  {
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext()) {
      ((MutableCompositionTrack)localIterator.next()).removeTimeRange(paramCMTimeRange);
    }
  }
  
  public void removeTrack(CompositionTrack paramCompositionTrack)
  {
    int j;
    for (int i = 0; i < this.tracks.size(); i = j + 1)
    {
      j = i;
      if ((MutableCompositionTrack)this.tracks.get(i) == paramCompositionTrack)
      {
        this.tracks.remove(i);
        j = i - 1;
      }
    }
  }
  
  public void scaleTimeRange(CMTimeRange paramCMTimeRange, CMTime paramCMTime)
  {
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext()) {
      ((MutableCompositionTrack)localIterator.next()).scaleTimeRange(paramCMTimeRange, paramCMTime);
    }
  }
  
  public void setNaturalSize(CGSize paramCGSize)
  {
    this.naturalSize = paramCGSize;
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      MutableCompositionTrack localMutableCompositionTrack = (MutableCompositionTrack)localIterator.next();
      if ((localMutableCompositionTrack != null) && (localMutableCompositionTrack.getMediaType() == 1) && (localMutableCompositionTrack.getNaturalSize() == null)) {
        localMutableCompositionTrack.setNaturalSize(paramCGSize);
      }
    }
  }
  
  public void setPreferRotation(int paramInt)
  {
    this.preferRotation = paramInt;
  }
  
  public void setPreferredVolume(float paramFloat)
  {
    this.preferredVolume = paramFloat;
  }
  
  @Nullable
  public MutableCompositionTrack trackWithTrackID(int paramInt)
  {
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      MutableCompositionTrack localMutableCompositionTrack = (MutableCompositionTrack)localIterator.next();
      if ((localMutableCompositionTrack != null) && (localMutableCompositionTrack.getTrackID() == paramInt)) {
        return localMutableCompositionTrack;
      }
    }
    return null;
  }
  
  public List<MutableCompositionTrack> tracksWithMediaType(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      MutableCompositionTrack localMutableCompositionTrack = (MutableCompositionTrack)localIterator.next();
      if ((localMutableCompositionTrack != null) && (localMutableCompositionTrack.getMediaType() == paramInt)) {
        localArrayList.add(localMutableCompositionTrack);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.asset.MutableComposition
 * JD-Core Version:    0.7.0.1
 */