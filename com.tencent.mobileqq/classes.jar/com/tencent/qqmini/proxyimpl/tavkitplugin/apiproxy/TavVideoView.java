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
  private int jdField_a_of_type_Int = -1;
  private Surface jdField_a_of_type_AndroidViewSurface = null;
  private TavPlayer jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer;
  private final String jdField_a_of_type_JavaLangString = "WS_TavVideoView@" + Integer.toHexString(hashCode());
  private int b = -1;
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer == null) || (this.jdField_a_of_type_AndroidViewSurface == null) || (this.jdField_a_of_type_Int == -1) || (this.b == -1)) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer.a(this.jdField_a_of_type_AndroidViewSurface, this.jdField_a_of_type_Int, this.b);
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
    if (this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer != null) {
      this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer.a();
    }
  }
  
  boolean a(TavPlayer paramTavPlayer)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer != null) && (!this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer.equals(paramTavPlayer))) {
      return false;
    }
    this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer = paramTavPlayer;
    a();
    return true;
  }
  
  public void handleInsertXWebExternalElement(JSONObject paramJSONObject, long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "handleInsertXWebExternalElement() called with: req = [" + paramJSONObject + "]");
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      this.jdField_a_of_type_Int = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramJSONObject.optInt("width", -1) + 0.5F));
      float f = DisplayUtil.getDensity(AppLoaderFactory.g().getContext());
      this.b = ((int)(paramJSONObject.optInt("height", -1) * f + 0.5F));
      a();
    }
  }
  
  public void handleOperateExternalElement(JSONObject paramJSONObject, int paramInt, IJsService paramIJsService, long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "handleOperateExternalElement() called with: req = [" + paramJSONObject + "], callbackId = [" + paramInt + "]");
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("data").getString("type");
      return;
    }
    catch (Exception paramJSONObject)
    {
      try
      {
        a(paramJSONObject, paramInt, paramIJsService);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        Logger.e(this.jdField_a_of_type_JavaLangString, "handleOperateExternalElement: ", paramJSONObject);
        a(paramInt, paramIJsService, "no match type");
      }
      paramJSONObject = paramJSONObject;
      Logger.e(this.jdField_a_of_type_JavaLangString, "handleOperateExternalElement: ", paramJSONObject);
      a(paramInt, paramIJsService, "no match type");
      return;
    }
  }
  
  public void handleRemoveExternalElement(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "handleRemoveExternalElement() called");
  }
  
  public void handleUpdateExternalElement(JSONObject paramJSONObject, long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "handleUpdateExternalElement() called with: req = [" + paramJSONObject + "]");
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
    Log.d(this.jdField_a_of_type_JavaLangString, "onInit() called with: tagName = [" + paramString + "], attributes = [" + paramMap + "]");
  }
  
  public void onRectChanged(Rect paramRect, long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onRectChanged() called with: rect = [" + paramRect + "]");
  }
  
  public void onRequestRedraw(long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onRequestRedraw() called");
  }
  
  public void onSurfaceCreated(Surface paramSurface, long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onSurfaceCreated() called with: surface = [" + paramSurface + "]");
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    a();
  }
  
  public void onSurfaceDestroyed(Surface paramSurface, long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onSurfaceDestroyed() called with: surface = [" + paramSurface + "]");
    b();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onTouchEvent() called with: event = [" + paramMotionEvent + "]");
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean, long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onVisibilityChanged() called with: visibility = [" + paramBoolean + "]");
    if ((this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer != null) && (!paramBoolean)) {
      this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer.b();
    }
  }
  
  public void setCallBackWebView(IJsService paramIJsService, long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "setCallBackWebView() called with: callBackWebView = [" + paramIJsService + "], widgetId = [" + paramLong + "]");
  }
  
  public void setCurPageWebViewId(int paramInt, long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "setCurPageWebViewId() called with: curPageWebViewId = [" + paramInt + "], widgetId = [" + paramLong + "]");
  }
  
  public void setMiniAppContext(IMiniAppContext paramIMiniAppContext, long paramLong)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "setMiniAppContext() called with: miniAppContext = [" + paramIMiniAppContext + "], widgetId = [" + paramLong + "]");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavVideoView
 * JD-Core Version:    0.7.0.1
 */