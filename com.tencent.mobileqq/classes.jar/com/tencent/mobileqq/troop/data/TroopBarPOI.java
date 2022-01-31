package com.tencent.mobileqq.troop.data;

import alud;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bbql;
import org.json.JSONObject;
import wxe;

public class TroopBarPOI
  implements Parcelable
{
  public static final Parcelable.Creator<TroopBarPOI> CREATOR = new bbql();
  public final int a;
  public final String a;
  public final int b;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  
  public TroopBarPOI(TroopBarPOI paramTroopBarPOI)
  {
    this.jdField_a_of_type_JavaLangString = paramTroopBarPOI.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramTroopBarPOI.jdField_b_of_type_JavaLangString;
    this.c = paramTroopBarPOI.c;
    this.jdField_a_of_type_Int = paramTroopBarPOI.jdField_a_of_type_Int;
    this.d = paramTroopBarPOI.d;
    this.jdField_b_of_type_Int = paramTroopBarPOI.jdField_b_of_type_Int;
    this.e = paramTroopBarPOI.e;
  }
  
  public TroopBarPOI(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Int = paramInt1;
    this.d = paramString4;
    this.jdField_b_of_type_Int = paramInt2;
    this.e = paramString5;
  }
  
  public TroopBarPOI(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("uid", "");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("catalog", "");
    this.c = paramJSONObject.optString("name", "");
    this.jdField_a_of_type_Int = ((int)(paramJSONObject.optDouble("longitude", -1.0D) * 1000000.0D));
    this.d = paramJSONObject.optString("addr", "");
    this.jdField_b_of_type_Int = ((int)(paramJSONObject.optDouble("latitude", -1.0D) * 1000000.0D));
    this.e = paramJSONObject.optString("dist", "");
  }
  
  public static String a(String paramString)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString))
    {
      wxe.e("TroopBarPOI", "location is null while spliting location!");
      return null;
    }
    String[] arrayOfString = paramString.split("·");
    if (arrayOfString.length == 1) {
      paramString = arrayOfString[0];
    }
    for (;;)
    {
      wxe.b("TroopBarPOI", "location name is %s.", paramString);
      return paramString;
      paramString = localObject;
      if (arrayOfString.length > 1) {
        paramString = arrayOfString[1];
      }
    }
  }
  
  public static String b(String paramString)
  {
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString))
    {
      wxe.e("TroopBarPOI", "location is null while spliting location!");
      return null;
    }
    Object localObject2 = paramString.split("·");
    if (localObject2.length == 1)
    {
      localObject2 = localObject2[0];
      localObject1 = localObject2;
      if (((String)localObject2).endsWith(alud.a(2131715616))) {
        localObject1 = paramString.substring(0, paramString.length() - 1);
      }
    }
    for (;;)
    {
      wxe.b("TroopBarPOI", "location name is %s.", localObject1);
      return localObject1;
      if (localObject2.length > 1) {
        localObject1 = localObject2[0];
      }
    }
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.c))
    {
      wxe.e("TroopBarPOI", "name is empty while get location string!");
      return null;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      wxe.d("TroopBarPOI", "catelog is empty while get location string!");
      return this.c;
    }
    String str2 = this.jdField_b_of_type_JavaLangString;
    String str1 = str2;
    if (str2.endsWith(alud.a(2131715642))) {
      str1 = str2.substring(0, str2.length() - 1);
    }
    return str1 + "·" + this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof TroopBarPOI))
    {
      paramObject = (TroopBarPOI)paramObject;
      bool1 = bool2;
      if (TextUtils.equals(paramObject.c, this.c))
      {
        bool1 = bool2;
        if (TextUtils.equals(paramObject.d, this.d)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPOI
 * JD-Core Version:    0.7.0.1
 */