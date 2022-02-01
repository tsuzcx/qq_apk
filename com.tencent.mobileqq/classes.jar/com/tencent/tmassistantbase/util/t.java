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
      localObject1 = b((Context)localObject2);
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
    catch (Throwable paramContext)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createQADID exception: ");
      ((StringBuilder)localObject1).append(paramContext.getMessage());
      Log.w("AMS-QADID", ((StringBuilder)localObject1).toString());
      return "01000000000000000000000000000000";
    }
    catch (Error paramContext)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createQADID error: ");
      ((StringBuilder)localObject1).append(paramContext.getMessage());
      Log.w("AMS-QADID", ((StringBuilder)localObject1).toString());
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
    while (i < 32)
    {
      if (i < 16) {
        localStringBuilder.append(paramArrayOfChar1[i]);
      } else {
        localStringBuilder.append(paramArrayOfChar2[(i - 16)]);
      }
      i += 1;
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
    while (i < 30)
    {
      if (i < 16) {
        arrayOfChar[i] = paramArrayOfChar1[i];
      } else {
        arrayOfChar[i] = paramArrayOfChar2[(i - 16)];
      }
      i += 1;
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
    if (paramContext != null) {
      if (Build.VERSION.SDK_INT >= 17) {
        paramContext.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      } else {
        paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      }
    }
    return new Pair(Integer.valueOf(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels)), Integer.valueOf(Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels)));
  }
  
  private static String c()
  {
    try
    {
      String str = TimeZone.getDefault().getDisplayName(false, 0);
      return str;
    }
    catch (AssertionError|Exception localAssertionError)
    {
      label11:
      break label11;
    }
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
        int k = paramString[i] & 0xFF;
        if (k < 16) {
          ((StringBuilder)localObject).append("0");
        }
        ((StringBuilder)localObject).append(Integer.toHexString(k));
        i += 1;
      }
      paramString = ((StringBuilder)localObject).toString().toUpperCase();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label93:
      break label93;
    }
    return "";
  }
  
  private static long d()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1;
    long l2;
    if (Build.VERSION.SDK_INT >= 18)
    {
      l1 = localStatFs.getBlockSizeLong();
      l2 = localStatFs.getBlockCountLong();
    }
    else
    {
      l1 = localStatFs.getBlockSize();
      l2 = localStatFs.getBlockCount();
    }
    return l1 * l2;
  }
  
  /* Error */
  private static long d(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 229	android/os/Build$VERSION:SDK_INT	I
    //   3: istore_1
    //   4: lconst_0
    //   5: lstore 4
    //   7: iload_1
    //   8: bipush 16
    //   10: if_icmplt +39 -> 49
    //   13: aload_0
    //   14: ldc_w 334
    //   17: invokevirtual 223	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   20: checkcast 336	android/app/ActivityManager
    //   23: astore_0
    //   24: new 338	android/app/ActivityManager$MemoryInfo
    //   27: dup
    //   28: invokespecial 339	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   31: astore 6
    //   33: aload_0
    //   34: ifnull +236 -> 270
    //   37: aload_0
    //   38: aload 6
    //   40: invokevirtual 343	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   43: aload 6
    //   45: getfield 347	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   48: lreturn
    //   49: new 349	java/io/FileReader
    //   52: dup
    //   53: ldc_w 351
    //   56: invokespecial 352	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   59: astore_0
    //   60: new 354	java/io/BufferedReader
    //   63: dup
    //   64: aload_0
    //   65: sipush 4096
    //   68: invokespecial 357	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   71: astore 6
    //   73: aload 6
    //   75: invokevirtual 360	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   78: astore 7
    //   80: aload 7
    //   82: ifnull +14 -> 96
    //   85: aload 7
    //   87: ldc_w 362
    //   90: invokevirtual 366	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   93: ifeq -20 -> 73
    //   96: lload 4
    //   98: lstore_2
    //   99: aload 7
    //   101: ifnull +26 -> 127
    //   104: aload 7
    //   106: ldc_w 368
    //   109: invokevirtual 372	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   112: iconst_1
    //   113: aaload
    //   114: invokestatic 375	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   117: invokevirtual 378	java/lang/Long:longValue	()J
    //   120: lstore_2
    //   121: lload_2
    //   122: ldc2_w 379
    //   125: lmul
    //   126: lstore_2
    //   127: aload 6
    //   129: invokevirtual 383	java/io/BufferedReader:close	()V
    //   132: aload_0
    //   133: invokevirtual 384	java/io/FileReader:close	()V
    //   136: lload_2
    //   137: lreturn
    //   138: astore 8
    //   140: aload_0
    //   141: astore 7
    //   143: aload 8
    //   145: astore_0
    //   146: goto +43 -> 189
    //   149: goto +70 -> 219
    //   152: goto +95 -> 247
    //   155: astore 8
    //   157: aconst_null
    //   158: astore 6
    //   160: aload_0
    //   161: astore 7
    //   163: aload 8
    //   165: astore_0
    //   166: goto +23 -> 189
    //   169: aconst_null
    //   170: astore 6
    //   172: goto +47 -> 219
    //   175: aconst_null
    //   176: astore 6
    //   178: goto +69 -> 247
    //   181: astore_0
    //   182: aconst_null
    //   183: astore 6
    //   185: aload 6
    //   187: astore 7
    //   189: aload 6
    //   191: ifnull +11 -> 202
    //   194: aload 6
    //   196: invokevirtual 383	java/io/BufferedReader:close	()V
    //   199: goto +3 -> 202
    //   202: aload 7
    //   204: ifnull +8 -> 212
    //   207: aload 7
    //   209: invokevirtual 384	java/io/FileReader:close	()V
    //   212: aload_0
    //   213: athrow
    //   214: aconst_null
    //   215: astore_0
    //   216: aload_0
    //   217: astore 6
    //   219: aload 6
    //   221: ifnull +11 -> 232
    //   224: aload 6
    //   226: invokevirtual 383	java/io/BufferedReader:close	()V
    //   229: goto +3 -> 232
    //   232: aload_0
    //   233: ifnull +37 -> 270
    //   236: lload 4
    //   238: lstore_2
    //   239: goto -107 -> 132
    //   242: aconst_null
    //   243: astore_0
    //   244: aload_0
    //   245: astore 6
    //   247: aload 6
    //   249: ifnull +11 -> 260
    //   252: aload 6
    //   254: invokevirtual 383	java/io/BufferedReader:close	()V
    //   257: goto +3 -> 260
    //   260: aload_0
    //   261: ifnull +9 -> 270
    //   264: lload 4
    //   266: lstore_2
    //   267: goto -135 -> 132
    //   270: lconst_0
    //   271: lreturn
    //   272: astore_0
    //   273: goto -31 -> 242
    //   276: astore_0
    //   277: goto -63 -> 214
    //   280: astore 6
    //   282: goto -107 -> 175
    //   285: astore 6
    //   287: goto -118 -> 169
    //   290: astore 7
    //   292: goto -140 -> 152
    //   295: astore 7
    //   297: goto -148 -> 149
    //   300: astore 6
    //   302: goto -170 -> 132
    //   305: astore_0
    //   306: lload_2
    //   307: lreturn
    //   308: astore 6
    //   310: goto -108 -> 202
    //   313: astore 6
    //   315: goto -103 -> 212
    //   318: astore 6
    //   320: goto -88 -> 232
    //   323: astore 6
    //   325: goto -65 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramContext	Context
    //   3	8	1	i	int
    //   98	209	2	l1	long
    //   5	260	4	l2	long
    //   31	222	6	localObject1	Object
    //   280	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   285	1	6	localIOException1	java.io.IOException
    //   300	1	6	localIOException2	java.io.IOException
    //   308	1	6	localIOException3	java.io.IOException
    //   313	1	6	localIOException4	java.io.IOException
    //   318	1	6	localIOException5	java.io.IOException
    //   323	1	6	localIOException6	java.io.IOException
    //   78	130	7	localObject2	Object
    //   290	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   295	1	7	localIOException7	java.io.IOException
    //   138	6	8	localObject3	Object
    //   155	9	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   73	80	138	finally
    //   85	96	138	finally
    //   104	121	138	finally
    //   60	73	155	finally
    //   49	60	181	finally
    //   49	60	272	java/io/FileNotFoundException
    //   49	60	276	java/io/IOException
    //   60	73	280	java/io/FileNotFoundException
    //   60	73	285	java/io/IOException
    //   73	80	290	java/io/FileNotFoundException
    //   85	96	290	java/io/FileNotFoundException
    //   104	121	290	java/io/FileNotFoundException
    //   73	80	295	java/io/IOException
    //   85	96	295	java/io/IOException
    //   104	121	295	java/io/IOException
    //   127	132	300	java/io/IOException
    //   132	136	305	java/io/IOException
    //   194	199	308	java/io/IOException
    //   207	212	313	java/io/IOException
    //   224	229	318	java/io/IOException
    //   252	257	323	java/io/IOException
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
    //   0: ldc_w 392
    //   3: invokestatic 397	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore_3
    //   15: new 349	java/io/FileReader
    //   18: dup
    //   19: ldc_w 399
    //   22: invokespecial 352	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   25: astore_0
    //   26: new 354	java/io/BufferedReader
    //   29: dup
    //   30: aload_0
    //   31: sipush 8192
    //   34: invokespecial 357	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 360	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +5 -> 49
    //   47: aload_3
    //   48: astore_2
    //   49: aload_1
    //   50: invokevirtual 383	java/io/BufferedReader:close	()V
    //   53: aload_0
    //   54: invokevirtual 384	java/io/FileReader:close	()V
    //   57: aload_2
    //   58: areturn
    //   59: astore_3
    //   60: aload_1
    //   61: astore_2
    //   62: aload_3
    //   63: astore_1
    //   64: goto +32 -> 96
    //   67: goto +55 -> 122
    //   70: goto +75 -> 145
    //   73: astore_1
    //   74: aload_3
    //   75: astore_2
    //   76: goto +20 -> 96
    //   79: aload 4
    //   81: astore_1
    //   82: goto +40 -> 122
    //   85: aload 5
    //   87: astore_1
    //   88: goto +57 -> 145
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_3
    //   95: astore_2
    //   96: aload_2
    //   97: ifnull +10 -> 107
    //   100: aload_2
    //   101: invokevirtual 383	java/io/BufferedReader:close	()V
    //   104: goto +3 -> 107
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 384	java/io/FileReader:close	()V
    //   115: aload_1
    //   116: athrow
    //   117: aconst_null
    //   118: astore_0
    //   119: aload 4
    //   121: astore_1
    //   122: aload_1
    //   123: ifnull +10 -> 133
    //   126: aload_1
    //   127: invokevirtual 383	java/io/BufferedReader:close	()V
    //   130: goto +3 -> 133
    //   133: aload_0
    //   134: ifnull +29 -> 163
    //   137: goto -84 -> 53
    //   140: aconst_null
    //   141: astore_0
    //   142: aload 5
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull +10 -> 156
    //   149: aload_1
    //   150: invokevirtual 383	java/io/BufferedReader:close	()V
    //   153: goto +3 -> 156
    //   156: aload_0
    //   157: ifnull +6 -> 163
    //   160: goto -107 -> 53
    //   163: aload_2
    //   164: areturn
    //   165: astore_0
    //   166: goto -26 -> 140
    //   169: astore_0
    //   170: goto -53 -> 117
    //   173: astore_1
    //   174: goto -89 -> 85
    //   177: astore_1
    //   178: goto -99 -> 79
    //   181: astore_3
    //   182: goto -112 -> 70
    //   185: astore_3
    //   186: goto -119 -> 67
    //   189: astore_1
    //   190: goto -137 -> 53
    //   193: astore_0
    //   194: aload_2
    //   195: areturn
    //   196: astore_2
    //   197: goto -90 -> 107
    //   200: astore_0
    //   201: goto -86 -> 115
    //   204: astore_1
    //   205: goto -72 -> 133
    //   208: astore_1
    //   209: goto -53 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   25	132	0	localFileReader	java.io.FileReader
    //   165	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   169	1	0	localIOException1	java.io.IOException
    //   193	1	0	localIOException2	java.io.IOException
    //   200	1	0	localIOException3	java.io.IOException
    //   37	27	1	localObject1	Object
    //   73	1	1	localObject2	Object
    //   81	7	1	localObject3	Object
    //   91	25	1	localObject4	Object
    //   121	29	1	localObject5	Object
    //   173	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   177	1	1	localIOException4	java.io.IOException
    //   189	1	1	localIOException5	java.io.IOException
    //   204	1	1	localIOException6	java.io.IOException
    //   208	1	1	localIOException7	java.io.IOException
    //   6	189	2	localObject6	Object
    //   196	1	2	localIOException8	java.io.IOException
    //   14	34	3	str	String
    //   59	36	3	localObject7	Object
    //   181	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   185	1	3	localIOException9	java.io.IOException
    //   8	112	4	localObject8	Object
    //   11	132	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   38	43	59	finally
    //   26	38	73	finally
    //   15	26	91	finally
    //   15	26	165	java/io/FileNotFoundException
    //   15	26	169	java/io/IOException
    //   26	38	173	java/io/FileNotFoundException
    //   26	38	177	java/io/IOException
    //   38	43	181	java/io/FileNotFoundException
    //   38	43	185	java/io/IOException
    //   49	53	189	java/io/IOException
    //   53	57	193	java/io/IOException
    //   100	104	196	java/io/IOException
    //   111	115	200	java/io/IOException
    //   126	130	204	java/io/IOException
    //   149	153	208	java/io/IOException
  }
  
  private static List<Long> e(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getPackageManager();
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      try
      {
        localArrayList.add(Long.valueOf(paramContext.getPackageInfo(a(str), 0).firstInstallTime));
      }
      catch (Exception localException)
      {
        label61:
        break label61;
      }
      localArrayList.add(Long.valueOf(-1L));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.t
 * JD-Core Version:    0.7.0.1
 */