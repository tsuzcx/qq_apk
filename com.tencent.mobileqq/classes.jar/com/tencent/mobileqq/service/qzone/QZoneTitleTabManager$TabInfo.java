package com.tencent.mobileqq.service.qzone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneTitleTabManager$TabInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TabInfo> CREATOR = new QZoneTitleTabManager.TabInfo.1();
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
  
  protected QZoneTitleTabManager$TabInfo(Parcel paramParcel)
  {
    boolean bool = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readInt();
    if (paramParcel.readByte() == 0) {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
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
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneTitleTabManager.TabInfo
 * JD-Core Version:    0.7.0.1
 */