package com.tencent.superplayer.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.superplayer.utils.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CacheContent
{
  private static final String TAG = "CacheContent";
  private static final String TRUE_REG = "^(1|true)$";
  public String originGroupName;
  private SharedPreferences sharedPreferences;
  
  private CacheContent() {}
  
  public CacheContent(String paramString)
  {
    this.originGroupName = paramString;
    if (SuperPlayerSDKMgr.getContext() != null) {
      this.sharedPreferences = SuperPlayerSDKMgr.getContext().getSharedPreferences(paramString, 0);
    }
    if (this.sharedPreferences == null)
    {
      this.sharedPreferences = new EmptySharedPreferences();
      LogUtil.w("CacheContent", "sharedPreferences is null, init EmptySharedPreferences");
    }
  }
  
  private boolean serverConfigEnable()
  {
    if (SuperPlayerSDKMgr.getSdkOption() != null) {
      return SuperPlayerSDKMgr.getSdkOption().serverConfigEnable;
    }
    return true;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    if (!serverConfigEnable()) {}
    do
    {
      return paramBoolean;
      paramString = this.sharedPreferences.getString(paramString, String.valueOf(paramBoolean));
    } while (TextUtils.isEmpty(paramString));
    return paramString.matches("^(1|true)$");
  }
  
  public int getInt(String paramString, int paramInt)
  {
    if (!serverConfigEnable()) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(this.sharedPreferences.getString(paramString, String.valueOf(paramInt)));
      return i;
    }
    catch (Exception paramString)
    {
      LogUtil.e("CacheContent", "getInt error,", paramString);
    }
    return paramInt;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    if (!serverConfigEnable()) {
      return paramString2;
    }
    return this.sharedPreferences.getString(paramString1, paramString2);
  }
  
  public boolean isValidate()
  {
    return (this.sharedPreferences != null) && (!(this.sharedPreferences instanceof EmptySharedPreferences));
  }
  
  public void save(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
        paramString = new JSONArray(paramString);
        i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          if (localJSONObject != null) {
            localEditor.putString(localJSONObject.optString("key"), localJSONObject.optString("value"));
          }
        }
        else
        {
          localEditor.apply();
          return;
        }
      }
      catch (JSONException paramString)
      {
        LogUtil.e("CacheContent", "save error", paramString);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.config.CacheContent
 * JD-Core Version:    0.7.0.1
 */