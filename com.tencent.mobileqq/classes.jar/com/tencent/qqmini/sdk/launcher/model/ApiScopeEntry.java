package com.tencent.qqmini.sdk.launcher.model;

import NS_MINI_USERAUTH.MiniUserAuth.StApiNameItem;
import NS_MINI_USERAUTH.MiniUserAuth.StApiScopeEntry;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import beqs;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.Serializable;
import org.json.JSONObject;

public class ApiScopeEntry
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ApiScopeEntry> CREATOR = new beqs();
  public String apiName;
  public String eventName;
  public String scope;
  
  public ApiScopeEntry() {}
  
  public ApiScopeEntry(Parcel paramParcel)
  {
    this.eventName = paramParcel.readString();
    this.apiName = paramParcel.readString();
    this.scope = paramParcel.readString();
  }
  
  public static ApiScopeEntry from(MiniUserAuth.StApiScopeEntry paramStApiScopeEntry)
  {
    ApiScopeEntry localApiScopeEntry = new ApiScopeEntry();
    if (paramStApiScopeEntry == null) {
      return localApiScopeEntry;
    }
    MiniUserAuth.StApiNameItem localStApiNameItem = (MiniUserAuth.StApiNameItem)paramStApiScopeEntry.api.get();
    if (localStApiNameItem != null)
    {
      localApiScopeEntry.eventName = localStApiNameItem.eventName.get();
      localApiScopeEntry.apiName = localStApiNameItem.apiName.get();
    }
    localApiScopeEntry.scope = paramStApiScopeEntry.scope.get();
    return localApiScopeEntry;
  }
  
  public static ApiScopeEntry fromJson(JSONObject paramJSONObject)
  {
    ApiScopeEntry localApiScopeEntry = new ApiScopeEntry();
    if (paramJSONObject != null)
    {
      localApiScopeEntry.eventName = paramJSONObject.optString("eventName");
      localApiScopeEntry.apiName = paramJSONObject.optString("apiName");
      localApiScopeEntry.scope = paramJSONObject.optString("scope");
    }
    return localApiScopeEntry;
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
      localJSONObject.put("eventName", this.eventName);
      localJSONObject.put("apiName", this.apiName);
      localJSONObject.put("scope", this.scope);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return localJSONObject;
  }
  
  public String toString()
  {
    return "ApiScopeEntry{eventName='" + this.eventName + '\'' + ", apiName='" + this.apiName + '\'' + ", scope='" + this.scope + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.eventName);
    paramParcel.writeString(this.apiName);
    paramParcel.writeString(this.scope);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry
 * JD-Core Version:    0.7.0.1
 */