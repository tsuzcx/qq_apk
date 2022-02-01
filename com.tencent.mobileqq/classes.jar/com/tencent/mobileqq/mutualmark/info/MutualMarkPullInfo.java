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
  public long a;
  public long b;
  public float c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public boolean q = false;
  
  public static MutualMarkPullInfo a(mutualmark.MutualMark paramMutualMark)
  {
    MutualMarkPullInfo localMutualMarkPullInfo = new MutualMarkPullInfo();
    localMutualMarkPullInfo.a = paramMutualMark.uint64_type.get();
    localMutualMarkPullInfo.b = paramMutualMark.uint64_level.get();
    localMutualMarkPullInfo.c = paramMutualMark.float_count.get();
    localMutualMarkPullInfo.d = paramMutualMark.uint64_day.get();
    localMutualMarkPullInfo.e = paramMutualMark.uint64_time.get();
    localMutualMarkPullInfo.g = paramMutualMark.uint64_icon_status.get();
    localMutualMarkPullInfo.i = paramMutualMark.uint64_sub_level.get();
    if (localMutualMarkPullInfo.g != 2L) {
      localMutualMarkPullInfo.h = 0L;
    } else if (paramMutualMark.uint64_icon_status_end_time.has()) {
      localMutualMarkPullInfo.h = paramMutualMark.uint64_icon_status_end_time.get();
    }
    if (paramMutualMark.uint32_close_flag.has())
    {
      boolean bool;
      if (paramMutualMark.uint32_close_flag.get() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localMutualMarkPullInfo.q = bool;
    }
    StringBuilder localStringBuilder;
    Object localObject;
    if (paramMutualMark.bytes_resource_info.has())
    {
      mutualmark.ResourceInfo_17 localResourceInfo_17 = new mutualmark.ResourceInfo_17();
      try
      {
        localResourceInfo_17.mergeFrom(paramMutualMark.bytes_resource_info.get().toByteArray());
      }
      catch (Throwable localThrowable1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseFrom error:");
        localStringBuilder.append(localThrowable1.getMessage());
        QLog.i("MutualMarkPullInfo", 1, localStringBuilder.toString());
        localObject = null;
      }
      a(localMutualMarkPullInfo, (mutualmark.ResourceInfo_17)localObject);
    }
    if (paramMutualMark.bytes_grade_resource_info.has())
    {
      localObject = new mutualmark.ResourceInfo();
      mutualmark.ResourceInfo localResourceInfo;
      try
      {
        ((mutualmark.ResourceInfo)localObject).mergeFrom(paramMutualMark.bytes_grade_resource_info.get().toByteArray());
      }
      catch (Throwable localThrowable2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseFrom error:");
        localStringBuilder.append(localThrowable2.getMessage());
        QLog.i("MutualMarkPullInfo", 1, localStringBuilder.toString());
        localResourceInfo = null;
      }
      a(localMutualMarkPullInfo, localResourceInfo);
    }
    if ((paramMutualMark.bytes_min_ver.has()) && (!TextUtils.isEmpty(paramMutualMark.bytes_min_ver.get().toStringUtf8()))) {
      localMutualMarkPullInfo.j = paramMutualMark.bytes_min_ver.get().toStringUtf8();
    }
    if ((paramMutualMark.bytes_max_ver.has()) && (!TextUtils.isEmpty(paramMutualMark.bytes_max_ver.get().toStringUtf8()))) {
      localMutualMarkPullInfo.k = paramMutualMark.bytes_max_ver.get().toStringUtf8();
    }
    if ((MutualMarkUtils.b(localMutualMarkPullInfo.j, localMutualMarkPullInfo.k)) && (!localMutualMarkPullInfo.q)) {
      localMutualMarkPullInfo.q = false;
    } else {
      localMutualMarkPullInfo.q = true;
    }
    paramMutualMark = new StringBuilder();
    paramMutualMark.append("isCurrentVersionShouldShow=");
    paramMutualMark.append(MutualMarkUtils.b(localMutualMarkPullInfo.j, localMutualMarkPullInfo.k));
    paramMutualMark.append(", user_close_flag=");
    paramMutualMark.append(localMutualMarkPullInfo.q);
    QLog.i("MutualMarkPullInfo", 1, paramMutualMark.toString());
    return localMutualMarkPullInfo;
  }
  
  private static void a(MutualMarkPullInfo paramMutualMarkPullInfo, mutualmark.ResourceInfo paramResourceInfo)
  {
    if ((paramMutualMarkPullInfo != null) && (paramResourceInfo != null))
    {
      if (paramResourceInfo.bytes_static_url.has())
      {
        paramMutualMarkPullInfo.l = paramResourceInfo.bytes_static_url.get().toStringUtf8();
        paramMutualMarkPullInfo.l = MutualMarkUtils.g(paramMutualMarkPullInfo.l);
      }
      if (paramResourceInfo.bytes_dynamic_url.has())
      {
        paramMutualMarkPullInfo.m = paramResourceInfo.bytes_dynamic_url.get().toStringUtf8();
        paramMutualMarkPullInfo.m = MutualMarkUtils.g(paramMutualMarkPullInfo.m);
      }
      if (paramResourceInfo.bytes_cartoon_url.has())
      {
        paramMutualMarkPullInfo.n = paramResourceInfo.bytes_cartoon_url.get().toStringUtf8();
        paramMutualMarkPullInfo.n = MutualMarkUtils.g(paramMutualMarkPullInfo.n);
      }
      if (paramResourceInfo.bytes_cartoon_md5.has()) {
        paramMutualMarkPullInfo.o = paramResourceInfo.bytes_cartoon_md5.get().toStringUtf8();
      }
      if (paramResourceInfo.bytes_word.has()) {
        paramMutualMarkPullInfo.p = paramResourceInfo.bytes_word.get().toStringUtf8();
      }
    }
  }
  
  private static void a(MutualMarkPullInfo paramMutualMarkPullInfo, mutualmark.ResourceInfo_17 paramResourceInfo_17)
  {
    if ((paramMutualMarkPullInfo != null) && (paramResourceInfo_17 != null))
    {
      if (paramResourceInfo_17.bytes_static_url.has())
      {
        paramMutualMarkPullInfo.l = paramResourceInfo_17.bytes_static_url.get().toStringUtf8();
        paramMutualMarkPullInfo.l = MutualMarkUtils.g(paramMutualMarkPullInfo.l);
      }
      if (paramResourceInfo_17.bytes_dynamic_url.has())
      {
        paramMutualMarkPullInfo.m = paramResourceInfo_17.bytes_dynamic_url.get().toStringUtf8();
        paramMutualMarkPullInfo.m = MutualMarkUtils.g(paramMutualMarkPullInfo.m);
      }
      if (paramResourceInfo_17.bytes_cartoon_url.has())
      {
        paramMutualMarkPullInfo.n = paramResourceInfo_17.bytes_cartoon_url.get().toStringUtf8();
        paramMutualMarkPullInfo.n = MutualMarkUtils.g(paramMutualMarkPullInfo.n);
      }
      if (paramResourceInfo_17.bytes_cartoon_md5.has()) {
        paramMutualMarkPullInfo.o = paramResourceInfo_17.bytes_cartoon_md5.get().toStringUtf8();
      }
      if (paramResourceInfo_17.bytes_word.has()) {
        paramMutualMarkPullInfo.p = paramResourceInfo_17.bytes_word.get().toStringUtf8();
      }
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkPullInfo{");
    localStringBuilder.append("type:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("level:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("count:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ");
    localStringBuilder.append("continue_days:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", ");
    localStringBuilder.append("last_action_time:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", ");
    localStringBuilder.append("last_change_time:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_status:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_status_end_time:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", ");
    localStringBuilder.append("sub_level:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_static_url:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_dynamic_url:");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_cartoon_url:");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_cartoon_md5:");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_name:");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", ");
    localStringBuilder.append("user_close_flag:");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", ");
    localStringBuilder.append("minVersion:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", ");
    localStringBuilder.append("maxVersion:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.info.MutualMarkPullInfo
 * JD-Core Version:    0.7.0.1
 */