package com.tencent.qqmini.sdk.launcher.model;

import NS_MINI_INTERFACE.INTERFACE.StPluginInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import berg;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public class MiniGamePluginInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MiniGamePluginInfo> CREATOR = new berg();
  public final int a;
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  
  public MiniGamePluginInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  public MiniGamePluginInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static MiniGamePluginInfo a(INTERFACE.StPluginInfo paramStPluginInfo)
  {
    if ((paramStPluginInfo != null) && (!TextUtils.isEmpty(paramStPluginInfo.pluginName.get())) && (!TextUtils.isEmpty(paramStPluginInfo.pluginId.get())) && (!TextUtils.isEmpty(paramStPluginInfo.version.get())) && (!TextUtils.isEmpty(paramStPluginInfo.url.get()))) {
      return new MiniGamePluginInfo(paramStPluginInfo.pluginName.get(), paramStPluginInfo.pluginId.get(), paramStPluginInfo.version.get(), paramStPluginInfo.url.get(), paramStPluginInfo.fileSize.get());
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof MiniGamePluginInfo));
            paramObject = (MiniGamePluginInfo)paramObject;
            bool1 = bool2;
          } while (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int);
          bool1 = bool2;
        } while (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString));
        bool1 = bool2;
      } while (!this.b.equals(paramObject.b));
      bool1 = bool2;
    } while (!this.c.equals(paramObject.c));
    return this.d.equals(paramObject.d);
  }
  
  public int hashCode()
  {
    return (((this.jdField_a_of_type_JavaLangString.hashCode() * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode()) * 31 + this.jdField_a_of_type_Int;
  }
  
  public String toString()
  {
    return "MiniGamePluginInfo{name='" + this.jdField_a_of_type_JavaLangString + '\'' + ", id='" + this.b + '\'' + ", version='" + this.c + '\'' + ", url='" + this.d + '\'' + ", packageSize=" + this.jdField_a_of_type_Int + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo
 * JD-Core Version:    0.7.0.1
 */