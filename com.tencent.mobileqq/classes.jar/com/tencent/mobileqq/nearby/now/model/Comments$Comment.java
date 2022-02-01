package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Comments$Comment
  implements Parcelable
{
  public static final Parcelable.Creator<Comment> CREATOR = new Comments.Comment.1();
  public long a;
  public String b;
  public long c;
  public int d;
  public String e;
  public long f;
  public String g;
  public int h;
  public long i;
  public String j;
  public long k;
  public String l;
  public int m;
  public long n;
  public MedalInfo o;
  
  public Comments$Comment() {}
  
  public Comments$Comment(Parcel paramParcel)
  {
    this.o = ((MedalInfo)paramParcel.readParcelable(MedalInfo.class.getClassLoader()));
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readInt();
    this.f = paramParcel.readLong();
    this.e = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readLong();
    this.k = paramParcel.readLong();
    this.j = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return hashCode();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof Comment;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (Comment)paramObject;
      bool1 = bool2;
      if (this.a == paramObject.a) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return super.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.o, paramInt);
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.f);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeLong(this.i);
    paramParcel.writeLong(this.k);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeLong(this.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.Comments.Comment
 * JD-Core Version:    0.7.0.1
 */