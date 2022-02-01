package com.tencent.mobileqq.leba.report;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;

public class LebaDaTong
{
  static LebaDaTong a = new LebaDaTong();
  long b = b();
  IGuardInterface c = new LebaDaTong.1(this);
  
  LebaDaTong()
  {
    GuardManager.sInstance.registerCallBack(this.c);
  }
  
  public static LebaDaTong a()
  {
    return a;
  }
  
  static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "other";
          }
        }
        else {
          return "num_red_dot";
        }
      }
      return "little_red_dot";
    }
    return "";
  }
  
  public static String a(LebaViewItem paramLebaViewItem)
  {
    if (paramLebaViewItem == null) {
      return "default";
    }
    if (paramLebaViewItem.h == 2) {
      return "more";
    }
    if (paramLebaViewItem.h == 1)
    {
      if (paramLebaViewItem.b == null) {
        return "default";
      }
      return paramLebaViewItem.b.getDaTongID();
    }
    return "default";
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString)
  {
    if (paramActivity != null) {
      VideoReport.addToDetectionWhitelist(paramActivity);
    }
    if (paramView == null) {
      return;
    }
    VideoReport.setPageId(paramView, paramString);
    VideoReport.setPageParams(paramView, "qq_session_id", a().c());
    VideoReport.setPageParams(paramView, "qq_mode", d());
    VideoReport.setPageParams(paramView, "SourceID", "");
    paramActivity = new StringBuilder();
    paramActivity.append("set da-tong page param, page-id=");
    paramActivity.append(paramString);
    paramActivity.append(", view=");
    paramActivity.append(paramView.toString());
    paramActivity.append(", session-id=");
    paramActivity.append(a().c());
    paramActivity.append(", qq-mode=");
    paramActivity.append(d());
    QLog.d("Leba.DaTong", 4, paramActivity.toString());
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportExposure, view=");
      localStringBuilder.append(paramView.toString());
      QLog.d("Leba.DaTong", 2, localStringBuilder.toString());
    }
    VideoReport.reportEvent("imp", paramView, null);
  }
  
  public static void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    a(paramView, a(paramInt));
  }
  
  public static void a(View paramView, LebaViewItem paramLebaViewItem)
  {
    b(paramView, a(paramLebaViewItem));
  }
  
  public static void a(View paramView, LebaViewItem paramLebaViewItem, int paramInt)
  {
    a(paramView, a(paramLebaViewItem), paramInt);
  }
  
  public static void a(View paramView, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRedPointTypeToItem，view=");
      localStringBuilder.append(paramView.toString());
      localStringBuilder.append(", type=");
      localStringBuilder.append(paramString);
      QLog.d("Leba.DaTong", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      VideoReport.setElementParam(paramView, "is_red_tips_em", "0");
      VideoReport.setElementParam(paramView, "qq_red_tips_type", "other");
      return;
    }
    VideoReport.setElementParam(paramView, "is_red_tips_em", "1");
    VideoReport.setElementParam(paramView, "qq_red_tips_type", paramString);
  }
  
  public static void a(View paramView, String paramString, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    b(paramView, paramString);
    VideoReport.setElementParam(paramView, "discover_sequence_em", Integer.valueOf(paramInt));
  }
  
  public static void a(View paramView, boolean paramBoolean, String paramString)
  {
    String str;
    if (paramBoolean) {
      str = "em_discover_del_button";
    } else {
      str = "em_discover_add_button";
    }
    VideoReport.setElementId(paramView, str);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementParam(paramView, "discover_feature_name", paramString);
  }
  
  static long b()
  {
    return System.currentTimeMillis();
  }
  
  public static void b(View paramView)
  {
    a(paramView, "friendmomt", 1);
  }
  
  static void b(View paramView, String paramString)
  {
    if (paramView == null) {
      return;
    }
    VideoReport.setElementId(paramView, "em_discover_button");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementParam(paramView, "discover_feature_name", paramString);
    VideoReport.setElementParam(paramView, "is_red_tips_em", "0");
    VideoReport.setElementParam(paramView, "qq_red_tips_type", "other");
    VideoReport.setElementParam(paramView, "discover_sequence_em", Integer.valueOf(1));
  }
  
  public static void c(View paramView)
  {
    a(paramView, "wezone", 2);
  }
  
  public static void c(View paramView, String paramString)
  {
    VideoReport.setElementId(paramView, "em_discover_button");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementParam(paramView, "discover_feature_name", paramString);
  }
  
  public static String d()
  {
    if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
      return "teenager";
    }
    if (SimpleUIUtil.e()) {
      return "simple";
    }
    return "default";
  }
  
  public static void d(View paramView)
  {
    VideoReport.setElementId(paramView, "em_discover_compile_button");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
  }
  
  public String c()
  {
    return String.valueOf(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.report.LebaDaTong
 * JD-Core Version:    0.7.0.1
 */