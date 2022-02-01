package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.proxyimpl.tavkitplugin.TavObjPool;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy=ExternalElementProxy.class)
public class TavVideoView
  extends ExternalElementProxy
{
  private int jdField_a_of_type_Int;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private TavPlayer jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer;
  private final String jdField_a_of_type_JavaLangString;
  private int b;
  
  public TavVideoView()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WS_TavVideoView@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_AndroidViewSurface = null;
    this.jdField_a_of_type_Int = -1;
    this.b = -1;
  }
  
  private void a()
  {
    TavPlayer localTavPlayer = this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer;
    if (localTavPlayer != null)
    {
      Surface localSurface = this.jdField_a_of_type_AndroidViewSurface;
      if (localSurface != null)
      {
        int i = this.jdField_a_of_type_Int;
        if (i != -1)
        {
          int j = this.b;
          if (j == -1) {
            return;
          }
          localTavPlayer.a(localSurface, i, j);
        }
      }
    }
  }
  
  private void a(int paramInt, IJsService paramIJsService, String paramString)
  {
    paramIJsService.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("operateXWebExternalElement", null, paramString).toString());
  }
  
  private void a(String paramString, int paramInt, IJsService paramIJsService)
  {
    if (!"tav_getObject".equals(paramString))
    {
      a(paramInt, paramIJsService, "no match type");
      return;
    }
    paramIJsService.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebExternalElement", ObjConvector.a(this, TavObjPool.a().a(this))).toString());
  }
  
  private void b()
  {
    TavPlayer localTavPlayer = this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer;
    if (localTavPlayer != null) {
      localTavPlayer.a();
    }
  }
  
  boolean a(TavPlayer paramTavPlayer)
  {
    TavPlayer localTavPlayer = this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer;
    if ((localTavPlayer != null) && (!localTavPlayer.equals(paramTavPlayer))) {
      return false;
    }
    this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer = paramTavPlayer;
    a();
    return true;
  }
  
  public void handleInsertXWebExternalElement(JSONObject paramJSONObject, long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleInsertXWebExternalElement() called with: req = [");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      this.jdField_a_of_type_Int = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramJSONObject.optInt("width", -1) + 0.5F));
      this.b = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramJSONObject.optInt("height", -1) + 0.5F));
      a();
    }
  }
  
  public void handleOperateExternalElement(JSONObject paramJSONObject, int paramInt, IJsService paramIJsService, long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleOperateExternalElement() called with: req = [");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("], callbackId = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("data").getString("type");
      try
      {
        a(paramJSONObject, paramInt, paramIJsService);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        Logger.e(this.jdField_a_of_type_JavaLangString, "handleOperateExternalElement: ", paramJSONObject);
        a(paramInt, paramIJsService, "no match type");
        return;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      Logger.e(this.jdField_a_of_type_JavaLangString, "handleOperateExternalElement: ", paramJSONObject);
      a(paramInt, paramIJsService, "no match type");
    }
  }
  
  public void handleRemoveExternalElement(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "handleRemoveExternalElement() called");
  }
  
  public void handleUpdateExternalElement(JSONObject paramJSONObject, long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleUpdateExternalElement() called with: req = [");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
  }
  
  public void nativeDestroy(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "nativeDestroy() called");
  }
  
  public void nativePause(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "nativePause() called");
  }
  
  public void nativeResume(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "nativeResume() called");
  }
  
  public void onActive(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onActive() called");
  }
  
  public void onDeActive(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onDeactive() called");
  }
  
  public void onDestroy(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onDestroy() called");
    b();
  }
  
  public void onInit(String paramString, Map<String, String> paramMap, long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInit() called with: tagName = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], attributes = [");
    localStringBuilder.append(paramMap);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
  }
  
  public void onRectChanged(Rect paramRect, long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRectChanged() called with: rect = [");
    localStringBuilder.append(paramRect);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
  }
  
  public void onRequestRedraw(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onRequestRedraw() called");
  }
  
  public void onSurfaceCreated(Surface paramSurface, long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceCreated() called with: surface = [");
    localStringBuilder.append(paramSurface);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    a();
  }
  
  public void onSurfaceDestroyed(Surface paramSurface, long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceDestroyed() called with: surface = [");
    localStringBuilder.append(paramSurface);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
    b();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTouchEvent() called with: event = [");
    localStringBuilder.append(paramMotionEvent);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVisibilityChanged() called with: visibility = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    Log.d((String)localObject, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer;
    if ((localObject != null) && (!paramBoolean)) {
      ((TavPlayer)localObject).b();
    }
  }
  
  public void setCallBackWebView(IJsService paramIJsService, long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCallBackWebView() called with: callBackWebView = [");
    localStringBuilder.append(paramIJsService);
    localStringBuilder.append("], widgetId = [");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
  }
  
  public void setCurPageWebViewId(int paramInt, long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCurPageWebViewId() called with: curPageWebViewId = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], widgetId = [");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
  }
  
  public void setMiniAppContext(IMiniAppContext paramIMiniAppContext, long paramLong)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMiniAppContext() called with: miniAppContext = [");
    localStringBuilder.append(paramIMiniAppContext);
    localStringBuilder.append("], widgetId = [");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    Log.d(str, localStringBuilder.toString());
  }
  
  public void webViewDestroy(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "webViewDestroy() called");
  }
  
  public void webViewPause(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "webViewPause() called");
  }
  
  public void webViewResume(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "webViewResume() called");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavVideoView
 * JD-Core Version:    0.7.0.1
 */