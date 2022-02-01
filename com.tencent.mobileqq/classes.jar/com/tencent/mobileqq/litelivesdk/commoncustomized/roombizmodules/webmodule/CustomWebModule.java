package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.falco.base.libapi.network.OnNetworkListener;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.litepages.room.webmodule.event.ContentLoadedEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ScreenModeEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ScrollByWebEvent;
import com.tencent.ilive.litepages.room.webmodule.event.SendChatInputEvent;
import com.tencent.ilive.litepages.room.webmodule.event.WebviewTransmitEvent;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.domain.factory.LiveCaseFactory;
import com.tencent.ilivesdk.domain.factory.LiveCaseType;
import com.tencent.ilivesdk.domain.factory.LiveUseCase;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.accountengine.UserInitStateCallback;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.App;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs.OnRefreshTokenListener;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteUIJs;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiveBusinessJsInterface;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebJsParams;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebviewWrapper;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.room.RecordVideoStateManager;
import com.tencent.mobileqq.litelivesdk.utils.UriUtil;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.room.RoomUtil;
import com.tencent.mobileqq.litelivesdk.utils.ui.DeviceManager;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.URLUtil;
import com.tencent.smtt.sdk.WebSettings;
import cooperation.qzone.webviewwrapper.IWebviewListener;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class CustomWebModule
  extends RoomBizModule
  implements View.OnTouchListener, OnNetworkListener, LiveBusinessJsInterface, IWebviewListener
{
  private float jdField_a_of_type_Float;
  protected int a;
  protected ViewGroup a;
  protected TouchWebView a;
  protected JsBizAdapter a;
  protected AVPlayerBuilderServiceInterface a;
  private LiveUseCase<Long, Boolean> jdField_a_of_type_ComTencentIlivesdkDomainFactoryLiveUseCase;
  private UserEngine jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine;
  private UserInitStateCallback jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback = new CustomWebModule.1(this);
  protected LiteLiveJsProvider a;
  protected App a;
  protected LiteAppJs.OnRefreshTokenListener a;
  protected WebviewWrapper a;
  protected String a;
  protected boolean a;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  private boolean d;
  private boolean e = false;
  private boolean f;
  private boolean g = true;
  private boolean h = false;
  private boolean i = false;
  
  public CustomWebModule()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter = new CustomWebModule.2(this);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsLiteAppJs$OnRefreshTokenListener = new CustomWebModule.3(this);
  }
  
  private String a(boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    Object localObject1 = BusinessManager.a.b();
    String str2 = paramBundle.getString("scroll_enable");
    String str3 = paramBundle.getString("enter_record_if_finish", "0");
    String str1 = paramBundle.getString("ext_action");
    long l = this.roomBizContext.getEnterRoomInfo().roomId;
    int j = DeviceManager.a(BaseApplicationImpl.getContext(), UIUtil.getStatusBarHeight(BaseApplicationImpl.getContext()));
    Object localObject2;
    if (RoomUtil.b(paramInt))
    {
      if (paramBoolean) {
        paramBundle = c();
      } else {
        paramBundle = b();
      }
      if (paramBundle.contains("?"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramBundle);
        ((StringBuilder)localObject2).append("&");
        paramBundle = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramBundle);
        ((StringBuilder)localObject2).append("?");
        paramBundle = ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramBundle);
      ((StringBuilder)localObject2).append("roomid={roomid}&fromid={fromid}&room_type={room_type}&scroll_enable={scroll_enalbe}&record_enable={record_enable}&__bh={bh}");
      paramBundle = UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(((StringBuilder)localObject2).toString(), "{roomid}", String.valueOf(l)), "{fromid}", String.valueOf(localObject1)), "{room_type}", String.valueOf(paramInt)), "{scroll_enalbe}", String.valueOf(str2)), "{record_enable}", String.valueOf(str3)), "{bh}", String.valueOf(j));
    }
    else
    {
      Object localObject3;
      if (RoomUtil.a(paramInt))
      {
        str2 = paramBundle.getString("topicid");
        str3 = paramBundle.getString("programid");
        localObject2 = paramBundle.getString("optionid");
        localObject3 = paramBundle.getString("topicTime");
        String str4 = paramBundle.getString("liveTime");
        if (paramBoolean) {
          paramBundle = g();
        } else {
          paramBundle = f();
        }
        if (paramBundle.contains("?"))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramBundle);
          localStringBuilder.append("&");
          paramBundle = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramBundle);
          localStringBuilder.append("?");
          paramBundle = localStringBuilder.toString();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramBundle);
        localStringBuilder.append("roomid={roomid}&from=0&fromid={fromid}&client_type={client_type}&isQBRecord=1&_retry=1&room_type={room_type}&topicid={topicid}&programid={programId}&optionid={optionid}&topicTime={topicTime}&liveTime={liveTime}");
        paramBundle = UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(localStringBuilder.toString(), "{roomid}", String.valueOf(l)), "{fromid}", String.valueOf(localObject1)), "{client_type}", String.valueOf(BusinessManager.a.a().d)), "{room_type}", String.valueOf(paramInt)), "{topicid}", String.valueOf(str2)), "{programId}", String.valueOf(str3)), "{optionid}", String.valueOf(localObject2)), "{topicTime}", String.valueOf(localObject3)), "{liveTime}", String.valueOf(str4));
      }
      else
      {
        localObject2 = paramBundle.getString("vid");
        if (paramBoolean) {
          paramBundle = e();
        } else {
          paramBundle = d();
        }
        if (paramBundle.contains("?"))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramBundle);
          ((StringBuilder)localObject3).append("&");
          paramBundle = ((StringBuilder)localObject3).toString();
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramBundle);
          ((StringBuilder)localObject3).append("?");
          paramBundle = ((StringBuilder)localObject3).toString();
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramBundle);
        ((StringBuilder)localObject3).append("vid={vid}&fromid={fromid}&room_type={room_type}&scroll_enable={scroll_enalbe}&record_enable={record_enable}&__bh={bh}");
        paramBundle = UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(((StringBuilder)localObject3).toString(), "{vid}", String.valueOf(localObject2)), "{fromid}", String.valueOf(localObject1)), "{room_type}", String.valueOf(paramInt)), "{scroll_enalbe}", String.valueOf(str2)), "{record_enable}", String.valueOf(str3)), "{bh}", String.valueOf(j));
      }
    }
    localObject1 = paramBundle;
    if (getRoomBizContext().getEnterRoomInfo().bootModulesIndex != 0)
    {
      localObject1 = paramBundle;
      if (BusinessManager.a.a().jdField_a_of_type_Boolean)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramBundle);
        ((StringBuilder)localObject1).append("&preload=1");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramBundle = (Bundle)localObject1;
    if (!TextUtils.isEmpty(str1))
    {
      paramBundle = new StringBuilder();
      paramBundle.append((String)localObject1);
      paramBundle.append("&ext_action=");
      paramBundle.append(str1);
      paramBundle = paramBundle.toString();
    }
    return paramBundle;
  }
  
  private void b(int paramInt)
  {
    int j = paramInt / 1000;
    int k = (int)this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.getVideoDurationMs() / 1000;
    if (k == 0) {
      paramInt = 0;
    } else {
      paramInt = j / k;
    }
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("currentposition", j);
      ((JSONObject)localObject2).put("bufferprogress", j);
      ((JSONObject)localObject2).put("duration", k);
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("code", 0);
      ((JSONObject)localObject1).put("result", localObject2);
      ((JSONObject)localObject1).put("duration", paramInt);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("javascript:(onVideoProgressUpdate(");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      ((StringBuilder)localObject2).append("))");
      localObject1 = ((StringBuilder)localObject2).toString();
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.evaluateJavascript((String)localObject1, new CustomWebModule.12(this));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" error ");
      ((StringBuilder)localObject2).append(localJSONException);
      QLog.d("IliveCustomWebModule", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.loginSuccess())
    {
      getLog().e("IliveCustomWebModule", "initLogin has loginSuccess", new Object[0]);
      h();
      return;
    }
    getLog().i("IliveCustomWebModule", "initLogin wait login complete", new Object[0]);
    this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.addUserInitCallback(this.jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback);
  }
  
  private void h()
  {
    b();
  }
  
  private void i()
  {
    getEvent().observe(WebviewTransmitEvent.class, new CustomWebModule.4(this));
  }
  
  private void j()
  {
    getEvent().observe(ScrollByWebEvent.class, new CustomWebModule.5(this));
  }
  
  private void k()
  {
    getEvent().observe(ContentLoadedEvent.class, new CustomWebModule.6(this));
  }
  
  private void l()
  {
    getEvent().observe(PlayerStateEvent.class, new CustomWebModule.7(this));
  }
  
  private void m()
  {
    getEvent().observe(SendChatInputEvent.class, new CustomWebModule.8(this));
  }
  
  private void n()
  {
    getEvent().observe(ScreenModeEvent.class, new CustomWebModule.9(this));
  }
  
  private void o()
  {
    this.f = false;
    RecordVideoStateManager.a().a(false);
    r();
  }
  
  private void p()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkDomainFactoryLiveUseCase.roomExecute(getRoomEngine(), this.mLifecycleOwner, Boolean.valueOf(true), new CustomWebModule.11(this));
  }
  
  private void q()
  {
    LiveUseCase localLiveUseCase = this.jdField_a_of_type_ComTencentIlivesdkDomainFactoryLiveUseCase;
    if ((localLiveUseCase != null) && (this.jdField_b_of_type_Boolean)) {
      localLiveUseCase.onDestroy();
    }
  }
  
  private void r()
  {
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("code", 0);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("javascript:(onVideoPlay(");
    ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
    ((StringBuilder)localObject2).append("))");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject2 != null) {
      ((TouchWebView)localObject2).evaluateJavascript((String)localObject1, new CustomWebModule.14(this));
    }
  }
  
  private void s()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CustomWebModule-------delayInit-----this = ");
    localStringBuilder.append(hashCode());
    QLog.i("LifeCycleCustomWebModule", 1, localStringBuilder.toString());
    d();
    c();
    g();
    ((NetworkStateInterface)BizEngineMgr.getInstance().getLiveEngine().getService(NetworkStateInterface.class)).addListener(this);
    this.h = false;
  }
  
  protected App a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp;
  }
  
  public WebJsParams a(String paramString)
  {
    return null;
  }
  
  protected WebviewWrapper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper;
  }
  
  public abstract String a(String paramString);
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new LiteAppJs(this.context, getRootView(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter).setOnRefreshTokenListener(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsLiteAppJs$OnRefreshTokenListener));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new LiteUIJs(this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
  }
  
  protected void a(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("state", paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:(__WEBVIEW_VISIBILITY_CHANGE(");
      localStringBuilder.append(((JSONObject)localObject).toString());
      localStringBuilder.append("))");
      localObject = localStringBuilder.toString();
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.evaluateJavascript((String)localObject, new CustomWebModule.10(this));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  protected void a(RoomExtInfo paramRoomExtInfo) {}
  
  protected void a(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {
      return;
    }
    if (!this.i)
    {
      this.i = true;
      if (WebSoUtils.b(paramString)) {
        ThreadManager.postImmediately(new CustomWebModule.17(this, paramString), null, false);
      }
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected boolean a()
  {
    return false;
  }
  
  public abstract String b();
  
  protected void b()
  {
    WebCookieManager.a().a(this.context, this.jdField_a_of_type_JavaLangString);
    WebCookieManager.a().a(this.context, "https://yutang.qq.com/");
    WebCookieManager.a().a(this.context, "https://ilive.qq.com/");
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  public abstract String c();
  
  public abstract String d();
  
  protected void d()
  {
    QLog.e("IliveCustomWebModule", 1, "ilivetime  initWebview ");
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider = new LiteLiveJsProvider();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper = new WebviewWrapper(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter, this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider, this, getRootView());
    QLog.e("IliveCustomWebModule", 1, "ilivetime initWebview ");
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.getWebview());
    Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings();
    ((WebSettings)localObject).setUserAgentString(a(((WebSettings)localObject).getUserAgentString()));
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOverScrollMode(2);
    e();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp = new App(this.context.getApplicationContext(), getAudienceRoomPager(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.addJavascriptInterface(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp, "__WEBVIEW_APP");
    QLog.e("IliveCustomWebModule", 1, "ilivetime  before oninit ");
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.onInit((Activity)this.context, ((Activity)this.context).getIntent(), "", this);
    QLog.e("IliveCustomWebModule", 1, "ilivetime  after oninit ");
    a();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.a();
    QLog.e("IliveCustomWebModule", 1, "ilivetime  after webViewDirectorConstruct ");
    f();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ilivetime load url:  ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.e("IliveCustomWebModule", 1, ((StringBuilder)localObject).toString());
    a(this.jdField_a_of_type_JavaLangString);
    QLog.e("IliveCustomWebModule", 1, "ilivetime finish load url ");
    QLog.e("IliveCustomWebModule", 1, "ilivetime initWebview finish ");
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.setOnWebviewTouchListener(this);
    if ((getAudienceRoomPager() != null) && (this.isUserVisibleHint))
    {
      localObject = getAudienceRoomPager();
      if (!this.jdField_a_of_type_Boolean)
      {
        ((IAudienceRoomPager)localObject).setScrollForbidden(true);
        return;
      }
      ((IAudienceRoomPager)localObject).setScrollForbidden(false);
    }
  }
  
  public abstract String e();
  
  protected void e()
  {
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localTouchWebView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.addView(localTouchWebView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public abstract String f();
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public abstract String g();
  
  protected void g()
  {
    m();
    l();
    k();
    j();
    n();
    i();
  }
  
  public boolean getAcceptReEnterRoom()
  {
    return true;
  }
  
  public void onActivityCreate(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityCreate(paramLifecycleOwner);
  }
  
  public void onActivityDestroy(LifecycleOwner paramLifecycleOwner)
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CustomWebModule-------onActivityDestroy-----this = ");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", mLiteWebviewWrapper =");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper);
    QLog.i("LifeCycleCustomWebModule", 1, localStringBuilder.toString());
    super.onActivityDestroy(paramLifecycleOwner);
    paramLifecycleOwner = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (paramLifecycleOwner != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(paramLifecycleOwner);
    }
    paramLifecycleOwner = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper;
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.onDestroy();
    }
  }
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    if (this.isUserVisibleHint) {
      this.h = false;
    }
    super.onActivityPause(paramLifecycleOwner);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper = a();
    paramLifecycleOwner = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper;
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.onPause();
    }
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CustomWebModule-------onActivityResume-----this = ");
    localStringBuilder.append(hashCode());
    QLog.i("LifeCycleCustomWebModule", 1, localStringBuilder.toString());
    super.onActivityResume(paramLifecycleOwner);
    if ((this.h) && ((this.isUserVisibleHint) || (BusinessManager.a.a().jdField_a_of_type_Boolean))) {
      s();
    }
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper = a();
    paramLifecycleOwner = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper;
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.onResume();
    }
  }
  
  public void onCreate(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CustomWebModule======onCreate, this = ");
    localStringBuilder.append(hashCode());
    QLog.i("LifeCycleCustomWebModule", 1, localStringBuilder.toString());
    super.onCreate(paramContext);
    this.h = true;
    this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine = BizEngineMgr.getInstance().getUserEngine();
    paramContext = (ViewStub)getRootView().findViewById(2131363663);
    paramContext.setLayoutResource(2131559226);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramContext.inflate());
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(0);
    paramContext = this.roomBizContext.getEnterRoomInfo().extData;
    this.jdField_a_of_type_Int = paramContext.getInt("content_type");
    this.jdField_a_of_type_Boolean = paramContext.getString("scroll_enable", "1").equals("1");
    if ((!RoomUtil.b(this.jdField_a_of_type_Int)) && (!RoomUtil.a(this.jdField_a_of_type_Int))) {
      this.jdField_b_of_type_Boolean = true;
    } else {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_a_of_type_JavaLangString = a(a(), this.jdField_a_of_type_Int, paramContext);
    paramContext = new StringBuilder();
    paramContext.append("CustomWebModule mBusinessUrlCustomWebModule mBusinessUrl = ");
    paramContext.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("IliveCustomWebModule", 1, paramContext.toString());
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface = ((AVPlayerBuilderServiceInterface)getRoomEngine().getService(AVPlayerBuilderServiceInterface.class));
    LogFactory.a().c("IliveCustomWebModule", "CustomWebModule======onCreate end");
  }
  
  protected void onCreateCases()
  {
    super.onCreateCases();
    this.jdField_a_of_type_ComTencentIlivesdkDomainFactoryLiveUseCase = getLiveCaseFactory().getCase(LiveCaseType.LISTEN_VIDEO_CURRENT_POSITION);
  }
  
  public void onDestroy()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CustomWebModule-------onDestroy-----this = ");
    ((StringBuilder)localObject).append(hashCode());
    QLog.i("LifeCycleCustomWebModule", 1, ((StringBuilder)localObject).toString());
    super.onDestroy();
    this.f = false;
    if (this.isUserVisibleHint) {
      RecordVideoStateManager.a().a(false);
    }
    q();
    localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView((View)localObject);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp = a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp;
    if (localObject != null)
    {
      ((App)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp = null;
    }
    this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.removeUserInitCallback(this.jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback);
    ((NetworkStateInterface)BizEngineMgr.getInstance().getLiveEngine().getService(NetworkStateInterface.class)).removeListener(this);
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    p();
    this.c = true;
    if (this.d) {
      a(1);
    }
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    q();
    a(0);
  }
  
  public void onExtActive()
  {
    super.onExtActive();
    Object localObject = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExtActive onExtActive mIsFirstActive = ");
    localStringBuilder.append(this.g);
    ((com.tencent.mobileqq.litelivesdk.utils.log.LogInterface)localObject).c("IliveCustomWebModule", localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if ((localObject != null) && (!this.g)) {
      ((TouchWebView)localObject).evaluateJavascript("javascript:__WEBVIEW_RELOADDATA()", new CustomWebModule.16(this));
    }
  }
  
  public void onExtDeActive()
  {
    super.onExtDeActive();
    this.g = false;
  }
  
  public void onFirstFrame()
  {
    super.onFirstFrame();
  }
  
  public void onNetWorkChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = getAudienceRoomPager();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp = a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp;
    if (localObject2 != null) {
      ((App)localObject2).c(paramBoolean1);
    }
    int k;
    int j;
    if (paramBoolean1)
    {
      k = 4;
      j = k;
      if (localObject1 != null)
      {
        ((IAudienceRoomPager)localObject1).setScrollForbidden(true);
        QLog.i("IliveCustomWebModule", 1, "onNetWorkChange setScrollForbidden is true");
        j = k;
      }
    }
    else
    {
      k = 9;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp;
      j = k;
      if (localObject2 != null)
      {
        j = k;
        if (!((App)localObject2).a())
        {
          j = k;
          if (localObject1 != null)
          {
            if (!this.jdField_a_of_type_Boolean) {
              return;
            }
            ((IAudienceRoomPager)localObject1).setScrollForbidden(false);
            QLog.i("IliveCustomWebModule", 1, "onNetWorkChange setScrollForbidden is false");
            j = k;
          }
        }
      }
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("state", String.valueOf(j));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("javascript:(__WEBVIEW_CLIENTAVSTATE(");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      ((StringBuilder)localObject2).append("))");
      localObject1 = ((StringBuilder)localObject2).toString();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.evaluateJavascript((String)localObject1, new CustomWebModule.13(this));
      return;
    }
    catch (JSONException localJSONException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" error ");
      ((StringBuilder)localObject2).append(localJSONException);
      QLog.d("IliveCustomWebModule", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void onPageFinished()
  {
    QLog.e("IliveCustomWebModule", 1, "onPageFinished");
  }
  
  public void onReceiveError(int paramInt, String paramString1, String paramString2) {}
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    this.f = false;
    RecordVideoStateManager.a().a(false);
    r();
  }
  
  public void onSwitchScreen(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = getAudienceRoomPager();
    if (paramView == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ontouch ");
    localStringBuilder.append(paramMotionEvent.getAction());
    localStringBuilder.append(" scroll by web");
    localStringBuilder.append(this.e);
    QLog.d("IliveCustomWebModule", 1, localStringBuilder.toString());
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      paramView.requestDisallowInterceptTouchEvent(true);
    }
    else if (!this.e)
    {
      paramView.requestDisallowInterceptTouchEvent(false);
    }
    else
    {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = this.jdField_a_of_type_Float;
    float f4 = this.jdField_b_of_type_Float;
    double d1 = Math.sqrt((f1 - f3) * (f1 - f3) + (f2 - f4) * (f2 - f4));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp = a();
    paramView = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp;
    if (paramView != null)
    {
      if (d1 > 50.0D)
      {
        paramView.a(true);
        return false;
      }
      paramView.a(false);
    }
    return false;
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CustomWebModule-------onVisibleToUser-----isVisibleToUser = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", this = ");
    ((StringBuilder)localObject).append(hashCode());
    QLog.i("LifeCycleCustomWebModule", 1, ((StringBuilder)localObject).toString());
    super.onVisibleToUser(paramBoolean);
    if (!BusinessManager.a.a().jdField_a_of_type_Boolean) {
      if (!paramBoolean)
      {
        localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
        if (localObject != null)
        {
          this.jdField_a_of_type_AndroidViewViewGroup.removeView((View)localObject);
          this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
          this.h = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper = a();
        localObject = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper;
        if (localObject != null)
        {
          ((WebviewWrapper)localObject).onDestroy();
          this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper = null;
        }
      }
      else if ((this.h) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null))
      {
        s();
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper = a();
        localObject = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper;
        if (localObject != null) {
          ((WebviewWrapper)localObject).onResume();
        }
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (!paramBoolean)
      {
        this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.pausePlay();
        return;
      }
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.resumePlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule
 * JD-Core Version:    0.7.0.1
 */