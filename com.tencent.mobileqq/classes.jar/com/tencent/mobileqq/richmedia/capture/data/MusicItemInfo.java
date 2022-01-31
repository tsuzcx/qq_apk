package com.tencent.mobileqq.richmedia.capture.data;

import ahml;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.Utils;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import org.json.JSONObject;

public class MusicItemInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ahml();
  public float a;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  private String g;
  
  public MusicItemInfo()
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public MusicItemInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_Int = paramParcel.readInt();
      this.jdField_f_of_type_JavaLangString = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public MusicItemInfo(String paramString)
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    paramString = new JSONObject(paramString);
    this.jdField_a_of_type_JavaLangString = paramString.optString("title");
    this.jdField_c_of_type_JavaLangString = paramString.optString("audio_url");
    this.jdField_b_of_type_JavaLangString = paramString.optString("author");
    this.jdField_a_of_type_Int = paramString.optInt("item_id");
    if (paramString.has("type")) {}
    for (this.jdField_d_of_type_Int = paramString.optInt("type");; this.jdField_d_of_type_Int = 1)
    {
      this.jdField_f_of_type_JavaLangString = paramString.optString("jump_ws");
      return;
    }
  }
  
  public MusicItemInfo(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 5;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_e_of_type_JavaLangString = paramString4;
    this.jdField_e_of_type_Int = paramInt2;
    this.jdField_f_of_type_Int = paramInt3;
    this.jdField_g_of_type_Int = paramInt4;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public MusicItemInfo(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    try
    {
      if (paramJSONObject.has("mMusicName")) {
        this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("mMusicName");
      }
      if (paramJSONObject.has("mSingername")) {
        this.jdField_b_of_type_JavaLangString = paramJSONObject.getString("mSingername");
      }
      if (paramJSONObject.has("mUrl")) {
        this.jdField_c_of_type_JavaLangString = paramJSONObject.getString("mUrl");
      }
      if (paramJSONObject.has("mTagName")) {
        this.jdField_d_of_type_JavaLangString = paramJSONObject.getString("mTagName");
      }
      if (paramJSONObject.has("mPath")) {
        this.jdField_g_of_type_JavaLangString = paramJSONObject.getString("mPath");
      }
      this.jdField_a_of_type_Int = paramJSONObject.getInt("mItemId");
      this.jdField_d_of_type_Int = paramJSONObject.getInt("mType");
      this.jdField_e_of_type_Int = paramJSONObject.getInt("musicStart");
      this.jdField_f_of_type_Int = paramJSONObject.getInt("musicEnd");
      this.jdField_g_of_type_Int = paramJSONObject.getInt("musicDuration");
      if (paramJSONObject.has("mSongMid")) {
        this.jdField_e_of_type_JavaLangString = paramJSONObject.getString("mSongMid");
      }
      this.jdField_a_of_type_Float = ((float)paramJSONObject.getDouble("mRecognitionOffset"));
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("mHasCopyright");
      this.jdField_b_of_type_Int = paramJSONObject.getInt("mAccuracy");
      if (paramJSONObject.has("jump_ws")) {
        this.jdField_f_of_type_JavaLangString = paramJSONObject.getString("jump_ws");
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  private String b()
  {
    if (this.jdField_d_of_type_Int == 5) {
      for (String str1 = ".mp3";; str2 = ".mp3")
      {
        try
        {
          int i = this.jdField_c_of_type_JavaLangString.indexOf(".m4a");
          if (i >= 0) {}
          if (!SLog.a()) {
            break label114;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            str1 = this.jdField_c_of_type_JavaLangString.substring(i, i + 4);
            if (SLog.a()) {
              SLog.d("MusicItemInfo", "getMusicSuffix " + str1 + " vIndex=" + i);
            }
            return str1;
          }
          catch (Exception localException2)
          {
            String str2;
            break label81;
          }
          localException1 = localException1;
          i = -1;
        }
        label81:
        SLog.d("MusicItemInfo", "getMusicSuffix e:" + localException1.toString());
        label114:
        if (SLog.a()) {
          SLog.d("MusicItemInfo", "getMusicSuffix e:" + localException1.toString());
        }
      }
    } else {
      return ".mp3";
    }
  }
  
  public MusicItemInfo a()
  {
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localMusicItemInfo.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localMusicItemInfo.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localMusicItemInfo.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localMusicItemInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localMusicItemInfo.jdField_d_of_type_Int = this.jdField_d_of_type_Int;
    localMusicItemInfo.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
    localMusicItemInfo.jdField_f_of_type_Int = this.jdField_f_of_type_Int;
    localMusicItemInfo.jdField_g_of_type_Int = this.jdField_g_of_type_Int;
    localMusicItemInfo.jdField_e_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    localMusicItemInfo.jdField_g_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
    localMusicItemInfo.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    localMusicItemInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localMusicItemInfo.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localMusicItemInfo.jdField_f_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    return localMusicItemInfo;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder(SdkContext.a().a().a().a());
      if ((this.jdField_d_of_type_Int == 5) && (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
      {
        this.jdField_g_of_type_JavaLangString = null;
        return this.jdField_g_of_type_JavaLangString;
      }
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        localStringBuilder.append(Utils.a(this.jdField_c_of_type_JavaLangString)).append("_").append(this.jdField_a_of_type_JavaLangString.hashCode()).append(b());
      }
      this.jdField_g_of_type_JavaLangString = localStringBuilder.toString();
    }
    return this.jdField_g_of_type_JavaLangString;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.jdField_a_of_type_JavaLangString != null) {
        localJSONObject.put("mMusicName", this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_b_of_type_JavaLangString != null) {
        localJSONObject.put("mSingername", this.jdField_b_of_type_JavaLangString);
      }
      if (this.jdField_c_of_type_JavaLangString != null) {
        localJSONObject.put("mUrl", this.jdField_c_of_type_JavaLangString);
      }
      if (this.jdField_d_of_type_JavaLangString != null) {
        localJSONObject.put("mTagName", this.jdField_d_of_type_JavaLangString);
      }
      if (this.jdField_g_of_type_JavaLangString != null) {
        localJSONObject.put("mPath", this.jdField_g_of_type_JavaLangString);
      }
      localJSONObject.put("mItemId", this.jdField_a_of_type_Int);
      localJSONObject.put("mType", this.jdField_d_of_type_Int);
      localJSONObject.put("musicStart", this.jdField_e_of_type_Int);
      localJSONObject.put("musicEnd", this.jdField_f_of_type_Int);
      localJSONObject.put("musicDuration", this.jdField_g_of_type_Int);
      if (this.jdField_e_of_type_JavaLangString != null) {
        localJSONObject.put("mSongMid", this.jdField_e_of_type_JavaLangString);
      }
      localJSONObject.put("mRecognitionOffset", this.jdField_a_of_type_Float);
      localJSONObject.put("mHasCopyright", this.jdField_a_of_type_Boolean);
      localJSONObject.put("mAccuracy", this.jdField_b_of_type_Int);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_g_of_type_JavaLangString = paramString;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_Int > -1) && (this.jdField_c_of_type_Int < 100);
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo)
  {
    if ((paramMusicItemInfo != null) && (paramMusicItemInfo.jdField_d_of_type_Int != 1) && (paramMusicItemInfo.jdField_d_of_type_Int != 5)) {
      if (this.jdField_d_of_type_Int != paramMusicItemInfo.jdField_d_of_type_Int) {}
    }
    while ((paramMusicItemInfo != null) && (paramMusicItemInfo.jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (paramMusicItemInfo.jdField_d_of_type_Int == this.jdField_d_of_type_Int) && (paramMusicItemInfo.jdField_a_of_type_JavaLangString != null) && (paramMusicItemInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean b()
  {
    return (this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 5);
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Int != 2;
  }
  
  public boolean d()
  {
    return (this.jdField_d_of_type_Int == 10) || (this.jdField_d_of_type_Int == 11);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return this.jdField_d_of_type_Int == 5;
  }
  
  public boolean f()
  {
    return ((this.jdField_d_of_type_Int == 5) || (this.jdField_d_of_type_Int == 1)) && (FileUtil.b(a()));
  }
  
  public int hashCode()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))) {
      return this.jdField_a_of_type_JavaLangString.hashCode() + this.jdField_e_of_type_JavaLangString.hashCode() + this.jdField_a_of_type_Int + this.jdField_d_of_type_Int;
    }
    return this.jdField_a_of_type_Int + this.jdField_d_of_type_Int;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MusicItemInfo: ").append(this.jdField_b_of_type_JavaLangString).append(" - ").append(this.jdField_a_of_type_JavaLangString).append(" - ").append("mRecognitionOffset=").append(this.jdField_a_of_type_Float);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jdField_b_of_type_Int);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo
 * JD-Core Version:    0.7.0.1
 */