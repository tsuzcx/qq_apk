package com.tencent.mobileqq.troop.troopsetting.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studyroom.api.IStudyRoomReporter;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;

class TroopSettingActivity$55
  implements View.OnClickListener
{
  TroopSettingActivity$55(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof oidb_0xe83.AppInfo))
    {
      oidb_0xe83.AppInfo localAppInfo = (oidb_0xe83.AppInfo)localObject1;
      String str1 = localAppInfo.url.get();
      long l2 = localAppInfo.appid.get();
      localObject1 = (ITroopInfoService)TroopSettingActivity.a(this.a).getRuntimeService(ITroopInfoService.class, "");
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((ITroopInfoService)localObject1).getTroopInfo(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          l1 = ((TroopInfo)localObject2).dwGroupClassExt;
          localObject1 = localObject2;
          break label111;
        }
      }
      else
      {
        localObject1 = null;
      }
      long l1 = 0L;
      label111:
      String str2 = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
      long l3 = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt;
      if (paramView.getTag(-1) == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(String.valueOf(l2));
        ((StringBuilder)localObject2).append("-0");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(String.valueOf(l2));
        ((StringBuilder)localObject2).append("-");
        ((StringBuilder)localObject2).append(paramView.getTag(-1).toString());
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      ReportController.b(null, "dc00898", "", str2, "0X800AFC4", "0X800AFC4", 0, 0, String.valueOf(l3), String.valueOf(l2), (String)localObject2, "");
      if (l2 == 0L)
      {
        ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).launcherTroopShortcutFragment(this.a.getActivity(), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        ReportController.b(null, "dc00898", "", this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "0X800AFC6", "0X800AFC6", 0, 0, String.valueOf(l1), "", "", "");
        ((ITroopAppService)TroopSettingActivity.a(this.a).getRuntimeService(ITroopAppService.class, "all")).setProfileAppListChangedFromWebOperate(true, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
      if ((!TextUtils.isEmpty(str1)) && (!TroopSettingActivity.a(this.a, l2, (TroopInfo)localObject1)))
      {
        if (l2 == 1101236949L) {
          ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).handleAppClick1101236949(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, this.a);
        }
        if (l2 == 101914115L) {
          ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).reportClockTroopAppShowOrClick(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, false);
        }
        int i = localAppInfo.push_red_point.get();
        if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(str1))
        {
          localObject1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).replaceSpecialTag(str1, l2, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, TroopSettingActivity.a(this.a), true);
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.a, (String)localObject1, 2010, ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).createEntryModel(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin), null);
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).reportQunMiniApp(localAppInfo, "click", this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        }
        for (;;)
        {
          break;
          if ((!str1.startsWith("http")) && (!str1.startsWith("https")))
          {
            if (str1.startsWith("mqqapi"))
            {
              localObject1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).replaceSpecialTag(str1, l2, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, TroopSettingActivity.a(this.a), true);
              if (l2 == 1105981808L)
              {
                localObject1 = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).configTroopStoryProfileFromAIO(this.a.getIntent(), (String)localObject1, null);
                ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).StoryReportorReportEvent("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
              }
              localObject2 = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getJumpActionIntent(this.a);
              ((Intent)localObject2).setData(Uri.parse((String)localObject1));
              this.a.startActivity((Intent)localObject2);
            }
          }
          else
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("url", ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).replaceSpecialTag(str1, l2, i, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, TroopSettingActivity.a(this.a), true));
            ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
            ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
            TroopSettingActivity.a((Intent)localObject1, l2);
            localObject2 = new ActivityURIRequest(this.a, "/base/browser");
            ((ActivityURIRequest)localObject2).extra().putAll(((Intent)localObject1).getExtras());
            ((ActivityURIRequest)localObject2).setFlags(((Intent)localObject1).getFlags());
            QRoute.startUri((URIRequest)localObject2, null);
          }
        }
        if (i != 0)
        {
          localAppInfo.push_red_point.set(0);
          ((TextView)paramView.findViewById(2131362859)).setVisibility(8);
          ((ITroopRedDotHandler)TroopSettingActivity.a(this.a).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopRedDotHandlerName())).a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, (int)l2);
        }
        TroopReportor.a("Grp_app_new", "grpData_admin", "app_clk", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData), String.valueOf(l2) });
        if (l2 == 0L) {
          localObject1 = "app_clk";
        }
        for (;;)
        {
          break;
          if (l2 == 1L) {
            localObject1 = "clk_file";
          } else if (l2 == 2L) {
            localObject1 = "clk_album";
          } else if (l2 == 1101236949L) {
            localObject1 = "clk_notice";
          } else {
            localObject1 = "";
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          TroopReportor.a("Grp_app_new", "grpData_admin", (String)localObject1, 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
        }
        ((IStudyRoomReporter)QRoute.api(IStudyRoomReporter.class)).reportForTroopEntry(l2, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.55
 * JD-Core Version:    0.7.0.1
 */