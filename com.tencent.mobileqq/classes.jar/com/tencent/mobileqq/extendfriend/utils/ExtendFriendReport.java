package com.tencent.mobileqq.extendfriend.utils;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo.LabelInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo.SchoolInfo;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExtendFriendReport
{
  private static int jdField_a_of_type_Int = -1;
  private static ExtendFriendReport jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendReport;
  private static StrangerInfo jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo;
  private static String jdField_a_of_type_JavaLangString;
  private static int jdField_b_of_type_Int = -1;
  private static String jdField_b_of_type_JavaLangString;
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static ExtendFriendReport a()
  {
    if (jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendReport == null) {
      jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendReport = new ExtendFriendReport();
    }
    return jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendReport;
  }
  
  public static String a()
  {
    int i = jdField_b_of_type_Int;
    if (i >= 0) {
      return String.valueOf(i + 1);
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.a())))
      {
        paramQQAppInterface = paramQQAppInterface.a();
        break label44;
      }
    }
    paramQQAppInterface = "";
    label44:
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("getRecomTrace1 strRecomTrace=%s", new Object[] { paramQQAppInterface }));
    }
    return paramQQAppInterface;
  }
  
  public static String a(StrangerInfo paramStrangerInfo)
  {
    if (paramStrangerInfo != null)
    {
      Object localObject1 = paramStrangerInfo.mSchoolInfos;
      StrangerInfo.LabelInfo localLabelInfo = null;
      if ((localObject1 != null) && (!paramStrangerInfo.mSchoolInfos.isEmpty())) {
        localObject1 = (StrangerInfo.SchoolInfo)paramStrangerInfo.mSchoolInfos.get(0);
      } else {
        localObject1 = null;
      }
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = String.valueOf(((StrangerInfo.SchoolInfo)localObject1).a);
        localObject1 = ((StrangerInfo.SchoolInfo)localObject1).jdField_b_of_type_JavaLangString;
      }
      else
      {
        localObject1 = null;
        localObject2 = localObject1;
      }
      Object localObject3 = localLabelInfo;
      if (paramStrangerInfo.mLabelInfos != null)
      {
        localObject3 = localLabelInfo;
        if (!paramStrangerInfo.mLabelInfos.isEmpty())
        {
          localObject3 = new StringBuilder();
          paramStrangerInfo = paramStrangerInfo.mLabelInfos.iterator();
          int i = 1;
          while (paramStrangerInfo.hasNext())
          {
            localLabelInfo = (StrangerInfo.LabelInfo)paramStrangerInfo.next();
            if (i != 0)
            {
              ((StringBuilder)localObject3).append(localLabelInfo.jdField_a_of_type_JavaLangString);
              i = 0;
            }
            else
            {
              ((StringBuilder)localObject3).append(",");
              ((StringBuilder)localObject3).append(localLabelInfo.jdField_a_of_type_JavaLangString);
            }
          }
          localObject3 = ((StringBuilder)localObject3).toString();
        }
      }
      return String.format("%s_%s_%s", new Object[] { localObject2, localObject1, localObject3 });
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("getRecomTrace2 strRecomTrace=%s", new Object[] { paramString }));
    }
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return "";
  }
  
  public static void a()
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_JavaLangString = null;
    jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo = null;
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, StrangerInfo paramStrangerInfo)
  {
    jdField_a_of_type_Int = paramInt1;
    jdField_b_of_type_Int = paramInt2;
    jdField_a_of_type_JavaLangString = paramString1;
    jdField_b_of_type_JavaLangString = paramString2;
    jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo = paramStrangerInfo;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("updateRecomTrace strRecomTrace=%s", new Object[] { paramString }));
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = (IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramString);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    ThreadManager.post(new ExtendFriendReport.1(this, paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3), 5, null, false);
  }
  
  public static String b()
  {
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      return jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public static String c()
  {
    if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
      return jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportEntryDuration duration=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    a("", "extend_friend_entry_duration", true, paramInt, 0L, localHashMap, "");
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ReportController.a(null, "dc00898", "", paramString1, "0X800AD9A", "0X800AD9A", paramInt, 0, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportPreDownload success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_pre_download", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, "reportEntry");
    }
    a("", "extend_friend_entry", true, 0L, 0L, new HashMap(), "");
  }
  
  public void b(int paramInt)
  {
    Object localObject2 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
    Object localObject1 = "";
    if ((localObject2 != null) && (((SosoLbsInfo)localObject2).mLocation != null))
    {
      localObject2 = ((SosoLbsInfo)localObject2).mLocation;
      if (!TextUtils.isEmpty(((SosoLocation)localObject2).city)) {
        localObject1 = ((SosoLocation)localObject2).city;
      }
      localObject2 = String.format("%s;%s", new Object[] { Double.valueOf(((SosoLocation)localObject2).mLat02), Double.valueOf(((SosoLocation)localObject2).mLon02) });
    }
    else
    {
      localObject1 = "";
      localObject2 = localObject1;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A68C", "0X800A68C", paramInt, 0, "", "", (String)localObject1, (String)localObject2);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("frompage", String.valueOf(paramInt));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#chat_tab#view", true, -1L, -1L, (Map)localObject1, true, true);
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportResUnzip success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_res_unzip", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void c(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportFeedReq success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_feed_req", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void d(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportVoiceUploadReq success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_voice_upload_req", paramBoolean, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport
 * JD-Core Version:    0.7.0.1
 */