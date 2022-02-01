package com.tencent.tmassistantsdk.internal.a;

import com.tencent.tmassistantbase.util.ab;
import java.util.ArrayList;

public class b
{
  protected static final String a = "b";
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, int paramInt3, byte[] paramArrayOfByte)
  {
    try
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hostPackageName = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",hostVersion = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",hostUserIdentity = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",dataItemType = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",dataItemAction = ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(",dataItemStartTime = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",dataItemEndTime = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",dataItemVersion = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",IPCData length= ");
      Object localObject;
      if (paramArrayOfByte == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(paramArrayOfByte.length);
      }
      localStringBuilder.append(localObject);
      ab.c(str, localStringBuilder.toString());
      paramString1 = new c(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramLong1, paramLong2, paramInt3, paramArrayOfByte);
      paramLong1 = new a().a(paramString1);
      return paramLong1;
    }
    finally {}
  }
  
  public ArrayList<c> a()
  {
    try
    {
      ArrayList localArrayList = new a().a();
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("result size = ");
      Object localObject1;
      if (localArrayList == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(localArrayList.size());
      }
      localStringBuilder.append(localObject1);
      ab.c(str, localStringBuilder.toString());
      return localArrayList;
    }
    finally {}
  }
  
  public boolean a(long paramLong)
  {
    try
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dbIdentity = ");
      localStringBuilder.append(paramLong);
      ab.c(str, localStringBuilder.toString());
      if (paramLong < 0L)
      {
        ab.c(a, "dbIdentity < 0,return false");
        return false;
      }
      boolean bool = new a().a(paramLong);
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("result = ");
      localStringBuilder.append(bool);
      ab.c(str, localStringBuilder.toString());
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.a.b
 * JD-Core Version:    0.7.0.1
 */