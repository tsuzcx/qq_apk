package com.tencent.oskplayer.model;

import android.text.TextUtils;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class SegmentVideoInfo$StreamInfo
{
  private VideoDecoderType.DecoderType decoderTypeSuggest;
  public boolean isHLSLive;
  public boolean isVideoTimeCanBeTrust;
  public boolean isVip;
  public String mSafeUrlKey;
  private String mUrl;
  public ArrayList<SegmentVideoInfo.SegmentInfo> segmentInfos;
  public int streamType;
  
  public SegmentVideoInfo$StreamInfo()
  {
    this.segmentInfos = new ArrayList();
    this.decoderTypeSuggest = VideoDecoderType.DecoderType.H264;
  }
  
  public SegmentVideoInfo$StreamInfo(String paramString, int paramInt)
  {
    this(paramString, paramInt, VideoDecoderType.DecoderType.H264);
  }
  
  public SegmentVideoInfo$StreamInfo(String paramString, int paramInt, VideoDecoderType.DecoderType paramDecoderType)
  {
    this.mUrl = paramString;
    paramString = new SegmentVideoInfo.SegmentInfo(paramString, 0, paramInt);
    this.segmentInfos = new ArrayList();
    this.segmentInfos.add(paramString);
    this.decoderTypeSuggest = paramDecoderType;
  }
  
  public void addSegmentInfo(String paramString, int paramInt)
  {
    if (this.segmentInfos == null) {
      this.segmentInfos = new ArrayList();
    }
    int i;
    if (this.segmentInfos.isEmpty())
    {
      i = 0;
    }
    else
    {
      i = this.segmentInfos.size();
      ArrayList localArrayList = this.segmentInfos;
      i -= 1;
      int j = ((SegmentVideoInfo.SegmentInfo)localArrayList.get(i)).offset;
      i = ((SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i)).duration + j;
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.segmentInfos.add(new SegmentVideoInfo.SegmentInfo(paramString, i, paramInt));
    }
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.segmentInfos;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public VideoDecoderType.DecoderType getDecoderTypeSuggest()
  {
    return this.decoderTypeSuggest;
  }
  
  public SegmentVideoInfo.SegmentInfo getSegment(int paramInt)
  {
    if ((this.segmentInfos != null) && (paramInt >= 0) && (paramInt < getCount())) {
      return (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(paramInt);
    }
    return null;
  }
  
  public int getSegmentIndex(long paramLong)
  {
    Object localObject = this.segmentInfos;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return -1;
      }
      int j = getCount();
      int i = 0;
      if (j == 1) {
        return 0;
      }
      while (i < j)
      {
        localObject = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i);
        if (localObject == null) {
          return -1;
        }
        if (((SegmentVideoInfo.SegmentInfo)localObject).offset + ((SegmentVideoInfo.SegmentInfo)localObject).duration > paramLong) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public int getTotalDuration()
  {
    Object localObject = this.segmentInfos;
    int i = 0;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return 0;
      }
      localObject = this.segmentInfos;
      localObject = (SegmentVideoInfo.SegmentInfo)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      if (localObject == null) {
        return 0;
      }
      i = ((SegmentVideoInfo.SegmentInfo)localObject).offset + ((SegmentVideoInfo.SegmentInfo)localObject).duration;
    }
    return i;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public boolean isValid()
  {
    Object localObject1 = this.segmentInfos;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      int i = 0;
      while (i < this.segmentInfos.size())
      {
        localObject1 = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i);
        if (localObject1 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("segment index=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(" segment is null");
          PlayerUtils.log(6, "SegmentVideoInfo", ((StringBuilder)localObject1).toString());
          return false;
        }
        if (TextUtils.isEmpty(((SegmentVideoInfo.SegmentInfo)localObject1).url))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("segment index=");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(" url is empty");
          PlayerUtils.log(6, "SegmentVideoInfo", ((StringBuilder)localObject1).toString());
          return false;
        }
        Object localObject2;
        if (((SegmentVideoInfo.SegmentInfo)localObject1).offset < 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("segment index=");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" segmentInfo.offset=");
          ((StringBuilder)localObject2).append(((SegmentVideoInfo.SegmentInfo)localObject1).offset);
          PlayerUtils.log(6, "SegmentVideoInfo", ((StringBuilder)localObject2).toString());
          return false;
        }
        if (((SegmentVideoInfo.SegmentInfo)localObject1).duration < 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("segment index=");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" segmentInfo.duration=");
          ((StringBuilder)localObject2).append(((SegmentVideoInfo.SegmentInfo)localObject1).duration);
          PlayerUtils.log(6, "SegmentVideoInfo", ((StringBuilder)localObject2).toString());
          return false;
        }
        if (i > 0)
        {
          localObject2 = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i - 1);
          if (((SegmentVideoInfo.SegmentInfo)localObject2).offset + ((SegmentVideoInfo.SegmentInfo)localObject2).duration != ((SegmentVideoInfo.SegmentInfo)localObject1).offset)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("segment index=");
            localStringBuilder.append(i);
            localStringBuilder.append(" segmentInfo.offset=");
            localStringBuilder.append(((SegmentVideoInfo.SegmentInfo)localObject1).offset);
            localStringBuilder.append(" before.offset=");
            localStringBuilder.append(((SegmentVideoInfo.SegmentInfo)localObject2).offset);
            localStringBuilder.append(" before.duration=");
            localStringBuilder.append(((SegmentVideoInfo.SegmentInfo)localObject2).duration);
            PlayerUtils.log(6, "SegmentVideoInfo", localStringBuilder.toString());
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    PlayerUtils.log(6, "SegmentVideoInfo", "segmentInfos is null or empty");
    return false;
  }
  
  public void setDecoderTypeSuggest(VideoDecoderType.DecoderType paramDecoderType)
  {
    this.decoderTypeSuggest = paramDecoderType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append("[");
    Object localObject = this.segmentInfos;
    if (localObject == null)
    {
      localStringBuilder.append("null");
    }
    else
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)((Iterator)localObject).next();
        if (localSegmentInfo == null)
        {
          localStringBuilder.append("{null}");
        }
        else
        {
          localStringBuilder.append("{url=");
          localStringBuilder.append(localSegmentInfo.url);
          localStringBuilder.append(", duration=");
          localStringBuilder.append(localSegmentInfo.duration);
          localStringBuilder.append(", offset=");
          localStringBuilder.append(localSegmentInfo.offset);
          localStringBuilder.append("}");
        }
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void updateDuration()
  {
    Object localObject = this.segmentInfos;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return;
      }
      int i = 1;
      while (i < this.segmentInfos.size())
      {
        localObject = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i);
        SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i - 1);
        if (localObject == null) {
          break;
        }
        if (localSegmentInfo == null) {
          return;
        }
        ((SegmentVideoInfo.SegmentInfo)localObject).offset = (localSegmentInfo.offset + localSegmentInfo.duration);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo
 * JD-Core Version:    0.7.0.1
 */