package com.tencent.mobileqq.webview.swift.utils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class SwiftWebAccelerator$5
  implements Runnable
{
  SwiftWebAccelerator$5(SwiftWebAccelerator paramSwiftWebAccelerator, long paramLong, Bundle paramBundle) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doThreadedStep_LoadConfigs.run cost ");
    ((StringBuilder)localObject).append(l - this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)localObject).toString());
    l = System.currentTimeMillis();
    BaseInnerDns.getInstance();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doThreadedStep_LoadConfigs:init inner-dns cost ");
    ((StringBuilder)localObject).append(l - this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)localObject).toString());
    l = System.currentTimeMillis();
    localObject = AuthorizeConfig.a(false);
    ((AuthorizeConfig)localObject).a("https://www.qq.com/", "foo.bar");
    ((AuthorizeConfig)localObject).a("skey");
    ((AuthorizeConfig)localObject).a("pskey");
    ((AuthorizeConfig)localObject).a("pt4_token");
    ((AuthorizeConfig)localObject).a("a1");
    ((AuthorizeConfig)localObject).a("a2");
    ((AuthorizeConfig)localObject).a("https://www.qq.com/");
    ((AuthorizeConfig)localObject).a();
    ((AuthorizeConfig)localObject).b();
    ((AuthorizeConfig)localObject).e();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doThreadedStep_LoadConfigs:load domain white list config, cost ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    ((StringBuilder)localObject).append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)localObject).toString());
    l = System.currentTimeMillis();
    if (WebAccelerateHelper.getInstance().isPreGetKey()) {
      SwiftBrowserCookieMonster.a(MobileQQ.sMobileQQ.waitAppRuntime(null), new Intent());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doThreadedStep_LoadConfigs:pre get key, cost ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    ((StringBuilder)localObject).append("ms.");
    QLog.i("WebLog_SwiftWebAccelerator", 1, ((StringBuilder)localObject).toString());
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("from", -1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doThreadedStep_LoadConfigs: preload from ");
      ((StringBuilder)localObject).append(i);
      QLog.d("WebLog_SwiftWebAccelerator", 2, ((StringBuilder)localObject).toString());
    }
    new Handler(Looper.getMainLooper()).post(new SwiftWebAccelerator.5.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.5
 * JD-Core Version:    0.7.0.1
 */