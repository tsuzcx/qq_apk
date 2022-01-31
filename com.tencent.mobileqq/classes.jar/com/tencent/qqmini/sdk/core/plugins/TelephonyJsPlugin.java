package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import bdcz;
import bdde;
import bdfz;
import bdgi;
import bdnw;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class TelephonyJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "TelephonyJsPlugin";
  
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
          paramString2.putExtra("phone_type", "手机");
        }
        if (!TextUtils.isEmpty(str28))
        {
          paramString2.putExtra("secondary_phone", str28);
          paramString2.putExtra("secondary_phone_type", "住宅");
        }
        if (!TextUtils.isEmpty(str26))
        {
          paramString2.putExtra("tertiary_phone", str26);
          paramString2.putExtra("tertiary_phone_type", "工作");
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
          ((ContentValues)localObject).put("data3", "手机");
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
          ((ContentValues)localObject).put("data3", "住宅传真");
          ((ContentValues)localObject).put("data1", str19);
          paramString1.add(localObject);
        }
        if (!TextUtils.isEmpty(str18))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/phone_v2");
          ((ContentValues)localObject).put("data2", Integer.valueOf(0));
          ((ContentValues)localObject).put("data3", "单位传真");
          ((ContentValues)localObject).put("data1", str18);
          paramString1.add(localObject);
        }
        if ((!TextUtils.isEmpty(str13)) || (!TextUtils.isEmpty(str14)) || (!TextUtils.isEmpty(str15)) || (!TextUtils.isEmpty(str16)) || (!TextUtils.isEmpty(str17)))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/postal-address_v2");
          ((ContentValues)localObject).put("data2", Integer.valueOf(1));
          ((ContentValues)localObject).put("data3", "住宅");
          ((ContentValues)localObject).put("data1", str13 + " " + str14 + " " + str15 + " " + str16 + " " + str17);
          paramString1.add(localObject);
        }
        if ((!TextUtils.isEmpty(str7)) || (!TextUtils.isEmpty(str8)) || (!TextUtils.isEmpty(str9)) || (!TextUtils.isEmpty(str10)) || (!TextUtils.isEmpty(str11)))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/postal-address_v2");
          ((ContentValues)localObject).put("data2", Integer.valueOf(2));
          ((ContentValues)localObject).put("data3", "单位");
          ((ContentValues)localObject).put("data1", str7 + " " + str8 + " " + str9 + " " + str10 + " " + str11);
          paramString1.add(localObject);
        }
        if ((!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str4)) || (!TextUtils.isEmpty(str5)) || (!TextUtils.isEmpty(str6)) || (!TextUtils.isEmpty(str12)))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/postal-address_v2");
          ((ContentValues)localObject).put("data2", Integer.valueOf(1));
          ((ContentValues)localObject).put("data3", "住宅");
          ((ContentValues)localObject).put("data1", str3 + " " + str4 + " " + str5 + " " + str6 + " " + str12);
          paramString1.add(localObject);
        }
        if (!TextUtils.isEmpty(str2))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/website");
          ((ContentValues)localObject).put("data2", Integer.valueOf(2));
          ((ContentValues)localObject).put("data3", "网址");
          ((ContentValues)localObject).put("data1", str2);
          paramString1.add(localObject);
        }
        if (!TextUtils.isEmpty(str1))
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("mimetype", "vnd.android.cursor.item/nickname");
          ((ContentValues)localObject).put("data2", Integer.valueOf(0));
          ((ContentValues)localObject).put("data3", "昵称");
          ((ContentValues)localObject).put("data1", str1);
          paramString1.add(localObject);
        }
        paramString2.putParcelableArrayListExtra("data", paramString1);
        if (this.mMiniAppContext.a() == null) {
          break;
        }
        this.mMiniAppContext.a().startActivity(paramString2);
        return;
        paramString2 = new Intent("android.intent.action.INSERT_OR_EDIT");
        paramString2.setType("vnd.android.cursor.item/contact");
      }
      return;
    }
    catch (Throwable paramString1)
    {
      bdnw.d("TelephonyJsPlugin", paramString1.getMessage(), paramString1);
    }
  }
  
  public String addPhoneContact(bdfz parambdfz)
  {
    bdgi.a(new TelephonyJsPlugin.2(this, parambdfz));
    return parambdfz.a();
  }
  
  public void getPhoneNumber(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.b).optJSONObject("data");
      String str = localJSONObject.optString("api_name", "");
      localJSONObject.optBoolean("with_credentials", true);
      if ("webapi_getuserwxphone".equals(str))
      {
        if (MiniAppEnv.g().getAuthSate(this.mMiniAppContext.a().appId).a(parambdfz.a))
        {
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getPhoneNumber(this.mMiniAppContext.a().appId, new TelephonyJsPlugin.1(this, parambdfz));
          return;
        }
        parambdfz.b();
        return;
      }
    }
    catch (JSONException parambdfz)
    {
      bdnw.d("TelephonyJsPlugin", "handleNativeRequest", parambdfz);
    }
  }
  
  public void handleMakePhoneCall(bdfz parambdfz)
  {
    j = 0;
    i = j;
    if (!TextUtils.isEmpty(parambdfz.b)) {}
    try
    {
      Object localObject = new JSONObject(parambdfz.b).optString("phoneNumber");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label111;
      }
      i = 1;
      localObject = new Intent("android.intent.action.CALL", Uri.parse("tel:" + (String)localObject));
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
      parambdfz.a();
      return;
    }
    parambdfz.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.TelephonyJsPlugin
 * JD-Core Version:    0.7.0.1
 */