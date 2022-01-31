package com.tencent.mobileqq.webview.swift.utils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import ayxg;
import bcgn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import mvs;

public class SwiftWebAccelerator$5
  implements Runnable
{
  public SwiftWebAccelerator$5(bcgn parambcgn, long paramLong, Bundle paramBundle) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_LoadConfigs.run cost " + (l - this.jdField_a_of_type_Long) + "ms.");
    l = System.currentTimeMillis();
    ayxg.a();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_LoadConfigs:init inner-dns cost " + (l - this.jdField_a_of_type_Long) + "ms.");
    l = System.currentTimeMillis();
    mvs localmvs = mvs.a(false);
    localmvs.a("http://www.qq.com/", "foo.bar");
    localmvs.a("skey");
    localmvs.a("pskey");
    localmvs.a("pt4_token");
    localmvs.a("a1");
    localmvs.a("a2");
    localmvs.b("http://www.qq.com/");
    localmvs.a();
    localmvs.b();
    localmvs.e();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_LoadConfigs:load domain white list config, cost " + (System.currentTimeMillis() - l) + "ms.");
    l = System.currentTimeMillis();
    if (WebAccelerateHelper.getInstance().isPreGetKey()) {
      SwiftBrowserCookieMonster.a(BaseApplicationImpl.sApplication.getRuntime(), new Intent());
    }
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_LoadConfigs:pre get key, cost " + (System.currentTimeMillis() - l) + "ms.");
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("from", -1);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_SwiftWebAccelerator", 2, "doThreadedStep_LoadConfigs: preload from " + i);
    }
    new Handler(Looper.getMainLooper()).post(new SwiftWebAccelerator.5.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.5
 * JD-Core Version:    0.7.0.1
 */