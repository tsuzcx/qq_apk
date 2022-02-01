package com.tencent.mobileqq.systemmsg;

import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class SystemMsgUtils
{
  private static long A = x;
  private static long B = A + (z - y);
  private static long C = 2601000000L;
  private static long D = 2652000000L;
  private static long E = 336000000L;
  private static long F = 387000000L;
  private static long G = 510000000L;
  private static long H = 2010000000L;
  private static long I = B;
  private static long J = I + (H - G);
  private static long a = 202000000L;
  private static long b = 213000000L;
  private static long c;
  private static long d = c + (b - a);
  private static long e = 480000000L;
  private static long f = 489000000L;
  private static long g = d;
  private static long h = g + (f - e);
  private static long i = 2100000000L;
  private static long j = 2147000000L;
  private static long k = h;
  private static long l = k + (j - i);
  private static long m = 2010000000L;
  private static long n = 2100000000L;
  private static long o = l;
  private static long p = o + (n - m);
  private static long q = 2147000000L;
  private static long r = 2200000000L;
  private static long s = p;
  private static long t = s + (r - q);
  private static long u = 4100000000L;
  private static long v = 4200000000L;
  private static long w = t;
  private static long x = w + (v - u);
  private static long y = 3800000000L;
  private static long z = 4000000000L;
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    if (paramInt1 == 1)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3)
          {
            if (paramInt2 != 4) {
              return paramInt1;
            }
            return 8;
          }
          return 7;
        }
        return 3;
      }
      i1 = 2;
    }
    return i1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 11)
    {
      if (paramInt1 != 1) {}
    }
    else {
      do
      {
        return 2;
        if (paramInt2 == 12)
        {
          if (paramInt1 != 1) {
            break;
          }
          return 3;
        }
        if (paramInt2 == 13) {
          return 3;
        }
        if (paramInt2 == 14) {
          return 4;
        }
      } while (paramInt2 == 16);
    }
    return paramInt1;
  }
  
  public static String a(long paramLong)
  {
    long l1 = c;
    int i3 = 0;
    if ((paramLong >= l1) && (paramLong < d))
    {
      l2 = paramLong - l1 + a;
      i2 = 0;
    }
    else
    {
      l2 = 0L;
      i2 = -1;
    }
    long l3 = g;
    l1 = l2;
    int i1 = i2;
    if (paramLong >= l3)
    {
      l1 = l2;
      i1 = i2;
      if (paramLong < h)
      {
        l1 = paramLong - l3 + e;
        i1 = 0;
      }
    }
    l3 = k;
    long l2 = l1;
    int i2 = i1;
    if (paramLong >= l3)
    {
      l2 = l1;
      i2 = i1;
      if (paramLong < l)
      {
        l2 = paramLong - l3 + i;
        i2 = 0;
      }
    }
    l3 = o;
    l1 = l2;
    i1 = i2;
    if (paramLong >= l3)
    {
      l1 = l2;
      i1 = i2;
      if (paramLong < p)
      {
        l1 = paramLong - l3 + m;
        i1 = 0;
      }
    }
    l3 = s;
    l2 = l1;
    i2 = i1;
    if (paramLong >= l3)
    {
      l2 = l1;
      i2 = i1;
      if (paramLong < t)
      {
        l2 = paramLong - l3 + q;
        i2 = 0;
      }
    }
    l3 = w;
    l1 = l2;
    i1 = i2;
    if (paramLong >= l3)
    {
      l1 = l2;
      i1 = i2;
      if (paramLong < x)
      {
        l1 = paramLong - l3 + u;
        i1 = 0;
      }
    }
    l2 = l1;
    i2 = i1;
    if (paramLong >= A)
    {
      l2 = l1;
      i2 = i1;
      if (paramLong < B)
      {
        if ((paramLong >= E) && (paramLong < F)) {
          l1 = C;
        }
        l2 = paramLong - A + y;
        i2 = 0;
      }
    }
    l1 = I;
    if ((paramLong >= l1) && (paramLong < J))
    {
      l2 = G + (paramLong - l1);
      i2 = i3;
    }
    if (i2 == 0) {
      return String.valueOf(l2);
    }
    return null;
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, int paramInt1, String paramString, int paramInt2)
  {
    if (paramStructMsg != null)
    {
      paramInt2 = paramStructMsg.msg_type.get();
      List localList;
      String str;
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {
          return;
        }
        localList = paramStructMsg.msg.actions.get();
        if ((localList != null) && (localList.size() > paramInt1) && (b(paramStructMsg.msg.sub_type.get(), paramStructMsg.msg.group_msg_type.get())))
        {
          str = ((structmsg.SystemMsgAction)localList.get(paramInt1)).result.get();
          paramStructMsg.msg.msg_decided.set(str);
          paramStructMsg.msg.msg_detail.set(paramString);
          paramInt1 = a(paramStructMsg.msg.sub_type.get(), ((structmsg.SystemMsgAction)localList.get(paramInt1)).action_info.type.get(), paramStructMsg.msg.group_msg_type.get());
          paramStructMsg.msg.sub_type.set(paramInt1);
          paramStructMsg.msg.actions.clear();
        }
      }
      else
      {
        localList = paramStructMsg.msg.actions.get();
        if ((localList != null) && (localList.size() > paramInt1))
        {
          str = ((structmsg.SystemMsgAction)localList.get(paramInt1)).result.get();
          paramStructMsg.msg.msg_decided.set(str);
          paramStructMsg.msg.msg_detail.set(paramString);
          paramInt1 = a(paramStructMsg.msg.sub_type.get(), ((structmsg.SystemMsgAction)localList.get(paramInt1)).action_info.type.get());
          paramStructMsg.msg.sub_type.set(paramInt1);
          paramStructMsg.msg.actions.clear();
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6) && (paramInt != 7) && (paramInt != 8) && (paramInt != 9) && (paramInt != 10) && (paramInt != 12)) {
      return paramInt == 13;
    }
    return true;
  }
  
  public static boolean a(structmsg.StructMsg paramStructMsg, int paramInt, String paramString1, String paramString2)
  {
    if ((paramStructMsg != null) && (paramInt != 0) && (paramInt != 3)) {
      if (paramStructMsg.msg_type.get() == 1)
      {
        if ((paramStructMsg.msg.sub_type.get() == 9) || (paramStructMsg.msg.sub_type.get() == 10) || (paramStructMsg.msg.sub_type.get() == 1))
        {
          paramStructMsg.msg.msg_decided.set(paramString2);
          paramStructMsg.msg.msg_detail.set(paramString1);
          paramStructMsg.msg.actions.clear();
          return true;
        }
      }
      else if (paramStructMsg.msg_type.get() == 2)
      {
        paramStructMsg.msg.sub_type.set(5);
        paramStructMsg.msg.msg_decided.set(paramString2);
        paramStructMsg.msg.msg_detail.set(paramString1);
        paramStructMsg.msg.actions.clear();
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 3) || ((paramInt2 != 10) && (paramInt2 != 11));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.SystemMsgUtils
 * JD-Core Version:    0.7.0.1
 */