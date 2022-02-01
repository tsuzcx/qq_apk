package com.tencent.mobileqq.mutualmark.info;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.qphone.base.util.QLog;

public class MutualMarkForDisplayInfo
{
  public float a;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public long d;
  public String d;
  public boolean d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  
  public MutualMarkForDisplayInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 999;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_d_of_type_Boolean = false;
  }
  
  public float a()
  {
    if (b()) {
      return 0.4F;
    }
    if (a()) {
      return 0.4F;
    }
    return 1.0F;
  }
  
  public void a(MutualMarkInfo paramMutualMarkInfo)
  {
    this.jdField_a_of_type_Long = paramMutualMarkInfo.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramMutualMarkInfo.jdField_b_of_type_Long;
    this.jdField_a_of_type_Float = paramMutualMarkInfo.jdField_a_of_type_Float;
    this.jdField_c_of_type_Long = paramMutualMarkInfo.jdField_c_of_type_Long;
    this.jdField_d_of_type_Long = paramMutualMarkInfo.jdField_d_of_type_Long;
    this.e = paramMutualMarkInfo.e;
    this.f = paramMutualMarkInfo.f;
    this.g = paramMutualMarkInfo.g;
    this.h = paramMutualMarkInfo.h;
    this.jdField_a_of_type_Boolean = paramMutualMarkInfo.jdField_b_of_type_Boolean;
    this.i = paramMutualMarkInfo.i;
    this.jdField_c_of_type_JavaLangString = paramMutualMarkInfo.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramMutualMarkInfo.jdField_b_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramMutualMarkInfo.jdField_c_of_type_JavaLangString;
    this.jdField_d_of_type_Boolean = paramMutualMarkInfo.jdField_a_of_type_Boolean;
  }
  
  public boolean a()
  {
    long l = this.jdField_a_of_type_Long;
    if (l != 12L)
    {
      if (IntimateUtil.a(l)) {
        return false;
      }
      if ((!MutualMarkUtils.c(this.jdField_a_of_type_Long)) && (this.jdField_a_of_type_Long != 7L))
      {
        if (MutualMarkUtils.a(this.jdField_d_of_type_Long * 1000L)) {
          return true;
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isInTwinkling icon_status:");
          localStringBuilder.append(this.f);
          localStringBuilder.append(" currentMillis:");
          localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis());
          localStringBuilder.append(" icon_status_end_time:");
          localStringBuilder.append(this.g);
          QLog.i("MutualMarkForDisplayInfo", 2, localStringBuilder.toString());
        }
        if ((this.f == 2L) && (NetConnInfoCenter.getServerTimeMillis() < this.g * 1000L)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean b()
  {
    return this.f == 1L;
  }
  
  public boolean c()
  {
    if ((this.jdField_c_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      return false;
    }
    return (this.jdField_c_of_type_Int != 0) || (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkForDisplayInfo{");
    localStringBuilder.append("type=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", level=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", continue_days=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", last_action_time=");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", last_change_time=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", icon_status=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", icon_status_end_time=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", sub_level=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", hasRemindInContact=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", remindAnimStartTime=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", sortKeyForNormal=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", isInAIOTitleLeft2=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", sortKeyForAIOTitle=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("'");
    localStringBuilder.append(", disableLocalResource=");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(", iconResId=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", iconApngUrl='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("'");
    localStringBuilder.append(", icon_static_url='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("'");
    localStringBuilder.append(", icon_name='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("'");
    localStringBuilder.append(", user_close_flag=");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo
 * JD-Core Version:    0.7.0.1
 */