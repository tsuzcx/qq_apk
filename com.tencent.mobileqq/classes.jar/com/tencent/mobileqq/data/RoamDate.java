package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Arrays;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin, date")
public class RoamDate
  extends Entity
{
  public static final int LOCAL_INDEX_00 = 0;
  public static final int LOCAL_INDEX_01 = 1;
  public static final int LOCAL_INDEX_10 = 2;
  public static final int LOCAL_INDEX_11 = 3;
  public static final int SERVER_INDEX_00 = 0;
  public static final int SERVER_INDEX_01 = 1;
  public static final int SERVER_INDEX_10 = 2;
  public static final int SERVER_INDEX_11 = 3;
  private static final String TABLE_NAME = "MessageRoamDate";
  public String date;
  @notColumn
  public long[] lastMsgTime = new long[31];
  public byte[] lastMsgTimeData;
  public long locindex;
  @notColumn
  public long[] random;
  public byte[] randomData;
  public long serindex;
  public String uin;
  
  public RoamDate()
  {
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = this.lastMsgTime;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = 0L;
      i += 1;
    }
    this.lastMsgTimeData = new byte[localObject.length * 8];
    i = 0;
    for (;;)
    {
      localObject = this.lastMsgTimeData;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = 0;
      i += 1;
    }
    this.random = new long[31];
    i = 0;
    for (;;)
    {
      localObject = this.random;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = 0L;
      i += 1;
    }
    this.randomData = new byte[localObject.length * 8];
    i = 0;
    for (;;)
    {
      localObject = this.randomData;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = 0;
      i += 1;
    }
  }
  
  public RoamDate(String paramString1, String paramString2)
  {
    this();
    this.uin = paramString1;
    this.date = paramString2;
  }
  
  public RoamDate(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this();
    this.uin = paramString1;
    this.date = paramString2;
    makeSerIndex(paramInt1, paramInt2);
  }
  
  private long bytes2Long(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[paramInt] & 0xFF) << 56) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 48) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 40) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 32) + ((paramArrayOfByte[(paramInt + 4)] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 5)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 6)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 7)] & 0xFF) << 0);
  }
  
  public static int getDays(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 2)
    {
      if ((paramInt2 != 4) && (paramInt2 != 6) && (paramInt2 != 9) && (paramInt2 != 11)) {
        return 31;
      }
      return 30;
    }
    if (((paramInt1 % 4 == 0) && (paramInt1 % 100 != 0)) || (paramInt1 % 400 == 0)) {
      return 29;
    }
    return 28;
  }
  
  private int getOneBit(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 1 << 31 - paramInt2) != 0) {
      return 1;
    }
    return 0;
  }
  
  private int getTwoBits(long paramLong, int paramInt)
  {
    return (int)(paramLong >> 62 - paramInt * 2 & 0x3);
  }
  
  private void long2Bytes(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 56));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 48));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 40));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 32));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(int)(paramLong >> 0));
  }
  
  private void makeSerIndex(int paramInt1, int paramInt2)
  {
    int k = getDays();
    int i = 0;
    int j;
    for (;;)
    {
      j = paramInt2;
      if (i >= paramInt2) {
        break;
      }
      j = paramInt2;
      if (i >= k) {
        break;
      }
      if (getOneBit(paramInt1, i) == 0) {
        setSerTwoBits(1, i);
      } else {
        setSerTwoBits(2, i);
      }
      i += 1;
    }
    while (j < k)
    {
      setSerTwoBits(0, j);
      j += 1;
    }
  }
  
  private void setLocTwoBits(int paramInt1, int paramInt2)
  {
    long l = paramInt1;
    paramInt1 = 62 - paramInt2 * 2;
    this.locindex = ((3L << paramInt1 ^ 0xFFFFFFFF) & this.locindex | l << paramInt1);
  }
  
  private void setSerTwoBits(int paramInt1, int paramInt2)
  {
    long l = paramInt1;
    paramInt1 = 62 - paramInt2 * 2;
    this.serindex = ((3L << paramInt1 ^ 0xFFFFFFFF) & this.serindex | l << paramInt1);
  }
  
  public void clearLocState()
  {
    this.locindex = 0L;
  }
  
  public void clearSerState()
  {
    this.serindex = 0L;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (RoamDate)paramObject;
    String str = this.uin;
    if (str == null)
    {
      if (paramObject.uin != null) {
        return false;
      }
    }
    else if (!str.equals(paramObject.uin)) {
      return false;
    }
    str = this.date;
    if (str == null)
    {
      if (paramObject.date != null) {
        return false;
      }
    }
    else if (!str.equals(paramObject.date)) {
      return false;
    }
    return true;
  }
  
  public int getDays()
  {
    String[] arrayOfString = this.date.split("-");
    return getDays(Integer.valueOf(arrayOfString[0]).intValue(), Integer.valueOf(arrayOfString[1]).intValue());
  }
  
  public long getLastMsgTime(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getDays())) {
      return this.lastMsgTime[paramInt];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("day must [0 - ");
    localStringBuilder.append(getDays() - 1);
    localStringBuilder.append("]");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int getLocState(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getDays())) {
      return getTwoBits(this.locindex, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("day must [0 - ");
    localStringBuilder.append(getDays() - 1);
    localStringBuilder.append("]");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int getMonth()
  {
    return Integer.valueOf(this.date.split("-")[1]).intValue();
  }
  
  public long getRandom(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getDays())) {
      return this.random[paramInt];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("day must [0 - ");
    localStringBuilder.append(getDays() - 1);
    localStringBuilder.append("]");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int getSerState(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getDays())) {
      return getTwoBits(this.serindex, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("day must [0 - ");
    localStringBuilder.append(getDays() - 1);
    localStringBuilder.append("]");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public String getTableName()
  {
    return "MessageRoamDate";
  }
  
  public int getYear()
  {
    return Integer.valueOf(this.date.split("-")[0]).intValue();
  }
  
  public int hashCode()
  {
    String str = this.uin;
    int j = 0;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    str = this.date;
    if (str != null) {
      j = str.hashCode();
    }
    return (i + 31) * 31 + j;
  }
  
  protected void postRead()
  {
    int k = 0;
    int j = 0;
    int i = 0;
    long[] arrayOfLong;
    for (;;)
    {
      arrayOfLong = this.lastMsgTime;
      if (j >= arrayOfLong.length) {
        break;
      }
      arrayOfLong[j] = bytes2Long(this.lastMsgTimeData, i);
      j += 1;
      i += 8;
    }
    i = 0;
    j = k;
    for (;;)
    {
      arrayOfLong = this.random;
      if (j >= arrayOfLong.length) {
        break;
      }
      arrayOfLong[j] = bytes2Long(this.randomData, i);
      j += 1;
      i += 8;
    }
  }
  
  protected void prewrite()
  {
    int k = 0;
    int j = 0;
    int i = 0;
    long[] arrayOfLong;
    for (;;)
    {
      arrayOfLong = this.lastMsgTime;
      if (j >= arrayOfLong.length) {
        break;
      }
      long2Bytes(this.lastMsgTimeData, i, arrayOfLong[j]);
      j += 1;
      i += 8;
    }
    i = 0;
    j = k;
    for (;;)
    {
      arrayOfLong = this.random;
      if (j >= arrayOfLong.length) {
        break;
      }
      long2Bytes(this.randomData, i, arrayOfLong[j]);
      j += 1;
      i += 8;
    }
  }
  
  public void setLastMsgTime(int paramInt, long paramLong)
  {
    if ((paramInt >= 0) && (paramInt < getDays()))
    {
      this.lastMsgTime[paramInt] = paramLong;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("day must [0 - ");
    localStringBuilder.append(getDays() - 1);
    localStringBuilder.append("]");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setLocState(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < getDays()) && (paramInt2 >= 0) && (paramInt2 <= 3))
    {
      setLocTwoBits(paramInt2, paramInt1);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("day must [0 - ");
    localStringBuilder.append(getDays() - 1);
    localStringBuilder.append("], state must [0 - 3]");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setRandom(int paramInt, long paramLong)
  {
    if ((paramInt >= 0) && (paramInt < getDays()))
    {
      this.random[paramInt] = paramLong;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("day must [0 - ");
    localStringBuilder.append(getDays() - 1);
    localStringBuilder.append("]");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setSerState(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < getDays()) && (paramInt2 >= 0) && (paramInt2 <= 3))
    {
      setSerTwoBits(paramInt2, paramInt1);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("day must [0 - ");
    localStringBuilder.append(getDays() - 1);
    localStringBuilder.append("], state must [0 - 3]");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setSerindex(int paramInt1, int paramInt2)
  {
    makeSerIndex(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin = ");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", date = ");
    localStringBuilder.append(this.date);
    localStringBuilder.append(", serindex = ");
    localStringBuilder.append(this.serindex);
    localStringBuilder.append(", locindex = ");
    localStringBuilder.append(this.locindex);
    localStringBuilder.append(", lastMsgTime = ");
    localStringBuilder.append(Arrays.toString(this.lastMsgTime));
    localStringBuilder.append(", random = ");
    localStringBuilder.append(Arrays.toString(this.random));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.RoamDate
 * JD-Core Version:    0.7.0.1
 */