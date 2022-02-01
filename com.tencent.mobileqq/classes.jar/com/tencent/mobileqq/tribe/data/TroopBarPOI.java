package com.tencent.mobileqq.tribe.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPOI
  implements Parcelable
{
  public static final Parcelable.Creator<TroopBarPOI> CREATOR = new TroopBarPOI.1();
  public final int a;
  public final String a;
  public final int b;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  
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
  
  public String a()
  {
    if (TextUtils.isEmpty(this.c))
    {
      SLog.e("TroopBarPOI", "name is empty while get location string!");
      return null;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      SLog.d("TroopBarPOI", "catelog is empty while get location string!");
      return this.c;
    }
    Object localObject2 = this.jdField_b_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith(HardCodeUtil.a(2131715029))) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("·");
    ((StringBuilder)localObject2).append(this.c);
    return ((StringBuilder)localObject2).toString();
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uid", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("catalog", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("name", this.c);
      localJSONObject.put("longitude", this.jdField_a_of_type_Int);
      localJSONObject.put("addr", this.d);
      localJSONObject.put("latitude", this.jdField_b_of_type_Int);
      localJSONObject.put("dist", this.e);
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
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof TroopBarPOI;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.data.TroopBarPOI
 * JD-Core Version:    0.7.0.1
 */