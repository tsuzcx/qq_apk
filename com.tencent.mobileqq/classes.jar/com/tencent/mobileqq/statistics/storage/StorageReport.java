package com.tencent.mobileqq.statistics.storage;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
  private long jdField_a_of_type_Long = 0L;
  private StorageReport.MyFileAccessComparator jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport$MyFileAccessComparator = new StorageReport.MyFileAccessComparator(null);
  private StorageReport.MyFileLargeComparator jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport$MyFileLargeComparator = new StorageReport.MyFileLargeComparator(null);
  private String jdField_a_of_type_JavaLangString = "";
  private Field jdField_a_of_type_JavaLangReflectField = null;
  private Method jdField_a_of_type_JavaLangReflectMethod = null;
  private ArrayList<StorageItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private boolean jdField_a_of_type_Boolean = true;
  private Field jdField_b_of_type_JavaLangReflectField = null;
  private ArrayList<StorageItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList(40);
  private boolean jdField_b_of_type_Boolean = false;
  private ArrayList<StorageItem> c = new ArrayList(7);
  private ArrayList<StorageItem> d = new ArrayList(7);
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "sdcard/Tencent/MobileQQ", "sdcard/Tencent/QQ_Images", "sdcard/Tencent/QQfile_recv", "sdcard/Tencent/QQ_Collection", "sdcard/Tencent/QQ_Favorite", "sdcard/Tencent/QQ_Video", "sdcard/Tencent/QQfile_share", "sdcard/Tencent/QQHomework_recv", "sdcard/Tencent/QQHomework_attach", "sdcard/Tencent/AIO_FORWARD", "sdcard/Tencent/QQ_business", "sdcard/Tencent/msflogs" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "data/data/com.tencent.mobileqq", "data/data/com.tencent.mobileqq/files" };
  }
  
  private StorageReport()
  {
    if (0.001000000047497451D >= Math.random()) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  private long a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    File localFile;
    do
    {
      return 0L;
      localFile = new File(paramString1 + "/" + paramString2);
    } while (localFile.isDirectory());
    StorageItem localStorageItem = (StorageItem)jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(StorageItem.class);
    localStorageItem.jdField_a_of_type_JavaLangString = paramString2;
    localStorageItem.jdField_a_of_type_Boolean = true;
    localStorageItem.jdField_a_of_type_Long = localFile.length();
    localStorageItem.jdField_b_of_type_JavaLangString = (paramString1 + "/" + paramString2);
    localStorageItem.jdField_b_of_type_Long = a(localFile);
    localStorageItem.c = 1L;
    if (localStorageItem.jdField_a_of_type_Long >= 524288.0D) {
      QLog.d("StorageReport", 1, "--scan qq-- file info: " + localStorageItem.toString());
    }
    if (localStorageItem.jdField_a_of_type_Long >= 2097152L) {
      a(localStorageItem);
    }
    a(localStorageItem, localStorageItem.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 20)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localStorageItem);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 20) {
        Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport$MyFileAccessComparator);
      }
      return localStorageItem.jdField_a_of_type_Long;
    }
    paramString1 = (StorageItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() >= 20) && (localStorageItem.jdField_b_of_type_Long > paramString1.jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramString1);
      this.jdField_a_of_type_JavaUtilArrayList.add(localStorageItem);
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport$MyFileAccessComparator);
      return localStorageItem.jdField_a_of_type_Long;
    }
    jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(localStorageItem);
    return localStorageItem.jdField_a_of_type_Long;
  }
  
  private Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    Stack localStack = new Stack();
    localStack.push(paramString);
    long l1 = 0L;
    long l2 = 0L;
    long l3 = 0L;
    if (!localStack.isEmpty())
    {
      paramString = new File((String)localStack.pop());
      long l4;
      if (paramString.isDirectory())
      {
        String[] arrayOfString = paramString.list();
        long l5;
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          l4 = l1;
          l5 = l2;
          l1 = l4;
          if (i < j)
          {
            String str = arrayOfString[i];
            File localFile = new File(paramString, str);
            if (localFile.isDirectory()) {
              localStack.push(localFile.getAbsolutePath());
            }
            for (;;)
            {
              i += 1;
              break;
              a(paramString.getAbsolutePath(), str);
              l4 += localFile.length();
              l2 += 1L;
            }
          }
        }
        else
        {
          l5 = l2;
        }
        l2 = l5;
        l3 += 1L;
        l4 = l1;
        l1 = l3;
      }
      for (;;)
      {
        l4 += paramString.length();
        l3 = l1;
        l1 = l4;
        break;
        a(paramString.getParent(), paramString.getName());
        l4 = l1;
        l1 = l3;
        l2 = 1L + l2;
      }
    }
    localBundle.putLong("key_size", l1);
    localBundle.putLong("key_file_count", l2);
    localBundle.putLong("key_dir_count", l3);
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
    if (jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport = new StorageReport();
      }
      return jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport;
    }
    finally {}
  }
  
  private String a(ArrayList<StorageItem> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    int i = 0;
    while (i < paramArrayList.size())
    {
      StorageItem localStorageItem = (StorageItem)paramArrayList.get(i);
      localStringBuilder.append(localStorageItem.c);
      localStringBuilder.append("-").append(localStorageItem.jdField_a_of_type_Long);
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
    if (QLog.isColorLevel()) {
      QLog.d("StorageReport", 2, "--scan qq-- file report to tdw : report key = " + this.jdField_a_of_type_JavaLangString + ",item info=" + paramStorageItem.toString());
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "qqStorageReport", true, 0L, 0L, localHashMap, null);
  }
  
  private void a(StorageItem paramStorageItem, long paramLong)
  {
    int i = 0;
    if ((paramStorageItem == null) || (TextUtils.isEmpty(paramStorageItem.jdField_b_of_type_JavaLangString))) {
      return;
    }
    if (paramLong < 10240L) {
      if (!paramStorageItem.jdField_b_of_type_JavaLangString.contains("data/data/com.tencent.mobileqq")) {
        break label197;
      }
    }
    label197:
    for (paramStorageItem = (StorageItem)this.d.get(i);; paramStorageItem = (StorageItem)this.c.get(i))
    {
      paramStorageItem.jdField_a_of_type_Long += paramLong;
      paramStorageItem.c += 1L;
      return;
      if ((paramLong >= 10240L) && (paramLong < 102400L))
      {
        i = 1;
        break;
      }
      if ((paramLong >= 102400L) && (paramLong < 1048576L))
      {
        i = 2;
        break;
      }
      if ((paramLong >= 1048576L) && (paramLong < 2097152L))
      {
        i = 3;
        break;
      }
      if ((paramLong >= 2097152L) && (paramLong < 10485760L))
      {
        i = 4;
        break;
      }
      if ((paramLong >= 10485760L) && (paramLong < 104857600L))
      {
        i = 5;
        break;
      }
      if (paramLong < 104857600L) {
        break;
      }
      i = 6;
      break;
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
    //   13: lconst_0
    //   14: lstore 54
    //   16: aload_0
    //   17: invokestatic 388	java/lang/System:currentTimeMillis	()J
    //   20: ldc2_w 389
    //   23: ldiv
    //   24: putfield 96	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   27: invokestatic 349	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   30: invokevirtual 394	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   33: checkcast 396	com/tencent/mobileqq/app/QQAppInterface
    //   36: astore 64
    //   38: aload 64
    //   40: ifnull +12 -> 52
    //   43: aload_0
    //   44: aload 64
    //   46: invokevirtual 399	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   49: putfield 102	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   52: aload_0
    //   53: new 131	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: getfield 102	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 401
    //   70: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: getfield 96	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   77: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   80: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: putfield 102	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   89: invokestatic 349	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   92: ldc_w 403
    //   95: iconst_0
    //   96: invokevirtual 407	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   99: astore 64
    //   101: aload 64
    //   103: ldc_w 409
    //   106: lconst_0
    //   107: invokeinterface 415 4 0
    //   112: lstore 6
    //   114: aload_0
    //   115: getfield 94	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Boolean	Z
    //   118: ifeq +41 -> 159
    //   121: lload 6
    //   123: lconst_0
    //   124: lcmp
    //   125: ifle +34 -> 159
    //   128: aload_0
    //   129: getfield 96	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   132: lload 6
    //   134: lsub
    //   135: invokestatic 419	java/lang/Math:abs	(J)J
    //   138: ldc2_w 420
    //   141: lcmp
    //   142: ifge +17 -> 159
    //   145: aload_0
    //   146: iconst_0
    //   147: putfield 94	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Boolean	Z
    //   150: ldc 173
    //   152: iconst_2
    //   153: ldc_w 423
    //   156: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_0
    //   160: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   163: invokevirtual 426	java/util/ArrayList:clear	()V
    //   166: aload_0
    //   167: getfield 78	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   170: invokevirtual 426	java/util/ArrayList:clear	()V
    //   173: aload_0
    //   174: getfield 108	com/tencent/mobileqq/statistics/storage/StorageReport:c	Ljava/util/ArrayList;
    //   177: invokevirtual 426	java/util/ArrayList:clear	()V
    //   180: aload_0
    //   181: getfield 110	com/tencent/mobileqq/statistics/storage/StorageReport:d	Ljava/util/ArrayList;
    //   184: invokevirtual 426	java/util/ArrayList:clear	()V
    //   187: iconst_0
    //   188: istore_2
    //   189: iload_2
    //   190: bipush 7
    //   192: if_icmpge +80 -> 272
    //   195: getstatic 34	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   198: ldc 28
    //   200: invokevirtual 153	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   203: checkcast 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   206: astore 65
    //   208: aload 65
    //   210: lconst_0
    //   211: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   214: aload 65
    //   216: lconst_0
    //   217: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   220: aload_0
    //   221: getfield 108	com/tencent/mobileqq/statistics/storage/StorageReport:c	Ljava/util/ArrayList;
    //   224: aload 65
    //   226: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   229: pop
    //   230: getstatic 34	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   233: ldc 28
    //   235: invokevirtual 153	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   238: checkcast 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   241: astore 65
    //   243: aload 65
    //   245: lconst_0
    //   246: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   249: aload 65
    //   251: lconst_0
    //   252: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   255: aload_0
    //   256: getfield 110	com/tencent/mobileqq/statistics/storage/StorageReport:d	Ljava/util/ArrayList;
    //   259: aload 65
    //   261: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   264: pop
    //   265: iload_2
    //   266: iconst_1
    //   267: iadd
    //   268: istore_2
    //   269: goto -80 -> 189
    //   272: new 129	java/io/File
    //   275: dup
    //   276: getstatic 62	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   279: iconst_0
    //   280: aaload
    //   281: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   284: invokevirtual 235	java/io/File:list	()[Ljava/lang/String;
    //   287: astore 65
    //   289: aload 65
    //   291: ifnull +2728 -> 3019
    //   294: aload 65
    //   296: arraylength
    //   297: ifle +2722 -> 3019
    //   300: lconst_0
    //   301: lstore 10
    //   303: lconst_0
    //   304: lstore 12
    //   306: iconst_0
    //   307: istore_2
    //   308: lload 10
    //   310: lstore 8
    //   312: lload 12
    //   314: lstore 6
    //   316: iload_2
    //   317: aload 65
    //   319: arraylength
    //   320: if_icmpge +2705 -> 3025
    //   323: new 129	java/io/File
    //   326: dup
    //   327: new 131	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   334: getstatic 62	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   337: iconst_0
    //   338: aaload
    //   339: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc 138
    //   344: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload 65
    //   349: iload_2
    //   350: aaload
    //   351: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   360: astore 66
    //   362: aload 66
    //   364: invokevirtual 149	java/io/File:isDirectory	()Z
    //   367: ifeq +98 -> 465
    //   370: new 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   373: dup
    //   374: invokespecial 427	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   377: astore 67
    //   379: aload 67
    //   381: iconst_0
    //   382: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   385: aload 67
    //   387: aload_0
    //   388: aload 66
    //   390: invokevirtual 165	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/io/File;)J
    //   393: putfield 167	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   396: aload 67
    //   398: aload 65
    //   400: iload_2
    //   401: aaload
    //   402: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   405: aload 67
    //   407: new 131	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   414: getstatic 62	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   417: iconst_0
    //   418: aaload
    //   419: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: ldc 138
    //   424: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 65
    //   429: iload_2
    //   430: aaload
    //   431: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: putfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   440: aload 67
    //   442: lconst_0
    //   443: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   446: aload 67
    //   448: lconst_0
    //   449: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   452: aload_0
    //   453: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   456: aload 67
    //   458: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   461: pop
    //   462: goto +2550 -> 3012
    //   465: lload 12
    //   467: aload_0
    //   468: getstatic 62	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   471: iconst_0
    //   472: aaload
    //   473: aload 65
    //   475: iload_2
    //   476: aaload
    //   477: invokespecial 243	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   480: ladd
    //   481: lstore 12
    //   483: lload 10
    //   485: lconst_1
    //   486: ladd
    //   487: lstore 10
    //   489: goto +2523 -> 3012
    //   492: iload_2
    //   493: getstatic 62	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   496: arraylength
    //   497: if_icmpge +2540 -> 3037
    //   500: getstatic 62	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   503: iload_2
    //   504: aaload
    //   505: astore 65
    //   507: new 129	java/io/File
    //   510: dup
    //   511: aload 65
    //   513: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   516: astore 66
    //   518: aload 66
    //   520: invokevirtual 149	java/io/File:isDirectory	()Z
    //   523: ifeq +2507 -> 3030
    //   526: new 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   529: dup
    //   530: invokespecial 427	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   533: astore 67
    //   535: aload 67
    //   537: iconst_0
    //   538: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   541: aload 67
    //   543: aload_0
    //   544: aload 66
    //   546: invokevirtual 165	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/io/File;)J
    //   549: putfield 167	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   552: aload 67
    //   554: aload 65
    //   556: ldc 138
    //   558: invokevirtual 431	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   561: iconst_2
    //   562: aaload
    //   563: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   566: aload 67
    //   568: aload 65
    //   570: putfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   573: aload 67
    //   575: lconst_0
    //   576: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   579: aload 67
    //   581: lconst_0
    //   582: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   585: aload_0
    //   586: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   589: aload 67
    //   591: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   594: pop
    //   595: goto +2435 -> 3030
    //   598: iload_2
    //   599: getstatic 68	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   602: arraylength
    //   603: if_icmpge +274 -> 877
    //   606: getstatic 68	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   609: iload_2
    //   610: aaload
    //   611: astore 65
    //   613: new 129	java/io/File
    //   616: dup
    //   617: aload 65
    //   619: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   622: invokevirtual 235	java/io/File:list	()[Ljava/lang/String;
    //   625: astore 66
    //   627: aload 66
    //   629: ifnull +2422 -> 3051
    //   632: aload 66
    //   634: arraylength
    //   635: ifle +2416 -> 3051
    //   638: iconst_0
    //   639: istore 4
    //   641: iload 4
    //   643: aload 66
    //   645: arraylength
    //   646: if_icmpge +2405 -> 3051
    //   649: new 129	java/io/File
    //   652: dup
    //   653: new 131	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   660: aload 65
    //   662: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: ldc 138
    //   667: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload 66
    //   672: iload 4
    //   674: aaload
    //   675: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   684: astore 67
    //   686: ldc 66
    //   688: new 131	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   695: aload 65
    //   697: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: ldc 138
    //   702: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: aload 66
    //   707: iload 4
    //   709: aaload
    //   710: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokevirtual 434	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   719: ifeq +36 -> 755
    //   722: ldc 173
    //   724: iconst_2
    //   725: new 131	java/lang/StringBuilder
    //   728: dup
    //   729: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   732: ldc_w 436
    //   735: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: aload 66
    //   740: iload 4
    //   742: aaload
    //   743: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: goto +2290 -> 3042
    //   755: aload 67
    //   757: invokevirtual 149	java/io/File:isDirectory	()Z
    //   760: ifeq +102 -> 862
    //   763: new 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   766: dup
    //   767: invokespecial 427	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   770: astore 68
    //   772: aload 68
    //   774: iconst_0
    //   775: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   778: aload 68
    //   780: aload_0
    //   781: aload 67
    //   783: invokevirtual 165	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/io/File;)J
    //   786: putfield 167	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   789: aload 68
    //   791: aload 66
    //   793: iload 4
    //   795: aaload
    //   796: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   799: aload 68
    //   801: new 131	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   808: aload 65
    //   810: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: ldc 138
    //   815: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: aload 66
    //   820: iload 4
    //   822: aaload
    //   823: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   829: putfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   832: aload 68
    //   834: lconst_0
    //   835: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   838: aload 68
    //   840: lconst_0
    //   841: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   844: aload_0
    //   845: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   848: aload 68
    //   850: invokevirtual 197	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   853: pop
    //   854: goto +2188 -> 3042
    //   857: astore_1
    //   858: aload_0
    //   859: monitorexit
    //   860: aload_1
    //   861: athrow
    //   862: aload_0
    //   863: aload 65
    //   865: aload 66
    //   867: iload 4
    //   869: aaload
    //   870: invokespecial 243	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   873: pop2
    //   874: goto +2168 -> 3042
    //   877: ldc 173
    //   879: iconst_2
    //   880: new 131	java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   887: ldc_w 438
    //   890: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: aload_0
    //   894: getfield 96	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   897: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   900: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   906: iconst_0
    //   907: istore_2
    //   908: lconst_0
    //   909: lstore 14
    //   911: lconst_0
    //   912: lstore 18
    //   914: lconst_0
    //   915: lstore 32
    //   917: lconst_0
    //   918: lstore 10
    //   920: lconst_0
    //   921: lstore 12
    //   923: lconst_0
    //   924: lstore 20
    //   926: lconst_0
    //   927: lstore 22
    //   929: lload 6
    //   931: lstore 24
    //   933: lload 8
    //   935: lstore 16
    //   937: lload 18
    //   939: lstore 8
    //   941: lload 12
    //   943: lstore 6
    //   945: aload_0
    //   946: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   949: invokevirtual 193	java/util/ArrayList:size	()I
    //   952: istore 4
    //   954: iload_2
    //   955: iload 4
    //   957: if_icmpge +1493 -> 2450
    //   960: aload_0
    //   961: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   964: invokevirtual 193	java/util/ArrayList:size	()I
    //   967: sipush 500
    //   970: if_icmplt +473 -> 1443
    //   973: ldc2_w 439
    //   976: invokestatic 446	java/lang/Thread:sleep	(J)V
    //   979: aload_0
    //   980: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   983: iload_2
    //   984: invokevirtual 207	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   987: checkcast 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   990: astore 65
    //   992: aload 65
    //   994: lconst_0
    //   995: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   998: aload 65
    //   1000: lconst_0
    //   1001: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1004: aload 65
    //   1006: lconst_0
    //   1007: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1010: aload 65
    //   1012: getfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1015: astore 66
    //   1017: lload 6
    //   1019: lstore 62
    //   1021: lload 14
    //   1023: lstore 46
    //   1025: lload 20
    //   1027: lstore 42
    //   1029: lload 8
    //   1031: lstore 60
    //   1033: lload 22
    //   1035: lstore 38
    //   1037: lload 32
    //   1039: lstore 36
    //   1041: lload 10
    //   1043: lstore 58
    //   1045: lload 16
    //   1047: lstore 18
    //   1049: lload 24
    //   1051: lstore 12
    //   1053: lload 54
    //   1055: lstore 56
    //   1057: new 129	java/io/File
    //   1060: dup
    //   1061: aload 66
    //   1063: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   1066: invokevirtual 235	java/io/File:list	()[Ljava/lang/String;
    //   1069: astore 67
    //   1071: aload 67
    //   1073: ifnull +389 -> 1462
    //   1076: lload 6
    //   1078: lstore 62
    //   1080: lload 14
    //   1082: lstore 46
    //   1084: lload 20
    //   1086: lstore 42
    //   1088: lload 8
    //   1090: lstore 60
    //   1092: lload 22
    //   1094: lstore 38
    //   1096: lload 32
    //   1098: lstore 36
    //   1100: lload 10
    //   1102: lstore 58
    //   1104: lload 16
    //   1106: lstore 18
    //   1108: lload 24
    //   1110: lstore 12
    //   1112: lload 54
    //   1114: lstore 56
    //   1116: aload 67
    //   1118: arraylength
    //   1119: ifle +343 -> 1462
    //   1122: lload 6
    //   1124: lstore 62
    //   1126: lload 14
    //   1128: lstore 46
    //   1130: lload 20
    //   1132: lstore 42
    //   1134: lload 8
    //   1136: lstore 60
    //   1138: lload 22
    //   1140: lstore 38
    //   1142: lload 32
    //   1144: lstore 36
    //   1146: lload 10
    //   1148: lstore 58
    //   1150: lload 16
    //   1152: lstore 18
    //   1154: lload 24
    //   1156: lstore 12
    //   1158: lload 54
    //   1160: lstore 56
    //   1162: aload 67
    //   1164: arraylength
    //   1165: istore 5
    //   1167: iconst_0
    //   1168: istore 4
    //   1170: iload 4
    //   1172: iload 5
    //   1174: if_icmpge +288 -> 1462
    //   1177: aload 67
    //   1179: iload 4
    //   1181: aaload
    //   1182: astore 68
    //   1184: lload 6
    //   1186: lstore 62
    //   1188: lload 14
    //   1190: lstore 46
    //   1192: lload 20
    //   1194: lstore 42
    //   1196: lload 8
    //   1198: lstore 60
    //   1200: lload 22
    //   1202: lstore 38
    //   1204: lload 32
    //   1206: lstore 36
    //   1208: lload 10
    //   1210: lstore 58
    //   1212: lload 16
    //   1214: lstore 18
    //   1216: lload 24
    //   1218: lstore 12
    //   1220: lload 54
    //   1222: lstore 56
    //   1224: aload_0
    //   1225: new 131	java/lang/StringBuilder
    //   1228: dup
    //   1229: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   1232: aload 66
    //   1234: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: ldc 138
    //   1239: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: aload 68
    //   1244: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1250: invokespecial 448	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1253: astore 68
    //   1255: lload 6
    //   1257: lstore 62
    //   1259: lload 14
    //   1261: lstore 46
    //   1263: lload 20
    //   1265: lstore 42
    //   1267: lload 8
    //   1269: lstore 60
    //   1271: lload 22
    //   1273: lstore 38
    //   1275: lload 32
    //   1277: lstore 36
    //   1279: lload 10
    //   1281: lstore 58
    //   1283: lload 16
    //   1285: lstore 18
    //   1287: lload 24
    //   1289: lstore 12
    //   1291: lload 54
    //   1293: lstore 56
    //   1295: aload 65
    //   1297: aload 65
    //   1299: getfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1302: aload 68
    //   1304: ldc 251
    //   1306: lconst_0
    //   1307: invokevirtual 449	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1310: ladd
    //   1311: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1314: lload 6
    //   1316: lstore 62
    //   1318: lload 14
    //   1320: lstore 46
    //   1322: lload 20
    //   1324: lstore 42
    //   1326: lload 8
    //   1328: lstore 60
    //   1330: lload 22
    //   1332: lstore 38
    //   1334: lload 32
    //   1336: lstore 36
    //   1338: lload 10
    //   1340: lstore 58
    //   1342: lload 16
    //   1344: lstore 18
    //   1346: lload 24
    //   1348: lstore 12
    //   1350: lload 54
    //   1352: lstore 56
    //   1354: aload 65
    //   1356: aload 65
    //   1358: getfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1361: aload 68
    //   1363: ldc_w 257
    //   1366: lconst_0
    //   1367: invokevirtual 449	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1370: ladd
    //   1371: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1374: lload 6
    //   1376: lstore 62
    //   1378: lload 14
    //   1380: lstore 46
    //   1382: lload 20
    //   1384: lstore 42
    //   1386: lload 8
    //   1388: lstore 60
    //   1390: lload 22
    //   1392: lstore 38
    //   1394: lload 32
    //   1396: lstore 36
    //   1398: lload 10
    //   1400: lstore 58
    //   1402: lload 16
    //   1404: lstore 18
    //   1406: lload 24
    //   1408: lstore 12
    //   1410: lload 54
    //   1412: lstore 56
    //   1414: aload 65
    //   1416: aload 65
    //   1418: getfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1421: aload 68
    //   1423: ldc_w 259
    //   1426: lconst_0
    //   1427: invokevirtual 449	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1430: ladd
    //   1431: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1434: iload 4
    //   1436: iconst_1
    //   1437: iadd
    //   1438: istore 4
    //   1440: goto -270 -> 1170
    //   1443: ldc2_w 450
    //   1446: invokestatic 446	java/lang/Thread:sleep	(J)V
    //   1449: goto -470 -> 979
    //   1452: astore 65
    //   1454: aload 65
    //   1456: invokevirtual 454	java/lang/InterruptedException:printStackTrace	()V
    //   1459: goto -480 -> 979
    //   1462: lload 6
    //   1464: lstore 62
    //   1466: lload 14
    //   1468: lstore 46
    //   1470: lload 20
    //   1472: lstore 42
    //   1474: lload 8
    //   1476: lstore 60
    //   1478: lload 22
    //   1480: lstore 38
    //   1482: lload 32
    //   1484: lstore 36
    //   1486: lload 10
    //   1488: lstore 58
    //   1490: lload 16
    //   1492: lstore 18
    //   1494: lload 24
    //   1496: lstore 12
    //   1498: lload 54
    //   1500: lstore 56
    //   1502: aload 66
    //   1504: ldc_w 456
    //   1507: invokevirtual 366	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1510: ifeq +597 -> 2107
    //   1513: lload 6
    //   1515: lstore 62
    //   1517: lload 14
    //   1519: lstore 46
    //   1521: lload 20
    //   1523: lstore 42
    //   1525: lload 8
    //   1527: lstore 60
    //   1529: lload 22
    //   1531: lstore 38
    //   1533: lload 32
    //   1535: lstore 36
    //   1537: lload 10
    //   1539: lstore 58
    //   1541: lload 16
    //   1543: lstore 18
    //   1545: lload 24
    //   1547: lstore 12
    //   1549: lload 54
    //   1551: lstore 56
    //   1553: aload 66
    //   1555: ldc_w 458
    //   1558: invokevirtual 366	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1561: ifeq +369 -> 1930
    //   1564: lload 6
    //   1566: lstore 62
    //   1568: lload 14
    //   1570: lstore 46
    //   1572: lload 20
    //   1574: lstore 42
    //   1576: lload 8
    //   1578: lstore 60
    //   1580: lload 22
    //   1582: lstore 38
    //   1584: lload 32
    //   1586: lstore 36
    //   1588: lload 10
    //   1590: lstore 58
    //   1592: lload 16
    //   1594: lstore 18
    //   1596: lload 24
    //   1598: lstore 12
    //   1600: lload 54
    //   1602: lstore 56
    //   1604: lload 20
    //   1606: aload 65
    //   1608: getfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1611: ladd
    //   1612: lstore 30
    //   1614: lload 6
    //   1616: lstore 62
    //   1618: lload 14
    //   1620: lstore 46
    //   1622: lload 30
    //   1624: lstore 42
    //   1626: lload 8
    //   1628: lstore 60
    //   1630: lload 22
    //   1632: lstore 38
    //   1634: lload 32
    //   1636: lstore 36
    //   1638: lload 10
    //   1640: lstore 58
    //   1642: lload 16
    //   1644: lstore 18
    //   1646: lload 24
    //   1648: lstore 12
    //   1650: lload 54
    //   1652: lstore 56
    //   1654: lload 14
    //   1656: aload 65
    //   1658: getfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1661: ladd
    //   1662: lstore 28
    //   1664: lload 6
    //   1666: lstore 62
    //   1668: lload 28
    //   1670: lstore 46
    //   1672: lload 30
    //   1674: lstore 42
    //   1676: lload 8
    //   1678: lstore 60
    //   1680: lload 22
    //   1682: lstore 38
    //   1684: lload 32
    //   1686: lstore 36
    //   1688: lload 10
    //   1690: lstore 58
    //   1692: lload 16
    //   1694: lstore 18
    //   1696: lload 24
    //   1698: lstore 12
    //   1700: lload 54
    //   1702: lstore 56
    //   1704: lload 6
    //   1706: aload 65
    //   1708: getfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1711: ladd
    //   1712: lstore 26
    //   1714: lload 24
    //   1716: lstore 52
    //   1718: lload 16
    //   1720: lstore 50
    //   1722: lload 10
    //   1724: lstore 48
    //   1726: lload 32
    //   1728: lstore 44
    //   1730: lload 22
    //   1732: lstore 40
    //   1734: lload 8
    //   1736: lstore 34
    //   1738: lload 26
    //   1740: lstore 62
    //   1742: lload 28
    //   1744: lstore 46
    //   1746: lload 30
    //   1748: lstore 42
    //   1750: lload 34
    //   1752: lstore 60
    //   1754: lload 40
    //   1756: lstore 38
    //   1758: lload 44
    //   1760: lstore 36
    //   1762: lload 48
    //   1764: lstore 58
    //   1766: lload 50
    //   1768: lstore 18
    //   1770: lload 52
    //   1772: lstore 12
    //   1774: lload 54
    //   1776: lstore 56
    //   1778: lload 54
    //   1780: aload 65
    //   1782: getfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1785: ladd
    //   1786: lstore 54
    //   1788: lload 26
    //   1790: lstore 62
    //   1792: lload 28
    //   1794: lstore 46
    //   1796: lload 30
    //   1798: lstore 42
    //   1800: lload 34
    //   1802: lstore 60
    //   1804: lload 40
    //   1806: lstore 38
    //   1808: lload 44
    //   1810: lstore 36
    //   1812: lload 48
    //   1814: lstore 58
    //   1816: lload 50
    //   1818: lstore 18
    //   1820: lload 52
    //   1822: lstore 12
    //   1824: lload 54
    //   1826: lstore 56
    //   1828: ldc 173
    //   1830: iconst_1
    //   1831: new 131	java/lang/StringBuilder
    //   1834: dup
    //   1835: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   1838: ldc_w 460
    //   1841: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: aload 65
    //   1846: invokevirtual 176	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   1849: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1852: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1855: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1858: lload 52
    //   1860: lstore 12
    //   1862: lload 50
    //   1864: lstore 16
    //   1866: lload 48
    //   1868: lstore 10
    //   1870: lload 44
    //   1872: lstore 32
    //   1874: lload 40
    //   1876: lstore 22
    //   1878: lload 34
    //   1880: lstore 8
    //   1882: lload 30
    //   1884: lstore 20
    //   1886: lload 28
    //   1888: lstore 14
    //   1890: lload 26
    //   1892: lstore 6
    //   1894: aload_1
    //   1895: ifnull +24 -> 1919
    //   1898: aload_1
    //   1899: iload_2
    //   1900: iconst_1
    //   1901: iadd
    //   1902: iload_3
    //   1903: iconst_2
    //   1904: isub
    //   1905: imul
    //   1906: aload_0
    //   1907: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1910: invokevirtual 193	java/util/ArrayList:size	()I
    //   1913: idiv
    //   1914: invokeinterface 383 2 0
    //   1919: iload_2
    //   1920: iconst_1
    //   1921: iadd
    //   1922: istore_2
    //   1923: lload 12
    //   1925: lstore 24
    //   1927: goto -982 -> 945
    //   1930: lload 6
    //   1932: lstore 62
    //   1934: lload 14
    //   1936: lstore 46
    //   1938: lload 20
    //   1940: lstore 42
    //   1942: lload 8
    //   1944: lstore 60
    //   1946: lload 22
    //   1948: lstore 38
    //   1950: lload 32
    //   1952: lstore 36
    //   1954: lload 10
    //   1956: lstore 58
    //   1958: lload 16
    //   1960: lstore 18
    //   1962: lload 24
    //   1964: lstore 12
    //   1966: lload 54
    //   1968: lstore 56
    //   1970: lload 24
    //   1972: aload 65
    //   1974: getfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1977: ladd
    //   1978: lstore 52
    //   1980: lload 6
    //   1982: lstore 62
    //   1984: lload 14
    //   1986: lstore 46
    //   1988: lload 20
    //   1990: lstore 42
    //   1992: lload 8
    //   1994: lstore 60
    //   1996: lload 22
    //   1998: lstore 38
    //   2000: lload 32
    //   2002: lstore 36
    //   2004: lload 10
    //   2006: lstore 58
    //   2008: lload 16
    //   2010: lstore 18
    //   2012: lload 52
    //   2014: lstore 12
    //   2016: lload 54
    //   2018: lstore 56
    //   2020: lload 16
    //   2022: aload 65
    //   2024: getfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2027: ladd
    //   2028: lstore 50
    //   2030: lload 6
    //   2032: lstore 62
    //   2034: lload 14
    //   2036: lstore 46
    //   2038: lload 20
    //   2040: lstore 42
    //   2042: lload 8
    //   2044: lstore 60
    //   2046: lload 22
    //   2048: lstore 38
    //   2050: lload 32
    //   2052: lstore 36
    //   2054: lload 10
    //   2056: lstore 58
    //   2058: lload 50
    //   2060: lstore 18
    //   2062: lload 52
    //   2064: lstore 12
    //   2066: lload 54
    //   2068: lstore 56
    //   2070: lload 10
    //   2072: aload 65
    //   2074: getfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2077: ladd
    //   2078: lstore 48
    //   2080: lload 6
    //   2082: lstore 26
    //   2084: lload 14
    //   2086: lstore 28
    //   2088: lload 20
    //   2090: lstore 30
    //   2092: lload 8
    //   2094: lstore 34
    //   2096: lload 22
    //   2098: lstore 40
    //   2100: lload 32
    //   2102: lstore 44
    //   2104: goto -366 -> 1738
    //   2107: lload 6
    //   2109: lstore 26
    //   2111: lload 14
    //   2113: lstore 28
    //   2115: lload 20
    //   2117: lstore 30
    //   2119: lload 8
    //   2121: lstore 34
    //   2123: lload 22
    //   2125: lstore 40
    //   2127: lload 32
    //   2129: lstore 44
    //   2131: lload 10
    //   2133: lstore 48
    //   2135: lload 16
    //   2137: lstore 50
    //   2139: lload 24
    //   2141: lstore 52
    //   2143: lload 6
    //   2145: lstore 62
    //   2147: lload 14
    //   2149: lstore 46
    //   2151: lload 20
    //   2153: lstore 42
    //   2155: lload 8
    //   2157: lstore 60
    //   2159: lload 22
    //   2161: lstore 38
    //   2163: lload 32
    //   2165: lstore 36
    //   2167: lload 10
    //   2169: lstore 58
    //   2171: lload 16
    //   2173: lstore 18
    //   2175: lload 24
    //   2177: lstore 12
    //   2179: lload 54
    //   2181: lstore 56
    //   2183: aload 66
    //   2185: ldc 64
    //   2187: invokevirtual 366	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2190: ifeq -452 -> 1738
    //   2193: lload 6
    //   2195: lstore 62
    //   2197: lload 14
    //   2199: lstore 46
    //   2201: lload 20
    //   2203: lstore 42
    //   2205: lload 8
    //   2207: lstore 60
    //   2209: lload 22
    //   2211: lstore 38
    //   2213: lload 32
    //   2215: lstore 36
    //   2217: lload 10
    //   2219: lstore 58
    //   2221: lload 16
    //   2223: lstore 18
    //   2225: lload 24
    //   2227: lstore 12
    //   2229: lload 54
    //   2231: lstore 56
    //   2233: lload 32
    //   2235: aload 65
    //   2237: getfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   2240: ladd
    //   2241: lstore 44
    //   2243: lload 6
    //   2245: lstore 62
    //   2247: lload 14
    //   2249: lstore 46
    //   2251: lload 20
    //   2253: lstore 42
    //   2255: lload 8
    //   2257: lstore 60
    //   2259: lload 22
    //   2261: lstore 38
    //   2263: lload 44
    //   2265: lstore 36
    //   2267: lload 10
    //   2269: lstore 58
    //   2271: lload 16
    //   2273: lstore 18
    //   2275: lload 24
    //   2277: lstore 12
    //   2279: lload 54
    //   2281: lstore 56
    //   2283: lload 22
    //   2285: aload 65
    //   2287: getfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2290: ladd
    //   2291: lstore 40
    //   2293: lload 6
    //   2295: lstore 62
    //   2297: lload 14
    //   2299: lstore 46
    //   2301: lload 20
    //   2303: lstore 42
    //   2305: lload 8
    //   2307: lstore 60
    //   2309: lload 40
    //   2311: lstore 38
    //   2313: lload 44
    //   2315: lstore 36
    //   2317: lload 10
    //   2319: lstore 58
    //   2321: lload 16
    //   2323: lstore 18
    //   2325: lload 24
    //   2327: lstore 12
    //   2329: lload 54
    //   2331: lstore 56
    //   2333: aload 65
    //   2335: getfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2338: lstore 22
    //   2340: lload 8
    //   2342: lload 22
    //   2344: ladd
    //   2345: lstore 34
    //   2347: lload 6
    //   2349: lstore 26
    //   2351: lload 14
    //   2353: lstore 28
    //   2355: lload 20
    //   2357: lstore 30
    //   2359: lload 10
    //   2361: lstore 48
    //   2363: lload 16
    //   2365: lstore 50
    //   2367: lload 24
    //   2369: lstore 52
    //   2371: goto -633 -> 1738
    //   2374: astore 65
    //   2376: aload 65
    //   2378: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   2381: ldc 173
    //   2383: iconst_1
    //   2384: new 131	java/lang/StringBuilder
    //   2387: dup
    //   2388: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   2391: ldc_w 463
    //   2394: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2397: aload 65
    //   2399: invokevirtual 467	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   2402: invokevirtual 470	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2405: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2408: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2411: lload 62
    //   2413: lstore 6
    //   2415: lload 46
    //   2417: lstore 14
    //   2419: lload 42
    //   2421: lstore 20
    //   2423: lload 60
    //   2425: lstore 8
    //   2427: lload 38
    //   2429: lstore 22
    //   2431: lload 36
    //   2433: lstore 32
    //   2435: lload 58
    //   2437: lstore 10
    //   2439: lload 18
    //   2441: lstore 16
    //   2443: lload 56
    //   2445: lstore 54
    //   2447: goto -553 -> 1894
    //   2450: aload_0
    //   2451: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2454: aload_0
    //   2455: getfield 92	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport$MyFileLargeComparator	Lcom/tencent/mobileqq/statistics/storage/StorageReport$MyFileLargeComparator;
    //   2458: invokestatic 203	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   2461: ldc 173
    //   2463: iconst_1
    //   2464: ldc_w 472
    //   2467: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2470: iconst_0
    //   2471: istore_2
    //   2472: iload_2
    //   2473: aload_0
    //   2474: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2477: invokevirtual 193	java/util/ArrayList:size	()I
    //   2480: if_icmpge +25 -> 2505
    //   2483: aload_0
    //   2484: aload_0
    //   2485: getfield 80	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2488: iload_2
    //   2489: invokevirtual 207	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2492: checkcast 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2495: invokespecial 186	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2498: iload_2
    //   2499: iconst_1
    //   2500: iadd
    //   2501: istore_2
    //   2502: goto -30 -> 2472
    //   2505: ldc 173
    //   2507: iconst_1
    //   2508: new 131	java/lang/StringBuilder
    //   2511: dup
    //   2512: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   2515: ldc_w 474
    //   2518: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2521: lload 54
    //   2523: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2526: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2529: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2532: new 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2535: dup
    //   2536: invokespecial 427	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   2539: astore 65
    //   2541: aload 65
    //   2543: iconst_0
    //   2544: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   2547: aload 65
    //   2549: ldc_w 476
    //   2552: putfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2555: aload 65
    //   2557: lload 16
    //   2559: lload 22
    //   2561: ladd
    //   2562: lload 14
    //   2564: ladd
    //   2565: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2568: aload 65
    //   2570: lload 10
    //   2572: lload 8
    //   2574: ladd
    //   2575: lload 6
    //   2577: ladd
    //   2578: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2581: aload 65
    //   2583: lconst_0
    //   2584: putfield 167	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   2587: aload 65
    //   2589: lload 54
    //   2591: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   2594: aload_0
    //   2595: aload 65
    //   2597: invokespecial 186	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2600: ldc 173
    //   2602: iconst_1
    //   2603: new 131	java/lang/StringBuilder
    //   2606: dup
    //   2607: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   2610: ldc_w 478
    //   2613: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2616: aload 65
    //   2618: invokevirtual 176	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   2621: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2624: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2627: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2630: new 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2633: dup
    //   2634: invokespecial 427	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   2637: astore 65
    //   2639: aload 65
    //   2641: iconst_0
    //   2642: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   2645: aload 65
    //   2647: ldc_w 480
    //   2650: putfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2653: aload 65
    //   2655: aload_0
    //   2656: aload_0
    //   2657: getfield 108	com/tencent/mobileqq/statistics/storage/StorageReport:c	Ljava/util/ArrayList;
    //   2660: invokespecial 482	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   2663: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2666: aload 65
    //   2668: lload 14
    //   2670: lload 16
    //   2672: ladd
    //   2673: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2676: aload 65
    //   2678: lload 6
    //   2680: lload 10
    //   2682: ladd
    //   2683: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2686: aload 65
    //   2688: lconst_0
    //   2689: putfield 167	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   2692: aload 65
    //   2694: lload 24
    //   2696: lload 20
    //   2698: ladd
    //   2699: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   2702: aload_0
    //   2703: aload 65
    //   2705: invokespecial 186	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2708: ldc 173
    //   2710: iconst_1
    //   2711: new 131	java/lang/StringBuilder
    //   2714: dup
    //   2715: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   2718: ldc_w 484
    //   2721: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2724: aload 65
    //   2726: invokevirtual 176	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   2729: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2732: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2735: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2738: new 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2741: dup
    //   2742: invokespecial 427	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   2745: astore 65
    //   2747: aload 65
    //   2749: iconst_0
    //   2750: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   2753: aload 65
    //   2755: ldc_w 486
    //   2758: putfield 162	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2761: aload 65
    //   2763: aload_0
    //   2764: aload_0
    //   2765: getfield 110	com/tencent/mobileqq/statistics/storage/StorageReport:d	Ljava/util/ArrayList;
    //   2768: invokespecial 482	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   2771: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2774: aload 65
    //   2776: lload 22
    //   2778: putfield 169	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2781: aload 65
    //   2783: lload 8
    //   2785: putfield 336	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2788: aload 65
    //   2790: lconst_0
    //   2791: putfield 167	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   2794: aload 65
    //   2796: lload 32
    //   2798: putfield 160	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   2801: aload_0
    //   2802: aload 65
    //   2804: invokespecial 186	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2807: ldc 173
    //   2809: iconst_1
    //   2810: new 131	java/lang/StringBuilder
    //   2813: dup
    //   2814: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   2817: ldc_w 488
    //   2820: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2823: aload 65
    //   2825: invokevirtual 176	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   2828: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2831: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2834: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2837: ldc 173
    //   2839: iconst_1
    //   2840: ldc_w 490
    //   2843: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2846: iconst_0
    //   2847: istore_2
    //   2848: iload_2
    //   2849: aload_0
    //   2850: getfield 78	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2853: invokevirtual 193	java/util/ArrayList:size	()I
    //   2856: if_icmpge +58 -> 2914
    //   2859: aload_0
    //   2860: getfield 78	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2863: iload_2
    //   2864: invokevirtual 207	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2867: checkcast 28	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2870: astore 65
    //   2872: aload 65
    //   2874: new 131	java/lang/StringBuilder
    //   2877: dup
    //   2878: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   2881: ldc_w 492
    //   2884: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2887: aload 65
    //   2889: getfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2892: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2895: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2898: putfield 154	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2901: aload_0
    //   2902: aload 65
    //   2904: invokespecial 186	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2907: iload_2
    //   2908: iconst_1
    //   2909: iadd
    //   2910: istore_2
    //   2911: goto -63 -> 2848
    //   2914: aload_0
    //   2915: getfield 94	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Boolean	Z
    //   2918: ifeq +140 -> 3058
    //   2921: aload 64
    //   2923: invokeinterface 496 1 0
    //   2928: ldc_w 409
    //   2931: aload_0
    //   2932: getfield 96	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   2935: invokeinterface 501 4 0
    //   2940: invokeinterface 504 1 0
    //   2945: pop
    //   2946: goto +112 -> 3058
    //   2949: iload_2
    //   2950: bipush 7
    //   2952: if_icmpge +44 -> 2996
    //   2955: getstatic 34	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   2958: aload_0
    //   2959: getfield 108	com/tencent/mobileqq/statistics/storage/StorageReport:c	Ljava/util/ArrayList;
    //   2962: iload_2
    //   2963: invokevirtual 207	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2966: checkcast 506	com/tencent/commonsdk/pool/RecyclablePool$Recyclable
    //   2969: invokevirtual 214	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   2972: getstatic 34	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   2975: aload_0
    //   2976: getfield 110	com/tencent/mobileqq/statistics/storage/StorageReport:d	Ljava/util/ArrayList;
    //   2979: iload_2
    //   2980: invokevirtual 207	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2983: checkcast 506	com/tencent/commonsdk/pool/RecyclablePool$Recyclable
    //   2986: invokevirtual 214	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   2989: iload_2
    //   2990: iconst_1
    //   2991: iadd
    //   2992: istore_2
    //   2993: goto -44 -> 2949
    //   2996: aload_1
    //   2997: ifnull +10 -> 3007
    //   3000: aload_1
    //   3001: iload_3
    //   3002: invokeinterface 383 2 0
    //   3007: aload_0
    //   3008: monitorexit
    //   3009: lload 24
    //   3011: lreturn
    //   3012: iload_2
    //   3013: iconst_1
    //   3014: iadd
    //   3015: istore_2
    //   3016: goto -2708 -> 308
    //   3019: lconst_0
    //   3020: lstore 8
    //   3022: lconst_0
    //   3023: lstore 6
    //   3025: iconst_1
    //   3026: istore_2
    //   3027: goto -2535 -> 492
    //   3030: iload_2
    //   3031: iconst_1
    //   3032: iadd
    //   3033: istore_2
    //   3034: goto -2542 -> 492
    //   3037: iconst_0
    //   3038: istore_2
    //   3039: goto -2441 -> 598
    //   3042: iload 4
    //   3044: iconst_1
    //   3045: iadd
    //   3046: istore 4
    //   3048: goto -2407 -> 641
    //   3051: iload_2
    //   3052: iconst_1
    //   3053: iadd
    //   3054: istore_2
    //   3055: goto -2457 -> 598
    //   3058: iconst_0
    //   3059: istore_2
    //   3060: goto -111 -> 2949
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3063	0	this	StorageReport
    //   0	3063	1	paramIProgressCallback	com.tencent.mobileqq.activity.QQSettingCleanActivity.IProgressCallback
    //   0	3063	2	paramInt1	int
    //   0	3063	3	paramInt2	int
    //   639	2408	4	i	int
    //   1165	10	5	j	int
    //   112	2912	6	l1	long
    //   310	2711	8	l2	long
    //   301	2380	10	l3	long
    //   304	2024	12	l4	long
    //   909	1760	14	l5	long
    //   935	1736	16	l6	long
    //   912	1528	18	l7	long
    //   924	1773	20	l8	long
    //   927	1850	22	l9	long
    //   931	2079	24	l10	long
    //   1712	638	26	l11	long
    //   1662	692	28	l12	long
    //   1612	746	30	l13	long
    //   915	1882	32	l14	long
    //   1736	610	34	l15	long
    //   1039	1393	36	l16	long
    //   1035	1393	38	l17	long
    //   1732	578	40	l18	long
    //   1027	1393	42	l19	long
    //   1728	586	44	l20	long
    //   1023	1393	46	l21	long
    //   1724	638	48	l22	long
    //   1720	646	50	l23	long
    //   1716	654	52	l24	long
    //   14	2576	54	l25	long
    //   1055	1389	56	l26	long
    //   1043	1393	58	l27	long
    //   1031	1393	60	l28	long
    //   1019	1393	62	l29	long
    //   36	2886	64	localObject1	Object
    //   206	1211	65	localObject2	Object
    //   1452	882	65	localInterruptedException	java.lang.InterruptedException
    //   2374	24	65	localException	java.lang.Exception
    //   2539	364	65	localStorageItem	StorageItem
    //   360	1824	66	localObject3	Object
    //   377	801	67	localObject4	Object
    //   770	652	68	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   6	13	857	finally
    //   16	38	857	finally
    //   43	52	857	finally
    //   52	121	857	finally
    //   128	159	857	finally
    //   159	187	857	finally
    //   195	265	857	finally
    //   272	289	857	finally
    //   294	300	857	finally
    //   316	462	857	finally
    //   465	483	857	finally
    //   492	595	857	finally
    //   598	627	857	finally
    //   632	638	857	finally
    //   641	752	857	finally
    //   755	854	857	finally
    //   862	874	857	finally
    //   877	906	857	finally
    //   945	954	857	finally
    //   960	979	857	finally
    //   979	1017	857	finally
    //   1057	1071	857	finally
    //   1116	1122	857	finally
    //   1162	1167	857	finally
    //   1224	1255	857	finally
    //   1295	1314	857	finally
    //   1354	1374	857	finally
    //   1414	1434	857	finally
    //   1443	1449	857	finally
    //   1454	1459	857	finally
    //   1502	1513	857	finally
    //   1553	1564	857	finally
    //   1604	1614	857	finally
    //   1654	1664	857	finally
    //   1704	1714	857	finally
    //   1778	1788	857	finally
    //   1828	1858	857	finally
    //   1898	1919	857	finally
    //   1970	1980	857	finally
    //   2020	2030	857	finally
    //   2070	2080	857	finally
    //   2183	2193	857	finally
    //   2233	2243	857	finally
    //   2283	2293	857	finally
    //   2333	2340	857	finally
    //   2376	2411	857	finally
    //   2450	2470	857	finally
    //   2472	2498	857	finally
    //   2505	2846	857	finally
    //   2848	2907	857	finally
    //   2914	2946	857	finally
    //   2955	2989	857	finally
    //   3000	3007	857	finally
    //   960	979	1452	java/lang/InterruptedException
    //   1443	1449	1452	java/lang/InterruptedException
    //   1057	1071	2374	java/lang/Exception
    //   1116	1122	2374	java/lang/Exception
    //   1162	1167	2374	java/lang/Exception
    //   1224	1255	2374	java/lang/Exception
    //   1295	1314	2374	java/lang/Exception
    //   1354	1374	2374	java/lang/Exception
    //   1414	1434	2374	java/lang/Exception
    //   1502	1513	2374	java/lang/Exception
    //   1553	1564	2374	java/lang/Exception
    //   1604	1614	2374	java/lang/Exception
    //   1654	1664	2374	java/lang/Exception
    //   1704	1714	2374	java/lang/Exception
    //   1778	1788	2374	java/lang/Exception
    //   1828	1858	2374	java/lang/Exception
    //   1970	1980	2374	java/lang/Exception
    //   2020	2030	2374	java/lang/Exception
    //   2070	2080	2374	java/lang/Exception
    //   2183	2193	2374	java/lang/Exception
    //   2233	2243	2374	java/lang/Exception
    //   2283	2293	2374	java/lang/Exception
    //   2333	2340	2374	java/lang/Exception
  }
  
  public long a(File paramFile)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaLangReflectField == null)
        {
          this.jdField_a_of_type_JavaLangReflectField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
          if (!this.jdField_a_of_type_JavaLangReflectField.isAccessible()) {
            this.jdField_a_of_type_JavaLangReflectField.setAccessible(true);
          }
        }
        Object localObject = this.jdField_a_of_type_JavaLangReflectField.get(null);
        if (this.jdField_a_of_type_JavaLangReflectMethod == null) {
          this.jdField_a_of_type_JavaLangReflectMethod = localObject.getClass().getMethod("lstat", new Class[] { String.class });
        }
        paramFile = this.jdField_a_of_type_JavaLangReflectMethod.invoke(localObject, new Object[] { paramFile.getAbsolutePath() });
        if (this.jdField_b_of_type_JavaLangReflectField == null)
        {
          this.jdField_b_of_type_JavaLangReflectField = paramFile.getClass().getDeclaredField("st_atime");
          if (!this.jdField_b_of_type_JavaLangReflectField.isAccessible()) {
            this.jdField_b_of_type_JavaLangReflectField.setAccessible(true);
          }
        }
        l = this.jdField_b_of_type_JavaLangReflectField.getLong(paramFile);
        if (l != 0L) {
          continue;
        }
      }
      catch (ClassNotFoundException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        l = this.jdField_a_of_type_Long - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      catch (NoSuchMethodException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        l = this.jdField_a_of_type_Long - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      catch (IllegalAccessException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        l = this.jdField_a_of_type_Long - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      catch (InvocationTargetException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        l = this.jdField_a_of_type_Long - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      catch (NoSuchFieldException paramFile)
      {
        paramFile.printStackTrace();
        if (0L == 0L) {
          continue;
        }
        long l = this.jdField_a_of_type_Long - 0L;
        if (l < 0L) {
          continue;
        }
        return l;
      }
      finally
      {
        if (0L != 0L) {
          break label313;
        }
      }
      return 0L;
      l = this.jdField_a_of_type_Long - l;
      if (l >= 0L) {
        return l;
      }
    }
    for (;;)
    {
      throw paramFile;
      label313:
      if (this.jdField_a_of_type_Long - 0L >= 0L) {}
    }
  }
  
  public long a(ArrayList<String> paramArrayList)
  {
    long l2;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      l2 = 0L;
      return l2;
    }
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= paramArrayList.size()) {
        break;
      }
      String str = (String)paramArrayList.get(i);
      String[] arrayOfString = new File(str).list();
      l2 = l1;
      if (arrayOfString != null)
      {
        l2 = l1;
        if (arrayOfString.length > 0)
        {
          int k = arrayOfString.length;
          int j = 0;
          for (;;)
          {
            l2 = l1;
            if (j >= k) {
              break;
            }
            File localFile = new File(str, arrayOfString[j]);
            l2 = l1;
            if (localFile.isFile()) {
              l2 = l1 + localFile.length();
            }
            j += 1;
            l1 = l2;
          }
        }
      }
      i += 1;
      l1 = l2;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.storage.StorageReport
 * JD-Core Version:    0.7.0.1
 */