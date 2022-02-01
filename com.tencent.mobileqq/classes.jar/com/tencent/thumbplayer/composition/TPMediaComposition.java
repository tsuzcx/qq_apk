package com.tencent.thumbplayer.composition;

import com.tencent.thumbplayer.api.composition.ITPMediaComposition;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TPMediaComposition
  implements ITPMediaComposition
{
  private static final String TAG = "TPMediaComposition";
  private int mAVTrackSequence = 0;
  private List<ITPMediaTrack> mAVTracks = new ArrayList(1);
  private int mAudioTrackSequence = 0;
  private List<ITPMediaTrack> mAudioTracks = new ArrayList(1);
  private int mVideoTrackSequence = 0;
  private List<ITPMediaTrack> mVideoTracks = new ArrayList(1);
  
  private int generateAVTrackSequence()
  {
    try
    {
      int i = this.mAVTrackSequence + 1;
      this.mAVTrackSequence = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int generateAudioTrackSequence()
  {
    try
    {
      int i = this.mAudioTrackSequence + 1;
      this.mAudioTrackSequence = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int generateVideoTrackSequence()
  {
    try
    {
      int i = this.mVideoTrackSequence + 1;
      this.mVideoTrackSequence = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ITPMediaTrack addAVTrack()
  {
    try
    {
      TPMediaCompositionTrack localTPMediaCompositionTrack = new TPMediaCompositionTrack(generateAVTrackSequence(), 1);
      this.mAVTracks.add(localTPMediaCompositionTrack);
      return localTPMediaCompositionTrack;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ITPMediaTrack addAudioTrack()
  {
    try
    {
      TPMediaCompositionTrack localTPMediaCompositionTrack = new TPMediaCompositionTrack(generateAudioTrackSequence(), 3);
      this.mAudioTracks.add(localTPMediaCompositionTrack);
      return localTPMediaCompositionTrack;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ITPMediaTrack addVideoTrack()
  {
    try
    {
      TPMediaCompositionTrack localTPMediaCompositionTrack = new TPMediaCompositionTrack(generateVideoTrackSequence(), 2);
      this.mVideoTracks.add(localTPMediaCompositionTrack);
      return localTPMediaCompositionTrack;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  long getAVDuration()
  {
    Object localObject = this.mAVTracks;
    long l1 = 0L;
    long l2 = l1;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        l2 = l1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        ITPMediaTrack localITPMediaTrack = (ITPMediaTrack)((Iterator)localObject).next();
        if (l1 < localITPMediaTrack.getTimelineDurationMs()) {
          l1 = localITPMediaTrack.getTimelineDurationMs();
        }
      }
    }
    return l2;
  }
  
  public List<ITPMediaTrack> getAllAVTracks()
  {
    return this.mAVTracks;
  }
  
  public List<ITPMediaTrack> getAllAudioTracks()
  {
    try
    {
      List localList = this.mAudioTracks;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<ITPMediaTrack> getAllVideoTracks()
  {
    try
    {
      List localList = this.mVideoTracks;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  long getAudioDuration()
  {
    Object localObject = this.mAudioTracks;
    long l1 = 0L;
    long l2 = l1;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        l2 = l1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        ITPMediaTrack localITPMediaTrack = (ITPMediaTrack)((Iterator)localObject).next();
        if (l1 < localITPMediaTrack.getTimelineDurationMs()) {
          l1 = localITPMediaTrack.getTimelineDurationMs();
        }
      }
    }
    return l2;
  }
  
  public ITPMediaTrack getAudioTrack(int paramInt)
  {
    try
    {
      ITPMediaTrack localITPMediaTrack = (ITPMediaTrack)this.mAudioTracks.get(paramInt);
      return localITPMediaTrack;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getDurationMs()
  {
    if (!TPCommonUtils.isEmpty(this.mAVTracks)) {
      return getAVDuration();
    }
    long l1 = getAudioDuration();
    long l2 = getVideoDuration();
    long l3;
    if (l2 > l1) {
      l3 = l2;
    } else {
      l3 = l1;
    }
    String str = TPMediaCompositionHelper.composition_duration_strategy;
    int i = -1;
    int j = str.hashCode();
    if (j != -2046821033)
    {
      if (j != -491658008)
      {
        if ((j == -472621683) && (str.equals("base_video"))) {
          i = 0;
        }
      }
      else if (str.equals("base_audio")) {
        i = 1;
      }
    }
    else if (str.equals("base_longer")) {
      i = 2;
    }
    long l4;
    if (i != 0)
    {
      l4 = l1;
      if (i != 1)
      {
        if (i != 2) {
          return l3;
        }
        l4 = l1;
        if (l2 <= l1) {}
      }
    }
    else
    {
      l4 = l2;
    }
    return l4;
  }
  
  public int getMediaType()
  {
    return 4;
  }
  
  public String getUrl()
  {
    try
    {
      String str = TPMediaCompositionXmlGenerator.buildAssetXmlFromComposition(this);
      return str;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPMediaComposition", localException);
    }
    return null;
  }
  
  long getVideoDuration()
  {
    Object localObject = this.mVideoTracks;
    long l1 = 0L;
    long l2 = l1;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        l2 = l1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        ITPMediaTrack localITPMediaTrack = (ITPMediaTrack)((Iterator)localObject).next();
        if (l1 < localITPMediaTrack.getTimelineDurationMs()) {
          l1 = localITPMediaTrack.getTimelineDurationMs();
        }
      }
    }
    return l2;
  }
  
  public ITPMediaTrack getVideoTrack(int paramInt)
  {
    try
    {
      ITPMediaTrack localITPMediaTrack = (ITPMediaTrack)this.mVideoTracks.get(paramInt);
      return localITPMediaTrack;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void release()
  {
    List localList = this.mVideoTracks;
    if (localList != null)
    {
      localList.clear();
      this.mVideoTracks = null;
    }
    localList = this.mAudioTracks;
    if (localList != null)
    {
      localList.clear();
      this.mAudioTracks = null;
    }
    localList = this.mAVTracks;
    if (localList != null)
    {
      localList.clear();
      this.mAVTracks = null;
    }
  }
  
  public boolean removeAVTrack(ITPMediaTrack paramITPMediaTrack)
  {
    if (paramITPMediaTrack != null) {
      return this.mAVTracks.remove(paramITPMediaTrack);
    }
    throw new IllegalArgumentException("remove audio track , track is null .");
  }
  
  public boolean removeAudioTrack(ITPMediaTrack paramITPMediaTrack)
  {
    if (paramITPMediaTrack != null) {
      try
      {
        boolean bool = this.mAudioTracks.remove(paramITPMediaTrack);
        return bool;
      }
      finally
      {
        break label35;
      }
    }
    throw new IllegalArgumentException("remove audio track , track is null .");
    label35:
    throw paramITPMediaTrack;
  }
  
  public boolean removeVideoTrack(ITPMediaTrack paramITPMediaTrack)
  {
    if (paramITPMediaTrack != null) {
      try
      {
        boolean bool = this.mVideoTracks.remove(paramITPMediaTrack);
        return bool;
      }
      finally
      {
        break label35;
      }
    }
    throw new IllegalArgumentException("remove video track , track is null .");
    label35:
    throw paramITPMediaTrack;
  }
  
  public void setAVTracks(List<ITPMediaTrack> paramList)
  {
    this.mAVTracks = paramList;
  }
  
  public void setAudioTracks(List<ITPMediaTrack> paramList)
  {
    this.mAudioTracks = paramList;
  }
  
  public void setVideoTracks(List<ITPMediaTrack> paramList)
  {
    this.mVideoTracks = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.composition.TPMediaComposition
 * JD-Core Version:    0.7.0.1
 */