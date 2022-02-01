package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import arry;
import bcwv;
import bcxo;
import bcxs;
import bcxu;
import bcxv;
import bcxw;
import bcxx;
import bcxy;
import bcya;
import bcyy;
import beum;
import beuq;
import bevl;
import bevm;
import bevn;
import bhhq;
import bhmi;
import bhnv;
import boev;
import boff;
import bpam;
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
  implements bcxy, beuq, Manager
{
  public static long a;
  private static bcxu jdField_a_of_type_Bcxu = new bcxu();
  private static final Object jdField_a_of_type_JavaLangObject;
  private static ArrayList<bcxy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new bcxs(this);
  private HashMap<String, bcxv> jdField_a_of_type_JavaUtilHashMap = new HashMap();
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
  private static int a(bcxy parambcxy)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore_2
    //   5: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Bcxu	Lbcxu;
    //   8: getfield 95	bcxu:jdField_a_of_type_Int	I
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
    //   0	100	0	parambcxy	bcxy
    //   11	80	1	i	int
    //   4	86	2	j	int
    //   41	29	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	12	94	finally
    //   34	67	94	finally
    //   73	89	94	finally
  }
  
  public static int a(@Nullable QQAppInterface paramQQAppInterface, bcxy parambcxy)
  {
    int i;
    if (paramQQAppInterface == null) {
      i = -101;
    }
    int j;
    do
    {
      return i;
      j = a(parambcxy);
      bpam.b("ShortVideoResourceManager", "startUserDownloadConfigUpdateForce[checkLocalConfigIsOK]:errCode=" + j);
      if (j == -115)
      {
        a(paramQQAppInterface, parambcxy);
        return 0;
      }
      i = j;
    } while (j != -116);
    return j;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str1 = a(paramSVConfigItem.name);
    if (bcwv.a(paramQQAppInterface, paramSVConfigItem))
    {
      String str2 = paramSVConfigItem.getSignature();
      VideoEnvironment.a("ShortVideoResourceManager", "doNoNeedDownload: signature=" + str2, null);
      int i = a(paramQQAppInterface, paramSVConfigItem.name, str2, str1, paramSVConfigItem.versionCode);
      if (i != 0)
      {
        bcxx.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, -1, i);
        b(str1);
        VideoEnvironment.a("ShortVideoResourceManager", "doNoNeedDownload: errCode=" + i, null);
        return i;
      }
      bcxx.a(paramSVConfigItem.name, paramSVConfigItem.versionCode, 0, i);
      return i;
    }
    VideoEnvironment.a("ShortVideoResourceManager", "doNoNeedDownload: sysSupport=false", null);
    return -1000;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = bcwv.a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
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
    if ((bcyy.a()) && (paramSVConfigItem.check64BitReady())) {
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
    //   199: invokestatic 310	bleb:a	(Ljava/io/File;)Ljava/lang/String;
    //   202: astore_3
    //   203: goto -63 -> 140
    //   206: aload_2
    //   207: invokestatic 314	bhsr:a	(Ljava/lang/String;)Z
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
    //   279: invokestatic 345	bdmc:a	(Landroid/content/Context;)Lbdmc;
    //   282: ldc 203
    //   284: ldc_w 347
    //   287: iconst_1
    //   288: lconst_0
    //   289: lconst_0
    //   290: aload_2
    //   291: ldc 203
    //   293: invokevirtual 350	bdmc:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
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
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)bhhq.a(paramString.getJSONObject(i), ShortVideoResourceManager.SVConfigItem.class);
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
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (j < paramList.size())
      {
        i = bcwv.a((ShortVideoResourceManager.SVConfigItem)paramList.get(j));
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
    //   12: ldc_w 408
    //   15: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokestatic 411	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:c	()Ljava/lang/String;
    //   21: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: aconst_null
    //   28: invokestatic 120	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   31: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Bcxu	Lbcxu;
    //   34: getfield 95	bcxu:jdField_a_of_type_Int	I
    //   37: iconst_1
    //   38: if_icmpne +14 -> 52
    //   41: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Bcxu	Lbcxu;
    //   44: iconst_2
    //   45: putfield 95	bcxu:jdField_a_of_type_Int	I
    //   48: ldc 2
    //   50: monitorexit
    //   51: return
    //   52: ldc 101
    //   54: new 103	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 413
    //   64: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Bcxu	Lbcxu;
    //   70: invokevirtual 414	bcxu:a	()Ljava/lang/String;
    //   73: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aconst_null
    //   80: invokestatic 120	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: getstatic 30	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_Bcxu	Lbcxu;
    //   86: getfield 95	bcxu:jdField_a_of_type_Int	I
    //   89: ifne -41 -> 48
    //   92: getstatic 35	com/tencent/mobileqq/shortvideo/ShortVideoResourceManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: invokevirtual 415	java/util/ArrayList:size	()I
    //   98: istore_0
    //   99: ldc 101
    //   101: new 103	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 417
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
        VideoEnvironment.a("ShortVideoResourceManager", "onReceiveFailed:status=" + jdField_a_of_type_Bcxu.a() + " mGetConfigType" + jdField_a_of_type_Bcxu.b + ",serverResult=" + paramInt + ",LogSignature=" + c(), null);
        if (jdField_a_of_type_Bcxu.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_Bcxu.jdField_a_of_type_Int = 0;
          if (paramInt == 0)
          {
            VideoEnvironment.a("ShortVideoResourceManager", "onReceiveFailed[RESULT_NO_DATA]", null);
            jdField_a_of_type_Bcxu.c = 1;
            jdField_a_of_type_Bcxu.d = 0;
            paramInt = jdField_a_of_type_JavaUtilArrayList.size() - 1;
            if (paramInt >= 0)
            {
              if (jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null) {
                break label244;
              }
              ((bcxy)jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(jdField_a_of_type_Bcxu.c, jdField_a_of_type_Bcxu.d);
              break label244;
            }
          }
          else
          {
            VideoEnvironment.a("ShortVideoResourceManager", "onReceiveFailed[RESULT_FAILED]", null);
            jdField_a_of_type_Bcxu.c = -1;
            jdField_a_of_type_Bcxu.d = paramInt;
            continue;
          }
          jdField_a_of_type_JavaUtilArrayList.clear();
        }
      }
      finally {}
      for (;;)
      {
        return;
        VideoEnvironment.a("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveFailed] mConfigStatus=" + jdField_a_of_type_Bcxu.a(), null);
      }
      label244:
      paramInt -= 1;
    }
  }
  
  private void a(bevm arg1)
  {
    int j = 0;
    Object localObject1 = ???.jdField_a_of_type_Bevl;
    String str1 = ((bevl)localObject1).c;
    VideoEnvironment.a("ShortVideoResourceManager", "[onResp]filePath=" + str1 + ",resp.mResult=" + ???.jdField_a_of_type_Int + ",mHttpCode=" + ???.c + ",mErrCode=" + ???.b + ",mErrDesc=" + ???.jdField_a_of_type_JavaLangString, null);
    localObject1 = (String)((bevl)localObject1).a();
    if (localObject1 == null) {}
    for (;;)
    {
      bcxv localbcxv;
      String str2;
      int k;
      int i;
      synchronized (this.b)
      {
        localbcxv = (bcxv)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
        str2 = localbcxv.jdField_a_of_type_JavaLangString;
        k = localbcxv.jdField_a_of_type_Int;
        String str3 = b();
        ??? = str3 + (String)localObject1;
        if (???.jdField_a_of_type_Int == 0)
        {
          i = a((String)localObject1, str2, str1);
          VideoEnvironment.a("ShortVideoResourceManager", "[onResp]verifyResource keyName=" + (String)localObject1 + ",errCode=" + i, null);
          if (i != 0)
          {
            if (i == -108)
            {
              boolean bool = a(str3 + (String)localObject1 + "error", str1);
              VideoEnvironment.a("ShortVideoResourceManager", "[onResp]renameResourceZip, save error file, success=" + bool, null);
            }
            b(str1);
            VideoEnvironment.a("ShortVideoResourceManager", "[onResp]verifyResource clearDownloadTempFile errCode=" + i, null);
            bcxx.a((String)localObject1, k, 0, i);
            label341:
            VideoEnvironment.a("ShortVideoResourceManager", "[onRespAsync]errCode=" + i + ",saveFilePath=" + (String)??? + ",key=" + (String)localObject1, null);
          }
        }
      }
      synchronized (this.b)
      {
        localbcxv.b = 3;
        k = localbcxv.jdField_a_of_type_JavaUtilArrayList.size();
        for (;;)
        {
          if (j < k) {}
          try
          {
            if ((localbcxv.jdField_a_of_type_JavaUtilArrayList.get(j) != null) && (localObject1 != null)) {
              ((bcxw)localbcxv.jdField_a_of_type_JavaUtilArrayList.get(j)).a((String)localObject1, i, (String)???);
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
            VideoEnvironment.a("ShortVideoResourceManager", "[onRespAsync]signature=" + ??? + ",errCode=" + i + ",key=" + (String)localObject1, null);
            break;
          }
          i = -3;
          b((String)???);
          b(str1);
          break;
          bcxx.a((String)localObject1, k, 1, -117);
          b(str1);
          VideoEnvironment.a("ShortVideoResourceManager", "[onResp]filePath=" + str1 + ",resp.mResult=" + ???.jdField_a_of_type_Int + ",mErrDesc=" + ???.jdField_a_of_type_JavaLangString + ",mErrDesc=" + ???.jdField_a_of_type_JavaLangString, null);
          i = -117;
          break label341;
        }
        localbcxv.jdField_a_of_type_JavaUtilArrayList.clear();
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
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, bcxy parambcxy)
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_Bcxu.jdField_a_of_type_Int == 0)
        {
          if (paramInt == 3)
          {
            i = b();
            if (i == 0)
            {
              if (parambcxy != null) {
                parambcxy.a(1, i);
              }
              return;
            }
          }
          int i = a();
          String str = a();
          VideoEnvironment.a("ShortVideoResourceManager", "doUserDownload[Begin download print]:version=" + i + " config_content" + str, null);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortVideoConfigData LogSignature=" + c(), null);
          jdField_a_of_type_Bcxu.jdField_a_of_type_Int = 1;
          jdField_a_of_type_Bcxu.b = paramInt;
          jdField_a_of_type_Bcxu.c = 0;
          jdField_a_of_type_Bcxu.d = 0;
          arry.b(paramQQAppInterface, paramInt);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortvideoConfigData[request started]:status=" + jdField_a_of_type_Bcxu.a() + " mGetConfigType" + jdField_a_of_type_Bcxu.b, null);
          if (parambcxy == null) {
            continue;
          }
          boolean bool = jdField_a_of_type_JavaUtilArrayList.contains(parambcxy);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortVideoConfigData contains=" + bool, null);
          if (bool) {
            continue;
          }
          if (paramInt == 3) {
            break label319;
          }
          jdField_a_of_type_JavaUtilArrayList.add(0, parambcxy);
          VideoEnvironment.a("ShortVideoResourceManager", "downloadShortVideoConfigData: add callBack OK...", null);
          continue;
        }
        VideoEnvironment.a("ShortVideoResourceManager", "downloadShortvideoConfigData[request pending]:status=" + jdField_a_of_type_Bcxu.a() + " mGetConfigType" + jdField_a_of_type_Bcxu.b, null);
      }
      finally {}
      continue;
      label319:
      jdField_a_of_type_JavaUtilArrayList.add(parambcxy);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bcxw parambcxw)
  {
    a(paramQQAppInterface, parambcxw, "new_qq_android_native_short_video_");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, bcxw parambcxw, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (parambcxw != null) {
        paramQQAppInterface.a().a(parambcxw, paramString);
      }
      return;
    }
    VideoEnvironment.a("ShortVideoResourceManager", "clearResourceCallBackWithNamePrefixSafe: app=null...", null);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, bcxy parambcxy)
  {
    a(paramQQAppInterface, 3, parambcxy);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    ThreadManager.excute(new ShortVideoResourceManager.2(paramQQAppInterface, paramList), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, bcxw parambcxw)
  {
    ThreadManager.excute(new ShortVideoResourceManager.3(paramQQAppInterface, paramList, parambcxw), 128, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, bcxw parambcxw, String paramString)
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
            break label228;
          }
          if (paramQQAppInterface != null) {
            continue;
          }
          VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix: app=null [RES_APP_INTERFACE_NULL_ERROR]", null);
          if (parambcxw != null) {
            parambcxw.a(localSVConfigItem.name, -1501, "");
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
          paramQQAppInterface.a(localSVConfigItem, parambcxw);
          continue;
        }
        paramList = a(localSVConfigItem.name);
      }
      finally {}
      i = a(paramQQAppInterface, localSVConfigItem);
      VideoEnvironment.a("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix:[doNoNeedDownload] itemConfig.name = " + localSVConfigItem.name + ", errCode=" + i, null);
      if (parambcxw != null)
      {
        parambcxw.a(localSVConfigItem.name, i, paramList);
        continue;
        label228:
        i += 1;
      }
    }
  }
  
  public static void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new ShortVideoResourceManager.10(paramString));
  }
  
  private static void a(String paramString, int paramInt)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      VideoEnvironment.a(paramInt);
    }
  }
  
  private void a(List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    ThreadManager.excute(new ShortVideoResourceManager.8(this, paramList), 128, null, false);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    String str = a(paramSVConfigItem.name);
    VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload:name=" + paramSVConfigItem.name, null);
    bcya localbcya = bcxx.a(paramSVConfigItem.name);
    VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload:versionCode=" + paramSVConfigItem.versionCode + " status.version" + localbcya.jdField_a_of_type_Int + ",status.lastErr=" + localbcya.c, null);
    if (!bcwv.a(paramQQAppInterface, paramSVConfigItem)) {
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
          if (paramSVConfigItem.versionCode <= localbcya.jdField_a_of_type_Int) {
            break label243;
          }
          if (localbcya.jdField_a_of_type_Int != 0) {
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
      } while (paramSVConfigItem.versionCode != localbcya.jdField_a_of_type_Int);
      if (localbcya.b != 0)
      {
        VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload[No equal]:status=" + localbcya.b + ",version" + localbcya.jdField_a_of_type_Int, null);
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
    } while (localbcya.c == 0);
    VideoEnvironment.a("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:status=" + localbcya.b + ",lastErr" + localbcya.c, null);
    return false;
  }
  
  private boolean a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem, bcxw parambcxw, boolean[] paramArrayOfBoolean)
  {
    String str = a(paramSVConfigItem.name);
    boolean bool = bcwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSVConfigItem.name);
    VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:alreadyExists=" + bool, null);
    paramArrayOfBoolean[0] = bool;
    if (bool)
    {
      VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:onDownloadFinish...", null);
      if (parambcxw != null) {
        parambcxw.a(paramSVConfigItem.name, 0, str);
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
    String str = b();
    return bhmi.a(str + paramString);
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
  
  public static int b(QQAppInterface paramQQAppInterface, bcxy parambcxy)
  {
    int i = 0;
    f();
    int j = b();
    VideoEnvironment.a("ShortVideoResourceManager", "startUserDownloadConfig[checkLocalConfigIsOK]:errCode=" + j, null);
    if (j != 0)
    {
      boolean bool = bhnv.g(null);
      VideoEnvironment.a("ShortVideoResourceManager", "startUserDownloadConfig:netUsable=" + bool, null);
      j = a(parambcxy);
      if (j == -115)
      {
        a(paramQQAppInterface, parambcxy);
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
      if (parambcxy != null)
      {
        parambcxy.a(1, 0);
        i = j;
      }
    }
  }
  
  private static int b(List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.e("ShortVideoResourceManager", 1, "checkFaceIdentityResVersion: error: listItem is null or empty");
      return -125;
    }
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (ShortVideoResourceManager.SVConfigItem)((Iterator)localObject).next();
      if (paramList.name.startsWith("new_qq_android_native_short_new_other_"))
      {
        localObject = "new_qq_android_native_short_new_other_" + paramList.versionCode;
        if (!paramList.name.equalsIgnoreCase((String)localObject))
        {
          QLog.e("ShortVideoResourceManager", 1, new Object[] { "checkFaceIdentityResVersion: check name ignore error, itemName: ", paramList.name, " validName : ", localObject });
          return -4;
        }
        if (paramList.versionCode < 3)
        {
          QLog.e("ShortVideoResourceManager", 1, new Object[] { "checkFaceIdentityResVersion:item.versionCode=", Integer.valueOf(paramList.versionCode), " buildInOther=", Integer.valueOf(3) });
          return -2;
        }
        return 0;
      }
    }
    return -2;
  }
  
  public static String b()
  {
    return boev.b;
  }
  
  public static void b()
  {
    for (;;)
    {
      try
      {
        VideoEnvironment.a("ShortVideoResourceManager", "onReceiveNoDataUpdate LogSignature=" + c(), null);
        int i;
        if (jdField_a_of_type_Bcxu.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_Bcxu.jdField_a_of_type_Int = 0;
          jdField_a_of_type_Bcxu.c = 1;
          i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i >= 0)
          {
            if (jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
              ((bcxy)jdField_a_of_type_JavaUtilArrayList.get(i)).a(jdField_a_of_type_Bcxu.c, 0);
            }
          }
          else {
            jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        else
        {
          VideoEnvironment.a("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveNoDataUpdate] mConfigStatus=" + jdField_a_of_type_Bcxu.a(), null);
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
        if (jdField_a_of_type_Bcxu.jdField_a_of_type_Int == 2)
        {
          jdField_a_of_type_Bcxu.jdField_a_of_type_Int = 0;
          jdField_a_of_type_Bcxu.c = 0;
          i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
          if (i >= 0)
          {
            if (jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
              ((bcxy)jdField_a_of_type_JavaUtilArrayList.get(i)).a(jdField_a_of_type_Bcxu.c, paramInt);
            }
          }
          else {
            jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
        else
        {
          VideoEnvironment.a("ShortVideoResourceManager", "ShortVideoResourceManager[onReceiveSuccess] mConfigStatus=" + jdField_a_of_type_Bcxu.a(), null);
          continue;
        }
        i -= 1;
      }
      finally {}
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, bcxw parambcxw)
  {
    a(paramQQAppInterface, parambcxw, "new_qq_android_native_art_filter_");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, bcxw parambcxw)
  {
    ThreadManager.excute(new ShortVideoResourceManager.5(paramQQAppInterface, paramList, parambcxw), 128, null, false);
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
    return "hashCode=" + jdField_a_of_type_Bcxu.hashCode() + " ,pid=" + Process.myPid() + ",tid" + Process.myTid();
  }
  
  public static void c(QQAppInterface paramQQAppInterface, List<ShortVideoResourceManager.SVConfigItem> paramList, bcxw parambcxw)
  {
    ThreadManager.excute(new ShortVideoResourceManager.7(paramQQAppInterface, paramList, parambcxw), 128, null, false);
  }
  
  private static String d()
  {
    return boff.jdField_a_of_type_JavaLangString + File.separator;
  }
  
  private void e()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        bcxv localbcxv = (bcxv)localIterator.next();
        if ((localbcxv != null) && (localbcxv.jdField_a_of_type_JavaUtilArrayList != null))
        {
          int i = 0;
          while (i < localbcxv.jdField_a_of_type_JavaUtilArrayList.size())
          {
            ((bcxw)localbcxv.jdField_a_of_type_JavaUtilArrayList.get(i)).B_();
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
      bool = bcxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
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
    VideoEnvironment.a("ShortVideoResourceManager", "[PreDownload]onConfigResult:result=" + paramInt1 + ",serverError" + paramInt2 + ",getType=" + jdField_a_of_type_Bcxu.b, null);
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
  
  public void a(bcxw parambcxw, String paramString)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        if ((localObject2 != null) && (((String)localObject2).startsWith(paramString)))
        {
          localObject2 = (bcxv)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
          if ((localObject2 != null) && (parambcxw != null)) {
            ((bcxv)localObject2).jdField_a_of_type_JavaUtilArrayList.remove(parambcxw);
          }
        }
      }
    }
  }
  
  public void a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem, bcxw parambcxw)
  {
    for (;;)
    {
      Object localObject2;
      boolean bool;
      synchronized (this.b)
      {
        localObject2 = (bcxv)this.jdField_a_of_type_JavaUtilHashMap.get(paramSVConfigItem.name);
        if (localObject2 != null) {
          break label361;
        }
        localObject2 = new boolean[1];
        bool = a(paramSVConfigItem, parambcxw, (boolean[])localObject2);
        if (localObject2[0] != 0) {
          parambcxw = null;
        }
        VideoEnvironment.a("ShortVideoResourceManager", "doRealSendRequest:doDownload=" + bool, null);
        beum localbeum;
        if (bool)
        {
          localObject2 = b();
          b((String)localObject2 + paramSVConfigItem.name);
          localObject2 = d();
          b((String)localObject2 + paramSVConfigItem.name);
          localbeum = new beum();
          localbeum.jdField_a_of_type_Beuq = this;
          if ((bcyy.a()) && (paramSVConfigItem.check64BitReady()))
          {
            localbeum.jdField_a_of_type_JavaLangString = paramSVConfigItem.arm64v8a_url;
            localbeum.jdField_a_of_type_Int = 0;
            localbeum.c = ((String)localObject2 + paramSVConfigItem.name);
            localbeum.b = bhnv.a(bevn.a().a());
            localbeum.n = true;
            localbeum.a(paramSVConfigItem.name);
            localObject2 = new bcxv(this, localbeum);
            ((bcxv)localObject2).jdField_a_of_type_Int = paramSVConfigItem.versionCode;
            if ((!bcyy.a()) || (!paramSVConfigItem.check64BitReady())) {
              break label349;
            }
            ((bcxv)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.arm64v8a_md5;
            if (parambcxw != null)
            {
              ((bcxv)localObject2).jdField_a_of_type_JavaUtilArrayList.add(parambcxw);
              VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[session][new]add callBack ok...", null);
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(paramSVConfigItem.name, localObject2);
            ((bcxv)localObject2).a();
          }
        }
        else
        {
          return;
        }
        localbeum.jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_url;
      }
      label349:
      ((bcxv)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_md5;
      continue;
      label361:
      if (((bcxv)localObject2).b == 0)
      {
        ((bcxv)localObject2).jdField_a_of_type_Int = paramSVConfigItem.versionCode;
        if ((bcyy.a()) && (paramSVConfigItem.check64BitReady())) {}
        for (((bcxv)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.arm64v8a_md5;; ((bcxv)localObject2).jdField_a_of_type_JavaLangString = paramSVConfigItem.armv7a_md5)
        {
          if (parambcxw != null)
          {
            bool = ((bcxv)localObject2).jdField_a_of_type_JavaUtilArrayList.contains(parambcxw);
            VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][start]contains=" + bool, null);
            if (!bool)
            {
              ((bcxv)localObject2).jdField_a_of_type_JavaUtilArrayList.add(parambcxw);
              VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][start]add callBack ok...", null);
            }
          }
          ((bcxv)localObject2).a();
          break;
        }
      }
      if (parambcxw != null)
      {
        bool = ((bcxv)localObject2).jdField_a_of_type_JavaUtilArrayList.contains(parambcxw);
        VideoEnvironment.a("ShortVideoResourceManager", "sendRequest[oldSession][pending]contains=" + bool, null);
        if (!bool)
        {
          ((bcxv)localObject2).jdField_a_of_type_JavaUtilArrayList.add(parambcxw);
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
    ((List)???).add("new_qq_android_native_art_filter_");
    ((List)???).add("new_qq_android_native_portrait_filter_");
    ((List)???).add("new_qq_android_native_short_other_");
    Iterator localIterator = ((List)???).iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (String)localIterator.next();
      synchronized (this.b)
      {
        localObject3 = (bcxv)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3);
        if (localObject3 != null) {
          ((bcxv)localObject3).jdField_a_of_type_JavaUtilArrayList.clear();
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
      bcxo.a();
      d();
      return;
    }
    finally {}
  }
  
  public final void onResp(bevm parambevm)
  {
    ThreadManager.post(new ShortVideoResourceManager.9(this, parambevm), 5, null, false);
  }
  
  public final void onUpdateProgeress(bevl arg1, long paramLong1, long paramLong2)
  {
    String str = (String)???.a();
    if (str == null) {}
    VideoEnvironment.a("ShortVideoResourceManager", "[onUpdateProgeress]curOffset=" + paramLong1 + ",totalLen=" + paramLong2 + ",key=" + str, null);
    for (;;)
    {
      int i;
      synchronized (this.b)
      {
        bcxv localbcxv = (bcxv)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        localbcxv.b = 2;
        int j = localbcxv.jdField_a_of_type_JavaUtilArrayList.size();
        i = 0;
        if (i < j)
        {
          if ((localbcxv.jdField_a_of_type_JavaUtilArrayList.get(i) != null) && (str != null)) {
            ((bcxw)localbcxv.jdField_a_of_type_JavaUtilArrayList.get(i)).a(str, paramLong1, paramLong2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceManager
 * JD-Core Version:    0.7.0.1
 */