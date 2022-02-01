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
  private RoomExtInfo b;
  private boolean n;
  private boolean o;
  
  private void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = new NowWebBizModule.SharePreferenceUtil(BaseApplicationImpl.getContext(), "now_room_info").b();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  private void c(String paramString)
  {
    a("now_mqq_scheme", paramString);
  }
  
  private void m()
  {
    if (this.n) {
      return;
    }
    Object localObject = this.b;
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
              boolean bool = this.o;
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
      DataReportMgr.a().a(this.b);
      this.n = true;
    }
  }
  
  private boolean t()
  {
    int j = u();
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
  
  private int u()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    }
    return 0;
  }
  
  private String v()
  {
    return new NowWebBizModule.SharePreferenceUtil(BaseApplicationImpl.getContext(), "now_room_info").a().getString("now_mqq_scheme", "");
  }
  
  public String a()
  {
    return "live";
  }
  
  public String a(String paramString)
  {
    String str = Build.VERSION.RELEASE;
    int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
    if ((!StringUtil.isEmpty(paramString)) && (paramString.contains("NowSDK/"))) {
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
  
  protected void a(RoomExtInfo paramRoomExtInfo)
  {
    super.a(paramRoomExtInfo);
    this.b = paramRoomExtInfo;
    if (t()) {
      m();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    RoomExtInfo localRoomExtInfo = this.b;
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
  
  public RoomExtInfo c()
  {
    return this.b;
  }
  
  public String d()
  {
    return "https://now.qq.com/h5/story.html";
  }
  
  public String e()
  {
    return "https://fastest.now.qq.com/h5/story.html";
  }
  
  public String f()
  {
    return "https://now.qq.com/h5/record.html";
  }
  
  public String g()
  {
    return null;
  }
  
  public String h()
  {
    return null;
  }
  
  public String i()
  {
    return null;
  }
  
  protected void j()
  {
    super.j();
    this.k.registerJsModule(new NowQQApiJs(this.f, this.context, this.l));
    this.k.registerJsModule(new NowAppJs(this.f, this.context, this.l));
    this.k.registerJsModule(new NowUIJs(this.f, this.context, this.l, this.roomBizContext));
    this.k.registerJsModule(new NowDeviceJs(this.f, this.context, this.l));
    this.k.registerJsModule(new NowQwMixAndroidJs(this.f, this.context, this.l));
    this.k.registerJsModule(new SsoJavascriptInterface(this.f, this.context, this.l));
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
    WebCookieManager.a().a(BaseApplicationImpl.getContext(), "https://now.qq.com/");
    this.l.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  public boolean onBackPressed()
  {
    if ((this.f != null) && (this.f.canGoBack()))
    {
      this.f.goBack();
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
    this.b = null;
    this.o = false;
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    Bundle localBundle = this.roomBizContext.getEnterRoomInfo().extData;
    if ((localBundle != null) && (localBundle.containsKey("mqqschema"))) {
      c(localBundle.getString("mqqschema"));
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    String str = v();
    if (!TextUtils.isEmpty(str)) {
      paramSwitchRoomInfo.extData.putString("mqqschema", str);
    }
    super.onSwitchRoom(paramSwitchRoomInfo);
    this.o = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowWebBizModule
 * JD-Core Version:    0.7.0.1
 */