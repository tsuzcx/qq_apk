package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.util.Log;
import com.tencent.qqmini.proxyimpl.tavkitplugin.BaseTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.TavObjPool;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.tav.decoder.logger.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public abstract class BaseTavApiProxy
{
  protected final String a;
  protected RequestEvent b;
  protected IMiniAppContext c;
  protected IMiniAppFileManager d;
  private BaseRuntime e;
  
  public BaseTavApiProxy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WS_");
    localStringBuilder.append(getClass().getSimpleName());
    this.a = localStringBuilder.toString();
  }
  
  private Integer d()
  {
    try
    {
      int i = e();
      return Integer.valueOf(i);
    }
    catch (Throwable localThrowable)
    {
      Logger.e(this.a, "tryGetCurPageWebViewId: fail", localThrowable);
    }
    return null;
  }
  
  private int e()
  {
    if (this.e == null) {
      this.e = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
    }
    return this.e.getPage().getPageInfo(1).pageId;
  }
  
  final void a()
  {
    Log.v(this.a, "returnOk() called");
    this.b.ok();
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("newObjInvoke() called with: req = [");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], eventBean = [");
    localStringBuilder.append(paramObjCreateTavEvent);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendMsgInvoke() called with: req = [");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], eventBean = [");
    localStringBuilder.append(paramSendMsgTavEvent);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
  }
  
  public void a(IMiniAppContext paramIMiniAppContext)
  {
    this.c = paramIMiniAppContext;
  }
  
  public final void a(RequestEvent paramRequestEvent, BaseTavEvent paramBaseTavEvent)
  {
    this.b = paramRequestEvent;
    if ((paramBaseTavEvent instanceof ObjCreateTavEvent))
    {
      a((ObjCreateTavEvent)paramBaseTavEvent);
      return;
    }
    if ((paramBaseTavEvent instanceof SendMsgTavEvent)) {
      a((SendMsgTavEvent)paramBaseTavEvent);
    }
  }
  
  public void a(IMiniAppFileManager paramIMiniAppFileManager)
  {
    this.d = paramIMiniAppFileManager;
  }
  
  final void a(@NotNull Object paramObject)
  {
    a(ObjConvector.a(paramObject, TavObjPool.a().a(paramObject)));
  }
  
  final void a(String paramString)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("returnFail() called with: msg = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Log.w(str, localStringBuilder.toString());
    this.b.fail(paramString);
  }
  
  final void a(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Integer localInteger = d();
    if (localInteger == null)
    {
      Logger.e(this.a, "onSubscribe: curPageWebViewId == null");
      return;
    }
    paramJSONObject = paramJSONObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("custom_event_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.c.performAction(ServiceSubscribeEvent.obtain(paramString, paramJSONObject, localInteger.intValue()));
    this.b.jsService.evaluateSubscribeJS(paramString, paramJSONObject, localInteger.intValue());
  }
  
  final void a(JSONObject paramJSONObject)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("returnOk() called with: json = [");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("]");
    Log.v(str, localStringBuilder.toString());
    this.b.ok(paramJSONObject);
  }
  
  final void b()
  {
    Log.w(this.a, "returnFail() called");
    this.b.fail();
  }
  
  final void b(Object paramObject)
  {
    c(ObjConvector.a(paramObject, TavObjPool.a().a(paramObject)));
  }
  
  final void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("illegal params: ");
    localStringBuilder.append(paramString);
    a(localStringBuilder.toString());
  }
  
  final void c()
  {
    a("illegal api");
  }
  
  final void c(Object paramObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("value", paramObject);
    a(localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.BaseTavApiProxy
 * JD-Core Version:    0.7.0.1
 */