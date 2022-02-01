package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
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
import com.tencent.ilive.audiencepages.room.AudienceRoomViewPager;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.commonpages.room.VerticalViewPager;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.litepages.room.webmodule.event.ContentLoadedEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ScreenModeEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ScrollByWebEvent;
import com.tencent.ilive.litepages.room.webmodule.event.SendChatInputEvent;
import com.tencent.ilive.litepages.room.webmodule.js.NormalJavascriptInterface;
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
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs.OnRefreshTokenListener;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteUIJs;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiveBusinessJsInterface;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebJsParams;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebviewWrapper;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
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
  private int jdField_a_of_type_Int = 1;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public TouchWebView a;
  private NormalJavascriptInterface jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsNormalJavascriptInterface;
  protected JsBizAdapter a;
  private AVPlayerBuilderServiceInterface jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface;
  private LiveUseCase<Long, Boolean> jdField_a_of_type_ComTencentIlivesdkDomainFactoryLiveUseCase;
  private UserEngine jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine;
  private UserInitStateCallback jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback = new CustomWebModule.1(this);
  protected LiteLiveJsProvider a;
  private LiteAppJs.OnRefreshTokenListener jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsLiteAppJs$OnRefreshTokenListener = new CustomWebModule.3(this);
  private WebviewWrapper jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper;
  protected String a;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d = false;
  private boolean e;
  private boolean f = true;
  private boolean g = false;
  private boolean h = false;
  
  public CustomWebModule()
  {
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter = new CustomWebModule.2(this);
  }
  
  private String a(boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    Object localObject = BusinessManager.a.b();
    String str1 = paramBundle.getString("scroll_enable");
    String str2 = paramBundle.getString("enter_record_if_finish", "0");
    long l = this.roomBizContext.getEnterRoomInfo().roomId;
    int i = DeviceManager.a(BaseApplicationImpl.getContext(), UIUtil.getStatusBarHeight(BaseApplicationImpl.getContext()));
    if (RoomUtil.b(paramInt))
    {
      if (paramBoolean)
      {
        paramBundle = c();
        if (!paramBundle.contains("?")) {
          break label224;
        }
      }
      label224:
      for (paramBundle = paramBundle + "&";; paramBundle = paramBundle + "?")
      {
        paramBundle = UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(paramBundle + "roomid={roomid}&fromid={fromid}&room_type={room_type}&scroll_enable={scroll_enalbe}&record_enable={record_enable}&__bh={bh}", "{roomid}", String.valueOf(l)), "{fromid}", String.valueOf(localObject)), "{room_type}", String.valueOf(paramInt)), "{scroll_enalbe}", String.valueOf(str1)), "{record_enable}", String.valueOf(str2)), "{bh}", String.valueOf(i));
        localObject = paramBundle;
        if (getRoomBizContext().getEnterRoomInfo().bootModulesIndex != 0) {
          localObject = paramBundle + "&preload=1";
        }
        return localObject;
        paramBundle = b();
        break;
      }
    }
    if (RoomUtil.a(paramInt))
    {
      str1 = paramBundle.getString("topicid");
      str2 = paramBundle.getString("programid");
      str3 = paramBundle.getString("optionid");
      String str4 = paramBundle.getString("topicTime");
      String str5 = paramBundle.getString("liveTime");
      if (paramBoolean)
      {
        paramBundle = g();
        label303:
        if (!paramBundle.contains("?")) {
          break label459;
        }
      }
      label459:
      for (paramBundle = paramBundle + "&";; paramBundle = paramBundle + "?")
      {
        paramBundle = UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(paramBundle + "roomid={roomid}&from=0&fromid={fromid}&client_type={client_type}&isQBRecord=1&_retry=1&room_type={room_type}&topicid={topicid}&programid={programId}&optionid={optionid}&topicTime={topicTime}&liveTime={liveTime}", "{roomid}", String.valueOf(l)), "{fromid}", String.valueOf(localObject)), "{client_type}", String.valueOf(BusinessManager.a.a().d)), "{room_type}", String.valueOf(paramInt)), "{topicid}", String.valueOf(str1)), "{programId}", String.valueOf(str2)), "{optionid}", String.valueOf(str3)), "{topicTime}", String.valueOf(str4)), "{liveTime}", String.valueOf(str5));
        break;
        paramBundle = f();
        break label303;
      }
    }
    String str3 = paramBundle.getString("vid");
    if (paramBoolean)
    {
      paramBundle = e();
      label499:
      if (!paramBundle.contains("?")) {
        break label618;
      }
    }
    label618:
    for (paramBundle = paramBundle + "&";; paramBundle = paramBundle + "?")
    {
      paramBundle = UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(paramBundle + "vid={vid}&fromid={fromid}&room_type={room_type}&scroll_enable={scroll_enalbe}&record_enable={record_enable}&__bh={bh}", "{vid}", String.valueOf(str3)), "{fromid}", String.valueOf(localObject)), "{room_type}", String.valueOf(paramInt)), "{scroll_enalbe}", String.valueOf(str1)), "{record_enable}", String.valueOf(str2)), "{bh}", String.valueOf(i));
      break;
      paramBundle = d();
      break label499;
    }
  }
  
  private void a(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("state", paramInt);
      localObject = "javascript:(__WEBVIEW_VISIBILITY_CHANGE(" + ((JSONObject)localObject).toString() + "))";
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.evaluateJavascript((String)localObject, new CustomWebModule.9(this));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {}
    do
    {
      do
      {
        return;
      } while (this.h);
      this.h = true;
    } while (!WebSoUtils.b(paramString));
    ThreadManager.postImmediately(new CustomWebModule.16(this, paramString), null, false);
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    int j = paramInt / 1000;
    int k = (int)this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.getVideoDurationMs() / 1000;
    if (k == 0) {}
    for (paramInt = i;; paramInt = j / k) {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("currentposition", j);
        ((JSONObject)localObject).put("bufferprogress", j);
        ((JSONObject)localObject).put("duration", k);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", 0);
        localJSONObject.put("result", localObject);
        localJSONObject.put("duration", paramInt);
        localObject = "javascript:(onVideoProgressUpdate(" + localJSONObject.toString() + "))";
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.evaluateJavascript((String)localObject, new CustomWebModule.11(this));
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("IliveCustomWebModule", 1, " error " + localJSONException);
      }
    }
  }
  
  private void c()
  {
    QLog.e("IliveCustomWebModule", 1, "ilivetime  initWebview ");
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider = new LiteLiveJsProvider();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper = new WebviewWrapper(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter, this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider, this, getRootView());
    QLog.e("IliveCustomWebModule", 1, "ilivetime initWebview ");
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.getWebview());
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings();
    localWebSettings.setUserAgentString(a(localWebSettings.getUserAgentString()));
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOverScrollMode(2);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsNormalJavascriptInterface = new NormalJavascriptInterface(this.context.getApplicationContext(), getAudienceRoomPager(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.addJavascriptInterface(this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsNormalJavascriptInterface, "__WEBVIEW_APP");
    QLog.e("IliveCustomWebModule", 1, "ilivetime  before oninit ");
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.onInit((Activity)this.context, ((Activity)this.context).getIntent(), "", this);
    QLog.e("IliveCustomWebModule", 1, "ilivetime  after oninit ");
    a();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.a();
    QLog.e("IliveCustomWebModule", 1, "ilivetime  after webViewDirectorConstruct ");
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
    QLog.e("IliveCustomWebModule", 1, "ilivetime load url:  " + this.jdField_a_of_type_JavaLangString);
    a(this.jdField_a_of_type_JavaLangString);
    QLog.e("IliveCustomWebModule", 1, "ilivetime finish load url ");
    QLog.e("IliveCustomWebModule", 1, "ilivetime initWebview finish ");
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.setOnWebviewTouchListener(this);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.loginSuccess())
    {
      getLog().e("IliveCustomWebModule", "initLogin has loginSuccess", new Object[0]);
      e();
      return;
    }
    getLog().i("IliveCustomWebModule", "initLogin wait login complete", new Object[0]);
    this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.addUserInitCallback(this.jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback);
  }
  
  private void e()
  {
    b();
  }
  
  private void f()
  {
    j();
    i();
    h();
    g();
    k();
  }
  
  private void g()
  {
    getEvent().observe(ScrollByWebEvent.class, new CustomWebModule.4(this));
  }
  
  private void h()
  {
    getEvent().observe(ContentLoadedEvent.class, new CustomWebModule.5(this));
  }
  
  private void i()
  {
    getEvent().observe(PlayerStateEvent.class, new CustomWebModule.6(this));
  }
  
  private void j()
  {
    getEvent().observe(SendChatInputEvent.class, new CustomWebModule.7(this));
  }
  
  private void k()
  {
    getEvent().observe(ScreenModeEvent.class, new CustomWebModule.8(this));
  }
  
  private void l()
  {
    this.e = false;
    o();
  }
  
  private void m()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkDomainFactoryLiveUseCase.roomExecute(getRoomEngine(), this.mLifecycleOwner, Boolean.valueOf(true), new CustomWebModule.10(this));
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentIlivesdkDomainFactoryLiveUseCase != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentIlivesdkDomainFactoryLiveUseCase.onDestroy();
    }
  }
  
  private void o()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("code", 0);
      localObject = "javascript:(onVideoPlay(" + ((JSONObject)localObject).toString() + "))";
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.evaluateJavascript((String)localObject, new CustomWebModule.13(this));
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void p()
  {
    QLog.i("LifeCycleCustomWebModule", 1, "CustomWebModule-------delayInit-----this = " + hashCode());
    c();
    d();
    f();
    ((NetworkStateInterface)BizEngineMgr.getInstance().getLiveEngine().getService(NetworkStateInterface.class)).addListener(this);
    this.g = false;
  }
  
  public WebJsParams a(String paramString)
  {
    return null;
  }
  
  public abstract String a(String paramString);
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new LiteAppJs(this.context, getRootView(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter).setOnRefreshTokenListener(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsLiteAppJs$OnRefreshTokenListener));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new LiteUIJs(this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
  }
  
  protected void a(RoomExtInfo paramRoomExtInfo) {}
  
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
    WebCookieManager.a().a(BaseApplicationImpl.getContext(), "https://now.qq.com/");
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  public abstract String c();
  
  public abstract String d();
  
  public abstract String e();
  
  public abstract String f();
  
  public abstract String g();
  
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
    QLog.i("LifeCycleCustomWebModule", 1, "CustomWebModule-------onActivityDestroy-----this = " + hashCode() + ", mLiteWebviewWrapper =" + this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper);
    super.onActivityDestroy(paramLifecycleOwner);
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper != null) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.onDestroy();
    }
  }
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    if (this.isUserVisibleHint) {
      this.g = false;
    }
    super.onActivityPause(paramLifecycleOwner);
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper != null) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.onPause();
    }
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    QLog.i("LifeCycleCustomWebModule", 1, "CustomWebModule-------onActivityResume-----this = " + hashCode());
    super.onActivityResume(paramLifecycleOwner);
    if ((this.g) && ((this.isUserVisibleHint) || (BusinessManager.a.a().jdField_a_of_type_Boolean))) {
      p();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper != null) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.onResume();
    }
  }
  
  public void onCreate(Context paramContext)
  {
    QLog.i("LifeCycleCustomWebModule", 1, "CustomWebModule======onCreate, this = " + hashCode());
    super.onCreate(paramContext);
    this.g = true;
    this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine = BizEngineMgr.getInstance().getUserEngine();
    paramContext = (ViewStub)getRootView().findViewById(2131363733);
    paramContext.setLayoutResource(2131559351);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramContext.inflate());
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(0);
    paramContext = this.roomBizContext.getEnterRoomInfo().extData;
    this.jdField_a_of_type_Int = paramContext.getInt("content_type");
    if ((RoomUtil.b(this.jdField_a_of_type_Int)) || (RoomUtil.a(this.jdField_a_of_type_Int))) {}
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      this.jdField_a_of_type_JavaLangString = a(a(), this.jdField_a_of_type_Int, paramContext);
      QLog.i("IliveCustomWebModule", 1, "CustomWebModule mBusinessUrl = " + this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface = ((AVPlayerBuilderServiceInterface)getRoomEngine().getService(AVPlayerBuilderServiceInterface.class));
      LogFactory.a().c("IliveCustomWebModule", "CustomWebModule======onCreate end");
      return;
    }
  }
  
  public void onCreateCases()
  {
    super.onCreateCases();
    this.jdField_a_of_type_ComTencentIlivesdkDomainFactoryLiveUseCase = getLiveCaseFactory().getCase(LiveCaseType.LISTEN_VIDEO_CURRENT_POSITION);
  }
  
  public void onDestroy()
  {
    QLog.i("LifeCycleCustomWebModule", 1, "CustomWebModule-------onDestroy-----this = " + hashCode());
    super.onDestroy();
    this.e = false;
    n();
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
    }
    if (this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsNormalJavascriptInterface != null)
    {
      this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsNormalJavascriptInterface.onDestroy();
      this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsNormalJavascriptInterface = null;
    }
    this.jdField_a_of_type_ComTencentLivesdkAccountengineUserEngine.removeUserInitCallback(this.jdField_a_of_type_ComTencentLivesdkAccountengineUserInitStateCallback);
    ((NetworkStateInterface)BizEngineMgr.getInstance().getLiveEngine().getService(NetworkStateInterface.class)).removeListener(this);
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    m();
    this.jdField_b_of_type_Boolean = true;
    if (this.c) {
      a(1);
    }
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    n();
    a(0);
  }
  
  public void onExtActive()
  {
    super.onExtActive();
    LogFactory.a().c("IliveCustomWebModule", "onExtActive onExtActive mIsFirstActive = " + this.f);
    if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (!this.f)) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.evaluateJavascript("javascript:__WEBVIEW_RELOADDATA()", new CustomWebModule.15(this));
    }
  }
  
  public void onExtDeActive()
  {
    super.onExtDeActive();
    this.f = false;
  }
  
  public void onFirstFrame()
  {
    super.onFirstFrame();
  }
  
  public void onNetWorkChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (AudienceRoomViewPager)getAudienceRoomPager().getViewPager();
    NormalJavascriptInterface.setNetWork(paramBoolean1);
    int i;
    if (paramBoolean1)
    {
      i = 4;
      if (localObject == null) {
        break label162;
      }
      ((AudienceRoomViewPager)localObject).setScrollForbidden(true);
      QLog.i("IliveCustomWebModule", 1, "onNetWorkChange setScrollForbidden is true");
      i = 4;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("state", String.valueOf(i));
        localObject = "javascript:(__WEBVIEW_CLIENTAVSTATE(" + ((JSONObject)localObject).toString() + "))";
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.evaluateJavascript((String)localObject, new CustomWebModule.12(this));
        return;
      }
      catch (JSONException localJSONException)
      {
        int j;
        label162:
        QLog.d("IliveCustomWebModule", 1, " error " + localJSONException);
      }
      j = 9;
      i = j;
      if (!this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsNormalJavascriptInterface.getForbiddenSPValue())
      {
        i = j;
        if (localObject != null)
        {
          ((AudienceRoomViewPager)localObject).setScrollForbidden(false);
          QLog.i("IliveCustomWebModule", 1, "onNetWorkChange setScrollForbidden is false");
          i = j;
        }
      }
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
    this.e = false;
    o();
  }
  
  public void onSwitchScreen(boolean paramBoolean)
  {
    int i = 1;
    super.onSwitchScreen(paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      if (!paramBoolean) {
        break label53;
      }
    }
    for (;;)
    {
      String str = String.format("javascript:__WEBVIIEW__SCREENMODE_CHANGE(%d)", new Object[] { Integer.valueOf(i) });
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.evaluateJavascript(str, new CustomWebModule.14(this));
      return;
      label53:
      i = 0;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = getAudienceRoomPager().getViewPager();
    if (paramView == null) {
      return false;
    }
    QLog.d("IliveCustomWebModule", 1, "ontouch " + paramMotionEvent.getAction() + " scroll by web" + this.d);
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      paramView.requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = this.jdField_a_of_type_Float;
      float f4 = this.jdField_a_of_type_Float;
      float f5 = this.jdField_b_of_type_Float;
      if (Math.sqrt((f1 - f4) * (f1 - f3) + (f2 - this.jdField_b_of_type_Float) * (f2 - f5)) <= 50.0D) {
        break;
      }
      this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsNormalJavascriptInterface.setIgnoreScrollForbidden(true);
      return false;
      if (!this.d) {
        paramView.requestDisallowInterceptTouchEvent(false);
      } else {
        paramView.requestDisallowInterceptTouchEvent(true);
      }
    }
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsNormalJavascriptInterface.setIgnoreScrollForbidden(false);
    return false;
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    QLog.i("LifeCycleCustomWebModule", 1, "CustomWebModule-------onVisibleToUser-----isVisibleToUser = " + paramBoolean + ", this = " + hashCode());
    super.onVisibleToUser(paramBoolean);
    if (!BusinessManager.a.a().jdField_a_of_type_Boolean)
    {
      if (paramBoolean) {
        break label104;
      }
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
        this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.onDestroy();
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper = null;
      }
    }
    label104:
    do
    {
      do
      {
        return;
      } while ((!this.g) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null));
      p();
    } while (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper == null);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebviewWrapper.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule
 * JD-Core Version:    0.7.0.1
 */