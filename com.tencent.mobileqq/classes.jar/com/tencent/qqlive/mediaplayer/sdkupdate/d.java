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
  
  /* Error */
  public static void a(String paramString1, String paramString2)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 124	com/tencent/commonsdk/zip/QZipFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 127	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   10: astore 7
    //   12: aload 7
    //   14: invokevirtual 131	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   17: astore 8
    //   19: aconst_null
    //   20: astore_0
    //   21: aload_3
    //   22: astore 4
    //   24: aload_0
    //   25: astore 5
    //   27: aload 8
    //   29: invokeinterface 137 1 0
    //   34: ifeq +267 -> 301
    //   37: aload_3
    //   38: astore 4
    //   40: aload_0
    //   41: astore 5
    //   43: aload 8
    //   45: invokeinterface 141 1 0
    //   50: checkcast 143	java/util/zip/ZipEntry
    //   53: astore 9
    //   55: aload_3
    //   56: astore 4
    //   58: aload_0
    //   59: astore 5
    //   61: aload 7
    //   63: aload 9
    //   65: invokevirtual 147	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   68: astore 6
    //   70: aload 6
    //   72: astore_0
    //   73: aload 9
    //   75: invokevirtual 150	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   78: astore 4
    //   80: aload 9
    //   82: invokevirtual 153	java/util/zip/ZipEntry:isDirectory	()Z
    //   85: ifeq +57 -> 142
    //   88: aload 4
    //   90: iconst_0
    //   91: aload 4
    //   93: invokevirtual 159	java/lang/String:length	()I
    //   96: iconst_1
    //   97: isub
    //   98: invokevirtual 163	java/lang/String:substring	(II)Ljava/lang/String;
    //   101: astore 4
    //   103: new 165	java/io/File
    //   106: dup
    //   107: new 74	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   114: aload_1
    //   115: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: getstatic 169	java/io/File:separator	Ljava/lang/String;
    //   121: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 4
    //   126: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   135: invokevirtual 173	java/io/File:mkdirs	()Z
    //   138: pop
    //   139: goto -118 -> 21
    //   142: new 165	java/io/File
    //   145: dup
    //   146: new 74	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   153: aload_1
    //   154: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: getstatic 169	java/io/File:separator	Ljava/lang/String;
    //   160: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 4
    //   165: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: astore 4
    //   176: aload 4
    //   178: invokevirtual 177	java/io/File:getParentFile	()Ljava/io/File;
    //   181: invokevirtual 180	java/io/File:exists	()Z
    //   184: ifne +12 -> 196
    //   187: aload 4
    //   189: invokevirtual 177	java/io/File:getParentFile	()Ljava/io/File;
    //   192: invokevirtual 173	java/io/File:mkdirs	()Z
    //   195: pop
    //   196: new 182	java/io/FileOutputStream
    //   199: dup
    //   200: aload 4
    //   202: invokespecial 183	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   205: astore 4
    //   207: sipush 8192
    //   210: newarray byte
    //   212: astore_3
    //   213: aload_0
    //   214: aload_3
    //   215: iconst_0
    //   216: aload_3
    //   217: arraylength
    //   218: invokevirtual 186	java/io/InputStream:read	([BII)I
    //   221: istore_2
    //   222: iload_2
    //   223: iconst_m1
    //   224: if_icmpeq +66 -> 290
    //   227: aload 4
    //   229: aload_3
    //   230: iconst_0
    //   231: iload_2
    //   232: invokevirtual 189	java/io/FileOutputStream:write	([BII)V
    //   235: aload 4
    //   237: invokevirtual 192	java/io/FileOutputStream:flush	()V
    //   240: goto -27 -> 213
    //   243: astore_1
    //   244: aload 4
    //   246: astore_3
    //   247: aload_3
    //   248: astore 4
    //   250: aload_0
    //   251: astore 5
    //   253: aload_1
    //   254: athrow
    //   255: astore_1
    //   256: aload 5
    //   258: astore_0
    //   259: aload 4
    //   261: astore_3
    //   262: aload 7
    //   264: ifnull +8 -> 272
    //   267: aload 7
    //   269: invokevirtual 193	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   272: aload_0
    //   273: ifnull +7 -> 280
    //   276: aload_0
    //   277: invokevirtual 65	java/io/InputStream:close	()V
    //   280: aload_3
    //   281: ifnull +7 -> 288
    //   284: aload_3
    //   285: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   288: aload_1
    //   289: athrow
    //   290: aload 4
    //   292: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   295: aload 4
    //   297: astore_3
    //   298: goto -277 -> 21
    //   301: aload 7
    //   303: ifnull +8 -> 311
    //   306: aload 7
    //   308: invokevirtual 193	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   311: aload_0
    //   312: ifnull +7 -> 319
    //   315: aload_0
    //   316: invokevirtual 65	java/io/InputStream:close	()V
    //   319: aload_3
    //   320: ifnull +7 -> 327
    //   323: aload_3
    //   324: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   327: return
    //   328: astore_0
    //   329: aload_0
    //   330: athrow
    //   331: astore_0
    //   332: aload_0
    //   333: athrow
    //   334: astore_1
    //   335: aload 4
    //   337: astore_3
    //   338: goto -76 -> 262
    //   341: astore_1
    //   342: goto -80 -> 262
    //   345: astore_1
    //   346: goto -99 -> 247
    //   349: astore_1
    //   350: goto -103 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	paramString1	String
    //   0	353	1	paramString2	String
    //   221	11	2	i	int
    //   1	337	3	localObject1	Object
    //   22	314	4	localObject2	Object
    //   25	232	5	str	String
    //   68	3	6	localInputStream	InputStream
    //   10	297	7	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   17	27	8	localEnumeration	java.util.Enumeration
    //   53	28	9	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   207	213	243	java/lang/Exception
    //   213	222	243	java/lang/Exception
    //   227	240	243	java/lang/Exception
    //   290	295	243	java/lang/Exception
    //   27	37	255	finally
    //   43	55	255	finally
    //   61	70	255	finally
    //   253	255	255	finally
    //   306	311	328	java/lang/Exception
    //   315	319	328	java/lang/Exception
    //   323	327	328	java/lang/Exception
    //   267	272	331	java/lang/Exception
    //   276	280	331	java/lang/Exception
    //   284	288	331	java/lang/Exception
    //   207	213	334	finally
    //   213	222	334	finally
    //   227	240	334	finally
    //   290	295	334	finally
    //   73	139	341	finally
    //   142	196	341	finally
    //   196	207	341	finally
    //   27	37	345	java/lang/Exception
    //   43	55	345	java/lang/Exception
    //   61	70	345	java/lang/Exception
    //   73	139	349	java/lang/Exception
    //   142	196	349	java/lang/Exception
    //   196	207	349	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.sdkupdate.d
 * JD-Core Version:    0.7.0.1
 */