package org.light.report.avreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceInfo
{
  private static final String[] SU_FILES = { "/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb" };
  private static final String TAG = "MobileBase-DeviceInfo";
  private static final String[] VM_APPS = { "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter" };
  private static final String[] VM_FILES = { "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd" };
  private static String roDebuggable = null;
  private static String roSecure;
  private static Map<String, String> systemProperties = null;
  
  static
  {
    roSecure = null;
  }
  
  public static boolean checkIsHaveCard()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when checking external card.", localThrowable);
    }
    return false;
  }
  
  /* Error */
  public static List<String> executeCommand(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 225	org/light/report/avreport/AppInfo:isLowMemory	(Landroid/content/Context;)Z
    //   4: ifeq +16 -> 20
    //   7: new 227	java/util/ArrayList
    //   10: dup
    //   11: ldc 229
    //   13: invokestatic 235	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   16: invokespecial 238	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   19: areturn
    //   20: new 227	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 239	java/util/ArrayList:<init>	()V
    //   27: astore_3
    //   28: aconst_null
    //   29: astore_2
    //   30: ldc 241
    //   32: astore_0
    //   33: new 243	java/io/File
    //   36: dup
    //   37: ldc 241
    //   39: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 249	java/io/File:exists	()Z
    //   45: ifeq +355 -> 400
    //   48: new 243	java/io/File
    //   51: dup
    //   52: ldc 241
    //   54: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: invokevirtual 252	java/io/File:canExecute	()Z
    //   60: ifne +6 -> 66
    //   63: goto +337 -> 400
    //   66: new 227	java/util/ArrayList
    //   69: dup
    //   70: iconst_2
    //   71: anewarray 21	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: ldc 254
    //   82: aastore
    //   83: invokestatic 260	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   86: invokespecial 238	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   89: astore_0
    //   90: aload_0
    //   91: aload_1
    //   92: invokeinterface 265 2 0
    //   97: pop
    //   98: invokestatic 271	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   101: aload_0
    //   102: iconst_3
    //   103: anewarray 21	java/lang/String
    //   106: invokeinterface 275 2 0
    //   111: checkcast 276	[Ljava/lang/String;
    //   114: invokevirtual 280	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   117: astore_1
    //   118: new 282	java/io/BufferedReader
    //   121: dup
    //   122: new 284	java/io/InputStreamReader
    //   125: dup
    //   126: aload_1
    //   127: invokevirtual 290	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   130: invokespecial 293	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   133: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +12 -> 155
    //   146: aload_3
    //   147: aload_2
    //   148: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   151: pop
    //   152: goto -15 -> 137
    //   155: new 282	java/io/BufferedReader
    //   158: dup
    //   159: new 284	java/io/InputStreamReader
    //   162: dup
    //   163: aload_1
    //   164: invokevirtual 303	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   167: invokespecial 293	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   170: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   173: astore 4
    //   175: aload_0
    //   176: astore_1
    //   177: aload 4
    //   179: astore_2
    //   180: aload 4
    //   182: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   185: astore 5
    //   187: aload 5
    //   189: ifnull +18 -> 207
    //   192: aload_0
    //   193: astore_1
    //   194: aload 4
    //   196: astore_2
    //   197: aload_3
    //   198: aload 5
    //   200: invokevirtual 300	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   203: pop
    //   204: goto -29 -> 175
    //   207: aload_0
    //   208: invokevirtual 306	java/io/BufferedReader:close	()V
    //   211: goto +13 -> 224
    //   214: astore_0
    //   215: ldc 10
    //   217: ldc_w 308
    //   220: aload_0
    //   221: invokestatic 311	org/light/report/avreport/AVRLogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: aload 4
    //   226: invokevirtual 306	java/io/BufferedReader:close	()V
    //   229: aload_3
    //   230: areturn
    //   231: astore_0
    //   232: ldc 10
    //   234: ldc_w 308
    //   237: aload_0
    //   238: invokestatic 311	org/light/report/avreport/AVRLogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload_3
    //   242: areturn
    //   243: astore_1
    //   244: aload_0
    //   245: astore_3
    //   246: aload 4
    //   248: astore_0
    //   249: aload_1
    //   250: astore 4
    //   252: goto +40 -> 292
    //   255: astore_3
    //   256: aconst_null
    //   257: astore_2
    //   258: aload_0
    //   259: astore_1
    //   260: aload_3
    //   261: astore_0
    //   262: goto +88 -> 350
    //   265: astore 4
    //   267: aconst_null
    //   268: astore_1
    //   269: aload_0
    //   270: astore_3
    //   271: aload_1
    //   272: astore_0
    //   273: goto +19 -> 292
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_3
    //   279: aload_2
    //   280: astore_1
    //   281: aload_3
    //   282: astore_2
    //   283: goto +67 -> 350
    //   286: astore 4
    //   288: aconst_null
    //   289: astore_3
    //   290: aload_3
    //   291: astore_0
    //   292: aload_3
    //   293: astore_1
    //   294: aload_0
    //   295: astore_2
    //   296: ldc 10
    //   298: ldc_w 313
    //   301: aload 4
    //   303: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   306: aload_3
    //   307: ifnull +20 -> 327
    //   310: aload_3
    //   311: invokevirtual 306	java/io/BufferedReader:close	()V
    //   314: goto +13 -> 327
    //   317: astore_1
    //   318: ldc 10
    //   320: ldc_w 308
    //   323: aload_1
    //   324: invokestatic 311	org/light/report/avreport/AVRLogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   327: aload_0
    //   328: ifnull +19 -> 347
    //   331: aload_0
    //   332: invokevirtual 306	java/io/BufferedReader:close	()V
    //   335: aconst_null
    //   336: areturn
    //   337: astore_0
    //   338: ldc 10
    //   340: ldc_w 308
    //   343: aload_0
    //   344: invokestatic 311	org/light/report/avreport/AVRLogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   347: aconst_null
    //   348: areturn
    //   349: astore_0
    //   350: aload_1
    //   351: ifnull +20 -> 371
    //   354: aload_1
    //   355: invokevirtual 306	java/io/BufferedReader:close	()V
    //   358: goto +13 -> 371
    //   361: astore_1
    //   362: ldc 10
    //   364: ldc_w 308
    //   367: aload_1
    //   368: invokestatic 311	org/light/report/avreport/AVRLogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   371: aload_2
    //   372: ifnull +20 -> 392
    //   375: aload_2
    //   376: invokevirtual 306	java/io/BufferedReader:close	()V
    //   379: goto +13 -> 392
    //   382: astore_1
    //   383: ldc 10
    //   385: ldc_w 308
    //   388: aload_1
    //   389: invokestatic 311	org/light/report/avreport/AVRLogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   392: goto +5 -> 397
    //   395: aload_0
    //   396: athrow
    //   397: goto -2 -> 395
    //   400: ldc_w 315
    //   403: astore_0
    //   404: goto -338 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	paramContext	Context
    //   0	407	1	paramString	String
    //   29	347	2	localObject1	Object
    //   27	219	3	localObject2	Object
    //   255	6	3	localObject3	Object
    //   270	41	3	localContext	Context
    //   173	78	4	localObject4	Object
    //   265	1	4	localThrowable1	Throwable
    //   286	16	4	localThrowable2	Throwable
    //   185	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   207	211	214	java/io/IOException
    //   224	229	231	java/io/IOException
    //   180	187	243	java/lang/Throwable
    //   197	204	243	java/lang/Throwable
    //   137	142	255	finally
    //   146	152	255	finally
    //   155	175	255	finally
    //   137	142	265	java/lang/Throwable
    //   146	152	265	java/lang/Throwable
    //   155	175	265	java/lang/Throwable
    //   33	48	276	finally
    //   48	63	276	finally
    //   66	137	276	finally
    //   33	48	286	java/lang/Throwable
    //   48	63	286	java/lang/Throwable
    //   66	137	286	java/lang/Throwable
    //   310	314	317	java/io/IOException
    //   331	335	337	java/io/IOException
    //   180	187	349	finally
    //   197	204	349	finally
    //   296	306	349	finally
    //   354	358	361	java/io/IOException
    //   375	379	382	java/io/IOException
  }
  
  public static String formatIpAddress(int paramInt)
  {
    if (paramInt < 0) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  @SuppressLint({"HardwareIds"})
  public static String getAndroidId(Context paramContext)
  {
    Object localObject = "fail";
    if (paramContext == null) {
      return "fail";
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext == null) {
        return "null";
      }
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting Android ID.", paramContext);
    }
    return localObject;
  }
  
  public static int getApiLevelInt()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    catch (Throwable localThrowable)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting API level.", localThrowable);
    }
    return -1;
  }
  
  public static String getBrand()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting brand.", localThrowable);
    }
    return "fail";
  }
  
  public static String getCountry()
  {
    try
    {
      String str = Locale.getDefault().getCountry();
      return str;
    }
    catch (Throwable localThrowable)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting country name.", localThrowable);
    }
    return "fail";
  }
  
  public static String getCpuAbi(Context paramContext, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramBoolean) {}
    try
    {
      localObject1 = getSystemProperty(paramContext, "ro.product.cpu.abilist");
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals("fail")) {}
      }
      else
      {
        localObject2 = getSystemProperty(paramContext, "ro.product.cpu.abi");
      }
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        if (((String)localObject2).equals("fail"))
        {
          localObject1 = localObject3;
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("ABI list: ");
          paramContext.append((String)localObject2);
          AVRLogUtils.d("MobileBase-DeviceInfo", paramContext.toString());
          localObject1 = localObject2.split(",")[0];
        }
      }
      paramContext = (Context)localObject1;
      if (localObject1 == null) {
        paramContext = System.getProperty("os.arch");
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramContext);
      paramContext = ((StringBuilder)localObject1).toString();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label157:
      break label157;
    }
    AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting CPU ABI.", paramContext);
    return "fail";
  }
  
  public static String getCpuName(Context paramContext)
  {
    return getSystemProperty(paramContext, "ro.board.platform");
  }
  
  /* Error */
  public static String getDebugInfo(Context paramContext)
  {
    // Byte code:
    //   0: new 323	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: getstatic 185	org/light/report/avreport/DeviceInfo:roSecure	Ljava/lang/String;
    //   11: ifnonnull +13 -> 24
    //   14: aload_0
    //   15: ldc_w 438
    //   18: invokestatic 400	org/light/report/avreport/DeviceInfo:getSystemProperty	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   21: putstatic 185	org/light/report/avreport/DeviceInfo:roSecure	Ljava/lang/String;
    //   24: getstatic 185	org/light/report/avreport/DeviceInfo:roSecure	Ljava/lang/String;
    //   27: ifnull +35 -> 62
    //   30: aload_3
    //   31: ldc_w 438
    //   34: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: ldc_w 440
    //   42: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_3
    //   47: getstatic 185	org/light/report/avreport/DeviceInfo:roSecure	Ljava/lang/String;
    //   50: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: ldc_w 442
    //   58: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: getstatic 187	org/light/report/avreport/DeviceInfo:roDebuggable	Ljava/lang/String;
    //   65: ifnonnull +13 -> 78
    //   68: aload_0
    //   69: ldc_w 444
    //   72: invokestatic 400	org/light/report/avreport/DeviceInfo:getSystemProperty	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   75: putstatic 187	org/light/report/avreport/DeviceInfo:roDebuggable	Ljava/lang/String;
    //   78: getstatic 187	org/light/report/avreport/DeviceInfo:roDebuggable	Ljava/lang/String;
    //   81: ifnull +35 -> 116
    //   84: aload_3
    //   85: ldc_w 444
    //   88: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: ldc_w 440
    //   96: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_3
    //   101: getstatic 187	org/light/report/avreport/DeviceInfo:roDebuggable	Ljava/lang/String;
    //   104: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_3
    //   109: ldc_w 442
    //   112: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: new 282	java/io/BufferedReader
    //   119: dup
    //   120: new 446	java/io/FileReader
    //   123: dup
    //   124: ldc_w 448
    //   127: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   130: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   133: astore_1
    //   134: aload_1
    //   135: astore_0
    //   136: aload_1
    //   137: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +15 -> 157
    //   145: aload_1
    //   146: astore_0
    //   147: aload_2
    //   148: ldc_w 451
    //   151: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   154: ifeq -20 -> 134
    //   157: aload_2
    //   158: ifnull +43 -> 201
    //   161: aload_1
    //   162: astore_0
    //   163: aload_2
    //   164: bipush 10
    //   166: invokevirtual 458	java/lang/String:substring	(I)Ljava/lang/String;
    //   169: invokevirtual 461	java/lang/String:trim	()Ljava/lang/String;
    //   172: astore_2
    //   173: aload_1
    //   174: astore_0
    //   175: aload_3
    //   176: ldc_w 463
    //   179: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_1
    //   184: astore_0
    //   185: aload_3
    //   186: ldc_w 440
    //   189: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_1
    //   194: astore_0
    //   195: aload_3
    //   196: aload_2
    //   197: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_1
    //   202: astore_0
    //   203: aload_3
    //   204: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore_2
    //   208: aload_1
    //   209: invokevirtual 306	java/io/BufferedReader:close	()V
    //   212: aload_2
    //   213: areturn
    //   214: astore_0
    //   215: ldc 10
    //   217: ldc_w 465
    //   220: aload_0
    //   221: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: aload_2
    //   225: areturn
    //   226: astore_2
    //   227: goto +12 -> 239
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_0
    //   233: goto +44 -> 277
    //   236: astore_2
    //   237: aconst_null
    //   238: astore_1
    //   239: aload_1
    //   240: astore_0
    //   241: ldc 10
    //   243: ldc_w 467
    //   246: aload_2
    //   247: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   250: aload_1
    //   251: ifnull +20 -> 271
    //   254: aload_1
    //   255: invokevirtual 306	java/io/BufferedReader:close	()V
    //   258: goto +13 -> 271
    //   261: astore_0
    //   262: ldc 10
    //   264: ldc_w 465
    //   267: aload_0
    //   268: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: aload_3
    //   272: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: areturn
    //   276: astore_1
    //   277: aload_0
    //   278: ifnull +20 -> 298
    //   281: aload_0
    //   282: invokevirtual 306	java/io/BufferedReader:close	()V
    //   285: goto +13 -> 298
    //   288: astore_0
    //   289: ldc 10
    //   291: ldc_w 465
    //   294: aload_0
    //   295: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   298: goto +5 -> 303
    //   301: aload_1
    //   302: athrow
    //   303: goto -2 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramContext	Context
    //   133	76	1	localBufferedReader	java.io.BufferedReader
    //   230	1	1	localObject1	Object
    //   238	17	1	localObject2	Object
    //   276	26	1	localObject3	Object
    //   140	85	2	str	String
    //   226	1	2	localThrowable1	Throwable
    //   236	11	2	localThrowable2	Throwable
    //   7	265	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   208	212	214	java/io/IOException
    //   136	141	226	java/lang/Throwable
    //   147	157	226	java/lang/Throwable
    //   163	173	226	java/lang/Throwable
    //   175	183	226	java/lang/Throwable
    //   185	193	226	java/lang/Throwable
    //   195	201	226	java/lang/Throwable
    //   203	208	226	java/lang/Throwable
    //   116	134	230	finally
    //   116	134	236	java/lang/Throwable
    //   254	258	261	java/io/IOException
    //   136	141	276	finally
    //   147	157	276	finally
    //   163	173	276	finally
    //   175	183	276	finally
    //   185	193	276	finally
    //   195	201	276	finally
    //   203	208	276	finally
    //   241	250	276	finally
    //   281	285	288	java/io/IOException
  }
  
  /* Error */
  public static long getDeviceBootTime(Context paramContext)
  {
    // Byte code:
    //   0: fconst_0
    //   1: fstore_2
    //   2: fconst_0
    //   3: fstore_3
    //   4: fconst_0
    //   5: fstore_1
    //   6: new 282	java/io/BufferedReader
    //   9: dup
    //   10: new 446	java/io/FileReader
    //   13: dup
    //   14: ldc_w 471
    //   17: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   20: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore 5
    //   25: aload 5
    //   27: astore_0
    //   28: aload 5
    //   30: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 6
    //   35: aload 6
    //   37: ifnull +45 -> 82
    //   40: aload 5
    //   42: astore_0
    //   43: aload 6
    //   45: ldc_w 473
    //   48: invokevirtual 420	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   51: iconst_0
    //   52: aaload
    //   53: astore 6
    //   55: aload 5
    //   57: astore_0
    //   58: invokestatic 477	java/lang/System:currentTimeMillis	()J
    //   61: l2f
    //   62: ldc_w 478
    //   65: fdiv
    //   66: fstore_1
    //   67: aload 5
    //   69: astore_0
    //   70: aload 6
    //   72: invokestatic 484	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   75: fstore 4
    //   77: fload_1
    //   78: fload 4
    //   80: fsub
    //   81: fstore_1
    //   82: fload_1
    //   83: fstore_2
    //   84: aload 5
    //   86: invokevirtual 306	java/io/BufferedReader:close	()V
    //   89: goto +62 -> 151
    //   92: astore_0
    //   93: ldc 10
    //   95: ldc_w 465
    //   98: aload_0
    //   99: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: fload_2
    //   103: fstore_1
    //   104: goto +47 -> 151
    //   107: astore 6
    //   109: goto +15 -> 124
    //   112: astore_0
    //   113: aconst_null
    //   114: astore 5
    //   116: goto +46 -> 162
    //   119: astore 6
    //   121: aconst_null
    //   122: astore 5
    //   124: aload 5
    //   126: astore_0
    //   127: ldc 10
    //   129: ldc_w 486
    //   132: aload 6
    //   134: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: fload_3
    //   138: fstore_1
    //   139: aload 5
    //   141: ifnull +10 -> 151
    //   144: aload 5
    //   146: invokevirtual 306	java/io/BufferedReader:close	()V
    //   149: fload_3
    //   150: fstore_1
    //   151: fload_1
    //   152: f2l
    //   153: lreturn
    //   154: astore 6
    //   156: aload_0
    //   157: astore 5
    //   159: aload 6
    //   161: astore_0
    //   162: aload 5
    //   164: ifnull +23 -> 187
    //   167: aload 5
    //   169: invokevirtual 306	java/io/BufferedReader:close	()V
    //   172: goto +15 -> 187
    //   175: astore 5
    //   177: ldc 10
    //   179: ldc_w 465
    //   182: aload 5
    //   184: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   187: aload_0
    //   188: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramContext	Context
    //   5	147	1	f1	float
    //   1	102	2	f2	float
    //   3	147	3	f3	float
    //   75	4	4	f4	float
    //   23	145	5	localObject1	Object
    //   175	8	5	localIOException	java.io.IOException
    //   33	38	6	str	String
    //   107	1	6	localThrowable1	Throwable
    //   119	14	6	localThrowable2	Throwable
    //   154	6	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   84	89	92	java/io/IOException
    //   144	149	92	java/io/IOException
    //   28	35	107	java/lang/Throwable
    //   43	55	107	java/lang/Throwable
    //   58	67	107	java/lang/Throwable
    //   70	77	107	java/lang/Throwable
    //   6	25	112	finally
    //   6	25	119	java/lang/Throwable
    //   28	35	154	finally
    //   43	55	154	finally
    //   58	67	154	finally
    //   70	77	154	finally
    //   127	137	154	finally
    //   167	172	175	java/io/IOException
  }
  
  public static String getDeviceName()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting device name.", localThrowable);
    }
    return "fail";
  }
  
  /* Error */
  public static String getElectronicfo()
  {
    // Byte code:
    //   0: new 323	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore_2
    //   16: aload_3
    //   17: astore_1
    //   18: aload 5
    //   20: astore 4
    //   22: new 243	java/io/File
    //   25: dup
    //   26: ldc_w 495
    //   29: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokevirtual 249	java/io/File:exists	()Z
    //   35: istore_0
    //   36: iload_0
    //   37: ifeq +80 -> 117
    //   40: aload_3
    //   41: astore_1
    //   42: aload 5
    //   44: astore 4
    //   46: new 282	java/io/BufferedReader
    //   49: dup
    //   50: new 446	java/io/FileReader
    //   53: dup
    //   54: ldc_w 495
    //   57: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   60: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   63: astore_2
    //   64: aload_2
    //   65: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore_1
    //   69: aload_1
    //   70: ifnull +28 -> 98
    //   73: aload 6
    //   75: ldc_w 497
    //   78: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 6
    //   84: ldc_w 440
    //   87: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 6
    //   93: aload_1
    //   94: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_2
    //   99: invokevirtual 306	java/io/BufferedReader:close	()V
    //   102: goto +15 -> 117
    //   105: astore_3
    //   106: aload_2
    //   107: astore_1
    //   108: aload_3
    //   109: astore_2
    //   110: goto +292 -> 402
    //   113: astore_3
    //   114: goto +250 -> 364
    //   117: aload_2
    //   118: astore_1
    //   119: aload_2
    //   120: astore 4
    //   122: aload 6
    //   124: ldc_w 442
    //   127: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_2
    //   132: astore_3
    //   133: aload_2
    //   134: astore_1
    //   135: aload_2
    //   136: astore 4
    //   138: new 243	java/io/File
    //   141: dup
    //   142: ldc_w 499
    //   145: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: invokevirtual 249	java/io/File:exists	()Z
    //   151: ifeq +81 -> 232
    //   154: aload_2
    //   155: astore_1
    //   156: aload_2
    //   157: astore 4
    //   159: new 282	java/io/BufferedReader
    //   162: dup
    //   163: new 446	java/io/FileReader
    //   166: dup
    //   167: ldc_w 499
    //   170: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   173: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   181: astore_1
    //   182: aload_1
    //   183: ifnull +28 -> 211
    //   186: aload 6
    //   188: ldc_w 501
    //   191: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 6
    //   197: ldc_w 440
    //   200: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 6
    //   206: aload_1
    //   207: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_2
    //   212: invokevirtual 306	java/io/BufferedReader:close	()V
    //   215: aload_2
    //   216: astore_3
    //   217: goto +15 -> 232
    //   220: astore_3
    //   221: aload_2
    //   222: astore_1
    //   223: aload_3
    //   224: astore_2
    //   225: goto +177 -> 402
    //   228: astore_3
    //   229: goto +135 -> 364
    //   232: aload_3
    //   233: astore_1
    //   234: aload_3
    //   235: astore 4
    //   237: aload 6
    //   239: ldc_w 442
    //   242: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_3
    //   247: astore_1
    //   248: aload_3
    //   249: astore 4
    //   251: new 243	java/io/File
    //   254: dup
    //   255: ldc_w 503
    //   258: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   261: invokevirtual 249	java/io/File:exists	()Z
    //   264: ifeq +79 -> 343
    //   267: aload_3
    //   268: astore_1
    //   269: aload_3
    //   270: astore 4
    //   272: new 282	java/io/BufferedReader
    //   275: dup
    //   276: new 446	java/io/FileReader
    //   279: dup
    //   280: ldc_w 503
    //   283: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   286: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   289: astore_2
    //   290: aload_2
    //   291: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   294: astore_1
    //   295: aload_1
    //   296: ifnull +28 -> 324
    //   299: aload 6
    //   301: ldc_w 505
    //   304: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 6
    //   310: ldc_w 440
    //   313: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 6
    //   319: aload_1
    //   320: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload_2
    //   325: invokevirtual 306	java/io/BufferedReader:close	()V
    //   328: goto +17 -> 345
    //   331: astore_3
    //   332: aload_2
    //   333: astore_1
    //   334: aload_3
    //   335: astore_2
    //   336: goto +66 -> 402
    //   339: astore_3
    //   340: goto +24 -> 364
    //   343: aload_3
    //   344: astore_2
    //   345: aload_2
    //   346: ifnull +50 -> 396
    //   349: aload_2
    //   350: invokevirtual 306	java/io/BufferedReader:close	()V
    //   353: goto +43 -> 396
    //   356: astore_2
    //   357: goto +45 -> 402
    //   360: astore_3
    //   361: aload 4
    //   363: astore_2
    //   364: aload_2
    //   365: astore_1
    //   366: ldc 10
    //   368: ldc_w 467
    //   371: aload_3
    //   372: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   375: aload_2
    //   376: ifnull +20 -> 396
    //   379: aload_2
    //   380: invokevirtual 306	java/io/BufferedReader:close	()V
    //   383: goto +13 -> 396
    //   386: astore_1
    //   387: ldc 10
    //   389: ldc_w 465
    //   392: aload_1
    //   393: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   396: aload 6
    //   398: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: areturn
    //   402: aload_1
    //   403: ifnull +20 -> 423
    //   406: aload_1
    //   407: invokevirtual 306	java/io/BufferedReader:close	()V
    //   410: goto +13 -> 423
    //   413: astore_1
    //   414: ldc 10
    //   416: ldc_w 465
    //   419: aload_1
    //   420: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   423: aload_2
    //   424: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	2	0	bool	boolean
    //   17	349	1	localObject1	Object
    //   386	21	1	localIOException1	java.io.IOException
    //   413	7	1	localIOException2	java.io.IOException
    //   15	335	2	localObject2	Object
    //   356	1	2	localObject3	Object
    //   363	61	2	localObject4	Object
    //   10	31	3	localObject5	Object
    //   105	4	3	localObject6	Object
    //   113	1	3	localThrowable1	Throwable
    //   132	85	3	localObject7	Object
    //   220	4	3	localObject8	Object
    //   228	42	3	localThrowable2	Throwable
    //   331	4	3	localObject9	Object
    //   339	5	3	localThrowable3	Throwable
    //   360	12	3	localThrowable4	Throwable
    //   20	342	4	localObject10	Object
    //   12	31	5	localObject11	Object
    //   7	390	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   64	69	105	finally
    //   73	98	105	finally
    //   98	102	105	finally
    //   64	69	113	java/lang/Throwable
    //   73	98	113	java/lang/Throwable
    //   98	102	113	java/lang/Throwable
    //   177	182	220	finally
    //   186	211	220	finally
    //   211	215	220	finally
    //   177	182	228	java/lang/Throwable
    //   186	211	228	java/lang/Throwable
    //   211	215	228	java/lang/Throwable
    //   290	295	331	finally
    //   299	324	331	finally
    //   324	328	331	finally
    //   290	295	339	java/lang/Throwable
    //   299	324	339	java/lang/Throwable
    //   324	328	339	java/lang/Throwable
    //   22	36	356	finally
    //   46	64	356	finally
    //   122	131	356	finally
    //   138	154	356	finally
    //   159	177	356	finally
    //   237	246	356	finally
    //   251	267	356	finally
    //   272	290	356	finally
    //   366	375	356	finally
    //   22	36	360	java/lang/Throwable
    //   46	64	360	java/lang/Throwable
    //   122	131	360	java/lang/Throwable
    //   138	154	360	java/lang/Throwable
    //   159	177	360	java/lang/Throwable
    //   237	246	360	java/lang/Throwable
    //   251	267	360	java/lang/Throwable
    //   272	290	360	java/lang/Throwable
    //   349	353	386	java/io/IOException
    //   379	383	386	java/io/IOException
    //   406	410	413	java/io/IOException
  }
  
  @SuppressLint({"HardwareIds"})
  public static String getHardwareSerialNumber()
  {
    try
    {
      String str = Build.SERIAL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting hardware serial number.", localThrowable);
    }
    return "fail";
  }
  
  public static String getIpAddress(Context paramContext)
  {
    Object localObject1 = "fail";
    if (paramContext == null) {
      return "fail";
    }
    try
    {
      Object localObject2 = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      paramContext = (Context)localObject1;
      if (localObject2 != null)
      {
        localObject2 = NetworkMonitor.getConnectionInfo((WifiManager)localObject2);
        paramContext = (Context)localObject1;
        if (localObject2 != null)
        {
          int i = ((WifiInfo)localObject2).getIpAddress();
          paramContext = new StringBuilder();
          paramContext.append("IP integer address: ");
          paramContext.append(i);
          AVRLogUtils.d("MobileBase-DeviceInfo", paramContext.toString());
          paramContext = formatIpAddress(i);
        }
      }
    }
    catch (Throwable paramContext)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting IP address.", paramContext);
      paramContext = (Context)localObject1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("IP address: ");
    ((StringBuilder)localObject1).append(paramContext);
    AVRLogUtils.d("MobileBase-DeviceInfo", ((StringBuilder)localObject1).toString());
    return paramContext;
  }
  
  /* Error */
  public static String getMmccid()
  {
    // Byte code:
    //   0: new 323	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: new 243	java/io/File
    //   12: dup
    //   13: ldc_w 545
    //   16: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: invokevirtual 249	java/io/File:exists	()Z
    //   22: ifeq +361 -> 383
    //   25: new 282	java/io/BufferedReader
    //   28: dup
    //   29: new 446	java/io/FileReader
    //   32: dup
    //   33: ldc_w 545
    //   36: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   39: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_0
    //   43: aload_0
    //   44: astore_1
    //   45: aload_0
    //   46: astore_2
    //   47: aload_0
    //   48: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +14 -> 67
    //   56: aload_0
    //   57: astore_1
    //   58: aload_0
    //   59: astore_2
    //   60: aload 4
    //   62: aload_3
    //   63: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_0
    //   68: astore_1
    //   69: aload_0
    //   70: astore_2
    //   71: aload_0
    //   72: invokevirtual 306	java/io/BufferedReader:close	()V
    //   75: goto +3 -> 78
    //   78: aload_0
    //   79: astore_1
    //   80: aload_0
    //   81: astore_2
    //   82: aload 4
    //   84: ldc_w 416
    //   87: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_0
    //   92: astore_1
    //   93: aload_0
    //   94: astore_2
    //   95: new 243	java/io/File
    //   98: dup
    //   99: ldc_w 547
    //   102: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: invokevirtual 249	java/io/File:exists	()Z
    //   108: ifeq +280 -> 388
    //   111: aload_0
    //   112: astore_1
    //   113: aload_0
    //   114: astore_2
    //   115: new 282	java/io/BufferedReader
    //   118: dup
    //   119: new 446	java/io/FileReader
    //   122: dup
    //   123: ldc_w 547
    //   126: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   129: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   132: astore_0
    //   133: aload_0
    //   134: astore_3
    //   135: aload_0
    //   136: astore_1
    //   137: aload_0
    //   138: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +14 -> 157
    //   146: aload_0
    //   147: astore_3
    //   148: aload_0
    //   149: astore_1
    //   150: aload 4
    //   152: aload_2
    //   153: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_0
    //   158: astore_3
    //   159: aload_0
    //   160: astore_1
    //   161: aload_0
    //   162: invokevirtual 306	java/io/BufferedReader:close	()V
    //   165: goto +3 -> 168
    //   168: aload_0
    //   169: astore_3
    //   170: aload_0
    //   171: astore_1
    //   172: aload 4
    //   174: ldc_w 416
    //   177: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_0
    //   182: astore_3
    //   183: aload_0
    //   184: astore_1
    //   185: new 243	java/io/File
    //   188: dup
    //   189: ldc_w 549
    //   192: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   195: invokevirtual 249	java/io/File:exists	()Z
    //   198: ifeq +193 -> 391
    //   201: aload_0
    //   202: astore_3
    //   203: aload_0
    //   204: astore_1
    //   205: new 282	java/io/BufferedReader
    //   208: dup
    //   209: new 446	java/io/FileReader
    //   212: dup
    //   213: ldc_w 549
    //   216: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   219: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   222: astore_2
    //   223: aload_2
    //   224: astore_1
    //   225: aload_2
    //   226: astore_3
    //   227: aload_2
    //   228: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   231: astore 5
    //   233: aload_2
    //   234: astore_0
    //   235: aload 5
    //   237: ifnull +20 -> 257
    //   240: aload_2
    //   241: astore_1
    //   242: aload_2
    //   243: astore_3
    //   244: aload 4
    //   246: aload 5
    //   248: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_2
    //   253: astore_0
    //   254: goto +3 -> 257
    //   257: aload_0
    //   258: astore_1
    //   259: aload_0
    //   260: astore_3
    //   261: aload 4
    //   263: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: astore_2
    //   267: aload_0
    //   268: ifnull +19 -> 287
    //   271: aload_0
    //   272: invokevirtual 306	java/io/BufferedReader:close	()V
    //   275: aload_2
    //   276: areturn
    //   277: astore_0
    //   278: ldc 10
    //   280: ldc_w 465
    //   283: aload_0
    //   284: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   287: aload_2
    //   288: areturn
    //   289: astore_0
    //   290: goto +70 -> 360
    //   293: astore_2
    //   294: aload_3
    //   295: astore_0
    //   296: goto +30 -> 326
    //   299: astore_2
    //   300: aload_3
    //   301: astore_0
    //   302: goto +24 -> 326
    //   305: astore_0
    //   306: goto +54 -> 360
    //   309: astore_1
    //   310: aload_2
    //   311: astore_0
    //   312: aload_1
    //   313: astore_2
    //   314: goto +12 -> 326
    //   317: astore_0
    //   318: aconst_null
    //   319: astore_1
    //   320: goto +40 -> 360
    //   323: astore_2
    //   324: aconst_null
    //   325: astore_0
    //   326: aload_0
    //   327: astore_1
    //   328: ldc 10
    //   330: ldc_w 551
    //   333: aload_2
    //   334: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   337: aload_0
    //   338: ifnull +19 -> 357
    //   341: aload_0
    //   342: invokevirtual 306	java/io/BufferedReader:close	()V
    //   345: aconst_null
    //   346: areturn
    //   347: astore_0
    //   348: ldc 10
    //   350: ldc_w 465
    //   353: aload_0
    //   354: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   357: aconst_null
    //   358: areturn
    //   359: astore_0
    //   360: aload_1
    //   361: ifnull +20 -> 381
    //   364: aload_1
    //   365: invokevirtual 306	java/io/BufferedReader:close	()V
    //   368: goto +13 -> 381
    //   371: astore_1
    //   372: ldc 10
    //   374: ldc_w 465
    //   377: aload_1
    //   378: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   381: aload_0
    //   382: athrow
    //   383: aconst_null
    //   384: astore_0
    //   385: goto -307 -> 78
    //   388: goto -220 -> 168
    //   391: goto -134 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	230	0	localObject1	Object
    //   277	7	0	localIOException1	java.io.IOException
    //   289	1	0	localObject2	Object
    //   295	7	0	localObject3	Object
    //   305	1	0	localObject4	Object
    //   311	1	0	localObject5	Object
    //   317	1	0	localObject6	Object
    //   325	17	0	localObject7	Object
    //   347	7	0	localIOException2	java.io.IOException
    //   359	23	0	localObject8	Object
    //   384	1	0	localObject9	Object
    //   44	215	1	localObject10	Object
    //   309	4	1	localThrowable1	Throwable
    //   319	46	1	localObject11	Object
    //   371	7	1	localIOException3	java.io.IOException
    //   46	242	2	localObject12	Object
    //   293	1	2	localThrowable2	Throwable
    //   299	12	2	localThrowable3	Throwable
    //   313	1	2	localThrowable4	Throwable
    //   323	11	2	localThrowable5	Throwable
    //   51	250	3	localObject13	Object
    //   7	255	4	localStringBuilder	StringBuilder
    //   231	16	5	str	String
    // Exception table:
    //   from	to	target	type
    //   271	275	277	java/io/IOException
    //   227	233	289	finally
    //   244	252	289	finally
    //   261	267	289	finally
    //   227	233	293	java/lang/Throwable
    //   244	252	293	java/lang/Throwable
    //   261	267	293	java/lang/Throwable
    //   137	142	299	java/lang/Throwable
    //   150	157	299	java/lang/Throwable
    //   161	165	299	java/lang/Throwable
    //   172	181	299	java/lang/Throwable
    //   185	201	299	java/lang/Throwable
    //   205	223	299	java/lang/Throwable
    //   47	52	305	finally
    //   60	67	305	finally
    //   71	75	305	finally
    //   82	91	305	finally
    //   95	111	305	finally
    //   115	133	305	finally
    //   47	52	309	java/lang/Throwable
    //   60	67	309	java/lang/Throwable
    //   71	75	309	java/lang/Throwable
    //   82	91	309	java/lang/Throwable
    //   95	111	309	java/lang/Throwable
    //   115	133	309	java/lang/Throwable
    //   0	43	317	finally
    //   0	43	323	java/lang/Throwable
    //   341	345	347	java/io/IOException
    //   137	142	359	finally
    //   150	157	359	finally
    //   161	165	359	finally
    //   172	181	359	finally
    //   185	201	359	finally
    //   205	223	359	finally
    //   328	337	359	finally
    //   364	368	371	java/io/IOException
  }
  
  public static String getNetWorkType(Context paramContext)
  {
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return null;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return null;
      }
      if (((NetworkInfo)localObject).getType() == 1)
      {
        paramContext = "WIFI";
      }
      else if (((NetworkInfo)localObject).getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          int i = paramContext.getNetworkType();
          switch (i)
          {
          default: 
            paramContext = new StringBuilder();
            paramContext.append("MOBILE(");
            paramContext.append(i);
            paramContext.append(")");
            paramContext = paramContext.toString();
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting type of network.", paramContext);
    }
    return "unknown";
    for (;;)
    {
      return paramContext;
      break;
      paramContext = "HSPA+";
      continue;
      paramContext = "eHRPD";
      continue;
      paramContext = "LTE";
      continue;
      paramContext = "EVDO_B";
      continue;
      paramContext = "iDen";
      continue;
      paramContext = "HSPA";
      continue;
      paramContext = "HSUPA";
      continue;
      paramContext = "HSDPA";
      continue;
      paramContext = "1xRTT";
      continue;
      paramContext = "EVDO_A";
      continue;
      paramContext = "EVDO_0";
      continue;
      paramContext = "CDMA";
      continue;
      paramContext = "UMTS";
      continue;
      paramContext = "EDGE";
      continue;
      paramContext = "GPRS";
    }
  }
  
  public static byte getNetworkClass(Context paramContext)
  {
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return -1;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return -1;
      }
      if (((NetworkInfo)localObject).getType() == 1) {
        return 1;
      }
      if (((NetworkInfo)localObject).getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext == null) {
          return -1;
        }
        int i = paramContext.getNetworkType();
        switch (i)
        {
        default: 
          return -1;
        case 13: 
          return 4;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
          return 3;
        }
        return 2;
      }
    }
    catch (Throwable paramContext)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting class of network.", paramContext);
    }
    return -1;
  }
  
  /* Error */
  public static long getRamAvailSize()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 8
    //   6: new 446	java/io/FileReader
    //   9: dup
    //   10: ldc_w 619
    //   13: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   16: astore 6
    //   18: aload 6
    //   20: astore 7
    //   22: new 282	java/io/BufferedReader
    //   25: dup
    //   26: aload 6
    //   28: sipush 2048
    //   31: invokespecial 622	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   34: astore 9
    //   36: aload 9
    //   38: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: pop
    //   42: aload 9
    //   44: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore 7
    //   49: aload 7
    //   51: ifnonnull +48 -> 99
    //   54: aload 9
    //   56: invokevirtual 306	java/io/BufferedReader:close	()V
    //   59: goto +15 -> 74
    //   62: astore 7
    //   64: ldc 10
    //   66: ldc_w 624
    //   69: aload 7
    //   71: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: aload 6
    //   76: invokevirtual 625	java/io/FileReader:close	()V
    //   79: ldc2_w 626
    //   82: lreturn
    //   83: astore 6
    //   85: ldc 10
    //   87: ldc_w 465
    //   90: aload 6
    //   92: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: ldc2_w 626
    //   98: lreturn
    //   99: aload 7
    //   101: ldc_w 629
    //   104: iconst_2
    //   105: invokevirtual 632	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   108: iconst_1
    //   109: aaload
    //   110: invokevirtual 360	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   113: ldc_w 634
    //   116: ldc_w 430
    //   119: invokevirtual 638	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   122: invokevirtual 461	java/lang/String:trim	()Ljava/lang/String;
    //   125: invokestatic 644	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   128: lstore_0
    //   129: aload 9
    //   131: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   134: astore 7
    //   136: aload 7
    //   138: ifnonnull +48 -> 186
    //   141: aload 9
    //   143: invokevirtual 306	java/io/BufferedReader:close	()V
    //   146: goto +15 -> 161
    //   149: astore 7
    //   151: ldc 10
    //   153: ldc_w 624
    //   156: aload 7
    //   158: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: aload 6
    //   163: invokevirtual 625	java/io/FileReader:close	()V
    //   166: ldc2_w 626
    //   169: lreturn
    //   170: astore 6
    //   172: ldc 10
    //   174: ldc_w 465
    //   177: aload 6
    //   179: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   182: ldc2_w 626
    //   185: lreturn
    //   186: aload 7
    //   188: ldc_w 629
    //   191: iconst_2
    //   192: invokevirtual 632	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   195: iconst_1
    //   196: aaload
    //   197: invokevirtual 360	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   200: ldc_w 634
    //   203: ldc_w 430
    //   206: invokevirtual 638	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   209: invokevirtual 461	java/lang/String:trim	()Ljava/lang/String;
    //   212: invokestatic 644	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   215: lstore_2
    //   216: lload_2
    //   217: invokestatic 648	java/lang/Long:signum	(J)I
    //   220: pop
    //   221: aload 9
    //   223: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   226: astore 7
    //   228: aload 7
    //   230: ifnonnull +48 -> 278
    //   233: aload 9
    //   235: invokevirtual 306	java/io/BufferedReader:close	()V
    //   238: goto +15 -> 253
    //   241: astore 7
    //   243: ldc 10
    //   245: ldc_w 624
    //   248: aload 7
    //   250: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: aload 6
    //   255: invokevirtual 625	java/io/FileReader:close	()V
    //   258: ldc2_w 626
    //   261: lreturn
    //   262: astore 6
    //   264: ldc 10
    //   266: ldc_w 465
    //   269: aload 6
    //   271: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   274: ldc2_w 626
    //   277: lreturn
    //   278: aload 7
    //   280: ldc_w 629
    //   283: iconst_2
    //   284: invokevirtual 632	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   287: iconst_1
    //   288: aaload
    //   289: invokevirtual 360	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   292: ldc_w 634
    //   295: ldc_w 430
    //   298: invokevirtual 638	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   301: invokevirtual 461	java/lang/String:trim	()Ljava/lang/String;
    //   304: invokestatic 644	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   307: lstore 4
    //   309: lload_0
    //   310: ldc2_w 649
    //   313: lmul
    //   314: lconst_0
    //   315: ladd
    //   316: lload_2
    //   317: ldc2_w 649
    //   320: lmul
    //   321: ladd
    //   322: lload 4
    //   324: ldc2_w 649
    //   327: lmul
    //   328: ladd
    //   329: lstore_0
    //   330: aload 9
    //   332: invokevirtual 306	java/io/BufferedReader:close	()V
    //   335: goto +15 -> 350
    //   338: astore 7
    //   340: ldc 10
    //   342: ldc_w 624
    //   345: aload 7
    //   347: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   350: aload 6
    //   352: invokevirtual 625	java/io/FileReader:close	()V
    //   355: lload_0
    //   356: lreturn
    //   357: astore 6
    //   359: ldc 10
    //   361: ldc_w 465
    //   364: aload 6
    //   366: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   369: lload_0
    //   370: lreturn
    //   371: astore 8
    //   373: goto +127 -> 500
    //   376: astore 7
    //   378: aload 9
    //   380: astore 10
    //   382: aload 7
    //   384: astore 9
    //   386: goto +42 -> 428
    //   389: astore 6
    //   391: aload 8
    //   393: astore 9
    //   395: aload 6
    //   397: astore 8
    //   399: aload 7
    //   401: astore 6
    //   403: goto +97 -> 500
    //   406: astore 9
    //   408: goto +20 -> 428
    //   411: astore 8
    //   413: aconst_null
    //   414: astore 9
    //   416: aload 9
    //   418: astore 6
    //   420: goto +80 -> 500
    //   423: astore 9
    //   425: aconst_null
    //   426: astore 6
    //   428: aload 10
    //   430: astore 8
    //   432: aload 6
    //   434: astore 7
    //   436: ldc 10
    //   438: ldc_w 652
    //   441: aload 9
    //   443: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   446: aload 10
    //   448: ifnull +23 -> 471
    //   451: aload 10
    //   453: invokevirtual 306	java/io/BufferedReader:close	()V
    //   456: goto +15 -> 471
    //   459: astore 7
    //   461: ldc 10
    //   463: ldc_w 624
    //   466: aload 7
    //   468: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   471: aload 6
    //   473: ifnull +23 -> 496
    //   476: aload 6
    //   478: invokevirtual 625	java/io/FileReader:close	()V
    //   481: goto +15 -> 496
    //   484: astore 6
    //   486: ldc 10
    //   488: ldc_w 465
    //   491: aload 6
    //   493: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   496: ldc2_w 653
    //   499: lreturn
    //   500: aload 9
    //   502: ifnull +23 -> 525
    //   505: aload 9
    //   507: invokevirtual 306	java/io/BufferedReader:close	()V
    //   510: goto +15 -> 525
    //   513: astore 7
    //   515: ldc 10
    //   517: ldc_w 624
    //   520: aload 7
    //   522: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   525: aload 6
    //   527: ifnull +23 -> 550
    //   530: aload 6
    //   532: invokevirtual 625	java/io/FileReader:close	()V
    //   535: goto +15 -> 550
    //   538: astore 6
    //   540: ldc 10
    //   542: ldc_w 465
    //   545: aload 6
    //   547: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   550: aload 8
    //   552: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   128	242	0	l1	long
    //   215	102	2	l2	long
    //   307	16	4	l3	long
    //   16	59	6	localFileReader	java.io.FileReader
    //   83	79	6	localIOException1	java.io.IOException
    //   170	84	6	localIOException2	java.io.IOException
    //   262	89	6	localIOException3	java.io.IOException
    //   357	8	6	localIOException4	java.io.IOException
    //   389	7	6	localObject1	Object
    //   401	76	6	localObject2	Object
    //   484	47	6	localIOException5	java.io.IOException
    //   538	8	6	localIOException6	java.io.IOException
    //   20	30	7	localObject3	Object
    //   62	38	7	localIOException7	java.io.IOException
    //   134	3	7	str1	String
    //   149	38	7	localIOException8	java.io.IOException
    //   226	3	7	str2	String
    //   241	38	7	localIOException9	java.io.IOException
    //   338	8	7	localIOException10	java.io.IOException
    //   376	24	7	localThrowable1	Throwable
    //   434	1	7	localObject4	Object
    //   459	8	7	localIOException11	java.io.IOException
    //   513	8	7	localIOException12	java.io.IOException
    //   4	1	8	localObject5	Object
    //   371	21	8	localObject6	Object
    //   397	1	8	localObject7	Object
    //   411	1	8	localObject8	Object
    //   430	121	8	localObject9	Object
    //   34	360	9	localObject10	Object
    //   406	1	9	localThrowable2	Throwable
    //   414	3	9	localObject11	Object
    //   423	83	9	localThrowable3	Throwable
    //   1	451	10	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   54	59	62	java/io/IOException
    //   74	79	83	java/io/IOException
    //   141	146	149	java/io/IOException
    //   161	166	170	java/io/IOException
    //   233	238	241	java/io/IOException
    //   253	258	262	java/io/IOException
    //   330	335	338	java/io/IOException
    //   350	355	357	java/io/IOException
    //   36	49	371	finally
    //   99	136	371	finally
    //   186	216	371	finally
    //   221	228	371	finally
    //   278	309	371	finally
    //   36	49	376	java/lang/Throwable
    //   99	136	376	java/lang/Throwable
    //   186	216	376	java/lang/Throwable
    //   221	228	376	java/lang/Throwable
    //   278	309	376	java/lang/Throwable
    //   22	36	389	finally
    //   436	446	389	finally
    //   22	36	406	java/lang/Throwable
    //   6	18	411	finally
    //   6	18	423	java/lang/Throwable
    //   451	456	459	java/io/IOException
    //   476	481	484	java/io/IOException
    //   505	510	513	java/io/IOException
    //   530	535	538	java/io/IOException
  }
  
  /* Error */
  public static long getRamTotalSize()
  {
    // Byte code:
    //   0: new 446	java/io/FileReader
    //   3: dup
    //   4: ldc_w 619
    //   7: invokespecial 449	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: new 282	java/io/BufferedReader
    //   14: dup
    //   15: aload_3
    //   16: sipush 2048
    //   19: invokespecial 622	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   22: astore_2
    //   23: aload_2
    //   24: astore 4
    //   26: aload_3
    //   27: astore 5
    //   29: aload_2
    //   30: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 6
    //   35: aload 6
    //   37: ifnonnull +42 -> 79
    //   40: aload_2
    //   41: invokevirtual 306	java/io/BufferedReader:close	()V
    //   44: goto +13 -> 57
    //   47: astore_2
    //   48: ldc 10
    //   50: ldc_w 624
    //   53: aload_2
    //   54: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   57: aload_3
    //   58: invokevirtual 625	java/io/FileReader:close	()V
    //   61: ldc2_w 626
    //   64: lreturn
    //   65: astore_2
    //   66: ldc 10
    //   68: ldc_w 465
    //   71: aload_2
    //   72: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   75: ldc2_w 626
    //   78: lreturn
    //   79: aload_2
    //   80: astore 4
    //   82: aload_3
    //   83: astore 5
    //   85: aload 6
    //   87: ldc_w 629
    //   90: iconst_2
    //   91: invokevirtual 632	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   94: iconst_1
    //   95: aaload
    //   96: invokevirtual 360	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   99: ldc_w 634
    //   102: ldc_w 430
    //   105: invokevirtual 638	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   108: invokevirtual 461	java/lang/String:trim	()Ljava/lang/String;
    //   111: invokestatic 644	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   114: lstore_0
    //   115: lload_0
    //   116: ldc2_w 649
    //   119: lmul
    //   120: lstore_0
    //   121: aload_2
    //   122: invokevirtual 306	java/io/BufferedReader:close	()V
    //   125: goto +13 -> 138
    //   128: astore_2
    //   129: ldc 10
    //   131: ldc_w 624
    //   134: aload_2
    //   135: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   138: aload_3
    //   139: invokevirtual 625	java/io/FileReader:close	()V
    //   142: lload_0
    //   143: lreturn
    //   144: astore_2
    //   145: ldc 10
    //   147: ldc_w 465
    //   150: aload_2
    //   151: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   154: lload_0
    //   155: lreturn
    //   156: astore 6
    //   158: goto +32 -> 190
    //   161: astore_2
    //   162: aconst_null
    //   163: astore 4
    //   165: goto +91 -> 256
    //   168: astore 6
    //   170: aconst_null
    //   171: astore_2
    //   172: goto +18 -> 190
    //   175: astore_2
    //   176: aconst_null
    //   177: astore_3
    //   178: aload_3
    //   179: astore 4
    //   181: goto +75 -> 256
    //   184: astore 6
    //   186: aconst_null
    //   187: astore_3
    //   188: aload_3
    //   189: astore_2
    //   190: aload_2
    //   191: astore 4
    //   193: aload_3
    //   194: astore 5
    //   196: ldc 10
    //   198: ldc_w 657
    //   201: aload 6
    //   203: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   206: aload_2
    //   207: ifnull +20 -> 227
    //   210: aload_2
    //   211: invokevirtual 306	java/io/BufferedReader:close	()V
    //   214: goto +13 -> 227
    //   217: astore_2
    //   218: ldc 10
    //   220: ldc_w 624
    //   223: aload_2
    //   224: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   227: aload_3
    //   228: ifnull +20 -> 248
    //   231: aload_3
    //   232: invokevirtual 625	java/io/FileReader:close	()V
    //   235: goto +13 -> 248
    //   238: astore_2
    //   239: ldc 10
    //   241: ldc_w 465
    //   244: aload_2
    //   245: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   248: ldc2_w 653
    //   251: lreturn
    //   252: astore_2
    //   253: aload 5
    //   255: astore_3
    //   256: aload 4
    //   258: ifnull +23 -> 281
    //   261: aload 4
    //   263: invokevirtual 306	java/io/BufferedReader:close	()V
    //   266: goto +15 -> 281
    //   269: astore 4
    //   271: ldc 10
    //   273: ldc_w 624
    //   276: aload 4
    //   278: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   281: aload_3
    //   282: ifnull +20 -> 302
    //   285: aload_3
    //   286: invokevirtual 625	java/io/FileReader:close	()V
    //   289: goto +13 -> 302
    //   292: astore_3
    //   293: ldc 10
    //   295: ldc_w 465
    //   298: aload_3
    //   299: invokestatic 215	org/light/report/avreport/AVRLogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   302: aload_2
    //   303: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   114	41	0	l	long
    //   22	19	2	localBufferedReader	java.io.BufferedReader
    //   47	7	2	localIOException1	java.io.IOException
    //   65	57	2	localIOException2	java.io.IOException
    //   128	7	2	localIOException3	java.io.IOException
    //   144	7	2	localIOException4	java.io.IOException
    //   161	1	2	localObject1	Object
    //   171	1	2	localObject2	Object
    //   175	1	2	localObject3	Object
    //   189	22	2	localObject4	Object
    //   217	7	2	localIOException5	java.io.IOException
    //   238	7	2	localIOException6	java.io.IOException
    //   252	51	2	localObject5	Object
    //   10	276	3	localObject6	Object
    //   292	7	3	localIOException7	java.io.IOException
    //   24	238	4	localObject7	Object
    //   269	8	4	localIOException8	java.io.IOException
    //   27	227	5	localObject8	Object
    //   33	53	6	str	String
    //   156	1	6	localThrowable1	Throwable
    //   168	1	6	localThrowable2	Throwable
    //   184	18	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   40	44	47	java/io/IOException
    //   57	61	65	java/io/IOException
    //   121	125	128	java/io/IOException
    //   138	142	144	java/io/IOException
    //   29	35	156	java/lang/Throwable
    //   85	115	156	java/lang/Throwable
    //   11	23	161	finally
    //   11	23	168	java/lang/Throwable
    //   0	11	175	finally
    //   0	11	184	java/lang/Throwable
    //   210	214	217	java/io/IOException
    //   231	235	238	java/io/IOException
    //   29	35	252	finally
    //   85	115	252	finally
    //   196	206	252	finally
    //   261	266	269	java/io/IOException
    //   285	289	292	java/io/IOException
  }
  
  public static long getRomAvailSize()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting available size of ROM.", localThrowable);
    }
    return -1L;
  }
  
  public static String getRomFingerprint(Context paramContext)
  {
    Object localObject = getSystemProperty(paramContext, "ro.miui.ui.version.name");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder();
      paramContext.append("XiaoMi/MIUI/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = getSystemProperty(paramContext, "ro.build.version.emui");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder();
      paramContext.append("HuaWei/EMOTION/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = getSystemProperty(paramContext, "ro.lenovo.series");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = getSystemProperty(paramContext, "ro.build.version.incremental");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Lenovo/VIBE/");
      ((StringBuilder)localObject).append(paramContext);
      return ((StringBuilder)localObject).toString();
    }
    localObject = getSystemProperty(paramContext, "ro.build.nubia.rom.name");
    StringBuilder localStringBuilder;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("fail")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Zte/NUBIA/");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_");
      localStringBuilder.append(getSystemProperty(paramContext, "ro.build.nubia.rom.code"));
      return localStringBuilder.toString();
    }
    localObject = getSystemProperty(paramContext, "ro.meizu.product.model");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("fail")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Meizu/FLYME/");
      ((StringBuilder)localObject).append(getSystemProperty(paramContext, "ro.build.display.id"));
      return ((StringBuilder)localObject).toString();
    }
    localObject = getSystemProperty(paramContext, "ro.build.version.opporom");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder();
      paramContext.append("Oppo/COLOROS/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = getSystemProperty(paramContext, "ro.vivo.os.build.display.id");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("fail")))
    {
      paramContext = new StringBuilder();
      paramContext.append("vivo/FUNTOUCH/");
      paramContext.append((String)localObject);
      return paramContext.toString();
    }
    localObject = getSystemProperty(paramContext, "ro.aa.romver");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("fail")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("htc/");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/");
      localStringBuilder.append(getSystemProperty(paramContext, "ro.build.description"));
      return localStringBuilder.toString();
    }
    localObject = getSystemProperty(paramContext, "ro.lewa.version");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("fail")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tcl/");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/");
      localStringBuilder.append(getSystemProperty(paramContext, "ro.build.display.id"));
      return localStringBuilder.toString();
    }
    localObject = getSystemProperty(paramContext, "ro.gn.gnromvernumber");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("fail")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("amigo/");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/");
      localStringBuilder.append(getSystemProperty(paramContext, "ro.build.display.id"));
      return localStringBuilder.toString();
    }
    paramContext = getSystemProperty(paramContext, "ro.build.tyd.kbstyle_version");
    if ((!TextUtils.isEmpty(paramContext)) && (!paramContext.equals("fail")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dido/");
      ((StringBuilder)localObject).append(paramContext);
      return ((StringBuilder)localObject).toString();
    }
    return "Android";
  }
  
  public static long getRomTotalSize()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting total size of ROM.", localThrowable);
    }
    return -1L;
  }
  
  public static String getSimInfo(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = getSystemProperty(paramContext, "gsm.sim.state");
    if (str != null)
    {
      localStringBuilder.append("gsm.sim.state");
      localStringBuilder.append("|");
      localStringBuilder.append(str);
    }
    localStringBuilder.append("\n");
    paramContext = getSystemProperty(paramContext, "gsm.sim.state2");
    if (paramContext != null)
    {
      localStringBuilder.append("gsm.sim.state2");
      localStringBuilder.append("|");
      localStringBuilder.append(paramContext);
    }
    return localStringBuilder.toString();
  }
  
  public static String getSystemProperty(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.trim().equals("")) {
        return "";
      }
      if (systemProperties == null)
      {
        systemProperties = new HashMap();
        Object localObject = executeCommand(paramContext, "getprop");
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          AVRLogUtils.d("MobileBase-DeviceInfo", "Successfully get 'getprop' list.");
          paramContext = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Matcher localMatcher = paramContext.matcher((String)((Iterator)localObject).next());
            if (localMatcher.find()) {
              systemProperties.put(localMatcher.group(1), localMatcher.group(2));
            }
          }
          paramContext = new StringBuilder();
          paramContext.append("System properties number: ");
          paramContext.append(systemProperties.size());
          AVRLogUtils.d("MobileBase-DeviceInfo", paramContext.toString());
        }
      }
      if (systemProperties.containsKey(paramString)) {
        return (String)systemProperties.get(paramString);
      }
      return "fail";
    }
    return "";
  }
  
  public static String getVersion()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      AVRLogUtils.w("MobileBase-DeviceInfo", "Exception occurred when getting release version.", localThrowable);
    }
    return "fail";
  }
  
  public static boolean isDeviceRooted()
  {
    String[] arrayOfString = SU_FILES;
    int j = arrayOfString.length;
    boolean bool = false;
    int i = 0;
    while (i < j)
    {
      if (new File(arrayOfString[i]).exists())
      {
        i = 1;
        break label46;
      }
      i += 1;
    }
    i = 0;
    label46:
    if ((Build.TAGS != null) && (Build.TAGS.contains("test-keys"))) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j != 0) || (i != 0)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.report.avreport.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */