package com.tencent.mobileqq.intervideo.lite_now_biz.now_live;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowAppJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowDeviceJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQQApiJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQwMixAndroidJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowUIJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.SsoJavascriptInterface;
import com.tencent.mobileqq.intervideo.lite_now_biz.module.NowCustomWebModule;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.DataReportMgr;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.OnGetRoomExtInfoListener;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.WebCookieManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class NowWebBizModule
  extends NowCustomWebModule
  implements OnGetRoomExtInfoListener
{
  private RoomExtInfo a;
  private boolean b;
  private boolean c;
  
  private int a()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    }
    return 0;
  }
  
  private void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = new NowWebBizModule.SharePreferenceUtil(BaseApplicationImpl.getContext(), "now_room_info").a();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  private void b(String paramString)
  {
    a("now_mqq_scheme", paramString);
  }
  
  private boolean b()
  {
    int j = a();
    IAudienceRoomPager localIAudienceRoomPager = getAudienceRoomPager();
    boolean bool = false;
    int i;
    if (localIAudienceRoomPager != null) {
      i = getAudienceRoomPager().getCurrentIndex();
    } else {
      i = 0;
    }
    if (j == i) {
      bool = true;
    }
    return bool;
  }
  
  private void c()
  {
    if (this.b) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
    if ((localObject != null) && ("4".equals(((RoomExtInfo)localObject).state)))
    {
      localObject = BizEngineMgr.getInstance().getLiveEngine();
      if (localObject != null) {
        try
        {
          localObject = (QualityReportServiceInterface)((LiveEngine)localObject).getService(QualityReportServiceInterface.class);
          if (localObject != null)
          {
            localObject = ((QualityReportServiceInterface)localObject).getAudQualityReporter();
            if (localObject != null)
            {
              boolean bool = this.c;
              if (bool)
              {
                ((AudQualityServiceInterface)localObject).reportSwitchOver();
                QLog.i("DataReportMgr", 1, "reportSwitchOver");
              }
              else
              {
                ((AudQualityServiceInterface)localObject).reportEnterOver();
                QLog.i("DataReportMgr", 1, "reportEnterOver");
              }
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      DataReportMgr.a().a(this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo);
      this.b = true;
    }
  }
  
  private String h()
  {
    return new NowWebBizModule.SharePreferenceUtil(BaseApplicationImpl.getContext(), "now_room_info").a().getString("now_mqq_scheme", "");
  }
  
  public RoomExtInfo a()
  {
    return this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
  }
  
  public String a()
  {
    return "live";
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
    localStringBuilder.append(" NetType/");
    localStringBuilder.append(i);
    localStringBuilder.append(" NowSDK/18_10.20");
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowQQApiJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowAppJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowUIJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter, this.roomBizContext));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowDeviceJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowQwMixAndroidJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new SsoJavascriptInterface(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
  }
  
  protected void a(RoomExtInfo paramRoomExtInfo)
  {
    super.a(paramRoomExtInfo);
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo = paramRoomExtInfo;
    if (b()) {
      c();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    RoomExtInfo localRoomExtInfo = this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
    if (localRoomExtInfo != null)
    {
      String str;
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      }
      localRoomExtInfo.followStatus = str;
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return "https://now.qq.com/h5/story.html";
  }
  
  protected void b()
  {
    WebCookieManager.a().a(this.context, this.jdField_a_of_type_JavaLangString);
    WebCookieManager.a().a(this.context, "https://yutang.qq.com/");
    WebCookieManager.a().a(this.context, "https://ilive.qq.com/");
    WebCookieManager.a().a(BaseApplicationImpl.getContext(), "https://now.qq.com/");
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  public String c()
  {
    return "https://fastest.now.qq.com/h5/story.html";
  }
  
  public String d()
  {
    return "https://now.qq.com/h5/record.html";
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
  
  public boolean onBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack()))
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
      return true;
    }
    return super.onBackPressed();
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo = null;
    this.c = false;
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    Bundle localBundle = this.roomBizContext.getEnterRoomInfo().extData;
    if ((localBundle != null) && (localBundle.containsKey("mqqschema"))) {
      b(localBundle.getString("mqqschema"));
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    String str = h();
    if (!TextUtils.isEmpty(str)) {
      paramSwitchRoomInfo.extData.putString("mqqschema", str);
    }
    super.onSwitchRoom(paramSwitchRoomInfo);
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowWebBizModule
 * JD-Core Version:    0.7.0.1
 */