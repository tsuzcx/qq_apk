package com.tencent.mobileqq.extendfriend.utils;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo.LabelInfo;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo.SchoolInfo;
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
  private static StrangerInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo = null;
  private static ExtendFriendReport jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendReport;
  private static String jdField_a_of_type_JavaLangString;
  private static int jdField_b_of_type_Int = -1;
  private static String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_JavaLangString = null;
  }
  
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
    String str = "";
    if (jdField_b_of_type_Int >= 0) {
      str = String.valueOf(jdField_b_of_type_Int + 1);
    }
    return str;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.jdField_b_of_type_JavaLangString))) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.jdField_b_of_type_JavaLangString;; paramQQAppInterface = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendReport", 0, String.format("getRecomTrace1 strRecomTrace=%s", new Object[] { paramQQAppInterface }));
      }
      return paramQQAppInterface;
    }
  }
  
  public static String a(StrangerInfo paramStrangerInfo)
  {
    StrangerInfo.LabelInfo localLabelInfo = null;
    Object localObject1 = "";
    if (paramStrangerInfo != null) {
      if ((paramStrangerInfo.mSchoolInfos == null) || (paramStrangerInfo.mSchoolInfos.isEmpty())) {
        break label224;
      }
    }
    label224:
    for (localObject1 = (StrangerInfo.SchoolInfo)paramStrangerInfo.mSchoolInfos.get(0);; localObject1 = null)
    {
      long l;
      if (localObject1 != null)
      {
        l = ((StrangerInfo.SchoolInfo)localObject1).a;
        localObject1 = ((StrangerInfo.SchoolInfo)localObject1).jdField_b_of_type_JavaLangString;
      }
      for (String str = String.valueOf(l);; str = null)
      {
        Object localObject2 = localLabelInfo;
        if (paramStrangerInfo.mLabelInfos != null)
        {
          localObject2 = localLabelInfo;
          if (!paramStrangerInfo.mLabelInfos.isEmpty())
          {
            localObject2 = new StringBuilder();
            paramStrangerInfo = paramStrangerInfo.mLabelInfos.iterator();
            int i = 1;
            if (paramStrangerInfo.hasNext())
            {
              localLabelInfo = (StrangerInfo.LabelInfo)paramStrangerInfo.next();
              if (i != 0)
              {
                ((StringBuilder)localObject2).append(localLabelInfo.jdField_a_of_type_JavaLangString);
                i = 0;
              }
              for (;;)
              {
                break;
                ((StringBuilder)localObject2).append(",");
                ((StringBuilder)localObject2).append(localLabelInfo.jdField_a_of_type_JavaLangString);
              }
            }
            localObject2 = ((StringBuilder)localObject2).toString();
          }
        }
        localObject1 = String.format("%s_%s_%s", new Object[] { str, localObject1, localObject2 });
        return localObject1;
        localObject1 = null;
      }
    }
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
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, StrangerInfo paramStrangerInfo)
  {
    jdField_a_of_type_Int = paramInt1;
    jdField_b_of_type_Int = paramInt2;
    jdField_a_of_type_JavaLangString = paramString1;
    jdField_b_of_type_JavaLangString = paramString2;
    jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo = paramStrangerInfo;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("updateRecomTrace strRecomTrace=%s", new Object[] { paramString }));
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null))
    {
      paramQQAppInterface = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.jdField_b_of_type_JavaLangString = paramString;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    ThreadManager.post(new ExtendFriendReport.1(this, paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3), 5, null, false);
  }
  
  public static String b()
  {
    String str = "";
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      str = jdField_a_of_type_JavaLangString;
    }
    return str;
  }
  
  public static void b()
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_JavaLangString = null;
    jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo = null;
  }
  
  public static String c()
  {
    String str = "";
    if (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
      str = jdField_b_of_type_JavaLangString;
    }
    return str;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, "reportEntry");
    }
    a("", "extend_friend_entry", true, 0L, 0L, new HashMap(), "");
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
  
  public void b(int paramInt)
  {
    Object localObject2 = "";
    Object localObject1 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
    if ((localObject1 != null) && (((SosoLbsInfo)localObject1).mLocation != null))
    {
      localObject2 = ((SosoLbsInfo)localObject1).mLocation;
      if (!TextUtils.isEmpty(((SosoLocation)localObject2).city))
      {
        localObject1 = ((SosoLocation)localObject2).city;
        localObject2 = String.format("%s;%s", new Object[] { Double.valueOf(((SosoLocation)localObject2).mLat02), Double.valueOf(((SosoLocation)localObject2).mLon02) });
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A68C", "0X800A68C", paramInt, 0, "", "", (String)localObject1, (String)localObject2);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("frompage", String.valueOf(paramInt));
      ExpandReportUtils.a("expose#chat_tab#view", true, -1L, -1L, (Map)localObject1, true, true);
      return;
      localObject1 = "";
      break;
      localObject1 = "";
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport
 * JD-Core Version:    0.7.0.1
 */