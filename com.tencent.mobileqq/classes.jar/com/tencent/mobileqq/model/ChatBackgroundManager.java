package com.tencent.mobileqq.model;

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
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasDownloadInfo;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.VasPalette;
import com.tencent.mobileqq.vas.VasPalette.OcNode;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.DIYThemeUtils;
import com.tencent.mobileqq.vas.theme.diy.ResData;
import com.tencent.mobileqq.vas.theme.diy.ResSuitData;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.theme.diy.ThemeDIYData;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic.DarkBrightnessTask;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
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
  public static final String d;
  public static int e;
  public static int f;
  static String i;
  static int j = 0;
  static Handler k;
  QQAppInterface a = null;
  String b;
  Map<String, IPCDownloadListener> c = new ConcurrentHashMap();
  LruCache<String, Vector<Integer>> g;
  boolean h;
  Map<String, VasDownloadInfo> l = new ConcurrentHashMap();
  private DownloaderFactory m = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.PATH_SYSTEM_BACKGROUND_RESOURCE);
    localStringBuilder.append("ChatBgJson.txt");
    d = localStringBuilder.toString();
    e = 1;
    f = 0;
    k = new ChatBackgroundManager.ReportChatBgHandler(BaseApplication.getContext().getMainLooper());
  }
  
  public ChatBackgroundManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = paramQQAppInterface.getAccount();
    this.m = ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY));
  }
  
  public static int a()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.vip_individuation.name());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 6)
      {
        boolean bool = "1".equals(localObject[4]);
        int n = 0;
        if ("1".equals(localObject[5])) {
          n = 2;
        }
        n = bool | false | n;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dynamic background DPC value = ");
          ((StringBuilder)localObject).append(n);
          QLog.d("ChatBackground", 2, ((StringBuilder)localObject).toString());
        }
        return n;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackground", 2, "dynamic background DPC default value = 3");
    }
    return 3;
  }
  
  public static int a(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramSharedPreferences == null) {
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_chat_bg_effect");
    int n = paramSharedPreferences.getInt(localStringBuilder.toString(), -1);
    if (n == -1) {
      return paramSharedPreferences.getInt("_chat_bg_effect", 0);
    }
    return n;
  }
  
  private Vector<Integer> a(Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      this.g = new LruCache(20);
    }
    else
    {
      localObject = (Vector)((LruCache)localObject).get(paramString);
      if (localObject != null) {
        return localObject;
      }
    }
    if (paramSessionInfo.H.c == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatBackgroundManager", 4, "SessionInfo.chatBg.img == null");
      }
      return null;
    }
    this.g.put(paramString, new Vector(5));
    localObject = new ChatBackgroundManager.3(this, paramContext);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("Background Path=");
      paramContext.append(paramString);
      paramContext.append(", start extract background theme color.");
      QLog.d("ChatBackgroundManager", 2, paramContext.toString());
    }
    if (paramSessionInfo.H.c != null)
    {
      if ((paramSessionInfo.H.c instanceof BitmapDrawable))
      {
        paramContext = ((BitmapDrawable)paramSessionInfo.H.c).getBitmap();
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatBackgroundManager", 4, "SessionInfo.chatBg.img is BitmapDrawable");
        }
      }
      else
      {
        paramContext = ImageUtil.c(paramSessionInfo.H.c);
        if (QLog.isDevelopLevel()) {
          QLog.d("ChatBackgroundManager", 4, "SessionInfo.chatBg.img is not BitmapDrawable");
        }
        bool = true;
        break label234;
      }
    }
    else {
      paramContext = null;
    }
    boolean bool = false;
    label234:
    ThreadManager.executeOnFileThread(new ChatBackgroundManager.BgColorExtractJob(this, paramString, paramContext, bool, (ChatBackgroundManager.BgThemeColorExtractListener)localObject));
    return null;
  }
  
  static void a(QQAppInterface paramQQAppInterface, String paramString, StatisticCollector paramStatisticCollector)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(i, Integer.valueOf(1));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initCurrChatBgNameForReport is:");
      localStringBuilder.append(i);
      QLog.d("ThemeDownloadTrace", 2, localStringBuilder.toString());
    }
    try
    {
      paramStatisticCollector.reportOnOff(paramQQAppInterface, paramString, localHashMap);
      return;
    }
    catch (NoClassDefFoundError paramQQAppInterface)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("realReportCurrChatBgName reportOnOff exception:");
        paramString.append(paramQQAppInterface.getMessage());
        QLog.e("ThemeDownloadTrace", 2, paramString.toString());
      }
    }
  }
  
  public static void a(String paramString)
  {
    VasMonitorHandler.a(BaseApplicationImpl.getApplication().getRuntime(), "individual_v2_background_play_fail", "0", paramString, Build.MODEL, Build.VERSION.RELEASE, Long.toString(DeviceInfoUtil.a()), 0.0F, 0.0F);
    paramString = new StringBuilder();
    paramString.append(Build.MODEL);
    paramString.append(" ");
    paramString.append(Build.VERSION.RELEASE);
    paramString.append(" ");
    paramString.append(Long.toString(DeviceInfoUtil.a()));
    VasMonitorDT.a("individual_v2_background_play_fail", paramString.toString());
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = ChatBackgroundUtil.a(paramContext, paramString1, paramString2);
    if (paramContext.contains("aioImage")) {
      return new File(paramContext.replace("aioImage", "main.json")).exists();
    }
    return false;
  }
  
  public static boolean a(File paramFile)
  {
    if ((b(paramFile)) && ((a() & 0x1) != 0))
    {
      long l1 = c();
      if (l1 <= 10485760L)
      {
        paramFile = new StringBuilder();
        paramFile.append("availableMemory is ");
        paramFile.append(l1);
        paramFile.append(", too low to play dynamic background");
        QLog.d("ChatBackground", 1, paramFile.toString());
        return false;
      }
      return true;
    }
    return false;
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chat_background_path_");
    localStringBuilder.append(paramString1);
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 4);
    if (TextUtils.isEmpty(paramString2)) {
      return paramContext.getInt("_chat_bg_effect", 0);
    }
    return a(paramContext, paramString2);
  }
  
  private void b(String paramString1, String paramString2)
  {
    boolean bool = paramString1.equals(ThemeBackground.c(this.a.getApp(), "theme_bg_setting_path_png", this.a.getCurrentAccountUin()));
    int n = 1;
    if ((!bool) && (!paramString1.equals(ThemeBackground.c(this.a.getApp(), "theme_bg_aio_path", this.a.getCurrentAccountUin())))) {
      n = 0;
    }
    if (n != 0) {
      GlobalImageCache.a.evictAll();
    }
    Object localObject = ThemeBackground.c(this.a.getApp(), "theme_bg_message_path_png", this.a.getCurrentAccountUin());
    if ((ThemeUtil.isNowThemeIsDIY()) && (paramString1.equals(localObject)))
    {
      localObject = new ThemeDIYData(2130849358, "theme_bg_message_path", 2131167543, "theme_bg_message_path_png", 50, 1);
      ((ThemeDIYData)localObject).i = new ResData();
      ResSuitData localResSuitData = new ResSuitData();
      localResSuitData.b = paramString1;
      localResSuitData.d = "";
      localResSuitData.g = "item";
      localResSuitData.f = "chatBg";
      paramString1 = DIYThemeUtils.a(this.a, localResSuitData, 116, localResSuitData.d);
      new ThemeDiyStyleLogic.DarkBrightnessTask(this.a.getApp(), this.a, paramString2, paramString1.d, (ThemeDIYData)localObject, null, new ChatBackgroundManager.4(this)).execute(new Object[0]);
    }
  }
  
  public static boolean b()
  {
    if ((a() & 0x1) != 0)
    {
      long l1 = c();
      if ((l1 > 10485760L) && (!DeviceInfoUtils.isLowPerfDevice())) {
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("availableMemory is ");
      localStringBuilder.append(l1);
      localStringBuilder.append(", too low to play dynamic background");
      QLog.d("ChatBackground", 1, localStringBuilder.toString());
    }
    return false;
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
    //   10: ldc_w 473
    //   13: bastore
    //   14: dup
    //   15: iconst_1
    //   16: ldc_w 474
    //   19: bastore
    //   20: dup
    //   21: iconst_2
    //   22: ldc_w 475
    //   25: bastore
    //   26: dup
    //   27: iconst_3
    //   28: ldc_w 476
    //   31: bastore
    //   32: dup
    //   33: iconst_4
    //   34: ldc_w 477
    //   37: bastore
    //   38: dup
    //   39: iconst_5
    //   40: ldc_w 478
    //   43: bastore
    //   44: dup
    //   45: bipush 6
    //   47: ldc_w 479
    //   50: bastore
    //   51: dup
    //   52: bipush 7
    //   54: ldc_w 478
    //   57: bastore
    //   58: pop
    //   59: aload_0
    //   60: invokevirtual 357	java/io/File:exists	()Z
    //   63: ifne +5 -> 68
    //   66: iconst_0
    //   67: ireturn
    //   68: aconst_null
    //   69: astore 6
    //   71: aconst_null
    //   72: astore 4
    //   74: new 481	java/io/RandomAccessFile
    //   77: dup
    //   78: aload_0
    //   79: ldc_w 483
    //   82: invokespecial 486	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   85: astore_0
    //   86: aload 5
    //   88: arraylength
    //   89: newarray byte
    //   91: astore 4
    //   93: aload_0
    //   94: aload 4
    //   96: invokevirtual 490	java/io/RandomAccessFile:read	([B)I
    //   99: pop
    //   100: iconst_0
    //   101: istore_1
    //   102: iload_1
    //   103: aload 5
    //   105: arraylength
    //   106: if_icmpge +44 -> 150
    //   109: aload 4
    //   111: iload_1
    //   112: baload
    //   113: istore_2
    //   114: aload 5
    //   116: iload_1
    //   117: baload
    //   118: istore_3
    //   119: iload_2
    //   120: iload_3
    //   121: if_icmpeq +22 -> 143
    //   124: aload_0
    //   125: invokevirtual 493	java/io/RandomAccessFile:close	()V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_0
    //   131: ldc 164
    //   133: iconst_1
    //   134: ldc_w 436
    //   137: aload_0
    //   138: invokestatic 496	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   141: iconst_0
    //   142: ireturn
    //   143: iload_1
    //   144: iconst_1
    //   145: iadd
    //   146: istore_1
    //   147: goto -45 -> 102
    //   150: aload_0
    //   151: invokevirtual 493	java/io/RandomAccessFile:close	()V
    //   154: iconst_1
    //   155: ireturn
    //   156: astore_0
    //   157: ldc 164
    //   159: iconst_1
    //   160: ldc_w 436
    //   163: aload_0
    //   164: invokestatic 496	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   167: iconst_1
    //   168: ireturn
    //   169: astore 4
    //   171: goto +62 -> 233
    //   174: astore 5
    //   176: goto +20 -> 196
    //   179: astore 5
    //   181: aload 4
    //   183: astore_0
    //   184: aload 5
    //   186: astore 4
    //   188: goto +45 -> 233
    //   191: astore 5
    //   193: aload 6
    //   195: astore_0
    //   196: aload_0
    //   197: astore 4
    //   199: ldc 164
    //   201: iconst_1
    //   202: ldc_w 436
    //   205: aload 5
    //   207: invokestatic 496	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload_0
    //   211: ifnull +20 -> 231
    //   214: aload_0
    //   215: invokevirtual 493	java/io/RandomAccessFile:close	()V
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_0
    //   221: ldc 164
    //   223: iconst_1
    //   224: ldc_w 436
    //   227: aload_0
    //   228: invokestatic 496	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: iconst_0
    //   232: ireturn
    //   233: aload_0
    //   234: ifnull +21 -> 255
    //   237: aload_0
    //   238: invokevirtual 493	java/io/RandomAccessFile:close	()V
    //   241: goto +14 -> 255
    //   244: astore_0
    //   245: ldc 164
    //   247: iconst_1
    //   248: ldc_w 436
    //   251: aload_0
    //   252: invokestatic 496	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   255: goto +6 -> 261
    //   258: aload 4
    //   260: athrow
    //   261: goto -3 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramFile	File
    //   101	46	1	n	int
    //   113	9	2	i1	int
    //   118	4	3	i2	int
    //   72	38	4	arrayOfByte1	byte[]
    //   169	13	4	localObject1	Object
    //   186	73	4	localObject2	Object
    //   4	111	5	arrayOfByte2	byte[]
    //   174	1	5	localIOException1	java.io.IOException
    //   179	6	5	localObject3	Object
    //   191	15	5	localIOException2	java.io.IOException
    //   69	125	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   124	128	130	java/io/IOException
    //   150	154	156	java/io/IOException
    //   86	100	169	finally
    //   102	109	169	finally
    //   86	100	174	java/io/IOException
    //   102	109	174	java/io/IOException
    //   74	86	179	finally
    //   199	210	179	finally
    //   74	86	191	java/io/IOException
    //   214	218	220	java/io/IOException
    //   237	241	244	java/io/IOException
  }
  
  public static long c()
  {
    Runtime localRuntime = Runtime.getRuntime();
    return localRuntime.maxMemory() - localRuntime.totalMemory() + localRuntime.freeMemory();
  }
  
  public static void j()
  {
    i = null;
    j = 0;
    k.removeMessages(1);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "ChatBackground destroy() is called");
    }
  }
  
  public int a(Context paramContext, SessionInfo paramSessionInfo, int paramInt, double paramDouble)
  {
    if ((paramSessionInfo != null) && (paramSessionInfo.H != null) && (paramSessionInfo.H.c != null))
    {
      Object localObject2 = paramSessionInfo.H.a;
      Object localObject1;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!"null".equals(localObject2)))
      {
        localObject1 = localObject2;
        if (!"none".equals(localObject2)) {}
      }
      else
      {
        localObject1 = ThemeUtil.getCurrentThemeId();
        if ("1000".equals(localObject1))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("ChatBackgroundManager", 4, "No Chat Background(Default Theme).");
          }
          return 2;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("theme_background_");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      paramContext = a(paramContext, paramSessionInfo, (String)localObject1);
      if (paramContext == null)
      {
        if (QLog.isDevelopLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("Background Path=");
          paramContext.append((String)localObject1);
          paramContext.append(", background color not in cache.");
          QLog.d("ChatBackgroundManager", 4, paramContext.toString());
        }
        return -1;
      }
      boolean bool = paramContext.isEmpty();
      int n = 0;
      if (bool)
      {
        if (QLog.isDevelopLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("Background Path=");
          paramContext.append((String)localObject1);
          paramContext.append(", background color is extracting.");
          QLog.d("ChatBackgroundManager", 4, paramContext.toString());
        }
        return 0;
      }
      while (n < paramContext.size())
      {
        if (a(((Integer)paramContext.get(n)).intValue(), paramInt, paramDouble))
        {
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("Background Path=");
            paramContext.append((String)localObject1);
            paramContext.append(", background color is similar to font color.");
            QLog.d("ChatBackgroundManager", 4, paramContext.toString());
          }
          return 1;
        }
        n += 1;
      }
      if (QLog.isDevelopLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("Background Path=");
        paramContext.append((String)localObject1);
        paramContext.append(", background color is not similar to font color.");
        QLog.d("ChatBackgroundManager", 4, paramContext.toString());
        return 2;
      }
    }
    else if (QLog.isDevelopLevel())
    {
      QLog.d("ChatBackgroundManager", 4, "No Chat Background.");
    }
    return 2;
  }
  
  public ChatBackgroundInfo a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("userChatbgInfo", 4).getString("userChatbgKey", "");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" getchatbgInfo chatbgInfo=");
      ((StringBuilder)localObject).append(paramContext);
      QLog.d("ChatBackgroundManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramContext != null)
    {
      try
      {
        if (paramContext.length() <= 0) {
          break label153;
        }
        paramContext = new JSONObject(paramContext);
        if (!paramContext.has(paramString)) {
          break label153;
        }
        localObject = paramContext.getJSONObject(paramString);
        paramContext = new ChatBackgroundInfo();
        try
        {
          paramContext.id = paramString;
          paramContext.name = ((JSONObject)localObject).optString("name");
          paramContext.url = ((JSONObject)localObject).optString("url");
          paramContext.thumbUrl = ((JSONObject)localObject).optString("thumbUrl");
          return paramContext;
        }
        catch (JSONException paramString) {}
        paramString.printStackTrace();
      }
      catch (JSONException paramString)
      {
        paramContext = null;
      }
      return paramContext;
    }
    label153:
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = ChatBackgroundUtil.a(this.a.getApp(), paramString1, 4);
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1 = localSharedPreferences.getString("chat_uniform_bg", null);
      if (TextUtils.isEmpty(paramString1)) {
        return ChatBackgroundUtil.b("null");
      }
      return ChatBackgroundUtil.b(paramString1);
    }
    paramString1 = localSharedPreferences.getString(paramString2, null);
    if (paramString1 == null)
    {
      paramString2 = localSharedPreferences.getString("chat_uniform_bg", null);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "null";
      }
    }
    return ChatBackgroundUtil.b(paramString1);
  }
  
  public Vector<Integer> a(Bitmap paramBitmap)
  {
    Object localObject = VasPalette.a(paramBitmap);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      paramBitmap = ((List)localObject).iterator();
      int i1 = 0;
      int n = 0;
      while (paramBitmap.hasNext()) {
        n += ((VasPalette.OcNode)paramBitmap.next()).d;
      }
      paramBitmap = new Vector();
      float f1 = ((VasPalette.OcNode)((List)localObject).get(0)).b();
      localObject = ((List)localObject).iterator();
      double d1;
      double d2;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        VasPalette.OcNode localOcNode = (VasPalette.OcNode)((Iterator)localObject).next();
        if (localOcNode.b() / f1 <= 0.2F) {
          break;
        }
        paramBitmap.add(Integer.valueOf(localOcNode.b()));
        i1 += localOcNode.d;
        d1 = i1;
        d2 = n;
        Double.isNaN(d1);
        Double.isNaN(d2);
      } while (d1 / d2 <= 0.800000011920929D);
      return paramBitmap;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setBgByScid  bgId:");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" effectId:");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" friendUin:");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" from:");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(" uinType:");
    ((StringBuilder)localObject1).append(paramInt3);
    QLog.d("ChatBackgroundManager", 1, ((StringBuilder)localObject1).toString());
    if ("99".equals(String.valueOf(paramInt1)))
    {
      ChatBackgroundUtil.a(this.a.getApp().getApplicationContext(), this.a.getCurrentUin(), paramString1, ChatBackgroundUtil.a(this.a.getApp().getApplicationContext(), this.a.getCurrentUin(), paramString1), paramInt2, paramInt3);
      return;
    }
    if ((!"100".equals(String.valueOf(paramInt1))) && (!"0".equals(String.valueOf(paramInt1))))
    {
      paramString2 = new StringBuilder();
      paramString2.append("callback_");
      paramString2.append(paramInt1);
      paramString2 = paramString2.toString();
      localObject1 = new ChatBackgroundInfo();
      Object localObject2 = ChatBackgroundUtil.a(true, String.valueOf(paramInt1));
      if (new File((String)localObject2).exists())
      {
        ChatBackgroundUtil.a(this.a.getApp().getApplicationContext(), this.a.getCurrentUin(), paramString1, (String)localObject2, paramInt2, paramInt3);
        return;
      }
      ((ChatBackgroundInfo)localObject1).id = String.valueOf(paramInt1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramInt1);
      a(((StringBuilder)localObject2).toString(), new ChatBackgroundManager.1(this, paramString1, paramInt2, paramInt3));
      a(this.a, (ChatBackgroundInfo)localObject1, paramString2);
      return;
    }
    ChatBackgroundUtil.a(this.a.getApp().getApplicationContext(), this.a.getCurrentUin(), paramString1, "null", paramInt2, paramInt3);
  }
  
  void a(int paramInt, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download chatbg report actionResult=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",chatbgId=");
      localStringBuilder.append(paramString);
      QLog.i("ChatBackgroundManager", 2, localStringBuilder.toString());
    }
    int n = NetworkUtil.getSystemNetwork(this.a.getApp().getApplicationContext());
    paramString = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(n);
    localStringBuilder.append("");
    ReportController.b(paramString, "CliOper", "", "", "chatbackground", "BjIDXiazai", 0, paramInt, "0", "0", localStringBuilder.toString(), String.valueOf(paramLong));
  }
  
  public void a(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    String str = paramString1.substring(7, paramString1.length());
    paramString2 = (VasDownloadInfo)this.l.get(str);
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = new VasDownloadInfo();
      paramString1.a = str;
    }
    paramString1.b = paramString3;
    boolean bool;
    if (paramInt1 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramString1.d = bool;
    paramString1.e = paramInt1;
    paramString1.h = System.currentTimeMillis();
    paramInt2 = paramString1.d ^ true;
    paramLong = paramString1.h;
    long l1 = paramString1.g;
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("endDownload  id=");
      paramString2.append(paramString1.d);
      paramString2.append("result =");
      paramString2.append(paramInt2);
      QLog.d("ChatBackgroundManager", 2, paramString2.toString());
    }
    if (paramString1.d)
    {
      a(0, paramString1.a, paramLong - l1);
    }
    else
    {
      a(1, paramString1.a, 0L);
      paramString2 = new StringBuilder();
      paramString2.append("chatbg downloadfail:id = ");
      paramString2.append(paramString1.a);
      paramString2.append(";result =");
      paramString2.append(paramInt2);
      QLog.d("ChatBackgroundManager", 1, paramString2.toString());
    }
    if (paramInt1 == 0)
    {
      paramString3 = g(str);
      paramString2 = ChatBackgroundUtil.a(str);
      File localFile = new File(paramString3);
      if (!localFile.exists())
      {
        paramString2 = new StringBuilder();
        paramString2.append("unzip file is missing ");
        paramString2.append(localFile.getAbsolutePath());
        QLog.e("ChatBackgroundManager", 1, paramString2.toString());
      }
      else
      {
        try
        {
          FileUtils.uncompressZip(localFile.getAbsolutePath(), paramString2, false);
          VasUpdateUtil.a(localFile);
          b(str, ChatBackgroundUtil.a(true, str));
        }
        catch (Throwable localThrowable)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("failed to unzip ");
          localStringBuilder.append(paramString3);
          localStringBuilder.append(" dstDir = ");
          localStringBuilder.append(paramString2);
          QLog.e("ChatBackgroundManager", 1, localStringBuilder.toString(), localThrowable);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("failed to unzip ");
          localStringBuilder.append(paramString3);
          localStringBuilder.append(" dstDir = ");
          localStringBuilder.append(paramString2);
          QLog.e("ChatBackgroundManager", 1, localStringBuilder.toString(), localOutOfMemoryError);
        }
        if (QLog.isColorLevel())
        {
          paramString3 = new StringBuilder();
          paramString3.append("onDownloadComplete, dstDir= ");
          paramString3.append(paramString2);
          QLog.d("ChatBackgroundManager", 2, paramString3.toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("onDownloadComplete failed, chatbg id = ");
      paramString2.append(str);
      paramString2.append(" errorCode = ");
      paramString2.append(paramInt1);
      QLog.d("ChatBackgroundManager", 2, paramString2.toString());
    }
    if ((!this.c.isEmpty()) && (paramString1.i != null) && (paramString1.i.containsKey("callbackId")))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1.i.getString("callbackId"));
      paramString2.append("_");
      paramString2.append(paramString1.i.getInt("id"));
      paramString2 = paramString2.toString();
      paramString2 = (IPCDownloadListener)this.c.remove(paramString2);
      if (paramString2 == null) {}
    }
    try
    {
      paramString2.a(Integer.valueOf(str).intValue(), paramInt2, paramString1.i);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      label729:
      break label729;
    }
    paramString1 = new StringBuilder();
    paramString1.append("onDownloadCompleted parse id faild, id = ");
    paramString1.append(str);
    QLog.e("ChatBackgroundManager", 2, paramString1.toString());
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras();
    if (localObject != null)
    {
      paramIntent = ChatActivityUtils.c(((Bundle)localObject).getInt("uintype", 999));
      int n = ((Bundle)localObject).getInt("bg_replace_entrance", 999);
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" uin_type : ");
        ((StringBuilder)localObject).append(paramIntent);
        ((StringBuilder)localObject).append(" entrance_type ： ");
        ((StringBuilder)localObject).append(n);
        QLog.d("reportEvent", 4, ((StringBuilder)localObject).toString());
      }
      if (n != 999) {
        ReportController.b(null, "CliOper", "", "", "background", "bkground_replace", n, 0, "0", "0", "", "");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt)
  {
    String str = paramString.substring(7, paramString.length());
    paramString = (VasDownloadInfo)this.l.get(str);
    paramQQAppInterface = paramString;
    if (paramString == null)
    {
      paramQQAppInterface = new VasDownloadInfo();
      paramQQAppInterface.a = str;
      this.l.put(str, paramQQAppInterface);
    }
    paramQQAppInterface.c = paramInt;
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatBackgroundInfo paramChatBackgroundInfo, String paramString)
  {
    paramQQAppInterface = this.a;
    if ((paramQQAppInterface != null) && ((paramString != null) || (DownloaderFactory.a(paramQQAppInterface.getApp().getApplicationContext()))) && (paramChatBackgroundInfo != null))
    {
      paramQQAppInterface = paramChatBackgroundInfo.id;
      localObject = new Bundle();
      if (!TextUtils.isEmpty(paramString)) {
        ((Bundle)localObject).putString("callbackId", paramString);
      }
    }
    try
    {
      ((Bundle)localObject).putInt("id", Integer.valueOf(paramQQAppInterface).intValue());
    }
    catch (NumberFormatException paramString)
    {
      label81:
      break label81;
    }
    paramString = new StringBuilder();
    paramString.append("startDownload parse id faild, id = ");
    paramString.append(paramQQAppInterface);
    QLog.e("ChatBackgroundManager", 2, paramString.toString());
    if (a(this.a.getApplication().getApplicationContext(), paramChatBackgroundInfo.id) == null) {
      a(this.a.getApplication().getApplicationContext(), paramChatBackgroundInfo);
    }
    ((Bundle)localObject).putSerializable("chatbgInfo", paramChatBackgroundInfo);
    if (!this.h)
    {
      this.h = VipFunCallUtil.a(this.a.getApplication(), "ChatBackgroundManager", false);
      if ((QLog.isColorLevel()) || (!this.h))
      {
        paramString = new StringBuilder();
        paramString.append("startDownload mhaveSDCard:");
        paramString.append(this.h);
        QLog.d("ChatBackgroundManager", 2, paramString.toString());
      }
    }
    paramString = new VasDownloadInfo();
    paramString.a = paramQQAppInterface;
    paramString.g = System.currentTimeMillis();
    paramString.i = ((Bundle)localObject);
    this.l.put(paramChatBackgroundInfo.id, paramString);
    paramString = (IVasQuickUpdateService)this.a.getRuntimeService(IVasQuickUpdateService.class, "");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("chatbg.");
    ((StringBuilder)localObject).append(paramChatBackgroundInfo.id);
    paramString.downloadItem(8L, ((StringBuilder)localObject).toString(), "ChatBackgroundRes");
    paramChatBackgroundInfo = new StringBuilder();
    paramChatBackgroundInfo.append("startDownload  id=");
    paramChatBackgroundInfo.append(paramQQAppInterface);
    QLog.d("ChatBackgroundManager", 1, paramChatBackgroundInfo.toString());
    return;
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("startDownload error mApp=");
    paramQQAppInterface.append(this.a);
    QLog.d("ChatBackgroundManager", 2, paramQQAppInterface.toString());
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    j = 0;
    k.removeMessages(1);
    i = null;
    paramQQAppInterface.execute(new ChatBackgroundManager.2(this, paramString, paramQQAppInterface));
  }
  
  public void a(String paramString, IPCDownloadListener paramIPCDownloadListener)
  {
    this.c.put(paramString, paramIPCDownloadListener);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ChatBackgroundUtil.a(this.a.getApp().getApplicationContext(), paramString1, paramString2, paramString3, paramInt);
    ReportController.b(null, "CliOper", "", "", "chatbackground", "BjIDShezhi", 0, 0, "0", "0", "", ChatBackgroundUtil.b(paramString3));
  }
  
  public boolean a(int paramInt1, int paramInt2, double paramDouble)
  {
    int n = Color.red(paramInt1);
    int i1 = Color.green(paramInt1);
    int i2 = Color.blue(paramInt1);
    int i3 = Color.red(paramInt2);
    int i4 = Color.green(paramInt2);
    int i5 = Color.blue(paramInt2);
    double d1 = Math.abs(n * n - i3 * i3);
    Double.isNaN(d1);
    double d2 = Math.abs(i1 * i1 - i4 * i4);
    Double.isNaN(d2);
    double d3 = Math.abs(i2 * i2 - i5 * i5);
    Double.isNaN(d3);
    d1 = d1 * 0.299D + d2 * 0.587D + d3 * 0.114D;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("color1=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", color2=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", similarity=");
      localStringBuilder.append(d1);
      QLog.d("ChatBackgroundManager", 4, localStringBuilder.toString());
    }
    return d1 < paramDouble;
  }
  
  public boolean a(Context paramContext, ChatBackgroundInfo paramChatBackgroundInfo)
  {
    paramContext = paramContext.getSharedPreferences("userChatbgInfo", 4);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramContext = paramContext.getString("userChatbgKey", "");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" setchatbgInfo chatbgInfo=");
      ((StringBuilder)localObject).append(paramChatBackgroundInfo.toString());
      QLog.d("ChatBackgroundManager", 2, ((StringBuilder)localObject).toString());
    }
    String str = paramChatBackgroundInfo.id;
    if (str != null)
    {
      if (paramContext != null) {}
      try
      {
        if (paramContext.length() > 0) {
          paramContext = new JSONObject(paramContext);
        } else {
          paramContext = new JSONObject();
        }
        if (paramContext.has(str)) {
          localObject = paramContext.getJSONObject(str);
        } else {
          localObject = new JSONObject();
        }
        ((JSONObject)localObject).put("name", paramChatBackgroundInfo.name);
        ((JSONObject)localObject).put("url", paramChatBackgroundInfo.url);
        ((JSONObject)localObject).put("thumbUrl", paramChatBackgroundInfo.thumbUrl);
        paramContext.put(str, localObject);
        boolean bool = localEditor.putString("userChatbgKey", paramContext.toString()).commit();
        if ((!bool) && (QLog.isColorLevel()))
        {
          paramContext = new StringBuilder();
          paramContext.append("setThemeInfo sp comit rt=");
          paramContext.append(bool);
          QLog.d("ChatBackgroundManager", 2, paramContext.toString());
        }
        return bool;
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel())
        {
          paramChatBackgroundInfo = new StringBuilder();
          paramChatBackgroundInfo.append("ThemeUtil setThemeInfo error:");
          paramChatBackgroundInfo.append(paramContext.getMessage());
          QLog.d("ChatBackgroundManager", 2, paramChatBackgroundInfo.toString());
        }
        paramContext.printStackTrace();
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundManager", 2, "ThemeUtil setThemeInfo error themeId is null");
    }
    return false;
  }
  
  public String b(Context paramContext, String paramString)
  {
    ChatBackgroundInfo localChatBackgroundInfo = a(paramContext, paramString);
    paramContext = "none";
    if (localChatBackgroundInfo != null)
    {
      paramString = localChatBackgroundInfo.thumbUrl;
      paramContext = paramString;
      if (paramString != null)
      {
        paramContext = paramString;
        if (!"none".equals(paramString))
        {
          paramContext = new StringBuilder();
          paramContext.append(paramString);
          paramContext.append("&isOldVersion=");
          paramContext.append(f);
          return paramContext.toString();
        }
      }
    }
    do
    {
      return paramContext;
      if (!new File(d).exists()) {
        break;
      }
      paramString = b(paramString);
      paramContext = paramString;
    } while ("none".equals(paramString));
    paramContext = new StringBuilder();
    paramContext.append(paramString);
    paramContext.append("?isOldVersion=");
    paramContext.append(e);
    paramContext = paramContext.toString();
    return paramContext;
  }
  
  public String b(String paramString)
  {
    try
    {
      Object localObject = FileUtils.readFileContent(new File(d));
      JSONArray localJSONArray = new JSONObject((String)((String)localObject).subSequence(((String)localObject).indexOf("{"), ((String)localObject).length() - 1)).getJSONObject("data").getJSONArray("chatBackground");
      int i1 = localJSONArray.length();
      int n = 0;
      while (n < i1)
      {
        localObject = localJSONArray.getJSONObject(n);
        if (((JSONObject)localObject).getString("id").equals(paramString))
        {
          paramString = new StringBuilder();
          paramString.append("https://i.gtimg.cn/qqshow/admindata/comdata/backgroundMall_chat_1/");
          paramString.append(((JSONObject)localObject).getString("thumbnail"));
          paramString = paramString.toString();
          return paramString;
        }
        n += 1;
      }
      return "none";
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String c(String paramString)
  {
    return ChatBackgroundUtil.a(this.a.getApp(), this.b, paramString);
  }
  
  public void c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 4);
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      paramString = e(paramString);
      int n = paramContext.getInt(paramString, 0);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("oldCount is:");
        localStringBuilder.append(n);
        QLog.d("ChatBackgroundManager", 2, localStringBuilder.toString());
      }
      paramContext = paramContext.edit();
      n += 1;
      paramContext.putInt(paramString, n);
      paramContext.commit();
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("save count is:");
        paramContext.append(n);
        QLog.d("ChatBackgroundManager", 2, paramContext.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ChatBackgroundManager", 2, "uin is empty,not save switch bg times");
    }
  }
  
  public int d(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQ", 4).getInt(e(paramString), 0);
  }
  
  public String d(String paramString)
  {
    return a(this.b, paramString);
  }
  
  public HashMap<String, Integer> d()
  {
    Object localObject1 = ChatBackgroundUtil.a(this.a.getApplication().getApplicationContext(), this.a.getCurrentAccountUin(), 4);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = ((SharedPreferences)localObject1).getAll().keySet().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (Pattern.compile("[0-9]*").matcher(str).matches())
      {
        localObject2 = ChatBackgroundUtil.b(((SharedPreferences)localObject1).getString(str, "null"));
        if ((localObject2 != null) && (!((String)localObject2).equals("null")) && (!((String)localObject2).equals("custom"))) {
          try
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append("_uinType");
            int n = ((SharedPreferences)localObject1).getInt(localStringBuilder.toString(), -1);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append("_");
            localStringBuilder.append(n);
            localHashMap.put(localStringBuilder.toString(), Integer.valueOf((String)localObject2));
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            localNumberFormatException2.printStackTrace();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getAllBgId id not number bgId:");
            localStringBuilder.append((String)localObject2);
            QLog.e("ChatBackgroundManager", 2, localStringBuilder.toString(), localNumberFormatException2);
          }
        }
      }
    }
    localObject1 = ChatBackgroundUtil.b(((SharedPreferences)localObject1).getString("chat_uniform_bg", "null"));
    if ((localObject1 != null) && (!((String)localObject1).equals("null")) && (!((String)localObject1).equals("custom"))) {
      try
      {
        localHashMap.put("null", Integer.valueOf((String)localObject1));
        return localHashMap;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        localNumberFormatException1.printStackTrace();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAllBgId id not number bgId:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.e("ChatBackgroundManager", 2, ((StringBuilder)localObject2).toString(), localNumberFormatException1);
      }
    }
    return localHashMap;
  }
  
  public String e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chat_background_switch_times_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void e()
  {
    Object localObject1 = ChatBackgroundUtil.a(this.a.getApplication().getApplicationContext(), this.a.getCurrentAccountUin(), 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    new HashMap();
    Iterator localIterator = ((SharedPreferences)localObject1).getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (Pattern.compile("[0-9]*").matcher(str).matches())
      {
        Object localObject2 = ChatBackgroundUtil.b(((SharedPreferences)localObject1).getString(str, "null"));
        if ((localObject2 != null) && (!((String)localObject2).equals("null")) && (!((String)localObject2).equals("custom")))
        {
          localEditor.remove(str);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("_uinType");
          localEditor.remove(((StringBuilder)localObject2).toString());
        }
      }
    }
    localObject1 = ChatBackgroundUtil.b(((SharedPreferences)localObject1).getString("chat_uniform_bg", "null"));
    if ((localObject1 != null) && (!((String)localObject1).equals("null")) && (!((String)localObject1).equals("custom"))) {
      localEditor.remove("chat_uniform_bg");
    }
    localEditor.commit();
  }
  
  public void e(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 4);
    paramString = e(paramString);
    paramContext = paramContext.edit();
    paramContext.putInt(paramString, 0);
    paramContext.commit();
  }
  
  public HashMap<String, Integer> f()
  {
    Object localObject1 = this.a.getApplication().getApplicationContext();
    Object localObject2 = this.a.getCurrentAccountUin();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("chat_background_path_");
    ((StringBuilder)localObject3).append((String)localObject2);
    localObject1 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 4);
    localObject2 = new HashMap();
    localObject3 = ((SharedPreferences)localObject1).edit();
    Iterator localIterator = ((SharedPreferences)localObject1).getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((Pattern.compile("[0-9]*").matcher(str).matches()) && (a((SharedPreferences)localObject1, str) > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_uinType");
        ((SharedPreferences.Editor)localObject3).remove(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_chat_bg_effect");
        ((SharedPreferences.Editor)localObject3).remove(localStringBuilder.toString());
      }
    }
    if (a((SharedPreferences)localObject1, "") > 0) {
      ((SharedPreferences.Editor)localObject3).remove("null");
    }
    return localObject2;
  }
  
  public boolean f(String paramString)
  {
    paramString = new File(ChatBackgroundUtil.a(paramString));
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return new File(paramString.getAbsoluteFile(), "aioImage").exists();
  }
  
  public String g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ChatBackgroundUtil.a(paramString));
    localStringBuilder.append(File.separatorChar);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  public HashMap<String, Integer> g()
  {
    Object localObject1 = this.a.getApplication().getApplicationContext();
    Object localObject2 = this.a.getCurrentAccountUin();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("chat_background_path_");
    ((StringBuilder)localObject3).append((String)localObject2);
    localObject1 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 4);
    localObject2 = new HashMap();
    localObject3 = ((SharedPreferences)localObject1).getAll().keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      if (Pattern.compile("[0-9]*").matcher(str).matches())
      {
        n = a((SharedPreferences)localObject1, str);
        if (n > 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_uinType");
          int i1 = ((SharedPreferences)localObject1).getInt(localStringBuilder.toString(), -1);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("_");
          localStringBuilder.append(i1);
          ((HashMap)localObject2).put(localStringBuilder.toString(), Integer.valueOf(n));
        }
      }
    }
    int n = a((SharedPreferences)localObject1, "");
    if (n > 0) {
      ((HashMap)localObject2).put("null", Integer.valueOf(n));
    }
    return localObject2;
  }
  
  public Bundle h(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public HashMap<String, String> h()
  {
    SharedPreferences localSharedPreferences = ChatBackgroundUtil.a(this.a.getApplication().getApplicationContext(), this.a.getCurrentAccountUin(), 4);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localSharedPreferences.getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (Pattern.compile("[0-9]*").matcher(str).matches()) {
        localHashMap.put(str, ChatBackgroundUtil.b(localSharedPreferences.getString(str, "null")));
      }
    }
    localHashMap.put("chat_uniform_bg", ChatBackgroundUtil.b(localSharedPreferences.getString("chat_uniform_bg", "null")));
    return localHashMap;
  }
  
  public HashMap<String, Integer> i()
  {
    Object localObject1 = this.a.getApplication().getApplicationContext();
    Object localObject2 = this.a.getCurrentAccountUin();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("chat_background_path_");
    ((StringBuilder)localObject3).append((String)localObject2);
    localObject2 = ((Context)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 4);
    localObject1 = new HashMap();
    localObject2 = ((SharedPreferences)localObject2).getAll().keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (Pattern.compile("[0-9]*").matcher((CharSequence)localObject3).matches()) {
        ((HashMap)localObject1).put(localObject3, Integer.valueOf(b(this.a.getApp(), this.b, (String)localObject3)));
      }
    }
    ((HashMap)localObject1).put("_chat_bg_effect", Integer.valueOf(b(this.a.getApp(), this.b, "")));
    return localObject1;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager
 * JD-Core Version:    0.7.0.1
 */