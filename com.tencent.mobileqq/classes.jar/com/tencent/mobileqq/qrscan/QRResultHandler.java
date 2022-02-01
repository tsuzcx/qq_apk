package com.tencent.mobileqq.qrscan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.api.ICrmApi;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.activity.QRCardActivity;
import com.tencent.mobileqq.qrscan.activity.QRJumpActivity;
import com.tencent.mobileqq.qrscan.activity.ScannerActivity;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.StringUtil;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QRResultHandler
{
  public static int a(AppRuntime paramAppRuntime, Activity paramActivity, QRActionEntity paramQRActionEntity, String paramString, Bundle paramBundle)
  {
    if ((paramQRActionEntity != null) && (paramQRActionEntity.c() != 0)) {}
    try
    {
      int i = paramQRActionEntity.c;
      if (i == 1) {
        break label278;
      }
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 6)
          {
            if (i != 10)
            {
              a(paramAppRuntime, paramActivity, paramString);
              return 0;
            }
            a(paramAppRuntime, paramActivity, ((IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class)).getUin(paramQRActionEntity.b().b()), paramBundle);
            return 10;
          }
          a(paramActivity, paramQRActionEntity);
          return paramQRActionEntity.c;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramQRActionEntity.b().c());
        ((StringBuilder)localObject1).append("");
        a(paramAppRuntime, paramActivity, ((StringBuilder)localObject1).toString(), paramBundle);
        return 3;
      }
      str = paramBundle.getString("authSig");
      if (TextUtils.isEmpty(paramString)) {
        break label359;
      }
      localObject1 = Uri.parse(paramString);
      if ((localObject1 == null) || (!((Uri)localObject1).isHierarchical())) {
        break label359;
      }
      localObject3 = ((Uri)localObject1).getQueryParameter("jump_from");
      localObject2 = ((Uri)localObject1).getQueryParameter("source_id");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label348;
      }
      localObject1 = paramBundle.getString("sourceId", "");
    }
    catch (Exception paramQRActionEntity)
    {
      for (;;)
      {
        String str;
        Object localObject3;
        continue;
        Object localObject2 = localObject1;
        Object localObject1 = localObject3;
        continue;
        localObject1 = "";
        localObject2 = localObject1;
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramQRActionEntity.b().c());
    ((StringBuilder)localObject3).append("");
    a(paramAppRuntime, paramActivity, ((StringBuilder)localObject3).toString(), (String)localObject1, (String)localObject2, paramBundle.getString("authKey"), str);
    return 2;
    label278:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramQRActionEntity.b().c());
    ((StringBuilder)localObject1).append("");
    a(paramAppRuntime, paramActivity, ((StringBuilder)localObject1).toString(), paramBundle.getBoolean("issupportwpa", false));
    return 1;
    a(paramAppRuntime, paramActivity, paramString);
    return 0;
    a(paramAppRuntime, paramActivity, paramString);
    return 0;
  }
  
  private static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (!"".equals(paramString)) {
        if (paramString.length() == 0) {
          return null;
        }
      }
    }
    try
    {
      localObject1 = new String(Base64Util.decode(paramString, 0));
      return localObject1;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private static void a(Context paramContext, QRActionEntity paramQRActionEntity)
  {
    AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    long l = paramQRActionEntity.b().c();
    ((ICrmApi)localAppRuntime.getRuntimeService(ICrmApi.class, "")).gotoCrmMainProfile(paramContext, null, String.valueOf(l), false, 1, true, -1);
  }
  
  public static void a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString)
  {
    paramAppRuntime = new Intent(paramActivity, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("https://qm.qq.com/cgi-bin/result");
    localStringBuilder.append("?p=a&v=");
    localStringBuilder.append(DeviceInfoUtil.e());
    localStringBuilder.append("&r=");
    localStringBuilder.append(URLEncoder.encode(paramString).replaceAll("\\+", "%20"));
    localStringBuilder.append("&_wv=1027");
    paramString = localStringBuilder.toString();
    paramAppRuntime.putExtra("title", paramActivity.getString(2131914190));
    paramAppRuntime.putExtra("url", paramString);
    paramAppRuntime.putExtra("key_isReadModeEnabled", true);
    if (paramActivity.getIntent().getBooleanExtra("fromPicQRDecode", false) == true)
    {
      paramActivity.startActivityForResult(paramAppRuntime, 2);
      return;
    }
    paramActivity.startActivity(paramAppRuntime);
  }
  
  public static void a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString, int paramInt)
  {
    paramAppRuntime = new Intent(paramActivity, QRCardActivity.class);
    paramAppRuntime.putExtra("CARDMODE", paramInt);
    paramAppRuntime.putExtra("QRCARDSTR", paramString);
    paramActivity.startActivity(paramAppRuntime);
  }
  
  private static final void a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    if (paramBundle != null)
    {
      String str = paramBundle.getString("extvalue");
      paramBundle = paramBundle.getString("exttype");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramBundle)))
      {
        localIntent.putExtra("extvalue", str);
        localIntent.putExtra("exttype", paramBundle);
      }
    }
    localIntent.putExtra("source", 1);
    paramBundle = (IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class);
    paramAppRuntime = (AppInterface)paramAppRuntime;
    paramBundle.gotoProfile(localIntent, paramAppRuntime, paramActivity, paramString, -1);
    ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(paramAppRuntime, paramString, "Pb_account_lifeservice", "mp_msg_sys_1", "scan");
  }
  
  private static void a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("src_type", "internal");
    localBundle.putString("version", "1");
    localBundle.putString("callback_type", "scheme");
    localBundle.putString("callback_name", "open_card");
    localBundle.putString("uin", paramString1);
    localBundle.putString("card_type", "group");
    localBundle.putString("authKey", paramString4);
    localBundle.putString("authSig", paramString5);
    localBundle.putString("from", "qrcode");
    if (!TextUtils.isEmpty(JumpAction.y)) {
      localBundle.putString("appid", JumpAction.y);
    }
    if (!TextUtils.isEmpty(JumpAction.z)) {
      localBundle.putString("openid", a(JumpAction.z));
    }
    JumpAction.y = null;
    JumpAction.z = null;
    paramString1 = paramString2;
    if (StringUtil.isEmpty(paramString2))
    {
      if ((paramActivity instanceof ScannerActivity)) {}
      do
      {
        paramString1 = "ScannerActivity";
        break;
        paramString1 = paramString2;
        if (!(paramActivity instanceof QRJumpActivity)) {
          break;
        }
      } while (paramActivity.getIntent().getBooleanExtra("fromQrcode", false));
      paramString1 = "QRJumpActivity";
    }
    if (!StringUtil.isEmpty(paramString3)) {
      localBundle.putString("source_id", paramString3);
    }
    localBundle.putString("jump_from", paramString1);
    paramString1 = new StringBuilder();
    paramString1.append("mqqapi://card/show_pslcard?");
    paramString1.append(HttpUtil.encodeUrl(localBundle));
    paramString1 = Uri.parse(paramString1.toString());
    paramAppRuntime = JumpParser.a((BaseQQAppInterface)paramAppRuntime, paramActivity, paramString1.toString());
    if (paramAppRuntime != null) {
      paramAppRuntime.a();
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("src_type", "internal");
    String str = "1";
    localBundle.putString("version", "1");
    localBundle.putString("callback_type", "scheme");
    localBundle.putString("callback_name", "open_card");
    localBundle.putString("uin", paramString);
    if (paramBoolean) {
      paramString = str;
    } else {
      paramString = "0";
    }
    localBundle.putString("wpa", paramString);
    paramString = new StringBuilder();
    paramString.append("mqqapi://card/show_pslcard?");
    paramString.append(HttpUtil.encodeUrl(localBundle));
    paramString = Uri.parse(paramString.toString());
    paramAppRuntime = JumpParser.a((BaseQQAppInterface)paramAppRuntime, paramActivity, paramString.toString());
    if (paramAppRuntime != null)
    {
      paramAppRuntime.j();
      paramAppRuntime.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.QRResultHandler
 * JD-Core Version:    0.7.0.1
 */