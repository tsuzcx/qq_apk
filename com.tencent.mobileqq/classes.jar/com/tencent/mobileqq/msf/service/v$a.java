package com.tencent.mobileqq.msf.service;

import com.tencent.qphone.base.util.QLog;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

class v$a
{
  public long[] a = null;
  public long[] b = null;
  
  public v$a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    this.a = paramArrayOfLong1;
    this.b = paramArrayOfLong2;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.a;
    int m = 0;
    int k = 0;
    if (localObject == null)
    {
      this.a = new long[1];
      this.a[0] = paramLong;
      this.b = new long[1];
    }
    long l1;
    if (paramBoolean) {
      l1 = 2L;
    } else {
      l1 = 1L;
    }
    int j = Arrays.binarySearch(this.a, paramLong);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" is the ");
    int i;
    if (j < 0) {
      i = -j - 1;
    } else {
      i = j;
    }
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("th of ");
    ((StringBuilder)localObject).append(Arrays.toString(this.a));
    QLog.d("GuardManager", 2, ((StringBuilder)localObject).toString());
    long l2;
    long[] arrayOfLong;
    if (j < 0)
    {
      i = -j - 1;
      if (i > 0) {
        l2 = paramLong - this.a[(i - 1)];
      } else {
        l2 = 9223372036854775807L;
      }
      localObject = this.a;
      long l3;
      if (i < localObject.length) {
        l3 = localObject[i] - paramLong;
      } else {
        l3 = 9223372036854775807L;
      }
      if ((l2 > v.b() * 2L) && (l3 > v.b() * 2L))
      {
        int n = this.a.length;
        localObject = new ArrayList(n * 2);
        j = 0;
        while (j < i)
        {
          ((ArrayList)localObject).add(Long.valueOf(this.a[j]));
          ((ArrayList)localObject).add(Long.valueOf(this.b[j]));
          j += 1;
        }
        ((ArrayList)localObject).add(Long.valueOf(paramLong));
        ((ArrayList)localObject).add(Long.valueOf(l1));
        while (i < n)
        {
          ((ArrayList)localObject).add(Long.valueOf(this.a[i]));
          ((ArrayList)localObject).add(Long.valueOf(this.b[i]));
          i += 1;
        }
        if (((ArrayList)localObject).size() > 56)
        {
          l1 = ((Long)((ArrayList)localObject).get(0)).longValue();
          paramLong = ((Long)((ArrayList)localObject).get(1)).longValue();
          m = ((ArrayList)localObject).size() / 2;
          i = 1;
          j = 0;
          while (i < m)
          {
            n = i * 2;
            long l4 = ((Long)((ArrayList)localObject).get(n)).longValue();
            l3 = ((Long)((ArrayList)localObject).get(n + 1)).longValue();
            if (l4 - l1 < v.b() * 3L)
            {
              l2 = paramLong + l3;
              l1 = (l1 * paramLong + l4 * l3) / l2;
              paramLong = l2;
            }
            else
            {
              n = j * 2;
              ((ArrayList)localObject).set(n, Long.valueOf(l1));
              ((ArrayList)localObject).set(n + 1, Long.valueOf(paramLong));
              j += 1;
              l1 = l4;
              paramLong = l3;
            }
            i += 1;
          }
          i = j * 2;
          ((ArrayList)localObject).set(i, Long.valueOf(l1));
          ((ArrayList)localObject).set(i + 1, Long.valueOf(paramLong));
          j += 1;
          this.a = new long[j];
          this.b = new long[j];
          i = k;
          while (i < j)
          {
            arrayOfLong = this.a;
            k = i * 2;
            arrayOfLong[i] = ((Long)((ArrayList)localObject).get(k)).longValue();
            this.b[i] = ((Long)((ArrayList)localObject).get(k + 1)).longValue();
            i += 1;
          }
        }
        j = ((ArrayList)localObject).size() / 2;
        this.a = new long[j];
        this.b = new long[j];
        i = m;
        while (i < j)
        {
          arrayOfLong = this.a;
          k = i * 2;
          arrayOfLong[i] = ((Long)((ArrayList)localObject).get(k)).longValue();
          this.b[i] = ((Long)((ArrayList)localObject).get(k + 1)).longValue();
          i += 1;
        }
      }
      j = i;
      if (l2 < l3) {
        j = i - 1;
      }
      localObject = this.a;
      l2 = localObject[j];
      arrayOfLong = this.b;
      localObject[j] = (l2 * arrayOfLong[j] + paramLong * l1);
      arrayOfLong[j] += l1;
      localObject[j] /= arrayOfLong[j];
    }
    else
    {
      localObject = this.a;
      l2 = localObject[j];
      arrayOfLong = this.b;
      localObject[j] = (l2 * arrayOfLong[j] + paramLong * l1);
      arrayOfLong[j] += l1;
      localObject[j] /= arrayOfLong[j];
    }
    QLog.d("GuardManager", 2, Arrays.toString(this.a));
  }
  
  public void a(ObjectOutputStream paramObjectOutputStream, boolean paramBoolean)
  {
    long[] arrayOfLong = this.a;
    int j = 0;
    int i;
    if (arrayOfLong != null) {
      i = arrayOfLong.length;
    } else {
      i = 0;
    }
    if (paramBoolean) {
      paramObjectOutputStream.writeLong(i);
    } else {
      paramObjectOutputStream.writeByte(i);
    }
    while (j < i)
    {
      paramObjectOutputStream.writeLong(this.a[j]);
      paramObjectOutputStream.writeLong(this.b[j]);
      j += 1;
    }
  }
  
  public boolean a(long paramLong)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      int j = Arrays.binarySearch((long[])localObject, paramLong);
      int i = j;
      if (j < 0)
      {
        i = -j - 1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" is the ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("th of ");
        ((StringBuilder)localObject).append(Arrays.toString(this.a));
        ((StringBuilder)localObject).append(", range reaches [");
        ((StringBuilder)localObject).append(paramLong - v.b());
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(v.b() + paramLong);
        ((StringBuilder)localObject).append("]");
        QLog.d("GuardManager", 2, ((StringBuilder)localObject).toString());
        if ((i > 0) && (paramLong - this.a[(i - 1)] <= v.b()))
        {
          i -= 1;
        }
        else
        {
          localObject = this.a;
          if ((i >= localObject.length) || (localObject[i] - paramLong > v.b())) {
            i = -1;
          }
        }
      }
      if (i >= 0)
      {
        int m = this.a.length;
        paramLong = this.b[i];
        i = 0;
        int k;
        for (j = 0; i < m; j = k)
        {
          k = j;
          if (this.b[i] > paramLong) {
            k = j + 1;
          }
          i += 1;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("order: ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", limit: ");
        ((StringBuilder)localObject).append(v.c());
        ((StringBuilder)localObject).append(", in ");
        ((StringBuilder)localObject).append(Arrays.toString(this.b));
        QLog.d("GuardManager", 2, ((StringBuilder)localObject).toString());
        if (j < v.c()) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.v.a
 * JD-Core Version:    0.7.0.1
 */