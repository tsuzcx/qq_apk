package com.tencent.mobileqq.nearby.picbrowser;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import assb;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PicInfo> CREATOR = new assb();
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public PicInfo()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public PicInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
  }
  
  public static List<PicInfo> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ArrayList localArrayList;
    for (;;)
    {
      return null;
      localArrayList = new ArrayList();
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          PicInfo localPicInfo = new PicInfo();
          if (localJSONObject.has("photoId")) {
            localPicInfo.jdField_a_of_type_Int = localJSONObject.getInt("photoId");
          }
          if (localJSONObject.has("localPath")) {
            localPicInfo.c = localJSONObject.getString("localPath");
          }
          if (localJSONObject.has("thumbUrl")) {
            localPicInfo.b = localJSONObject.getString("thumbUrl");
          }
          if (localJSONObject.has("bigPicUrl")) {
            localPicInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("bigPicUrl");
          }
          if (localJSONObject.has("videoUrl")) {
            localPicInfo.d = localJSONObject.getString("videoUrl");
          }
          if (localJSONObject.has("videoLocalPath")) {
            localPicInfo.e = localJSONObject.getString("videoLocalPath");
          }
          if (localJSONObject.has("videoId")) {
            localPicInfo.f = localJSONObject.getString("videoId");
          }
          localArrayList.add(localPicInfo);
          i += 1;
        }
        if (!QLog.isDevelopLevel()) {}
      }
      catch (JSONException paramString) {}
    }
    QLog.i("Q.nearby_people_card.", 4, "picInfo convertFrom exception : " + paramString.getMessage());
    return null;
    return localArrayList;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("photoId", this.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(this.c)) {
        localJSONObject.put("localPath", this.c);
      }
      if (!TextUtils.isEmpty(this.b)) {
        localJSONObject.put("thumbUrl", this.b);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localJSONObject.put("bigPicUrl", this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.d)) {
        localJSONObject.put("videoUrl", this.d);
      }
      if (!TextUtils.isEmpty(this.e)) {
        localJSONObject.put("videoLocalPath", this.e);
      }
      if (!TextUtils.isEmpty(this.f)) {
        localJSONObject.put("videoId", this.f);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.nearby_people_card.", 4, "picInfo convert2Json exception : " + localJSONException.getMessage());
      }
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("photoId:").append(this.jdField_a_of_type_Int).append(",localPath:").append(this.c).append(" ,thumbUrl:").append(this.b).append(" ,bigPicUrl:").append(this.jdField_a_of_type_JavaLangString).append(" ,videoUrl:").append(this.d).append(" ,videoLocalPath:").append(this.e).append(" ,videoId:").append(this.f).append(" ,picType:").append(this.g);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicInfo
 * JD-Core Version:    0.7.0.1
 */