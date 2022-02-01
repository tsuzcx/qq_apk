package com.tencent.ttpic.audio;

import android.util.Pair;
import com.tencent.ttpic.util.AudioFabbyUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public enum MicAudioAdjustManager
{
  INSTANCE;
  
  private static final double BASE_DECIBEL = 65.0D;
  private static final int UPDATE_INTERVAL = 400;
  private static List<Pair<Float, Double>> mOffsetMap;
  private static List<Pair<Float, Double>> mScaleMap;
  private int mLastDecibel;
  private long mLastUpdateTime;
  private int mMeanDecibel = 65;
  private Queue<Integer> mRecentDbs = new LinkedList();
  private int mSumDecibel;
  
  private MicAudioAdjustManager() {}
  
  public static MicAudioAdjustManager getInstance()
  {
    initOffsetScaleMap();
    return INSTANCE;
  }
  
  private static void initOffsetScaleMap()
  {
    mOffsetMap = new ArrayList();
    mScaleMap = new ArrayList();
    mOffsetMap.add(Pair.create(Float.valueOf(0.0F), Double.valueOf(65.0D)));
    mOffsetMap.add(Pair.create(Float.valueOf(120.0F), Double.valueOf(-55.0D)));
    mScaleMap.add(Pair.create(Float.valueOf(0.0F), Double.valueOf(1.0D)));
    mScaleMap.add(Pair.create(Float.valueOf(65.0F), Double.valueOf(1.0D)));
    mScaleMap.add(Pair.create(Float.valueOf(120.0F), Double.valueOf(1.0D)));
  }
  
  public int adjustDecibel(int paramInt)
  {
    double d2 = 0.0D;
    if (mOffsetMap != null) {}
    for (double d1 = AudioFabbyUtil.getRangeValue(0, this.mMeanDecibel, mOffsetMap, 0.0D);; d1 = 0.0D)
    {
      if (mScaleMap != null) {
        d2 = AudioFabbyUtil.getRangeValue(0, this.mMeanDecibel, mScaleMap, 1.0D);
      }
      return (int)(d1 + (d2 * (paramInt - this.mMeanDecibel) + this.mMeanDecibel));
    }
  }
  
  public void setMicDecibel(int paramInt)
  {
    if (this.mLastDecibel != paramInt)
    {
      this.mRecentDbs.offer(Integer.valueOf(paramInt));
      for (this.mSumDecibel += paramInt; this.mRecentDbs.size() > 10; this.mSumDecibel -= ((Integer)this.mRecentDbs.poll()).intValue()) {}
      long l = System.currentTimeMillis();
      if (l - this.mLastUpdateTime >= 400L)
      {
        this.mMeanDecibel = (this.mSumDecibel / Math.max(this.mRecentDbs.size(), 1));
        this.mLastUpdateTime = l;
      }
      this.mLastDecibel = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.audio.MicAudioAdjustManager
 * JD-Core Version:    0.7.0.1
 */