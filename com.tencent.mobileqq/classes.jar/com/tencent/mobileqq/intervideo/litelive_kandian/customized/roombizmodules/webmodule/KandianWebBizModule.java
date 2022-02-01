package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.webmodule;

import android.os.Build.VERSION;
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
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.DataReportMgr;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.OnGetRoomExtInfoListener;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.WebCookieManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class KandianWebBizModule
  extends CustomWebModule
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
  
  public RoomExtInfo a()
  {
    return this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
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
  
  public String b()
  {
    return "https://ilive.qq.com/1014/h5/lite_room.html";
  }
  
  protected void b()
  {
    super.b();
    WebCookieManager.a().a(BaseApplicationImpl.getContext(), "https://now.qq.com/");
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  public String c()
  {
    return "https://fastest.ilive.qq.com/1014/h5/lite_room.html";
  }
  
  public String d()
  {
    return "https://ilive.qq.com/1014/h5/lite_record.html";
  }
  
  public String e()
  {
    return "https://fastest.ilive.qq.com/1014/h5/lite_record.html";
  }
  
  public String f()
  {
    return "https://ilive.qq.com/1014/h5/lite_temporary.html";
  }
  
  public String g()
  {
    return "https://fastest.ilive.qq.com/1014/h5/lite_temporary.html";
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo = null;
    this.c = false;
    this.b = false;
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.webmodule.KandianWebBizModule
 * JD-Core Version:    0.7.0.1
 */