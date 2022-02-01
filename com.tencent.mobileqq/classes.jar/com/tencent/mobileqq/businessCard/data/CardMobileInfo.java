package com.tencent.mobileqq.businessCard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class CardMobileInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardMobileInfo> CREATOR = new CardMobileInfo.1();
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public CardMobileInfo() {}
  
  public CardMobileInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.c = paramParcel.readString();
      this.d = paramParcel.readString();
      return;
    }
  }
  
  public static String a(List<CardMobileInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    localJSONArray1 = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CardMobileInfo localCardMobileInfo = (CardMobileInfo)paramList.next();
        JSONArray localJSONArray2 = new JSONArray();
        localJSONArray2.put(0, localCardMobileInfo.jdField_a_of_type_JavaLangString);
        localJSONArray2.put(1, localCardMobileInfo.d);
        localJSONArray2.put(2, localCardMobileInfo.jdField_a_of_type_Boolean);
        localJSONArray2.put(3, localCardMobileInfo.c);
        localJSONArray2.put(4, localCardMobileInfo.b);
        localJSONArray1.put(localJSONArray2);
      }
      return localJSONArray1.toString();
    }
    catch (JSONException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public static List<CardMobileInfo> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        JSONArray localJSONArray = (JSONArray)paramString.get(i);
        CardMobileInfo localCardMobileInfo = new CardMobileInfo();
        localCardMobileInfo.jdField_a_of_type_JavaLangString = ((String)localJSONArray.get(0));
        localCardMobileInfo.d = localJSONArray.getString(1);
        localCardMobileInfo.jdField_a_of_type_Boolean = localJSONArray.getBoolean(2);
        localCardMobileInfo.c = localJSONArray.getString(3);
        localCardMobileInfo.b = ((String)localJSONArray.get(4));
        localArrayList.add(localCardMobileInfo);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard", 2, "unPackMoblieInfos has exception");
      }
      paramString.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "CardMobileInfo{, isFriend=" + this.jdField_a_of_type_Boolean + "bindqq='" + this.b + ",nickName=" + this.c + ", mobile='" + this.jdField_a_of_type_JavaLangString + ",format= " + this.d + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.c);
      paramParcel.writeString(this.d);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.data.CardMobileInfo
 * JD-Core Version:    0.7.0.1
 */