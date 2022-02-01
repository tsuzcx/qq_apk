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
  public int b;
  public String c;
  public int d;
  public String e = "";
  public long f = 0L;
  public String g;
  public String h;
  public String i;
  
  public RecommendContactInfo() {}
  
  public RecommendContactInfo(RecommendedContactInfo paramRecommendedContactInfo)
  {
    this.a = paramRecommendedContactInfo.age;
    this.b = paramRecommendedContactInfo.sex;
    this.c = paramRecommendedContactInfo.personalSign;
    this.d = paramRecommendedContactInfo.eNetworkType;
    this.e = paramRecommendedContactInfo.faceUrl;
    this.f = paramRecommendedContactInfo.faceFlag;
  }
  
  public RecommendContactInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mobile", this.g);
      localJSONObject.put("name", this.h);
      localJSONObject.put("age", this.a);
      localJSONObject.put("sex", this.b);
      localJSONObject.put("signature", this.c);
      String str;
      if (this.d != 0) {
        str = HardCodeUtil.a(2131916782);
      } else {
        str = HardCodeUtil.a(2131916781);
      }
      localJSONObject.put("online", str);
      localJSONObject.put("url", this.i);
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
    localStringBuilder.append(this.a);
    localStringBuilder.append(", sex=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", personalSign='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", eNetworkType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", unicode='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.data.RecommendContactInfo
 * JD-Core Version:    0.7.0.1
 */