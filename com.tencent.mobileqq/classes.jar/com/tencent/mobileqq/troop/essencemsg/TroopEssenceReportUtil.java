package com.tencent.mobileqq.troop.essencemsg;

import android.text.TextUtils;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;

public class TroopEssenceReportUtil
{
  private static GroupCatalogBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = GroupCatalogTool.a(BaseApplicationImpl.getApplication()).a(BaseApplicationImpl.getApplication(), paramString);
    } while (paramString == null);
    if ((paramString.jdField_a_of_type_Int > 2) && (paramString.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null)) {
      return a(paramString.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.b);
    }
    return paramString;
  }
  
  public static void a(AppInterface paramAppInterface, View paramView, String paramString)
  {
    if ((paramView == null) || (TextUtils.isEmpty(paramString)) || (paramAppInterface == null)) {
      return;
    }
    VideoReport.setElementId(paramView, "em_msg_label");
    VideoReport.resetElementParams(paramView);
    paramAppInterface = new HashMap();
    paramAppInterface.put("msg_label", "1");
    VideoReport.setElementParams(paramView, paramAppInterface);
    VideoReport.traversePage(paramView);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("msg_type", String.valueOf(paramInt));
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localHashMap.put("action_result", str);
      a(paramQQAppInterface, String.valueOf(paramLong), "click#group_aio_fullscreen#pin_message_send", localHashMap);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("msg_type", String.valueOf(paramInt1));
    if (paramInt2 == 1)
    {
      a(paramQQAppInterface, String.valueOf(paramLong), "click#group_aio#message_more_pin", localHashMap);
      return;
    }
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localHashMap.put("action_result", str);
      a(paramQQAppInterface, String.valueOf(paramLong), "click#group_aio#message_more_pin_cancel", localHashMap);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localHashMap.put("action_result", str);
      a(paramQQAppInterface, String.valueOf(paramLong), "click#group_aio_mulitple_choice#pin_button", localHashMap);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a(paramQQAppInterface, paramString, "expose#group_aio#pin_message_tips", null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("msg_type", String.valueOf(paramInt));
    a(paramQQAppInterface, String.valueOf(paramString), "click#group_aio_mulitple_choice#message", localHashMap);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap == null) || (TextUtils.isEmpty(paramString1))) {
      paramHashMap = new HashMap();
    }
    paramString2 = paramQQAppInterface.getCurrentUin();
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = paramQQAppInterface.b(paramString1);
    paramHashMap.put("group_id", paramString1);
    a(localTroopInfo, paramHashMap);
    paramQQAppInterface.a(paramString1, paramString2, new TroopEssenceReportUtil.1(localTroopInfo, paramHashMap));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "2";; str = "1")
    {
      localHashMap.put("status_tag1", str);
      a(paramQQAppInterface, paramString, "click#group_aio#pin_button", localHashMap);
      return;
    }
  }
  
  private static void a(TroopInfo paramTroopInfo, HashMap<String, String> paramHashMap)
  {
    if (paramTroopInfo == null) {}
    do
    {
      return;
      paramTroopInfo = a(String.valueOf(paramTroopInfo.dwGroupClassExt));
      if (paramTroopInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopEssenceReportUtil", 1, "fillGroupClassExParams: catalogBean == null");
    return;
    if (paramTroopInfo.jdField_a_of_type_Int == 1)
    {
      paramHashMap.put("group_type1", String.valueOf(paramTroopInfo.b));
      return;
    }
    if (paramTroopInfo.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null) {
      paramHashMap.put("group_type1", String.valueOf(paramTroopInfo.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.b));
    }
    paramHashMap.put("group_type2", String.valueOf(paramTroopInfo.b));
  }
  
  private static int b(TroopInfo paramTroopInfo, TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopMemberInfo == null)) {
      return 4;
    }
    if (paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin)) {
      return 1;
    }
    if (paramTroopInfo.isTroopAdmin(paramTroopMemberInfo.memberuin)) {
      return 2;
    }
    return 3;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, long paramLong, int paramInt, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    long l = TroopEssenceUtil.a(paramQQAppInterface, String.valueOf(paramLong));
    if (paramBoolean) {}
    for (paramQQAppInterface = "1";; paramQQAppInterface = "2")
    {
      ReportController.b(null, "dc00898", "", String.valueOf(paramLong), "0X800B727", "0X800B727", 0, 0, String.valueOf(l), String.valueOf(paramInt), paramQQAppInterface, "");
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    long l = TroopEssenceUtil.a(paramQQAppInterface, String.valueOf(paramLong));
    if (paramBoolean) {}
    for (paramQQAppInterface = "1";; paramQQAppInterface = "2")
    {
      ReportController.b(null, "dc00898", "", String.valueOf(paramLong), "0X800B72A", "0X800B72A", 0, 0, String.valueOf(l), "", paramQQAppInterface, "");
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a(paramQQAppInterface, paramString, "click#group_aio#pin_message_tips_pin_list", null);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ReportController.b(null, "dc00898", "", paramString, "0X800B729", "0X800B729", 0, 0, String.valueOf(TroopEssenceUtil.a(paramQQAppInterface, paramString)), String.valueOf(paramInt), "", "");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    long l = TroopEssenceUtil.a(paramQQAppInterface, paramString);
    if (paramBoolean) {}
    for (paramQQAppInterface = "2";; paramQQAppInterface = "1")
    {
      ReportController.b(null, "dc00898", "", paramString, "0X800B72C", "0X800B72C", 0, 0, String.valueOf(l), paramQQAppInterface, "", "");
      return;
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "2";; str = "1")
    {
      localHashMap.put("status_tag1", str);
      a(paramQQAppInterface, String.valueOf(paramLong), "expose#group_aio#pin_button", localHashMap);
      return;
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a(paramQQAppInterface, paramString, "click#group_aio#pin_message_tips_message", null);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    long l = TroopEssenceUtil.a(paramQQAppInterface, String.valueOf(paramLong));
    if (paramBoolean) {}
    for (paramQQAppInterface = "2";; paramQQAppInterface = "1")
    {
      ReportController.b(null, "dc00898", "", String.valueOf(paramLong), "0X800B72B", "0X800B72B", 0, 0, String.valueOf(l), paramQQAppInterface, "", "");
      return;
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a(paramQQAppInterface, paramString, "click#group_aio#pin_message_tail", null);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a(paramQQAppInterface, paramString, "expose#group_aio_fullscreen#pin_button", null);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ReportController.b(null, "dc00898", "", paramString, "0X800B725", "0X800B725", 0, 0, String.valueOf(TroopEssenceUtil.a(paramQQAppInterface, paramString)), "", "", "");
  }
  
  public static void g(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a(paramQQAppInterface, paramString, "click#group_aio_fullscreen#pin_button", null);
  }
  
  public static void h(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ReportController.b(null, "dc00898", "", paramString, "0X800B726", "0X800B726", 0, 0, String.valueOf(TroopEssenceUtil.a(paramQQAppInterface, paramString)), "", "", "");
  }
  
  public static void i(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a(paramQQAppInterface, paramString, "expose#group_aio_mulitple_choice#pin_button", null);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ReportController.b(null, "dc00898", "", paramString, "0X800B728", "0X800B728", 0, 0, String.valueOf(TroopEssenceUtil.a(paramQQAppInterface, paramString)), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil
 * JD-Core Version:    0.7.0.1
 */