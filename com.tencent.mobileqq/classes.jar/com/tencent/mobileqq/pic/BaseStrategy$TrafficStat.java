package com.tencent.mobileqq.pic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.TimeZone;
import mqq.app.MobileQQ;

public class BaseStrategy$TrafficStat
{
  public long a = 0L;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  public long e = 0L;
  private long f = 0L;
  private long g = 0L;
  private SharedPreferences h;
  
  public BaseStrategy$TrafficStat()
  {
    a();
  }
  
  void a()
  {
    this.h = MobileQQ.sMobileQQ.getSharedPreferences("sp_pic_predown", 0);
    this.a = this.h.getLong("key_update_time", System.currentTimeMillis());
    this.b = this.h.getLong("key_xg_c2c", 0L);
    this.c = this.h.getLong("key_xg_grp", 0L);
    this.d = this.h.getLong("key_wifi_c2c", 0L);
    this.e = this.h.getLong("key_wifi_grp", 0L);
  }
  
  public boolean a(long paramLong)
  {
    try
    {
      long l1;
      if (this.f == 0L)
      {
        l1 = TimeZone.getDefault().getOffset(this.a);
        long l2 = (this.a + l1) / 86400000L;
        Long.signum(l2);
        this.g = (l2 * 86400000L - l1);
        this.f = (this.g + 86400000L);
      }
      if (paramLong <= this.f)
      {
        l1 = this.g;
        if (paramLong >= l1) {
          return true;
        }
      }
      this.f = 0L;
      this.g = 0L;
      this.e = 0L;
      this.d = 0L;
      this.c = 0L;
      this.b = 0L;
      this.a = paramLong;
      return false;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.h.edit();
      localEditor.putLong("key_update_time", this.a);
      localEditor.putLong("key_xg_c2c", this.b);
      localEditor.putLong("key_xg_grp", this.c);
      localEditor.putLong("key_wifi_c2c", this.d);
      localEditor.putLong("key_wifi_grp", this.e);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long[] c()
  {
    try
    {
      a(System.currentTimeMillis());
      long l1 = this.b;
      long l2 = this.c;
      long l3 = this.d;
      long l4 = this.e;
      return new long[] { l1, l2, l3, l4 };
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BaseStrategy.TrafficStat
 * JD-Core Version:    0.7.0.1
 */