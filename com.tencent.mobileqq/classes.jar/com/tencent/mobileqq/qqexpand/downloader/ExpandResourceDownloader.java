package com.tencent.mobileqq.qqexpand.downloader;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.qqexpand.utils.ExpandFileUtils;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.LocalStorageUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
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
  private final QQAppInterface a;
  private final IPreDownloadController b;
  private final ExpandResourceDownloader.ResourceDownloaderListener c;
  private final String d;
  private final String e;
  private final HashMap<String, Long> f = new HashMap();
  private long g;
  private final AtomicInteger h = new AtomicInteger(2);
  private long i;
  private long j;
  
  public ExpandResourceDownloader(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString1, @NonNull String paramString2, @NonNull ExpandResourceDownloader.ResourceDownloaderListener paramResourceDownloaderListener)
  {
    this.a = paramQQAppInterface;
    this.b = ((IPreDownloadController)this.a.getRuntimeService(IPreDownloadController.class));
    this.d = paramString1;
    this.e = paramString2;
    this.c = paramResourceDownloaderListener;
    a(LocalStorageUtils.a().getString("expand_flutter_res_files", "[]"));
    if (QLog.isColorLevel()) {
      QLog.d("ExpandResourceDownloader", 2, String.format("ExpandResourceDownloader() url=%s md5=%s", new Object[] { paramString1, paramString2 }));
    }
  }
  
  private void a(int paramInt, String paramString1, long paramLong, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", String.valueOf(paramInt));
    localHashMap.put("version", paramString1);
    localHashMap.put("time_cost", String.valueOf(paramLong));
    localHashMap.put("error_msg", paramString2);
    localHashMap.put("total_length", String.valueOf(this.j));
    localHashMap.put("download_length", String.valueOf(this.i));
    paramString1 = new StringBuilder();
    paramString1.append(NetworkState.g().getNetworkType());
    paramString1.append("");
    localHashMap.put("param_NetworkInfo", paramString1.toString());
    if (QLog.isColorLevel()) {
      QLog.d("ExpandResourceDownloader", 2, String.format("resourceDownloadReport=%s", new Object[] { localHashMap.toString() }));
    }
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expand_quality#succ_rate#resource_download", true, -1L, -1L, localHashMap, true, true);
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = new JsonParser().parse(paramString).getAsJsonArray();
      int m = paramString.size();
      int k = 0;
      while (k < m)
      {
        String str = paramString.get(k).getAsJsonObject().getAsJsonPrimitive("filename").getAsString();
        long l = paramString.get(k).getAsJsonObject().getAsJsonPrimitive("size").getAsLong();
        this.f.put(str, Long.valueOf(l));
        k += 1;
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
    boolean bool3 = new File(paramString1).exists();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
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
    Object localObject = c(paramString);
    HttpEngineTask.IHttpEngineTask localIHttpEngineTask = f();
    localObject = new HttpEngineTask(this.a, this.e, localIHttpEngineTask, (HttpNetReq)localObject);
    this.b.requestPreDownload(10073, "prd", this.e, 0, this.d, paramString, 2, 0, false, (AbsPreDownloadTask)localObject);
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new ArrayList();
      FileUtils.uncompressZip(paramString1, paramString2, false, null, (List)localObject);
      paramString1 = new JsonArray(((ArrayList)localObject).size());
      int k = new File(paramString2).getAbsolutePath().length();
      paramString2 = ((ArrayList)localObject).iterator();
      while (paramString2.hasNext())
      {
        localObject = (File)paramString2.next();
        JsonObject localJsonObject = new JsonObject();
        localJsonObject.addProperty("filename", ((File)localObject).getAbsolutePath().substring(k + 1));
        localJsonObject.addProperty("size", Long.valueOf(((File)localObject).length()));
        paramString1.add(localJsonObject);
      }
      paramString1 = paramString1.toString();
      paramString2 = new StringBuilder();
      paramString2.append("unzipResource save sp.... ");
      paramString2.append(paramString1);
      QLog.d("ExpandResourceDownloader", 1, paramString2.toString());
      a(paramString1);
      LocalStorageUtils.a().edit().putString("expand_flutter_res_files", paramString1).apply();
      return true;
    }
    catch (Exception paramString1)
    {
      QLog.e("ExpandResourceDownloader", 1, "unzipResource fail.", paramString1);
    }
    return false;
  }
  
  @NotNull
  private HttpNetReq c(String paramString)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new ExpandResourceDownloader.2(this);
    localHttpNetReq.mReqUrl = this.d;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramString;
    localHttpNetReq.mPrioty = 0;
    localHttpNetReq.mSupportBreakResume = true;
    return localHttpNetReq;
  }
  
  private void d(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private String e(String paramString)
  {
    return ExpandResourceUtil.b(paramString);
  }
  
  @NotNull
  private HttpEngineTask.IHttpEngineTask f()
  {
    return new ExpandResourceDownloader.1(this);
  }
  
  private boolean g()
  {
    if (!TextUtils.isEmpty(this.e)) {
      return a(e(this.e), this.e);
    }
    return false;
  }
  
  private boolean h()
  {
    return (!TextUtils.isEmpty(this.e)) && (i());
  }
  
  private boolean i()
  {
    Object localObject = j();
    if (this.f.size() > 0)
    {
      Iterator localIterator = new ArrayList(this.f.entrySet()).iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        File localFile = new File((String)localObject, (String)localEntry.getKey());
        if ((!localFile.exists()) || (localFile.length() != ((Long)localEntry.getValue()).longValue()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("validateFiles() warning file ");
          ((StringBuilder)localObject).append((String)localEntry.getKey());
          ((StringBuilder)localObject).append(" size not match! ");
          ((StringBuilder)localObject).append(localEntry.getValue());
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(localFile.length());
          QLog.w("ExpandResourceDownloader", 1, ((StringBuilder)localObject).toString());
          return false;
        }
      }
      QLog.d("ExpandResourceDownloader", 1, "validateFiles() all file matched size!");
      return true;
    }
    QLog.w("ExpandResourceDownloader", 1, "validateFiles() warning file list is empty, no file exists!");
    return false;
  }
  
  private String j()
  {
    return ExpandResourceUtil.b();
  }
  
  public boolean a()
  {
    boolean bool1 = g();
    boolean bool2 = h();
    if (QLog.isColorLevel()) {
      QLog.d("ExpandResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    return (bool1) && (bool2);
  }
  
  public void b()
  {
    if ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExpandResourceDownloader", 2, String.format("checkResourceReady download=%s unzipped=%s", new Object[] { this.d, this.e }));
      }
      Object localObject = e(this.e);
      if (!ExpandFileUtils.a((String)localObject, this.e))
      {
        if (this.h.compareAndSet(2, 3))
        {
          d((String)localObject);
          b((String)localObject);
        }
      }
      else
      {
        boolean bool2 = h();
        boolean bool1 = bool2;
        if (!bool2)
        {
          bool2 = b((String)localObject, j());
          boolean bool3 = h();
          if ((bool2) && (bool3)) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ExpandResourceDownloader", 2, String.format("downloadResource unzip unzipDone=%s unzipped=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3) }));
          }
          ExtendFriendReport.a().b(bool1, bool3 ^ true);
        }
        localObject = this.c;
        if (localObject != null) {
          ((ExpandResourceDownloader.ResourceDownloaderListener)localObject).a(bool1);
        }
      }
      return;
    }
    QLog.e("ExpandResourceDownloader", 1, "downloadResource invalid parameters.");
  }
  
  public void c()
  {
    if (!TextUtils.isEmpty(this.d)) {
      this.b.cancelPreDownload(this.d);
    }
  }
  
  public String d()
  {
    if (a())
    {
      String str = j();
      if (QLog.isColorLevel()) {
        QLog.d("ExpandResourceDownloader", 2, String.format("getUnzipValidResourcePath=%s", new Object[] { str }));
      }
      return str;
    }
    return "";
  }
  
  public void e()
  {
    if ((!a()) && (this.h.get() != 3))
    {
      QLog.d("ExpandResourceDownloader", 1, String.format("current downLoad status is %s, redownload resource!", new Object[] { this.h }));
      this.h.set(2);
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.downloader.ExpandResourceDownloader
 * JD-Core Version:    0.7.0.1
 */