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
    long l2;
    if (this.mAVTracks != null)
    {
      Iterator localIterator = this.mAVTracks.iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label69;
      }
      ITPMediaTrack localITPMediaTrack = (ITPMediaTrack)localIterator.next();
      if (l1 >= localITPMediaTrack.getTimelineDurationMs()) {
        break label71;
      }
      l1 = localITPMediaTrack.getTimelineDurationMs();
    }
    label69:
    label71:
    for (;;)
    {
      break;
      l2 = 0L;
      return l2;
    }
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
    long l2;
    if (this.mAudioTracks != null)
    {
      Iterator localIterator = this.mAudioTracks.iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label69;
      }
      ITPMediaTrack localITPMediaTrack = (ITPMediaTrack)localIterator.next();
      if (l1 >= localITPMediaTrack.getTimelineDurationMs()) {
        break label71;
      }
      l1 = localITPMediaTrack.getTimelineDurationMs();
    }
    label69:
    label71:
    for (;;)
    {
      break;
      l2 = 0L;
      return l2;
    }
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
    long l2;
    if (!TPCommonUtils.isEmpty(this.mAVTracks)) {
      l2 = getAVDuration();
    }
    long l4;
    long l1;
    label40:
    do
    {
      return l2;
      l4 = getAudioDuration();
      l1 = getVideoDuration();
      long l3;
      String str;
      int i;
      if (l1 > l4)
      {
        l3 = l1;
        str = TPMediaCompositionHelper.composition_duration_strategy;
        i = -1;
        switch (str.hashCode())
        {
        }
      }
      for (;;)
      {
        l2 = l1;
        switch (i)
        {
        case 0: 
        default: 
          return l3;
          l3 = l4;
          break label40;
          if (str.equals("base_video"))
          {
            i = 0;
            continue;
            if (str.equals("base_audio"))
            {
              i = 1;
              continue;
              if (str.equals("base_longer")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      return l4;
      l2 = l1;
    } while (l1 > l4);
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
    long l2;
    if (this.mVideoTracks != null)
    {
      Iterator localIterator = this.mVideoTracks.iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label69;
      }
      ITPMediaTrack localITPMediaTrack = (ITPMediaTrack)localIterator.next();
      if (l1 >= localITPMediaTrack.getTimelineDurationMs()) {
        break label71;
      }
      l1 = localITPMediaTrack.getTimelineDurationMs();
    }
    label69:
    label71:
    for (;;)
    {
      break;
      l2 = 0L;
      return l2;
    }
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
    if (this.mVideoTracks != null)
    {
      this.mVideoTracks.clear();
      this.mVideoTracks = null;
    }
    if (this.mAudioTracks != null)
    {
      this.mAudioTracks.clear();
      this.mAudioTracks = null;
    }
    if (this.mAVTracks != null)
    {
      this.mAVTracks.clear();
      this.mAVTracks = null;
    }
  }
  
  public boolean removeAVTrack(ITPMediaTrack paramITPMediaTrack)
  {
    if (paramITPMediaTrack == null) {
      throw new IllegalArgumentException("remove audio track , track is null .");
    }
    return this.mAVTracks.remove(paramITPMediaTrack);
  }
  
  public boolean removeAudioTrack(ITPMediaTrack paramITPMediaTrack)
  {
    if (paramITPMediaTrack == null) {
      try
      {
        throw new IllegalArgumentException("remove audio track , track is null .");
      }
      finally {}
    }
    boolean bool = this.mAudioTracks.remove(paramITPMediaTrack);
    return bool;
  }
  
  public boolean removeVideoTrack(ITPMediaTrack paramITPMediaTrack)
  {
    if (paramITPMediaTrack == null) {
      try
      {
        throw new IllegalArgumentException("remove video track , track is null .");
      }
      finally {}
    }
    boolean bool = this.mVideoTracks.remove(paramITPMediaTrack);
    return bool;
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