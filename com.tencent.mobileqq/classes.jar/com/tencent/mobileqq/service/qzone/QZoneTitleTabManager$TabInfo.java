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
  public String b;
  public boolean c;
  public int d;
  public int e;
  public String f;
  
  public QZoneTitleTabManager$TabInfo()
  {
    this.c = true;
  }
  
  public QZoneTitleTabManager$TabInfo(int paramInt, String paramString)
  {
    this.c = true;
    this.a = paramInt;
    this.b = paramString;
  }
  
  protected QZoneTitleTabManager$TabInfo(Parcel paramParcel)
  {
    boolean bool = true;
    this.c = true;
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    if (paramParcel.readByte() == 0) {
      bool = false;
    }
    this.c = bool;
    this.f = paramParcel.readString();
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id", this.a);
    localJSONObject.put("name", this.b);
    localJSONObject.put("actionType", this.d);
    localJSONObject.put("subActionType", this.e);
    localJSONObject.put("rememberAnchor", this.c);
    localJSONObject.put("url", this.f);
    return localJSONObject;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("id");
    this.b = paramJSONObject.optString("name");
    this.d = paramJSONObject.optInt("actionType", -1);
    this.e = paramJSONObject.optInt("subActionType", -1);
    this.c = paramJSONObject.optBoolean("rememberAnchor", false);
    this.f = paramJSONObject.optString("url");
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
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeByte((byte)this.c);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneTitleTabManager.TabInfo
 * JD-Core Version:    0.7.0.1
 */