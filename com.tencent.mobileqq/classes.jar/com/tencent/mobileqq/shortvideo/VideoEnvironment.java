package com.tencent.mobileqq.shortvideo;

import ahly;
import ahlz;
import ahmc;
import ahmd;
import ahme;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.util.ArrayList;

public class VideoEnvironment
{
  public static int a;
  public static Handler a;
  public static VideoEnvironment.ShortVideoConfig a;
  private static Object jdField_a_of_type_JavaLangObject;
  private static final String jdField_a_of_type_JavaLangString;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
  public static boolean a;
  public static final int[] a;
  public static final String[] a;
  private static Object jdField_b_of_type_JavaLangObject;
  public static boolean b;
  private static int[] jdField_b_of_type_ArrayOfInt = new int[16];
  public static final String[] b;
  private static Object jdField_c_of_type_JavaLangObject;
  private static boolean jdField_c_of_type_Boolean;
  public static final String[] c;
  private static boolean jdField_d_of_type_Boolean;
  private static final String[] jdField_d_of_type_ArrayOfJavaLangString;
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    File localFile = new File(ShortVideoSoLoad.getShortVideoSoPath(a()));
    if (!localFile.exists())
    {
      localFile.mkdirs();
      a("VideoEnvironment:[static]loadPathFile not exist...", null);
    }
    jdField_d_of_type_ArrayOfJavaLangString = new String[] { "backup", "trim_process_pic", "trim_process_pie" };
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaLangString = "backup" + File.separatorChar;
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig = new VideoEnvironment.ShortVideoConfig();
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
      if (!jdField_d_of_type_Boolean)
      {
        getAVCodecLibMetadata(jdField_b_of_type_ArrayOfInt);
        jdField_d_of_type_Boolean = true;
      }
      paramInt = jdField_b_of_type_ArrayOfInt[paramInt];
      return paramInt;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return 0;
  }
  
  public static int a(String arg0, Context paramContext)
  {
    int i = ShortVideoSoLoad.getShortVideoSoLoadStatus();
    if (i == 0)
    {
      a("loadAVCodecSo[already loaded],staus=" + i, null);
      return i;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      i = c();
      a("loadAVCodecSo[loaded End],loadcode=" + i, null);
      return i;
    }
  }
  
  public static int a(String paramString, Context paramContext, boolean paramBoolean)
  {
    return a(paramString, paramContext);
  }
  
  private static int a(String[] paramArrayOfString)
  {
    String str = ahly.a();
    a("LoadPathso: currentSoName=" + str, null);
    if (str.equals("d000_1")) {
      return -11;
    }
    Object localObject = ahly.a(str);
    int i = ((ahlz)localObject).a();
    a("LoadPathso: CfgParser err=" + i, null);
    if (i == 0)
    {
      localObject = ((ahlz)localObject).b();
      a("LoadPathso: currentVersion=" + (String)localObject + " dymAVCodecVersion=" + 56, null);
      if (Integer.parseInt((String)localObject) >= 56)
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
    jdField_c_of_type_Boolean = true;
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
        VideoEnvironment.ShortVideoDownload localShortVideoDownload = (VideoEnvironment.ShortVideoDownload)localObject[i];
        jdField_a_of_type_AndroidOsHandler.post(new ahmd(localShortVideoDownload, paramInt));
        i += 1;
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject = ShortVideoSoLoad.getShortVideoSoPath(a());
    localObject = new File((String)localObject + jdField_a_of_type_JavaLangString);
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
    PtvFilterSoLoad.b();
    a("initBuiltInDoCopyEnvStep:[end]...", null);
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      CodecParam.r = paramInt * 1000;
    }
    for (CodecParam.r += 100000;; CodecParam.r += 350000)
    {
      CodecParam.s *= 4;
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
    VideoEnvironment.ShortVideoConfig localShortVideoConfig = new VideoEnvironment.ShortVideoConfig();
    try
    {
      paramAppInterface = paramString.split(",");
      if ((paramAppInterface == null) || (paramAppInterface.length == 0))
      {
        if (!QLog.isColorLevel()) {
          break label1715;
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
          break label1715;
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
    label611:
    Object localObject2;
    label831:
    label1011:
    label1141:
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "initConfig(): time cost " + (l2 - l1) + "ms");
      }
      a(localShortVideoConfig);
      return;
      paramAppInterface = paramString[3].split("\\*");
      if ((paramAppInterface == null) || (paramAppInterface.length != 2))
      {
        if (!QLog.isColorLevel()) {
          break label1715;
        }
        QLog.d("VideoEnvironment", 2, "initConfig(): resolution is null or length is not 2");
        return;
      }
      localShortVideoConfig.jdField_a_of_type_Int = 0;
      localShortVideoConfig.jdField_d_of_type_Int = Integer.valueOf(paramAppInterface[0]).intValue();
      localShortVideoConfig.jdField_e_of_type_Int = Integer.valueOf(paramAppInterface[1]).intValue();
      localShortVideoConfig.jdField_b_of_type_Int = Integer.valueOf(paramString[0]).intValue();
      localShortVideoConfig.jdField_c_of_type_Int = Integer.valueOf(paramString[1]).intValue();
      localShortVideoConfig.l = Integer.valueOf(paramString[2]).intValue();
      localShortVideoConfig.jdField_f_of_type_Int = Integer.valueOf(paramString[4]).intValue();
      localShortVideoConfig.jdField_g_of_type_Int = Integer.valueOf(paramString[5]).intValue();
      localShortVideoConfig.i = Integer.valueOf(paramString[6]).intValue();
      localShortVideoConfig.h = Integer.valueOf(paramString[7]).intValue();
      localShortVideoConfig.j = Integer.valueOf(paramString[8]).intValue();
      localShortVideoConfig.k = Integer.valueOf(paramString[9]).intValue();
      localShortVideoConfig.m = Integer.valueOf(paramString[10]).intValue();
      localShortVideoConfig.n = Integer.valueOf(paramString[11]).intValue();
      localShortVideoConfig.o = Integer.valueOf(paramString[12]).intValue();
      if (paramString.length < 17)
      {
        i = 1;
        paramAppInterface = null;
        if (i == 0) {
          break label1011;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoEnvironment", 2, "initConfig(): (resolutions == null) || (resolutions.length == 0) || (indexs.length != 3)");
        }
        localShortVideoConfig.jdField_a_of_type_ArrayOfInt = new int[] { localShortVideoConfig.jdField_d_of_type_Int };
        localShortVideoConfig.jdField_b_of_type_ArrayOfInt = new int[] { localShortVideoConfig.jdField_e_of_type_Int };
        localShortVideoConfig.p = 0;
        localShortVideoConfig.q = 0;
      }
      for (localShortVideoConfig.r = 0;; localShortVideoConfig.r = i)
      {
        if (paramString.length <= 25) {
          break label1141;
        }
        paramAppInterface = a(paramString[17], "").split(";");
        localShortVideoConfig.jdField_e_of_type_ArrayOfInt = new int[paramAppInterface.length];
        i = 0;
        while (i < paramAppInterface.length)
        {
          localObject1 = paramAppInterface[i];
          localShortVideoConfig.jdField_e_of_type_ArrayOfInt[i] = Integer.valueOf((String)localObject1).intValue();
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
          break label1716;
        }
        localShortVideoConfig.jdField_a_of_type_ArrayOfInt = new int[paramAppInterface.length];
        localShortVideoConfig.jdField_b_of_type_ArrayOfInt = new int[paramAppInterface.length];
        localShortVideoConfig.jdField_c_of_type_ArrayOfInt = new int[paramAppInterface.length];
        localShortVideoConfig.jdField_d_of_type_ArrayOfInt = new int[paramAppInterface.length];
        i = 0;
        if (i >= paramAppInterface.length) {
          break label1710;
        }
        localObject1 = paramAppInterface[i].split("#");
        if ((localObject1 == null) || (localObject1.length < 3)) {
          break label1721;
        }
        localObject2 = localObject1[0].split("\\*");
        if ((localObject2 == null) || (localObject2.length != 2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoEnvironment", 2, "initConfig(): res is null or length is not 2");
          }
          localShortVideoConfig.jdField_a_of_type_ArrayOfInt[i] = localShortVideoConfig.jdField_d_of_type_Int;
          localShortVideoConfig.jdField_b_of_type_ArrayOfInt[i] = localShortVideoConfig.jdField_e_of_type_Int;
        }
        while ((localObject1[1] != null) && (localObject1[2] != null))
        {
          localShortVideoConfig.jdField_c_of_type_ArrayOfInt[i] = Integer.valueOf(localObject1[1]).intValue();
          localShortVideoConfig.jdField_d_of_type_ArrayOfInt[i] = Integer.valueOf(localObject1[2]).intValue();
          break;
          localShortVideoConfig.jdField_a_of_type_ArrayOfInt[i] = Integer.valueOf(localObject2[0]).intValue();
          localShortVideoConfig.jdField_b_of_type_ArrayOfInt[i] = Integer.valueOf(localObject2[1]).intValue();
        }
        localShortVideoConfig.p = Integer.valueOf(a(paramString[14], "0")).intValue();
        localShortVideoConfig.q = Integer.valueOf(a(paramString[15], "0")).intValue();
        localShortVideoConfig.r = Integer.valueOf(a(paramString[16], "0")).intValue();
        if (localShortVideoConfig.p >= paramAppInterface.length) {
          break label1728;
        }
        i = localShortVideoConfig.p;
        localShortVideoConfig.p = i;
        if (localShortVideoConfig.q >= paramAppInterface.length) {
          break label1733;
        }
        i = localShortVideoConfig.q;
        localShortVideoConfig.q = i;
        if (localShortVideoConfig.r >= paramAppInterface.length) {
          break label1738;
        }
        i = localShortVideoConfig.r;
      }
    }
    label1090:
    label1112:
    label1134:
    paramAppInterface = a(paramString[18], "").split(";");
    localShortVideoConfig.jdField_f_of_type_ArrayOfInt = new int[paramAppInterface.length];
    int i = 0;
    while (i < paramAppInterface.length)
    {
      localObject1 = paramAppInterface[i];
      localShortVideoConfig.jdField_f_of_type_ArrayOfInt[i] = Integer.valueOf((String)localObject1).intValue();
      i += 1;
    }
    Object localObject1 = a(paramString[19], "").split(";");
    localShortVideoConfig.jdField_g_of_type_ArrayOfInt = new int[paramAppInterface.length];
    i = 0;
    while (i < localObject1.length)
    {
      paramAppInterface = localObject1[i];
      localShortVideoConfig.jdField_g_of_type_ArrayOfInt[i] = Integer.valueOf(paramAppInterface).intValue();
      i += 1;
    }
    paramAppInterface = a(paramString[20], "").split(";");
    if ((paramAppInterface != null) && (paramAppInterface.length == 2))
    {
      localShortVideoConfig.s = Integer.valueOf(paramAppInterface[0]).intValue();
      localShortVideoConfig.t = Integer.valueOf(paramAppInterface[1]).intValue();
    }
    localShortVideoConfig.jdField_b_of_type_Boolean = a(paramString[21], "").toLowerCase().contains(Build.MODEL.toLowerCase());
    if (!CameraCompatibleList.d(CameraCompatibleList.i)) {
      if (!CameraCompatibleList.b(CameraCompatibleList.G)) {
        break label1755;
      }
    }
    for (;;)
    {
      label1369:
      localShortVideoConfig.jdField_c_of_type_Boolean = paramBoolean;
      if (!localShortVideoConfig.jdField_c_of_type_Boolean) {
        localShortVideoConfig.jdField_c_of_type_Boolean = c(a(paramString[22], ""));
      }
      localShortVideoConfig.jdField_a_of_type_Boolean = a(paramString[23], "").equals("1");
      paramAppInterface = a(paramString[24], "").split(";");
      if ((paramAppInterface != null) && (paramAppInterface.length == 2))
      {
        localShortVideoConfig.u = Integer.valueOf(paramAppInterface[0]).intValue();
        localShortVideoConfig.v = Integer.valueOf(paramAppInterface[1]).intValue();
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
              break label1748;
            }
            int j = Integer.valueOf(localObject1[0]).intValue();
            localObject2 = new VideoEnvironment.SVFileSizeCtrlFactor();
            ((VideoEnvironment.SVFileSizeCtrlFactor)localObject2).jdField_a_of_type_Int = Integer.valueOf(localObject1[1]).intValue();
            ((VideoEnvironment.SVFileSizeCtrlFactor)localObject2).jdField_c_of_type_Int = Integer.valueOf(localObject1[2]).intValue();
            ((VideoEnvironment.SVFileSizeCtrlFactor)localObject2).jdField_d_of_type_Int = Integer.valueOf(localObject1[3]).intValue();
            ((VideoEnvironment.SVFileSizeCtrlFactor)localObject2).jdField_b_of_type_Int = Integer.valueOf(localObject1[4]).intValue();
            localShortVideoConfig.jdField_a_of_type_AndroidUtilSparseArray.put(j, localObject2);
            break label1748;
          }
          i = paramString.length;
          if (i > 26) {}
          try
          {
            localShortVideoConfig.jdField_a_of_type_Float = Float.parseFloat(paramString[26]);
            if ((localShortVideoConfig.jdField_a_of_type_Float < 0.0F) || (localShortVideoConfig.jdField_a_of_type_Float > 1.0F)) {
              localShortVideoConfig.jdField_a_of_type_Float = 1.0F;
            }
            if (paramString.length <= 27) {
              break;
            }
            localShortVideoConfig.jdField_d_of_type_Boolean = a(paramString[27], "0").equals("1");
          }
          catch (NumberFormatException paramAppInterface)
          {
            for (;;)
            {
              paramAppInterface.printStackTrace();
            }
          }
        }
        label1710:
        i = 0;
        break label611;
        label1715:
        return;
        label1716:
        i = 1;
        break label611;
        label1721:
        i += 1;
        break label831;
        label1728:
        i = 0;
        break label1090;
        label1733:
        i = 0;
        break label1112;
        label1738:
        i = 0;
        break label1134;
        paramBoolean = true;
        break label1369;
        label1748:
        i += 1;
      }
      label1755:
      paramBoolean = false;
    }
  }
  
  public static void a(VideoEnvironment.ShortVideoConfig paramShortVideoConfig)
  {
    synchronized (jdField_c_of_type_JavaLangObject)
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig = paramShortVideoConfig;
      jdField_a_of_type_Int = 0;
      return;
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
        VideoEnvironment.ShortVideoDownload localShortVideoDownload = (VideoEnvironment.ShortVideoDownload)paramAppInterface[i];
        jdField_a_of_type_AndroidOsHandler.post(new ahme(localShortVideoDownload, paramBoolean));
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
      bool1 = VcSystemInfo.e();
      bool2 = f();
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "isX86Platform: isBeautySupported=" + bool1 + " isSoSupportBeauty=" + bool2);
      }
    } while ((!bool1) || (!bool2));
    return true;
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt > 56) {}
    while (paramInt == 56) {
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
    return (VersionUtils.d()) && (c(paramAppInterface)) && (!g());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2 = false;
    String str1 = ShortVideoSoLoad.getShortVideoSoPath(a());
    Object localObject2 = str1 + jdField_a_of_type_JavaLangString;
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
            FileUtils.a(paramString, (String)localObject2, false);
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
    localObject2 = ahly.a(ahly.a(paramString));
    paramInt = ((ahlz)localObject2).a();
    if (paramInt != 0)
    {
      a("VideoEnvironment:[uncompressZipSo][createParser] errorCodec=" + paramInt, null);
      throw new RuntimeException("createParser err=" + paramInt);
    }
    Object localObject3 = ahly.a(paramQQAppInterface);
    paramString = ((ahlz)localObject2).a();
    a("VideoEnvironment:[uncompressZipSo][Md5] md5Cfg=" + paramString + " md5Cmp=" + (String)localObject3, null);
    if (!paramString.equalsIgnoreCase((String)localObject3)) {
      throw new RuntimeException("[Md5 error] md5Cfg=" + paramString + " md5Cmp=" + (String)localObject3);
    }
    long l1 = localFile.length();
    localObject3 = ((ahlz)localObject2).b().trim();
    localObject2 = ahly.a(paramString, (String)localObject3);
    a("VideoEnvironment:[uncompressZipSo][trim] versionvalid=" + (String)localObject3 + " soNewName=" + (String)localObject2, null);
    str1 = str1 + (String)localObject2;
    localObject3 = new File(str1);
    paramInt = 0;
    long l2;
    String str2;
    if (((File)localObject3).exists())
    {
      l2 = ((File)localObject3).length();
      str2 = ahly.a(str1);
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
        f();
        e();
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
        String str2 = ahly.a(str3);
        a("copySoToFilesDir:[destFile exists] srcMd5=" + str2 + " srcPath=" + str3, null);
        str3 = ahly.a(str1);
        a("copySoToFilesDir:[destFile exists] dstMd5=" + str3 + " dstPath=" + str1, null);
        if ((str2 != null) && (!"".equals(str2)) && (str2.equalsIgnoreCase(str3))) {
          return true;
        }
        paramFile2.delete();
      }
      l1 = paramFile1.length();
      FileUtils.b(paramFile1, paramFile2);
      l2 = paramFile2.length();
      a("copySoToFilesDir: soSize=" + l1 + " deSize=" + l2, null);
    } while (l1 != l2);
    return true;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool3 = ahly.a(paramString2);
    a(paramString1 + " saveSuccess=" + bool3, null);
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool3 = ahly.a(paramString2);
      a(paramString1 + " saveSuccessTwo=" + bool3, null);
      bool1 = bool2;
      if (!bool3)
      {
        bool1 = true;
        bool2 = ahly.a("d000_1");
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
        localObject1 = GloableValue.jdField_d_of_type_ArrayOfInt;
        localObject3 = localObject1;
        if (localObject1.length != GloableValue.jdField_d_of_type_ArrayOfInt.length) {
          localObject3 = GloableValue.jdField_d_of_type_ArrayOfInt;
        }
        return localObject3;
      }
      finally {}
      Object localObject3 = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_f_of_type_ArrayOfInt;
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = GloableValue.jdField_f_of_type_ArrayOfInt;
        continue;
        localObject3 = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_g_of_type_ArrayOfInt;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = GloableValue.jdField_e_of_type_ArrayOfInt;
          continue;
          localObject3 = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_e_of_type_ArrayOfInt;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = GloableValue.jdField_d_of_type_ArrayOfInt;
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
        if ((jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_ArrayOfInt == null) || (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_ArrayOfInt == null) || (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_ArrayOfInt == null) || (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_d_of_type_ArrayOfInt == null)) {
          return null;
        }
        if (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_Boolean)
        {
          arrayOfInt[0] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_d_of_type_Int;
          arrayOfInt[1] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_e_of_type_Int;
          arrayOfInt[2] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_ArrayOfInt[1];
          arrayOfInt[3] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_d_of_type_ArrayOfInt[1];
          i = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_d_of_type_Int;
          paramInt = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_e_of_type_Int;
          localObject1 = arrayOfInt;
          j = i;
          m = paramInt;
          com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter.jdField_a_of_type_JavaLangString = j + "*" + m;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label672;
          }
          QLog.d("DynamicAdjustment", 2, "预览分辨率 : " + localObject1[0] + " * " + localObject1[1]);
          return localObject1;
        }
        if ((jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_ArrayOfInt != null) && (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_ArrayOfInt != null))
        {
          if (!jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_Boolean) {
            break label675;
          }
          if (paramBoolean)
          {
            break label675;
            label274:
            i = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_ArrayOfInt[paramInt];
            j = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_ArrayOfInt[paramInt];
            if (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_d_of_type_Boolean)
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
        Size localSize;
        try
        {
          localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4).getString("SVDNAdjustment_quality_resolution", null);
          k = paramInt;
          localSize = Size.a((String)localObject1);
          k = paramInt;
          paramInt = 0;
          if (localSize == null) {
            break label717;
          }
        }
        catch (NumberFormatException localNumberFormatException1) {}
        try
        {
          if (paramInt >= jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_ArrayOfInt.length) {
            break label717;
          }
          m = k;
          if (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_ArrayOfInt[paramInt] == localSize.jdField_a_of_type_Int)
          {
            int n = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_ArrayOfInt[paramInt];
            int i1 = localSize.jdField_b_of_type_Int;
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
          break label559;
          k = j;
          j = paramInt;
          paramInt = k;
        }
      }
      paramInt = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.q;
      continue;
      paramInt = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.r;
      continue;
      paramInt = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.p;
    }
    for (;;)
    {
      arrayOfInt[0] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_ArrayOfInt[j];
      arrayOfInt[1] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_ArrayOfInt[j];
      arrayOfInt[2] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_ArrayOfInt[j];
      arrayOfInt[3] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_d_of_type_ArrayOfInt[j];
      localObject1 = arrayOfInt;
      break;
      localObject2 = finally;
      throw localObject2;
      label559:
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
          i = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_ArrayOfInt[0];
          paramInt = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_ArrayOfInt[0];
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
      label672:
      label675:
      label725:
      paramInt = j;
      j = k;
    }
  }
  
  public static int b()
  {
    try
    {
      if (!jdField_d_of_type_Boolean)
      {
        getAVCodecLibMetadata(jdField_b_of_type_ArrayOfInt);
        jdField_d_of_type_Boolean = true;
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
    if ((jdField_a_of_type_Int & 0x1) == 0) {
      synchronized (jdField_c_of_type_JavaLangObject)
      {
        CodecParam.jdField_g_of_type_Int = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_Int;
        CodecParam.h = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.u;
        CodecParam.i = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.v;
        jdField_a_of_type_Int |= 0x1;
        return;
      }
    }
  }
  
  public static void b(int paramInt)
  {
    if (jdField_a_of_type_Int != -1) {
      synchronized (jdField_c_of_type_JavaLangObject)
      {
        VideoEnvironment.SVFileSizeCtrlFactor localSVFileSizeCtrlFactor = (VideoEnvironment.SVFileSizeCtrlFactor)jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (localSVFileSizeCtrlFactor != null)
        {
          CodecParam.t = localSVFileSizeCtrlFactor.jdField_b_of_type_Int;
          CodecParam.u = localSVFileSizeCtrlFactor.jdField_c_of_type_Int;
          CodecParam.v = localSVFileSizeCtrlFactor.jdField_d_of_type_Int;
          CodecParam.r = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_f_of_type_Int;
          CodecParam.s = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_g_of_type_Int;
          CodecParam.w = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.k;
          CodecParam.x = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.l;
          jdField_a_of_type_Int |= 0x2;
          return;
        }
        CodecParam.t = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.h;
        CodecParam.u = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.i;
        CodecParam.v = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.j;
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
    return (VersionUtils.d()) && (c(paramAppInterface));
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
            paramString = ahly.a(paramString);
          } while (TextUtils.isEmpty(paramString));
          paramString = paramString.trim();
          str = a();
        } while ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(paramString)));
        paramString = ahly.a(str);
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
      if (i < jdField_d_of_type_ArrayOfJavaLangString.length)
      {
        if (paramString.equals(jdField_d_of_type_ArrayOfJavaLangString[i])) {
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
    CodecParam.r = 450000;
    CodecParam.s = 100000;
    CodecParam.t = 38;
    CodecParam.u = 3;
    CodecParam.v = 5;
  }
  
  public static void c(int paramInt)
  {
    if (jdField_a_of_type_Int != -1) {
      synchronized (jdField_c_of_type_JavaLangObject)
      {
        VideoEnvironment.SVFileSizeCtrlFactor localSVFileSizeCtrlFactor = (VideoEnvironment.SVFileSizeCtrlFactor)jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (localSVFileSizeCtrlFactor != null)
        {
          CodecParam.jdField_c_of_type_Int = localSVFileSizeCtrlFactor.jdField_a_of_type_Int;
          jdField_a_of_type_Int |= 0x4;
          return;
        }
        if (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_Int > 600) {
          jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_Int = 8;
        }
        CodecParam.jdField_c_of_type_Int = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_Int * 1000;
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
      if (VcSystemInfo.f() != 7) {
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
    //   6: getstatic 852	com/tencent/mobileqq/shortvideo/ShortVideoUtils:jdField_b_of_type_Boolean	Z
    //   9: ifne +11 -> 20
    //   12: getstatic 852	com/tencent/mobileqq/shortvideo/ShortVideoUtils:jdField_b_of_type_Boolean	Z
    //   15: istore 4
    //   17: iload 4
    //   19: ireturn
    //   20: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +43 -> 66
    //   26: ldc 250
    //   28: iconst_2
    //   29: new 84	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 854
    //   39: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: getstatic 859	android/os/Build$VERSION:SDK_INT	I
    //   45: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: ldc_w 861
    //   51: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: getstatic 507	android/os/Build:MODEL	Ljava/lang/String;
    //   57: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: iload 6
    //   68: istore 4
    //   70: getstatic 859	android/os/Build$VERSION:SDK_INT	I
    //   73: bipush 10
    //   75: if_icmplt -58 -> 17
    //   78: getstatic 104	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_Int	I
    //   81: iconst_m1
    //   82: if_icmpne +86 -> 168
    //   85: aload_0
    //   86: aconst_null
    //   87: iconst_0
    //   88: invokestatic 863	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Z)V
    //   91: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +74 -> 168
    //   97: ldc 250
    //   99: iconst_2
    //   100: ldc_w 865
    //   103: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: ldc 250
    //   108: iconst_2
    //   109: new 84	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 867
    //   119: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: getstatic 109	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   125: getfield 451	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:m	I
    //   128: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: ldc 250
    //   139: iconst_2
    //   140: new 84	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 869
    //   150: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 109	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   156: getfield 454	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:n	I
    //   159: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: getstatic 111	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_c_of_type_JavaLangObject	Ljava/lang/Object;
    //   171: astore_0
    //   172: aload_0
    //   173: monitorenter
    //   174: getstatic 109	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   177: getfield 457	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:o	I
    //   180: istore_1
    //   181: getstatic 109	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   184: getfield 451	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:m	I
    //   187: istore_2
    //   188: getstatic 109	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   191: getfield 454	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:n	I
    //   194: istore_3
    //   195: getstatic 109	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   198: getfield 524	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:jdField_c_of_type_Boolean	Z
    //   201: istore 7
    //   203: aload_0
    //   204: monitorexit
    //   205: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +92 -> 300
    //   211: ldc 250
    //   213: iconst_2
    //   214: new 84	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 871
    //   224: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: iload_1
    //   228: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: ldc 250
    //   239: iconst_2
    //   240: new 84	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   247: ldc_w 873
    //   250: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload_2
    //   254: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: ldc 250
    //   265: iconst_2
    //   266: new 84	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   273: ldc_w 875
    //   276: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: iload_3
    //   280: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: ldc_w 877
    //   286: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: iload 7
    //   291: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   294: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: iload 7
    //   302: ifeq +68 -> 370
    //   305: iload 6
    //   307: istore 4
    //   309: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq -295 -> 17
    //   315: ldc 250
    //   317: iconst_2
    //   318: new 84	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 879
    //   328: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: iload 7
    //   333: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   336: ldc_w 861
    //   339: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: getstatic 507	android/os/Build:MODEL	Ljava/lang/String;
    //   345: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: iconst_0
    //   355: ireturn
    //   356: astore_0
    //   357: aload_0
    //   358: invokevirtual 880	java/lang/Throwable:printStackTrace	()V
    //   361: iconst_0
    //   362: ireturn
    //   363: astore 8
    //   365: aload_0
    //   366: monitorexit
    //   367: aload 8
    //   369: athrow
    //   370: getstatic 834	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   373: astore_0
    //   374: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +29 -> 406
    //   380: ldc 250
    //   382: iconst_2
    //   383: new 84	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   390: ldc_w 882
    //   393: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_0
    //   397: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: invokestatic 596	com/tencent/mobileqq/shortvideo/VideoEnvironment:c	()Z
    //   409: ifeq +48 -> 457
    //   412: getstatic 883	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_b_of_type_Boolean	Z
    //   415: istore 5
    //   417: iload 5
    //   419: istore 4
    //   421: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq -407 -> 17
    //   427: ldc 250
    //   429: iconst_2
    //   430: new 84	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 885
    //   440: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: iload 5
    //   445: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   448: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: iload 5
    //   456: ireturn
    //   457: iload_1
    //   458: iconst_1
    //   459: if_icmpne +77 -> 536
    //   462: aload_0
    //   463: ifnull +116 -> 579
    //   466: ldc_w 470
    //   469: aload_0
    //   470: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   473: ifne +106 -> 579
    //   476: ldc_w 887
    //   479: aload_0
    //   480: invokevirtual 667	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   483: ifeq +96 -> 579
    //   486: iload 5
    //   488: istore 4
    //   490: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq +40 -> 533
    //   496: ldc 250
    //   498: iconst_2
    //   499: new 84	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   506: ldc_w 889
    //   509: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload_0
    //   513: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc_w 891
    //   519: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: iload 4
    //   524: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: iload 4
    //   535: ireturn
    //   536: iload 5
    //   538: istore 4
    //   540: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq -53 -> 490
    //   546: ldc 250
    //   548: iconst_2
    //   549: new 84	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 893
    //   559: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iconst_1
    //   563: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   566: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 336	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   572: iload 5
    //   574: istore 4
    //   576: goto -86 -> 490
    //   579: iconst_0
    //   580: istore 4
    //   582: goto -92 -> 490
    // Local variable table:
    //   start	length	slot	name	signature
    //   180	280	1	i	int
    //   187	67	2	j	int
    //   194	86	3	k	int
    //   15	566	4	bool1	boolean
    //   1	572	5	bool2	boolean
    //   4	302	6	bool3	boolean
    //   201	131	7	bool4	boolean
    //   363	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   85	91	356	java/lang/Throwable
    //   174	205	363	finally
    //   365	367	363	finally
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
    int j = -5;
    int k = ShortVideoSoLoad.getShortVideoSoLoadStatus();
    Object localObject1 = jdField_a_of_type_JavaLangObject;
    int i = k;
    if (k != 0) {}
    for (;;)
    {
      try
      {
        a("loadAVCodecPreDownload[realDoLoadSo begin] loadcode=" + k, null);
        i = c();
        a("loadAVCodecPreDownload[realDoLoadSo end]loadcode=" + i, null);
        a("loadAVCodecPreDownload[After realDoLoadSo]...", null);
        if (i == 0)
        {
          k = b();
          if (k < 56)
          {
            ShortVideoSoLoad.setShortVideoSoLoadStatus(-5);
            a("loadAVCodecPreDownload[VIDEO_SO_VERSION_ERR]:soversion=" + k + " dymAVCodecVersion=" + 56, null);
            i = j;
            a("loadAVCodecPreDownload[End all] loadcode=" + i, null);
            return i;
          }
        }
        else
        {
          a("loadAVCodecPreDownload[loadcode=" + i + "]");
        }
      }
      finally {}
    }
  }
  
  private static String d()
  {
    return ahly.a("HookTestAVCodec001", "56");
  }
  
  public static void d()
  {
    ShortVideoSoLoad.setShortVideoSoLoadStatus(-4);
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
          CodecParam.jdField_c_of_type_Int = paramInt * 1000;
          jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_Int = paramInt;
          jdField_a_of_type_Int |= 0x4;
          return;
        }
        finally {}
        jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_Int = 8;
        CodecParam.jdField_c_of_type_Int = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_Int * 1000;
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
    return ahly.a("HookTestAVCodecSdcard002", "56");
  }
  
  private static void e()
  {
    ThreadManager.post(new ahmc(), 5, null, false);
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
  
  private static void f()
  {
    Object localObject1 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplicationImpl.getContext());
    Object localObject2 = (String)localObject1 + jdField_a_of_type_JavaLangString;
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
  
  public static boolean f()
  {
    return a(1) > 0;
  }
  
  private static boolean g()
  {
    return CameraCompatibleList.a(CameraCompatibleList.n);
  }
  
  private static native void getAVCodecLibMetadata(int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoEnvironment
 * JD-Core Version:    0.7.0.1
 */