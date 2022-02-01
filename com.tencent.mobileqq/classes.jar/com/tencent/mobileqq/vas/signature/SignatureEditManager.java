package com.tencent.mobileqq.vas.signature;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class SignatureEditManager
{
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt, String paramString)
  {
    a(paramActivity, paramAppInterface, paramInt, paramString, -1, -1, -1, null);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    a(paramActivity, paramAppInterface, paramInt1, paramString, -1, -1, -1, null, paramInt2);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    a(paramActivity, paramAppInterface, paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramBundle, 0);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle, int paramInt5)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("fragmentStyle", 3);
    Object localObject4 = "signature_1";
    Object localObject1 = "";
    Object localObject3;
    if (paramInt1 == 0)
    {
      localObject2 = localObject1;
      if (paramBundle != null) {
        localObject2 = paramBundle.getString("signUrl");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject3 = localObject4;
        localObject1 = localObject2;
        if (((String)localObject2).contains(".qq.com")) {}
      }
      else
      {
        localObject1 = IndividuationUrlHelper.a("signatureEntrance");
        localObject3 = localObject4;
      }
    }
    else
    {
      localObject3 = localObject4;
      if (paramInt1 == 1)
      {
        localObject1 = IndividuationUrlHelper.a("signatureDIYEntrance");
        localIntent.putExtra("open_diy", true);
        localObject3 = "signature_5";
      }
    }
    Object localObject2 = new StringBuilder((String)localObject1);
    if (((String)localObject1).contains("?")) {
      ((StringBuilder)localObject2).append("&signatureEdit=1");
    } else {
      ((StringBuilder)localObject2).append("?signatureEdit=1");
    }
    if (paramInt3 > -1)
    {
      ((StringBuilder)localObject2).append("&templateId=");
      ((StringBuilder)localObject2).append(paramInt3);
    }
    if (paramInt4 > -1)
    {
      ((StringBuilder)localObject2).append("&fontId=");
      ((StringBuilder)localObject2).append(paramInt4);
    }
    localObject1 = VasWebviewUtil.b(((StringBuilder)localObject2).toString(), paramInt5);
    if (QLog.isColorLevel())
    {
      localObject2 = VasUtils.a;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("openSignatureEdit: url= ");
      ((StringBuilder)localObject4).append((String)localObject1);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject4).toString());
    }
    localIntent.putExtra("url", (String)localObject1);
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("via", paramString);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    if (paramBundle != null) {
      localIntent.putExtra("sign_extra", paramBundle);
    }
    if (paramInt2 == -1) {
      paramActivity.startActivity(localIntent);
    } else {
      paramActivity.startActivityForResult(localIntent, paramInt2);
    }
    if (paramAppInterface != null) {
      VasWebviewUtil.a(paramAppInterface.getCurrentAccountUin(), "signature", (String)localObject3, paramString, 1, 0, 0, "", "", "");
    }
  }
  
  public static void b(Activity paramActivity, AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    a(paramActivity, paramAppInterface, paramInt1, paramString, paramInt2, -1, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.signature.SignatureEditManager
 * JD-Core Version:    0.7.0.1
 */