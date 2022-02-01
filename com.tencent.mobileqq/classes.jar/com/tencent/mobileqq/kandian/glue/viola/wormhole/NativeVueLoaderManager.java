package com.tencent.mobileqq.kandian.glue.viola.wormhole;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.nativevue.NativeVueEngine;
import com.tencent.nativevue.NativeVueEngine.Builder;
import com.tencent.nativevue.NativeVueEngine.DomResult;
import com.tencent.nativevue.NativeVuePreconditionAdapter;
import com.tencent.nativevue.NativeVuePreconditionAdapter.LoadSoResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.utils.ViolaUtils;

public class NativeVueLoaderManager
  implements NativeVuePreconditionAdapter
{
  private static volatile NativeVueLoaderManager a;
  private volatile boolean b;
  private String c;
  private Handler d = new Handler(Looper.getMainLooper());
  
  public static NativeVueLoaderManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new NativeVueLoaderManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(long paramLong, String paramString)
  {
    ViolaUtils.reportNVCost(paramLong);
    IReportDelegate localIReportDelegate = ViolaSDKManager.getInstance().getReportDelegate();
    if (localIReportDelegate != null) {
      localIReportDelegate.reportData(paramString);
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int j = Aladdin.getConfig(366).getIntegerFromString("disable_native_vue_render_dom", 0);
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i != 0) {
      return false;
    }
    return "1".equals(Uri.parse(paramString).getQueryParameter("supportNV"));
  }
  
  private void e()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    NativeVueEngine.Builder localBuilder = new NativeVueEngine.Builder().env("ViolaEnv", ViolaBizUtils.a()).logAdapter(new NativeVueLoaderManager.NVLogAdapter(null)).preconditionAdapter(this);
    NativeVueEngine.getInstance().init(localBuilder);
    if (QLog.isColorLevel()) {
      QLog.d("NativeVueLoaderManager", 2, "init NativeVue");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, NativeVueEngine.DomResult paramDomResult)
  {
    e();
    if (paramString1 == null)
    {
      QLog.e("NativeVueLoaderManager", 1, "data is null");
      if (paramDomResult != null) {
        paramDomResult.onResult("");
      }
    }
    paramString2 = ViolaUtils.getVueDomFromJsSource(paramString2, "@nativeDom");
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("NativeVueLoaderManager", 1, "fail to get vueDom from js source");
      if (paramDomResult != null)
      {
        paramDomResult.onResult("");
        return;
      }
    }
    this.c = paramString3;
    NativeVueEngine.getInstance().createVDom(paramString1, paramString2, paramInt, new NativeVueLoaderManager.NVDomResultProxy(this, paramDomResult, paramString3));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, NativeVueEngine.DomResult paramDomResult)
  {
    a(paramString1, paramString2, paramString3, 0, paramDomResult);
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void c()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(365);
    int i = 0;
    if (localAladdinConfig.getIntegerFromString("disable_preload_native_vue", 0) == 1) {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    e();
    if (QLog.isColorLevel()) {
      QLog.d("NativeVueLoaderManager", 2, "preInitNativeVue");
    }
  }
  
  public void d()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(336);
    int i = 0;
    if (localAladdinConfig.getIntegerFromString("disable_native_vue_predownload", 0) == 1) {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    ViolaSDKManager.getInstance().getDomManager().post(new NativeVueLoaderManager.1(this));
  }
  
  public void loadNativeVueSo(NativeVuePreconditionAdapter.LoadSoResult paramLoadSoResult)
  {
    SoLoadManager.getInstance().load("nativevue", new NativeVueLoaderManager.2(this, paramLoadSoResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.wormhole.NativeVueLoaderManager
 * JD-Core Version:    0.7.0.1
 */