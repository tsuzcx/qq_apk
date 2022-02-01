package com.tencent.mobileqq.haoliyou.orion;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Date;

class ZhuosConfig
{
  static ZhuosConfig a = new ZhuosConfig(false, new Date(0L), new Date(0L));
  final boolean b;
  final Date c;
  final Date d;
  
  ZhuosConfig(boolean paramBoolean, @NonNull Date paramDate1, @NonNull Date paramDate2)
  {
    this.b = paramBoolean;
    this.c = paramDate1;
    this.d = paramDate2;
  }
  
  private boolean b()
  {
    long l = NetConnInfoCenter.getServerTime() * 1000L;
    return (this.c.getTime() <= l) && (this.d.getTime() >= l);
  }
  
  boolean a()
  {
    return (b()) && (this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.orion.ZhuosConfig
 * JD-Core Version:    0.7.0.1
 */