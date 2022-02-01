package com.tencent.mobileqq.enterpriseqq;

import android.text.TextUtils;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnterPriseQQCache
{
  private Map<String, Long> a = new HashMap();
  private Map<String, Integer> b = new HashMap();
  private Map<String, List<StructMsg.ButtonInfo>> c = new HashMap();
  private byte[] d = new byte[1];
  
  public List<StructMsg.ButtonInfo> a(String paramString)
  {
    synchronized (this.d)
    {
      if (this.c.containsKey(paramString))
      {
        paramString = (List)this.c.get(paramString);
        return paramString;
      }
      return null;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.d)
      {
        this.a.put(paramString, Long.valueOf(paramLong));
        return;
      }
    }
  }
  
  public void a(String paramString, List<StructMsg.ButtonInfo> paramList, int paramInt, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.d)
      {
        if (this.c.containsKey(paramString)) {
          this.c.remove(paramString);
        }
        this.c.put(paramString, paramList);
        this.b.put(paramString, Integer.valueOf(paramInt));
        this.a.put(paramString, Long.valueOf(paramLong));
        return;
      }
    }
  }
  
  public int b(String paramString)
  {
    synchronized (this.d)
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.b.containsKey(paramString)))
      {
        int i = ((Integer)this.b.get(paramString)).intValue();
        return i;
      }
      return -1;
    }
  }
  
  public long c(String paramString)
  {
    for (;;)
    {
      synchronized (this.d)
      {
        if ((!TextUtils.isEmpty(paramString)) && (this.a.containsKey(paramString)))
        {
          l = ((Long)this.a.get(paramString)).longValue();
          return l;
        }
      }
      long l = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterPriseQQCache
 * JD-Core Version:    0.7.0.1
 */