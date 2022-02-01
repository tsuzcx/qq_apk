package com.tencent.mobileqq.vas.signature;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class SignatureEditManager
{
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt, String paramString)
  {
    a(paramActivity, paramAppInterface, paramInt, paramString, -1, -1, -1, null);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    a(paramActivity, paramAppInterface, paramInt1, paramString, paramInt2, -1, -1, null);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    String str2 = "signature_1";
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("fragmentStyle", 3);
    Object localObject1 = "";
    Object localObject2;
    String str1;
    if (paramInt1 == 0)
    {
      localObject2 = localObject1;
      if (paramBundle != null) {
        localObject2 = paramBundle.getString("signUrl");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        str1 = str2;
        if (((String)localObject2).contains(".qq.com")) {}
      }
      else
      {
        localObject1 = IndividuationUrlHelper.a("signatureEntrance");
        str1 = str2;
      }
      localObject2 = new StringBuilder((String)localObject1);
      if (!((String)localObject1).contains("?")) {
        break label324;
      }
      ((StringBuilder)localObject2).append("&signatureEdit=1");
      label117:
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
      if (QLog.isColorLevel()) {
        QLog.d(VasUtils.a, 2, "openSignatureEdit: url= " + ((StringBuilder)localObject2).toString());
      }
      localIntent.putExtra("url", ((StringBuilder)localObject2).toString());
      localIntent.putExtra("isTransparentTitle", true);
      localIntent.putExtra("via", paramString);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      if (paramBundle != null) {
        localIntent.putExtra("sign_extra", paramBundle);
      }
      if (paramInt2 != -1) {
        break label335;
      }
      paramActivity.startActivity(localIntent);
    }
    for (;;)
    {
      if (paramAppInterface != null) {
        VasWebviewUtil.reportCommercialDrainage(paramAppInterface.getCurrentAccountUin(), "signature", str1, paramString, 1, 0, 0, "", "", "");
      }
      return;
      str1 = str2;
      if (paramInt1 != 1) {
        break;
      }
      localObject1 = IndividuationUrlHelper.a("signatureDIYEntrance");
      localIntent.putExtra("open_diy", true);
      str1 = "signature_5";
      break;
      label324:
      ((StringBuilder)localObject2).append("?signatureEdit=1");
      break label117;
      label335:
      paramActivity.startActivityForResult(localIntent, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.signature.SignatureEditManager
 * JD-Core Version:    0.7.0.1
 */