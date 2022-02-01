package com.tencent.mobileqq.businessCard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aqaf;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class CardUinInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardUinInfo> CREATOR = new aqaf();
  public String a;
  public boolean a;
  public boolean b;
  
  public CardUinInfo() {}
  
  public CardUinInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label48;
      }
    }
    label48:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.b = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static String a(List<CardUinInfo> paramList)
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
    return "CardUinInfo{uin='" + this.jdField_a_of_type_JavaLangString + ", isFriend='" + this.jdField_a_of_type_Boolean + ", isSearchable=" + this.b + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.b) {
        break label46;
      }
    }
    label46:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.data.CardUinInfo
 * JD-Core Version:    0.7.0.1
 */