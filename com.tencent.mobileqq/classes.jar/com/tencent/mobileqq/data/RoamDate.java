package com.tencent.mobileqq.data;

import auko;
import aulz;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.Arrays;

@uniqueConstraints(clause=ConflictClause.FAIL, columnNames="uin, date")
public class RoamDate
  extends auko
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
  @aulz
  public long[] lastMsgTime = new long[31];
  public byte[] lastMsgTimeData;
  public long locindex;
  @aulz
  public long[] random;
  public byte[] randomData;
  public long serindex;
  public String uin;
  
  public RoamDate()
  {
    int i = 0;
    while (i < this.lastMsgTime.length)
    {
      this.lastMsgTime[i] = 0L;
      i += 1;
    }
    this.lastMsgTimeData = new byte[this.lastMsgTime.length * 8];
    i = 0;
    while (i < this.lastMsgTimeData.length)
    {
      this.lastMsgTimeData[i] = 0;
      i += 1;
    }
    this.random = new long[31];
    i = 0;
    while (i < this.random.length)
    {
      this.random[i] = 0L;
      i += 1;
    }
    this.randomData = new byte[this.random.length * 8];
    i = 0;
    while (i < this.randomData.length)
    {
      this.randomData[i] = 0;
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
    switch (paramInt2)
    {
    case 3: 
    case 5: 
    case 7: 
    case 8: 
    case 10: 
    default: 
      return 31;
    case 4: 
    case 6: 
    case 9: 
    case 11: 
      return 30;
    }
    if (((paramInt1 % 4 == 0) && (paramInt1 % 100 != 0)) || (paramInt1 % 400 == 0)) {
      return 29;
    }
    return 28;
  }
  
  private int getOneBit(int paramInt1, int paramInt2)
  {
    if ((1 << 31 - paramInt2 & paramInt1) != 0) {
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
    int j = paramInt2;
    if (i < paramInt2)
    {
      j = paramInt2;
      if (i < k)
      {
        if (getOneBit(paramInt1, i) == 0) {
          setSerTwoBits(1, i);
        }
        for (;;)
        {
          i += 1;
          break;
          setSerTwoBits(2, i);
        }
      }
    }
    while (j < k)
    {
      setSerTwoBits(0, j);
      j += 1;
    }
  }
  
  private void setLocTwoBits(int paramInt1, int paramInt2)
  {
    this.locindex = (paramInt1 << 62 - paramInt2 * 2 | (3L << 62 - paramInt2 * 2 ^ 0xFFFFFFFF) & this.locindex);
  }
  
  private void setSerTwoBits(int paramInt1, int paramInt2)
  {
    this.serindex = (paramInt1 << 62 - paramInt2 * 2 | (3L << 62 - paramInt2 * 2 ^ 0xFFFFFFFF) & this.serindex);
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
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (RoamDate)paramObject;
        if (this.uin == null)
        {
          if (paramObject.uin != null) {
            return false;
          }
        }
        else if (!this.uin.equals(paramObject.uin)) {
          return false;
        }
        if (this.date != null) {
          break;
        }
      } while (paramObject.date == null);
      return false;
    } while (this.date.equals(paramObject.date));
    return false;
  }
  
  public int getDays()
  {
    String[] arrayOfString = this.date.split("-");
    return getDays(Integer.valueOf(arrayOfString[0]).intValue(), Integer.valueOf(arrayOfString[1]).intValue());
  }
  
  public long getLastMsgTime(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getDays())) {
      throw new IllegalArgumentException("day must [0 - " + (getDays() - 1) + "]");
    }
    return this.lastMsgTime[paramInt];
  }
  
  public int getLocState(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getDays())) {
      throw new IllegalArgumentException("day must [0 - " + (getDays() - 1) + "]");
    }
    return getTwoBits(this.locindex, paramInt);
  }
  
  public int getMonth()
  {
    return Integer.valueOf(this.date.split("-")[1]).intValue();
  }
  
  public long getRandom(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getDays())) {
      throw new IllegalArgumentException("day must [0 - " + (getDays() - 1) + "]");
    }
    return this.random[paramInt];
  }
  
  public int getSerState(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getDays())) {
      throw new IllegalArgumentException("day must [0 - " + (getDays() - 1) + "]");
    }
    return getTwoBits(this.serindex, paramInt);
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
    int j = 0;
    int i;
    if (this.uin == null)
    {
      i = 0;
      if (this.date != null) {
        break label39;
      }
    }
    for (;;)
    {
      return (i + 31) * 31 + j;
      i = this.uin.hashCode();
      break;
      label39:
      j = this.date.hashCode();
    }
  }
  
  public void postRead()
  {
    int k = 0;
    int i = 0;
    int j = 0;
    while (j < this.lastMsgTime.length)
    {
      this.lastMsgTime[j] = bytes2Long(this.lastMsgTimeData, i);
      j += 1;
      i += 8;
    }
    j = 0;
    i = k;
    while (j < this.random.length)
    {
      this.random[j] = bytes2Long(this.randomData, i);
      j += 1;
      i += 8;
    }
  }
  
  public void prewrite()
  {
    int k = 0;
    int i = 0;
    int j = 0;
    while (j < this.lastMsgTime.length)
    {
      long2Bytes(this.lastMsgTimeData, i, this.lastMsgTime[j]);
      j += 1;
      i += 8;
    }
    j = 0;
    i = k;
    while (j < this.random.length)
    {
      long2Bytes(this.randomData, i, this.random[j]);
      j += 1;
      i += 8;
    }
  }
  
  public void setLastMsgTime(int paramInt, long paramLong)
  {
    if ((paramInt < 0) || (paramInt >= getDays())) {
      throw new IllegalArgumentException("day must [0 - " + (getDays() - 1) + "]");
    }
    this.lastMsgTime[paramInt] = paramLong;
  }
  
  public void setLocState(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= getDays()) || (paramInt2 < 0) || (paramInt2 > 3)) {
      throw new IllegalArgumentException("day must [0 - " + (getDays() - 1) + "], state must [0 - 3]");
    }
    setLocTwoBits(paramInt2, paramInt1);
  }
  
  public void setRandom(int paramInt, long paramLong)
  {
    if ((paramInt < 0) || (paramInt >= getDays())) {
      throw new IllegalArgumentException("day must [0 - " + (getDays() - 1) + "]");
    }
    this.random[paramInt] = paramLong;
  }
  
  public void setSerState(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= getDays()) || (paramInt2 < 0) || (paramInt2 > 3)) {
      throw new IllegalArgumentException("day must [0 - " + (getDays() - 1) + "], state must [0 - 3]");
    }
    setSerTwoBits(paramInt2, paramInt1);
  }
  
  public void setSerindex(int paramInt1, int paramInt2)
  {
    makeSerIndex(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return "uin = " + this.uin + ", date = " + this.date + ", serindex = " + this.serindex + ", locindex = " + this.locindex + ", lastMsgTime = " + Arrays.toString(this.lastMsgTime) + ", random = " + Arrays.toString(this.random);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.RoamDate
 * JD-Core Version:    0.7.0.1
 */