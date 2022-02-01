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
    if (this.segmentInfos.isEmpty()) {}
    int j;
    for (int i = 0;; i = ((SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i - 1)).duration + j)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.segmentInfos.add(new SegmentVideoInfo.SegmentInfo(paramString, i, paramInt));
      }
      return;
      i = this.segmentInfos.size();
      j = ((SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i - 1)).offset;
    }
  }
  
  public int getCount()
  {
    if (this.segmentInfos == null) {
      return 0;
    }
    return this.segmentInfos.size();
  }
  
  public VideoDecoderType.DecoderType getDecoderTypeSuggest()
  {
    return this.decoderTypeSuggest;
  }
  
  public SegmentVideoInfo.SegmentInfo getSegment(int paramInt)
  {
    if ((this.segmentInfos == null) || (paramInt < 0) || (paramInt >= getCount())) {
      return null;
    }
    return (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(paramInt);
  }
  
  public int getSegmentIndex(long paramLong)
  {
    int i = 0;
    if ((this.segmentInfos == null) || (this.segmentInfos.isEmpty())) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = getCount();
    } while (j == 1);
    i = 0;
    while (i < j)
    {
      SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i);
      if (localSegmentInfo == null) {
        return -1;
      }
      int k = localSegmentInfo.offset;
      if (localSegmentInfo.duration + k > paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getTotalDuration()
  {
    if ((this.segmentInfos == null) || (this.segmentInfos.isEmpty())) {
      return 0;
    }
    SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(this.segmentInfos.size() - 1);
    if (localSegmentInfo == null) {
      return 0;
    }
    int i = localSegmentInfo.offset;
    return localSegmentInfo.duration + i;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public boolean isValid()
  {
    if ((this.segmentInfos == null) || (this.segmentInfos.isEmpty()))
    {
      PlayerUtils.log(6, "SegmentVideoInfo", "segmentInfos is null or empty");
      return false;
    }
    int i = 0;
    while (i < this.segmentInfos.size())
    {
      SegmentVideoInfo.SegmentInfo localSegmentInfo1 = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i);
      if (localSegmentInfo1 == null)
      {
        PlayerUtils.log(6, "SegmentVideoInfo", "segment index=" + i + " segment is null");
        return false;
      }
      if (TextUtils.isEmpty(localSegmentInfo1.url))
      {
        PlayerUtils.log(6, "SegmentVideoInfo", "segment index=" + i + " url is empty");
        return false;
      }
      if (localSegmentInfo1.offset < 0)
      {
        PlayerUtils.log(6, "SegmentVideoInfo", "segment index=" + i + " segmentInfo.offset=" + localSegmentInfo1.offset);
        return false;
      }
      if (localSegmentInfo1.duration < 0)
      {
        PlayerUtils.log(6, "SegmentVideoInfo", "segment index=" + i + " segmentInfo.duration=" + localSegmentInfo1.duration);
        return false;
      }
      if (i > 0)
      {
        SegmentVideoInfo.SegmentInfo localSegmentInfo2 = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i - 1);
        if (localSegmentInfo2.offset + localSegmentInfo2.duration != localSegmentInfo1.offset)
        {
          PlayerUtils.log(6, "SegmentVideoInfo", "segment index=" + i + " segmentInfo.offset=" + localSegmentInfo1.offset + " before.offset=" + localSegmentInfo2.offset + " before.duration=" + localSegmentInfo2.duration);
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
  
  public void setDecoderTypeSuggest(VideoDecoderType.DecoderType paramDecoderType)
  {
    this.decoderTypeSuggest = paramDecoderType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(32).append("[");
    if (this.segmentInfos == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    Iterator localIterator = this.segmentInfos.iterator();
    label49:
    SegmentVideoInfo.SegmentInfo localSegmentInfo;
    if (localIterator.hasNext())
    {
      localSegmentInfo = (SegmentVideoInfo.SegmentInfo)localIterator.next();
      if (localSegmentInfo != null) {
        break label89;
      }
      localStringBuilder.append("{null}");
    }
    for (;;)
    {
      localStringBuilder.append(", ");
      break label49;
      break;
      label89:
      localStringBuilder.append("{url=").append(localSegmentInfo.url);
      localStringBuilder.append(", duration=").append(localSegmentInfo.duration);
      localStringBuilder.append(", offset=").append(localSegmentInfo.offset).append("}");
    }
  }
  
  public void updateDuration()
  {
    if ((this.segmentInfos == null) || (this.segmentInfos.isEmpty())) {}
    label89:
    for (;;)
    {
      return;
      int i = 1;
      for (;;)
      {
        if (i >= this.segmentInfos.size()) {
          break label89;
        }
        SegmentVideoInfo.SegmentInfo localSegmentInfo1 = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i);
        SegmentVideoInfo.SegmentInfo localSegmentInfo2 = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i - 1);
        if ((localSegmentInfo1 == null) || (localSegmentInfo2 == null)) {
          break;
        }
        int j = localSegmentInfo2.offset;
        localSegmentInfo1.offset = (localSegmentInfo2.duration + j);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo
 * JD-Core Version:    0.7.0.1
 */