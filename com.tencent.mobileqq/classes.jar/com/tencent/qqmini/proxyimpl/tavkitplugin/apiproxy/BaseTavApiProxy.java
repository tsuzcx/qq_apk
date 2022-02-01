package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.util.Log;
import com.tencent.qqmini.proxyimpl.tavkitplugin.BaseTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.TavObjPool;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public abstract class BaseTavApiProxy
{
  protected MiniAppFileManager a;
  protected IMiniAppContext a;
  protected RequestEvent a;
  protected final String a;
  
  public BaseTavApiProxy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WS_");
    localStringBuilder.append(getClass().getSimpleName());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  final void a()
  {
    Log.v(this.jdField_a_of_type_JavaLangString, "returnOk() called");
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok();
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("newObjInvoke() called with: req = [");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent);
    localStringBuilder.append("], eventBean = [");
    localStringBuilder.append(paramObjCreateTavEvent);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendMsgInvoke() called with: req = [");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent);
    localStringBuilder.append("], eventBean = [");
    localStringBuilder.append(paramSendMsgTavEvent);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
  }
  
  public void a(MiniAppFileManager paramMiniAppFileManager)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkCoreManagerMiniAppFileManager = paramMiniAppFileManager;
  }
  
  public void a(IMiniAppContext paramIMiniAppContext)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
  }
  
  public final void a(RequestEvent paramRequestEvent, BaseTavEvent paramBaseTavEvent)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent = paramRequestEvent;
    if ((paramBaseTavEvent instanceof ObjCreateTavEvent))
    {
      a((ObjCreateTavEvent)paramBaseTavEvent);
      return;
    }
    if ((paramBaseTavEvent instanceof SendMsgTavEvent)) {
      a((SendMsgTavEvent)paramBaseTavEvent);
    }
  }
  
  final void a(@NotNull Object paramObject)
  {
    a(ObjConvector.a(paramObject, TavObjPool.a().a(paramObject)));
  }
  
  final void a(String paramString)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("returnFail() called with: msg = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Log.w(str, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail(paramString);
  }
  
  final void a(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    paramJSONObject = paramJSONObject.toString();
    int i = PageAction.obtain(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext).getPageId();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("custom_event_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.performAction(ServiceSubscribeEvent.obtain(paramString, paramJSONObject, i));
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.jsService.evaluateSubscribeJS(paramString, paramJSONObject, i);
  }
  
  final void a(JSONObject paramJSONObject)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("returnOk() called with: json = [");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("]");
    Log.v(str, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok(paramJSONObject);
  }
  
  final void b()
  {
    Log.w(this.jdField_a_of_type_JavaLangString, "returnFail() called");
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.BaseTavApiProxy
 * JD-Core Version:    0.7.0.1
 */