package com.tencent.mobileqq.statistics.storage;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class StorageReport
{
  private static volatile Handler jdField_a_of_type_AndroidOsHandler;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static final RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(StorageItem.class, 50);
  private static volatile StorageReport jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport;
  public static final String[] a;
  public static final String[] b;
  private long jdField_a_of_type_Long;
  private StorageReport.MyFileAccessComparator jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport$MyFileAccessComparator = new StorageReport.MyFileAccessComparator(null);
  private StorageReport.MyFileLargeComparator jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport$MyFileLargeComparator = new StorageReport.MyFileLargeComparator(null);
  private String jdField_a_of_type_JavaLangString;
  private Field jdField_a_of_type_JavaLangReflectField;
  private Method jdField_a_of_type_JavaLangReflectMethod;
  private ArrayList<StorageItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private boolean jdField_a_of_type_Boolean;
  private Field jdField_b_of_type_JavaLangReflectField;
  private ArrayList<StorageItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList(40);
  private boolean jdField_b_of_type_Boolean;
  private ArrayList<StorageItem> c;
  private ArrayList<StorageItem> d;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "sdcard/Tencent/MobileQQ", "sdcard/Tencent/QQ_Images", "sdcard/Tencent/QQfile_recv", "sdcard/Tencent/QQ_Collection", "sdcard/Tencent/QQ_Favorite", "sdcard/Tencent/QQ_Video", "sdcard/Tencent/QQfile_share", "sdcard/Tencent/QQHomework_recv", "sdcard/Tencent/QQHomework_attach", "sdcard/Tencent/AIO_FORWARD", "sdcard/Tencent/QQ_business", "sdcard/Tencent/msflogs" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "data/data/com.tencent.mobileqq", "data/data/com.tencent.mobileqq/files" };
  }
  
  private StorageReport()
  {
    boolean bool = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangReflectField = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangReflectField = null;
    this.jdField_a_of_type_JavaLangReflectMethod = null;
    this.c = new ArrayList(7);
    this.d = new ArrayList(7);
    this.jdField_b_of_type_Boolean = false;
    if (0.001000000047497451D < Math.random()) {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
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
      localObject = (StorageItem)jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(StorageItem.class);
      ((StorageItem)localObject).jdField_a_of_type_JavaLangString = paramString2;
      ((StorageItem)localObject).jdField_a_of_type_Boolean = true;
      ((StorageItem)localObject).jdField_a_of_type_Long = localFile.length();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString2);
      ((StorageItem)localObject).jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      ((StorageItem)localObject).jdField_b_of_type_Long = a(localFile);
      ((StorageItem)localObject).c = 1L;
      if (((StorageItem)localObject).jdField_a_of_type_Long >= 524288.0D)
      {
        paramString1 = new StringBuilder();
        paramString1.append("--scan qq-- file info: ");
        paramString1.append(((StorageItem)localObject).toString());
        QLog.d("StorageReport", 1, paramString1.toString());
      }
      if (((StorageItem)localObject).jdField_a_of_type_Long >= 2097152L) {
        a((StorageItem)localObject);
      }
      a((StorageItem)localObject, ((StorageItem)localObject).jdField_a_of_type_Long);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 20)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() == 20) {
          Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport$MyFileAccessComparator);
        }
        return ((StorageItem)localObject).jdField_a_of_type_Long;
      }
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList;
      paramString1 = (StorageItem)paramString1.get(paramString1.size() - 1);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() >= 20) && (((StorageItem)localObject).jdField_b_of_type_Long > paramString1.jdField_b_of_type_Long))
      {
        paramString2 = this.jdField_a_of_type_JavaUtilArrayList;
        paramString2.remove(paramString2.size() - 1);
        jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramString1);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport$MyFileAccessComparator);
        return ((StorageItem)localObject).jdField_a_of_type_Long;
      }
      jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle((RecyclablePool.Recyclable)localObject);
      return ((StorageItem)localObject).jdField_a_of_type_Long;
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
          int j = arrayOfString.length;
          int i = 0;
          for (;;)
          {
            l4 = l1;
            l3 = l2;
            if (i >= j) {
              break;
            }
            String str = arrayOfString[i];
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
            i += 1;
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
  
  public static Handler a()
  {
    try
    {
      if (jdField_a_of_type_AndroidOsHandler == null)
      {
        jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("SETTING_STORAGE_CLEAN_SCAN", 0);
        jdField_a_of_type_AndroidOsHandlerThread.start();
        jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      Handler localHandler = jdField_a_of_type_AndroidOsHandler;
      return localHandler;
    }
    finally {}
  }
  
  public static StorageReport a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport == null) {
          jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport = new StorageReport();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport;
  }
  
  private String a(ArrayList<StorageItem> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    int i = 0;
    while (i < paramArrayList.size())
    {
      StorageItem localStorageItem = (StorageItem)paramArrayList.get(i);
      localStringBuilder.append(localStorageItem.c);
      localStringBuilder.append("-");
      localStringBuilder.append(localStorageItem.jdField_a_of_type_Long);
      if (i < paramArrayList.size() - 1) {
        localStringBuilder.append("|");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_AndroidOsHandler != null)
      {
        jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
        jdField_a_of_type_AndroidOsHandler = null;
      }
      if (jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        jdField_a_of_type_AndroidOsHandlerThread.quit();
        jdField_a_of_type_AndroidOsHandlerThread = null;
      }
      return;
    }
    finally {}
  }
  
  private void a(StorageItem paramStorageItem)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    HashMap localHashMap = new HashMap(20);
    localHashMap.put("report_key", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("path", paramStorageItem.jdField_b_of_type_JavaLangString);
    localHashMap.put("name", paramStorageItem.jdField_a_of_type_JavaLangString);
    localHashMap.put("size", String.valueOf(paramStorageItem.jdField_a_of_type_Long));
    localHashMap.put("accessTime", String.valueOf(paramStorageItem.jdField_b_of_type_Long));
    localHashMap.put("isFile", String.valueOf(paramStorageItem.jdField_a_of_type_Boolean));
    localHashMap.put("fileCount", String.valueOf(paramStorageItem.c));
    localHashMap.put("dirCount", String.valueOf(paramStorageItem.d));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--scan qq-- file report to tdw : report key = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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
      if (TextUtils.isEmpty(paramStorageItem.jdField_b_of_type_JavaLangString)) {
        return;
      }
      int i = 0;
      if (paramLong >= 10240L) {
        if ((paramLong >= 10240L) && (paramLong < 102400L)) {
          i = 1;
        } else if ((paramLong >= 102400L) && (paramLong < 1048576L)) {
          i = 2;
        } else if ((paramLong >= 1048576L) && (paramLong < 2097152L)) {
          i = 3;
        } else if ((paramLong >= 2097152L) && (paramLong < 10485760L)) {
          i = 4;
        } else if ((paramLong >= 10485760L) && (paramLong < 104857600L)) {
          i = 5;
        } else if (paramLong >= 104857600L) {
          i = 6;
        }
      }
      if (paramStorageItem.jdField_b_of_type_JavaLangString.contains("data/data/com.tencent.mobileqq")) {
        paramStorageItem = (StorageItem)this.d.get(i);
      } else {
        paramStorageItem = (StorageItem)this.c.get(i);
      }
      paramStorageItem.jdField_a_of_type_Long += paramLong;
      paramStorageItem.c += 1L;
    }
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
    //   8: invokeinterface 383 2 0
    //   13: aload_0
    //   14: invokestatic 388	java/lang/System:currentTimeMillis	()J
    //   17: ldc2_w 389
    //   20: ldiv
    //   21: putfield 96	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   24: invokestatic 349	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   27: invokevirtual 394	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   30: checkcast 396	com/tencent/mobileqq/app/QQAppInterface
    //   33: astore 49
    //   35: aload 49
    //   37: ifnull +12 -> 49
    //   40: aload_0
    //   41: aload 49
    //   43: invokevirtual 399	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   46: putfield 102	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   49: new 129	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   56: astore 49
    //   58: aload 49
    //   60: aload_0
    //   61: getfield 102	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 49
    //   70: ldc_w 401
    //   73: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 49
    //   79: aload_0
    //   80: getfield 96	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   83: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   86: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_0
    //   91: aload 49
    //   93: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: putfield 102	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   99: invokestatic 349	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   102: ldc_w 403
    //   105: iconst_0
    //   106: invokevirtual 407	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   109: astore 49
    //   111: aload 49
    //   113: ldc_w 409
    //   116: lconst_0
    //   117: invokeinterface 415 4 0
    //   122: lstore 8
    //   124: aload_0
    //   125: getfield 94	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Boolean	Z
    //   128: ifeq +41 -> 169
    //   131: lload 8
    //   133: lconst_0
    //   134: lcmp
    //   135: ifle +34 -> 169
    //   138: aload_0
    //   139: getfield 96	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   142: lload 8
    //   144: lsub
    //   145: invokestatic 419	java/lang/Math:abs	(J)J
    //   148: ldc2_w 420
    //   151: lcmp
    //   152: ifge +17 -> 169
    //   155: aload_0
    //   156: iconst_0
    //   157: putfield 94	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Boolean	Z
    //   160: ldc 176
    //   162: iconst_2
    //   163: ldc_w 423
    //   166: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload_0
    //   170: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   173: invokevirtual 426	java/util/ArrayList:clear	()V
    //   176: aload_0
    //   177: getfield 78	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   180: invokevirtual 426	java/util/ArrayList:clear	()V
    //   183: aload_0
    //   184: getfield 108	com/tencent/mobileqq/statistics/storage/StorageReport:c	Ljava/util/ArrayList;
    //   187: invokevirtual 426	java/util/ArrayList:clear	()V
    //   190: aload_0
    //   191: getfield 110	com/tencent/mobileqq/statistics/storage/StorageReport:d	Ljava/util/ArrayList;
    //   194: invokevirtual 426	java/util/ArrayList:clear	()V
    //   197: iconst_0
    //   198: istore_2
    //   199: iload_2
    //   200: bipush 7
    //   202: if_icmpge +80 -> 282
    //   205: getstatic 34	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   208: ldc 28
    //   210: invokevirtual 153	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   213: checkcast 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   216: astore 50
    //   218: aload 50
    //   220: lconst_0
    //   221: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   224: aload 50
    //   226: lconst_0
    //   227: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   230: aload_0
    //   231: getfield 108	com/tencent/mobileqq/statistics/storage/StorageReport:c	Ljava/util/ArrayList;
    //   234: aload 50
    //   236: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   239: pop
    //   240: getstatic 34	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   243: ldc 28
    //   245: invokevirtual 153	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   248: checkcast 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   251: astore 50
    //   253: aload 50
    //   255: lconst_0
    //   256: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   259: aload 50
    //   261: lconst_0
    //   262: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   265: aload_0
    //   266: getfield 110	com/tencent/mobileqq/statistics/storage/StorageReport:d	Ljava/util/ArrayList;
    //   269: aload 50
    //   271: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   274: pop
    //   275: iload_2
    //   276: iconst_1
    //   277: iadd
    //   278: istore_2
    //   279: goto -80 -> 199
    //   282: new 138	java/io/File
    //   285: dup
    //   286: getstatic 62	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   289: iconst_0
    //   290: aaload
    //   291: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   294: invokevirtual 235	java/io/File:list	()[Ljava/lang/String;
    //   297: astore 50
    //   299: aload 50
    //   301: ifnull +2540 -> 2841
    //   304: aload 50
    //   306: arraylength
    //   307: ifle +2534 -> 2841
    //   310: lconst_0
    //   311: lstore 12
    //   313: lload 12
    //   315: lstore 8
    //   317: iconst_0
    //   318: istore_2
    //   319: lload 12
    //   321: lstore 14
    //   323: lload 8
    //   325: lstore 10
    //   327: iload_2
    //   328: aload 50
    //   330: arraylength
    //   331: if_icmpge +2516 -> 2847
    //   334: new 129	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   341: astore 51
    //   343: aload 51
    //   345: getstatic 62	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   348: iconst_0
    //   349: aaload
    //   350: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 51
    //   356: ldc 136
    //   358: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 51
    //   364: aload 50
    //   366: iload_2
    //   367: aaload
    //   368: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: new 138	java/io/File
    //   375: dup
    //   376: aload 51
    //   378: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   384: astore 52
    //   386: aload 52
    //   388: invokevirtual 149	java/io/File:isDirectory	()Z
    //   391: ifeq +111 -> 502
    //   394: new 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   397: dup
    //   398: invokespecial 427	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   401: astore 51
    //   403: aload 51
    //   405: iconst_0
    //   406: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   409: aload 51
    //   411: aload_0
    //   412: aload 52
    //   414: invokevirtual 165	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/io/File;)J
    //   417: putfield 167	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   420: aload 51
    //   422: aload 50
    //   424: iload_2
    //   425: aaload
    //   426: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   429: new 129	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   436: astore 52
    //   438: aload 52
    //   440: getstatic 62	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   443: iconst_0
    //   444: aaload
    //   445: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload 52
    //   451: ldc 136
    //   453: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 52
    //   459: aload 50
    //   461: iload_2
    //   462: aaload
    //   463: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload 51
    //   469: aload 52
    //   471: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: putfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   477: aload 51
    //   479: lconst_0
    //   480: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   483: aload 51
    //   485: lconst_0
    //   486: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   489: aload_0
    //   490: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   493: aload 51
    //   495: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   498: pop
    //   499: goto +2335 -> 2834
    //   502: lload 12
    //   504: aload_0
    //   505: getstatic 62	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   508: iconst_0
    //   509: aaload
    //   510: aload 50
    //   512: iload_2
    //   513: aaload
    //   514: invokespecial 243	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   517: ladd
    //   518: lstore 12
    //   520: lload 8
    //   522: lconst_1
    //   523: ladd
    //   524: lstore 8
    //   526: goto +2308 -> 2834
    //   529: iload_2
    //   530: getstatic 62	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   533: arraylength
    //   534: if_icmpge +2325 -> 2859
    //   537: getstatic 62	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   540: iload_2
    //   541: aaload
    //   542: astore 50
    //   544: new 138	java/io/File
    //   547: dup
    //   548: aload 50
    //   550: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   553: astore 51
    //   555: aload 51
    //   557: invokevirtual 149	java/io/File:isDirectory	()Z
    //   560: ifeq +2292 -> 2852
    //   563: new 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   566: dup
    //   567: invokespecial 427	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   570: astore 52
    //   572: aload 52
    //   574: iconst_0
    //   575: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   578: aload 52
    //   580: aload_0
    //   581: aload 51
    //   583: invokevirtual 165	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/io/File;)J
    //   586: putfield 167	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   589: aload 52
    //   591: aload 50
    //   593: ldc 136
    //   595: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   598: iconst_2
    //   599: aaload
    //   600: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   603: aload 52
    //   605: aload 50
    //   607: putfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   610: aload 52
    //   612: lconst_0
    //   613: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   616: aload 52
    //   618: lconst_0
    //   619: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   622: aload_0
    //   623: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   626: aload 52
    //   628: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   631: pop
    //   632: goto +2220 -> 2852
    //   635: iload_2
    //   636: getstatic 68	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   639: arraylength
    //   640: if_icmpge +330 -> 970
    //   643: getstatic 68	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   646: iload_2
    //   647: aaload
    //   648: astore 50
    //   650: new 138	java/io/File
    //   653: dup
    //   654: aload 50
    //   656: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   659: invokevirtual 235	java/io/File:list	()[Ljava/lang/String;
    //   662: astore 51
    //   664: lload 8
    //   666: lstore 12
    //   668: aload 51
    //   670: ifnull +2207 -> 2877
    //   673: lload 8
    //   675: lstore 12
    //   677: aload 51
    //   679: arraylength
    //   680: ifle +2197 -> 2877
    //   683: iconst_0
    //   684: istore 4
    //   686: lload 8
    //   688: lstore 12
    //   690: iload 4
    //   692: aload 51
    //   694: arraylength
    //   695: if_icmpge +2182 -> 2877
    //   698: new 129	java/lang/StringBuilder
    //   701: dup
    //   702: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   705: astore 52
    //   707: aload 52
    //   709: aload 50
    //   711: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload 52
    //   717: ldc 136
    //   719: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload 52
    //   725: aload 51
    //   727: iload 4
    //   729: aaload
    //   730: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: new 138	java/io/File
    //   737: dup
    //   738: aload 52
    //   740: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   746: astore 52
    //   748: new 129	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   755: astore 53
    //   757: aload 53
    //   759: aload 50
    //   761: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: aload 53
    //   767: ldc 136
    //   769: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: pop
    //   773: aload 53
    //   775: aload 51
    //   777: iload 4
    //   779: aaload
    //   780: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: ldc 66
    //   786: aload 53
    //   788: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: invokevirtual 434	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   794: ifeq +46 -> 840
    //   797: new 129	java/lang/StringBuilder
    //   800: dup
    //   801: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   804: astore 52
    //   806: aload 52
    //   808: ldc_w 436
    //   811: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload 52
    //   817: aload 51
    //   819: iload 4
    //   821: aaload
    //   822: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: ldc 176
    //   828: iconst_2
    //   829: aload 52
    //   831: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: goto +2031 -> 2868
    //   840: aload 52
    //   842: invokevirtual 149	java/io/File:isDirectory	()Z
    //   845: ifeq +110 -> 955
    //   848: new 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   851: dup
    //   852: invokespecial 427	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   855: astore 53
    //   857: aload 53
    //   859: iconst_0
    //   860: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   863: aload 53
    //   865: aload_0
    //   866: aload 52
    //   868: invokevirtual 165	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/io/File;)J
    //   871: putfield 167	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   874: aload 53
    //   876: aload 51
    //   878: iload 4
    //   880: aaload
    //   881: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   884: new 129	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   891: astore 52
    //   893: aload 52
    //   895: aload 50
    //   897: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: pop
    //   901: aload 52
    //   903: ldc 136
    //   905: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: pop
    //   909: aload 52
    //   911: aload 51
    //   913: iload 4
    //   915: aaload
    //   916: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: pop
    //   920: aload 53
    //   922: aload 52
    //   924: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: putfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   930: aload 53
    //   932: lconst_0
    //   933: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   936: aload 53
    //   938: lconst_0
    //   939: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   942: aload_0
    //   943: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   946: aload 53
    //   948: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   951: pop
    //   952: goto +1916 -> 2868
    //   955: aload_0
    //   956: aload 50
    //   958: aload 51
    //   960: iload 4
    //   962: aaload
    //   963: invokespecial 243	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   966: pop2
    //   967: goto +1901 -> 2868
    //   970: new 129	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   977: astore 50
    //   979: aload 50
    //   981: ldc_w 438
    //   984: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload 50
    //   990: aload_0
    //   991: getfield 96	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   994: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   997: pop
    //   998: ldc 176
    //   1000: iconst_2
    //   1001: aload 50
    //   1003: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1006: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1009: iconst_0
    //   1010: istore_2
    //   1011: lconst_0
    //   1012: lstore 20
    //   1014: lconst_0
    //   1015: lstore 28
    //   1017: lconst_0
    //   1018: lstore 30
    //   1020: lconst_0
    //   1021: lstore 14
    //   1023: lconst_0
    //   1024: lstore 12
    //   1026: lconst_0
    //   1027: lstore 18
    //   1029: lconst_0
    //   1030: lstore 24
    //   1032: lconst_0
    //   1033: lstore 16
    //   1035: lload 10
    //   1037: lstore 22
    //   1039: lload 8
    //   1041: lstore 26
    //   1043: lload 30
    //   1045: lstore 8
    //   1047: lload 28
    //   1049: lstore 10
    //   1051: aload_0
    //   1052: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1055: invokevirtual 193	java/util/ArrayList:size	()I
    //   1058: istore 4
    //   1060: iload_2
    //   1061: iload 4
    //   1063: if_icmpge +1145 -> 2208
    //   1066: aload_0
    //   1067: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1070: invokevirtual 193	java/util/ArrayList:size	()I
    //   1073: sipush 500
    //   1076: if_icmplt +12 -> 1088
    //   1079: ldc2_w 439
    //   1082: invokestatic 446	java/lang/Thread:sleep	(J)V
    //   1085: goto +19 -> 1104
    //   1088: ldc2_w 447
    //   1091: invokestatic 446	java/lang/Thread:sleep	(J)V
    //   1094: goto +10 -> 1104
    //   1097: astore 50
    //   1099: aload 50
    //   1101: invokevirtual 451	java/lang/InterruptedException:printStackTrace	()V
    //   1104: aload_0
    //   1105: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1108: iload_2
    //   1109: invokevirtual 207	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1112: checkcast 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   1115: astore 53
    //   1117: lload 26
    //   1119: lstore 28
    //   1121: aload 53
    //   1123: lconst_0
    //   1124: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1127: aload 53
    //   1129: lconst_0
    //   1130: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1133: aload 53
    //   1135: lconst_0
    //   1136: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1139: aload 53
    //   1141: getfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1144: astore 54
    //   1146: new 138	java/io/File
    //   1149: dup
    //   1150: aload 54
    //   1152: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   1155: invokevirtual 235	java/io/File:list	()[Ljava/lang/String;
    //   1158: astore 52
    //   1160: aload 49
    //   1162: astore 51
    //   1164: iload_2
    //   1165: istore 5
    //   1167: lload 20
    //   1169: lstore 30
    //   1171: aload 52
    //   1173: ifnull +307 -> 1480
    //   1176: aload 49
    //   1178: astore 50
    //   1180: iload_2
    //   1181: istore 4
    //   1183: lload 20
    //   1185: lstore 26
    //   1187: aload 49
    //   1189: astore 51
    //   1191: iload_2
    //   1192: istore 5
    //   1194: lload 20
    //   1196: lstore 30
    //   1198: aload 52
    //   1200: arraylength
    //   1201: ifle +279 -> 1480
    //   1204: aload 49
    //   1206: astore 50
    //   1208: iload_2
    //   1209: istore 4
    //   1211: lload 20
    //   1213: lstore 26
    //   1215: aload 52
    //   1217: arraylength
    //   1218: istore 6
    //   1220: iconst_0
    //   1221: istore 7
    //   1223: aload 49
    //   1225: astore 51
    //   1227: iload_2
    //   1228: istore 5
    //   1230: lload 20
    //   1232: lstore 30
    //   1234: iload 7
    //   1236: iload 6
    //   1238: if_icmpge +242 -> 1480
    //   1241: aload 52
    //   1243: iload 7
    //   1245: aaload
    //   1246: astore 51
    //   1248: aload 49
    //   1250: astore 50
    //   1252: iload_2
    //   1253: istore 4
    //   1255: lload 20
    //   1257: lstore 26
    //   1259: new 129	java/lang/StringBuilder
    //   1262: dup
    //   1263: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   1266: astore 55
    //   1268: aload 49
    //   1270: astore 50
    //   1272: iload_2
    //   1273: istore 4
    //   1275: lload 20
    //   1277: lstore 26
    //   1279: aload 55
    //   1281: aload 54
    //   1283: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: pop
    //   1287: aload 55
    //   1289: ldc 136
    //   1291: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: pop
    //   1295: aload 55
    //   1297: aload 51
    //   1299: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: pop
    //   1303: aload_0
    //   1304: aload 55
    //   1306: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1309: invokespecial 453	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1312: astore 50
    //   1314: aload 53
    //   1316: getfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1319: lstore 26
    //   1321: lload 14
    //   1323: lstore 34
    //   1325: lload 12
    //   1327: lstore 32
    //   1329: aload 49
    //   1331: astore 51
    //   1333: iload_2
    //   1334: istore 4
    //   1336: lload 20
    //   1338: lstore 30
    //   1340: aload 53
    //   1342: lload 26
    //   1344: aload 50
    //   1346: ldc 251
    //   1348: lconst_0
    //   1349: invokevirtual 454	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1352: ladd
    //   1353: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1356: lload 14
    //   1358: lstore 34
    //   1360: lload 12
    //   1362: lstore 32
    //   1364: aload 49
    //   1366: astore 51
    //   1368: iload_2
    //   1369: istore 4
    //   1371: lload 20
    //   1373: lstore 30
    //   1375: aload 53
    //   1377: aload 53
    //   1379: getfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1382: aload 50
    //   1384: ldc_w 257
    //   1387: lconst_0
    //   1388: invokevirtual 454	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1391: ladd
    //   1392: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1395: lload 14
    //   1397: lstore 34
    //   1399: lload 12
    //   1401: lstore 32
    //   1403: aload 49
    //   1405: astore 51
    //   1407: iload_2
    //   1408: istore 4
    //   1410: lload 20
    //   1412: lstore 30
    //   1414: aload 53
    //   1416: aload 53
    //   1418: getfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1421: aload 50
    //   1423: ldc_w 259
    //   1426: lconst_0
    //   1427: invokevirtual 454	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1430: ladd
    //   1431: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1434: iload 7
    //   1436: iconst_1
    //   1437: iadd
    //   1438: istore 7
    //   1440: goto -217 -> 1223
    //   1443: astore 50
    //   1445: goto +20 -> 1465
    //   1448: astore 51
    //   1450: aload 50
    //   1452: astore 49
    //   1454: lload 26
    //   1456: lstore 20
    //   1458: iload 4
    //   1460: istore_2
    //   1461: aload 51
    //   1463: astore 50
    //   1465: lload 20
    //   1467: lstore 26
    //   1469: lload 8
    //   1471: lstore 20
    //   1473: lload 26
    //   1475: lstore 8
    //   1477: goto +642 -> 2119
    //   1480: aload 51
    //   1482: astore 49
    //   1484: iload 5
    //   1486: istore_2
    //   1487: lload 30
    //   1489: lstore 26
    //   1491: lload 10
    //   1493: lstore 30
    //   1495: lload 8
    //   1497: lstore 20
    //   1499: aload 54
    //   1501: ldc_w 456
    //   1504: invokevirtual 374	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1507: istore 48
    //   1509: iload 48
    //   1511: ifeq +307 -> 1818
    //   1514: lload 14
    //   1516: lstore 34
    //   1518: lload 12
    //   1520: lstore 32
    //   1522: aload 49
    //   1524: astore 51
    //   1526: iload_2
    //   1527: istore 4
    //   1529: lload 26
    //   1531: lstore 30
    //   1533: aload 54
    //   1535: ldc_w 458
    //   1538: invokevirtual 374	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1541: ifeq +105 -> 1646
    //   1544: lload 14
    //   1546: lstore 34
    //   1548: lload 12
    //   1550: lstore 32
    //   1552: aload 49
    //   1554: astore 51
    //   1556: iload_2
    //   1557: istore 4
    //   1559: lload 26
    //   1561: lstore 30
    //   1563: lload 14
    //   1565: aload 53
    //   1567: getfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1570: ladd
    //   1571: lstore 14
    //   1573: lload 14
    //   1575: lstore 34
    //   1577: lload 12
    //   1579: lstore 32
    //   1581: aload 49
    //   1583: astore 51
    //   1585: iload_2
    //   1586: istore 4
    //   1588: lload 26
    //   1590: lstore 30
    //   1592: lload 12
    //   1594: aload 53
    //   1596: getfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1599: ladd
    //   1600: lstore 12
    //   1602: lload 14
    //   1604: lstore 34
    //   1606: lload 12
    //   1608: lstore 32
    //   1610: aload 49
    //   1612: astore 51
    //   1614: iload_2
    //   1615: istore 4
    //   1617: lload 26
    //   1619: lstore 30
    //   1621: lload 16
    //   1623: aload 53
    //   1625: getfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1628: ladd
    //   1629: lstore 36
    //   1631: lload 10
    //   1633: lstore 20
    //   1635: lload 8
    //   1637: lstore 30
    //   1639: lload 36
    //   1641: lstore 16
    //   1643: goto +270 -> 1913
    //   1646: lload 14
    //   1648: lstore 34
    //   1650: lload 12
    //   1652: lstore 32
    //   1654: aload 49
    //   1656: astore 51
    //   1658: iload_2
    //   1659: istore 4
    //   1661: lload 26
    //   1663: lstore 30
    //   1665: aload 53
    //   1667: getfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1670: lstore 20
    //   1672: lload 28
    //   1674: lload 20
    //   1676: ladd
    //   1677: lstore 46
    //   1679: lload 10
    //   1681: lstore 30
    //   1683: lload 8
    //   1685: lstore 32
    //   1687: lload 46
    //   1689: lstore 34
    //   1691: lload 14
    //   1693: lstore 36
    //   1695: lload 22
    //   1697: lstore 28
    //   1699: lload 12
    //   1701: lstore 38
    //   1703: lload 18
    //   1705: lstore 40
    //   1707: lload 24
    //   1709: lstore 42
    //   1711: lload 16
    //   1713: lstore 44
    //   1715: lload 22
    //   1717: aload 53
    //   1719: getfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1722: ladd
    //   1723: lstore 22
    //   1725: lload 10
    //   1727: lstore 30
    //   1729: lload 8
    //   1731: lstore 32
    //   1733: lload 46
    //   1735: lstore 34
    //   1737: lload 14
    //   1739: lstore 36
    //   1741: lload 22
    //   1743: lstore 28
    //   1745: lload 12
    //   1747: lstore 38
    //   1749: lload 18
    //   1751: lstore 40
    //   1753: lload 24
    //   1755: lstore 42
    //   1757: lload 16
    //   1759: lstore 44
    //   1761: aload 53
    //   1763: getfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1766: lstore 20
    //   1768: lload 24
    //   1770: lload 20
    //   1772: ladd
    //   1773: lstore 24
    //   1775: lload 10
    //   1777: lstore 20
    //   1779: lload 8
    //   1781: lstore 10
    //   1783: lload 46
    //   1785: lstore 8
    //   1787: goto +134 -> 1921
    //   1790: astore 50
    //   1792: lload 8
    //   1794: lstore 20
    //   1796: lload 34
    //   1798: lstore 14
    //   1800: lload 32
    //   1802: lstore 12
    //   1804: aload 51
    //   1806: astore 49
    //   1808: iload 4
    //   1810: istore_2
    //   1811: lload 30
    //   1813: lstore 8
    //   1815: goto +304 -> 2119
    //   1818: lload 10
    //   1820: lstore 30
    //   1822: lload 8
    //   1824: lstore 20
    //   1826: aload 54
    //   1828: ldc 64
    //   1830: invokevirtual 374	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1833: ifeq +72 -> 1905
    //   1836: lload 10
    //   1838: lstore 30
    //   1840: lload 8
    //   1842: lstore 20
    //   1844: lload 10
    //   1846: aload 53
    //   1848: getfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1851: ladd
    //   1852: lstore 10
    //   1854: lload 10
    //   1856: lstore 30
    //   1858: lload 8
    //   1860: lstore 20
    //   1862: lload 8
    //   1864: aload 53
    //   1866: getfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1869: ladd
    //   1870: lstore 8
    //   1872: lload 10
    //   1874: lstore 30
    //   1876: lload 8
    //   1878: lstore 20
    //   1880: aload 53
    //   1882: getfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1885: lstore 32
    //   1887: lload 18
    //   1889: lload 32
    //   1891: ladd
    //   1892: lstore 18
    //   1894: lload 10
    //   1896: lstore 20
    //   1898: lload 8
    //   1900: lstore 30
    //   1902: goto +11 -> 1913
    //   1905: lload 8
    //   1907: lstore 30
    //   1909: lload 10
    //   1911: lstore 20
    //   1913: lload 28
    //   1915: lstore 8
    //   1917: lload 30
    //   1919: lstore 10
    //   1921: lload 20
    //   1923: lstore 30
    //   1925: lload 10
    //   1927: lstore 32
    //   1929: lload 8
    //   1931: lstore 34
    //   1933: lload 14
    //   1935: lstore 36
    //   1937: lload 22
    //   1939: lstore 28
    //   1941: lload 12
    //   1943: lstore 38
    //   1945: lload 18
    //   1947: lstore 40
    //   1949: lload 24
    //   1951: lstore 42
    //   1953: lload 16
    //   1955: lstore 44
    //   1957: aload 53
    //   1959: getfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1962: lstore 46
    //   1964: lload 26
    //   1966: lload 46
    //   1968: ladd
    //   1969: lstore 26
    //   1971: new 129	java/lang/StringBuilder
    //   1974: dup
    //   1975: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   1978: astore 50
    //   1980: aload 50
    //   1982: ldc_w 460
    //   1985: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1988: pop
    //   1989: aload 50
    //   1991: aload 53
    //   1993: invokevirtual 174	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   1996: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1999: pop
    //   2000: ldc 176
    //   2002: iconst_1
    //   2003: aload 50
    //   2005: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2008: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2011: lload 26
    //   2013: lstore 32
    //   2015: lload 20
    //   2017: lstore 30
    //   2019: lload 10
    //   2021: lstore 28
    //   2023: lload 8
    //   2025: lstore 26
    //   2027: goto +153 -> 2180
    //   2030: astore 50
    //   2032: lload 20
    //   2034: lstore 30
    //   2036: lload 10
    //   2038: lstore 20
    //   2040: lload 8
    //   2042: lstore 34
    //   2044: lload 26
    //   2046: lstore 8
    //   2048: goto +37 -> 2085
    //   2051: astore 50
    //   2053: lload 26
    //   2055: lstore 8
    //   2057: lload 44
    //   2059: lstore 16
    //   2061: lload 42
    //   2063: lstore 24
    //   2065: lload 40
    //   2067: lstore 18
    //   2069: lload 38
    //   2071: lstore 12
    //   2073: lload 28
    //   2075: lstore 22
    //   2077: lload 36
    //   2079: lstore 14
    //   2081: lload 32
    //   2083: lstore 20
    //   2085: lload 34
    //   2087: lstore 28
    //   2089: lload 30
    //   2091: lstore 10
    //   2093: goto +26 -> 2119
    //   2096: astore 50
    //   2098: lload 30
    //   2100: lstore 10
    //   2102: goto +13 -> 2115
    //   2105: astore 50
    //   2107: lload 20
    //   2109: lstore 26
    //   2111: lload 8
    //   2113: lstore 20
    //   2115: lload 26
    //   2117: lstore 8
    //   2119: aload 50
    //   2121: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   2124: new 129	java/lang/StringBuilder
    //   2127: dup
    //   2128: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   2131: astore 51
    //   2133: aload 51
    //   2135: ldc_w 463
    //   2138: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2141: pop
    //   2142: aload 51
    //   2144: aload 50
    //   2146: invokevirtual 467	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   2149: invokevirtual 470	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2152: pop
    //   2153: ldc 176
    //   2155: iconst_1
    //   2156: aload 51
    //   2158: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2161: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2164: lload 28
    //   2166: lstore 26
    //   2168: lload 20
    //   2170: lstore 28
    //   2172: lload 10
    //   2174: lstore 30
    //   2176: lload 8
    //   2178: lstore 32
    //   2180: aload_1
    //   2181: ifnull +707 -> 2888
    //   2184: aload_1
    //   2185: iload_2
    //   2186: iconst_1
    //   2187: iadd
    //   2188: iload_3
    //   2189: iconst_2
    //   2190: isub
    //   2191: imul
    //   2192: aload_0
    //   2193: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2196: invokevirtual 193	java/util/ArrayList:size	()I
    //   2199: idiv
    //   2200: invokeinterface 383 2 0
    //   2205: goto +683 -> 2888
    //   2208: aload_0
    //   2209: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2212: aload_0
    //   2213: getfield 92	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport$MyFileLargeComparator	Lcom/tencent/mobileqq/statistics/storage/StorageReport$MyFileLargeComparator;
    //   2216: invokestatic 203	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   2219: ldc 176
    //   2221: iconst_1
    //   2222: ldc_w 472
    //   2225: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2228: iconst_0
    //   2229: istore_2
    //   2230: iload_2
    //   2231: aload_0
    //   2232: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2235: invokevirtual 193	java/util/ArrayList:size	()I
    //   2238: if_icmpge +25 -> 2263
    //   2241: aload_0
    //   2242: aload_0
    //   2243: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2246: iload_2
    //   2247: invokevirtual 207	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2250: checkcast 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2253: invokespecial 186	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2256: iload_2
    //   2257: iconst_1
    //   2258: iadd
    //   2259: istore_2
    //   2260: goto -30 -> 2230
    //   2263: new 129	java/lang/StringBuilder
    //   2266: dup
    //   2267: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   2270: astore 50
    //   2272: aload 50
    //   2274: ldc_w 474
    //   2277: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2280: pop
    //   2281: aload 50
    //   2283: lload 20
    //   2285: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2288: pop
    //   2289: ldc 176
    //   2291: iconst_1
    //   2292: aload 50
    //   2294: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2297: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2300: new 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2303: dup
    //   2304: invokespecial 427	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   2307: astore 50
    //   2309: aload 50
    //   2311: iconst_0
    //   2312: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   2315: aload 50
    //   2317: ldc_w 476
    //   2320: putfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2323: aload 50
    //   2325: lload 22
    //   2327: lload 8
    //   2329: ladd
    //   2330: lload 12
    //   2332: ladd
    //   2333: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2336: aload 50
    //   2338: lload 24
    //   2340: lload 18
    //   2342: ladd
    //   2343: lload 16
    //   2345: ladd
    //   2346: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2349: aload 50
    //   2351: lconst_0
    //   2352: putfield 167	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   2355: aload 50
    //   2357: lload 20
    //   2359: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   2362: aload_0
    //   2363: aload 50
    //   2365: invokespecial 186	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2368: new 129	java/lang/StringBuilder
    //   2371: dup
    //   2372: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   2375: astore 51
    //   2377: aload 51
    //   2379: ldc_w 478
    //   2382: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2385: pop
    //   2386: aload 51
    //   2388: aload 50
    //   2390: invokevirtual 174	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   2393: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2396: pop
    //   2397: ldc 176
    //   2399: iconst_1
    //   2400: aload 51
    //   2402: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2405: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2408: new 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2411: dup
    //   2412: invokespecial 427	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   2415: astore 50
    //   2417: aload 50
    //   2419: iconst_0
    //   2420: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   2423: aload 50
    //   2425: ldc_w 480
    //   2428: putfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2431: aload 50
    //   2433: aload_0
    //   2434: aload_0
    //   2435: getfield 108	com/tencent/mobileqq/statistics/storage/StorageReport:c	Ljava/util/ArrayList;
    //   2438: invokespecial 482	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   2441: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2444: aload 50
    //   2446: lload 22
    //   2448: lload 12
    //   2450: ladd
    //   2451: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2454: aload 50
    //   2456: lload 24
    //   2458: lload 16
    //   2460: ladd
    //   2461: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2464: aload 50
    //   2466: lconst_0
    //   2467: putfield 167	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   2470: aload 50
    //   2472: lload 26
    //   2474: lload 14
    //   2476: ladd
    //   2477: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   2480: aload_0
    //   2481: aload 50
    //   2483: invokespecial 186	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2486: new 129	java/lang/StringBuilder
    //   2489: dup
    //   2490: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   2493: astore 51
    //   2495: aload 51
    //   2497: ldc_w 484
    //   2500: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2503: pop
    //   2504: aload 51
    //   2506: aload 50
    //   2508: invokevirtual 174	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   2511: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2514: pop
    //   2515: ldc 176
    //   2517: iconst_1
    //   2518: aload 51
    //   2520: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2523: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2526: new 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2529: dup
    //   2530: invokespecial 427	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   2533: astore 50
    //   2535: iconst_0
    //   2536: istore 4
    //   2538: aload 50
    //   2540: iconst_0
    //   2541: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   2544: aload 50
    //   2546: ldc_w 486
    //   2549: putfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2552: aload 50
    //   2554: aload_0
    //   2555: aload_0
    //   2556: getfield 110	com/tencent/mobileqq/statistics/storage/StorageReport:d	Ljava/util/ArrayList;
    //   2559: invokespecial 482	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   2562: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2565: aload 50
    //   2567: lload 8
    //   2569: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2572: aload 50
    //   2574: lload 18
    //   2576: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2579: aload 50
    //   2581: lconst_0
    //   2582: putfield 167	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   2585: aload 50
    //   2587: lload 10
    //   2589: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   2592: aload_0
    //   2593: aload 50
    //   2595: invokespecial 186	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2598: new 129	java/lang/StringBuilder
    //   2601: dup
    //   2602: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   2605: astore 51
    //   2607: aload 51
    //   2609: ldc_w 488
    //   2612: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2615: pop
    //   2616: aload 51
    //   2618: aload 50
    //   2620: invokevirtual 174	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   2623: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2626: pop
    //   2627: ldc 176
    //   2629: iconst_1
    //   2630: aload 51
    //   2632: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2635: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2638: ldc 176
    //   2640: iconst_1
    //   2641: ldc_w 490
    //   2644: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2647: iconst_0
    //   2648: istore_2
    //   2649: iload_2
    //   2650: aload_0
    //   2651: getfield 78	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2654: invokevirtual 193	java/util/ArrayList:size	()I
    //   2657: if_icmpge +68 -> 2725
    //   2660: aload_0
    //   2661: getfield 78	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2664: iload_2
    //   2665: invokevirtual 207	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2668: checkcast 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2671: astore 50
    //   2673: new 129	java/lang/StringBuilder
    //   2676: dup
    //   2677: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   2680: astore 51
    //   2682: aload 51
    //   2684: ldc_w 492
    //   2687: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2690: pop
    //   2691: aload 51
    //   2693: aload 50
    //   2695: getfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2698: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2701: pop
    //   2702: aload 50
    //   2704: aload 51
    //   2706: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2709: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2712: aload_0
    //   2713: aload 50
    //   2715: invokespecial 186	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2718: iload_2
    //   2719: iconst_1
    //   2720: iadd
    //   2721: istore_2
    //   2722: goto -73 -> 2649
    //   2725: aload_0
    //   2726: getfield 94	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Boolean	Z
    //   2729: ifeq +178 -> 2907
    //   2732: aload 49
    //   2734: invokeinterface 496 1 0
    //   2739: ldc_w 409
    //   2742: aload_0
    //   2743: getfield 96	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   2746: invokeinterface 501 4 0
    //   2751: invokeinterface 504 1 0
    //   2756: pop
    //   2757: goto +150 -> 2907
    //   2760: iload_2
    //   2761: bipush 7
    //   2763: if_icmpge +44 -> 2807
    //   2766: getstatic 34	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   2769: aload_0
    //   2770: getfield 108	com/tencent/mobileqq/statistics/storage/StorageReport:c	Ljava/util/ArrayList;
    //   2773: iload_2
    //   2774: invokevirtual 207	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2777: checkcast 506	com/tencent/commonsdk/pool/RecyclablePool$Recyclable
    //   2780: invokevirtual 214	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   2783: getstatic 34	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   2786: aload_0
    //   2787: getfield 110	com/tencent/mobileqq/statistics/storage/StorageReport:d	Ljava/util/ArrayList;
    //   2790: iload_2
    //   2791: invokevirtual 207	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2794: checkcast 506	com/tencent/commonsdk/pool/RecyclablePool$Recyclable
    //   2797: invokevirtual 214	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   2800: iload_2
    //   2801: iconst_1
    //   2802: iadd
    //   2803: istore_2
    //   2804: goto -44 -> 2760
    //   2807: aload_1
    //   2808: ifnull +10 -> 2818
    //   2811: aload_1
    //   2812: iload_3
    //   2813: invokeinterface 383 2 0
    //   2818: aload_0
    //   2819: monitorexit
    //   2820: lload 26
    //   2822: lreturn
    //   2823: astore_1
    //   2824: aload_0
    //   2825: monitorexit
    //   2826: goto +5 -> 2831
    //   2829: aload_1
    //   2830: athrow
    //   2831: goto -2 -> 2829
    //   2834: iload_2
    //   2835: iconst_1
    //   2836: iadd
    //   2837: istore_2
    //   2838: goto -2519 -> 319
    //   2841: lconst_0
    //   2842: lstore 14
    //   2844: lconst_0
    //   2845: lstore 10
    //   2847: iconst_1
    //   2848: istore_2
    //   2849: goto -2320 -> 529
    //   2852: iload_2
    //   2853: iconst_1
    //   2854: iadd
    //   2855: istore_2
    //   2856: goto -2327 -> 529
    //   2859: iconst_0
    //   2860: istore_2
    //   2861: lload 14
    //   2863: lstore 8
    //   2865: goto -2230 -> 635
    //   2868: iload 4
    //   2870: iconst_1
    //   2871: iadd
    //   2872: istore 4
    //   2874: goto -2188 -> 686
    //   2877: iload_2
    //   2878: iconst_1
    //   2879: iadd
    //   2880: istore_2
    //   2881: lload 12
    //   2883: lstore 8
    //   2885: goto -2250 -> 635
    //   2888: iload_2
    //   2889: iconst_1
    //   2890: iadd
    //   2891: istore_2
    //   2892: lload 32
    //   2894: lstore 20
    //   2896: lload 30
    //   2898: lstore 10
    //   2900: lload 28
    //   2902: lstore 8
    //   2904: goto -1853 -> 1051
    //   2907: iload 4
    //   2909: istore_2
    //   2910: goto -150 -> 2760
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2913	0	this	StorageReport
    //   0	2913	1	paramIProgressCallback	com.tencent.mobileqq.activity.QQSettingCleanActivity.IProgressCallback
    //   0	2913	2	paramInt1	int
    //   0	2913	3	paramInt2	int
    //   684	2224	4	i	int
    //   1165	320	5	j	int
    //   1218	21	6	k	int
    //   1221	218	7	m	int
    //   122	2781	8	l1	long
    //   325	2574	10	l2	long
    //   311	2571	12	l3	long
    //   321	2541	14	l4	long
    //   1033	1426	16	l5	long
    //   1027	1548	18	l6	long
    //   1012	1883	20	l7	long
    //   1037	1410	22	l8	long
    //   1030	1427	24	l9	long
    //   1041	1780	26	l10	long
    //   1015	1886	28	l11	long
    //   1018	1879	30	l12	long
    //   1327	1566	32	l13	long
    //   1323	763	34	l14	long
    //   1629	449	36	l15	long
    //   1701	369	38	l16	long
    //   1705	361	40	l17	long
    //   1709	353	42	l18	long
    //   1713	345	44	l19	long
    //   1677	290	46	l20	long
    //   1507	3	48	bool	boolean
    //   33	2700	49	localObject1	Object
    //   216	786	50	localObject2	Object
    //   1097	3	50	localInterruptedException	java.lang.InterruptedException
    //   1178	244	50	localObject3	Object
    //   1443	8	50	localException1	java.lang.Exception
    //   1463	1	50	localObject4	Object
    //   1790	1	50	localException2	java.lang.Exception
    //   1978	26	50	localStringBuilder1	StringBuilder
    //   2030	1	50	localException3	java.lang.Exception
    //   2051	1	50	localException4	java.lang.Exception
    //   2096	1	50	localException5	java.lang.Exception
    //   2105	40	50	localException6	java.lang.Exception
    //   2270	444	50	localObject5	Object
    //   341	1065	51	localObject6	Object
    //   1448	33	51	localException7	java.lang.Exception
    //   1524	1181	51	localObject7	Object
    //   384	858	52	localObject8	Object
    //   755	1237	53	localObject9	Object
    //   1144	683	54	str	String
    //   1266	39	55	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   1066	1085	1097	java/lang/InterruptedException
    //   1088	1094	1097	java/lang/InterruptedException
    //   1287	1321	1443	java/lang/Exception
    //   1198	1204	1448	java/lang/Exception
    //   1215	1220	1448	java/lang/Exception
    //   1259	1268	1448	java/lang/Exception
    //   1279	1287	1448	java/lang/Exception
    //   1340	1356	1790	java/lang/Exception
    //   1375	1395	1790	java/lang/Exception
    //   1414	1434	1790	java/lang/Exception
    //   1533	1544	1790	java/lang/Exception
    //   1563	1573	1790	java/lang/Exception
    //   1592	1602	1790	java/lang/Exception
    //   1621	1631	1790	java/lang/Exception
    //   1665	1672	1790	java/lang/Exception
    //   1971	2011	2030	java/lang/Exception
    //   1715	1725	2051	java/lang/Exception
    //   1761	1768	2051	java/lang/Exception
    //   1957	1964	2051	java/lang/Exception
    //   1499	1509	2096	java/lang/Exception
    //   1826	1836	2096	java/lang/Exception
    //   1844	1854	2096	java/lang/Exception
    //   1862	1872	2096	java/lang/Exception
    //   1880	1887	2096	java/lang/Exception
    //   1146	1160	2105	java/lang/Exception
    //   6	13	2823	finally
    //   13	35	2823	finally
    //   40	49	2823	finally
    //   49	131	2823	finally
    //   138	169	2823	finally
    //   169	197	2823	finally
    //   205	275	2823	finally
    //   282	299	2823	finally
    //   304	310	2823	finally
    //   327	499	2823	finally
    //   502	520	2823	finally
    //   529	632	2823	finally
    //   635	664	2823	finally
    //   677	683	2823	finally
    //   690	837	2823	finally
    //   840	952	2823	finally
    //   955	967	2823	finally
    //   970	1009	2823	finally
    //   1051	1060	2823	finally
    //   1066	1085	2823	finally
    //   1088	1094	2823	finally
    //   1099	1104	2823	finally
    //   1104	1117	2823	finally
    //   1121	1146	2823	finally
    //   1146	1160	2823	finally
    //   1198	1204	2823	finally
    //   1215	1220	2823	finally
    //   1259	1268	2823	finally
    //   1279	1287	2823	finally
    //   1287	1321	2823	finally
    //   1340	1356	2823	finally
    //   1375	1395	2823	finally
    //   1414	1434	2823	finally
    //   1499	1509	2823	finally
    //   1533	1544	2823	finally
    //   1563	1573	2823	finally
    //   1592	1602	2823	finally
    //   1621	1631	2823	finally
    //   1665	1672	2823	finally
    //   1715	1725	2823	finally
    //   1761	1768	2823	finally
    //   1826	1836	2823	finally
    //   1844	1854	2823	finally
    //   1862	1872	2823	finally
    //   1880	1887	2823	finally
    //   1957	1964	2823	finally
    //   1971	2011	2823	finally
    //   2119	2164	2823	finally
    //   2184	2205	2823	finally
    //   2208	2228	2823	finally
    //   2230	2256	2823	finally
    //   2263	2535	2823	finally
    //   2538	2647	2823	finally
    //   2649	2718	2823	finally
    //   2725	2757	2823	finally
    //   2766	2800	2823	finally
    //   2811	2818	2823	finally
  }
  
  /* Error */
  public long a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   4: ifnonnull +37 -> 41
    //   7: aload_0
    //   8: ldc_w 518
    //   11: invokestatic 524	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   14: ldc_w 526
    //   17: invokevirtual 530	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   20: putfield 98	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   23: aload_0
    //   24: getfield 98	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   27: invokevirtual 535	java/lang/reflect/Field:isAccessible	()Z
    //   30: ifne +11 -> 41
    //   33: aload_0
    //   34: getfield 98	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   37: iconst_1
    //   38: invokevirtual 539	java/lang/reflect/Field:setAccessible	(Z)V
    //   41: aload_0
    //   42: getfield 98	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   45: aconst_null
    //   46: invokevirtual 541	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore 4
    //   51: aload_0
    //   52: getfield 106	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangReflectMethod	Ljava/lang/reflect/Method;
    //   55: ifnonnull +27 -> 82
    //   58: aload_0
    //   59: aload 4
    //   61: invokevirtual 545	java/lang/Object:getClass	()Ljava/lang/Class;
    //   64: ldc_w 547
    //   67: iconst_1
    //   68: anewarray 520	java/lang/Class
    //   71: dup
    //   72: iconst_0
    //   73: ldc 36
    //   75: aastore
    //   76: invokevirtual 551	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   79: putfield 106	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangReflectMethod	Ljava/lang/reflect/Method;
    //   82: aload_0
    //   83: getfield 106	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangReflectMethod	Ljava/lang/reflect/Method;
    //   86: aload 4
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload_1
    //   95: invokevirtual 241	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   98: aastore
    //   99: invokevirtual 557	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   102: astore_1
    //   103: aload_0
    //   104: getfield 104	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   107: ifnonnull +35 -> 142
    //   110: aload_0
    //   111: aload_1
    //   112: invokevirtual 545	java/lang/Object:getClass	()Ljava/lang/Class;
    //   115: ldc_w 559
    //   118: invokevirtual 530	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   121: putfield 104	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   124: aload_0
    //   125: getfield 104	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   128: invokevirtual 535	java/lang/reflect/Field:isAccessible	()Z
    //   131: ifne +11 -> 142
    //   134: aload_0
    //   135: getfield 104	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   138: iconst_1
    //   139: invokevirtual 539	java/lang/reflect/Field:setAccessible	(Z)V
    //   142: aload_0
    //   143: getfield 104	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaLangReflectField	Ljava/lang/reflect/Field;
    //   146: aload_1
    //   147: invokevirtual 562	java/lang/reflect/Field:getLong	(Ljava/lang/Object;)J
    //   150: lstore_2
    //   151: lload_2
    //   152: lconst_0
    //   153: lcmp
    //   154: ifne +5 -> 159
    //   157: lconst_0
    //   158: lreturn
    //   159: aload_0
    //   160: getfield 96	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
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
    //   182: invokevirtual 563	java/lang/NoSuchFieldException:printStackTrace	()V
    //   185: lconst_0
    //   186: lreturn
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 564	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   192: lconst_0
    //   193: lreturn
    //   194: astore_1
    //   195: aload_1
    //   196: invokevirtual 565	java/lang/IllegalAccessException:printStackTrace	()V
    //   199: lconst_0
    //   200: lreturn
    //   201: astore_1
    //   202: aload_1
    //   203: invokevirtual 566	java/lang/NoSuchMethodException:printStackTrace	()V
    //   206: lconst_0
    //   207: lreturn
    //   208: astore_1
    //   209: aload_1
    //   210: invokevirtual 567	java/lang/ClassNotFoundException:printStackTrace	()V
    //   213: lconst_0
    //   214: lreturn
    //   215: aload_1
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	StorageReport
    //   0	217	1	paramFile	File
    //   150	25	2	l	long
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
      int i = 0;
      while (i < paramArrayList.size())
      {
        String str = (String)paramArrayList.get(i);
        String[] arrayOfString = new File(str).list();
        long l2 = l1;
        if (arrayOfString != null)
        {
          l2 = l1;
          if (arrayOfString.length > 0)
          {
            int k = arrayOfString.length;
            int j = 0;
            while (j < k)
            {
              File localFile = new File(str, arrayOfString[j]);
              l2 = l1;
              if (localFile.isFile()) {
                l2 = l1 + localFile.length();
              }
              j += 1;
              l1 = l2;
            }
            l2 = l1;
          }
        }
        i += 1;
        l1 = l2;
      }
      return l1;
    }
    return 0L;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.storage.StorageReport
 * JD-Core Version:    0.7.0.1
 */