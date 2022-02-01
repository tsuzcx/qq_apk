package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MusicCacheManager
{
  private static long a = 157286400L;
  
  public static void a()
  {
    Object localObject1 = new File(AppConstants.SDCARD_MUSIC);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.isFile()) {
          localObject2.delete();
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public static void a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: new 44	java/io/RandomAccessFile
    //   8: dup
    //   9: aload_0
    //   10: ldc 46
    //   12: invokespecial 49	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 53	java/io/RandomAccessFile:readByte	()B
    //   20: istore_1
    //   21: aload_0
    //   22: lconst_0
    //   23: invokevirtual 57	java/io/RandomAccessFile:seek	(J)V
    //   26: aload_0
    //   27: iload_1
    //   28: invokevirtual 61	java/io/RandomAccessFile:write	(I)V
    //   31: aload_0
    //   32: invokevirtual 64	java/io/RandomAccessFile:close	()V
    //   35: return
    //   36: astore_3
    //   37: aload_0
    //   38: astore_2
    //   39: aload_3
    //   40: astore_0
    //   41: goto +30 -> 71
    //   44: astore_3
    //   45: goto +11 -> 56
    //   48: astore_0
    //   49: goto +22 -> 71
    //   52: astore_3
    //   53: aload 4
    //   55: astore_0
    //   56: aload_0
    //   57: astore_2
    //   58: aload_3
    //   59: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 64	java/io/RandomAccessFile:close	()V
    //   70: return
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 64	java/io/RandomAccessFile:close	()V
    //   79: aload_0
    //   80: athrow
    //   81: astore_0
    //   82: return
    //   83: astore_2
    //   84: goto -5 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramFile	File
    //   20	8	1	i	int
    //   4	72	2	localFile	File
    //   83	1	2	localIOException1	java.io.IOException
    //   36	4	3	localObject1	Object
    //   44	1	3	localIOException2	java.io.IOException
    //   52	7	3	localIOException3	java.io.IOException
    //   1	53	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	31	36	finally
    //   16	31	44	java/io/IOException
    //   5	16	48	finally
    //   58	62	48	finally
    //   5	16	52	java/io/IOException
    //   31	35	81	java/io/IOException
    //   66	70	81	java/io/IOException
    //   75	79	83	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_MUSIC);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".cfg");
    paramString = new File(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "delCfgFile");
    }
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  /* Error */
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 4
    //   11: astore_3
    //   12: new 16	java/io/File
    //   15: dup
    //   16: getstatic 22	com/tencent/mobileqq/app/AppConstants:SDCARD_MUSIC	Ljava/lang/String;
    //   19: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore 7
    //   24: aload 4
    //   26: astore_3
    //   27: aload 7
    //   29: invokevirtual 29	java/io/File:exists	()Z
    //   32: ifne +12 -> 44
    //   35: aload 4
    //   37: astore_3
    //   38: aload 7
    //   40: invokevirtual 101	java/io/File:mkdir	()Z
    //   43: pop
    //   44: aload 4
    //   46: astore_3
    //   47: new 69	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   54: astore 7
    //   56: aload 4
    //   58: astore_3
    //   59: aload 7
    //   61: getstatic 22	com/tencent/mobileqq/app/AppConstants:SDCARD_MUSIC	Ljava/lang/String;
    //   64: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 4
    //   70: astore_3
    //   71: aload 7
    //   73: aload_0
    //   74: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 4
    //   80: astore_3
    //   81: aload 7
    //   83: ldc 76
    //   85: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 4
    //   91: astore_3
    //   92: new 16	java/io/File
    //   95: dup
    //   96: aload 7
    //   98: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: astore_0
    //   105: aload 4
    //   107: astore_3
    //   108: aload_0
    //   109: invokevirtual 29	java/io/File:exists	()Z
    //   112: ifne +11 -> 123
    //   115: aload 4
    //   117: astore_3
    //   118: aload_0
    //   119: invokevirtual 104	java/io/File:createNewFile	()Z
    //   122: pop
    //   123: aload 4
    //   125: astore_3
    //   126: new 106	java/io/FileOutputStream
    //   129: dup
    //   130: aload_0
    //   131: iconst_0
    //   132: invokespecial 109	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   135: astore_0
    //   136: new 69	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   143: astore_3
    //   144: aload_3
    //   145: ldc 111
    //   147: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_3
    //   152: iload_1
    //   153: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_3
    //   158: ldc 116
    //   160: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_3
    //   165: iload_2
    //   166: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_3
    //   171: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: astore_3
    //   175: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +38 -> 216
    //   181: new 69	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   188: astore 4
    //   190: aload 4
    //   192: ldc 118
    //   194: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 4
    //   200: aload_3
    //   201: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 87
    //   207: iconst_2
    //   208: aload 4
    //   210: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload_0
    //   217: aload_3
    //   218: invokevirtual 124	java/lang/String:getBytes	()[B
    //   221: invokevirtual 129	java/io/OutputStream:write	([B)V
    //   224: aload_0
    //   225: invokevirtual 130	java/io/OutputStream:close	()V
    //   228: return
    //   229: astore_0
    //   230: new 69	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   237: astore_3
    //   238: goto +174 -> 412
    //   241: astore 4
    //   243: aload_0
    //   244: astore_3
    //   245: aload 4
    //   247: astore_0
    //   248: goto +192 -> 440
    //   251: astore 4
    //   253: goto +17 -> 270
    //   256: astore 4
    //   258: goto +87 -> 345
    //   261: astore_0
    //   262: goto +178 -> 440
    //   265: astore 4
    //   267: aload 5
    //   269: astore_0
    //   270: aload_0
    //   271: astore_3
    //   272: new 69	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   279: astore 5
    //   281: aload_0
    //   282: astore_3
    //   283: aload 5
    //   285: ldc 132
    //   287: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_0
    //   292: astore_3
    //   293: aload 5
    //   295: aload 4
    //   297: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   300: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_0
    //   305: astore_3
    //   306: ldc 87
    //   308: iconst_1
    //   309: aload 5
    //   311: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: aload 4
    //   316: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: aload_0
    //   320: ifnull +119 -> 439
    //   323: aload_0
    //   324: invokevirtual 130	java/io/OutputStream:close	()V
    //   327: return
    //   328: astore_0
    //   329: new 69	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   336: astore_3
    //   337: goto +75 -> 412
    //   340: astore 4
    //   342: aload 6
    //   344: astore_0
    //   345: aload_0
    //   346: astore_3
    //   347: new 69	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   354: astore 5
    //   356: aload_0
    //   357: astore_3
    //   358: aload 5
    //   360: ldc 141
    //   362: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_0
    //   367: astore_3
    //   368: aload 5
    //   370: aload 4
    //   372: invokevirtual 142	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   375: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_0
    //   380: astore_3
    //   381: ldc 87
    //   383: iconst_1
    //   384: aload 5
    //   386: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: aload 4
    //   391: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   394: aload_0
    //   395: ifnull +44 -> 439
    //   398: aload_0
    //   399: invokevirtual 130	java/io/OutputStream:close	()V
    //   402: return
    //   403: astore_0
    //   404: new 69	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   411: astore_3
    //   412: aload_3
    //   413: ldc 132
    //   415: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_3
    //   420: aload_0
    //   421: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   424: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: ldc 87
    //   430: iconst_1
    //   431: aload_3
    //   432: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: aload_0
    //   436: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   439: return
    //   440: aload_3
    //   441: ifnull +50 -> 491
    //   444: aload_3
    //   445: invokevirtual 130	java/io/OutputStream:close	()V
    //   448: goto +43 -> 491
    //   451: astore_3
    //   452: new 69	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   459: astore 4
    //   461: aload 4
    //   463: ldc 132
    //   465: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 4
    //   471: aload_3
    //   472: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   475: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: ldc 87
    //   481: iconst_1
    //   482: aload 4
    //   484: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: aload_3
    //   488: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   491: aload_0
    //   492: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	paramString	String
    //   0	493	1	paramInt1	int
    //   0	493	2	paramInt2	int
    //   11	434	3	localObject1	Object
    //   451	37	3	localException	Exception
    //   7	202	4	localStringBuilder1	StringBuilder
    //   241	5	4	localObject2	Object
    //   251	1	4	localIOException1	java.io.IOException
    //   256	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   265	50	4	localIOException2	java.io.IOException
    //   340	50	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   459	24	4	localStringBuilder2	StringBuilder
    //   1	384	5	localStringBuilder3	StringBuilder
    //   4	339	6	localObject3	Object
    //   22	75	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   224	228	229	java/lang/Exception
    //   136	216	241	finally
    //   216	224	241	finally
    //   136	216	251	java/io/IOException
    //   216	224	251	java/io/IOException
    //   136	216	256	java/io/FileNotFoundException
    //   216	224	256	java/io/FileNotFoundException
    //   12	24	261	finally
    //   27	35	261	finally
    //   38	44	261	finally
    //   47	56	261	finally
    //   59	68	261	finally
    //   71	78	261	finally
    //   81	89	261	finally
    //   92	105	261	finally
    //   108	115	261	finally
    //   118	123	261	finally
    //   126	136	261	finally
    //   272	281	261	finally
    //   283	291	261	finally
    //   293	304	261	finally
    //   306	319	261	finally
    //   347	356	261	finally
    //   358	366	261	finally
    //   368	379	261	finally
    //   381	394	261	finally
    //   12	24	265	java/io/IOException
    //   27	35	265	java/io/IOException
    //   38	44	265	java/io/IOException
    //   47	56	265	java/io/IOException
    //   59	68	265	java/io/IOException
    //   71	78	265	java/io/IOException
    //   81	89	265	java/io/IOException
    //   92	105	265	java/io/IOException
    //   108	115	265	java/io/IOException
    //   118	123	265	java/io/IOException
    //   126	136	265	java/io/IOException
    //   323	327	328	java/lang/Exception
    //   12	24	340	java/io/FileNotFoundException
    //   27	35	340	java/io/FileNotFoundException
    //   38	44	340	java/io/FileNotFoundException
    //   47	56	340	java/io/FileNotFoundException
    //   59	68	340	java/io/FileNotFoundException
    //   71	78	340	java/io/FileNotFoundException
    //   81	89	340	java/io/FileNotFoundException
    //   92	105	340	java/io/FileNotFoundException
    //   108	115	340	java/io/FileNotFoundException
    //   118	123	340	java/io/FileNotFoundException
    //   126	136	340	java/io/FileNotFoundException
    //   398	402	403	java/lang/Exception
    //   444	448	451	java/lang/Exception
  }
  
  private static boolean a(File paramFile)
  {
    if (!paramFile.getName().endsWith(".cfg"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(".cfg");
      new File(localStringBuilder.toString()).delete();
    }
    return paramFile.delete();
  }
  
  /* Error */
  public static boolean a(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: new 69	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: getstatic 22	com/tencent/mobileqq/app/AppConstants:SDCARD_MUSIC	Ljava/lang/String;
    //   14: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 4
    //   20: aload_0
    //   21: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 4
    //   27: ldc 76
    //   29: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: new 16	java/io/File
    //   36: dup
    //   37: aload 4
    //   39: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 7
    //   47: aload 7
    //   49: invokevirtual 29	java/io/File:exists	()Z
    //   52: ifne +5 -> 57
    //   55: iconst_1
    //   56: ireturn
    //   57: new 157	java/io/FileInputStream
    //   60: dup
    //   61: aload 7
    //   63: invokespecial 159	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   66: astore_0
    //   67: sipush 4096
    //   70: newarray byte
    //   72: astore 8
    //   74: new 161	java/io/ByteArrayOutputStream
    //   77: dup
    //   78: invokespecial 162	java/io/ByteArrayOutputStream:<init>	()V
    //   81: astore 6
    //   83: aload_0
    //   84: astore 4
    //   86: aload 6
    //   88: astore 5
    //   90: aload_0
    //   91: aload 8
    //   93: invokevirtual 168	java/io/InputStream:read	([B)I
    //   96: istore_2
    //   97: iload_2
    //   98: iconst_m1
    //   99: if_icmpeq +22 -> 121
    //   102: aload_0
    //   103: astore 4
    //   105: aload 6
    //   107: astore 5
    //   109: aload 6
    //   111: aload 8
    //   113: iconst_0
    //   114: iload_2
    //   115: invokevirtual 171	java/io/ByteArrayOutputStream:write	([BII)V
    //   118: goto -35 -> 83
    //   121: aload_0
    //   122: astore 4
    //   124: aload 6
    //   126: astore 5
    //   128: aload 6
    //   130: invokevirtual 172	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   133: ldc 174
    //   135: invokevirtual 178	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   138: astore 8
    //   140: aload 8
    //   142: ifnull +247 -> 389
    //   145: aload_0
    //   146: astore 4
    //   148: aload 6
    //   150: astore 5
    //   152: aload 8
    //   154: arraylength
    //   155: iconst_4
    //   156: if_icmpge +6 -> 162
    //   159: goto +230 -> 389
    //   162: aload_0
    //   163: astore 4
    //   165: aload 6
    //   167: astore 5
    //   169: aload 8
    //   171: iconst_1
    //   172: aaload
    //   173: invokestatic 184	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   176: istore_2
    //   177: aload_0
    //   178: astore 4
    //   180: aload 6
    //   182: astore 5
    //   184: aload 8
    //   186: iconst_3
    //   187: aaload
    //   188: invokestatic 184	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   191: istore_3
    //   192: iload_2
    //   193: iload_3
    //   194: if_icmpne +95 -> 289
    //   197: aload 6
    //   199: invokevirtual 185	java/io/ByteArrayOutputStream:close	()V
    //   202: goto +43 -> 245
    //   205: astore_1
    //   206: new 69	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   213: astore 4
    //   215: aload 4
    //   217: ldc 187
    //   219: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 4
    //   225: aload_1
    //   226: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   229: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: ldc 87
    //   235: iconst_1
    //   236: aload 4
    //   238: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: aload_1
    //   242: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   245: aload_0
    //   246: invokevirtual 188	java/io/InputStream:close	()V
    //   249: iconst_1
    //   250: ireturn
    //   251: astore_0
    //   252: new 69	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   259: astore_1
    //   260: aload_1
    //   261: ldc 187
    //   263: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: aload_0
    //   269: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   272: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: ldc 87
    //   278: iconst_1
    //   279: aload_1
    //   280: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: aload_0
    //   284: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   287: iconst_1
    //   288: ireturn
    //   289: aload_1
    //   290: iconst_0
    //   291: iload_2
    //   292: iastore
    //   293: aload_1
    //   294: iconst_1
    //   295: iload_3
    //   296: iastore
    //   297: aload 6
    //   299: invokevirtual 185	java/io/ByteArrayOutputStream:close	()V
    //   302: goto +43 -> 345
    //   305: astore_1
    //   306: new 69	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   313: astore 4
    //   315: aload 4
    //   317: ldc 187
    //   319: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 4
    //   325: aload_1
    //   326: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   329: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: ldc 87
    //   335: iconst_1
    //   336: aload 4
    //   338: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: aload_1
    //   342: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   345: aload_0
    //   346: invokevirtual 188	java/io/InputStream:close	()V
    //   349: iconst_0
    //   350: ireturn
    //   351: astore_0
    //   352: new 69	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   359: astore_1
    //   360: aload_1
    //   361: ldc 187
    //   363: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload_1
    //   368: aload_0
    //   369: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   372: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: ldc 87
    //   378: iconst_1
    //   379: aload_1
    //   380: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: aload_0
    //   384: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   387: iconst_0
    //   388: ireturn
    //   389: aload_0
    //   390: astore 4
    //   392: aload 6
    //   394: astore 5
    //   396: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq +18 -> 417
    //   402: aload_0
    //   403: astore 4
    //   405: aload 6
    //   407: astore 5
    //   409: ldc 87
    //   411: iconst_2
    //   412: ldc 190
    //   414: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload_1
    //   418: iconst_0
    //   419: iconst_0
    //   420: iastore
    //   421: aload_1
    //   422: iconst_1
    //   423: iconst_0
    //   424: iastore
    //   425: aload 6
    //   427: invokevirtual 185	java/io/ByteArrayOutputStream:close	()V
    //   430: goto +43 -> 473
    //   433: astore_1
    //   434: new 69	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   441: astore 4
    //   443: aload 4
    //   445: ldc 187
    //   447: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload 4
    //   453: aload_1
    //   454: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   457: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: ldc 87
    //   463: iconst_1
    //   464: aload 4
    //   466: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: aload_1
    //   470: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   473: aload_0
    //   474: invokevirtual 188	java/io/InputStream:close	()V
    //   477: iconst_0
    //   478: ireturn
    //   479: astore_0
    //   480: new 69	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   487: astore_1
    //   488: aload_1
    //   489: ldc 187
    //   491: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload_1
    //   496: aload_0
    //   497: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   500: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: ldc 87
    //   506: iconst_1
    //   507: aload_1
    //   508: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: aload_0
    //   512: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   515: iconst_0
    //   516: ireturn
    //   517: astore_1
    //   518: goto +39 -> 557
    //   521: astore_1
    //   522: goto +222 -> 744
    //   525: astore_1
    //   526: goto +14 -> 540
    //   529: astore_1
    //   530: goto +24 -> 554
    //   533: astore_1
    //   534: goto +207 -> 741
    //   537: astore_1
    //   538: aconst_null
    //   539: astore_0
    //   540: aconst_null
    //   541: astore 5
    //   543: aload_0
    //   544: astore 4
    //   546: aload_1
    //   547: astore_0
    //   548: goto +365 -> 913
    //   551: astore_1
    //   552: aconst_null
    //   553: astore_0
    //   554: aconst_null
    //   555: astore 6
    //   557: aload_0
    //   558: astore 4
    //   560: aload 6
    //   562: astore 5
    //   564: new 69	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   571: astore 8
    //   573: aload_0
    //   574: astore 4
    //   576: aload 6
    //   578: astore 5
    //   580: aload 8
    //   582: ldc 187
    //   584: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload_0
    //   589: astore 4
    //   591: aload 6
    //   593: astore 5
    //   595: aload 8
    //   597: aload_1
    //   598: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   601: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload_0
    //   606: astore 4
    //   608: aload 6
    //   610: astore 5
    //   612: ldc 87
    //   614: iconst_1
    //   615: aload 8
    //   617: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: aload_1
    //   621: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   624: aload_0
    //   625: astore 4
    //   627: aload 6
    //   629: astore 5
    //   631: aload 7
    //   633: invokevirtual 39	java/io/File:delete	()Z
    //   636: pop
    //   637: aload 6
    //   639: ifnull +51 -> 690
    //   642: aload 6
    //   644: invokevirtual 185	java/io/ByteArrayOutputStream:close	()V
    //   647: goto +43 -> 690
    //   650: astore_1
    //   651: new 69	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   658: astore 4
    //   660: aload 4
    //   662: ldc 187
    //   664: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 4
    //   670: aload_1
    //   671: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   674: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: ldc 87
    //   680: iconst_1
    //   681: aload 4
    //   683: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: aload_1
    //   687: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   690: aload_0
    //   691: ifnull +45 -> 736
    //   694: aload_0
    //   695: invokevirtual 188	java/io/InputStream:close	()V
    //   698: iconst_0
    //   699: ireturn
    //   700: astore_0
    //   701: new 69	java/lang/StringBuilder
    //   704: dup
    //   705: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   708: astore_1
    //   709: aload_1
    //   710: ldc 187
    //   712: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload_1
    //   717: aload_0
    //   718: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   721: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: pop
    //   725: ldc 87
    //   727: iconst_1
    //   728: aload_1
    //   729: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: aload_0
    //   733: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   736: iconst_0
    //   737: ireturn
    //   738: astore_1
    //   739: aconst_null
    //   740: astore_0
    //   741: aconst_null
    //   742: astore 6
    //   744: aload_0
    //   745: astore 4
    //   747: aload 6
    //   749: astore 5
    //   751: new 69	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   758: astore 7
    //   760: aload_0
    //   761: astore 4
    //   763: aload 6
    //   765: astore 5
    //   767: aload 7
    //   769: ldc 192
    //   771: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: aload_0
    //   776: astore 4
    //   778: aload 6
    //   780: astore 5
    //   782: aload 7
    //   784: aload_1
    //   785: invokevirtual 142	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   788: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: pop
    //   792: aload_0
    //   793: astore 4
    //   795: aload 6
    //   797: astore 5
    //   799: ldc 87
    //   801: iconst_1
    //   802: aload 7
    //   804: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: aload_1
    //   808: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   811: aload 6
    //   813: ifnull +51 -> 864
    //   816: aload 6
    //   818: invokevirtual 185	java/io/ByteArrayOutputStream:close	()V
    //   821: goto +43 -> 864
    //   824: astore_1
    //   825: new 69	java/lang/StringBuilder
    //   828: dup
    //   829: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   832: astore 4
    //   834: aload 4
    //   836: ldc 187
    //   838: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload 4
    //   844: aload_1
    //   845: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   848: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: ldc 87
    //   854: iconst_1
    //   855: aload 4
    //   857: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: aload_1
    //   861: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   864: aload_0
    //   865: ifnull +45 -> 910
    //   868: aload_0
    //   869: invokevirtual 188	java/io/InputStream:close	()V
    //   872: iconst_0
    //   873: ireturn
    //   874: astore_0
    //   875: new 69	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   882: astore_1
    //   883: aload_1
    //   884: ldc 187
    //   886: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload_1
    //   891: aload_0
    //   892: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   895: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: ldc 87
    //   901: iconst_1
    //   902: aload_1
    //   903: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: aload_0
    //   907: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   910: iconst_0
    //   911: ireturn
    //   912: astore_0
    //   913: aload 5
    //   915: ifnull +51 -> 966
    //   918: aload 5
    //   920: invokevirtual 185	java/io/ByteArrayOutputStream:close	()V
    //   923: goto +43 -> 966
    //   926: astore_1
    //   927: new 69	java/lang/StringBuilder
    //   930: dup
    //   931: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   934: astore 5
    //   936: aload 5
    //   938: ldc 187
    //   940: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: pop
    //   944: aload 5
    //   946: aload_1
    //   947: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   950: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: pop
    //   954: ldc 87
    //   956: iconst_1
    //   957: aload 5
    //   959: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   962: aload_1
    //   963: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   966: aload 4
    //   968: ifnull +51 -> 1019
    //   971: aload 4
    //   973: invokevirtual 188	java/io/InputStream:close	()V
    //   976: goto +43 -> 1019
    //   979: astore_1
    //   980: new 69	java/lang/StringBuilder
    //   983: dup
    //   984: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   987: astore 4
    //   989: aload 4
    //   991: ldc 187
    //   993: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload 4
    //   999: aload_1
    //   1000: invokevirtual 135	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1003: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: pop
    //   1007: ldc 87
    //   1009: iconst_1
    //   1010: aload 4
    //   1012: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1015: aload_1
    //   1016: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1019: goto +5 -> 1024
    //   1022: aload_0
    //   1023: athrow
    //   1024: goto -2 -> 1022
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1027	0	paramString	String
    //   0	1027	1	paramArrayOfInt	int[]
    //   96	196	2	i	int
    //   191	105	3	j	int
    //   7	1004	4	localObject1	Object
    //   88	870	5	localObject2	Object
    //   81	736	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   45	758	7	localObject3	Object
    //   72	544	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   197	202	205	java/io/IOException
    //   245	249	251	java/io/IOException
    //   297	302	305	java/io/IOException
    //   345	349	351	java/io/IOException
    //   425	430	433	java/io/IOException
    //   473	477	479	java/io/IOException
    //   90	97	517	java/io/IOException
    //   109	118	517	java/io/IOException
    //   128	140	517	java/io/IOException
    //   152	159	517	java/io/IOException
    //   169	177	517	java/io/IOException
    //   184	192	517	java/io/IOException
    //   396	402	517	java/io/IOException
    //   409	417	517	java/io/IOException
    //   90	97	521	java/io/FileNotFoundException
    //   109	118	521	java/io/FileNotFoundException
    //   128	140	521	java/io/FileNotFoundException
    //   152	159	521	java/io/FileNotFoundException
    //   169	177	521	java/io/FileNotFoundException
    //   184	192	521	java/io/FileNotFoundException
    //   396	402	521	java/io/FileNotFoundException
    //   409	417	521	java/io/FileNotFoundException
    //   67	83	525	finally
    //   67	83	529	java/io/IOException
    //   67	83	533	java/io/FileNotFoundException
    //   57	67	537	finally
    //   57	67	551	java/io/IOException
    //   642	647	650	java/io/IOException
    //   694	698	700	java/io/IOException
    //   57	67	738	java/io/FileNotFoundException
    //   816	821	824	java/io/IOException
    //   868	872	874	java/io/IOException
    //   90	97	912	finally
    //   109	118	912	finally
    //   128	140	912	finally
    //   152	159	912	finally
    //   169	177	912	finally
    //   184	192	912	finally
    //   396	402	912	finally
    //   409	417	912	finally
    //   564	573	912	finally
    //   580	588	912	finally
    //   595	605	912	finally
    //   612	624	912	finally
    //   631	637	912	finally
    //   751	760	912	finally
    //   767	775	912	finally
    //   782	792	912	finally
    //   799	811	912	finally
    //   918	923	926	java/io/IOException
    //   971	976	979	java/io/IOException
  }
  
  public static void b()
  {
    Object localObject1 = new File(AppConstants.SDCARD_MUSIC);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).add(5, -15);
    int i = 0;
    ((Calendar)localObject2).set(11, 0);
    ((Calendar)localObject2).set(12, 0);
    ((Calendar)localObject2).set(13, 0);
    ((Calendar)localObject2).set(14, 0);
    long l3 = ((Calendar)localObject2).getTimeInMillis();
    if (((File)localObject1).exists())
    {
      localObject2 = ((File)localObject1).listFiles();
      if (localObject2 == null) {
        return;
      }
      localObject1 = new TreeMap();
      int j = localObject2.length;
      File localFile;
      for (l1 = 0L;; l1 = l2)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        localFile = localObject2[i];
        l2 = l1;
        if (localFile.isFile()) {}
        try
        {
          if (localFile.lastModified() < l3)
          {
            a(localFile);
            l2 = l1;
          }
          else
          {
            ((TreeMap)localObject1).put(Long.valueOf(localFile.lastModified()), localFile);
            l2 = localFile.length();
            l2 = l1 + l2;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            l2 = l1;
          }
        }
        i += 1;
      }
      if (l2 > a)
      {
        localObject2 = ((TreeMap)localObject1).entrySet().iterator();
        l1 = l2;
        for (;;)
        {
          l2 = l1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localFile = (File)((Map.Entry)((Iterator)localObject2).next()).getValue();
          l2 = localFile.length();
          if (a(localFile)) {
            l1 -= l2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MusicCacheManager
 * JD-Core Version:    0.7.0.1
 */