package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.CRC32;

public class t
{
  private static final String[] a = { "Y29tLnRlbmNlbnQubW0=", "Y29tLnRlbmNlbnQubW9iaWxlcXE=" };
  
  private static String a()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      Object localObject2 = paramContext.getApplicationContext();
      String str2 = a();
      Pair localPair = c((Context)localObject2);
      String str3 = e();
      long l1 = d((Context)localObject2);
      long l2 = d();
      paramContext = b();
      Object localObject1 = b((Context)localObject2);
      String str1 = c();
      localObject2 = e((Context)localObject2);
      str2 = String.format(Locale.US, "%s|%d|%d|%s|%d|%d", new Object[] { str2, localPair.first, localPair.second, str3, Long.valueOf(l1), Long.valueOf(l2) });
      paramContext = String.format(Locale.US, "%s|%s|%s|%s", new Object[] { paramContext, localObject1, str1, TextUtils.join("|", (Iterable)localObject2) });
      localObject1 = b(str2);
      paramContext = b(paramContext);
      a((char[])localObject1);
      b((char[])localObject1, paramContext);
      paramContext = a((char[])localObject1, paramContext);
      return paramContext;
    }
    catch (Error paramContext)
    {
      Log.w("AMS-QADID", "createQADID error: " + paramContext.getMessage());
      return "01000000000000000000000000000000";
    }
    catch (Throwable paramContext)
    {
      Log.w("AMS-QADID", "createQADID exception: " + paramContext.getMessage());
    }
    return "01000000000000000000000000000000";
  }
  
  private static String a(String paramString)
  {
    return new String(Base64.decode(paramString, 2));
  }
  
  private static String a(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < 32)
    {
      if (i < 16) {
        localStringBuilder.append(paramArrayOfChar1[i]);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramArrayOfChar2[(i - 16)]);
      }
    }
    return localStringBuilder.toString();
  }
  
  private static void a(char[] paramArrayOfChar)
  {
    String str = Integer.toHexString(1).toUpperCase();
    if (str.length() < 2)
    {
      paramArrayOfChar[0] = '0';
      paramArrayOfChar[1] = str.charAt(0);
      return;
    }
    paramArrayOfChar[0] = str.charAt(0);
    paramArrayOfChar[1] = str.charAt(1);
  }
  
  private static long b(char[] paramArrayOfChar)
  {
    Object localObject = new StringBuilder();
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(paramArrayOfChar[i]);
      i += 1;
    }
    paramArrayOfChar = d(((StringBuilder)localObject).toString());
    localObject = new CRC32();
    ((CRC32)localObject).update(paramArrayOfChar);
    return ((CRC32)localObject).getValue();
  }
  
  private static String b()
  {
    return Locale.getDefault().getLanguage();
  }
  
  private static String b(Context paramContext)
  {
    return paramContext.getApplicationContext().getResources().getConfiguration().locale.getCountry();
  }
  
  private static void b(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    char[] arrayOfChar = new char[30];
    int i = 0;
    if (i < 30)
    {
      if (i < 16) {
        arrayOfChar[i] = paramArrayOfChar1[i];
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfChar[i] = paramArrayOfChar2[(i - 16)];
      }
    }
    paramArrayOfChar1 = Integer.toHexString((int)(b(arrayOfChar) % 256L)).toUpperCase();
    if (paramArrayOfChar1.length() < 2)
    {
      paramArrayOfChar2[14] = '0';
      paramArrayOfChar2[15] = paramArrayOfChar1.charAt(0);
      return;
    }
    paramArrayOfChar2[14] = paramArrayOfChar1.charAt(0);
    paramArrayOfChar2[15] = paramArrayOfChar1.charAt(1);
  }
  
  private static char[] b(String paramString)
  {
    paramString = c(paramString);
    char[] arrayOfChar = new char[16];
    int i = 8;
    while (i < 24)
    {
      arrayOfChar[(i - 8)] = paramString.charAt(i);
      i += 1;
    }
    return arrayOfChar;
  }
  
  private static Pair<Integer, Integer> c(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext != null)
    {
      if (Build.VERSION.SDK_INT < 17) {
        break label76;
      }
      paramContext.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels)), Integer.valueOf(Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels)));
      label76:
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
  }
  
  private static String c()
  {
    try
    {
      String str = TimeZone.getDefault().getDisplayName(false, 0);
      return str;
    }
    catch (Exception localException)
    {
      return "";
    }
    catch (AssertionError localAssertionError) {}
    return "";
  }
  
  private static String c(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuilder();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        int k = paramString[i];
        if ((k & 0xFF) < 16) {
          ((StringBuilder)localObject).append("0");
        }
        ((StringBuilder)localObject).append(Integer.toHexString(k & 0xFF));
        i += 1;
      }
      paramString = ((StringBuilder)localObject).toString().toUpperCase();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return "";
  }
  
  private static long d()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    if (Build.VERSION.SDK_INT >= 18)
    {
      l = localStatFs.getBlockSizeLong();
      return localStatFs.getBlockCountLong() * l;
    }
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  /* Error */
  private static long d(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: lconst_0
    //   7: lstore_3
    //   8: getstatic 229	android/os/Build$VERSION:SDK_INT	I
    //   11: bipush 16
    //   13: if_icmplt +43 -> 56
    //   16: aload_0
    //   17: ldc_w 334
    //   20: invokevirtual 223	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 336	android/app/ActivityManager
    //   26: astore_0
    //   27: new 338	android/app/ActivityManager$MemoryInfo
    //   30: dup
    //   31: invokespecial 339	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   34: astore 5
    //   36: aload_0
    //   37: ifnull +277 -> 314
    //   40: aload_0
    //   41: aload 5
    //   43: invokevirtual 343	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   46: aload 5
    //   48: getfield 347	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   51: lstore_1
    //   52: lload_1
    //   53: lstore_3
    //   54: lload_3
    //   55: lreturn
    //   56: new 349	java/io/FileReader
    //   59: dup
    //   60: ldc_w 351
    //   63: invokespecial 352	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   66: astore_0
    //   67: new 354	java/io/BufferedReader
    //   70: dup
    //   71: aload_0
    //   72: sipush 4096
    //   75: invokespecial 357	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   78: astore 5
    //   80: aload 5
    //   82: invokevirtual 360	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   85: astore 6
    //   87: aload 6
    //   89: ifnull +14 -> 103
    //   92: aload 6
    //   94: ldc_w 362
    //   97: invokevirtual 366	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   100: ifeq -20 -> 80
    //   103: lload_3
    //   104: lstore_1
    //   105: aload 6
    //   107: ifnull +26 -> 133
    //   110: aload 6
    //   112: ldc_w 368
    //   115: invokevirtual 372	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   118: iconst_1
    //   119: aaload
    //   120: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   123: invokevirtual 378	java/lang/Long:longValue	()J
    //   126: lstore_1
    //   127: lload_1
    //   128: ldc2_w 379
    //   131: lmul
    //   132: lstore_1
    //   133: aload 5
    //   135: ifnull +8 -> 143
    //   138: aload 5
    //   140: invokevirtual 383	java/io/BufferedReader:close	()V
    //   143: lload_1
    //   144: lstore_3
    //   145: aload_0
    //   146: ifnull -92 -> 54
    //   149: aload_0
    //   150: invokevirtual 384	java/io/FileReader:close	()V
    //   153: lload_1
    //   154: lreturn
    //   155: astore_0
    //   156: lload_1
    //   157: lreturn
    //   158: astore_0
    //   159: aconst_null
    //   160: astore 6
    //   162: aload 5
    //   164: astore_0
    //   165: aload 6
    //   167: astore 5
    //   169: aload 5
    //   171: ifnull +8 -> 179
    //   174: aload 5
    //   176: invokevirtual 383	java/io/BufferedReader:close	()V
    //   179: aload_0
    //   180: ifnull -126 -> 54
    //   183: aload_0
    //   184: invokevirtual 384	java/io/FileReader:close	()V
    //   187: lconst_0
    //   188: lreturn
    //   189: astore_0
    //   190: lconst_0
    //   191: lreturn
    //   192: astore_0
    //   193: aconst_null
    //   194: astore 5
    //   196: aconst_null
    //   197: astore_0
    //   198: aload 5
    //   200: ifnull +8 -> 208
    //   203: aload 5
    //   205: invokevirtual 383	java/io/BufferedReader:close	()V
    //   208: aload_0
    //   209: ifnull -155 -> 54
    //   212: aload_0
    //   213: invokevirtual 384	java/io/FileReader:close	()V
    //   216: lconst_0
    //   217: lreturn
    //   218: astore_0
    //   219: lconst_0
    //   220: lreturn
    //   221: astore 5
    //   223: aconst_null
    //   224: astore_0
    //   225: aload 6
    //   227: ifnull +8 -> 235
    //   230: aload 6
    //   232: invokevirtual 383	java/io/BufferedReader:close	()V
    //   235: aload_0
    //   236: ifnull +7 -> 243
    //   239: aload_0
    //   240: invokevirtual 384	java/io/FileReader:close	()V
    //   243: aload 5
    //   245: athrow
    //   246: astore 5
    //   248: goto -105 -> 143
    //   251: astore 5
    //   253: goto -74 -> 179
    //   256: astore 5
    //   258: goto -50 -> 208
    //   261: astore 6
    //   263: goto -28 -> 235
    //   266: astore_0
    //   267: goto -24 -> 243
    //   270: astore 5
    //   272: goto -47 -> 225
    //   275: astore 7
    //   277: aload 5
    //   279: astore 6
    //   281: aload 7
    //   283: astore 5
    //   285: goto -60 -> 225
    //   288: astore 5
    //   290: aconst_null
    //   291: astore 5
    //   293: goto -95 -> 198
    //   296: astore 6
    //   298: goto -100 -> 198
    //   301: astore 5
    //   303: aconst_null
    //   304: astore 5
    //   306: goto -137 -> 169
    //   309: astore 6
    //   311: goto -142 -> 169
    //   314: lconst_0
    //   315: lstore_1
    //   316: goto -264 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramContext	Context
    //   51	265	1	l1	long
    //   7	138	3	l2	long
    //   4	200	5	localObject1	Object
    //   221	23	5	localObject2	Object
    //   246	1	5	localIOException1	java.io.IOException
    //   251	1	5	localIOException2	java.io.IOException
    //   256	1	5	localIOException3	java.io.IOException
    //   270	8	5	localObject3	Object
    //   283	1	5	localObject4	Object
    //   288	1	5	localIOException4	java.io.IOException
    //   291	1	5	localObject5	Object
    //   301	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   304	1	5	localObject6	Object
    //   1	230	6	str	String
    //   261	1	6	localIOException5	java.io.IOException
    //   279	1	6	localObject7	Object
    //   296	1	6	localIOException6	java.io.IOException
    //   309	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   275	7	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   149	153	155	java/io/IOException
    //   56	67	158	java/io/FileNotFoundException
    //   183	187	189	java/io/IOException
    //   56	67	192	java/io/IOException
    //   212	216	218	java/io/IOException
    //   56	67	221	finally
    //   138	143	246	java/io/IOException
    //   174	179	251	java/io/IOException
    //   203	208	256	java/io/IOException
    //   230	235	261	java/io/IOException
    //   239	243	266	java/io/IOException
    //   67	80	270	finally
    //   80	87	275	finally
    //   92	103	275	finally
    //   110	127	275	finally
    //   67	80	288	java/io/IOException
    //   80	87	296	java/io/IOException
    //   92	103	296	java/io/IOException
    //   110	127	296	java/io/IOException
    //   67	80	301	java/io/FileNotFoundException
    //   80	87	309	java/io/FileNotFoundException
    //   92	103	309	java/io/FileNotFoundException
    //   110	127	309	java/io/FileNotFoundException
  }
  
  private static byte[] d(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    return arrayOfByte;
  }
  
  /* Error */
  private static String e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_1
    //   7: ldc_w 392
    //   10: invokestatic 397	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_2
    //   14: new 349	java/io/FileReader
    //   17: dup
    //   18: ldc_w 399
    //   21: invokespecial 352	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: new 354	java/io/BufferedReader
    //   28: dup
    //   29: aload_0
    //   30: sipush 8192
    //   33: invokespecial 357	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual 360	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +5 -> 48
    //   46: aload_3
    //   47: astore_2
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 383	java/io/BufferedReader:close	()V
    //   56: aload_2
    //   57: astore_1
    //   58: aload_0
    //   59: ifnull +9 -> 68
    //   62: aload_0
    //   63: invokevirtual 384	java/io/FileReader:close	()V
    //   66: aload_2
    //   67: astore_1
    //   68: aload_1
    //   69: areturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_3
    //   73: aload_1
    //   74: astore_0
    //   75: aload_3
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +7 -> 85
    //   81: aload_1
    //   82: invokevirtual 383	java/io/BufferedReader:close	()V
    //   85: aload_2
    //   86: astore_1
    //   87: aload_0
    //   88: ifnull -20 -> 68
    //   91: aload_0
    //   92: invokevirtual 384	java/io/FileReader:close	()V
    //   95: aload_2
    //   96: areturn
    //   97: astore_0
    //   98: aload_2
    //   99: areturn
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_0
    //   103: aload 4
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 383	java/io/BufferedReader:close	()V
    //   114: aload_2
    //   115: astore_1
    //   116: aload_0
    //   117: ifnull -49 -> 68
    //   120: aload_0
    //   121: invokevirtual 384	java/io/FileReader:close	()V
    //   124: aload_2
    //   125: areturn
    //   126: astore_0
    //   127: aload_2
    //   128: areturn
    //   129: astore_1
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_3
    //   133: astore_2
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 383	java/io/BufferedReader:close	()V
    //   142: aload_0
    //   143: ifnull +7 -> 150
    //   146: aload_0
    //   147: invokevirtual 384	java/io/FileReader:close	()V
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: goto -97 -> 56
    //   156: astore_0
    //   157: aload_2
    //   158: areturn
    //   159: astore_1
    //   160: goto -75 -> 85
    //   163: astore_1
    //   164: goto -50 -> 114
    //   167: astore_2
    //   168: goto -26 -> 142
    //   171: astore_0
    //   172: goto -22 -> 150
    //   175: astore_1
    //   176: aload_3
    //   177: astore_2
    //   178: goto -44 -> 134
    //   181: astore_3
    //   182: aload_1
    //   183: astore_2
    //   184: aload_3
    //   185: astore_1
    //   186: goto -52 -> 134
    //   189: astore_1
    //   190: aload 4
    //   192: astore_1
    //   193: goto -87 -> 106
    //   196: astore_3
    //   197: goto -91 -> 106
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_1
    //   203: goto -126 -> 77
    //   206: astore_3
    //   207: goto -130 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   24	39	0	localFileReader	java.io.FileReader
    //   70	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   74	18	0	localObject1	Object
    //   97	1	0	localIOException1	java.io.IOException
    //   100	1	0	localIOException2	java.io.IOException
    //   102	19	0	localObject2	Object
    //   126	1	0	localIOException3	java.io.IOException
    //   131	16	0	localObject3	Object
    //   156	1	0	localIOException4	java.io.IOException
    //   171	1	0	localIOException5	java.io.IOException
    //   6	110	1	localObject4	Object
    //   129	22	1	localObject5	Object
    //   152	1	1	localIOException6	java.io.IOException
    //   159	1	1	localIOException7	java.io.IOException
    //   163	1	1	localIOException8	java.io.IOException
    //   175	8	1	localObject6	Object
    //   185	1	1	localObject7	Object
    //   189	1	1	localIOException9	java.io.IOException
    //   192	1	1	localObject8	Object
    //   200	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   202	1	1	localObject9	Object
    //   13	145	2	str1	String
    //   167	1	2	localIOException10	java.io.IOException
    //   177	7	2	localObject10	Object
    //   4	173	3	str2	String
    //   181	4	3	localObject11	Object
    //   196	1	3	localIOException11	java.io.IOException
    //   206	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	190	4	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   14	25	70	java/io/FileNotFoundException
    //   91	95	97	java/io/IOException
    //   14	25	100	java/io/IOException
    //   120	124	126	java/io/IOException
    //   14	25	129	finally
    //   52	56	152	java/io/IOException
    //   62	66	156	java/io/IOException
    //   81	85	159	java/io/IOException
    //   110	114	163	java/io/IOException
    //   138	142	167	java/io/IOException
    //   146	150	171	java/io/IOException
    //   25	37	175	finally
    //   37	42	181	finally
    //   25	37	189	java/io/IOException
    //   37	42	196	java/io/IOException
    //   25	37	200	java/io/FileNotFoundException
    //   37	42	206	java/io/FileNotFoundException
  }
  
  private static List<Long> e(Context paramContext)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getPackageManager();
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    for (;;)
    {
      if (i < j)
      {
        String str = arrayOfString[i];
        try
        {
          localArrayList.add(Long.valueOf(paramContext.getPackageInfo(a(str), 0).firstInstallTime));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localArrayList.add(Long.valueOf(-1L));
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.t
 * JD-Core Version:    0.7.0.1
 */