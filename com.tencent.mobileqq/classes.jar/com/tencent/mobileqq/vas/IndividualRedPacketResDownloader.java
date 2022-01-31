package com.tencent.mobileqq.vas;

import akhr;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IndividualRedPacketResDownloader
{
  long jdField_a_of_type_Long;
  public IndividualRedPacketManager a;
  public QQAppInterface a;
  public IndividualRedPacketResDownloader.Char300Info a;
  public IndividualRedPacketResDownloader.RedPacketResInfo a;
  public VasQuickUpdateManager.CallBacker a;
  public String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  Map jdField_a_of_type_JavaUtilMap;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public IndividualRedPacketResDownloader.Char300Info b;
  public String b;
  public Map b;
  public AtomicBoolean b;
  public boolean b;
  public String c;
  public Map c;
  
  public IndividualRedPacketResDownloader(QQAppInterface paramQQAppInterface, IndividualRedPacketManager paramIndividualRedPacketManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info = new IndividualRedPacketResDownloader.Char300Info();
    this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info = new IndividualRedPacketResDownloader.Char300Info();
    this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo = new IndividualRedPacketResDownloader.RedPacketResInfo();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new akhr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager = paramIndividualRedPacketManager;
    this.jdField_b_of_type_Boolean = paramIndividualRedPacketManager.b().getBoolean("mall_entrance_switch", false);
    this.jdField_a_of_type_Boolean = paramIndividualRedPacketManager.b().getBoolean("redpacket_is_show_switch", false);
    this.jdField_b_of_type_JavaUtilMap = new QQConcurrentHashMap(1009, 0, 300);
    this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.f = 8;
    this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.f = 26;
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(183)).a(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
  
  public static boolean a(IndividualRedPacketResDownloader.RedPacketResInfo paramRedPacketResInfo)
  {
    if ((paramRedPacketResInfo == null) || (paramRedPacketResInfo.f == 0)) {}
    for (;;)
    {
      return false;
      paramRedPacketResInfo = IndividualRedPacketManager.a(paramRedPacketResInfo.jdField_d_of_type_JavaLangString, paramRedPacketResInfo.jdField_c_of_type_JavaLangString, paramRedPacketResInfo.f, paramRedPacketResInfo.jdField_d_of_type_Int, 0);
      if (TextUtils.isEmpty(paramRedPacketResInfo)) {}
      for (paramRedPacketResInfo = null; (paramRedPacketResInfo != null) && (paramRedPacketResInfo.exists()) && (paramRedPacketResInfo.isFile()); paramRedPacketResInfo = new File(paramRedPacketResInfo)) {
        return true;
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool3 = false;
    File localFile1 = new File(paramString1);
    if ((localFile1 != null) && (localFile1.exists()) && (localFile1.isFile())) {
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 2, "uncompressZip zipFile.exists(), zipFile.length()=" + localFile1.length());
      }
    }
    for (;;)
    {
      try
      {
        FileUtils.a(paramString1, paramString2, false);
        File localFile2 = new File(paramString2);
        if (localFile2.exists())
        {
          i = ThemeUtil.getFileNumInFile(localFile2);
          if (i > 0)
          {
            i = 1;
            if (i == 0)
            {
              paramString2 = new File(paramString2);
              QLog.d("IndividualRedPacketResDownloader", 1, "uncompressZip DownloaderFactory.unzipResource, themeZipPath:" + paramString1);
              bool1 = DownloaderFactory.a(localFile1, paramString2, false);
              bool2 = bool1;
              j = i;
              if (i == 0)
              {
                bool2 = bool1;
                j = i;
                if (!bool1)
                {
                  FileUtils.d(paramString1);
                  QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip result false");
                  j = i;
                  bool2 = bool1;
                }
              }
              if (j == 0)
              {
                bool1 = bool3;
                if (!bool2) {}
              }
              else
              {
                bool1 = true;
              }
              return bool1;
            }
          }
          else
          {
            QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip fileNum == 0");
            i = 0;
            continue;
          }
        }
      }
      catch (IOException localIOException)
      {
        QLog.e("IndividualRedPacketResDownloader", 1, "uncompressZip FileUtils.uncompressZip IOException:" + localIOException.getMessage());
        int i = 0;
        continue;
        boolean bool1 = false;
        continue;
        i = 0;
        continue;
      }
      boolean bool2 = false;
      int j = 0;
    }
  }
  
  public IndividualRedPacketResDownloader.RedPacketTemplateInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = new File(IndividualRedPacketManager.a(paramString, null, 0, 0, 0));
    } while (!paramString.exists());
    try
    {
      IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo = a(new JSONObject(FileUtils.a(paramString)), true);
      if (localRedPacketTemplateInfo != null) {
        this.jdField_b_of_type_JavaUtilMap.put(localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString, localRedPacketTemplateInfo);
      }
      return localRedPacketTemplateInfo;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "loadPacketJson ,filePath:" + paramString.getAbsolutePath(), localThrowable);
    }
    return null;
  }
  
  public IndividualRedPacketResDownloader.RedPacketTemplateInfo a(String paramString, boolean paramBoolean)
  {
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (!paramBoolean) {}
    while ((localRedPacketTemplateInfo != null) && (localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo != null) && (localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo != null) && (localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo != null)) {
      return localRedPacketTemplateInfo;
    }
    return a(paramString);
  }
  
  IndividualRedPacketResDownloader.RedPacketTemplateInfo a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return null;
    }
    label1042:
    for (;;)
    {
      Object localObject1;
      IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo;
      Object localObject2;
      try
      {
        localObject1 = paramJSONObject.optString("id");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localRedPacketTemplateInfo = new IndividualRedPacketResDownloader.RedPacketTemplateInfo();
        localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo = new IndividualRedPacketResDownloader.DecorateInfo();
        localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f = 2;
        localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo = new IndividualRedPacketResDownloader.DecorateInfo();
        localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f = 3;
        localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo = new IndividualRedPacketResDownloader.DecorateInfo();
        localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f = 14;
        localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString = ((String)localObject1);
        localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_d_of_type_JavaLangString = ((String)localObject1);
        localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_c_of_type_JavaLangString = paramJSONObject.optString("name");
        localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_c_of_type_JavaLangString = localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_c_of_type_JavaLangString;
        localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_c_of_type_JavaLangString = localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_c_of_type_JavaLangString;
        localRedPacketTemplateInfo.jdField_a_of_type_Int = paramJSONObject.optInt("customWord", IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int);
        localRedPacketTemplateInfo.e = paramJSONObject.optInt("fontTypeId", 1);
        localRedPacketTemplateInfo.jdField_d_of_type_Int = paramJSONObject.optInt("version", 0);
        localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_d_of_type_Int = localRedPacketTemplateInfo.jdField_d_of_type_Int;
        localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_d_of_type_Int = localRedPacketTemplateInfo.jdField_d_of_type_Int;
        localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_d_of_type_Int = localRedPacketTemplateInfo.jdField_d_of_type_Int;
        if (localRedPacketTemplateInfo.jdField_a_of_type_Int != IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int) {
          break label875;
        }
        localObject1 = paramJSONObject.optJSONArray("aioChar");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 4))
        {
          localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
          localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
          localObject1 = paramJSONObject.optJSONArray("packetChar");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() >= 4))
          {
            localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
            localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
            localObject1 = paramJSONObject.optJSONArray("sendChar");
            if ((localObject1 == null) || (((JSONArray)localObject1).length() < 4)) {
              break label809;
            }
            localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
            localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
            localObject2 = localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
            if (localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig != null) {
              break label1042;
            }
            localObject1 = paramJSONObject.optString("aioImgUrl", "");
            ((IndividualRedPacketResDownloader.DecorateInfo)localObject2).e = ((String)localObject1);
            localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.e = paramJSONObject.optString("redEnvelopeImgUrl", "");
            localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.e = paramJSONObject.optString("sendImgUrl", "");
            return localRedPacketTemplateInfo;
          }
        }
        else
        {
          QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson aioChar error,name:" + localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_c_of_type_JavaLangString + ", id:" + localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
          localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect = new Rect(1, 1, 1, 1);
          localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_Int = 1;
          localRedPacketTemplateInfo.jdField_a_of_type_Int = IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int;
          continue;
        }
        QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson packetChar error,name:" + localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_c_of_type_JavaLangString + ", id:" + localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "getTemplateByJson Err:" + paramJSONObject.toString() + ", isV710:" + paramBoolean);
        return null;
      }
      localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect = new Rect(1, 1, 1, 1);
      localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_Int = 1;
      localRedPacketTemplateInfo.jdField_a_of_type_Int = IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int;
      continue;
      label809:
      if (QLog.isColorLevel())
      {
        QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson sendChar error,name:" + localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_c_of_type_JavaLangString + ", id:" + localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
        continue;
        label875:
        localObject1 = paramJSONObject.optString("aioPngZip", null);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).indexOf("http") >= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson aioPngZip ,name=" + localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_c_of_type_JavaLangString + ", id:" + localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString + ", url:" + (String)localObject1 + ", isV710:" + paramBoolean);
          }
          localObject2 = new CustomizeStrategyFactory.AnimConfig();
          ((CustomizeStrategyFactory.AnimConfig)localObject2).jdField_b_of_type_Int = paramJSONObject.optInt("interval", 100);
          ((CustomizeStrategyFactory.AnimConfig)localObject2).jdField_a_of_type_Int = paramJSONObject.optInt("flameCount", 0);
          localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig = ((CustomizeStrategyFactory.AnimConfig)localObject2);
          localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_JavaLangString = ((String)localObject1);
          localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f = 19;
          continue;
          localObject1 = localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager != null) && (this.jdField_a_of_type_JavaUtilArrayList != null))
        {
          int i = this.jdField_a_of_type_JavaUtilArrayList.size();
          if (i > 0) {}
        }
        else
        {
          return;
        }
        try
        {
          IndividualRedPacketResDownloader.DownloadHolder localDownloadHolder = (IndividualRedPacketResDownloader.DownloadHolder)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
          if (localDownloadHolder != null) {
            break label99;
          }
          a();
        }
        catch (Exception localException)
        {
          QLog.d("IndividualRedPacketResDownloader", 2, "preDownload, err=" + localException.getMessage());
        }
        continue;
        if (!new File(localObject.jdField_b_of_type_JavaLangString).exists()) {
          break label123;
        }
      }
      finally {}
      label99:
      a();
      continue;
      label123:
      VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183);
      if (!localVasQuickUpdateManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        localVasQuickUpdateManager.a();
      }
      localVasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      localVasQuickUpdateManager.a(localObject.jdField_a_of_type_Long, localObject.jdField_a_of_type_JavaLangString, "silent_download.redbag");
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (0L == paramLong) || (TextUtils.isEmpty(paramString1)))
        {
          QLog.e("IndividualRedPacketResDownloader", 1, "downloadResIfNotExsit err filePath, bid=" + paramLong + ",id:" + paramString1);
          return;
        }
        if ("iRedPacket_v3.specialChar.zip".equals(paramString1))
        {
          paramString2 = IndividualRedPacketManager.a(null, null, 11, 0, 0);
          VasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, paramString1, paramString2, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
          continue;
        }
        paramString2 = new File(IndividualRedPacketManager.a(paramString1, null, 24, 0, 0));
      }
      finally {}
      boolean bool = paramString2.exists();
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 1, "downloadResIfNotExsit, id: " + paramString1 + " exists: " + bool);
      }
      if (bool) {
        VasQuickUpdateEngine.safeDeleteFile(paramString2);
      }
      paramString2 = IndividualRedPacketManager.a(paramString1, null, 0, 0, 0);
      paramString1 = "luckyMoney.item." + paramString1;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject7;
    label230:
    Object localObject8;
    label447:
    label503:
    Object localObject9;
    label546:
    label576:
    int j;
    label654:
    int i;
    int m;
    int n;
    label713:
    int i1;
    label829:
    label858:
    String str1;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager;
          if (localObject1 != null) {
            continue;
          }
        }
      }
      finally
      {
        try
        {
          Object localObject1 = new JSONObject(FileUtils.a((File)localObject7));
          if (localObject1 != null) {
            break label230;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("IndividualRedPacketResDownloader", 2, "initAllConfigJson null == resJson,isAfterDownload:" + paramBoolean1 + ", isInit" + paramBoolean2);
        }
        catch (Throwable localThrowable)
        {
          boolean bool;
          QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID ,filePath:" + ((File)localObject7).getAbsolutePath(), localThrowable);
        }
        localObject2 = finally;
      }
      return;
      localObject1 = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.json";
      localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!paramBoolean1)
      {
        bool = true;
        localObject7 = VasQuickUpdateManager.a((AppRuntime)localObject7, 16L, "iRedPacket_v3.json", (String)localObject1, bool, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        if (localObject7 != null)
        {
          bool = ((File)localObject7).exists();
          if (!bool) {}
        }
      }
      else
      {
        bool = false;
        continue;
      }
      Object localObject3 = null;
      continue;
      try
      {
        long l = localObject3.optLong("timestamp", 1L);
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "initAllConfigJson timestamp=" + l + ", mJsonTimestamp:" + this.jdField_a_of_type_Long);
        }
        if (l > this.jdField_a_of_type_Long)
        {
          this.jdField_a_of_type_Long = l;
          localObject7 = localObject3.optJSONObject("data");
          if (localObject7 == null) {
            QLog.e("IndividualRedPacketResDownloader", 2, "initAllConfigJson, null == data, timestamp=" + l + ", mJsonTimestamp:" + this.jdField_a_of_type_Long);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config JSONException: " + localJSONException.getMessage());
        VasMonitorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_redpacket_json_err", "decode_json_err", localJSONException.getMessage(), null, 0.0F);
        continue;
        Object localObject4 = ((JSONObject)localObject7).optJSONArray("activityInfo");
        if ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0)) {
          break label1809;
        }
        localObject4 = ((JSONArray)localObject4).optJSONObject(0);
        paramBoolean1 = false;
        if (localObject4 != null)
        {
          localObject8 = ((JSONObject)localObject4).optString("time");
          if (!TextUtils.isEmpty((CharSequence)localObject8))
          {
            if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject8).getTime() - NetConnInfoCenter.getServerTimeMillis() >= 172800000L) {
              break label1815;
            }
            paramBoolean1 = true;
          }
          localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b();
          localObject9 = ((SharedPreferences)localObject8).edit();
          if (((JSONObject)localObject4).has("androidShowSwitch"))
          {
            if (((JSONObject)localObject4).getInt("androidShowSwitch") != 1) {
              break label1820;
            }
            paramBoolean2 = true;
            this.jdField_a_of_type_Boolean = paramBoolean2;
          }
          if (((JSONObject)localObject4).has("androidEntrySwitch"))
          {
            if (((JSONObject)localObject4).getInt("androidEntrySwitch") != 1) {
              break label1825;
            }
            paramBoolean2 = true;
            this.jdField_b_of_type_Boolean = paramBoolean2;
          }
          if ((this.jdField_a_of_type_Boolean == ((SharedPreferences)localObject8).getBoolean("redpacket_is_show_switch", false)) && (this.jdField_b_of_type_Boolean == ((SharedPreferences)localObject8).getBoolean("mall_entrance_switch", false))) {
            break label1797;
          }
          ((SharedPreferences.Editor)localObject9).putBoolean("redpacket_is_show_switch", this.jdField_a_of_type_Boolean);
          ((SharedPreferences.Editor)localObject9).putBoolean("mall_entrance_switch", this.jdField_b_of_type_Boolean);
          ((SharedPreferences.Editor)localObject9).commit();
          break label1797;
          localObject4 = ((JSONObject)localObject7).optJSONArray("isPreload");
          j = 0;
          i = 0;
          if ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0)) {
            break label1787;
          }
          localObject4 = ((JSONArray)localObject4).optJSONObject(0);
          m = ((JSONObject)localObject4).optInt("isPreload", 5);
          n = ((JSONObject)localObject4).optInt("preloadTotal", 50);
          localObject8 = ((JSONObject)localObject7).optJSONArray("templateIdList");
          if (QLog.isColorLevel())
          {
            localObject9 = new StringBuilder().append("checkAndDownloadBeforeUse ,emergencyDownload:").append(paramBoolean1).append(", templateIdList:");
            if (localObject8 != null) {
              break label892;
            }
          }
        }
        for (localObject4 = "null";; localObject4 = Integer.valueOf(((JSONArray)localObject8).length()))
        {
          QLog.d("IndividualRedPacketResDownloader", 2, localObject4);
          if ((this.jdField_a_of_type_JavaUtilMap != null) && (this.jdField_a_of_type_JavaUtilMap.size() > 0)) {
            this.jdField_b_of_type_JavaUtilMap.putAll(this.jdField_a_of_type_JavaUtilMap);
          }
          localObject9 = new ArrayList();
          if (localObject8 == null) {
            break label1433;
          }
          i1 = 0;
          j = i;
          if (i1 >= ((JSONArray)localObject8).length()) {
            break label1433;
          }
          if ((i1 >= n) || (i >= m)) {
            break label1830;
          }
          j = 1;
          str1 = ((JSONArray)localObject8).optString(i1);
          if (!TextUtils.isEmpty(str1)) {
            break label905;
          }
          break label1800;
          QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse ,activityInfoObj0 == null");
          paramBoolean1 = false;
          break;
        }
        label905:
        localObject4 = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)this.jdField_b_of_type_JavaUtilMap.get(str1);
        synchronized (this.jdField_c_of_type_JavaUtilMap)
        {
          if (!this.jdField_c_of_type_JavaUtilMap.containsKey(str1)) {
            break label1781;
          }
          if ((localObject4 != null) && (!a(((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject4).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo)) && (!a(((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject4).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo)) && (!a(((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject4).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo))) {
            break label1778;
          }
          localObject4 = a(str1);
          label990:
          if ((localObject4 == null) || (!a(((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject4).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo)) || (!a(((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject4).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo)) || (!a(((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject4).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo))) {
            break label1389;
          }
          List localList = (List)this.jdField_c_of_type_JavaUtilMap.get(str1);
          k = 0;
          label1047:
          if (k >= localList.size()) {
            break;
          }
          String str2 = (String)localList.get(k);
          if (TextUtils.isEmpty(str2)) {
            break label1836;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str2, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject4).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f);
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str2 + "_tp", ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject4).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f);
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str2 + "_send", ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject4).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f);
        }
      }
      catch (Exception localException)
      {
        label892:
        QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config error: " + localException.getMessage());
      }
    }
    this.jdField_c_of_type_JavaUtilMap.remove(str1);
    int k = 0;
    label1234:
    Object localObject6;
    if (localException == null)
    {
      localObject6 = new IndividualRedPacketResDownloader.RedPacketTemplateInfo();
      ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject6).jdField_a_of_type_JavaLangString = str1;
      this.jdField_b_of_type_JavaUtilMap.put(str1, localObject6);
    }
    if ((j != 0) && (k == 0))
    {
      if (new File(IndividualRedPacketManager.a(str1, null, 0, 0, 0)).exists()) {
        j = 0;
      }
      label1433:
      for (;;)
      {
        label1307:
        if ((j != 0) && (k == 0))
        {
          i += 1;
          localObject6 = new IndividualRedPacketResDownloader.DownloadHolder();
          ((IndividualRedPacketResDownloader.DownloadHolder)localObject6).jdField_a_of_type_Long = 16L;
          ((IndividualRedPacketResDownloader.DownloadHolder)localObject6).jdField_a_of_type_JavaLangString = ("luckyMoney.item." + str1);
          ((IndividualRedPacketResDownloader.DownloadHolder)localObject6).jdField_b_of_type_JavaLangString = IndividualRedPacketManager.a(str1, null, 0, 0, 0);
          ((ArrayList)localObject9).add(localObject6);
          break label1800;
          label1389:
          a(16L, str1, null);
          k = 1;
          break;
          if (new File(IndividualRedPacketManager.a(str1, null, 3, 0, 0)).exists()) {
            break label1845;
          }
          j = 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse finish! size = " + this.jdField_b_of_type_JavaUtilMap.size() + ", preloadSize=" + j + ", totalCanPreload=" + m);
          }
          localObject6 = ((JSONObject)localObject7).optJSONArray("vipRedPacketURL");
          if (localObject6 != null) {
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject6).length())
      {
        localObject8 = ((JSONArray)localObject6).optJSONObject(i);
        localObject7 = ((JSONObject)localObject8).optString("name");
        localObject8 = ((JSONObject)localObject8).optString("url", null);
        if ("aioTail".equals(localObject7)) {
          this.jdField_b_of_type_JavaLangString = ((String)localObject8);
        } else if ("personalityMall".equals(localObject7)) {
          this.jdField_a_of_type_JavaLangString = ((String)localObject8);
        } else if ("tencentPay".equals(localObject7)) {
          this.jdField_c_of_type_JavaLangString = ((String)localObject8);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse mAioTailURL:" + this.jdField_b_of_type_JavaLangString + ", mTencentPayURL:" + this.jdField_c_of_type_JavaLangString + ", mPersonalityMallURL:" + this.jdField_a_of_type_JavaLangString);
        }
        label1671:
        i = NetworkUtil.a(null);
        if (this.jdField_a_of_type_JavaUtilArrayList == null)
        {
          this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject9);
          label1689:
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || ((1 != i) && (!paramBoolean1)) || (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b())) {
            break label1764;
          }
          a();
        }
        for (;;)
        {
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          break;
          if (!QLog.isColorLevel()) {
            break label1671;
          }
          QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse urllist == null");
          break label1671;
          this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject9);
          break label1689;
          label1764:
          this.jdField_a_of_type_JavaUtilArrayList = null;
        }
        break label1800;
        break label1307;
        label1778:
        break label990;
        label1781:
        k = 0;
        break label1234;
        label1787:
        m = 5;
        n = 50;
        break label713;
        label1797:
        break label654;
        label1800:
        i1 += 1;
        break label829;
        label1809:
        localObject6 = null;
        break label447;
        label1815:
        paramBoolean1 = false;
        break label503;
        label1820:
        paramBoolean2 = false;
        break label546;
        label1825:
        paramBoolean2 = false;
        break label576;
        label1830:
        j = 0;
        break label858;
        label1836:
        k += 1;
        break label1047;
        label1845:
        j = 0;
        break label1307;
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, File paramFile)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager == null)) {
      return;
    }
    if ((paramFile != null) && (paramFile.exists())) {}
    File localFile;
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(FileUtils.a(paramFile));
        if (localObject1 != null) {
          break label172;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject1 = new StringBuilder().append("initJsonBySCID null == resJson, scid=").append(paramString).append(", isAfterDownload:").append(paramBoolean1).append(", isInit").append(paramBoolean2).append(", file=");
        if (paramFile == null) {
          break label165;
        }
        paramString = paramFile.getAbsolutePath();
        QLog.e("IndividualRedPacketResDownloader", 2, paramString);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID ,filePath:" + paramFile.getAbsolutePath(), localThrowable);
      }
      localFile = null;
      continue;
      label165:
      paramString = "null";
    }
    for (;;)
    {
      try
      {
        label172:
        Object localObject2;
        if ("iRedPacket_v3.char300.json".equals(paramString))
        {
          localObject2 = localFile.optJSONArray("data");
          if (localObject2 != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            int i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              localStringBuilder.append(((JSONArray)localObject2).getString(i));
              i += 1;
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
            this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.e = 2;
          }
        }
        if ("iRedPacket_v3.font.zip".equals(paramString))
        {
          this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.jdField_d_of_type_JavaLangString = localFile.optString("id", "");
          this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.jdField_c_of_type_JavaLangString = localFile.optString("name", "");
          this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.jdField_d_of_type_Int = localFile.optInt("version");
          this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.e = 2;
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.jdField_d_of_type_JavaLangString);
        }
        if ("iRedPacket_v3.specialChar.zip".equals(paramString))
        {
          this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_d_of_type_JavaLangString = localFile.optString("id", "0");
          this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_d_of_type_Int = localFile.optInt("version");
          this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.e = 2;
          this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_b_of_type_JavaLangString = localFile.optString("char", "");
          this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_a_of_type_JavaLangString = ("" + this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_b_of_type_JavaLangString);
          paramString = this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_d_of_type_JavaLangString + this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_d_of_type_Int;
          if ((!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_b_of_type_JavaLangString)) && (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b().getString("special_unzip_version_key", ""))))
          {
            localFile = new File(IndividualRedPacketManager.a(null, null, 26, 0, 0));
            localObject2 = IndividualRedPacketManager.a(2) + "images";
            if (!a(localFile.getAbsolutePath(), (String)localObject2)) {
              break label700;
            }
            this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b().edit().putString("special_unzip_version_key", paramString).commit();
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.e != 2) || (this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.e != 2) || (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse goto preCreatePersonalFontImg");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info);
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID parse Json config JSONException: " + paramString.getMessage());
        VasMonitorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_redpacket_json_err", "decode_json_err", paramString.getMessage(), null, 0.0F);
        return;
      }
      label700:
      if ((!localFile.exists()) && (paramFile != null)) {
        paramFile.delete();
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183)).b(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_b_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    a(false, true);
    String str = IndividualRedPacketManager.a(null, null, 8, 0, 0);
    if (VasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.font.zip", str, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker) != null) {
      a(false, true, "iRedPacket_v3.font.zip", new File(IndividualRedPacketManager.a(null, null, 21, 0, 0)));
    }
    str = IndividualRedPacketManager.a(null, null, 25, 0, 0);
    a(false, true, "iRedPacket_v3.specialChar.zip", VasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.specialChar.zip", str, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker));
    str = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.char300.json";
    a(false, true, "iRedPacket_v3.char300.json", VasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.char300.json", str, true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker));
  }
  
  public void d()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    label10:
    String[] arrayOfString;
    Object localObject2;
    do
    {
      do
      {
        break label10;
        do
        {
          return;
        } while ((this.jdField_a_of_type_JavaUtilMap != null) || (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b().getBoolean("res_version_has_updated", false)));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b().getString("res_version_old_id_list", null);
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      arrayOfString = ((String)localObject1).split(",");
      localObject2 = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.g, false);
      if (localObject2 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("IndividualRedPacketResDownloader", 2, "loadOldTemplate null == resJson, idArr=" + (String)localObject1);
    return;
    Object localObject1 = ((JSONObject)localObject2).optJSONObject("data");
    if (localObject1 == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "loadOldTemplate data fail Err, return");
      return;
    }
    localObject1 = ((JSONObject)localObject1).optJSONArray("templateList");
    if (localObject1 == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "loadOldTemplate templateList fail Err, return");
      return;
    }
    this.jdField_a_of_type_JavaUtilMap = new QQConcurrentHashMap(1007, 0, 300);
    int m = 0;
    int i = 0;
    int j;
    label253:
    int k;
    int n;
    try
    {
      if (m < ((JSONArray)localObject1).length())
      {
        Object localObject3 = ((JSONArray)localObject1).optJSONObject(m);
        if (localObject3 == null)
        {
          j = i;
        }
        else
        {
          localObject2 = ((JSONObject)localObject3).optString("id");
          j = i;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            if (arrayOfString != null)
            {
              j = 0;
              k = i;
              n = j;
              if (j < arrayOfString.length)
              {
                if (((String)localObject2).equals(arrayOfString[j]))
                {
                  n = j;
                  k = i;
                }
              }
              else
              {
                label282:
                if (!new File(IndividualRedPacketManager.a((String)localObject2, null, 0, 0, 0)).exists()) {
                  break label336;
                }
                arrayOfString[n] = "";
                j = 1;
                break label564;
              }
              if (j < arrayOfString.length - 1) {
                break label575;
              }
              arrayOfString[j] = "";
              i = 1;
              break label575;
              label336:
              localObject3 = a((JSONObject)localObject3, false);
              if ((localObject3 == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject3).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null)) {
                break label582;
              }
              this.jdField_a_of_type_JavaUtilMap.put(localObject2, localObject3);
              j = k;
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "loadOldTemplate TODO v7.10 updateErr:" + localThrowable.toString());
      return;
    }
    if (i != 0)
    {
      localObject2 = new StringBuilder();
      i = i1;
      label445:
      if (i < arrayOfString.length)
      {
        if (TextUtils.isEmpty(arrayOfString[i])) {
          break label594;
        }
        if (((StringBuilder)localObject2).length() <= 0) {
          break label601;
        }
      }
    }
    label564:
    label575:
    label582:
    label594:
    label601:
    for (String str = "," + arrayOfString[i];; str = arrayOfString[i])
    {
      ((StringBuilder)localObject2).append(str);
      break label594;
      this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b().edit().putString("res_version_old_id_list", ((StringBuilder)localObject2).toString()).commit();
      if (this.jdField_a_of_type_JavaUtilMap.size() >= 1) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap = null;
      return;
      n = 0;
      k = i;
      break label282;
      for (;;)
      {
        m += 1;
        i = j;
        break;
        j += 1;
        break label253;
        arrayOfString[n] = "";
        j = 1;
      }
      i += 1;
      break label445;
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager == null)) {}
    File localFile1;
    File localFile2;
    File localFile3;
    int j;
    for (;;)
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.c.get()) {
        try
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b().getBoolean("res_version_has_updated", false))
          {
            Object localObject1 = new File(IndividualRedPacketManager.a(3) + "10029_0");
            localObject3 = new File(IndividualRedPacketManager.a(null, null, 8, 0, 0));
            if ((((File)localObject1).exists()) && (!((File)localObject3).exists())) {
              ((File)localObject1).renameTo((File)localObject3);
            }
            localFile1 = new File(AppConstants.aJ + "RedPacket/templateAIO");
            localFile2 = new File(AppConstants.aJ + "RedPacket/templateTENPAY");
            localFile3 = new File(AppConstants.aJ + "RedPacket/templateSEND");
            j = 0;
            i = j;
            if (localFile1.exists())
            {
              i = j;
              if (localFile1.isDirectory())
              {
                i = j;
                if (localFile2.exists())
                {
                  i = j;
                  if (localFile2.isDirectory())
                  {
                    i = j;
                    if (localFile3.exists())
                    {
                      i = j;
                      if (localFile3.isDirectory())
                      {
                        localObject1 = localFile1.list();
                        localObject3 = localFile2.list();
                        localObject4 = localFile3.list();
                        i = j;
                        if (localObject1.length > 0)
                        {
                          i = j;
                          if (localObject3.length > 0)
                          {
                            i = j;
                            if (localObject4.length > 0) {
                              i = 1;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            if (i == 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b().edit().putBoolean("res_version_has_updated", true).commit();
              return;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion TODO v7.10 updateErr:" + localThrowable.toString());
          return;
        }
      }
    }
    Object localObject3 = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.g, false);
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IndividualRedPacketResDownloader", 2, "updateResVersion null == resJson waiting download");
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
      localObject4 = ClubContentJsonTask.g.jdField_a_of_type_JavaLangString;
      localObject2 = new File(((Context)localObject2).getFilesDir(), (String)localObject4);
      localObject2 = new DownloadTask(ClubContentJsonTask.g.jdField_b_of_type_JavaLangString, (File)localObject2);
      ((DownloadTask)localObject2).l = true;
      if (DownloaderFactory.a((DownloadTask)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) {
        break label507;
      }
    }
    for (localObject2 = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.g, false); localObject2 == null; localObject2 = localObject3)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion fail Err, return");
      return;
      label507:
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion download Err : " + ClubContentJsonTask.g.jdField_b_of_type_JavaLangString);
    }
    localObject2 = ((JSONObject)localObject2).optJSONObject("data");
    if (localObject2 == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion data fail Err, return");
      return;
    }
    JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("templateList");
    if (localJSONArray == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion templateList fail Err, return");
      return;
    }
    this.jdField_a_of_type_JavaUtilMap = new QQConcurrentHashMap(1007, 0, 300);
    Object localObject4 = new StringBuilder();
    int i = 0;
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo;
    Object localObject5;
    if (i < localJSONArray.length())
    {
      localRedPacketTemplateInfo = a(localJSONArray.optJSONObject(i), false);
      if ((localRedPacketTemplateInfo == null) || (localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null) || (localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null) || (localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null) || (new File(IndividualRedPacketManager.a(localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString, null, 0, 0, 0)).exists())) {
        break label1215;
      }
      localObject5 = localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString + "_" + localRedPacketTemplateInfo.jdField_d_of_type_Int;
      localObject3 = localFile1.getAbsolutePath() + File.separator + (String)localObject5;
      IndividualRedPacketResDownloader.DecorateInfo localDecorateInfo1 = localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
      localObject2 = localObject3;
      if (localDecorateInfo1.f == 19) {
        localObject2 = (String)localObject3 + "_zip";
      }
      if (!new File((String)localObject2).exists()) {
        break label1215;
      }
      localObject3 = new String[3];
      localObject3[0] = localObject2;
      localObject3[1] = (localFile2.getAbsolutePath() + File.separator + (String)localObject5);
      localObject3[2] = (localFile3.getAbsolutePath() + File.separator + (String)localObject5);
      localObject2 = localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
      IndividualRedPacketResDownloader.DecorateInfo localDecorateInfo2 = localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
      localObject5 = new String[3];
      localObject5[0] = IndividualRedPacketManager.a(localDecorateInfo1.jdField_d_of_type_JavaLangString, localDecorateInfo1.jdField_c_of_type_JavaLangString, localDecorateInfo1.f, localDecorateInfo1.jdField_d_of_type_Int, 0);
      localObject5[1] = IndividualRedPacketManager.a(((IndividualRedPacketResDownloader.DecorateInfo)localObject2).jdField_d_of_type_JavaLangString, ((IndividualRedPacketResDownloader.DecorateInfo)localObject2).jdField_c_of_type_JavaLangString, ((IndividualRedPacketResDownloader.DecorateInfo)localObject2).f, ((IndividualRedPacketResDownloader.DecorateInfo)localObject2).jdField_d_of_type_Int, 0);
      localObject5[2] = IndividualRedPacketManager.a(localDecorateInfo2.jdField_d_of_type_JavaLangString, localDecorateInfo2.jdField_c_of_type_JavaLangString, localDecorateInfo2.f, localDecorateInfo2.jdField_d_of_type_Int, 0);
      j = 0;
    }
    for (;;)
    {
      if (j < localObject3.length) {
        if (!FileUtils.d(localObject3[j], localObject5[j]))
        {
          if (QLog.isColorLevel()) {
            QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion copyFile aio file Err:" + localObject3[j] + ", newPath:" + localObject5[j]);
          }
        }
        else
        {
          if (j != 0) {
            break label1222;
          }
          if (((StringBuilder)localObject4).length() > 0) {}
          for (localObject2 = "," + localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString;; localObject2 = localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString)
          {
            ((StringBuilder)localObject4).append((String)localObject2);
            this.jdField_a_of_type_JavaUtilMap.put(localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString, localRedPacketTemplateInfo);
            break;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b().edit();
          if (((StringBuilder)localObject4).length() > 0) {
            ((SharedPreferences.Editor)localObject2).putString("res_version_old_id_list", ((StringBuilder)localObject4).toString());
          }
          ((SharedPreferences.Editor)localObject2).putBoolean("res_version_has_updated", true);
          ((SharedPreferences.Editor)localObject2).commit();
          VasQuickUpdateEngine.safeDeleteFile(localFile1);
          VasQuickUpdateEngine.safeDeleteFile(localFile2);
          VasQuickUpdateEngine.safeDeleteFile(localFile3);
          return;
        }
      }
      label1215:
      i += 1;
      break;
      label1222:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividualRedPacketResDownloader
 * JD-Core Version:    0.7.0.1
 */