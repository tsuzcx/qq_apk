package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;

public class UrlJumpInfo
  implements Parcelable
{
  public static final Parcelable.Creator<UrlJumpInfo> CREATOR = new UrlJumpInfo.1();
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public UrlJumpInfo() {}
  
  protected UrlJumpInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
  }
  
  @NonNull
  public static UrlJumpInfo a(articlesummary.UrlJumpInfo paramUrlJumpInfo)
  {
    UrlJumpInfo localUrlJumpInfo = new UrlJumpInfo();
    if ((paramUrlJumpInfo != null) && (paramUrlJumpInfo.has()) && (paramUrlJumpInfo.get() != null))
    {
      int i;
      if (paramUrlJumpInfo.uint32_jump_type.has()) {
        i = paramUrlJumpInfo.uint32_jump_type.get();
      } else {
        i = 0;
      }
      localUrlJumpInfo.a = i;
      localUrlJumpInfo.d = RIJPBFieldUtils.d(paramUrlJumpInfo.bytes_jump_schema);
      localUrlJumpInfo.c = RIJPBFieldUtils.d(paramUrlJumpInfo.bytes_jump_bundle);
      localUrlJumpInfo.b = RIJPBFieldUtils.d(paramUrlJumpInfo.bytes_jump_url);
      localUrlJumpInfo.e = RIJPBFieldUtils.d(paramUrlJumpInfo.bytes_clipboard_info);
      localUrlJumpInfo.f = RIJPBFieldUtils.d(paramUrlJumpInfo.bytes_common_data);
    }
    return localUrlJumpInfo;
  }
  
  public articlesummary.UrlJumpInfo a()
  {
    articlesummary.UrlJumpInfo localUrlJumpInfo = new articlesummary.UrlJumpInfo();
    localUrlJumpInfo.uint32_jump_type.set(this.a);
    if (!TextUtils.isEmpty(this.b)) {
      localUrlJumpInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    if (!TextUtils.isEmpty(this.c)) {
      localUrlJumpInfo.bytes_jump_bundle.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localUrlJumpInfo.bytes_jump_schema.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    if (!TextUtils.isEmpty(this.e)) {
      localUrlJumpInfo.bytes_clipboard_info.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    if (!TextUtils.isEmpty(this.f)) {
      localUrlJumpInfo.bytes_common_data.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    return localUrlJumpInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UrlJumpInfo{jumpType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpBundle='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpSchema='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clipboardInfo='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commonData='");
    localStringBuilder.append(this.f);
    localStringBuilder.append("'");
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo
 * JD-Core Version:    0.7.0.1
 */