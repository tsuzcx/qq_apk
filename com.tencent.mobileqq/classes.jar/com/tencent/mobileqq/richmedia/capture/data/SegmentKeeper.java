package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.sveffects.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SegmentKeeper
  implements Parcelable
{
  public static final Parcelable.Creator<SegmentKeeper> CREATOR = new SegmentKeeper.1();
  public static final String KEY_ADJUSTTIME_VALID = "adjusttime_valid";
  public static final String KEY_DURATION = "duration_ms";
  public static final String KEY_MODE = "mode";
  public static final String KEY_SEGMENT_END = "end_ms";
  public static final String KEY_SEGMENT_LIST = "segments";
  public static final String KEY_SEGMENT_START = "start_ms";
  public static final int MODE_LOOP = 1;
  public static final int MODE_NORMAL = 0;
  public static final String TAG = "SegmentKeeper";
  private static long mAdjustTime = 0L;
  private boolean mAdjustTimeValid = true;
  private boolean mCurIn = false;
  private boolean mDataLocked = false;
  private boolean mDisable = false;
  private long mDuration = 9223372036854775807L;
  private boolean mLastIn = false;
  private int mMode = 1;
  private boolean mReverse = false;
  private List<Pair<Long, Long>> mSegmentRanges = new LinkedList();
  
  public SegmentKeeper() {}
  
  public SegmentKeeper(Parcel paramParcel)
  {
    this.mMode = paramParcel.readInt();
    this.mDuration = paramParcel.readLong();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.mAdjustTimeValid = bool1;
      if (paramParcel.readInt() != 1) {
        break label205;
      }
      bool1 = true;
      label106:
      this.mReverse = bool1;
      if (paramParcel.readInt() != 1) {
        break label211;
      }
    }
    label205:
    label211:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mDataLocked = bool1;
      int j = paramParcel.readInt();
      this.mSegmentRanges.clear();
      if (j <= 0) {
        return;
      }
      while (i < j)
      {
        long l1 = paramParcel.readLong();
        long l2 = paramParcel.readLong();
        this.mSegmentRanges.add(new Pair(Long.valueOf(l1), Long.valueOf(l2)));
        i += 1;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label106;
    }
  }
  
  public SegmentKeeper(SegmentKeeper paramSegmentKeeper)
  {
    set(paramSegmentKeeper);
  }
  
  public static void adjustTime(long paramLong)
  {
    mAdjustTime = paramLong;
  }
  
  private void sortList()
  {
    SegmentKeeper.SortComparator localSortComparator = new SegmentKeeper.SortComparator(this, null);
    Collections.sort(this.mSegmentRanges, localSortComparator);
  }
  
  public void addSegment(long paramLong1, long paramLong2)
  {
    if (this.mDataLocked)
    {
      SLog.d("SegmentKeeper", "addSegment, data is locked!!");
      return;
    }
    Pair localPair = new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    this.mSegmentRanges.add(localPair);
  }
  
  public void addSegment(Pair<Long, Long> paramPair)
  {
    if (paramPair == null) {
      return;
    }
    if (this.mDataLocked)
    {
      SLog.d("SegmentKeeper", "addSegment, data is locked!!");
      return;
    }
    paramPair = new Pair(paramPair.first, paramPair.second);
    this.mSegmentRanges.add(paramPair);
  }
  
  public void addSegment(List<Pair<Long, Long>> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (this.mDataLocked)
      {
        SLog.d("SegmentKeeper", "addSegment, data is locked!!");
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        addSegment((Pair)paramList.next());
      }
    }
  }
  
  public void changeNormalMode(long paramLong)
  {
    SLog.d("SegmentKeeper", "changeNomalMode begin:" + toString());
    if (this.mMode == 0) {
      return;
    }
    if (this.mSegmentRanges.size() == 0)
    {
      this.mDuration = paramLong;
      return;
    }
    Iterator localIterator;
    Pair localPair;
    if (paramLong <= this.mDuration)
    {
      this.mDuration = paramLong;
      localLinkedList = new LinkedList();
      localIterator = this.mSegmentRanges.iterator();
      while (localIterator.hasNext())
      {
        localPair = (Pair)localIterator.next();
        l2 = ((Long)localPair.first).longValue();
        l1 = ((Long)localPair.second).longValue();
        if (l2 < this.mDuration)
        {
          paramLong = l1;
          if (l1 > this.mDuration) {
            paramLong = this.mDuration;
          }
          localLinkedList.add(new Pair(Long.valueOf(l2), Long.valueOf(paramLong)));
        }
      }
      this.mSegmentRanges.clear();
      this.mSegmentRanges.addAll(localLinkedList);
      SLog.d("SegmentKeeper", "changeNomalMode end:" + toString());
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    long l2 = paramLong / this.mDuration;
    for (long l1 = 0L; l1 < l2; l1 = 1L + l1)
    {
      localIterator = this.mSegmentRanges.iterator();
      while (localIterator.hasNext())
      {
        localPair = (Pair)localIterator.next();
        localLinkedList.add(new Pair(Long.valueOf(((Long)localPair.first).longValue() + this.mDuration * l1), Long.valueOf(((Long)localPair.second).longValue() + this.mDuration * l1)));
      }
    }
    l1 = paramLong - this.mDuration * l2;
    if (l1 > 0L)
    {
      localIterator = this.mSegmentRanges.iterator();
      while (localIterator.hasNext())
      {
        localPair = (Pair)localIterator.next();
        l2 = ((Long)localPair.first).longValue();
        long l3 = ((Long)localPair.second).longValue();
        if (l3 <= l1)
        {
          localLinkedList.add(new Pair(Long.valueOf(l2), Long.valueOf(l3)));
        }
        else
        {
          if (l1 <= l2) {
            break;
          }
          localLinkedList.add(new Pair(Long.valueOf(l2), Long.valueOf(l1)));
        }
      }
    }
    this.mDuration = paramLong;
    this.mSegmentRanges.clear();
    this.mSegmentRanges.addAll(localLinkedList);
    SLog.d("SegmentKeeper", "changeNomalMode end:" + toString());
  }
  
  public void clearSegments()
  {
    if (this.mDataLocked) {
      SLog.d("SegmentKeeper", "clearSegments, data is locked!!");
    }
    while (this.mSegmentRanges.size() == 0) {
      return;
    }
    this.mSegmentRanges.clear();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void disable(boolean paramBoolean)
  {
    this.mDisable = paramBoolean;
  }
  
  public void fromJSONObject(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      if (this.mDataLocked)
      {
        SLog.d("SegmentKeeper", "fromJSONObject , data is locked:");
        return;
      }
      try
      {
        this.mDuration = paramJSONObject.optLong("duration_ms", 9223372036854775807L);
        this.mAdjustTimeValid = paramJSONObject.optBoolean("adjusttime_valid", true);
        this.mMode = paramJSONObject.optInt("mode", 0);
        paramJSONObject = paramJSONObject.optJSONArray("segments");
        this.mSegmentRanges.clear();
        if (paramJSONObject == null) {
          continue;
        }
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
          this.mSegmentRanges.add(new Pair(Long.valueOf(localJSONObject.getLong("start_ms")), Long.valueOf(localJSONObject.getLong("end_ms"))));
          i += 1;
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        SLog.e("SegmentKeeper", "FromJSONObject exception:" + paramJSONObject.toString());
      }
    }
  }
  
  public List<Pair<Long, Long>> getSegmentList()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.mSegmentRanges);
    return localLinkedList;
  }
  
  public void init(int paramInt, long paramLong, List<Pair<Long, Long>> paramList)
  {
    this.mMode = paramInt;
    this.mDuration = paramLong;
    setSegmentList(paramList);
  }
  
  public boolean isCurrentIn()
  {
    return this.mCurIn;
  }
  
  public boolean isDataLocked()
  {
    return this.mDataLocked;
  }
  
  public boolean isDisable()
  {
    return this.mDisable;
  }
  
  public boolean isEmpty()
  {
    return this.mSegmentRanges.size() == 0;
  }
  
  public boolean isInSegment(long paramLong)
  {
    if (this.mDisable) {
      return true;
    }
    if (isEmpty()) {
      return true;
    }
    if (this.mAdjustTimeValid) {}
    for (long l = mAdjustTime;; l = 0L)
    {
      l += paramLong;
      paramLong = l;
      if (this.mMode == 1)
      {
        paramLong = l;
        if (l > this.mDuration)
        {
          paramLong = l;
          if (this.mDuration > 0L) {
            paramLong = l % this.mDuration;
          }
        }
        SLog.d("SegmentKeeper", "isInSegment time, loop mode, pos:" + paramLong);
      }
      if (this.mDuration >= paramLong) {
        break;
      }
      return false;
    }
    Iterator localIterator = this.mSegmentRanges.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((paramLong >= ((Long)localPair.first).longValue()) && (paramLong <= ((Long)localPair.second).longValue())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isSegmentChanged(long paramLong)
  {
    this.mLastIn = this.mCurIn;
    this.mCurIn = isInSegment(paramLong);
    return this.mCurIn != this.mLastIn;
  }
  
  public void lockData(boolean paramBoolean)
  {
    this.mDataLocked = paramBoolean;
  }
  
  public void removeLastSegment()
  {
    if (this.mDataLocked) {
      SLog.d("SegmentKeeper", "removeLastSegment, data is locked!!");
    }
    while (this.mSegmentRanges.size() == 0) {
      return;
    }
    if (this.mMode == 1) {
      SLog.e("SegmentKeeper", "removeLastSegment in loop moad!! segments:" + toString());
    }
    this.mSegmentRanges.remove(this.mSegmentRanges.size() - 1);
  }
  
  public void reverseSegments(boolean paramBoolean)
  {
    if (this.mReverse == paramBoolean) {}
    do
    {
      return;
      this.mReverse = paramBoolean;
    } while (this.mSegmentRanges.size() == 0);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mSegmentRanges.iterator();
    long l1;
    long l2;
    if (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      l1 = ((Long)localPair.first).longValue();
      l2 = ((Long)localPair.second).longValue();
      if (l1 >= 0L) {
        break label214;
      }
      l1 = 0L;
    }
    label212:
    label214:
    for (;;)
    {
      if (l2 > this.mDuration) {
        l2 = this.mDuration;
      }
      for (;;)
      {
        if (l1 >= l2) {
          break label212;
        }
        localArrayList.add(new Pair(Long.valueOf(this.mDuration - l2), Long.valueOf(this.mDuration - l1)));
        break;
        this.mSegmentRanges.clear();
        this.mSegmentRanges.addAll(localArrayList);
        SLog.d("SegmentKeeper", "reverssegment:" + toString());
        return;
      }
      break;
    }
  }
  
  public void set(SegmentKeeper paramSegmentKeeper)
  {
    if (paramSegmentKeeper == null) {
      return;
    }
    this.mDuration = paramSegmentKeeper.mDuration;
    mAdjustTime = mAdjustTime;
    this.mMode = paramSegmentKeeper.mMode;
    this.mDisable = paramSegmentKeeper.mDisable;
    this.mSegmentRanges.clear();
    this.mSegmentRanges.addAll(paramSegmentKeeper.getSegmentList());
    this.mReverse = paramSegmentKeeper.mReverse;
    this.mDataLocked = paramSegmentKeeper.mDataLocked;
    this.mAdjustTimeValid = paramSegmentKeeper.mAdjustTimeValid;
  }
  
  public void setAdjustTimeValid(boolean paramBoolean)
  {
    this.mAdjustTimeValid = paramBoolean;
  }
  
  public void setMode(int paramInt)
  {
    this.mMode = paramInt;
  }
  
  public void setSegmentList(List<Pair<Long, Long>> paramList)
  {
    if (this.mDataLocked) {
      SLog.e("SegmentKeeper", "setSegmentList, data is locked!!");
    }
    do
    {
      return;
      this.mSegmentRanges.clear();
    } while (paramList == null);
    this.mSegmentRanges.addAll(paramList);
  }
  
  public JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("duration_ms", this.mDuration);
      localJSONObject.put("adjusttime_valid", this.mAdjustTimeValid);
      localJSONObject.put("mode", this.mMode);
      if (this.mSegmentRanges.size() > 0)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.mSegmentRanges.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Pair)localIterator.next();
          long l1 = ((Long)((Pair)localObject).first).longValue();
          long l2 = ((Long)((Pair)localObject).second).longValue();
          localObject = new JSONObject();
          ((JSONObject)localObject).put("start_ms", l1);
          ((JSONObject)localObject).put("end_ms", l2);
          localJSONArray.put(localObject);
        }
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      SLog.e("SegmentKeeper", "toJSONObject exception:" + localJSONException.toString());
    }
    localJSONObject.put("segments", localJSONException);
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("segmode=[");
    localStringBuilder.append(this.mMode);
    localStringBuilder.append("]");
    localStringBuilder.append("adjusttimevalid=[");
    localStringBuilder.append(this.mAdjustTimeValid);
    localStringBuilder.append("]");
    localStringBuilder.append("duration=[");
    localStringBuilder.append(this.mDuration);
    localStringBuilder.append("]");
    localStringBuilder.append("disable=[");
    localStringBuilder.append(this.mDisable);
    localStringBuilder.append("]");
    localStringBuilder.append("reverse=[");
    localStringBuilder.append(this.mReverse);
    localStringBuilder.append("]");
    localStringBuilder.append("datalocked=[");
    localStringBuilder.append(this.mDataLocked);
    localStringBuilder.append("]");
    localStringBuilder.append("segments=");
    if (this.mSegmentRanges.size() > 0)
    {
      Iterator localIterator = this.mSegmentRanges.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        localStringBuilder.append("[");
        localStringBuilder.append(localPair.first);
        localStringBuilder.append("-");
        localStringBuilder.append(localPair.second);
        localStringBuilder.append("]");
      }
    }
    localStringBuilder.append("[null]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.mMode);
    paramParcel.writeLong(this.mDuration);
    if (this.mAdjustTimeValid)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.mReverse) {
        break label156;
      }
      paramInt = 1;
      label41:
      paramParcel.writeInt(paramInt);
      if (!this.mDataLocked) {
        break label161;
      }
    }
    label156:
    label161:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.mSegmentRanges.size());
      if (this.mSegmentRanges.size() <= 0) {
        return;
      }
      Iterator localIterator = this.mSegmentRanges.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        paramParcel.writeLong(((Long)localPair.first).longValue());
        paramParcel.writeLong(((Long)localPair.second).longValue());
      }
      paramInt = 0;
      break;
      paramInt = 0;
      break label41;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper
 * JD-Core Version:    0.7.0.1
 */