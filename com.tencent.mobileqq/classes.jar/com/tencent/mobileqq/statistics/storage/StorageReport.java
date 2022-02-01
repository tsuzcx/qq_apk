package com.tencent.mobileqq.statistics.storage;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vfs.VFSRegisterProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class StorageReport
{
  public static final String[] a = { "/data/data/com.tencent.mobileqq", "/data/data/com.tencent.mobileqq/files" };
  private static volatile StorageReport b;
  private static final RecyclablePool c = new RecyclablePool(StorageItem.class, 50);
  private static volatile Handler d;
  private static HandlerThread e;
  private static List<String> r;
  private ArrayList<StorageItem> f = new ArrayList(20);
  private ArrayList<StorageItem> g = new ArrayList(40);
  private StorageReport.MyFileAccessComparator h = new StorageReport.MyFileAccessComparator(null);
  private StorageReport.MyFileLargeComparator i = new StorageReport.MyFileLargeComparator(null);
  private boolean j;
  private long k;
  private Field l;
  private String m;
  private Field n;
  private Method o;
  private ArrayList<StorageItem> p;
  private ArrayList<StorageItem> q;
  private boolean s;
  
  private StorageReport()
  {
    boolean bool = true;
    this.j = true;
    this.k = 0L;
    this.l = null;
    this.m = "";
    this.n = null;
    this.o = null;
    this.p = new ArrayList(7);
    this.q = new ArrayList(7);
    this.s = false;
    if (0.001000000047497451D < Math.random()) {
      bool = false;
    }
    this.j = bool;
  }
  
  private long a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return 0L;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramString2);
      File localFile = new File(((StringBuilder)localObject).toString());
      if (localFile.isDirectory()) {
        return 0L;
      }
      localObject = (StorageItem)c.obtain(StorageItem.class);
      ((StorageItem)localObject).a = paramString2;
      ((StorageItem)localObject).e = true;
      ((StorageItem)localObject).c = localFile.length();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString2);
      ((StorageItem)localObject).b = localStringBuilder.toString();
      ((StorageItem)localObject).d = a(localFile);
      ((StorageItem)localObject).f = 1L;
      if (((StorageItem)localObject).c >= 524288.0D)
      {
        paramString1 = new StringBuilder();
        paramString1.append("--scan qq-- file info: ");
        paramString1.append(((StorageItem)localObject).toString());
        QLog.d("StorageReport", 1, paramString1.toString());
      }
      if (((StorageItem)localObject).c >= 2097152L) {
        a((StorageItem)localObject);
      }
      a((StorageItem)localObject, ((StorageItem)localObject).c);
      if (this.f.size() < 20)
      {
        this.f.add(localObject);
        if (this.f.size() == 20) {
          Collections.sort(this.f, this.h);
        }
        return ((StorageItem)localObject).c;
      }
      paramString1 = this.f;
      paramString1 = (StorageItem)paramString1.get(paramString1.size() - 1);
      if ((this.f.size() >= 20) && (((StorageItem)localObject).d > paramString1.d))
      {
        paramString2 = this.f;
        paramString2.remove(paramString2.size() - 1);
        c.recycle(paramString1);
        this.f.add(localObject);
        Collections.sort(this.f, this.h);
        return ((StorageItem)localObject).c;
      }
      c.recycle((RecyclablePool.Recyclable)localObject);
      return ((StorageItem)localObject).c;
    }
    return 0L;
  }
  
  private Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    Stack localStack = new Stack();
    localStack.push(paramString);
    long l1 = 0L;
    long l2 = 0L;
    long l5 = l2;
    while (!localStack.isEmpty())
    {
      paramString = new File((String)localStack.pop());
      if (paramString.isDirectory())
      {
        String[] arrayOfString = paramString.list();
        long l4 = l1;
        long l3 = l2;
        if (arrayOfString != null)
        {
          int i2 = arrayOfString.length;
          int i1 = 0;
          for (;;)
          {
            l4 = l1;
            l3 = l2;
            if (i1 >= i2) {
              break;
            }
            String str = arrayOfString[i1];
            File localFile = new File(paramString, str);
            if (localFile.isDirectory())
            {
              localStack.push(localFile.getAbsolutePath());
            }
            else
            {
              a(paramString.getAbsolutePath(), str);
              l1 += localFile.length();
              l2 += 1L;
            }
            i1 += 1;
          }
        }
        l5 += 1L;
        l1 = l4;
        l2 = l3;
      }
      else
      {
        a(paramString.getParent(), paramString.getName());
        l2 += 1L;
      }
      l1 += paramString.length();
    }
    localBundle.putLong("key_size", l1);
    localBundle.putLong("key_file_count", l2);
    localBundle.putLong("key_dir_count", l5);
    return localBundle;
  }
  
  public static StorageReport a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new StorageReport();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(StorageItem paramStorageItem)
  {
    if (!this.j) {
      return;
    }
    HashMap localHashMap = new HashMap(20);
    localHashMap.put("report_key", this.m);
    localHashMap.put("path", paramStorageItem.b);
    localHashMap.put("name", paramStorageItem.a);
    localHashMap.put("size", String.valueOf(paramStorageItem.c));
    localHashMap.put("accessTime", String.valueOf(paramStorageItem.d));
    localHashMap.put("isFile", String.valueOf(paramStorageItem.e));
    localHashMap.put("fileCount", String.valueOf(paramStorageItem.f));
    localHashMap.put("dirCount", String.valueOf(paramStorageItem.g));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--scan qq-- file report to tdw : report key = ");
      localStringBuilder.append(this.m);
      localStringBuilder.append(",item info=");
      localStringBuilder.append(paramStorageItem.toString());
      QLog.d("StorageReport", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "qqStorageReport", true, 0L, 0L, localHashMap, null);
  }
  
  private void a(StorageItem paramStorageItem, long paramLong)
  {
    if (paramStorageItem != null)
    {
      if (TextUtils.isEmpty(paramStorageItem.b)) {
        return;
      }
      int i1 = 0;
      if (paramLong >= 10240L) {
        if ((paramLong >= 10240L) && (paramLong < 102400L)) {
          i1 = 1;
        } else if ((paramLong >= 102400L) && (paramLong < 1048576L)) {
          i1 = 2;
        } else if ((paramLong >= 1048576L) && (paramLong < 2097152L)) {
          i1 = 3;
        } else if ((paramLong >= 2097152L) && (paramLong < 10485760L)) {
          i1 = 4;
        } else if ((paramLong >= 10485760L) && (paramLong < 104857600L)) {
          i1 = 5;
        } else if (paramLong >= 104857600L) {
          i1 = 6;
        }
      }
      if (paramStorageItem.b.contains("/data/data/com.tencent.mobileqq")) {
        paramStorageItem = (StorageItem)this.q.get(i1);
      } else {
        paramStorageItem = (StorageItem)this.p.get(i1);
      }
      paramStorageItem.c += paramLong;
      paramStorageItem.f += 1L;
    }
  }
  
  private String b(ArrayList<StorageItem> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      StorageItem localStorageItem = (StorageItem)paramArrayList.get(i1);
      localStringBuilder.append(localStorageItem.f);
      localStringBuilder.append("-");
      localStringBuilder.append(localStorageItem.c);
      if (i1 < paramArrayList.size() - 1) {
        localStringBuilder.append("|");
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static Handler c()
  {
    try
    {
      if (d == null)
      {
        e = new HandlerThread("SETTING_STORAGE_CLEAN_SCAN", 0);
        e.start();
        d = new Handler(e.getLooper());
      }
      Handler localHandler = d;
      return localHandler;
    }
    finally {}
  }
  
  public static void d()
  {
    try
    {
      if (d != null)
      {
        d.removeCallbacks(null);
        d = null;
      }
      if (e != null)
      {
        e.quit();
        e = null;
      }
      return;
    }
    finally {}
  }
  
  private static List<String> e()
  {
    if (r == null)
    {
      r = new ArrayList(Arrays.asList(new String[] { "/sdcard/Tencent/MobileQQ", "/sdcard/Tencent/QQ_Images", "/sdcard/Tencent/QQfile_recv", "/sdcard/Tencent/QQ_Collection", "/sdcard/Tencent/QQ_Favorite", "/sdcard/Tencent/QQ_Video", "/sdcard/Tencent/QQfile_share", "/sdcard/Tencent/QQHomework_recv", "/sdcard/Tencent/QQHomework_attach", "/sdcard/Tencent/AIO_FORWARD", "/sdcard/Tencent/QQ_business", "/sdcard/Tencent/msflogs" }));
      String str = VFSRegisterProxy.a().b();
      if (str != null) {
        r.add(str);
      }
    }
    return r;
  }
  
  /* Error */
  public long a(com.tencent.mobileqq.activity.QQSettingCleanActivity.IProgressCallback paramIProgressCallback, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +10 -> 13
    //   6: aload_1
    //   7: iload_2
    //   8: invokeinterface 424 2 0
    //   13: aload_0
    //   14: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   17: ldc2_w 430
    //   20: ldiv
    //   21: putfield 87	com/tencent/mobileqq/statistics/storage/StorageReport:k	J
    //   24: invokestatic 301	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   27: invokevirtual 435	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   30: checkcast 437	com/tencent/mobileqq/app/QQAppInterface
    //   33: astore 37
    //   35: aload 37
    //   37: ifnull +12 -> 49
    //   40: aload_0
    //   41: aload 37
    //   43: invokevirtual 440	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   46: putfield 93	com/tencent/mobileqq/statistics/storage/StorageReport:m	Ljava/lang/String;
    //   49: new 120	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   56: astore 37
    //   58: aload 37
    //   60: aload_0
    //   61: getfield 93	com/tencent/mobileqq/statistics/storage/StorageReport:m	Ljava/lang/String;
    //   64: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 37
    //   70: ldc_w 442
    //   73: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 37
    //   79: aload_0
    //   80: getfield 87	com/tencent/mobileqq/statistics/storage/StorageReport:k	J
    //   83: invokestatic 275	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   86: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_0
    //   91: aload 37
    //   93: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: putfield 93	com/tencent/mobileqq/statistics/storage/StorageReport:m	Ljava/lang/String;
    //   99: invokestatic 301	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   102: ldc_w 444
    //   105: iconst_0
    //   106: invokevirtual 448	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   109: astore 38
    //   111: aload 38
    //   113: ldc_w 450
    //   116: lconst_0
    //   117: invokeinterface 456 4 0
    //   122: lstore 6
    //   124: aload_0
    //   125: getfield 85	com/tencent/mobileqq/statistics/storage/StorageReport:j	Z
    //   128: ifeq +41 -> 169
    //   131: lload 6
    //   133: lconst_0
    //   134: lcmp
    //   135: ifle +34 -> 169
    //   138: aload_0
    //   139: getfield 87	com/tencent/mobileqq/statistics/storage/StorageReport:k	J
    //   142: lload 6
    //   144: lsub
    //   145: invokestatic 460	java/lang/Math:abs	(J)J
    //   148: ldc2_w 461
    //   151: lcmp
    //   152: ifge +17 -> 169
    //   155: aload_0
    //   156: iconst_0
    //   157: putfield 85	com/tencent/mobileqq/statistics/storage/StorageReport:j	Z
    //   160: ldc 170
    //   162: iconst_2
    //   163: ldc_w 464
    //   166: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload_0
    //   170: getfield 71	com/tencent/mobileqq/statistics/storage/StorageReport:g	Ljava/util/ArrayList;
    //   173: invokevirtual 467	java/util/ArrayList:clear	()V
    //   176: aload_0
    //   177: getfield 69	com/tencent/mobileqq/statistics/storage/StorageReport:f	Ljava/util/ArrayList;
    //   180: invokevirtual 467	java/util/ArrayList:clear	()V
    //   183: aload_0
    //   184: getfield 99	com/tencent/mobileqq/statistics/storage/StorageReport:p	Ljava/util/ArrayList;
    //   187: invokevirtual 467	java/util/ArrayList:clear	()V
    //   190: aload_0
    //   191: getfield 101	com/tencent/mobileqq/statistics/storage/StorageReport:q	Ljava/util/ArrayList;
    //   194: invokevirtual 467	java/util/ArrayList:clear	()V
    //   197: iconst_0
    //   198: istore_2
    //   199: iload_2
    //   200: bipush 7
    //   202: if_icmpge +80 -> 282
    //   205: getstatic 51	com/tencent/mobileqq/statistics/storage/StorageReport:c	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   208: ldc 45
    //   210: invokevirtual 144	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   213: checkcast 45	com/tencent/mobileqq/statistics/storage/StorageItem
    //   216: astore 37
    //   218: aload 37
    //   220: lconst_0
    //   221: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   224: aload 37
    //   226: lconst_0
    //   227: putfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   230: aload_0
    //   231: getfield 99	com/tencent/mobileqq/statistics/storage/StorageReport:p	Ljava/util/ArrayList;
    //   234: aload 37
    //   236: invokevirtual 191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   239: pop
    //   240: getstatic 51	com/tencent/mobileqq/statistics/storage/StorageReport:c	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   243: ldc 45
    //   245: invokevirtual 144	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   248: checkcast 45	com/tencent/mobileqq/statistics/storage/StorageItem
    //   251: astore 37
    //   253: aload 37
    //   255: lconst_0
    //   256: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   259: aload 37
    //   261: lconst_0
    //   262: putfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   265: aload_0
    //   266: getfield 101	com/tencent/mobileqq/statistics/storage/StorageReport:q	Ljava/util/ArrayList;
    //   269: aload 37
    //   271: invokevirtual 191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   274: pop
    //   275: iload_2
    //   276: iconst_1
    //   277: iadd
    //   278: istore_2
    //   279: goto -80 -> 199
    //   282: invokestatic 469	com/tencent/mobileqq/statistics/storage/StorageReport:e	()Ljava/util/List;
    //   285: astore 37
    //   287: aload 37
    //   289: iconst_0
    //   290: invokeinterface 470 2 0
    //   295: checkcast 53	java/lang/String
    //   298: astore 39
    //   300: new 129	java/io/File
    //   303: dup
    //   304: aload 39
    //   306: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   309: invokevirtual 229	java/io/File:list	()[Ljava/lang/String;
    //   312: astore 40
    //   314: aload 40
    //   316: ifnull +2389 -> 2705
    //   319: aload 40
    //   321: arraylength
    //   322: ifle +2383 -> 2705
    //   325: lconst_0
    //   326: lstore 10
    //   328: lload 10
    //   330: lstore 6
    //   332: iconst_0
    //   333: istore_2
    //   334: lload 10
    //   336: lstore 12
    //   338: lload 6
    //   340: lstore 8
    //   342: iload_2
    //   343: aload 40
    //   345: arraylength
    //   346: if_icmpge +2365 -> 2711
    //   349: new 120	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   356: astore 41
    //   358: aload 41
    //   360: aload 39
    //   362: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 41
    //   368: ldc 127
    //   370: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 41
    //   376: aload 40
    //   378: iload_2
    //   379: aaload
    //   380: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: new 129	java/io/File
    //   387: dup
    //   388: aload 41
    //   390: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   396: astore 42
    //   398: aload 42
    //   400: invokevirtual 140	java/io/File:isDirectory	()Z
    //   403: ifeq +108 -> 511
    //   406: new 45	com/tencent/mobileqq/statistics/storage/StorageItem
    //   409: dup
    //   410: invokespecial 471	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   413: astore 41
    //   415: aload 41
    //   417: iconst_0
    //   418: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:e	Z
    //   421: aload 41
    //   423: aload_0
    //   424: aload 42
    //   426: invokevirtual 159	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/io/File;)J
    //   429: putfield 161	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   432: aload 41
    //   434: aload 40
    //   436: iload_2
    //   437: aaload
    //   438: putfield 146	com/tencent/mobileqq/statistics/storage/StorageItem:a	Ljava/lang/String;
    //   441: new 120	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   448: astore 42
    //   450: aload 42
    //   452: aload 39
    //   454: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 42
    //   460: ldc 127
    //   462: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 42
    //   468: aload 40
    //   470: iload_2
    //   471: aaload
    //   472: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 41
    //   478: aload 42
    //   480: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: putfield 156	com/tencent/mobileqq/statistics/storage/StorageItem:b	Ljava/lang/String;
    //   486: aload 41
    //   488: lconst_0
    //   489: putfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   492: aload 41
    //   494: lconst_0
    //   495: putfield 288	com/tencent/mobileqq/statistics/storage/StorageItem:g	J
    //   498: aload_0
    //   499: getfield 71	com/tencent/mobileqq/statistics/storage/StorageReport:g	Ljava/util/ArrayList;
    //   502: aload 41
    //   504: invokevirtual 191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   507: pop
    //   508: goto +2190 -> 2698
    //   511: lload 10
    //   513: aload_0
    //   514: aload 39
    //   516: aload 40
    //   518: iload_2
    //   519: aaload
    //   520: invokespecial 237	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   523: ladd
    //   524: lstore 10
    //   526: lload 6
    //   528: lconst_1
    //   529: ladd
    //   530: lstore 6
    //   532: goto +2166 -> 2698
    //   535: iload_2
    //   536: aload 37
    //   538: invokeinterface 472 1 0
    //   543: if_icmpge +2180 -> 2723
    //   546: aload 37
    //   548: iload_2
    //   549: invokeinterface 470 2 0
    //   554: checkcast 53	java/lang/String
    //   557: astore 39
    //   559: new 129	java/io/File
    //   562: dup
    //   563: aload 39
    //   565: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   568: astore 40
    //   570: aload 40
    //   572: invokevirtual 140	java/io/File:isDirectory	()Z
    //   575: ifeq +2141 -> 2716
    //   578: new 45	com/tencent/mobileqq/statistics/storage/StorageItem
    //   581: dup
    //   582: invokespecial 471	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   585: astore 41
    //   587: aload 41
    //   589: iconst_0
    //   590: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:e	Z
    //   593: aload 41
    //   595: aload_0
    //   596: aload 40
    //   598: invokevirtual 159	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/io/File;)J
    //   601: putfield 161	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   604: aload 41
    //   606: aload 39
    //   608: ldc 127
    //   610: invokevirtual 476	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   613: iconst_2
    //   614: aaload
    //   615: putfield 146	com/tencent/mobileqq/statistics/storage/StorageItem:a	Ljava/lang/String;
    //   618: aload 41
    //   620: aload 39
    //   622: putfield 156	com/tencent/mobileqq/statistics/storage/StorageItem:b	Ljava/lang/String;
    //   625: aload 41
    //   627: lconst_0
    //   628: putfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   631: aload 41
    //   633: lconst_0
    //   634: putfield 288	com/tencent/mobileqq/statistics/storage/StorageItem:g	J
    //   637: aload_0
    //   638: getfield 71	com/tencent/mobileqq/statistics/storage/StorageReport:g	Ljava/util/ArrayList;
    //   641: aload 41
    //   643: invokevirtual 191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   646: pop
    //   647: goto +2069 -> 2716
    //   650: iload_2
    //   651: getstatic 59	com/tencent/mobileqq/statistics/storage/StorageReport:a	[Ljava/lang/String;
    //   654: arraylength
    //   655: if_icmpge +318 -> 973
    //   658: getstatic 59	com/tencent/mobileqq/statistics/storage/StorageReport:a	[Ljava/lang/String;
    //   661: iload_2
    //   662: aaload
    //   663: astore 37
    //   665: new 129	java/io/File
    //   668: dup
    //   669: aload 37
    //   671: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   674: invokevirtual 229	java/io/File:list	()[Ljava/lang/String;
    //   677: astore 39
    //   679: aload 39
    //   681: ifnull +2056 -> 2737
    //   684: aload 39
    //   686: arraylength
    //   687: ifle +2050 -> 2737
    //   690: iconst_0
    //   691: istore 4
    //   693: iload 4
    //   695: aload 39
    //   697: arraylength
    //   698: if_icmpge +2039 -> 2737
    //   701: new 120	java/lang/StringBuilder
    //   704: dup
    //   705: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   708: astore 40
    //   710: aload 40
    //   712: aload 37
    //   714: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 40
    //   720: ldc 127
    //   722: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload 40
    //   728: aload 39
    //   730: iload 4
    //   732: aaload
    //   733: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: new 129	java/io/File
    //   740: dup
    //   741: aload 40
    //   743: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   749: astore 40
    //   751: new 120	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   758: astore 41
    //   760: aload 41
    //   762: aload 37
    //   764: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload 41
    //   770: ldc 127
    //   772: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: aload 41
    //   778: aload 39
    //   780: iload 4
    //   782: aaload
    //   783: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: ldc 57
    //   789: aload 41
    //   791: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokevirtual 479	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   797: ifeq +46 -> 843
    //   800: new 120	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   807: astore 40
    //   809: aload 40
    //   811: ldc_w 481
    //   814: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: aload 40
    //   820: aload 39
    //   822: iload 4
    //   824: aaload
    //   825: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: pop
    //   829: ldc 170
    //   831: iconst_2
    //   832: aload 40
    //   834: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   840: goto +1888 -> 2728
    //   843: aload 40
    //   845: invokevirtual 140	java/io/File:isDirectory	()Z
    //   848: ifeq +110 -> 958
    //   851: new 45	com/tencent/mobileqq/statistics/storage/StorageItem
    //   854: dup
    //   855: invokespecial 471	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   858: astore 41
    //   860: aload 41
    //   862: iconst_0
    //   863: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:e	Z
    //   866: aload 41
    //   868: aload_0
    //   869: aload 40
    //   871: invokevirtual 159	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/io/File;)J
    //   874: putfield 161	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   877: aload 41
    //   879: aload 39
    //   881: iload 4
    //   883: aaload
    //   884: putfield 146	com/tencent/mobileqq/statistics/storage/StorageItem:a	Ljava/lang/String;
    //   887: new 120	java/lang/StringBuilder
    //   890: dup
    //   891: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   894: astore 40
    //   896: aload 40
    //   898: aload 37
    //   900: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: pop
    //   904: aload 40
    //   906: ldc 127
    //   908: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: pop
    //   912: aload 40
    //   914: aload 39
    //   916: iload 4
    //   918: aaload
    //   919: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload 41
    //   925: aload 40
    //   927: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   930: putfield 156	com/tencent/mobileqq/statistics/storage/StorageItem:b	Ljava/lang/String;
    //   933: aload 41
    //   935: lconst_0
    //   936: putfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   939: aload 41
    //   941: lconst_0
    //   942: putfield 288	com/tencent/mobileqq/statistics/storage/StorageItem:g	J
    //   945: aload_0
    //   946: getfield 71	com/tencent/mobileqq/statistics/storage/StorageReport:g	Ljava/util/ArrayList;
    //   949: aload 41
    //   951: invokevirtual 191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   954: pop
    //   955: goto +1773 -> 2728
    //   958: aload_0
    //   959: aload 37
    //   961: aload 39
    //   963: iload 4
    //   965: aaload
    //   966: invokespecial 237	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   969: pop2
    //   970: goto +1758 -> 2728
    //   973: new 120	java/lang/StringBuilder
    //   976: dup
    //   977: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   980: astore 37
    //   982: aload 37
    //   984: ldc_w 483
    //   987: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: pop
    //   991: aload 37
    //   993: aload_0
    //   994: getfield 87	com/tencent/mobileqq/statistics/storage/StorageReport:k	J
    //   997: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1000: pop
    //   1001: ldc 170
    //   1003: iconst_2
    //   1004: aload 37
    //   1006: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1009: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1012: lload 8
    //   1014: lstore 6
    //   1016: iconst_0
    //   1017: istore_2
    //   1018: lconst_0
    //   1019: lstore 18
    //   1021: lconst_0
    //   1022: lstore 16
    //   1024: lconst_0
    //   1025: lstore 10
    //   1027: lconst_0
    //   1028: lstore 8
    //   1030: lconst_0
    //   1031: lstore 20
    //   1033: lload 12
    //   1035: lstore 14
    //   1037: lload 20
    //   1039: lstore 12
    //   1041: aload_0
    //   1042: getfield 71	com/tencent/mobileqq/statistics/storage/StorageReport:g	Ljava/util/ArrayList;
    //   1045: invokevirtual 187	java/util/ArrayList:size	()I
    //   1048: istore 4
    //   1050: iload_2
    //   1051: iload 4
    //   1053: if_icmpge +1034 -> 2087
    //   1056: aload_0
    //   1057: getfield 71	com/tencent/mobileqq/statistics/storage/StorageReport:g	Ljava/util/ArrayList;
    //   1060: invokevirtual 187	java/util/ArrayList:size	()I
    //   1063: sipush 500
    //   1066: if_icmplt +12 -> 1078
    //   1069: ldc2_w 484
    //   1072: invokestatic 491	java/lang/Thread:sleep	(J)V
    //   1075: goto +19 -> 1094
    //   1078: ldc2_w 492
    //   1081: invokestatic 491	java/lang/Thread:sleep	(J)V
    //   1084: goto +10 -> 1094
    //   1087: astore 37
    //   1089: aload 37
    //   1091: invokevirtual 496	java/lang/InterruptedException:printStackTrace	()V
    //   1094: aload_0
    //   1095: getfield 71	com/tencent/mobileqq/statistics/storage/StorageReport:g	Ljava/util/ArrayList;
    //   1098: iload_2
    //   1099: invokevirtual 201	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1102: checkcast 45	com/tencent/mobileqq/statistics/storage/StorageItem
    //   1105: astore 39
    //   1107: aload 39
    //   1109: lconst_0
    //   1110: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1113: aload 39
    //   1115: lconst_0
    //   1116: putfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   1119: aload 39
    //   1121: lconst_0
    //   1122: putfield 288	com/tencent/mobileqq/statistics/storage/StorageItem:g	J
    //   1125: aload 39
    //   1127: getfield 156	com/tencent/mobileqq/statistics/storage/StorageItem:b	Ljava/lang/String;
    //   1130: astore 40
    //   1132: new 129	java/io/File
    //   1135: dup
    //   1136: aload 40
    //   1138: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   1141: invokevirtual 229	java/io/File:list	()[Ljava/lang/String;
    //   1144: astore 37
    //   1146: aload 37
    //   1148: ifnull +392 -> 1540
    //   1151: aload 37
    //   1153: arraylength
    //   1154: ifle +386 -> 1540
    //   1157: aload 37
    //   1159: arraylength
    //   1160: istore 4
    //   1162: iconst_0
    //   1163: istore 5
    //   1165: lload 18
    //   1167: lstore 22
    //   1169: lload 16
    //   1171: lstore 20
    //   1173: iload 5
    //   1175: iload 4
    //   1177: if_icmpge +371 -> 1548
    //   1180: aload 37
    //   1182: iload 5
    //   1184: aaload
    //   1185: astore 41
    //   1187: lload 18
    //   1189: lstore 32
    //   1191: lload 6
    //   1193: lstore 30
    //   1195: lload 16
    //   1197: lstore 28
    //   1199: lload 10
    //   1201: lstore 26
    //   1203: lload 8
    //   1205: lstore 24
    //   1207: lload 12
    //   1209: lstore 22
    //   1211: lload 14
    //   1213: lstore 20
    //   1215: new 120	java/lang/StringBuilder
    //   1218: dup
    //   1219: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1222: astore 42
    //   1224: lload 18
    //   1226: lstore 32
    //   1228: lload 6
    //   1230: lstore 30
    //   1232: lload 16
    //   1234: lstore 28
    //   1236: lload 10
    //   1238: lstore 26
    //   1240: lload 8
    //   1242: lstore 24
    //   1244: lload 12
    //   1246: lstore 22
    //   1248: lload 14
    //   1250: lstore 20
    //   1252: aload 42
    //   1254: aload 40
    //   1256: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: pop
    //   1260: lload 18
    //   1262: lstore 32
    //   1264: lload 6
    //   1266: lstore 30
    //   1268: lload 16
    //   1270: lstore 28
    //   1272: lload 10
    //   1274: lstore 26
    //   1276: lload 8
    //   1278: lstore 24
    //   1280: lload 12
    //   1282: lstore 22
    //   1284: lload 14
    //   1286: lstore 20
    //   1288: aload 42
    //   1290: ldc 127
    //   1292: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: pop
    //   1296: lload 18
    //   1298: lstore 32
    //   1300: lload 6
    //   1302: lstore 30
    //   1304: lload 16
    //   1306: lstore 28
    //   1308: lload 10
    //   1310: lstore 26
    //   1312: lload 8
    //   1314: lstore 24
    //   1316: lload 12
    //   1318: lstore 22
    //   1320: lload 14
    //   1322: lstore 20
    //   1324: aload 42
    //   1326: aload 41
    //   1328: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: pop
    //   1332: lload 18
    //   1334: lstore 32
    //   1336: lload 6
    //   1338: lstore 30
    //   1340: lload 16
    //   1342: lstore 28
    //   1344: lload 10
    //   1346: lstore 26
    //   1348: lload 8
    //   1350: lstore 24
    //   1352: lload 12
    //   1354: lstore 22
    //   1356: lload 14
    //   1358: lstore 20
    //   1360: aload_0
    //   1361: aload 42
    //   1363: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1366: invokespecial 498	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1369: astore 41
    //   1371: lload 6
    //   1373: lstore 32
    //   1375: lload 16
    //   1377: lstore 30
    //   1379: lload 10
    //   1381: lstore 28
    //   1383: lload 8
    //   1385: lstore 26
    //   1387: lload 12
    //   1389: lstore 24
    //   1391: lload 14
    //   1393: lstore 22
    //   1395: lload 18
    //   1397: lstore 20
    //   1399: aload 39
    //   1401: getfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1404: lstore 34
    //   1406: lload 16
    //   1408: lstore 20
    //   1410: aload 39
    //   1412: lload 34
    //   1414: aload 41
    //   1416: ldc 245
    //   1418: lconst_0
    //   1419: invokevirtual 499	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1422: ladd
    //   1423: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1426: aload 39
    //   1428: aload 39
    //   1430: getfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   1433: aload 41
    //   1435: ldc 251
    //   1437: lconst_0
    //   1438: invokevirtual 499	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1441: ladd
    //   1442: putfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   1445: aload 39
    //   1447: aload 39
    //   1449: getfield 288	com/tencent/mobileqq/statistics/storage/StorageItem:g	J
    //   1452: aload 41
    //   1454: ldc 253
    //   1456: lconst_0
    //   1457: invokevirtual 499	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1460: ladd
    //   1461: putfield 288	com/tencent/mobileqq/statistics/storage/StorageItem:g	J
    //   1464: iload 5
    //   1466: iconst_1
    //   1467: iadd
    //   1468: istore 5
    //   1470: lload 20
    //   1472: lstore 16
    //   1474: goto -309 -> 1165
    //   1477: astore 37
    //   1479: lload 18
    //   1481: lstore 16
    //   1483: lload 20
    //   1485: lstore 18
    //   1487: goto +511 -> 1998
    //   1490: astore 37
    //   1492: lload 32
    //   1494: lstore 18
    //   1496: lload 30
    //   1498: lstore 6
    //   1500: lload 28
    //   1502: lstore 16
    //   1504: lload 26
    //   1506: lstore 10
    //   1508: lload 24
    //   1510: lstore 8
    //   1512: lload 22
    //   1514: lstore 12
    //   1516: lload 20
    //   1518: lstore 14
    //   1520: goto +5 -> 1525
    //   1523: astore 37
    //   1525: lload 18
    //   1527: lstore 20
    //   1529: lload 16
    //   1531: lstore 18
    //   1533: lload 20
    //   1535: lstore 16
    //   1537: goto +461 -> 1998
    //   1540: lload 16
    //   1542: lstore 20
    //   1544: lload 18
    //   1546: lstore 22
    //   1548: lload 22
    //   1550: lstore 18
    //   1552: aload 40
    //   1554: ldc 55
    //   1556: invokevirtual 326	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1559: istore 36
    //   1561: iload 36
    //   1563: ifeq +86 -> 1649
    //   1566: lload 10
    //   1568: lstore 16
    //   1570: lload 10
    //   1572: aload 39
    //   1574: getfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1577: ladd
    //   1578: lstore 10
    //   1580: lload 10
    //   1582: lstore 16
    //   1584: aload 39
    //   1586: getfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   1589: lstore 22
    //   1591: lload 8
    //   1593: lload 22
    //   1595: ladd
    //   1596: lstore 8
    //   1598: aload 39
    //   1600: getfield 288	com/tencent/mobileqq/statistics/storage/StorageItem:g	J
    //   1603: lstore 16
    //   1605: lload 12
    //   1607: lload 16
    //   1609: ladd
    //   1610: lstore 22
    //   1612: lload 20
    //   1614: lstore 12
    //   1616: lload 6
    //   1618: lstore 16
    //   1620: lload 22
    //   1622: lstore 6
    //   1624: goto +83 -> 1707
    //   1627: astore 37
    //   1629: goto +9 -> 1638
    //   1632: astore 37
    //   1634: lload 16
    //   1636: lstore 10
    //   1638: lload 18
    //   1640: lstore 16
    //   1642: lload 20
    //   1644: lstore 18
    //   1646: goto +352 -> 1998
    //   1649: aload 39
    //   1651: getfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1654: lstore 16
    //   1656: lload 14
    //   1658: lload 16
    //   1660: ladd
    //   1661: lstore 22
    //   1663: lload 6
    //   1665: lstore 14
    //   1667: lload 6
    //   1669: aload 39
    //   1671: getfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   1674: ladd
    //   1675: lstore 16
    //   1677: lload 16
    //   1679: lstore 14
    //   1681: aload 39
    //   1683: getfield 288	com/tencent/mobileqq/statistics/storage/StorageItem:g	J
    //   1686: lstore 6
    //   1688: lload 20
    //   1690: lload 6
    //   1692: ladd
    //   1693: lstore 20
    //   1695: lload 12
    //   1697: lstore 6
    //   1699: lload 22
    //   1701: lstore 14
    //   1703: lload 20
    //   1705: lstore 12
    //   1707: lload 16
    //   1709: lstore 32
    //   1711: lload 12
    //   1713: lstore 30
    //   1715: lload 10
    //   1717: lstore 28
    //   1719: lload 8
    //   1721: lstore 26
    //   1723: lload 6
    //   1725: lstore 24
    //   1727: lload 14
    //   1729: lstore 22
    //   1731: lload 18
    //   1733: lstore 20
    //   1735: aload 39
    //   1737: getfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1740: lstore 34
    //   1742: lload 18
    //   1744: lload 34
    //   1746: ladd
    //   1747: lstore 18
    //   1749: lload 18
    //   1751: lstore 32
    //   1753: lload 16
    //   1755: lstore 30
    //   1757: lload 12
    //   1759: lstore 28
    //   1761: lload 10
    //   1763: lstore 26
    //   1765: lload 8
    //   1767: lstore 24
    //   1769: lload 6
    //   1771: lstore 22
    //   1773: lload 14
    //   1775: lstore 20
    //   1777: new 120	java/lang/StringBuilder
    //   1780: dup
    //   1781: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   1784: astore 37
    //   1786: lload 18
    //   1788: lstore 32
    //   1790: lload 16
    //   1792: lstore 30
    //   1794: lload 12
    //   1796: lstore 28
    //   1798: lload 10
    //   1800: lstore 26
    //   1802: lload 8
    //   1804: lstore 24
    //   1806: lload 6
    //   1808: lstore 22
    //   1810: lload 14
    //   1812: lstore 20
    //   1814: aload 37
    //   1816: ldc_w 501
    //   1819: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1822: pop
    //   1823: lload 18
    //   1825: lstore 32
    //   1827: lload 16
    //   1829: lstore 30
    //   1831: lload 12
    //   1833: lstore 28
    //   1835: lload 10
    //   1837: lstore 26
    //   1839: lload 8
    //   1841: lstore 24
    //   1843: lload 6
    //   1845: lstore 22
    //   1847: lload 14
    //   1849: lstore 20
    //   1851: aload 37
    //   1853: aload 39
    //   1855: invokevirtual 168	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   1858: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1861: pop
    //   1862: lload 18
    //   1864: lstore 32
    //   1866: lload 16
    //   1868: lstore 30
    //   1870: lload 12
    //   1872: lstore 28
    //   1874: lload 10
    //   1876: lstore 26
    //   1878: lload 8
    //   1880: lstore 24
    //   1882: lload 6
    //   1884: lstore 22
    //   1886: lload 14
    //   1888: lstore 20
    //   1890: ldc 170
    //   1892: iconst_1
    //   1893: aload 37
    //   1895: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1898: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1901: lload 16
    //   1903: lstore 20
    //   1905: lload 12
    //   1907: lstore 16
    //   1909: lload 6
    //   1911: lstore 12
    //   1913: goto +146 -> 2059
    //   1916: astore 37
    //   1918: lload 32
    //   1920: lstore 6
    //   1922: lload 30
    //   1924: lstore 16
    //   1926: lload 28
    //   1928: lstore 10
    //   1930: lload 26
    //   1932: lstore 8
    //   1934: lload 24
    //   1936: lstore 12
    //   1938: lload 22
    //   1940: lstore 14
    //   1942: goto -413 -> 1529
    //   1945: astore 37
    //   1947: lload 14
    //   1949: lstore 6
    //   1951: lload 22
    //   1953: lstore 14
    //   1955: goto +5 -> 1960
    //   1958: astore 37
    //   1960: lload 18
    //   1962: lstore 16
    //   1964: lload 20
    //   1966: lstore 18
    //   1968: goto +30 -> 1998
    //   1971: astore 37
    //   1973: lload 18
    //   1975: lstore 16
    //   1977: lload 20
    //   1979: lstore 18
    //   1981: goto +17 -> 1998
    //   1984: astore 37
    //   1986: lload 18
    //   1988: lstore 20
    //   1990: lload 16
    //   1992: lstore 18
    //   1994: lload 20
    //   1996: lstore 16
    //   1998: aload 37
    //   2000: invokevirtual 502	java/lang/Exception:printStackTrace	()V
    //   2003: new 120	java/lang/StringBuilder
    //   2006: dup
    //   2007: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   2010: astore 39
    //   2012: aload 39
    //   2014: ldc_w 504
    //   2017: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2020: pop
    //   2021: aload 39
    //   2023: aload 37
    //   2025: invokevirtual 508	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   2028: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2031: pop
    //   2032: ldc 170
    //   2034: iconst_1
    //   2035: aload 39
    //   2037: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2040: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2043: lload 16
    //   2045: lstore 22
    //   2047: lload 18
    //   2049: lstore 16
    //   2051: lload 6
    //   2053: lstore 20
    //   2055: lload 22
    //   2057: lstore 18
    //   2059: aload_1
    //   2060: ifnull +684 -> 2744
    //   2063: aload_1
    //   2064: iload_2
    //   2065: iconst_1
    //   2066: iadd
    //   2067: iload_3
    //   2068: iconst_2
    //   2069: isub
    //   2070: imul
    //   2071: aload_0
    //   2072: getfield 71	com/tencent/mobileqq/statistics/storage/StorageReport:g	Ljava/util/ArrayList;
    //   2075: invokevirtual 187	java/util/ArrayList:size	()I
    //   2078: idiv
    //   2079: invokeinterface 424 2 0
    //   2084: goto +660 -> 2744
    //   2087: aload_0
    //   2088: getfield 71	com/tencent/mobileqq/statistics/storage/StorageReport:g	Ljava/util/ArrayList;
    //   2091: aload_0
    //   2092: getfield 83	com/tencent/mobileqq/statistics/storage/StorageReport:i	Lcom/tencent/mobileqq/statistics/storage/StorageReport$MyFileLargeComparator;
    //   2095: invokestatic 197	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   2098: ldc 170
    //   2100: iconst_1
    //   2101: ldc_w 513
    //   2104: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2107: iconst_0
    //   2108: istore_2
    //   2109: iload_2
    //   2110: aload_0
    //   2111: getfield 71	com/tencent/mobileqq/statistics/storage/StorageReport:g	Ljava/util/ArrayList;
    //   2114: invokevirtual 187	java/util/ArrayList:size	()I
    //   2117: if_icmpge +25 -> 2142
    //   2120: aload_0
    //   2121: aload_0
    //   2122: getfield 71	com/tencent/mobileqq/statistics/storage/StorageReport:g	Ljava/util/ArrayList;
    //   2125: iload_2
    //   2126: invokevirtual 201	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2129: checkcast 45	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2132: invokespecial 180	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2135: iload_2
    //   2136: iconst_1
    //   2137: iadd
    //   2138: istore_2
    //   2139: goto -30 -> 2109
    //   2142: new 120	java/lang/StringBuilder
    //   2145: dup
    //   2146: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   2149: astore 37
    //   2151: aload 37
    //   2153: ldc_w 515
    //   2156: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2159: pop
    //   2160: aload 37
    //   2162: lload 18
    //   2164: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2167: pop
    //   2168: ldc 170
    //   2170: iconst_1
    //   2171: aload 37
    //   2173: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2176: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2179: new 45	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2182: dup
    //   2183: invokespecial 471	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   2186: astore 37
    //   2188: aload 37
    //   2190: iconst_0
    //   2191: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:e	Z
    //   2194: aload 37
    //   2196: ldc_w 517
    //   2199: putfield 156	com/tencent/mobileqq/statistics/storage/StorageItem:b	Ljava/lang/String;
    //   2202: aload 37
    //   2204: lload 6
    //   2206: lload 8
    //   2208: ladd
    //   2209: putfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   2212: aload 37
    //   2214: lload 16
    //   2216: lload 12
    //   2218: ladd
    //   2219: putfield 288	com/tencent/mobileqq/statistics/storage/StorageItem:g	J
    //   2222: aload 37
    //   2224: lconst_0
    //   2225: putfield 161	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2228: aload 37
    //   2230: lload 18
    //   2232: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2235: aload_0
    //   2236: aload 37
    //   2238: invokespecial 180	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2241: new 120	java/lang/StringBuilder
    //   2244: dup
    //   2245: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   2248: astore 39
    //   2250: aload 39
    //   2252: ldc_w 519
    //   2255: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2258: pop
    //   2259: aload 39
    //   2261: aload 37
    //   2263: invokevirtual 168	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   2266: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2269: pop
    //   2270: ldc 170
    //   2272: iconst_1
    //   2273: aload 39
    //   2275: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2278: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2281: new 45	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2284: dup
    //   2285: invokespecial 471	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   2288: astore 37
    //   2290: aload 37
    //   2292: iconst_0
    //   2293: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:e	Z
    //   2296: aload 37
    //   2298: ldc_w 521
    //   2301: putfield 156	com/tencent/mobileqq/statistics/storage/StorageItem:b	Ljava/lang/String;
    //   2304: aload 37
    //   2306: aload_0
    //   2307: aload_0
    //   2308: getfield 99	com/tencent/mobileqq/statistics/storage/StorageReport:p	Ljava/util/ArrayList;
    //   2311: invokespecial 523	com/tencent/mobileqq/statistics/storage/StorageReport:b	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   2314: putfield 146	com/tencent/mobileqq/statistics/storage/StorageItem:a	Ljava/lang/String;
    //   2317: aload 37
    //   2319: lload 6
    //   2321: putfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   2324: aload 37
    //   2326: lload 16
    //   2328: putfield 288	com/tencent/mobileqq/statistics/storage/StorageItem:g	J
    //   2331: aload 37
    //   2333: lconst_0
    //   2334: putfield 161	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2337: aload 37
    //   2339: lload 14
    //   2341: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2344: aload_0
    //   2345: aload 37
    //   2347: invokespecial 180	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2350: new 120	java/lang/StringBuilder
    //   2353: dup
    //   2354: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   2357: astore 39
    //   2359: aload 39
    //   2361: ldc_w 525
    //   2364: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2367: pop
    //   2368: aload 39
    //   2370: aload 37
    //   2372: invokevirtual 168	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   2375: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2378: pop
    //   2379: ldc 170
    //   2381: iconst_1
    //   2382: aload 39
    //   2384: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2387: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2390: new 45	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2393: dup
    //   2394: invokespecial 471	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   2397: astore 37
    //   2399: iconst_0
    //   2400: istore 4
    //   2402: aload 37
    //   2404: iconst_0
    //   2405: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:e	Z
    //   2408: aload 37
    //   2410: ldc_w 527
    //   2413: putfield 156	com/tencent/mobileqq/statistics/storage/StorageItem:b	Ljava/lang/String;
    //   2416: aload 37
    //   2418: aload_0
    //   2419: aload_0
    //   2420: getfield 101	com/tencent/mobileqq/statistics/storage/StorageReport:q	Ljava/util/ArrayList;
    //   2423: invokespecial 523	com/tencent/mobileqq/statistics/storage/StorageReport:b	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   2426: putfield 146	com/tencent/mobileqq/statistics/storage/StorageItem:a	Ljava/lang/String;
    //   2429: aload 37
    //   2431: lload 8
    //   2433: putfield 163	com/tencent/mobileqq/statistics/storage/StorageItem:f	J
    //   2436: aload 37
    //   2438: lload 12
    //   2440: putfield 288	com/tencent/mobileqq/statistics/storage/StorageItem:g	J
    //   2443: aload 37
    //   2445: lconst_0
    //   2446: putfield 161	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2449: aload 37
    //   2451: lload 10
    //   2453: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2456: aload_0
    //   2457: aload 37
    //   2459: invokespecial 180	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2462: new 120	java/lang/StringBuilder
    //   2465: dup
    //   2466: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   2469: astore 39
    //   2471: aload 39
    //   2473: ldc_w 529
    //   2476: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2479: pop
    //   2480: aload 39
    //   2482: aload 37
    //   2484: invokevirtual 168	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   2487: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2490: pop
    //   2491: ldc 170
    //   2493: iconst_1
    //   2494: aload 39
    //   2496: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2499: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2502: ldc 170
    //   2504: iconst_1
    //   2505: ldc_w 531
    //   2508: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2511: iconst_0
    //   2512: istore_2
    //   2513: iload_2
    //   2514: aload_0
    //   2515: getfield 69	com/tencent/mobileqq/statistics/storage/StorageReport:f	Ljava/util/ArrayList;
    //   2518: invokevirtual 187	java/util/ArrayList:size	()I
    //   2521: if_icmpge +68 -> 2589
    //   2524: aload_0
    //   2525: getfield 69	com/tencent/mobileqq/statistics/storage/StorageReport:f	Ljava/util/ArrayList;
    //   2528: iload_2
    //   2529: invokevirtual 201	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2532: checkcast 45	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2535: astore 37
    //   2537: new 120	java/lang/StringBuilder
    //   2540: dup
    //   2541: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   2544: astore 39
    //   2546: aload 39
    //   2548: ldc_w 533
    //   2551: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2554: pop
    //   2555: aload 39
    //   2557: aload 37
    //   2559: getfield 146	com/tencent/mobileqq/statistics/storage/StorageItem:a	Ljava/lang/String;
    //   2562: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2565: pop
    //   2566: aload 37
    //   2568: aload 39
    //   2570: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2573: putfield 146	com/tencent/mobileqq/statistics/storage/StorageItem:a	Ljava/lang/String;
    //   2576: aload_0
    //   2577: aload 37
    //   2579: invokespecial 180	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2582: iload_2
    //   2583: iconst_1
    //   2584: iadd
    //   2585: istore_2
    //   2586: goto -73 -> 2513
    //   2589: aload_0
    //   2590: getfield 85	com/tencent/mobileqq/statistics/storage/StorageReport:j	Z
    //   2593: ifeq +162 -> 2755
    //   2596: aload 38
    //   2598: invokeinterface 537 1 0
    //   2603: ldc_w 450
    //   2606: aload_0
    //   2607: getfield 87	com/tencent/mobileqq/statistics/storage/StorageReport:k	J
    //   2610: invokeinterface 542 4 0
    //   2615: invokeinterface 545 1 0
    //   2620: pop
    //   2621: goto +134 -> 2755
    //   2624: iload_2
    //   2625: bipush 7
    //   2627: if_icmpge +44 -> 2671
    //   2630: getstatic 51	com/tencent/mobileqq/statistics/storage/StorageReport:c	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   2633: aload_0
    //   2634: getfield 99	com/tencent/mobileqq/statistics/storage/StorageReport:p	Ljava/util/ArrayList;
    //   2637: iload_2
    //   2638: invokevirtual 201	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2641: checkcast 547	com/tencent/commonsdk/pool/RecyclablePool$Recyclable
    //   2644: invokevirtual 208	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   2647: getstatic 51	com/tencent/mobileqq/statistics/storage/StorageReport:c	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   2650: aload_0
    //   2651: getfield 101	com/tencent/mobileqq/statistics/storage/StorageReport:q	Ljava/util/ArrayList;
    //   2654: iload_2
    //   2655: invokevirtual 201	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2658: checkcast 547	com/tencent/commonsdk/pool/RecyclablePool$Recyclable
    //   2661: invokevirtual 208	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   2664: iload_2
    //   2665: iconst_1
    //   2666: iadd
    //   2667: istore_2
    //   2668: goto -44 -> 2624
    //   2671: aload_1
    //   2672: ifnull +10 -> 2682
    //   2675: aload_1
    //   2676: iload_3
    //   2677: invokeinterface 424 2 0
    //   2682: aload_0
    //   2683: monitorexit
    //   2684: lload 18
    //   2686: lreturn
    //   2687: astore_1
    //   2688: aload_0
    //   2689: monitorexit
    //   2690: goto +5 -> 2695
    //   2693: aload_1
    //   2694: athrow
    //   2695: goto -2 -> 2693
    //   2698: iload_2
    //   2699: iconst_1
    //   2700: iadd
    //   2701: istore_2
    //   2702: goto -2368 -> 334
    //   2705: lconst_0
    //   2706: lstore 12
    //   2708: lconst_0
    //   2709: lstore 8
    //   2711: iconst_1
    //   2712: istore_2
    //   2713: goto -2178 -> 535
    //   2716: iload_2
    //   2717: iconst_1
    //   2718: iadd
    //   2719: istore_2
    //   2720: goto -2185 -> 535
    //   2723: iconst_0
    //   2724: istore_2
    //   2725: goto -2075 -> 650
    //   2728: iload 4
    //   2730: iconst_1
    //   2731: iadd
    //   2732: istore 4
    //   2734: goto -2041 -> 693
    //   2737: iload_2
    //   2738: iconst_1
    //   2739: iadd
    //   2740: istore_2
    //   2741: goto -2091 -> 650
    //   2744: iload_2
    //   2745: iconst_1
    //   2746: iadd
    //   2747: istore_2
    //   2748: lload 20
    //   2750: lstore 6
    //   2752: goto -1711 -> 1041
    //   2755: iload 4
    //   2757: istore_2
    //   2758: goto -134 -> 2624
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2761	0	this	StorageReport
    //   0	2761	1	paramIProgressCallback	com.tencent.mobileqq.activity.QQSettingCleanActivity.IProgressCallback
    //   0	2761	2	paramInt1	int
    //   0	2761	3	paramInt2	int
    //   691	2065	4	i1	int
    //   1163	306	5	i2	int
    //   122	2629	6	l1	long
    //   340	2370	8	l2	long
    //   326	2126	10	l3	long
    //   336	2371	12	l4	long
    //   1035	1305	14	l5	long
    //   1022	1305	16	l6	long
    //   1019	1666	18	l7	long
    //   1031	1718	20	l8	long
    //   1167	889	22	l9	long
    //   1205	730	24	l10	long
    //   1201	730	26	l11	long
    //   1197	730	28	l12	long
    //   1193	730	30	l13	long
    //   1189	730	32	l14	long
    //   1404	341	34	l15	long
    //   1559	3	36	bool	boolean
    //   33	972	37	localObject1	Object
    //   1087	3	37	localInterruptedException	java.lang.InterruptedException
    //   1144	37	37	arrayOfString	String[]
    //   1477	1	37	localException1	java.lang.Exception
    //   1490	1	37	localException2	java.lang.Exception
    //   1523	1	37	localException3	java.lang.Exception
    //   1627	1	37	localException4	java.lang.Exception
    //   1632	1	37	localException5	java.lang.Exception
    //   1784	110	37	localStringBuilder	StringBuilder
    //   1916	1	37	localException6	java.lang.Exception
    //   1945	1	37	localException7	java.lang.Exception
    //   1958	1	37	localException8	java.lang.Exception
    //   1971	1	37	localException9	java.lang.Exception
    //   1984	40	37	localException10	java.lang.Exception
    //   2149	429	37	localObject2	Object
    //   109	2488	38	localSharedPreferences	android.content.SharedPreferences
    //   298	2271	39	localObject3	Object
    //   312	1241	40	localObject4	Object
    //   356	1097	41	localObject5	Object
    //   396	966	42	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   1056	1075	1087	java/lang/InterruptedException
    //   1078	1084	1087	java/lang/InterruptedException
    //   1410	1464	1477	java/lang/Exception
    //   1215	1224	1490	java/lang/Exception
    //   1252	1260	1490	java/lang/Exception
    //   1288	1296	1490	java/lang/Exception
    //   1324	1332	1490	java/lang/Exception
    //   1360	1371	1490	java/lang/Exception
    //   1777	1786	1490	java/lang/Exception
    //   1814	1823	1490	java/lang/Exception
    //   1851	1862	1490	java/lang/Exception
    //   1890	1901	1490	java/lang/Exception
    //   1151	1162	1523	java/lang/Exception
    //   1598	1605	1627	java/lang/Exception
    //   1570	1580	1632	java/lang/Exception
    //   1584	1591	1632	java/lang/Exception
    //   1399	1406	1916	java/lang/Exception
    //   1735	1742	1916	java/lang/Exception
    //   1667	1677	1945	java/lang/Exception
    //   1681	1688	1945	java/lang/Exception
    //   1649	1656	1958	java/lang/Exception
    //   1552	1561	1971	java/lang/Exception
    //   1132	1146	1984	java/lang/Exception
    //   6	13	2687	finally
    //   13	35	2687	finally
    //   40	49	2687	finally
    //   49	131	2687	finally
    //   138	169	2687	finally
    //   169	197	2687	finally
    //   205	275	2687	finally
    //   282	314	2687	finally
    //   319	325	2687	finally
    //   342	508	2687	finally
    //   511	526	2687	finally
    //   535	647	2687	finally
    //   650	679	2687	finally
    //   684	690	2687	finally
    //   693	840	2687	finally
    //   843	955	2687	finally
    //   958	970	2687	finally
    //   973	1012	2687	finally
    //   1041	1050	2687	finally
    //   1056	1075	2687	finally
    //   1078	1084	2687	finally
    //   1089	1094	2687	finally
    //   1094	1132	2687	finally
    //   1132	1146	2687	finally
    //   1151	1162	2687	finally
    //   1215	1224	2687	finally
    //   1252	1260	2687	finally
    //   1288	1296	2687	finally
    //   1324	1332	2687	finally
    //   1360	1371	2687	finally
    //   1399	1406	2687	finally
    //   1410	1464	2687	finally
    //   1552	1561	2687	finally
    //   1570	1580	2687	finally
    //   1584	1591	2687	finally
    //   1598	1605	2687	finally
    //   1649	1656	2687	finally
    //   1667	1677	2687	finally
    //   1681	1688	2687	finally
    //   1735	1742	2687	finally
    //   1777	1786	2687	finally
    //   1814	1823	2687	finally
    //   1851	1862	2687	finally
    //   1890	1901	2687	finally
    //   1998	2043	2687	finally
    //   2063	2084	2687	finally
    //   2087	2107	2687	finally
    //   2109	2135	2687	finally
    //   2142	2399	2687	finally
    //   2402	2511	2687	finally
    //   2513	2582	2687	finally
    //   2589	2621	2687	finally
    //   2630	2664	2687	finally
    //   2675	2682	2687	finally
  }
  
  /* Error */
  public long a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	com/tencent/mobileqq/statistics/storage/StorageReport:l	Ljava/lang/reflect/Field;
    //   4: ifnonnull +37 -> 41
    //   7: aload_0
    //   8: ldc_w 559
    //   11: invokestatic 565	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   14: ldc_w 567
    //   17: invokevirtual 571	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   20: putfield 89	com/tencent/mobileqq/statistics/storage/StorageReport:l	Ljava/lang/reflect/Field;
    //   23: aload_0
    //   24: getfield 89	com/tencent/mobileqq/statistics/storage/StorageReport:l	Ljava/lang/reflect/Field;
    //   27: invokevirtual 576	java/lang/reflect/Field:isAccessible	()Z
    //   30: ifne +11 -> 41
    //   33: aload_0
    //   34: getfield 89	com/tencent/mobileqq/statistics/storage/StorageReport:l	Ljava/lang/reflect/Field;
    //   37: iconst_1
    //   38: invokevirtual 580	java/lang/reflect/Field:setAccessible	(Z)V
    //   41: aload_0
    //   42: getfield 89	com/tencent/mobileqq/statistics/storage/StorageReport:l	Ljava/lang/reflect/Field;
    //   45: aconst_null
    //   46: invokevirtual 582	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore 4
    //   51: aload_0
    //   52: getfield 97	com/tencent/mobileqq/statistics/storage/StorageReport:o	Ljava/lang/reflect/Method;
    //   55: ifnonnull +27 -> 82
    //   58: aload_0
    //   59: aload 4
    //   61: invokevirtual 586	java/lang/Object:getClass	()Ljava/lang/Class;
    //   64: ldc_w 588
    //   67: iconst_1
    //   68: anewarray 561	java/lang/Class
    //   71: dup
    //   72: iconst_0
    //   73: ldc 53
    //   75: aastore
    //   76: invokevirtual 592	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   79: putfield 97	com/tencent/mobileqq/statistics/storage/StorageReport:o	Ljava/lang/reflect/Method;
    //   82: aload_0
    //   83: getfield 97	com/tencent/mobileqq/statistics/storage/StorageReport:o	Ljava/lang/reflect/Method;
    //   86: aload 4
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload_1
    //   95: invokevirtual 235	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   98: aastore
    //   99: invokevirtual 598	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   102: astore_1
    //   103: aload_0
    //   104: getfield 95	com/tencent/mobileqq/statistics/storage/StorageReport:n	Ljava/lang/reflect/Field;
    //   107: ifnonnull +35 -> 142
    //   110: aload_0
    //   111: aload_1
    //   112: invokevirtual 586	java/lang/Object:getClass	()Ljava/lang/Class;
    //   115: ldc_w 600
    //   118: invokevirtual 571	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   121: putfield 95	com/tencent/mobileqq/statistics/storage/StorageReport:n	Ljava/lang/reflect/Field;
    //   124: aload_0
    //   125: getfield 95	com/tencent/mobileqq/statistics/storage/StorageReport:n	Ljava/lang/reflect/Field;
    //   128: invokevirtual 576	java/lang/reflect/Field:isAccessible	()Z
    //   131: ifne +11 -> 142
    //   134: aload_0
    //   135: getfield 95	com/tencent/mobileqq/statistics/storage/StorageReport:n	Ljava/lang/reflect/Field;
    //   138: iconst_1
    //   139: invokevirtual 580	java/lang/reflect/Field:setAccessible	(Z)V
    //   142: aload_0
    //   143: getfield 95	com/tencent/mobileqq/statistics/storage/StorageReport:n	Ljava/lang/reflect/Field;
    //   146: aload_1
    //   147: invokevirtual 603	java/lang/reflect/Field:getLong	(Ljava/lang/Object;)J
    //   150: lstore_2
    //   151: lload_2
    //   152: lconst_0
    //   153: lcmp
    //   154: ifne +5 -> 159
    //   157: lconst_0
    //   158: lreturn
    //   159: aload_0
    //   160: getfield 87	com/tencent/mobileqq/statistics/storage/StorageReport:k	J
    //   163: lload_2
    //   164: lsub
    //   165: lstore_2
    //   166: lload_2
    //   167: lconst_0
    //   168: lcmp
    //   169: ifge +5 -> 174
    //   172: lconst_0
    //   173: lreturn
    //   174: lload_2
    //   175: lreturn
    //   176: astore_1
    //   177: goto +38 -> 215
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 604	java/lang/NoSuchFieldException:printStackTrace	()V
    //   185: lconst_0
    //   186: lreturn
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 605	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   192: lconst_0
    //   193: lreturn
    //   194: astore_1
    //   195: aload_1
    //   196: invokevirtual 606	java/lang/IllegalAccessException:printStackTrace	()V
    //   199: lconst_0
    //   200: lreturn
    //   201: astore_1
    //   202: aload_1
    //   203: invokevirtual 607	java/lang/NoSuchMethodException:printStackTrace	()V
    //   206: lconst_0
    //   207: lreturn
    //   208: astore_1
    //   209: aload_1
    //   210: invokevirtual 608	java/lang/ClassNotFoundException:printStackTrace	()V
    //   213: lconst_0
    //   214: lreturn
    //   215: aload_1
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	StorageReport
    //   0	217	1	paramFile	File
    //   150	25	2	l1	long
    //   49	38	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	41	176	finally
    //   41	82	176	finally
    //   82	142	176	finally
    //   142	151	176	finally
    //   181	185	176	finally
    //   188	192	176	finally
    //   195	199	176	finally
    //   202	206	176	finally
    //   209	213	176	finally
    //   0	41	180	java/lang/NoSuchFieldException
    //   41	82	180	java/lang/NoSuchFieldException
    //   82	142	180	java/lang/NoSuchFieldException
    //   142	151	180	java/lang/NoSuchFieldException
    //   0	41	187	java/lang/reflect/InvocationTargetException
    //   41	82	187	java/lang/reflect/InvocationTargetException
    //   82	142	187	java/lang/reflect/InvocationTargetException
    //   142	151	187	java/lang/reflect/InvocationTargetException
    //   0	41	194	java/lang/IllegalAccessException
    //   41	82	194	java/lang/IllegalAccessException
    //   82	142	194	java/lang/IllegalAccessException
    //   142	151	194	java/lang/IllegalAccessException
    //   0	41	201	java/lang/NoSuchMethodException
    //   41	82	201	java/lang/NoSuchMethodException
    //   82	142	201	java/lang/NoSuchMethodException
    //   142	151	201	java/lang/NoSuchMethodException
    //   0	41	208	java/lang/ClassNotFoundException
    //   41	82	208	java/lang/ClassNotFoundException
    //   82	142	208	java/lang/ClassNotFoundException
    //   142	151	208	java/lang/ClassNotFoundException
  }
  
  public long a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return 0L;
      }
      long l1 = 0L;
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        String str = (String)paramArrayList.get(i1);
        String[] arrayOfString = new File(str).list();
        long l2 = l1;
        if (arrayOfString != null)
        {
          l2 = l1;
          if (arrayOfString.length > 0)
          {
            int i3 = arrayOfString.length;
            int i2 = 0;
            while (i2 < i3)
            {
              File localFile = new File(str, arrayOfString[i2]);
              l2 = l1;
              if (localFile.isFile()) {
                l2 = l1 + localFile.length();
              }
              i2 += 1;
              l1 = l2;
            }
            l2 = l1;
          }
        }
        i1 += 1;
        l1 = l2;
      }
      return l1;
    }
    return 0L;
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public boolean b()
  {
    return this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.storage.StorageReport
 * JD-Core Version:    0.7.0.1
 */