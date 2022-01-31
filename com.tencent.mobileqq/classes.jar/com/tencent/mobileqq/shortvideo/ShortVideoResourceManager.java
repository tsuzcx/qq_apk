package com.tencent.mobileqq.shortvideo;

import aidx;
import aief;
import aieg;
import aieh;
import aiei;
import aiej;
import aiel;
import aiem;
import aien;
import aieo;
import aiep;
import aieq;
import aier;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;

public class ShortVideoResourceManager
  implements ShortVideoResourceStatus.ISVConfig, INetEngine.INetEngineListener, Manager
{
  public static long a;
  private static ShortVideoResourceManager.ConfigSession jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession = new ShortVideoResourceManager.ConfigSession();
  private static final Object jdField_a_of_type_JavaLangObject;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new aief(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Object b = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    d();
  }
  
  public ShortVideoResourceManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public static int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).getInt("short_video_resource_version", 0);
  }
  
  private static int a(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str1 = a(paramSVConfigItem.name);
    if (aidx.a(paramQQAppInterface, paramSVConfigItem))
    {
      String str2 = paramSVConfigItem.getSignature();
      VideoEnvironment.a("ShortVideoResourceManager", "doNoNeedDownload: signature=" + str2, null);
      int i = a(paramQQAppInterface, paramSVConfigItem.name, str2, str1, paramSVConfigItem.versionCode);
      if (i != 0)
      {
        ShortVideoResourceStatus.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, -1, i);
        b(str1);
        VideoEnvironment.a("ShortVideoResourceManager", "doNoNeedDownload: errCode=" + i, null);
        return i;
      }
      ShortVideoResourceStatus.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, 0, i);
      return i;
    }
    VideoEnvironment.a("ShortVideoResourceManager", "doNoNeedDownload: sysSupport=false", null);
    return -1000;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, ShortVideoResourceStatus.ISVConfig paramISVConfig)
  {
    int i = 0;
    d();
    int j = a(new ArrayList(0));
    VideoEnvironment.a("ShortVideoResourceManager", "startUserDownloadConfig[checkLocalConfigIsOK]:errCode=" + j, null);
    if (j != 0)
    {
      boolean bool = NetworkUtil.g(null);
      VideoEnvironment.a("ShortVideoResourceManager", "startUserDownloadConfig:netUsable=" + bool, null);
      j = a(paramISVConfig);
      if (j == -115)
      {
        a(paramQQAppInterface, paramISVConfig);
        VideoEnvironment.a("ShortVideoResourceManager", "startUserDownloadConfig[end]:errCode=" + i, null);
        return i;
      }
      i = j;
      if (j != -116) {}
    }
    for (;;)
    {
      break;
      i = j;
      if (paramISVConfig != null)
      {
        paramISVConfig.a(1, 0);
        i = j;
      }
    }
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = aidx.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    VideoEnvironment.a("ShortVideoResourceManager", "[userUncompressZipResource]needRestore=" + bool + ",keyName=" + paramString1, null);
    if (bool) {}
    for (paramInt = -118;; paramInt = 0)
    {
      VideoEnvironment.a("ShortVideoResourceManager", "[userUncompressZipResource]errCode=" + paramInt + ",keyName=" + paramString1, null);
      return paramInt;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, List paramList)
  {
    int i = a();
    paramQQAppInterface = b();
    if ((i == 0) || (TextUtils.isEmpty(paramQQAppInterface)))
    {
      bool = a("", 0);
      VideoEnvironment.a("ShortVideoResourceManager", "[checkConfigResourceIsOK]:version=" + i + ",successReset=" + bool + ",config_content=" + paramQQAppInterface, null);
      i = -101;
    }
    int j;
    do
    {
      return i;
      i = a(paramQQAppInterface, paramList);
      VideoEnvironment.a("ShortVideoResourceManager", "[checkConfigResourceIsOK]parseConfigData_errCode=" + i, null);
      if (i != 0)
      {
        paramList.clear();
        bool = a("", 0);
        VideoEnvironment.a("ShortVideoResourceManager", "[doUserDownloadResource]parseConfigData:errCode=" + i + ",successReset=" + bool + ",config_content=" + paramQQAppInterface, null);
        return i;
      }
      j = b(paramList);
      i = j;
    } while (j == 0);
    paramList.clear();
    boolean bool = a("", 0);
    VideoEnvironment.a("ShortVideoResourceManager", "[doUserDownloadResource]checkResourceVersion:errCode=" + j + ",successReset=" + bool + ",config_content=" + paramQQAppInterface, null);
    return j;
  }
  
  private static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str = c();
    str = str + paramSVConfigItem.name;
    return a(paramSVConfigItem.name, paramSVConfigItem.armv7a_md5, str);
  }
  
  /* Error */
  private static int a(ShortVideoResourceStatus.ISVConfig paramISVConfig)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore_2
    //   5: getstatic 28	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession	Lcom/tencent/mobileqq/shortvideo/ShortVideoResourceManager$ConfigSession;
    //   8: getfield 237	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager$ConfigSession:jdField_a_of_type_Int	I
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +11 -> 24
    //   16: bipush 141
    //   18: istore_1
    //   19: ldc 2
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: aload_0
    //   25: ifnonnull +9 -> 34
    //   28: bipush 140
    //   30: istore_1
    //   31: goto -12 -> 19
    //   34: getstatic 33	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   37: aload_0
    //   38: invokevirtual 241	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   41: istore_3
    //   42: ldc 110
    //   44: new 112	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   51: ldc 243
    //   53: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_3
    //   57: invokevirtual 167	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: aconst_null
    //   64: invokestatic 125	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: iload_2
    //   68: istore_1
    //   69: iload_3
    //   70: ifne -51 -> 19
    //   73: getstatic 33	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   76: aload_0
    //   77: invokevirtual 246	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   80: pop
    //   81: ldc 110
    //   83: ldc 248
    //   85: aconst_null
    //   86: invokestatic 125	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: iload_2
    //   90: istore_1
    //   91: goto -72 -> 19
    //   94: astore_0
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_0
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramISVConfig	ShortVideoResourceStatus.ISVConfig
    //   11	80	1	i	int
    //   4	86	2	j	int
    //   41	29	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	12	94	finally
    //   34	67	94	finally
    //   73	89	94	finally
  }
  
  private static int a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, paramString1 + "|verifyResource() lResMd5=" + paramString2 + ", filepath=" + paramString3);
    }
    if (TextUtils.isEmpty(paramString3)) {
      return -105;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return -106;
    }
    File localFile = new File(paramString3);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoResourceManager", 2, paramString1 + "|verifyResource() file[" + paramString3 + "] not exist..");
      }
      return -107;
    }
    Object localObject = null;
    try
    {
      paramString3 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString3));
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoResourceManager", 2, paramString1 + "|verifyResource  lResMd5=" + paramString2 + ",md5=" + paramString3);
      }
      if (paramString2.equalsIgnoreCase(paramString3)) {
        return 0;
      }
    }
    catch (UnsatisfiedLinkError paramString3)
    {
      for (;;)
      {
        try
        {
          paramString3 = MD5FileUtil.a(localFile);
        }
        catch (Exception paramString3)
        {
          paramString3 = localObject;
        }
        return -108;
      }
    }
  }
  
  private static int a(String paramString, List paramList)
  {
    try
    {
      paramString = new JSONArray(paramString);
      j = paramString.length();
      if (j > 0) {
        break label211;
      }
      VideoEnvironment.a("ShortVideoResourceManager", "parseConfigData: arrayLength=" + j, null);
      return -100;
    }
    catch (JSONException paramString)
    {
      int j;
      ShortVideoResourceManager.SVConfigItem localSVConfigItem;
      if (!QLog.isColorLevel()) {
        break label124;
      }
      QLog.d("ShortVideoResourceManager", 2, "parseConfigData[JSONException]", paramString);
      paramList.clear();
      for (i = -100;; i = 0)
      {
        VideoEnvironment.a("ShortVideoResourceManager", "parseConfigData:errCode=" + i, null);
        return i;
        paramList.add(localSVConfigItem);
        i += 1;
        break;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        label124:
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoResourceManager", 2, "parseConfigData[OutOfMemoryError]", paramString);
        }
        paramList.clear();
        int i = -100;
        continue;
        label211:
        i = 0;
      }
    }
    if (i < j)
    {
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)JSONUtils.a(paramString.getJSONObject(i), ShortVideoResourceManager.SVConfigItem.class);
      if (localSVConfigItem == null)
      {
        VideoEnvironment.a("ShortVideoResourceManager", "parseConfigData:item=null i=" + i, null);
        paramList.clear();
        return -100;
      }
    }
  }
  
  private static int a(List paramList)
  {
    int i = a();
    String str = b();
    VideoEnvironment.a("ShortVideoResourceManager", "checkLocalConfigIsOK:version=" + i + " config_content" + str, null);
    if ((i != 0) && (!TextUtils.isEmpty(str)))
    {
      int j = a(str, paramList);
      VideoEnvironment.a("ShortVideoResourceManager", "checkLocalConfigIsOK:parseConfigData_errCode=" + j, null);
      i = j;
      if (j == 0) {
        i = b(paramList);
      }
      return i;
    }
    return -101;
  }
  
  private static String a()
  {
    return "hashCode=" + jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.hashCode() + " ,pid=" + Process.myPid() + ",tid" + Process.myTid();
  }
  
  private static String a(String paramString)
  {
    String str = c();
    return str + paramString;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 110
    //   5: new 112	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 365
    //   15: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokestatic 367	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:a	()Ljava/lang/String;
    //   21: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: aconst_null
    //   28: invokestatic 125	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   31: getstatic 28	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession	Lcom/tencent/mobileqq/shortvideo/ShortVideoResourceManager$ConfigSession;
    //   34: getfield 237	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager$ConfigSession:jdField_a_of_type_Int	I
    //   37: iconst_1
    //   38: if_icmpne +14 -> 52
    //   41: getstatic 28	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession	Lcom/tencent/mobileqq/shortvideo/ShortVideoResourceManager$ConfigSession;
    //   44: iconst_2
    //   45: putfield 237	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager$ConfigSession:jdField_a_of_type_Int	I
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: ldc 110
    //   54: new 112	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 369
    //   64: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 28	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession	Lcom/tencent/mobileqq/shortvideo/ShortVideoResourceManager$ConfigSession;
    //   70: invokevirtual 370	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager$ConfigSession:a	()Ljava/lang/String;
    //   73: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aconst_null
    //   80: invokestatic 125	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: getstatic 28	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession	Lcom/tencent/mobileqq/shortvideo/ShortVideoResourceManager$ConfigSession;
    //   86: getfield 237	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager$ConfigSession:jdField_a_of_type_Int	I
    //   89: ifne -41 -> 48
    //   92: getstatic 33	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: invokevirtual 373	java/util/ArrayList:size	()I
    //   98: istore_0
    //   99: ldc 110
    //   101: new 112	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 375
    //   111: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: iload_0
    //   115: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aconst_null
    //   122: invokestatic 125	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: iload_0
    //   126: ifle -78 -> 48
    //   129: goto -81 -> 48
    //   132: astore_1
    //   133: ldc 2
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   98	28	0	i	int
    //   132	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	48	132	finally
    //   52	125	132	finally
  }
  
  public static void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        VideoEnvironment.a("ShortVideoResourceManager", "onReceiveFailed:status=" + jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.a() + " mGetConfigType" + jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.b + ",serverResult=" + paramInt + ",LogSignature=" + a(), null);
        if (jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_a_of_type_Int = 0;
          if (paramInt == 0)
          {
            VideoEnvironment.a("ShortVideoResourceManager", "onReceiveFailed[RESULT_NO_DATA]", null);
            jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_c_of_type_Int = 1;
            jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.d = 0;
            paramInt = jdField_a_of_type_JavaUtilArrayList.size() - 1;
            if (paramInt >= 0)
            {
              if (jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null) {
                break label244;
              }
              ((ShortVideoResourceStatus.ISVConfig)jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_c_of_type_Int, jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.d);
              break label244;
            }
          }
          else
          {
            VideoEnvironment.a("ShortVideoResourceManager", "onReceiveFailed[RESULT_FAILED]", null);
            jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_c_of_type_Int = -1;
            jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.d = paramInt;
            continue;
          }
          jdField_a_of_type_JavaUtilArrayList.clear();
        }
      }
      finally {}
      for (;;)
      {
        return;
        VideoEnvironment.a("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveFailed] mConfigStatus=" + jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.a(), null);
      }
      label244:
      paramInt -= 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    
    if (paramInt != 3)
    {
      a(paramQQAppInterface, paramInt, paramQQAppInterface.a());
      return;
    }
    throw new Error("preDownloadShortVideoConfigData: call user type...");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, ShortVideoResourceStatus.ISVConfig paramISVConfig)
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_a_of_type_Int == 0)
        {
          if (paramInt == 3)
          {
            i = a(new ArrayList(0));
            if (i == 0)
            {
              if (paramISVConfig != null) {
                paramISVConfig.a(1, i);
              }
              return;
            }
          }
          int i = a();
          String str = b();
          VideoEnvironment.a("ShortVideoResourceManager", "doUserDownload[Begin download print]:version=" + i + " config_content" + str, null);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortVideoConfigData LogSignature=" + a(), null);
          jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_a_of_type_Int = 1;
          jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.b = paramInt;
          jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_c_of_type_Int = 0;
          jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.d = 0;
          ConfigServlet.b(paramQQAppInterface, paramInt);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortvideoConfigData[request started]:status=" + jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.a() + " mGetConfigType" + jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.b, null);
          if (paramISVConfig == null) {
            continue;
          }
          boolean bool = jdField_a_of_type_JavaUtilArrayList.contains(paramISVConfig);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortVideoConfigData contains=" + bool, null);
          if (bool) {
            continue;
          }
          if (paramInt == 3) {
            break label327;
          }
          jdField_a_of_type_JavaUtilArrayList.add(0, paramISVConfig);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortVideoConfigData: add callBack OK...", null);
          continue;
        }
        VideoEnvironment.a("ShortVideoResourceManager", "downloadShortvideoConfigData[request pending]:status=" + jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.a() + " mGetConfigType" + jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.b, null);
      }
      finally {}
      continue;
      label327:
      jdField_a_of_type_JavaUtilArrayList.add(paramISVConfig);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    a(paramQQAppInterface, paramINet_ShortVideoResource, "new_qq_android_native_short_video_");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (paramINet_ShortVideoResource != null) {
        paramQQAppInterface.a().a(paramINet_ShortVideoResource, paramString);
      }
      return;
    }
    VideoEnvironment.a("ShortVideoResourceManager", "clearResourceCallBackWithNamePrefixSafe: app=null...", null);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ShortVideoResourceStatus.ISVConfig paramISVConfig)
  {
    a(paramQQAppInterface, 3, paramISVConfig);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List paramList)
  {
    ThreadManager.post(new aiej(paramQQAppInterface, paramList), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List paramList, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.post(new aiel(paramQQAppInterface, paramList, paramINet_ShortVideoResource), 5, null, false);
  }
  
  public static void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new aiei(paramString));
  }
  
  private static void a(String paramString, int paramInt)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      VideoEnvironment.a(paramInt);
    }
    while (!paramString.startsWith("new_qq_android_native_short_filter_")) {
      return;
    }
  }
  
  private void a(List paramList)
  {
    ThreadManager.post(new aieg(this, paramList), 5, null, false);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str = a(paramSVConfigItem.name);
    VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload:name=" + paramSVConfigItem.name, null);
    aier localaier = ShortVideoResourceStatus.a(paramSVConfigItem.name);
    VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload:versionCode=" + paramSVConfigItem.versionCode + " status.version" + localaier.jdField_a_of_type_Int + ",status.lastErr=" + localaier.jdField_c_of_type_Int, null);
    if (!aidx.a(paramQQAppInterface, paramSVConfigItem)) {
      VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload:userDownload=false", null);
    }
    label236:
    label243:
    do
    {
      do
      {
        do
        {
          return false;
          if (paramSVConfigItem.versionCode <= localaier.jdField_a_of_type_Int) {
            break label243;
          }
          if (localaier.jdField_a_of_type_Int != 0) {
            break label236;
          }
          VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload:status.version=0", null);
          if (!new File(str).exists()) {
            break;
          }
          VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload:[exists]filePath=" + str, null);
          i = a(paramSVConfigItem);
          VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload[zipVerifyMd5]:errCode=" + i, null);
        } while (i == 0);
        b(str);
        return true;
        b(str);
        return true;
      } while (paramSVConfigItem.versionCode != localaier.jdField_a_of_type_Int);
      if (localaier.b != 0)
      {
        VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload[No equal]:status=" + localaier.b + ",version" + localaier.jdField_a_of_type_Int, null);
        b(str);
        return true;
      }
      boolean bool = a(paramSVConfigItem.name);
      VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:exist=" + bool, null);
      if (!bool) {
        return true;
      }
      int i = a(paramSVConfigItem);
      VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:errCode=" + i, null);
      if (i != 0)
      {
        b(str);
        return true;
      }
    } while (localaier.jdField_c_of_type_Int == 0);
    VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:status=" + localaier.b + ",lastErr" + localaier.jdField_c_of_type_Int, null);
    return false;
  }
  
  private boolean a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource, boolean[] paramArrayOfBoolean)
  {
    String str = a(paramSVConfigItem.name);
    boolean bool = aidx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem.name);
    VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:alreadyExists=" + bool, null);
    paramArrayOfBoolean[0] = bool;
    if (bool)
    {
      VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:onDownloadFinish...", null);
      if (paramINet_ShortVideoResource != null) {
        paramINet_ShortVideoResource.a(paramSVConfigItem.name, 0, str);
      }
      VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:itemConfig.versionCode=" + paramSVConfigItem.versionCode, null);
      bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem);
      if (!bool)
      {
        int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem);
        VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:doNoNeedDownload_errCode=" + i, null);
        if (i == 0) {}
      }
      return bool;
    }
    return true;
  }
  
  private static boolean a(String paramString)
  {
    String str = c();
    return FileUtils.a(str + paramString);
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).edit();
    localEditor.putString("short_video_res_config_key", paramString);
    localEditor.putInt("short_video_resource_version", paramInt);
    return localEditor.commit();
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      VideoEnvironment.a("ShortVideoResourceManager", "[onResp]renameResourceZip destPath=" + paramString1 + ",outPath=" + paramString2, null);
      paramString1 = new File(paramString1);
      if (paramString1.exists())
      {
        paramString1.delete();
        VideoEnvironment.a("ShortVideoResourceManager", "[onResp]renameResourceZip rename  destFile already exists[delete]...", null);
      }
      paramString2 = new File(paramString2);
      long l1 = paramString2.length();
      boolean bool = paramString2.renameTo(paramString1);
      VideoEnvironment.a("ShortVideoResourceManager", "[onResp]renameResourceZip orgLength=" + l1 + ",success=" + bool, null);
      if (bool)
      {
        bool = paramString1.exists();
        long l2 = paramString1.length();
        VideoEnvironment.a("ShortVideoResourceManager", "[onResp]renameResourceZip destExists=" + bool + ",destLength=" + l2, null);
        if ((bool) && (l2 == l1)) {
          return true;
        }
      }
      return false;
    }
  }
  
  private static int b(List paramList)
  {
    int j = 0;
    int i = 0;
    while (i < paramList.size())
    {
      j = aidx.a((ShortVideoResourceManager.SVConfigItem)paramList.get(i));
      if (j != 0) {
        return j;
      }
      i += 1;
    }
    return j;
  }
  
  private static String b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).getString("short_video_res_config_key", "");
  }
  
  public static void b()
  {
    for (;;)
    {
      try
      {
        VideoEnvironment.a("ShortVideoResourceManager", "onReceiveNoDataUpdate LogSignature=" + a(), null);
        int i;
        if (jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_a_of_type_Int = 0;
          jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_c_of_type_Int = 1;
          i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i >= 0)
          {
            if (jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
              ((ShortVideoResourceStatus.ISVConfig)jdField_a_of_type_JavaUtilArrayList.get(i)).a(jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_c_of_type_Int, 0);
            }
          }
          else {
            jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        else
        {
          VideoEnvironment.a("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveNoDataUpdate] mConfigStatus=" + jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.a(), null);
          continue;
        }
        i -= 1;
      }
      finally {}
    }
  }
  
  public static void b(int paramInt)
  {
    for (;;)
    {
      try
      {
        VideoEnvironment.a("ShortVideoResourceManager", "onReceiveSuccess LogSignature=" + a(), null);
        int i;
        if (jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_a_of_type_Int = 0;
          jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_c_of_type_Int = 0;
          i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i >= 0)
          {
            if (jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
              ((ShortVideoResourceStatus.ISVConfig)jdField_a_of_type_JavaUtilArrayList.get(i)).a(jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.jdField_c_of_type_Int, paramInt);
            }
          }
          else {
            jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        else
        {
          VideoEnvironment.a("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveSuccess] mConfigStatus=" + jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.a(), null);
          continue;
        }
        i -= 1;
      }
      finally {}
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    a(paramQQAppInterface, paramINet_ShortVideoResource, "new_qq_android_native_short_filter_");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List paramList, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.post(new aiem(paramQQAppInterface, paramList, paramINet_ShortVideoResource), 5, null, false);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, List paramList, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource, String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      ShortVideoResourceManager.SVConfigItem localSVConfigItem;
      try
      {
        if (i < paramList.size())
        {
          localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)paramList.get(i);
          if (!localSVConfigItem.name.startsWith(paramString)) {
            break label208;
          }
          if (paramQQAppInterface != null) {
            continue;
          }
          VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix: app=null [RES_APP_INTERFACE_NULL_ERROR]", null);
          if (paramINet_ShortVideoResource != null) {
            paramINet_ShortVideoResource.a(localSVConfigItem.name, -1501, "");
          }
        }
        return;
        boolean bool = a(paramQQAppInterface, localSVConfigItem);
        VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix: needDownload=" + bool, null);
        if (bool)
        {
          paramQQAppInterface.a().a(localSVConfigItem, paramINet_ShortVideoResource);
          continue;
        }
        paramList = a(localSVConfigItem.name);
      }
      finally {}
      i = a(paramQQAppInterface, localSVConfigItem);
      VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix:[doNoNeedDownload] errCode=" + i, null);
      if (paramINet_ShortVideoResource != null)
      {
        paramINet_ShortVideoResource.a(localSVConfigItem.name, i, paramList);
        continue;
        label208:
        i += 1;
      }
    }
  }
  
  private void b(NetResp arg1)
  {
    int j = 0;
    Object localObject1 = ???.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
    String str1 = ((NetReq)localObject1).jdField_c_of_type_JavaLangString;
    VideoEnvironment.a("ShortVideoResourceManager", "[onResp]filePath=" + str1 + ",resp.mResult=" + ???.jdField_a_of_type_Int + ",mHttpCode=" + ???.jdField_c_of_type_Int + ",mErrCode=" + ???.b + ",mErrDesc=" + ???.jdField_a_of_type_JavaLangString, null);
    localObject1 = (String)((NetReq)localObject1).a();
    if (localObject1 == null) {}
    for (;;)
    {
      aieq localaieq;
      String str2;
      int k;
      int i;
      synchronized (this.b)
      {
        localaieq = (aieq)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
        str2 = localaieq.jdField_a_of_type_JavaLangString;
        k = localaieq.jdField_a_of_type_Int;
        ??? = c();
        ??? = (String)??? + (String)localObject1;
        if (???.jdField_a_of_type_Int == 0)
        {
          i = a((String)localObject1, str2, str1);
          VideoEnvironment.a("ShortVideoResourceManager", "[onResp]verifyResource keyName=" + (String)localObject1 + ",errCode=" + i, null);
          if (i != 0)
          {
            b(str1);
            VideoEnvironment.a("ShortVideoResourceManager", "[onResp]verifyResource clearDownloadTempFile errCode=" + i, null);
            ShortVideoResourceStatus.a((String)localObject1, k, 0, i);
            VideoEnvironment.a("ShortVideoResourceManager", "[onRespAsync]errCode=" + i + ",saveFilePath=" + (String)??? + ",key=" + (String)localObject1, null);
            synchronized (this.b)
            {
              localaieq.b = 3;
              k = localaieq.jdField_a_of_type_JavaUtilArrayList.size();
              if (j >= k) {}
            }
          }
        }
      }
      try
      {
        if (localaieq.jdField_a_of_type_JavaUtilArrayList.get(j) != null) {
          ((ShortVideoResourceManager.INet_ShortVideoResource)localaieq.jdField_a_of_type_JavaUtilArrayList.get(j)).a((String)localObject1, i, (String)???);
        }
        label386:
        j += 1;
        continue;
        ??? = finally;
        throw ???;
        if (a((String)???, str1))
        {
          ??? = str2 + '_' + k;
          i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, ???, (String)???, k);
          VideoEnvironment.a("ShortVideoResourceManager", "[onRespAsync]signature=" + ??? + ",errCode=" + i + ",key=" + (String)localObject1, null);
          continue;
        }
        i = -3;
        b((String)???);
        b(str1);
        continue;
        ShortVideoResourceStatus.a((String)localObject1, k, 1, -117);
        b(str1);
        VideoEnvironment.a("ShortVideoResourceManager", "[onResp]filePath=" + str1 + ",resp.mResult=" + ???.jdField_a_of_type_Int + ",mErrDesc=" + ???.jdField_a_of_type_JavaLangString + ",mErrDesc=" + ???.jdField_a_of_type_JavaLangString, null);
        i = -117;
        continue;
        localaieq.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilHashMap.remove(localObject1);
        return;
        localObject2 = finally;
        throw localObject2;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        break label386;
      }
    }
  }
  
  private static void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  private void b(List paramList)
  {
    Object localObject = jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      ShortVideoResourceManager.SVConfigItem localSVConfigItem;
      try
      {
        if (i >= paramList.size()) {
          break label119;
        }
        localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)paramList.get(i);
        if (!localSVConfigItem.predownload) {
          VideoEnvironment.a("ShortVideoResourceManager", "preDownloadResource:parseConfigData predownload=false", null);
        } else if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSVConfigItem)) {
          a(localSVConfigItem, null);
        }
      }
      finally {}
      int j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSVConfigItem);
      VideoEnvironment.a("ShortVideoResourceManager", "preDownloadResourceSync:needDownload=false [doNoNeedDownload] errCode=" + j, null);
      break label123;
      label119:
      return;
      label123:
      i += 1;
    }
  }
  
  private static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aK);
    localStringBuilder.append("sv_config_resource");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  private void c()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        aieq localaieq = (aieq)localIterator.next();
        if ((localaieq != null) && (localaieq.jdField_a_of_type_JavaUtilArrayList != null))
        {
          int i = 0;
          while (i < localaieq.jdField_a_of_type_JavaUtilArrayList.size())
          {
            ((ShortVideoResourceManager.INet_ShortVideoResource)localaieq.jdField_a_of_type_JavaUtilArrayList.get(i)).C_();
            i += 1;
          }
        }
      }
      return;
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, List paramList, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.post(new aien(paramQQAppInterface, paramList, paramINet_ShortVideoResource), 5, null, false);
  }
  
  private static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aK);
    localStringBuilder.append("sv_config_resource");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("download");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  private static void d()
  {
    File localFile = new File(c());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(d());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, List paramList, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.postDownLoadTask(new aieo(paramQQAppInterface, paramList, paramINet_ShortVideoResource), 5, null, false);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, List paramList, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.postDownLoadTask(new aiep(paramQQAppInterface, paramList, paramINet_ShortVideoResource), 5, null, false);
  }
  
  public int a(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent|received save version: " + paramInt + ",config_content=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent| version=" + paramInt + ",config_content=" + paramString);
      }
      return -101;
    }
    boolean bool = a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent| saveContentOK=" + bool);
    }
    if (bool) {
      return 0;
    }
    return -128;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("ShortVideoResourceManager", "[PreDownload]onConfigResult:result=" + paramInt1 + ",serverError" + paramInt2 + ",getType=" + jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$ConfigSession.b, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0) {
        VideoEnvironment.a("ShortVideoResourceManager", "[PreDownload]onConfigResult:RESULT_OK,saveError=" + paramInt2, null);
      }
    }
    else {
      return;
    }
    paramInt1 = a();
    String str = b();
    boolean bool;
    if ((paramInt1 == 0) || (TextUtils.isEmpty(str)))
    {
      bool = a("", 0);
      VideoEnvironment.a("ShortVideoResourceManager", "[PreDownload]onConfigResult:version=" + paramInt1 + ",successReset=" + bool + ",config_content=" + str, null);
      return;
    }
    ArrayList localArrayList = new ArrayList(1);
    paramInt1 = a(str, localArrayList);
    VideoEnvironment.a("ShortVideoResourceManager", "[PreDownload]onConfigResult:parseConfigData_errCode=" + paramInt1, null);
    if (paramInt1 == -100)
    {
      bool = a("", 0);
      VideoEnvironment.a("ShortVideoResourceManager", "[PreDownload]onConfigResult:parseConfigData_errCode=" + paramInt1 + ",successReset=" + bool, null);
      return;
    }
    if (paramInt1 == 0)
    {
      paramInt1 = b(localArrayList);
      if (paramInt1 != 0)
      {
        bool = a("", 0);
        VideoEnvironment.a("ShortVideoResourceManager", "[PreDownload]onConfigResult:checkResourceVersion errCode=" + paramInt1 + ",successReset=" + bool, null);
        return;
      }
      a(localArrayList);
      VideoEnvironment.a("ShortVideoResourceManager", "[PreDownload]onConfigResult:success,sendRequest or no needDownload or predownload = false...", null);
      return;
    }
    VideoEnvironment.a("ShortVideoResourceManager", "[PreDownload]onConfigResult:parseConfigData Other error code ...", null);
  }
  
  public void a(ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource, String paramString)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        if ((localObject2 != null) && (((String)localObject2).startsWith(paramString)))
        {
          localObject2 = (aieq)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
          if ((localObject2 != null) && (paramINet_ShortVideoResource != null)) {
            ((aieq)localObject2).jdField_a_of_type_JavaUtilArrayList.remove(paramINet_ShortVideoResource);
          }
        }
      }
    }
  }
  
  public void a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    for (;;)
    {
      Object localObject2;
      boolean bool;
      synchronized (this.b)
      {
        localObject2 = (aieq)this.jdField_a_of_type_JavaUtilHashMap.get(paramSVConfigItem.name);
        if (localObject2 == null)
        {
          localObject2 = new boolean[1];
          bool = a(paramSVConfigItem, paramINet_ShortVideoResource, (boolean[])localObject2);
          if (localObject2[0] != 0) {
            paramINet_ShortVideoResource = null;
          }
          VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:doDownload=" + bool, null);
          if (bool)
          {
            localObject2 = c();
            b((String)localObject2 + paramSVConfigItem.name);
            localObject2 = d();
            b((String)localObject2 + paramSVConfigItem.name);
            HttpNetReq localHttpNetReq = new HttpNetReq();
            localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
            localHttpNetReq.jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_url;
            localHttpNetReq.jdField_a_of_type_Int = 0;
            localHttpNetReq.jdField_c_of_type_JavaLangString = ((String)localObject2 + paramSVConfigItem.name);
            localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
            localHttpNetReq.n = true;
            localHttpNetReq.a(paramSVConfigItem.name);
            localObject2 = new aieq(this, localHttpNetReq);
            ((aieq)localObject2).jdField_a_of_type_Int = paramSVConfigItem.versionCode;
            ((aieq)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_md5;
            if (paramINet_ShortVideoResource != null)
            {
              ((aieq)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramINet_ShortVideoResource);
              VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[session][new]add callBack ok...", null);
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(paramSVConfigItem.name, localObject2);
            ((aieq)localObject2).a();
          }
          return;
        }
        if (((aieq)localObject2).b == 0)
        {
          ((aieq)localObject2).jdField_a_of_type_Int = paramSVConfigItem.versionCode;
          ((aieq)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_md5;
          if (paramINet_ShortVideoResource != null)
          {
            bool = ((aieq)localObject2).jdField_a_of_type_JavaUtilArrayList.contains(paramINet_ShortVideoResource);
            VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][start]contains=" + bool, null);
            if (!bool)
            {
              ((aieq)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramINet_ShortVideoResource);
              VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][start]add callBack ok...", null);
            }
          }
          ((aieq)localObject2).a();
        }
      }
      if (paramINet_ShortVideoResource != null)
      {
        bool = ((aieq)localObject2).jdField_a_of_type_JavaUtilArrayList.contains(paramINet_ShortVideoResource);
        VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][pending]contains=" + bool, null);
        if (!bool)
        {
          ((aieq)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramINet_ShortVideoResource);
          VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][pending]add callBack ok...", null);
        }
      }
    }
  }
  
  public final void a(NetReq arg1, long paramLong1, long paramLong2)
  {
    String str = (String)???.a();
    if (str == null) {}
    VideoEnvironment.a("ShortVideoResourceManager", "[onUpdateProgeress]curOffset=" + paramLong1 + ",totalLen=" + paramLong2 + ",key=" + str, null);
    for (;;)
    {
      int i;
      synchronized (this.b)
      {
        aieq localaieq = (aieq)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        localaieq.b = 2;
        int j = localaieq.jdField_a_of_type_JavaUtilArrayList.size();
        i = 0;
        if (i < j)
        {
          if (localaieq.jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
            ((ShortVideoResourceManager.INet_ShortVideoResource)localaieq.jdField_a_of_type_JavaUtilArrayList.get(i)).a(str, paramLong1, paramLong2);
          }
        }
        else
        {
          i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
          VideoEnvironment.a("ShortVideoResourceManager", "[onUpdateProgeress]downloadProgress=" + i + ",key=" + str, null);
          a(str, i);
          return;
        }
      }
      i += 1;
    }
  }
  
  public final void a(NetResp paramNetResp)
  {
    ThreadManager.post(new aieh(this, paramNetResp), 5, null, false);
  }
  
  public void onDestroy()
  {
    try
    {
      int i = jdField_a_of_type_JavaUtilArrayList.size();
      jdField_a_of_type_JavaUtilArrayList.clear();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoResourceManager", 2, new Object[] { "updateShortVideoResConfigContent|onDestroy sizeCallBack=", Integer.valueOf(i) });
      }
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager
 * JD-Core Version:    0.7.0.1
 */