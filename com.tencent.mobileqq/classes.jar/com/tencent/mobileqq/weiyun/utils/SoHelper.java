package com.tencent.mobileqq.weiyun.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.weiyun.api.download.IWeiyunSoListener;
import com.tencent.mobileqq.weiyun.sdk.download.WyDownloader;
import java.io.File;

public class SoHelper
{
  private static final String a = ;
  private static final String b;
  private static final String c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://dlied5sdk.myapp.com/weiyun/android/qq/");
    localStringBuilder.append(a);
    localStringBuilder.append("/weiyunLibrary");
    localStringBuilder.append(1005);
    localStringBuilder.append(".zip");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://dlied5sdk.myapp.com/weiyun/android/qq/");
    localStringBuilder.append(a);
    localStringBuilder.append("/librarySize");
    localStringBuilder.append(1005);
    localStringBuilder.append(".txt");
    c = localStringBuilder.toString();
  }
  
  /* Error */
  static int a(String paramString)
  {
    // Byte code:
    //   0: ldc 55
    //   2: astore_2
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 6
    //   12: new 57	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 64	java/io/File:exists	()Z
    //   25: ifne +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: new 66	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 69	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_3
    //   39: new 71	java/io/InputStreamReader
    //   42: dup
    //   43: aload_3
    //   44: invokespecial 74	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   47: astore 4
    //   49: new 76	java/io/BufferedReader
    //   52: dup
    //   53: aload 4
    //   55: invokespecial 79	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: astore 5
    //   60: aload 5
    //   62: invokevirtual 82	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore_0
    //   66: aload_0
    //   67: ifnull +37 -> 104
    //   70: new 17	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   77: astore 6
    //   79: aload 6
    //   81: aload_2
    //   82: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 6
    //   88: aload_0
    //   89: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 6
    //   95: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore_0
    //   99: aload_0
    //   100: astore_2
    //   101: goto -41 -> 60
    //   104: aload_2
    //   105: astore_0
    //   106: aload_3
    //   107: invokevirtual 87	java/io/InputStream:close	()V
    //   110: aload 4
    //   112: ifnull +10 -> 122
    //   115: aload_2
    //   116: astore_0
    //   117: aload 4
    //   119: invokevirtual 88	java/io/InputStreamReader:close	()V
    //   122: aload_2
    //   123: astore_0
    //   124: aload 5
    //   126: ifnull +183 -> 309
    //   129: aload_2
    //   130: astore_0
    //   131: aload 5
    //   133: invokevirtual 89	java/io/BufferedReader:close	()V
    //   136: aload_2
    //   137: astore_0
    //   138: goto +171 -> 309
    //   141: goto +168 -> 309
    //   144: astore_0
    //   145: aload 5
    //   147: astore_2
    //   148: goto +55 -> 203
    //   151: goto +89 -> 240
    //   154: goto +123 -> 277
    //   157: astore_0
    //   158: aload 6
    //   160: astore_2
    //   161: goto +42 -> 203
    //   164: astore_0
    //   165: aconst_null
    //   166: astore 4
    //   168: aload 6
    //   170: astore_2
    //   171: goto +32 -> 203
    //   174: aconst_null
    //   175: astore 4
    //   177: aload 7
    //   179: astore 5
    //   181: goto +59 -> 240
    //   184: aconst_null
    //   185: astore 4
    //   187: aload 8
    //   189: astore 5
    //   191: goto +86 -> 277
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_3
    //   197: aload_3
    //   198: astore 4
    //   200: aload 6
    //   202: astore_2
    //   203: aload_3
    //   204: ifnull +7 -> 211
    //   207: aload_3
    //   208: invokevirtual 87	java/io/InputStream:close	()V
    //   211: aload 4
    //   213: ifnull +8 -> 221
    //   216: aload 4
    //   218: invokevirtual 88	java/io/InputStreamReader:close	()V
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 89	java/io/BufferedReader:close	()V
    //   229: aload_0
    //   230: athrow
    //   231: aconst_null
    //   232: astore_3
    //   233: aload_3
    //   234: astore 4
    //   236: aload 7
    //   238: astore 5
    //   240: aload_3
    //   241: ifnull +9 -> 250
    //   244: aload_2
    //   245: astore_0
    //   246: aload_3
    //   247: invokevirtual 87	java/io/InputStream:close	()V
    //   250: aload 4
    //   252: ifnull +124 -> 376
    //   255: aload_2
    //   256: astore_0
    //   257: aload 4
    //   259: invokevirtual 88	java/io/InputStreamReader:close	()V
    //   262: goto +114 -> 376
    //   265: aload_2
    //   266: astore_0
    //   267: aload 5
    //   269: invokevirtual 89	java/io/BufferedReader:close	()V
    //   272: aload_2
    //   273: astore_0
    //   274: goto +35 -> 309
    //   277: aload_3
    //   278: ifnull +9 -> 287
    //   281: aload_2
    //   282: astore_0
    //   283: aload_3
    //   284: invokevirtual 87	java/io/InputStream:close	()V
    //   287: aload 4
    //   289: ifnull +10 -> 299
    //   292: aload_2
    //   293: astore_0
    //   294: aload 4
    //   296: invokevirtual 88	java/io/InputStreamReader:close	()V
    //   299: aload_2
    //   300: astore_0
    //   301: aload 5
    //   303: ifnull +6 -> 309
    //   306: goto -41 -> 265
    //   309: aload_0
    //   310: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifne +10 -> 323
    //   316: aload_0
    //   317: invokestatic 100	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   320: istore_1
    //   321: iload_1
    //   322: ireturn
    //   323: iconst_0
    //   324: ireturn
    //   325: astore_0
    //   326: goto +60 -> 386
    //   329: astore_0
    //   330: goto -99 -> 231
    //   333: astore_0
    //   334: goto -150 -> 184
    //   337: astore_0
    //   338: goto -164 -> 174
    //   341: astore_0
    //   342: aload 8
    //   344: astore 5
    //   346: goto -69 -> 277
    //   349: astore_0
    //   350: aload 7
    //   352: astore 5
    //   354: goto -114 -> 240
    //   357: astore_0
    //   358: goto -204 -> 154
    //   361: astore_0
    //   362: goto -211 -> 151
    //   365: astore_2
    //   366: goto -225 -> 141
    //   369: astore_2
    //   370: goto -141 -> 229
    //   373: astore_0
    //   374: iconst_0
    //   375: ireturn
    //   376: aload_2
    //   377: astore_0
    //   378: aload 5
    //   380: ifnull -71 -> 309
    //   383: goto -118 -> 265
    //   386: aconst_null
    //   387: astore_0
    //   388: aload_0
    //   389: astore 4
    //   391: aload 8
    //   393: astore 5
    //   395: aload_0
    //   396: astore_3
    //   397: goto -120 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	paramString	String
    //   320	2	1	i	int
    //   2	298	2	localObject1	Object
    //   365	1	2	localIOException1	java.io.IOException
    //   369	8	2	localIOException2	java.io.IOException
    //   38	359	3	localObject2	Object
    //   47	343	4	localObject3	Object
    //   58	336	5	localObject4	Object
    //   10	191	6	localStringBuilder	StringBuilder
    //   4	347	7	localObject5	Object
    //   7	385	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   60	66	144	finally
    //   70	99	144	finally
    //   49	60	157	finally
    //   39	49	164	finally
    //   12	28	194	finally
    //   30	39	194	finally
    //   12	28	325	java/io/FileNotFoundException
    //   30	39	325	java/io/FileNotFoundException
    //   12	28	329	java/io/IOException
    //   30	39	329	java/io/IOException
    //   39	49	333	java/io/FileNotFoundException
    //   39	49	337	java/io/IOException
    //   49	60	341	java/io/FileNotFoundException
    //   49	60	349	java/io/IOException
    //   60	66	357	java/io/FileNotFoundException
    //   70	99	357	java/io/FileNotFoundException
    //   60	66	361	java/io/IOException
    //   70	99	361	java/io/IOException
    //   106	110	365	java/io/IOException
    //   117	122	365	java/io/IOException
    //   131	136	365	java/io/IOException
    //   246	250	365	java/io/IOException
    //   257	262	365	java/io/IOException
    //   267	272	365	java/io/IOException
    //   283	287	365	java/io/IOException
    //   294	299	365	java/io/IOException
    //   207	211	369	java/io/IOException
    //   216	221	369	java/io/IOException
    //   225	229	369	java/io/IOException
    //   316	321	373	java/lang/NumberFormatException
  }
  
  public static File a(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "libwlc_upload_uni_v1.0.1.so");
  }
  
  public static void a(Context paramContext, IWeiyunSoListener paramIWeiyunSoListener)
  {
    File localFile1 = a(paramContext);
    File localFile2 = b(paramContext);
    if ((localFile1.exists()) && (localFile2.exists()))
    {
      if (paramIWeiyunSoListener != null) {
        paramIWeiyunSoListener.a(localFile1.getAbsolutePath(), localFile2.getAbsolutePath());
      }
    }
    else
    {
      String str = WeiyunPathUtil.a(123L);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("weiyunLibrary.zip");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("sizeLibrary.txt");
      str = localStringBuilder.toString();
      WyDownloader.a().a(b, (String)localObject, "SoHelper", new SoHelper.1(str, (String)localObject, paramIWeiyunSoListener, paramContext, localFile1, localFile2));
    }
  }
  
  static void a(File paramFile, String paramString)
  {
    paramFile.delete();
    paramFile = new File(paramString);
    if (paramFile.exists()) {
      paramFile.delete();
    }
  }
  
  public static File b(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "libwlc_data_cmd_qq_v1.0.1.so");
  }
  
  private static String b()
  {
    String str;
    if (Build.VERSION.SDK_INT < 21) {
      str = Build.CPU_ABI;
    } else if ((Build.SUPPORTED_ABIS != null) && (Build.SUPPORTED_ABIS.length > 0)) {
      str = Build.SUPPORTED_ABIS[0];
    } else {
      str = null;
    }
    if ((!TextUtils.isEmpty(str)) && (str.contains("armeabi-v7a"))) {
      return "armeabi-v7a";
    }
    return "armeabi";
  }
  
  public static boolean c(Context paramContext)
  {
    File localFile1 = a(paramContext);
    File localFile2 = b(paramContext);
    File localFile3 = new File(paramContext.getFilesDir(), "libWeiyunSDK.so");
    paramContext = PreferenceUtils.a(paramContext, "0", "key_local_so_version");
    if ((localFile1.exists()) && ((localFile2.exists()) || (localFile3.exists())))
    {
      if (!String.valueOf(1005).equals(paramContext))
      {
        localFile1.delete();
        localFile2.delete();
        localFile3.delete();
        return false;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.utils.SoHelper
 * JD-Core Version:    0.7.0.1
 */