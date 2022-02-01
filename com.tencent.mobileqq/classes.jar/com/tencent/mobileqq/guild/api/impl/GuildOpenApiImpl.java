package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.mobileqq.guild.config.QQGuildConfigBean;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.URLUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class GuildOpenApiImpl
  implements IGuildOpenApi
{
  private static final String TAG = "QQGuildOpenApiImpl";
  private AppRuntime app;
  private HashMap<String, GuildOpenApiImpl.GuildPackageData> mPackageSchemeMap = new HashMap();
  
  private GuildOpenApiImpl.GuildPackageData getDefaultPackageData()
  {
    int i = this.mPackageSchemeMap.size();
    GuildOpenApiImpl.GuildPackageData localGuildPackageData = null;
    if (i == 0)
    {
      QLog.e("QQGuildOpenApiImpl", 1, "handleGuildOpenResultSuccess package is null");
      return null;
    }
    Iterator localIterator = this.mPackageSchemeMap.values().iterator();
    if (localIterator.hasNext()) {
      localGuildPackageData = (GuildOpenApiImpl.GuildPackageData)localIterator.next();
    }
    return localGuildPackageData;
  }
  
  private String getGuildOpenCreateUrl(boolean paramBoolean)
  {
    Object localObject1 = QQGuildUtil.c();
    if (localObject1 == null) {
      return "";
    }
    if (paramBoolean) {
      localObject1 = ((QQGuildConfigBean)localObject1).f;
    } else {
      localObject1 = ((QQGuildConfigBean)localObject1).e;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "";
    }
    return localObject2;
  }
  
  private void goBackToThirdApp(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("openid", paramString3);
      ((JSONObject)localObject).put("user_openid", paramString3);
      ((JSONObject)localObject).put("gamedata", Base64.encodeToString(paramString2.getBytes(), 0));
    }
    catch (Exception paramString2)
    {
      QLog.e("QQGuildOpenApiImpl", 1, paramString2, new Object[0]);
    }
    paramString2 = String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response=%3$s", new Object[] { Long.valueOf(paramLong), "guildOpen", ((JSONObject)localObject).toString() });
    paramString3 = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleGuildOpenResult uriString:");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("QQGuildOpenApiImpl", 1, ((StringBuilder)localObject).toString());
    paramString3.setPackage(paramString1);
    paramString3.addFlags(268435456);
    paramString3.putExtra("big_brother_source_key", "biz_src_jc_qqstation_wzry");
    BaseApplication.getContext().startActivity(paramString3);
  }
  
  private void showBackThirdAppDialog() {}
  
  public QQGuildOpenData getGuildOpenDataFromApp(String paramString)
  {
    paramString = (GuildOpenApiImpl.GuildPackageData)this.mPackageSchemeMap.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.c;
  }
  
  public void gotoGuildOpenAddAction(Activity paramActivity, String paramString1, String paramString2, QQGuildOpenData paramQQGuildOpenData)
  {
    this.mPackageSchemeMap.clear();
    this.mPackageSchemeMap.put(paramString1, new GuildOpenApiImpl.GuildPackageData(paramString1, paramString2, paramQQGuildOpenData));
    paramString1 = new Bundle();
    paramString1.putSerializable("extra_open_guild_data", paramQQGuildOpenData);
    ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab(paramActivity, GuildMainFrameConstants.r, paramString1);
  }
  
  public void gotoGuildOpenCreateAction(Activity paramActivity, String paramString1, String paramString2, QQGuildOpenData paramQQGuildOpenData)
  {
    this.mPackageSchemeMap.clear();
    this.mPackageSchemeMap.put(paramString1, new GuildOpenApiImpl.GuildPackageData(paramString1, paramString2, paramQQGuildOpenData));
    String str = getGuildOpenCreateUrl(paramQQGuildOpenData.isFromSDK);
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildOpenApiImpl", 2, new Object[] { "gotoGuildOpenCreateAction url:", str });
    }
    paramString2 = str;
    if (!TextUtils.isEmpty(str)) {
      paramString2 = URLUtil.a(URLUtil.a(str, "raw_url", paramQQGuildOpenData.rawUrl), "package_id", paramString1);
    }
    paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString1.putExtra("url", paramString2);
    paramActivity.startActivity(paramString1);
    paramActivity.finish();
  }
  
  public void handleBackToAppDialog(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramActivity == null) {
        return;
      }
      Object localObject = paramBundle.getString("guild_from");
      String str = paramBundle.getString("guild_from_app_name");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if ((!"guildOpenCreate".equals(localObject)) && (!"guildOpenJoin".equals(localObject))) {
          return;
        }
        paramBundle = ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString);
        GuildOpenApiImpl.GuildPackageData localGuildPackageData = getDefaultPackageData();
        if ((paramBundle != null) && (localGuildPackageData != null) && (localGuildPackageData.c != null))
        {
          boolean bool = ((String)localObject).equals("guildOpenCreate");
          QLog.i("QQGuildOpenApiImpl", 1, "handleBackToAppDialog show dialog success");
          if (bool) {
            paramString = "频道创建成功！";
          } else {
            paramString = "加入成功！";
          }
          paramString = String.format("%s是否返回%s", new Object[] { paramString, str });
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("返回");
          localStringBuilder.append(str);
          localStringBuilder.append("");
          paramString = DialogUtil.a(paramActivity, 232, null, paramString, "留在频道", localStringBuilder.toString(), new GuildOpenApiImpl.1(this, (String)localObject, localGuildPackageData), new GuildOpenApiImpl.2(this));
          paramString.show();
          localObject = paramString.findViewById(2131431871);
          if (bool) {
            paramActivity = "pg_sgrp_create_success";
          } else {
            paramActivity = "pg_sgrp_join_success";
          }
          VideoReport.setPageId(localObject, paramActivity);
          paramActivity = new HashMap();
          paramActivity.put("dt_appkey", "0S200MNJT807V3GE");
          paramActivity.put("sgrp_channel_id", paramBundle.getGuildID());
          paramActivity.put("sgrp_game_teamid", localGuildPackageData.c.orgId);
          paramActivity.put("sgrp_game_sceneid", localGuildPackageData.c.from);
          paramActivity.put("sgrp_game_appid", Long.valueOf(localGuildPackageData.c.appId));
          VideoReport.setPageParams(localObject, new PageParams(paramActivity));
          paramBundle = paramString.getBtnLeft();
          if (bool) {
            paramActivity = "em_sgrp_create_success_stay";
          } else {
            paramActivity = "em_sgrp_join_success_stay";
          }
          VideoReport.setElementId(paramBundle, paramActivity);
          VideoReport.setElementExposePolicy(paramString.getBtnLeft(), ExposurePolicy.REPORT_ALL);
          VideoReport.setElementClickPolicy(paramString.getBtnLeft(), ClickPolicy.REPORT_ALL);
          paramBundle = paramString.getBtnight();
          if (bool) {
            paramActivity = "em_sgrp_create_success_back";
          } else {
            paramActivity = "em_sgrp_join_success_back";
          }
          VideoReport.setElementId(paramBundle, paramActivity);
          VideoReport.setElementExposePolicy(paramString.getBtnight(), ExposurePolicy.REPORT_ALL);
          VideoReport.setElementClickPolicy(paramString.getBtnight(), ClickPolicy.REPORT_ALL);
          return;
        }
        QLog.e("QQGuildOpenApiImpl", 1, "handleBackToAppDialog null guildInfo or packageData");
      }
    }
  }
  
  public void handleEnterToTroop(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleEnterToTroop, troopUin: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(",packageId:");
    ((StringBuilder)localObject).append(paramString1);
    QLog.i("QQGuildOpenApiImpl", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.e("QQGuildOpenApiImpl", 1, "handleEnterToTroop error troop uin");
      return;
    }
    localObject = BaseAIOUtils.a(new Intent(), new int[] { 2 });
    ((Intent)localObject).putExtra("uin", paramString2);
    ((Intent)localObject).putExtra("uintype", 1);
    ((Intent)localObject).putExtra("fromThirdAppByOpenSDK", true);
    ((Intent)localObject).putExtra("action", 4);
    paramString1 = getGuildOpenDataFromApp(paramString1);
    if (paramString1 == null)
    {
      QLog.e("QQGuildOpenApiImpl", 1, "handleEnterToTroop error none guildOpenData");
      return;
    }
    ((Intent)localObject).putExtra("appid", String.valueOf(paramString1.appId));
    ((Intent)localObject).putExtra("app_name", paramString1.appName);
    ((Intent)localObject).putExtra("pkg_name", paramString1.packageId);
    RouteUtils.a(BaseApplication.getContext(), (Intent)localObject, "/base/start/splash");
  }
  
  public void handleGuildOpenResult(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.mPackageSchemeMap.get(paramString1) != null))
    {
      GuildOpenApiImpl.GuildPackageData localGuildPackageData = (GuildOpenApiImpl.GuildPackageData)this.mPackageSchemeMap.get(paramString1);
      if (localGuildPackageData == null) {
        return;
      }
      goBackToThirdApp(localGuildPackageData.c.appId, paramString1, paramString2, localGuildPackageData.c.openId);
      return;
    }
    QLog.e("QQGuildOpenApiImpl", 1, "handleGuildOpenResult error scheme and package is null");
  }
  
  public void handleGuildOpenResult(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    goBackToThirdApp(paramLong, paramString1, paramString2, paramString3);
  }
  
  public void handleTroopBackToAppDialog(Activity paramActivity, Bundle paramBundle)
  {
    if (!paramBundle.getBoolean("fromThirdAppByOpenSDK")) {
      return;
    }
    paramBundle = getGuildOpenDataFromApp(paramBundle.getString("pkg_name"));
    String str = String.format("%s是否返回%s", new Object[] { "战队群创建成功！", paramBundle.appName });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("返回");
    localStringBuilder.append(paramBundle.appName);
    localStringBuilder.append("");
    DialogUtil.a(paramActivity, 232, null, str, "留在战队群", localStringBuilder.toString(), new GuildOpenApiImpl.3(this, paramBundle), new GuildOpenApiImpl.4(this)).show();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    this.mPackageSchemeMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildOpenApiImpl
 * JD-Core Version:    0.7.0.1
 */