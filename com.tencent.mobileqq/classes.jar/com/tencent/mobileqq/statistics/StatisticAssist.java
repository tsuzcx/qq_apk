package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageReportData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class StatisticAssist
{
  private static List<MessageReportData> a;
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = paramString1 + paramString2;
    return paramContext.getSharedPreferences(paramString1 + "statistic", 0).getInt(paramString2, 0);
  }
  
  public static List<MessageReportData> a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = paramQQAppInterface.query(MessageReportData.class, false, null, null, null, null, null, null);
    paramQQAppInterface.close();
    return localList;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = paramString1 + paramString2;
    paramContext = paramContext.getSharedPreferences(paramString1 + "statistic", 0);
    int i = paramContext.getInt(paramString2, 0);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticAssist", 2, paramString2 + ": " + i);
    }
    paramContext.edit().putInt(paramString2, i + 1).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences(paramString + "statistic", 0).edit().clear().commit();
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.drop(MessageReportData.class);
    paramQQAppInterface.close();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    paramString4 = new MessageReportData(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10);
    paramString1 = null;
    if (a == null)
    {
      paramString5 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramString1 = paramString5.query(MessageReportData.class, false, "senderUin=? and recieverUin=?", new String[] { paramString2, paramString3 }, null, null, null, null);
      paramString5.close();
    }
    for (;;)
    {
      try
      {
        if (a != null) {
          break label231;
        }
        if (paramString1 != null)
        {
          a = paramString1;
          break label231;
          if (i >= a.size()) {
            break label225;
          }
          paramString1 = (MessageReportData)a.get(i);
          if (paramString1.equals(paramString4))
          {
            paramString1.msgCount += 1;
            paramString4.msgCount = paramString1.msgCount;
            i = 0;
            if (i != 0)
            {
              a.add(paramString4);
              paramString4.msgCount = 1;
            }
            paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
            paramQQAppInterface.persistOrReplace(paramString4);
            paramQQAppInterface.close();
          }
        }
        else
        {
          a = new ArrayList();
        }
      }
      finally {}
      i += 1;
      continue;
      label225:
      int i = 1;
      continue;
      label231:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticAssist
 * JD-Core Version:    0.7.0.1
 */