package com.tencent.mobileqq.mutualmark;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MutualMarkBusinessLogicHelper
{
  private static boolean a;
  
  private static List<MessageRecord> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (a(localMessageRecord)) {
        localArrayList.add(localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt)
  {
    if (paramMessageForUniteGrayTip != null)
    {
      String str2 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
      String str1 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("sub_level");
      String str3 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
      String str4 = paramMessageForUniteGrayTip.frienduin;
      if (!TextUtils.isEmpty(str2))
      {
        long l1 = MutualMarkUtils.b(str2);
        long l2 = MutualMarkUtils.a(str2);
        if ((MutualMarkUtils.b(l1)) && (l2 >= 0L))
        {
          String str5 = MutualMarkUtils.a(l1, l2);
          int i = (int)(l1 * 10L + l2);
          paramMessageForUniteGrayTip = str1;
          if (TextUtils.isEmpty(str1)) {
            paramMessageForUniteGrayTip = "0";
          }
          ReportController.b(paramQQAppInterface, "dc00898", "", str4, "0X800A7E4", str5, i, 0, paramMessageForUniteGrayTip, "", "", "");
        }
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("reportMutualMarkGrayTipExposure id:");
        paramQQAppInterface.append(str2);
        paramQQAppInterface.append(" willDowngradeSoon:");
        paramQQAppInterface.append(str3);
        paramQQAppInterface.append(" grayID:");
        paramQQAppInterface.append(paramInt);
        QLog.i("MutualMarkBusinessLogicHelper", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt, String paramString)
  {
    if (paramMessageForUniteGrayTip != null)
    {
      paramQQAppInterface = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
      paramMessageForUniteGrayTip.getExtInfoFromExtStr("sub_level");
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportMutualMarkGrayTipClickWebLink id:");
        localStringBuilder.append(paramQQAppInterface);
        localStringBuilder.append(" willDowngradeSoon:");
        localStringBuilder.append(paramMessageForUniteGrayTip);
        localStringBuilder.append(" url:");
        localStringBuilder.append(paramString);
        QLog.i("MutualMarkBusinessLogicHelper", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (a) {
      return;
    }
    paramQQAppInterface = a(paramQQAppInterface.getMessageFacade().h(paramString, paramInt));
    if (!paramQQAppInterface.isEmpty())
    {
      paramQQAppInterface = b(paramQQAppInterface);
      paramString = new RuntimeException(paramQQAppInterface);
      CaughtExceptionReport.a(paramString, paramQQAppInterface);
      QLog.e("MutualMarkBusinessLogicHelper", 1, paramString, new Object[] { paramQQAppInterface });
      a = true;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo)
  {
    if (paramMutualMarkForDisplayInfo != null)
    {
      Object localObject = MutualMarkUtils.a(paramMutualMarkForDisplayInfo.a, paramMutualMarkForDisplayInfo.b);
      int i = (int)(paramMutualMarkForDisplayInfo.a * 10L + paramMutualMarkForDisplayInfo.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramMutualMarkForDisplayInfo.i);
      ReportController.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E3", (String)localObject, i, 0, localStringBuilder.toString(), "", "", "");
      if ((int)paramMutualMarkForDisplayInfo.a == 17)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramMutualMarkForDisplayInfo.i);
        ReportController.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7A1", "0X800A7A1", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
      }
    }
    VipUtils.a(paramString, paramMutualMarkForDisplayInfo, paramQQAppInterface, "C2C_click");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8007602", "0X8007602", 0, 0, "", "", "", "");
    ReportController.b(null, "dc00898", "", "", "0X800A1FA", "0X800A1FA", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo1, MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo2)
  {
    Object localObject;
    int i;
    if (paramMutualMarkForDisplayInfo1 != null)
    {
      localObject = MutualMarkUtils.a(paramMutualMarkForDisplayInfo1.a, paramMutualMarkForDisplayInfo1.b);
      i = (int)(paramMutualMarkForDisplayInfo1.a * 10L + paramMutualMarkForDisplayInfo1.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramMutualMarkForDisplayInfo1.i);
      ReportController.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", (String)localObject, i, 0, localStringBuilder.toString(), "", "", "");
    }
    if (paramMutualMarkForDisplayInfo2 != null)
    {
      paramMutualMarkForDisplayInfo1 = MutualMarkUtils.a(paramMutualMarkForDisplayInfo2.a, paramMutualMarkForDisplayInfo2.b);
      i = (int)(paramMutualMarkForDisplayInfo2.a * 10L + paramMutualMarkForDisplayInfo2.b);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramMutualMarkForDisplayInfo2.i);
      ReportController.b(paramQQAppInterface, "dc00898", "", paramString, "0X800A7E2", paramMutualMarkForDisplayInfo1, i, 0, ((StringBuilder)localObject).toString(), "", "", "");
    }
    ReportController.b(null, "dc00898", "", "", "0X800A1F9", "0X800A1F9", 0, 0, "", "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return false;
  }
  
  private static boolean a(MessageRecord paramMessageRecord)
  {
    if (!paramMessageRecord.isSendFromLocal()) {
      return false;
    }
    Date localDate = new Date();
    localDate.setTime(paramMessageRecord.time * 1000L);
    int i = localDate.getDate();
    localDate.setTime(NetConnInfoCenter.getServerTimeMillis());
    return localDate.getDate() - i == 1;
  }
  
  @NonNull
  private static String b(List<MessageRecord> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      localStringBuilder.append("[");
      localStringBuilder.append(i);
      localStringBuilder.append("] ");
      localStringBuilder.append(localMessageRecord.toString());
      localStringBuilder.append("\n");
      localStringBuilder.append(localMessageRecord.getExtInfoFromExtStr("SendMessageError"));
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void b(QQAppInterface paramQQAppInterface) {}
  
  public static void b(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt)
  {
    if (paramMessageForUniteGrayTip != null)
    {
      String str2 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_id");
      String str1 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("sub_level");
      String str3 = paramMessageForUniteGrayTip.getExtInfoFromExtStr("mutualmark_WillDowngradeSoon");
      String str4 = paramMessageForUniteGrayTip.frienduin;
      if (!TextUtils.isEmpty(str2))
      {
        long l1 = MutualMarkUtils.b(str2);
        long l2 = MutualMarkUtils.a(str2);
        if ((MutualMarkUtils.b(l1)) && (l2 >= 0L))
        {
          String str5 = MutualMarkUtils.a(l1, l2);
          int i = (int)(l1 * 10L + l2);
          paramMessageForUniteGrayTip = str1;
          if (TextUtils.isEmpty(str1)) {
            paramMessageForUniteGrayTip = "0";
          }
          ReportController.b(paramQQAppInterface, "dc00898", "", str4, "0X800A7E5", str5, i, 0, paramMessageForUniteGrayTip, "", "", "");
        }
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("reportMutualMarkGrayTipClick id:");
        paramQQAppInterface.append(str2);
        paramQQAppInterface.append(" willDowngradeSoon:");
        paramQQAppInterface.append(str3);
        paramQQAppInterface.append(" grayID:");
        paramQQAppInterface.append(paramInt);
        QLog.i("MutualMarkBusinessLogicHelper", 2, paramQQAppInterface.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkBusinessLogicHelper
 * JD-Core Version:    0.7.0.1
 */