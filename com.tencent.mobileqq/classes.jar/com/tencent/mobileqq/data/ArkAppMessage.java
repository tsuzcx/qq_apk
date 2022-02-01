package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppMessage
{
  public String appDesc;
  public String appId;
  public String appMinVersion;
  public String appName;
  public String appView;
  public String compatibleText;
  public String config;
  @RecordForTest
  public MessageForStructing containStructMsg;
  public int forwardID;
  public int from;
  public List<ArkAppMessage> mAppList;
  public String mExtra;
  public String mSourceActionData;
  public String mSourceAd;
  public String mSourceName;
  public String mSourceUrl;
  public String mSource_A_ActionData;
  public String mText;
  public String metaList;
  public String promptText;
  public long uniSeq;
  
  public ArkAppMessage()
  {
    reset();
  }
  
  public ArkAppMessage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.promptText = paramString1;
    this.appDesc = paramString3;
    this.appName = paramString2;
    this.appView = paramString4;
    this.appMinVersion = paramString5;
    this.metaList = paramString6;
    this.config = paramString7;
    this.compatibleText = paramString8;
  }
  
  public static String msgDataToString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    try
    {
      paramArrayOfByte = (String)new ObjectInputStream(paramArrayOfByte).readObject();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg data to string fail, ");
      localStringBuilder.append(paramArrayOfByte);
      QLog.w("ArkApp.Message", 1, localStringBuilder.toString());
    }
    return "";
  }
  
  public boolean fromAppXml(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app_xml: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("ArkApp.Message", 2, ((StringBuilder)localObject).toString());
    }
    reset();
    if (paramString != null) {
      if (paramString.length() == 0) {
        return false;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        this.appName = paramString.optString("app");
        this.appView = paramString.optString("view");
        this.appDesc = paramString.optString("desc");
        this.appMinVersion = paramString.optString("ver");
        this.promptText = paramString.optString("prompt");
        this.metaList = paramString.optString("meta");
        this.config = paramString.optString("config");
        this.from = paramString.optInt("from");
        this.appId = paramString.optString("appID");
        this.mSourceName = paramString.optString("sourceName");
        this.mSourceActionData = paramString.optString("actionData");
        this.mSource_A_ActionData = paramString.optString("actionData_A");
        this.mSourceUrl = paramString.optString("sourceUrl");
        this.mAppList = new ArrayList();
        this.mText = paramString.optString("text");
        this.mExtra = paramString.optString("extra");
        localObject = paramString.optJSONArray("extraApps");
        if ((localObject != null) && (((JSONArray)localObject).length() != 0))
        {
          int j = ((JSONArray)localObject).length();
          i = 0;
          if (i < j)
          {
            JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
            if (localJSONObject == null) {
              break label334;
            }
            ArkAppMessage localArkAppMessage = new ArkAppMessage();
            if (!localArkAppMessage.fromAppXml(localJSONObject.toString())) {
              break label334;
            }
            this.mAppList.add(localArkAppMessage);
            break label334;
          }
        }
        this.mSourceAd = paramString.optString("sourceAd");
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return false;
      label334:
      i += 1;
    }
  }
  
  public boolean fromBytes(byte[] paramArrayOfByte)
  {
    return fromAppXml(msgDataToString(paramArrayOfByte));
  }
  
  public String getAppIdFromMeta()
  {
    boolean bool = TextUtils.isEmpty(this.metaList);
    Object localObject2 = "";
    if (bool) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.metaList);
      Iterator localIterator = localJSONObject.keys();
      Object localObject1 = localObject2;
      if (localIterator != null)
      {
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (String)localIterator.next();
          if ("appid".equals(localObject1)) {
            return localJSONObject.optString("appid", "");
          }
          localObject1 = localJSONObject.opt((String)localObject1);
        } while ((!(localObject1 instanceof JSONObject)) || (!((JSONObject)localObject1).has("appid")));
        localObject1 = ((JSONObject)localObject1).optString("appid", "");
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("arkMessage getAppIdFromMeta error : ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("ArkApp.Message", 1, ((StringBuilder)localObject2).toString());
    }
    return "";
  }
  
  public String getFilterExtra()
  {
    try
    {
      Object localObject = new JSONObject(this.mExtra);
      ((JSONObject)localObject).remove("msg_seq");
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ArkApp.Message", 1, "JSONException", localJSONException);
    }
    return new JSONObject().toString();
  }
  
  public String getSummery()
  {
    if (!TextUtils.isEmpty(this.promptText)) {
      return this.promptText;
    }
    return BaseApplicationImpl.getApplication().getString(2131690162);
  }
  
  public long optMsgSeq()
  {
    if (TextUtils.isEmpty(this.mExtra)) {
      return -1L;
    }
    try
    {
      long l = new JSONObject(this.mExtra).optLong("msg_seq", -1L);
      return l;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ArkApp.Message", 1, "JSONException", localJSONException);
    }
    return -1L;
  }
  
  public void reset()
  {
    this.promptText = null;
    this.appName = null;
    this.appDesc = null;
    this.appView = null;
    this.appMinVersion = null;
    this.metaList = null;
    this.config = null;
    this.compatibleText = null;
  }
  
  public String toAppXml()
  {
    try
    {
      Object localObject1 = new JSONObject();
      if (this.appName != null) {
        ((JSONObject)localObject1).put("app", this.appName);
      }
      if (this.appDesc != null) {
        ((JSONObject)localObject1).put("desc", this.appDesc);
      }
      if (this.appView != null) {
        ((JSONObject)localObject1).put("view", this.appView);
      }
      if (this.appMinVersion != null) {
        ((JSONObject)localObject1).put("ver", this.appMinVersion);
      }
      if (this.promptText != null) {
        ((JSONObject)localObject1).put("prompt", this.promptText);
      }
      if (this.from != 0) {
        ((JSONObject)localObject1).put("from", this.from);
      }
      if (this.appId != null) {
        ((JSONObject)localObject1).put("appID", this.appId);
      }
      if (this.mSourceName != null) {
        ((JSONObject)localObject1).put("sourceName", this.mSourceName);
      }
      if (this.mSourceActionData != null) {
        ((JSONObject)localObject1).put("actionData", this.mSourceActionData);
      }
      if (this.mSource_A_ActionData != null) {
        ((JSONObject)localObject1).put("actionData_A", this.mSource_A_ActionData);
      }
      if (this.mSourceUrl != null) {
        ((JSONObject)localObject1).put("sourceUrl", this.mSourceUrl);
      }
      String str1 = this.metaList;
      Object localObject3;
      if (str1 != null) {
        try
        {
          ((JSONObject)localObject1).put("meta", new JSONObject(this.metaList));
        }
        catch (Exception localException2)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("toAppXml fail, metaList, err=");
          ((StringBuilder)localObject3).append(localException2.getMessage());
          ArkAppCenter.a("ArkApp.Message", ((StringBuilder)localObject3).toString());
        }
      }
      String str2 = this.config;
      if (str2 != null) {
        try
        {
          ((JSONObject)localObject1).put("config", new JSONObject(this.config));
        }
        catch (Exception localException3)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("toAppXml fail, config, err=");
          ((StringBuilder)localObject3).append(localException3.getMessage());
          ArkAppCenter.a("ArkApp.Message", ((StringBuilder)localObject3).toString());
        }
      }
      if (this.mText != null) {
        ((JSONObject)localObject1).put("text", this.mText);
      }
      Object localObject2 = this.mAppList;
      if (localObject2 != null) {
        try
        {
          localObject2 = new JSONArray();
          localObject3 = this.mAppList.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((JSONArray)localObject2).put(new JSONObject(((ArkAppMessage)((Iterator)localObject3).next()).toAppXml()));
          }
          ((JSONObject)localObject1).put("extraApps", localObject2);
        }
        catch (Exception localException4)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("toAppXml fail, config, err=");
          ((StringBuilder)localObject3).append(localException4.getMessage());
          ArkAppCenter.a("ArkApp.Message", ((StringBuilder)localObject3).toString());
        }
      }
      if (this.mSourceAd != null) {
        ((JSONObject)localObject1).put("sourceAd", this.mSourceAd);
      }
      if (this.mExtra != null) {
        ((JSONObject)localObject1).put("extra", this.mExtra);
      }
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
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
  
  public JSONObject toShareMsgJSONObject()
  {
    localJSONObject = new JSONObject();
    try
    {
      if (this.appName != null) {
        localJSONObject.put("forward_ark_app_name", this.appName);
      }
      if (this.appDesc != null) {
        localJSONObject.put("forward_ark_app_desc", this.appDesc);
      }
      if (this.appView != null) {
        localJSONObject.put("forward_ark_app_view", this.appView);
      }
      if (this.appMinVersion != null) {
        localJSONObject.put("forward_ark_app_ver", this.appMinVersion);
      }
      if (this.promptText != null) {
        localJSONObject.put("forward_ark_app_prompt", this.promptText);
      }
      String str1 = this.metaList;
      if (str1 != null) {
        try
        {
          localJSONObject.put("forward_ark_app_meta", new JSONObject(this.metaList));
        }
        catch (Exception localException1)
        {
          QLog.e("ArkApp.Message", 1, "toShareMsgJSONObject fail, metaList, err=", localException1);
        }
      }
      String str2 = this.config;
      if (str2 != null) {
        try
        {
          localJSONObject.put("forward_ark_app_config", new JSONObject(this.config));
          return localJSONObject;
        }
        catch (Exception localException2)
        {
          QLog.e("ArkApp.Message", 1, "toShareMsgJSONObject fail, config, err=", localException2);
          return localJSONObject;
        }
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ArkApp.Message", 1, "toShareMsgJSONObject fail, err=", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.ArkAppMessage
 * JD-Core Version:    0.7.0.1
 */