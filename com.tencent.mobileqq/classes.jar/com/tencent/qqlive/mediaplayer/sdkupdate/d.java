package com.tencent.qqlive.mediaplayer.sdkupdate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class d
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static boolean b = false;
  private static TVK_SDKMgr.OnLogListener c = null;
  
  public static String a()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfStackTraceElement[i]).append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(File paramFile)
  {
    byte[] arrayOfByte = new byte[8192];
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = new FileInputStream(paramFile);
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      for (;;)
      {
        int i = paramFile.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFile.close();
      paramFile = a(localMessageDigest.digest());
      return paramFile;
    }
    catch (Exception paramFile) {}
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(a[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(a[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = "[" + paramString1 + "]" + paramString3;
    if (c != null) {
      switch (paramInt)
      {
      }
    }
    while (!b)
    {
      return;
      c.v(paramString2, paramString1);
      return;
      c.d(paramString2, paramString1);
      return;
      c.i(paramString2, paramString1);
      return;
      c.w(paramString2, paramString1);
      return;
      c.e(paramString2, paramString1);
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      Log.v(paramString2, paramString1);
      return;
    case 2: 
      Log.d(paramString2, paramString1);
      return;
    case 3: 
      Log.i(paramString2, paramString1);
      return;
    case 4: 
      Log.w(paramString2, paramString1);
      return;
    }
    Log.e(paramString2, paramString1);
  }
  
  public static void a(TVK_SDKMgr.OnLogListener paramOnLogListener)
  {
    c = paramOnLogListener;
  }
  
  public static void a(File paramFile, int paramInt)
  {
    a(paramFile, paramInt, false);
  }
  
  public static void a(File paramFile, int paramInt, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.isDirectory()))
    {
      a(5, "UpdateUtils.java", "MediaPlayerMgr", "printDir, dirFile is null");
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length <= 0))
    {
      a(5, "UpdateUtils.java", "MediaPlayerMgr", "printDir, childFiles is null or length 0 ");
      return;
    }
    a(paramInt, "UpdateUtils.java", "MediaPlayerMgr", "printDir,  dirFile:" + paramFile.getAbsolutePath());
    int j = arrayOfFile.length;
    int i = 0;
    label87:
    if (i < j)
    {
      paramFile = arrayOfFile[i];
      if (paramFile != null)
      {
        if (!paramBoolean) {
          break label167;
        }
        a(paramInt, "UpdateUtils.java", "MediaPlayerMgr", "printDir, file.name :" + paramFile.getName() + " , file.size :" + paramFile.length() + ", md5:" + a(paramFile));
      }
    }
    for (;;)
    {
      i += 1;
      break label87;
      break;
      label167:
      a(paramInt, "UpdateUtils.java", "MediaPlayerMgr", "printDir, file.name :" + paramFile.getName() + " , file.size :" + paramFile.length());
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 186	java/util/zip/ZipFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 189	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   10: astore 7
    //   12: aload 7
    //   14: invokevirtual 193	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   17: astore 8
    //   19: aconst_null
    //   20: astore_0
    //   21: aload_3
    //   22: astore 4
    //   24: aload_0
    //   25: astore 5
    //   27: aload 8
    //   29: invokeinterface 198 1 0
    //   34: ifeq +280 -> 314
    //   37: aload_3
    //   38: astore 4
    //   40: aload_0
    //   41: astore 5
    //   43: aload 8
    //   45: invokeinterface 202 1 0
    //   50: checkcast 204	java/util/zip/ZipEntry
    //   53: astore 9
    //   55: aload_3
    //   56: astore 4
    //   58: aload_0
    //   59: astore 5
    //   61: aload 7
    //   63: aload 9
    //   65: invokevirtual 208	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   68: astore 6
    //   70: aload 6
    //   72: astore_0
    //   73: aload 9
    //   75: invokevirtual 209	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   78: astore 4
    //   80: aload 4
    //   82: ldc 211
    //   84: invokevirtual 217	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   87: ifeq +6 -> 93
    //   90: goto -69 -> 21
    //   93: aload 9
    //   95: invokevirtual 218	java/util/zip/ZipEntry:isDirectory	()Z
    //   98: ifeq +57 -> 155
    //   101: aload 4
    //   103: iconst_0
    //   104: aload 4
    //   106: invokevirtual 221	java/lang/String:length	()I
    //   109: iconst_1
    //   110: isub
    //   111: invokevirtual 225	java/lang/String:substring	(II)Ljava/lang/String;
    //   114: astore 4
    //   116: new 142	java/io/File
    //   119: dup
    //   120: new 48	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   127: aload_1
    //   128: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: getstatic 229	java/io/File:separator	Ljava/lang/String;
    //   134: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 4
    //   139: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokespecial 230	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: invokevirtual 233	java/io/File:mkdirs	()Z
    //   151: pop
    //   152: goto -131 -> 21
    //   155: new 142	java/io/File
    //   158: dup
    //   159: new 48	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   166: aload_1
    //   167: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: getstatic 229	java/io/File:separator	Ljava/lang/String;
    //   173: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 4
    //   178: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokespecial 230	java/io/File:<init>	(Ljava/lang/String;)V
    //   187: astore 4
    //   189: aload 4
    //   191: invokevirtual 237	java/io/File:getParentFile	()Ljava/io/File;
    //   194: invokevirtual 240	java/io/File:exists	()Z
    //   197: ifne +12 -> 209
    //   200: aload 4
    //   202: invokevirtual 237	java/io/File:getParentFile	()Ljava/io/File;
    //   205: invokevirtual 233	java/io/File:mkdirs	()Z
    //   208: pop
    //   209: new 242	java/io/FileOutputStream
    //   212: dup
    //   213: aload 4
    //   215: invokespecial 243	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   218: astore 4
    //   220: sipush 8192
    //   223: newarray byte
    //   225: astore_3
    //   226: aload_0
    //   227: aload_3
    //   228: iconst_0
    //   229: aload_3
    //   230: arraylength
    //   231: invokevirtual 246	java/io/InputStream:read	([BII)I
    //   234: istore_2
    //   235: iload_2
    //   236: iconst_m1
    //   237: if_icmpeq +66 -> 303
    //   240: aload 4
    //   242: aload_3
    //   243: iconst_0
    //   244: iload_2
    //   245: invokevirtual 249	java/io/FileOutputStream:write	([BII)V
    //   248: aload 4
    //   250: invokevirtual 252	java/io/FileOutputStream:flush	()V
    //   253: goto -27 -> 226
    //   256: astore_1
    //   257: aload 4
    //   259: astore_3
    //   260: aload_3
    //   261: astore 4
    //   263: aload_0
    //   264: astore 5
    //   266: aload_1
    //   267: athrow
    //   268: astore_1
    //   269: aload 5
    //   271: astore_0
    //   272: aload 4
    //   274: astore_3
    //   275: aload 7
    //   277: ifnull +8 -> 285
    //   280: aload 7
    //   282: invokevirtual 253	java/util/zip/ZipFile:close	()V
    //   285: aload_0
    //   286: ifnull +7 -> 293
    //   289: aload_0
    //   290: invokevirtual 92	java/io/InputStream:close	()V
    //   293: aload_3
    //   294: ifnull +7 -> 301
    //   297: aload_3
    //   298: invokevirtual 254	java/io/FileOutputStream:close	()V
    //   301: aload_1
    //   302: athrow
    //   303: aload 4
    //   305: invokevirtual 254	java/io/FileOutputStream:close	()V
    //   308: aload 4
    //   310: astore_3
    //   311: goto -290 -> 21
    //   314: aload 7
    //   316: ifnull +8 -> 324
    //   319: aload 7
    //   321: invokevirtual 253	java/util/zip/ZipFile:close	()V
    //   324: aload_0
    //   325: ifnull +7 -> 332
    //   328: aload_0
    //   329: invokevirtual 92	java/io/InputStream:close	()V
    //   332: aload_3
    //   333: ifnull +7 -> 340
    //   336: aload_3
    //   337: invokevirtual 254	java/io/FileOutputStream:close	()V
    //   340: return
    //   341: astore_0
    //   342: aload_0
    //   343: athrow
    //   344: astore_0
    //   345: aload_0
    //   346: athrow
    //   347: astore_1
    //   348: aload 4
    //   350: astore_3
    //   351: goto -76 -> 275
    //   354: astore_1
    //   355: goto -80 -> 275
    //   358: astore_1
    //   359: goto -99 -> 260
    //   362: astore_1
    //   363: goto -103 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	paramString1	String
    //   0	366	1	paramString2	String
    //   234	11	2	i	int
    //   1	350	3	localObject1	Object
    //   22	327	4	localObject2	Object
    //   25	245	5	str	String
    //   68	3	6	localInputStream	InputStream
    //   10	310	7	localZipFile	java.util.zip.ZipFile
    //   17	27	8	localEnumeration	java.util.Enumeration
    //   53	41	9	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   220	226	256	java/lang/Exception
    //   226	235	256	java/lang/Exception
    //   240	253	256	java/lang/Exception
    //   303	308	256	java/lang/Exception
    //   27	37	268	finally
    //   43	55	268	finally
    //   61	70	268	finally
    //   266	268	268	finally
    //   319	324	341	java/lang/Exception
    //   328	332	341	java/lang/Exception
    //   336	340	341	java/lang/Exception
    //   280	285	344	java/lang/Exception
    //   289	293	344	java/lang/Exception
    //   297	301	344	java/lang/Exception
    //   220	226	347	finally
    //   226	235	347	finally
    //   240	253	347	finally
    //   303	308	347	finally
    //   73	90	354	finally
    //   93	152	354	finally
    //   155	209	354	finally
    //   209	220	354	finally
    //   27	37	358	java/lang/Exception
    //   43	55	358	java/lang/Exception
    //   61	70	358	java/lang/Exception
    //   73	90	362	java/lang/Exception
    //   93	152	362	java/lang/Exception
    //   155	209	362	java/lang/Exception
    //   209	220	362	java/lang/Exception
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.getType() == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    try
    {
      paramFile1 = new FileInputStream(paramFile1);
      paramFile2 = new FileOutputStream(paramFile2);
      byte[] arrayOfByte = new byte[8192];
      for (;;)
      {
        int i = paramFile1.read(arrayOfByte, 0, 8192);
        if (i <= -1) {
          break;
        }
        paramFile2.write(arrayOfByte, 0, i);
      }
      paramFile2.flush();
      paramFile2.close();
      paramFile1.close();
      return true;
    }
    catch (Exception paramFile1) {}
    return false;
  }
  
  public static void b(File paramFile)
  {
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    while (!paramFile.isDirectory()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      b(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.sdkupdate.d
 * JD-Core Version:    0.7.0.1
 */