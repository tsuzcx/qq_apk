package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.qphone.base.util.BaseApplication;

public class WatchTogetherSession
  extends TogetherSession
  implements Parcelable
{
  public static final Parcelable.Creator<WatchTogetherSession> CREATOR = new WatchTogetherSession.1();
  public int a = 0;
  public String b = "";
  public long c;
  public String d;
  public String e = "";
  
  protected WatchTogetherSession(Parcel paramParcel)
  {
    this.l = paramParcel.readInt();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readString();
    this.o = paramParcel.readInt();
    this.p = paramParcel.readInt();
    this.q = paramParcel.readInt();
    this.r = paramParcel.readString();
    this.t = paramParcel.readLong();
    this.u = paramParcel.readInt();
    this.v = paramParcel.readInt();
    this.w = paramParcel.readString();
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.x = paramParcel.readLong();
  }
  
  public WatchTogetherSession(String paramString)
  {
    this.l = 2;
    this.m = 1;
    this.n = paramString;
  }
  
  public String a()
  {
    return this.e;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (this.u == 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQAppInterface.getApp().getString(2131897475));
      localStringBuilder.append(this.d);
      return localStringBuilder.toString();
    }
    return this.d;
  }
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean) {
      return paramQQAppInterface.getApp().getString(2131897467);
    }
    return a(paramQQAppInterface, 2131897479, 2131897477, 2131897474);
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, 2131897478, 2131897476);
  }
  
  public int c()
  {
    return 2130846274;
  }
  
  protected Object clone()
  {
    WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)super.clone();
    localWatchTogetherSession.l = this.l;
    localWatchTogetherSession.m = this.m;
    localWatchTogetherSession.n = this.n;
    localWatchTogetherSession.o = this.o;
    localWatchTogetherSession.p = this.p;
    localWatchTogetherSession.q = this.q;
    localWatchTogetherSession.r = this.r;
    localWatchTogetherSession.t = this.t;
    localWatchTogetherSession.u = this.u;
    localWatchTogetherSession.v = this.v;
    localWatchTogetherSession.w = this.w;
    localWatchTogetherSession.a = this.a;
    localWatchTogetherSession.b = this.b;
    localWatchTogetherSession.c = this.c;
    localWatchTogetherSession.d = this.d;
    localWatchTogetherSession.e = this.e;
    localWatchTogetherSession.x = this.x;
    return localWatchTogetherSession;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WatchTogetherSession{roomType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", jumpurl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roomId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", roomName='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roomCover='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serviceType=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", uin='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", joinNum=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", userState=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", creator='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", timeStamp=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", videoType=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", videoJumpType=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", videoJumpURL='");
    localStringBuilder.append(this.w);
    localStringBuilder.append('\'');
    localStringBuilder.append(", identifyId=");
    localStringBuilder.append(this.x);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeInt(this.o);
    paramParcel.writeInt(this.p);
    paramParcel.writeInt(this.q);
    paramParcel.writeString(this.r);
    paramParcel.writeLong(this.t);
    paramParcel.writeInt(this.u);
    paramParcel.writeInt(this.v);
    paramParcel.writeString(this.w);
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeLong(this.x);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession
 * JD-Core Version:    0.7.0.1
 */