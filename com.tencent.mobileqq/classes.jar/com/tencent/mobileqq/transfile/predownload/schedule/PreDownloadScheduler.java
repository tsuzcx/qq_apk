package com.tencent.mobileqq.transfile.predownload.schedule;

import aixl;
import aixm;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import mqq.manager.Manager;

public class PreDownloadScheduler
  implements Handler.Callback, Manager
{
  private double jdField_a_of_type_Double = 0.0D;
  private long jdField_a_of_type_Long;
  private aixm jdField_a_of_type_Aixm = new aixm(null);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PreDownloadItem jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem;
  private FPSCalculator.GetFPSListener jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator$GetFPSListener = new aixl(this);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private boolean jdField_a_of_type_Boolean;
  private double jdField_b_of_type_Double = 0.0D;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList(10);
  private boolean jdField_b_of_type_Boolean;
  private double jdField_c_of_type_Double = 30.0D;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private double jdField_d_of_type_Double = 50.0D;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long = 6L;
  private boolean jdField_g_of_type_Boolean = true;
  private boolean h;
  
  public PreDownloadScheduler(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
  }
  
  private int a()
  {
    int i = 0;
    if (BaseApplicationImpl.isFirstLaunchNew) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreDownloadScheduler", 2, " getStartUpCondition  condition = " + i);
      }
      return i;
      if (BaseApplicationImpl.isCurrentVersionFirstLaunch) {
        i = 2;
      }
    }
  }
  
  public static String a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "department should not be empty");
      }
      paramString = null;
      return paramString;
    }
    String str3 = (String)PreDownloadConstants.b.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(str3))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
      }
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/pddata/";
        File localFile = new File(str1);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        str1 = str1 + paramString + "/" + str3;
        paramString = str1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("PreDownloadScheduler", 1, "[getPreDownloadPath] path = " + str1);
        return str1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PreDownloadScheduler", 1, "Exception:", localException);
        }
        str2 = "/sdcard/tencent/MobileQQ/pddata/";
        continue;
      }
      String str2 = BaseApplicationImpl.getContext().getFilesDir() + "/pddata/";
    }
  }
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    switch (NetworkUtil.a(paramQQAppInterface.getApp()))
    {
    default: 
      return "unknown";
    case 0: 
      return "none";
    case 1: 
      return "Wi-Fi";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "5G";
  }
  
  private void a(double paramDouble1, double paramDouble2, String paramString, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("downloadUrl", paramString);
    localHashMap.put("downloadSize", String.valueOf(paramLong));
    localHashMap.put("CPU", String.valueOf(paramDouble2));
    localHashMap.put("FPS", String.valueOf(paramDouble1));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[report puse info]:");
      localStringBuilder.append(", ").append("downloadUrl").append("=").append(paramString);
      localStringBuilder.append(", ").append("downloadSize").append("=").append(String.valueOf(paramLong));
      localStringBuilder.append(", ").append("CPU").append("=").append(String.valueOf(paramDouble2));
      localStringBuilder.append(", ").append("FPS").append("=").append(String.valueOf(paramDouble1));
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
    StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "PreDownloadReportPause", true, 0L, 0L, localHashMap, null);
  }
  
  private void a(PreDownloadItem paramPreDownloadItem)
  {
    int i = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    if ((i <= 1) || (i >= paramPreDownloadItem.jdField_b_of_type_Int))
    {
      paramPreDownloadItem.jdField_g_of_type_Int = a();
      paramPreDownloadItem.jdField_b_of_type_Long = System.currentTimeMillis();
      paramPreDownloadItem.jdField_g_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramPreDownloadItem.jdField_e_of_type_Int = 1;
      paramPreDownloadItem.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadAbsPreDownloadTask.b();
      this.jdField_b_of_type_JavaUtilArrayList.add(paramPreDownloadItem);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("[start downloading direct without contrl] begin task :");
        localStringBuilder.append(",businessID=").append(paramPreDownloadItem.jdField_a_of_type_Int);
        localStringBuilder.append(",businessName=").append(paramPreDownloadItem.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(",downloadUrl=").append(paramPreDownloadItem.jdField_e_of_type_JavaLangString);
        localStringBuilder.append(",fileKey=").append(paramPreDownloadItem.jdField_d_of_type_JavaLangString);
        QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
      }
      b(paramPreDownloadItem);
    }
  }
  
  private void b(PreDownloadItem paramPreDownloadItem)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    HashMap localHashMap = new HashMap(20);
    localHashMap.put("businessID", String.valueOf(paramPreDownloadItem.jdField_a_of_type_Int));
    localHashMap.put("businessName", paramPreDownloadItem.jdField_a_of_type_JavaLangString);
    localHashMap.put("businessEngName", paramPreDownloadItem.jdField_b_of_type_JavaLangString);
    localHashMap.put("department", paramPreDownloadItem.jdField_c_of_type_JavaLangString);
    localHashMap.put("fileKey", paramPreDownloadItem.jdField_d_of_type_JavaLangString);
    localHashMap.put("downloadUrl", paramPreDownloadItem.jdField_e_of_type_JavaLangString);
    localHashMap.put("filePath", paramPreDownloadItem.jdField_f_of_type_JavaLangString);
    localHashMap.put("reqTime", String.valueOf(paramPreDownloadItem.jdField_a_of_type_Long));
    localHashMap.put("reqNetWork", String.valueOf(paramPreDownloadItem.jdField_b_of_type_Int));
    localHashMap.put("downNetWork", String.valueOf(paramPreDownloadItem.jdField_g_of_type_JavaLangString));
    localHashMap.put("startTime", String.valueOf(paramPreDownloadItem.jdField_b_of_type_Long));
    localHashMap.put("downloadTime", String.valueOf(paramPreDownloadItem.jdField_c_of_type_Long));
    localHashMap.put("downloadSize", String.valueOf(paramPreDownloadItem.jdField_d_of_type_Long));
    localHashMap.put("businessPriority", String.valueOf(paramPreDownloadItem.jdField_c_of_type_Int));
    localHashMap.put("innerPriority", String.valueOf(paramPreDownloadItem.jdField_d_of_type_Int));
    localHashMap.put("state", String.valueOf(paramPreDownloadItem.jdField_e_of_type_Int));
    localHashMap.put("reqCondition", String.valueOf(paramPreDownloadItem.jdField_f_of_type_Int));
    localHashMap.put("startCondition", String.valueOf(paramPreDownloadItem.jdField_g_of_type_Int));
    localHashMap.put("saveOnSD", String.valueOf(paramPreDownloadItem.jdField_a_of_type_Boolean));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[report item]:");
      localStringBuilder.append(", ").append("businessID").append("=").append(paramPreDownloadItem.jdField_a_of_type_Int);
      localStringBuilder.append(", ").append("businessName").append("=").append(paramPreDownloadItem.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", ").append("businessEngName").append("=").append(paramPreDownloadItem.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(", ").append("department").append("=").append(paramPreDownloadItem.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(", ").append("fileKey").append("=").append(paramPreDownloadItem.jdField_d_of_type_JavaLangString);
      localStringBuilder.append(", ").append("downloadUrl").append("=").append(paramPreDownloadItem.jdField_e_of_type_JavaLangString);
      localStringBuilder.append(", ").append("filePath").append("=").append(paramPreDownloadItem.jdField_f_of_type_JavaLangString);
      localStringBuilder.append(", ").append("reqTime").append("=").append(String.valueOf(paramPreDownloadItem.jdField_a_of_type_Long));
      localStringBuilder.append(", ").append("reqNetWork").append("=").append(String.valueOf(paramPreDownloadItem.jdField_b_of_type_Int));
      localStringBuilder.append(", ").append("downNetWork").append("=").append(String.valueOf(paramPreDownloadItem.jdField_g_of_type_JavaLangString));
      localStringBuilder.append(", ").append("startTime").append("=").append(String.valueOf(paramPreDownloadItem.jdField_b_of_type_Long));
      localStringBuilder.append(", ").append("downloadTime").append("=").append(String.valueOf(paramPreDownloadItem.jdField_c_of_type_Long));
      localStringBuilder.append(", ").append("downloadSize").append("=").append(String.valueOf(paramPreDownloadItem.jdField_d_of_type_Long));
      localStringBuilder.append(", ").append("businessPriority").append("=").append(String.valueOf(paramPreDownloadItem.jdField_c_of_type_Int));
      localStringBuilder.append(", ").append("innerPriority").append("=").append(String.valueOf(paramPreDownloadItem.jdField_d_of_type_Int));
      localStringBuilder.append(", ").append("state").append("=").append(String.valueOf(paramPreDownloadItem.jdField_e_of_type_Int));
      localStringBuilder.append(", ").append("reqCondition").append("=").append(String.valueOf(paramPreDownloadItem.jdField_f_of_type_Int));
      localStringBuilder.append(", ").append("startCondition").append("=").append(String.valueOf(paramPreDownloadItem.jdField_g_of_type_Int));
      localStringBuilder.append(", ").append("saveOnSD").append("=").append(String.valueOf(paramPreDownloadItem.jdField_a_of_type_Boolean));
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
    StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "PreDownloadReport", true, 0L, 0L, localHashMap, null);
  }
  
  private void d()
  {
    int j = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem != null) && (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_b_of_type_Long) >= 60000L)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem = null;
    }
    int k;
    int m;
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem == null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Aixm);
      k = a();
      m = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      if (m != 0) {
        break label108;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreDownloadScheduler", 2, " [no network] donot start any task! ");
      }
    }
    return;
    label108:
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    int i = j;
    for (;;)
    {
      Object localObject4;
      try
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder("pending task id:");
          i = 0;
          if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            localObject4 = (PreDownloadItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (localObject4 == null) {
              break label789;
            }
            ((StringBuilder)localObject2).append(((PreDownloadItem)localObject4).jdField_a_of_type_Int).append(",");
            break label789;
          }
          QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject2).toString());
          i = j;
        }
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label577;
        }
        Object localObject2 = (PreDownloadItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localObject2 != null) && (((PreDownloadItem)localObject2).jdField_f_of_type_Int == 1) && (k == 1))
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder("[forbidden on first start] remove task :\n");
            ((StringBuilder)localObject4).append(",businessID=").append(((PreDownloadItem)localObject2).jdField_a_of_type_Int);
            ((StringBuilder)localObject4).append(",businessName=").append(((PreDownloadItem)localObject2).jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject4).append(",downloadUrl=").append(((PreDownloadItem)localObject2).jdField_e_of_type_JavaLangString);
            ((StringBuilder)localObject4).append(",reqCondition=").append(((PreDownloadItem)localObject2).jdField_f_of_type_Int);
            QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject4).toString());
          }
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
          return;
        }
      }
      finally {}
      if ((localObject3 != null) && (((localObject3.jdField_f_of_type_Int == 2) && (!this.jdField_b_of_type_Boolean)) || ((m > 1) && (m < localObject3.jdField_b_of_type_Int)) || ((localObject3.jdField_f_of_type_Int == 3) && (!this.jdField_c_of_type_Boolean))))
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder("[network or reqconditon not fit] donot download task :\n");
          ((StringBuilder)localObject4).append(",businessID=").append(localObject3.jdField_a_of_type_Int);
          ((StringBuilder)localObject4).append(",businessName=").append(localObject3.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject4).append(",downloadUrl=").append(localObject3.jdField_e_of_type_JavaLangString);
          ((StringBuilder)localObject4).append(",reqCondition=").append(localObject3.jdField_f_of_type_Int);
          ((StringBuilder)localObject4).append(",current appBackground=").append(this.jdField_b_of_type_Boolean);
          ((StringBuilder)localObject4).append(",reqNetWork=").append(localObject3.jdField_b_of_type_Int);
          ((StringBuilder)localObject4).append(",current netWorkType=").append(m);
          QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject4).toString());
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem = ((PreDownloadItem)this.jdField_a_of_type_JavaUtilArrayList.remove(i));
        label577:
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadAbsPreDownloadTask != null))
        {
          if (this.jdField_e_of_type_Long == 0L) {
            this.jdField_e_of_type_Long = System.currentTimeMillis();
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_g_of_type_Int = k;
          this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_b_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_g_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_e_of_type_Int = 1;
          this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadAbsPreDownloadTask.b();
          this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder("[start downloading] begin task :");
            localStringBuilder.append(",businessID=").append(this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_a_of_type_Int);
            localStringBuilder.append(",businessName=").append(this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_a_of_type_JavaLangString);
            localStringBuilder.append(",downloadUrl=").append(this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_e_of_type_JavaLangString);
            localStringBuilder.append(",fileKey=").append(this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_d_of_type_JavaLangString);
            QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
          }
        }
        for (;;)
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem = null;
        }
        label789:
        i += 1;
        continue;
      }
      i += 1;
    }
  }
  
  private void e()
  {
    if (this.h)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)
      {
        FPSCalculator.a().b(this.jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator$GetFPSListener);
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadScheduler", 2, "[fps callback disabled],there is no pending task!");
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        FPSCalculator.a().a(this.jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator$GetFPSListener);
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadScheduler", 2, "[fps callback enabled],there is pending tasks!");
        }
      }
    }
  }
  
  public AbsPreDownloadTask a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ cancelPreDownload ] downloadUrl = " + paramString);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject3 = this.jdField_a_of_type_JavaLangObject;
      i = 0;
      localObject1 = localObject2;
    }
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject2 = (PreDownloadItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (paramString.equals(((PreDownloadItem)localObject2).jdField_e_of_type_JavaLangString)) {
            localObject1 = ((PreDownloadItem)localObject2).jdField_a_of_type_ComTencentMobileqqTransfilePredownloadAbsPreDownloadTask;
          }
        }
        else
        {
          localObject2 = new Message();
          ((Message)localObject2).what = 1003;
          ((Message)localObject2).obj = paramString;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          return localObject1;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void a()
  {
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ startPreDownload ] enable time = " + this.jdField_f_of_type_Long);
    }
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 10000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_JavaLangString = (BaseApplicationImpl.getContext().getFilesDir() + "/pddata/");
    paramQQAppInterface = new File(this.jdField_b_of_type_JavaLangString);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    this.jdField_c_of_type_JavaLangString = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/pddata/");
    paramQQAppInterface = new File(this.jdField_c_of_type_JavaLangString);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    this.jdField_g_of_type_Long = 6L;
    this.jdField_c_of_type_Double = 30.0D;
    this.jdField_d_of_type_Double = 50.0D;
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences("sp_pre_downlaod", 0);
    boolean bool2 = paramQQAppInterface.getBoolean("sp_key_pre_sample_mark", false);
    QLog.e("PreDownloadScheduler", 1, " pre download bSampledLastTime = " + bool2);
    double d1 = Math.random();
    boolean bool1;
    if (9.999999747378752E-006D >= d1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      QLog.e("PreDownloadScheduler", 1, " pre download random = " + d1);
      if (!bool2) {
        break label318;
      }
      this.jdField_a_of_type_Boolean = true;
      paramQQAppInterface.edit().putBoolean("sp_key_pre_sample_mark", false).commit();
      QLog.e("PreDownloadScheduler", 1, " pre download last time sampled, also sampled this time");
    }
    for (;;)
    {
      QLog.e("PreDownloadScheduler", 1, " pre download set mNeedReport = " + this.jdField_a_of_type_Boolean);
      return;
      bool1 = false;
      break;
      label318:
      paramQQAppInterface.edit().putBoolean("sp_key_pre_sample_mark", this.jdField_a_of_type_Boolean).commit();
    }
  }
  
  public void a(AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    Message localMessage = new Message();
    localMessage.what = 1006;
    localMessage.obj = paramAbsPreDownloadTask;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ preDownloadSuccess ] downloadUrl = " + paramString + ",size = " + paramLong);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_Long = paramLong;
    Message localMessage = new Message();
    localMessage.what = 1004;
    localMessage.obj = paramString;
    localMessage.arg1 = ((int)paramLong);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if ((this.jdField_g_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreDownloadScheduler", 2, "[System busy] dowload not ready!");
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (Math.abs(System.currentTimeMillis() - this.jdField_f_of_type_Long) >= 60000L) && (this.jdField_e_of_type_Long == 0L))
      {
        this.jdField_g_of_type_Long -= 2L;
        this.jdField_d_of_type_Double += 10.0D;
        this.jdField_c_of_type_Double -= 10.0D;
        this.jdField_e_of_type_Boolean = true;
        this.jdField_f_of_type_Boolean = true;
        this.jdField_d_of_type_Boolean = true;
        QLog.d("PreDownloadScheduler", 2, "[System busy] for 60 seconds after pull msg, set download enable");
        QLog.d("PreDownloadScheduler", 2, "mCPUThreshold = " + this.jdField_d_of_type_Double + ",mFPSThreshold=" + this.jdField_c_of_type_Double);
      }
    }
    else
    {
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    if ((paramInt1 == 0) || (TextUtils.isEmpty(paramString3)) || (paramAbsPreDownloadTask == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "requestPreDownload param error! busindessID=0 or downloadUrl is empty or task is empty\n");
      }
      return false;
    }
    String str1 = (String)PreDownloadConstants.a.get(Integer.valueOf(paramInt1));
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define name in PreDownloadConstants.BUSINESS_NAME for business");
      }
      return false;
    }
    String str2 = (String)PreDownloadConstants.b.get(Integer.valueOf(paramInt1));
    if (TextUtils.isEmpty(str2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
      }
      return false;
    }
    Object localObject = (Integer)PreDownloadConstants.c.get(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define priority in PreDownloadConstants.BUSINESS_PRIORITY for business");
      }
      return false;
    }
    int i = ((Integer)localObject).intValue();
    if ((i < 0) || (i > 4))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, " requestPreDownload param priority error,priority value should be in[0,1,2,3,4]!");
      }
      return false;
    }
    localObject = new PreDownloadItem();
    ((PreDownloadItem)localObject).jdField_a_of_type_Int = paramInt1;
    ((PreDownloadItem)localObject).jdField_a_of_type_JavaLangString = str1;
    ((PreDownloadItem)localObject).jdField_b_of_type_JavaLangString = str2;
    ((PreDownloadItem)localObject).jdField_c_of_type_JavaLangString = paramString1;
    ((PreDownloadItem)localObject).jdField_d_of_type_JavaLangString = paramString2;
    ((PreDownloadItem)localObject).jdField_e_of_type_JavaLangString = paramString3;
    ((PreDownloadItem)localObject).jdField_b_of_type_Int = paramInt3;
    ((PreDownloadItem)localObject).jdField_d_of_type_Int = paramInt2;
    ((PreDownloadItem)localObject).jdField_f_of_type_JavaLangString = paramString4;
    ((PreDownloadItem)localObject).jdField_e_of_type_Int = 0;
    ((PreDownloadItem)localObject).jdField_a_of_type_Long = System.currentTimeMillis();
    ((PreDownloadItem)localObject).jdField_c_of_type_Int = i;
    ((PreDownloadItem)localObject).jdField_f_of_type_Int = paramInt4;
    ((PreDownloadItem)localObject).jdField_a_of_type_Boolean = paramBoolean;
    ((PreDownloadItem)localObject).jdField_a_of_type_ComTencentMobileqqTransfilePredownloadAbsPreDownloadTask = paramAbsPreDownloadTask;
    paramString1 = new Message();
    paramString1.what = 1002;
    paramString1.obj = localObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ requestPreDownload ]  downloadUrl = " + paramString3);
    }
    return a();
  }
  
  public void b()
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ onAppForground ] mAppBackground = " + this.jdField_b_of_type_Boolean);
    }
    Message localMessage = new Message();
    localMessage.what = 1008;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[setEnable] enable = " + this.jdField_g_of_type_Boolean);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ onAppBackground ] mAppBackground = " + this.jdField_b_of_type_Boolean);
    }
    Message localMessage = new Message();
    localMessage.what = 1009;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = 0;
    int i = 0;
    int j = 0;
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1001: 
      this.jdField_d_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "startPreDownload mBeReady set true, all pre download will start ");
      }
      paramMessage = BaseApplicationImpl.getApplication().getSharedPreferences("sp_pre_downlaod", 0);
      i = paramMessage.getInt("sp_key_pre_download_version", 0);
      if (i != 0)
      {
        localObject1 = PreDownloadController.a(i, 0);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          i = 0;
          while (i < ((ArrayList)localObject1).size())
          {
            if (QLog.isColorLevel()) {
              QLog.e("PreDownloadScheduler", 1, "[onVersionUpdate PreDownloadScheduler]  delete file: " + (String)((ArrayList)localObject1).get(i));
            }
            FileUtils.a((String)((ArrayList)localObject1).get(i), false);
            i += 1;
          }
        }
      }
      paramMessage.edit().putInt("sp_key_pre_download_version", 0).commit();
      d();
      e();
      return true;
    case 1002: 
      localObject1 = (PreDownloadItem)paramMessage.obj;
      if (this.jdField_g_of_type_Boolean) {
        paramMessage = this.jdField_a_of_type_JavaLangObject;
      }
      break;
    }
    label878:
    for (i = 0;; i = 0)
    {
      for (;;)
      {
        try
        {
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label878;
          }
          PreDownloadItem localPreDownloadItem2 = (PreDownloadItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (((PreDownloadItem)localObject1).jdField_e_of_type_JavaLangString.equals(localPreDownloadItem2.jdField_e_of_type_JavaLangString))
          {
            i = 1;
            k = i;
            if (j < this.jdField_b_of_type_JavaUtilArrayList.size())
            {
              localPreDownloadItem2 = (PreDownloadItem)this.jdField_b_of_type_JavaUtilArrayList.get(j);
              if (!((PreDownloadItem)localObject1).jdField_e_of_type_JavaLangString.equals(localPreDownloadItem2.jdField_e_of_type_JavaLangString)) {
                continue;
              }
              k = 1;
            }
            if (k == 0) {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            }
            d();
            e();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("PreDownloadScheduler", 1, " [msg request add to list]  mPendingList size = " + this.jdField_a_of_type_JavaUtilArrayList.size());
            return true;
          }
          i += 1;
          continue;
          j += 1;
          continue;
          a(localPreDownloadItem1);
        }
        finally {}
      }
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        i = k;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject2 = (PreDownloadItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (paramMessage.equals(((PreDownloadItem)localObject2).jdField_e_of_type_JavaLangString))
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(localObject2);
            ((PreDownloadItem)localObject2).jdField_e_of_type_Int = 3;
            b((PreDownloadItem)localObject2);
            if (QLog.isColorLevel()) {
              QLog.e("PreDownloadScheduler", 1, "[ msg cancel] task.url = " + ((PreDownloadItem)localObject2).jdField_e_of_type_JavaLangString);
            }
            if (localObject2 == this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem) {
              this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem = null;
            }
            e();
          }
          i += 1;
        }
      }
      d();
      return true;
      Object localObject2 = (String)paramMessage.obj;
      j = paramMessage.arg1;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          paramMessage = (PreDownloadItem)this.jdField_b_of_type_JavaUtilArrayList.get(i);
          if (((String)localObject2).equals(paramMessage.jdField_e_of_type_JavaLangString))
          {
            paramMessage.jdField_d_of_type_Long = j;
            paramMessage.jdField_c_of_type_Long = (System.currentTimeMillis() - paramMessage.jdField_b_of_type_Long);
            paramMessage.jdField_e_of_type_Int = 2;
            if (QLog.isColorLevel()) {
              QLog.e("PreDownloadScheduler", 1, "[msg download sucess] task.url = " + paramMessage.jdField_e_of_type_JavaLangString);
            }
            b(paramMessage);
            this.jdField_b_of_type_JavaUtilArrayList.remove(i);
            if (paramMessage == this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem) {
              this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem = null;
            }
          }
          i += 1;
        }
      }
      d();
      return true;
      d();
      e();
      return true;
      paramMessage = (Bundle)paramMessage.obj;
      a(paramMessage.getDouble("FPS"), paramMessage.getDouble("CPU"), this.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_Long);
      return true;
      paramMessage = (AbsPreDownloadTask)paramMessage.obj;
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadAbsPreDownloadTask != null) && (paramMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadAbsPreDownloadTask == paramMessage))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PreDownloadScheduler", 1, " pre download onTaskEnd task key = " + this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadAbsPreDownloadTask.jdField_d_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadItem = null;
      }
      d();
      return true;
      d();
      return true;
    }
  }
  
  public void onDestroy()
  {
    if (this.h) {
      FPSCalculator.a().b(this.jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator$GetFPSListener);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.removeAll(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaUtilArrayList.removeAll(this.jdField_b_of_type_JavaUtilArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler
 * JD-Core Version:    0.7.0.1
 */