package com.tencent.mobileqq.vas;

import android.os.Bundle;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class ClubContentJsonTask$1
  extends DownloadListener
{
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject2 = paramDownloadTask.a();
    String str1 = ((Bundle)localObject2).getString("method");
    if (str1 == null) {
      str1 = "other";
    }
    for (;;)
    {
      String str2 = ((Bundle)localObject2).getString("ifromet");
      if (str2 == null) {
        str2 = "null";
      }
      for (;;)
      {
        boolean bool2 = true;
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "Club_jsonDownloadListener key = " + paramDownloadTask.jdField_a_of_type_JavaLangString + ",satatus = " + paramDownloadTask.a() + ",errCode = " + paramDownloadTask.jdField_a_of_type_Int + ",errMsg = " + paramDownloadTask.b);
        }
        Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        Object localObject3;
        boolean bool1;
        if ((localObject1 instanceof QQAppInterface))
        {
          localObject1 = (QQAppInterface)localObject1;
          if ((paramDownloadTask.a() != 3) || (paramDownloadTask.jdField_a_of_type_Int != 0)) {
            break label614;
          }
          localObject3 = ((Bundle)localObject2).getString("version_key");
          if (localObject3 != null) {
            ClubContentJsonTask.a(BaseApplicationImpl.sApplication.getApplicationContext(), (String)localObject3, ((Bundle)localObject2).getInt("version", 0));
          }
          if ((paramDownloadTask.jdField_a_of_type_JavaLangString == null) || (localObject1 == null)) {
            break label541;
          }
          if (!ClubContentJsonTask.c.jdField_a_of_type_JavaLangString.equals(paramDownloadTask.jdField_a_of_type_JavaLangString)) {
            break label384;
          }
          ClubContentJsonTask.c.jdField_a_of_type_OrgJsonJSONObject = null;
          ClubContentJsonTask.c.a(((QQAppInterface)localObject1).getApplication());
          bool1 = bool2;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentJsonTask", 2, "jsonDownloadListener,ret=" + bool1 + ",file.name:" + paramDownloadTask.jdField_a_of_type_JavaLangString + ",method:" + str1 + ",ifromet:" + str2);
          }
          if (localObject1 != null) {}
          try
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("param_jsonName", paramDownloadTask.jdField_a_of_type_JavaLangString);
            ((HashMap)localObject2).put("param_method", str1);
            ((HashMap)localObject2).put("param_from", str2);
            StatisticCollector.getInstance(((QQAppInterface)localObject1).getApplication().getApplicationContext()).collectPerformance(((QQAppInterface)localObject1).getAccount(), "ClubContentJsonLoaded", bool1, 1L, 0L, (HashMap)localObject2, "", false);
            return;
          }
          catch (Exception paramDownloadTask)
          {
            label384:
            label541:
            label562:
            label609:
            label614:
            paramDownloadTask.printStackTrace();
            return;
          }
          localObject1 = null;
          break;
          if (paramDownloadTask.jdField_a_of_type_JavaLangString.equals(ClubContentJsonTask.f.jdField_a_of_type_JavaLangString))
          {
            FunnyPicHelper.a((QQAppInterface)localObject1);
            bool1 = bool2;
          }
          else
          {
            bool1 = bool2;
            if (!paramDownloadTask.jdField_a_of_type_JavaLangString.equals(ClubContentJsonTask.b.jdField_a_of_type_JavaLangString)) {
              if (paramDownloadTask.jdField_a_of_type_JavaLangString.equals(ClubContentJsonTask.h.jdField_a_of_type_JavaLangString))
              {
                ((URLInterceptManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.URL_INTECEPT_MANAGER)).a((QQAppInterface)localObject1);
                bool1 = bool2;
              }
              else if (paramDownloadTask.jdField_a_of_type_JavaLangString.equals(ClubContentJsonTask.d.jdField_a_of_type_JavaLangString))
              {
                ClubContentJsonTask.d.jdField_a_of_type_OrgJsonJSONObject = null;
                ClubContentJsonTask.d.a(((QQAppInterface)localObject1).getApplication());
                bool1 = bool2;
              }
              else
              {
                bool1 = bool2;
                if (paramDownloadTask.jdField_a_of_type_JavaLangString.equals(ClubContentJsonTask.i.jdField_a_of_type_JavaLangString))
                {
                  localObject2 = (FontManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.CHAT_FONT_MANAGER);
                  bool1 = bool2;
                  continue;
                  localObject2 = new StringBuilder().append("jsonDownloadListener, app == null:");
                  if (localObject1 == null)
                  {
                    bool1 = true;
                    localObject2 = ((StringBuilder)localObject2).append(bool1).append(",key == null:");
                    if (paramDownloadTask.jdField_a_of_type_JavaLangString != null) {
                      break label609;
                    }
                  }
                  for (bool1 = true;; bool1 = false)
                  {
                    QLog.e("ClubContentJsonTask", 2, bool1);
                    bool1 = bool2;
                    break;
                    bool1 = false;
                    break label562;
                  }
                  QLog.e("ClubContentJsonTask", 1, "ClubContentJsonTask jsondownfail task.key = " + paramDownloadTask.jdField_a_of_type_JavaLangString);
                  if ((paramDownloadTask.jdField_a_of_type_JavaLangString != null) && (paramDownloadTask.jdField_a_of_type_JavaLangString.equals(ClubContentJsonTask.g.jdField_a_of_type_JavaLangString)) && (localObject1 != null))
                  {
                    localObject3 = (IndividualRedPacketManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
                    localObject2 = "0";
                    if (((IndividualRedPacketManager)localObject3).a()) {
                      localObject2 = "1";
                    }
                    ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X800612B", "0X800612B", 0, 0, (String)localObject2, "0", "", "");
                  }
                  bool1 = false;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask) {}
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ClubContentJsonTask.1
 * JD-Core Version:    0.7.0.1
 */