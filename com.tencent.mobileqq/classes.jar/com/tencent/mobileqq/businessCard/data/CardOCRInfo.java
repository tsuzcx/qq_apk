package com.tencent.mobileqq.businessCard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class CardOCRInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardOCRInfo> CREATOR = new CardOCRInfo.1();
  public String a;
  public String b;
  public List<String> c = new ArrayList();
  public List<String> d = new ArrayList();
  public float e;
  public float f;
  public float g;
  public int h;
  public String i;
  public String j;
  
  public CardOCRInfo() {}
  
  public CardOCRInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    paramParcel.readList(this.c, getClass().getClassLoader());
    paramParcel.readList(this.d, getClass().getClassLoader());
    this.e = paramParcel.readFloat();
    this.f = paramParcel.readFloat();
    this.g = paramParcel.readFloat();
  }
  
  public static CardOCRInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    CardOCRInfo localCardOCRInfo = new CardOCRInfo();
    try
    {
      paramString = new JSONArray(paramString);
      localCardOCRInfo.a = paramString.getString(0);
      localCardOCRInfo.b = paramString.getString(1);
      localCardOCRInfo.c = BusinessCard.unPack(paramString.getString(2));
      localCardOCRInfo.d = BusinessCard.unPack(paramString.getString(3));
      return localCardOCRInfo;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard", 2, "unPackOCRInfo has exception");
      }
      paramString.printStackTrace();
    }
    return localCardOCRInfo;
  }
  
  public static String a(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo == null) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONArray.put(0, paramCardOCRInfo.a);
      localJSONArray.put(1, paramCardOCRInfo.b);
      localJSONArray.put(2, BusinessCard.pack(paramCardOCRInfo.c));
      localJSONArray.put(3, BusinessCard.pack(paramCardOCRInfo.d));
    }
    catch (JSONException paramCardOCRInfo)
    {
      paramCardOCRInfo.printStackTrace();
    }
    return localJSONArray.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("erroCode: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" errMsg: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" uincon:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" phone: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" phoneConfidence: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" name:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" nameConfidence:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" imgUrl:");
    localStringBuilder.append(this.j);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeList(this.c);
    paramParcel.writeList(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeFloat(this.f);
    paramParcel.writeFloat(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.data.CardOCRInfo
 * JD-Core Version:    0.7.0.1
 */