package com.tencent.mobileqq.mutualmark.info;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.mutualmark.mutualmark.MutualMark;
import tencent.im.mutualmark.mutualmark.ResourceInfo;
import tencent.im.mutualmark.mutualmark.ResourceInfo_17;

public class MutualMarkPullInfo
{
  public float a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g;
  public String g;
  public long h;
  
  public MutualMarkPullInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static MutualMarkPullInfo a(mutualmark.MutualMark paramMutualMark)
  {
    Object localObject4 = null;
    MutualMarkPullInfo localMutualMarkPullInfo = new MutualMarkPullInfo();
    localMutualMarkPullInfo.jdField_a_of_type_Long = paramMutualMark.uint64_type.get();
    localMutualMarkPullInfo.jdField_b_of_type_Long = paramMutualMark.uint64_level.get();
    localMutualMarkPullInfo.jdField_a_of_type_Float = paramMutualMark.float_count.get();
    localMutualMarkPullInfo.jdField_c_of_type_Long = paramMutualMark.uint64_day.get();
    localMutualMarkPullInfo.jdField_d_of_type_Long = paramMutualMark.uint64_time.get();
    localMutualMarkPullInfo.jdField_f_of_type_Long = paramMutualMark.uint64_icon_status.get();
    localMutualMarkPullInfo.h = paramMutualMark.uint64_sub_level.get();
    if (localMutualMarkPullInfo.jdField_f_of_type_Long != 2L) {
      localMutualMarkPullInfo.jdField_g_of_type_Long = 0L;
    }
    for (;;)
    {
      boolean bool;
      label135:
      Object localObject1;
      if (paramMutualMark.uint32_close_flag.has())
      {
        if (paramMutualMark.uint32_close_flag.get() != 0)
        {
          bool = true;
          localMutualMarkPullInfo.jdField_a_of_type_Boolean = bool;
        }
      }
      else if (paramMutualMark.bytes_resource_info.has()) {
        localObject1 = new mutualmark.ResourceInfo_17();
      }
      try
      {
        ((mutualmark.ResourceInfo_17)localObject1).mergeFrom(paramMutualMark.bytes_resource_info.get().toByteArray());
        a(localMutualMarkPullInfo, (mutualmark.ResourceInfo_17)localObject1);
        if (paramMutualMark.bytes_grade_resource_info.has()) {
          localObject1 = new mutualmark.ResourceInfo();
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          ((mutualmark.ResourceInfo)localObject1).mergeFrom(paramMutualMark.bytes_grade_resource_info.get().toByteArray());
          a(localMutualMarkPullInfo, (mutualmark.ResourceInfo)localObject1);
          if ((paramMutualMark.bytes_min_ver.has()) && (!TextUtils.isEmpty(paramMutualMark.bytes_min_ver.get().toStringUtf8()))) {
            localMutualMarkPullInfo.jdField_a_of_type_JavaLangString = paramMutualMark.bytes_min_ver.get().toStringUtf8();
          }
          if ((paramMutualMark.bytes_max_ver.has()) && (!TextUtils.isEmpty(paramMutualMark.bytes_max_ver.get().toStringUtf8()))) {
            localMutualMarkPullInfo.jdField_b_of_type_JavaLangString = paramMutualMark.bytes_max_ver.get().toStringUtf8();
          }
          if ((MutualMarkUtils.a(localMutualMarkPullInfo.jdField_a_of_type_JavaLangString, localMutualMarkPullInfo.jdField_b_of_type_JavaLangString)) && (!localMutualMarkPullInfo.jdField_a_of_type_Boolean))
          {
            localMutualMarkPullInfo.jdField_a_of_type_Boolean = false;
            QLog.i("MutualMarkPullInfo", 1, "isCurrentVersionShouldShow=" + MutualMarkUtils.a(localMutualMarkPullInfo.jdField_a_of_type_JavaLangString, localMutualMarkPullInfo.jdField_b_of_type_JavaLangString) + ", user_close_flag=" + localMutualMarkPullInfo.jdField_a_of_type_Boolean);
            return localMutualMarkPullInfo;
            if (!paramMutualMark.uint64_icon_status_end_time.has()) {
              continue;
            }
            localMutualMarkPullInfo.jdField_g_of_type_Long = paramMutualMark.uint64_icon_status_end_time.get();
            continue;
            bool = false;
            break label135;
            localThrowable1 = localThrowable1;
            QLog.i("MutualMarkPullInfo", 1, "parseFrom error:" + localThrowable1.getMessage());
            Object localObject2 = null;
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            QLog.i("MutualMarkPullInfo", 1, "parseFrom error:" + localThrowable2.getMessage());
            Object localObject3 = localObject4;
            continue;
            localMutualMarkPullInfo.jdField_a_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  private static void a(MutualMarkPullInfo paramMutualMarkPullInfo, mutualmark.ResourceInfo paramResourceInfo)
  {
    if ((paramMutualMarkPullInfo != null) && (paramResourceInfo != null))
    {
      if (paramResourceInfo.bytes_static_url.has())
      {
        paramMutualMarkPullInfo.jdField_c_of_type_JavaLangString = paramResourceInfo.bytes_static_url.get().toStringUtf8();
        paramMutualMarkPullInfo.jdField_c_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPullInfo.jdField_c_of_type_JavaLangString);
      }
      if (paramResourceInfo.bytes_dynamic_url.has())
      {
        paramMutualMarkPullInfo.jdField_d_of_type_JavaLangString = paramResourceInfo.bytes_dynamic_url.get().toStringUtf8();
        paramMutualMarkPullInfo.jdField_d_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPullInfo.jdField_d_of_type_JavaLangString);
      }
      if (paramResourceInfo.bytes_cartoon_url.has())
      {
        paramMutualMarkPullInfo.jdField_e_of_type_JavaLangString = paramResourceInfo.bytes_cartoon_url.get().toStringUtf8();
        paramMutualMarkPullInfo.jdField_e_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPullInfo.jdField_e_of_type_JavaLangString);
      }
      if (paramResourceInfo.bytes_cartoon_md5.has()) {
        paramMutualMarkPullInfo.jdField_f_of_type_JavaLangString = paramResourceInfo.bytes_cartoon_md5.get().toStringUtf8();
      }
      if (paramResourceInfo.bytes_word.has()) {
        paramMutualMarkPullInfo.jdField_g_of_type_JavaLangString = paramResourceInfo.bytes_word.get().toStringUtf8();
      }
    }
  }
  
  private static void a(MutualMarkPullInfo paramMutualMarkPullInfo, mutualmark.ResourceInfo_17 paramResourceInfo_17)
  {
    if ((paramMutualMarkPullInfo != null) && (paramResourceInfo_17 != null))
    {
      if (paramResourceInfo_17.bytes_static_url.has())
      {
        paramMutualMarkPullInfo.jdField_c_of_type_JavaLangString = paramResourceInfo_17.bytes_static_url.get().toStringUtf8();
        paramMutualMarkPullInfo.jdField_c_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPullInfo.jdField_c_of_type_JavaLangString);
      }
      if (paramResourceInfo_17.bytes_dynamic_url.has())
      {
        paramMutualMarkPullInfo.jdField_d_of_type_JavaLangString = paramResourceInfo_17.bytes_dynamic_url.get().toStringUtf8();
        paramMutualMarkPullInfo.jdField_d_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPullInfo.jdField_d_of_type_JavaLangString);
      }
      if (paramResourceInfo_17.bytes_cartoon_url.has())
      {
        paramMutualMarkPullInfo.jdField_e_of_type_JavaLangString = paramResourceInfo_17.bytes_cartoon_url.get().toStringUtf8();
        paramMutualMarkPullInfo.jdField_e_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPullInfo.jdField_e_of_type_JavaLangString);
      }
      if (paramResourceInfo_17.bytes_cartoon_md5.has()) {
        paramMutualMarkPullInfo.jdField_f_of_type_JavaLangString = paramResourceInfo_17.bytes_cartoon_md5.get().toStringUtf8();
      }
      if (paramResourceInfo_17.bytes_word.has()) {
        paramMutualMarkPullInfo.jdField_g_of_type_JavaLangString = paramResourceInfo_17.bytes_word.get().toStringUtf8();
      }
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkPullInfo{");
    localStringBuilder.append("type:").append(this.jdField_a_of_type_Long).append(", ");
    localStringBuilder.append("level:").append(this.jdField_b_of_type_Long).append(", ");
    localStringBuilder.append("count:").append(this.jdField_a_of_type_Float).append(", ");
    localStringBuilder.append("continue_days:").append(this.jdField_c_of_type_Long).append(", ");
    localStringBuilder.append("last_action_time:").append(this.jdField_d_of_type_Long).append(", ");
    localStringBuilder.append("last_change_time:").append(this.jdField_e_of_type_Long).append(", ");
    localStringBuilder.append("icon_status:").append(this.jdField_f_of_type_Long).append(", ");
    localStringBuilder.append("icon_status_end_time:").append(this.jdField_g_of_type_Long).append(", ");
    localStringBuilder.append("sub_level:").append(this.h).append(", ");
    localStringBuilder.append("icon_static_url:").append(this.jdField_c_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_dynamic_url:").append(this.jdField_d_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_cartoon_url:").append(this.jdField_e_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_cartoon_md5:").append(this.jdField_f_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_name:").append(this.jdField_g_of_type_JavaLangString).append(", ");
    localStringBuilder.append("user_close_flag:").append(this.jdField_a_of_type_Boolean).append(", ");
    localStringBuilder.append("minVersion:").append(this.jdField_a_of_type_JavaLangString).append(", ");
    localStringBuilder.append("maxVersion:").append(this.jdField_b_of_type_JavaLangString).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkPullInfo
 * JD-Core Version:    0.7.0.1
 */