package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IVPluginManager;
import com.tencent.mobileqq.intervideo.impl.Shadow;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.shadow.dynamic.host.EnterCallback;
import java.util.concurrent.ExecutorService;

public class NowShadowImpl
  implements IShadow
{
  private IVPluginManager a;
  
  private void a(String paramString)
  {
    try
    {
      PluginManagerInterfaceImpl.a().a().b("enter_shadow_err").c(paramString).b();
      ThreadManagerV2.getUIHandlerV2().post(new NowShadowImpl.2(this));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public IVPluginManager a(Context paramContext, String paramString1, String paramString2)
  {
    return Shadow.a(paramContext, paramString1, paramString2);
  }
  
  public void enter(Context paramContext, long paramLong, String paramString1, String paramString2, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    ThreadManagerExecutor.getSingleThreadExecutorService(192).execute(new NowShadowImpl.1(this, paramContext, paramString1, paramString2, paramLong, paramBundle, paramEnterCallback));
  }
  
  public boolean hasPluginManager()
  {
    return this.a != null;
  }
  
  public void setILoggerFactory() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.NowShadowImpl
 * JD-Core Version:    0.7.0.1
 */