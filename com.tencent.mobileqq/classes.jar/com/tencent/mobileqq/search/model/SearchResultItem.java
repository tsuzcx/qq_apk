package com.tencent.mobileqq.search.model;

import addcontacts.AccountSearchPb.record;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class SearchResultItem
  implements Parcelable
{
  public static final Parcelable.Creator<SearchResultItem> CREATOR = new SearchResultItem.1();
  public long a = 0L;
  public int b = 0;
  public String c = "";
  public String d = "";
  public byte e = 0;
  public byte f = 0;
  public byte g = 0;
  public byte[] h = null;
  public byte[] i = null;
  
  public SearchResultItem() {}
  
  public SearchResultItem(AccountSearchPb.record paramrecord)
  {
    if (paramrecord != null)
    {
      this.a = paramrecord.uin.get();
      this.b = paramrecord.source.get();
      this.c = paramrecord.name.get();
      this.d = paramrecord.mobile.get();
      this.e = ((byte)(int)(paramrecord.relation.get() & 1L));
      this.f = ((byte)(int)(paramrecord.relation.get() & 0x2));
      this.i = paramrecord.bytes_token.get().toByteArray();
    }
  }
  
  protected SearchResultItem(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readByte();
    this.f = paramParcel.readByte();
    this.g = paramParcel.readByte();
    this.h = paramParcel.createByteArray();
    this.i = paramParcel.createByteArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeByte(this.e);
    paramParcel.writeByte(this.f);
    paramParcel.writeByte(this.g);
    paramParcel.writeByteArray(this.h);
    paramParcel.writeByteArray(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.SearchResultItem
 * JD-Core Version:    0.7.0.1
 */