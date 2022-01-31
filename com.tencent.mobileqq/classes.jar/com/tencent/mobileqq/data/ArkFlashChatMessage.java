package com.tencent.mobileqq.data;

import android.text.TextUtils;
import ayla;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;
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
  public int forwardID;
  public boolean preview;
  public String promptText;
  public long uniSeq;
  
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
  
  public String getArkDisplay()
  {
    if (this.promptText != null) {
      return ayla.a(getSummery());
    }
    return getSummery();
  }
  
  public String getMeta(long paramLong, boolean paramBoolean)
  {
    try
    {
      String str = FlashChatManager.b(getArkDisplay());
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("id", String.valueOf(paramLong));
      localJSONObject2.put("text", str);
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localJSONObject2.put("runstate", i);
        if (this.preview) {
          localJSONObject2.put("preview", 1);
        }
        localJSONObject1.put("content", localJSONObject2);
        str = localJSONObject1.toString();
        return str;
      }
      return "";
    }
    catch (Exception localException)
    {
      QLog.e("ArkApp.Message", 1, localException, new Object[0]);
    }
  }
  
  public String getSummery()
  {
    if (!TextUtils.isEmpty(this.promptText)) {
      return this.promptText;
    }
    return MobileQQ.sMobileQQ.getString(2131690240);
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