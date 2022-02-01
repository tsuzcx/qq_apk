package dov.com.qq.im.ae.download.old;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.util.AEQLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;

public class AEOldShortVideoResManager
  implements INetEngineListener, AEOldShortVideoResStatus.ISVConfig, Manager
{
  public static long a;
  private static AEOldShortVideoResManager.ConfigSession jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static ArrayList<AEOldShortVideoResStatus.ISVConfig> jdField_a_of_type_JavaUtilArrayList;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new AEOldShortVideoResManager.1(this);
  private HashMap<String, AEOldShortVideoResManager.HttpEngineSession> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Object b = new Object();
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession = new AEOldShortVideoResManager.ConfigSession();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaLangObject = new Object();
    f();
  }
  
  public AEOldShortVideoResManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public static int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).getInt("short_video_resource_version", 0);
  }
  
  private static int a(QQAppInterface paramQQAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    String str1 = a(paramSVConfigItem.name);
    if (AEOldShortVideoBusinessProcess.a(paramQQAppInterface, paramSVConfigItem))
    {
      String str2 = paramSVConfigItem.getSignature();
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doNoNeedDownload: signature=" + str2, null);
      int i = a(paramQQAppInterface, paramSVConfigItem.name, str2, str1, paramSVConfigItem.versionCode);
      if (i != 0)
      {
        AEOldShortVideoResStatus.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, -1, i);
        a(str1);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doNoNeedDownload: errCode=" + i, null);
        return i;
      }
      AEOldShortVideoResStatus.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, 0, i);
      return i;
    }
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doNoNeedDownload: sysSupport=false", null);
    return -1000;
  }
  
  public static int a(@Nullable QQAppInterface paramQQAppInterface, AEOldShortVideoResStatus.ISVConfig paramISVConfig)
  {
    int i;
    if (paramQQAppInterface == null) {
      i = -101;
    }
    int j;
    do
    {
      return i;
      j = a(paramISVConfig);
      AEQLog.b("AEOldShortVideoResManager", "startUserDownloadConfigUpdateForce[checkLocalConfigIsOK]:errCode=" + j);
      if (j == -115)
      {
        a(paramQQAppInterface, paramISVConfig);
        return 0;
      }
      i = j;
    } while (j != -116);
    return j;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = AEOldShortVideoBusinessProcess.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[userUncompressZipResource]needRestore=" + bool + ",keyName=" + paramString1, null);
    if (bool) {}
    for (paramInt = -118;; paramInt = 0)
    {
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[userUncompressZipResource]errCode=" + paramInt + ",keyName=" + paramString1, null);
      return paramInt;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    int i = a();
    paramQQAppInterface = a();
    if ((i == 0) || (TextUtils.isEmpty(paramQQAppInterface)))
    {
      bool = a("", 0);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[checkConfigResourceIsOK]:version=" + i + ", successReset=" + bool + ", config_content=" + paramQQAppInterface, null);
      i = -101;
    }
    int j;
    do
    {
      return i;
      i = a(paramQQAppInterface, paramList);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[checkConfigResourceIsOK]parseConfigData_errCode=" + i, null);
      if (i != 0)
      {
        paramList.clear();
        bool = a("", 0);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[doUserDownloadResource]parseConfigData:errCode=" + i + ", successReset=" + bool + ", config_content=" + paramQQAppInterface, null);
        return i;
      }
      j = a(paramList);
      i = j;
    } while (j == 0);
    paramList.clear();
    boolean bool = a("", 0);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[doUserDownloadResource]checkResourceVersion:errCode=" + j + ", successReset=" + bool + ", config_content=" + paramQQAppInterface, null);
    return j;
  }
  
  private static int a(AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    String str = b();
    str = str + paramSVConfigItem.name;
    if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramSVConfigItem.check64BitReady())) {
      return a(paramSVConfigItem.name, paramSVConfigItem.arm64v8a_md5, paramSVConfigItem.armv7a_md5, str);
    }
    return a(paramSVConfigItem.name, paramSVConfigItem.armv7a_md5, paramSVConfigItem.arm64v8a_md5, str);
  }
  
  /* Error */
  private static int a(AEOldShortVideoResStatus.ISVConfig paramISVConfig)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore_2
    //   5: getstatic 32	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager:jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession	Ldov/com/qq/im/ae/download/old/AEOldShortVideoResManager$ConfigSession;
    //   8: getfield 245	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager$ConfigSession:jdField_a_of_type_Int	I
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
    //   34: getstatic 37	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   37: aload_0
    //   38: invokevirtual 249	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   41: istore_3
    //   42: ldc 115
    //   44: new 117	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   51: ldc 251
    //   53: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_3
    //   57: invokevirtual 177	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: aconst_null
    //   64: invokestatic 131	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: iload_2
    //   68: istore_1
    //   69: iload_3
    //   70: ifne -51 -> 19
    //   73: getstatic 37	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   76: aload_0
    //   77: invokevirtual 254	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   80: pop
    //   81: ldc 115
    //   83: ldc_w 256
    //   86: aconst_null
    //   87: invokestatic 131	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: iload_2
    //   91: istore_1
    //   92: goto -73 -> 19
    //   95: astore_0
    //   96: ldc 2
    //   98: monitorexit
    //   99: aload_0
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramISVConfig	AEOldShortVideoResStatus.ISVConfig
    //   11	81	1	i	int
    //   4	87	2	j	int
    //   41	29	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	12	95	finally
    //   34	67	95	finally
    //   73	90	95	finally
  }
  
  private static int a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, "", paramString3);
  }
  
  /* Error */
  private static int a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +43 -> 46
    //   6: ldc 115
    //   8: iconst_2
    //   9: new 117	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc_w 268
    //   23: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 270
    //   33: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_3
    //   47: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifeq +6 -> 56
    //   53: bipush 151
    //   55: ireturn
    //   56: aload_1
    //   57: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: ifeq +6 -> 66
    //   63: bipush 150
    //   65: ireturn
    //   66: new 276	java/io/File
    //   69: dup
    //   70: aload_3
    //   71: invokespecial 278	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore 5
    //   76: aload 5
    //   78: invokevirtual 281	java/io/File:exists	()Z
    //   81: ifne +48 -> 129
    //   84: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +39 -> 126
    //   90: ldc 115
    //   92: iconst_2
    //   93: new 117	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   100: aload_0
    //   101: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 283
    //   107: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_3
    //   111: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc_w 285
    //   117: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: bipush 149
    //   128: ireturn
    //   129: aconst_null
    //   130: astore 4
    //   132: aload_3
    //   133: invokestatic 294	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   136: invokestatic 300	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   139: astore_3
    //   140: invokestatic 266	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +43 -> 186
    //   146: ldc 115
    //   148: iconst_2
    //   149: new 117	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   156: aload_0
    //   157: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 302
    //   163: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_1
    //   167: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc_w 304
    //   173: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_3
    //   177: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload_1
    //   187: aload_3
    //   188: invokevirtual 310	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   191: ifeq +15 -> 206
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_3
    //   197: aload 5
    //   199: invokestatic 315	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   202: astore_3
    //   203: goto -63 -> 140
    //   206: aload_2
    //   207: invokestatic 319	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   210: ifne +116 -> 326
    //   213: aload_2
    //   214: aload_3
    //   215: invokevirtual 310	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   218: ifne +108 -> 326
    //   221: new 47	java/util/HashMap
    //   224: dup
    //   225: invokespecial 48	java/util/HashMap:<init>	()V
    //   228: astore_2
    //   229: aload_2
    //   230: ldc_w 321
    //   233: aload_0
    //   234: invokevirtual 325	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: pop
    //   238: aload_2
    //   239: ldc_w 327
    //   242: aload_1
    //   243: invokevirtual 325	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: pop
    //   247: aload_3
    //   248: ifnull +51 -> 299
    //   251: aload_2
    //   252: ldc_w 329
    //   255: aload_3
    //   256: invokevirtual 325	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: aload_2
    //   261: ldc_w 331
    //   264: aload 5
    //   266: invokevirtual 335	java/io/File:length	()J
    //   269: invokestatic 339	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   272: invokevirtual 325	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   275: pop
    //   276: invokestatic 344	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   279: invokestatic 350	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   282: ldc 194
    //   284: ldc_w 352
    //   287: iconst_1
    //   288: lconst_0
    //   289: lconst_0
    //   290: aload_2
    //   291: ldc 194
    //   293: invokevirtual 356	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   296: goto +30 -> 326
    //   299: ldc 194
    //   301: astore_3
    //   302: goto -51 -> 251
    //   305: astore_0
    //   306: ldc 115
    //   308: iconst_1
    //   309: ldc_w 358
    //   312: aload_0
    //   313: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: goto +10 -> 326
    //   319: astore_3
    //   320: aload 4
    //   322: astore_3
    //   323: goto -183 -> 140
    //   326: bipush 148
    //   328: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	paramString1	String
    //   0	329	1	paramString2	String
    //   0	329	2	paramString3	String
    //   0	329	3	paramString4	String
    //   130	191	4	localObject	Object
    //   74	191	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   132	140	196	java/lang/UnsatisfiedLinkError
    //   221	247	305	java/lang/Exception
    //   251	296	305	java/lang/Exception
    //   197	203	319	java/lang/Exception
  }
  
  public static int a(String paramString, List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    try
    {
      paramString = new JSONArray(paramString);
      j = paramString.length();
      if (j > 0) {
        break label211;
      }
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "parseConfigData: arrayLength=" + j, null);
      return -100;
    }
    catch (JSONException paramString)
    {
      int j;
      AEOldShortVideoResManager.SVConfigItem localSVConfigItem;
      if (!QLog.isColorLevel()) {
        break label124;
      }
      QLog.d("AEOldShortVideoResManager", 2, "parseConfigData[JSONException]", paramString);
      paramList.clear();
      for (i = -100;; i = 0)
      {
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "parseConfigData:errCode=" + i, null);
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
          QLog.d("AEOldShortVideoResManager", 2, "parseConfigData[OutOfMemoryError]", paramString);
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
      localSVConfigItem = (AEOldShortVideoResManager.SVConfigItem)JSONUtils.a(paramString.getJSONObject(i), AEOldShortVideoResManager.SVConfigItem.class);
      if (localSVConfigItem == null)
      {
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "parseConfigData:item=null i=" + i, null);
        paramList.clear();
        return -100;
      }
    }
  }
  
  private static int a(List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (j < paramList.size())
      {
        i = AEOldShortVideoBusinessProcess.a((AEOldShortVideoResManager.SVConfigItem)paramList.get(j));
        if (i == 0) {}
      }
      else
      {
        j = i;
        if (i == 0) {
          j = b(paramList);
        }
        return j;
      }
      j += 1;
    }
  }
  
  public static AEOldShortVideoResManager a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      return (AEOldShortVideoResManager)paramQQAppInterface.getManager(QQManagerFactory.OLD_SHORT_VIDEO_RES_MANAGER);
    }
    return null;
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).getString("short_video_res_config_key", "");
  }
  
  public static String a(String paramString)
  {
    String str = b();
    return str + paramString;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 115
    //   5: new 117	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 426
    //   15: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokestatic 429	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager:c	()Ljava/lang/String;
    //   21: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: aconst_null
    //   28: invokestatic 131	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   31: getstatic 32	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager:jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession	Ldov/com/qq/im/ae/download/old/AEOldShortVideoResManager$ConfigSession;
    //   34: getfield 245	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager$ConfigSession:jdField_a_of_type_Int	I
    //   37: iconst_1
    //   38: if_icmpne +14 -> 52
    //   41: getstatic 32	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager:jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession	Ldov/com/qq/im/ae/download/old/AEOldShortVideoResManager$ConfigSession;
    //   44: iconst_2
    //   45: putfield 245	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager$ConfigSession:jdField_a_of_type_Int	I
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: ldc 115
    //   54: new 117	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 431
    //   64: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 32	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager:jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession	Ldov/com/qq/im/ae/download/old/AEOldShortVideoResManager$ConfigSession;
    //   70: invokevirtual 432	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager$ConfigSession:a	()Ljava/lang/String;
    //   73: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aconst_null
    //   80: invokestatic 131	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: getstatic 32	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager:jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession	Ldov/com/qq/im/ae/download/old/AEOldShortVideoResManager$ConfigSession;
    //   86: getfield 245	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager$ConfigSession:jdField_a_of_type_Int	I
    //   89: ifne -41 -> 48
    //   92: getstatic 37	dov/com/qq/im/ae/download/old/AEOldShortVideoResManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: invokevirtual 433	java/util/ArrayList:size	()I
    //   98: istore_0
    //   99: ldc 115
    //   101: new 117	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 435
    //   111: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: iload_0
    //   115: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aconst_null
    //   122: invokestatic 131	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onReceiveFailed:status=" + jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a() + " mGetConfigType" + jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.b + ",serverResult=" + paramInt + ",LogSignature=" + c(), null);
        if (jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int = 0;
          if (paramInt == 0)
          {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onReceiveFailed[RESULT_NO_DATA]", null);
            jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c = 1;
            jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.d = 0;
            paramInt = jdField_a_of_type_JavaUtilArrayList.size() - 1;
            if (paramInt >= 0)
            {
              if (jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null) {
                break label244;
              }
              ((AEOldShortVideoResStatus.ISVConfig)jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c, jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.d);
              break label244;
            }
          }
          else
          {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onReceiveFailed[RESULT_FAILED]", null);
            jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c = -1;
            jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.d = paramInt;
            continue;
          }
          jdField_a_of_type_JavaUtilArrayList.clear();
        }
      }
      finally {}
      for (;;)
      {
        return;
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "ShortVideoResourceManager[onReceiveFailed] mConfigStatus=" + jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a(), null);
      }
      label244:
      paramInt -= 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    
    if (paramInt != 3)
    {
      a(paramQQAppInterface, paramInt, a(paramQQAppInterface));
      return;
    }
    throw new Error("preDownloadShortVideoConfigData: call user type...");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, AEOldShortVideoResStatus.ISVConfig paramISVConfig)
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int == 0)
        {
          if (paramInt == 3)
          {
            i = b();
            if (i == 0)
            {
              if (paramISVConfig != null) {
                paramISVConfig.a(1, i);
              }
              return;
            }
          }
          int i = a();
          String str = a();
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doUserDownload[Begin download print]:version=" + i + " config_content" + str, null);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "downloadShortVideoConfigData LogSignature=" + c(), null);
          jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int = 1;
          jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.b = paramInt;
          jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c = 0;
          jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.d = 0;
          ConfigServlet.b(paramQQAppInterface, paramInt);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "downloadShortvideoConfigData[request started]:status=" + jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a() + " mGetConfigType" + jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.b, null);
          if (paramISVConfig == null) {
            continue;
          }
          boolean bool = jdField_a_of_type_JavaUtilArrayList.contains(paramISVConfig);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "downloadShortVideoConfigData contains=" + bool, null);
          if (bool) {
            continue;
          }
          if (paramInt == 3) {
            break label319;
          }
          jdField_a_of_type_JavaUtilArrayList.add(0, paramISVConfig);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "downloadShortVideoConfigData: add callBack OK...", null);
          continue;
        }
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "downloadShortvideoConfigData[request pending]:status=" + jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a() + " mGetConfigType" + jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.b, null);
      }
      finally {}
      continue;
      label319:
      jdField_a_of_type_JavaUtilArrayList.add(paramISVConfig);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, AEOldShortVideoResStatus.ISVConfig paramISVConfig)
  {
    a(paramQQAppInterface, 3, paramISVConfig);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    ThreadManager.excute(new AEOldShortVideoResManager.2(paramQQAppInterface, paramList), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<AEOldShortVideoResManager.SVConfigItem> paramList, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.excute(new AEOldShortVideoResManager.3(paramQQAppInterface, paramList, paramINet_ShortVideoResource), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<AEOldShortVideoResManager.SVConfigItem> paramList, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource, String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      AEOldShortVideoResManager.SVConfigItem localSVConfigItem;
      try
      {
        if (i < paramList.size())
        {
          localSVConfigItem = (AEOldShortVideoResManager.SVConfigItem)paramList.get(i);
          if (!localSVConfigItem.name.startsWith(paramString)) {
            break label228;
          }
          if (paramQQAppInterface != null) {
            continue;
          }
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doUserDownloadResourceWithNamePrefix: app=null [RES_APP_INTERFACE_NULL_ERROR]", null);
          if (paramINet_ShortVideoResource != null) {
            paramINet_ShortVideoResource.a(localSVConfigItem.name, -1501, "");
          }
        }
        return;
        boolean bool = a(paramQQAppInterface, localSVConfigItem);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doUserDownloadResourceWithNamePrefix: needDownload=" + bool, null);
        if (bool)
        {
          paramQQAppInterface = a(paramQQAppInterface);
          if (paramQQAppInterface == null) {
            continue;
          }
          paramQQAppInterface.a(localSVConfigItem, paramINet_ShortVideoResource);
          continue;
        }
        paramList = a(localSVConfigItem.name);
      }
      finally {}
      i = a(paramQQAppInterface, localSVConfigItem);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doUserDownloadResourceWithNamePrefix:[doNoNeedDownload] itemConfig.name = " + localSVConfigItem.name + ", errCode=" + i, null);
      if (paramINet_ShortVideoResource != null)
      {
        paramINet_ShortVideoResource.a(localSVConfigItem.name, i, paramList);
        continue;
        label228:
        i += 1;
      }
    }
  }
  
  private void a(NetResp arg1)
  {
    int j = 0;
    Object localObject1 = ???.mReq;
    String str1 = ((NetReq)localObject1).mOutPath;
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]filePath=" + str1 + ",resp.mResult=" + ???.mResult + ",mHttpCode=" + ???.mHttpCode + ",mErrCode=" + ???.mErrCode + ",mErrDesc=" + ???.mErrDesc, null);
    localObject1 = (String)((NetReq)localObject1).getUserData();
    if (localObject1 == null) {}
    for (;;)
    {
      AEOldShortVideoResManager.HttpEngineSession localHttpEngineSession;
      String str2;
      int k;
      int i;
      synchronized (this.b)
      {
        localHttpEngineSession = (AEOldShortVideoResManager.HttpEngineSession)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
        str2 = localHttpEngineSession.jdField_a_of_type_JavaLangString;
        k = localHttpEngineSession.jdField_a_of_type_Int;
        String str3 = b();
        ??? = str3 + (String)localObject1;
        if (???.mResult == 0)
        {
          i = a((String)localObject1, str2, str1);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]verifyResource keyName=" + (String)localObject1 + ",errCode=" + i, null);
          if (i != 0)
          {
            if (i == -108)
            {
              boolean bool = a(str3 + (String)localObject1 + "error", str1);
              VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]renameResourceZip, save error file, success=" + bool, null);
            }
            a(str1);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]verifyResource clearDownloadTempFile errCode=" + i, null);
            AEOldShortVideoResStatus.a((String)localObject1, k, 0, i);
            label341:
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onRespAsync]errCode=" + i + ",saveFilePath=" + (String)??? + ",key=" + (String)localObject1, null);
          }
        }
      }
      synchronized (this.b)
      {
        localHttpEngineSession.b = 3;
        k = localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.size();
        for (;;)
        {
          if (j < k) {}
          try
          {
            if ((localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.get(j) != null) && (localObject1 != null)) {
              ((AEOldShortVideoResManager.INet_ShortVideoResource)localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.get(j)).a((String)localObject1, i, (String)???);
            }
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
          {
            label457:
            break label457;
          }
          j += 1;
          continue;
          ??? = finally;
          throw ???;
          if (a((String)???, str1))
          {
            ??? = str2 + '_' + k;
            i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, ???, (String)???, k);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onRespAsync]signature=" + ??? + ",errCode=" + i + ",key=" + (String)localObject1, null);
            break;
          }
          i = -3;
          a((String)???);
          a(str1);
          break;
          AEOldShortVideoResStatus.a((String)localObject1, k, 1, -117);
          a(str1);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]filePath=" + str1 + ",resp.mResult=" + ???.mResult + ",mErrDesc=" + ???.mErrDesc + ",mErrDesc=" + ???.mErrDesc, null);
          i = -117;
          break label341;
        }
        localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilHashMap.remove(localObject1);
        return;
      }
    }
  }
  
  private static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  private void a(List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    ThreadManager.excute(new AEOldShortVideoResManager.8(this, paramList), 128, null, false);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    String str = a(paramSVConfigItem.name);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload:name=" + paramSVConfigItem.name, null);
    AEOldShortVideoResStatus.ResStatus localResStatus = AEOldShortVideoResStatus.a(paramSVConfigItem.name);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload:versionCode=" + paramSVConfigItem.versionCode + " status.version" + localResStatus.jdField_a_of_type_Int + ",status.lastErr=" + localResStatus.c, null);
    if (!AEOldShortVideoBusinessProcess.a(paramQQAppInterface, paramSVConfigItem)) {
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload:userDownload=false", null);
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
          if (paramSVConfigItem.versionCode <= localResStatus.jdField_a_of_type_Int) {
            break label243;
          }
          if (localResStatus.jdField_a_of_type_Int != 0) {
            break label236;
          }
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload:status.version=0", null);
          if (!new File(str).exists()) {
            break;
          }
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload:[exists]filePath=" + str, null);
          i = a(paramSVConfigItem);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload[zipVerifyMd5]:errCode=" + i, null);
        } while (i == 0);
        a(str);
        return true;
        a(str);
        return true;
      } while (paramSVConfigItem.versionCode != localResStatus.jdField_a_of_type_Int);
      if (localResStatus.b != 0)
      {
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload[No equal]:status=" + localResStatus.b + ",version" + localResStatus.jdField_a_of_type_Int, null);
        a(str);
        return true;
      }
      boolean bool = a(paramSVConfigItem.name);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload[equal]:exist=" + bool, null);
      if (!bool) {
        return true;
      }
      int i = a(paramSVConfigItem);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload[equal]:errCode=" + i, null);
      if (i != 0)
      {
        a(str);
        return true;
      }
    } while (localResStatus.c == 0);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload[equal]:status=" + localResStatus.b + ",lastErr" + localResStatus.c, null);
    return false;
  }
  
  private boolean a(AEOldShortVideoResManager.SVConfigItem paramSVConfigItem, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource, boolean[] paramArrayOfBoolean)
  {
    String str = a(paramSVConfigItem.name);
    boolean bool = AEOldShortVideoBusinessProcess.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem.name);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doRealSendRequest:alreadyExists=" + bool, null);
    paramArrayOfBoolean[0] = bool;
    if (bool)
    {
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doRealSendRequest:onDownloadFinish...", null);
      if (paramINet_ShortVideoResource != null) {
        paramINet_ShortVideoResource.a(paramSVConfigItem.name, 0, str);
      }
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doRealSendRequest:itemConfig.versionCode=" + paramSVConfigItem.versionCode, null);
      bool = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem);
      if (!bool)
      {
        int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doRealSendRequest:doNoNeedDownload_errCode=" + i, null);
        if (i == 0) {}
      }
      return bool;
    }
    return true;
  }
  
  private static boolean a(String paramString)
  {
    String str = b();
    return FileUtils.a(str + paramString);
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).edit();
    localEditor.putString("short_video_res_config_key", paramString);
    localEditor.putInt("short_video_resource_version", paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("AEOldShortVideoResManager", 2, "updateShortVideoResConfigContent| saveContentOK，config_content = " + paramString);
    }
    return localEditor.commit();
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]renameResourceZip destPath=" + paramString1 + ",outPath=" + paramString2, null);
      paramString1 = new File(paramString1);
      if (paramString1.exists())
      {
        paramString1.delete();
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]renameResourceZip rename  destFile already exists[delete]...", null);
      }
      paramString2 = new File(paramString2);
      long l1 = paramString2.length();
      boolean bool = paramString2.renameTo(paramString1);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]renameResourceZip orgLength=" + l1 + ",success=" + bool, null);
      if (bool)
      {
        bool = paramString1.exists();
        long l2 = paramString1.length();
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]renameResourceZip destExists=" + bool + ",destLength=" + l2, null);
        if ((bool) && (l2 == l1)) {
          return true;
        }
      }
      return false;
    }
  }
  
  private static int b()
  {
    int i = a();
    String str = a();
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkLocalConfigIsOK:version=" + i + " config_content" + str, null);
    if ((i != 0) && (!TextUtils.isEmpty(str)))
    {
      ArrayList localArrayList = new ArrayList();
      int j = a(str, localArrayList);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkLocalConfigIsOK:parseConfigData_errCode=" + j, null);
      i = j;
      if (j == 0) {
        i = a(localArrayList);
      }
      return i;
    }
    return -101;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, AEOldShortVideoResStatus.ISVConfig paramISVConfig)
  {
    int i = 0;
    f();
    int j = b();
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "startUserDownloadConfig[checkLocalConfigIsOK]:errCode=" + j, null);
    if (j != 0)
    {
      boolean bool = NetworkUtil.g(null);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "startUserDownloadConfig:netUsable=" + bool, null);
      j = a(paramISVConfig);
      if (j == -115)
      {
        a(paramQQAppInterface, paramISVConfig);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "startUserDownloadConfig[end]:errCode=" + i, null);
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
  
  private static int b(List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.e("AEOldShortVideoResManager", 1, "checkFaceIdentityResVersion: error: listItem is null or empty");
      return -125;
    }
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (AEOldShortVideoResManager.SVConfigItem)((Iterator)localObject).next();
      if (paramList.name.startsWith("new_qq_android_native_short_new_other_"))
      {
        localObject = "new_qq_android_native_short_new_other_" + paramList.versionCode;
        if (!paramList.name.equalsIgnoreCase((String)localObject))
        {
          QLog.e("AEOldShortVideoResManager", 1, new Object[] { "checkFaceIdentityResVersion: check name ignore error, itemName: ", paramList.name, " validName : ", localObject });
          return -4;
        }
        if (paramList.versionCode < 3)
        {
          QLog.e("AEOldShortVideoResManager", 1, new Object[] { "checkFaceIdentityResVersion:item.versionCode=", Integer.valueOf(paramList.versionCode), " buildInOther=", Integer.valueOf(3) });
          return -2;
        }
        return 0;
      }
    }
    return -2;
  }
  
  public static String b()
  {
    return AEOldPath.CAMERA.FILES.b;
  }
  
  public static void b()
  {
    for (;;)
    {
      try
      {
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onReceiveNoDataUpdate LogSignature=" + c(), null);
        int i;
        if (jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int = 0;
          jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c = 1;
          i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i >= 0)
          {
            if (jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
              ((AEOldShortVideoResStatus.ISVConfig)jdField_a_of_type_JavaUtilArrayList.get(i)).a(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c, 0);
            }
          }
          else {
            jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        else
        {
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "ShortVideoResourceManager[onReceiveNoDataUpdate] mConfigStatus=" + jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a(), null);
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
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onReceiveSuccess LogSignature=" + c(), null);
        int i;
        if (jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.jdField_a_of_type_Int = 0;
          jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c = 0;
          i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i >= 0)
          {
            if (jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
              ((AEOldShortVideoResStatus.ISVConfig)jdField_a_of_type_JavaUtilArrayList.get(i)).a(jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.c, paramInt);
            }
          }
          else {
            jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        else
        {
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "ShortVideoResourceManager[onReceiveSuccess] mConfigStatus=" + jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.a(), null);
          continue;
        }
        i -= 1;
      }
      finally {}
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<AEOldShortVideoResManager.SVConfigItem> paramList, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.excute(new AEOldShortVideoResManager.5(paramQQAppInterface, paramList, paramINet_ShortVideoResource), 128, null, false);
  }
  
  private void b(List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    Object localObject = jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      AEOldShortVideoResManager.SVConfigItem localSVConfigItem;
      try
      {
        if (i >= paramList.size()) {
          break label119;
        }
        localSVConfigItem = (AEOldShortVideoResManager.SVConfigItem)paramList.get(i);
        if (!localSVConfigItem.predownload) {
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "preDownloadResource:parseConfigData predownload=false", null);
        } else if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSVConfigItem)) {
          a(localSVConfigItem, null);
        }
      }
      finally {}
      int j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSVConfigItem);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "preDownloadResourceSync:needDownload=false [doNoNeedDownload] errCode=" + j, null);
      break label123;
      label119:
      return;
      label123:
      i += 1;
    }
  }
  
  private static String c()
  {
    return "hashCode=" + jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.hashCode() + " ,pid=" + Process.myPid() + ",tid" + Process.myTid();
  }
  
  public static void c(QQAppInterface paramQQAppInterface, List<AEOldShortVideoResManager.SVConfigItem> paramList, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    ThreadManager.excute(new AEOldShortVideoResManager.7(paramQQAppInterface, paramList, paramINet_ShortVideoResource), 128, null, false);
  }
  
  private static String d()
  {
    return AEOldPathBase.TMP.jdField_a_of_type_JavaLangString + File.separator;
  }
  
  private void e()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        AEOldShortVideoResManager.HttpEngineSession localHttpEngineSession = (AEOldShortVideoResManager.HttpEngineSession)localIterator.next();
        if ((localHttpEngineSession != null) && (localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList != null))
        {
          int i = 0;
          while (i < localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.size())
          {
            ((AEOldShortVideoResManager.INet_ShortVideoResource)localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
            i += 1;
          }
        }
      }
      return;
    }
  }
  
  private static void f()
  {
    File localFile = new File(b());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(d());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public int a(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEOldShortVideoResManager", 2, "updateShortVideoResConfigContent|received save version: " + paramInt + ", config_content: " + paramString);
    }
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      int j = -101;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("AEOldShortVideoResManager", 2, "updateShortVideoResConfigContent| version: " + paramInt + ",config_content: " + paramString);
        i = j;
      }
      return i;
    }
    boolean bool = a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("AEOldShortVideoResManager", 2, "updateShortVideoResConfigContent| saveContentOK: " + bool);
    }
    if (bool) {}
    for (paramInt = 0;; paramInt = -128)
    {
      i = paramInt;
      if (!bool) {
        break;
      }
      bool = AEOldShortVideoResDownload.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      i = paramInt;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AEOldShortVideoResManager", 2, "updateShortVideoResConfigContent| downloadState: " + bool);
      return paramInt;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    QLog.d("AEOldShortVideoResManager", 1, "updateShortVideoOtherConfigOnly|received save version: " + paramInt + ", config_content: " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("AEOldShortVideoResManager", 1, "updateShortVideoOtherConfigOnly| version: " + paramInt + ",config_content: " + paramString);
      return -101;
    }
    boolean bool = a(paramString, paramInt);
    QLog.d("AEOldShortVideoResManager", 1, "updateShortVideoOtherConfigOnly| saveContentOK: " + bool);
    if (bool) {
      return 0;
    }
    return -128;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:result=" + paramInt1 + ",serverError" + paramInt2 + ",getType=" + jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$ConfigSession.b, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0) {
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:RESULT_OK,saveError=" + paramInt2, null);
      }
    }
    else {
      return;
    }
    paramInt1 = a();
    String str = a();
    boolean bool;
    if ((paramInt1 == 0) || (TextUtils.isEmpty(str)))
    {
      bool = a("", 0);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:version=" + paramInt1 + ",successReset=" + bool + ",config_content=" + str, null);
      return;
    }
    ArrayList localArrayList = new ArrayList(1);
    paramInt1 = a(str, localArrayList);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:parseConfigData_errCode=" + paramInt1, null);
    if (paramInt1 == -100)
    {
      bool = a("", 0);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:parseConfigData_errCode=" + paramInt1 + ",successReset=" + bool, null);
      return;
    }
    if (paramInt1 == 0)
    {
      paramInt1 = a(localArrayList);
      if (paramInt1 != 0)
      {
        bool = a("", 0);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:checkResourceVersion errCode=" + paramInt1 + ",successReset=" + bool, null);
        return;
      }
      a(localArrayList);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:success,sendRequest or no needDownload or predownload = false...", null);
      return;
    }
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:parseConfigData Other error code ...", null);
  }
  
  public void a(AEOldShortVideoResManager.SVConfigItem paramSVConfigItem, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource)
  {
    for (;;)
    {
      Object localObject2;
      boolean bool;
      synchronized (this.b)
      {
        localObject2 = (AEOldShortVideoResManager.HttpEngineSession)this.jdField_a_of_type_JavaUtilHashMap.get(paramSVConfigItem.name);
        if (localObject2 != null) {
          break label361;
        }
        localObject2 = new boolean[1];
        bool = a(paramSVConfigItem, paramINet_ShortVideoResource, (boolean[])localObject2);
        if (localObject2[0] != 0) {
          paramINet_ShortVideoResource = null;
        }
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doRealSendRequest:doDownload=" + bool, null);
        HttpNetReq localHttpNetReq;
        if (bool)
        {
          localObject2 = b();
          a((String)localObject2 + paramSVConfigItem.name);
          localObject2 = d();
          a((String)localObject2 + paramSVConfigItem.name);
          localHttpNetReq = new HttpNetReq();
          localHttpNetReq.mCallback = this;
          if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramSVConfigItem.check64BitReady()))
          {
            localHttpNetReq.mReqUrl = paramSVConfigItem.arm64v8a_url;
            localHttpNetReq.mHttpMethod = 0;
            localHttpNetReq.mOutPath = ((String)localObject2 + paramSVConfigItem.name);
            localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
            localHttpNetReq.bAcceptNegativeContentLength = true;
            localHttpNetReq.setUserData(paramSVConfigItem.name);
            localObject2 = new AEOldShortVideoResManager.HttpEngineSession(this, localHttpNetReq);
            ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_Int = paramSVConfigItem.versionCode;
            if ((!VideoEnvironment64BitUtils.checkIs64bit()) || (!paramSVConfigItem.check64BitReady())) {
              break label349;
            }
            ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.arm64v8a_md5;
            if (paramINet_ShortVideoResource != null)
            {
              ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramINet_ShortVideoResource);
              VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[session][new]add callBack ok...", null);
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(paramSVConfigItem.name, localObject2);
            ((AEOldShortVideoResManager.HttpEngineSession)localObject2).a();
          }
        }
        else
        {
          return;
        }
        localHttpNetReq.mReqUrl = paramSVConfigItem.armv7a_url;
      }
      label349:
      ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_md5;
      continue;
      label361:
      if (((AEOldShortVideoResManager.HttpEngineSession)localObject2).b == 0)
      {
        ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_Int = paramSVConfigItem.versionCode;
        if ((VideoEnvironment64BitUtils.checkIs64bit()) && (paramSVConfigItem.check64BitReady())) {}
        for (((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.arm64v8a_md5;; ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_md5)
        {
          if (paramINet_ShortVideoResource != null)
          {
            bool = ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaUtilArrayList.contains(paramINet_ShortVideoResource);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[oldSession][start]contains=" + bool, null);
            if (!bool)
            {
              ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramINet_ShortVideoResource);
              VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[oldSession][start]add callBack ok...", null);
            }
          }
          ((AEOldShortVideoResManager.HttpEngineSession)localObject2).a();
          break;
        }
      }
      if (paramINet_ShortVideoResource != null)
      {
        bool = ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaUtilArrayList.contains(paramINet_ShortVideoResource);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[oldSession][pending]contains=" + bool, null);
        if (!bool)
        {
          ((AEOldShortVideoResManager.HttpEngineSession)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramINet_ShortVideoResource);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[oldSession][pending]add callBack ok...", null);
        }
      }
    }
  }
  
  public void c()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void d()
  {
    ??? = new ArrayList();
    ((List)???).add("new_qq_android_native_short_video_");
    ((List)???).add("new_qq_android_native_art_filter_");
    ((List)???).add("new_qq_android_native_portrait_filter_");
    ((List)???).add("new_qq_android_native_short_other_");
    Iterator localIterator = ((List)???).iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (String)localIterator.next();
      synchronized (this.b)
      {
        localObject3 = (AEOldShortVideoResManager.HttpEngineSession)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3);
        if (localObject3 != null) {
          ((AEOldShortVideoResManager.HttpEngineSession)localObject3).jdField_a_of_type_JavaUtilArrayList.clear();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    try
    {
      int i = jdField_a_of_type_JavaUtilArrayList.size();
      jdField_a_of_type_JavaUtilArrayList.clear();
      QLog.d("AEOldShortVideoResManager", 1, new Object[] { "onDestroy sizeCallBack = ", Integer.valueOf(i) });
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      AEOldShortVideoResDownload.a();
      d();
      return;
    }
    finally {}
  }
  
  public final void onResp(NetResp paramNetResp)
  {
    ThreadManager.post(new AEOldShortVideoResManager.9(this, paramNetResp), 5, null, false);
  }
  
  public final void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    String str = (String)???.getUserData();
    if (str == null) {}
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onUpdateProgeress]curOffset=" + paramLong1 + ",totalLen=" + paramLong2 + ",key=" + str, null);
    for (;;)
    {
      int i;
      synchronized (this.b)
      {
        AEOldShortVideoResManager.HttpEngineSession localHttpEngineSession = (AEOldShortVideoResManager.HttpEngineSession)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        localHttpEngineSession.b = 2;
        int j = localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.size();
        i = 0;
        if (i < j)
        {
          if ((localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.get(i) != null) && (str != null)) {
            ((AEOldShortVideoResManager.INet_ShortVideoResource)localHttpEngineSession.jdField_a_of_type_JavaUtilArrayList.get(i)).a(str, paramLong1, paramLong2);
          }
        }
        else
        {
          i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onUpdateProgeress]downloadProgress=" + i + ",key=" + str, null);
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResManager
 * JD-Core Version:    0.7.0.1
 */