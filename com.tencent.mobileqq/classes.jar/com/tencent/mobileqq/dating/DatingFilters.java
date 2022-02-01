package com.tencent.mobileqq.dating;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.UnsupportedEncodingException;

public class DatingFilters
  implements Parcelable
{
  public static final Parcelable.Creator<DatingFilters> CREATOR = new DatingFilters.1();
  public static final String[] a = { HardCodeUtil.a(2131900993), "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
  public static final int[] b = { 0, 22, 26, 35, 120 };
  public static final int[] c = { 0, 18, 23, 27, 36 };
  public static final String[] d = { HardCodeUtil.a(2131900991), HardCodeUtil.a(2131900997), HardCodeUtil.a(2131900996), HardCodeUtil.a(2131900994), HardCodeUtil.a(2131900992) };
  public static String[] e = { HardCodeUtil.a(2131900999), HardCodeUtil.a(2131901001), HardCodeUtil.a(2131900998), HardCodeUtil.a(2131900995), HardCodeUtil.a(2131900990), HardCodeUtil.a(2131901000) };
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k = 0;
  public appoint_define.LocaleInfo l = null;
  public int m;
  
  private DatingFilters(Parcel paramParcel)
  {
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.m = paramParcel.readInt();
    paramParcel = paramParcel.readString();
    if ((paramParcel != null) && (!paramParcel.equals(""))) {}
    try
    {
      appoint_define.LocaleInfo localLocaleInfo = new appoint_define.LocaleInfo();
      localLocaleInfo.mergeFrom(paramParcel.getBytes("ISO-8859-1"));
      this.l = localLocaleInfo;
      return;
    }
    catch (Exception paramParcel)
    {
      label116:
      break label116;
    }
    this.l = null;
    return;
    this.l = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (DatingFilters)paramObject;
    if (this.j != paramObject.j) {
      return false;
    }
    if (this.k != paramObject.k) {
      return false;
    }
    if (this.h != paramObject.h) {
      return false;
    }
    if (this.g != paramObject.g) {
      return false;
    }
    if (this.f != paramObject.f) {
      return false;
    }
    appoint_define.LocaleInfo localLocaleInfo1 = this.l;
    appoint_define.LocaleInfo localLocaleInfo2 = paramObject.l;
    return (localLocaleInfo1 == localLocaleInfo2) || ((localLocaleInfo1 != null) && (localLocaleInfo2 != null) && (localLocaleInfo1.str_name.get().equals(paramObject.l.str_name.get())));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DatingFilters [gender=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", datingTime=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", datingContent=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", age=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", career=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", dest=");
    Object localObject = this.l;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((appoint_define.LocaleInfo)localObject).str_name.get();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.m);
    try
    {
      String str;
      if (this.l == null) {
        str = "";
      } else {
        str = new String(this.l.toByteArray(), "ISO-8859-1");
      }
      paramParcel.writeString(str);
      return;
    }
    catch (UnsupportedEncodingException paramParcel)
    {
      paramParcel.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingFilters
 * JD-Core Version:    0.7.0.1
 */