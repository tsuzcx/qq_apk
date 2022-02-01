package com.tencent.mobileqq.qfix;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.app.SystemClassLoaderInjector;
import com.tencent.mobileqq.qfix.b.d;
import com.tencent.raft.raftannotation.RaftFactoryMethod;
import com.tencent.raft.raftannotation.RaftMethod;
import com.tencent.raft.raftannotation.RaftService;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;

@RaftService
public class Relax
{
  public static final int ApplyKitkatError = 5;
  public static final String TAG = "PatchLogTag";
  public static final int kApplyDisabled = 6;
  public static final int kApplyInitError = 2;
  public static final int kApplyInjectError = 1;
  public static final int kApplyPreloadCleanError = 3;
  public static final int kApplyRelaxError = 4;
  public static final int kApplySuccess = 0;
  public static final String kConfigFile = "config.txt";
  public static final String kPatchDex = "classes.dex";
  public static final String kPatchMeta = "resources.meta";
  public static final String kPatchRes = "resources.zip";
  public static final String[] kPatchSo = { "lib/armeabi-v7a/librelax.so", "lib/armeabi/librelax.so" };
  
  static
  {
    System.currentTimeMillis();
  }
  
  static void a(String paramString, QZipFile paramQZipFile)
  {
    Object localObject1 = paramQZipFile.getEntry("config.txt");
    if (localObject1 != null)
    {
      Log.d("PatchLogTag", "pre-unzip patch config files..");
      copy(paramQZipFile.getInputStream((ZipEntry)localObject1), new File(paramString, "config.txt"));
    }
    localObject1 = kPatchSo;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      ZipEntry localZipEntry = paramQZipFile.getEntry((String)localObject2);
      if (localZipEntry != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pre-unzip patch so: ");
        localStringBuilder.append((String)localObject2);
        Log.d("PatchLogTag", localStringBuilder.toString());
        localObject2 = new File(paramString, (String)localObject2);
        copy(paramQZipFile.getInputStream(localZipEntry), (File)localObject2);
      }
      i += 1;
    }
  }
  
  /* Error */
  private static byte[] a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 109	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 110	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: new 112	java/io/BufferedInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 115	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: astore_0
    //   19: sipush 4000
    //   22: newarray byte
    //   24: astore 4
    //   26: aload_2
    //   27: astore_0
    //   28: aload_2
    //   29: aload 4
    //   31: iconst_0
    //   32: aload 4
    //   34: arraylength
    //   35: invokevirtual 119	java/io/BufferedInputStream:read	([BII)I
    //   38: istore_1
    //   39: iload_1
    //   40: iconst_m1
    //   41: if_icmpeq +16 -> 57
    //   44: aload_2
    //   45: astore_0
    //   46: aload_3
    //   47: aload 4
    //   49: iconst_0
    //   50: iload_1
    //   51: invokevirtual 123	java/io/ByteArrayOutputStream:write	([BII)V
    //   54: goto -28 -> 26
    //   57: aload_2
    //   58: astore_0
    //   59: aload_3
    //   60: iconst_0
    //   61: invokevirtual 126	java/io/ByteArrayOutputStream:write	(I)V
    //   64: aload_2
    //   65: astore_0
    //   66: aload_3
    //   67: invokevirtual 130	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   70: astore_3
    //   71: aload_2
    //   72: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   75: aload_3
    //   76: areturn
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   82: aload_3
    //   83: areturn
    //   84: astore_3
    //   85: goto +12 -> 97
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_0
    //   91: goto +30 -> 121
    //   94: astore_3
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_0
    //   99: aload_3
    //   100: invokevirtual 137	java/lang/Throwable:printStackTrace	()V
    //   103: aload_2
    //   104: ifnull +14 -> 118
    //   107: aload_2
    //   108: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_2
    //   121: aload_0
    //   122: ifnull +15 -> 137
    //   125: aload_0
    //   126: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   129: goto +8 -> 137
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   137: goto +5 -> 142
    //   140: aload_2
    //   141: athrow
    //   142: goto -2 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramInputStream	InputStream
    //   38	13	1	i	int
    //   16	56	2	localBufferedInputStream	java.io.BufferedInputStream
    //   88	1	2	localObject1	Object
    //   96	12	2	localObject2	Object
    //   120	21	2	localObject3	Object
    //   7	76	3	localObject4	Object
    //   84	1	3	localThrowable1	java.lang.Throwable
    //   94	6	3	localThrowable2	java.lang.Throwable
    //   24	24	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   71	75	77	java/io/IOException
    //   19	26	84	java/lang/Throwable
    //   28	39	84	java/lang/Throwable
    //   46	54	84	java/lang/Throwable
    //   59	64	84	java/lang/Throwable
    //   66	71	84	java/lang/Throwable
    //   0	17	88	finally
    //   0	17	94	java/lang/Throwable
    //   107	111	113	java/io/IOException
    //   19	26	120	finally
    //   28	39	120	finally
    //   46	54	120	finally
    //   59	64	120	finally
    //   66	71	120	finally
    //   99	103	120	finally
    //   125	129	132	java/io/IOException
  }
  
  public static int apply(Context paramContext, File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean)
  {
    File localFile1 = new File(paramFile3, "config.txt");
    if (!localFile1.exists()) {
      return 2;
    }
    String[] arrayOfString = kPatchSo;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      File localFile2 = new File(paramFile3, arrayOfString[i]);
      if (localFile2.exists())
      {
        paramFile3 = new StringBuilder();
        paramFile3.append("load relax from local: ");
        paramFile3.append(localFile2.getAbsolutePath());
        Log.d("PatchLogTag", paramFile3.toString());
        System.load(localFile2.getAbsolutePath());
        bool = true;
        break label126;
      }
      i += 1;
    }
    boolean bool = false;
    label126:
    return apply(paramContext, paramFile1, paramFile2, new FileInputStream(localFile1), bool, paramBoolean);
  }
  
  public static int apply(Context paramContext, File paramFile1, File paramFile2, InputStream paramInputStream, boolean paramBoolean)
  {
    return apply(paramContext, paramFile1, paramFile2, paramInputStream, paramBoolean, true);
  }
  
  public static int apply(Context paramContext, File paramFile1, File paramFile2, InputStream paramInputStream, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramFile1.isFile())
    {
      if (!paramFile2.isDirectory()) {
        return 2;
      }
      System.loadLibrary("c++_shared");
      if (!paramBoolean1) {
        System.loadLibrary("relax");
      }
      if (!"Success".equals(SystemClassLoaderInjector.a(paramContext, paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath(), null, false))) {
        return 1;
      }
      paramFile1 = Relax.class.getClassLoader();
      try
      {
        int i = relax(paramContext, Relax.c.class.getDeclaredMethod("a", new Class[0]), Relax.c.class.getDeclaredMethod("b", new Class[0]), paramFile1, paramFile2, a(paramInputStream), paramBoolean2);
        if (i != 0)
        {
          paramContext = SystemClassLoaderInjector.a((Application)paramContext.getApplicationContext(), 0);
          paramFile1 = new StringBuilder();
          paramFile1.append("applyRelaxPatch failed, unloadResult=");
          paramFile1.append(paramContext);
          Log.d("PatchLogTag", paramFile1.toString());
        }
        return i;
      }
      catch (NoSuchMethodException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return 2;
  }
  
  @RaftMethod
  public static boolean applyRes(Context paramContext, InputStream paramInputStream, File paramFile)
  {
    paramInputStream = a(paramInputStream);
    if (paramInputStream == null) {
      return false;
    }
    paramInputStream = new String(paramInputStream);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qfix");
    return d.a(paramContext, localStringBuilder.toString(), paramInputStream, paramFile);
  }
  
  /* Error */
  public static void copy(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 251	java/io/File:getParentFile	()Ljava/io/File;
    //   4: invokevirtual 254	java/io/File:mkdirs	()Z
    //   7: pop
    //   8: new 256	java/io/FileOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 257	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   16: astore_3
    //   17: sipush 4096
    //   20: newarray byte
    //   22: astore_1
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 262	java/io/InputStream:read	([B)I
    //   28: istore_2
    //   29: iload_2
    //   30: ifle +13 -> 43
    //   33: aload_3
    //   34: aload_1
    //   35: iconst_0
    //   36: iload_2
    //   37: invokevirtual 265	java/io/OutputStream:write	([BII)V
    //   40: goto -17 -> 23
    //   43: aload_0
    //   44: ifnull +7 -> 51
    //   47: aload_0
    //   48: invokevirtual 266	java/io/InputStream:close	()V
    //   51: aload_3
    //   52: invokevirtual 267	java/io/OutputStream:close	()V
    //   55: return
    //   56: astore_1
    //   57: goto +6 -> 63
    //   60: astore_1
    //   61: aconst_null
    //   62: astore_3
    //   63: aload_0
    //   64: ifnull +10 -> 74
    //   67: aload_0
    //   68: invokevirtual 266	java/io/InputStream:close	()V
    //   71: goto +3 -> 74
    //   74: aload_3
    //   75: ifnull +7 -> 82
    //   78: aload_3
    //   79: invokevirtual 267	java/io/OutputStream:close	()V
    //   82: goto +5 -> 87
    //   85: aload_1
    //   86: athrow
    //   87: goto -2 -> 85
    //   90: astore_0
    //   91: goto -40 -> 51
    //   94: astore_0
    //   95: return
    //   96: astore_0
    //   97: goto -23 -> 74
    //   100: astore_0
    //   101: goto -19 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramInputStream	InputStream
    //   0	104	1	paramFile	File
    //   28	9	2	i	int
    //   16	63	3	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   17	23	56	finally
    //   23	29	56	finally
    //   33	40	56	finally
    //   8	17	60	finally
    //   47	51	90	java/io/IOException
    //   51	55	94	java/io/IOException
    //   67	71	96	java/io/IOException
    //   78	82	100	java/io/IOException
  }
  
  @RaftFactoryMethod
  public static Relax getInstance()
  {
    return Relax.RelaxHolder.access$100();
  }
  
  private static native int relax(Context paramContext, Method paramMethod1, Method paramMethod2, ClassLoader paramClassLoader, File paramFile, byte[] paramArrayOfByte, boolean paramBoolean);
  
  /* Error */
  public static void unzipRelaxConfig(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 64	com/tencent/commonsdk/zip/QZipFile
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 278	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: aload_1
    //   14: aload_0
    //   15: invokestatic 280	com/tencent/mobileqq/qfix/Relax:a	(Ljava/lang/String;Lcom/tencent/commonsdk/zip/QZipFile;)V
    //   18: aload_0
    //   19: invokevirtual 281	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: astore_2
    //   26: aload_1
    //   27: astore_0
    //   28: goto +35 -> 63
    //   31: astore_1
    //   32: goto +10 -> 42
    //   35: astore_0
    //   36: goto +27 -> 63
    //   39: astore_1
    //   40: aload_3
    //   41: astore_0
    //   42: aload_0
    //   43: astore_2
    //   44: aload_1
    //   45: invokevirtual 137	java/lang/Throwable:printStackTrace	()V
    //   48: aload_0
    //   49: ifnull +13 -> 62
    //   52: aload_0
    //   53: invokevirtual 281	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   56: return
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   62: return
    //   63: aload_2
    //   64: ifnull +15 -> 79
    //   67: aload_2
    //   68: invokevirtual 281	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   71: goto +8 -> 79
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   79: aload_0
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	paramString1	String
    //   0	81	1	paramString2	String
    //   3	65	2	str	String
    //   1	40	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	18	23	finally
    //   13	18	31	java/lang/Throwable
    //   4	13	35	finally
    //   44	48	35	finally
    //   4	13	39	java/lang/Throwable
    //   18	22	57	java/io/IOException
    //   52	56	57	java/io/IOException
    //   67	71	74	java/io/IOException
  }
  
  @RaftMethod
  public int applyPatch(Context paramContext, File paramFile1, File paramFile2, InputStream paramInputStream, boolean paramBoolean)
  {
    return apply(paramContext, paramFile1, paramFile2, paramInputStream, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.Relax
 * JD-Core Version:    0.7.0.1
 */