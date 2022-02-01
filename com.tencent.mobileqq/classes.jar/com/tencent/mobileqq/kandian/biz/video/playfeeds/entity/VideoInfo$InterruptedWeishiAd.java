package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import java.util.Arrays;

public class VideoInfo$InterruptedWeishiAd
  implements Parcelable
{
  public static final Parcelable.Creator<InterruptedWeishiAd> CREATOR = new VideoInfo.InterruptedWeishiAd.1();
  public int[] a;
  public boolean b;
  public boolean c;
  public int d;
  public String e;
  public int f;
  public String g;
  public String h;
  public String i;
  public String j;
  public UrlJumpInfo k;
  
  public VideoInfo$InterruptedWeishiAd()
  {
    this.b = false;
    this.c = false;
    this.d = -1;
  }
  
  protected VideoInfo$InterruptedWeishiAd(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.b = false;
    this.c = false;
    this.d = -1;
    this.a = paramParcel.createIntArray();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.c = bool1;
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    int m = this.f;
    if (m == 0) {
      localObject = "弹出式web页面";
    } else if (m == 1) {
      localObject = HardCodeUtil.a(2131913485);
    } else {
      localObject = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InterruptedWeishiAd{showPositon=");
    localStringBuilder.append(Arrays.toString(this.a));
    localStringBuilder.append(", isShowInSwitch=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isShowInPlayEnd=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", showAfterPlayTime=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", adUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", downloadBtnText=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", openBtnText=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", appInfo=");
    Object localObject = this.k;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((UrlJumpInfo)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.a);
    paramParcel.writeByte((byte)this.b);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeParcelable(this.k, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.InterruptedWeishiAd
 * JD-Core Version:    0.7.0.1
 */