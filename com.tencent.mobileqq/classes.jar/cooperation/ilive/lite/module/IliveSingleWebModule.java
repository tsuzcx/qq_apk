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
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.App;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebViewPool;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebviewWrapper;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.room.RoomManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;
import cooperation.ilive.lite.js.IliveSingleWebviewWrapper;
import cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class IliveSingleWebModule
  extends IliveWebBizModule
{
  private static IliveSingleWebviewWrapper jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper;
  private static String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean = true;
  private long jdField_a_of_type_Long;
  private IliveLiteEventCenter.Observer jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter$Observer = new IliveSingleWebModule.1(this);
  private boolean c = false;
  private boolean d = false;
  
  private TouchWebView a()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = WebViewPool.a.a();
    }
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  private HashMap<String, String> a()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (b())) {
      return (HashMap)RoomManager.a(this.jdField_a_of_type_JavaLangString);
    }
    return null;
  }
  
  private JSONObject a()
  {
    return new JSONObject(a());
  }
  
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
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle = paramBundle.getString("callback_id");
    TouchWebView localTouchWebView = a();
    if ((localTouchWebView != null) && (!TextUtils.isEmpty(paramBundle)))
    {
      long l = a();
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
    ThreadCenter.postDefaultUITask(new IliveSingleWebModule.2(this, paramBundle));
  }
  
  public static void c()
  {
    QLog.e("IliveSingleWebModule", 1, "destorySingleWebView");
    jdField_b_of_type_JavaLangString = "";
    IliveSingleWebviewWrapper localIliveSingleWebviewWrapper = jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper;
    if (localIliveSingleWebviewWrapper != null)
    {
      localIliveSingleWebviewWrapper.b();
      jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper = null;
    }
  }
  
  private void c(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadCenter.postDefaultUITask(new IliveSingleWebModule.3(this, paramBundle));
  }
  
  private boolean c()
  {
    TouchWebView localTouchWebView = a();
    if (localTouchWebView == null) {
      return false;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i) == localTouchWebView) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void h()
  {
    if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString))
    {
      QLog.e("IliveSingleWebModule", 1, "preloadNextRoom mSwitchCallbackId = null");
      return;
    }
    TouchWebView localTouchWebView = a();
    if (localTouchWebView != null)
    {
      long l1 = LiveLiteRoomSwitchService.a(a() - 1);
      long l2 = LiveLiteRoomSwitchService.a(a() + 1);
      JSONObject localJSONObject1 = new JSONObject();
      Object localObject = new JSONObject();
      JSONObject localJSONObject2 = a();
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
        localTouchWebView.callJs(jdField_b_of_type_JavaLangString, new String[] { localJSONObject1.toString() });
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  protected App a()
  {
    IliveSingleWebviewWrapper localIliveSingleWebviewWrapper = jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper;
    if (localIliveSingleWebviewWrapper != null) {
      return localIliveSingleWebviewWrapper.a();
    }
    return super.a();
  }
  
  protected WebviewWrapper a()
  {
    return jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper;
  }
  
  protected void a()
  {
    if (jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper == null) {
      return;
    }
    QLog.e("IliveSingleWebModule", 1, "registerJsModule");
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider = jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper.a();
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a();
    super.a();
  }
  
  protected void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyVisibility state = ");
    localStringBuilder.append(paramInt);
    QLog.e("IliveSingleWebModule", 1, localStringBuilder.toString());
  }
  
  protected void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ilivetime  initWebview mSwitchCallbackId = ");
    ((StringBuilder)localObject).append(jdField_b_of_type_JavaLangString);
    QLog.e("IliveSingleWebModule", 1, ((StringBuilder)localObject).toString());
    if ((jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper != null) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp = jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper.a();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = a();
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider = new LiteLiveJsProvider();
      jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper = new IliveSingleWebviewWrapper(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter, this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider, this, getRootView());
      QLog.e("IliveSingleWebModule", 1, "initWebview create WebviewWrapper ");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = ((TouchWebView)jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper.getWebview());
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings();
      ((WebSettings)localObject).setUserAgentString(a(((WebSettings)localObject).getUserAgentString()));
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setHorizontalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOverScrollMode(2);
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp = new App(this.context.getApplicationContext(), getAudienceRoomPager(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
      jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp);
      jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper.onInit((Activity)this.context, ((Activity)this.context).getIntent(), "", this);
      e();
      a();
      jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper.a();
      a(this.jdField_a_of_type_JavaLangString);
      jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper.setOnWebviewTouchListener(this);
      if ((getAudienceRoomPager() != null) && (this.isUserVisibleHint))
      {
        localObject = getAudienceRoomPager();
        if (!this.jdField_a_of_type_Boolean) {
          ((IAudienceRoomPager)localObject).setScrollForbidden(true);
        } else {
          ((IAudienceRoomPager)localObject).setScrollForbidden(false);
        }
      }
    }
    f();
  }
  
  protected void e()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("addWebView mIsLoadUrl = ");
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append(" mIsShow = ");
    ((StringBuilder)localObject1).append(this.c);
    QLog.e("IliveSingleWebModule", 1, ((StringBuilder)localObject1).toString());
    localObject1 = a();
    if (localObject1 == null) {
      return;
    }
    if ((this.d) && (this.c)) {
      ((TouchWebView)localObject1).setVisibility(0);
    }
    Object localObject2 = jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper;
    if (localObject2 != null) {
      ((IliveSingleWebviewWrapper)localObject2).onResume();
    }
    if (c()) {
      return;
    }
    try
    {
      if (((TouchWebView)localObject1).getParent() != null) {
        ((ViewGroup)((TouchWebView)localObject1).getParent()).removeView((View)localObject1);
      }
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp = jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper.a();
      if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp != null) {
        ((TouchWebView)localObject1).addJavascriptInterface(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp, "__WEBVIEW_APP");
      }
      this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
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
  
  protected void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start loadUrl roomid = ");
    localStringBuilder.append(a());
    localStringBuilder.append(" mSwitchCallbackId = ");
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" isForceLoad = ");
    localStringBuilder.append(jdField_b_of_type_Boolean);
    QLog.e("IliveSingleWebModule", 1, localStringBuilder.toString());
    this.d = true;
    if ((!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) && (!BusinessManager.a.a().jdField_a_of_type_Boolean) && (!jdField_b_of_type_Boolean))
    {
      e();
      return;
    }
    super.f();
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
    IliveLiteEventCenter.a().a(this.jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter$Observer);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    IliveLiteEventCenter.a().b(this.jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter$Observer);
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    this.d = false;
    this.c = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoom roomId = ");
    localStringBuilder.append(a());
    QLog.e("IliveSingleWebModule", 1, localStringBuilder.toString());
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    paramSwitchRoomInfo = new StringBuilder();
    paramSwitchRoomInfo.append("onSwitchRoom roomId = ");
    paramSwitchRoomInfo.append(a());
    QLog.e("IliveSingleWebModule", 1, paramSwitchRoomInfo.toString());
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
    paramSwitchRoomInfo = jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper;
    if (paramSwitchRoomInfo != null)
    {
      paramSwitchRoomInfo.a(this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
      jdField_a_of_type_CooperationIliveLiteJsIliveSingleWebviewWrapper.setOnWebviewTouchListener(this);
    }
    g();
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveSingleWebModule
 * JD-Core Version:    0.7.0.1
 */