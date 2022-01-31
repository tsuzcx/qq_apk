package com.tencent.mobileqq.model;

import aehm;
import aehn;
import aeho;
import aehp;
import aehr;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.VasPalette;
import com.tencent.mobileqq.vas.VasPalette.OcNode;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatBackgroundManager
  implements Manager
{
  public static int a;
  public static Handler a;
  public static int b;
  public static final String b;
  public static int c;
  public static String c;
  public LruCache a;
  public QQAppInterface a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new aehm(this, "param_WIFIFontDownloadFlow", "param_XGFontDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  public IPCDownloadListener a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_b_of_type_JavaLangString = AppConstants.bK + "ChatBgJson.txt";
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_AndroidOsHandler = new aehr(BaseApplication.getContext().getMainLooper());
  }
  
  public ChatBackgroundManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramQQAppInterface.getManager(46));
  }
  
  public static int a()
  {
    int j = 0;
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.vip_individuation.name());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 6)
      {
        if ("1".equals(localObject[4])) {}
        for (int i = 1;; i = 0)
        {
          if ("1".equals(localObject[5])) {
            j = 2;
          }
          i = i | 0x0 | j;
          if (QLog.isColorLevel()) {
            QLog.d("ChatBackground", 2, "dynamic background DPC value = " + i);
          }
          return i;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackground", 2, "dynamic background DPC default value = 3");
    }
    return 3;
  }
  
  public static long a()
  {
    Runtime localRuntime = Runtime.getRuntime();
    long l1 = localRuntime.maxMemory();
    long l2 = localRuntime.totalMemory();
    return localRuntime.freeMemory() + (l1 - l2);
  }
  
  public static String a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return AppConstants.bK + paramString + ".jpg";
    }
    return AppConstants.aJ + "custom_background/" + paramString;
  }
  
  private Vector a(Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null) {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
    }
    while (paramSessionInfo.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatBackgroundManager", 4, "SessionInfo.chatBg.img == null");
      }
      return null;
      localObject = (Vector)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      if (localObject != null) {
        return localObject;
      }
    }
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, new Vector(5));
    Object localObject = new aeho(this, paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundManager", 2, "Background Path=" + paramString + ", start extract background theme color.");
    }
    boolean bool2 = false;
    boolean bool1;
    if (paramSessionInfo.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      if ((paramSessionInfo.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable))
      {
        paramSessionInfo = ((BitmapDrawable)paramSessionInfo.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
        paramContext = paramSessionInfo;
        bool1 = bool2;
        if (QLog.isDevelopLevel())
        {
          QLog.d("ChatBackgroundManager", 4, "SessionInfo.chatBg.img is BitmapDrawable");
          bool1 = bool2;
          paramContext = paramSessionInfo;
        }
      }
    }
    for (;;)
    {
      ThreadManager.executeOnFileThread(new aehp(this, paramString, paramContext, bool1, (ChatBackgroundManager.BgThemeColorExtractListener)localObject));
      return null;
      paramSessionInfo = ImageUtil.b(paramSessionInfo.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      bool2 = true;
      paramContext = paramSessionInfo;
      bool1 = bool2;
      if (QLog.isDevelopLevel())
      {
        QLog.d("ChatBackgroundManager", 4, "SessionInfo.chatBg.img is not BitmapDrawable");
        paramContext = paramSessionInfo;
        bool1 = bool2;
        continue;
        paramContext = null;
        bool1 = bool2;
      }
    }
  }
  
  public static void a()
  {
    jdField_c_of_type_JavaLangString = null;
    jdField_c_of_type_Int = 0;
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "ChatBackground destroy() is called");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, StatisticCollector paramStatisticCollector)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(jdField_c_of_type_JavaLangString, Integer.valueOf(1));
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "initCurrChatBgNameForReport is:" + jdField_c_of_type_JavaLangString);
    }
    paramStatisticCollector.b(paramQQAppInterface, paramString, localHashMap);
  }
  
  public static void a(String paramString)
  {
    VasMonitorHandler.a(BaseApplicationImpl.getApplication().getRuntime(), "individual_v2_background_play_fail", "0", paramString, Build.MODEL, Build.VERSION.RELEASE, Long.toString(DeviceInfoUtil.e()), 0.0F, 0.0F);
  }
  
  public static boolean a(File paramFile)
  {
    if ((b(paramFile)) && ((a() & 0x1) != 0))
    {
      long l = a();
      if (l <= 10485760L) {
        QLog.d("ChatBackground", 1, "availableMemory is " + l + ", too low to play dynamic background");
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean b(File paramFile)
  {
    // Byte code:
    //   0: bipush 8
    //   2: newarray byte
    //   4: astore 5
    //   6: aload 5
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 337
    //   13: bastore
    //   14: dup
    //   15: iconst_1
    //   16: ldc_w 338
    //   19: bastore
    //   20: dup
    //   21: iconst_2
    //   22: ldc_w 339
    //   25: bastore
    //   26: dup
    //   27: iconst_3
    //   28: ldc_w 340
    //   31: bastore
    //   32: dup
    //   33: iconst_4
    //   34: ldc_w 341
    //   37: bastore
    //   38: dup
    //   39: iconst_5
    //   40: ldc_w 342
    //   43: bastore
    //   44: dup
    //   45: bipush 6
    //   47: ldc_w 343
    //   50: bastore
    //   51: dup
    //   52: bipush 7
    //   54: ldc_w 342
    //   57: bastore
    //   58: pop
    //   59: aload_0
    //   60: invokevirtual 348	java/io/File:exists	()Z
    //   63: ifne +5 -> 68
    //   66: iconst_0
    //   67: ireturn
    //   68: new 350	java/io/RandomAccessFile
    //   71: dup
    //   72: aload_0
    //   73: ldc_w 352
    //   76: invokespecial 355	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   79: astore 4
    //   81: aload 4
    //   83: astore_0
    //   84: aload 5
    //   86: arraylength
    //   87: newarray byte
    //   89: astore 6
    //   91: aload 4
    //   93: astore_0
    //   94: aload 4
    //   96: aload 6
    //   98: invokevirtual 359	java/io/RandomAccessFile:read	([B)I
    //   101: pop
    //   102: iconst_0
    //   103: istore_1
    //   104: aload 4
    //   106: astore_0
    //   107: iload_1
    //   108: aload 5
    //   110: arraylength
    //   111: if_icmpge +50 -> 161
    //   114: aload 6
    //   116: iload_1
    //   117: baload
    //   118: istore_2
    //   119: aload 5
    //   121: iload_1
    //   122: baload
    //   123: istore_3
    //   124: iload_2
    //   125: iload_3
    //   126: if_icmpeq +28 -> 154
    //   129: aload 4
    //   131: ifnull -65 -> 66
    //   134: aload 4
    //   136: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_0
    //   142: ldc 140
    //   144: iconst_1
    //   145: ldc_w 364
    //   148: aload_0
    //   149: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   152: iconst_0
    //   153: ireturn
    //   154: iload_1
    //   155: iconst_1
    //   156: iadd
    //   157: istore_1
    //   158: goto -54 -> 104
    //   161: aload 4
    //   163: ifnull +8 -> 171
    //   166: aload 4
    //   168: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   171: iconst_1
    //   172: ireturn
    //   173: astore_0
    //   174: ldc 140
    //   176: iconst_1
    //   177: ldc_w 364
    //   180: aload_0
    //   181: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -13 -> 171
    //   187: astore 5
    //   189: aconst_null
    //   190: astore 4
    //   192: aload 4
    //   194: astore_0
    //   195: ldc 140
    //   197: iconst_1
    //   198: ldc_w 364
    //   201: aload 5
    //   203: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   206: aload 4
    //   208: ifnull -142 -> 66
    //   211: aload 4
    //   213: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   216: iconst_0
    //   217: ireturn
    //   218: astore_0
    //   219: ldc 140
    //   221: iconst_1
    //   222: ldc_w 364
    //   225: aload_0
    //   226: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore 4
    //   233: aconst_null
    //   234: astore_0
    //   235: aload_0
    //   236: ifnull +7 -> 243
    //   239: aload_0
    //   240: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   243: aload 4
    //   245: athrow
    //   246: astore_0
    //   247: ldc 140
    //   249: iconst_1
    //   250: ldc_w 364
    //   253: aload_0
    //   254: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   257: goto -14 -> 243
    //   260: astore 4
    //   262: goto -27 -> 235
    //   265: astore 5
    //   267: goto -75 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramFile	File
    //   103	55	1	i	int
    //   118	9	2	j	int
    //   123	4	3	k	int
    //   79	133	4	localRandomAccessFile	java.io.RandomAccessFile
    //   231	13	4	localObject1	Object
    //   260	1	4	localObject2	Object
    //   4	116	5	arrayOfByte1	byte[]
    //   187	15	5	localIOException1	java.io.IOException
    //   265	1	5	localIOException2	java.io.IOException
    //   89	26	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   134	139	141	java/io/IOException
    //   166	171	173	java/io/IOException
    //   68	81	187	java/io/IOException
    //   211	216	218	java/io/IOException
    //   68	81	231	finally
    //   239	243	246	java/io/IOException
    //   84	91	260	finally
    //   94	102	260	finally
    //   107	114	260	finally
    //   195	206	260	finally
    //   84	91	265	java/io/IOException
    //   94	102	265	java/io/IOException
    //   107	114	265	java/io/IOException
  }
  
  private String e(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.equals("null"))) {
      str = "null";
    }
    do
    {
      return str;
      if (paramString.equals("none")) {
        return "null";
      }
      int i = paramString.lastIndexOf(File.separatorChar);
      if ((i < 0) || (i >= paramString.length() - 1)) {
        break label153;
      }
      str = paramString.substring(0, i + 1);
      if (!AppConstants.bK.equals(str)) {
        break;
      }
      str = paramString.substring(i + 1);
      i = str.lastIndexOf('.');
      paramString = str;
      if (i >= 0) {
        paramString = str.substring(0, i);
      }
      str = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("ChatBackgroundManager", 2, "picName is:" + paramString);
    return paramString;
    return "custom";
    label153:
    throw new IllegalStateException("picPath is illegal,picPath is:" + paramString);
  }
  
  public int a(Context paramContext, SessionInfo paramSessionInfo, int paramInt, double paramDouble)
  {
    int i = 0;
    int j = 0;
    String str;
    if ((paramSessionInfo != null) && (paramSessionInfo.a != null) && (paramSessionInfo.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      str = paramSessionInfo.a.jdField_a_of_type_JavaLangString;
      if ((!TextUtils.isEmpty(str)) && (!"null".equals(str)) && (!"none".equals(str))) {
        break label362;
      }
      str = ThemeUtil.getCurrentThemeId();
      if ("1000".equals(str))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatBackgroundManager", 4, "No Chat Background(Default Theme).");
        }
        paramInt = 2;
        return paramInt;
      }
      str = "theme_background_" + str;
    }
    label362:
    for (;;)
    {
      paramContext = a(paramContext, paramSessionInfo, str);
      if (paramContext == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatBackgroundManager", 4, "Background Path=" + str + ", background color not in cache.");
        }
        return -1;
      }
      if (paramContext.isEmpty())
      {
        paramInt = j;
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("ChatBackgroundManager", 4, "Background Path=" + str + ", background color is extracting.");
        return 0;
      }
      do
      {
        i += 1;
        if (i >= paramContext.size()) {
          break;
        }
      } while (!a(((Integer)paramContext.get(i)).intValue(), paramInt, paramDouble));
      if (QLog.isColorLevel()) {
        QLog.d("ChatBackgroundManager", 4, "Background Path=" + str + ", background color is similar to font color.");
      }
      return 1;
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatBackgroundManager", 4, "Background Path=" + str + ", background color is not similar to font color.");
      }
      for (;;)
      {
        return 2;
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatBackgroundManager", 4, "No Chat Background.");
        }
      }
    }
  }
  
  public int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(d(paramString), 0);
  }
  
  public Bundle a(Context paramContext, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    try
    {
      File localFile = new File(a(true, paramString1));
      if ((a(paramContext, paramString1) != null) && (localFile.exists()))
      {
        localBundle.putInt("status", 1);
        localBundle.putInt("progress", 100);
        localBundle.putInt("result", 0);
        localBundle.putString("message", "本地存在");
      }
      for (;;)
      {
        localBundle.putString("id", paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("ChatBackgroundManager", 2, "queryInfo chatbgId=" + paramString1 + ",json=" + localBundle.toString());
        }
        return localBundle;
        paramContext = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(paramString2);
        if (paramContext == null) {
          break;
        }
        switch (paramContext.a())
        {
        case 0: 
        case 1: 
          localBundle.putInt("result", 0);
          localBundle.putString("message", "未知状态");
          localBundle.putInt("status", 0);
          localBundle.putInt("progress", (int)paramContext.a);
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        continue;
        localBundle.putInt("result", 0);
        localBundle.putString("message", "下载中");
        continue;
        localBundle.putInt("result", 0);
        localBundle.putString("message", "下载完成");
        continue;
        localBundle.putInt("result", 1);
        localBundle.putString("message", "下载失败");
        continue;
        localBundle.putInt("status", 0);
        localBundle.putInt("progress", 0);
        localBundle.putInt("result", 0);
        localBundle.putString("message", "未知状态");
      }
    }
  }
  
  public ChatBackgroundInfo a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("userChatbgInfo", 0).getString("userChatbgKey", "");
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundManager", 2, " getchatbgInfo chatbgInfo=" + paramContext);
    }
    if (paramContext != null)
    {
      try
      {
        if (paramContext.length() <= 0) {
          break label147;
        }
        paramContext = new JSONObject(paramContext);
        if (!paramContext.has(paramString)) {
          break label147;
        }
        JSONObject localJSONObject = paramContext.getJSONObject(paramString);
        paramContext = new ChatBackgroundInfo();
        paramString.printStackTrace();
      }
      catch (JSONException paramString)
      {
        try
        {
          paramContext.id = paramString;
          paramContext.name = localJSONObject.getString("name");
          paramContext.url = localJSONObject.getString("url");
          paramContext.thumbUrl = localJSONObject.getString("thumbUrl");
          return paramContext;
        }
        catch (JSONException paramString)
        {
          break label137;
        }
        paramString = paramString;
        paramContext = null;
      }
      label137:
      return paramContext;
    }
    label147:
    return null;
  }
  
  public String a(Context paramContext, String paramString)
  {
    String str = "none";
    paramContext = a(paramContext, paramString);
    if (paramContext != null)
    {
      paramString = paramContext.thumbUrl;
      paramContext = paramString;
      if (paramString != null)
      {
        paramContext = paramString;
        if (!"none".equals(paramString)) {
          paramContext = paramString + "&isOldVersion=" + jdField_b_of_type_Int;
        }
      }
    }
    do
    {
      do
      {
        return paramContext;
        paramContext = str;
      } while (!new File(jdField_b_of_type_JavaLangString).exists());
      paramString = a(paramString);
      paramContext = paramString;
    } while ("none".equals(paramString));
    return paramString + "?isOldVersion=" + jdField_a_of_type_Int;
  }
  
  public String a(String paramString)
  {
    try
    {
      Object localObject = FileUtils.a(new File(jdField_b_of_type_JavaLangString));
      localObject = new JSONObject((String)((String)localObject).subSequence(((String)localObject).indexOf("{"), ((String)localObject).length() - 1)).getJSONObject("data").getJSONArray("chatBackground");
      int j = ((JSONArray)localObject).length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        if (localJSONObject.getString("id").equals(paramString))
        {
          paramString = "http://i.gtimg.cn/qqshow/admindata/comdata/backgroundMall_chat_1/" + localJSONObject.getString("thumbnail");
          return paramString;
        }
        i += 1;
      }
      return "none";
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
  }
  
  public HashMap a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localObject1 = ((Context)localObject1).getSharedPreferences("chat_background_path_" + (String)localObject2, 0);
    localObject2 = new HashMap();
    Iterator localIterator = ((SharedPreferences)localObject1).getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (Pattern.compile("[0-9]*").matcher(str).matches()) {
        ((HashMap)localObject2).put(str, e(((SharedPreferences)localObject1).getString(str, "null")));
      }
    }
    ((HashMap)localObject2).put("chat_uniform_bg", e(((SharedPreferences)localObject1).getString("chat_uniform_bg", "null")));
    return localObject2;
  }
  
  public List a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localObject2 = ((Context)localObject1).getSharedPreferences("chat_background_path_" + (String)localObject2, 0);
    localObject1 = new ArrayList();
    Iterator localIterator = ((SharedPreferences)localObject2).getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (Pattern.compile("[0-9]*").matcher(str).matches())
      {
        str = e(((SharedPreferences)localObject2).getString(str, "null"));
        if ((str != null) && (!str.equals("null")) && (!str.equals("custom")) && (!((List)localObject1).contains(Integer.valueOf(str)))) {
          ((List)localObject1).add(Integer.valueOf(str));
        }
      }
    }
    localObject2 = e(((SharedPreferences)localObject2).getString("chat_uniform_bg", "null"));
    if ((localObject2 != null) && (!((String)localObject2).equals("null")) && (!((String)localObject2).equals("custom")) && (!((List)localObject1).contains(Integer.valueOf((String)localObject2)))) {
      ((List)localObject1).add(Integer.valueOf((String)localObject2));
    }
    return localObject1;
  }
  
  public Vector a(Bitmap paramBitmap)
  {
    int j = 0;
    Object localObject = VasPalette.a(paramBitmap);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      paramBitmap = ((List)localObject).iterator();
      for (int i = 0; paramBitmap.hasNext(); i = ((VasPalette.OcNode)paramBitmap.next()).jdField_a_of_type_Int + i) {}
      paramBitmap = new Vector();
      float f = ((VasPalette.OcNode)((List)localObject).get(0)).a();
      localObject = ((List)localObject).iterator();
      int k;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        VasPalette.OcNode localOcNode = (VasPalette.OcNode)((Iterator)localObject).next();
        if (localOcNode.a() / f <= 0.2F) {
          break;
        }
        paramBitmap.add(Integer.valueOf(localOcNode.a()));
        k = j + localOcNode.jdField_a_of_type_Int;
        j = k;
      } while (k / i <= 0.800000011920929D);
      return paramBitmap;
    }
    return null;
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatBackgroundManager", 2, "download chatbg report actionResult=" + paramInt + ",chatbgId=" + paramString);
    }
    int i = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "chatbackground", "BjIDXiazai", 0, paramInt, "0", "0", i + "", String.valueOf(paramLong));
  }
  
  public void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("ChatBackgroundManager", 2, "uin is empty,not save switch bg times");
      }
    }
    int i;
    do
    {
      return;
      paramString = d(paramString);
      i = paramContext.getInt(paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.d("ChatBackgroundManager", 2, "oldCount is:" + i);
      }
      paramContext = paramContext.edit();
      i += 1;
      paramContext.putInt(paramString, i);
      paramContext.commit();
    } while (!QLog.isColorLevel());
    QLog.d("ChatBackgroundManager", 2, "save count is:" + i);
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      String str = ChatActivityUtils.b(paramIntent.getInt("uintype", 999));
      int i = paramIntent.getInt("bg_replace_entrance", 999);
      if (QLog.isDevelopLevel()) {
        QLog.d("reportEvent", 4, " uin_type : " + str + " entrance_type ： " + i);
      }
      if (i != 999) {
        ReportController.b(null, "CliOper", "", "", "background", "bkground_replace", i, 0, "0", "0", "", "");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    jdField_c_of_type_Int = 0;
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    jdField_c_of_type_JavaLangString = null;
    paramQQAppInterface.a(new aehn(this, paramString, paramQQAppInterface));
  }
  
  public void a(ChatBackgroundInfo paramChatBackgroundInfo, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || ((paramString == null) && (!DownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext()))) || (paramChatBackgroundInfo == null)) {
      QLog.d("ChatBackgroundManager", 2, "startDownload error mApp=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    String str1;
    do
    {
      return;
      str1 = paramChatBackgroundInfo.id;
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", Integer.valueOf(str1).intValue());
      localBundle.putString("callbackId", paramString);
      if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramChatBackgroundInfo.id) == null) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramChatBackgroundInfo);
      }
      paramString = new File(a(true, str1));
      if (paramString.exists())
      {
        this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(Long.valueOf(str1).longValue(), 0, localBundle);
        return;
      }
      String str2 = paramChatBackgroundInfo.url;
      localBundle.putSerializable("chatbgInfo", paramChatBackgroundInfo);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), "ChatBackgroundManager", false);
        if ((QLog.isColorLevel()) || (!this.jdField_a_of_type_Boolean)) {
          QLog.d("ChatBackgroundManager", 2, "startDownload mhaveSDCard:" + this.jdField_a_of_type_Boolean);
        }
      }
      paramChatBackgroundInfo = new DownloadTask(str2, paramString);
      paramChatBackgroundInfo.b = true;
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(paramChatBackgroundInfo, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("ChatBackgroundManager", 2, "startDownload  id=" + str1);
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ChatBackground.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramString1, paramString2, paramString3);
    ReportController.b(null, "CliOper", "", "", "chatbackground", "BjIDShezhi", 0, 0, "0", "0", "", e(paramString3));
  }
  
  public boolean a(int paramInt1, int paramInt2, double paramDouble)
  {
    int i = Color.red(paramInt1);
    int j = Color.green(paramInt1);
    int k = Color.blue(paramInt1);
    int m = Color.red(paramInt2);
    int n = Color.green(paramInt2);
    int i1 = Color.blue(paramInt2);
    double d = Math.abs(i * i - m * m);
    d = Math.abs(j * j - n * n) * 0.587D + d * 0.299D + Math.abs(k * k - i1 * i1) * 0.114D;
    if (QLog.isDevelopLevel()) {
      QLog.d("ChatBackgroundManager", 4, "color1=" + paramInt1 + ", color2=" + paramInt2 + ", similarity=" + d);
    }
    return d < paramDouble;
  }
  
  public boolean a(Context paramContext, ChatBackgroundInfo paramChatBackgroundInfo)
  {
    boolean bool = false;
    paramContext = paramContext.getSharedPreferences("userChatbgInfo", 0);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramContext = paramContext.getString("userChatbgKey", "");
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundManager", 2, " setchatbgInfo chatbgInfo=" + paramChatBackgroundInfo.toString());
    }
    String str = paramChatBackgroundInfo.id;
    if (str != null)
    {
      if (paramContext != null) {}
      try
      {
        if (paramContext.length() > 0)
        {
          paramContext = new JSONObject(paramContext);
          if (!paramContext.has(str)) {
            break label233;
          }
        }
        label233:
        for (JSONObject localJSONObject = paramContext.getJSONObject(str);; localJSONObject = new JSONObject())
        {
          localJSONObject.put("name", paramChatBackgroundInfo.name);
          localJSONObject.put("url", paramChatBackgroundInfo.url);
          localJSONObject.put("thumbUrl", paramChatBackgroundInfo.thumbUrl);
          paramContext.put(str, localJSONObject);
          bool = localEditor.putString("userChatbgKey", paramContext.toString()).commit();
          if ((bool) || (!QLog.isColorLevel())) {
            return bool;
          }
          QLog.d("ChatBackgroundManager", 2, "setThemeInfo sp comit rt=" + bool);
          return bool;
          paramContext = new JSONObject();
          break;
        }
        if (!QLog.isColorLevel()) {
          return bool;
        }
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatBackgroundManager", 2, "ThemeUtil setThemeInfo error:" + paramContext.getMessage());
        }
        paramContext.printStackTrace();
        return false;
      }
    }
    else
    {
      QLog.d("ChatBackgroundManager", 2, "ThemeUtil setThemeInfo error themeId is null");
      return false;
    }
    return bool;
  }
  
  public String b(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("chat_background_path_" + this.jdField_a_of_type_JavaLangString, 0);
    String str = localSharedPreferences.getString(paramString, null);
    paramString = str;
    if (str == null)
    {
      str = localSharedPreferences.getString("chat_uniform_bg", null);
      paramString = str;
      if (str == null) {
        paramString = "null";
      }
    }
    if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.equals("null"))) {
      str = "null";
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.equals("none"));
    return "null";
  }
  
  public void b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    paramString = d(paramString);
    paramContext = paramContext.edit();
    paramContext.putInt(paramString, 0);
    paramContext.commit();
  }
  
  public String c(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("chat_background_path_" + this.jdField_a_of_type_JavaLangString, 0);
    String str = localSharedPreferences.getString(paramString, null);
    paramString = str;
    if (str == null)
    {
      str = localSharedPreferences.getString("chat_uniform_bg", null);
      paramString = str;
      if (str == null) {
        paramString = "null";
      }
    }
    return e(paramString);
  }
  
  public String d(String paramString)
  {
    return "chat_background_switch_times_" + paramString;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager
 * JD-Core Version:    0.7.0.1
 */