package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.webmodule;

import android.os.Build.VERSION;
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
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.DataReportMgr;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.OnGetRoomExtInfoListener;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class KandianWebBizModule
  extends CustomWebModule
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
  
  public RoomExtInfo a()
  {
    return this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleModelRoomExtInfo;
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
        break label30;
      }
    }
    label30:
    for (String str = "1";; str = "0")
    {
      localRoomExtInfo.followStatus = str;
      return;
    }
  }
  
  public String b()
  {
    return "https://ilive.qq.com/1014/h5/lite_room.html";
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
    this.b = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.webmodule.KandianWebBizModule
 * JD-Core Version:    0.7.0.1
 */