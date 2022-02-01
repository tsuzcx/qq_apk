package com.tencent.tgpa.vendorpd.gradish;

import android.content.Context;
import com.tencent.tgpa.vendorpd.b.f;
import java.io.File;

public class LibraryLoaderHelper
{
  private static final String LIB_DIR = "lib";
  
  public static File getWorkaroundLibDir(Context paramContext)
  {
    return paramContext.getDir("lib", 0);
  }
  
  private static File getWorkaroundLibFile(Context paramContext, String paramString)
  {
    paramString = System.mapLibraryName(paramString);
    return new File(getWorkaroundLibDir(paramContext), paramString);
  }
  
  public static boolean loadLibrary(Context paramContext, String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError|SecurityException localUnsatisfiedLinkError)
    {
      label6:
      break label6;
    }
    f.d("load tgpa so lib by system failed!!!");
    return tryLoadLibraryUsingWorkaround(paramContext, paramString);
  }
  
  public static boolean loadLibrary(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists())) {
      if (!paramFile.canRead()) {
        return false;
      }
    }
    try
    {
      System.load(paramFile.getAbsolutePath());
      return true;
    }
    catch (UnsatisfiedLinkError paramFile) {}
    return false;
    return false;
  }
  
  private static boolean tryLoadLibraryUsingWorkaround(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    File localFile = getWorkaroundLibFile(paramContext, paramString);
    if ((!localFile.exists()) && (!unpackLibrariesOnce(paramContext, paramString)))
    {
      paramContext = new StringBuilder();
      paramContext.append("can not find lib file or unzip lib file failed. lib path: ");
      paramContext.append(localFile.getAbsolutePath());
      f.d(paramContext.toString());
      return false;
    }
    return loadLibrary(localFile);
  }
  
  /* Error */
  private static boolean unpackLibrariesOnce(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 93	java/util/zip/ZipFile
    //   3: dup
    //   4: new 31	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokevirtual 97	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   12: getfield 102	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   15: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: iconst_1
    //   19: invokespecial 107	java/util/zip/ZipFile:<init>	(Ljava/io/File;I)V
    //   22: astore 6
    //   24: new 77	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   31: astore 4
    //   33: aload 4
    //   35: ldc 109
    //   37: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 4
    //   43: getstatic 114	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   46: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 4
    //   52: ldc 116
    //   54: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 4
    //   60: aload_1
    //   61: invokestatic 29	java/lang/System:mapLibraryName	(Ljava/lang/String;)Ljava/lang/String;
    //   64: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 6
    //   70: aload 4
    //   72: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 120	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnonnull +10 -> 92
    //   85: aload 6
    //   87: invokevirtual 123	java/util/zip/ZipFile:close	()V
    //   90: iconst_0
    //   91: ireturn
    //   92: aload_0
    //   93: aload_1
    //   94: invokestatic 72	com/tencent/tgpa/vendorpd/gradish/LibraryLoaderHelper:getWorkaroundLibFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   97: astore 7
    //   99: aload 7
    //   101: invokevirtual 60	java/io/File:exists	()Z
    //   104: istore_3
    //   105: iload_3
    //   106: ifne +5 -> 111
    //   109: iconst_0
    //   110: ireturn
    //   111: aload 7
    //   113: invokevirtual 126	java/io/File:createNewFile	()Z
    //   116: istore_3
    //   117: iload_3
    //   118: ifeq +156 -> 274
    //   121: aload 6
    //   123: aload 4
    //   125: invokevirtual 130	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   128: astore_0
    //   129: new 132	java/io/FileOutputStream
    //   132: dup
    //   133: aload 7
    //   135: invokespecial 135	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   138: astore_1
    //   139: sipush 16384
    //   142: newarray byte
    //   144: astore 4
    //   146: aload_0
    //   147: aload 4
    //   149: invokevirtual 141	java/io/InputStream:read	([B)I
    //   152: istore_2
    //   153: iload_2
    //   154: ifle +14 -> 168
    //   157: aload_1
    //   158: aload 4
    //   160: iconst_0
    //   161: iload_2
    //   162: invokevirtual 145	java/io/FileOutputStream:write	([BII)V
    //   165: goto -19 -> 146
    //   168: aload_0
    //   169: ifnull +17 -> 186
    //   172: aload_0
    //   173: invokevirtual 146	java/io/InputStream:close	()V
    //   176: goto +10 -> 186
    //   179: astore_0
    //   180: aload_1
    //   181: invokevirtual 147	java/io/FileOutputStream:close	()V
    //   184: aload_0
    //   185: athrow
    //   186: aload_1
    //   187: invokevirtual 147	java/io/FileOutputStream:close	()V
    //   190: aload 7
    //   192: iconst_1
    //   193: iconst_0
    //   194: invokevirtual 151	java/io/File:setReadable	(ZZ)Z
    //   197: pop
    //   198: aload 7
    //   200: iconst_1
    //   201: iconst_0
    //   202: invokevirtual 154	java/io/File:setExecutable	(ZZ)Z
    //   205: pop
    //   206: aload 7
    //   208: iconst_1
    //   209: invokevirtual 158	java/io/File:setWritable	(Z)Z
    //   212: pop
    //   213: aload 6
    //   215: invokevirtual 123	java/util/zip/ZipFile:close	()V
    //   218: iconst_1
    //   219: ireturn
    //   220: astore 4
    //   222: goto +19 -> 241
    //   225: astore_1
    //   226: goto +6 -> 232
    //   229: astore_1
    //   230: aconst_null
    //   231: astore_0
    //   232: aconst_null
    //   233: astore 5
    //   235: aload_1
    //   236: astore 4
    //   238: aload 5
    //   240: astore_1
    //   241: aload_0
    //   242: ifnull +21 -> 263
    //   245: aload_0
    //   246: invokevirtual 146	java/io/InputStream:close	()V
    //   249: goto +14 -> 263
    //   252: astore_0
    //   253: aload_1
    //   254: ifnull +7 -> 261
    //   257: aload_1
    //   258: invokevirtual 147	java/io/FileOutputStream:close	()V
    //   261: aload_0
    //   262: athrow
    //   263: aload_1
    //   264: ifnull +7 -> 271
    //   267: aload_1
    //   268: invokevirtual 147	java/io/FileOutputStream:close	()V
    //   271: aload 4
    //   273: athrow
    //   274: new 91	java/io/IOException
    //   277: dup
    //   278: invokespecial 159	java/io/IOException:<init>	()V
    //   281: athrow
    //   282: astore_0
    //   283: aload_0
    //   284: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   287: aload 7
    //   289: invokevirtual 60	java/io/File:exists	()Z
    //   292: ifeq +43 -> 335
    //   295: aload 7
    //   297: invokevirtual 165	java/io/File:delete	()Z
    //   300: ifne +35 -> 335
    //   303: new 77	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   310: astore_1
    //   311: aload_1
    //   312: ldc 167
    //   314: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_1
    //   319: aload 7
    //   321: invokevirtual 67	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   324: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_1
    //   329: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 52	com/tencent/tgpa/vendorpd/b/f:d	(Ljava/lang/String;)V
    //   335: aload 6
    //   337: invokevirtual 123	java/util/zip/ZipFile:close	()V
    //   340: aload_0
    //   341: athrow
    //   342: astore_0
    //   343: aload_0
    //   344: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   347: ldc 169
    //   349: invokestatic 52	com/tencent/tgpa/vendorpd/b/f:d	(Ljava/lang/String;)V
    //   352: iconst_0
    //   353: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramContext	Context
    //   0	354	1	paramString	String
    //   152	10	2	i	int
    //   104	14	3	bool	boolean
    //   31	128	4	localObject1	Object
    //   220	1	4	localObject2	Object
    //   236	36	4	str	String
    //   233	6	5	localObject3	Object
    //   22	314	6	localZipFile	java.util.zip.ZipFile
    //   97	223	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   172	176	179	finally
    //   139	146	220	finally
    //   146	153	220	finally
    //   157	165	220	finally
    //   129	139	225	finally
    //   121	129	229	finally
    //   245	249	252	finally
    //   111	117	282	java/io/IOException
    //   180	186	282	java/io/IOException
    //   186	213	282	java/io/IOException
    //   257	261	282	java/io/IOException
    //   261	263	282	java/io/IOException
    //   267	271	282	java/io/IOException
    //   271	274	282	java/io/IOException
    //   274	282	282	java/io/IOException
    //   0	80	342	java/io/IOException
    //   85	90	342	java/io/IOException
    //   92	105	342	java/io/IOException
    //   213	218	342	java/io/IOException
    //   283	335	342	java/io/IOException
    //   335	342	342	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.gradish.LibraryLoaderHelper
 * JD-Core Version:    0.7.0.1
 */