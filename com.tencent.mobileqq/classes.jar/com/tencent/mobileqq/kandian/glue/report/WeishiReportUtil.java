package com.tencent.mobileqq.kandian.glue.report;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.RIJWeiShiLegacyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class WeishiReportUtil
{
  private static long jdField_a_of_type_Long = -1L;
  private static MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  private static long b;
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  public static MessageForStructing a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return RIJWeiShiLegacyUtils.a.a();
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 9) {
      return "Other";
    }
    return "MsgTab";
  }
  
  public static String a(long paramLong)
  {
    return String.valueOf((paramLong - a()) / 1000L);
  }
  
  public static String a(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData != null) {
      return b(paramRecentBaseData.mUnreadFlag);
    }
    return "";
  }
  
  public static String a(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mArticleIds)))
    {
      paramMessageForStructing = paramMessageForStructing.structingMsg.mArticleIds.split("\\|");
      if (paramMessageForStructing.length > 0) {
        return paramMessageForStructing[0];
      }
    }
    return "";
  }
  
  public static void a()
  {
    a(9, "", "", "", "");
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    b = System.currentTimeMillis();
    ReadinjoySPEventReport.ForeBackGround.a(25);
    ThreadManager.executeOnSubThread(new WeishiReportUtil.1(paramInt, paramString1, paramString2, paramString3, paramString4));
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    a(paramInt, paramString1, paramString2, paramString3, paramString4, paramLong, paramString5, true);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new WeishiReportUtil.2(paramInt, paramString1, paramLong, paramString2, paramString3, paramString4));
    if (paramBoolean) {
      ReadinjoySPEventReport.ForeBackGround.a();
    }
  }
  
  public static void a(RecentBaseData paramRecentBaseData, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    MessageForStructing localMessageForStructing = RIJWeiShiLegacyUtils.a.a();
    if (localMessageForStructing != null)
    {
      if (localMessageForStructing.isread) {
        return;
      }
      String str = localMessageForStructing.getExtInfoFromExtStr("weishi_red_pnt_report");
      if ((TextUtils.isEmpty(str)) || (!"1".equals(str)))
      {
        localMessageForStructing.saveExtInfoToExtStr("weishi_red_pnt_report", "1");
        jdField_a_of_type_Long = System.currentTimeMillis();
        ThreadManager.post(new WeishiReportUtil.3(localQQAppInterface, localMessageForStructing, paramRecentBaseData, paramInt), 5, null, false);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString4);
      QLog.d("WeishiReportUtil", 2, localStringBuilder.toString());
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc01160", "", "", paramString3, paramString3, 0, 0, "", paramString1, paramString2, paramString4, false);
  }
  
  public static boolean a(MessageForStructing paramMessageForStructing)
  {
    return (paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null);
  }
  
  public static MessageForStructing b()
  {
    MessageForStructing localMessageForStructing = jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
    jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
    return localMessageForStructing;
  }
  
  public static String b(int paramInt)
  {
    if (paramInt == 1) {
      return "1";
    }
    if (paramInt == 2) {
      return "0";
    }
    return "";
  }
  
  public static String b(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mStrategyIds))) {
      return paramMessageForStructing.structingMsg.mStrategyIds;
    }
    return "";
  }
  
  public static void b()
  {
    a(9, "", "", "", "", b, "");
  }
  
  public static String c(int paramInt)
  {
    if (paramInt != 9) {
      return "1";
    }
    return "0";
  }
  
  public static String c(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mAlgorithmIds))) {
      return paramMessageForStructing.structingMsg.mAlgorithmIds;
    }
    return "";
  }
  
  public static void c()
  {
    String str = d(a());
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("FolderStatus");
    localAttributeList.att_value.set(str);
    localArrayList.add(localAttributeList);
    ReadinjoyReportUtils.a(27, localArrayList);
  }
  
  public static String d(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
    {
      if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.reportEventFolderStatusValue)) {
        return paramMessageForStructing.structingMsg.reportEventFolderStatusValue;
      }
      return "2";
    }
    return "1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.WeishiReportUtil
 * JD-Core Version:    0.7.0.1
 */