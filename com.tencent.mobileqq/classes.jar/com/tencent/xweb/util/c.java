package com.tencent.xweb.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetFileDescriptor;
import java.io.Closeable;
import java.io.File;
import org.xwalk.core.Log;

public class c
{
  public static String a(Context paramContext)
  {
    if (paramContext == null)
    {
      Log.e("FileUtils", "getDataRootPath null == context");
      return "";
    }
    if (paramContext.getApplicationInfo() == null)
    {
      Log.e("FileUtils", "getDataRootPath null == getApplicationInfo()");
      return "";
    }
    String str = paramContext.getApplicationInfo().dataDir;
    Object localObject;
    if (str != null)
    {
      localObject = str;
      if (!str.isEmpty()) {}
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/data/data/");
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      localObject = ((StringBuilder)localObject).toString();
      Log.e("FileUtils", "getDataRootPath null == context.getApplicationInfo().dataDir");
    }
    return localObject;
  }
  
  public static void a(AssetFileDescriptor paramAssetFileDescriptor)
  {
    if (paramAssetFileDescriptor != null) {
      try
      {
        paramAssetFileDescriptor.close();
        return;
      }
      catch (Exception paramAssetFileDescriptor)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryClose AssetFileDescriptor error: ");
        localStringBuilder.append(paramAssetFileDescriptor.getMessage());
        Log.e("FileUtils", localStringBuilder.toString());
      }
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeable close  failed ");
      localStringBuilder.append(paramCloseable.getMessage());
      Log.e("FileUtils", localStringBuilder.toString());
    }
  }
  
  /* Error */
  public static boolean a(AssetFileDescriptor paramAssetFileDescriptor, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +246 -> 247
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: goto +239 -> 247
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore_3
    //   19: aconst_null
    //   20: astore 7
    //   22: aload_1
    //   23: invokevirtual 85	java/io/File:exists	()Z
    //   26: ifeq +8 -> 34
    //   29: aload_1
    //   30: invokevirtual 88	java/io/File:delete	()Z
    //   33: pop
    //   34: new 90	java/io/FileOutputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   42: astore 4
    //   44: aload 7
    //   46: astore_1
    //   47: aload 6
    //   49: astore_3
    //   50: aload_0
    //   51: invokevirtual 97	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   54: astore 5
    //   56: aload 5
    //   58: astore_1
    //   59: aload 5
    //   61: astore_3
    //   62: ldc 98
    //   64: newarray byte
    //   66: astore 6
    //   68: aload 5
    //   70: astore_1
    //   71: aload 5
    //   73: astore_3
    //   74: aload 5
    //   76: aload 6
    //   78: invokevirtual 104	java/io/FileInputStream:read	([B)I
    //   81: istore_2
    //   82: iload_2
    //   83: iconst_m1
    //   84: if_icmpeq +21 -> 105
    //   87: aload 5
    //   89: astore_1
    //   90: aload 5
    //   92: astore_3
    //   93: aload 4
    //   95: aload 6
    //   97: iconst_0
    //   98: iload_2
    //   99: invokevirtual 108	java/io/FileOutputStream:write	([BII)V
    //   102: goto -34 -> 68
    //   105: aload 5
    //   107: astore_1
    //   108: aload 5
    //   110: astore_3
    //   111: aload 4
    //   113: invokevirtual 111	java/io/FileOutputStream:flush	()V
    //   116: aload 4
    //   118: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   121: aload 5
    //   123: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   126: aload_0
    //   127: invokestatic 115	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   130: iconst_1
    //   131: ireturn
    //   132: astore 5
    //   134: aload_1
    //   135: astore_3
    //   136: aload 4
    //   138: astore_1
    //   139: aload 5
    //   141: astore 4
    //   143: goto +89 -> 232
    //   146: astore 5
    //   148: aload 4
    //   150: astore_1
    //   151: aload 5
    //   153: astore 4
    //   155: goto +23 -> 178
    //   158: astore 4
    //   160: aconst_null
    //   161: astore 5
    //   163: aload_3
    //   164: astore_1
    //   165: aload 5
    //   167: astore_3
    //   168: goto +64 -> 232
    //   171: astore 4
    //   173: aconst_null
    //   174: astore_3
    //   175: aload 5
    //   177: astore_1
    //   178: new 40	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   185: astore 5
    //   187: aload 5
    //   189: ldc 117
    //   191: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 5
    //   197: aload 4
    //   199: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   202: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: ldc 8
    //   208: aload 5
    //   210: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 16	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_1
    //   217: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   220: aload_3
    //   221: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   224: aload_0
    //   225: invokestatic 115	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   228: iconst_0
    //   229: ireturn
    //   230: astore 4
    //   232: aload_1
    //   233: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   236: aload_3
    //   237: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   240: aload_0
    //   241: invokestatic 115	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   244: aload 4
    //   246: athrow
    //   247: ldc 8
    //   249: ldc 119
    //   251: invokestatic 16	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: iconst_0
    //   255: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramAssetFileDescriptor	AssetFileDescriptor
    //   0	256	1	paramFile	File
    //   81	18	2	i	int
    //   18	219	3	localObject1	Object
    //   42	112	4	localObject2	Object
    //   158	1	4	localObject3	Object
    //   171	27	4	localException1	Exception
    //   230	15	4	localObject4	Object
    //   15	107	5	localFileInputStream	java.io.FileInputStream
    //   132	8	5	localObject5	Object
    //   146	6	5	localException2	Exception
    //   161	48	5	localStringBuilder	StringBuilder
    //   12	84	6	arrayOfByte	byte[]
    //   20	25	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   50	56	132	finally
    //   62	68	132	finally
    //   74	82	132	finally
    //   93	102	132	finally
    //   111	116	132	finally
    //   50	56	146	java/lang/Exception
    //   62	68	146	java/lang/Exception
    //   74	82	146	java/lang/Exception
    //   93	102	146	java/lang/Exception
    //   111	116	146	java/lang/Exception
    //   22	34	158	finally
    //   34	44	158	finally
    //   22	34	171	java/lang/Exception
    //   34	44	171	java/lang/Exception
    //   178	216	230	finally
  }
  
  public static boolean a(File paramFile)
  {
    try
    {
      b(paramFile);
      return true;
    }
    catch (Exception localException)
    {
      label6:
      break label6;
    }
    Log.i("FileUtils", String.format("safeDeleteAll all files.(%s)", new Object[] { paramFile.getAbsolutePath() }));
    return false;
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 8
    //   5: aconst_null
    //   6: astore 4
    //   8: new 100	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 137	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: astore 6
    //   18: new 139	java/io/BufferedInputStream
    //   21: dup
    //   22: aload 6
    //   24: invokespecial 142	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_0
    //   28: new 90	java/io/FileOutputStream
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   36: astore_1
    //   37: new 144	java/io/BufferedOutputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 147	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   45: astore 7
    //   47: sipush 5120
    //   50: newarray byte
    //   52: astore 4
    //   54: aload_0
    //   55: aload 4
    //   57: invokevirtual 148	java/io/BufferedInputStream:read	([B)I
    //   60: istore_2
    //   61: iload_2
    //   62: iconst_m1
    //   63: if_icmpeq +15 -> 78
    //   66: aload 7
    //   68: aload 4
    //   70: iconst_0
    //   71: iload_2
    //   72: invokevirtual 149	java/io/BufferedOutputStream:write	([BII)V
    //   75: goto -21 -> 54
    //   78: aload 7
    //   80: invokevirtual 150	java/io/BufferedOutputStream:flush	()V
    //   83: iconst_1
    //   84: istore_3
    //   85: aload_0
    //   86: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   89: aload 7
    //   91: astore_0
    //   92: aload_0
    //   93: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   96: aload 6
    //   98: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   101: aload_1
    //   102: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   105: iload_3
    //   106: ireturn
    //   107: astore 4
    //   109: aload_1
    //   110: astore 5
    //   112: aload 7
    //   114: astore_1
    //   115: goto +49 -> 164
    //   118: astore 5
    //   120: aload_0
    //   121: astore 4
    //   123: aload 7
    //   125: astore_0
    //   126: goto +119 -> 245
    //   129: astore 4
    //   131: aconst_null
    //   132: astore 7
    //   134: aload_1
    //   135: astore 5
    //   137: aload 7
    //   139: astore_1
    //   140: goto +24 -> 164
    //   143: astore 5
    //   145: aconst_null
    //   146: astore 7
    //   148: aload_0
    //   149: astore 4
    //   151: aload 7
    //   153: astore_0
    //   154: goto +91 -> 245
    //   157: astore 4
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: astore 5
    //   164: aload_0
    //   165: astore 7
    //   167: aload 4
    //   169: astore_0
    //   170: aload 7
    //   172: astore 4
    //   174: aload_1
    //   175: astore 7
    //   177: goto +125 -> 302
    //   180: astore 5
    //   182: aconst_null
    //   183: astore_1
    //   184: aload_0
    //   185: astore 4
    //   187: aload_1
    //   188: astore_0
    //   189: goto +56 -> 245
    //   192: astore_0
    //   193: aconst_null
    //   194: astore 7
    //   196: aload 7
    //   198: astore 5
    //   200: aload 8
    //   202: astore 4
    //   204: goto +98 -> 302
    //   207: astore 5
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_0
    //   212: astore_1
    //   213: goto +32 -> 245
    //   216: astore_0
    //   217: aconst_null
    //   218: astore 7
    //   220: aload 7
    //   222: astore 6
    //   224: aload 6
    //   226: astore 5
    //   228: aload 8
    //   230: astore 4
    //   232: goto +70 -> 302
    //   235: astore 5
    //   237: aconst_null
    //   238: astore_0
    //   239: aload_0
    //   240: astore 6
    //   242: aload 6
    //   244: astore_1
    //   245: new 40	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   252: astore 7
    //   254: aload 7
    //   256: ldc 152
    //   258: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 7
    //   264: aload 5
    //   266: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   269: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: ldc 8
    //   275: aload 7
    //   277: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 16	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload 4
    //   285: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   288: goto -196 -> 92
    //   291: astore 8
    //   293: aload_0
    //   294: astore 7
    //   296: aload_1
    //   297: astore 5
    //   299: aload 8
    //   301: astore_0
    //   302: aload 4
    //   304: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   307: aload 7
    //   309: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   312: aload 6
    //   314: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   317: aload 5
    //   319: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   322: goto +5 -> 327
    //   325: aload_0
    //   326: athrow
    //   327: goto -2 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	paramFile1	File
    //   0	330	1	paramFile2	File
    //   60	12	2	i	int
    //   1	105	3	bool	boolean
    //   6	63	4	arrayOfByte	byte[]
    //   107	1	4	localObject1	Object
    //   121	1	4	localFile1	File
    //   129	1	4	localObject2	Object
    //   149	1	4	localFile2	File
    //   157	11	4	localObject3	Object
    //   172	131	4	localObject4	Object
    //   110	1	5	localFile3	File
    //   118	1	5	localException1	Exception
    //   135	1	5	localFile4	File
    //   143	1	5	localException2	Exception
    //   162	1	5	localFile5	File
    //   180	1	5	localException3	Exception
    //   198	1	5	localObject5	Object
    //   207	1	5	localException4	Exception
    //   226	1	5	localObject6	Object
    //   235	30	5	localException5	Exception
    //   297	21	5	localFile6	File
    //   16	297	6	localObject7	Object
    //   45	263	7	localObject8	Object
    //   3	226	8	localObject9	Object
    //   291	9	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   47	54	107	finally
    //   54	61	107	finally
    //   66	75	107	finally
    //   78	83	107	finally
    //   47	54	118	java/lang/Exception
    //   54	61	118	java/lang/Exception
    //   66	75	118	java/lang/Exception
    //   78	83	118	java/lang/Exception
    //   37	47	129	finally
    //   37	47	143	java/lang/Exception
    //   28	37	157	finally
    //   28	37	180	java/lang/Exception
    //   18	28	192	finally
    //   18	28	207	java/lang/Exception
    //   8	18	216	finally
    //   8	18	235	java/lang/Exception
    //   245	283	291	finally
  }
  
  /* Error */
  public static boolean a(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +176 -> 177
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: goto +169 -> 177
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore 4
    //   17: aload 4
    //   19: astore_3
    //   20: aload_1
    //   21: invokevirtual 85	java/io/File:exists	()Z
    //   24: ifeq +11 -> 35
    //   27: aload 4
    //   29: astore_3
    //   30: aload_1
    //   31: invokevirtual 88	java/io/File:delete	()Z
    //   34: pop
    //   35: aload 4
    //   37: astore_3
    //   38: new 90	java/io/FileOutputStream
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   46: astore_1
    //   47: ldc 98
    //   49: newarray byte
    //   51: astore_3
    //   52: aload_0
    //   53: aload_3
    //   54: invokevirtual 156	java/io/InputStream:read	([B)I
    //   57: istore_2
    //   58: iload_2
    //   59: iconst_m1
    //   60: if_icmpeq +13 -> 73
    //   63: aload_1
    //   64: aload_3
    //   65: iconst_0
    //   66: iload_2
    //   67: invokevirtual 108	java/io/FileOutputStream:write	([BII)V
    //   70: goto -18 -> 52
    //   73: aload_1
    //   74: invokevirtual 111	java/io/FileOutputStream:flush	()V
    //   77: aload_1
    //   78: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   81: aload_0
    //   82: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore 4
    //   89: aload_1
    //   90: astore_3
    //   91: aload 4
    //   93: astore_1
    //   94: goto +73 -> 167
    //   97: astore 4
    //   99: goto +12 -> 111
    //   102: astore_1
    //   103: goto +64 -> 167
    //   106: astore 4
    //   108: aload 5
    //   110: astore_1
    //   111: aload_1
    //   112: astore_3
    //   113: new 40	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   120: astore 5
    //   122: aload_1
    //   123: astore_3
    //   124: aload 5
    //   126: ldc 158
    //   128: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_1
    //   133: astore_3
    //   134: aload 5
    //   136: aload 4
    //   138: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   141: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_1
    //   146: astore_3
    //   147: ldc 8
    //   149: aload 5
    //   151: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 16	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_1
    //   158: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   161: aload_0
    //   162: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   165: iconst_0
    //   166: ireturn
    //   167: aload_3
    //   168: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   171: aload_0
    //   172: invokestatic 113	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   175: aload_1
    //   176: athrow
    //   177: ldc 8
    //   179: ldc 160
    //   181: invokestatic 16	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: iconst_0
    //   185: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramInputStream	java.io.InputStream
    //   0	186	1	paramFile	File
    //   57	10	2	i	int
    //   19	149	3	localObject1	Object
    //   15	21	4	localObject2	Object
    //   87	5	4	localObject3	Object
    //   97	1	4	localException1	Exception
    //   106	31	4	localException2	Exception
    //   12	138	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   47	52	87	finally
    //   52	58	87	finally
    //   63	70	87	finally
    //   73	77	87	finally
    //   47	52	97	java/lang/Exception
    //   52	58	97	java/lang/Exception
    //   63	70	97	java/lang/Exception
    //   73	77	97	java/lang/Exception
    //   20	27	102	finally
    //   30	35	102	finally
    //   38	47	102	finally
    //   113	122	102	finally
    //   124	132	102	finally
    //   134	145	102	finally
    //   147	157	102	finally
    //   20	27	106	java/lang/Exception
    //   30	35	106	java/lang/Exception
    //   38	47	106	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isFile()))
    {
      paramString.delete();
      return true;
    }
    return false;
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_3
    //   11: new 100	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 171	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual 175	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   24: astore 5
    //   26: new 90	java/io/FileOutputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 176	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   34: astore 7
    //   36: aload 7
    //   38: invokevirtual 177	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   41: astore 6
    //   43: aload 6
    //   45: astore_3
    //   46: aload 6
    //   48: astore 4
    //   50: aload 6
    //   52: aload 5
    //   54: lconst_0
    //   55: aload 5
    //   57: invokevirtual 183	java/nio/channels/FileChannel:size	()J
    //   60: invokevirtual 187	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   63: pop2
    //   64: aload 6
    //   66: astore_3
    //   67: aload 6
    //   69: astore 4
    //   71: aload 6
    //   73: iconst_1
    //   74: invokevirtual 191	java/nio/channels/FileChannel:force	(Z)V
    //   77: aload_2
    //   78: invokevirtual 192	java/io/FileInputStream:close	()V
    //   81: aload 7
    //   83: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   86: aload 5
    //   88: ifnull +11 -> 99
    //   91: aload 5
    //   93: invokevirtual 194	java/nio/channels/FileChannel:close	()V
    //   96: goto +3 -> 99
    //   99: aload 6
    //   101: ifnull +8 -> 109
    //   104: aload 6
    //   106: invokevirtual 194	java/nio/channels/FileChannel:close	()V
    //   109: iconst_1
    //   110: ireturn
    //   111: astore_0
    //   112: aload_3
    //   113: astore_1
    //   114: aload 7
    //   116: astore 4
    //   118: goto +22 -> 140
    //   121: astore_3
    //   122: aload 4
    //   124: astore 6
    //   126: aload 7
    //   128: astore 4
    //   130: goto +25 -> 155
    //   133: astore_0
    //   134: aconst_null
    //   135: astore 4
    //   137: aload 4
    //   139: astore_1
    //   140: aload_2
    //   141: astore_3
    //   142: aload_1
    //   143: astore_2
    //   144: goto +176 -> 320
    //   147: astore_3
    //   148: aconst_null
    //   149: astore 4
    //   151: aload 4
    //   153: astore 6
    //   155: aload_2
    //   156: astore 7
    //   158: aload 6
    //   160: astore_2
    //   161: aload_3
    //   162: astore 6
    //   164: aload 7
    //   166: astore_3
    //   167: goto +64 -> 231
    //   170: astore_0
    //   171: aconst_null
    //   172: astore 4
    //   174: aload_2
    //   175: astore_3
    //   176: aload 4
    //   178: astore_2
    //   179: aload 6
    //   181: astore 5
    //   183: goto +137 -> 320
    //   186: astore 6
    //   188: aconst_null
    //   189: astore 4
    //   191: aload_2
    //   192: astore_3
    //   193: aload 4
    //   195: astore_2
    //   196: aload 7
    //   198: astore 5
    //   200: goto +31 -> 231
    //   203: astore_0
    //   204: aconst_null
    //   205: astore_2
    //   206: aload_2
    //   207: astore_3
    //   208: aload_3
    //   209: astore 4
    //   211: aload 6
    //   213: astore 5
    //   215: goto +105 -> 320
    //   218: astore 6
    //   220: aconst_null
    //   221: astore_2
    //   222: aload_2
    //   223: astore_3
    //   224: aload_3
    //   225: astore 4
    //   227: aload 7
    //   229: astore 5
    //   231: ldc 8
    //   233: ldc 196
    //   235: iconst_4
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload 6
    //   243: invokevirtual 200	java/lang/Object:getClass	()Ljava/lang/Class;
    //   246: invokevirtual 205	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   249: aastore
    //   250: dup
    //   251: iconst_1
    //   252: aload 6
    //   254: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   257: aastore
    //   258: dup
    //   259: iconst_2
    //   260: aload_0
    //   261: aastore
    //   262: dup
    //   263: iconst_3
    //   264: aload_1
    //   265: aastore
    //   266: invokestatic 132	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   269: invokestatic 16	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload_3
    //   273: ifnull +10 -> 283
    //   276: aload_3
    //   277: invokevirtual 192	java/io/FileInputStream:close	()V
    //   280: goto +3 -> 283
    //   283: aload 4
    //   285: ifnull +11 -> 296
    //   288: aload 4
    //   290: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   293: goto +3 -> 296
    //   296: aload 5
    //   298: ifnull +11 -> 309
    //   301: aload 5
    //   303: invokevirtual 194	java/nio/channels/FileChannel:close	()V
    //   306: goto +3 -> 309
    //   309: aload_2
    //   310: ifnull +7 -> 317
    //   313: aload_2
    //   314: invokevirtual 194	java/nio/channels/FileChannel:close	()V
    //   317: iconst_0
    //   318: ireturn
    //   319: astore_0
    //   320: aload_3
    //   321: ifnull +10 -> 331
    //   324: aload_3
    //   325: invokevirtual 192	java/io/FileInputStream:close	()V
    //   328: goto +3 -> 331
    //   331: aload 4
    //   333: ifnull +11 -> 344
    //   336: aload 4
    //   338: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   341: goto +3 -> 344
    //   344: aload 5
    //   346: ifnull +11 -> 357
    //   349: aload 5
    //   351: invokevirtual 194	java/nio/channels/FileChannel:close	()V
    //   354: goto +3 -> 357
    //   357: aload_2
    //   358: ifnull +7 -> 365
    //   361: aload_2
    //   362: invokevirtual 194	java/nio/channels/FileChannel:close	()V
    //   365: aload_0
    //   366: athrow
    //   367: astore_0
    //   368: goto -287 -> 81
    //   371: astore_0
    //   372: goto -286 -> 86
    //   375: astore_0
    //   376: goto -277 -> 99
    //   379: astore_0
    //   380: iconst_1
    //   381: ireturn
    //   382: astore_0
    //   383: goto -100 -> 283
    //   386: astore_0
    //   387: goto -91 -> 296
    //   390: astore_0
    //   391: goto -82 -> 309
    //   394: astore_0
    //   395: iconst_0
    //   396: ireturn
    //   397: astore_1
    //   398: goto -67 -> 331
    //   401: astore_1
    //   402: goto -58 -> 344
    //   405: astore_1
    //   406: goto -49 -> 357
    //   409: astore_1
    //   410: goto -45 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	paramString1	String
    //   0	413	1	paramString2	String
    //   19	343	2	localObject1	Object
    //   10	103	3	localObject2	Object
    //   121	1	3	localException1	Exception
    //   141	1	3	localObject3	Object
    //   147	15	3	localException2	Exception
    //   166	159	3	localObject4	Object
    //   1	336	4	localObject5	Object
    //   24	326	5	localObject6	Object
    //   7	173	6	localObject7	Object
    //   186	26	6	localException3	Exception
    //   218	35	6	localException4	Exception
    //   4	224	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   36	43	111	finally
    //   50	64	111	finally
    //   71	77	111	finally
    //   36	43	121	java/lang/Exception
    //   50	64	121	java/lang/Exception
    //   71	77	121	java/lang/Exception
    //   26	36	133	finally
    //   26	36	147	java/lang/Exception
    //   20	26	170	finally
    //   20	26	186	java/lang/Exception
    //   11	20	203	finally
    //   11	20	218	java/lang/Exception
    //   231	272	319	finally
    //   77	81	367	java/lang/Exception
    //   81	86	371	java/lang/Exception
    //   91	96	375	java/io/IOException
    //   104	109	379	java/io/IOException
    //   276	280	382	java/lang/Exception
    //   288	293	386	java/lang/Exception
    //   301	306	390	java/io/IOException
    //   313	317	394	java/io/IOException
    //   324	328	397	java/lang/Exception
    //   336	341	401	java/lang/Exception
    //   349	354	405	java/io/IOException
    //   361	365	409	java/io/IOException
  }
  
  public static void b(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return;
      }
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if ((arrayOfFile != null) && (arrayOfFile.length > 0))
        {
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            File localFile = arrayOfFile[i];
            if ((localFile != null) && (localFile.exists())) {
              if (localFile.isFile()) {
                localFile.delete();
              } else {
                b(localFile);
              }
            }
            i += 1;
          }
        }
        paramFile.delete();
      }
    }
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      b(new File(paramString));
      return true;
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    Log.i("FileUtils", String.format("delete all files.(%s)", new Object[] { paramString }));
    return false;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    File localFile = new File(paramString2);
    if ((!localFile.isDirectory()) || (!localFile.exists())) {
      localFile.mkdirs();
    }
    paramString1 = new File(paramString1).listFiles();
    if (paramString1 == null) {
      return false;
    }
    int i = 0;
    while (i < paramString1.length)
    {
      if (paramString1[i].isFile())
      {
        localFile = paramString1[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(new File(paramString2).getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramString1[i].getName());
        if (!a(localFile, new File(localStringBuilder.toString()))) {
          return false;
        }
      }
      paramString1[i].isDirectory();
      i += 1;
    }
    return true;
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    Object localObject1 = new File(paramString2);
    if ((!((File)localObject1).isDirectory()) || (!((File)localObject1).exists())) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = new File(paramString1).listFiles();
    if (localObject1 == null) {
      return false;
    }
    int i = 0;
    while (i < localObject1.length)
    {
      Object localObject2;
      StringBuilder localStringBuilder;
      if (localObject1[i].isFile())
      {
        localObject2 = localObject1[i];
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(new File(paramString2).getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append(localObject1[i].getName());
        if (!a((File)localObject2, new File(localStringBuilder.toString()))) {
          return false;
        }
      }
      if (localObject1[i].isDirectory())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(localObject1[i].getName());
        localObject2 = ((StringBuilder)localObject2).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("/");
        localStringBuilder.append(localObject1[i].getName());
        if (!c((String)localObject2, localStringBuilder.toString())) {
          return false;
        }
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.util.c
 * JD-Core Version:    0.7.0.1
 */