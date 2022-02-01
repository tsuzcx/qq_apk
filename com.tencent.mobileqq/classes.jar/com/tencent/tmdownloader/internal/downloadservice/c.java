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
    boolean bool;
    if (paramCursor.getInt(paramCursor.getColumnIndex("isAutoInstallBySDK")) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localc.F = bool;
    localc.I = paramCursor.getLong(paramCursor.getColumnIndex("fileSize"));
    return localc;
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
    }
    catch (Throwable paramDownloaderTask)
    {
      ab.a("_DownloadInfo", ">buildInfo parseInt error!", paramDownloaderTask);
    }
    localDownloadTaskInfo.stackInfo = this.M;
    return localDownloadTaskInfo;
  }
  
  public static void a(ContentValues paramContentValues, c paramc)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    Object localObject1 = HalleyAgent.getDownloader().getAllTasks();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("isSavePathExisted ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(",taskList=");
    ((StringBuilder)localObject2).append(localObject1);
    ab.e("_DownloadInfo", ((StringBuilder)localObject2).toString());
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (DownloaderTask)((Iterator)localObject2).next();
      if ((TextUtils.equals(((DownloaderTask)localObject1).getSavePath(), paramString)) && (!TextUtils.equals(((DownloaderTask)localObject1).getUrl(), this.b)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Task ");
        ((StringBuilder)localObject2).append(((DownloaderTask)localObject1).getUrl());
        ((StringBuilder)localObject2).append(" has same path:");
        ((StringBuilder)localObject2).append(paramString);
        ab.e("_DownloadInfo", ((StringBuilder)localObject2).toString());
        return true;
      }
    }
    return false;
  }
  
  public void a(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("halleytest updateStatus status=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", mStatus = ");
      localStringBuilder.append(this.g);
      ab.c("_DownloadInfo", localStringBuilder.toString());
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
        if ((this.g == 4) && (this.F))
        {
          ab.c("_DownloadInfo", "Download status is succeed, start to install");
          a.a(com.tencent.tmdownloader.internal.storage.d.a(this.j));
        }
      }
      else
      {
        com.tencent.tmdownloader.internal.storage.a.a().a(this.b);
        f.a().a(String.valueOf(this.q));
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, DownloaderTask paramDownloaderTask)
  {
    if (paramDownloaderTask == null) {
      ab.e("_DownloadInfo", "<downloadReport> task is null ,return");
    }
    long l1 = System.currentTimeMillis() / 1000L;
    Object localObject = paramDownloaderTask.getUniqueKey();
    String str = paramDownloaderTask.getUrl();
    boolean bool = paramDownloaderTask.isPausedOnMobile() ^ true;
    int i2 = paramDownloaderTask.getFailCode();
    int i1;
    if (paramInt != 101) {
      i1 = -1;
    }
    long l2 = paramDownloaderTask.getStartTime();
    long l3 = paramDownloaderTask.getCostTime();
    long l4 = paramDownloaderTask.getTotalLength();
    paramDownloaderTask = new StringBuilder();
    paramDownloaderTask.append(l1);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append(this.q);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append(this.s);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append(this.r);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append(this.B);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append(paramInt);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append((String)localObject);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append(str);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append(i1);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append(i2);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append(l2);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append(l3);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append(l4);
    paramDownloaderTask.append("|");
    paramDownloaderTask.append(this.x);
    paramDownloaderTask = paramDownloaderTask.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<downloadReport> reportLog type=8,postReport.data: ");
    ((StringBuilder)localObject).append(paramDownloaderTask);
    ab.c("_DownloadInfo", ((StringBuilder)localObject).toString());
    k.a().post(new e(this, paramDownloaderTask));
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mContentType: ");
    localStringBuilder.append(this.a);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mURL: ");
    localStringBuilder.append(this.b);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mBakUrl: ");
    localStringBuilder.append(this.J);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTotalBytes: ");
    localStringBuilder.append(this.i);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUUID: ");
    localStringBuilder.append(this.d);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mStatus: ");
    localStringBuilder.append(this.g);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mReceivedBytes: ");
    localStringBuilder.append(this.h);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mFileName: ");
    localStringBuilder.append(this.j);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mDownloadFailedErrCode: ");
    localStringBuilder.append(this.l);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNetType:");
    localStringBuilder.append(this.m);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mDownloadFailedTime:");
    localStringBuilder.append(this.n);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mHeaderParamString:");
    localStringBuilder.append(this.p);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mAppid:");
    localStringBuilder.append(this.q);
    localStringBuilder.append(" mpackageName:");
    localStringBuilder.append(this.r);
    localStringBuilder.append(" mVersioncode:");
    localStringBuilder.append(this.s);
    localStringBuilder.append(" via:");
    localStringBuilder.append(this.x);
    ab.c(paramString, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChannelid:");
    localStringBuilder.append(this.y);
    localStringBuilder.append(" traceId:");
    localStringBuilder.append(this.z);
    localStringBuilder.append(" extraData:");
    localStringBuilder.append(this.A);
    localStringBuilder.append(" downloadType:");
    localStringBuilder.append(this.B);
    localStringBuilder.append(" mIconUrl:");
    localStringBuilder.append(this.D);
    localStringBuilder.append(" mAppName:");
    localStringBuilder.append(this.E);
    localStringBuilder.append(" showNotification:");
    localStringBuilder.append(this.K);
    localStringBuilder.append(" isAutoInstallBySDK:");
    localStringBuilder.append(this.F);
    ab.c(paramString, localStringBuilder.toString());
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
    long l1 = this.i;
    return (l1 != 0L) && (this.h == l1);
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
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 0) {
      this.l = paramInt;
    } else if (paramInt == -23) {
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
    } else if ((paramInt != -14) && (paramInt != -47) && (paramInt != -49) && (paramInt != -50) && (paramInt != -72))
    {
      if (paramInt == -11) {
        this.l = 704;
      } else if (paramInt == -43) {
        this.l = 705;
      } else if (paramInt == -42) {
        this.l = 706;
      } else if ((paramInt != -53) && (paramInt != -65) && (paramInt != -59))
      {
        if (paramInt == -57) {
          this.l = 709;
        } else if ((paramInt != -12) && (paramInt != -40))
        {
          if ((paramInt != -13) && (paramInt != -46))
          {
            if (paramInt == -15) {
              this.l = 605;
            } else if (paramInt == -10) {
              this.l = 712;
            } else {
              this.l = 604;
            }
          }
          else {
            this.l = 711;
          }
        }
        else {
          this.l = 710;
        }
      }
      else {
        this.l = 707;
      }
    }
    else {
      this.l = 703;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("halleytest convertHalleyFailCodeToDownloadFailedErrCode halley failCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",mDownloadFailedErrCode = ");
    localStringBuilder.append(this.l);
    ab.e("_DownloadInfo", localStringBuilder.toString());
  }
  
  public void b(long paramLong)
  {
    this.h = paramLong;
    f.a().a(this.b, this.h, this.i);
  }
  
  boolean b()
  {
    int i1 = this.g;
    return (i1 > 3) && (i1 != 6) && (i1 != 5);
  }
  
  public int c()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("url: ");
    ((StringBuilder)localObject1).append(this.b);
    ab.c("_DownloadInfo", ((StringBuilder)localObject1).toString());
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (!TextUtils.isEmpty(this.p))
    {
      localObject1 = this.o;
      if ((localObject1 == null) || (((HashMap)localObject1).size() <= 0))
      {
        localObject1 = new HashMap();
        try
        {
          localObject3 = new JSONObject(this.p);
          localObject4 = ((JSONObject)localObject3).keys();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (String)((Iterator)localObject4).next();
            ((HashMap)localObject1).put(localObject5, ((JSONObject)localObject3).getString((String)localObject5));
          }
          if (((HashMap)localObject1).size() > 0) {
            this.o = ((HashMap)localObject1);
          }
        }
        catch (JSONException localJSONException)
        {
          ab.b("_DownloadInfo", "exception: ", localJSONException);
          localJSONException.printStackTrace();
        }
      }
    }
    if (this.e) {
      return 5;
    }
    if (this.j == null) {
      if ("application/vnd.android.package-archive".equals(this.a)) {
        this.j = b.b(this.b);
      } else {
        this.j = b.a(this.b, this.a);
      }
    }
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
    Object localObject2 = b(this.b);
    if (localObject2 != null)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("halleyTest getIncompleteTask dt = ");
      ((StringBuilder)localObject3).append(localObject2);
      ((StringBuilder)localObject3).append(",download %=");
      ((StringBuilder)localObject3).append(((DownloaderTask)localObject2).getPercentage());
      ab.c("_DownloadInfo", ((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("halleyTest getIncompleteTask dt = ");
      ((StringBuilder)localObject3).append(localObject2);
      ((StringBuilder)localObject3).append(",download length=");
      ((StringBuilder)localObject3).append(((DownloaderTask)localObject2).getReceivedLength());
      ab.c("_DownloadInfo", ((StringBuilder)localObject3).toString());
    }
    else
    {
      localObject3 = c(this.b);
      if (localObject3 != null)
      {
        localObject3 = new File(((DownloaderTask)localObject3).getRealSaveName());
        if ((!b.b(this.b, this.a)) && (!((File)localObject3).exists())) {
          f();
        }
      }
    }
    if (localObject2 == null) {
      try
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mFileSize = ");
        ((StringBuilder)localObject2).append(this.I);
        ab.c("_DownloadInfo", ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mFileNameB = ");
        ((StringBuilder)localObject2).append(this.j);
        ab.c("_DownloadInfo", ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(com.tencent.tmdownloader.internal.storage.d.b(this.j));
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(this.j);
        if (d(((StringBuilder)localObject2).toString())) {
          this.j = b.a(this.b, this.a);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mFileNameA = ");
        ((StringBuilder)localObject2).append(this.j);
        ab.c("_DownloadInfo", ((StringBuilder)localObject2).toString());
        if (this.I > 0L) {
          localObject2 = HalleyAgent.getDownloader().createNewTask(0, this.b, this.b, com.tencent.tmdownloader.internal.storage.d.b(this.j), this.j, this.O, this.I);
        } else {
          localObject2 = HalleyAgent.getDownloader().createNewTask(this.H, this.b, this.b, com.tencent.tmdownloader.internal.storage.d.b(this.j), this.j, this.O);
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.q);
        ((StringBuilder)localObject3).append("");
        ((DownloaderTask)localObject2).setAppId(((StringBuilder)localObject3).toString());
        ((DownloaderTask)localObject2).setPauseTaskOnMobile(false);
        if ((this.x != null) && (!TextUtils.isEmpty(this.x)) && (this.x.contains("ANDROIDQQ.GAME.DETAIL")))
        {
          localObject3 = GlobalUtil.getInstance().getModel();
          localObject4 = GlobalUtil.getInstance().getBrand();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("_");
          ((StringBuilder)localObject5).append((String)localObject4);
          ((StringBuilder)localObject5).append("_");
          ((StringBuilder)localObject5).append((String)localObject3);
          localObject3 = ((StringBuilder)localObject5).toString();
          localObject4 = HalleyAgent.getDownloader();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(this.x);
          ((StringBuilder)localObject5).append((String)localObject3);
          ((Downloader)localObject4).setQua1(((StringBuilder)localObject5).toString());
        }
        if ((this.x != null) && (!TextUtils.isEmpty(this.x)))
        {
          ((DownloaderTask)localObject2).setAppScene(this.x);
          ((DownloaderTask)localObject2).setCategory(DownloaderTaskCategory.Cate_DefaultMass);
        }
        else
        {
          ((DownloaderTask)localObject2).setCategory(DownloaderTaskCategory.Cate_DefaultEase);
        }
        a(1);
        HalleyAgent.getDownloader().addNewTask((DownloaderTask)localObject2);
        a(100, (DownloaderTask)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("halleyTest createNewTask mURL=");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append(",saveFilePath=");
        ((StringBuilder)localObject2).append(com.tencent.tmdownloader.internal.storage.d.a(this.j));
        ((StringBuilder)localObject2).append(",fileName=");
        ((StringBuilder)localObject2).append(this.j);
        ab.c("_DownloadInfo", ((StringBuilder)localObject2).toString());
        return 0;
      }
      catch (Exception localException)
      {
        ab.c("_DownloadInfo", "startDownloadIfReady HalleyAgent createNewTask Exception", localException);
        return 0;
      }
    }
    try
    {
      localException.setPauseTaskOnMobile(false);
      a(1);
      localException.resume();
      return 0;
    }
    catch (HalleyException localHalleyException)
    {
      localHalleyException.printStackTrace();
    }
    return 0;
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
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DownloadInfo::pauseDownload url: ");
    ((StringBuilder)localObject).append(this.b);
    ab.c("_DownloadInfo", ((StringBuilder)localObject).toString());
    localObject = b(this.b);
    if (localObject != null)
    {
      ((DownloaderTask)localObject).pause();
      a(3);
      return;
    }
    ab.d("_DownloadInfo", "DownloadInfo::pauseDownload task == null");
  }
  
  public void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DownloadInfo::stopDownload url: ");
    ((StringBuilder)localObject).append(this.b);
    ab.c("_DownloadInfo", ((StringBuilder)localObject).toString());
    localObject = b(this.b);
    if (localObject != null)
    {
      HalleyAgent.getDownloader().deleteTask((DownloaderTask)localObject, false);
      a(6);
      return;
    }
    ab.d("_DownloadInfo", "DownloadInfo::stopDownload task == null");
  }
  
  public void f()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("DownloadInfo::deleteDownload url: ");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(",mFileName: ");
    ((StringBuilder)localObject1).append(this.j);
    ab.c("_DownloadInfo", ((StringBuilder)localObject1).toString());
    localObject1 = c(this.b);
    Object localObject2 = com.tencent.tmdownloader.internal.storage.d.a(((DownloaderTask)localObject1).getRealSaveName());
    if (localObject2 != null)
    {
      localObject2 = new File((String)localObject2);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
    }
    HalleyAgent.getDownloader().deleteTask((DownloaderTask)localObject1, true);
    a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.c
 * JD-Core Version:    0.7.0.1
 */