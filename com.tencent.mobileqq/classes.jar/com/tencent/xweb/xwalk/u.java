package com.tencent.xweb.xwalk;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class u
{
  private static String a(String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    if (paramString.endsWith("/")) {
      return paramString;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append('/');
    return ((StringBuilder)localObject).toString();
  }
  
  private static void a(ZipOutputStream paramZipOutputStream, File paramFile, String paramString)
  {
    boolean bool = paramFile.isDirectory();
    int i = 0;
    if (bool)
    {
      localObject1 = paramFile.listFiles();
      int j = localObject1.length;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null) {
          if (((File)localObject2).isDirectory())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramFile.getName());
            localStringBuilder.append(File.separator);
            localStringBuilder.append(((File)localObject2).getName());
            localStringBuilder.append(File.separator);
            a(paramZipOutputStream, (File)localObject2, localStringBuilder.toString());
          }
          else
          {
            a(paramZipOutputStream, (File)localObject2, paramString);
          }
        }
        i += 1;
      }
    }
    Object localObject1 = new byte[2048];
    Object localObject2 = new BufferedInputStream(new FileInputStream(paramFile));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramFile.getName());
    paramZipOutputStream.putNextEntry(new ZipEntry(localStringBuilder.toString()));
    for (;;)
    {
      i = ((InputStream)localObject2).read((byte[])localObject1);
      if (i == -1) {
        break;
      }
      paramZipOutputStream.write((byte[])localObject1, 0, i);
    }
    ((InputStream)localObject2).close();
  }
  
  /* Error */
  public static boolean a(File paramFile, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 6
    //   11: new 76	java/util/zip/ZipOutputStream
    //   14: dup
    //   15: new 100	java/io/BufferedOutputStream
    //   18: dup
    //   19: new 102	java/io/FileOutputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 103	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 106	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: invokespecial 107	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   33: astore_1
    //   34: iload 4
    //   36: istore_3
    //   37: aload_1
    //   38: iconst_0
    //   39: invokevirtual 111	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   42: aload_0
    //   43: ifnull +217 -> 260
    //   46: iload 4
    //   48: istore_3
    //   49: aload_0
    //   50: invokevirtual 16	java/io/File:exists	()Z
    //   53: ifne +6 -> 59
    //   56: goto +204 -> 260
    //   59: iload 4
    //   61: istore_3
    //   62: aload_0
    //   63: invokevirtual 48	java/io/File:isDirectory	()Z
    //   66: istore 5
    //   68: iload 5
    //   70: ifeq +20 -> 90
    //   73: aload_1
    //   74: invokevirtual 114	java/util/zip/ZipOutputStream:closeEntry	()V
    //   77: aload_1
    //   78: invokevirtual 115	java/util/zip/ZipOutputStream:close	()V
    //   81: iconst_0
    //   82: ireturn
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   88: iconst_0
    //   89: ireturn
    //   90: iload 4
    //   92: istore_3
    //   93: sipush 2048
    //   96: newarray byte
    //   98: astore 6
    //   100: iload 4
    //   102: istore_3
    //   103: new 63	java/io/BufferedInputStream
    //   106: dup
    //   107: new 65	java/io/FileInputStream
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 68	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   115: invokespecial 71	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   118: astore 7
    //   120: iload 4
    //   122: istore_3
    //   123: new 73	java/util/zip/ZipEntry
    //   126: dup
    //   127: aload_0
    //   128: invokevirtual 55	java/io/File:getName	()Ljava/lang/String;
    //   131: invokespecial 74	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   134: astore 8
    //   136: iload 4
    //   138: istore_3
    //   139: aload 8
    //   141: iload_2
    //   142: invokevirtual 121	java/util/zip/ZipEntry:setMethod	(I)V
    //   145: iload 4
    //   147: istore_3
    //   148: aload 8
    //   150: aload_0
    //   151: invokevirtual 125	java/io/File:length	()J
    //   154: invokevirtual 129	java/util/zip/ZipEntry:setCompressedSize	(J)V
    //   157: iload 4
    //   159: istore_3
    //   160: aload 8
    //   162: aload_0
    //   163: invokevirtual 125	java/io/File:length	()J
    //   166: invokevirtual 132	java/util/zip/ZipEntry:setSize	(J)V
    //   169: iload 4
    //   171: istore_3
    //   172: aload_1
    //   173: new 73	java/util/zip/ZipEntry
    //   176: dup
    //   177: aload_0
    //   178: invokevirtual 55	java/io/File:getName	()Ljava/lang/String;
    //   181: invokespecial 74	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   184: invokevirtual 80	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   187: iload 4
    //   189: istore_3
    //   190: aload 7
    //   192: aload 6
    //   194: invokevirtual 86	java/io/InputStream:read	([B)I
    //   197: istore_2
    //   198: iload_2
    //   199: iconst_m1
    //   200: if_icmpeq +17 -> 217
    //   203: iload 4
    //   205: istore_3
    //   206: aload_1
    //   207: aload 6
    //   209: iconst_0
    //   210: iload_2
    //   211: invokevirtual 90	java/util/zip/ZipOutputStream:write	([BII)V
    //   214: goto -27 -> 187
    //   217: iload 4
    //   219: istore_3
    //   220: aload 7
    //   222: invokevirtual 93	java/io/InputStream:close	()V
    //   225: iconst_1
    //   226: istore_3
    //   227: iconst_1
    //   228: istore 5
    //   230: aload_1
    //   231: invokevirtual 135	java/util/zip/ZipOutputStream:flush	()V
    //   234: iload 5
    //   236: istore 4
    //   238: aload_1
    //   239: invokevirtual 114	java/util/zip/ZipOutputStream:closeEntry	()V
    //   242: iload 5
    //   244: istore 4
    //   246: aload_1
    //   247: invokevirtual 115	java/util/zip/ZipOutputStream:close	()V
    //   250: iconst_1
    //   251: ireturn
    //   252: astore_0
    //   253: aload_0
    //   254: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   257: iload 4
    //   259: ireturn
    //   260: aload_1
    //   261: invokevirtual 114	java/util/zip/ZipOutputStream:closeEntry	()V
    //   264: aload_1
    //   265: invokevirtual 115	java/util/zip/ZipOutputStream:close	()V
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_0
    //   271: aload_0
    //   272: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   275: iconst_0
    //   276: ireturn
    //   277: astore_0
    //   278: goto +51 -> 329
    //   281: astore 6
    //   283: aload_1
    //   284: astore_0
    //   285: aload 6
    //   287: astore_1
    //   288: goto +14 -> 302
    //   291: astore_0
    //   292: aload 6
    //   294: astore_1
    //   295: goto +34 -> 329
    //   298: astore_1
    //   299: aload 7
    //   301: astore_0
    //   302: aload_0
    //   303: astore 6
    //   305: aload_1
    //   306: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   309: aload_0
    //   310: ifnull +17 -> 327
    //   313: iload_3
    //   314: istore 4
    //   316: aload_0
    //   317: invokevirtual 114	java/util/zip/ZipOutputStream:closeEntry	()V
    //   320: iload_3
    //   321: istore 4
    //   323: aload_0
    //   324: invokevirtual 115	java/util/zip/ZipOutputStream:close	()V
    //   327: iload_3
    //   328: ireturn
    //   329: aload_1
    //   330: ifnull +19 -> 349
    //   333: aload_1
    //   334: invokevirtual 114	java/util/zip/ZipOutputStream:closeEntry	()V
    //   337: aload_1
    //   338: invokevirtual 115	java/util/zip/ZipOutputStream:close	()V
    //   341: goto +8 -> 349
    //   344: astore_1
    //   345: aload_1
    //   346: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   349: goto +5 -> 354
    //   352: aload_0
    //   353: athrow
    //   354: goto -2 -> 352
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	paramFile	File
    //   0	357	1	paramString	String
    //   0	357	2	paramInt	int
    //   1	327	3	bool1	boolean
    //   3	319	4	bool2	boolean
    //   66	177	5	bool3	boolean
    //   9	199	6	arrayOfByte	byte[]
    //   281	12	6	localException	java.lang.Exception
    //   303	1	6	localFile	File
    //   6	294	7	localBufferedInputStream	BufferedInputStream
    //   134	27	8	localZipEntry	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   73	81	83	java/io/IOException
    //   238	242	252	java/io/IOException
    //   246	250	252	java/io/IOException
    //   316	320	252	java/io/IOException
    //   323	327	252	java/io/IOException
    //   260	268	270	java/io/IOException
    //   37	42	277	finally
    //   49	56	277	finally
    //   62	68	277	finally
    //   93	100	277	finally
    //   103	120	277	finally
    //   123	136	277	finally
    //   139	145	277	finally
    //   148	157	277	finally
    //   160	169	277	finally
    //   172	187	277	finally
    //   190	198	277	finally
    //   206	214	277	finally
    //   220	225	277	finally
    //   230	234	277	finally
    //   37	42	281	java/lang/Exception
    //   49	56	281	java/lang/Exception
    //   62	68	281	java/lang/Exception
    //   93	100	281	java/lang/Exception
    //   103	120	281	java/lang/Exception
    //   123	136	281	java/lang/Exception
    //   139	145	281	java/lang/Exception
    //   148	157	281	java/lang/Exception
    //   160	169	281	java/lang/Exception
    //   172	187	281	java/lang/Exception
    //   190	198	281	java/lang/Exception
    //   206	214	281	java/lang/Exception
    //   220	225	281	java/lang/Exception
    //   230	234	281	java/lang/Exception
    //   11	34	291	finally
    //   305	309	291	finally
    //   11	34	298	java/lang/Exception
    //   333	341	344	java/io/IOException
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 139	com/tencent/xweb/xwalk/u:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore 10
    //   6: iconst_0
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 4
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 8
    //   18: aconst_null
    //   19: astore 7
    //   21: aconst_null
    //   22: astore 6
    //   24: aconst_null
    //   25: astore_0
    //   26: new 141	java/util/zip/ZipInputStream
    //   29: dup
    //   30: new 63	java/io/BufferedInputStream
    //   33: dup
    //   34: new 65	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 142	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   42: invokespecial 71	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: invokespecial 143	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_1
    //   49: aload 9
    //   51: astore 6
    //   53: aload 8
    //   55: astore 7
    //   57: sipush 2048
    //   60: newarray byte
    //   62: astore 8
    //   64: aload_0
    //   65: astore 6
    //   67: aload_0
    //   68: astore 7
    //   70: aload_1
    //   71: invokevirtual 147	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   74: astore 11
    //   76: aload 11
    //   78: ifnull +259 -> 337
    //   81: aload_0
    //   82: astore 6
    //   84: aload_0
    //   85: astore 7
    //   87: aload 11
    //   89: invokevirtual 148	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   92: astore 9
    //   94: aload_0
    //   95: astore 6
    //   97: aload_0
    //   98: astore 7
    //   100: aload 9
    //   102: ldc 150
    //   104: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   107: ifne -43 -> 64
    //   110: aload_0
    //   111: astore 6
    //   113: aload_0
    //   114: astore 7
    //   116: aload 9
    //   118: ldc 156
    //   120: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   123: ifeq +6 -> 129
    //   126: goto -62 -> 64
    //   129: aload_0
    //   130: astore 6
    //   132: aload_0
    //   133: astore 7
    //   135: aload 9
    //   137: aload 10
    //   139: invokestatic 160	com/tencent/xweb/xwalk/u:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: astore 6
    //   145: aload_0
    //   146: astore 7
    //   148: aload 11
    //   150: invokevirtual 161	java/util/zip/ZipEntry:isDirectory	()Z
    //   153: ifeq +71 -> 224
    //   156: aload_0
    //   157: astore 6
    //   159: aload_0
    //   160: astore 7
    //   162: new 29	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   169: astore 11
    //   171: aload_0
    //   172: astore 6
    //   174: aload_0
    //   175: astore 7
    //   177: aload 11
    //   179: aload 10
    //   181: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_0
    //   186: astore 6
    //   188: aload_0
    //   189: astore 7
    //   191: aload 11
    //   193: aload 9
    //   195: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_0
    //   200: astore 6
    //   202: aload_0
    //   203: astore 7
    //   205: new 8	java/io/File
    //   208: dup
    //   209: aload 11
    //   211: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokespecial 12	java/io/File:<init>	(Ljava/lang/String;)V
    //   217: invokevirtual 19	java/io/File:mkdirs	()Z
    //   220: pop
    //   221: goto -157 -> 64
    //   224: aload_0
    //   225: astore 6
    //   227: aload_0
    //   228: astore 7
    //   230: new 29	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   237: astore 11
    //   239: aload_0
    //   240: astore 6
    //   242: aload_0
    //   243: astore 7
    //   245: aload 11
    //   247: aload 10
    //   249: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_0
    //   254: astore 6
    //   256: aload_0
    //   257: astore 7
    //   259: aload 11
    //   261: aload 9
    //   263: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_0
    //   268: astore 6
    //   270: aload_0
    //   271: astore 7
    //   273: new 100	java/io/BufferedOutputStream
    //   276: dup
    //   277: new 102	java/io/FileOutputStream
    //   280: dup
    //   281: aload 11
    //   283: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokespecial 103	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   289: invokespecial 106	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   292: astore_0
    //   293: aload_1
    //   294: aload 8
    //   296: invokevirtual 162	java/util/zip/ZipInputStream:read	([B)I
    //   299: istore_2
    //   300: iload_2
    //   301: iconst_m1
    //   302: if_icmpeq +14 -> 316
    //   305: aload_0
    //   306: aload 8
    //   308: iconst_0
    //   309: iload_2
    //   310: invokevirtual 163	java/io/BufferedOutputStream:write	([BII)V
    //   313: goto -20 -> 293
    //   316: aload_0
    //   317: invokevirtual 164	java/io/BufferedOutputStream:flush	()V
    //   320: aload_0
    //   321: invokevirtual 165	java/io/BufferedOutputStream:close	()V
    //   324: goto -260 -> 64
    //   327: astore 6
    //   329: goto +120 -> 449
    //   332: astore 6
    //   334: goto +55 -> 389
    //   337: iconst_1
    //   338: istore 5
    //   340: iconst_1
    //   341: istore 4
    //   343: iload 4
    //   345: istore_3
    //   346: aload_1
    //   347: invokevirtual 166	java/util/zip/ZipInputStream:closeEntry	()V
    //   350: iload 4
    //   352: istore_3
    //   353: aload_1
    //   354: invokevirtual 167	java/util/zip/ZipInputStream:close	()V
    //   357: iload 5
    //   359: istore_3
    //   360: aload_0
    //   361: ifnull +84 -> 445
    //   364: iload 4
    //   366: istore_3
    //   367: aload_0
    //   368: invokevirtual 165	java/io/BufferedOutputStream:close	()V
    //   371: iconst_1
    //   372: ireturn
    //   373: astore_0
    //   374: aload_0
    //   375: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   378: iload_3
    //   379: ireturn
    //   380: astore_0
    //   381: goto +78 -> 459
    //   384: astore 6
    //   386: aload 7
    //   388: astore_0
    //   389: goto +16 -> 405
    //   392: astore_0
    //   393: aconst_null
    //   394: astore_1
    //   395: goto +64 -> 459
    //   398: astore 6
    //   400: aconst_null
    //   401: astore_0
    //   402: aload 7
    //   404: astore_1
    //   405: aload 6
    //   407: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   410: aload_1
    //   411: ifnull +17 -> 428
    //   414: iload 4
    //   416: istore_3
    //   417: aload_1
    //   418: invokevirtual 166	java/util/zip/ZipInputStream:closeEntry	()V
    //   421: iload 4
    //   423: istore_3
    //   424: aload_1
    //   425: invokevirtual 167	java/util/zip/ZipInputStream:close	()V
    //   428: iload 5
    //   430: istore_3
    //   431: aload_0
    //   432: ifnull +13 -> 445
    //   435: iload 4
    //   437: istore_3
    //   438: aload_0
    //   439: invokevirtual 165	java/io/BufferedOutputStream:close	()V
    //   442: iload 5
    //   444: istore_3
    //   445: iload_3
    //   446: ireturn
    //   447: astore 6
    //   449: aload_0
    //   450: astore 7
    //   452: aload 6
    //   454: astore_0
    //   455: aload 7
    //   457: astore 6
    //   459: aload_1
    //   460: ifnull +14 -> 474
    //   463: aload_1
    //   464: invokevirtual 166	java/util/zip/ZipInputStream:closeEntry	()V
    //   467: aload_1
    //   468: invokevirtual 167	java/util/zip/ZipInputStream:close	()V
    //   471: goto +3 -> 474
    //   474: aload 6
    //   476: ifnull +15 -> 491
    //   479: aload 6
    //   481: invokevirtual 165	java/io/BufferedOutputStream:close	()V
    //   484: goto +7 -> 491
    //   487: aload_1
    //   488: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   491: goto +5 -> 496
    //   494: aload_0
    //   495: athrow
    //   496: goto -2 -> 494
    //   499: astore_1
    //   500: goto -13 -> 487
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	paramString1	String
    //   0	503	1	paramString2	String
    //   299	11	2	i	int
    //   345	101	3	bool1	boolean
    //   10	426	4	bool2	boolean
    //   7	436	5	bool3	boolean
    //   22	247	6	str1	String
    //   327	1	6	localObject1	Object
    //   332	1	6	localIOException1	java.io.IOException
    //   384	1	6	localIOException2	java.io.IOException
    //   398	8	6	localIOException3	java.io.IOException
    //   447	6	6	localObject2	Object
    //   457	23	6	localObject3	Object
    //   19	437	7	localObject4	Object
    //   16	291	8	arrayOfByte	byte[]
    //   13	249	9	str2	String
    //   4	244	10	str3	String
    //   74	208	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   293	300	327	finally
    //   305	313	327	finally
    //   316	324	327	finally
    //   293	300	332	java/io/IOException
    //   305	313	332	java/io/IOException
    //   316	324	332	java/io/IOException
    //   346	350	373	java/io/IOException
    //   353	357	373	java/io/IOException
    //   367	371	373	java/io/IOException
    //   417	421	373	java/io/IOException
    //   424	428	373	java/io/IOException
    //   438	442	373	java/io/IOException
    //   57	64	380	finally
    //   70	76	380	finally
    //   87	94	380	finally
    //   100	110	380	finally
    //   116	126	380	finally
    //   135	142	380	finally
    //   148	156	380	finally
    //   162	171	380	finally
    //   177	185	380	finally
    //   191	199	380	finally
    //   205	221	380	finally
    //   230	239	380	finally
    //   245	253	380	finally
    //   259	267	380	finally
    //   273	293	380	finally
    //   57	64	384	java/io/IOException
    //   70	76	384	java/io/IOException
    //   87	94	384	java/io/IOException
    //   100	110	384	java/io/IOException
    //   116	126	384	java/io/IOException
    //   135	142	384	java/io/IOException
    //   148	156	384	java/io/IOException
    //   162	171	384	java/io/IOException
    //   177	185	384	java/io/IOException
    //   191	199	384	java/io/IOException
    //   205	221	384	java/io/IOException
    //   230	239	384	java/io/IOException
    //   245	253	384	java/io/IOException
    //   259	267	384	java/io/IOException
    //   273	293	384	java/io/IOException
    //   26	49	392	finally
    //   26	49	398	java/io/IOException
    //   405	410	447	finally
    //   463	471	499	java/io/IOException
    //   479	484	499	java/io/IOException
  }
  
  public static boolean a(File[] paramArrayOfFile, String paramString)
  {
    return a(paramArrayOfFile, paramString, -1);
  }
  
  /* Error */
  public static boolean a(File[] paramArrayOfFile, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +264 -> 265
    //   4: aconst_null
    //   5: astore 7
    //   7: aconst_null
    //   8: astore 6
    //   10: iconst_1
    //   11: istore 5
    //   13: iconst_1
    //   14: istore 4
    //   16: new 76	java/util/zip/ZipOutputStream
    //   19: dup
    //   20: new 100	java/io/BufferedOutputStream
    //   23: dup
    //   24: new 102	java/io/FileOutputStream
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 103	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 106	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: invokespecial 107	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   38: astore_1
    //   39: aload_1
    //   40: iload_2
    //   41: invokevirtual 111	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   44: aload_0
    //   45: arraylength
    //   46: istore_3
    //   47: iconst_0
    //   48: istore_2
    //   49: iload_2
    //   50: iload_3
    //   51: if_icmpge +90 -> 141
    //   54: aload_0
    //   55: iload_2
    //   56: aaload
    //   57: astore 6
    //   59: aload 6
    //   61: ifnull +73 -> 134
    //   64: aload 6
    //   66: invokevirtual 16	java/io/File:exists	()Z
    //   69: ifne +6 -> 75
    //   72: goto +62 -> 134
    //   75: aload 6
    //   77: invokevirtual 48	java/io/File:isDirectory	()Z
    //   80: ifeq +46 -> 126
    //   83: new 29	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   90: astore 7
    //   92: aload 7
    //   94: aload 6
    //   96: invokevirtual 55	java/io/File:getName	()Ljava/lang/String;
    //   99: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 7
    //   105: getstatic 59	java/io/File:separator	Ljava/lang/String;
    //   108: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_1
    //   113: aload 6
    //   115: aload 7
    //   117: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 61	com/tencent/xweb/xwalk/u:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   123: goto +11 -> 134
    //   126: aload_1
    //   127: aload 6
    //   129: ldc 173
    //   131: invokestatic 61	com/tencent/xweb/xwalk/u:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   134: iload_2
    //   135: iconst_1
    //   136: iadd
    //   137: istore_2
    //   138: goto -89 -> 49
    //   141: aload_1
    //   142: invokevirtual 135	java/util/zip/ZipOutputStream:flush	()V
    //   145: iload 4
    //   147: istore 5
    //   149: aload_1
    //   150: invokevirtual 114	java/util/zip/ZipOutputStream:closeEntry	()V
    //   153: iload 4
    //   155: istore 5
    //   157: aload_1
    //   158: invokevirtual 115	java/util/zip/ZipOutputStream:close	()V
    //   161: iconst_1
    //   162: ireturn
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   168: iload 5
    //   170: ireturn
    //   171: astore 6
    //   173: aload_1
    //   174: astore_0
    //   175: iload 5
    //   177: istore 4
    //   179: aload 6
    //   181: astore_1
    //   182: goto +31 -> 213
    //   185: astore_0
    //   186: goto +57 -> 243
    //   189: astore 6
    //   191: aload_1
    //   192: astore_0
    //   193: aload 6
    //   195: astore_1
    //   196: goto +14 -> 210
    //   199: astore_0
    //   200: aload 6
    //   202: astore_1
    //   203: goto +40 -> 243
    //   206: astore_1
    //   207: aload 7
    //   209: astore_0
    //   210: iconst_0
    //   211: istore 4
    //   213: aload_0
    //   214: astore 6
    //   216: aload_1
    //   217: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   220: aload_0
    //   221: ifnull +19 -> 240
    //   224: iload 4
    //   226: istore 5
    //   228: aload_0
    //   229: invokevirtual 114	java/util/zip/ZipOutputStream:closeEntry	()V
    //   232: iload 4
    //   234: istore 5
    //   236: aload_0
    //   237: invokevirtual 115	java/util/zip/ZipOutputStream:close	()V
    //   240: iload 4
    //   242: ireturn
    //   243: aload_1
    //   244: ifnull +19 -> 263
    //   247: aload_1
    //   248: invokevirtual 114	java/util/zip/ZipOutputStream:closeEntry	()V
    //   251: aload_1
    //   252: invokevirtual 115	java/util/zip/ZipOutputStream:close	()V
    //   255: goto +8 -> 263
    //   258: astore_1
    //   259: aload_1
    //   260: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   263: aload_0
    //   264: athrow
    //   265: new 175	java/lang/NullPointerException
    //   268: dup
    //   269: ldc 177
    //   271: invokespecial 178	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   274: astore_0
    //   275: goto +5 -> 280
    //   278: aload_0
    //   279: athrow
    //   280: goto -2 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramArrayOfFile	File[]
    //   0	283	1	paramString	String
    //   0	283	2	paramInt	int
    //   46	6	3	i	int
    //   14	227	4	bool1	boolean
    //   11	224	5	bool2	boolean
    //   8	120	6	localFile	File
    //   171	9	6	localException1	java.lang.Exception
    //   189	12	6	localException2	java.lang.Exception
    //   214	1	6	arrayOfFile	File[]
    //   5	203	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   149	153	163	java/io/IOException
    //   157	161	163	java/io/IOException
    //   228	232	163	java/io/IOException
    //   236	240	163	java/io/IOException
    //   141	145	171	java/lang/Exception
    //   39	47	185	finally
    //   64	72	185	finally
    //   75	123	185	finally
    //   126	134	185	finally
    //   141	145	185	finally
    //   39	47	189	java/lang/Exception
    //   64	72	189	java/lang/Exception
    //   75	123	189	java/lang/Exception
    //   126	134	189	java/lang/Exception
    //   16	39	199	finally
    //   216	220	199	finally
    //   16	39	206	java/lang/Exception
    //   247	255	258	java/io/IOException
  }
  
  private static void b(String paramString1, String paramString2)
  {
    paramString1 = paramString1.split("/");
    if (paramString1.length <= 1) {
      return;
    }
    int i = 0;
    while (i < paramString1.length - 1)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(paramString1[i]);
      ((StringBuilder)localObject).append("/");
      paramString2 = ((StringBuilder)localObject).toString();
      localObject = new File(paramString2);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.u
 * JD-Core Version:    0.7.0.1
 */