package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.ktx.PBFieldUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.feeds_info.IconWordingInfo;

public class IconWordingInfo
{
  public int a;
  public String b;
  public String c;
  public String d;
  public int e;
  public String f;
  public int g;
  
  public static IconWordingInfo a(feeds_info.IconWordingInfo paramIconWordingInfo)
  {
    IconWordingInfo localIconWordingInfo = new IconWordingInfo();
    localIconWordingInfo.a = PBFieldUtils.a(paramIconWordingInfo.uint32_type);
    if (paramIconWordingInfo.bytes_icon_url.has()) {
      localIconWordingInfo.b = paramIconWordingInfo.bytes_icon_url.get().toStringUtf8();
    }
    if (paramIconWordingInfo.bytes_wording.has()) {
      localIconWordingInfo.c = paramIconWordingInfo.bytes_wording.get().toStringUtf8();
    }
    if (paramIconWordingInfo.bytes_status_icon_url.has()) {
      localIconWordingInfo.d = paramIconWordingInfo.bytes_status_icon_url.get().toStringUtf8();
    }
    localIconWordingInfo.e = PBFieldUtils.a(paramIconWordingInfo.uint32_status);
    if (paramIconWordingInfo.bytes_status.has()) {
      localIconWordingInfo.f = paramIconWordingInfo.bytes_status.get().toStringUtf8();
    }
    localIconWordingInfo.g = PBFieldUtils.a(paramIconWordingInfo.uint32_icon_show_mode);
    return localIconWordingInfo;
  }
  
  public feeds_info.IconWordingInfo a()
  {
    feeds_info.IconWordingInfo localIconWordingInfo = new feeds_info.IconWordingInfo();
    localIconWordingInfo.uint32_type.set(this.a);
    if (!TextUtils.isEmpty(this.b)) {
      localIconWordingInfo.bytes_icon_url.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    if (!TextUtils.isEmpty(this.c)) {
      localIconWordingInfo.bytes_wording.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localIconWordingInfo.bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    localIconWordingInfo.uint32_status.set(this.e);
    localIconWordingInfo.uint32_icon_show_mode.set(this.g);
    if (!TextUtils.isEmpty(this.f)) {
      localIconWordingInfo.bytes_status.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    return localIconWordingInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.IconWordingInfo
 * JD-Core Version:    0.7.0.1
 */