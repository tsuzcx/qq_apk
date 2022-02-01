package com.tencent.mobileqq.flashshow.helper;

import com.tencent.mobileqq.flashshow.api.data.FSRedPointData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class FSEeveeRedPointHelper
{
  private static final String TAG = "FSEeveeRedPoint";
  private static volatile FSEeveeRedPointHelper mInstance;
  private final HashMap<Integer, Long> mLastPreTabRedPointTimestamps = new HashMap();
  private long mLastReadBubbleRedPointTime = 0L;
  private long mLastReadEntrancePointTime = 0L;
  private final HashMap<Integer, Long> mLastReadedTabRedPointTimestamps = new HashMap();
  private final HashMap<Integer, Long> mLastRspTabRedPointTimestamps = new HashMap();
  
  public static FSEeveeRedPointHelper getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null)
        {
          QLog.e("FSEeveeRedPoint", 1, "getInstance");
          mInstance = new FSEeveeRedPointHelper();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  private long getTabRedPointTimestamp(int paramInt, HashMap<Integer, Long> paramHashMap)
  {
    paramHashMap = (Long)paramHashMap.get(Integer.valueOf(paramInt));
    if (paramHashMap == null) {
      return 0L;
    }
    return paramHashMap.longValue();
  }
  
  public static void releaseInstance()
  {
    QLog.d("FSEeveeRedPoint", 1, "releaseInstance");
    if (mInstance == null) {
      return;
    }
    try
    {
      if (mInstance == null) {
        return;
      }
      mInstance = new FSEeveeRedPointHelper();
      return;
    }
    finally {}
  }
  
  private void saveTabRedPointTimestamp(int paramInt, long paramLong, HashMap<Integer, Long> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    long l = getTabRedPointTimestamp(paramInt, paramHashMap);
    if (paramLong > l) {
      paramHashMap.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
    }
    paramHashMap = new StringBuilder();
    paramHashMap.append("saveTabRedPointTimestamp timeStamp = ");
    paramHashMap.append(paramLong);
    paramHashMap.append(" tabRedPointTimestamp= ");
    paramHashMap.append(l);
    QLog.d("FSEeveeRedPoint", 2, paramHashMap.toString());
  }
  
  public long getLastPreTabRedPointTimestamp(int paramInt)
  {
    return getTabRedPointTimestamp(paramInt, this.mLastPreTabRedPointTimestamps);
  }
  
  public long getLastReadBubbleRedPointTimestamp()
  {
    return this.mLastReadBubbleRedPointTime;
  }
  
  public long getLastReadedBottomRedPointTimestamp()
  {
    return this.mLastReadEntrancePointTime;
  }
  
  public long getLastReadedTabRedPointTimestamp(int paramInt)
  {
    return getTabRedPointTimestamp(paramInt, this.mLastReadedTabRedPointTimestamps);
  }
  
  public long getLastRspTabRedPointTimestamp(int paramInt)
  {
    return getTabRedPointTimestamp(paramInt, this.mLastRspTabRedPointTimestamps);
  }
  
  public boolean isValidRedPointInfo(FSRedPointData paramFSRedPointData)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramFSRedPointData == null) {
      return false;
    }
    int i = paramFSRedPointData.getBadgeMainTypeValue();
    int j = paramFSRedPointData.getBadgeSubTypeValue();
    long l1 = paramFSRedPointData.getLastClearTimestamp();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return true;
        }
        l2 = getLastReadBubbleRedPointTimestamp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tabBadge seq=");
        localStringBuilder.append(paramFSRedPointData.getSeq());
        localStringBuilder.append(" lastClearTimestamp =");
        localStringBuilder.append(l1);
        localStringBuilder.append(" lastReadBubbleRedPointTimestamp =");
        localStringBuilder.append(l2);
        QLog.d("FSEeveeRedPoint", 1, localStringBuilder.toString());
        if (l1 >= l2) {
          bool1 = true;
        }
        return bool1;
      }
      l2 = getLastReadedBottomRedPointTimestamp();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bottomEntranceBadge seq=");
      localStringBuilder.append(paramFSRedPointData.getSeq());
      localStringBuilder.append(" lastClearTimestamp =");
      localStringBuilder.append(l1);
      localStringBuilder.append(" lastReadedBottomRedPointTimestamp=");
      localStringBuilder.append(l2);
      QLog.d("FSEeveeRedPoint", 1, localStringBuilder.toString());
      bool1 = bool2;
      if (l1 >= l2) {
        bool1 = true;
      }
      return bool1;
    }
    long l2 = getLastReadedTabRedPointTimestamp(j);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tabBadge seq=");
    localStringBuilder.append(paramFSRedPointData.getSeq());
    localStringBuilder.append(" lastClearTimestamp =");
    localStringBuilder.append(l1);
    localStringBuilder.append(" lastReadedTabRedPointTimestamp =");
    localStringBuilder.append(l2);
    QLog.d("FSEeveeRedPoint", 1, localStringBuilder.toString());
    bool1 = bool3;
    if (l1 >= l2) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void saveLastPreTabRedPointTimestamp(int paramInt, long paramLong)
  {
    saveTabRedPointTimestamp(paramInt, paramLong, this.mLastPreTabRedPointTimestamps);
  }
  
  public void saveLastReadBubbleRedPointTimestamp(long paramLong)
  {
    if (paramLong > this.mLastReadBubbleRedPointTime) {
      this.mLastReadBubbleRedPointTime = paramLong;
    }
  }
  
  public void saveLastReadedBottomRedPointTimestamp(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveLastReadedBottomRedPointTimestamp timeStamp=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("mLastReadEntrancePointTime=");
    localStringBuilder.append(this.mLastReadEntrancePointTime);
    QLog.d("FSEeveeRedPoint", 2, localStringBuilder.toString());
    if (paramLong > this.mLastReadEntrancePointTime) {
      this.mLastReadEntrancePointTime = paramLong;
    }
  }
  
  public void saveLastReadedTabRedPointTimestamp(int paramInt, long paramLong)
  {
    saveTabRedPointTimestamp(paramInt, paramLong, this.mLastReadedTabRedPointTimestamps);
  }
  
  public void saveLastRspTabRedPointTimestamp(int paramInt, long paramLong)
  {
    saveTabRedPointTimestamp(paramInt, paramLong, this.mLastRspTabRedPointTimestamps);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSEeveeRedPointHelper
 * JD-Core Version:    0.7.0.1
 */