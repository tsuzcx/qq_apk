package com.tencent.mobileqq.shortvideo;

import allk;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import anhk;
import bcfk;
import bcfl;
import bcgd;
import bcge;
import bcgf;
import bcgx;
import bcif;
import bcjb;
import bcls;
import bgmg;
import bhgg;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.util.ArrayList;
import lkw;

public class VideoEnvironment
{
  public static int a;
  public static Handler a;
  public static bcge a;
  private static Object jdField_a_of_type_JavaLangObject;
  public static String a;
  private static ArrayList<bcgf> jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
  public static boolean a;
  public static final int[] a;
  public static final String[] a;
  private static Object jdField_b_of_type_JavaLangObject;
  private static final String jdField_b_of_type_JavaLangString;
  public static boolean b;
  private static int[] jdField_b_of_type_ArrayOfInt = new int[16];
  public static final String[] b;
  private static Object jdField_c_of_type_JavaLangObject;
  private static boolean jdField_c_of_type_Boolean;
  public static final String[] c;
  private static final String[] d;
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_a_of_type_JavaLangString = bhgg.a(anhk.aZ + "/Tencent/com/tencent/mobileqq/debugDecodeShortVideo");
    File localFile = new File(ShortVideoSoLoad.getShortVideoSoPath(a()));
    if (!localFile.exists())
    {
      localFile.mkdirs();
      a("VideoEnvironment:[static]loadPathFile not exist...", null);
    }
    d = new String[] { "backup", "trim_process_pic", "trim_process_pie" };
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangString = "backup" + File.separatorChar;
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_Bcge = new bcge();
    jdField_c_of_type_JavaLangObject = new Object();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "1920*1080", "1280*720", "960*720", "640*480" };
    jdField_a_of_type_ArrayOfInt = new int[] { 1920, 1280, 960, 640 };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "1000", "2000", "4000", "8000" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=1920*1080#2000#3000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55;3000#6500#3#9#55|1|dynamic=1", "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=1280*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=1", "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=1", "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=640*480#450#750;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=1" };
  }
  
  public static int a()
  {
    return ShortVideoSoLoad.getShortVideoSoLoadStatus();
  }
  
  private static int a(int paramInt)
  {
    if ((paramInt <= 0) && (paramInt >= 16)) {
      return 0;
    }
    try
    {
      if (!jdField_c_of_type_Boolean)
      {
        getAVCodecLibMetadata(jdField_b_of_type_ArrayOfInt);
        jdField_c_of_type_Boolean = true;
      }
      paramInt = jdField_b_of_type_ArrayOfInt[paramInt];
      return paramInt;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return 0;
  }
  
  /* Error */
  public static int a(String arg0, Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 165	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoLoadStatus	()I
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +31 -> 39
    //   11: new 43	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   18: ldc 177
    //   20: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_2
    //   24: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: aconst_null
    //   31: invokestatic 93	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   34: ldc 2
    //   36: monitorexit
    //   37: iload_2
    //   38: ireturn
    //   39: getstatic 106	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   42: astore_0
    //   43: aload_0
    //   44: monitorenter
    //   45: invokestatic 182	com/tencent/mobileqq/shortvideo/VideoEnvironment:c	()I
    //   48: istore_2
    //   49: new 43	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   56: ldc 184
    //   58: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload_2
    //   62: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: aconst_null
    //   69: invokestatic 93	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: aload_0
    //   73: monitorexit
    //   74: goto -40 -> 34
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	1	paramContext	Context
    //   6	56	2	i	int
    // Exception table:
    //   from	to	target	type
    //   45	74	77	finally
    //   78	80	77	finally
    //   3	7	82	finally
    //   11	34	82	finally
    //   39	45	82	finally
    //   80	82	82	finally
  }
  
  public static int a(String paramString, Context paramContext, boolean paramBoolean)
  {
    return a(paramString, paramContext);
  }
  
  private static int a(String[] paramArrayOfString)
  {
    String str = bcfk.a();
    a("LoadPathso: currentSoName=" + str, null);
    if (str.equals("d000_1")) {
      return -11;
    }
    Object localObject = bcfk.a(str);
    int i = ((bcfl)localObject).a();
    a("LoadPathso: CfgParser err=" + i, null);
    if (i == 0)
    {
      localObject = ((bcfl)localObject).b();
      a("LoadPathso: currentVersion=" + (String)localObject + " dymAVCodecVersion=" + 65, null);
      if (Integer.parseInt((String)localObject) >= 65)
      {
        paramArrayOfString[0] = str;
        return 255;
      }
      return -13;
    }
    return -12;
  }
  
  public static Context a()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public static String a()
  {
    String[] arrayOfString = new String[1];
    int i = a(arrayOfString);
    a("getShortVideoSoLibName: errcode=" + i + " soNameValue=" + arrayOfString[0], null);
    if (i == 255) {
      return arrayOfString[0];
    }
    a("getShortVideoSoLibName[err=" + i + "]");
    a("getShortVideoSoLibName[get End],errcode=" + i, null);
    return null;
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  private static String a(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf("=");
    if (i == -1) {
      return paramString2;
    }
    return paramString1.substring(i + 1);
  }
  
  public static void a()
  {
    if ((jdField_a_of_type_Int & 0x1) == 0) {
      synchronized (jdField_c_of_type_JavaLangObject)
      {
        bcjb.jdField_g_of_type_Int = jdField_a_of_type_Bcge.jdField_b_of_type_Int;
        bcjb.h = jdField_a_of_type_Bcge.u;
        bcjb.i = jdField_a_of_type_Bcge.v;
        jdField_a_of_type_Int |= 0x1;
        return;
      }
    }
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoEnvironment", 2, "VideoEnvironment|progress=" + paramInt);
    }
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = jdField_a_of_type_JavaUtilArrayList.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < localObject.length)
      {
        bcgf localbcgf = (bcgf)localObject[i];
        jdField_a_of_type_AndroidOsHandler.post(new VideoEnvironment.2(localbcgf, paramInt));
        i += 1;
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject = ShortVideoSoLoad.getShortVideoSoPath(a());
    localObject = new File((String)localObject + jdField_b_of_type_JavaLangString);
    boolean bool = ((File)localObject).exists();
    a("initBuiltInDoCopyEnvStep:[begin] backupDirExists=" + bool, null);
    if (!bool) {
      ((File)localObject).mkdirs();
    }
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_clear_sp", 4);
    if (((SharedPreferences)localObject).getInt("flow_filter_clear_key", -1) < 1) {
      ((SharedPreferences)localObject).edit().putInt("flow_filter_clear_key", 1).commit();
    }
    a("initBuiltInDoCopyEnvStep:clear earlyDownload cache data...", null);
    bcls.a();
    a("initBuiltInDoCopyEnvStep:[end]...", null);
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      bcjb.r = paramInt * 1000;
    }
    for (bcjb.r += 100000;; bcjb.r += 350000)
    {
      bcjb.s *= 4;
      return;
    }
  }
  
  public static void a(bcge parambcge)
  {
    synchronized (jdField_c_of_type_JavaLangObject)
    {
      jdField_a_of_type_Bcge = parambcge;
      jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramAppInterface == null) && (QLog.isColorLevel())) {
      QLog.d("VideoEnvironment", 2, "initConfig()[use default index]: app is null");
    }
    long l1 = System.currentTimeMillis();
    paramAppInterface = paramString;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "initConfig()[use user passed config]: config is null");
      }
      paramAppInterface = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "initConfig(): DPConfig = " + paramAppInterface);
    }
    paramString = paramAppInterface;
    if (paramAppInterface == null) {
      paramString = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=0";
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "initConfig(): config=" + paramString);
    }
    bcge localbcge = new bcge();
    try
    {
      paramAppInterface = paramString.split(",");
      if ((paramAppInterface == null) || (paramAppInterface.length == 0))
      {
        if (!QLog.isColorLevel()) {
          break label1727;
        }
        QLog.d("VideoEnvironment", 2, "initConfig(): configs is null or its length is 0");
        return;
      }
      boolean bool = paramBoolean;
      if (!paramBoolean) {
        bool = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name());
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "initConfig(): isInDPCWhiteList=" + bool);
      }
      paramString = paramAppInterface[0].split("\\|");
      if ((paramString == null) || (paramString.length < 13))
      {
        if (!QLog.isColorLevel()) {
          break label1727;
        }
        QLog.d("VideoEnvironment", 2, "initConfig(): configs is null or length less than 13");
        return;
      }
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoEnvironment", 2, "initConfig(): " + paramAppInterface.getMessage());
      }
    }
    label621:
    Object localObject2;
    label1153:
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "initConfig(): time cost " + (l2 - l1) + "ms");
      }
      a(localbcge);
      return;
      paramAppInterface = paramString[3].split("\\*");
      if ((paramAppInterface == null) || (paramAppInterface.length != 2))
      {
        if (!QLog.isColorLevel()) {
          break label1727;
        }
        QLog.d("VideoEnvironment", 2, "initConfig(): resolution is null or length is not 2");
        return;
      }
      localbcge.jdField_a_of_type_Int = 0;
      localbcge.jdField_d_of_type_Int = Integer.valueOf(paramAppInterface[0]).intValue();
      localbcge.jdField_e_of_type_Int = Integer.valueOf(paramAppInterface[1]).intValue();
      localbcge.jdField_b_of_type_Int = Integer.valueOf(paramString[0]).intValue();
      localbcge.jdField_c_of_type_Int = Integer.valueOf(paramString[1]).intValue();
      localbcge.l = Integer.valueOf(paramString[2]).intValue();
      localbcge.jdField_f_of_type_Int = Integer.valueOf(paramString[4]).intValue();
      localbcge.jdField_g_of_type_Int = Integer.valueOf(paramString[5]).intValue();
      localbcge.i = Integer.valueOf(paramString[6]).intValue();
      localbcge.h = Integer.valueOf(paramString[7]).intValue();
      localbcge.j = Integer.valueOf(paramString[8]).intValue();
      localbcge.k = Integer.valueOf(paramString[9]).intValue();
      localbcge.m = Integer.valueOf(paramString[10]).intValue();
      localbcge.n = Integer.valueOf(paramString[11]).intValue();
      localbcge.o = Integer.valueOf(paramString[12]).intValue();
      if (paramString.length < 17)
      {
        i = 1;
        paramAppInterface = null;
        if (i == 0) {
          break label1023;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoEnvironment", 2, "initConfig(): (resolutions == null) || (resolutions.length == 0) || (indexs.length != 3)");
        }
        localbcge.jdField_a_of_type_ArrayOfInt = new int[] { localbcge.jdField_d_of_type_Int };
        localbcge.jdField_b_of_type_ArrayOfInt = new int[] { localbcge.jdField_e_of_type_Int };
        localbcge.p = 0;
        localbcge.q = 0;
      }
      label842:
      label1102:
      label1124:
      label1146:
      for (localbcge.r = 0;; localbcge.r = i)
      {
        if (paramString.length <= 25) {
          break label1153;
        }
        paramAppInterface = a(paramString[17], "").split(";");
        localbcge.jdField_e_of_type_ArrayOfInt = new int[paramAppInterface.length];
        i = 0;
        while (i < paramAppInterface.length)
        {
          localObject1 = paramAppInterface[i];
          localbcge.jdField_e_of_type_ArrayOfInt[i] = Integer.valueOf((String)localObject1).intValue();
          i += 1;
        }
        paramAppInterface = a(paramString[13], "");
        if (TextUtils.isEmpty(paramAppInterface))
        {
          i = 1;
          paramAppInterface = null;
          break;
        }
        paramAppInterface = paramAppInterface.split(";");
        if ((paramAppInterface == null) || (paramAppInterface.length == 0)) {
          break label1728;
        }
        localbcge.jdField_a_of_type_ArrayOfInt = new int[paramAppInterface.length];
        localbcge.jdField_b_of_type_ArrayOfInt = new int[paramAppInterface.length];
        localbcge.jdField_c_of_type_ArrayOfInt = new int[paramAppInterface.length];
        localbcge.jdField_d_of_type_ArrayOfInt = new int[paramAppInterface.length];
        i = 0;
        if (i >= paramAppInterface.length) {
          break label1722;
        }
        localObject1 = paramAppInterface[i].split("#");
        if ((localObject1 == null) || (localObject1.length < 3)) {
          break label1733;
        }
        localObject2 = localObject1[0].split("\\*");
        if ((localObject2 == null) || (localObject2.length != 2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoEnvironment", 2, "initConfig(): res is null or length is not 2");
          }
          localbcge.jdField_a_of_type_ArrayOfInt[i] = localbcge.jdField_d_of_type_Int;
          localbcge.jdField_b_of_type_ArrayOfInt[i] = localbcge.jdField_e_of_type_Int;
        }
        while ((localObject1[1] != null) && (localObject1[2] != null))
        {
          localbcge.jdField_c_of_type_ArrayOfInt[i] = Integer.valueOf(localObject1[1]).intValue();
          localbcge.jdField_d_of_type_ArrayOfInt[i] = Integer.valueOf(localObject1[2]).intValue();
          break;
          localbcge.jdField_a_of_type_ArrayOfInt[i] = Integer.valueOf(localObject2[0]).intValue();
          localbcge.jdField_b_of_type_ArrayOfInt[i] = Integer.valueOf(localObject2[1]).intValue();
        }
        label1023:
        localbcge.p = Integer.valueOf(a(paramString[14], "0")).intValue();
        localbcge.q = Integer.valueOf(a(paramString[15], "0")).intValue();
        localbcge.r = Integer.valueOf(a(paramString[16], "0")).intValue();
        if (localbcge.p >= paramAppInterface.length) {
          break label1740;
        }
        i = localbcge.p;
        localbcge.p = i;
        if (localbcge.q >= paramAppInterface.length) {
          break label1745;
        }
        i = localbcge.q;
        localbcge.q = i;
        if (localbcge.r >= paramAppInterface.length) {
          break label1750;
        }
        i = localbcge.r;
      }
    }
    paramAppInterface = a(paramString[18], "").split(";");
    localbcge.jdField_f_of_type_ArrayOfInt = new int[paramAppInterface.length];
    int i = 0;
    while (i < paramAppInterface.length)
    {
      localObject1 = paramAppInterface[i];
      localbcge.jdField_f_of_type_ArrayOfInt[i] = Integer.valueOf((String)localObject1).intValue();
      i += 1;
    }
    Object localObject1 = a(paramString[19], "").split(";");
    localbcge.jdField_g_of_type_ArrayOfInt = new int[paramAppInterface.length];
    i = 0;
    while (i < localObject1.length)
    {
      paramAppInterface = localObject1[i];
      localbcge.jdField_g_of_type_ArrayOfInt[i] = Integer.valueOf(paramAppInterface).intValue();
      i += 1;
    }
    paramAppInterface = a(paramString[20], "").split(";");
    if ((paramAppInterface != null) && (paramAppInterface.length == 2))
    {
      localbcge.s = Integer.valueOf(paramAppInterface[0]).intValue();
      localbcge.t = Integer.valueOf(paramAppInterface[1]).intValue();
    }
    localbcge.jdField_b_of_type_Boolean = a(paramString[21], "").toLowerCase().contains(Build.MODEL.toLowerCase());
    if (!bcif.d(bcif.i)) {
      if (!bcif.b(bcif.G)) {
        break label1767;
      }
    }
    for (;;)
    {
      label1381:
      localbcge.jdField_c_of_type_Boolean = paramBoolean;
      if (!localbcge.jdField_c_of_type_Boolean) {
        localbcge.jdField_c_of_type_Boolean = c(a(paramString[22], ""));
      }
      localbcge.jdField_a_of_type_Boolean = a(paramString[23], "").equals("1");
      paramAppInterface = a(paramString[24], "").split(";");
      if ((paramAppInterface != null) && (paramAppInterface.length == 2))
      {
        localbcge.u = Integer.valueOf(paramAppInterface[0]).intValue();
        localbcge.v = Integer.valueOf(paramAppInterface[1]).intValue();
      }
      paramAppInterface = paramString[25].split(";");
      if ((paramAppInterface != null) && (paramAppInterface.length > 0)) {
        i = 0;
      }
      for (;;)
      {
        for (;;)
        {
          if (i < paramAppInterface.length)
          {
            localObject1 = paramAppInterface[i].split("#");
            if ((localObject1 == null) || (localObject1.length != 5)) {
              break label1760;
            }
            int j = Integer.valueOf(localObject1[0]).intValue();
            localObject2 = new bcgd();
            ((bcgd)localObject2).jdField_a_of_type_Int = Integer.valueOf(localObject1[1]).intValue();
            ((bcgd)localObject2).jdField_c_of_type_Int = Integer.valueOf(localObject1[2]).intValue();
            ((bcgd)localObject2).jdField_d_of_type_Int = Integer.valueOf(localObject1[3]).intValue();
            ((bcgd)localObject2).jdField_b_of_type_Int = Integer.valueOf(localObject1[4]).intValue();
            localbcge.jdField_a_of_type_AndroidUtilSparseArray.put(j, localObject2);
            break label1760;
          }
          i = paramString.length;
          if (i > 26) {}
          try
          {
            localbcge.jdField_a_of_type_Float = Float.parseFloat(paramString[26]);
            if ((localbcge.jdField_a_of_type_Float < 0.0F) || (localbcge.jdField_a_of_type_Float > 1.0F)) {
              localbcge.jdField_a_of_type_Float = 1.0F;
            }
            if (paramString.length <= 27) {
              break;
            }
            localbcge.jdField_d_of_type_Boolean = a(paramString[27], "0").equals("1");
          }
          catch (NumberFormatException paramAppInterface)
          {
            for (;;)
            {
              paramAppInterface.printStackTrace();
            }
          }
        }
        label1722:
        i = 0;
        break label621;
        label1727:
        return;
        label1728:
        i = 1;
        break label621;
        label1733:
        i += 1;
        break label842;
        label1740:
        i = 0;
        break label1102;
        label1745:
        i = 0;
        break label1124;
        label1750:
        i = 0;
        break label1146;
        paramBoolean = true;
        break label1381;
        label1760:
        i += 1;
      }
      label1767:
      paramBoolean = false;
    }
  }
  
  private static void a(String paramString)
  {
    a("PrintPreDownloadInfo:[" + paramString + "]-------------***-------------", null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.i(paramString1, 2, paramString2, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.i(paramString1, 2, paramString2);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    a("VideoEnvironment", paramString, paramThrowable);
  }
  
  public static void a(boolean paramBoolean, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoEnvironment", 2, "VideoEnvironment[success=" + paramBoolean + "][Video so download success...]");
    }
    if ((paramBoolean) && (c(paramAppInterface))) {
      d();
    }
    for (;;)
    {
      try
      {
        jdField_a_of_type_Boolean = true;
        paramAppInterface = jdField_a_of_type_JavaUtilArrayList.toArray();
        if (paramBoolean) {
          jdField_a_of_type_JavaUtilArrayList.clear();
        }
        if ((paramAppInterface == null) || (paramAppInterface.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < paramAppInterface.length)
      {
        bcgf localbcgf = (bcgf)paramAppInterface[i];
        jdField_a_of_type_AndroidOsHandler.post(new VideoEnvironment.3(localbcgf, paramBoolean));
        i += 1;
      }
    }
  }
  
  public static boolean a()
  {
    if (c()) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = lkw.d();
      bool2 = f();
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "isX86Platform: isBeautySupported=" + bool1 + " isSoSupportBeauty=" + bool2);
      }
    } while ((!bool1) || (!bool2));
    return true;
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt > 65) {}
    while (paramInt == 65) {
      return true;
    }
    return false;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((paramInt2 < 0) || (paramInt2 >= 32)) {
      bool = false;
    }
    while ((a(paramInt1) & 0xFFFFFFFF & 1 << paramInt2) != 0) {
      return bool;
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    return (VersionUtils.isIceScreamSandwich()) && (c(paramAppInterface)) && (!g());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2 = false;
    String str1 = ShortVideoSoLoad.getShortVideoSoPath(a());
    Object localObject2 = str1 + jdField_b_of_type_JavaLangString;
    a("VideoEnvironment:[uncompressZipSo]destDir=" + (String)localObject2, null);
    File localFile;
    boolean bool1;
    for (;;)
    {
      try
      {
        synchronized (jdField_b_of_type_JavaLangObject)
        {
          localFile = new File((String)localObject2);
          if (!localFile.exists())
          {
            localFile.mkdirs();
            paramQQAppInterface = (String)localObject2 + a("AVCodec");
            localFile = new File(paramQQAppInterface);
            if (localFile.exists())
            {
              a("VideoEnvironment:[uncompressZipSo][has back file] path=" + paramQQAppInterface, null);
              localFile.delete();
            }
            bgmg.a(paramString, (String)localObject2, false);
            bool1 = localFile.exists();
            a("VideoEnvironment:[end uncompressZipSo] existsFile=" + bool1, null);
            if (bool1) {
              break;
            }
            throw new RuntimeException("After uncompressZip,AVCodec file not exist...");
          }
        }
        bool1 = b(paramQQAppInterface, (String)localObject2, paramInt);
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        a("VideoEnvironment:exp=", paramQQAppInterface);
        return true;
      }
      a("VideoEnvironment:[checkUncompressedResourceIsOK] checkOK=" + bool1, null);
      if (bool1) {
        return false;
      }
    }
    paramString = new File((String)localObject2 + "config_version");
    if (!paramString.exists()) {
      throw new RuntimeException("After uncompressZip,config_version file not exist...");
    }
    localObject2 = bcfk.a(bcfk.a(paramString));
    paramInt = ((bcfl)localObject2).a();
    if (paramInt != 0)
    {
      a("VideoEnvironment:[uncompressZipSo][createParser] errorCodec=" + paramInt, null);
      throw new RuntimeException("createParser err=" + paramInt);
    }
    Object localObject3 = bcfk.a(paramQQAppInterface);
    paramString = ((bcfl)localObject2).a();
    a("VideoEnvironment:[uncompressZipSo][Md5] md5Cfg=" + paramString + " md5Cmp=" + (String)localObject3, null);
    if (!paramString.equalsIgnoreCase((String)localObject3)) {
      throw new RuntimeException("[Md5 error] md5Cfg=" + paramString + " md5Cmp=" + (String)localObject3);
    }
    long l1 = localFile.length();
    localObject3 = ((bcfl)localObject2).b().trim();
    localObject2 = bcfk.a(paramString, (String)localObject3);
    a("VideoEnvironment:[uncompressZipSo][trim] versionvalid=" + (String)localObject3 + " soNewName=" + (String)localObject2, null);
    str1 = str1 + (String)localObject2;
    localObject3 = new File(str1);
    paramInt = 0;
    long l2;
    String str2;
    if (((File)localObject3).exists())
    {
      l2 = ((File)localObject3).length();
      str2 = bcfk.a(str1);
      if (!paramString.equalsIgnoreCase(str2))
      {
        bool1 = true;
        a("VideoEnvironment:[uncompressZipSo] md5NoEqualsAlready=" + bool1 + " fileSize=" + l2 + " alreadySoMd5=" + str2, null);
        if (bool1)
        {
          ((File)localObject3).delete();
          paramInt = 1;
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        if (!localFile.renameTo((File)localObject3))
        {
          throw new RuntimeException("[renameTo error] destFilePath=" + paramQQAppInterface + "  loadFilePath=" + str1);
          a("VideoEnvironment:[uncompressZipSo] Restore SP md5NoEqualsAlready=" + bool1 + " fileSize=" + l2 + " alreadySoMd5=" + str2 + ",md5Cfg=" + paramString, null);
          bool1 = a("VideoEnvironment:[uncompressZipSo Restore SP ]storeSoNewVersion", (String)localObject2);
          break label916;
        }
        l2 = ((File)localObject3).length();
        if (l1 == l2)
        {
          a("VideoEnvironment:[uncompressZipSo success]storeSoNewVersion loadLength=" + l2 + "  soNewName=" + (String)localObject2, null);
          bool1 = a("VideoEnvironment:[uncompressZipSo success]storeSoNewVersion", (String)localObject2);
        }
      }
      else
      {
        e();
        d();
        return bool1;
      }
      throw new RuntimeException("[length error] destLength=" + l1 + " loadLength=" + l2);
      label916:
      continue;
      bool1 = false;
      break;
      bool1 = false;
      paramInt = 1;
    }
  }
  
  private static boolean a(File paramFile1, File paramFile2)
  {
    if (!paramFile1.exists()) {
      a("copySoToFilesDir: filesource not exist", null);
    }
    long l1;
    long l2;
    do
    {
      return false;
      String str3 = paramFile1.getAbsolutePath();
      String str1 = paramFile2.getAbsolutePath();
      boolean bool = paramFile2.exists();
      a("copySoToFilesDir: srcPath=" + str3 + " dstPath=" + str1 + " dstExists=" + bool, null);
      if (bool)
      {
        String str2 = bcfk.a(str3);
        a("copySoToFilesDir:[destFile exists] srcMd5=" + str2 + " srcPath=" + str3, null);
        str3 = bcfk.a(str1);
        a("copySoToFilesDir:[destFile exists] dstMd5=" + str3 + " dstPath=" + str1, null);
        if ((str2 != null) && (!"".equals(str2)) && (str2.equalsIgnoreCase(str3))) {
          return true;
        }
        paramFile2.delete();
      }
      l1 = paramFile1.length();
      bgmg.b(paramFile1, paramFile2);
      l2 = paramFile2.length();
      a("copySoToFilesDir: soSize=" + l1 + " deSize=" + l2, null);
    } while (l1 != l2);
    return true;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool3 = bcfk.a(paramString2);
    a(paramString1 + " saveSuccess=" + bool3, null);
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool3 = bcfk.a(paramString2);
      a(paramString1 + " saveSuccessTwo=" + bool3, null);
      bool1 = bool2;
      if (!bool3)
      {
        bool1 = true;
        bool2 = bcfk.a("d000_1");
        a("VideoEnvironment", paramString1 + "clearMemoryOK=" + bool2 + ",signature=" + paramString2, null);
      }
    }
    return bool1;
  }
  
  public static int[] a(int paramInt)
  {
    localObject4 = jdField_c_of_type_JavaLangObject;
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        localObject1 = bcgx.jdField_d_of_type_ArrayOfInt;
        localObject3 = localObject1;
        if (localObject1.length != bcgx.jdField_d_of_type_ArrayOfInt.length) {
          localObject3 = bcgx.jdField_d_of_type_ArrayOfInt;
        }
        return localObject3;
      }
      finally {}
      Object localObject3 = jdField_a_of_type_Bcge.jdField_f_of_type_ArrayOfInt;
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = bcgx.jdField_f_of_type_ArrayOfInt;
        continue;
        localObject3 = jdField_a_of_type_Bcge.jdField_g_of_type_ArrayOfInt;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = bcgx.jdField_e_of_type_ArrayOfInt;
          continue;
          localObject3 = jdField_a_of_type_Bcge.jdField_e_of_type_ArrayOfInt;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = bcgx.jdField_d_of_type_ArrayOfInt;
          }
        }
      }
    }
  }
  
  public static int[] a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    int i = -1;
    int k = -1;
    int m = k;
    int j = i;
    int[] arrayOfInt;
    if (jdField_a_of_type_Int != -1) {
      arrayOfInt = new int[4];
    }
    for (;;)
    {
      synchronized (jdField_c_of_type_JavaLangObject)
      {
        if ((jdField_a_of_type_Bcge.jdField_a_of_type_ArrayOfInt == null) || (jdField_a_of_type_Bcge.jdField_b_of_type_ArrayOfInt == null) || (jdField_a_of_type_Bcge.jdField_c_of_type_ArrayOfInt == null) || (jdField_a_of_type_Bcge.jdField_d_of_type_ArrayOfInt == null)) {
          return null;
        }
        if (jdField_a_of_type_Bcge.jdField_a_of_type_Boolean)
        {
          arrayOfInt[0] = jdField_a_of_type_Bcge.jdField_d_of_type_Int;
          arrayOfInt[1] = jdField_a_of_type_Bcge.jdField_e_of_type_Int;
          arrayOfInt[2] = jdField_a_of_type_Bcge.jdField_c_of_type_ArrayOfInt[1];
          arrayOfInt[3] = jdField_a_of_type_Bcge.jdField_d_of_type_ArrayOfInt[1];
          i = jdField_a_of_type_Bcge.jdField_d_of_type_Int;
          paramInt = jdField_a_of_type_Bcge.jdField_e_of_type_Int;
          localObject1 = arrayOfInt;
          j = i;
          m = paramInt;
          alkm.jdField_a_of_type_JavaLangString = j + "*" + m;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label675;
          }
          QLog.d("DynamicAdjustment", 2, "预览分辨率 : " + localObject1[0] + " * " + localObject1[1]);
          return localObject1;
        }
        if ((jdField_a_of_type_Bcge.jdField_a_of_type_ArrayOfInt != null) && (jdField_a_of_type_Bcge.jdField_b_of_type_ArrayOfInt != null))
        {
          if (!jdField_a_of_type_Bcge.jdField_b_of_type_Boolean) {
            break label678;
          }
          if (paramBoolean)
          {
            break label678;
            label274:
            i = jdField_a_of_type_Bcge.jdField_a_of_type_ArrayOfInt[paramInt];
            j = jdField_a_of_type_Bcge.jdField_b_of_type_ArrayOfInt[paramInt];
            if (jdField_a_of_type_Bcge.jdField_d_of_type_Boolean)
            {
              if (QLog.isColorLevel()) {
                QLog.d("VideoEnvironment", 2, "dynamic adjust is enable");
              }
              k = paramInt;
            }
          }
        }
      }
      for (;;)
      {
        allk localallk;
        try
        {
          localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4).getString("SVDNAdjustment_quality_resolution", null);
          k = paramInt;
          localallk = allk.a((String)localObject1);
          k = paramInt;
          paramInt = 0;
          if (localallk == null) {
            break label717;
          }
        }
        catch (NumberFormatException localNumberFormatException1) {}
        try
        {
          if (paramInt >= jdField_a_of_type_Bcge.jdField_a_of_type_ArrayOfInt.length) {
            break label717;
          }
          m = k;
          if (jdField_a_of_type_Bcge.jdField_a_of_type_ArrayOfInt[paramInt] == localallk.jdField_a_of_type_Int)
          {
            int n = jdField_a_of_type_Bcge.jdField_b_of_type_ArrayOfInt[paramInt];
            int i1 = localallk.jdField_b_of_type_Int;
            m = k;
            if (n == i1)
            {
              k = paramInt;
              QLog.d("DynamicAdjustment", 2, "应用动态调整分辨率" + (String)localObject1);
              m = paramInt;
            }
          }
          paramInt += 1;
          k = m;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          break label560;
          k = j;
          j = paramInt;
          paramInt = k;
        }
      }
      paramInt = jdField_a_of_type_Bcge.q;
      continue;
      paramInt = jdField_a_of_type_Bcge.r;
      continue;
      paramInt = jdField_a_of_type_Bcge.p;
    }
    for (;;)
    {
      arrayOfInt[0] = jdField_a_of_type_Bcge.jdField_a_of_type_ArrayOfInt[j];
      arrayOfInt[1] = jdField_a_of_type_Bcge.jdField_b_of_type_ArrayOfInt[j];
      arrayOfInt[2] = jdField_a_of_type_Bcge.jdField_c_of_type_ArrayOfInt[j];
      arrayOfInt[3] = jdField_a_of_type_Bcge.jdField_d_of_type_ArrayOfInt[j];
      localObject1 = arrayOfInt;
      break;
      localObject2 = finally;
      throw localObject2;
      label560:
      if (QLog.isColorLevel())
      {
        QLog.e("VideoEnvironment", 2, "parseSize(): " + localNumberFormatException1.getMessage());
        break label725;
        if (QLog.isColorLevel())
        {
          QLog.d("VideoEnvironment", 2, "dynamic adjust is disable");
          k = j;
          j = paramInt;
          paramInt = k;
          continue;
          i = jdField_a_of_type_Bcge.jdField_a_of_type_ArrayOfInt[0];
          paramInt = jdField_a_of_type_Bcge.jdField_b_of_type_ArrayOfInt[0];
          j = 0;
          continue;
          Object localObject3 = null;
          paramInt = k;
          break;
        }
        return localNumberFormatException2;
        switch (paramInt)
        {
        }
        paramInt = 1;
        break label274;
        label717:
        paramInt = j;
        j = k;
        continue;
      }
      label675:
      label678:
      label725:
      paramInt = j;
      j = k;
    }
  }
  
  public static int b()
  {
    try
    {
      if (!jdField_c_of_type_Boolean)
      {
        getAVCodecLibMetadata(jdField_b_of_type_ArrayOfInt);
        jdField_c_of_type_Boolean = true;
      }
      i = jdField_b_of_type_ArrayOfInt[0];
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoEnvironment", 2, "getAVCodecVersion: AVCodec_version=" + i);
    }
    return i;
  }
  
  public static void b()
  {
    bcjb.r = 450000;
    bcjb.s = 100000;
    bcjb.t = 38;
    bcjb.u = 3;
    bcjb.v = 5;
  }
  
  public static void b(int paramInt)
  {
    if (jdField_a_of_type_Int != -1) {
      synchronized (jdField_c_of_type_JavaLangObject)
      {
        bcgd localbcgd = (bcgd)jdField_a_of_type_Bcge.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (localbcgd != null)
        {
          bcjb.t = localbcgd.jdField_b_of_type_Int;
          bcjb.u = localbcgd.jdField_c_of_type_Int;
          bcjb.v = localbcgd.jdField_d_of_type_Int;
          bcjb.r = jdField_a_of_type_Bcge.jdField_f_of_type_Int;
          bcjb.s = jdField_a_of_type_Bcge.jdField_g_of_type_Int;
          bcjb.w = jdField_a_of_type_Bcge.k;
          bcjb.x = jdField_a_of_type_Bcge.l;
          jdField_a_of_type_Int |= 0x2;
          return;
        }
        bcjb.t = jdField_a_of_type_Bcge.h;
        bcjb.u = jdField_a_of_type_Bcge.i;
        bcjb.v = jdField_a_of_type_Bcge.j;
      }
    }
  }
  
  public static boolean b()
  {
    if (c()) {}
    while (!a(6, 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean b(int paramInt)
  {
    return a(paramInt) > 0;
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    return (VersionUtils.isIceScreamSandwich()) && (c(paramAppInterface));
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramString = new File(paramString + "config_version");
    if (!paramString.exists()) {}
    do
    {
      do
      {
        String str;
        do
        {
          do
          {
            return false;
            paramString = bcfk.a(paramString);
          } while (TextUtils.isEmpty(paramString));
          paramString = paramString.trim();
          str = a();
        } while ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(paramString)));
        paramString = bcfk.a(str);
      } while (paramString.a() != 0);
      paramString = paramString.b().trim();
    } while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase("" + paramInt)));
    return e(paramQQAppInterface);
  }
  
  private static boolean b(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < d.length)
      {
        if (paramString.equals(d[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static int c()
  {
    String str = ShortVideoSoLoad.getShortVideoSoPath(a());
    String[] arrayOfString = new String[1];
    int i = a(arrayOfString);
    if (i == 255)
    {
      str = str + arrayOfString[0];
      a("Before LoadPath so. loadSoPath=" + str + "  soNameValue[0]=" + arrayOfString[0], null);
      i = ShortVideoSoLoad.LoadExtractedShortVideo(str);
      a("After LoadPath so. errCode=" + i, null);
      return i;
    }
    a("realDoLoadSo[errcode=" + i + "]");
    return i;
  }
  
  public static void c()
  {
    ShortVideoSoLoad.setShortVideoSoLoadStatus(-4);
  }
  
  public static void c(int paramInt)
  {
    if (jdField_a_of_type_Int != -1) {
      synchronized (jdField_c_of_type_JavaLangObject)
      {
        bcgd localbcgd = (bcgd)jdField_a_of_type_Bcge.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (localbcgd != null)
        {
          bcjb.jdField_c_of_type_Int = localbcgd.jdField_a_of_type_Int;
          jdField_a_of_type_Int |= 0x4;
          return;
        }
        if (jdField_a_of_type_Bcge.jdField_c_of_type_Int > 600) {
          jdField_a_of_type_Bcge.jdField_c_of_type_Int = 8;
        }
        bcjb.jdField_c_of_type_Int = jdField_a_of_type_Bcge.jdField_c_of_type_Int * 1000;
      }
    }
  }
  
  public static boolean c()
  {
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "isX86Platform: Build.CPU_ABI=" + str1 + " Build.CPU_ABI2=" + str2);
    }
    if ((str1 != null) && (!"".equals(str1)) && ("x86".equalsIgnoreCase(str1))) {}
    do
    {
      return true;
      if (lkw.f() != 7) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoEnvironment", 2, "isX86Platform: VcSystemInfo.getCpuArchitecture()=x86");
    return true;
    return false;
  }
  
  /* Error */
  public static boolean c(AppInterface arg0)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: getstatic 868	com/tencent/mobileqq/shortvideo/ShortVideoUtils:jdField_b_of_type_Boolean	Z
    //   9: ifne +11 -> 20
    //   12: getstatic 868	com/tencent/mobileqq/shortvideo/ShortVideoUtils:jdField_b_of_type_Boolean	Z
    //   15: istore 4
    //   17: iload 4
    //   19: ireturn
    //   20: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +44 -> 67
    //   26: ldc_w 281
    //   29: iconst_2
    //   30: new 43	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 870
    //   40: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: getstatic 875	android/os/Build$VERSION:SDK_INT	I
    //   46: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 877
    //   52: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: getstatic 528	android/os/Build:MODEL	Ljava/lang/String;
    //   58: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: iload 6
    //   69: istore 4
    //   71: getstatic 875	android/os/Build$VERSION:SDK_INT	I
    //   74: bipush 10
    //   76: if_icmplt -59 -> 17
    //   79: getstatic 119	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_Int	I
    //   82: iconst_m1
    //   83: if_icmpne +89 -> 172
    //   86: aload_0
    //   87: aconst_null
    //   88: iconst_0
    //   89: invokestatic 879	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Z)V
    //   92: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +77 -> 172
    //   98: ldc_w 281
    //   101: iconst_2
    //   102: ldc_w 881
    //   105: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: ldc_w 281
    //   111: iconst_2
    //   112: new 43	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 883
    //   122: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: getstatic 124	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_Bcge	Lbcge;
    //   128: getfield 472	bcge:m	I
    //   131: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: ldc_w 281
    //   143: iconst_2
    //   144: new 43	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 885
    //   154: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: getstatic 124	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_Bcge	Lbcge;
    //   160: getfield 475	bcge:n	I
    //   163: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: getstatic 126	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_c_of_type_JavaLangObject	Ljava/lang/Object;
    //   175: astore_0
    //   176: aload_0
    //   177: monitorenter
    //   178: getstatic 124	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_Bcge	Lbcge;
    //   181: getfield 478	bcge:o	I
    //   184: istore_1
    //   185: getstatic 124	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_Bcge	Lbcge;
    //   188: getfield 472	bcge:m	I
    //   191: istore_2
    //   192: getstatic 124	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_Bcge	Lbcge;
    //   195: getfield 475	bcge:n	I
    //   198: istore_3
    //   199: getstatic 124	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_Bcge	Lbcge;
    //   202: getfield 545	bcge:jdField_c_of_type_Boolean	Z
    //   205: istore 7
    //   207: aload_0
    //   208: monitorexit
    //   209: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +95 -> 307
    //   215: ldc_w 281
    //   218: iconst_2
    //   219: new 43	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 887
    //   229: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload_1
    //   233: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: ldc_w 281
    //   245: iconst_2
    //   246: new 43	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   253: ldc_w 889
    //   256: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: iload_2
    //   260: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   263: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: ldc_w 281
    //   272: iconst_2
    //   273: new 43	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 891
    //   283: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload_3
    //   287: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: ldc_w 893
    //   293: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: iload 7
    //   298: invokevirtual 307	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   301: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: iload 7
    //   309: ifeq +69 -> 378
    //   312: iload 6
    //   314: istore 4
    //   316: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq -302 -> 17
    //   322: ldc_w 281
    //   325: iconst_2
    //   326: new 43	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   333: ldc_w 895
    //   336: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload 7
    //   341: invokevirtual 307	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   344: ldc_w 877
    //   347: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: getstatic 528	android/os/Build:MODEL	Ljava/lang/String;
    //   353: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: iconst_0
    //   363: ireturn
    //   364: astore_0
    //   365: aload_0
    //   366: invokevirtual 896	java/lang/Throwable:printStackTrace	()V
    //   369: iconst_0
    //   370: ireturn
    //   371: astore 8
    //   373: aload_0
    //   374: monitorexit
    //   375: aload 8
    //   377: athrow
    //   378: getstatic 850	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   381: astore_0
    //   382: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +30 -> 415
    //   388: ldc_w 281
    //   391: iconst_2
    //   392: new 43	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 898
    //   402: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_0
    //   406: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: invokestatic 612	com/tencent/mobileqq/shortvideo/VideoEnvironment:c	()Z
    //   418: ifeq +49 -> 467
    //   421: getstatic 899	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_b_of_type_Boolean	Z
    //   424: istore 5
    //   426: iload 5
    //   428: istore 4
    //   430: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq -416 -> 17
    //   436: ldc_w 281
    //   439: iconst_2
    //   440: new 43	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   447: ldc_w 901
    //   450: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: iload 5
    //   455: invokevirtual 307	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   458: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: iload 5
    //   466: ireturn
    //   467: iload_1
    //   468: iconst_1
    //   469: if_icmpne +78 -> 547
    //   472: aload_0
    //   473: ifnull +118 -> 591
    //   476: ldc_w 491
    //   479: aload_0
    //   480: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   483: ifne +108 -> 591
    //   486: ldc_w 903
    //   489: aload_0
    //   490: invokevirtual 683	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   493: ifeq +98 -> 591
    //   496: iload 5
    //   498: istore 4
    //   500: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +41 -> 544
    //   506: ldc_w 281
    //   509: iconst_2
    //   510: new 43	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   517: ldc_w 905
    //   520: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload_0
    //   524: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 907
    //   530: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: iload 4
    //   535: invokevirtual 307	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   538: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: iload 4
    //   546: ireturn
    //   547: iload 5
    //   549: istore 4
    //   551: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq -54 -> 500
    //   557: ldc_w 281
    //   560: iconst_2
    //   561: new 43	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   568: ldc_w 909
    //   571: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: iconst_1
    //   575: invokevirtual 307	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   578: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: iload 5
    //   586: istore 4
    //   588: goto -88 -> 500
    //   591: iconst_0
    //   592: istore 4
    //   594: goto -94 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   184	286	1	i	int
    //   191	69	2	j	int
    //   198	89	3	k	int
    //   15	578	4	bool1	boolean
    //   1	584	5	bool2	boolean
    //   4	309	6	bool3	boolean
    //   205	135	7	bool4	boolean
    //   371	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   86	92	364	java/lang/Throwable
    //   178	209	371	finally
    //   373	375	371	finally
  }
  
  private static boolean c(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String str = Build.MODEL.toLowerCase();
      paramString = paramString.split("\\;");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          if (paramString[i].equalsIgnoreCase(str)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private static int d()
  {
    int j = ShortVideoSoLoad.getShortVideoSoLoadStatus();
    Object localObject1 = jdField_a_of_type_JavaLangObject;
    int i = j;
    if (j != 0) {}
    try
    {
      a("loadAVCodecPreDownload[realDoLoadSo begin] loadcode=" + j, null);
      i = c();
      a("loadAVCodecPreDownload[realDoLoadSo end]loadcode=" + i, null);
      a("loadAVCodecPreDownload[After realDoLoadSo]...", null);
      a("loadAVCodecPreDownload[loadcode=" + i + "]");
      a("loadAVCodecPreDownload[End all] loadcode=" + i, null);
      return i;
    }
    finally {}
  }
  
  private static String d()
  {
    return bcfk.a("HookTestAVCodec001", "65");
  }
  
  private static void d()
  {
    ThreadManager.post(new VideoEnvironment.1(), 5, null, false);
  }
  
  public static void d(int paramInt)
  {
    Object localObject1;
    if (jdField_a_of_type_Int != -1)
    {
      localObject1 = jdField_c_of_type_JavaLangObject;
      if (paramInt > 0) {}
      for (;;)
      {
        try
        {
          bcjb.jdField_c_of_type_Int = paramInt * 1000;
          jdField_a_of_type_Bcge.jdField_c_of_type_Int = paramInt;
          jdField_a_of_type_Int |= 0x4;
          return;
        }
        finally {}
        jdField_a_of_type_Bcge.jdField_c_of_type_Int = 8;
        bcjb.jdField_c_of_type_Int = jdField_a_of_type_Bcge.jdField_c_of_type_Int * 1000;
      }
    }
  }
  
  public static boolean d()
  {
    int i = b();
    boolean bool = b(2);
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "supportSubmitCallback: soVersion =" + i + ", result = " + bool);
    }
    return bool;
  }
  
  public static boolean d(AppInterface paramAppInterface)
  {
    return c(paramAppInterface);
  }
  
  private static String e()
  {
    return bcfk.a("HookTestAVCodecSdcard002", "65");
  }
  
  private static void e()
  {
    Object localObject1 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplicationImpl.getContext());
    Object localObject2 = (String)localObject1 + jdField_b_of_type_JavaLangString;
    File localFile1 = new File((String)localObject2 + "trim_process_pie");
    File localFile2 = new File((String)localObject1 + "trim_process_pie");
    boolean bool = localFile1.exists();
    a("copyPieAndPicFile:[VIDEO_TRIM_PIE]unzipExists=" + bool, null);
    if (bool) {
      a(localFile1, localFile2);
    }
    localObject2 = new File((String)localObject2 + "trim_process_pic");
    localObject1 = new File((String)localObject1 + "trim_process_pic");
    bool = ((File)localObject2).exists();
    a("copyPieAndPicFile:[VIDEO_TRIM_PIC]unzipExists=" + bool, null);
    if (bool) {
      a((File)localObject2, (File)localObject1);
    }
  }
  
  public static boolean e()
  {
    return ShortVideoSoLoad.getShortVideoSoLoadStatus() == 0;
  }
  
  public static boolean e(AppInterface paramAppInterface)
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(paramAppInterface);
    } while (ShortVideoUtils.a());
    return false;
  }
  
  public static boolean f()
  {
    return a(1) > 0;
  }
  
  private static boolean g()
  {
    return bcif.a(bcif.n);
  }
  
  private static native void getAVCodecLibMetadata(int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoEnvironment
 * JD-Core Version:    0.7.0.1
 */