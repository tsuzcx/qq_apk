package dov.com.qq.im.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import boie;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class LockedCategory
  implements Parcelable
{
  public static final Parcelable.Creator<LockedCategory> CREATOR = new boie();
  public int a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  private String d;
  
  public LockedCategory(Parcel paramParcel)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public LockedCategory(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("comboId");
    this.b = paramJSONObject.optString("introduceUrl");
    this.c = paramJSONObject.optString("backgroundUrl");
    this.d = paramJSONObject.optString("expire_date");
    this.jdField_a_of_type_Int = paramJSONObject.optInt("unlock_type", 1);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    try
    {
      boolean bool = new Date(NetConnInfoCenter.getServerTimeMillis()).after(localSimpleDateFormat.parse(this.d.toString()));
      if (!bool) {
        break label41;
      }
    }
    catch (ParseException localParseException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("LockedCategory", 2, localParseException, new Object[0]);
    }
    return true;
    label41:
    return false;
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LockedCategory").append(":").append(this.jdField_a_of_type_JavaLangString).append(",");
    localStringBuilder.append(this.jdField_a_of_type_Int).append(",").append(this.d).append(",").append(this.b).append(",");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.data.LockedCategory
 * JD-Core Version:    0.7.0.1
 */