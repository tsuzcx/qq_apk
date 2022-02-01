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
  private UserEngine a;
  private LiveUseCase<Long, Boolean> b;
  protected App c;
  protected WebviewWrapper d;
  protected AVPlayerBuilderServiceInterface e;
  protected TouchWebView f;
  protected ViewGroup g;
  protected String h;
  protected int i = 1;
  protected boolean j = true;
  protected LiteLiveJsProvider k;
  protected JsBizAdapter l = new CustomWebModule.2(this);
  protected LiteAppJs.OnRefreshTokenListener m = new CustomWebModule.3(this);
  private boolean n = false;
  private boolean o;
  private boolean p;
  private boolean q = false;
  private boolean r;
  private float s;
  private float t;
  private boolean u = true;
  private boolean v = false;
  private boolean w = false;
  private UserInitStateCallback x = new CustomWebModule.1(this);
  
  private void A()
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
    localObject2 = this.f;
    if (localObject2 != null) {
      ((TouchWebView)localObject2).evaluateJavascript((String)localObject1, new CustomWebModule.14(this));
    }
  }
  
  private void B()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CustomWebModule-------delayInit-----this = ");
    localStringBuilder.append(hashCode());
    QLog.i("LifeCycleCustomWebModule", 1, localStringBuilder.toString());
    n();
    a();
    q();
    ((NetworkStateInterface)BizEngineMgr.getInstance().getLiveEngine().getService(NetworkStateInterface.class)).addListener(this);
    this.v = false;
  }
  
  private String a(boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    Object localObject1 = BusinessManager.a.g();
    String str2 = paramBundle.getString("scroll_enable");
    String str3 = paramBundle.getString("enter_record_if_finish", "0");
    String str1 = paramBundle.getString("ext_action");
    long l1 = this.roomBizContext.getEnterRoomInfo().roomId;
    int i1 = DeviceManager.a(BaseApplicationImpl.getContext(), UIUtil.getStatusBarHeight(BaseApplicationImpl.getContext()));
    Object localObject2;
    if (RoomUtil.b(paramInt))
    {
      if (paramBoolean) {
        paramBundle = e();
      } else {
        paramBundle = d();
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
      paramBundle = UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(((StringBuilder)localObject2).toString(), "{roomid}", String.valueOf(l1)), "{fromid}", String.valueOf(localObject1)), "{room_type}", String.valueOf(paramInt)), "{scroll_enalbe}", String.valueOf(str2)), "{record_enable}", String.valueOf(str3)), "{bh}", String.valueOf(i1));
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
          paramBundle = i();
        } else {
          paramBundle = h();
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
        paramBundle = UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(localStringBuilder.toString(), "{roomid}", String.valueOf(l1)), "{fromid}", String.valueOf(localObject1)), "{client_type}", String.valueOf(BusinessManager.a.b().f)), "{room_type}", String.valueOf(paramInt)), "{topicid}", String.valueOf(str2)), "{programId}", String.valueOf(str3)), "{optionid}", String.valueOf(localObject2)), "{topicTime}", String.valueOf(localObject3)), "{liveTime}", String.valueOf(str4));
      }
      else
      {
        localObject2 = paramBundle.getString("vid");
        if (paramBoolean) {
          paramBundle = g();
        } else {
          paramBundle = f();
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
        paramBundle = UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(UriUtil.a(((StringBuilder)localObject3).toString(), "{vid}", String.valueOf(localObject2)), "{fromid}", String.valueOf(localObject1)), "{room_type}", String.valueOf(paramInt)), "{scroll_enalbe}", String.valueOf(str2)), "{record_enable}", String.valueOf(str3)), "{bh}", String.valueOf(i1));
      }
    }
    localObject1 = paramBundle;
    if (getRoomBizContext().getEnterRoomInfo().bootModulesIndex != 0)
    {
      localObject1 = paramBundle;
      if (BusinessManager.a.b().k)
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
  
  private void a()
  {
    if (this.a.loginSuccess())
    {
      getLog().e("IliveCustomWebModule", "initLogin has loginSuccess", new Object[0]);
      b();
      return;
    }
    getLog().i("IliveCustomWebModule", "initLogin wait login complete", new Object[0]);
    this.a.addUserInitCallback(this.x);
  }
  
  private void b()
  {
    l();
  }
  
  private void b(int paramInt)
  {
    int i1 = paramInt / 1000;
    int i2 = (int)this.e.getVideoDurationMs() / 1000;
    if (i2 == 0) {
      paramInt = 0;
    } else {
      paramInt = i1 / i2;
    }
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("currentposition", i1);
      ((JSONObject)localObject2).put("bufferprogress", i1);
      ((JSONObject)localObject2).put("duration", i2);
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("code", 0);
      ((JSONObject)localObject1).put("result", localObject2);
      ((JSONObject)localObject1).put("duration", paramInt);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("javascript:(onVideoProgressUpdate(");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      ((StringBuilder)localObject2).append("))");
      localObject1 = ((StringBuilder)localObject2).toString();
      if (this.f != null)
      {
        this.f.evaluateJavascript((String)localObject1, new CustomWebModule.12(this));
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
    getEvent().observe(WebviewTransmitEvent.class, new CustomWebModule.4(this));
  }
  
  private void m()
  {
    getEvent().observe(ScrollByWebEvent.class, new CustomWebModule.5(this));
  }
  
  private void t()
  {
    getEvent().observe(ContentLoadedEvent.class, new CustomWebModule.6(this));
  }
  
  private void u()
  {
    getEvent().observe(PlayerStateEvent.class, new CustomWebModule.7(this));
  }
  
  private void v()
  {
    getEvent().observe(SendChatInputEvent.class, new CustomWebModule.8(this));
  }
  
  private void w()
  {
    getEvent().observe(ScreenModeEvent.class, new CustomWebModule.9(this));
  }
  
  private void x()
  {
    this.r = false;
    RecordVideoStateManager.a().a(false);
    A();
  }
  
  private void y()
  {
    if (!this.n) {
      return;
    }
    this.b.roomExecute(getRoomEngine(), this.mLifecycleOwner, Boolean.valueOf(true), new CustomWebModule.11(this));
  }
  
  private void z()
  {
    LiveUseCase localLiveUseCase = this.b;
    if ((localLiveUseCase != null) && (this.n)) {
      localLiveUseCase.onDestroy();
    }
  }
  
  public abstract String a(String paramString);
  
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
      if (this.f != null)
      {
        this.f.evaluateJavascript((String)localObject, new CustomWebModule.10(this));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  protected void a(RoomExtInfo paramRoomExtInfo) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void b(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {
      return;
    }
    if (!this.w)
    {
      this.w = true;
      if (WebSoUtils.b(paramString)) {
        ThreadManager.postImmediately(new CustomWebModule.17(this, paramString), null, false);
      }
    }
  }
  
  public abstract String d();
  
  public abstract String e();
  
  public abstract String f();
  
  public abstract String g();
  
  public boolean getAcceptReEnterRoom()
  {
    return true;
  }
  
  public abstract String h();
  
  public abstract String i();
  
  protected void j()
  {
    this.k.registerJsModule(new LiteAppJs(this.context, getRootView(), this.l).setOnRefreshTokenListener(this.m));
    this.k.registerJsModule(new LiteUIJs(this.context, this.l));
  }
  
  protected boolean k()
  {
    return false;
  }
  
  protected void l()
  {
    WebCookieManager.a().a(this.context, this.h);
    WebCookieManager.a().a(this.context, "https://yutang.qq.com/");
    WebCookieManager.a().a(this.context, "https://ilive.qq.com/");
    this.l.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  protected void n()
  {
    QLog.e("IliveCustomWebModule", 1, "ilivetime  initWebview ");
    this.k = new LiteLiveJsProvider();
    this.d = new WebviewWrapper(BaseApplicationImpl.getContext(), this.l, this.k, this, getRootView());
    QLog.e("IliveCustomWebModule", 1, "ilivetime initWebview ");
    this.f = ((TouchWebView)this.d.getWebview());
    Object localObject = this.f.getSettings();
    ((WebSettings)localObject).setUserAgentString(a(((WebSettings)localObject).getUserAgentString()));
    this.f.setBackgroundColor(0);
    this.f.setHorizontalScrollBarEnabled(false);
    this.f.setVerticalScrollBarEnabled(false);
    this.f.setOverScrollMode(2);
    o();
    this.c = new App(this.context.getApplicationContext(), getAudienceRoomPager(), this.i, this.j);
    this.f.addJavascriptInterface(this.c, "__WEBVIEW_APP");
    QLog.e("IliveCustomWebModule", 1, "ilivetime  before oninit ");
    this.d.onInit((Activity)this.context, ((Activity)this.context).getIntent(), "", this);
    QLog.e("IliveCustomWebModule", 1, "ilivetime  after oninit ");
    j();
    this.d.c();
    QLog.e("IliveCustomWebModule", 1, "ilivetime  after webViewDirectorConstruct ");
    p();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ilivetime load url:  ");
    ((StringBuilder)localObject).append(this.h);
    QLog.e("IliveCustomWebModule", 1, ((StringBuilder)localObject).toString());
    b(this.h);
    QLog.e("IliveCustomWebModule", 1, "ilivetime finish load url ");
    QLog.e("IliveCustomWebModule", 1, "ilivetime initWebview finish ");
    this.d.setOnWebviewTouchListener(this);
    if ((getAudienceRoomPager() != null) && (this.isUserVisibleHint))
    {
      localObject = getAudienceRoomPager();
      if (!this.j)
      {
        ((IAudienceRoomPager)localObject).setScrollForbidden(true);
        return;
      }
      ((IAudienceRoomPager)localObject).setScrollForbidden(false);
    }
  }
  
  protected void o()
  {
    TouchWebView localTouchWebView = this.f;
    if (localTouchWebView == null) {
      return;
    }
    this.g.addView(localTouchWebView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void onActivityCreate(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityCreate(paramLifecycleOwner);
  }
  
  public void onActivityDestroy(LifecycleOwner paramLifecycleOwner)
  {
    this.d = s();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CustomWebModule-------onActivityDestroy-----this = ");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", mLiteWebviewWrapper =");
    localStringBuilder.append(this.d);
    QLog.i("LifeCycleCustomWebModule", 1, localStringBuilder.toString());
    super.onActivityDestroy(paramLifecycleOwner);
    paramLifecycleOwner = this.f;
    if (paramLifecycleOwner != null) {
      this.g.removeView(paramLifecycleOwner);
    }
    paramLifecycleOwner = this.d;
    if (paramLifecycleOwner != null) {
      paramLifecycleOwner.onDestroy();
    }
  }
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    if (this.isUserVisibleHint) {
      this.v = false;
    }
    super.onActivityPause(paramLifecycleOwner);
    this.d = s();
    paramLifecycleOwner = this.d;
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
    if ((this.v) && ((this.isUserVisibleHint) || (BusinessManager.a.b().k))) {
      B();
    }
    this.d = s();
    paramLifecycleOwner = this.d;
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
    this.v = true;
    this.a = BizEngineMgr.getInstance().getUserEngine();
    paramContext = (ViewStub)getRootView().findViewById(2131429576);
    paramContext.setLayoutResource(2131625146);
    this.g = ((ViewGroup)paramContext.inflate());
    this.g.setBackgroundColor(0);
    paramContext = this.roomBizContext.getEnterRoomInfo().extData;
    this.i = paramContext.getInt("content_type");
    this.j = paramContext.getString("scroll_enable", "1").equals("1");
    if ((!RoomUtil.b(this.i)) && (!RoomUtil.a(this.i))) {
      this.n = true;
    } else {
      this.n = false;
    }
    this.h = a(k(), this.i, paramContext);
    paramContext = new StringBuilder();
    paramContext.append("CustomWebModule mBusinessUrlCustomWebModule mBusinessUrl = ");
    paramContext.append(this.h);
    QLog.i("IliveCustomWebModule", 1, paramContext.toString());
    this.e = ((AVPlayerBuilderServiceInterface)getRoomEngine().getService(AVPlayerBuilderServiceInterface.class));
    LogFactory.a().c("IliveCustomWebModule", "CustomWebModule======onCreate end");
  }
  
  protected void onCreateCases()
  {
    super.onCreateCases();
    this.b = getLiveCaseFactory().getCase(LiveCaseType.LISTEN_VIDEO_CURRENT_POSITION);
  }
  
  public void onDestroy()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CustomWebModule-------onDestroy-----this = ");
    ((StringBuilder)localObject).append(hashCode());
    QLog.i("LifeCycleCustomWebModule", 1, ((StringBuilder)localObject).toString());
    super.onDestroy();
    this.r = false;
    if (this.isUserVisibleHint) {
      RecordVideoStateManager.a().a(false);
    }
    z();
    localObject = this.f;
    if (localObject != null)
    {
      this.g.removeView((View)localObject);
      this.f = null;
    }
    this.c = r();
    localObject = this.c;
    if (localObject != null)
    {
      ((App)localObject).b();
      this.c = null;
    }
    this.a.removeUserInitCallback(this.x);
    ((NetworkStateInterface)BizEngineMgr.getInstance().getLiveEngine().getService(NetworkStateInterface.class)).removeListener(this);
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    y();
    this.o = true;
    if (this.p) {
      a(1);
    }
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    z();
    a(0);
  }
  
  public void onExtActive()
  {
    super.onExtActive();
    Object localObject = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExtActive onExtActive mIsFirstActive = ");
    localStringBuilder.append(this.u);
    ((com.tencent.mobileqq.litelivesdk.utils.log.LogInterface)localObject).c("IliveCustomWebModule", localStringBuilder.toString());
    localObject = this.f;
    if ((localObject != null) && (!this.u)) {
      ((TouchWebView)localObject).evaluateJavascript("javascript:__WEBVIEW_RELOADDATA()", new CustomWebModule.16(this));
    }
  }
  
  public void onExtDeActive()
  {
    super.onExtDeActive();
    this.u = false;
  }
  
  public void onFirstFrame()
  {
    super.onFirstFrame();
  }
  
  public WebJsParams onJsParamsParse(String paramString)
  {
    return null;
  }
  
  public void onNetWorkChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = getAudienceRoomPager();
    this.c = r();
    Object localObject2 = this.c;
    if (localObject2 != null) {
      ((App)localObject2).c(paramBoolean1);
    }
    int i2;
    int i1;
    if (paramBoolean1)
    {
      i2 = 4;
      i1 = i2;
      if (localObject1 != null)
      {
        ((IAudienceRoomPager)localObject1).setScrollForbidden(true);
        QLog.i("IliveCustomWebModule", 1, "onNetWorkChange setScrollForbidden is true");
        i1 = i2;
      }
    }
    else
    {
      i2 = 9;
      localObject2 = this.c;
      i1 = i2;
      if (localObject2 != null)
      {
        i1 = i2;
        if (!((App)localObject2).a())
        {
          i1 = i2;
          if (localObject1 != null)
          {
            if (!this.j) {
              return;
            }
            ((IAudienceRoomPager)localObject1).setScrollForbidden(false);
            QLog.i("IliveCustomWebModule", 1, "onNetWorkChange setScrollForbidden is false");
            i1 = i2;
          }
        }
      }
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("state", String.valueOf(i1));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("javascript:(__WEBVIEW_CLIENTAVSTATE(");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      ((StringBuilder)localObject2).append("))");
      localObject1 = ((StringBuilder)localObject2).toString();
      this.f.evaluateJavascript((String)localObject1, new CustomWebModule.13(this));
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
    this.r = false;
    RecordVideoStateManager.a().a(false);
    A();
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
    localStringBuilder.append(this.q);
    QLog.d("IliveCustomWebModule", 1, localStringBuilder.toString());
    if (paramMotionEvent.getAction() == 0)
    {
      this.s = paramMotionEvent.getX();
      this.t = paramMotionEvent.getY();
      paramView.requestDisallowInterceptTouchEvent(true);
    }
    else if (!this.q)
    {
      paramView.requestDisallowInterceptTouchEvent(false);
    }
    else
    {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = this.s;
    float f4 = this.t;
    double d1 = Math.sqrt((f1 - f3) * (f1 - f3) + (f2 - f4) * (f2 - f4));
    this.c = r();
    paramView = this.c;
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
    if (!BusinessManager.a.b().k) {
      if (!paramBoolean)
      {
        localObject = this.f;
        if (localObject != null)
        {
          this.g.removeView((View)localObject);
          this.f = null;
          this.v = true;
        }
        this.d = s();
        localObject = this.d;
        if (localObject != null)
        {
          ((WebviewWrapper)localObject).onDestroy();
          this.d = null;
        }
      }
      else if ((this.v) && (this.f == null))
      {
        B();
        this.d = s();
        localObject = this.d;
        if (localObject != null) {
          ((WebviewWrapper)localObject).onResume();
        }
      }
    }
    if (this.n)
    {
      if (!paramBoolean)
      {
        this.e.pausePlay();
        return;
      }
      this.e.resumePlay();
    }
  }
  
  protected void p()
  {
    if (this.f != null)
    {
      if (TextUtils.isEmpty(this.h)) {
        return;
      }
      this.f.loadUrl(this.h);
    }
  }
  
  protected void q()
  {
    v();
    u();
    t();
    m();
    w();
    c();
  }
  
  protected App r()
  {
    return this.c;
  }
  
  protected WebviewWrapper s()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule
 * JD-Core Version:    0.7.0.1
 */