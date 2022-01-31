package com.tencent.mobileqq.service.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import azav;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneTitleTabManager$TabInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TabInfo> CREATOR = new azav();
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  
  public QZoneTitleTabManager$TabInfo()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public QZoneTitleTabManager$TabInfo(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public QZoneTitleTabManager$TabInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_JavaLangString = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id", this.jdField_a_of_type_Int);
    localJSONObject.put("name", this.jdField_a_of_type_JavaLangString);
    localJSONObject.put("actionType", this.jdField_b_of_type_Int);
    localJSONObject.put("subActionType", this.c);
    localJSONObject.put("rememberAnchor", this.jdField_a_of_type_Boolean);
    localJSONObject.put("url", this.jdField_b_of_type_JavaLangString);
    return localJSONObject;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = paramJSONObject.optInt("id");
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("actionType", -1);
    this.c = paramJSONObject.optInt("subActionType", -1);
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("rememberAnchor", false);
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("url");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    try
    {
      String str = a().toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneTitleTabManager", 2, "", localJSONException);
      }
    }
    return "";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.c);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneTitleTabManager.TabInfo
 * JD-Core Version:    0.7.0.1
 */