package com.tencent.mobileqq.troop.troopapps.api.impl;

import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi;
import com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi.IGetAppInfoCB;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x8d3.oidb_0x8d3.AppInfo;
import tencent.im.oidb.cmd0x8d3.oidb_0x8d3.AppTip;
import tencent.im.oidb.cmd0x8d3.oidb_0x8d3.ReqBody;
import tencent.im.oidb.cmd0x8d3.oidb_0x8d3.RspBody;
import tencent.im.oidb.oidb_0x8cf.oidb_0x8cf.AppBrief;
import tencent.im.oidb.oidb_0x8cf.oidb_0x8cf.ReqBody;
import tencent.im.oidb.oidb_0x8cf.oidb_0x8cf.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopCardAppInfoHelperApiImpl
  implements ITroopCardAppInfoHelperApi
{
  public static final String CMD_GET_TROOP_APP_BRIEF_LIST = "OidbSvc.0x8cf_6";
  public static final String CMD_GET_TROOP_APP_INFO_LIST = "OidbSvc.0x8d3_1";
  protected static final String TAG = "TroopCardAppInfoHandler";
  protected boolean bIsDestroy = false;
  protected AppRuntime mApp;
  protected ITroopCardAppInfoHelperApi.IGetAppInfoCB mIGetAppInfoCB;
  
  private void getAppInfoDetail(List<Long> paramList)
  {
    Object localObject = new oidb_0x8d3.ReqBody();
    ((oidb_0x8d3.ReqBody)localObject).rpt_uint64_appidlist.set(paramList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2259);
    paramList.uint32_service_type.set(1);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8d3.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.mApp.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x8d3_1");
    ((NewIntent)localObject).putExtra("data", paramList.toByteArray());
    ((NewIntent)localObject).setObserver(new TroopCardAppInfoHelperApiImpl.2(this));
    this.mApp.startServlet((NewIntent)localObject);
  }
  
  private void onFailed()
  {
    ITroopCardAppInfoHelperApi.IGetAppInfoCB localIGetAppInfoCB = this.mIGetAppInfoCB;
    if (localIGetAppInfoCB != null) {
      localIGetAppInfoCB.a();
    }
  }
  
  private void onSucess(ArrayList<TroopAppInfo> paramArrayList)
  {
    ITroopCardAppInfoHelperApi.IGetAppInfoCB localIGetAppInfoCB = this.mIGetAppInfoCB;
    if (localIGetAppInfoCB != null) {
      localIGetAppInfoCB.a(paramArrayList);
    }
  }
  
  private ArrayList<Long> parseAppInfoBriefList(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    oidb_0x8cf.RspBody localRspBody = new oidb_0x8cf.RspBody();
    localArrayList = new ArrayList();
    try
    {
      localRspBody.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      paramOIDBSSOPkg = localRspBody.rpt_msg_app_brief.get().iterator();
      while (paramOIDBSSOPkg.hasNext()) {
        localArrayList.add(Long.valueOf(((oidb_0x8cf.AppBrief)paramOIDBSSOPkg.next()).opt_uint64_appid.get()));
      }
      return localArrayList;
    }
    catch (Exception paramOIDBSSOPkg)
    {
      paramOIDBSSOPkg.printStackTrace();
    }
  }
  
  private ArrayList<TroopAppInfo> parseAppInfoDetail(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    localArrayList = new ArrayList();
    try
    {
      Object localObject1 = new oidb_0x8d3.RspBody();
      ((oidb_0x8d3.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      paramOIDBSSOPkg = ((oidb_0x8d3.RspBody)localObject1).rpt_msg_appinfo_list.get();
      if ((paramOIDBSSOPkg != null) && (paramOIDBSSOPkg.size() > 0))
      {
        paramOIDBSSOPkg = paramOIDBSSOPkg.iterator();
        while (paramOIDBSSOPkg.hasNext())
        {
          Object localObject2 = (oidb_0x8d3.AppInfo)paramOIDBSSOPkg.next();
          localObject1 = new TroopAppInfo();
          ((TroopAppInfo)localObject1).appId = ((oidb_0x8d3.AppInfo)localObject2).opt_uint64_appid.get();
          ((TroopAppInfo)localObject1).appName = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_appname.get().toByteArray());
          ((TroopAppInfo)localObject1).appType = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_type.get();
          ((TroopAppInfo)localObject1).appFrom = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_from.get();
          ((TroopAppInfo)localObject1).appIntro = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_app_intro.get().toByteArray());
          ((TroopAppInfo)localObject1).appUrl = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_app_url.get().toByteArray());
          ((TroopAppInfo)localObject1).appIcon = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_app_icon.get().toByteArray());
          ((TroopAppInfo)localObject1).appWindowHeight = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_window_high.get();
          ((TroopAppInfo)localObject1).appWindowWidth = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_window_width.get();
          ((TroopAppInfo)localObject1).appUpdateTime = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_update_time.get();
          ((TroopAppInfo)localObject1).openParam = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_open_param.get().toByteArray());
          ((TroopAppInfo)localObject1).appStatus = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_status.get();
          ((TroopAppInfo)localObject1).appInnerType = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_inner_type.get();
          ((TroopAppInfo)localObject1).initFlag = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_init_flag.get();
          ((TroopAppInfo)localObject1).settingFlag = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_setting_flag.get();
          ((TroopAppInfo)localObject1).tags = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_tags.get().toByteArray());
          ((TroopAppInfo)localObject1).versionAndroid = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_version_android.get().toByteArray());
          ((TroopAppInfo)localObject1).androidDownloadUrl = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_android_download_url.get().toByteArray());
          ((TroopAppInfo)localObject1).androidOpen = new String(((oidb_0x8d3.AppInfo)localObject2).opt_bytes_android_open.get().toByteArray());
          ((TroopAppInfo)localObject1).appSortKey = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_sort_key.get();
          ((TroopAppInfo)localObject1).appIsNew = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_is_new.get();
          ((TroopAppInfo)localObject1).appNewTime = ((oidb_0x8d3.AppInfo)localObject2).opt_uint32_app_new_time.get();
          localObject2 = (oidb_0x8d3.AppTip)((oidb_0x8d3.AppInfo)localObject2).opt_msg_app_tip.get();
          if (localObject2 != null)
          {
            ((TroopAppInfo)localObject1).AppTipInfoSeq = ((oidb_0x8d3.AppTip)localObject2).uint32_tip_info_seq.get();
            ((TroopAppInfo)localObject1).AppTipIcon = new String(((oidb_0x8d3.AppTip)localObject2).bytes_icon.get().toByteArray());
            ((TroopAppInfo)localObject1).AppTipIconTimeStamp = ((oidb_0x8d3.AppTip)localObject2).uint32_icon_time_stamp.get();
            ((TroopAppInfo)localObject1).AppTipToolTip = new String(((oidb_0x8d3.AppTip)localObject2).bytes_tooltip.get().toByteArray());
            ((TroopAppInfo)localObject1).AppTipReportIdClick = ((oidb_0x8d3.AppTip)localObject2).uint32_reportid_click.get();
            ((TroopAppInfo)localObject1).AppTipReportIdShow = ((oidb_0x8d3.AppTip)localObject2).uint32_reportid_show.get();
          }
          localArrayList.add(localObject1);
        }
      }
      return localArrayList;
    }
    catch (Exception paramOIDBSSOPkg)
    {
      paramOIDBSSOPkg.printStackTrace();
    }
  }
  
  public void destroy()
  {
    this.mIGetAppInfoCB = null;
    this.bIsDestroy = true;
  }
  
  public boolean getAppInfoBriefList(String paramString, ITroopCardAppInfoHelperApi.IGetAppInfoCB paramIGetAppInfoCB)
  {
    return getAppInfoBriefList(paramString, paramIGetAppInfoCB, false);
  }
  
  public boolean getAppInfoBriefList(String paramString, ITroopCardAppInfoHelperApi.IGetAppInfoCB paramIGetAppInfoCB, boolean paramBoolean)
  {
    this.mIGetAppInfoCB = paramIGetAppInfoCB;
    paramIGetAppInfoCB = new oidb_0x8cf.ReqBody();
    try
    {
      paramIGetAppInfoCB.opt_uint64_groupcode.set(Long.parseLong(paramString));
      paramIGetAppInfoCB.opt_uint32_need_mobile_sysapps.set(1);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(2255);
      paramString.uint32_service_type.set(6);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIGetAppInfoCB.toByteArray()));
      paramIGetAppInfoCB = new NewIntent(this.mApp.getApplication(), ProtoServlet.class);
      paramIGetAppInfoCB.putExtra("cmd", "OidbSvc.0x8cf_6");
      paramIGetAppInfoCB.putExtra("data", paramString.toByteArray());
      paramIGetAppInfoCB.setObserver(new TroopCardAppInfoHelperApiImpl.1(this, paramBoolean));
      this.mApp.startServlet(paramIGetAppInfoCB);
      return true;
    }
    catch (NumberFormatException paramIGetAppInfoCB)
    {
      label133:
      break label133;
    }
    if (QLog.isColorLevel())
    {
      paramIGetAppInfoCB = new StringBuilder();
      paramIGetAppInfoCB.append("getTroopAppList, NumberFormatException, troopUin :");
      paramIGetAppInfoCB.append(paramString);
      QLog.d("TroopCardAppInfoHandler", 2, paramIGetAppInfoCB.toString());
    }
    onFailed();
    return false;
  }
  
  public void init(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopCardAppInfoHelperApiImpl
 * JD-Core Version:    0.7.0.1
 */