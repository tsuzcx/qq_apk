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
import com.tencent.ilive.commonpages.room.VerticalViewPager;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
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
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class NowWebBizModule
  extends NowCustomWebModule
  implements OnGetRoomExtInfoListener
{
  private RoomExtInfo jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private int a()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    }
    return 0;
  }
  
  private void a(String paramString)
  {
    a("now_mqq_scheme", paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = new NowWebBizModule.SharePreferenceUtil(BaseApplicationImpl.getContext(), "now_room_info").a();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  private boolean b()
  {
    boolean bool = false;
    int j = a();
    if (getAudienceRoomPager().getViewPager() != null) {}
    for (int i = getAudienceRoomPager().getViewPager().getCurrentItem();; i = 0)
    {
      if (j == i) {
        bool = true;
      }
      return bool;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo == null) || (!"4".equals(this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo.state))) {
      return;
    }
    Object localObject = BizEngineMgr.getInstance().getLiveEngine();
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        localObject = (QualityReportServiceInterface)((LiveEngine)localObject).getService(QualityReportServiceInterface.class);
        if (localObject != null)
        {
          localObject = ((QualityReportServiceInterface)localObject).getAudQualityReporter();
          if (localObject != null)
          {
            if (!this.b) {
              continue;
            }
            ((AudQualityServiceInterface)localObject).reportSwitchOver();
            QLog.i("DataReportMgr", 1, "reportSwitchOver");
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      DataReportMgr.a().a(this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo);
      this.jdField_a_of_type_Boolean = true;
      return;
      ((AudQualityServiceInterface)localObject).reportEnterOver();
      QLog.i("DataReportMgr", 1, "reportEnterOver");
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
    String str2 = Build.VERSION.RELEASE;
    int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
    String str1;
    if (!StringUtil.a(paramString))
    {
      str1 = paramString;
      if (paramString.contains("NowSDK/")) {}
    }
    else
    {
      str1 = paramString + " NowLive/" + 10305 + "_" + str2 + " NetType/" + i + " NowSDK/18_10.20";
    }
    return str1;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowQQApiJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowAppJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowUIJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter, this.roomBizContext));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowDeviceJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new NowQwMixAndroidJs(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(new SsoJavascriptInterface(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.context, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter));
  }
  
  public void a(RoomExtInfo paramRoomExtInfo)
  {
    super.a(paramRoomExtInfo);
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo = paramRoomExtInfo;
    if (b()) {
      c();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    RoomExtInfo localRoomExtInfo;
    if (this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo != null)
    {
      localRoomExtInfo = this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (String str = "1";; str = "0")
    {
      localRoomExtInfo.followStatus = str;
      return;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return "https://now.qq.com/h5/story.html";
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
    this.b = false;
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    Bundle localBundle = this.roomBizContext.getEnterRoomInfo().extData;
    if ((localBundle != null) && (localBundle.containsKey("mqqschema"))) {
      a(localBundle.getString("mqqschema"));
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    String str = h();
    if (!TextUtils.isEmpty(str)) {
      paramSwitchRoomInfo.extData.putString("mqqschema", str);
    }
    super.onSwitchRoom(paramSwitchRoomInfo);
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowWebBizModule
 * JD-Core Version:    0.7.0.1
 */