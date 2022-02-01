package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.AnimConfig;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
  public QQLruCache<String, IndividualRedPacketResDownloader.RedPacketTemplateInfo> a;
  IndividualRedPacketManager jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public IndividualRedPacketResDownloader.Char300Info a;
  public IndividualRedPacketResDownloader.RedPacketResInfo a;
  CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new IndividualRedPacketResDownloader.1(this);
  public String a;
  ArrayList<IndividualRedPacketResDownloader.DownloadHolder> jdField_a_of_type_JavaUtilArrayList;
  public Map<String, List<String>> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public IndividualRedPacketResDownloader.Char300Info b;
  public String b;
  public AtomicBoolean b;
  public boolean b;
  public String c;
  
  public IndividualRedPacketResDownloader(QQAppInterface paramQQAppInterface, IndividualRedPacketManager paramIndividualRedPacketManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info = new IndividualRedPacketResDownloader.Char300Info();
    this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info = new IndividualRedPacketResDownloader.Char300Info();
    this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo = new IndividualRedPacketResDownloader.RedPacketResInfo();
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager = paramIndividualRedPacketManager;
    this.jdField_b_of_type_Boolean = paramIndividualRedPacketManager.b().getBoolean("mall_entrance_switch", false);
    this.jdField_a_of_type_Boolean = paramIndividualRedPacketManager.b().getBoolean("redpacket_is_show_switch", false);
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new QQLruCache(1009, 100, 300);
    this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.f = 8;
    this.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.f = 26;
    paramQQAppInterface = (IVasQuickUpdateService)paramQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    if (paramQQAppInterface != null) {
      paramQQAppInterface.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, JSONArray paramJSONArray, ArrayList<IndividualRedPacketResDownloader.DownloadHolder> paramArrayList)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    boolean bool1;
    String str;
    label69:
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo;
    if (paramInt2 < paramJSONArray.length())
    {
      if ((paramInt2 < paramInt1) && (i < paramInt3)) {}
      for (bool1 = true;; bool1 = false)
      {
        str = paramJSONArray.optString(paramInt2);
        if (!TextUtils.isEmpty(str)) {
          break label69;
        }
        j = i;
        paramInt2 += 1;
        i = j;
        break;
      }
      localRedPacketTemplateInfo = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(str);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
          break label190;
        }
        bool2 = a(false, str, localRedPacketTemplateInfo);
        boolean bool3 = bool1;
        if (bool1)
        {
          bool3 = bool1;
          if (!bool2) {
            bool3 = a(str);
          }
        }
        j = i;
        if (!bool3) {
          break;
        }
        j = i;
        if (bool2) {
          break;
        }
        j = a(i, paramArrayList, str);
      }
      return i;
      label190:
      boolean bool2 = false;
    }
  }
  
  private int a(int paramInt, ArrayList<IndividualRedPacketResDownloader.DownloadHolder> paramArrayList, String paramString)
  {
    IndividualRedPacketResDownloader.DownloadHolder localDownloadHolder = new IndividualRedPacketResDownloader.DownloadHolder();
    localDownloadHolder.jdField_a_of_type_Long = 16L;
    localDownloadHolder.jdField_a_of_type_JavaLangString = ("luckyMoney.item." + paramString);
    localDownloadHolder.jdField_b_of_type_JavaLangString = IndividualRedPacketManager.a(paramString, null, 0, 0, 0);
    paramArrayList.add(localDownloadHolder);
    return paramInt + 1;
  }
  
  private JSONObject a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IndividualRedPacketResDownloader", 2, "updateResVersion null == resJson waiting download");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    String str = ClubContentJsonTask.g.jdField_a_of_type_JavaLangString;
    localObject = new File(((Context)localObject).getFilesDir(), str);
    localObject = new DownloadTask(ClubContentJsonTask.g.jdField_b_of_type_JavaLangString, (File)localObject);
    ((DownloadTask)localObject).n = true;
    if (DownloaderFactory.a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
      return ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.g, false);
    }
    QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion download Err : " + ClubContentJsonTask.g.jdField_b_of_type_JavaLangString);
    return paramJSONObject;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    String str1 = IndividualRedPacketManager.a(paramString);
    if (paramBoolean)
    {
      paramString = a(str1);
      if ((paramString != null) && (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager != null))
      {
        ??? = IndividualRedPacketManager.a(str1, null, paramString.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f, paramString.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_d_of_type_Int, 0);
        ??? = (String)??? + "_dir2";
        VasUpdateUtil.a(new File((String)???));
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "callBacker delete animateDir: " + (String)???);
        }
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str1)) {
          break label305;
        }
        localObject2 = (List)this.jdField_a_of_type_JavaUtilMap.get(str1);
        i = 0;
        if (i < ((List)localObject2).size())
        {
          String str2 = (String)((List)localObject2).get(i);
          if (TextUtils.isEmpty(str2)) {
            break label363;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str2, paramString.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f);
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str2 + "_tp", paramString.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f);
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str2 + "_send", paramString.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramString.jdField_a_of_type_JavaLangString);
      label305:
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Object localObject2 = IndividualRedPacketManager.jdField_c_of_type_JavaLangString;
      if (paramBoolean) {}
      for (paramString = "1";; paramString = "0")
      {
        ReportController.b((AppRuntime)???, "CliOper", "", "", "0X800612E", "0X800612E", 0, 0, (String)localObject2, paramString, "1", str1);
        return;
      }
      label363:
      i += 1;
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      b(paramJSONArray);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse urllist == null");
  }
  
  private void a(boolean paramBoolean, ArrayList<IndividualRedPacketResDownloader.DownloadHolder> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    }
    while ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && ((1 == paramInt) || (paramBoolean)) && (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b()))
    {
      a();
      return;
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
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
  
  private boolean a(File paramFile1, File paramFile2, File paramFile3, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if (paramJSONObject == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion data fail Err, return");
      return true;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("templateList");
    if (localJSONArray == null)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion templateList fail Err, return");
      return true;
    }
    int i = 0;
    if (i < localJSONArray.length())
    {
      Object localObject2 = a(localJSONArray.optJSONObject(i), false);
      if ((localObject2 == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo == null)) {}
      label532:
      for (;;)
      {
        i += 1;
        break;
        if (!new File(IndividualRedPacketManager.a(((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).jdField_a_of_type_JavaLangString, null, 0, 0, 0)).exists())
        {
          Object localObject3 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).jdField_a_of_type_JavaLangString + "_" + ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).jdField_d_of_type_Int;
          Object localObject1 = paramFile1.getAbsolutePath() + File.separator + (String)localObject3;
          IndividualRedPacketResDownloader.DecorateInfo localDecorateInfo = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
          paramJSONObject = (JSONObject)localObject1;
          if (localDecorateInfo.f == 19) {
            paramJSONObject = (String)localObject1 + "_zip";
          }
          if (new File(paramJSONObject).exists())
          {
            localObject1 = new String[3];
            localObject1[0] = paramJSONObject;
            localObject1[1] = (paramFile2.getAbsolutePath() + File.separator + (String)localObject3);
            localObject1[2] = (paramFile3.getAbsolutePath() + File.separator + (String)localObject3);
            paramJSONObject = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
            localObject2 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject2).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
            localObject3 = new String[3];
            localObject3[0] = IndividualRedPacketManager.a(localDecorateInfo.jdField_d_of_type_JavaLangString, localDecorateInfo.jdField_c_of_type_JavaLangString, localDecorateInfo.f, localDecorateInfo.jdField_d_of_type_Int, 0);
            localObject3[1] = IndividualRedPacketManager.a(paramJSONObject.jdField_d_of_type_JavaLangString, paramJSONObject.jdField_c_of_type_JavaLangString, paramJSONObject.f, paramJSONObject.jdField_d_of_type_Int, 0);
            localObject3[2] = IndividualRedPacketManager.a(((IndividualRedPacketResDownloader.DecorateInfo)localObject2).jdField_d_of_type_JavaLangString, ((IndividualRedPacketResDownloader.DecorateInfo)localObject2).jdField_c_of_type_JavaLangString, ((IndividualRedPacketResDownloader.DecorateInfo)localObject2).f, ((IndividualRedPacketResDownloader.DecorateInfo)localObject2).jdField_d_of_type_Int, 0);
            int j = 0;
            for (;;)
            {
              if (j >= localObject1.length) {
                break label532;
              }
              if (!FileUtils.d(localObject1[j], localObject3[j]))
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion copyFile aio file Err:" + localObject1[j] + ", newPath:" + localObject3[j]);
                break;
              }
              j += 1;
            }
          }
        }
      }
    }
    return false;
  }
  
  private boolean a(File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramFile1.exists())
    {
      bool = paramBoolean;
      if (paramFile1.isDirectory())
      {
        bool = paramBoolean;
        if (paramFile2.exists())
        {
          bool = paramBoolean;
          if (paramFile2.isDirectory())
          {
            bool = paramBoolean;
            if (paramFile3.exists())
            {
              bool = paramBoolean;
              if (paramFile3.isDirectory())
              {
                paramFile1 = paramFile1.list();
                paramFile2 = paramFile2.list();
                paramFile3 = paramFile3.list();
                bool = paramBoolean;
                if (paramFile1.length > 0)
                {
                  bool = paramBoolean;
                  if (paramFile2.length > 0)
                  {
                    bool = paramBoolean;
                    if (paramFile3.length > 0) {
                      bool = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool;
  }
  
  private boolean a(String paramString)
  {
    if (new File(IndividualRedPacketManager.a(paramString, null, 0, 0, 0)).exists()) {}
    while (new File(IndividualRedPacketManager.a(paramString, null, 3, 0, 0)).exists()) {
      return false;
    }
    return true;
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
                  FileUtils.e(paramString1);
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
  
  private boolean a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject = paramJSONObject.optString("time");
    SharedPreferences.Editor localEditor;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject).getTime() - NetConnInfoCenter.getServerTimeMillis() < 172800000L) {
        paramBoolean = true;
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b();
      localEditor = ((SharedPreferences)localObject).edit();
      if (paramJSONObject.has("androidShowSwitch"))
      {
        if (paramJSONObject.getInt("androidShowSwitch") != 1) {
          break label203;
        }
        bool1 = true;
        label92:
        this.jdField_a_of_type_Boolean = bool1;
      }
      if (paramJSONObject.has("androidEntrySwitch")) {
        if (paramJSONObject.getInt("androidEntrySwitch") != 1) {
          break label208;
        }
      }
    }
    label203:
    label208:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      if ((this.jdField_a_of_type_Boolean != ((SharedPreferences)localObject).getBoolean("redpacket_is_show_switch", false)) || (this.jdField_b_of_type_Boolean != ((SharedPreferences)localObject).getBoolean("mall_entrance_switch", false)))
      {
        localEditor.putBoolean("redpacket_is_show_switch", this.jdField_a_of_type_Boolean);
        localEditor.putBoolean("mall_entrance_switch", this.jdField_b_of_type_Boolean);
        localEditor.commit();
      }
      return paramBoolean;
      paramBoolean = false;
      break;
      bool1 = false;
      break label92;
    }
  }
  
  private boolean a(boolean paramBoolean, String paramString, IndividualRedPacketResDownloader.RedPacketTemplateInfo paramRedPacketTemplateInfo)
  {
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo;
    if ((paramRedPacketTemplateInfo != null) && (!a(paramRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo)) && (!a(paramRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo)))
    {
      localRedPacketTemplateInfo = paramRedPacketTemplateInfo;
      if (!a(paramRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo)) {}
    }
    else
    {
      localRedPacketTemplateInfo = a(paramString);
    }
    if ((localRedPacketTemplateInfo != null) && (a(localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo)) && (a(localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo)) && (a(localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo)))
    {
      paramRedPacketTemplateInfo = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      int i = 0;
      if (i < paramRedPacketTemplateInfo.size())
      {
        String str = (String)paramRedPacketTemplateInfo.get(i);
        if (TextUtils.isEmpty(str)) {}
        for (;;)
        {
          i += 1;
          break;
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str, localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f);
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str + "_tp", localRedPacketTemplateInfo.jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f);
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str + "_send", localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      return paramBoolean;
    }
    a(16L, paramString, null);
    return true;
  }
  
  private void b(JSONArray paramJSONArray)
  {
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("url", null);
      if ("aioTail".equals(str)) {
        this.jdField_b_of_type_JavaLangString = ((String)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ("personalityMall".equals(str)) {
          this.jdField_a_of_type_JavaLangString = ((String)localObject);
        } else if ("tencentPay".equals(str)) {
          this.jdField_c_of_type_JavaLangString = ((String)localObject);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse mAioTailURL:" + this.jdField_b_of_type_JavaLangString + ", mTencentPayURL:" + this.jdField_c_of_type_JavaLangString + ", mPersonalityMallURL:" + this.jdField_a_of_type_JavaLangString);
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
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString, localRedPacketTemplateInfo);
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
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString);
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
    label1043:
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
          break label876;
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
              break label810;
            }
            localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect = new Rect(((JSONArray)localObject1).optInt(0), ((JSONArray)localObject1).optInt(1), ((JSONArray)localObject1).optInt(0) + ((JSONArray)localObject1).optInt(2), ((JSONArray)localObject1).optInt(1) + ((JSONArray)localObject1).optInt(3));
            localRedPacketTemplateInfo.jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_Int = ((JSONArray)localObject1).optInt(2);
            localObject2 = localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
            if (localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$AnimConfig != null) {
              break label1043;
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
      label810:
      if (QLog.isColorLevel())
      {
        QLog.d("IndividualRedPacketResDownloader", 2, "getTemplateByJson sendChar error,name:" + localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_c_of_type_JavaLangString + ", id:" + localRedPacketTemplateInfo.jdField_a_of_type_JavaLangString + ", isV710:" + paramBoolean);
        continue;
        label876:
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
  
  public JSONObject a(File paramFile, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramFile != null)
    {
      localJSONObject = paramJSONObject;
      if (!paramFile.exists()) {}
    }
    try
    {
      localJSONObject = new JSONObject(FileUtils.a(paramFile));
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID ,filePath:" + paramFile.getAbsolutePath(), localThrowable);
    }
    return paramJSONObject;
  }
  
  void a()
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
      IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
      localIVasQuickUpdateService.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
      localIVasQuickUpdateService.downloadItem(localObject.jdField_a_of_type_Long, localObject.jdField_a_of_type_JavaLangString, "silent_download.redbag");
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
          VasUpdateUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, paramString1, paramString2, true, this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
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
        VasUpdateUtil.a(paramString2);
      }
      paramString2 = IndividualRedPacketManager.a(paramString1, null, 0, 0, 0);
      paramString1 = "luckyMoney.item." + paramString1;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    int k = 0;
    Object localObject4;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager;
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Object localObject1 = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.json";
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!paramBoolean1)
        {
          localObject1 = a(VasUpdateUtil.a((AppRuntime)localObject4, 16L, "iRedPacket_v3.json", (String)localObject1, bool, this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker), null);
          if (localObject1 != null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("IndividualRedPacketResDownloader", 2, "initAllConfigJson null == resJson,isAfterDownload:" + paramBoolean1 + ", isInit" + paramBoolean2);
          }
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
    for (;;)
    {
      JSONArray localJSONArray;
      try
      {
        long l = localObject2.optLong("timestamp", 1L);
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "initAllConfigJson timestamp=" + l + ", mJsonTimestamp:" + this.jdField_a_of_type_Long);
        }
        if (l <= this.jdField_a_of_type_Long) {
          break;
        }
        this.jdField_a_of_type_Long = l;
        localObject4 = localObject2.optJSONObject("data");
        if (localObject4 == null) {
          QLog.e("IndividualRedPacketResDownloader", 2, "initAllConfigJson, null == data, timestamp=" + l + ", mJsonTimestamp:" + this.jdField_a_of_type_Long);
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config JSONException: ", localJSONException);
        VasMonitorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_redpacket_json_err", "decode_json_err", localJSONException.getMessage(), null, 0.0F);
        break;
        Object localObject3 = ((JSONObject)localObject4).optJSONArray("activityInfo");
        if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
          break label656;
        }
        localObject3 = ((JSONArray)localObject3).optJSONObject(0);
        if (localObject3 == null) {
          break label662;
        }
        paramBoolean1 = a((JSONObject)localObject3, false);
        localObject3 = ((JSONObject)localObject4).optJSONArray("isPreload");
        m = 50;
        int n = 5;
        int j = m;
        int i = n;
        if (localObject3 != null)
        {
          j = m;
          i = n;
          if (((JSONArray)localObject3).length() > 0)
          {
            localObject3 = ((JSONArray)localObject3).optJSONObject(0);
            i = ((JSONObject)localObject3).optInt("isPreload", 5);
            j = ((JSONObject)localObject3).optInt("preloadTotal", 50);
          }
        }
        localJSONArray = ((JSONObject)localObject4).optJSONArray("templateIdList");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("checkAndDownloadBeforeUse ,emergencyDownload:").append(paramBoolean1).append(", templateIdList:");
          if (localJSONArray != null) {
            break label676;
          }
          localObject3 = "null";
          QLog.d("IndividualRedPacketResDownloader", 2, localObject3);
        }
        localObject3 = new ArrayList();
        if (localJSONArray != null) {
          k = a(j, 0, i, localJSONArray, (ArrayList)localObject3);
        }
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse finish! size = " + this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.size() + ", preloadSize=" + k + ", totalCanPreload=" + i);
        }
        a(((JSONObject)localObject4).optJSONArray("vipRedPacketURL"));
        a(paramBoolean1, (ArrayList)localObject3, NetworkUtil.a(null));
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
      catch (Exception localException)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse parse Json config error: ", localException);
      }
      break;
      label656:
      Integer localInteger = null;
      continue;
      label662:
      QLog.e("IndividualRedPacketResDownloader", 2, "checkAndDownloadBeforeUse ,activityInfoObj0 == null");
      paramBoolean1 = false;
      continue;
      label676:
      int m = localJSONArray.length();
      localInteger = Integer.valueOf(m);
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, File paramFile)
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
              break label683;
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
        QLog.e("IndividualRedPacketResDownloader", 2, "initJsonBySCID parse Json config JSONException: ", paramString);
        VasMonitorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_redpacket_json_err", "decode_json_err", paramString.getMessage(), null, 0.0F);
        return;
      }
      label683:
      if ((!localFile.exists()) && (paramFile != null)) {
        paramFile.delete();
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    a(false, true);
    String str = IndividualRedPacketManager.a(null, null, 8, 0, 0);
    if (VasUpdateUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.font.zip", str, true, this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker) != null) {
      a(false, true, "iRedPacket_v3.font.zip", new File(IndividualRedPacketManager.a(null, null, 21, 0, 0)));
    }
    str = IndividualRedPacketManager.a(null, null, 25, 0, 0);
    a(false, true, "iRedPacket_v3.specialChar.zip", VasUpdateUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.specialChar.zip", str, true, this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker));
    str = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.char300.json";
    a(false, true, "iRedPacket_v3.char300.json", VasUpdateUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.char300.json", str, true, this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker));
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager == null)) {}
    File localFile2;
    File localFile3;
    File localFile4;
    do
    {
      for (;;)
      {
        return;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          try
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b().getBoolean("res_version_has_updated", false))
            {
              File localFile1 = new File(IndividualRedPacketManager.a(3) + "10029_0");
              localObject2 = new File(IndividualRedPacketManager.a(null, null, 8, 0, 0));
              if ((localFile1.exists()) && (!((File)localObject2).exists())) {
                localFile1.renameTo((File)localObject2);
              }
              localFile2 = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "RedPacket/templateAIO"));
              localFile3 = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "RedPacket/templateTENPAY"));
              localFile4 = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "RedPacket/templateSEND"));
              if (!a(localFile2, localFile3, localFile4, false))
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
      Object localObject2 = ClubContentJsonTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ClubContentJsonTask.g, false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a((JSONObject)localObject2);
      }
      if (localObject1 == null)
      {
        QLog.e("IndividualRedPacketResDownloader", 2, "updateResVersion fail Err, return");
        return;
      }
    } while (a(localFile2, localFile3, localFile4, (JSONObject)localObject1));
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.b().edit();
    ((SharedPreferences.Editor)localObject1).putBoolean("res_version_has_updated", true);
    ((SharedPreferences.Editor)localObject1).commit();
    VasUpdateUtil.a(localFile2);
    VasUpdateUtil.a(localFile3);
    VasUpdateUtil.a(localFile4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividualRedPacketResDownloader
 * JD-Core Version:    0.7.0.1
 */