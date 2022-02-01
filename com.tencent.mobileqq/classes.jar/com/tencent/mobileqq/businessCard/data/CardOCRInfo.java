package com.tencent.mobileqq.businessCard.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aqkt;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class CardOCRInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardOCRInfo> CREATOR = new aqkt();
  public float a;
  public int a;
  public String a;
  public List<String> a;
  public float b;
  public String b;
  public List<String> b;
  public float c;
  public String c;
  public String d;
  
  public CardOCRInfo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public CardOCRInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    paramParcel.readList(this.jdField_a_of_type_JavaUtilList, getClass().getClassLoader());
    paramParcel.readList(this.jdField_b_of_type_JavaUtilList, getClass().getClassLoader());
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_b_of_type_Float = paramParcel.readFloat();
    this.jdField_c_of_type_Float = paramParcel.readFloat();
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
      localCardOCRInfo.jdField_a_of_type_JavaLangString = paramString.getString(0);
      localCardOCRInfo.jdField_b_of_type_JavaLangString = paramString.getString(1);
      localCardOCRInfo.jdField_a_of_type_JavaUtilList = BusinessCard.unPack(paramString.getString(2));
      localCardOCRInfo.jdField_b_of_type_JavaUtilList = BusinessCard.unPack(paramString.getString(3));
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
      localJSONArray.put(0, paramCardOCRInfo.jdField_a_of_type_JavaLangString);
      localJSONArray.put(1, paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      localJSONArray.put(2, BusinessCard.pack(paramCardOCRInfo.jdField_a_of_type_JavaUtilList));
      localJSONArray.put(3, BusinessCard.pack(paramCardOCRInfo.jdField_b_of_type_JavaUtilList));
      return localJSONArray.toString();
    }
    catch (JSONException paramCardOCRInfo)
    {
      for (;;)
      {
        paramCardOCRInfo.printStackTrace();
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "erroCode: " + this.jdField_a_of_type_Int + " errMsg: " + this.jdField_c_of_type_JavaLangString + " uin:" + this.jdField_a_of_type_JavaUtilList + " uincon:" + this.jdField_b_of_type_Float + " phone: " + this.jdField_b_of_type_JavaUtilList + " phoneConfidence: " + this.jdField_c_of_type_Float + " name:" + this.jdField_a_of_type_JavaLangString + " nameConfidence:" + this.jdField_a_of_type_Float + " imgUrl:" + this.d;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeList(this.jdField_b_of_type_JavaUtilList);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeFloat(this.jdField_b_of_type_Float);
    paramParcel.writeFloat(this.jdField_c_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.data.CardOCRInfo
 * JD-Core Version:    0.7.0.1
 */