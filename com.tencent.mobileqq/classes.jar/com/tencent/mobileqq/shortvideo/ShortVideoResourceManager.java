package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import aova;
import ayyv;
import ayzp;
import ayzs;
import ayzu;
import ayzv;
import ayzw;
import ayzx;
import ayzy;
import ayzz;
import azax;
import baps;
import bapx;
import baqv;
import baqw;
import baqx;
import bavr;
import bcyj;
import bdcs;
import bdee;
import bkks;
import bklc;
import bkwi;
import blfg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
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
  implements ayzy, bapx, Manager
{
  public static long a;
  private static ayzu jdField_a_of_type_Ayzu = new ayzu();
  private static final Object jdField_a_of_type_JavaLangObject;
  private static ArrayList<ayzy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ayzs(this);
  private HashMap<String, ayzv> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Object b = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    f();
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
  
  /* Error */
  private static int a(ayzy paramayzy)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore_2
    //   5: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Ayzu	Layzu;
    //   8: getfield 95	ayzu:jdField_a_of_type_Int	I
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
    //   34: getstatic 35	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   37: aload_0
    //   38: invokevirtual 99	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   41: istore_3
    //   42: ldc 101
    //   44: new 103	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   51: ldc 106
    //   53: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_3
    //   57: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: aconst_null
    //   64: invokestatic 120	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: iload_2
    //   68: istore_1
    //   69: iload_3
    //   70: ifne -51 -> 19
    //   73: getstatic 35	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   76: aload_0
    //   77: invokevirtual 123	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   80: pop
    //   81: ldc 101
    //   83: ldc 125
    //   85: aconst_null
    //   86: invokestatic 120	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   0	100	0	paramayzy	ayzy
    //   11	80	1	i	int
    //   4	86	2	j	int
    //   41	29	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	12	94	finally
    //   34	67	94	finally
    //   73	89	94	finally
  }
  
  public static int a(@Nullable QQAppInterface paramQQAppInterface, ayzy paramayzy)
  {
    int i;
    if (paramQQAppInterface == null) {
      i = -101;
    }
    int j;
    do
    {
      return i;
      j = a(paramayzy);
      blfg.b("ShortVideoResourceManager", "startUserDownloadConfigUpdateForce[checkLocalConfigIsOK]:errCode=" + j);
      if (j == -115)
      {
        a(paramQQAppInterface, paramayzy);
        return 0;
      }
      i = j;
    } while (j != -116);
    return j;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str1 = a(paramSVConfigItem.name);
    if (ayyv.a(paramQQAppInterface, paramSVConfigItem))
    {
      String str2 = paramSVConfigItem.getSignature();
      VideoEnvironment.a("ShortVideoResourceManager", "doNoNeedDownload: signature=" + str2, null);
      int i = a(paramQQAppInterface, paramSVConfigItem.name, str2, str1, paramSVConfigItem.versionCode);
      if (i != 0)
      {
        ayzx.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, -1, i);
        b(str1);
        VideoEnvironment.a("ShortVideoResourceManager", "doNoNeedDownload: errCode=" + i, null);
        return i;
      }
      ayzx.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, 0, i);
      return i;
    }
    VideoEnvironment.a("ShortVideoResourceManager", "doNoNeedDownload: sysSupport=false", null);
    return -1000;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = ayyv.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    VideoEnvironment.a("ShortVideoResourceManager", "[userUncompressZipResource]needRestore=" + bool + ",keyName=" + paramString1, null);
    if (bool) {}
    for (paramInt = -118;; paramInt = 0)
    {
      VideoEnvironment.a("ShortVideoResourceManager", "[userUncompressZipResource]errCode=" + paramInt + ",keyName=" + paramString1, null);
      return paramInt;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    int i = a();
    paramQQAppInterface = a();
    if ((i == 0) || (TextUtils.isEmpty(paramQQAppInterface)))
    {
      bool = a("", 0);
      VideoEnvironment.a("ShortVideoResourceManager", "[checkConfigResourceIsOK]:version=" + i + ", successReset=" + bool + ", config_content=" + paramQQAppInterface, null);
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
        VideoEnvironment.a("ShortVideoResourceManager", "[doUserDownloadResource]parseConfigData:errCode=" + i + ", successReset=" + bool + ", config_content=" + paramQQAppInterface, null);
        return i;
      }
      j = a(paramList);
      i = j;
    } while (j == 0);
    paramList.clear();
    boolean bool = a("", 0);
    VideoEnvironment.a("ShortVideoResourceManager", "[doUserDownloadResource]checkResourceVersion:errCode=" + j + ", successReset=" + bool + ", config_content=" + paramQQAppInterface, null);
    return j;
  }
  
  private static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str = b();
    str = str + paramSVConfigItem.name;
    if ((azax.a()) && (paramSVConfigItem.check64BitReady())) {
      return a(paramSVConfigItem.name, paramSVConfigItem.arm64v8a_md5, paramSVConfigItem.armv7a_md5, str);
    }
    return a(paramSVConfigItem.name, paramSVConfigItem.armv7a_md5, paramSVConfigItem.arm64v8a_md5, str);
  }
  
  private static int a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, "", paramString3);
  }
  
  /* Error */
  private static int a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +43 -> 46
    //   6: ldc 101
    //   8: iconst_2
    //   9: new 103	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc_w 263
    //   23: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 265
    //   33: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_3
    //   47: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifeq +6 -> 56
    //   53: bipush 151
    //   55: ireturn
    //   56: aload_1
    //   57: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: ifeq +6 -> 66
    //   63: bipush 150
    //   65: ireturn
    //   66: new 271	java/io/File
    //   69: dup
    //   70: aload_3
    //   71: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore 5
    //   76: aload 5
    //   78: invokevirtual 276	java/io/File:exists	()Z
    //   81: ifne +48 -> 129
    //   84: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +39 -> 126
    //   90: ldc 101
    //   92: iconst_2
    //   93: new 103	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   100: aload_0
    //   101: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 278
    //   107: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_3
    //   111: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc_w 280
    //   117: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: bipush 149
    //   128: ireturn
    //   129: aconst_null
    //   130: astore 4
    //   132: aload_3
    //   133: invokestatic 289	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   136: invokestatic 295	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   139: astore_3
    //   140: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +43 -> 186
    //   146: ldc 101
    //   148: iconst_2
    //   149: new 103	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   156: aload_0
    //   157: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 297
    //   163: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_1
    //   167: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc_w 299
    //   173: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_3
    //   177: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload_1
    //   187: aload_3
    //   188: invokevirtual 305	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   191: ifeq +15 -> 206
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_3
    //   197: aload 5
    //   199: invokestatic 310	bhli:a	(Ljava/io/File;)Ljava/lang/String;
    //   202: astore_3
    //   203: goto -63 -> 140
    //   206: aload_2
    //   207: invokestatic 314	bdje:a	(Ljava/lang/String;)Z
    //   210: ifne +116 -> 326
    //   213: aload_2
    //   214: aload_3
    //   215: invokevirtual 305	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   218: ifne +108 -> 326
    //   221: new 45	java/util/HashMap
    //   224: dup
    //   225: invokespecial 46	java/util/HashMap:<init>	()V
    //   228: astore_2
    //   229: aload_2
    //   230: ldc_w 316
    //   233: aload_0
    //   234: invokevirtual 320	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: pop
    //   238: aload_2
    //   239: ldc_w 322
    //   242: aload_1
    //   243: invokevirtual 320	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: pop
    //   247: aload_3
    //   248: ifnull +51 -> 299
    //   251: aload_2
    //   252: ldc_w 324
    //   255: aload_3
    //   256: invokevirtual 320	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: aload_2
    //   261: ldc_w 326
    //   264: aload 5
    //   266: invokevirtual 330	java/io/File:length	()J
    //   269: invokestatic 334	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   272: invokevirtual 320	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   275: pop
    //   276: invokestatic 340	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   279: invokestatic 345	azmz:a	(Landroid/content/Context;)Lazmz;
    //   282: ldc 203
    //   284: ldc_w 347
    //   287: iconst_1
    //   288: lconst_0
    //   289: lconst_0
    //   290: aload_2
    //   291: ldc 203
    //   293: invokevirtual 350	azmz:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   296: goto +30 -> 326
    //   299: ldc 203
    //   301: astore_3
    //   302: goto -51 -> 251
    //   305: astore_0
    //   306: ldc 101
    //   308: iconst_1
    //   309: ldc_w 352
    //   312: aload_0
    //   313: invokestatic 355	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
  
  public static int a(String paramString, List<ShortVideoResourceManager.SVConfigItem> paramList)
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
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)bcyj.a(paramString.getJSONObject(i), ShortVideoResourceManager.SVConfigItem.class);
      if (localSVConfigItem == null)
      {
        VideoEnvironment.a("ShortVideoResourceManager", "parseConfigData:item=null i=" + i, null);
        paramList.clear();
        return -100;
      }
    }
  }
  
  private static int a(List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    int j = 0;
    int i = 0;
    while (i < paramList.size())
    {
      j = ayyv.a((ShortVideoResourceManager.SVConfigItem)paramList.get(i));
      if (j != 0) {
        return j;
      }
      i += 1;
    }
    return j;
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
    //   3: ldc 101
    //   5: new 103	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 406
    //   15: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokestatic 409	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:c	()Ljava/lang/String;
    //   21: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: aconst_null
    //   28: invokestatic 120	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   31: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Ayzu	Layzu;
    //   34: getfield 95	ayzu:jdField_a_of_type_Int	I
    //   37: iconst_1
    //   38: if_icmpne +14 -> 52
    //   41: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Ayzu	Layzu;
    //   44: iconst_2
    //   45: putfield 95	ayzu:jdField_a_of_type_Int	I
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: ldc 101
    //   54: new 103	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 411
    //   64: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Ayzu	Layzu;
    //   70: invokevirtual 412	ayzu:a	()Ljava/lang/String;
    //   73: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aconst_null
    //   80: invokestatic 120	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Ayzu	Layzu;
    //   86: getfield 95	ayzu:jdField_a_of_type_Int	I
    //   89: ifne -41 -> 48
    //   92: getstatic 35	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: invokevirtual 413	java/util/ArrayList:size	()I
    //   98: istore_0
    //   99: ldc 101
    //   101: new 103	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 415
    //   111: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: iload_0
    //   115: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aconst_null
    //   122: invokestatic 120	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
        VideoEnvironment.a("ShortVideoResourceManager", "onReceiveFailed:status=" + jdField_a_of_type_Ayzu.a() + " mGetConfigType" + jdField_a_of_type_Ayzu.b + ",serverResult=" + paramInt + ",LogSignature=" + c(), null);
        if (jdField_a_of_type_Ayzu.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_Ayzu.jdField_a_of_type_Int = 0;
          if (paramInt == 0)
          {
            VideoEnvironment.a("ShortVideoResourceManager", "onReceiveFailed[RESULT_NO_DATA]", null);
            jdField_a_of_type_Ayzu.jdField_c_of_type_Int = 1;
            jdField_a_of_type_Ayzu.d = 0;
            paramInt = jdField_a_of_type_JavaUtilArrayList.size() - 1;
            if (paramInt >= 0)
            {
              if (jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null) {
                break label244;
              }
              ((ayzy)jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(jdField_a_of_type_Ayzu.jdField_c_of_type_Int, jdField_a_of_type_Ayzu.d);
              break label244;
            }
          }
          else
          {
            VideoEnvironment.a("ShortVideoResourceManager", "onReceiveFailed[RESULT_FAILED]", null);
            jdField_a_of_type_Ayzu.jdField_c_of_type_Int = -1;
            jdField_a_of_type_Ayzu.d = paramInt;
            continue;
          }
          jdField_a_of_type_JavaUtilArrayList.clear();
        }
      }
      finally {}
      for (;;)
      {
        return;
        VideoEnvironment.a("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveFailed] mConfigStatus=" + jdField_a_of_type_Ayzu.a(), null);
      }
      label244:
      paramInt -= 1;
    }
  }
  
  private void a(baqw parambaqw)
  {
    Object localObject1 = parambaqw.jdField_a_of_type_Baqv;
    ??? = ((baqv)localObject1).jdField_c_of_type_JavaLangString;
    VideoEnvironment.a("ShortVideoResourceManager", "[onResp]filePath=" + (String)??? + ",resp.mResult=" + parambaqw.jdField_a_of_type_Int + ",mHttpCode=" + parambaqw.jdField_c_of_type_Int + ",mErrCode=" + parambaqw.b + ",mErrDesc=" + parambaqw.jdField_a_of_type_JavaLangString, null);
    localObject1 = (String)((baqv)localObject1).a();
    if (localObject1 == null) {}
    for (;;)
    {
      ayzv localayzv;
      Object localObject4;
      int j;
      int i;
      synchronized (this.b)
      {
        localayzv = (ayzv)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
        localObject4 = localayzv.jdField_a_of_type_JavaLangString;
        j = localayzv.jdField_a_of_type_Int;
        String str = b();
        ??? = str + (String)localObject1;
        if (parambaqw.jdField_a_of_type_Int == 0)
        {
          i = a((String)localObject1, (String)localObject4, (String)???);
          VideoEnvironment.a("ShortVideoResourceManager", "[onResp]verifyResource keyName=" + (String)localObject1 + ",errCode=" + i, null);
          if (i != 0)
          {
            if (i == -108)
            {
              boolean bool = a(str + (String)localObject1 + "error", (String)???);
              VideoEnvironment.a("ShortVideoResourceManager", "[onResp]renameResourceZip, save error file, success=" + bool, null);
            }
            b((String)???);
            VideoEnvironment.a("ShortVideoResourceManager", "[onResp]verifyResource clearDownloadTempFile errCode=" + i, null);
            ayzx.a((String)localObject1, j, 0, i);
            label337:
            VideoEnvironment.a("ShortVideoResourceManager", "[onRespAsync]errCode=" + i + ",saveFilePath=" + (String)??? + ",key=" + (String)localObject1, null);
          }
        }
      }
      synchronized (this.b)
      {
        localayzv.b = 3;
        int k = localayzv.jdField_a_of_type_JavaUtilArrayList.size();
        j = 0;
        label412:
        if (j < k) {
          for (;;)
          {
            try
            {
              if (localayzv.jdField_a_of_type_JavaUtilArrayList.get(j) != null)
              {
                if (localObject1 != null) {
                  ((ayzw)localayzv.jdField_a_of_type_JavaUtilArrayList.get(j)).a((String)localObject1, i, (String)???);
                }
                localObject4 = (bavr)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(193);
                if ((localObject1 != null) && (((String)localObject1).startsWith("new_qq_android_native_short_filter_")) && (((bavr)localObject4).a()) && (!bkwi.a().a()))
                {
                  if (i != 0) {
                    continue;
                  }
                  ((bavr)localObject4).a((String)parambaqw.jdField_a_of_type_JavaUtilHashMap.get("param_url"), parambaqw.jdField_a_of_type_Long);
                }
              }
            }
            catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
            {
              continue;
            }
            j += 1;
            break label412;
            parambaqw = finally;
            throw parambaqw;
            if (a((String)???, (String)???))
            {
              ??? = (String)localObject4 + '_' + j;
              i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, (String)???, (String)???, j);
              VideoEnvironment.a("ShortVideoResourceManager", "[onRespAsync]signature=" + (String)??? + ",errCode=" + i + ",key=" + (String)localObject1, null);
              break;
            }
            i = -3;
            b((String)???);
            b((String)???);
            break;
            ayzx.a((String)localObject1, j, 1, -117);
            b((String)???);
            VideoEnvironment.a("ShortVideoResourceManager", "[onResp]filePath=" + (String)??? + ",resp.mResult=" + parambaqw.jdField_a_of_type_Int + ",mErrDesc=" + parambaqw.jdField_a_of_type_JavaLangString + ",mErrDesc=" + parambaqw.jdField_a_of_type_JavaLangString, null);
            i = -117;
            break label337;
            ((bavr)localObject4).a((String)parambaqw.jdField_a_of_type_JavaUtilHashMap.get("param_url"), -1L);
          }
        }
        localayzv.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilHashMap.remove(localObject1);
        return;
      }
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
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, ayzy paramayzy)
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_Ayzu.jdField_a_of_type_Int == 0)
        {
          if (paramInt == 3)
          {
            i = b();
            if (i == 0)
            {
              if (paramayzy != null) {
                paramayzy.a(1, i);
              }
              return;
            }
          }
          int i = a();
          String str = a();
          VideoEnvironment.a("ShortVideoResourceManager", "doUserDownload[Begin download print]:version=" + i + " config_content" + str, null);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortVideoConfigData LogSignature=" + c(), null);
          jdField_a_of_type_Ayzu.jdField_a_of_type_Int = 1;
          jdField_a_of_type_Ayzu.b = paramInt;
          jdField_a_of_type_Ayzu.jdField_c_of_type_Int = 0;
          jdField_a_of_type_Ayzu.d = 0;
          aova.b(paramQQAppInterface, paramInt);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortvideoConfigData[request started]:status=" + jdField_a_of_type_Ayzu.a() + " mGetConfigType" + jdField_a_of_type_Ayzu.b, null);
          if (paramayzy == null) {
            continue;
          }
          boolean bool = jdField_a_of_type_JavaUtilArrayList.contains(paramayzy);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortVideoConfigData contains=" + bool, null);
          if (bool) {
            continue;
          }
          if (paramInt == 3) {
            break label319;
          }
          jdField_a_of_type_JavaUtilArrayList.add(0, paramayzy);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortVideoConfigData: add callBack OK...", null);
          continue;
        }
        VideoEnvironment.a("ShortVideoResourceManager", "downloadShortvideoConfigData[request pending]:status=" + jdField_a_of_type_Ayzu.a() + " mGetConfigType" + jdField_a_of_type_Ayzu.b, null);
      }
      finally {}
      continue;
      label319:
      jdField_a_of_type_JavaUtilArrayList.add(paramayzy);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ayzw paramayzw)
  {
    a(paramQQAppInterface, paramayzw, "new_qq_android_native_short_video_");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ayzw paramayzw, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (paramayzw != null) {
        paramQQAppInterface.a().a(paramayzw, paramString);
      }
      return;
    }
    VideoEnvironment.a("ShortVideoResourceManager", "clearResourceCallBackWithNamePrefixSafe: app=null...", null);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ayzy paramayzy)
  {
    a(paramQQAppInterface, 3, paramayzy);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    ThreadManager.excute(new ShortVideoResourceManager.3(paramQQAppInterface, paramList), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, ayzw paramayzw)
  {
    ThreadManager.excute(new ShortVideoResourceManager.4(paramQQAppInterface, paramList, paramayzw), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, ayzw paramayzw, String paramString)
  {
    ThreadManager.excute(new ShortVideoResourceManager.10(paramQQAppInterface, paramList, paramayzw, paramString), 128, null, false);
  }
  
  public static void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new ShortVideoResourceManager.13(paramString));
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
  
  private void a(List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    ThreadManager.excute(new ShortVideoResourceManager.11(this, paramList), 128, null, false);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str = a(paramSVConfigItem.name);
    VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload:name=" + paramSVConfigItem.name, null);
    ayzz localayzz = ayzx.a(paramSVConfigItem.name);
    VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload:versionCode=" + paramSVConfigItem.versionCode + " status.version" + localayzz.jdField_a_of_type_Int + ",status.lastErr=" + localayzz.jdField_c_of_type_Int, null);
    if (!ayyv.a(paramQQAppInterface, paramSVConfigItem)) {
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
          if (paramSVConfigItem.versionCode <= localayzz.jdField_a_of_type_Int) {
            break label243;
          }
          if (localayzz.jdField_a_of_type_Int != 0) {
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
      } while (paramSVConfigItem.versionCode != localayzz.jdField_a_of_type_Int);
      if (localayzz.b != 0)
      {
        VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload[No equal]:status=" + localayzz.b + ",version" + localayzz.jdField_a_of_type_Int, null);
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
    } while (localayzz.jdField_c_of_type_Int == 0);
    VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:status=" + localayzz.b + ",lastErr" + localayzz.jdField_c_of_type_Int, null);
    return false;
  }
  
  private boolean a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem, ayzw paramayzw, boolean[] paramArrayOfBoolean)
  {
    boolean bool1 = true;
    String str = a(paramSVConfigItem.name);
    boolean bool2 = ayyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem.name);
    VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:alreadyExists=" + bool2, null);
    paramArrayOfBoolean[0] = bool2;
    if (bool2)
    {
      VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:onDownloadFinish...", null);
      if (paramayzw != null)
      {
        if ((!paramSVConfigItem.name.startsWith("new_qq_android_native_ptu_res_")) && (!paramSVConfigItem.name.startsWith("new_qq_android_native_short_filter_"))) {
          break label211;
        }
        paramayzw.a(paramSVConfigItem.name, 1, str);
      }
    }
    for (;;)
    {
      VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:itemConfig.versionCode=" + paramSVConfigItem.versionCode, null);
      bool2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem);
      bool1 = bool2;
      if (!bool2)
      {
        int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem);
        VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:doNoNeedDownload_errCode=" + i, null);
        bool1 = bool2;
        if (i == 0) {}
      }
      return bool1;
      label211:
      paramayzw.a(paramSVConfigItem.name, 0, str);
    }
  }
  
  private static boolean a(String paramString)
  {
    String str = b();
    return bdcs.a(str + paramString);
  }
  
  private static boolean a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).edit();
    localEditor.putString("short_video_res_config_key", paramString);
    localEditor.putInt("short_video_resource_version", paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent| saveContentOK，config_content = " + paramString);
    }
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
  
  private static int b()
  {
    int i = a();
    String str = a();
    VideoEnvironment.a("ShortVideoResourceManager", "checkLocalConfigIsOK:version=" + i + " config_content" + str, null);
    if ((i != 0) && (!TextUtils.isEmpty(str)))
    {
      ArrayList localArrayList = new ArrayList();
      int j = a(str, localArrayList);
      VideoEnvironment.a("ShortVideoResourceManager", "checkLocalConfigIsOK:parseConfigData_errCode=" + j, null);
      i = j;
      if (j == 0) {
        i = a(localArrayList);
      }
      return i;
    }
    return -101;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, ayzy paramayzy)
  {
    int i = 0;
    f();
    int j = b();
    VideoEnvironment.a("ShortVideoResourceManager", "startUserDownloadConfig[checkLocalConfigIsOK]:errCode=" + j, null);
    if (j != 0)
    {
      boolean bool = bdee.g(null);
      VideoEnvironment.a("ShortVideoResourceManager", "startUserDownloadConfig:netUsable=" + bool, null);
      j = a(paramayzy);
      if (j == -115)
      {
        a(paramQQAppInterface, paramayzy);
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
      if (paramayzy != null)
      {
        paramayzy.a(1, 0);
        i = j;
      }
    }
  }
  
  public static String b()
  {
    return bkks.b;
  }
  
  public static void b()
  {
    for (;;)
    {
      try
      {
        VideoEnvironment.a("ShortVideoResourceManager", "onReceiveNoDataUpdate LogSignature=" + c(), null);
        int i;
        if (jdField_a_of_type_Ayzu.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_Ayzu.jdField_a_of_type_Int = 0;
          jdField_a_of_type_Ayzu.jdField_c_of_type_Int = 1;
          i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i >= 0)
          {
            if (jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
              ((ayzy)jdField_a_of_type_JavaUtilArrayList.get(i)).a(jdField_a_of_type_Ayzu.jdField_c_of_type_Int, 0);
            }
          }
          else {
            jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        else
        {
          VideoEnvironment.a("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveNoDataUpdate] mConfigStatus=" + jdField_a_of_type_Ayzu.a(), null);
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
        VideoEnvironment.a("ShortVideoResourceManager", "onReceiveSuccess LogSignature=" + c(), null);
        int i;
        if (jdField_a_of_type_Ayzu.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_Ayzu.jdField_a_of_type_Int = 0;
          jdField_a_of_type_Ayzu.jdField_c_of_type_Int = 0;
          i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i >= 0)
          {
            if (jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
              ((ayzy)jdField_a_of_type_JavaUtilArrayList.get(i)).a(jdField_a_of_type_Ayzu.jdField_c_of_type_Int, paramInt);
            }
          }
          else {
            jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        else
        {
          VideoEnvironment.a("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveSuccess] mConfigStatus=" + jdField_a_of_type_Ayzu.a(), null);
          continue;
        }
        i -= 1;
      }
      finally {}
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ayzw paramayzw)
  {
    a(paramQQAppInterface, paramayzw, "new_qq_android_native_short_filter_");
  }
  
  private static void b(QQAppInterface paramQQAppInterface, HashMap<ShortVideoResourceManager.SVConfigItem, ayzw> paramHashMap)
  {
    for (;;)
    {
      ShortVideoResourceManager.SVConfigItem localSVConfigItem;
      ayzw localayzw;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = paramHashMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
        boolean bool = a(paramQQAppInterface, localSVConfigItem);
        localayzw = (ayzw)paramHashMap.get(localSVConfigItem);
        VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadAllResourceSync:name=" + localSVConfigItem.name + ",needDownload=" + bool, null);
        if (bool) {
          paramQQAppInterface.a().a(localSVConfigItem, localayzw);
        }
      }
      String str = a(localSVConfigItem.name);
      int i = a(paramQQAppInterface, localSVConfigItem);
      VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadAllResourceSync:[doNoNeedDownload] errCode=" + i, null);
      if (localayzw != null) {
        localayzw.a(localSVConfigItem.name, i, str);
      }
      VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadAllResourceSync: [onDownloadFinish]name=" + localSVConfigItem.name, null);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, ayzw paramayzw)
  {
    ThreadManager.excute(new ShortVideoResourceManager.5(paramQQAppInterface, paramList, paramayzw), 128, null, false);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, ayzw paramayzw, String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangObject;
    int i = 0;
    ShortVideoResourceManager.SVConfigItem localSVConfigItem;
    label80:
    int j;
    for (;;)
    {
      try
      {
        if (i < paramList.size())
        {
          localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)paramList.get(i);
          if (!localSVConfigItem.name.startsWith(paramString)) {
            break;
          }
          if (paramQQAppInterface != null) {
            continue;
          }
          VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix: app=null [RES_APP_INTERFACE_NULL_ERROR]", null);
          if (paramayzw != null) {
            paramayzw.a(localSVConfigItem.name, -1501, "");
          }
        }
        return;
        boolean bool = a(paramQQAppInterface, localSVConfigItem);
        VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix: needDownload=" + bool, null);
        if (bool)
        {
          paramQQAppInterface = paramQQAppInterface.a();
          if (paramQQAppInterface == null) {
            continue;
          }
          paramQQAppInterface.a(localSVConfigItem, paramayzw);
          continue;
        }
        paramList = a(localSVConfigItem.name);
      }
      finally {}
      j = a(paramQQAppInterface, localSVConfigItem);
      VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix:[doNoNeedDownload] itemConfig.name = " + localSVConfigItem.name + ", errCode=" + j, null);
      if (paramayzw != null)
      {
        if (localSVConfigItem.name.startsWith("new_qq_android_native_ptu_res_")) {
          break label272;
        }
        i = j;
        if (localSVConfigItem.name.startsWith("new_qq_android_native_short_filter_")) {
          break label272;
        }
      }
    }
    for (;;)
    {
      paramayzw.a(localSVConfigItem.name, i, paramList);
      break label80;
      i += 1;
      break;
      label272:
      i = j;
      if (j == 0) {
        i = 1;
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
  
  private void b(List<ShortVideoResourceManager.SVConfigItem> paramList)
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
    return "hashCode=" + jdField_a_of_type_Ayzu.hashCode() + " ,pid=" + Process.myPid() + ",tid" + Process.myTid();
  }
  
  public static void c(QQAppInterface paramQQAppInterface, ayzw paramayzw)
  {
    a(paramQQAppInterface, paramayzw, "new_qq_android_native_art_filter_");
  }
  
  public static void c(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, ayzw paramayzw)
  {
    ThreadManager.excute(new ShortVideoResourceManager.7(paramQQAppInterface, paramList, paramayzw), 128, null, false);
  }
  
  private static String d()
  {
    return bklc.jdField_a_of_type_JavaLangString + File.separator;
  }
  
  public static void d(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, ayzw paramayzw)
  {
    ThreadManager.excute(new ShortVideoResourceManager.9(paramQQAppInterface, paramList, paramayzw), 128, null, false);
  }
  
  private void e()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        ayzv localayzv = (ayzv)localIterator.next();
        if ((localayzv != null) && (localayzv.jdField_a_of_type_JavaUtilArrayList != null))
        {
          int i = 0;
          while (i < localayzv.jdField_a_of_type_JavaUtilArrayList.size())
          {
            ((ayzw)localayzv.jdField_a_of_type_JavaUtilArrayList.get(i)).G_();
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
      QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent|received save version: " + paramInt + ", config_content: " + paramString);
    }
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      int j = -101;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent| version: " + paramInt + ",config_content: " + paramString);
        i = j;
      }
      return i;
    }
    boolean bool = a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent| saveContentOK: " + bool);
    }
    if (bool) {}
    for (paramInt = 0;; paramInt = -128)
    {
      i = paramInt;
      if (!bool) {
        break;
      }
      bool = ayzp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      i = paramInt;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent| downloadState: " + bool);
      return paramInt;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    QLog.d("ShortVideoResourceManager", 1, "updateShortVideoOtherConfigOnly|received save version: " + paramInt + ", config_content: " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ShortVideoResourceManager", 1, "updateShortVideoOtherConfigOnly| version: " + paramInt + ",config_content: " + paramString);
      return -101;
    }
    boolean bool = a(paramString, paramInt);
    QLog.d("ShortVideoResourceManager", 1, "updateShortVideoOtherConfigOnly| saveContentOK: " + bool);
    if (bool) {
      return 0;
    }
    return -128;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("ShortVideoResourceManager", "[PreDownload]onConfigResult:result=" + paramInt1 + ",serverError" + paramInt2 + ",getType=" + jdField_a_of_type_Ayzu.b, null);
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
    String str = a();
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
      paramInt1 = a(localArrayList);
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
  
  public void a(ayzw paramayzw, String paramString)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        if ((localObject2 != null) && (((String)localObject2).startsWith(paramString)))
        {
          localObject2 = (ayzv)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
          if ((localObject2 != null) && (paramayzw != null)) {
            ((ayzv)localObject2).jdField_a_of_type_JavaUtilArrayList.remove(paramayzw);
          }
        }
      }
    }
  }
  
  public void a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem, ayzw paramayzw)
  {
    for (;;)
    {
      Object localObject2;
      boolean bool;
      synchronized (this.b)
      {
        localObject2 = (ayzv)this.jdField_a_of_type_JavaUtilHashMap.get(paramSVConfigItem.name);
        if (localObject2 != null) {
          break label361;
        }
        localObject2 = new boolean[1];
        bool = a(paramSVConfigItem, paramayzw, (boolean[])localObject2);
        if (localObject2[0] != 0) {
          paramayzw = null;
        }
        VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:doDownload=" + bool, null);
        baps localbaps;
        if (bool)
        {
          localObject2 = b();
          b((String)localObject2 + paramSVConfigItem.name);
          localObject2 = d();
          b((String)localObject2 + paramSVConfigItem.name);
          localbaps = new baps();
          localbaps.jdField_a_of_type_Bapx = this;
          if ((azax.a()) && (paramSVConfigItem.check64BitReady()))
          {
            localbaps.jdField_a_of_type_JavaLangString = paramSVConfigItem.arm64v8a_url;
            localbaps.jdField_a_of_type_Int = 0;
            localbaps.jdField_c_of_type_JavaLangString = ((String)localObject2 + paramSVConfigItem.name);
            localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
            localbaps.n = true;
            localbaps.a(paramSVConfigItem.name);
            localObject2 = new ayzv(this, localbaps);
            ((ayzv)localObject2).jdField_a_of_type_Int = paramSVConfigItem.versionCode;
            if ((!azax.a()) || (!paramSVConfigItem.check64BitReady())) {
              break label349;
            }
            ((ayzv)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.arm64v8a_md5;
            if (paramayzw != null)
            {
              ((ayzv)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramayzw);
              VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[session][new]add callBack ok...", null);
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(paramSVConfigItem.name, localObject2);
            ((ayzv)localObject2).a();
          }
        }
        else
        {
          return;
        }
        localbaps.jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_url;
      }
      label349:
      ((ayzv)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_md5;
      continue;
      label361:
      if (((ayzv)localObject2).b == 0)
      {
        ((ayzv)localObject2).jdField_a_of_type_Int = paramSVConfigItem.versionCode;
        if ((azax.a()) && (paramSVConfigItem.check64BitReady())) {}
        for (((ayzv)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.arm64v8a_md5;; ((ayzv)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_md5)
        {
          if (paramayzw != null)
          {
            bool = ((ayzv)localObject2).jdField_a_of_type_JavaUtilArrayList.contains(paramayzw);
            VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][start]contains=" + bool, null);
            if (!bool)
            {
              ((ayzv)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramayzw);
              VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][start]add callBack ok...", null);
            }
          }
          ((ayzv)localObject2).a();
          break;
        }
      }
      if (paramayzw != null)
      {
        bool = ((ayzv)localObject2).jdField_a_of_type_JavaUtilArrayList.contains(paramayzw);
        VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][pending]contains=" + bool, null);
        if (!bool)
        {
          ((ayzv)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramayzw);
          VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][pending]add callBack ok...", null);
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
    ((List)???).add("new_qq_android_native_short_filter_");
    ((List)???).add("new_qq_android_native_art_filter_");
    ((List)???).add("new_qq_android_native_portrait_filter_");
    ((List)???).add("new_qq_android_native_short_other_");
    ((List)???).add("new_qq_android_native_ptu_res_");
    Iterator localIterator = ((List)???).iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (String)localIterator.next();
      synchronized (this.b)
      {
        localObject3 = (ayzv)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3);
        if (localObject3 != null) {
          ((ayzv)localObject3).jdField_a_of_type_JavaUtilArrayList.clear();
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
      QLog.d("ShortVideoResourceManager", 1, new Object[] { "onDestroy sizeCallBack = ", Integer.valueOf(i) });
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      ayzp.a();
      d();
      return;
    }
    finally {}
  }
  
  public final void onResp(baqw parambaqw)
  {
    ThreadManager.post(new ShortVideoResourceManager.12(this, parambaqw), 5, null, false);
  }
  
  public final void onUpdateProgeress(baqv arg1, long paramLong1, long paramLong2)
  {
    String str = (String)???.a();
    if (str == null) {}
    VideoEnvironment.a("ShortVideoResourceManager", "[onUpdateProgeress]curOffset=" + paramLong1 + ",totalLen=" + paramLong2 + ",key=" + str, null);
    for (;;)
    {
      int i;
      synchronized (this.b)
      {
        ayzv localayzv = (ayzv)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        localayzv.b = 2;
        int j = localayzv.jdField_a_of_type_JavaUtilArrayList.size();
        i = 0;
        if (i < j)
        {
          if ((localayzv.jdField_a_of_type_JavaUtilArrayList.get(i) != null) && (str != null)) {
            ((ayzw)localayzv.jdField_a_of_type_JavaUtilArrayList.get(i)).a(str, paramLong1, paramLong2);
          }
        }
        else
        {
          i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
          VideoEnvironment.a("ShortVideoResourceManager", "[onUpdateProgeress]downloadProgress=" + i + ",key=" + str, null);
          if (str != null) {
            a(str, i);
          }
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager
 * JD-Core Version:    0.7.0.1
 */