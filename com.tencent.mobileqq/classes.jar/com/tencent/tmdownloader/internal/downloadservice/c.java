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
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmdownloader.notify.DownloadTaskInfo;
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
  public int B = 0;
  public String C = "";
  public String D = "";
  public String E = "";
  public boolean F = false;
  public boolean G = false;
  public int H = 0;
  public long I;
  public String J;
  public int K = 0;
  public String L;
  public String M;
  final Object N = new Object();
  public DownloaderTaskListener O = new d(this);
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
  public int k;
  public int l;
  public String m;
  public long n;
  protected HashMap<String, String> o;
  protected String p;
  public long q = 0L;
  public String r = "";
  public String s = "";
  public long t = 0L;
  public long u = 0L;
  public long v = 0L;
  public String w = "";
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
    this.k = paramInt;
    this.g = 0;
    this.l = 0;
    this.e = false;
    this.a = paramString2;
    this.m = b.a();
    this.n = 0L;
  }
  
  public static c a(Cursor paramCursor)
  {
    c localc = new c();
    localc.f = paramCursor.getInt(paramCursor.getColumnIndex("taskId"));
    localc.d = paramCursor.getString(paramCursor.getColumnIndex("uId"));
    localc.c = paramCursor.getString(paramCursor.getColumnIndex("finalUrl"));
    localc.b = paramCursor.getString(paramCursor.getColumnIndex("taskUrl"));
    localc.J = paramCursor.getString(paramCursor.getColumnIndex("bakUrl"));
    localc.j = paramCursor.getString(paramCursor.getColumnIndex("fileName"));
    localc.a = paramCursor.getString(paramCursor.getColumnIndex("contentType"));
    localc.i = paramCursor.getLong(paramCursor.getColumnIndex("totalBytes"));
    localc.g = paramCursor.getInt(paramCursor.getColumnIndex("status"));
    localc.h = paramCursor.getLong(paramCursor.getColumnIndex("receivedBytes"));
    localc.k = paramCursor.getInt(paramCursor.getColumnIndex("priority"));
    localc.m = paramCursor.getString(paramCursor.getColumnIndex("netType"));
    localc.l = paramCursor.getInt(paramCursor.getColumnIndex("downloadFailedErrCode"));
    localc.n = paramCursor.getLong(paramCursor.getColumnIndex("downloadFailedTime"));
    localc.p = paramCursor.getString(paramCursor.getColumnIndex("headerParams"));
    localc.q = paramCursor.getLong(paramCursor.getColumnIndex("appId"));
    localc.r = paramCursor.getString(paramCursor.getColumnIndex("taskPakcageName"));
    localc.s = paramCursor.getString(paramCursor.getColumnIndex("taskVersioncode"));
    localc.t = paramCursor.getLong(paramCursor.getColumnIndex("startTime"));
    localc.u = paramCursor.getLong(paramCursor.getColumnIndex("endTime"));
    localc.B = paramCursor.getInt(paramCursor.getColumnIndex("downloadType"));
    localc.v = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
    localc.w = paramCursor.getString(paramCursor.getColumnIndex("uintype"));
    localc.x = paramCursor.getString(paramCursor.getColumnIndex("via"));
    localc.y = paramCursor.getString(paramCursor.getColumnIndex("channelId"));
    localc.z = paramCursor.getString(paramCursor.getColumnIndex("traceId"));
    localc.A = paramCursor.getString(paramCursor.getColumnIndex("extraData"));
    localc.D = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
    localc.E = paramCursor.getString(paramCursor.getColumnIndex("appName"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("isAutoInstallBySDK")) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localc.F = bool;
      localc.I = paramCursor.getLong(paramCursor.getColumnIndex("fileSize"));
      return localc;
    }
  }
  
  private DownloadTaskInfo a(DownloaderTask paramDownloaderTask)
  {
    DownloadTaskInfo localDownloadTaskInfo = new DownloadTaskInfo();
    localDownloadTaskInfo.url = paramDownloaderTask.getUrl();
    localDownloadTaskInfo.pkgName = this.r;
    localDownloadTaskInfo.source = this.L;
    try
    {
      localDownloadTaskInfo.versionCode = Integer.parseInt(this.s);
      localDownloadTaskInfo.stackInfo = this.M;
      return localDownloadTaskInfo;
    }
    catch (Throwable paramDownloaderTask)
    {
      for (;;)
      {
        ab.a("_DownloadInfo", ">buildInfo parseInt error!", paramDownloaderTask);
      }
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
      paramContentValues.put("bakUrl", paramc.J);
      paramContentValues.put("fileName", paramc.j);
      paramContentValues.put("contentType", paramc.a);
      paramContentValues.put("totalBytes", Long.valueOf(paramc.i));
      paramContentValues.put("status", Integer.valueOf(paramc.g));
      paramContentValues.put("receivedBytes", Long.valueOf(paramc.h));
      paramContentValues.put("priority", Integer.valueOf(paramc.k));
      paramContentValues.put("netType", paramc.m);
      paramContentValues.put("downloadFailedErrCode", Integer.valueOf(paramc.l));
      paramContentValues.put("downloadFailedTime", Long.valueOf(paramc.n));
      paramContentValues.put("headerParams", paramc.p);
      paramContentValues.put("appId", Long.valueOf(paramc.q));
      paramContentValues.put("taskPakcageName", paramc.r);
      paramContentValues.put("taskVersioncode", paramc.s);
      paramContentValues.put("startTime", Long.valueOf(paramc.t));
      paramContentValues.put("endTime", Long.valueOf(paramc.u));
      paramContentValues.put("downloadType", Integer.valueOf(paramc.B));
      paramContentValues.put("uin", Long.valueOf(paramc.v));
      paramContentValues.put("uintype", paramc.w);
      paramContentValues.put("via", paramc.x);
      paramContentValues.put("channelId", paramc.y);
      paramContentValues.put("traceId", paramc.z);
      paramContentValues.put("extraData", paramc.A);
      paramContentValues.put("iconUrl", paramc.D);
      paramContentValues.put("appName", paramc.E);
      if (!paramc.F) {
        break label367;
      }
    }
    label367:
    for (int i1 = 1;; i1 = 0)
    {
      paramContentValues.put("isAutoInstallBySDK", Integer.valueOf(i1));
      paramContentValues.put("fileSize", Long.valueOf(paramc.I));
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
    localc.J = paramCursor.getString(paramCursor.getColumnIndex("bakUrl"));
    localc.j = paramCursor.getString(paramCursor.getColumnIndex("fileName"));
    localc.a = paramCursor.getString(paramCursor.getColumnIndex("contentType"));
    localc.i = paramCursor.getLong(paramCursor.getColumnIndex("totalBytes"));
    localc.g = paramCursor.getInt(paramCursor.getColumnIndex("status"));
    localc.h = paramCursor.getLong(paramCursor.getColumnIndex("receivedBytes"));
    localc.k = paramCursor.getInt(paramCursor.getColumnIndex("priority"));
    localc.I = paramCursor.getLong(paramCursor.getColumnIndex("fileSize"));
    localc.m = null;
    localc.l = 0;
    localc.n = 0L;
    localc.p = null;
    return localc;
  }
  
  private boolean d(String paramString)
  {
    Object localObject = HalleyAgent.getDownloader().getAllTasks();
    ab.e("_DownloadInfo", "isSavePathExisted " + paramString + ",taskList=" + localObject);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DownloaderTask localDownloaderTask = (DownloaderTask)((Iterator)localObject).next();
      if ((TextUtils.equals(localDownloaderTask.getSavePath(), paramString)) && (!TextUtils.equals(localDownloaderTask.getUrl(), this.b)))
      {
        ab.e("_DownloadInfo", "Task " + localDownloaderTask.getUrl() + " has same path:" + paramString);
        return true;
      }
    }
    return false;
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        ab.c("_DownloadInfo", "halleytest updateStatus status=" + paramInt + ", mStatus = " + this.g);
        boolean bool = b();
        if (bool) {
          return;
        }
        this.g = paramInt;
        if ((this.g != 6) && (this.g != 6))
        {
          if (this.g == 5) {
            this.n = System.currentTimeMillis();
          }
          com.tencent.tmdownloader.internal.storage.a.a().a(this);
          f.a().a(this.b, this.g, this.l, "");
          if ((this.g != 4) || (!this.F)) {
            continue;
          }
          ab.c("_DownloadInfo", "Download status is succeed, start to install");
          a.a(com.tencent.tmdownloader.internal.storage.d.a(this.j));
          continue;
        }
        com.tencent.tmdownloader.internal.storage.a.a().a(this.b);
      }
      finally {}
      f.a().a(String.valueOf(this.q));
    }
  }
  
  public void a(int paramInt, DownloaderTask paramDownloaderTask)
  {
    if (paramDownloaderTask == null) {
      ab.e("_DownloadInfo", "<downloadReport> task is null ,return");
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
      paramDownloaderTask = l1 + "|" + this.q + "|" + this.s + "|" + this.r + "|" + this.B + "|" + paramInt + "|" + str1 + "|" + str2 + "|" + i1 + "|" + i2 + "|" + l2 + "|" + l3 + "|" + l4 + "|" + this.x;
      ab.c("_DownloadInfo", "<downloadReport> reportLog type=8,postReport.data: " + paramDownloaderTask);
      k.a().post(new e(this, paramDownloaderTask));
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
    ab.c(paramString, "--------dump DownloadInfo-----------");
    ab.c(paramString, "mContentType: " + this.a);
    ab.c(paramString, "mURL: " + this.b);
    ab.c(paramString, "mBakUrl: " + this.J);
    ab.c(paramString, "mTotalBytes: " + this.i);
    ab.c(paramString, "mUUID: " + this.d);
    ab.c(paramString, "mStatus: " + this.g);
    ab.c(paramString, "mReceivedBytes: " + this.h);
    ab.c(paramString, "mFileName: " + this.j);
    ab.c(paramString, "mDownloadFailedErrCode: " + this.l);
    ab.c(paramString, "mNetType:" + this.m);
    ab.c(paramString, "mDownloadFailedTime:" + this.n);
    ab.c(paramString, "mHeaderParamString:" + this.p);
    ab.c(paramString, "mAppid:" + this.q + " mpackageName:" + this.r + " mVersioncode:" + this.s + " via:" + this.x);
    ab.c(paramString, "mChannelid:" + this.y + " traceId:" + this.z + " extraData:" + this.A + " downloadType:" + this.B + " mIconUrl:" + this.D + " mAppName:" + this.E + " showNotification:" + this.K + " isAutoInstallBySDK:" + this.F);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      this.o = paramHashMap;
      this.p = new JSONObject(paramHashMap).toString();
    }
  }
  
  boolean a()
  {
    return (this.i != 0L) && (this.h == this.i);
  }
  
  public DownloaderTask b(String paramString)
  {
    Object localObject2 = HalleyAgent.getDownloader().getIncompleteTasks();
    synchronized (this.N)
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
      this.l = paramInt;
    }
    for (;;)
    {
      ab.e("_DownloadInfo", "halleytest convertHalleyFailCodeToDownloadFailedErrCode halley failCode = " + paramInt + ",mDownloadFailedErrCode = " + this.l);
      return;
      if (paramInt == -23) {
        this.l = 601;
      } else if (paramInt == -25) {
        this.l = 602;
      } else if (paramInt == -29) {
        this.l = 603;
      } else if (paramInt == -26) {
        this.l = 605;
      } else if (paramInt == -27) {
        this.l = 606;
      } else if (paramInt == -51) {
        this.l = 700;
      } else if (paramInt == -41) {
        this.l = 701;
      } else if (paramInt == -58) {
        this.l = 702;
      } else if ((paramInt == -14) || (paramInt == -47) || (paramInt == -49) || (paramInt == -50) || (paramInt == -72)) {
        this.l = 703;
      } else if (paramInt == -11) {
        this.l = 704;
      } else if (paramInt == -43) {
        this.l = 705;
      } else if (paramInt == -42) {
        this.l = 706;
      } else if ((paramInt == -53) || (paramInt == -65) || (paramInt == -59)) {
        this.l = 707;
      } else if (paramInt == -57) {
        this.l = 709;
      } else if ((paramInt == -12) || (paramInt == -40)) {
        this.l = 710;
      } else if ((paramInt == -13) || (paramInt == -46)) {
        this.l = 711;
      } else if (paramInt == -15) {
        this.l = 605;
      } else if (paramInt == -10) {
        this.l = 712;
      } else {
        this.l = 604;
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
    ab.c("_DownloadInfo", "url: " + this.b);
    Object localObject1;
    Object localObject2;
    if ((!TextUtils.isEmpty(this.p)) && ((this.o == null) || (this.o.size() <= 0)))
    {
      HashMap localHashMap = new HashMap();
      try
      {
        localObject1 = new JSONObject(this.p);
        localObject2 = ((JSONObject)localObject1).keys();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localHashMap.put(str, ((JSONObject)localObject1).getString(str));
          continue;
          if (!this.e) {
            break label156;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        ab.b("_DownloadInfo", "exception: ", localJSONException);
        localJSONException.printStackTrace();
      }
    }
    for (;;)
    {
      return 5;
      if (localJSONException.size() > 0) {
        this.o = localJSONException;
      }
    }
    label156:
    DownloaderTask localDownloaderTask;
    if (this.j == null)
    {
      if ("application/vnd.android.package-archive".equals(this.a)) {
        this.j = b.b(this.b);
      }
    }
    else
    {
      if (this.g == 5) {
        this.c = this.b;
      }
      if (this.g == 5)
      {
        this.g = 0;
        this.l = 0;
      }
      ab.c("_DownloadInfo", "startDownloadIfReady...");
      a("_DownloadInfo");
      localDownloaderTask = b(this.b);
      if (localDownloaderTask == null) {
        break label798;
      }
      ab.c("_DownloadInfo", "halleyTest getIncompleteTask dt = " + localDownloaderTask + ",download %=" + localDownloaderTask.getPercentage());
      ab.c("_DownloadInfo", "halleyTest getIncompleteTask dt = " + localDownloaderTask + ",download length=" + localDownloaderTask.getReceivedLength());
      label332:
      if (localDownloaderTask != null) {
        break label918;
      }
    }
    for (;;)
    {
      try
      {
        ab.c("_DownloadInfo", "mFileSize = " + this.I);
        ab.c("_DownloadInfo", "mFileNameB = " + this.j);
        if (d(com.tencent.tmdownloader.internal.storage.d.b(this.j) + File.separator + this.j)) {
          this.j = b.a(this.b, this.a);
        }
        ab.c("_DownloadInfo", "mFileNameA = " + this.j);
        if (this.I <= 0L) {
          continue;
        }
        localDownloaderTask = HalleyAgent.getDownloader().createNewTask(0, this.b, this.b, com.tencent.tmdownloader.internal.storage.d.b(this.j), this.j, this.O, this.I);
        localDownloaderTask.setAppId(this.q + "");
        localDownloaderTask.setPauseTaskOnMobile(false);
        if ((this.x != null) && (!TextUtils.isEmpty(this.x)) && (this.x.contains("ANDROIDQQ.GAME.DETAIL")))
        {
          localObject1 = GlobalUtil.getInstance().getModel();
          localObject2 = GlobalUtil.getInstance().getBrand();
          localObject1 = "_" + (String)localObject2 + "_" + (String)localObject1;
          HalleyAgent.getDownloader().setQua1(this.x + (String)localObject1);
        }
        if ((this.x == null) || (TextUtils.isEmpty(this.x))) {
          continue;
        }
        localDownloaderTask.setAppScene(this.x);
        localDownloaderTask.setCategory(DownloaderTaskCategory.Cate_DefaultMass);
        a(1);
        HalleyAgent.getDownloader().addNewTask(localDownloaderTask);
        a(100, localDownloaderTask);
        ab.c("_DownloadInfo", "halleyTest createNewTask mURL=" + this.b + ",saveFilePath=" + com.tencent.tmdownloader.internal.storage.d.a(this.j) + ",fileName=" + this.j);
      }
      catch (Exception localException)
      {
        label798:
        ab.c("_DownloadInfo", "startDownloadIfReady HalleyAgent createNewTask Exception", localException);
        continue;
      }
      return 0;
      this.j = b.a(this.b, this.a);
      break;
      localObject1 = c(this.b);
      if (localObject1 == null) {
        break label332;
      }
      localObject1 = new File(((DownloaderTask)localObject1).getRealSaveName());
      if ((b.b(this.b, this.a)) || (((File)localObject1).exists())) {
        break label332;
      }
      f();
      break label332;
      localDownloaderTask = HalleyAgent.getDownloader().createNewTask(this.H, this.b, this.b, com.tencent.tmdownloader.internal.storage.d.b(this.j), this.j, this.O);
      continue;
      localDownloaderTask.setCategory(DownloaderTaskCategory.Cate_DefaultEase);
      continue;
      try
      {
        label918:
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
    synchronized (this.N)
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
    ab.c("_DownloadInfo", "DownloadInfo::pauseDownload url: " + this.b);
    DownloaderTask localDownloaderTask = b(this.b);
    if (localDownloaderTask != null)
    {
      localDownloaderTask.pause();
      a(3);
      return;
    }
    ab.d("_DownloadInfo", "DownloadInfo::pauseDownload task == null");
  }
  
  public void e()
  {
    ab.c("_DownloadInfo", "DownloadInfo::stopDownload url: " + this.b);
    DownloaderTask localDownloaderTask = b(this.b);
    if (localDownloaderTask != null)
    {
      HalleyAgent.getDownloader().deleteTask(localDownloaderTask, false);
      a(6);
      return;
    }
    ab.d("_DownloadInfo", "DownloadInfo::stopDownload task == null");
  }
  
  public void f()
  {
    ab.c("_DownloadInfo", "DownloadInfo::deleteDownload url: " + this.b + ",mFileName: " + this.j);
    DownloaderTask localDownloaderTask = c(this.b);
    Object localObject = com.tencent.tmdownloader.internal.storage.d.a(localDownloaderTask.getRealSaveName());
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if ((localObject != null) && (((File)localObject).exists())) {
        ((File)localObject).delete();
      }
    }
    HalleyAgent.getDownloader().deleteTask(localDownloaderTask, true);
    a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.c
 * JD-Core Version:    0.7.0.1
 */