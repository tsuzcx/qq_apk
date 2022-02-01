package com.tencent.mobileqq.kandian.repo.feeds;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ArkAppFeedsInfo;

public class ArkAppFeedsInfo
  implements Cloneable
{
  public long a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public static ArkAppFeedsInfo a(articlesummary.ArkAppFeedsInfo paramArkAppFeedsInfo)
  {
    if (paramArkAppFeedsInfo == null)
    {
      QLog.d("ArkAppFeedsInfo", 1, "covertPBToInfo feedsInfo == null");
      return null;
    }
    ArkAppFeedsInfo localArkAppFeedsInfo = new ArkAppFeedsInfo();
    long l;
    if (paramArkAppFeedsInfo.uint64_feeds_id.has()) {
      l = paramArkAppFeedsInfo.uint64_feeds_id.get();
    } else {
      l = 0L;
    }
    localArkAppFeedsInfo.a = l;
    int i;
    if (paramArkAppFeedsInfo.uint32_feeds_style.has()) {
      i = paramArkAppFeedsInfo.uint32_feeds_style.get();
    } else {
      i = 0;
    }
    localArkAppFeedsInfo.b = i;
    boolean bool = paramArkAppFeedsInfo.bytes_app_name.has();
    String str2 = "";
    if ((bool) && (paramArkAppFeedsInfo.bytes_app_name.get() != null)) {
      str1 = paramArkAppFeedsInfo.bytes_app_name.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localArkAppFeedsInfo.c = str1;
    if ((paramArkAppFeedsInfo.bytes_app_view.has()) && (paramArkAppFeedsInfo.bytes_app_view.get() != null)) {
      str1 = paramArkAppFeedsInfo.bytes_app_view.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localArkAppFeedsInfo.d = str1;
    if ((paramArkAppFeedsInfo.bytes_app_desc.has()) && (paramArkAppFeedsInfo.bytes_app_desc.get() != null)) {
      str1 = paramArkAppFeedsInfo.bytes_app_desc.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localArkAppFeedsInfo.e = str1;
    if ((paramArkAppFeedsInfo.bytes_app_prompt.has()) && (paramArkAppFeedsInfo.bytes_app_prompt.get() != null)) {
      str1 = paramArkAppFeedsInfo.bytes_app_prompt.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localArkAppFeedsInfo.f = str1;
    if ((paramArkAppFeedsInfo.bytes_app_ver.has()) && (paramArkAppFeedsInfo.bytes_app_ver.get() != null)) {
      str1 = paramArkAppFeedsInfo.bytes_app_ver.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localArkAppFeedsInfo.g = str1;
    String str1 = str2;
    if (paramArkAppFeedsInfo.bytes_app_meta.has())
    {
      str1 = str2;
      if (paramArkAppFeedsInfo.bytes_app_meta.get() != null) {
        str1 = paramArkAppFeedsInfo.bytes_app_meta.get().toStringUtf8();
      }
    }
    localArkAppFeedsInfo.h = str1;
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppFeedsInfo", 2, new Object[] { "mFeedsId: ", Long.valueOf(localArkAppFeedsInfo.a), ", mFeedsStyle: ", Integer.valueOf(localArkAppFeedsInfo.b), ", appName: ", localArkAppFeedsInfo.c, ", appView: ", localArkAppFeedsInfo.d, ", appMinVersion: ", localArkAppFeedsInfo.g, ", metaList: ", localArkAppFeedsInfo.h });
    }
    return localArkAppFeedsInfo;
  }
  
  public ArkAppFeedsInfo a()
  {
    try
    {
      ArkAppFeedsInfo localArkAppFeedsInfo = (ArkAppFeedsInfo)super.clone();
      return localArkAppFeedsInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppFeedsInfo", 2, new Object[] { "Clone not support: ", localCloneNotSupportedException.toString() });
      }
    }
    return null;
  }
  
  public articlesummary.ArkAppFeedsInfo b()
  {
    articlesummary.ArkAppFeedsInfo localArkAppFeedsInfo = new articlesummary.ArkAppFeedsInfo();
    localArkAppFeedsInfo.uint32_feeds_style.set(this.b);
    localArkAppFeedsInfo.uint64_feeds_id.set(this.a);
    if (!TextUtils.isEmpty(this.c)) {
      localArkAppFeedsInfo.bytes_app_name.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localArkAppFeedsInfo.bytes_app_view.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    if (!TextUtils.isEmpty(this.e)) {
      localArkAppFeedsInfo.bytes_app_desc.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    if (!TextUtils.isEmpty(this.f)) {
      localArkAppFeedsInfo.bytes_app_prompt.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    if (!TextUtils.isEmpty(this.g)) {
      localArkAppFeedsInfo.bytes_app_ver.set(ByteStringMicro.copyFromUtf8(this.g));
    }
    if (!TextUtils.isEmpty(this.h)) {
      localArkAppFeedsInfo.bytes_app_meta.set(ByteStringMicro.copyFromUtf8(this.h));
    }
    return localArkAppFeedsInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArkAppFeedsInfo
 * JD-Core Version:    0.7.0.1
 */