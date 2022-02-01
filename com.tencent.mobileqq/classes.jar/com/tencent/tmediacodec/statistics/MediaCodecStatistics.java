package com.tencent.tmediacodec.statistics;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MediaCodecStatistics
{
  private long lastTimeInMs;
  private String mCacheResultData = "";
  private boolean mIsReuse;
  private boolean mIsReuseHasSet;
  private boolean mIsVideo;
  private boolean mReuseEnable;
  private final Map<String, Long> mStatisticsMap = new HashMap();
  
  public MediaCodecStatistics(boolean paramBoolean)
  {
    this.mIsVideo = paramBoolean;
  }
  
  private final void setIsReuse(boolean paramBoolean)
  {
    this.mIsReuse = paramBoolean;
    this.mIsReuseHasSet = true;
  }
  
  private final void setReuseEnable(boolean paramBoolean)
  {
    this.mReuseEnable = paramBoolean;
  }
  
  public final void configCodecEnd(boolean paramBoolean)
  {
    setIsReuse(paramBoolean);
    this.mStatisticsMap.put("configCodec", Long.valueOf(System.currentTimeMillis() - this.lastTimeInMs));
  }
  
  public final void configCodecStart(boolean paramBoolean)
  {
    setReuseEnable(paramBoolean);
    this.lastTimeInMs = System.currentTimeMillis();
  }
  
  public final void createByCodecEnd()
  {
    this.mStatisticsMap.put("createCodec", Long.valueOf(System.currentTimeMillis() - this.lastTimeInMs));
  }
  
  public final void createByCodecStart()
  {
    this.mCacheResultData = "";
    this.mStatisticsMap.clear();
    this.lastTimeInMs = System.currentTimeMillis();
  }
  
  @NonNull
  public final String getData()
  {
    if (TextUtils.isEmpty(this.mCacheResultData))
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      localStringBuilder.append("\"isVideo\":");
      localStringBuilder.append(this.mIsVideo + " ,");
      if (this.mIsReuseHasSet)
      {
        localStringBuilder.append("\"isReuse\":");
        localStringBuilder.append(this.mIsReuse + " ,");
      }
      localStringBuilder.append("\"reuseEnable\":");
      localStringBuilder.append(this.mReuseEnable + " ,");
      Iterator localIterator = this.mStatisticsMap.entrySet().iterator();
      long l2;
      for (long l1 = 0L; localIterator.hasNext(); l1 = l2)
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        l2 = l1;
        if (localEntry != null) {
          l2 = l1 + ((Number)localEntry.getValue()).longValue();
        }
        localStringBuilder.append("\"" + localEntry.getKey() + "\":");
        localStringBuilder.append(((Number)localEntry.getValue()).longValue() + " ,");
      }
      localStringBuilder.append("\"totalCodec\":");
      localStringBuilder.append(l1);
      localStringBuilder.append("}");
      this.mCacheResultData = localStringBuilder.toString();
    }
    return this.mCacheResultData;
  }
  
  public final void startCodecEnd()
  {
    this.mStatisticsMap.put("startCodec", Long.valueOf(System.currentTimeMillis() - this.lastTimeInMs));
  }
  
  public final void startCodecStart()
  {
    this.lastTimeInMs = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.statistics.MediaCodecStatistics
 * JD-Core Version:    0.7.0.1
 */