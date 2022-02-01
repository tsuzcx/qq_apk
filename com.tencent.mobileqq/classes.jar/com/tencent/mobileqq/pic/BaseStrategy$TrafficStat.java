package com.tencent.mobileqq.pic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.TimeZone;
import mqq.app.MobileQQ;

public class BaseStrategy$TrafficStat
{
  public long a;
  private SharedPreferences a;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  public long e = 0L;
  private long f = 0L;
  private long g = 0L;
  
  public BaseStrategy$TrafficStat()
  {
    this.jdField_a_of_type_Long = 0L;
    a();
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("sp_pic_predown", 0);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_update_time", System.currentTimeMillis());
    this.b = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_xg_c2c", 0L);
    this.c = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_xg_grp", 0L);
    this.d = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_wifi_c2c", 0L);
    this.e = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_wifi_grp", 0L);
  }
  
  public boolean a(long paramLong)
  {
    try
    {
      long l1;
      if (this.f == 0L)
      {
        l1 = TimeZone.getDefault().getOffset(this.jdField_a_of_type_Long);
        long l2 = (this.jdField_a_of_type_Long + l1) / 86400000L;
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
      this.jdField_a_of_type_Long = paramLong;
      return false;
    }
    finally {}
  }
  
  public long[] a()
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
  
  public void b()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putLong("key_update_time", this.jdField_a_of_type_Long);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BaseStrategy.TrafficStat
 * JD-Core Version:    0.7.0.1
 */