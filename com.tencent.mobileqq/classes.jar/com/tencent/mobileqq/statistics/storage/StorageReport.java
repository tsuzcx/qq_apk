package com.tencent.mobileqq.statistics.storage;

import ahta;
import ahtb;
import android.os.Bundle;
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
  private static final RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(StorageItem.class, 50);
  private static volatile StorageReport jdField_a_of_type_ComTencentMobileqqStatisticsStorageStorageReport;
  public static final String[] a;
  public static final String[] b;
  private long jdField_a_of_type_Long;
  private ahta jdField_a_of_type_Ahta = new ahta(null);
  private ahtb jdField_a_of_type_Ahtb = new ahtb(null);
  private String jdField_a_of_type_JavaLangString = "";
  private Field jdField_a_of_type_JavaLangReflectField;
  private Method jdField_a_of_type_JavaLangReflectMethod;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private boolean jdField_a_of_type_Boolean = true;
  private Field jdField_b_of_type_JavaLangReflectField;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList(40);
  private boolean jdField_b_of_type_Boolean;
  private ArrayList c = new ArrayList(7);
  private ArrayList d = new ArrayList(7);
  
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
        Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Ahta);
      }
      return localStorageItem.jdField_a_of_type_Long;
    }
    paramString1 = (StorageItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() >= 20) && (localStorageItem.jdField_b_of_type_Long > paramString1.jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(paramString1);
      this.jdField_a_of_type_JavaUtilArrayList.add(localStorageItem);
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Ahta);
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
  
  private String a(ArrayList paramArrayList)
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
    StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "qqStorageReport", true, 0L, 0L, localHashMap, null);
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
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: iload_2
    //   6: invokeinterface 336 2 0
    //   11: lconst_0
    //   12: lstore 54
    //   14: lconst_0
    //   15: lstore 12
    //   17: lconst_0
    //   18: lstore 10
    //   20: aload_0
    //   21: invokestatic 341	java/lang/System:currentTimeMillis	()J
    //   24: ldc2_w 342
    //   27: ldiv
    //   28: putfield 344	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   31: invokestatic 304	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   34: invokevirtual 348	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   37: checkcast 350	com/tencent/mobileqq/app/QQAppInterface
    //   40: astore 64
    //   42: aload 64
    //   44: ifnull +12 -> 56
    //   47: aload_0
    //   48: aload 64
    //   50: invokevirtual 353	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   53: putfield 95	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: aload_0
    //   57: new 118	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   64: aload_0
    //   65: getfield 95	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   68: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc_w 355
    //   74: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: getfield 344	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   81: invokestatic 278	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   84: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: putfield 95	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   93: invokestatic 304	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   96: ldc_w 357
    //   99: iconst_0
    //   100: invokevirtual 361	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   103: astore 64
    //   105: aload 64
    //   107: ldc_w 363
    //   110: lconst_0
    //   111: invokeinterface 369 4 0
    //   116: lstore 6
    //   118: aload_0
    //   119: getfield 91	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Boolean	Z
    //   122: ifeq +41 -> 163
    //   125: lload 6
    //   127: lconst_0
    //   128: lcmp
    //   129: ifle +34 -> 163
    //   132: aload_0
    //   133: getfield 344	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   136: lload 6
    //   138: lsub
    //   139: invokestatic 373	java/lang/Math:abs	(J)J
    //   142: ldc2_w 374
    //   145: lcmp
    //   146: ifge +17 -> 163
    //   149: aload_0
    //   150: iconst_0
    //   151: putfield 91	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Boolean	Z
    //   154: ldc 161
    //   156: iconst_2
    //   157: ldc_w 377
    //   160: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload_0
    //   164: getfield 77	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   167: invokevirtual 380	java/util/ArrayList:clear	()V
    //   170: aload_0
    //   171: getfield 75	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   174: invokevirtual 380	java/util/ArrayList:clear	()V
    //   177: aload_0
    //   178: getfield 97	com/tencent/mobileqq/statistics/storage/StorageReport:c	Ljava/util/ArrayList;
    //   181: invokevirtual 380	java/util/ArrayList:clear	()V
    //   184: aload_0
    //   185: getfield 99	com/tencent/mobileqq/statistics/storage/StorageReport:d	Ljava/util/ArrayList;
    //   188: invokevirtual 380	java/util/ArrayList:clear	()V
    //   191: iconst_0
    //   192: istore_2
    //   193: iload_2
    //   194: bipush 7
    //   196: if_icmpge +80 -> 276
    //   199: getstatic 31	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   202: ldc 25
    //   204: invokevirtual 140	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   207: checkcast 25	com/tencent/mobileqq/statistics/storage/StorageItem
    //   210: astore 65
    //   212: aload 65
    //   214: lconst_0
    //   215: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   218: aload 65
    //   220: lconst_0
    //   221: putfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   224: aload_0
    //   225: getfield 97	com/tencent/mobileqq/statistics/storage/StorageReport:c	Ljava/util/ArrayList;
    //   228: aload 65
    //   230: invokevirtual 185	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   233: pop
    //   234: getstatic 31	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   237: ldc 25
    //   239: invokevirtual 140	com/tencent/commonsdk/pool/RecyclablePool:obtain	(Ljava/lang/Class;)Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;
    //   242: checkcast 25	com/tencent/mobileqq/statistics/storage/StorageItem
    //   245: astore 65
    //   247: aload 65
    //   249: lconst_0
    //   250: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   253: aload 65
    //   255: lconst_0
    //   256: putfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   259: aload_0
    //   260: getfield 99	com/tencent/mobileqq/statistics/storage/StorageReport:d	Ljava/util/ArrayList;
    //   263: aload 65
    //   265: invokevirtual 185	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   268: pop
    //   269: iload_2
    //   270: iconst_1
    //   271: iadd
    //   272: istore_2
    //   273: goto -80 -> 193
    //   276: new 116	java/io/File
    //   279: dup
    //   280: getstatic 59	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   283: iconst_0
    //   284: aaload
    //   285: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   288: invokevirtual 223	java/io/File:list	()[Ljava/lang/String;
    //   291: astore 65
    //   293: lload 10
    //   295: lstore 6
    //   297: lload 12
    //   299: lstore 8
    //   301: aload 65
    //   303: ifnull +207 -> 510
    //   306: lload 10
    //   308: lstore 6
    //   310: lload 12
    //   312: lstore 8
    //   314: aload 65
    //   316: arraylength
    //   317: ifle +193 -> 510
    //   320: iconst_0
    //   321: istore_2
    //   322: lload 10
    //   324: lstore 6
    //   326: lload 12
    //   328: lstore 8
    //   330: iload_2
    //   331: aload 65
    //   333: arraylength
    //   334: if_icmpge +176 -> 510
    //   337: new 116	java/io/File
    //   340: dup
    //   341: new 118	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   348: getstatic 59	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   351: iconst_0
    //   352: aaload
    //   353: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: ldc 125
    //   358: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload 65
    //   363: iload_2
    //   364: aaload
    //   365: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   374: astore 66
    //   376: aload 66
    //   378: invokevirtual 136	java/io/File:isDirectory	()Z
    //   381: ifeq +102 -> 483
    //   384: new 25	com/tencent/mobileqq/statistics/storage/StorageItem
    //   387: dup
    //   388: invokespecial 381	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   391: astore 67
    //   393: aload 67
    //   395: iconst_0
    //   396: putfield 142	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   399: aload 67
    //   401: aload_0
    //   402: aload 66
    //   404: invokevirtual 153	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/io/File;)J
    //   407: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   410: aload 67
    //   412: aload 65
    //   414: iload_2
    //   415: aaload
    //   416: putfield 141	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   419: aload 67
    //   421: new 118	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   428: getstatic 59	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   431: iconst_0
    //   432: aaload
    //   433: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: ldc 125
    //   438: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload 65
    //   443: iload_2
    //   444: aaload
    //   445: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: putfield 150	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   454: aload 67
    //   456: lconst_0
    //   457: putfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   460: aload 67
    //   462: lconst_0
    //   463: putfield 291	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   466: aload_0
    //   467: getfield 77	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   470: aload 67
    //   472: invokevirtual 185	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   475: pop
    //   476: iload_2
    //   477: iconst_1
    //   478: iadd
    //   479: istore_2
    //   480: goto -158 -> 322
    //   483: lload 12
    //   485: aload_0
    //   486: getstatic 59	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   489: iconst_0
    //   490: aaload
    //   491: aload 65
    //   493: iload_2
    //   494: aaload
    //   495: invokespecial 231	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   498: ladd
    //   499: lstore 12
    //   501: lload 10
    //   503: lconst_1
    //   504: ladd
    //   505: lstore 10
    //   507: goto -31 -> 476
    //   510: iconst_1
    //   511: istore_2
    //   512: iload_2
    //   513: getstatic 59	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   516: arraylength
    //   517: if_icmpge +105 -> 622
    //   520: getstatic 59	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   523: iload_2
    //   524: aaload
    //   525: astore 65
    //   527: new 116	java/io/File
    //   530: dup
    //   531: aload 65
    //   533: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   536: astore 66
    //   538: aload 66
    //   540: invokevirtual 136	java/io/File:isDirectory	()Z
    //   543: ifeq +72 -> 615
    //   546: new 25	com/tencent/mobileqq/statistics/storage/StorageItem
    //   549: dup
    //   550: invokespecial 381	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   553: astore 67
    //   555: aload 67
    //   557: iconst_0
    //   558: putfield 142	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   561: aload 67
    //   563: aload_0
    //   564: aload 66
    //   566: invokevirtual 153	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/io/File;)J
    //   569: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   572: aload 67
    //   574: aload 65
    //   576: ldc 125
    //   578: invokevirtual 385	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   581: iconst_2
    //   582: aaload
    //   583: putfield 141	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   586: aload 67
    //   588: aload 65
    //   590: putfield 150	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   593: aload 67
    //   595: lconst_0
    //   596: putfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   599: aload 67
    //   601: lconst_0
    //   602: putfield 291	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   605: aload_0
    //   606: getfield 77	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   609: aload 67
    //   611: invokevirtual 185	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   614: pop
    //   615: iload_2
    //   616: iconst_1
    //   617: iadd
    //   618: istore_2
    //   619: goto -107 -> 512
    //   622: iconst_0
    //   623: istore_2
    //   624: iload_2
    //   625: getstatic 65	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   628: arraylength
    //   629: if_icmpge +282 -> 911
    //   632: getstatic 65	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   635: iload_2
    //   636: aaload
    //   637: astore 65
    //   639: new 116	java/io/File
    //   642: dup
    //   643: aload 65
    //   645: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   648: invokevirtual 223	java/io/File:list	()[Ljava/lang/String;
    //   651: astore 66
    //   653: aload 66
    //   655: ifnull +249 -> 904
    //   658: aload 66
    //   660: arraylength
    //   661: ifle +243 -> 904
    //   664: iconst_0
    //   665: istore 4
    //   667: iload 4
    //   669: aload 66
    //   671: arraylength
    //   672: if_icmpge +232 -> 904
    //   675: new 116	java/io/File
    //   678: dup
    //   679: new 118	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   686: aload 65
    //   688: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: ldc 125
    //   693: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: aload 66
    //   698: iload 4
    //   700: aaload
    //   701: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   710: astore 67
    //   712: ldc 63
    //   714: new 118	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   721: aload 65
    //   723: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: ldc 125
    //   728: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload 66
    //   733: iload 4
    //   735: aaload
    //   736: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokevirtual 388	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   745: ifeq +42 -> 787
    //   748: ldc 161
    //   750: iconst_2
    //   751: new 118	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   758: ldc_w 390
    //   761: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload 66
    //   766: iload 4
    //   768: aaload
    //   769: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   778: iload 4
    //   780: iconst_1
    //   781: iadd
    //   782: istore 4
    //   784: goto -117 -> 667
    //   787: aload 67
    //   789: invokevirtual 136	java/io/File:isDirectory	()Z
    //   792: ifeq +97 -> 889
    //   795: new 25	com/tencent/mobileqq/statistics/storage/StorageItem
    //   798: dup
    //   799: invokespecial 381	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   802: astore 68
    //   804: aload 68
    //   806: iconst_0
    //   807: putfield 142	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   810: aload 68
    //   812: aload_0
    //   813: aload 67
    //   815: invokevirtual 153	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/io/File;)J
    //   818: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   821: aload 68
    //   823: aload 66
    //   825: iload 4
    //   827: aaload
    //   828: putfield 141	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   831: aload 68
    //   833: new 118	java/lang/StringBuilder
    //   836: dup
    //   837: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   840: aload 65
    //   842: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: ldc 125
    //   847: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: aload 66
    //   852: iload 4
    //   854: aaload
    //   855: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   861: putfield 150	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   864: aload 68
    //   866: lconst_0
    //   867: putfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   870: aload 68
    //   872: lconst_0
    //   873: putfield 291	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   876: aload_0
    //   877: getfield 77	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   880: aload 68
    //   882: invokevirtual 185	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   885: pop
    //   886: goto -108 -> 778
    //   889: aload_0
    //   890: aload 65
    //   892: aload 66
    //   894: iload 4
    //   896: aaload
    //   897: invokespecial 231	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   900: pop2
    //   901: goto -123 -> 778
    //   904: iload_2
    //   905: iconst_1
    //   906: iadd
    //   907: istore_2
    //   908: goto -284 -> 624
    //   911: ldc 161
    //   913: iconst_2
    //   914: new 118	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   921: ldc_w 392
    //   924: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: aload_0
    //   928: getfield 344	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   931: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   934: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   937: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   940: iconst_0
    //   941: istore_2
    //   942: lconst_0
    //   943: lstore 20
    //   945: lconst_0
    //   946: lstore 22
    //   948: lconst_0
    //   949: lstore 10
    //   951: lconst_0
    //   952: lstore 14
    //   954: lconst_0
    //   955: lstore 18
    //   957: lconst_0
    //   958: lstore 32
    //   960: lconst_0
    //   961: lstore 12
    //   963: lload 8
    //   965: lstore 24
    //   967: lload 6
    //   969: lstore 16
    //   971: lload 18
    //   973: lstore 8
    //   975: lload 12
    //   977: lstore 6
    //   979: iload_2
    //   980: aload_0
    //   981: getfield 77	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   984: invokevirtual 181	java/util/ArrayList:size	()I
    //   987: if_icmpge +1491 -> 2478
    //   990: aload_0
    //   991: getfield 77	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   994: invokevirtual 181	java/util/ArrayList:size	()I
    //   997: sipush 500
    //   1000: if_icmplt +471 -> 1471
    //   1003: ldc2_w 393
    //   1006: invokestatic 400	java/lang/Thread:sleep	(J)V
    //   1009: aload_0
    //   1010: getfield 77	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1013: iload_2
    //   1014: invokevirtual 195	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1017: checkcast 25	com/tencent/mobileqq/statistics/storage/StorageItem
    //   1020: astore 65
    //   1022: aload 65
    //   1024: lconst_0
    //   1025: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1028: aload 65
    //   1030: lconst_0
    //   1031: putfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1034: aload 65
    //   1036: lconst_0
    //   1037: putfield 291	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1040: aload 65
    //   1042: getfield 150	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1045: astore 66
    //   1047: lload 6
    //   1049: lstore 62
    //   1051: lload 14
    //   1053: lstore 46
    //   1055: lload 20
    //   1057: lstore 42
    //   1059: lload 8
    //   1061: lstore 60
    //   1063: lload 22
    //   1065: lstore 38
    //   1067: lload 32
    //   1069: lstore 36
    //   1071: lload 10
    //   1073: lstore 58
    //   1075: lload 16
    //   1077: lstore 18
    //   1079: lload 24
    //   1081: lstore 12
    //   1083: lload 54
    //   1085: lstore 56
    //   1087: new 116	java/io/File
    //   1090: dup
    //   1091: aload 66
    //   1093: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   1096: invokevirtual 223	java/io/File:list	()[Ljava/lang/String;
    //   1099: astore 67
    //   1101: aload 67
    //   1103: ifnull +387 -> 1490
    //   1106: lload 6
    //   1108: lstore 62
    //   1110: lload 14
    //   1112: lstore 46
    //   1114: lload 20
    //   1116: lstore 42
    //   1118: lload 8
    //   1120: lstore 60
    //   1122: lload 22
    //   1124: lstore 38
    //   1126: lload 32
    //   1128: lstore 36
    //   1130: lload 10
    //   1132: lstore 58
    //   1134: lload 16
    //   1136: lstore 18
    //   1138: lload 24
    //   1140: lstore 12
    //   1142: lload 54
    //   1144: lstore 56
    //   1146: aload 67
    //   1148: arraylength
    //   1149: ifle +341 -> 1490
    //   1152: lload 6
    //   1154: lstore 62
    //   1156: lload 14
    //   1158: lstore 46
    //   1160: lload 20
    //   1162: lstore 42
    //   1164: lload 8
    //   1166: lstore 60
    //   1168: lload 22
    //   1170: lstore 38
    //   1172: lload 32
    //   1174: lstore 36
    //   1176: lload 10
    //   1178: lstore 58
    //   1180: lload 16
    //   1182: lstore 18
    //   1184: lload 24
    //   1186: lstore 12
    //   1188: lload 54
    //   1190: lstore 56
    //   1192: aload 67
    //   1194: arraylength
    //   1195: istore 5
    //   1197: iconst_0
    //   1198: istore 4
    //   1200: iload 4
    //   1202: iload 5
    //   1204: if_icmpge +286 -> 1490
    //   1207: aload 67
    //   1209: iload 4
    //   1211: aaload
    //   1212: astore 68
    //   1214: lload 6
    //   1216: lstore 62
    //   1218: lload 14
    //   1220: lstore 46
    //   1222: lload 20
    //   1224: lstore 42
    //   1226: lload 8
    //   1228: lstore 60
    //   1230: lload 22
    //   1232: lstore 38
    //   1234: lload 32
    //   1236: lstore 36
    //   1238: lload 10
    //   1240: lstore 58
    //   1242: lload 16
    //   1244: lstore 18
    //   1246: lload 24
    //   1248: lstore 12
    //   1250: lload 54
    //   1252: lstore 56
    //   1254: aload_0
    //   1255: new 118	java/lang/StringBuilder
    //   1258: dup
    //   1259: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   1262: aload 66
    //   1264: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: ldc 125
    //   1269: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: aload 68
    //   1274: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokespecial 402	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1283: astore 68
    //   1285: lload 6
    //   1287: lstore 62
    //   1289: lload 14
    //   1291: lstore 46
    //   1293: lload 20
    //   1295: lstore 42
    //   1297: lload 8
    //   1299: lstore 60
    //   1301: lload 22
    //   1303: lstore 38
    //   1305: lload 32
    //   1307: lstore 36
    //   1309: lload 10
    //   1311: lstore 58
    //   1313: lload 16
    //   1315: lstore 18
    //   1317: lload 24
    //   1319: lstore 12
    //   1321: lload 54
    //   1323: lstore 56
    //   1325: aload 65
    //   1327: aload 65
    //   1329: getfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1332: aload 68
    //   1334: ldc 239
    //   1336: lconst_0
    //   1337: invokevirtual 403	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1340: ladd
    //   1341: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1344: lload 6
    //   1346: lstore 62
    //   1348: lload 14
    //   1350: lstore 46
    //   1352: lload 20
    //   1354: lstore 42
    //   1356: lload 8
    //   1358: lstore 60
    //   1360: lload 22
    //   1362: lstore 38
    //   1364: lload 32
    //   1366: lstore 36
    //   1368: lload 10
    //   1370: lstore 58
    //   1372: lload 16
    //   1374: lstore 18
    //   1376: lload 24
    //   1378: lstore 12
    //   1380: lload 54
    //   1382: lstore 56
    //   1384: aload 65
    //   1386: aload 65
    //   1388: getfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1391: aload 68
    //   1393: ldc 245
    //   1395: lconst_0
    //   1396: invokevirtual 403	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1399: ladd
    //   1400: putfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1403: lload 6
    //   1405: lstore 62
    //   1407: lload 14
    //   1409: lstore 46
    //   1411: lload 20
    //   1413: lstore 42
    //   1415: lload 8
    //   1417: lstore 60
    //   1419: lload 22
    //   1421: lstore 38
    //   1423: lload 32
    //   1425: lstore 36
    //   1427: lload 10
    //   1429: lstore 58
    //   1431: lload 16
    //   1433: lstore 18
    //   1435: lload 24
    //   1437: lstore 12
    //   1439: lload 54
    //   1441: lstore 56
    //   1443: aload 65
    //   1445: aload 65
    //   1447: getfield 291	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1450: aload 68
    //   1452: ldc 247
    //   1454: lconst_0
    //   1455: invokevirtual 403	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1458: ladd
    //   1459: putfield 291	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1462: iload 4
    //   1464: iconst_1
    //   1465: iadd
    //   1466: istore 4
    //   1468: goto -268 -> 1200
    //   1471: ldc2_w 404
    //   1474: invokestatic 400	java/lang/Thread:sleep	(J)V
    //   1477: goto -468 -> 1009
    //   1480: astore 65
    //   1482: aload 65
    //   1484: invokevirtual 408	java/lang/InterruptedException:printStackTrace	()V
    //   1487: goto -478 -> 1009
    //   1490: lload 6
    //   1492: lstore 62
    //   1494: lload 14
    //   1496: lstore 46
    //   1498: lload 20
    //   1500: lstore 42
    //   1502: lload 8
    //   1504: lstore 60
    //   1506: lload 22
    //   1508: lstore 38
    //   1510: lload 32
    //   1512: lstore 36
    //   1514: lload 10
    //   1516: lstore 58
    //   1518: lload 16
    //   1520: lstore 18
    //   1522: lload 24
    //   1524: lstore 12
    //   1526: lload 54
    //   1528: lstore 56
    //   1530: aload 66
    //   1532: ldc_w 410
    //   1535: invokevirtual 319	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1538: ifeq +597 -> 2135
    //   1541: lload 6
    //   1543: lstore 62
    //   1545: lload 14
    //   1547: lstore 46
    //   1549: lload 20
    //   1551: lstore 42
    //   1553: lload 8
    //   1555: lstore 60
    //   1557: lload 22
    //   1559: lstore 38
    //   1561: lload 32
    //   1563: lstore 36
    //   1565: lload 10
    //   1567: lstore 58
    //   1569: lload 16
    //   1571: lstore 18
    //   1573: lload 24
    //   1575: lstore 12
    //   1577: lload 54
    //   1579: lstore 56
    //   1581: aload 66
    //   1583: ldc_w 412
    //   1586: invokevirtual 319	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1589: ifeq +369 -> 1958
    //   1592: lload 6
    //   1594: lstore 62
    //   1596: lload 14
    //   1598: lstore 46
    //   1600: lload 20
    //   1602: lstore 42
    //   1604: lload 8
    //   1606: lstore 60
    //   1608: lload 22
    //   1610: lstore 38
    //   1612: lload 32
    //   1614: lstore 36
    //   1616: lload 10
    //   1618: lstore 58
    //   1620: lload 16
    //   1622: lstore 18
    //   1624: lload 24
    //   1626: lstore 12
    //   1628: lload 54
    //   1630: lstore 56
    //   1632: lload 20
    //   1634: aload 65
    //   1636: getfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1639: ladd
    //   1640: lstore 30
    //   1642: lload 6
    //   1644: lstore 62
    //   1646: lload 14
    //   1648: lstore 46
    //   1650: lload 30
    //   1652: lstore 42
    //   1654: lload 8
    //   1656: lstore 60
    //   1658: lload 22
    //   1660: lstore 38
    //   1662: lload 32
    //   1664: lstore 36
    //   1666: lload 10
    //   1668: lstore 58
    //   1670: lload 16
    //   1672: lstore 18
    //   1674: lload 24
    //   1676: lstore 12
    //   1678: lload 54
    //   1680: lstore 56
    //   1682: lload 14
    //   1684: aload 65
    //   1686: getfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   1689: ladd
    //   1690: lstore 28
    //   1692: lload 6
    //   1694: lstore 62
    //   1696: lload 28
    //   1698: lstore 46
    //   1700: lload 30
    //   1702: lstore 42
    //   1704: lload 8
    //   1706: lstore 60
    //   1708: lload 22
    //   1710: lstore 38
    //   1712: lload 32
    //   1714: lstore 36
    //   1716: lload 10
    //   1718: lstore 58
    //   1720: lload 16
    //   1722: lstore 18
    //   1724: lload 24
    //   1726: lstore 12
    //   1728: lload 54
    //   1730: lstore 56
    //   1732: lload 6
    //   1734: aload 65
    //   1736: getfield 291	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   1739: ladd
    //   1740: lstore 26
    //   1742: lload 24
    //   1744: lstore 52
    //   1746: lload 16
    //   1748: lstore 50
    //   1750: lload 10
    //   1752: lstore 48
    //   1754: lload 32
    //   1756: lstore 44
    //   1758: lload 22
    //   1760: lstore 40
    //   1762: lload 8
    //   1764: lstore 34
    //   1766: lload 26
    //   1768: lstore 62
    //   1770: lload 28
    //   1772: lstore 46
    //   1774: lload 30
    //   1776: lstore 42
    //   1778: lload 34
    //   1780: lstore 60
    //   1782: lload 40
    //   1784: lstore 38
    //   1786: lload 44
    //   1788: lstore 36
    //   1790: lload 48
    //   1792: lstore 58
    //   1794: lload 50
    //   1796: lstore 18
    //   1798: lload 52
    //   1800: lstore 12
    //   1802: lload 54
    //   1804: lstore 56
    //   1806: lload 54
    //   1808: aload 65
    //   1810: getfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   1813: ladd
    //   1814: lstore 54
    //   1816: lload 26
    //   1818: lstore 62
    //   1820: lload 28
    //   1822: lstore 46
    //   1824: lload 30
    //   1826: lstore 42
    //   1828: lload 34
    //   1830: lstore 60
    //   1832: lload 40
    //   1834: lstore 38
    //   1836: lload 44
    //   1838: lstore 36
    //   1840: lload 48
    //   1842: lstore 58
    //   1844: lload 50
    //   1846: lstore 18
    //   1848: lload 52
    //   1850: lstore 12
    //   1852: lload 54
    //   1854: lstore 56
    //   1856: ldc 161
    //   1858: iconst_1
    //   1859: new 118	java/lang/StringBuilder
    //   1862: dup
    //   1863: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   1866: ldc_w 414
    //   1869: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1872: aload 65
    //   1874: invokevirtual 164	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   1877: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1883: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1886: lload 52
    //   1888: lstore 12
    //   1890: lload 50
    //   1892: lstore 16
    //   1894: lload 48
    //   1896: lstore 10
    //   1898: lload 44
    //   1900: lstore 32
    //   1902: lload 40
    //   1904: lstore 22
    //   1906: lload 34
    //   1908: lstore 8
    //   1910: lload 30
    //   1912: lstore 20
    //   1914: lload 28
    //   1916: lstore 14
    //   1918: lload 26
    //   1920: lstore 6
    //   1922: aload_1
    //   1923: ifnull +24 -> 1947
    //   1926: aload_1
    //   1927: iload_2
    //   1928: iconst_1
    //   1929: iadd
    //   1930: iload_3
    //   1931: iconst_2
    //   1932: isub
    //   1933: imul
    //   1934: aload_0
    //   1935: getfield 77	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1938: invokevirtual 181	java/util/ArrayList:size	()I
    //   1941: idiv
    //   1942: invokeinterface 336 2 0
    //   1947: iload_2
    //   1948: iconst_1
    //   1949: iadd
    //   1950: istore_2
    //   1951: lload 12
    //   1953: lstore 24
    //   1955: goto -976 -> 979
    //   1958: lload 6
    //   1960: lstore 62
    //   1962: lload 14
    //   1964: lstore 46
    //   1966: lload 20
    //   1968: lstore 42
    //   1970: lload 8
    //   1972: lstore 60
    //   1974: lload 22
    //   1976: lstore 38
    //   1978: lload 32
    //   1980: lstore 36
    //   1982: lload 10
    //   1984: lstore 58
    //   1986: lload 16
    //   1988: lstore 18
    //   1990: lload 24
    //   1992: lstore 12
    //   1994: lload 54
    //   1996: lstore 56
    //   1998: lload 24
    //   2000: aload 65
    //   2002: getfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   2005: ladd
    //   2006: lstore 52
    //   2008: lload 6
    //   2010: lstore 62
    //   2012: lload 14
    //   2014: lstore 46
    //   2016: lload 20
    //   2018: lstore 42
    //   2020: lload 8
    //   2022: lstore 60
    //   2024: lload 22
    //   2026: lstore 38
    //   2028: lload 32
    //   2030: lstore 36
    //   2032: lload 10
    //   2034: lstore 58
    //   2036: lload 16
    //   2038: lstore 18
    //   2040: lload 52
    //   2042: lstore 12
    //   2044: lload 54
    //   2046: lstore 56
    //   2048: lload 16
    //   2050: aload 65
    //   2052: getfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2055: ladd
    //   2056: lstore 50
    //   2058: lload 6
    //   2060: lstore 62
    //   2062: lload 14
    //   2064: lstore 46
    //   2066: lload 20
    //   2068: lstore 42
    //   2070: lload 8
    //   2072: lstore 60
    //   2074: lload 22
    //   2076: lstore 38
    //   2078: lload 32
    //   2080: lstore 36
    //   2082: lload 10
    //   2084: lstore 58
    //   2086: lload 50
    //   2088: lstore 18
    //   2090: lload 52
    //   2092: lstore 12
    //   2094: lload 54
    //   2096: lstore 56
    //   2098: lload 10
    //   2100: aload 65
    //   2102: getfield 291	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2105: ladd
    //   2106: lstore 48
    //   2108: lload 6
    //   2110: lstore 26
    //   2112: lload 14
    //   2114: lstore 28
    //   2116: lload 20
    //   2118: lstore 30
    //   2120: lload 8
    //   2122: lstore 34
    //   2124: lload 22
    //   2126: lstore 40
    //   2128: lload 32
    //   2130: lstore 44
    //   2132: goto -366 -> 1766
    //   2135: lload 6
    //   2137: lstore 26
    //   2139: lload 14
    //   2141: lstore 28
    //   2143: lload 20
    //   2145: lstore 30
    //   2147: lload 8
    //   2149: lstore 34
    //   2151: lload 22
    //   2153: lstore 40
    //   2155: lload 32
    //   2157: lstore 44
    //   2159: lload 10
    //   2161: lstore 48
    //   2163: lload 16
    //   2165: lstore 50
    //   2167: lload 24
    //   2169: lstore 52
    //   2171: lload 6
    //   2173: lstore 62
    //   2175: lload 14
    //   2177: lstore 46
    //   2179: lload 20
    //   2181: lstore 42
    //   2183: lload 8
    //   2185: lstore 60
    //   2187: lload 22
    //   2189: lstore 38
    //   2191: lload 32
    //   2193: lstore 36
    //   2195: lload 10
    //   2197: lstore 58
    //   2199: lload 16
    //   2201: lstore 18
    //   2203: lload 24
    //   2205: lstore 12
    //   2207: lload 54
    //   2209: lstore 56
    //   2211: aload 66
    //   2213: ldc 61
    //   2215: invokevirtual 319	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2218: ifeq -452 -> 1766
    //   2221: lload 6
    //   2223: lstore 62
    //   2225: lload 14
    //   2227: lstore 46
    //   2229: lload 20
    //   2231: lstore 42
    //   2233: lload 8
    //   2235: lstore 60
    //   2237: lload 22
    //   2239: lstore 38
    //   2241: lload 32
    //   2243: lstore 36
    //   2245: lload 10
    //   2247: lstore 58
    //   2249: lload 16
    //   2251: lstore 18
    //   2253: lload 24
    //   2255: lstore 12
    //   2257: lload 54
    //   2259: lstore 56
    //   2261: lload 32
    //   2263: aload 65
    //   2265: getfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   2268: ladd
    //   2269: lstore 44
    //   2271: lload 6
    //   2273: lstore 62
    //   2275: lload 14
    //   2277: lstore 46
    //   2279: lload 20
    //   2281: lstore 42
    //   2283: lload 8
    //   2285: lstore 60
    //   2287: lload 22
    //   2289: lstore 38
    //   2291: lload 44
    //   2293: lstore 36
    //   2295: lload 10
    //   2297: lstore 58
    //   2299: lload 16
    //   2301: lstore 18
    //   2303: lload 24
    //   2305: lstore 12
    //   2307: lload 54
    //   2309: lstore 56
    //   2311: lload 22
    //   2313: aload 65
    //   2315: getfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2318: ladd
    //   2319: lstore 40
    //   2321: lload 6
    //   2323: lstore 62
    //   2325: lload 14
    //   2327: lstore 46
    //   2329: lload 20
    //   2331: lstore 42
    //   2333: lload 8
    //   2335: lstore 60
    //   2337: lload 40
    //   2339: lstore 38
    //   2341: lload 44
    //   2343: lstore 36
    //   2345: lload 10
    //   2347: lstore 58
    //   2349: lload 16
    //   2351: lstore 18
    //   2353: lload 24
    //   2355: lstore 12
    //   2357: lload 54
    //   2359: lstore 56
    //   2361: aload 65
    //   2363: getfield 291	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2366: lstore 22
    //   2368: lload 8
    //   2370: lload 22
    //   2372: ladd
    //   2373: lstore 34
    //   2375: lload 6
    //   2377: lstore 26
    //   2379: lload 14
    //   2381: lstore 28
    //   2383: lload 20
    //   2385: lstore 30
    //   2387: lload 10
    //   2389: lstore 48
    //   2391: lload 16
    //   2393: lstore 50
    //   2395: lload 24
    //   2397: lstore 52
    //   2399: goto -633 -> 1766
    //   2402: astore 65
    //   2404: aload 65
    //   2406: invokevirtual 415	java/lang/Exception:printStackTrace	()V
    //   2409: ldc 161
    //   2411: iconst_1
    //   2412: new 118	java/lang/StringBuilder
    //   2415: dup
    //   2416: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   2419: ldc_w 417
    //   2422: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2425: aload 65
    //   2427: invokevirtual 421	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   2430: invokevirtual 424	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2433: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2436: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2439: lload 62
    //   2441: lstore 6
    //   2443: lload 46
    //   2445: lstore 14
    //   2447: lload 42
    //   2449: lstore 20
    //   2451: lload 60
    //   2453: lstore 8
    //   2455: lload 38
    //   2457: lstore 22
    //   2459: lload 36
    //   2461: lstore 32
    //   2463: lload 58
    //   2465: lstore 10
    //   2467: lload 18
    //   2469: lstore 16
    //   2471: lload 56
    //   2473: lstore 54
    //   2475: goto -553 -> 1922
    //   2478: aload_0
    //   2479: getfield 77	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2482: aload_0
    //   2483: getfield 89	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Ahtb	Lahtb;
    //   2486: invokestatic 191	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   2489: ldc 161
    //   2491: iconst_1
    //   2492: ldc_w 426
    //   2495: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2498: iconst_0
    //   2499: istore_2
    //   2500: iload_2
    //   2501: aload_0
    //   2502: getfield 77	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2505: invokevirtual 181	java/util/ArrayList:size	()I
    //   2508: if_icmpge +25 -> 2533
    //   2511: aload_0
    //   2512: aload_0
    //   2513: getfield 77	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2516: iload_2
    //   2517: invokevirtual 195	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2520: checkcast 25	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2523: invokespecial 174	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2526: iload_2
    //   2527: iconst_1
    //   2528: iadd
    //   2529: istore_2
    //   2530: goto -30 -> 2500
    //   2533: ldc 161
    //   2535: iconst_1
    //   2536: new 118	java/lang/StringBuilder
    //   2539: dup
    //   2540: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   2543: ldc_w 428
    //   2546: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2549: lload 54
    //   2551: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2554: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2557: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2560: new 25	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2563: dup
    //   2564: invokespecial 381	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   2567: astore 65
    //   2569: aload 65
    //   2571: iconst_0
    //   2572: putfield 142	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   2575: aload 65
    //   2577: ldc_w 430
    //   2580: putfield 150	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2583: aload 65
    //   2585: lload 16
    //   2587: lload 22
    //   2589: ladd
    //   2590: lload 14
    //   2592: ladd
    //   2593: putfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2596: aload 65
    //   2598: lload 10
    //   2600: lload 8
    //   2602: ladd
    //   2603: lload 6
    //   2605: ladd
    //   2606: putfield 291	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2609: aload 65
    //   2611: lconst_0
    //   2612: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   2615: aload 65
    //   2617: lload 54
    //   2619: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   2622: aload_0
    //   2623: aload 65
    //   2625: invokespecial 174	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2628: ldc 161
    //   2630: iconst_1
    //   2631: new 118	java/lang/StringBuilder
    //   2634: dup
    //   2635: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   2638: ldc_w 432
    //   2641: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2644: aload 65
    //   2646: invokevirtual 164	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   2649: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2652: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2655: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2658: new 25	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2661: dup
    //   2662: invokespecial 381	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   2665: astore 65
    //   2667: aload 65
    //   2669: iconst_0
    //   2670: putfield 142	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   2673: aload 65
    //   2675: ldc_w 434
    //   2678: putfield 150	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2681: aload 65
    //   2683: aload_0
    //   2684: aload_0
    //   2685: getfield 97	com/tencent/mobileqq/statistics/storage/StorageReport:c	Ljava/util/ArrayList;
    //   2688: invokespecial 436	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   2691: putfield 141	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2694: aload 65
    //   2696: lload 14
    //   2698: lload 16
    //   2700: ladd
    //   2701: putfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2704: aload 65
    //   2706: lload 6
    //   2708: lload 10
    //   2710: ladd
    //   2711: putfield 291	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2714: aload 65
    //   2716: lconst_0
    //   2717: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   2720: aload 65
    //   2722: lload 24
    //   2724: lload 20
    //   2726: ladd
    //   2727: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   2730: aload_0
    //   2731: aload 65
    //   2733: invokespecial 174	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2736: ldc 161
    //   2738: iconst_1
    //   2739: new 118	java/lang/StringBuilder
    //   2742: dup
    //   2743: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   2746: ldc_w 438
    //   2749: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2752: aload 65
    //   2754: invokevirtual 164	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   2757: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2760: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2763: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2766: new 25	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2769: dup
    //   2770: invokespecial 381	com/tencent/mobileqq/statistics/storage/StorageItem:<init>	()V
    //   2773: astore 65
    //   2775: aload 65
    //   2777: iconst_0
    //   2778: putfield 142	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Boolean	Z
    //   2781: aload 65
    //   2783: ldc_w 440
    //   2786: putfield 150	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2789: aload 65
    //   2791: aload_0
    //   2792: aload_0
    //   2793: getfield 99	com/tencent/mobileqq/statistics/storage/StorageReport:d	Ljava/util/ArrayList;
    //   2796: invokespecial 436	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   2799: putfield 141	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2802: aload 65
    //   2804: lload 22
    //   2806: putfield 157	com/tencent/mobileqq/statistics/storage/StorageItem:c	J
    //   2809: aload 65
    //   2811: lload 8
    //   2813: putfield 291	com/tencent/mobileqq/statistics/storage/StorageItem:d	J
    //   2816: aload 65
    //   2818: lconst_0
    //   2819: putfield 155	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_b_of_type_Long	J
    //   2822: aload 65
    //   2824: lload 32
    //   2826: putfield 148	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_Long	J
    //   2829: aload_0
    //   2830: aload 65
    //   2832: invokespecial 174	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2835: ldc 161
    //   2837: iconst_1
    //   2838: new 118	java/lang/StringBuilder
    //   2841: dup
    //   2842: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   2845: ldc_w 442
    //   2848: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2851: aload 65
    //   2853: invokevirtual 164	com/tencent/mobileqq/statistics/storage/StorageItem:toString	()Ljava/lang/String;
    //   2856: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2859: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2862: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2865: ldc 161
    //   2867: iconst_1
    //   2868: ldc_w 444
    //   2871: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2874: iconst_0
    //   2875: istore_2
    //   2876: iload_2
    //   2877: aload_0
    //   2878: getfield 75	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2881: invokevirtual 181	java/util/ArrayList:size	()I
    //   2884: if_icmpge +58 -> 2942
    //   2887: aload_0
    //   2888: getfield 75	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2891: iload_2
    //   2892: invokevirtual 195	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2895: checkcast 25	com/tencent/mobileqq/statistics/storage/StorageItem
    //   2898: astore 65
    //   2900: aload 65
    //   2902: new 118	java/lang/StringBuilder
    //   2905: dup
    //   2906: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   2909: ldc_w 446
    //   2912: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2915: aload 65
    //   2917: getfield 141	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2920: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2923: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2926: putfield 141	com/tencent/mobileqq/statistics/storage/StorageItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2929: aload_0
    //   2930: aload 65
    //   2932: invokespecial 174	com/tencent/mobileqq/statistics/storage/StorageReport:a	(Lcom/tencent/mobileqq/statistics/storage/StorageItem;)V
    //   2935: iload_2
    //   2936: iconst_1
    //   2937: iadd
    //   2938: istore_2
    //   2939: goto -63 -> 2876
    //   2942: aload_0
    //   2943: getfield 91	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Boolean	Z
    //   2946: ifeq +28 -> 2974
    //   2949: aload 64
    //   2951: invokeinterface 450 1 0
    //   2956: ldc_w 363
    //   2959: aload_0
    //   2960: getfield 344	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_Long	J
    //   2963: invokeinterface 455 4 0
    //   2968: invokeinterface 458 1 0
    //   2973: pop
    //   2974: iconst_0
    //   2975: istore_2
    //   2976: iload_2
    //   2977: bipush 7
    //   2979: if_icmpge +44 -> 3023
    //   2982: getstatic 31	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   2985: aload_0
    //   2986: getfield 97	com/tencent/mobileqq/statistics/storage/StorageReport:c	Ljava/util/ArrayList;
    //   2989: iload_2
    //   2990: invokevirtual 195	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2993: checkcast 460	com/tencent/commonsdk/pool/RecyclablePool$Recyclable
    //   2996: invokevirtual 202	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   2999: getstatic 31	com/tencent/mobileqq/statistics/storage/StorageReport:jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool	Lcom/tencent/commonsdk/pool/RecyclablePool;
    //   3002: aload_0
    //   3003: getfield 99	com/tencent/mobileqq/statistics/storage/StorageReport:d	Ljava/util/ArrayList;
    //   3006: iload_2
    //   3007: invokevirtual 195	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3010: checkcast 460	com/tencent/commonsdk/pool/RecyclablePool$Recyclable
    //   3013: invokevirtual 202	com/tencent/commonsdk/pool/RecyclablePool:recycle	(Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;)V
    //   3016: iload_2
    //   3017: iconst_1
    //   3018: iadd
    //   3019: istore_2
    //   3020: goto -44 -> 2976
    //   3023: aload_1
    //   3024: ifnull +10 -> 3034
    //   3027: aload_1
    //   3028: iload_3
    //   3029: invokeinterface 336 2 0
    //   3034: lload 24
    //   3036: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3037	0	this	StorageReport
    //   0	3037	1	paramIProgressCallback	com.tencent.mobileqq.activity.QQSettingCleanActivity.IProgressCallback
    //   0	3037	2	paramInt1	int
    //   0	3037	3	paramInt2	int
    //   665	802	4	i	int
    //   1195	10	5	j	int
    //   116	2591	6	l1	long
    //   299	2513	8	l2	long
    //   18	2691	10	l3	long
    //   15	2341	12	l4	long
    //   952	1745	14	l5	long
    //   969	1730	16	l6	long
    //   955	1513	18	l7	long
    //   943	1782	20	l8	long
    //   946	1859	22	l9	long
    //   965	2070	24	l10	long
    //   1740	638	26	l11	long
    //   1690	692	28	l12	long
    //   1640	746	30	l13	long
    //   958	1867	32	l14	long
    //   1764	610	34	l15	long
    //   1069	1391	36	l16	long
    //   1065	1391	38	l17	long
    //   1760	578	40	l18	long
    //   1057	1391	42	l19	long
    //   1756	586	44	l20	long
    //   1053	1391	46	l21	long
    //   1752	638	48	l22	long
    //   1748	646	50	l23	long
    //   1744	654	52	l24	long
    //   12	2606	54	l25	long
    //   1085	1387	56	l26	long
    //   1073	1391	58	l27	long
    //   1061	1391	60	l28	long
    //   1049	1391	62	l29	long
    //   40	2910	64	localObject1	Object
    //   210	1236	65	localObject2	Object
    //   1480	882	65	localInterruptedException	java.lang.InterruptedException
    //   2402	24	65	localException	java.lang.Exception
    //   2567	364	65	localStorageItem	StorageItem
    //   374	1838	66	localObject3	Object
    //   391	817	67	localObject4	Object
    //   802	649	68	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   990	1009	1480	java/lang/InterruptedException
    //   1471	1477	1480	java/lang/InterruptedException
    //   1087	1101	2402	java/lang/Exception
    //   1146	1152	2402	java/lang/Exception
    //   1192	1197	2402	java/lang/Exception
    //   1254	1285	2402	java/lang/Exception
    //   1325	1344	2402	java/lang/Exception
    //   1384	1403	2402	java/lang/Exception
    //   1443	1462	2402	java/lang/Exception
    //   1530	1541	2402	java/lang/Exception
    //   1581	1592	2402	java/lang/Exception
    //   1632	1642	2402	java/lang/Exception
    //   1682	1692	2402	java/lang/Exception
    //   1732	1742	2402	java/lang/Exception
    //   1806	1816	2402	java/lang/Exception
    //   1856	1886	2402	java/lang/Exception
    //   1998	2008	2402	java/lang/Exception
    //   2048	2058	2402	java/lang/Exception
    //   2098	2108	2402	java/lang/Exception
    //   2211	2221	2402	java/lang/Exception
    //   2261	2271	2402	java/lang/Exception
    //   2311	2321	2402	java/lang/Exception
    //   2361	2368	2402	java/lang/Exception
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
  
  public long a(ArrayList paramArrayList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.storage.StorageReport
 * JD-Core Version:    0.7.0.1
 */