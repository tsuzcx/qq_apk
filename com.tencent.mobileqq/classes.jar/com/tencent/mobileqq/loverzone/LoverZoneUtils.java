package com.tencent.mobileqq.loverzone;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class LoverZoneUtils
{
  public static int a(String paramString)
  {
    Iterator localIterator = LpReportInfo_dc03950.LOVE_ZONE_SETTING_ME_RESERVES_LIST.iterator();
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 2;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.equals(paramString))) {
          return i;
        }
        i += 1;
      }
    }
    return 1;
  }
  
  public static String a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.buffer.has()))
    {
      paramAppInfo = paramAppInfo.buffer.get();
      try
      {
        localObject = new JSONObject(paramAppInfo);
        paramAppInfo = ((JSONObject)localObject).optJSONObject("param");
        localObject = ((JSONObject)localObject).optString("_show_mission");
        if ((paramAppInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          paramAppInfo = (JSONObject)paramAppInfo.opt((String)localObject);
          if (paramAppInfo != null) {
            return localObject;
          }
        }
      }
      catch (Exception paramAppInfo)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("buffer handle exception:");
        ((StringBuilder)localObject).append(paramAppInfo);
        QLog.e("LoverZoneUtils", 1, ((StringBuilder)localObject).toString());
        paramAppInfo.printStackTrace();
      }
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString)
  {
    a(paramQQAppInterface, paramContext, paramInt, paramString, "2");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    String str = QzoneConfig.getInstance().getConfig("sweet_miniapp", "sweet_mainpage", "mqqapi://miniapp/open?_atype=0&_mappid=1108789561&_mvid=&_vt=3&referer=brandonlin&via=brandonlin&_sig=57b13f050e544ea7391452287c2f92c7ebf08e0d4bd1faef7d72c8c961ea80c9");
    if (!TextUtils.isEmpty(str)) {
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(str))
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, str, paramInt, null);
      }
      else if ((str.startsWith("mqqapi://")) && (paramQQAppInterface != null))
      {
        paramContext = JumpParser.a(paramQQAppInterface, paramContext, str);
        if (paramContext != null) {
          paramContext.a();
        }
      }
      else if (paramQQAppInterface != null)
      {
        Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
        localIntent.putExtra("url", str.replace("{hostuin}", paramQQAppInterface.getCurrentAccountUin()));
        localIntent.putExtra("injectrecommend", true);
        localIntent.putExtra("finish_animation_out_to_right", true);
        localIntent.putExtra("is_wrap_content", true);
        localIntent.putExtra("hide_left_button", false);
        paramContext.startActivity(localIntent);
      }
    }
    a(paramString1, paramString2, "2", LpReportInfo_dc03950.getReportUserType(paramQQAppInterface));
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("goToLoverZone, url: %s", new Object[] { str }));
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("25", paramString1, paramString2, paramString3, paramString4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loverzone.LoverZoneUtils
 * JD-Core Version:    0.7.0.1
 */