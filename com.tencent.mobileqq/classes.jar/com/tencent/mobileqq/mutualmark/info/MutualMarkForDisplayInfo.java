package com.tencent.mobileqq.mutualmark.info;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.qphone.base.util.QLog;

public class MutualMarkForDisplayInfo
{
  public long a;
  public long b;
  public float c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  public boolean j;
  public long k;
  public int l = 0;
  public boolean m = false;
  public int n = 999;
  public String o;
  public boolean p;
  public int q;
  public String r;
  public String s = "";
  public String t = "";
  public boolean u = false;
  
  public void a(MutualMarkInfo paramMutualMarkInfo)
  {
    this.a = paramMutualMarkInfo.a;
    this.b = paramMutualMarkInfo.b;
    this.c = paramMutualMarkInfo.c;
    this.d = paramMutualMarkInfo.d;
    this.e = paramMutualMarkInfo.e;
    this.f = paramMutualMarkInfo.f;
    this.g = paramMutualMarkInfo.g;
    this.h = paramMutualMarkInfo.h;
    this.i = paramMutualMarkInfo.i;
    this.j = paramMutualMarkInfo.n;
    this.k = paramMutualMarkInfo.o;
    this.s = paramMutualMarkInfo.j;
    this.r = paramMutualMarkInfo.k;
    this.t = paramMutualMarkInfo.l;
    this.u = paramMutualMarkInfo.m;
  }
  
  public boolean a()
  {
    long l1 = this.a;
    if (l1 != 12L)
    {
      if (IntimateUtil.a(l1)) {
        return false;
      }
      if ((!MutualMarkUtils.c(this.a)) && (this.a != 7L))
      {
        if (MutualMarkUtils.a(this.e * 1000L)) {
          return true;
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isInTwinkling icon_status:");
          localStringBuilder.append(this.g);
          localStringBuilder.append(" currentMillis:");
          localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis());
          localStringBuilder.append(" icon_status_end_time:");
          localStringBuilder.append(this.h);
          QLog.i("MutualMarkForDisplayInfo", 2, localStringBuilder.toString());
        }
        if ((this.g == 2L) && (NetConnInfoCenter.getServerTimeMillis() < this.h * 1000L)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean b()
  {
    return this.g == 1L;
  }
  
  public boolean c()
  {
    if ((this.p) && (TextUtils.isEmpty(this.s))) {
      return false;
    }
    return (this.q != 0) || (!TextUtils.isEmpty(this.s));
  }
  
  public float d()
  {
    if (b()) {
      return 0.4F;
    }
    if (a()) {
      return 0.4F;
    }
    return 1.0F;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkForDisplayInfo{");
    localStringBuilder.append("type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", level=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", continue_days=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", last_action_time=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", last_change_time=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", icon_status=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", icon_status_end_time=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", sub_level=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", hasRemindInContact=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", remindAnimStartTime=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", sortKeyForNormal=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", isInAIOTitleLeft2=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", sortKeyForAIOTitle=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.o);
    localStringBuilder.append("'");
    localStringBuilder.append(", disableLocalResource=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", iconResId=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", iconApngUrl='");
    localStringBuilder.append(this.r);
    localStringBuilder.append("'");
    localStringBuilder.append(", icon_static_url='");
    localStringBuilder.append(this.s);
    localStringBuilder.append("'");
    localStringBuilder.append(", icon_name='");
    localStringBuilder.append(this.t);
    localStringBuilder.append("'");
    localStringBuilder.append(", user_close_flag=");
    localStringBuilder.append(this.u);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo
 * JD-Core Version:    0.7.0.1
 */