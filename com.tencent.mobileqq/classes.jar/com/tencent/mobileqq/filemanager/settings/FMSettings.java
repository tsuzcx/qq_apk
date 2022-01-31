package com.tencent.mobileqq.filemanager.settings;

import adgg;
import adgh;
import adgj;
import adgq;
import adgr;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StatFs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FMSettings
{
  public int a;
  public long a;
  public QQCustomDialog a;
  public String a;
  public Map a;
  boolean a;
  public long b;
  public String b;
  public boolean b;
  long c = System.currentTimeMillis() / 1000L;
  long d = 0L;
  
  private FMSettings()
  {
    this.jdField_a_of_type_JavaUtilMap = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    a(2, "new FMSetting!");
    a();
  }
  
  public static FMSettings a()
  {
    return adgq.a();
  }
  
  private String a(String paramString)
  {
    paramString = (paramString + "/Tencent/QQfile_recv/").replace("//", "/");
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramString;
  }
  
  public static void a(int paramInt, String paramString) {}
  
  /* Error */
  private void a(File paramFile1, File paramFile2, FMSettingInterface.MoveFileCallback paramMoveFileCallback)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aload_1
    //   10: invokevirtual 99	java/io/File:exists	()Z
    //   13: ifeq +12 -> 25
    //   16: aload_1
    //   17: invokevirtual 122	java/io/File:length	()J
    //   20: lconst_0
    //   21: lcmp
    //   22: ifne +54 -> 76
    //   25: iconst_1
    //   26: ldc 124
    //   28: invokestatic 53	com/tencent/mobileqq/filemanager/settings/FMSettings:a	(ILjava/lang/String;)V
    //   31: iconst_0
    //   32: ifeq +11 -> 43
    //   35: new 126	java/lang/NullPointerException
    //   38: dup
    //   39: invokespecial 127	java/lang/NullPointerException:<init>	()V
    //   42: athrow
    //   43: iconst_0
    //   44: ifeq +11 -> 55
    //   47: new 126	java/lang/NullPointerException
    //   50: dup
    //   51: invokespecial 127	java/lang/NullPointerException:<init>	()V
    //   54: athrow
    //   55: aload_3
    //   56: aload_1
    //   57: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: aload_2
    //   61: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: invokeinterface 135 3 0
    //   69: aload_3
    //   70: invokeinterface 136 1 0
    //   75: return
    //   76: aload_2
    //   77: invokevirtual 99	java/io/File:exists	()Z
    //   80: ifeq +8 -> 88
    //   83: aload_2
    //   84: invokevirtual 139	java/io/File:delete	()Z
    //   87: pop
    //   88: new 141	java/io/FileOutputStream
    //   91: dup
    //   92: aload_2
    //   93: invokespecial 144	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   96: astore 5
    //   98: new 146	java/io/FileInputStream
    //   101: dup
    //   102: aload_1
    //   103: invokespecial 147	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   106: astore 6
    //   108: invokestatic 153	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   111: sipush 4096
    //   114: invokevirtual 157	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   117: astore 7
    //   119: aload 6
    //   121: aload 7
    //   123: invokevirtual 161	java/io/FileInputStream:read	([B)I
    //   126: istore 4
    //   128: iload 4
    //   130: iconst_m1
    //   131: if_icmpeq +69 -> 200
    //   134: aload_0
    //   135: getfield 28	com/tencent/mobileqq/filemanager/settings/FMSettings:jdField_a_of_type_Boolean	Z
    //   138: ifne +62 -> 200
    //   141: aload 5
    //   143: aload 7
    //   145: iconst_0
    //   146: iload 4
    //   148: invokevirtual 165	java/io/FileOutputStream:write	([BII)V
    //   151: aload 5
    //   153: invokevirtual 168	java/io/FileOutputStream:flush	()V
    //   156: aload_3
    //   157: iload 4
    //   159: i2l
    //   160: lconst_0
    //   161: invokeinterface 171 5 0
    //   166: goto -47 -> 119
    //   169: astore_1
    //   170: aload 6
    //   172: astore_2
    //   173: aload 5
    //   175: astore_1
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 175	java/io/FileInputStream:close	()V
    //   192: aload_3
    //   193: iconst_m1
    //   194: invokeinterface 178 2 0
    //   199: return
    //   200: invokestatic 153	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   203: aload 7
    //   205: invokevirtual 182	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   208: aload 5
    //   210: ifnull +8 -> 218
    //   213: aload 5
    //   215: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   218: aload 6
    //   220: ifnull +8 -> 228
    //   223: aload 6
    //   225: invokevirtual 175	java/io/FileInputStream:close	()V
    //   228: aload_3
    //   229: aload_1
    //   230: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   233: aload_2
    //   234: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   237: invokeinterface 135 3 0
    //   242: aload_3
    //   243: invokeinterface 136 1 0
    //   248: return
    //   249: astore_1
    //   250: aconst_null
    //   251: astore 5
    //   253: aload 9
    //   255: astore_1
    //   256: aload 5
    //   258: ifnull +8 -> 266
    //   261: aload 5
    //   263: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   266: aload_1
    //   267: ifnull +7 -> 274
    //   270: aload_1
    //   271: invokevirtual 175	java/io/FileInputStream:close	()V
    //   274: aload_3
    //   275: iconst_m1
    //   276: invokeinterface 178 2 0
    //   281: return
    //   282: astore_1
    //   283: aconst_null
    //   284: astore 5
    //   286: aload 7
    //   288: astore_1
    //   289: aload 5
    //   291: ifnull +8 -> 299
    //   294: aload 5
    //   296: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   299: aload_1
    //   300: ifnull +7 -> 307
    //   303: aload_1
    //   304: invokevirtual 175	java/io/FileInputStream:close	()V
    //   307: aload_3
    //   308: iconst_m1
    //   309: invokeinterface 178 2 0
    //   314: return
    //   315: astore 7
    //   317: aconst_null
    //   318: astore 5
    //   320: aconst_null
    //   321: astore 6
    //   323: aload 5
    //   325: ifnull +8 -> 333
    //   328: aload 5
    //   330: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   333: aload 6
    //   335: ifnull +8 -> 343
    //   338: aload 6
    //   340: invokevirtual 175	java/io/FileInputStream:close	()V
    //   343: aload_3
    //   344: aload_1
    //   345: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   348: aload_2
    //   349: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   352: invokeinterface 135 3 0
    //   357: aload_3
    //   358: invokeinterface 136 1 0
    //   363: aload 7
    //   365: athrow
    //   366: astore 5
    //   368: goto -325 -> 43
    //   371: astore 5
    //   373: goto -318 -> 55
    //   376: astore 5
    //   378: goto -160 -> 218
    //   381: astore 5
    //   383: goto -155 -> 228
    //   386: astore_1
    //   387: goto -203 -> 184
    //   390: astore_1
    //   391: goto -199 -> 192
    //   394: astore_2
    //   395: goto -129 -> 266
    //   398: astore_1
    //   399: goto -125 -> 274
    //   402: astore_2
    //   403: goto -104 -> 299
    //   406: astore_1
    //   407: goto -100 -> 307
    //   410: astore 5
    //   412: goto -79 -> 333
    //   415: astore 5
    //   417: goto -74 -> 343
    //   420: astore 7
    //   422: aconst_null
    //   423: astore 6
    //   425: goto -102 -> 323
    //   428: astore 7
    //   430: goto -107 -> 323
    //   433: astore_1
    //   434: aload 7
    //   436: astore_1
    //   437: goto -148 -> 289
    //   440: astore_1
    //   441: aload 6
    //   443: astore_1
    //   444: goto -155 -> 289
    //   447: astore_1
    //   448: aload 9
    //   450: astore_1
    //   451: goto -195 -> 256
    //   454: astore_1
    //   455: aload 6
    //   457: astore_1
    //   458: goto -202 -> 256
    //   461: astore_1
    //   462: aconst_null
    //   463: astore_1
    //   464: aload 8
    //   466: astore_2
    //   467: goto -291 -> 176
    //   470: astore_1
    //   471: aload 5
    //   473: astore_1
    //   474: aload 8
    //   476: astore_2
    //   477: goto -301 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	this	FMSettings
    //   0	480	1	paramFile1	File
    //   0	480	2	paramFile2	File
    //   0	480	3	paramMoveFileCallback	FMSettingInterface.MoveFileCallback
    //   126	32	4	i	int
    //   96	233	5	localFileOutputStream	java.io.FileOutputStream
    //   366	1	5	localException1	Exception
    //   371	1	5	localException2	Exception
    //   376	1	5	localException3	Exception
    //   381	1	5	localException4	Exception
    //   410	1	5	localException5	Exception
    //   415	57	5	localException6	Exception
    //   106	350	6	localFileInputStream	java.io.FileInputStream
    //   4	283	7	arrayOfByte	byte[]
    //   315	49	7	localObject1	Object
    //   420	1	7	localObject2	Object
    //   428	7	7	localObject3	Object
    //   7	468	8	localObject4	Object
    //   1	448	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   108	119	169	java/io/IOException
    //   119	128	169	java/io/IOException
    //   134	166	169	java/io/IOException
    //   200	208	169	java/io/IOException
    //   9	25	249	java/lang/OutOfMemoryError
    //   25	31	249	java/lang/OutOfMemoryError
    //   76	88	249	java/lang/OutOfMemoryError
    //   88	98	249	java/lang/OutOfMemoryError
    //   9	25	282	java/lang/Exception
    //   25	31	282	java/lang/Exception
    //   76	88	282	java/lang/Exception
    //   88	98	282	java/lang/Exception
    //   9	25	315	finally
    //   25	31	315	finally
    //   76	88	315	finally
    //   88	98	315	finally
    //   35	43	366	java/lang/Exception
    //   47	55	371	java/lang/Exception
    //   213	218	376	java/lang/Exception
    //   223	228	381	java/lang/Exception
    //   180	184	386	java/lang/Exception
    //   188	192	390	java/lang/Exception
    //   261	266	394	java/lang/Exception
    //   270	274	398	java/lang/Exception
    //   294	299	402	java/lang/Exception
    //   303	307	406	java/lang/Exception
    //   328	333	410	java/lang/Exception
    //   338	343	415	java/lang/Exception
    //   98	108	420	finally
    //   108	119	428	finally
    //   119	128	428	finally
    //   134	166	428	finally
    //   200	208	428	finally
    //   98	108	433	java/lang/Exception
    //   108	119	440	java/lang/Exception
    //   119	128	440	java/lang/Exception
    //   134	166	440	java/lang/Exception
    //   200	208	440	java/lang/Exception
    //   98	108	447	java/lang/OutOfMemoryError
    //   108	119	454	java/lang/OutOfMemoryError
    //   119	128	454	java/lang/OutOfMemoryError
    //   134	166	454	java/lang/OutOfMemoryError
    //   200	208	454	java/lang/OutOfMemoryError
    //   9	25	461	java/io/IOException
    //   25	31	461	java/io/IOException
    //   76	88	461	java/io/IOException
    //   88	98	461	java/io/IOException
    //   98	108	470	java/io/IOException
  }
  
  private void a(List paramList, FMSettingInterface.MoveFileCallback paramMoveFileCallback)
  {
    a(1, "moveFileToDefaultPath");
    if ((paramList == null) || (paramList.size() == 0)) {
      a(1, "moveFileToDefaultPath,lstPath is null or size = 0");
    }
    Object localObject;
    String str1;
    int j;
    int i;
    do
    {
      return;
      this.jdField_a_of_type_Long = 0L;
      try
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_Long = 0L;
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          str1 = (String)((Iterator)localObject).next();
          this.jdField_b_of_type_Long += FileUtil.a(str1);
        }
        a(1, "moveFileToDefaultPath,total size[" + this.jdField_b_of_type_Long + "]");
      }
      finally {}
      if (this.jdField_b_of_type_Long == 0L)
      {
        paramMoveFileCallback.a();
        return;
      }
      str1 = d().jdField_b_of_type_JavaLangString + d().c;
      j = paramList.size();
      i = 0;
    } while (i >= j);
    String str2 = (String)paramList.get(i);
    if (str2.contains("/.tmp/")) {
      localObject = b(str1) + FileManagerUtil.a(str2);
    }
    for (;;)
    {
      for (;;)
      {
        localObject = new File((String)localObject);
        try
        {
          ThreadManager.post(new adgh(this, str2, (File)localObject, j, paramMoveFileCallback), 8, null, false);
          i += 1;
        }
        catch (Exception paramList)
        {
          a(1, "copyFile Fail! " + paramList.toString());
        }
      }
      if (str2.contains("/.thumbnails/")) {
        localObject = c(str1) + FileManagerUtil.a(str2);
      } else {
        localObject = a(str1) + FileManagerUtil.a(str2);
      }
    }
  }
  
  private boolean a(String paramString)
  {
    File localFile = new File(paramString);
    boolean bool = false;
    if (!localFile.exists()) {
      bool = localFile.mkdirs();
    }
    if (bool) {
      a(2, "create [" + paramString + "] success!");
    }
    return bool;
  }
  
  private adgr b()
  {
    return (adgr)this.jdField_a_of_type_JavaUtilMap.get("sdCard");
  }
  
  private String b(String paramString)
  {
    paramString = (paramString + "/Tencent/QQfile_recv/.tmp/").replace("//", "/");
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramString;
  }
  
  private adgr c()
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 1) {
      return null;
    }
    return (adgr)this.jdField_a_of_type_JavaUtilMap.get("externalSdCard");
  }
  
  private String c(String paramString)
  {
    paramString = (paramString + "/Tencent/QQfile_recv/.thumbnails/").replace("//", "/");
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramString;
  }
  
  private void c()
  {
    adgr localadgr = a();
    if (localadgr == null) {
      return;
    }
    ThreadManager.post(new adgg(this, b(localadgr.jdField_b_of_type_JavaLangString + localadgr.c)), 8, null, false);
  }
  
  private adgr d()
  {
    a(2, "getDefaultStorage[" + this.jdField_a_of_type_JavaUtilMap.size() + "]");
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (adgr)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
      ((adgr)localObject2).a();
      if (((adgr)localObject2).jdField_a_of_type_Boolean)
      {
        a(2, "getDefaultStorage[" + ((adgr)localObject2).jdField_b_of_type_JavaLangString + "] + ext[" + ((adgr)localObject2).c + "]");
        return localObject2;
      }
    }
    a(2, "getDefaultStorage nothing is default refresh!");
    localObject1 = (adgr)this.jdField_a_of_type_JavaUtilMap.get("sdCard");
    ((adgr)localObject1).a(BaseApplicationImpl.getContext());
    return localObject1;
  }
  
  public long a()
  {
    Object localObject = d().jdField_b_of_type_JavaLangString;
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return i * l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 2147483647L;
  }
  
  public adgr a()
  {
    a(2, "getOtherStorage[" + this.jdField_a_of_type_JavaUtilMap.size() + "]");
    adgr localadgr = d();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (adgr)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      if (localadgr != localObject) {
        return localObject;
      }
    }
    a(2, "getOtherStorage nothing is default refresh!");
    return null;
  }
  
  public String a()
  {
    adgr localadgr = a();
    if (localadgr == null) {
      return null;
    }
    return a(localadgr.jdField_b_of_type_JavaLangString + localadgr.c);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Map localMap = FileManagerUtil.a(localBaseApplication);
    a(1, "qurey strorages[" + localMap.size() + "]");
    String str1 = localBaseApplication.getSharedPreferences("FMSETTING_59", 0).getString("DefaultRootPath", AppConstants.aI);
    a(1, "qurey defaultRootPath[" + str1 + "]");
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    Iterator localIterator = localMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Object localObject = ((File)localMap.get(str2)).getPath();
      adgr localadgr = new adgr(this, null);
      localadgr.jdField_a_of_type_Boolean = false;
      if (str2.equalsIgnoreCase("sdCard"))
      {
        localadgr.jdField_a_of_type_JavaLangString = "SD卡";
        localadgr.jdField_b_of_type_JavaLangString = ((String)localObject);
        localadgr.c = "";
      }
      for (;;)
      {
        a(1, "rootPath[" + localadgr.jdField_b_of_type_JavaLangString + "],bDefault[" + localadgr.jdField_a_of_type_Boolean + "]");
        try
        {
          localObject = new StatFs((String)localObject);
          localadgr.jdField_a_of_type_Long = (((StatFs)localObject).getAvailableBlocks() * ((StatFs)localObject).getBlockSize());
          a(4, "defaultRootPath[" + str1 + "].equalsIgnoreCase(si.rootPath[" + localadgr.jdField_b_of_type_JavaLangString + "])");
          if ((localMap.size() == 1) || (str1.equalsIgnoreCase(localadgr.jdField_b_of_type_JavaLangString)))
          {
            a(4, "defaultRootPath.equalsIgnoreCase(si.rootPath) = true");
            localadgr.jdField_a_of_type_Boolean = true;
            localadgr.a(localBaseApplication);
          }
          localadgr.a();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            String str3;
            localException.printStackTrace();
          }
        }
        this.jdField_a_of_type_JavaUtilMap.put(str2, localadgr);
        break;
        if (str2.equalsIgnoreCase("externalSdCard"))
        {
          localadgr.jdField_a_of_type_JavaLangString = "外置SD卡";
          localBaseApplication.getExternalFilesDir(null);
          str3 = BaseApplicationImpl.sApplication.getPackageName();
          localadgr.jdField_b_of_type_JavaLangString = ((String)localObject);
          localadgr.c = ("/Android/data/" + str3 + "/");
        }
      }
    }
  }
  
  public void a(long paramLong, List arg3, Activity paramActivity, FMSettingInterface.MoveFileCallback paramMoveFileCallback)
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      long l;
      synchronized (BaseApplicationImpl.getContext())
      {
        this.jdField_b_of_type_Boolean = true;
        l = b();
        if (!a())
        {
          paramMoveFileCallback.a(12);
          synchronized (BaseApplicationImpl.getContext())
          {
            this.jdField_b_of_type_Boolean = false;
            return;
          }
        }
      }
      if (l < paramLong)
      {
        paramMoveFileCallback.a(16);
        synchronized (BaseApplicationImpl.getContext())
        {
          this.jdField_b_of_type_Boolean = false;
          return;
        }
      }
      a(1, "showChoosePath, callback[" + paramMoveFileCallback + "]");
      ??? = b();
      adgr localadgr = c();
      if (((adgr)???).jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaLangString = "本机内存已满，下载失败。为保证以后顺利下载，默认存储路径将为你更换到外置SD卡中：";
      }
      for (this.jdField_b_of_type_JavaLangString = (a().jdField_b_of_type_JavaLangString + a().c + "/Tencent/QQfile_recv/").replace("//", "/"); paramActivity != null; this.jdField_b_of_type_JavaLangString = (a().jdField_b_of_type_JavaLangString + a().c + "/Tencent/QQfile_recv/").replace("//", "/"))
      {
        label213:
        paramActivity.runOnUiThread(new adgj(this, paramActivity, ???, paramMoveFileCallback));
        return;
        if ((localadgr == null) || (!localadgr.jdField_a_of_type_Boolean)) {
          break label213;
        }
        this.jdField_a_of_type_JavaLangString = "外置SD卡已满，下载失败。为保证以后顺利下载，默认存储路径将为你更换到本机内存中：";
      }
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        if (paramString != null) {
          this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        }
        if ("externalSdCard".equalsIgnoreCase(paramString))
        {
          ((adgr)this.jdField_a_of_type_JavaUtilMap.get("sdCard")).a(BaseApplicationImpl.getContext());
          return;
        }
      }
    }
    catch (Exception paramString) {}
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 1) {}
    while (c() == null) {
      return false;
    }
    return true;
  }
  
  public long b()
  {
    Object localObject = a();
    if (localObject == null) {
      return 0L;
    }
    localObject = ((adgr)localObject).jdField_b_of_type_JavaLangString;
    try
    {
      localObject = new StatFs((String)localObject);
      long l = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return i * l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 2147483647L;
  }
  
  public String b()
  {
    return a(d().jdField_b_of_type_JavaLangString + d().c);
  }
  
  public void b()
  {
    try
    {
      a(1, "FMSettings free");
      Field localField = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getClass().getSuperclass().getDeclaredField("mShowing");
      localField.setAccessible(true);
      localField.set(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, Boolean.valueOf(true));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public String c()
  {
    return b(d().jdField_b_of_type_JavaLangString + d().c);
  }
  
  public String d()
  {
    return c(d().jdField_b_of_type_JavaLangString + d().c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings
 * JD-Core Version:    0.7.0.1
 */