package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class Comments
  implements Parcelable
{
  public static final Parcelable.Creator<Comments> CREATOR = new Comments.1();
  public long a;
  public boolean b;
  public List<Comments.Comment> c = new ArrayList();
  public List<Comments.Comment> d = new ArrayList();
  public Comments.LastDeleteInfo e = null;
  
  public Comments() {}
  
  public Comments(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.b = bool;
    paramParcel.readTypedList(this.c, Comments.Comment.CREATOR);
  }
  
  public boolean a(Comments.Comment paramComment)
  {
    return this.c.contains(paramComment);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
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
    paramParcel.writeLong(this.a);
    paramParcel.writeByte((byte)this.b);
    paramParcel.writeTypedList(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.Comments
 * JD-Core Version:    0.7.0.1
 */