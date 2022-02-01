package com.tencent.mobileqq.picbrowser;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PicInfo> CREATOR = new PicInfo.1();
  public int a = -1;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public PicInfo() {}
  
  public PicInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
  }
  
  public static List<PicInfo> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        PicInfo localPicInfo = new PicInfo();
        if (localJSONObject.has("photoId")) {
          localPicInfo.a = localJSONObject.getInt("photoId");
        }
        if (localJSONObject.has("localPath")) {
          localPicInfo.d = localJSONObject.getString("localPath");
        }
        if (localJSONObject.has("thumbUrl")) {
          localPicInfo.c = localJSONObject.getString("thumbUrl");
        }
        if (localJSONObject.has("bigPicUrl")) {
          localPicInfo.b = localJSONObject.getString("bigPicUrl");
        }
        if (localJSONObject.has("videoUrl")) {
          localPicInfo.e = localJSONObject.getString("videoUrl");
        }
        if (localJSONObject.has("videoLocalPath")) {
          localPicInfo.f = localJSONObject.getString("videoLocalPath");
        }
        if (localJSONObject.has("videoId")) {
          localPicInfo.g = localJSONObject.getString("videoId");
        }
        ((List)localObject).add(localPicInfo);
        i += 1;
      }
      return localObject;
    }
    catch (JSONException paramString)
    {
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("picInfo convertFrom exception : ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.i("Q.nearby_people_card.", 4, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("photoId", this.a);
      if (!TextUtils.isEmpty(this.d)) {
        localJSONObject.put("localPath", this.d);
      }
      if (!TextUtils.isEmpty(this.c)) {
        localJSONObject.put("thumbUrl", this.c);
      }
      if (!TextUtils.isEmpty(this.b)) {
        localJSONObject.put("bigPicUrl", this.b);
      }
      if (!TextUtils.isEmpty(this.e)) {
        localJSONObject.put("videoUrl", this.e);
      }
      if (!TextUtils.isEmpty(this.f)) {
        localJSONObject.put("videoLocalPath", this.f);
      }
      if (!TextUtils.isEmpty(this.g)) {
        localJSONObject.put("videoId", this.g);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("picInfo convert2Json exception : ");
        localStringBuilder.append(localJSONException.getMessage());
        QLog.i("Q.nearby_people_card.", 4, localStringBuilder.toString());
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
    localStringBuilder.append("photoId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",localPath:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" ,thumbUrl:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ,bigPicUrl:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ,videoUrl:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" ,videoLocalPath:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" ,videoId:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" ,picType:");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicInfo
 * JD-Core Version:    0.7.0.1
 */