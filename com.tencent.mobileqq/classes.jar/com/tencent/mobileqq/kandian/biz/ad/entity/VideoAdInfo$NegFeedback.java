package com.tencent.mobileqq.kandian.biz.ad.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.NegFeedback;

public class VideoAdInfo$NegFeedback
  implements Parcelable
{
  public static final Parcelable.Creator<NegFeedback> CREATOR = new VideoAdInfo.NegFeedback.1();
  public long a;
  public String b;
  
  public VideoAdInfo$NegFeedback() {}
  
  protected VideoAdInfo$NegFeedback(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
  }
  
  public VideoAdInfo$NegFeedback(oidb_0x6cf.NegFeedback paramNegFeedback)
  {
    this.a = paramNegFeedback.uint64_type_id.get();
    this.b = paramNegFeedback.bytes_type_desc.get().toStringUtf8();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo.NegFeedback
 * JD-Core Version:    0.7.0.1
 */