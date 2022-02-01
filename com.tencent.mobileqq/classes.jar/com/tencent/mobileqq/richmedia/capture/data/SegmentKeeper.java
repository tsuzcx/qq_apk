package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.sveffects.SLog;
import java.util.ArrayList;
import java.util.Collection;
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
  private static long mAdjustTime;
  private boolean mAdjustTimeValid;
  private boolean mCurIn;
  private boolean mDataLocked;
  private boolean mDisable;
  private long mDuration;
  private boolean mLastIn;
  private int mMode;
  private boolean mReverse;
  private List<Pair<Long, Long>> mSegmentRanges;
  
  public SegmentKeeper()
  {
    this.mMode = 1;
    this.mReverse = false;
    this.mDataLocked = false;
    this.mSegmentRanges = new LinkedList();
    this.mDuration = 9223372036854775807L;
    this.mAdjustTimeValid = true;
    this.mCurIn = false;
    this.mLastIn = false;
    this.mDisable = false;
  }
  
  public SegmentKeeper(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.mMode = 1;
    int i = 0;
    this.mReverse = false;
    this.mDataLocked = false;
    this.mSegmentRanges = new LinkedList();
    this.mDuration = 9223372036854775807L;
    this.mAdjustTimeValid = true;
    this.mCurIn = false;
    this.mLastIn = false;
    this.mDisable = false;
    this.mMode = paramParcel.readInt();
    this.mDuration = paramParcel.readLong();
    boolean bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mAdjustTimeValid = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mReverse = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.mDataLocked = bool1;
    int j = paramParcel.readInt();
    this.mSegmentRanges.clear();
    if (j > 0) {
      while (i < j)
      {
        long l1 = paramParcel.readLong();
        long l2 = paramParcel.readLong();
        this.mSegmentRanges.add(new Pair(Long.valueOf(l1), Long.valueOf(l2)));
        i += 1;
      }
    }
  }
  
  public SegmentKeeper(SegmentKeeper paramSegmentKeeper)
  {
    this.mMode = 1;
    this.mReverse = false;
    this.mDataLocked = false;
    this.mSegmentRanges = new LinkedList();
    this.mDuration = 9223372036854775807L;
    this.mAdjustTimeValid = true;
    this.mCurIn = false;
    this.mLastIn = false;
    this.mDisable = false;
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
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("changeNomalMode begin:");
    ((StringBuilder)localObject1).append(toString());
    SLog.d("SegmentKeeper", ((StringBuilder)localObject1).toString());
    if (this.mMode == 0) {
      return;
    }
    if (this.mSegmentRanges.size() == 0)
    {
      this.mDuration = paramLong;
      return;
    }
    Pair localPair;
    long l3;
    if (paramLong <= this.mDuration)
    {
      this.mDuration = paramLong;
      localObject1 = new LinkedList();
      localObject2 = this.mSegmentRanges.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localPair = (Pair)((Iterator)localObject2).next();
        l3 = ((Long)localPair.first).longValue();
        l1 = ((Long)localPair.second).longValue();
        l2 = this.mDuration;
        if (l3 < l2)
        {
          paramLong = l1;
          if (l1 > l2) {
            paramLong = l2;
          }
          ((List)localObject1).add(new Pair(Long.valueOf(l3), Long.valueOf(paramLong)));
        }
      }
      this.mSegmentRanges.clear();
      this.mSegmentRanges.addAll((Collection)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("changeNomalMode end:");
      ((StringBuilder)localObject1).append(toString());
      SLog.d("SegmentKeeper", ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject2 = new LinkedList();
    long l2 = paramLong / this.mDuration;
    for (long l1 = 0L; l1 < l2; l1 += 1L)
    {
      localObject1 = this.mSegmentRanges.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localPair = (Pair)((Iterator)localObject1).next();
        ((List)localObject2).add(new Pair(Long.valueOf(((Long)localPair.first).longValue() + this.mDuration * l1), Long.valueOf(((Long)localPair.second).longValue() + this.mDuration * l1)));
      }
    }
    l1 = paramLong - l2 * this.mDuration;
    if (l1 > 0L)
    {
      localObject1 = this.mSegmentRanges.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localPair = (Pair)((Iterator)localObject1).next();
        l2 = ((Long)localPair.first).longValue();
        l3 = ((Long)localPair.second).longValue();
        if (l3 <= l1)
        {
          ((List)localObject2).add(new Pair(Long.valueOf(l2), Long.valueOf(l3)));
        }
        else
        {
          if (l1 <= l2) {
            break;
          }
          ((List)localObject2).add(new Pair(Long.valueOf(l2), Long.valueOf(l1)));
        }
      }
    }
    this.mDuration = paramLong;
    this.mSegmentRanges.clear();
    this.mSegmentRanges.addAll((Collection)localObject2);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("changeNomalMode end:");
    ((StringBuilder)localObject1).append(toString());
    SLog.d("SegmentKeeper", ((StringBuilder)localObject1).toString());
  }
  
  public void clearSegments()
  {
    if (this.mDataLocked)
    {
      SLog.d("SegmentKeeper", "clearSegments, data is locked!!");
      return;
    }
    if (this.mSegmentRanges.size() == 0) {
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
    if (paramJSONObject == null) {
      return;
    }
    if (this.mDataLocked)
    {
      SLog.d("SegmentKeeper", "fromJSONObject , data is locked:");
      return;
    }
    try
    {
      this.mDuration = paramJSONObject.optLong("duration_ms", 9223372036854775807L);
      this.mAdjustTimeValid = paramJSONObject.optBoolean("adjusttime_valid", true);
      int i = 0;
      this.mMode = paramJSONObject.optInt("mode", 0);
      paramJSONObject = paramJSONObject.optJSONArray("segments");
      this.mSegmentRanges.clear();
      if (paramJSONObject == null) {
        return;
      }
      Object localObject;
      while (i < paramJSONObject.length())
      {
        localObject = (JSONObject)paramJSONObject.get(i);
        this.mSegmentRanges.add(new Pair(Long.valueOf(((JSONObject)localObject).getLong("start_ms")), Long.valueOf(((JSONObject)localObject).getLong("end_ms"))));
        i += 1;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FromJSONObject exception:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      SLog.e("SegmentKeeper", ((StringBuilder)localObject).toString());
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
    if (this.mAdjustTimeValid) {
      l1 = mAdjustTime;
    } else {
      l1 = 0L;
    }
    long l1 = paramLong + l1;
    paramLong = l1;
    if (this.mMode == 1)
    {
      long l2 = this.mDuration;
      paramLong = l1;
      if (l1 > l2)
      {
        paramLong = l1;
        if (l2 > 0L) {
          paramLong = l1 % l2;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isInSegment time, loop mode, pos:");
      ((StringBuilder)localObject).append(paramLong);
      SLog.d("SegmentKeeper", ((StringBuilder)localObject).toString());
    }
    if (this.mDuration < paramLong) {
      return false;
    }
    Object localObject = this.mSegmentRanges.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
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
    if (this.mDataLocked)
    {
      SLog.d("SegmentKeeper", "removeLastSegment, data is locked!!");
      return;
    }
    if (this.mSegmentRanges.size() == 0) {
      return;
    }
    if (this.mMode == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeLastSegment in loop moad!! segments:");
      ((StringBuilder)localObject).append(toString());
      SLog.e("SegmentKeeper", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mSegmentRanges;
    ((List)localObject).remove(((List)localObject).size() - 1);
  }
  
  public void reverseSegments(boolean paramBoolean)
  {
    if (this.mReverse == paramBoolean) {
      return;
    }
    this.mReverse = paramBoolean;
    if (this.mSegmentRanges.size() == 0) {
      return;
    }
    Object localObject = new ArrayList();
    Iterator localIterator = this.mSegmentRanges.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      long l2 = ((Long)localPair.first).longValue();
      long l3 = ((Long)localPair.second).longValue();
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      long l4 = this.mDuration;
      l2 = l3;
      if (l3 > l4) {
        l2 = l4;
      }
      if (l1 < l2) {
        ((List)localObject).add(new Pair(Long.valueOf(this.mDuration - l2), Long.valueOf(this.mDuration - l1)));
      }
    }
    this.mSegmentRanges.clear();
    this.mSegmentRanges.addAll((Collection)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reverssegment:");
    ((StringBuilder)localObject).append(toString());
    SLog.d("SegmentKeeper", ((StringBuilder)localObject).toString());
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
    if (this.mDataLocked)
    {
      SLog.e("SegmentKeeper", "setSegmentList, data is locked!!");
      return;
    }
    this.mSegmentRanges.clear();
    if (paramList != null) {
      this.mSegmentRanges.addAll(paramList);
    }
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
        localObject1 = this.mSegmentRanges.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Pair)((Iterator)localObject1).next();
          long l1 = ((Long)((Pair)localObject2).first).longValue();
          long l2 = ((Long)((Pair)localObject2).second).longValue();
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("start_ms", l1);
          ((JSONObject)localObject2).put("end_ms", l2);
          localJSONArray.put(localObject2);
        }
        localJSONObject.put("segments", localJSONArray);
        return localJSONObject;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("toJSONObject exception:");
      ((StringBuilder)localObject1).append(localJSONException.toString());
      SLog.e("SegmentKeeper", ((StringBuilder)localObject1).toString());
    }
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper
 * JD-Core Version:    0.7.0.1
 */