package com.tencent.qqmini.sdk.core.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import org.json.JSONObject;

public class UserAuthScope
  implements Parcelable, Serializable
{
  public static final int AUTH_TYPE_ASK_EVERY_TIME = 1;
  public static final int AUTH_TYPE_ASK_ONLY_ONCE = 0;
  public static final Parcelable.Creator<UserAuthScope> CREATOR = new UserAuthScope.1();
  public int authType;
  public String desc;
  public String scope;
  public String settingPageTitle;
  
  public UserAuthScope() {}
  
  protected UserAuthScope(Parcel paramParcel)
  {
    this.scope = paramParcel.readString();
    this.authType = paramParcel.readInt();
    this.desc = paramParcel.readString();
    this.settingPageTitle = paramParcel.readString();
  }
  
  public static UserAuthScope fromJson(JSONObject paramJSONObject)
  {
    UserAuthScope localUserAuthScope = new UserAuthScope();
    if (paramJSONObject != null)
    {
      localUserAuthScope.scope = paramJSONObject.optString("scope");
      localUserAuthScope.authType = paramJSONObject.optInt("authType");
      localUserAuthScope.desc = paramJSONObject.optString("desc");
      localUserAuthScope.settingPageTitle = paramJSONObject.optString("settingPageTitle");
    }
    return localUserAuthScope;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("scope", this.scope);
      localJSONObject.put("authType", this.authType);
      localJSONObject.put("desc", this.desc);
      localJSONObject.put("settingPageTitle", this.settingPageTitle);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return localJSONObject;
  }
  
  public String toString()
  {
    return "UserAuthScope{scope='" + this.scope + '\'' + ", authType=" + this.authType + ", desc='" + this.desc + '\'' + ", settingPageTitle='" + this.settingPageTitle + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.scope);
    paramParcel.writeInt(this.authType);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.settingPageTitle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.auth.UserAuthScope
 * JD-Core Version:    0.7.0.1
 */