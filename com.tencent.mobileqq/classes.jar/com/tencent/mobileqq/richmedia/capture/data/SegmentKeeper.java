package com.tencent.mobileqq.richmedia.capture.data;

import ahmm;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.sveffects.SLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SegmentKeeper
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ahmm();
  private static long jdField_b_of_type_Long = 0L;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  
  public SegmentKeeper() {}
  
  public SegmentKeeper(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.c = bool1;
      if (paramParcel.readInt() != 1) {
        break label205;
      }
      bool1 = true;
      label106:
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readInt() != 1) {
        break label211;
      }
    }
    label205:
    label211:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      int j = paramParcel.readInt();
      this.jdField_a_of_type_JavaUtilList.clear();
      if (j <= 0) {
        return;
      }
      while (i < j)
      {
        long l1 = paramParcel.readLong();
        long l2 = paramParcel.readLong();
        this.jdField_a_of_type_JavaUtilList.add(new Pair(Long.valueOf(l1), Long.valueOf(l2)));
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
    a(paramSegmentKeeper);
  }
  
  public static void b(long paramLong)
  {
    jdField_b_of_type_Long = paramLong;
  }
  
  public List a()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localLinkedList;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("duration_ms", this.jdField_a_of_type_Long);
      localJSONObject.put("adjusttime_valid", this.c);
      localJSONObject.put("mode", this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
      SLog.a("SegmentKeeper", "toJSONObject exception:" + localJSONException.toString());
    }
    localJSONObject.put("segments", localJSONException);
    return localJSONObject;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {
      SLog.d("SegmentKeeper", "clearSegments, data is locked!!");
    }
    while (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    SLog.d("SegmentKeeper", "changeNomalMode begin:" + toString());
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.jdField_a_of_type_Long = paramLong;
      return;
    }
    Iterator localIterator;
    Pair localPair;
    if (paramLong <= this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = paramLong;
      localLinkedList = new LinkedList();
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localPair = (Pair)localIterator.next();
        l2 = ((Long)localPair.first).longValue();
        l1 = ((Long)localPair.second).longValue();
        if (l2 < this.jdField_a_of_type_Long)
        {
          paramLong = l1;
          if (l1 > this.jdField_a_of_type_Long) {
            paramLong = this.jdField_a_of_type_Long;
          }
          localLinkedList.add(new Pair(Long.valueOf(l2), Long.valueOf(paramLong)));
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(localLinkedList);
      SLog.d("SegmentKeeper", "changeNomalMode end:" + toString());
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    long l2 = paramLong / this.jdField_a_of_type_Long;
    for (long l1 = 0L; l1 < l2; l1 = 1L + l1)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localPair = (Pair)localIterator.next();
        localLinkedList.add(new Pair(Long.valueOf(((Long)localPair.first).longValue() + this.jdField_a_of_type_Long * l1), Long.valueOf(((Long)localPair.second).longValue() + this.jdField_a_of_type_Long * l1)));
      }
    }
    l1 = paramLong - this.jdField_a_of_type_Long * l2;
    if (l1 > 0L)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(localLinkedList);
    SLog.d("SegmentKeeper", "changeNomalMode end:" + toString());
  }
  
  public void a(Pair paramPair)
  {
    if (paramPair == null) {
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      SLog.d("SegmentKeeper", "addSegment, data is locked!!");
      return;
    }
    paramPair = new Pair(paramPair.first, paramPair.second);
    this.jdField_a_of_type_JavaUtilList.add(paramPair);
  }
  
  public void a(SegmentKeeper paramSegmentKeeper)
  {
    if (paramSegmentKeeper == null) {
      return;
    }
    this.jdField_a_of_type_Long = paramSegmentKeeper.jdField_a_of_type_Long;
    jdField_b_of_type_Long = jdField_b_of_type_Long;
    this.jdField_a_of_type_Int = paramSegmentKeeper.jdField_a_of_type_Int;
    this.f = paramSegmentKeeper.f;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramSegmentKeeper.a());
    this.jdField_a_of_type_Boolean = paramSegmentKeeper.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_Boolean = paramSegmentKeeper.jdField_b_of_type_Boolean;
    this.c = paramSegmentKeeper.c;
  }
  
  public void a(List paramList)
  {
    if (this.jdField_b_of_type_Boolean) {
      SLog.a("SegmentKeeper", "setSegmentList, data is locked!!");
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
    } while (paramList == null);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        SLog.d("SegmentKeeper", "fromJSONObject , data is locked:");
        return;
      }
      try
      {
        this.jdField_a_of_type_Long = paramJSONObject.optLong("duration_ms", 9223372036854775807L);
        this.c = paramJSONObject.optBoolean("adjusttime_valid", true);
        this.jdField_a_of_type_Int = paramJSONObject.optInt("mode", 0);
        paramJSONObject = paramJSONObject.optJSONArray("segments");
        this.jdField_a_of_type_JavaUtilList.clear();
        if (paramJSONObject == null) {
          continue;
        }
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
          this.jdField_a_of_type_JavaUtilList.add(new Pair(Long.valueOf(localJSONObject.getLong("start_ms")), Long.valueOf(localJSONObject.getLong("end_ms"))));
          i += 1;
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        SLog.a("SegmentKeeper", "FromJSONObject exception:" + paramJSONObject.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    if (this.f) {
      return true;
    }
    if (b()) {
      return true;
    }
    if (this.c) {}
    for (long l = jdField_b_of_type_Long;; l = 0L)
    {
      l += paramLong;
      paramLong = l;
      if (this.jdField_a_of_type_Int == 1)
      {
        paramLong = l;
        if (l > this.jdField_a_of_type_Long)
        {
          paramLong = l;
          if (this.jdField_a_of_type_Long > 0L) {
            paramLong = l % this.jdField_a_of_type_Long;
          }
        }
        SLog.d("SegmentKeeper", "isInSegment time, loop mode, pos:" + paramLong);
      }
      if (this.jdField_a_of_type_Long >= paramLong) {
        break;
      }
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((paramLong >= ((Long)localPair.first).longValue()) && (paramLong <= ((Long)localPair.second).longValue())) {
        return true;
      }
    }
    return false;
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        SLog.d("SegmentKeeper", "addSegment, data is locked!!");
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((Pair)paramList.next());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilList.size() == 0;
  }
  
  public boolean b(long paramLong)
  {
    this.e = this.d;
    this.d = a(paramLong);
    return this.d != this.e;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("segmode=[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("]");
    localStringBuilder.append("adjusttimevalid=[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    localStringBuilder.append("duration=[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    localStringBuilder.append("disable=[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    localStringBuilder.append("reverse=[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("]");
    localStringBuilder.append("datalocked=[");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("]");
    localStringBuilder.append("segments=");
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    if (this.c)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.jdField_a_of_type_Boolean) {
        break label156;
      }
      paramInt = 1;
      label41:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label161;
      }
    }
    label156:
    label161:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.jdField_a_of_type_JavaUtilList.size());
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper
 * JD-Core Version:    0.7.0.1
 */