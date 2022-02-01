package com.tencent.open.agent;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.QuickAuthorityConfBean;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.util;

class QuickLoginAuthorityActivity$1
  extends SSOAccountObserver
{
  QuickLoginAuthorityActivity$1(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->onFailed--action = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", ret = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", ssoAccount = *");
    ((StringBuilder)localObject).append(AuthorityUtil.a(paramString));
    QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject).toString());
    this.a.g();
    if (paramInt2 == -1000)
    {
      paramString = this.a;
      AuthUIUtil.a(paramString, paramString.getResources().getString(2131892333));
      return;
    }
    paramBundle = (ErrMsg)paramBundle.getParcelable("lastError");
    if (paramBundle == null) {
      paramBundle = this.a.getString(2131892330);
    } else {
      paramBundle = paramBundle.getMessage();
    }
    QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, new Object[] { "ssoAccount failed, error: ", paramBundle });
    localObject = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBundle);
    localStringBuilder.append("(");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(")");
    QQToast.makeText((Context)localObject, localStringBuilder.toString(), 0).show();
    this.a.a(paramString);
  }
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->onGetA1WithA1--ret = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", ssoAccount = *");
    ((StringBuilder)localObject).append(AuthorityUtil.a(paramString));
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    ((QuickLoginAuthorityActivity)localObject).b = OpenSdkVirtualUtil.a(((QuickLoginAuthorityActivity)localObject).k, paramString);
    this.a.c = null;
    paramString = new WloginSimpleInfo();
    this.a.k.getBasicUserInfo(this.a.b, paramString);
    paramArrayOfByte = new RSACrypt(this.a).EncryptData(this.a.o, paramArrayOfByte);
    paramString = (ErrMsg)paramBundle.getParcelable("errMsg");
    paramBundle = this.a;
    localObject = paramBundle.b;
    if (paramString == null) {
      paramString = "";
    } else {
      paramString = paramString.getMessage();
    }
    paramBundle.a(paramInt1, paramArrayOfByte, (String)localObject, paramString);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("-->onGetTicketNoPasswd--ssoAccount = *");
    paramBundle.append(AuthorityUtil.a(paramString));
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramBundle.toString());
    paramBundle = this.a;
    Object localObject = null;
    paramBundle.c = null;
    if ((paramBundle.h.containsKey("qrcode")) && (this.a.h.containsKey("schemacallback")))
    {
      QuickLoginAuthorityActivity.a(this.a);
      return;
    }
    if (this.a.h.containsKey("p"))
    {
      QuickAuthorityConfBean localQuickAuthorityConfBean = (QuickAuthorityConfBean)QConfigManager.b().b(546);
      if (paramInt == 32) {
        paramBundle = util.buf_to_string(paramArrayOfByte);
      } else {
        paramBundle = "";
      }
      String str1 = this.a.h.getString("p");
      paramArrayOfByte = str1;
      if (!TextUtils.isEmpty(str1))
      {
        paramArrayOfByte = str1;
        if (!str1.endsWith("&"))
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(str1);
          paramArrayOfByte.append("&");
          paramArrayOfByte = paramArrayOfByte.toString();
        }
      }
      paramString = "keyindex=19&clientuin=$CLIENTUIN$&clientkey=$CLIENTKEY$".replace("$CLIENTUIN$", paramString).replace("$CLIENTKEY$", paramBundle);
      paramBundle = new StringBuilder();
      paramBundle.append(paramArrayOfByte);
      paramBundle.append(paramString);
      String str2 = paramBundle.toString();
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
      str1 = this.a.h.getString("schemacallback");
      boolean bool = TextUtils.isEmpty(str1);
      paramBundle = "com.ijinshan.browser_fast";
      if (!bool)
      {
        if (str1.startsWith("mttbrowser://"))
        {
          paramString = "com.tencent.mtt";
          break label474;
        }
        if (str1.startsWith("ucweb://"))
        {
          paramString = "com.UCMobile";
          break label474;
        }
        if (str1.startsWith("bdbrowser://"))
        {
          paramString = "com.baidu.browser.apps";
          break label474;
        }
        if (str1.startsWith("bdapp://"))
        {
          paramString = "com.baidu.searchbox";
          break label474;
        }
        if (str1.startsWith("googlechrome://"))
        {
          paramString = "com.android.chrome";
          break label474;
        }
        if (str1.startsWith("mzbrowser://"))
        {
          paramString = "com.android.browser";
          break label474;
        }
        if (str1.startsWith("lb://"))
        {
          paramString = "com.ijinshan.browser_fast";
          break label474;
        }
        if (str1.startsWith("qihoobrowser://"))
        {
          paramString = "com.qihoo.browser";
          break label474;
        }
        if (str1.startsWith("browser2345://"))
        {
          paramString = "com.browser2345";
          break label474;
        }
        if (str1.startsWith("SogouMSE://"))
        {
          paramString = "sogou.mobile.explorer";
          break label474;
        }
      }
      paramString = null;
      label474:
      if (TextUtils.isEmpty(paramString))
      {
        paramArrayOfByte = Uri.parse(paramArrayOfByte).getQueryParameter("pt_browser");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("-->onGetTicketNoPasswd--schemacallback=");
        localStringBuilder.append(str1);
        localStringBuilder.append(",pt_browser=");
        localStringBuilder.append(paramArrayOfByte);
        QLog.i("SSOAccountObserver", 1, localStringBuilder.toString());
        if ((!TextUtils.isEmpty(paramArrayOfByte)) && ("LieBaoFast".equals(paramArrayOfByte))) {
          paramString = paramBundle;
        }
      }
      bool = TextUtils.isEmpty(paramString);
      int i = 0;
      paramInt = i;
      if (!bool)
      {
        try
        {
          paramArrayOfByte = this.a.getPackageManager().getPackageInfo(paramString, 0);
        }
        catch (PackageManager.NameNotFoundException paramArrayOfByte)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("-->onGetTicketNoPasswd exception:");
          paramBundle.append(paramArrayOfByte.getStackTrace().toString());
          QLog.e("SSOAccountObserver", 1, paramBundle.toString());
          paramArrayOfByte = localObject;
        }
        if (localQuickAuthorityConfBean.a == 1)
        {
          paramBundle = (String)localQuickAuthorityConfBean.f.get(paramString);
          paramInt = i;
          if (this.a.a(paramString, paramBundle))
          {
            paramInt = i;
            if (paramArrayOfByte == null) {}
          }
        }
        else
        {
          do
          {
            paramInt = 1;
            break;
            paramInt = i;
          } while (paramArrayOfByte != null);
        }
      }
      if (paramInt != 0)
      {
        localIntent.setPackage(paramString);
        localIntent.setData(Uri.parse(str2));
      }
      if ((localQuickAuthorityConfBean.b == 1) && (paramInt == 0))
      {
        this.a.g();
        QQToast.makeText(MobileQQ.sMobileQQ, HardCodeUtil.a(2131908843), 1).show();
      }
      else
      {
        try
        {
          this.a.startActivity(localIntent);
        }
        catch (Exception paramString)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("startActivity :");
          paramArrayOfByte.append(paramString.getMessage());
          QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramArrayOfByte.toString());
        }
        this.a.f();
      }
      paramArrayOfByte = new HashMap();
      paramArrayOfByte.put("callback", str1);
      if (paramInt != 0) {
        paramString = "1";
      } else {
        paramString = "0";
      }
      paramArrayOfByte.put("checkRes", paramString);
      StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", "kQuickLoginForBrowser", true, 0L, 0L, paramArrayOfByte, "");
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("-->onUserCancel--action = ");
    paramBundle.append(paramInt);
    paramBundle.append(", ssoAccount = *");
    paramBundle.append(AuthorityUtil.a(paramString));
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, paramBundle.toString());
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.1
 * JD-Core Version:    0.7.0.1
 */