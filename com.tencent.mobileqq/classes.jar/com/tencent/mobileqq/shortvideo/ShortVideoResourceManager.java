package com.tencent.mobileqq.shortvideo;

import ajed;
import amnh;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import aweh;
import awez;
import awfc;
import awfe;
import awff;
import awfg;
import awfh;
import awfi;
import awfj;
import awgh;
import axro;
import axrt;
import axsp;
import axsq;
import axsr;
import axxj;
import azxx;
import bace;
import badq;
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
  implements awfi, axrt, Manager
{
  public static long a;
  private static awfe jdField_a_of_type_Awfe = new awfe();
  private static final Object jdField_a_of_type_JavaLangObject;
  private static ArrayList<awfi> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new awfc(this);
  private HashMap<String, awff> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final Object b = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    e();
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
  private static int a(awfi paramawfi)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore_2
    //   5: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Awfe	Lawfe;
    //   8: getfield 95	awfe:jdField_a_of_type_Int	I
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
    //   0	100	0	paramawfi	awfi
    //   11	80	1	i	int
    //   4	86	2	j	int
    //   41	29	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	12	94	finally
    //   34	67	94	finally
    //   73	89	94	finally
  }
  
  public static int a(QQAppInterface paramQQAppInterface, awfi paramawfi)
  {
    int i = 0;
    e();
    int j = b();
    VideoEnvironment.a("ShortVideoResourceManager", "startUserDownloadConfig[checkLocalConfigIsOK]:errCode=" + j, null);
    if (j != 0)
    {
      boolean bool = badq.g(null);
      VideoEnvironment.a("ShortVideoResourceManager", "startUserDownloadConfig:netUsable=" + bool, null);
      j = a(paramawfi);
      if (j == -115)
      {
        a(paramQQAppInterface, paramawfi);
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
      if (paramawfi != null)
      {
        paramawfi.a(1, 0);
        i = j;
      }
    }
  }
  
  private static int a(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str1 = a(paramSVConfigItem.name);
    if (aweh.a(paramQQAppInterface, paramSVConfigItem))
    {
      String str2 = paramSVConfigItem.getSignature();
      VideoEnvironment.a("ShortVideoResourceManager", "doNoNeedDownload: signature=" + str2, null);
      int i = a(paramQQAppInterface, paramSVConfigItem.name, str2, str1, paramSVConfigItem.versionCode);
      if (i != 0)
      {
        awfh.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, -1, i);
        b(str1);
        VideoEnvironment.a("ShortVideoResourceManager", "doNoNeedDownload: errCode=" + i, null);
        return i;
      }
      awfh.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, 0, i);
      return i;
    }
    VideoEnvironment.a("ShortVideoResourceManager", "doNoNeedDownload: sysSupport=false", null);
    return -1000;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = aweh.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
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
    String str = c();
    str = str + paramSVConfigItem.name;
    return a(paramSVConfigItem.name, paramSVConfigItem.armv7a_md5, str);
  }
  
  /* Error */
  private static int a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +43 -> 46
    //   6: ldc 101
    //   8: iconst_2
    //   9: new 103	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc_w 261
    //   23: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 263
    //   33: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_2
    //   47: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifeq +6 -> 56
    //   53: bipush 151
    //   55: ireturn
    //   56: aload_1
    //   57: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: ifeq +6 -> 66
    //   63: bipush 150
    //   65: ireturn
    //   66: new 269	java/io/File
    //   69: dup
    //   70: aload_2
    //   71: invokespecial 271	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore 4
    //   76: aload 4
    //   78: invokevirtual 274	java/io/File:exists	()Z
    //   81: ifne +48 -> 129
    //   84: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +39 -> 126
    //   90: ldc 101
    //   92: iconst_2
    //   93: new 103	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   100: aload_0
    //   101: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 276
    //   107: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_2
    //   111: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc_w 278
    //   117: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 280	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: bipush 149
    //   128: ireturn
    //   129: aconst_null
    //   130: astore_3
    //   131: aload_2
    //   132: invokestatic 286	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   135: invokestatic 292	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   138: astore_2
    //   139: invokestatic 259	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +43 -> 185
    //   145: ldc 101
    //   147: iconst_2
    //   148: new 103	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   155: aload_0
    //   156: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 294
    //   162: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_1
    //   166: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 296
    //   172: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_2
    //   176: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload_1
    //   186: aload_2
    //   187: invokevirtual 302	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   190: ifeq +15 -> 205
    //   193: iconst_0
    //   194: ireturn
    //   195: astore_2
    //   196: aload 4
    //   198: invokestatic 307	bech:a	(Ljava/io/File;)Ljava/lang/String;
    //   201: astore_2
    //   202: goto -63 -> 139
    //   205: new 45	java/util/HashMap
    //   208: dup
    //   209: invokespecial 46	java/util/HashMap:<init>	()V
    //   212: astore_3
    //   213: aload_3
    //   214: ldc_w 309
    //   217: aload_0
    //   218: invokevirtual 313	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   221: pop
    //   222: aload_3
    //   223: ldc_w 315
    //   226: aload_1
    //   227: invokevirtual 313	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   230: pop
    //   231: aload_2
    //   232: ifnull +51 -> 283
    //   235: aload_3
    //   236: ldc_w 317
    //   239: aload_2
    //   240: invokevirtual 313	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   243: pop
    //   244: aload_3
    //   245: ldc_w 319
    //   248: aload 4
    //   250: invokevirtual 323	java/io/File:length	()J
    //   253: invokestatic 327	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   256: invokevirtual 313	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: invokestatic 333	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   263: invokestatic 338	awrn:a	(Landroid/content/Context;)Lawrn;
    //   266: ldc 211
    //   268: ldc_w 340
    //   271: iconst_1
    //   272: lconst_0
    //   273: lconst_0
    //   274: aload_3
    //   275: ldc 211
    //   277: invokevirtual 343	awrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   280: goto +29 -> 309
    //   283: ldc 211
    //   285: astore_2
    //   286: goto -51 -> 235
    //   289: astore_0
    //   290: ldc 101
    //   292: iconst_1
    //   293: ldc_w 345
    //   296: aload_0
    //   297: invokestatic 348	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   300: goto +9 -> 309
    //   303: astore_2
    //   304: aload_3
    //   305: astore_2
    //   306: goto -167 -> 139
    //   309: bipush 148
    //   311: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramString1	String
    //   0	312	1	paramString2	String
    //   0	312	2	paramString3	String
    //   130	175	3	localHashMap	HashMap
    //   74	175	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   131	139	195	java/lang/UnsatisfiedLinkError
    //   205	231	289	java/lang/Exception
    //   235	280	289	java/lang/Exception
    //   196	202	303	java/lang/Exception
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
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)azxx.a(paramString.getJSONObject(i), ShortVideoResourceManager.SVConfigItem.class);
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
      j = aweh.a((ShortVideoResourceManager.SVConfigItem)paramList.get(i));
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
    String str = c();
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
    //   12: ldc_w 399
    //   15: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokestatic 401	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:b	()Ljava/lang/String;
    //   21: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: aconst_null
    //   28: invokestatic 120	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   31: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Awfe	Lawfe;
    //   34: getfield 95	awfe:jdField_a_of_type_Int	I
    //   37: iconst_1
    //   38: if_icmpne +14 -> 52
    //   41: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Awfe	Lawfe;
    //   44: iconst_2
    //   45: putfield 95	awfe:jdField_a_of_type_Int	I
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: ldc 101
    //   54: new 103	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 403
    //   64: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Awfe	Lawfe;
    //   70: invokevirtual 404	awfe:a	()Ljava/lang/String;
    //   73: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aconst_null
    //   80: invokestatic 120	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Awfe	Lawfe;
    //   86: getfield 95	awfe:jdField_a_of_type_Int	I
    //   89: ifne -41 -> 48
    //   92: getstatic 35	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: invokevirtual 405	java/util/ArrayList:size	()I
    //   98: istore_0
    //   99: ldc 101
    //   101: new 103	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 407
    //   111: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: iload_0
    //   115: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
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
        VideoEnvironment.a("ShortVideoResourceManager", "onReceiveFailed:status=" + jdField_a_of_type_Awfe.a() + " mGetConfigType" + jdField_a_of_type_Awfe.b + ",serverResult=" + paramInt + ",LogSignature=" + b(), null);
        if (jdField_a_of_type_Awfe.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_Awfe.jdField_a_of_type_Int = 0;
          if (paramInt == 0)
          {
            VideoEnvironment.a("ShortVideoResourceManager", "onReceiveFailed[RESULT_NO_DATA]", null);
            jdField_a_of_type_Awfe.jdField_c_of_type_Int = 1;
            jdField_a_of_type_Awfe.d = 0;
            paramInt = jdField_a_of_type_JavaUtilArrayList.size() - 1;
            if (paramInt >= 0)
            {
              if (jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null) {
                break label244;
              }
              ((awfi)jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(jdField_a_of_type_Awfe.jdField_c_of_type_Int, jdField_a_of_type_Awfe.d);
              break label244;
            }
          }
          else
          {
            VideoEnvironment.a("ShortVideoResourceManager", "onReceiveFailed[RESULT_FAILED]", null);
            jdField_a_of_type_Awfe.jdField_c_of_type_Int = -1;
            jdField_a_of_type_Awfe.d = paramInt;
            continue;
          }
          jdField_a_of_type_JavaUtilArrayList.clear();
        }
      }
      finally {}
      for (;;)
      {
        return;
        VideoEnvironment.a("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveFailed] mConfigStatus=" + jdField_a_of_type_Awfe.a(), null);
      }
      label244:
      paramInt -= 1;
    }
  }
  
  private void a(axsq paramaxsq)
  {
    Object localObject1 = paramaxsq.jdField_a_of_type_Axsp;
    ??? = ((axsp)localObject1).jdField_c_of_type_JavaLangString;
    VideoEnvironment.a("ShortVideoResourceManager", "[onResp]filePath=" + (String)??? + ",resp.mResult=" + paramaxsq.jdField_a_of_type_Int + ",mHttpCode=" + paramaxsq.jdField_c_of_type_Int + ",mErrCode=" + paramaxsq.b + ",mErrDesc=" + paramaxsq.jdField_a_of_type_JavaLangString, null);
    localObject1 = (String)((axsp)localObject1).a();
    if (localObject1 == null) {}
    for (;;)
    {
      awff localawff;
      Object localObject4;
      int j;
      int i;
      synchronized (this.b)
      {
        localawff = (awff)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
        localObject4 = localawff.jdField_a_of_type_JavaLangString;
        j = localawff.jdField_a_of_type_Int;
        String str = c();
        ??? = str + (String)localObject1;
        if (paramaxsq.jdField_a_of_type_Int == 0)
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
            awfh.a((String)localObject1, j, 0, i);
            label337:
            VideoEnvironment.a("ShortVideoResourceManager", "[onRespAsync]errCode=" + i + ",saveFilePath=" + (String)??? + ",key=" + (String)localObject1, null);
          }
        }
      }
      synchronized (this.b)
      {
        localawff.b = 3;
        int k = localawff.jdField_a_of_type_JavaUtilArrayList.size();
        j = 0;
        label412:
        if (j < k) {
          for (;;)
          {
            try
            {
              if (localawff.jdField_a_of_type_JavaUtilArrayList.get(j) != null)
              {
                ((awfg)localawff.jdField_a_of_type_JavaUtilArrayList.get(j)).a((String)localObject1, i, (String)???);
                localObject4 = (axxj)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(193);
                if ((localObject1 != null) && (((String)localObject1).startsWith("new_qq_android_native_short_filter_")) && (((axxj)localObject4).a()) && (!awgh.a().a()))
                {
                  if (i != 0) {
                    continue;
                  }
                  ((axxj)localObject4).a((String)paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("param_url"), paramaxsq.jdField_a_of_type_Long);
                }
              }
            }
            catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
            {
              continue;
            }
            j += 1;
            break label412;
            paramaxsq = finally;
            throw paramaxsq;
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
            awfh.a((String)localObject1, j, 1, -117);
            b((String)???);
            VideoEnvironment.a("ShortVideoResourceManager", "[onResp]filePath=" + (String)??? + ",resp.mResult=" + paramaxsq.jdField_a_of_type_Int + ",mErrDesc=" + paramaxsq.jdField_a_of_type_JavaLangString + ",mErrDesc=" + paramaxsq.jdField_a_of_type_JavaLangString, null);
            i = -117;
            break label337;
            ((axxj)localObject4).a((String)paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("param_url"), -1L);
          }
        }
        localawff.jdField_a_of_type_JavaUtilArrayList.clear();
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
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, awfi paramawfi)
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_Awfe.jdField_a_of_type_Int == 0)
        {
          if (paramInt == 3)
          {
            i = b();
            if (i == 0)
            {
              if (paramawfi != null) {
                paramawfi.a(1, i);
              }
              return;
            }
          }
          int i = a();
          String str = a();
          VideoEnvironment.a("ShortVideoResourceManager", "doUserDownload[Begin download print]:version=" + i + " config_content" + str, null);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortVideoConfigData LogSignature=" + b(), null);
          jdField_a_of_type_Awfe.jdField_a_of_type_Int = 1;
          jdField_a_of_type_Awfe.b = paramInt;
          jdField_a_of_type_Awfe.jdField_c_of_type_Int = 0;
          jdField_a_of_type_Awfe.d = 0;
          amnh.b(paramQQAppInterface, paramInt);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortvideoConfigData[request started]:status=" + jdField_a_of_type_Awfe.a() + " mGetConfigType" + jdField_a_of_type_Awfe.b, null);
          if (paramawfi == null) {
            continue;
          }
          boolean bool = jdField_a_of_type_JavaUtilArrayList.contains(paramawfi);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortVideoConfigData contains=" + bool, null);
          if (bool) {
            continue;
          }
          if (paramInt == 3) {
            break label319;
          }
          jdField_a_of_type_JavaUtilArrayList.add(0, paramawfi);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortVideoConfigData: add callBack OK...", null);
          continue;
        }
        VideoEnvironment.a("ShortVideoResourceManager", "downloadShortvideoConfigData[request pending]:status=" + jdField_a_of_type_Awfe.a() + " mGetConfigType" + jdField_a_of_type_Awfe.b, null);
      }
      finally {}
      continue;
      label319:
      jdField_a_of_type_JavaUtilArrayList.add(paramawfi);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, awfg paramawfg)
  {
    a(paramQQAppInterface, paramawfg, "new_qq_android_native_short_video_");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, awfg paramawfg, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (paramawfg != null) {
        paramQQAppInterface.a().a(paramawfg, paramString);
      }
      return;
    }
    VideoEnvironment.a("ShortVideoResourceManager", "clearResourceCallBackWithNamePrefixSafe: app=null...", null);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, awfi paramawfi)
  {
    a(paramQQAppInterface, 3, paramawfi);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    ThreadManager.excute(new ShortVideoResourceManager.3(paramQQAppInterface, paramList), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, awfg paramawfg)
  {
    ThreadManager.excute(new ShortVideoResourceManager.4(paramQQAppInterface, paramList, paramawfg), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, awfg paramawfg, String paramString)
  {
    ThreadManager.excute(new ShortVideoResourceManager.10(paramQQAppInterface, paramList, paramawfg, paramString), 128, null, false);
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
    awfj localawfj = awfh.a(paramSVConfigItem.name);
    VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload:versionCode=" + paramSVConfigItem.versionCode + " status.version" + localawfj.jdField_a_of_type_Int + ",status.lastErr=" + localawfj.jdField_c_of_type_Int, null);
    if (!aweh.a(paramQQAppInterface, paramSVConfigItem)) {
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
          if (paramSVConfigItem.versionCode <= localawfj.jdField_a_of_type_Int) {
            break label243;
          }
          if (localawfj.jdField_a_of_type_Int != 0) {
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
      } while (paramSVConfigItem.versionCode != localawfj.jdField_a_of_type_Int);
      if (localawfj.b != 0)
      {
        VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload[No equal]:status=" + localawfj.b + ",version" + localawfj.jdField_a_of_type_Int, null);
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
    } while (localawfj.jdField_c_of_type_Int == 0);
    VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:status=" + localawfj.b + ",lastErr" + localawfj.jdField_c_of_type_Int, null);
    return false;
  }
  
  private boolean a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem, awfg paramawfg, boolean[] paramArrayOfBoolean)
  {
    String str = a(paramSVConfigItem.name);
    boolean bool = aweh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem.name);
    VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:alreadyExists=" + bool, null);
    paramArrayOfBoolean[0] = bool;
    if (bool)
    {
      VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:onDownloadFinish...", null);
      if (paramawfg != null) {
        paramawfg.a(paramSVConfigItem.name, 0, str);
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
    return bace.a(str + paramString);
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
  
  private static String b()
  {
    return "hashCode=" + jdField_a_of_type_Awfe.hashCode() + " ,pid=" + Process.myPid() + ",tid" + Process.myTid();
  }
  
  public static void b()
  {
    for (;;)
    {
      try
      {
        VideoEnvironment.a("ShortVideoResourceManager", "onReceiveNoDataUpdate LogSignature=" + b(), null);
        int i;
        if (jdField_a_of_type_Awfe.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_Awfe.jdField_a_of_type_Int = 0;
          jdField_a_of_type_Awfe.jdField_c_of_type_Int = 1;
          i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i >= 0)
          {
            if (jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
              ((awfi)jdField_a_of_type_JavaUtilArrayList.get(i)).a(jdField_a_of_type_Awfe.jdField_c_of_type_Int, 0);
            }
          }
          else {
            jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        else
        {
          VideoEnvironment.a("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveNoDataUpdate] mConfigStatus=" + jdField_a_of_type_Awfe.a(), null);
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
        VideoEnvironment.a("ShortVideoResourceManager", "onReceiveSuccess LogSignature=" + b(), null);
        int i;
        if (jdField_a_of_type_Awfe.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_Awfe.jdField_a_of_type_Int = 0;
          jdField_a_of_type_Awfe.jdField_c_of_type_Int = 0;
          i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i >= 0)
          {
            if (jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
              ((awfi)jdField_a_of_type_JavaUtilArrayList.get(i)).a(jdField_a_of_type_Awfe.jdField_c_of_type_Int, paramInt);
            }
          }
          else {
            jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        else
        {
          VideoEnvironment.a("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveSuccess] mConfigStatus=" + jdField_a_of_type_Awfe.a(), null);
          continue;
        }
        i -= 1;
      }
      finally {}
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, awfg paramawfg)
  {
    a(paramQQAppInterface, paramawfg, "new_qq_android_native_short_filter_");
  }
  
  private static void b(QQAppInterface paramQQAppInterface, HashMap<ShortVideoResourceManager.SVConfigItem, awfg> paramHashMap)
  {
    for (;;)
    {
      ShortVideoResourceManager.SVConfigItem localSVConfigItem;
      awfg localawfg;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = paramHashMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
        boolean bool = a(paramQQAppInterface, localSVConfigItem);
        localawfg = (awfg)paramHashMap.get(localSVConfigItem);
        VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadAllResourceSync:name=" + localSVConfigItem.name + ",needDownload=" + bool, null);
        if (bool) {
          paramQQAppInterface.a().a(localSVConfigItem, localawfg);
        }
      }
      String str = a(localSVConfigItem.name);
      int i = a(paramQQAppInterface, localSVConfigItem);
      VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadAllResourceSync:[doNoNeedDownload] errCode=" + i, null);
      if (localawfg != null) {
        localawfg.a(localSVConfigItem.name, i, str);
      }
      VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadAllResourceSync: [onDownloadFinish]name=" + localSVConfigItem.name, null);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, awfg paramawfg)
  {
    ThreadManager.excute(new ShortVideoResourceManager.5(paramQQAppInterface, paramList, paramawfg), 128, null, false);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, awfg paramawfg, String paramString)
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
          if (paramawfg != null) {
            paramawfg.a(localSVConfigItem.name, -1501, "");
          }
        }
        return;
        boolean bool = a(paramQQAppInterface, localSVConfigItem);
        VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix: needDownload=" + bool, null);
        if (bool)
        {
          paramQQAppInterface.a().a(localSVConfigItem, paramawfg);
          continue;
        }
        paramList = a(localSVConfigItem.name);
      }
      finally {}
      j = a(paramQQAppInterface, localSVConfigItem);
      VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix:[doNoNeedDownload] itemConfig.name = " + localSVConfigItem.name + ", errCode=" + j, null);
      if (paramawfg != null)
      {
        if (localSVConfigItem.name.startsWith("new_qq_android_native_ptu_res_")) {
          break label266;
        }
        i = j;
        if (localSVConfigItem.name.startsWith("new_qq_android_native_short_filter_")) {
          break label266;
        }
      }
    }
    for (;;)
    {
      paramawfg.a(localSVConfigItem.name, i, paramList);
      break label80;
      i += 1;
      break;
      label266:
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
    StringBuilder localStringBuilder = new StringBuilder(ajed.aU);
    localStringBuilder.append("sv_config_resource");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static void c(QQAppInterface paramQQAppInterface, awfg paramawfg)
  {
    a(paramQQAppInterface, paramawfg, "new_qq_android_native_art_filter_");
  }
  
  public static void c(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, awfg paramawfg)
  {
    ThreadManager.excute(new ShortVideoResourceManager.7(paramQQAppInterface, paramList, paramawfg), 128, null, false);
  }
  
  private static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder(ajed.aU);
    localStringBuilder.append("sv_config_resource");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("download");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  private void d()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        awff localawff = (awff)localIterator.next();
        if ((localawff != null) && (localawff.jdField_a_of_type_JavaUtilArrayList != null))
        {
          int i = 0;
          while (i < localawff.jdField_a_of_type_JavaUtilArrayList.size())
          {
            ((awfg)localawff.jdField_a_of_type_JavaUtilArrayList.get(i)).I_();
            i += 1;
          }
        }
      }
      return;
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, awfg paramawfg)
  {
    ThreadManager.excute(new ShortVideoResourceManager.9(paramQQAppInterface, paramList, paramawfg), 128, null, false);
  }
  
  private static void e()
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
      bool = awez.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      i = paramInt;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent| downloadState: " + bool);
      return paramInt;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("ShortVideoResourceManager", "[PreDownload]onConfigResult:result=" + paramInt1 + ",serverError" + paramInt2 + ",getType=" + jdField_a_of_type_Awfe.b, null);
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
  
  public void a(awfg paramawfg, String paramString)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        if ((localObject2 != null) && (((String)localObject2).startsWith(paramString)))
        {
          localObject2 = (awff)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
          if ((localObject2 != null) && (paramawfg != null)) {
            ((awff)localObject2).jdField_a_of_type_JavaUtilArrayList.remove(paramawfg);
          }
        }
      }
    }
  }
  
  public void a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem, awfg paramawfg)
  {
    for (;;)
    {
      Object localObject2;
      boolean bool;
      synchronized (this.b)
      {
        localObject2 = (awff)this.jdField_a_of_type_JavaUtilHashMap.get(paramSVConfigItem.name);
        if (localObject2 == null)
        {
          localObject2 = new boolean[1];
          bool = a(paramSVConfigItem, paramawfg, (boolean[])localObject2);
          if (localObject2[0] != 0) {
            paramawfg = null;
          }
          VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:doDownload=" + bool, null);
          if (bool)
          {
            localObject2 = c();
            b((String)localObject2 + paramSVConfigItem.name);
            localObject2 = d();
            b((String)localObject2 + paramSVConfigItem.name);
            axro localaxro = new axro();
            localaxro.jdField_a_of_type_Axrt = this;
            localaxro.jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_url;
            localaxro.jdField_a_of_type_Int = 0;
            localaxro.jdField_c_of_type_JavaLangString = ((String)localObject2 + paramSVConfigItem.name);
            localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
            localaxro.n = true;
            localaxro.a(paramSVConfigItem.name);
            localObject2 = new awff(this, localaxro);
            ((awff)localObject2).jdField_a_of_type_Int = paramSVConfigItem.versionCode;
            ((awff)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_md5;
            if (paramawfg != null)
            {
              ((awff)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramawfg);
              VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[session][new]add callBack ok...", null);
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(paramSVConfigItem.name, localObject2);
            ((awff)localObject2).a();
          }
          return;
        }
        if (((awff)localObject2).b == 0)
        {
          ((awff)localObject2).jdField_a_of_type_Int = paramSVConfigItem.versionCode;
          ((awff)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_md5;
          if (paramawfg != null)
          {
            bool = ((awff)localObject2).jdField_a_of_type_JavaUtilArrayList.contains(paramawfg);
            VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][start]contains=" + bool, null);
            if (!bool)
            {
              ((awff)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramawfg);
              VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][start]add callBack ok...", null);
            }
          }
          ((awff)localObject2).a();
        }
      }
      if (paramawfg != null)
      {
        bool = ((awff)localObject2).jdField_a_of_type_JavaUtilArrayList.contains(paramawfg);
        VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][pending]contains=" + bool, null);
        if (!bool)
        {
          ((awff)localObject2).jdField_a_of_type_JavaUtilArrayList.add(paramawfg);
          VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][pending]add callBack ok...", null);
        }
      }
    }
  }
  
  public void c()
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
        localObject3 = (awff)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3);
        if (localObject3 != null) {
          ((awff)localObject3).jdField_a_of_type_JavaUtilArrayList.clear();
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
      awez.a();
      c();
      return;
    }
    finally {}
  }
  
  public final void onResp(axsq paramaxsq)
  {
    ThreadManager.post(new ShortVideoResourceManager.12(this, paramaxsq), 5, null, false);
  }
  
  public final void onUpdateProgeress(axsp arg1, long paramLong1, long paramLong2)
  {
    String str = (String)???.a();
    if (str == null) {}
    VideoEnvironment.a("ShortVideoResourceManager", "[onUpdateProgeress]curOffset=" + paramLong1 + ",totalLen=" + paramLong2 + ",key=" + str, null);
    for (;;)
    {
      int i;
      synchronized (this.b)
      {
        awff localawff = (awff)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        localawff.b = 2;
        int j = localawff.jdField_a_of_type_JavaUtilArrayList.size();
        i = 0;
        if (i < j)
        {
          if ((localawff.jdField_a_of_type_JavaUtilArrayList.get(i) != null) && (str != null)) {
            ((awfg)localawff.jdField_a_of_type_JavaUtilArrayList.get(i)).a(str, paramLong1, paramLong2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager
 * JD-Core Version:    0.7.0.1
 */