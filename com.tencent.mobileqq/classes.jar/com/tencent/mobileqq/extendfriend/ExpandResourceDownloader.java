package com.tencent.mobileqq.extendfriend;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.tencent.biz.expand.utils.ExpandFileUtils;
import com.tencent.biz.expand.utils.LocalStorageUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

public class ExpandResourceDownloader
{
  private long jdField_a_of_type_Long;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final ExpandResourceDownloader.ResourceDownloaderListener jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader$ResourceDownloaderListener;
  private final PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  private final String jdField_a_of_type_JavaLangString;
  private final HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(2);
  private long jdField_b_of_type_Long;
  private final String jdField_b_of_type_JavaLangString;
  private long c;
  
  public ExpandResourceDownloader(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString1, @NonNull String paramString2, @NonNull ExpandResourceDownloader.ResourceDownloaderListener paramResourceDownloaderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2));
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader$ResourceDownloaderListener = paramResourceDownloaderListener;
    a(LocalStorageUtils.a().getString("expand_flutter_res_files", "[]"));
    if (QLog.isColorLevel()) {
      QLog.d("ExpandResourceDownloader", 2, String.format("ExpandResourceDownloader() url=%s md5=%s", new Object[] { paramString1, paramString2 }));
    }
  }
  
  @NotNull
  private HttpNetReq a(String paramString)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new ExpandResourceDownloader.2(this);
    localHttpNetReq.mReqUrl = this.jdField_a_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramString;
    localHttpNetReq.mPrioty = 0;
    localHttpNetReq.mSupportBreakResume = true;
    return localHttpNetReq;
  }
  
  @NotNull
  private HttpEngineTask.IHttpEngineTask a()
  {
    return new ExpandResourceDownloader.1(this);
  }
  
  public static String a()
  {
    return String.format("%s/res", new Object[] { c() });
  }
  
  private String a(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { c(), paramString });
  }
  
  private void a(int paramInt, String paramString1, long paramLong, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", String.valueOf(paramInt));
    localHashMap.put("version", paramString1);
    localHashMap.put("time_cost", String.valueOf(paramLong));
    localHashMap.put("error_msg", paramString2);
    localHashMap.put("total_length", String.valueOf(this.c));
    localHashMap.put("download_length", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_NetworkInfo", NetworkState.g().getNetworkType() + "");
    if (QLog.isColorLevel()) {
      QLog.d("ExpandResourceDownloader", 2, String.format("resourceDownloadReport=%s", new Object[] { localHashMap.toString() }));
    }
    ExpandReportUtils.a("expand_quality#succ_rate#resource_download", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = new JsonParser().parse(paramString).getAsJsonArray();
      int j = paramString.size();
      int i = 0;
      while (i < j)
      {
        String str = paramString.get(i).getAsJsonObject().getAsJsonPrimitive("filename").getAsString();
        long l = paramString.get(i).getAsJsonObject().getAsJsonPrimitive("size").getAsLong();
        this.jdField_a_of_type_JavaUtilHashMap.put(str, Long.valueOf(l));
        i += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ExpandResourceDownloader", 2, paramString, new Object[] { "parse error!" });
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (new File(paramString1).exists())
    {
      paramString1 = PortalUtils.a(paramString1);
      bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (paramString2.equalsIgnoreCase(paramString1)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(String paramString)
  {
    Object localObject = a(paramString);
    HttpEngineTask.IHttpEngineTask localIHttpEngineTask = a();
    localObject = new HttpEngineTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, localIHttpEngineTask, (HttpNetReq)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.requestPreDownload(10073, "prd", this.jdField_b_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString, paramString, 2, 0, false, (AbsPreDownloadTask)localObject);
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      bool = a(a(this.jdField_b_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString);
    }
    return bool;
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new ArrayList();
      FileUtils.a(paramString1, paramString2, false, null, (List)localObject);
      paramString1 = new JsonArray(((ArrayList)localObject).size());
      int i = new File(paramString2).getAbsolutePath().length();
      paramString2 = ((ArrayList)localObject).iterator();
      while (paramString2.hasNext())
      {
        localObject = (File)paramString2.next();
        JsonObject localJsonObject = new JsonObject();
        localJsonObject.addProperty("filename", ((File)localObject).getAbsolutePath().substring(i + 1));
        localJsonObject.addProperty("size", Long.valueOf(((File)localObject).length()));
        paramString1.add(localJsonObject);
      }
      paramString1 = paramString1.toString();
    }
    catch (Exception paramString1)
    {
      QLog.e("ExpandResourceDownloader", 1, "unzipResource fail.", paramString1);
      return false;
    }
    QLog.d("ExpandResourceDownloader", 1, "unzipResource save sp.... " + paramString1);
    a(paramString1);
    LocalStorageUtils.a().edit().putString("expand_flutter_res_files", paramString1).apply();
    return true;
  }
  
  private static String c()
  {
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject2 != null)
    {
      localObject2 = ((File)localObject2).getAbsolutePath() + "/pddata/prd/ef_flutter_res_v2";
      File localFile = new File((String)localObject2);
      localObject1 = localObject2;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  private void c(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      bool1 = bool2;
      if (d()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean d()
  {
    String str = a();
    if (this.jdField_a_of_type_JavaUtilHashMap.size() > 0)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilHashMap.entrySet()).iterator();
      Map.Entry localEntry;
      File localFile;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator.next();
        localFile = new File(str, (String)localEntry.getKey());
      } while ((localFile.exists()) && (localFile.length() == ((Long)localEntry.getValue()).longValue()));
      QLog.w("ExpandResourceDownloader", 1, "validateFiles() warning file " + (String)localEntry.getKey() + " size not match! " + localEntry.getValue() + "/" + localFile.length());
      return false;
    }
    QLog.w("ExpandResourceDownloader", 1, "validateFiles() warning file list is empty, no file exists!");
    return false;
    QLog.d("ExpandResourceDownloader", 1, "validateFiles() all file matched size!");
    return true;
  }
  
  public void a()
  {
    int i = 1;
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      QLog.e("ExpandResourceDownloader", 1, "downloadResource invalid parameters.");
    }
    Object localObject;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ExpandResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
      }
      localObject = a(this.jdField_b_of_type_JavaLangString);
      if (ExpandFileUtils.a((String)localObject, this.jdField_b_of_type_JavaLangString)) {
        break;
      }
    } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(2, 3));
    c((String)localObject);
    b((String)localObject);
    return;
    boolean bool2 = c();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool2 = b((String)localObject, a());
      boolean bool3 = c();
      if ((!bool2) || (!bool3)) {
        break label225;
      }
      bool1 = true;
      label153:
      if (QLog.isColorLevel()) {
        QLog.d("ExpandResourceDownloader", 2, String.format("downloadResource unzip unzipDone=%s unzipped=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3) }));
      }
      localObject = ExtendFriendReport.a();
      if (bool3) {
        break label230;
      }
    }
    for (;;)
    {
      ((ExtendFriendReport)localObject).b(bool1, i);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader$ResourceDownloaderListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExpandResourceDownloader$ResourceDownloaderListener.a(bool1);
      return;
      label225:
      bool1 = false;
      break label153;
      label230:
      i = 0;
    }
  }
  
  public boolean a()
  {
    boolean bool1 = b();
    boolean bool2 = c();
    if (QLog.isColorLevel()) {
      QLog.d("ExpandResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (bool2);
  }
  
  public String b()
  {
    if (a())
    {
      String str = a();
      if (QLog.isColorLevel()) {
        QLog.d("ExpandResourceDownloader", 2, String.format("getUnzipValidResourcePath=%s", new Object[] { str }));
      }
      return str;
    }
    return "";
  }
  
  public void b()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void c()
  {
    if ((!a()) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3))
    {
      QLog.d("ExpandResourceDownloader", 1, String.format("current downLoad status is %s, redownload resource!", new Object[] { this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger }));
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExpandResourceDownloader
 * JD-Core Version:    0.7.0.1
 */