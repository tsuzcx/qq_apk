package com.tencent.mobileqq.comment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;

public class DanmuItemBean
  implements Parcelable
{
  public static final Parcelable.Creator<DanmuItemBean> CREATOR = new DanmuItemBean.1();
  public long a;
  public long b;
  public long c;
  public String d = "";
  public String e = "";
  public long f;
  public boolean g;
  public String h = "";
  public int i;
  
  public DanmuItemBean() {}
  
  public DanmuItemBean(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString1, String paramString2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.f = paramLong3;
    this.c = paramLong4;
    this.d = paramString1;
    this.e = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DanmuItemBean{commentUin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", commentSeq=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", createTime=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", location=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", content=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", nickName='");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", createTime=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", anonymousFlag=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", anonymousNick=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", anonymousHeadPortrait=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    for (;;)
    {
      try
      {
        paramParcel.writeLong(this.a);
        paramParcel.writeLong(this.b);
        paramParcel.writeLong(this.f);
        paramParcel.writeLong(this.c);
        paramParcel.writeString(this.d);
        paramParcel.writeString(this.e);
        if (this.g)
        {
          paramInt = 1;
          paramParcel.writeInt(paramInt);
          paramParcel.writeString(this.h);
          paramParcel.writeInt(this.i);
          return;
        }
      }
      catch (Exception paramParcel)
      {
        QLog.d("DanmuItemBean", 1, "writeToParcel failed, ", paramParcel);
        return;
      }
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuItemBean
 * JD-Core Version:    0.7.0.1
 */