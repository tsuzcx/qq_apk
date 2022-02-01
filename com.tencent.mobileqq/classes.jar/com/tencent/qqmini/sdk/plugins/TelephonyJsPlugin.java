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
      for (;;)
      {
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
        if (!TextUtils.isEmpty((CharSequence)localObject1))
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
        if (this.mMiniAppContext.getAttachedActivity() == null) {
          break;
        }
        this.mMiniAppContext.getAttachedActivity().startActivity(paramString1);
        return;
        paramString1 = new Intent("android.intent.action.INSERT_OR_EDIT");
        paramString1.setType("vnd.android.cursor.item/contact");
      }
      return;
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
      String str = paramString1;
      if (!TextUtils.isEmpty(paramString2)) {
        str = paramString1 + " " + paramString2;
      }
      paramString1 = str;
      if (!TextUtils.isEmpty(paramString3)) {
        paramString1 = str + " " + paramString3;
      }
      paramIntent.putExtra("name", paramString1.trim());
    }
  }
  
  private void parseNumber(JSONObject paramJSONObject, ArrayList<ContentValues> paramArrayList)
  {
    Object localObject2 = paramJSONObject.optString("hostNumber");
    Object localObject1 = paramJSONObject.optString("photoFilePath");
    String str = paramJSONObject.optString("workFaxNumber");
    paramJSONObject = paramJSONObject.optString("homeFaxNumber");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
      localContentValues.put("data2", Integer.valueOf(0));
      localContentValues.put("data3", "手机");
      localContentValues.put("data1", (String)localObject2);
      paramArrayList.add(localContentValues);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("mimetype", "vnd.android.cursor.item/photo");
      ((ContentValues)localObject2).put("data15", (String)localObject1);
      paramArrayList.add(localObject2);
    }
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      localObject1 = new ContentValues();
      ((ContentValues)localObject1).put("mimetype", "vnd.android.cursor.item/phone_v2");
      ((ContentValues)localObject1).put("data2", Integer.valueOf(0));
      ((ContentValues)localObject1).put("data3", "住宅传真");
      ((ContentValues)localObject1).put("data1", paramJSONObject);
      paramArrayList.add(localObject1);
    }
    if (!TextUtils.isEmpty(str))
    {
      paramJSONObject = new ContentValues();
      paramJSONObject.put("mimetype", "vnd.android.cursor.item/phone_v2");
      paramJSONObject.put("data2", Integer.valueOf(0));
      paramJSONObject.put("data3", "单位传真");
      paramJSONObject.put("data1", str);
      paramArrayList.add(paramJSONObject);
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
      localContentValues.put("data1", str1 + " " + str2 + " " + str3 + " " + str4 + " " + paramJSONObject);
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
      localContentValues.put("data1", str1 + " " + str2 + " " + str3 + " " + str4 + " " + paramJSONObject);
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
      localContentValues.put("data1", str1 + " " + str2 + " " + str3 + " " + str4 + " " + paramJSONObject);
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
    j = 0;
    i = j;
    if (!TextUtils.isEmpty(paramRequestEvent.jsonParams)) {}
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams).optString("phoneNumber");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label111;
      }
      i = 1;
      localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + (String)localObject));
      this.mContext.startActivity((Intent)localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
        continue;
        i = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin
 * JD-Core Version:    0.7.0.1
 */