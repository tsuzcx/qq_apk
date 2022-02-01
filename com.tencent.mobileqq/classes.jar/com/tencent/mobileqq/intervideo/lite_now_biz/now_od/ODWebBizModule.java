package com.tencent.mobileqq.intervideo.lite_now_biz.now_od;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.AudioChangeEvent;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowAppJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowEventJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQQApiJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQbizApiJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowUIJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.SsoJavascriptInterface;
import com.tencent.mobileqq.intervideo.lite_now_biz.module.NowCustomWebModule;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.OnGetRoomExtInfoListener;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class ODWebBizModule
  extends NowCustomWebModule
  implements OnGetRoomExtInfoListener
{
  Observer<AudioChangeEvent> jdField_a_of_type_AndroidxLifecycleObserver = new ODWebBizModule.1(this);
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public ODWebBizModule()
  {
    c();
  }
  
  private String h()
  {
    Object localObject = this.roomBizContext.getEnterRoomInfo().extData.getString("mqqschema");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = Uri.parse((String)localObject);
    try
    {
      localObject = ((Uri)localObject).getQueryParameter("anchoruid");
      return localObject;
    }
    catch (Exception localException) {}
    return null;
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
    return "https://now.qq.com/qq/jiaoyou/index.html";
  }
  
  protected void b()
  {
    ODWebCookieManager.a().a(this.jdField_a_of_type_JavaLangString);
    ODWebCookieManager.a().a("https://yutang.qq.com/");
    ODWebCookieManager.a().a("https://ilive.qq.com/");
    ODWebCookieManager.a().a("https://now.qq.com/");
    ODWebCookieManager.a().a("https://fastest.now.qq.com/");
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  public String c()
  {
    return "https://fastest.now.qq.com/qq/jiaoyou/index.html";
  }
  
  protected void c()
  {
    ODWebCookieManager.a().b("https://now.qq.com/");
    ODWebCookieManager.a().b("https://fastest.now.qq.com/");
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
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    paramContext = h();
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramContext)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("&friend_uin=");
      localStringBuilder.append(paramContext);
      this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    }
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.getModuleEvent().observe(AudioChangeEvent.class, this.jdField_a_of_type_AndroidxLifecycleObserver);
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.getModuleEvent().removeObserver(AudioChangeEvent.class, this.jdField_a_of_type_AndroidxLifecycleObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_od.ODWebBizModule
 * JD-Core Version:    0.7.0.1
 */