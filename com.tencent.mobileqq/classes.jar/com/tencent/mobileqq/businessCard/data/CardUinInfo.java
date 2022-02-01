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

public class CardUinInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardUinInfo> CREATOR = new CardUinInfo.1();
  public String a;
  public boolean a;
  public boolean b;
  
  public CardUinInfo() {}
  
  public CardUinInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    int i = paramParcel.readByte();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.b = bool1;
  }
  
  public static String a(List<CardUinInfo> paramList)
  {
    JSONArray localJSONArray1;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localJSONArray1 = new JSONArray();
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          CardUinInfo localCardUinInfo = (CardUinInfo)paramList.next();
          JSONArray localJSONArray2 = new JSONArray();
          localJSONArray2.put(0, localCardUinInfo.jdField_a_of_type_JavaLangString);
          localJSONArray2.put(1, localCardUinInfo.jdField_a_of_type_Boolean);
          localJSONArray2.put(2, localCardUinInfo.b);
          localJSONArray1.put(localJSONArray2);
        }
        return localJSONArray1.toString();
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
    }
    return "";
  }
  
  public static List<CardUinInfo> a(String paramString)
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
        CardUinInfo localCardUinInfo = new CardUinInfo();
        localCardUinInfo.jdField_a_of_type_JavaLangString = localJSONArray.getString(0);
        localCardUinInfo.jdField_a_of_type_Boolean = localJSONArray.getBoolean(1);
        localCardUinInfo.b = localJSONArray.getBoolean(2);
        localArrayList.add(localCardUinInfo);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard", 2, "unPackUinInfos has exception");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CardUinInfo{uin='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", isFriend='");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", isSearchable=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeByte((byte)this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.data.CardUinInfo
 * JD-Core Version:    0.7.0.1
 */