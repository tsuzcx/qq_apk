package com.tencent.mobileqq.phonecontact.data;

import SecurityAccountServer.RecommendedContactInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.HardCodeUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class RecommendContactInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RecommendContactInfo> CREATOR = new RecommendContactInfo.1();
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  
  public RecommendContactInfo()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
  }
  
  public RecommendContactInfo(RecommendedContactInfo paramRecommendedContactInfo)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = paramRecommendedContactInfo.age;
    this.jdField_b_of_type_Int = paramRecommendedContactInfo.sex;
    this.jdField_a_of_type_JavaLangString = paramRecommendedContactInfo.personalSign;
    this.jdField_c_of_type_Int = paramRecommendedContactInfo.eNetworkType;
    this.jdField_b_of_type_JavaLangString = paramRecommendedContactInfo.faceUrl;
    this.jdField_a_of_type_Long = paramRecommendedContactInfo.faceFlag;
  }
  
  public RecommendContactInfo(Parcel paramParcel)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mobile", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("name", this.d);
      localJSONObject.put("age", this.jdField_a_of_type_Int);
      localJSONObject.put("sex", this.jdField_b_of_type_Int);
      localJSONObject.put("signature", this.jdField_a_of_type_JavaLangString);
      String str;
      if (this.jdField_c_of_type_Int != 0) {
        str = HardCodeUtil.a(2131719230);
      } else {
        str = HardCodeUtil.a(2131719229);
      }
      localJSONObject.put("online", str);
      localJSONObject.put("url", this.e);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoginWelcomeContactInfo{age=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", sex=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", personalSign='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", eNetworkType=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", unicode='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.data.RecommendContactInfo
 * JD-Core Version:    0.7.0.1
 */