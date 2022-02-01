package com.tencent.mobileqq.mediafocus;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaFocusStackItem
  implements Parcelable
{
  public static final Parcelable.Creator<MediaFocusStackItem> CREATOR = new MediaFocusStackItem.1();
  private int a;
  private long b;
  private String c;
  private String d;
  
  public MediaFocusStackItem(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.b = paramLong;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  protected MediaFocusStackItem(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaFocusStackItem{type='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", time='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", id='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pname='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusStackItem
 * JD-Core Version:    0.7.0.1
 */