package com.tencent.tmdownloader.internal.downloadservice;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.common.HalleyException;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public String A = "";
  public String B = "";
  public int C = 0;
  public String D = "";
  public String E = "";
  public String F = "";
  public boolean G = false;
  public boolean H = false;
  public int I = 0;
  public long J;
  public String K;
  public int L = 0;
  final Object M = new Object();
  public DownloaderTaskListener N = new d(this);
  public String a;
  public String b;
  public String c;
  public String d;
  boolean e;
  public int f;
  public int g;
  public long h;
  public long i;
  public String j;
  protected String k;
  public int l;
  public int m;
  public String n;
  public long o;
  protected HashMap<String, String> p;
  protected String q;
  public long r = 0L;
  public String s = "";
  public String t = "";
  public long u = 0L;
  public long v = 0L;
  public long w = 0L;
  public String x = "";
  public String y = "";
  public String z = "";
  
  public c()
  {
    this.e = false;
  }
  
  public c(String paramString1, int paramInt, String paramString2)
  {
    this.b = paramString1;
    this.c = b.a(paramString1);
    this.d = UUID.randomUUID().toString();
    this.l = paramInt;
    this.g = 0;
    this.m = 0;
    this.e = false;
    this.a = paramString2;
    this.n = b.a();
    this.o = 0L;
  }
  
  public static c a(Cursor paramCursor)
  {
    c localc = new c();
    localc.f = paramCursor.getInt(paramCursor.getColumnIndex("taskId"));
    localc.d = paramCursor.getString(paramCursor.getColumnIndex("uId"));
    localc.c = paramCursor.getString(paramCursor.getColumnIndex("finalUrl"));
    localc.b = paramCursor.getString(paramCursor.getColumnIndex("taskUrl"));
    localc.K = paramCursor.getString(paramCursor.getColumnIndex("bakUrl"));
    localc.j = paramCursor.getString(paramCursor.getColumnIndex("fileName"));
    localc.a = paramCursor.getString(paramCursor.getColumnIndex("contentType"));
    localc.i = paramCursor.getLong(paramCursor.getColumnIndex("totalBytes"));
    localc.g = paramCursor.getInt(paramCursor.getColumnIndex("status"));
    localc.h = paramCursor.getLong(paramCursor.getColumnIndex("receivedBytes"));
    localc.l = paramCursor.getInt(paramCursor.getColumnIndex("priority"));
    localc.n = paramCursor.getString(paramCursor.getColumnIndex("netType"));
    localc.m = paramCursor.getInt(paramCursor.getColumnIndex("downloadFailedErrCode"));
    localc.o = paramCursor.getLong(paramCursor.getColumnIndex("downloadFailedTime"));
    localc.q = paramCursor.getString(paramCursor.getColumnIndex("headerParams"));
    localc.r = paramCursor.getLong(paramCursor.getColumnIndex("appId"));
    localc.s = paramCursor.getString(paramCursor.getColumnIndex("taskPakcageName"));
    localc.t = paramCursor.getString(paramCursor.getColumnIndex("taskVersioncode"));
    localc.u = paramCursor.getLong(paramCursor.getColumnIndex("startTime"));
    localc.v = paramCursor.getLong(paramCursor.getColumnIndex("endTime"));
    localc.C = paramCursor.getInt(paramCursor.getColumnIndex("downloadType"));
    localc.w = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
    localc.x = paramCursor.getString(paramCursor.getColumnIndex("uintype"));
    localc.y = paramCursor.getString(paramCursor.getColumnIndex("via"));
    localc.z = paramCursor.getString(paramCursor.getColumnIndex("channelId"));
    localc.A = paramCursor.getString(paramCursor.getColumnIndex("traceId"));
    localc.B = paramCursor.getString(paramCursor.getColumnIndex("extraData"));
    localc.E = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
    localc.F = paramCursor.getString(paramCursor.getColumnIndex("appName"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("isAutoInstallBySDK")) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localc.G = bool;
      localc.J = paramCursor.getLong(paramCursor.getColumnIndex("fileSize"));
      return localc;
    }
  }
  
  public static void a(ContentValues paramContentValues, c paramc)
  {
    if ((paramc != null) && (paramContentValues != null))
    {
      paramContentValues.put("taskId", Integer.valueOf(paramc.f));
      paramContentValues.put("uId", paramc.d);
      paramContentValues.put("finalUrl", paramc.c);
      paramContentValues.put("taskUrl", paramc.b);
      paramContentValues.put("bakUrl", paramc.K);
      paramContentValues.put("fileName", paramc.j);
      paramContentValues.put("contentType", paramc.a);
      paramContentValues.put("totalBytes", Long.valueOf(paramc.i));
      paramContentValues.put("status", Integer.valueOf(paramc.g));
      paramContentValues.put("receivedBytes", Long.valueOf(paramc.h));
      paramContentValues.put("priority", Integer.valueOf(paramc.l));
      paramContentValues.put("netType", paramc.n);
      paramContentValues.put("downloadFailedErrCode", Integer.valueOf(paramc.m));
      paramContentValues.put("downloadFailedTime", Long.valueOf(paramc.o));
      paramContentValues.put("headerParams", paramc.q);
      paramContentValues.put("appId", Long.valueOf(paramc.r));
      paramContentValues.put("taskPakcageName", paramc.s);
      paramContentValues.put("taskVersioncode", paramc.t);
      paramContentValues.put("startTime", Long.valueOf(paramc.u));
      paramContentValues.put("endTime", Long.valueOf(paramc.v));
      paramContentValues.put("downloadType", Integer.valueOf(paramc.C));
      paramContentValues.put("uin", Long.valueOf(paramc.w));
      paramContentValues.put("uintype", paramc.x);
      paramContentValues.put("via", paramc.y);
      paramContentValues.put("channelId", paramc.z);
      paramContentValues.put("traceId", paramc.A);
      paramContentValues.put("extraData", paramc.B);
      paramContentValues.put("iconUrl", paramc.E);
      paramContentValues.put("appName", paramc.F);
      if (!paramc.G) {
        break label367;
      }
    }
    label367:
    for (int i1 = 1;; i1 = 0)
    {
      paramContentValues.put("isAutoInstallBySDK", Integer.valueOf(i1));
      paramContentValues.put("fileSize", Long.valueOf(paramc.J));
      return;
    }
  }
  
  public static c b(Cursor paramCursor)
  {
    c localc = new c();
    localc.f = paramCursor.getInt(paramCursor.getColumnIndex("taskId"));
    localc.d = paramCursor.getString(paramCursor.getColumnIndex("uId"));
    localc.c = paramCursor.getString(paramCursor.getColumnIndex("finalUrl"));
    localc.b = paramCursor.getString(paramCursor.getColumnIndex("taskUrl"));
    localc.K = paramCursor.getString(paramCursor.getColumnIndex("bakUrl"));
    localc.j = paramCursor.getString(paramCursor.getColumnIndex("fileName"));
    localc.a = paramCursor.getString(paramCursor.getColumnIndex("contentType"));
    localc.i = paramCursor.getLong(paramCursor.getColumnIndex("totalBytes"));
    localc.g = paramCursor.getInt(paramCursor.getColumnIndex("status"));
    localc.h = paramCursor.getLong(paramCursor.getColumnIndex("receivedBytes"));
    localc.l = paramCursor.getInt(paramCursor.getColumnIndex("priority"));
    localc.J = paramCursor.getLong(paramCursor.getColumnIndex("fileSize"));
    localc.n = null;
    localc.m = 0;
    localc.o = 0L;
    localc.q = null;
    return localc;
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        r.c("_DownloadInfo", "halleytest updateStatus status=" + paramInt + ", mStatus = " + this.g);
        boolean bool = b();
        if (bool) {
          return;
        }
        this.g = paramInt;
        if ((this.g != 6) && (this.g != 6))
        {
          if (this.g == 5) {
            this.o = System.currentTimeMillis();
          }
          com.tencent.tmdownloader.internal.storage.a.a().a(this);
          f.a().a(this.b, this.g, this.m, "");
          if ((this.g != 4) || (!this.G)) {
            continue;
          }
          r.c("_DownloadInfo", "Download status is succeed, start to install");
          a.a(com.tencent.tmdownloader.internal.storage.d.a(this.j));
          continue;
        }
        com.tencent.tmdownloader.internal.storage.a.a().a(this.b);
      }
      finally {}
      f.a().a(String.valueOf(this.r));
    }
  }
  
  public void a(int paramInt, DownloaderTask paramDownloaderTask)
  {
    if (paramDownloaderTask == null) {
      r.e("_DownloadInfo", "<downloadReport> task is null ,return");
    }
    long l1 = System.currentTimeMillis() / 1000L;
    String str1 = paramDownloaderTask.getUniqueKey();
    String str2 = paramDownloaderTask.getUrl();
    if (paramDownloaderTask.isPausedOnMobile()) {}
    for (int i1 = 0;; i1 = 1)
    {
      int i2 = paramDownloaderTask.getFailCode();
      if (paramInt != 101) {
        i1 = -1;
      }
      long l2 = paramDownloaderTask.getStartTime();
      long l3 = paramDownloaderTask.getCostTime();
      long l4 = paramDownloaderTask.getTotalLength();
      paramDownloaderTask = l1 + "|" + this.r + "|" + this.t + "|" + this.s + "|" + this.C + "|" + paramInt + "|" + str1 + "|" + str2 + "|" + i1 + "|" + i2 + "|" + l2 + "|" + l3 + "|" + l4 + "|" + this.y;
      r.c("_DownloadInfo", "<downloadReport> reportLog type=8,postReport.data: " + paramDownloaderTask);
      com.tencent.tmassistantbase.util.f.a().post(new e(this, paramDownloaderTask));
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (0L == paramLong) {
      this.h = 0L;
    }
    this.i = paramLong;
    com.tencent.tmdownloader.internal.storage.a.a().a(this);
  }
  
  public void a(String paramString)
  {
    r.c(paramString, "--------dump DownloadInfo-----------");
    r.c(paramString, "mContentType: " + this.a);
    r.c(paramString, "mURL: " + this.b);
    r.c(paramString, "mBakUrl: " + this.K);
    r.c(paramString, "mTotalBytes: " + this.i);
    r.c(paramString, "mUUID: " + this.d);
    r.c(paramString, "mStatus: " + this.g);
    r.c(paramString, "mReceivedBytes: " + this.h);
    r.c(paramString, "mFileName: " + this.j);
    r.c(paramString, "mDownloadFailedErrCode: " + this.m);
    r.c(paramString, "mNetType:" + this.n);
    r.c(paramString, "mDownloadFailedTime:" + this.o);
    r.c(paramString, "mHeaderParamString:" + this.q);
    r.c(paramString, "mAppid:" + this.r + " mpackageName:" + this.s + " mVersioncode:" + this.t + " via:" + this.y);
    r.c(paramString, "mChannelid:" + this.z + " traceId:" + this.A + " extraData:" + this.B + " downloadType:" + this.C + " mIconUrl:" + this.E + " mAppName:" + this.F + " showNotification:" + this.L + " isAutoInstallBySDK:" + this.G);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      this.p = paramHashMap;
      this.q = new JSONObject(paramHashMap).toString();
    }
  }
  
  boolean a()
  {
    return (this.i != 0L) && (this.h == this.i);
  }
  
  public DownloaderTask b(String paramString)
  {
    Object localObject2 = HalleyAgent.getDownloader().getIncompleteTasks();
    synchronized (this.M)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DownloaderTask localDownloaderTask = (DownloaderTask)((Iterator)localObject2).next();
        if (localDownloaderTask.getId().equals(paramString)) {
          return localDownloaderTask;
        }
      }
      return null;
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 0) {
      this.m = paramInt;
    }
    for (;;)
    {
      r.e("_DownloadInfo", "halleytest convertHalleyFailCodeToDownloadFailedErrCode halley failCode = " + paramInt + ",mDownloadFailedErrCode = " + this.m);
      return;
      if (paramInt == -23) {
        this.m = 601;
      } else if (paramInt == -25) {
        this.m = 602;
      } else if (paramInt == -29) {
        this.m = 603;
      } else if (paramInt == -26) {
        this.m = 605;
      } else if (paramInt == -27) {
        this.m = 606;
      } else if (paramInt == -51) {
        this.m = 700;
      } else if (paramInt == -41) {
        this.m = 701;
      } else if (paramInt == -58) {
        this.m = 702;
      } else if ((paramInt == -14) || (paramInt == -47) || (paramInt == -49) || (paramInt == -50) || (paramInt == -72)) {
        this.m = 703;
      } else if (paramInt == -11) {
        this.m = 704;
      } else if (paramInt == -43) {
        this.m = 705;
      } else if (paramInt == -42) {
        this.m = 706;
      } else if ((paramInt == -53) || (paramInt == -65) || (paramInt == -59)) {
        this.m = 707;
      } else if (paramInt == -57) {
        this.m = 709;
      } else if ((paramInt == -12) || (paramInt == -40)) {
        this.m = 710;
      } else if ((paramInt == -13) || (paramInt == -46)) {
        this.m = 711;
      } else if (paramInt == -15) {
        this.m = 605;
      } else if (paramInt == -10) {
        this.m = 712;
      } else {
        this.m = 604;
      }
    }
  }
  
  public void b(long paramLong)
  {
    this.h = paramLong;
    f.a().a(this.b, this.h, this.i);
  }
  
  boolean b()
  {
    return (this.g > 3) && (this.g != 6) && (this.g != 5);
  }
  
  public int c()
  {
    r.c("_DownloadInfo", "url: " + this.b);
    Object localObject2;
    Object localObject3;
    if ((!TextUtils.isEmpty(this.q)) && ((this.p == null) || (this.p.size() <= 0)))
    {
      HashMap localHashMap = new HashMap();
      try
      {
        localObject2 = new JSONObject(this.q);
        localObject3 = ((JSONObject)localObject2).keys();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          localHashMap.put(str, ((JSONObject)localObject2).getString(str));
          continue;
          if (!this.e) {
            break label162;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        r.b("_DownloadInfo", "exception: ", localJSONException);
        localJSONException.printStackTrace();
      }
    }
    for (;;)
    {
      return 5;
      if (localJSONException.size() > 0) {
        this.p = localJSONException;
      }
    }
    label162:
    label224:
    long l1;
    if (this.j == null)
    {
      if ("application/vnd.android.package-archive".equals(this.a)) {
        this.j = b.b(this.b);
      }
    }
    else
    {
      if (this.k == null)
      {
        if (!"application/vnd.android.package-archive".equals(this.a)) {
          break label391;
        }
        this.k = b.b(this.b);
      }
      if (this.i == 0L) {
        new com.tencent.tmdownloader.internal.storage.d(this.k, this.j).b();
      }
      if (this.g == 5) {
        this.c = this.b;
      }
      if (TextUtils.isEmpty(this.j)) {
        break label417;
      }
      localObject1 = new com.tencent.tmdownloader.internal.storage.d(this.k, this.j);
      l1 = ((com.tencent.tmdownloader.internal.storage.d)localObject1).c();
      r.c("_DownloadInfo", "FileLen: " + l1 + " filename: " + this.j);
      if (l1 <= this.i) {
        break label409;
      }
      ((com.tencent.tmdownloader.internal.storage.d)localObject1).b();
    }
    label391:
    label409:
    for (this.h = 0L;; this.h = l1)
    {
      if (!a()) {
        break label417;
      }
      ((com.tencent.tmdownloader.internal.storage.d)localObject1).e();
      a(4);
      return 4;
      this.j = b.a(this.b, this.a);
      break;
      this.k = b.a(this.b, this.a);
      break label224;
    }
    label417:
    if (this.g == 5)
    {
      this.g = 0;
      this.m = 0;
    }
    r.c("_DownloadInfo", "startDownloadIfReady...");
    a("_DownloadInfo");
    Object localObject1 = b(this.b);
    if (localObject1 != null)
    {
      r.c("_DownloadInfo", "halleyTest getIncompleteTask dt = " + localObject1 + ",download %=" + ((DownloaderTask)localObject1).getPercentage());
      r.c("_DownloadInfo", "halleyTest getIncompleteTask dt = " + localObject1 + ",download length=" + ((DownloaderTask)localObject1).getReceivedLength());
      if (localObject1 != null) {
        break label1012;
      }
    }
    for (;;)
    {
      try
      {
        r.c("_DownloadInfo", "mFileSize = " + this.J);
        if (this.J <= 0L) {
          continue;
        }
        localObject1 = HalleyAgent.getDownloader().createNewTask(0, this.b, this.b, com.tencent.tmdownloader.internal.storage.d.b(this.j), this.j, this.N, this.J);
        ((DownloaderTask)localObject1).setAppId(this.r + "");
        ((DownloaderTask)localObject1).setPauseTaskOnMobile(false);
        if ((this.y != null) && (!TextUtils.isEmpty(this.y)) && (this.y.contains("ANDROIDQQ.GAME.DETAIL")))
        {
          localObject2 = GlobalUtil.getInstance().getModel();
          localObject3 = GlobalUtil.getInstance().getBrand();
          localObject2 = "_" + (String)localObject3 + "_" + (String)localObject2;
          HalleyAgent.getDownloader().setQua1(this.y + (String)localObject2);
        }
        if ((this.y == null) || (TextUtils.isEmpty(this.y))) {
          continue;
        }
        ((DownloaderTask)localObject1).setAppScene(this.y);
        ((DownloaderTask)localObject1).setCategory(DownloaderTaskCategory.Cate_DefaultMass);
        a(1);
        HalleyAgent.getDownloader().addNewTask((DownloaderTask)localObject1);
        a(100, (DownloaderTask)localObject1);
        r.c("_DownloadInfo", "halleyTest createNewTask mURL=" + this.b + ",saveFilePath=" + com.tencent.tmdownloader.internal.storage.d.a(this.j) + ",fileName=" + this.j);
      }
      catch (Exception localException)
      {
        r.c("_DownloadInfo", "startDownloadIfReady HalleyAgent createNewTask Exception", localException);
        continue;
      }
      return 0;
      localObject2 = c(this.b);
      if (localObject2 == null) {
        break;
      }
      localObject2 = new File(((DownloaderTask)localObject2).getRealSaveName());
      if ((b.b(this.b, this.a)) || (((File)localObject2).exists())) {
        break;
      }
      f();
      break;
      localObject1 = HalleyAgent.getDownloader().createNewTask(this.I, this.b, this.b, com.tencent.tmdownloader.internal.storage.d.b(this.j), this.j, this.N);
      continue;
      ((DownloaderTask)localObject1).setCategory(DownloaderTaskCategory.Cate_DefaultEase);
      continue;
      try
      {
        label1012:
        localException.setPauseTaskOnMobile(false);
        a(1);
        localException.resume();
      }
      catch (HalleyException localHalleyException)
      {
        localHalleyException.printStackTrace();
      }
    }
  }
  
  public DownloaderTask c(String paramString)
  {
    Object localObject2 = HalleyAgent.getDownloader().getAllTasks();
    synchronized (this.M)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DownloaderTask localDownloaderTask = (DownloaderTask)((Iterator)localObject2).next();
        if (localDownloaderTask.getId().equals(paramString)) {
          return localDownloaderTask;
        }
      }
      return null;
    }
  }
  
  public void d()
  {
    r.c("_DownloadInfo", "DownloadInfo::pauseDownload url: " + this.b);
    DownloaderTask localDownloaderTask = b(this.b);
    if (localDownloaderTask != null)
    {
      localDownloaderTask.pause();
      a(3);
      return;
    }
    r.d("_DownloadInfo", "DownloadInfo::pauseDownload task == null");
  }
  
  public void e()
  {
    r.c("_DownloadInfo", "DownloadInfo::stopDownload url: " + this.b);
    DownloaderTask localDownloaderTask = b(this.b);
    if (localDownloaderTask != null)
    {
      HalleyAgent.getDownloader().deleteTask(localDownloaderTask, false);
      a(6);
      return;
    }
    r.d("_DownloadInfo", "DownloadInfo::stopDownload task == null");
  }
  
  public void f()
  {
    r.c("_DownloadInfo", "DownloadInfo::deleteDownload url: " + this.b + ",mFileName: " + this.j);
    DownloaderTask localDownloaderTask = c(this.b);
    String str = localDownloaderTask.getRealSaveName();
    Object localObject = com.tencent.tmdownloader.internal.storage.d.a(str);
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if ((localObject != null) && (((File)localObject).exists())) {
        ((File)localObject).delete();
      }
    }
    if ((this.j != null) && (str != this.j)) {
      new com.tencent.tmdownloader.internal.storage.d(this.k, this.j).a();
    }
    HalleyAgent.getDownloader().deleteTask(localDownloaderTask, true);
    a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.c
 * JD-Core Version:    0.7.0.1
 */