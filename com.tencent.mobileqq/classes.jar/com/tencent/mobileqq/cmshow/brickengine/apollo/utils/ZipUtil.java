package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil
{
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_1
    //   5: ifnull +431 -> 436
    //   8: aload_1
    //   9: ldc 17
    //   11: invokevirtual 23	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: new 25	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 28	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore 6
    //   29: new 30	com/tencent/commonsdk/zip/QZipInputStream
    //   32: dup
    //   33: new 32	java/io/BufferedInputStream
    //   36: dup
    //   37: aload 6
    //   39: invokespecial 35	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: invokespecial 36	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore 7
    //   47: aconst_null
    //   48: astore 4
    //   50: aload 7
    //   52: invokevirtual 40	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   55: astore_0
    //   56: aload_0
    //   57: ifnull +331 -> 388
    //   60: new 42	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   67: astore 5
    //   69: aload 5
    //   71: ldc 45
    //   73: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 5
    //   79: aload_0
    //   80: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: ldc 54
    //   86: aload 5
    //   88: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 63	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: aload_0
    //   96: invokevirtual 68	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   99: astore_0
    //   100: new 42	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   107: astore 5
    //   109: aload 5
    //   111: aload_1
    //   112: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 5
    //   118: getstatic 74	java/io/File:separator	Ljava/lang/String;
    //   121: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 5
    //   127: aload_0
    //   128: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 5
    //   134: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 5
    //   139: aload_0
    //   140: ifnull -93 -> 47
    //   143: aload_0
    //   144: ldc 17
    //   146: invokevirtual 23	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   149: ifne -102 -> 47
    //   152: aload 5
    //   154: ldc 17
    //   156: invokevirtual 23	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   159: ifeq +6 -> 165
    //   162: goto -115 -> 47
    //   165: new 42	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   172: astore 5
    //   174: aload 5
    //   176: aload_1
    //   177: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 5
    //   183: getstatic 74	java/io/File:separator	Ljava/lang/String;
    //   186: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 5
    //   192: aload_0
    //   193: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: new 70	java/io/File
    //   200: dup
    //   201: aload 5
    //   203: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: astore_0
    //   210: new 70	java/io/File
    //   213: dup
    //   214: aload_0
    //   215: invokevirtual 78	java/io/File:getParent	()Ljava/lang/String;
    //   218: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   221: astore 5
    //   223: aload 5
    //   225: invokevirtual 82	java/io/File:exists	()Z
    //   228: ifne +9 -> 237
    //   231: aload 5
    //   233: invokevirtual 85	java/io/File:mkdirs	()Z
    //   236: pop
    //   237: sipush 4096
    //   240: newarray byte
    //   242: astore 8
    //   244: new 87	java/io/FileOutputStream
    //   247: dup
    //   248: aload_0
    //   249: invokespecial 90	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   252: astore 5
    //   254: new 92	java/io/BufferedOutputStream
    //   257: dup
    //   258: aload 5
    //   260: sipush 4096
    //   263: invokespecial 95	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   266: astore_0
    //   267: aload 7
    //   269: aload 8
    //   271: iconst_0
    //   272: sipush 4096
    //   275: invokevirtual 99	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   278: istore_2
    //   279: iload_2
    //   280: iconst_m1
    //   281: if_icmpeq +14 -> 295
    //   284: aload_0
    //   285: aload 8
    //   287: iconst_0
    //   288: iload_2
    //   289: invokevirtual 103	java/io/BufferedOutputStream:write	([BII)V
    //   292: goto -25 -> 267
    //   295: aload_0
    //   296: invokevirtual 106	java/io/BufferedOutputStream:flush	()V
    //   299: aload_0
    //   300: invokevirtual 109	java/io/BufferedOutputStream:close	()V
    //   303: aload 5
    //   305: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   308: goto -261 -> 47
    //   311: astore 4
    //   313: aload_0
    //   314: astore_1
    //   315: aload 4
    //   317: astore_0
    //   318: goto +6 -> 324
    //   321: astore_0
    //   322: aconst_null
    //   323: astore_1
    //   324: aload 5
    //   326: astore 4
    //   328: goto +6 -> 334
    //   331: astore_0
    //   332: aconst_null
    //   333: astore_1
    //   334: aload 4
    //   336: ifnull +8 -> 344
    //   339: aload 4
    //   341: invokevirtual 110	java/io/FileOutputStream:close	()V
    //   344: aload_1
    //   345: ifnull +7 -> 352
    //   348: aload_1
    //   349: invokevirtual 109	java/io/BufferedOutputStream:close	()V
    //   352: aload_0
    //   353: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   356: ldc 115
    //   358: iconst_1
    //   359: aload_0
    //   360: invokevirtual 118	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   363: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: iconst_0
    //   367: istore_2
    //   368: goto +22 -> 390
    //   371: astore_0
    //   372: iload_3
    //   373: istore_2
    //   374: goto +52 -> 426
    //   377: astore_0
    //   378: ldc 115
    //   380: iconst_1
    //   381: aload_0
    //   382: invokevirtual 125	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   385: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: iconst_1
    //   389: istore_2
    //   390: aload 6
    //   392: invokevirtual 126	java/io/FileInputStream:close	()V
    //   395: aload 7
    //   397: invokevirtual 127	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   400: iload_2
    //   401: ireturn
    //   402: astore_0
    //   403: goto +23 -> 426
    //   406: astore_0
    //   407: aload_0
    //   408: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   411: ldc 115
    //   413: iconst_1
    //   414: aload_0
    //   415: invokevirtual 118	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   418: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: iconst_0
    //   422: ireturn
    //   423: astore_0
    //   424: iconst_1
    //   425: istore_2
    //   426: ldc 115
    //   428: iconst_1
    //   429: aload_0
    //   430: invokevirtual 125	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   433: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: iload_2
    //   437: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	paramString1	String
    //   0	438	1	paramString2	String
    //   1	436	2	i	int
    //   3	370	3	j	int
    //   48	1	4	localObject1	Object
    //   311	5	4	localException	Exception
    //   326	14	4	localObject2	Object
    //   67	258	5	localObject3	Object
    //   27	364	6	localFileInputStream	FileInputStream
    //   45	351	7	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    //   242	44	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   267	279	311	java/lang/Exception
    //   284	292	311	java/lang/Exception
    //   295	303	311	java/lang/Exception
    //   254	267	321	java/lang/Exception
    //   303	308	321	java/lang/Exception
    //   50	56	331	java/lang/Exception
    //   60	139	331	java/lang/Exception
    //   143	162	331	java/lang/Exception
    //   165	237	331	java/lang/Exception
    //   237	254	331	java/lang/Exception
    //   352	366	371	java/lang/OutOfMemoryError
    //   50	56	377	java/lang/OutOfMemoryError
    //   60	139	377	java/lang/OutOfMemoryError
    //   143	162	377	java/lang/OutOfMemoryError
    //   165	237	377	java/lang/OutOfMemoryError
    //   237	254	377	java/lang/OutOfMemoryError
    //   254	267	377	java/lang/OutOfMemoryError
    //   267	279	377	java/lang/OutOfMemoryError
    //   284	292	377	java/lang/OutOfMemoryError
    //   295	303	377	java/lang/OutOfMemoryError
    //   303	308	377	java/lang/OutOfMemoryError
    //   390	400	402	java/lang/OutOfMemoryError
    //   19	47	406	java/lang/Exception
    //   339	344	406	java/lang/Exception
    //   348	352	406	java/lang/Exception
    //   352	366	406	java/lang/Exception
    //   378	388	406	java/lang/Exception
    //   390	400	406	java/lang/Exception
    //   19	47	423	java/lang/OutOfMemoryError
    //   339	344	423	java/lang/OutOfMemoryError
    //   348	352	423	java/lang/OutOfMemoryError
    //   378	388	423	java/lang/OutOfMemoryError
  }
  
  private static void a(ZipOutputStream paramZipOutputStream, File paramFile, String paramString)
  {
    boolean bool = paramFile.isDirectory();
    int i = 0;
    Object localObject;
    if (bool)
    {
      if (paramString.equals(""))
      {
        paramString = paramFile.getName();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(paramFile.getName());
        paramString = ((StringBuilder)localObject).toString();
      }
      paramFile = paramFile.listFiles();
      int j = paramFile.length;
      while (i < j)
      {
        localObject = paramFile[i];
        if (localObject != null) {
          a(paramZipOutputStream, (File)localObject, paramString);
        }
        i += 1;
      }
    }
    byte[] arrayOfByte = new byte[4096];
    try
    {
      try
      {
        localObject = new BufferedInputStream(new FileInputStream(paramFile));
        try
        {
          if (paramString.equals(""))
          {
            paramFile = paramFile.getName();
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString);
            localStringBuilder.append(File.separator);
            localStringBuilder.append(paramFile.getName());
            paramFile = localStringBuilder.toString();
          }
          paramZipOutputStream.putNextEntry(new ZipEntry(paramFile));
          for (;;)
          {
            i = ((InputStream)localObject).read(arrayOfByte);
            if (i == -1) {
              break;
            }
            paramZipOutputStream.write(arrayOfByte, 0, i);
          }
          ((InputStream)localObject).close();
          return;
        }
        catch (Exception paramFile)
        {
          paramZipOutputStream = (ZipOutputStream)localObject;
        }
        if (paramZipOutputStream == null) {
          break label255;
        }
      }
      catch (Exception paramFile)
      {
        paramZipOutputStream = null;
      }
      paramZipOutputStream.close();
      label255:
      paramFile.printStackTrace();
      QLog.d("[cmshow]ZipUtil", 1, paramFile.getMessage());
      return;
    }
    catch (OutOfMemoryError paramZipOutputStream)
    {
      QLog.d("[cmshow]ZipUtil", 1, paramZipOutputStream.getMessage());
    }
  }
  
  /* Error */
  public static int b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_0
    //   10: istore_3
    //   11: new 148	java/util/zip/ZipOutputStream
    //   14: dup
    //   15: new 87	java/io/FileOutputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 161	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   23: invokespecial 164	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: astore_1
    //   27: new 70	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 82	java/io/File:exists	()Z
    //   40: ifeq +46 -> 86
    //   43: aload_0
    //   44: invokevirtual 131	java/io/File:isDirectory	()Z
    //   47: istore 5
    //   49: iload 5
    //   51: ifeq +28 -> 79
    //   54: aload_0
    //   55: invokevirtual 142	java/io/File:listFiles	()[Ljava/io/File;
    //   58: astore_0
    //   59: aload_0
    //   60: arraylength
    //   61: istore 4
    //   63: iconst_0
    //   64: istore_2
    //   65: goto +134 -> 199
    //   68: aload_1
    //   69: aload 6
    //   71: ldc 133
    //   73: invokestatic 144	com/tencent/mobileqq/cmshow/brickengine/apollo/utils/ZipUtil:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   76: goto +139 -> 215
    //   79: aload_1
    //   80: aload_0
    //   81: ldc 133
    //   83: invokestatic 144	com/tencent/mobileqq/cmshow/brickengine/apollo/utils/ZipUtil:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   86: aload_1
    //   87: invokevirtual 165	java/util/zip/ZipOutputStream:close	()V
    //   90: goto +132 -> 222
    //   93: astore_0
    //   94: goto +77 -> 171
    //   97: astore 6
    //   99: aload_1
    //   100: astore_0
    //   101: aload 6
    //   103: astore_1
    //   104: goto +24 -> 128
    //   107: astore 6
    //   109: aload_1
    //   110: astore_0
    //   111: aload 6
    //   113: astore_1
    //   114: goto +37 -> 151
    //   117: astore_0
    //   118: aload 6
    //   120: astore_1
    //   121: goto +50 -> 171
    //   124: astore_1
    //   125: aload 7
    //   127: astore_0
    //   128: aload_0
    //   129: astore 6
    //   131: aload_1
    //   132: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   135: aload_0
    //   136: invokevirtual 165	java/util/zip/ZipOutputStream:close	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_0
    //   142: iload_3
    //   143: istore_2
    //   144: goto +43 -> 187
    //   147: astore_1
    //   148: aload 8
    //   150: astore_0
    //   151: aload_0
    //   152: astore 6
    //   154: ldc 115
    //   156: iconst_1
    //   157: aload_1
    //   158: invokevirtual 125	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   161: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_0
    //   165: invokevirtual 165	java/util/zip/ZipOutputStream:close	()V
    //   168: goto +54 -> 222
    //   171: aload_1
    //   172: invokevirtual 165	java/util/zip/ZipOutputStream:close	()V
    //   175: aload_0
    //   176: athrow
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   182: iconst_0
    //   183: ireturn
    //   184: astore_0
    //   185: iconst_1
    //   186: istore_2
    //   187: ldc 115
    //   189: iconst_1
    //   190: aload_0
    //   191: invokevirtual 125	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   194: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: iload_2
    //   198: ireturn
    //   199: iload_2
    //   200: iload 4
    //   202: if_icmpge -116 -> 86
    //   205: aload_0
    //   206: iload_2
    //   207: aaload
    //   208: astore 6
    //   210: aload 6
    //   212: ifnonnull -144 -> 68
    //   215: iload_2
    //   216: iconst_1
    //   217: iadd
    //   218: istore_2
    //   219: goto -20 -> 199
    //   222: iconst_1
    //   223: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramString1	String
    //   0	224	1	paramString2	String
    //   64	155	2	i	int
    //   10	133	3	j	int
    //   61	142	4	k	int
    //   47	3	5	bool	boolean
    //   7	63	6	localFile	File
    //   97	5	6	localException	Exception
    //   107	12	6	localOutOfMemoryError	OutOfMemoryError
    //   129	82	6	str	String
    //   1	125	7	localObject1	Object
    //   4	145	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	49	93	finally
    //   54	63	93	finally
    //   68	76	93	finally
    //   79	86	93	finally
    //   27	49	97	java/lang/Exception
    //   54	63	97	java/lang/Exception
    //   68	76	97	java/lang/Exception
    //   79	86	97	java/lang/Exception
    //   27	49	107	java/lang/OutOfMemoryError
    //   54	63	107	java/lang/OutOfMemoryError
    //   68	76	107	java/lang/OutOfMemoryError
    //   79	86	107	java/lang/OutOfMemoryError
    //   11	27	117	finally
    //   131	135	117	finally
    //   154	164	117	finally
    //   11	27	124	java/lang/Exception
    //   135	139	141	java/lang/OutOfMemoryError
    //   11	27	147	java/lang/OutOfMemoryError
    //   86	90	177	java/lang/Exception
    //   135	139	177	java/lang/Exception
    //   164	168	177	java/lang/Exception
    //   171	177	177	java/lang/Exception
    //   86	90	184	java/lang/OutOfMemoryError
    //   164	168	184	java/lang/OutOfMemoryError
    //   171	177	184	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ZipUtil
 * JD-Core Version:    0.7.0.1
 */