package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class TelephonyJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "TelephonyJsPlugin";
  
  private void doAddPhoneContact(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      Object localObject2 = new JSONObject(paramString2);
      Object localObject3 = ((JSONObject)localObject2).optString("firstName");
      String str1 = ((JSONObject)localObject2).optString("middleName");
      String str2 = ((JSONObject)localObject2).optString("lastName");
      paramString2 = ((JSONObject)localObject2).optString("nickName");
      String str3 = ((JSONObject)localObject2).optString("remark");
      String str4 = ((JSONObject)localObject2).optString("organization");
      String str5 = ((JSONObject)localObject2).optString("title");
      String str6 = ((JSONObject)localObject2).optString("email");
      Object localObject1 = ((JSONObject)localObject2).optString("url");
      if (paramBoolean)
      {
        paramString1 = new Intent("android.intent.action.INSERT");
        paramString1.setType("vnd.android.cursor.dir/raw_contact");
      }
      else
      {
        paramString1 = new Intent("android.intent.action.INSERT_OR_EDIT");
        paramString1.setType("vnd.android.cursor.item/contact");
      }
      parseName((String)localObject3, str1, str2, paramString1);
      parsePhoneNumber((JSONObject)localObject2, paramString1);
      paramString1.putExtra("notes", str3);
      paramString1.putExtra("company", str4);
      paramString1.putExtra("job_title", str5);
      paramString1.putExtra("email", str6);
      localObject3 = new ArrayList();
      parseNumber((JSONObject)localObject2, (ArrayList)localObject3);
      processAddress((JSONObject)localObject2, (ArrayList)localObject3);
      processWorkAddress((JSONObject)localObject2, (ArrayList)localObject3);
      processHomeAddress((JSONObject)localObject2, (ArrayList)localObject3);
      paramBoolean = TextUtils.isEmpty((CharSequence)localObject1);
      if (!paramBoolean)
      {
        localObject2 = new ContentValues();
        ((ContentValues)localObject2).put("mimetype", "vnd.android.cursor.item/website");
        ((ContentValues)localObject2).put("data2", Integer.valueOf(2));
        ((ContentValues)localObject2).put("data3", "网址");
        ((ContentValues)localObject2).put("data1", (String)localObject1);
        ((ArrayList)localObject3).add(localObject2);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject1 = new ContentValues();
        ((ContentValues)localObject1).put("mimetype", "vnd.android.cursor.item/nickname");
        ((ContentValues)localObject1).put("data2", Integer.valueOf(0));
        ((ContentValues)localObject1).put("data3", "昵称");
        ((ContentValues)localObject1).put("data1", paramString2);
        ((ArrayList)localObject3).add(localObject1);
      }
      paramString1.putParcelableArrayListExtra("data", (ArrayList)localObject3);
      if (this.mMiniAppContext.getAttachedActivity() != null)
      {
        this.mMiniAppContext.getAttachedActivity().startActivity(paramString1);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QMLog.e("TelephonyJsPlugin", paramString1.getMessage(), paramString1);
    }
  }
  
  private void parseName(String paramString1, String paramString2, String paramString3, Intent paramIntent)
  {
    if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2)) || (!TextUtils.isEmpty(paramString3)))
    {
      Object localObject = paramString1;
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramString2);
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString1 = (String)localObject;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString1 = new StringBuilder();
        paramString1.append((String)localObject);
        paramString1.append(" ");
        paramString1.append(paramString3);
        paramString1 = paramString1.toString();
      }
      paramIntent.putExtra("name", paramString1.trim());
    }
  }
  
  private void parseNumber(JSONObject paramJSONObject, ArrayList<ContentValues> paramArrayList)
  {
    Object localObject = paramJSONObject.optString("hostNumber");
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    Integer localInteger = Integer.valueOf(0);
    ContentValues localContentValues;
    if (!bool)
    {
      localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
      localContentValues.put("data2", localInteger);
      localContentValues.put("data3", "手机");
      localContentValues.put("data1", (String)localObject);
      paramArrayList.add(localContentValues);
    }
    localObject = paramJSONObject.optString("photoFilePath");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/photo");
      localContentValues.put("data15", (String)localObject);
      paramArrayList.add(localContentValues);
    }
    localObject = paramJSONObject.optString("homeFaxNumber");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
      localContentValues.put("data2", localInteger);
      localContentValues.put("data3", "住宅传真");
      localContentValues.put("data1", (String)localObject);
      paramArrayList.add(localContentValues);
    }
    paramJSONObject = paramJSONObject.optString("workFaxNumber");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      localObject = new ContentValues();
      ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/phone_v2");
      ((ContentValues)localObject).put("data2", localInteger);
      ((ContentValues)localObject).put("data3", "单位传真");
      ((ContentValues)localObject).put("data1", paramJSONObject);
      paramArrayList.add(localObject);
    }
  }
  
  private void parsePhoneNumber(JSONObject paramJSONObject, Intent paramIntent)
  {
    String str1 = paramJSONObject.optString("mobilePhoneNumber");
    String str2 = paramJSONObject.optString("workPhoneNumber");
    paramJSONObject = paramJSONObject.optString("homePhoneNumber");
    if (!TextUtils.isEmpty(str1))
    {
      paramIntent.putExtra("phone", str1);
      paramIntent.putExtra("phone_type", "手机");
    }
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramIntent.putExtra("secondary_phone", paramJSONObject);
      paramIntent.putExtra("secondary_phone_type", "住宅");
    }
    if (!TextUtils.isEmpty(str2))
    {
      paramIntent.putExtra("tertiary_phone", str2);
      paramIntent.putExtra("tertiary_phone_type", "工作");
    }
  }
  
  private void processAddress(JSONObject paramJSONObject, ArrayList<ContentValues> paramArrayList)
  {
    paramJSONObject.optString("weChatNumber");
    String str1 = paramJSONObject.optString("addressCountry");
    String str2 = paramJSONObject.optString("addressState");
    String str3 = paramJSONObject.optString("addressCity");
    String str4 = paramJSONObject.optString("addressStreet");
    paramJSONObject = paramJSONObject.optString("addressPostalCode");
    if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str4)) || (!TextUtils.isEmpty(paramJSONObject)))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
      localContentValues.put("data2", Integer.valueOf(1));
      localContentValues.put("data3", "住宅");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(" ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" ");
      localStringBuilder.append(str3);
      localStringBuilder.append(" ");
      localStringBuilder.append(str4);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramJSONObject);
      localContentValues.put("data1", localStringBuilder.toString());
      paramArrayList.add(localContentValues);
    }
  }
  
  private void processHomeAddress(JSONObject paramJSONObject, ArrayList<ContentValues> paramArrayList)
  {
    String str1 = paramJSONObject.optString("homeAddressCountry");
    String str2 = paramJSONObject.optString("homeAddressState");
    String str3 = paramJSONObject.optString("homeAddressCity");
    String str4 = paramJSONObject.optString("homeAddressStreet");
    paramJSONObject = paramJSONObject.optString("homeAddressPostalCode");
    if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str4)) || (!TextUtils.isEmpty(paramJSONObject)))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
      localContentValues.put("data2", Integer.valueOf(1));
      localContentValues.put("data3", "住宅");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(" ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" ");
      localStringBuilder.append(str3);
      localStringBuilder.append(" ");
      localStringBuilder.append(str4);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramJSONObject);
      localContentValues.put("data1", localStringBuilder.toString());
      paramArrayList.add(localContentValues);
    }
  }
  
  private void processWorkAddress(JSONObject paramJSONObject, ArrayList<ContentValues> paramArrayList)
  {
    String str1 = paramJSONObject.optString("workAddressCountry");
    String str2 = paramJSONObject.optString("workAddressState");
    String str3 = paramJSONObject.optString("workAddressCity");
    String str4 = paramJSONObject.optString("workAddressStreet");
    paramJSONObject = paramJSONObject.optString("workAddressPostalCode");
    if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str4)) || (!TextUtils.isEmpty(paramJSONObject)))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
      localContentValues.put("data2", Integer.valueOf(2));
      localContentValues.put("data3", "单位");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(" ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" ");
      localStringBuilder.append(str3);
      localStringBuilder.append(" ");
      localStringBuilder.append(str4);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramJSONObject);
      localContentValues.put("data1", localStringBuilder.toString());
      paramArrayList.add(localContentValues);
    }
  }
  
  @JsEvent({"addPhoneContact"})
  public String addPhoneContact(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new TelephonyJsPlugin.2(this, paramRequestEvent));
    return paramRequestEvent.ok();
  }
  
  @JsEvent({"getPhoneNumber"})
  public void getPhoneNumber(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("data");
      String str = localJSONObject.optString("api_name", "");
      localJSONObject.optBoolean("with_credentials", true);
      if ("webapi_getuserwxphone".equals(str))
      {
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getPhoneNumber(this.mMiniAppContext.getMiniAppInfo().appId, new TelephonyJsPlugin.1(this, paramRequestEvent));
        return;
      }
      paramRequestEvent.fail();
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("TelephonyJsPlugin", "handleNativeRequest", paramRequestEvent);
    }
  }
  
  @JsEvent({"makePhoneCall"})
  public void handleMakePhoneCall(RequestEvent paramRequestEvent)
  {
    boolean bool = TextUtils.isEmpty(paramRequestEvent.jsonParams);
    j = 0;
    i = j;
    if (!bool) {}
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams).optString("phoneNumber");
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tel:");
        localStringBuilder.append((String)localObject);
        localObject = new Intent("android.intent.action.DIAL", Uri.parse(localStringBuilder.toString()));
        this.mContext.startActivity((Intent)localObject);
        i = 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
    if (i != 0)
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin
 * JD-Core Version:    0.7.0.1
 */