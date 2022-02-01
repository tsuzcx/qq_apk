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
  public final String a;
  public final String b;
  public final String c;
  public final int d;
  public final String e;
  public final int f;
  public final String g;
  
  public TroopBarPOI(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramInt1;
    this.e = paramString4;
    this.f = paramInt2;
    this.g = paramString5;
  }
  
  public TroopBarPOI(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("uid", "");
    this.b = paramJSONObject.optString("catalog", "");
    this.c = paramJSONObject.optString("name", "");
    this.d = ((int)(paramJSONObject.optDouble("longitude", -1.0D) * 1000000.0D));
    this.e = paramJSONObject.optString("addr", "");
    this.f = ((int)(paramJSONObject.optDouble("latitude", -1.0D) * 1000000.0D));
    this.g = paramJSONObject.optString("dist", "");
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uid", this.a);
      localJSONObject.put("catalog", this.b);
      localJSONObject.put("name", this.c);
      localJSONObject.put("longitude", this.d);
      localJSONObject.put("addr", this.e);
      localJSONObject.put("latitude", this.f);
      localJSONObject.put("dist", this.g);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.c))
    {
      SLog.e("TroopBarPOI", "name is empty while get location string!");
      return null;
    }
    if (TextUtils.isEmpty(this.b))
    {
      SLog.d("TroopBarPOI", "catelog is empty while get location string!");
      return this.c;
    }
    Object localObject2 = this.b;
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith(HardCodeUtil.a(2131912520))) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("·");
    ((StringBuilder)localObject2).append(this.c);
    return ((StringBuilder)localObject2).toString();
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
        if (TextUtils.equals(paramObject.e, this.e)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeString(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.data.TroopBarPOI
 * JD-Core Version:    0.7.0.1
 */