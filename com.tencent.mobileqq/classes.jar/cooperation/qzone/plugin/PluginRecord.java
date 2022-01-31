package cooperation.qzone.plugin;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anep;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginRecord
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new anep();
  public float a;
  public int a;
  public long a;
  public String a;
  boolean a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j;
  public String k;
  
  public PluginRecord()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public PluginRecord(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.c = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.d = paramParcel.readString();
    this.i = paramParcel.readString();
  }
  
  public PluginRecord(PluginRecord paramPluginRecord)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramPluginRecord.jdField_a_of_type_Int;
    this.jdField_a_of_type_Float = paramPluginRecord.jdField_a_of_type_Float;
    this.jdField_a_of_type_JavaLangString = paramPluginRecord.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramPluginRecord.jdField_b_of_type_JavaLangString;
    this.c = paramPluginRecord.c;
    this.e = paramPluginRecord.e;
    this.f = paramPluginRecord.f;
    this.g = paramPluginRecord.g;
    this.h = paramPluginRecord.h;
    this.jdField_b_of_type_Int = paramPluginRecord.jdField_b_of_type_Int;
    this.jdField_a_of_type_Long = paramPluginRecord.jdField_a_of_type_Long;
    this.j = paramPluginRecord.j;
    this.k = paramPluginRecord.k;
    this.jdField_a_of_type_Boolean = paramPluginRecord.jdField_a_of_type_Boolean;
    this.d = paramPluginRecord.d;
    this.i = paramPluginRecord.i;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  protected PluginRecord a()
  {
    return new PluginRecord(this);
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", this.jdField_a_of_type_Int);
      localJSONObject.put("progress", this.jdField_a_of_type_Float);
      localJSONObject.put("url", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("app", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("ver", this.c);
      localJSONObject.put("name", this.e);
      localJSONObject.put("id", this.f);
      localJSONObject.put("mainVersion", this.g);
      localJSONObject.put("md5", this.h);
      localJSONObject.put("mProcesses", this.j);
      localJSONObject.put("mInstalledPath", this.k);
      localJSONObject.put("old_ver", this.d);
      localJSONObject.put("md5_2", this.i);
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "toJson :" + localJSONObject);
      }
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PluginRecord", 1, localJSONException, new Object[0]);
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginManger", 2, "fromJson :" + paramString);
      }
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Int = paramString.optInt("state");
      this.jdField_a_of_type_Float = ((float)paramString.optDouble("progress", 0.0D));
      this.jdField_a_of_type_JavaLangString = paramString.optString("url");
      this.jdField_b_of_type_JavaLangString = paramString.optString("app");
      this.c = paramString.optString("ver");
      this.e = paramString.optString("name");
      this.f = paramString.optString("id");
      this.g = paramString.optString("mainVersion");
      this.h = paramString.optString("md5");
      this.j = paramString.optString("mProcesses");
      this.k = paramString.optString("mInstalledPath");
      this.d = paramString.optString("old_ver");
      this.i = paramString.optString("md5_2");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof PluginRecord))) {}
    do
    {
      return false;
      paramObject = (PluginRecord)paramObject;
    } while ((this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) || (!a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!a(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) || (!a(this.c, paramObject.c)) || (!a(this.e, paramObject.e)) || (!a(this.f, paramObject.f)) || (!a(this.g, paramObject.g)) || (!a(this.h, paramObject.h)) || (!a(this.d, paramObject.d)) || (!a(this.i, paramObject.i)));
    return true;
  }
  
  public int hashCode()
  {
    int n = 0;
    int m;
    if (this.f == null)
    {
      m = 0;
      if (this.c != null) {
        break label40;
      }
    }
    for (;;)
    {
      return (m + 527) * 31 + n;
      m = this.f.hashCode();
      break;
      label40:
      n = this.c.hashCode();
    }
  }
  
  public String toString()
  {
    return "PluginRecord{" + this.f + " " + this.c + " " + this.jdField_a_of_type_Int + " }";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.d);
      paramParcel.writeString(this.i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.PluginRecord
 * JD-Core Version:    0.7.0.1
 */