package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.Secure;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceApiPlugin
  extends WebViewPlugin
{
  public static PowerManager.WakeLock a;
  public static boolean b = false;
  private int[] c;
  private String d = "";
  
  public DeviceApiPlugin()
  {
    this.mPluginNameSpace = "device";
  }
  
  public static void a(boolean paramBoolean1, Context paramContext, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (a == null) {
        a = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(10, "VasWakeLock");
      }
      a.acquire();
      b = true;
      return;
    }
    paramContext = a;
    if ((paramContext != null) && (paramContext.isHeld())) {
      a.release();
    }
    if (!paramBoolean2) {
      b = false;
    }
  }
  
  private int h()
  {
    return DeviceInfoUtil.h();
  }
  
  public final String a()
  {
    Object localObject1 = "";
    Object localObject2;
    try
    {
      String str = BaseApplicationImpl.getApplication().getResources().getConfiguration().toString();
      localObject1 = str;
      localObject2 = str;
      if (QLog.isColorLevel())
      {
        localObject1 = str;
        QLog.d("DeviceApiPlugin", 2, new Object[] { "getConfiguration:", str });
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DeviceApiPlugin", 1, "getConfiguration ", localThrowable);
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  public String b()
  {
    return String.valueOf(DeviceInfoUtil.l());
  }
  
  public String c()
  {
    String str2;
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      StringBuilder localStringBuilder;
      for (String str1 = ""; localInputStream.read(arrayOfByte) != -1; str1 = localStringBuilder.toString())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(new String(arrayOfByte));
      }
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      str2 = "N/A";
    }
    return str2.trim();
  }
  
  /* Error */
  public String d()
  {
    // Byte code:
    //   0: new 174	java/io/FileReader
    //   3: dup
    //   4: ldc 176
    //   6: invokespecial 179	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: new 181	java/io/BufferedReader
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 184	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   18: astore 4
    //   20: aload_1
    //   21: astore_2
    //   22: aload 4
    //   24: astore_3
    //   25: aload 4
    //   27: invokevirtual 187	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore 5
    //   32: aload_1
    //   33: astore_2
    //   34: aload 4
    //   36: astore_3
    //   37: aload_1
    //   38: invokevirtual 188	java/io/FileReader:close	()V
    //   41: aload_1
    //   42: astore_2
    //   43: aload 4
    //   45: astore_3
    //   46: aload 4
    //   48: invokevirtual 189	java/io/BufferedReader:close	()V
    //   51: aload_1
    //   52: astore_2
    //   53: aload 4
    //   55: astore_3
    //   56: aload 5
    //   58: invokevirtual 170	java/lang/String:trim	()Ljava/lang/String;
    //   61: astore 5
    //   63: aload_1
    //   64: invokevirtual 188	java/io/FileReader:close	()V
    //   67: goto +8 -> 75
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   75: aload 4
    //   77: invokevirtual 189	java/io/BufferedReader:close	()V
    //   80: aload 5
    //   82: areturn
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   88: aload 5
    //   90: areturn
    //   91: astore 5
    //   93: aload_1
    //   94: astore 6
    //   96: aload 4
    //   98: astore_1
    //   99: goto +59 -> 158
    //   102: astore 5
    //   104: aload_1
    //   105: astore 6
    //   107: aload 4
    //   109: astore_1
    //   110: goto +94 -> 204
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_3
    //   116: goto +142 -> 258
    //   119: astore 5
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_1
    //   124: astore 6
    //   126: aload_2
    //   127: astore_1
    //   128: goto +30 -> 158
    //   131: astore 5
    //   133: aconst_null
    //   134: astore_2
    //   135: aload_1
    //   136: astore 6
    //   138: aload_2
    //   139: astore_1
    //   140: goto +64 -> 204
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_3
    //   146: aload_3
    //   147: astore_1
    //   148: goto +110 -> 258
    //   151: astore 5
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: astore 6
    //   158: aload 6
    //   160: astore_2
    //   161: aload_1
    //   162: astore_3
    //   163: aload 5
    //   165: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   168: aload 6
    //   170: ifnull +16 -> 186
    //   173: aload 6
    //   175: invokevirtual 188	java/io/FileReader:close	()V
    //   178: goto +8 -> 186
    //   181: astore_2
    //   182: aload_2
    //   183: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   186: aload_1
    //   187: ifnull +61 -> 248
    //   190: aload_1
    //   191: invokevirtual 189	java/io/BufferedReader:close	()V
    //   194: goto +54 -> 248
    //   197: astore 5
    //   199: aconst_null
    //   200: astore_1
    //   201: aload_1
    //   202: astore 6
    //   204: aload 6
    //   206: astore_2
    //   207: aload_1
    //   208: astore_3
    //   209: aload 5
    //   211: invokevirtual 190	java/io/FileNotFoundException:printStackTrace	()V
    //   214: aload 6
    //   216: ifnull +16 -> 232
    //   219: aload 6
    //   221: invokevirtual 188	java/io/FileReader:close	()V
    //   224: goto +8 -> 232
    //   227: astore_2
    //   228: aload_2
    //   229: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   232: aload_1
    //   233: ifnull +15 -> 248
    //   236: aload_1
    //   237: invokevirtual 189	java/io/BufferedReader:close	()V
    //   240: goto +8 -> 248
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   248: ldc 167
    //   250: areturn
    //   251: astore 4
    //   253: aload_2
    //   254: astore_1
    //   255: aload 4
    //   257: astore_2
    //   258: aload_1
    //   259: ifnull +15 -> 274
    //   262: aload_1
    //   263: invokevirtual 188	java/io/FileReader:close	()V
    //   266: goto +8 -> 274
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   274: aload_3
    //   275: ifnull +15 -> 290
    //   278: aload_3
    //   279: invokevirtual 189	java/io/BufferedReader:close	()V
    //   282: goto +8 -> 290
    //   285: astore_1
    //   286: aload_1
    //   287: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   290: aload_2
    //   291: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	DeviceApiPlugin
    //   9	55	1	localFileReader1	java.io.FileReader
    //   70	2	1	localIOException1	IOException
    //   83	11	1	localIOException2	IOException
    //   98	139	1	localObject1	Object
    //   243	2	1	localIOException3	IOException
    //   254	9	1	localObject2	Object
    //   269	2	1	localIOException4	IOException
    //   285	2	1	localIOException5	IOException
    //   21	32	2	localFileReader2	java.io.FileReader
    //   113	1	2	localObject3	Object
    //   122	17	2	localObject4	Object
    //   143	1	2	localObject5	Object
    //   160	1	2	localObject6	Object
    //   181	2	2	localIOException6	IOException
    //   206	1	2	localObject7	Object
    //   227	27	2	localIOException7	IOException
    //   257	34	2	localObject8	Object
    //   24	255	3	localObject9	Object
    //   18	90	4	localBufferedReader	java.io.BufferedReader
    //   251	5	4	localObject10	Object
    //   30	59	5	str	String
    //   91	1	5	localIOException8	IOException
    //   102	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   119	1	5	localIOException9	IOException
    //   131	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   151	13	5	localIOException10	IOException
    //   197	13	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   94	126	6	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   63	67	70	java/io/IOException
    //   75	80	83	java/io/IOException
    //   25	32	91	java/io/IOException
    //   37	41	91	java/io/IOException
    //   46	51	91	java/io/IOException
    //   56	63	91	java/io/IOException
    //   25	32	102	java/io/FileNotFoundException
    //   37	41	102	java/io/FileNotFoundException
    //   46	51	102	java/io/FileNotFoundException
    //   56	63	102	java/io/FileNotFoundException
    //   10	20	113	finally
    //   10	20	119	java/io/IOException
    //   10	20	131	java/io/FileNotFoundException
    //   0	10	143	finally
    //   0	10	151	java/io/IOException
    //   173	178	181	java/io/IOException
    //   0	10	197	java/io/FileNotFoundException
    //   219	224	227	java/io/IOException
    //   190	194	243	java/io/IOException
    //   236	240	243	java/io/IOException
    //   25	32	251	finally
    //   37	41	251	finally
    //   46	51	251	finally
    //   56	63	251	finally
    //   163	168	251	finally
    //   209	214	251	finally
    //   262	266	269	java/io/IOException
    //   278	282	285	java/io/IOException
  }
  
  /* Error */
  public String e()
  {
    // Byte code:
    //   0: new 174	java/io/FileReader
    //   3: dup
    //   4: ldc 192
    //   6: invokespecial 179	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: new 181	java/io/BufferedReader
    //   13: dup
    //   14: aload_2
    //   15: invokespecial 184	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   18: astore 5
    //   20: aload_2
    //   21: astore_3
    //   22: aload 5
    //   24: astore 4
    //   26: aload 5
    //   28: invokevirtual 187	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: ldc 194
    //   33: iconst_2
    //   34: invokevirtual 198	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   37: astore 6
    //   39: iconst_0
    //   40: istore_1
    //   41: aload_2
    //   42: astore_3
    //   43: aload 5
    //   45: astore 4
    //   47: iload_1
    //   48: aload 6
    //   50: arraylength
    //   51: if_icmpge +10 -> 61
    //   54: iload_1
    //   55: iconst_1
    //   56: iadd
    //   57: istore_1
    //   58: goto -17 -> 41
    //   61: aload 6
    //   63: iconst_1
    //   64: aaload
    //   65: astore_3
    //   66: aload_2
    //   67: invokevirtual 188	java/io/FileReader:close	()V
    //   70: goto +8 -> 78
    //   73: astore_2
    //   74: aload_2
    //   75: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   78: aload 5
    //   80: invokevirtual 189	java/io/BufferedReader:close	()V
    //   83: aload_3
    //   84: areturn
    //   85: astore_2
    //   86: aload_2
    //   87: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   90: aload_3
    //   91: areturn
    //   92: astore_3
    //   93: aload_2
    //   94: astore 6
    //   96: aload 5
    //   98: astore_2
    //   99: aload_3
    //   100: astore 5
    //   102: goto +65 -> 167
    //   105: astore_3
    //   106: aload_2
    //   107: astore 6
    //   109: aload 5
    //   111: astore_2
    //   112: aload_3
    //   113: astore 5
    //   115: goto +99 -> 214
    //   118: astore_3
    //   119: aconst_null
    //   120: astore 4
    //   122: goto +145 -> 267
    //   125: astore 5
    //   127: aconst_null
    //   128: astore_3
    //   129: aload_2
    //   130: astore 6
    //   132: aload_3
    //   133: astore_2
    //   134: goto +33 -> 167
    //   137: astore 5
    //   139: aconst_null
    //   140: astore_3
    //   141: aload_2
    //   142: astore 6
    //   144: aload_3
    //   145: astore_2
    //   146: goto +68 -> 214
    //   149: astore_3
    //   150: aconst_null
    //   151: astore 4
    //   153: aload 4
    //   155: astore_2
    //   156: goto +111 -> 267
    //   159: astore 5
    //   161: aconst_null
    //   162: astore 6
    //   164: aload 6
    //   166: astore_2
    //   167: aload 6
    //   169: astore_3
    //   170: aload_2
    //   171: astore 4
    //   173: aload 5
    //   175: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   178: aload 6
    //   180: ifnull +16 -> 196
    //   183: aload 6
    //   185: invokevirtual 188	java/io/FileReader:close	()V
    //   188: goto +8 -> 196
    //   191: astore_3
    //   192: aload_3
    //   193: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   196: aload_2
    //   197: ifnull +61 -> 258
    //   200: aload_2
    //   201: invokevirtual 189	java/io/BufferedReader:close	()V
    //   204: aconst_null
    //   205: areturn
    //   206: astore 5
    //   208: aconst_null
    //   209: astore 6
    //   211: aload 6
    //   213: astore_2
    //   214: aload 6
    //   216: astore_3
    //   217: aload_2
    //   218: astore 4
    //   220: aload 5
    //   222: invokevirtual 190	java/io/FileNotFoundException:printStackTrace	()V
    //   225: aload 6
    //   227: ifnull +16 -> 243
    //   230: aload 6
    //   232: invokevirtual 188	java/io/FileReader:close	()V
    //   235: goto +8 -> 243
    //   238: astore_3
    //   239: aload_3
    //   240: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   243: aload_2
    //   244: ifnull +14 -> 258
    //   247: aload_2
    //   248: invokevirtual 189	java/io/BufferedReader:close	()V
    //   251: aconst_null
    //   252: areturn
    //   253: astore_2
    //   254: aload_2
    //   255: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   258: aconst_null
    //   259: areturn
    //   260: astore 5
    //   262: aload_3
    //   263: astore_2
    //   264: aload 5
    //   266: astore_3
    //   267: aload_2
    //   268: ifnull +15 -> 283
    //   271: aload_2
    //   272: invokevirtual 188	java/io/FileReader:close	()V
    //   275: goto +8 -> 283
    //   278: astore_2
    //   279: aload_2
    //   280: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   283: aload 4
    //   285: ifnull +16 -> 301
    //   288: aload 4
    //   290: invokevirtual 189	java/io/BufferedReader:close	()V
    //   293: goto +8 -> 301
    //   296: astore_2
    //   297: aload_2
    //   298: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   301: goto +5 -> 306
    //   304: aload_3
    //   305: athrow
    //   306: goto -2 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	DeviceApiPlugin
    //   40	18	1	i	int
    //   9	58	2	localFileReader1	java.io.FileReader
    //   73	2	2	localIOException1	IOException
    //   85	9	2	localIOException2	IOException
    //   98	150	2	localObject1	Object
    //   253	2	2	localIOException3	IOException
    //   263	9	2	localObject2	Object
    //   278	2	2	localIOException4	IOException
    //   296	2	2	localIOException5	IOException
    //   21	70	3	localFileReader2	java.io.FileReader
    //   92	8	3	localIOException6	IOException
    //   105	8	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   118	1	3	localObject3	Object
    //   128	17	3	localObject4	Object
    //   149	1	3	localObject5	Object
    //   169	1	3	localObject6	Object
    //   191	2	3	localIOException7	IOException
    //   216	1	3	localObject7	Object
    //   238	25	3	localIOException8	IOException
    //   266	39	3	localObject8	Object
    //   24	265	4	localObject9	Object
    //   18	96	5	localObject10	Object
    //   125	1	5	localIOException9	IOException
    //   137	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   159	15	5	localIOException10	IOException
    //   206	15	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   260	5	5	localObject11	Object
    //   37	194	6	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   66	70	73	java/io/IOException
    //   78	83	85	java/io/IOException
    //   26	39	92	java/io/IOException
    //   47	54	92	java/io/IOException
    //   26	39	105	java/io/FileNotFoundException
    //   47	54	105	java/io/FileNotFoundException
    //   10	20	118	finally
    //   10	20	125	java/io/IOException
    //   10	20	137	java/io/FileNotFoundException
    //   0	10	149	finally
    //   0	10	159	java/io/IOException
    //   183	188	191	java/io/IOException
    //   0	10	206	java/io/FileNotFoundException
    //   230	235	238	java/io/IOException
    //   200	204	253	java/io/IOException
    //   247	251	253	java/io/IOException
    //   26	39	260	finally
    //   47	54	260	finally
    //   173	178	260	finally
    //   220	225	260	finally
    //   271	275	278	java/io/IOException
    //   288	293	296	java/io/IOException
  }
  
  public long f()
  {
    ActivityManager localActivityManager = (ActivityManager)this.mRuntime.d().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem / 1024L;
  }
  
  /* Error */
  public long g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_3
    //   11: new 181	java/io/BufferedReader
    //   14: dup
    //   15: new 174	java/io/FileReader
    //   18: dup
    //   19: ldc 231
    //   21: invokespecial 179	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   24: bipush 8
    //   26: invokespecial 234	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: invokevirtual 187	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore 6
    //   38: aload_3
    //   39: astore_1
    //   40: aload 6
    //   42: ifnull +6 -> 48
    //   45: aload 6
    //   47: astore_1
    //   48: aload_1
    //   49: astore_3
    //   50: aload_2
    //   51: invokevirtual 189	java/io/BufferedReader:close	()V
    //   54: goto +83 -> 137
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   62: aload_3
    //   63: astore_1
    //   64: goto +73 -> 137
    //   67: astore_3
    //   68: goto +17 -> 85
    //   71: astore_3
    //   72: goto +42 -> 114
    //   75: astore_1
    //   76: aload 6
    //   78: astore_2
    //   79: goto +95 -> 174
    //   82: astore_3
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: aload_3
    //   88: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   91: aload 4
    //   93: astore_1
    //   94: aload_2
    //   95: ifnull +42 -> 137
    //   98: aload 5
    //   100: astore_3
    //   101: aload_2
    //   102: invokevirtual 189	java/io/BufferedReader:close	()V
    //   105: aload 4
    //   107: astore_1
    //   108: goto +29 -> 137
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_2
    //   114: aload_2
    //   115: astore_1
    //   116: aload_3
    //   117: invokevirtual 190	java/io/FileNotFoundException:printStackTrace	()V
    //   120: aload 4
    //   122: astore_1
    //   123: aload_2
    //   124: ifnull +13 -> 137
    //   127: aload 5
    //   129: astore_3
    //   130: aload_2
    //   131: invokevirtual 189	java/io/BufferedReader:close	()V
    //   134: aload 4
    //   136: astore_1
    //   137: aload_1
    //   138: ifnull +29 -> 167
    //   141: aload_1
    //   142: aload_1
    //   143: bipush 58
    //   145: invokevirtual 238	java/lang/String:indexOf	(I)I
    //   148: iconst_1
    //   149: iadd
    //   150: aload_1
    //   151: bipush 107
    //   153: invokevirtual 238	java/lang/String:indexOf	(I)I
    //   156: invokevirtual 242	java/lang/String:substring	(II)Ljava/lang/String;
    //   159: invokevirtual 170	java/lang/String:trim	()Ljava/lang/String;
    //   162: invokestatic 248	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: i2l
    //   166: lreturn
    //   167: lconst_0
    //   168: lreturn
    //   169: astore_3
    //   170: aload_1
    //   171: astore_2
    //   172: aload_3
    //   173: astore_1
    //   174: aload_2
    //   175: ifnull +15 -> 190
    //   178: aload_2
    //   179: invokevirtual 189	java/io/BufferedReader:close	()V
    //   182: goto +8 -> 190
    //   185: astore_2
    //   186: aload_2
    //   187: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   190: aload_1
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	DeviceApiPlugin
    //   31	18	1	localObject1	Object
    //   57	2	1	localIOException1	IOException
    //   63	1	1	localObject2	Object
    //   75	1	1	localObject3	Object
    //   86	105	1	localObject4	Object
    //   29	150	2	localObject5	Object
    //   185	2	2	localIOException2	IOException
    //   10	53	3	localObject6	Object
    //   67	1	3	localIOException3	IOException
    //   71	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   82	6	3	localIOException4	IOException
    //   100	1	3	localObject7	Object
    //   111	6	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   129	1	3	localObject8	Object
    //   169	4	3	localObject9	Object
    //   4	131	4	localObject10	Object
    //   1	127	5	localObject11	Object
    //   7	70	6	str	String
    // Exception table:
    //   from	to	target	type
    //   50	54	57	java/io/IOException
    //   101	105	57	java/io/IOException
    //   130	134	57	java/io/IOException
    //   32	38	67	java/io/IOException
    //   32	38	71	java/io/FileNotFoundException
    //   11	30	75	finally
    //   11	30	82	java/io/IOException
    //   11	30	111	java/io/FileNotFoundException
    //   32	38	169	finally
    //   87	91	169	finally
    //   116	120	169	finally
    //   178	182	185	java/io/IOException
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(", pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(", methodName=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("DeviceApiPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("device".equals(paramString2)))
    {
      if (paramString3 == null) {
        return false;
      }
      paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramString2 == null) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("handleJsRequest JSON = ");
        paramJsBridgeListener.append(paramString2.toString());
        QLog.d("DeviceApiPlugin", 2, paramJsBridgeListener.toString());
      }
    }
    try
    {
      if (paramString2.has("callback"))
      {
        paramJsBridgeListener = paramString2.getString("callback");
        break label245;
      }
      i = paramString1.indexOf("#");
      if (i != -1)
      {
        i += 1;
        if (i > paramString1.length() - 1) {
          return false;
        }
        paramJsBridgeListener = paramString1.substring(i);
        break label245;
      }
      return false;
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        boolean bool;
        continue;
        int i = 0;
        if (i == 1)
        {
          bool = true;
        }
        else
        {
          bool = false;
          continue;
          paramString1 = "{'result':0,'message':'dim'}";
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("Failed to parse callbackid,json=");
      paramJsBridgeListener.append(paramString2);
      QLog.i("DeviceApiPlugin", 2, paramJsBridgeListener.toString());
    }
    paramJsBridgeListener = null;
    label245:
    if (paramJsBridgeListener == null) {
      return false;
    }
    if ("setScreenStatus".equals(paramString3))
    {
      try
      {
        if (!paramString2.has("status")) {
          break label1129;
        }
        i = paramString2.getInt("status");
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          break label370;
        }
        paramString2 = new StringBuilder();
        paramString2.append("Failed to setScreenStatus:");
        paramString2.append(paramString1.getMessage());
        QLog.i("DeviceApiPlugin", 2, paramString2.toString());
        label370:
        paramString2 = new StringBuilder();
        paramString2.append("{'result':-1,'message':");
        paramString2.append(paramString1.getMessage());
        paramString2.append("}");
        callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
        return true;
      }
      a(bool, this.mRuntime.d().getApplicationContext(), false);
      if (!b) {
        break label1150;
      }
      paramString1 = "{'result':1,'message':'light'}";
      callJs(paramJsBridgeListener, new String[] { paramString1 });
      return true;
    }
    else
    {
      if ("getWebpDecoderVersion".equals(paramString3))
      {
        paramString1 = new JSONObject();
        try
        {
          paramString1.put("result", -1);
          if (this.c != null)
          {
            paramString1.put("result", 0);
            paramString1.put("type", this.d);
            paramString1.put("version", String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.c[0]), Integer.valueOf(this.c[1]), Integer.valueOf(this.c[2]) }));
          }
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
      if ("canInstallThirdPartyApp".equals(paramString3))
      {
        paramString1 = this.mRuntime.d();
        if (paramString1 != null)
        {
          i = Settings.Secure.getInt(paramString1.getContentResolver(), "install_non_market_apps", 0);
          paramString1 = new StringBuilder();
          paramString1.append("{'result':");
          paramString1.append(i);
          paramString1.append("}");
          paramString1 = paramString1.toString();
        }
        else
        {
          paramString1 = "{'result':-1,'message':'Context is null!'}";
        }
        callJs(paramJsBridgeListener, new String[] { paramString1 });
        return true;
      }
      if ("getCPUInfo".equals(paramString3)) {
        try
        {
          paramString1 = new JSONObject();
          paramString1.put("maxFreq", b());
          paramString1.put("minFreq", c());
          paramString1.put("curFreq", d());
          paramString1.put("CPUName", e());
          paramString1 = paramString1.toString();
          paramString2 = new StringBuilder();
          paramString2.append("getCPUInfo : ");
          paramString2.append(paramString1);
          QLog.i("DeviceApiPlugin", 2, paramString2.toString());
          callJs(paramJsBridgeListener, new String[] { paramString1 });
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
      if ("getMemInfo".equals(paramString3)) {
        try
        {
          paramString1 = new JSONObject();
          paramString1.put("idleMem", f());
          paramString1.put("totalMem", g());
          paramString1 = paramString1.toString();
          paramString2 = new StringBuilder();
          paramString2.append("getMemInfo : ");
          paramString2.append(paramString1);
          QLog.i("DeviceApiPlugin", 2, paramString2.toString());
          callJs(paramJsBridgeListener, new String[] { paramString1 });
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
      if ("getCPUCoreNum".equals(paramString3)) {
        try
        {
          paramString1 = new JSONObject();
          paramString1.put("count", h());
          paramString1 = paramString1.toString();
          paramString2 = new StringBuilder();
          paramString2.append("getCPUCoreNum : ");
          paramString2.append(paramString1);
          QLog.i("DeviceApiPlugin", 2, paramString2.toString());
          callJs(paramJsBridgeListener, new String[] { paramString1 });
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
      if ("getConfiguration".equals(paramString3)) {
        try
        {
          paramString1 = new JSONObject();
          paramString1.put("config", a());
          paramString1 = paramString1.toString();
          paramString2 = new StringBuilder();
          paramString2.append("getConfiguration : ");
          paramString2.append(paramString1);
          QLog.i("DeviceApiPlugin", 1, paramString2.toString());
          callJs(paramJsBridgeListener, new String[] { paramString1 });
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          QLog.e("DeviceApiPlugin", 1, new Object[] { "getConfiguration ", paramJsBridgeListener.toString() });
          return true;
        }
      }
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("NOT support method ");
        paramJsBridgeListener.append(paramString3);
        paramJsBridgeListener.append(" yet!!");
        QLog.w("DeviceApiPlugin", 2, paramJsBridgeListener.toString());
      }
      return false;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    if (b) {
      a(false, null, false);
    }
    PowerManager.WakeLock localWakeLock = a;
    if ((localWakeLock != null) && (localWakeLock.isHeld())) {
      a.release();
    }
    a = null;
    super.onDestroy();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if ((paramCustomWebView != null) && (paramCustomWebView.getX5WebViewExtension() != null))
    {
      this.c = new int[] { 0, 3, 0, 0 };
      this.d = "QQBrowser";
      return;
    }
    this.c = WebpSoLoader.b();
    if (this.c != null)
    {
      if (WebpSoLoader.a != null)
      {
        this.d = "Hook";
        return;
      }
      this.d = "System";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DeviceApiPlugin
 * JD-Core Version:    0.7.0.1
 */