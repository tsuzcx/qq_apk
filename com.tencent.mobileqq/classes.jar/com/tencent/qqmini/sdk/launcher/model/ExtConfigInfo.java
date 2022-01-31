package com.tencent.qqmini.sdk.launcher.model;

import NS_MINI_INTERFACE.INTERFACE.StExtConfigInfo;
import NS_MINI_USERAUTH.MiniUserAuth.StApiScopeConfig;
import NS_MINI_USERAUTH.MiniUserAuth.StApiScopeEntry;
import NS_MINI_USERAUTH.MiniUserAuth.StUserAuthScope;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExtConfigInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ExtConfigInfo> CREATOR = new ExtConfigInfo.1();
  private static final String TAG = "ExtConfigInfo";
  public ArrayList<ApiScopeEntry> apiScopeEntries = new ArrayList();
  public String configKey;
  public String configVersion;
  public ArrayList<UserAuthScope> userAuthScopes = new ArrayList();
  
  public ExtConfigInfo() {}
  
  protected ExtConfigInfo(Parcel paramParcel)
  {
    this.configKey = paramParcel.readString();
    this.configVersion = paramParcel.readString();
    this.userAuthScopes = paramParcel.createTypedArrayList(UserAuthScope.CREATOR);
    this.apiScopeEntries = paramParcel.createTypedArrayList(ApiScopeEntry.CREATOR);
  }
  
  public static ExtConfigInfo from(INTERFACE.StExtConfigInfo paramStExtConfigInfo)
  {
    ExtConfigInfo localExtConfigInfo = new ExtConfigInfo();
    if (paramStExtConfigInfo == null) {
      return localExtConfigInfo;
    }
    localExtConfigInfo.configKey = paramStExtConfigInfo.configKey.get();
    localExtConfigInfo.configVersion = paramStExtConfigInfo.configVersion.get();
    Object localObject = new MiniUserAuth.StApiScopeConfig();
    try
    {
      ((MiniUserAuth.StApiScopeConfig)localObject).mergeFrom(paramStExtConfigInfo.dataBuf.get().toByteArray());
      localExtConfigInfo.userAuthScopes = new ArrayList();
      paramStExtConfigInfo = ((MiniUserAuth.StApiScopeConfig)localObject).scopeList.get();
      if (paramStExtConfigInfo != null)
      {
        paramStExtConfigInfo = paramStExtConfigInfo.iterator();
        while (paramStExtConfigInfo.hasNext())
        {
          UserAuthScope localUserAuthScope = UserAuthScope.from((MiniUserAuth.StUserAuthScope)paramStExtConfigInfo.next());
          localExtConfigInfo.userAuthScopes.add(localUserAuthScope);
          continue;
          return localExtConfigInfo;
        }
      }
    }
    catch (Exception paramStExtConfigInfo)
    {
      QMLog.e("ExtConfigInfo", "merge from error", paramStExtConfigInfo);
    }
    for (;;)
    {
      paramStExtConfigInfo = ((MiniUserAuth.StApiScopeConfig)localObject).apiToScope.get();
      if (paramStExtConfigInfo != null)
      {
        paramStExtConfigInfo = paramStExtConfigInfo.iterator();
        while (paramStExtConfigInfo.hasNext())
        {
          localObject = ApiScopeEntry.from((MiniUserAuth.StApiScopeEntry)paramStExtConfigInfo.next());
          localExtConfigInfo.apiScopeEntries.add(localObject);
        }
      }
    }
  }
  
  public static ExtConfigInfo fromJson(JSONObject paramJSONObject)
  {
    int j = 0;
    ExtConfigInfo localExtConfigInfo = new ExtConfigInfo();
    if (paramJSONObject != null)
    {
      localExtConfigInfo.configKey = paramJSONObject.optString("configKey");
      localExtConfigInfo.configVersion = paramJSONObject.optString("configVersion");
      Object localObject = paramJSONObject.optJSONArray("userAuthScopes");
      int i;
      if (localObject != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          UserAuthScope localUserAuthScope = UserAuthScope.fromJson(((JSONArray)localObject).optJSONObject(i));
          localExtConfigInfo.userAuthScopes.add(localUserAuthScope);
          i += 1;
        }
      }
      paramJSONObject = paramJSONObject.optJSONArray("apiScopeEntries");
      if (paramJSONObject != null)
      {
        i = j;
        while (i < paramJSONObject.length())
        {
          localObject = ApiScopeEntry.fromJson(paramJSONObject.optJSONObject(i));
          localExtConfigInfo.apiScopeEntries.add(localObject);
          i += 1;
        }
      }
    }
    return localExtConfigInfo;
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
      localJSONObject.put("configKey", this.configKey);
      localJSONObject.put("configVersion", this.configVersion);
      JSONArray localJSONArray1 = new JSONArray();
      localIterator = this.userAuthScopes.iterator();
      while (localIterator.hasNext()) {
        localJSONArray1.put(((UserAuthScope)localIterator.next()).toJson());
      }
      localJSONObject.put("userAuthScopes", localException);
    }
    catch (Exception localException)
    {
      QMLog.e("ExtConfigInfo", "toJson error", localException);
      return localJSONObject;
    }
    JSONArray localJSONArray2 = new JSONArray();
    Iterator localIterator = this.apiScopeEntries.iterator();
    while (localIterator.hasNext()) {
      localJSONArray2.put(((ApiScopeEntry)localIterator.next()).toJson());
    }
    localJSONObject.put("apiScopeEntries", localJSONArray2);
    return localJSONObject;
  }
  
  public INTERFACE.StExtConfigInfo toProto()
  {
    INTERFACE.StExtConfigInfo localStExtConfigInfo = new INTERFACE.StExtConfigInfo();
    localStExtConfigInfo.configKey.set(this.configKey);
    localStExtConfigInfo.configVersion.set(this.configVersion);
    return localStExtConfigInfo;
  }
  
  public String toString()
  {
    return "ExtConfigInfo{configKey='" + this.configKey + '\'' + ", configVersion='" + this.configVersion + '\'' + ", userAuthScopes=" + this.userAuthScopes + ", apiScopeEntries=" + this.apiScopeEntries + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.configKey);
    paramParcel.writeString(this.configVersion);
    paramParcel.writeTypedList(this.userAuthScopes);
    paramParcel.writeTypedList(this.apiScopeEntries);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo
 * JD-Core Version:    0.7.0.1
 */