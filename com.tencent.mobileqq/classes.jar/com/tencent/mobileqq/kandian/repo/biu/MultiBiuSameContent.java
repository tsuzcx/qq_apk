package com.tencent.mobileqq.kandian.repo.biu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import java.util.ArrayList;

public class MultiBiuSameContent
  implements Parcelable
{
  public static final Parcelable.Creator<MultiBiuSameContent> CREATOR = new MultiBiuSameContent.1();
  public long a;
  public String b;
  public int c;
  public int d;
  public long e;
  public int f;
  public int g;
  public long h;
  public ArrayList<BiuCommentInfo> i = new ArrayList();
  
  public MultiBiuSameContent() {}
  
  protected MultiBiuSameContent(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readLong();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readLong();
    this.i = paramParcel.createTypedArrayList(BiuCommentInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeLong(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeTypedList(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.biu.MultiBiuSameContent
 * JD-Core Version:    0.7.0.1
 */