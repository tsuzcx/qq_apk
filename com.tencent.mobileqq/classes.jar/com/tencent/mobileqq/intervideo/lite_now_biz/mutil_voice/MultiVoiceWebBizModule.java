package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import android.os.Build.VERSION;
import androidx.lifecycle.Observer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.AudioChangeEvent;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowAppJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowEventJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQQApiJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQbizApiJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowUIJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.SsoJavascriptInterface;
import com.tencent.mobileqq.intervideo.lite_now_biz.module.NowCustomWebModule;
import com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.event.MultiVoicePageEvent;
import com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.js.MultiVoiceAppJs;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.OnGetRoomExtInfoListener;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class MultiVoiceWebBizModule
  extends NowCustomWebModule
  implements OnGetRoomExtInfoListener
{
  private Observer<AudioChangeEvent> jdField_a_of_type_AndroidxLifecycleObserver = new MultiVoiceWebBizModule.1(this);
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Observer<MultiVoicePageEvent> b = new MultiVoiceWebBizModule.2(this);
  
  public MultiVoiceWebBizModule()
  {
    c();
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.getModuleEvent().observe(AudioChangeEvent.class, this.jdField_a_of_type_AndroidxLifecycleObserver);
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.getModuleEvent().observe(MultiVoicePageEvent.class, this.b);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.getModuleEvent().removeObserver(AudioChangeEvent.class, this.jdField_a_of_type_AndroidxLifecycleObserver);
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.getModuleEvent().removeObserver(MultiVoicePageEvent.class, this.b);
  }
  
  public RoomExtInfo a()
  {
    return null;
  }
  
  public String a()
  {
    return "od";
  }
  
  public String a(String paramString)
  {
    String str = Build.VERSION.RELEASE;
    int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
    if ((!StringUtil.a(paramString)) && (paramString.contains("NowSDK/"))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" NowLive/");
    localStringBuilder.append(10800);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localStringBuilder.append(" QQ/8.4.8.1522 NetType/");
    localStringBuilder.append(i);
    localStringBuilder.append(" NowSDK/18_10.20");
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new SsoJavascriptInterface(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowQQApiJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new MultiVoiceAppJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowAppJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowUIJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter, this.roomBizContext));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowQbizApiJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowEventJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter, this.jdField_a_of_type_JavaUtilMap));
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return "https://now.qq.com/qq/qun-jiaoyou/index.html";
  }
  
  protected void b()
  {
    MultiVoiceWebCookieManager.a().a(this.jdField_a_of_type_JavaLangString);
    MultiVoiceWebCookieManager.a().a("https://yutang.qq.com/");
    MultiVoiceWebCookieManager.a().a("https://ilive.qq.com/");
    MultiVoiceWebCookieManager.a().a("https://now.qq.com/");
    MultiVoiceWebCookieManager.a().a("https://fastest.now.qq.com/");
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  public String c()
  {
    return "https://fastest.now.qq.com/qq/qun-jiaoyou/index.html";
  }
  
  protected void c()
  {
    MultiVoiceWebCookieManager.a().b("https://now.qq.com/");
    MultiVoiceWebCookieManager.a().b("https://fastest.now.qq.com/");
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  public String d()
  {
    return null;
  }
  
  public String e()
  {
    return null;
  }
  
  public String f()
  {
    return null;
  }
  
  public String g()
  {
    return null;
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    h();
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceWebBizModule
 * JD-Core Version:    0.7.0.1
 */