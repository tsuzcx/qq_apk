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
      StringBuilder localStringBuilder1 = new StringBuilder("{");
      localStringBuilder1.append("\"isVideo\":");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mIsVideo);
      ((StringBuilder)localObject).append(" ,");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      if (this.mIsReuseHasSet)
      {
        localStringBuilder1.append("\"isReuse\":");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.mIsReuse);
        ((StringBuilder)localObject).append(" ,");
        localStringBuilder1.append(((StringBuilder)localObject).toString());
      }
      localStringBuilder1.append("\"reuseEnable\":");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mReuseEnable);
      ((StringBuilder)localObject).append(" ,");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      long l1 = 0L;
      localObject = this.mStatisticsMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        long l2 = l1;
        if (localEntry != null) {
          l2 = l1 + ((Number)localEntry.getValue()).longValue();
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("\"");
        localStringBuilder2.append(localEntry.getKey());
        localStringBuilder2.append("\":");
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(((Number)localEntry.getValue()).longValue());
        localStringBuilder2.append(" ,");
        localStringBuilder1.append(localStringBuilder2.toString());
        l1 = l2;
      }
      localStringBuilder1.append("\"totalCodec\":");
      localStringBuilder1.append(l1);
      localStringBuilder1.append("}");
      this.mCacheResultData = localStringBuilder1.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.statistics.MediaCodecStatistics
 * JD-Core Version:    0.7.0.1
 */