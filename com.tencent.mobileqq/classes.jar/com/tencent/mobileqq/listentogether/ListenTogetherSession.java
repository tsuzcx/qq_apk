package com.tencent.mobileqq.listentogether;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.together.TogetherSession;
import java.util.ArrayList;
import java.util.List;

public class ListenTogetherSession
  extends TogetherSession
  implements Parcelable
{
  public static final Parcelable.Creator<ListenTogetherSession> CREATOR = new ListenTogetherSession.1();
  public List<MusicInfo> a;
  public boolean b;
  public String c;
  public int d;
  public String e;
  public int f;
  public boolean g;
  public boolean h;
  public boolean i;
  public int j;
  public int k;
  
  public ListenTogetherSession(int paramInt, String paramString)
  {
    this.b = false;
    this.h = false;
    this.i = false;
    this.j = 1;
    this.k = 0;
    this.l = 1;
    this.m = paramInt;
    this.n = paramString;
  }
  
  private ListenTogetherSession(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.b = false;
    this.h = false;
    this.i = false;
    this.j = 1;
    this.k = 0;
    this.l = paramParcel.readInt();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readString();
    this.p = paramParcel.readInt();
    this.a = new ArrayList();
    paramParcel.readTypedList(this.a, MusicInfo.CREATOR);
    this.t = paramParcel.readLong();
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    this.q = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.r = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    boolean bool1 = bool2;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    }
    this.g = bool1;
    this.j = paramParcel.readInt();
    this.x = paramParcel.readLong();
    this.s = paramParcel.readString();
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return ListenTogetherUtils.a(this.m, paramInt1, paramInt2);
  }
  
  public void a(ListenTogetherSession paramListenTogetherSession)
  {
    this.p = paramListenTogetherSession.p;
    this.q = paramListenTogetherSession.q;
    this.c = paramListenTogetherSession.c;
    this.r = paramListenTogetherSession.r;
    this.s = paramListenTogetherSession.s;
    this.d = paramListenTogetherSession.d;
    this.e = paramListenTogetherSession.e;
    this.g = paramListenTogetherSession.g;
    this.t = paramListenTogetherSession.t;
    this.a = paramListenTogetherSession.a;
    this.f = paramListenTogetherSession.f;
    this.h = paramListenTogetherSession.h;
    this.i = paramListenTogetherSession.i;
    this.j = paramListenTogetherSession.j;
    this.x = paramListenTogetherSession.x;
  }
  
  public int d()
  {
    if (this.m == 1) {
      return -1;
    }
    if (HardCodeUtil.a(2131891218).equals(this.c)) {
      return 3;
    }
    if (HardCodeUtil.a(2131891229).equals(this.c)) {
      return 2;
    }
    if (HardCodeUtil.a(2131891245).equals(this.c)) {
      return 1;
    }
    return 4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public MusicInfo e()
  {
    if (this.p == 3) {
      return null;
    }
    List localList = this.a;
    if ((localList != null) && (localList.size() > 0)) {
      return (MusicInfo)this.a.get(0);
    }
    return null;
  }
  
  public String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.m);
    localStringBuilder.append("_");
    localStringBuilder.append(this.n);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ListenTogetherSession{type=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", uin='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", musicList=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", timeStamp=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", fold=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", userState=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", joinedNum=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", creator='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", creatorNick='");
    String str;
    if (this.s == null) {
      str = "null";
    } else {
      str = this.s;
    }
    localStringBuilder.append(str);
    localStringBuilder.append('\'');
    localStringBuilder.append(", playMode='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", joinedType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", joinedUin='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", joinedIsCreator=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", themeId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", bAlowMemberStart=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", bAlowMemberAddSong=");
    localStringBuilder.append(this.i);
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
    paramParcel.writeInt(this.p);
    paramParcel.writeTypedList(this.a);
    paramParcel.writeLong(this.t);
    paramParcel.writeByte((byte)this.b);
    paramParcel.writeInt(this.q);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.r);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeInt(this.j);
    paramParcel.writeLong(this.x);
    paramParcel.writeString(this.s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherSession
 * JD-Core Version:    0.7.0.1
 */