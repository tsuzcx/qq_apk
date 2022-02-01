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
    Object localObject = mOffsetMap;
    Float localFloat = Float.valueOf(0.0F);
    ((List)localObject).add(Pair.create(localFloat, Double.valueOf(65.0D)));
    List localList = mOffsetMap;
    localObject = Float.valueOf(120.0F);
    localList.add(Pair.create(localObject, Double.valueOf(-55.0D)));
    localList = mScaleMap;
    Double localDouble = Double.valueOf(1.0D);
    localList.add(Pair.create(localFloat, localDouble));
    mScaleMap.add(Pair.create(Float.valueOf(65.0F), localDouble));
    mScaleMap.add(Pair.create(localObject, localDouble));
  }
  
  public int adjustDecibel(int paramInt)
  {
    List localList = mOffsetMap;
    double d2 = 0.0D;
    double d1;
    if (localList != null) {
      d1 = AudioFabbyUtil.getRangeValue(0, this.mMeanDecibel, localList, 0.0D);
    } else {
      d1 = 0.0D;
    }
    localList = mScaleMap;
    if (localList != null) {
      d2 = AudioFabbyUtil.getRangeValue(0, this.mMeanDecibel, localList, 1.0D);
    }
    int i = this.mMeanDecibel;
    double d3 = paramInt - i;
    Double.isNaN(d3);
    double d4 = i;
    Double.isNaN(d4);
    return (int)(d3 * d2 + d4 + d1);
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