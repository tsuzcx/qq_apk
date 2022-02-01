package cooperation.ilive.lite.module;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.App;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebViewPool;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebviewWrapper;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.room.RoomManager;
import com.tencent.mobileqq.litelivesdk.utils.UriUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;
import cooperation.ilive.lite.js.IliveSingleWebviewWrapper;
import cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class IliveSingleWebModule
  extends IliveWebBizModule
{
  private static String a;
  private static boolean b = true;
  private static IliveSingleWebviewWrapper q;
  private boolean n = false;
  private boolean o = false;
  private long p;
  private IliveLiteEventCenter.Observer r = new IliveSingleWebModule.1(this);
  
  private JSONObject a(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("roomid", paramLong);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a()
  {
    QLog.e("IliveSingleWebModule", 1, "destorySingleWebView");
    a = "";
    IliveSingleWebviewWrapper localIliveSingleWebviewWrapper = q;
    if (localIliveSingleWebviewWrapper != null)
    {
      localIliveSingleWebviewWrapper.d();
      q = null;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle = paramBundle.getString("callback_id");
    TouchWebView localTouchWebView = t();
    if ((localTouchWebView != null) && (!TextUtils.isEmpty(paramBundle)))
    {
      long l = m();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("curRoom", l);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentId data = \n ");
        localStringBuilder.append(localJSONObject.toString());
        QLog.e("IliveSingleWebModule", 1, localStringBuilder.toString());
        localTouchWebView.callJs(paramBundle, new String[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  private void b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    Object localObject1 = paramBundle.getString("callback_id");
    int i = paramBundle.getInt("code");
    String str = paramBundle.getString("message");
    paramBundle = t();
    if ((paramBundle != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      long l = m();
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("code", i);
        ((JSONObject)localObject2).put("message", str);
        ((JSONObject)localObject2).put("roomId", l);
        str = ((JSONObject)localObject2).toString();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("callbackNeedShowGiftIcon resultString:");
          ((StringBuilder)localObject2).append(str);
          QLog.d("IliveSingleWebModule", 2, ((StringBuilder)localObject2).toString());
        }
        paramBundle.callJs((String)localObject1, new String[] { str });
        return;
      }
      catch (Exception paramBundle)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("callbackNeedShowGiftIcon throw e:");
        ((StringBuilder)localObject1).append(paramBundle.getMessage());
        QLog.e("IliveSingleWebModule", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void c(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadCenter.postDefaultUITask(new IliveSingleWebModule.2(this, paramBundle));
  }
  
  private void d(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadCenter.postDefaultUITask(new IliveSingleWebModule.3(this, paramBundle));
  }
  
  private TouchWebView t()
  {
    if (this.f == null) {
      this.f = WebViewPool.a.b();
    }
    return this.f;
  }
  
  private boolean u()
  {
    TouchWebView localTouchWebView = t();
    if (localTouchWebView == null) {
      return false;
    }
    int i = 0;
    while (i < this.g.getChildCount())
    {
      if (this.g.getChildAt(i) == localTouchWebView) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void v()
  {
    if (TextUtils.isEmpty(a))
    {
      QLog.e("IliveSingleWebModule", 1, "preloadNextRoom mSwitchCallbackId = null");
      return;
    }
    TouchWebView localTouchWebView = t();
    if (localTouchWebView != null)
    {
      long l1 = LiveLiteRoomSwitchService.a(c() - 1);
      long l2 = LiveLiteRoomSwitchService.a(c() + 1);
      JSONObject localJSONObject1 = new JSONObject();
      Object localObject = new JSONObject();
      JSONObject localJSONObject2 = w();
      JSONObject localJSONObject3 = a(l1);
      JSONObject localJSONObject4 = a(l2);
      try
      {
        ((JSONObject)localObject).put("preRoom", localJSONObject3);
        ((JSONObject)localObject).put("curRoom", localJSONObject2);
        ((JSONObject)localObject).put("nextRoom", localJSONObject4);
        localJSONObject1.put("data", localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preloadNextRoom data = \n ");
        ((StringBuilder)localObject).append(localJSONObject1.toString());
        QLog.e("IliveSingleWebModule", 1, ((StringBuilder)localObject).toString());
        IliveLiteMonitorUtil.a("live_switch_consume");
        localTouchWebView.callJs(a, new String[] { localJSONObject1.toString() });
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private JSONObject w()
  {
    return new JSONObject(x());
  }
  
  private HashMap<String, String> x()
  {
    if ((!TextUtils.isEmpty(this.h)) && (b())) {
      return (HashMap)RoomManager.a(this.h);
    }
    return null;
  }
  
  protected void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyVisibility state = ");
    localStringBuilder.append(paramInt);
    QLog.e("IliveSingleWebModule", 1, localStringBuilder.toString());
  }
  
  public String d()
  {
    Object localObject2 = super.d();
    Object localObject3 = BusinessManager.a.c();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((EnterRoomConfig)localObject3).extData != null)
      {
        Map localMap = RoomManager.a(((EnterRoomConfig)localObject3).extData.getString("mqqschema"));
        localObject1 = localObject2;
        if (localMap.containsKey("room_type")) {
          localObject1 = UriUtil.b((String)localObject2, "room_type", (String)localMap.get("room_type"));
        }
        localObject2 = localObject1;
        if (localMap.containsKey("game_id")) {
          localObject2 = UriUtil.b((String)localObject1, "game_id", (String)localMap.get("game_id"));
        }
        localObject3 = localObject2;
        if (localMap.containsKey("game_tag_id")) {
          localObject3 = UriUtil.b((String)localObject2, "game_tag_id", (String)localMap.get("game_tag_id"));
        }
        localObject1 = localObject3;
        if (localMap.containsKey("video_source")) {
          localObject1 = UriUtil.b((String)localObject3, "video_source", (String)localMap.get("video_source"));
        }
      }
    }
    return localObject1;
  }
  
  protected void j()
  {
    if (q == null) {
      return;
    }
    QLog.e("IliveSingleWebModule", 1, "registerJsModule");
    this.k = q.a();
    if (this.k == null) {
      return;
    }
    this.k.removeAllJsModule();
    super.j();
  }
  
  protected void n()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ilivetime  initWebview mSwitchCallbackId = ");
    ((StringBuilder)localObject).append(a);
    QLog.e("IliveSingleWebModule", 1, ((StringBuilder)localObject).toString());
    if ((q != null) && (!TextUtils.isEmpty(a)))
    {
      this.c = q.b();
      this.f = t();
    }
    else
    {
      this.k = new LiteLiveJsProvider();
      q = new IliveSingleWebviewWrapper(BaseApplicationImpl.getContext(), this.l, this.k, this, getRootView());
      QLog.e("IliveSingleWebModule", 1, "initWebview create WebviewWrapper ");
      this.f = ((TouchWebView)q.getWebview());
      localObject = this.f.getSettings();
      ((WebSettings)localObject).setUserAgentString(a(((WebSettings)localObject).getUserAgentString()));
      this.f.setBackgroundColor(0);
      this.f.setHorizontalScrollBarEnabled(false);
      this.f.setVerticalScrollBarEnabled(false);
      this.f.setOverScrollMode(2);
      this.c = new App(this.context.getApplicationContext(), getAudienceRoomPager(), this.i, this.j);
      q.a(this.c);
      q.onInit((Activity)this.context, ((Activity)this.context).getIntent(), "", this);
      o();
      j();
      q.c();
      b(this.h);
      q.setOnWebviewTouchListener(this);
      if ((getAudienceRoomPager() != null) && (this.isUserVisibleHint))
      {
        localObject = getAudienceRoomPager();
        if (!this.j) {
          ((IAudienceRoomPager)localObject).setScrollForbidden(true);
        } else {
          ((IAudienceRoomPager)localObject).setScrollForbidden(false);
        }
      }
    }
    p();
  }
  
  protected void o()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("addWebView mIsLoadUrl = ");
    ((StringBuilder)localObject1).append(this.o);
    ((StringBuilder)localObject1).append(" mIsShow = ");
    ((StringBuilder)localObject1).append(this.n);
    QLog.e("IliveSingleWebModule", 1, ((StringBuilder)localObject1).toString());
    localObject1 = t();
    if (localObject1 == null) {
      return;
    }
    if ((this.o) && (this.n)) {
      ((TouchWebView)localObject1).setVisibility(0);
    }
    Object localObject2 = q;
    if (localObject2 != null) {
      ((IliveSingleWebviewWrapper)localObject2).onResume();
    }
    if (u()) {
      return;
    }
    try
    {
      if (((TouchWebView)localObject1).getParent() != null) {
        ((ViewGroup)((TouchWebView)localObject1).getParent()).removeView((View)localObject1);
      }
      this.c = q.b();
      if (this.c != null) {
        ((TouchWebView)localObject1).addJavascriptInterface(this.c, "__WEBVIEW_APP");
      }
      this.g.addView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("addWebView exception msg = ");
      ((StringBuilder)localObject2).append(localThrowable.getMessage());
      QLog.e("IliveSingleWebModule", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPause current =  ");
      localStringBuilder.append(b());
      QLog.i("IliveSingleWebModule", 2, localStringBuilder.toString());
    }
    if (b()) {
      super.onActivityPause(paramLifecycleOwner);
    }
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResume current =  ");
      localStringBuilder.append(b());
      QLog.i("IliveSingleWebModule", 2, localStringBuilder.toString());
    }
    if (b()) {
      super.onActivityResume(paramLifecycleOwner);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    IliveLiteEventCenter.a().a(this.r);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IliveLiteEventCenter.a().b(this.r);
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    this.o = false;
    this.n = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoom roomId = ");
    localStringBuilder.append(m());
    QLog.e("IliveSingleWebModule", 1, localStringBuilder.toString());
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    paramSwitchRoomInfo = new StringBuilder();
    paramSwitchRoomInfo.append("onSwitchRoom roomId = ");
    paramSwitchRoomInfo.append(m());
    QLog.e("IliveSingleWebModule", 1, paramSwitchRoomInfo.toString());
    this.p = System.currentTimeMillis();
    j();
    paramSwitchRoomInfo = q;
    if (paramSwitchRoomInfo != null)
    {
      paramSwitchRoomInfo.a(this.context, this.l);
      q.setOnWebviewTouchListener(this);
    }
    q();
    v();
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    IliveLiteEventCenter.a().a("ACTION_WEBVIEW_SHOW_GIFT_ICON_EVENT", null);
  }
  
  protected void p()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start loadUrl roomid = ");
    localStringBuilder.append(m());
    localStringBuilder.append(" mSwitchCallbackId = ");
    localStringBuilder.append(a);
    localStringBuilder.append(" isForceLoad = ");
    localStringBuilder.append(b);
    QLog.e("IliveSingleWebModule", 1, localStringBuilder.toString());
    this.o = true;
    if ((!TextUtils.isEmpty(a)) && (!BusinessManager.a.b().k) && (!b))
    {
      o();
      return;
    }
    super.p();
  }
  
  protected App r()
  {
    IliveSingleWebviewWrapper localIliveSingleWebviewWrapper = q;
    if (localIliveSingleWebviewWrapper != null) {
      return localIliveSingleWebviewWrapper.b();
    }
    return super.r();
  }
  
  protected WebviewWrapper s()
  {
    return q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveSingleWebModule
 * JD-Core Version:    0.7.0.1
 */