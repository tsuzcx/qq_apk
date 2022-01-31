package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajyc;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONObject;

public class ContactJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_ADD_PHONE_CONTACT = "addPhoneContact";
  public static final String EVENT_ENTER_CONTACT = "enterContact";
  public static final String EVENT_OPEN_CONSTOMER_SERVICE_CONVERSATION = "openCustomerServiceConversation";
  private static final Set<String> S_EVENT_MAP = new ContactJsPlugin.1();
  private static final String TAG = ContactJsPlugin.class.getSimpleName();
  private Handler mainHandler = new Handler(Looper.getMainLooper());
  
  private void doAddPhoneContact(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      paramString1 = new JSONObject(paramString2);
      Object localObject = paramString1.optString("firstName");
      String str30 = paramString1.optString("middleName");
      String str29 = paramString1.optString("lastName");
      String str1 = paramString1.optString("nickName");
      String str20 = paramString1.optString("photoFilePath");
      String str22 = paramString1.optString("remark");
      String str23 = paramString1.optString("mobilePhoneNumber");
      paramString1.optString("weChatNumber");
      String str13 = paramString1.optString("addressCountry");
      String str14 = paramString1.optString("addressState");
      String str15 = paramString1.optString("addressCity");
      String str16 = paramString1.optString("addressStreet");
      String str17 = paramString1.optString("addressPostalCode");
      String str24 = paramString1.optString("organization");
      String str25 = paramString1.optString("title");
      String str18 = paramString1.optString("workFaxNumber");
      String str26 = paramString1.optString("workPhoneNumber");
      String str21 = paramString1.optString("hostNumber");
      String str27 = paramString1.optString("email");
      String str2 = paramString1.optString("url");
      String str7 = paramString1.optString("workAddressCountry");
      String str8 = paramString1.optString("workAddressState");
      String str9 = paramString1.optString("workAddressCity");
      String str10 = paramString1.optString("workAddressStreet");
      String str11 = paramString1.optString("workAddressPostalCode");
      String str19 = paramString1.optString("homeFaxNumber");
      String str28 = paramString1.optString("homePhoneNumber");
      String str3 = paramString1.optString("homeAddressCountry");
      String str4 = paramString1.optString("homeAddressState");
      String str5 = paramString1.optString("homeAddressCity");
      String str6 = paramString1.optString("homeAddressStreet");
      String str12 = paramString1.optString("homeAddressPostalCode");
      if (paramBoolean)
      {
        paramString2 = new Intent("android.intent.action.INSERT");
        paramString2.setType("vnd.android.cursor.dir/raw_contact");
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.isEmpty(str30)) || (!TextUtils.isEmpty(str29)))
        {
          paramString1 = (String)localObject;
          if (!TextUtils.isEmpty(str30)) {
            paramString1 = (String)localObject + " " + str30;
          }
          localObject = paramString1;
          if (!TextUtils.isEmpty(str29)) {
            localObject = paramString1 + " " + str29;
          }
          paramString2.putExtra("name", ((String)localObject).trim());
        }
        if (!TextUtils.isEmpty(str23))
        {
          paramString2.putExtra("phone", str23);
          paramString2.putExtra("phone_type", ajyc.a(2131702476));
        }
        if (!TextUtils.isEmpty(str28))
        {
          paramString2.putExtra("secondary_phone", str28);
          paramString2.putExtra("secondary_phone_type", ajyc.a(2131702477));
        }
        if (!TextUtils.isEmpty(str26))
        {
          paramString2.putExtra("tertiary_phone", str26);
          paramString2.putExtra("tertiary_phone_type", ajyc.a(2131702480));
        }
        paramString2.putExtra("notes", str22);
        paramString2.putExtra("company", str24);
        paramString2.putExtra("job_title", str25);
        paramString2.putExtra("email", str27);
        paramString1 = new ArrayList();
        if (!TextUtils.isEmpty(str21))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/phone_v2");
          ((ContentValues)localObject).put("data2", Integer.valueOf(0));
          ((ContentValues)localObject).put("data3", ajyc.a(2131702473));
          ((ContentValues)localObject).put("data1", str21);
          paramString1.add(localObject);
        }
        if (!TextUtils.isEmpty(str20))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/photo");
          ((ContentValues)localObject).put("data15", str20);
          paramString1.add(localObject);
        }
        if (!TextUtils.isEmpty(str19))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/phone_v2");
          ((ContentValues)localObject).put("data2", Integer.valueOf(0));
          ((ContentValues)localObject).put("data3", ajyc.a(2131702472));
          ((ContentValues)localObject).put("data1", str19);
          paramString1.add(localObject);
        }
        if (!TextUtils.isEmpty(str18))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/phone_v2");
          ((ContentValues)localObject).put("data2", Integer.valueOf(0));
          ((ContentValues)localObject).put("data3", ajyc.a(2131702479));
          ((ContentValues)localObject).put("data1", str18);
          paramString1.add(localObject);
        }
        if ((!TextUtils.isEmpty(str13)) || (!TextUtils.isEmpty(str14)) || (!TextUtils.isEmpty(str15)) || (!TextUtils.isEmpty(str16)) || (!TextUtils.isEmpty(str17)))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/postal-address_v2");
          ((ContentValues)localObject).put("data2", Integer.valueOf(1));
          ((ContentValues)localObject).put("data3", ajyc.a(2131702470));
          ((ContentValues)localObject).put("data1", str13 + " " + str14 + " " + str15 + " " + str16 + " " + str17);
          paramString1.add(localObject);
        }
        if ((!TextUtils.isEmpty(str7)) || (!TextUtils.isEmpty(str8)) || (!TextUtils.isEmpty(str9)) || (!TextUtils.isEmpty(str10)) || (!TextUtils.isEmpty(str11)))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/postal-address_v2");
          ((ContentValues)localObject).put("data2", Integer.valueOf(2));
          ((ContentValues)localObject).put("data3", ajyc.a(2131702478));
          ((ContentValues)localObject).put("data1", str7 + " " + str8 + " " + str9 + " " + str10 + " " + str11);
          paramString1.add(localObject);
        }
        if ((!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str4)) || (!TextUtils.isEmpty(str5)) || (!TextUtils.isEmpty(str6)) || (!TextUtils.isEmpty(str12)))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/postal-address_v2");
          ((ContentValues)localObject).put("data2", Integer.valueOf(1));
          ((ContentValues)localObject).put("data3", ajyc.a(2131702482));
          ((ContentValues)localObject).put("data1", str3 + " " + str4 + " " + str5 + " " + str6 + " " + str12);
          paramString1.add(localObject);
        }
        if (!TextUtils.isEmpty(str2))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/website");
          ((ContentValues)localObject).put("data2", Integer.valueOf(2));
          ((ContentValues)localObject).put("data3", ajyc.a(2131702474));
          ((ContentValues)localObject).put("data1", str2);
          paramString1.add(localObject);
        }
        if (!TextUtils.isEmpty(str1))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/nickname");
          ((ContentValues)localObject).put("data2", Integer.valueOf(0));
          ((ContentValues)localObject).put("data3", ajyc.a(2131702481));
          ((ContentValues)localObject).put("data1", str1);
          paramString1.add(localObject);
        }
        paramString2.putParcelableArrayListExtra("data", paramString1);
        this.jsPluginEngine.appBrandRuntime.activity.startActivity(paramString2);
        return;
        paramString2 = new Intent("android.intent.action.INSERT_OR_EDIT");
        paramString2.setType("vnd.android.cursor.item/contact");
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QZLog.e(TAG, 1, paramString1, new Object[0]);
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d(TAG, 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("addPhoneContact".equals(paramString1)) {
      try
      {
        this.mainHandler.post(new ContactJsPlugin.2(this, paramString1, paramString2));
        String str = ApiUtil.wrapCallbackOk(paramString1, new JSONObject()).toString();
        return str;
      }
      catch (Throwable localThrowable)
      {
        QZLog.e(TAG, 1, localThrowable, new Object[0]);
        paramJsRuntime.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail(paramString1, null).toString());
      }
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      if (("enterContact".equals(paramString1)) || ("openCustomerServiceConversation".equals(paramString1))) {
        MiniAppCmdUtil.getInstance().getRobotUin(getAppId(), new ContactJsPlugin.3(this, paramJsRuntime, paramString1, paramInt));
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ContactJsPlugin
 * JD-Core Version:    0.7.0.1
 */