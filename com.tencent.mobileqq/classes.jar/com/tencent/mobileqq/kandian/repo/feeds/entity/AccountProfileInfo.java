package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.feeds_info.AccountProfile;

public class AccountProfileInfo
{
  public long a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public static AccountProfileInfo a(feeds_info.AccountProfile paramAccountProfile)
  {
    if (paramAccountProfile == null) {
      return null;
    }
    AccountProfileInfo localAccountProfileInfo = new AccountProfileInfo();
    localAccountProfileInfo.a = paramAccountProfile.uint64_uin.get();
    localAccountProfileInfo.b = paramAccountProfile.uint32_account_type.get();
    if (paramAccountProfile.bytes_desc.has()) {
      localAccountProfileInfo.e = paramAccountProfile.bytes_desc.get().toStringUtf8();
    }
    if (paramAccountProfile.bytes_profile_photo_url.has()) {
      localAccountProfileInfo.d = paramAccountProfile.bytes_profile_photo_url.get().toStringUtf8();
    }
    if (paramAccountProfile.bytes_nick.has()) {
      localAccountProfileInfo.c = paramAccountProfile.bytes_nick.get().toStringUtf8();
    }
    if (paramAccountProfile.bytes_home_page_url.has()) {
      localAccountProfileInfo.f = paramAccountProfile.bytes_home_page_url.get().toStringUtf8();
    }
    return localAccountProfileInfo;
  }
  
  public feeds_info.AccountProfile a()
  {
    feeds_info.AccountProfile localAccountProfile = new feeds_info.AccountProfile();
    if (!TextUtils.isEmpty(this.c)) {
      localAccountProfile.bytes_nick.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localAccountProfile.bytes_profile_photo_url.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    if (!TextUtils.isEmpty(this.e)) {
      localAccountProfile.bytes_desc.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    if (!TextUtils.isEmpty(this.f)) {
      localAccountProfile.bytes_home_page_url.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    localAccountProfile.uint32_account_type.set(this.b);
    localAccountProfile.uint64_uin.set(this.a);
    return localAccountProfile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.AccountProfileInfo
 * JD-Core Version:    0.7.0.1
 */