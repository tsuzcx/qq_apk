package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.StatFs;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class c
{
  static int a = -1;
  private static final String b = "MSF.C.CoreUtil";
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[(paramInt + 3)];
    int j = paramArrayOfByte[(paramInt + 2)];
    int k = paramArrayOfByte[(paramInt + 1)];
    return paramArrayOfByte[(paramInt + 0)] << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000;
  }
  
  public static File a(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("/load/");
      paramString = new File(localStringBuilder.toString());
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 56	android/content/Context:getFilesDir	()Ljava/io/File;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnonnull +84 -> 93
    //   12: aload_0
    //   13: invokevirtual 59	android/content/Context:getCacheDir	()Ljava/io/File;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull +20 -> 38
    //   21: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +287 -> 311
    //   27: ldc 11
    //   29: iconst_2
    //   30: ldc 66
    //   32: invokestatic 70	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: goto +276 -> 311
    //   38: aload_0
    //   39: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: bipush 47
    //   46: invokevirtual 79	java/lang/String:lastIndexOf	(I)I
    //   49: istore_1
    //   50: aload_2
    //   51: astore_0
    //   52: iload_1
    //   53: iconst_m1
    //   54: if_icmpeq +44 -> 98
    //   57: aload_2
    //   58: iconst_0
    //   59: iload_1
    //   60: invokevirtual 83	java/lang/String:substring	(II)Ljava/lang/String;
    //   63: astore_0
    //   64: new 24	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   71: astore_2
    //   72: aload_2
    //   73: aload_0
    //   74: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_2
    //   79: ldc 85
    //   81: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_2
    //   86: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_0
    //   90: goto +8 -> 98
    //   93: aload_2
    //   94: invokevirtual 73	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   97: astore_0
    //   98: aload_0
    //   99: ifnonnull +62 -> 161
    //   102: new 24	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   109: astore_0
    //   110: aload_0
    //   111: invokestatic 90	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   114: invokevirtual 93	java/io/File:getPath	()Ljava/lang/String;
    //   117: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_0
    //   122: ldc 95
    //   124: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_0
    //   129: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore_2
    //   133: new 33	java/io/File
    //   136: dup
    //   137: aload_2
    //   138: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   141: astore_3
    //   142: aload_2
    //   143: astore_0
    //   144: aload_3
    //   145: invokevirtual 44	java/io/File:exists	()Z
    //   148: ifne +91 -> 239
    //   151: aload_3
    //   152: invokevirtual 47	java/io/File:mkdirs	()Z
    //   155: pop
    //   156: aload_2
    //   157: astore_0
    //   158: goto +81 -> 239
    //   161: new 33	java/io/File
    //   164: dup
    //   165: aload_0
    //   166: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   169: astore_2
    //   170: aload_2
    //   171: invokevirtual 44	java/io/File:exists	()Z
    //   174: ifne +8 -> 182
    //   177: aload_2
    //   178: invokevirtual 47	java/io/File:mkdirs	()Z
    //   181: pop
    //   182: aload_2
    //   183: invokevirtual 44	java/io/File:exists	()Z
    //   186: ifeq +10 -> 196
    //   189: aload_2
    //   190: invokevirtual 98	java/io/File:canWrite	()Z
    //   193: ifne +46 -> 239
    //   196: new 24	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   203: astore_0
    //   204: aload_0
    //   205: invokestatic 90	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   208: invokevirtual 93	java/io/File:getPath	()Ljava/lang/String;
    //   211: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_0
    //   216: ldc 95
    //   218: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_0
    //   223: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: astore_0
    //   227: new 33	java/io/File
    //   230: dup
    //   231: aload_0
    //   232: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   235: invokevirtual 47	java/io/File:mkdirs	()Z
    //   238: pop
    //   239: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +34 -> 276
    //   245: new 24	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   252: astore_2
    //   253: aload_2
    //   254: ldc 100
    //   256: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_2
    //   261: aload_0
    //   262: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: ldc 11
    //   268: iconst_2
    //   269: aload_2
    //   270: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: ldc 2
    //   278: monitorexit
    //   279: aload_0
    //   280: areturn
    //   281: astore_0
    //   282: goto +24 -> 306
    //   285: astore_0
    //   286: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +12 -> 301
    //   292: ldc 11
    //   294: iconst_2
    //   295: ldc 105
    //   297: aload_0
    //   298: invokestatic 108	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: ldc 2
    //   303: monitorexit
    //   304: aconst_null
    //   305: areturn
    //   306: ldc 2
    //   308: monitorexit
    //   309: aload_0
    //   310: athrow
    //   311: aconst_null
    //   312: astore_0
    //   313: goto -215 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramContext	Context
    //   49	11	1	i	int
    //   7	263	2	localObject	Object
    //   141	11	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   3	8	281	finally
    //   12	17	281	finally
    //   21	35	281	finally
    //   38	50	281	finally
    //   57	90	281	finally
    //   93	98	281	finally
    //   102	142	281	finally
    //   144	156	281	finally
    //   161	182	281	finally
    //   182	189	281	finally
    //   189	196	281	finally
    //   196	239	281	finally
    //   239	276	281	finally
    //   286	301	281	finally
    //   3	8	285	java/lang/Throwable
    //   12	17	285	java/lang/Throwable
    //   21	35	285	java/lang/Throwable
    //   38	50	285	java/lang/Throwable
    //   57	90	285	java/lang/Throwable
    //   93	98	285	java/lang/Throwable
    //   102	142	285	java/lang/Throwable
    //   144	156	285	java/lang/Throwable
    //   161	182	285	java/lang/Throwable
    //   182	189	285	java/lang/Throwable
    //   189	196	285	java/lang/Throwable
    //   196	239	285	java/lang/Throwable
    //   239	276	285	java/lang/Throwable
  }
  
  public static String a(InputStream paramInputStream)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte[64];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i));
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static void a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: new 33	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokestatic 133	com/tencent/mobileqq/msf/core/c:h	(Landroid/content/Context;)Ljava/lang/String;
    //   8: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 44	java/io/File:exists	()Z
    //   16: ifeq +8 -> 24
    //   19: aload_3
    //   20: invokevirtual 136	java/io/File:delete	()Z
    //   23: pop
    //   24: aconst_null
    //   25: astore 4
    //   27: aconst_null
    //   28: astore_2
    //   29: aload_2
    //   30: astore_0
    //   31: aload_3
    //   32: invokevirtual 139	java/io/File:createNewFile	()Z
    //   35: pop
    //   36: aload_2
    //   37: astore_0
    //   38: new 141	java/io/FileOutputStream
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 144	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   46: astore_2
    //   47: aload_2
    //   48: iload_1
    //   49: invokestatic 147	com/tencent/mobileqq/msf/core/c:a	(I)[B
    //   52: invokevirtual 151	java/io/FileOutputStream:write	([B)V
    //   55: aload_2
    //   56: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   59: return
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   65: return
    //   66: astore_0
    //   67: goto +36 -> 103
    //   70: astore_0
    //   71: aload_0
    //   72: astore_3
    //   73: goto +15 -> 88
    //   76: astore_3
    //   77: aload_0
    //   78: astore_2
    //   79: aload_3
    //   80: astore_0
    //   81: goto +22 -> 103
    //   84: astore_3
    //   85: aload 4
    //   87: astore_2
    //   88: aload_2
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   102: return
    //   103: aload_2
    //   104: ifnull +15 -> 119
    //   107: aload_2
    //   108: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   111: goto +8 -> 119
    //   114: astore_2
    //   115: aload_2
    //   116: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   119: aload_0
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramContext	Context
    //   0	121	1	paramInt	int
    //   28	80	2	localObject1	Object
    //   114	2	2	localIOException	IOException
    //   11	62	3	localObject2	Object
    //   76	4	3	localObject3	Object
    //   84	7	3	localException	Exception
    //   25	61	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   55	59	60	java/io/IOException
    //   98	102	60	java/io/IOException
    //   47	55	66	finally
    //   47	55	70	java/lang/Exception
    //   31	36	76	finally
    //   38	47	76	finally
    //   90	94	76	finally
    //   31	36	84	java/lang/Exception
    //   38	47	84	java/lang/Exception
    //   107	111	114	java/io/IOException
  }
  
  private static void a(Context paramContext, String paramString, int paramInt, String[] paramArrayOfString)
  {
    QLog.d("MSF.C.CoreUtil", 1, "MsfCore init ->realCopySoLib begin.");
    Object localObject1 = paramContext.getAssets();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("lib/");
    ((StringBuilder)localObject2).append(paramString);
    localObject1 = ((AssetManager)localObject1).list(((StringBuilder)localObject2).toString());
    localObject2 = d(paramContext);
    StringBuilder localStringBuilder1;
    if (localObject1 != null)
    {
      localStringBuilder1 = new StringBuilder("realCopySoLib list assetsFileNames: ");
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localStringBuilder1.append(localObject1[i]);
        localStringBuilder1.append(" ");
        i += 1;
      }
      QLog.i("MSF.C.CoreUtil", 1, localStringBuilder1.toString());
    }
    int i2 = localObject1.length;
    int j = 0;
    int k = 0;
    int n;
    for (int i = 0; j < i2; i = n)
    {
      localStringBuilder1 = localObject1[j];
      int i3 = paramArrayOfString.length;
      int i1 = 0;
      int m;
      for (;;)
      {
        m = k;
        n = i;
        if (i1 >= i3) {
          break;
        }
        if (paramArrayOfString[i1].equals(localStringBuilder1))
        {
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("lib/");
          ((StringBuilder)localObject3).append(paramString);
          ((StringBuilder)localObject3).append("/");
          ((StringBuilder)localObject3).append(localStringBuilder1);
          localObject3 = ((StringBuilder)localObject3).toString();
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(localStringBuilder1);
          localObject4 = new File(((StringBuilder)localObject4).toString());
          if ((((File)localObject4).exists()) && (!((File)localObject4).delete()))
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("realCopySoLib delete ");
            localStringBuilder2.append(((File)localObject4).getName());
            localStringBuilder2.append(" failed.");
            QLog.w("MSF.C.CoreUtil", 1, localStringBuilder2.toString());
          }
          boolean bool = a((String)localObject3, (String)localObject2, paramContext);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("realCopySoLib ");
          ((StringBuilder)localObject3).append(localStringBuilder1);
          ((StringBuilder)localObject3).append(" size=");
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(localStringBuilder1);
          ((StringBuilder)localObject3).append(new File(((StringBuilder)localObject4).toString()).length());
          ((StringBuilder)localObject3).append(" ");
          ((StringBuilder)localObject3).append(bool);
          QLog.i("MSF.C.CoreUtil", 1, ((StringBuilder)localObject3).toString());
          if (!bool)
          {
            m = k + 1;
            n = i;
            break;
          }
          n = i + 1;
          m = k;
          break;
        }
        i1 += 1;
      }
      j += 1;
      k = m;
    }
    if (k == 0)
    {
      QLog.i("MSF.C.CoreUtil", 1, "realCopySoLib update versionCode and jniFile");
      a(paramContext, paramInt);
      j(paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append("MsfCore init ->realCopySoLib end. copyFailCount:");
    paramContext.append(k);
    paramContext.append(" copySuccCount=");
    paramContext.append(i);
    QLog.d("MSF.C.CoreUtil", 1, paramContext.toString());
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, int paramInt, String[] paramArrayOfString)
  {
    if (paramBoolean) {
      a(paramContext, paramString, paramInt, paramArrayOfString);
    } else {
      try
      {
        String[] arrayOfString1 = m(paramContext);
        String[] arrayOfString2 = l(paramContext);
        if ((arrayOfString1 == null) || (arrayOfString2 == null) || (!arrayOfString2[0].equals(arrayOfString1[0])) || (!arrayOfString2[1].equals(arrayOfString1[1]))) {
          a(paramContext, paramString, paramInt, paramArrayOfString);
        }
      }
      catch (Exception paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("check package jni id error ");
        paramString.append(paramContext);
        QLog.w("MSF.C.CoreUtil", 1, paramString.toString());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.CoreUtil", 2, "MsfCore init ->copySoLib end.");
    }
  }
  
  public static boolean a()
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bRet=");
    localStringBuilder.append(false);
    localPrintStream.println(localStringBuilder.toString());
    return false;
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(d(paramContext));
    ((StringBuilder)localObject).append("lib");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".so");
    File localFile = new File(((StringBuilder)localObject).toString());
    localObject = localFile;
    if (!localFile.exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getFilesDir().getParent());
      ((StringBuilder)localObject).append("/lib/lib");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".so");
      localObject = new File(((StringBuilder)localObject).toString());
    }
    if (((File)localObject).exists()) {}
    try
    {
      System.load(((File)localObject).getAbsolutePath());
      bool = true;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      boolean bool;
      label142:
      break label142;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("cannot load library ");
      paramContext.append(((File)localObject).getAbsolutePath());
      QLog.d("MSF.C.CoreUtil", 2, paramContext.toString());
    }
    bool = false;
    if (!bool) {}
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      label195:
      break label195;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("cannot load library ");
      paramContext.append(paramString);
      QLog.d("MSF.C.CoreUtil", 2, paramContext.toString());
    }
    return false;
    return bool;
  }
  
  private static boolean a(String paramString1, String paramString2, Context paramContext)
  {
    boolean bool2 = false;
    if ((paramContext != null) && (paramString1 != null)) {}
    for (;;)
    {
      String str;
      int i;
      StringBuilder localStringBuilder;
      try
      {
        if (paramString1.contains(".so"))
        {
          if (paramString2 != null)
          {
            str = paramString2;
            if (paramString2.trim().length() != 0) {}
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.e("MSF.C.CoreUtil", 2, "not define lib out path");
            }
            str = paramContext.getFilesDir().getAbsolutePath();
          }
          new File(str).mkdirs();
          i = paramString1.lastIndexOf('/');
          if (i < 0) {
            break label352;
          }
          paramString2 = paramString1.substring(i + 1);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("copy lib:");
            localStringBuilder.append(paramString1);
            QLog.d("MSF.C.CoreUtil", 2, localStringBuilder.toString());
          }
          localStringBuilder = null;
        }
      }
      finally {}
      try
      {
        paramString1 = paramContext.getAssets().open(paramString1);
      }
      catch (Exception paramString1)
      {
        continue;
      }
      try
      {
        paramContext = new StringBuilder();
        paramContext.append(str);
        paramContext.append("/");
        paramContext.append(paramString2);
        paramString2 = new File(paramContext.toString());
        if (paramString2.exists()) {
          paramString2.delete();
        }
        paramString2.createNewFile();
        paramString2 = new FileOutputStream(paramString2);
      }
      catch (Exception paramString2)
      {
        continue;
      }
      try
      {
        paramContext = new byte[4096];
        if (paramString1.available() > 0)
        {
          i = paramString1.read(paramContext);
          if (i > 0)
          {
            paramString2.write(paramContext, 0, i);
            continue;
          }
        }
        paramString2.close();
        paramString1.close();
        bool1 = true;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      continue;
      paramString2 = localStringBuilder;
      continue;
      paramString1 = null;
      paramString2 = localStringBuilder;
      if (paramString2 != null) {}
      try
      {
        paramString2.close();
      }
      catch (IOException paramString2)
      {
        continue;
      }
      boolean bool1 = bool2;
      if (paramString1 != null) {}
      try
      {
        paramString1.close();
        bool1 = bool2;
      }
      catch (IOException paramString1)
      {
        bool1 = bool2;
        continue;
      }
      return bool1;
      return false;
      label352:
      paramString2 = paramString1;
    }
  }
  
  public static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt >>> 24 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static File b(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("/cacheTemp/");
      paramString = new File(localStringBuilder.toString());
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getFilesDir().getAbsolutePath();
      if (paramContext == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("MSF.C.CoreUtil", 2, "getFilePath dir is null");
        }
        return null;
      }
      File localFile = new File(paramContext);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return paramContext;
    }
    finally {}
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = Build.CPU_ABI;
      if ((paramContext != null) && (paramContext.contains("x86"))) {
        return "x86";
      }
      if ((paramContext != null) && (paramContext.contains("mip"))) {
        return "mips";
      }
      return "armeabi";
    }
    finally {}
  }
  
  public static String d(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getParent());
    localStringBuilder.append("/txlib/");
    return localStringBuilder.toString();
  }
  
  public static int e(Context paramContext)
  {
    if ((a == -1) && (paramContext != null))
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      try
      {
        a = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return a;
  }
  
  public static String f(Context paramContext)
  {
    if (paramContext != null)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      try
      {
        paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionName;
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  /* Error */
  public static int g(Context paramContext)
  {
    // Byte code:
    //   0: new 33	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokestatic 358	com/tencent/mobileqq/msf/core/c:i	(Landroid/content/Context;)Ljava/lang/String;
    //   8: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: aload 4
    //   15: invokevirtual 44	java/io/File:exists	()Z
    //   18: ifeq +9 -> 27
    //   21: aload 4
    //   23: invokevirtual 136	java/io/File:delete	()Z
    //   26: pop
    //   27: new 33	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokestatic 133	com/tencent/mobileqq/msf/core/c:h	(Landroid/content/Context;)Ljava/lang/String;
    //   35: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_0
    //   39: aload_0
    //   40: invokevirtual 44	java/io/File:exists	()Z
    //   43: istore_3
    //   44: iconst_m1
    //   45: istore_2
    //   46: iload_3
    //   47: ifeq +130 -> 177
    //   50: new 360	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 361	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: astore 4
    //   60: iload_2
    //   61: istore_1
    //   62: aload 4
    //   64: astore_0
    //   65: aload 4
    //   67: invokevirtual 362	java/io/FileInputStream:available	()I
    //   70: iconst_4
    //   71: if_icmpne +32 -> 103
    //   74: aload 4
    //   76: astore_0
    //   77: iconst_4
    //   78: newarray byte
    //   80: astore 5
    //   82: aload 4
    //   84: astore_0
    //   85: aload 4
    //   87: aload 5
    //   89: invokevirtual 363	java/io/FileInputStream:read	([B)I
    //   92: pop
    //   93: aload 4
    //   95: astore_0
    //   96: aload 5
    //   98: iconst_0
    //   99: invokestatic 365	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   102: istore_1
    //   103: iload_1
    //   104: istore_2
    //   105: aload 4
    //   107: invokevirtual 366	java/io/FileInputStream:close	()V
    //   110: iload_1
    //   111: ireturn
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   117: iload_2
    //   118: ireturn
    //   119: astore 5
    //   121: goto +15 -> 136
    //   124: astore 4
    //   126: aconst_null
    //   127: astore_0
    //   128: goto +30 -> 158
    //   131: astore 5
    //   133: aconst_null
    //   134: astore 4
    //   136: aload 4
    //   138: astore_0
    //   139: aload 5
    //   141: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   144: aload 4
    //   146: ifnull +31 -> 177
    //   149: aload 4
    //   151: invokevirtual 366	java/io/FileInputStream:close	()V
    //   154: iconst_m1
    //   155: ireturn
    //   156: astore 4
    //   158: aload_0
    //   159: ifnull +15 -> 174
    //   162: aload_0
    //   163: invokevirtual 366	java/io/FileInputStream:close	()V
    //   166: goto +8 -> 174
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 157	java/io/IOException:printStackTrace	()V
    //   174: aload 4
    //   176: athrow
    //   177: iconst_m1
    //   178: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramContext	Context
    //   61	50	1	i	int
    //   45	73	2	j	int
    //   43	4	3	bool	boolean
    //   11	95	4	localObject1	Object
    //   124	1	4	localObject2	Object
    //   134	16	4	localObject3	Object
    //   156	19	4	localObject4	Object
    //   80	17	5	arrayOfByte	byte[]
    //   119	1	5	localException1	Exception
    //   131	9	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   105	110	112	java/io/IOException
    //   149	154	112	java/io/IOException
    //   65	74	119	java/lang/Exception
    //   77	82	119	java/lang/Exception
    //   85	93	119	java/lang/Exception
    //   96	103	119	java/lang/Exception
    //   50	60	124	finally
    //   50	60	131	java/lang/Exception
    //   65	74	156	finally
    //   77	82	156	finally
    //   85	93	156	finally
    //   96	103	156	finally
    //   139	144	156	finally
    //   162	166	169	java/io/IOException
  }
  
  public static String h(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir());
    localStringBuilder.append("/verFile");
    return localStringBuilder.toString();
  }
  
  public static String i(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir());
    localStringBuilder.append("/verFile2");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static void j(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 11
    //   8: iconst_2
    //   9: ldc_w 372
    //   12: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aconst_null
    //   16: astore 4
    //   18: aconst_null
    //   19: astore_3
    //   20: aload_0
    //   21: invokevirtual 165	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   24: ldc_w 374
    //   27: invokevirtual 302	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: astore_2
    //   31: new 24	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   38: astore 5
    //   40: aload 5
    //   42: aload_0
    //   43: invokevirtual 56	android/content/Context:getFilesDir	()Ljava/io/File;
    //   46: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 5
    //   52: ldc_w 376
    //   55: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: new 141	java/io/FileOutputStream
    //   62: dup
    //   63: aload 5
    //   65: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 377	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   71: astore_0
    //   72: sipush 128
    //   75: newarray byte
    //   77: astore_3
    //   78: aload_2
    //   79: aload_3
    //   80: invokevirtual 118	java/io/InputStream:read	([B)I
    //   83: istore_1
    //   84: iload_1
    //   85: ifle +13 -> 98
    //   88: aload_0
    //   89: aload_3
    //   90: iconst_0
    //   91: iload_1
    //   92: invokevirtual 380	java/io/OutputStream:write	([BII)V
    //   95: goto -17 -> 78
    //   98: aload_2
    //   99: ifnull +7 -> 106
    //   102: aload_2
    //   103: invokevirtual 308	java/io/InputStream:close	()V
    //   106: aload_0
    //   107: invokevirtual 381	java/io/OutputStream:close	()V
    //   110: return
    //   111: astore 4
    //   113: aload_0
    //   114: astore_3
    //   115: aload 4
    //   117: astore_0
    //   118: goto +13 -> 131
    //   121: goto +33 -> 154
    //   124: astore_0
    //   125: goto +6 -> 131
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 308	java/io/InputStream:close	()V
    //   139: aload_3
    //   140: ifnull +7 -> 147
    //   143: aload_3
    //   144: invokevirtual 381	java/io/OutputStream:close	()V
    //   147: aload_0
    //   148: athrow
    //   149: aconst_null
    //   150: astore_2
    //   151: aload 4
    //   153: astore_0
    //   154: aload_2
    //   155: ifnull +7 -> 162
    //   158: aload_2
    //   159: invokevirtual 308	java/io/InputStream:close	()V
    //   162: aload_0
    //   163: ifnull +7 -> 170
    //   166: aload_0
    //   167: invokevirtual 381	java/io/OutputStream:close	()V
    //   170: return
    //   171: astore_0
    //   172: goto -23 -> 149
    //   175: astore_0
    //   176: aload 4
    //   178: astore_0
    //   179: goto -25 -> 154
    //   182: astore_3
    //   183: goto -62 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramContext	Context
    //   83	9	1	i	int
    //   30	129	2	localInputStream	InputStream
    //   19	125	3	localObject1	Object
    //   182	1	3	localException	Exception
    //   16	1	4	localObject2	Object
    //   111	66	4	localObject3	Object
    //   38	26	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   72	78	111	finally
    //   78	84	111	finally
    //   88	95	111	finally
    //   31	72	124	finally
    //   20	31	128	finally
    //   20	31	171	java/lang/Exception
    //   31	72	175	java/lang/Exception
    //   72	78	182	java/lang/Exception
    //   78	84	182	java/lang/Exception
    //   88	95	182	java/lang/Exception
  }
  
  public static long k(Context paramContext)
  {
    try
    {
      paramContext = new StatFs(d(paramContext));
      long l = paramContext.getBlockSize();
      l = paramContext.getAvailableBlocks() * l / 1024L;
      return l;
    }
    catch (Exception paramContext)
    {
      label32:
      break label32;
    }
    return 0L;
  }
  
  private static String[] l(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    int k = 0;
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    for (;;)
    {
      int j;
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.getFilesDir());
        ((StringBuilder)localObject).append("/jni.ini");
        paramContext = new FileInputStream(((StringBuilder)localObject).toString());
        try
        {
          paramContext = new BufferedReader(new InputStreamReader(paramContext));
          int i = 0;
          localObject = paramContext.readLine();
          j = k;
          if (localObject != null)
          {
            j = k;
            if (i < 2)
            {
              arrayOfString[i] = localObject;
              i += 1;
              continue;
            }
          }
          if (j < arrayOfString.length)
          {
            if (arrayOfString[j] == null) {
              break label307;
            }
            arrayOfString[j].trim();
            if (arrayOfString[j].length() <= 4) {
              break label307;
            }
            arrayOfString[j] = arrayOfString[j].substring(4);
            break label307;
          }
          paramContext.close();
        }
        catch (IOException paramContext)
        {
          if (!QLog.isColorLevel()) {
            break label268;
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get oldJniID IOException ");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        QLog.d("MSF.C.CoreUtil", 2, ((StringBuilder)localObject).toString());
      }
      catch (IOException paramContext)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("get oldJniID FileNotFoundException ");
          ((StringBuilder)localObject).append(paramContext.getMessage());
          QLog.d("MSF.C.CoreUtil", 2, ((StringBuilder)localObject).toString());
        }
        paramContext.printStackTrace();
      }
      label268:
      paramContext = new StringBuilder();
      paramContext.append("get old jni id = ");
      paramContext.append(Arrays.toString(arrayOfString));
      QLog.d("MSF.C.CoreUtil", 1, paramContext.toString());
      return arrayOfString;
      label307:
      j += 1;
    }
  }
  
  private static String[] m(Context paramContext)
  {
    Object localObject1 = new String[2];
    for (;;)
    {
      Object localObject2;
      int i;
      int j;
      try
      {
        localObject2 = paramContext.getAssets().open("jni.ini");
        paramContext = (Context)localObject1;
        if (localObject2 == null) {
          continue;
        }
        paramContext = new BufferedReader(new InputStreamReader((InputStream)localObject2));
        i = 0;
        localObject2 = paramContext.readLine();
        if (localObject2 == null) {
          break label217;
        }
        j = 1;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("read jni error ");
        ((StringBuilder)localObject1).append(paramContext);
        QLog.d("MSF.C.CoreUtil", 2, ((StringBuilder)localObject1).toString());
        paramContext = new String[2];
        paramContext[0] = "0";
        paramContext[1] = "0";
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("get new jni id = ");
        ((StringBuilder)localObject1).append(Arrays.toString(paramContext));
        QLog.d("MSF.C.CoreUtil", 1, ((StringBuilder)localObject1).toString());
        return paramContext;
      }
      paramContext = (Context)localObject1;
      if (i < localObject1.length)
      {
        if (localObject1[i] != null)
        {
          localObject1[i].trim();
          if (localObject1[i].length() > 4) {
            localObject1[i] = localObject1[i].substring(4);
          }
        }
        i += 1;
      }
      else
      {
        label217:
        j = 0;
        int k;
        if (i < 2) {
          k = 1;
        } else {
          k = 0;
        }
        if ((j & k) != 0)
        {
          localObject1[i] = localObject2;
          i += 1;
        }
        else
        {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c
 * JD-Core Version:    0.7.0.1
 */