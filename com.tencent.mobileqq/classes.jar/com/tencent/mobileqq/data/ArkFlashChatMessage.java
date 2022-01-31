package com.tencent.mobileqq.data;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkFlashChatMessage
{
  public final String TAG = "ArkApp.Message";
  public String appDesc;
  public String appMinVersion;
  public String appName;
  public int appResId;
  public String appView;
  public String config;
  public String promptText;
  
  public ArkFlashChatMessage()
  {
    reset();
  }
  
  public boolean fromAppXml(String paramString)
  {
    reset();
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.appName = paramString.optString("a");
      this.appView = paramString.optString("m");
      this.appDesc = paramString.optString("desc");
      this.appMinVersion = paramString.optString("v");
      this.promptText = paramString.optString("prompt");
      this.appResId = paramString.optInt("resid");
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean fromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    try
    {
      boolean bool = fromAppXml((String)new ObjectInputStream(paramArrayOfByte).readObject());
      return bool;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public String getMeta(long paramLong, boolean paramBoolean)
  {
    int i = 1;
    String str = getSummery();
    if (paramBoolean) {}
    for (;;)
    {
      return String.format("{\"content\":{\"id\":\"%d\",\"text\":\"%s\",\"runstate\":%d}}", new Object[] { Long.valueOf(paramLong), str, Integer.valueOf(i) });
      i = 0;
    }
  }
  
  public String getSummery()
  {
    if (!TextUtils.isEmpty(this.promptText)) {
      return this.promptText;
    }
    return MobileQQ.sMobileQQ.getString(2131438243);
  }
  
  public void reset()
  {
    this.promptText = null;
    this.appName = null;
    this.appDesc = null;
    this.appView = null;
    this.appMinVersion = null;
    this.config = null;
  }
  
  public String toAppXml()
  {
    try
    {
      Object localObject = new JSONObject();
      if (this.appName != null) {
        ((JSONObject)localObject).put("a", this.appName);
      }
      if (this.appDesc != null) {
        ((JSONObject)localObject).put("desc", this.appDesc);
      }
      if (this.appResId != 0) {
        ((JSONObject)localObject).put("resid", this.appResId);
      }
      if (this.appView != null) {
        ((JSONObject)localObject).put("m", this.appView);
      }
      if (this.appMinVersion != null) {
        ((JSONObject)localObject).put("v", this.appMinVersion);
      }
      if (this.promptText != null) {
        ((JSONObject)localObject).put("prompt", this.promptText);
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public byte[] toBytes()
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      new ObjectOutputStream((OutputStream)localObject).writeObject(toAppXml());
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public byte[] toPbData()
  {
    Object localObject = toAppXml();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((String)localObject).getBytes("utf-8");
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ArkFlashChatMessage
 * JD-Core Version:    0.7.0.1
 */