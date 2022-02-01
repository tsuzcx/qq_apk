package com.tencent.qqmini.sdk.launcher.model;

import NS_MINI_USERAUTH.MiniUserAuth.StUserAuthScope;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
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
  
  public static UserAuthScope from(MiniUserAuth.StUserAuthScope paramStUserAuthScope)
  {
    UserAuthScope localUserAuthScope = new UserAuthScope();
    if (paramStUserAuthScope == null) {
      return localUserAuthScope;
    }
    localUserAuthScope.scope = paramStUserAuthScope.scope.get();
    localUserAuthScope.authType = paramStUserAuthScope.authType.get();
    localUserAuthScope.desc = paramStUserAuthScope.desc.get();
    localUserAuthScope.settingPageTitle = paramStUserAuthScope.settingPageTitle.get();
    return localUserAuthScope;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserAuthScope{scope='");
    localStringBuilder.append(this.scope);
    localStringBuilder.append('\'');
    localStringBuilder.append(", authType=");
    localStringBuilder.append(this.authType);
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.desc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", settingPageTitle='");
    localStringBuilder.append(this.settingPageTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.scope);
    paramParcel.writeInt(this.authType);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.settingPageTitle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.UserAuthScope
 * JD-Core Version:    0.7.0.1
 */