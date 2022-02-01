package com.tencent.mobileqq.kandian.biz.framework;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadService;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.impl.ReadInJoyCaptureLauncher;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJUGCDianDian
{
  public static void a(int paramInt, List<PopupMenuDialog.MenuItem> paramList)
  {
    PopupMenuDialog.MenuItem localMenuItem;
    if ((paramInt & 0x1) != 0)
    {
      localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.id = 0;
      localMenuItem.title = BaseApplicationImpl.getApplication().getString(2131915352);
      localMenuItem.iconId = 2130843907;
      paramList.add(localMenuItem);
    }
    if ((paramInt & 0x2) != 0)
    {
      localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.id = 1;
      localMenuItem.title = BaseApplicationImpl.getApplication().getString(2131915356);
      localMenuItem.iconId = 2130843908;
      paramList.add(localMenuItem);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView)
  {
    StatisticCollector.getInstance(paramBaseActivity).collectPerformance(RIJQQAppInterfaceUtil.d(), "actReadInJoyDDShowPopupMenu", true, 0L, 0L, null, "");
    ArrayList localArrayList = new ArrayList();
    a(ReadInJoyHelper.J(RIJQQAppInterfaceUtil.e()), localArrayList);
    if (localArrayList.size() == 0) {
      a(31, localArrayList);
    }
    PopupMenuDialog.build(paramBaseActivity, localArrayList, new RIJUGCDianDian.1(paramBaseActivity), new RIJUGCDianDian.2(), AIOUtils.b(125.0F, paramBaseActivity.getResources()), false, 2130843888, 2131951651).showAsDropDown(paramView);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localJSONObject.put("releasetype", paramString2);
      localJSONObject.put("tab_source", paramString1);
      localJSONObject.put("kandian_mode_new", VideoReporter.c());
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("secondClassDeliverOperationReport:");
        paramString2.append(paramString1.toString());
        QLog.e("RIJUGCDianDian", 2, paramString2.toString());
      }
      paramString1 = "";
    }
    PublicAccountReportUtils.a(null, "", "0X8008C5D", "0X8008C5D", 0, 0, "", "", "", paramString1, false);
  }
  
  public static boolean a()
  {
    return ReadInJoyHelper.J(RIJQQAppInterfaceUtil.e()) != 0;
  }
  
  public static int b()
  {
    return KandianVideoUploadService.a();
  }
  
  private static void b(Context paramContext)
  {
    c(paramContext);
    StatisticCollector.getInstance(paramContext).collectPerformance(RIJQQAppInterfaceUtil.e().getAccount(), "actReadInJoyDDShowVideoAS", true, 0L, 0L, null, "");
  }
  
  private static void c(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_from_dian_dian", true);
    ReadInJoyCaptureLauncher.getInstance().launchFromNative(paramContext, localBundle);
    ((Activity)paramContext).overridePendingTransition(2130772373, 2130772092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJUGCDianDian
 * JD-Core Version:    0.7.0.1
 */