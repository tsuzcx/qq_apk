package com.tencent.oskplayer.model;

import android.text.TextUtils;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SegmentVideoInfo
{
  public static final int DEFAULT_VIDEO_RATE = 750;
  private static final String LOG_TAG = "SegmentVideoInfo";
  public static final int STREAM_TYPE_H265_NORMAL = 4;
  public static final int STREAM_TYPE_HIGNBR = 1;
  public static final int STREAM_TYPE_LOWBR = 2;
  public static final int STREAM_TYPE_NORMAL = 0;
  public static final int STREAM_TYPE_ORIGINAL = 3;
  private int currentStreamRate;
  private int defaultStreamRate;
  private HashMap<Integer, SegmentVideoInfo.StreamInfo> streams;
  
  public SegmentVideoInfo()
  {
    this(new HashMap());
  }
  
  public SegmentVideoInfo(String paramString, int paramInt)
  {
    this();
    paramString = new SegmentVideoInfo.StreamInfo(paramString, paramInt);
    this.streams.put(Integer.valueOf(0), paramString);
  }
  
  public SegmentVideoInfo(HashMap<Integer, SegmentVideoInfo.StreamInfo> paramHashMap)
  {
    this(paramHashMap, 750);
  }
  
  public SegmentVideoInfo(HashMap<Integer, SegmentVideoInfo.StreamInfo> paramHashMap, int paramInt)
  {
    this.streams = paramHashMap;
    this.defaultStreamRate = paramInt;
    this.currentStreamRate = paramInt;
  }
  
  public static int maxFloor(Set<Integer> paramSet, int paramInt)
  {
    if ((paramSet == null) || (paramSet.size() == 0)) {}
    label73:
    label74:
    for (;;)
    {
      return paramInt;
      paramSet = paramSet.iterator();
      int i = 0;
      if (paramSet.hasNext())
      {
        Integer localInteger = (Integer)paramSet.next();
        if ((localInteger.intValue() <= i) || (localInteger.intValue() > paramInt)) {
          break label73;
        }
        i = localInteger.intValue();
      }
      for (;;)
      {
        break;
        if (i == 0) {
          break label74;
        }
        return i;
      }
    }
  }
  
  private void resetStreamTypeIfNeeded()
  {
    int i;
    if ((this.streams != null) && (this.streams.size() > 0))
    {
      Iterator localIterator = this.streams.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (localInteger.intValue() <= i) {
          break label103;
        }
        i = localInteger.intValue();
      }
    }
    label103:
    for (;;)
    {
      break;
      if (i <= 4)
      {
        if (this.defaultStreamRate >= 750) {
          this.defaultStreamRate = 0;
        }
        if (this.currentStreamRate >= 750) {
          this.currentStreamRate = 0;
        }
      }
      return;
    }
  }
  
  public SegmentVideoInfo.StreamInfo getCurrentStreamInfo()
  {
    resetStreamTypeIfNeeded();
    return getStreamInfo(this.currentStreamRate);
  }
  
  public int getCurrentStreamType()
  {
    resetStreamTypeIfNeeded();
    return this.currentStreamRate;
  }
  
  public SegmentVideoInfo.StreamInfo getDefaultStreamInfo()
  {
    if (this.streams == null) {
      return null;
    }
    resetStreamTypeIfNeeded();
    return (SegmentVideoInfo.StreamInfo)this.streams.get(Integer.valueOf(this.defaultStreamRate));
  }
  
  public String getDefaultUrl()
  {
    return getRealSegmentUrl(0, 0);
  }
  
  public String getRealSegmentUrl(int paramInt1, int paramInt2)
  {
    Object localObject = getStreamInfo(paramInt1);
    if ((localObject == null) || (((SegmentVideoInfo.StreamInfo)localObject).segmentInfos == null)) {
      return "";
    }
    localObject = (SegmentVideoInfo.SegmentInfo)((SegmentVideoInfo.StreamInfo)localObject).segmentInfos.get(paramInt2);
    if (localObject == null) {
      return "";
    }
    if (TextUtils.isEmpty(((SegmentVideoInfo.SegmentInfo)localObject).url)) {
      return "";
    }
    return ((SegmentVideoInfo.SegmentInfo)localObject).url;
  }
  
  public int getSegmentCount()
  {
    SegmentVideoInfo.StreamInfo localStreamInfo = getCurrentStreamInfo();
    if (localStreamInfo == null) {
      return 0;
    }
    return localStreamInfo.getCount();
  }
  
  public SegmentVideoInfo.StreamInfo getStreamInfo(int paramInt)
  {
    if ((this.streams == null) || (this.streams.size() == 0)) {
      return null;
    }
    return (SegmentVideoInfo.StreamInfo)this.streams.get(Integer.valueOf(paramInt));
  }
  
  public HashMap<Integer, SegmentVideoInfo.StreamInfo> getStreams()
  {
    return this.streams;
  }
  
  public int getdefaultStreamRate()
  {
    resetStreamTypeIfNeeded();
    return this.defaultStreamRate;
  }
  
  public boolean isValid()
  {
    if ((this.streams == null) || (this.streams.isEmpty()))
    {
      PlayerUtils.log(6, "SegmentVideoInfo", "streams is null or empty");
      return false;
    }
    Iterator localIterator = this.streams.values().iterator();
    while (localIterator.hasNext()) {
      if (!((SegmentVideoInfo.StreamInfo)localIterator.next()).isValid()) {
        return false;
      }
    }
    return true;
  }
  
  public void setCurrentStreamType(int paramInt)
  {
    this.currentStreamRate = paramInt;
  }
  
  public void setMaxStreamRate(int paramInt)
  {
    if (this.currentStreamRate > paramInt) {
      this.currentStreamRate = maxFloor(this.streams.keySet(), paramInt);
    }
  }
  
  public void setStreamInfo(SegmentVideoInfo.StreamInfo paramStreamInfo, int paramInt)
  {
    if (this.streams == null) {
      return;
    }
    this.streams.put(Integer.valueOf(paramInt), paramStreamInfo);
  }
  
  public void setStreams(HashMap<Integer, SegmentVideoInfo.StreamInfo> paramHashMap)
  {
    this.streams = paramHashMap;
  }
  
  public void setVideoRate(int paramInt)
  {
    this.currentStreamRate = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64).append("SegmentVideoInfo{streams=[");
    Iterator localIterator = this.streams.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localStringBuilder.append("{streamType=").append(((Map.Entry)localObject).getKey()).append(", streamInfo=");
      localObject = (SegmentVideoInfo.StreamInfo)((Map.Entry)localObject).getValue();
      if (localObject == null) {
        localStringBuilder.append("null");
      }
      for (;;)
      {
        localStringBuilder.append("}, ");
        break;
        localStringBuilder.append(((SegmentVideoInfo.StreamInfo)localObject).toString());
      }
    }
    localStringBuilder.append("]");
    localStringBuilder.append(", defaultStreamRate=").append(this.defaultStreamRate);
    localStringBuilder.append(", currentStreamRate=").append(this.currentStreamRate);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.model.SegmentVideoInfo
 * JD-Core Version:    0.7.0.1
 */