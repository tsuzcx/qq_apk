package cooperation.qzone.patch;

import java.io.InputStream;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

public class PatchMergeUtils
{
  /* Error */
  public static boolean MergeApk(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 15	java/util/jar/JarOutputStream
    //   6: dup
    //   7: new 17	java/io/FileOutputStream
    //   10: dup
    //   11: aload_2
    //   12: invokespecial 20	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 23	java/util/jar/JarOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 5
    //   20: new 25	java/util/jar/JarFile
    //   23: dup
    //   24: new 27	java/io/File
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 31	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   35: astore_2
    //   36: new 25	java/util/jar/JarFile
    //   39: dup
    //   40: new 27	java/io/File
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: invokespecial 31	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   51: astore_0
    //   52: new 33	java/util/HashSet
    //   55: dup
    //   56: invokespecial 34	java/util/HashSet:<init>	()V
    //   59: astore_1
    //   60: aload_0
    //   61: invokevirtual 38	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   64: astore 6
    //   66: iconst_1
    //   67: istore_3
    //   68: aload 6
    //   70: invokeinterface 44 1 0
    //   75: istore 4
    //   77: iload 4
    //   79: ifeq +152 -> 231
    //   82: aload 6
    //   84: invokeinterface 48 1 0
    //   89: checkcast 50	java/util/jar/JarEntry
    //   92: astore 7
    //   94: aload 7
    //   96: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   99: ldc 56
    //   101: invokevirtual 62	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   104: ifeq +68 -> 172
    //   107: aload 7
    //   109: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   112: ldc 64
    //   114: invokevirtual 67	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   117: ifeq +55 -> 172
    //   120: new 69	java/util/zip/ZipEntry
    //   123: dup
    //   124: iload_3
    //   125: invokestatic 73	cooperation/qzone/patch/PatchMergeUtils:getDexName	(I)Ljava/lang/String;
    //   128: invokespecial 74	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   131: astore 8
    //   133: aload_0
    //   134: new 69	java/util/zip/ZipEntry
    //   137: dup
    //   138: aload 7
    //   140: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   143: invokespecial 74	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   146: invokevirtual 78	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   149: astore 7
    //   151: aload 5
    //   153: aload 8
    //   155: aload 7
    //   157: invokestatic 82	cooperation/qzone/patch/PatchMergeUtils:writeZipEntry	(Ljava/util/jar/JarOutputStream;Ljava/util/zip/ZipEntry;Ljava/io/InputStream;)V
    //   160: aload 7
    //   162: invokevirtual 87	java/io/InputStream:close	()V
    //   165: iload_3
    //   166: iconst_1
    //   167: iadd
    //   168: istore_3
    //   169: goto -101 -> 68
    //   172: aload_1
    //   173: aload 7
    //   175: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   178: invokevirtual 91	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   181: pop
    //   182: new 69	java/util/zip/ZipEntry
    //   185: dup
    //   186: aload 7
    //   188: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   191: invokespecial 74	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   194: astore 8
    //   196: aload_0
    //   197: new 69	java/util/zip/ZipEntry
    //   200: dup
    //   201: aload 7
    //   203: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   206: invokespecial 74	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   209: invokevirtual 78	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   212: astore 7
    //   214: aload 5
    //   216: aload 8
    //   218: aload 7
    //   220: invokestatic 82	cooperation/qzone/patch/PatchMergeUtils:writeZipEntry	(Ljava/util/jar/JarOutputStream;Ljava/util/zip/ZipEntry;Ljava/io/InputStream;)V
    //   223: aload 7
    //   225: invokevirtual 87	java/io/InputStream:close	()V
    //   228: goto -160 -> 68
    //   231: aload_2
    //   232: invokevirtual 38	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   235: astore 6
    //   237: aload 6
    //   239: invokeinterface 44 1 0
    //   244: ifeq +200 -> 444
    //   247: aload 6
    //   249: invokeinterface 48 1 0
    //   254: checkcast 50	java/util/jar/JarEntry
    //   257: astore 7
    //   259: aload 7
    //   261: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   264: ldc 56
    //   266: invokevirtual 62	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   269: ifeq +68 -> 337
    //   272: aload 7
    //   274: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   277: ldc 64
    //   279: invokevirtual 67	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   282: ifeq +55 -> 337
    //   285: new 69	java/util/zip/ZipEntry
    //   288: dup
    //   289: iload_3
    //   290: invokestatic 73	cooperation/qzone/patch/PatchMergeUtils:getDexName	(I)Ljava/lang/String;
    //   293: invokespecial 74	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   296: astore 8
    //   298: aload_2
    //   299: new 69	java/util/zip/ZipEntry
    //   302: dup
    //   303: aload 7
    //   305: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   308: invokespecial 74	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   311: invokevirtual 78	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   314: astore 7
    //   316: aload 5
    //   318: aload 8
    //   320: aload 7
    //   322: invokestatic 82	cooperation/qzone/patch/PatchMergeUtils:writeZipEntry	(Ljava/util/jar/JarOutputStream;Ljava/util/zip/ZipEntry;Ljava/io/InputStream;)V
    //   325: aload 7
    //   327: invokevirtual 87	java/io/InputStream:close	()V
    //   330: iload_3
    //   331: iconst_1
    //   332: iadd
    //   333: istore_3
    //   334: goto -97 -> 237
    //   337: aload_1
    //   338: aload 7
    //   340: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   343: invokevirtual 94	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   346: ifne +52 -> 398
    //   349: new 69	java/util/zip/ZipEntry
    //   352: dup
    //   353: aload 7
    //   355: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   358: invokespecial 74	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   361: astore 8
    //   363: aload_2
    //   364: new 69	java/util/zip/ZipEntry
    //   367: dup
    //   368: aload 7
    //   370: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   373: invokespecial 74	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   376: invokevirtual 78	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   379: astore 7
    //   381: aload 5
    //   383: aload 8
    //   385: aload 7
    //   387: invokestatic 82	cooperation/qzone/patch/PatchMergeUtils:writeZipEntry	(Ljava/util/jar/JarOutputStream;Ljava/util/zip/ZipEntry;Ljava/io/InputStream;)V
    //   390: aload 7
    //   392: invokevirtual 87	java/io/InputStream:close	()V
    //   395: goto -158 -> 237
    //   398: getstatic 100	java/lang/System:out	Ljava/io/PrintStream;
    //   401: astore 8
    //   403: new 102	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   410: astore 9
    //   412: aload 9
    //   414: ldc 105
    //   416: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 9
    //   422: aload 7
    //   424: invokevirtual 54	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   427: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload 8
    //   433: aload 9
    //   435: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokevirtual 117	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   441: goto -204 -> 237
    //   444: aload 5
    //   446: invokevirtual 118	java/util/jar/JarOutputStream:close	()V
    //   449: aload_2
    //   450: invokevirtual 119	java/util/jar/JarFile:close	()V
    //   453: aload_0
    //   454: invokevirtual 119	java/util/jar/JarFile:close	()V
    //   457: iconst_1
    //   458: ireturn
    //   459: astore_1
    //   460: goto +88 -> 548
    //   463: astore_1
    //   464: goto +28 -> 492
    //   467: astore_1
    //   468: aconst_null
    //   469: astore_0
    //   470: goto +78 -> 548
    //   473: astore_1
    //   474: aconst_null
    //   475: astore_0
    //   476: goto +16 -> 492
    //   479: astore_1
    //   480: aconst_null
    //   481: astore_2
    //   482: aload_2
    //   483: astore_0
    //   484: goto +64 -> 548
    //   487: astore_1
    //   488: aconst_null
    //   489: astore_2
    //   490: aload_2
    //   491: astore_0
    //   492: goto +23 -> 515
    //   495: astore_1
    //   496: aconst_null
    //   497: astore_2
    //   498: aload_2
    //   499: astore_0
    //   500: aload_0
    //   501: astore 5
    //   503: goto +45 -> 548
    //   506: astore_1
    //   507: aconst_null
    //   508: astore_2
    //   509: aload_2
    //   510: astore_0
    //   511: aload 6
    //   513: astore 5
    //   515: aload_1
    //   516: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   519: aload 5
    //   521: ifnull +8 -> 529
    //   524: aload 5
    //   526: invokevirtual 118	java/util/jar/JarOutputStream:close	()V
    //   529: aload_2
    //   530: ifnull +7 -> 537
    //   533: aload_2
    //   534: invokevirtual 119	java/util/jar/JarFile:close	()V
    //   537: aload_0
    //   538: ifnull +7 -> 545
    //   541: aload_0
    //   542: invokevirtual 119	java/util/jar/JarFile:close	()V
    //   545: iconst_0
    //   546: ireturn
    //   547: astore_1
    //   548: aload 5
    //   550: ifnull +8 -> 558
    //   553: aload 5
    //   555: invokevirtual 118	java/util/jar/JarOutputStream:close	()V
    //   558: aload_2
    //   559: ifnull +7 -> 566
    //   562: aload_2
    //   563: invokevirtual 119	java/util/jar/JarFile:close	()V
    //   566: aload_0
    //   567: ifnull +7 -> 574
    //   570: aload_0
    //   571: invokevirtual 119	java/util/jar/JarFile:close	()V
    //   574: goto +5 -> 579
    //   577: aload_1
    //   578: athrow
    //   579: goto -2 -> 577
    //   582: astore_1
    //   583: goto -134 -> 449
    //   586: astore_1
    //   587: goto -134 -> 453
    //   590: astore_0
    //   591: iconst_1
    //   592: ireturn
    //   593: astore_1
    //   594: goto -65 -> 529
    //   597: astore_1
    //   598: goto -61 -> 537
    //   601: astore_0
    //   602: goto -57 -> 545
    //   605: astore 5
    //   607: goto -49 -> 558
    //   610: astore_2
    //   611: goto -45 -> 566
    //   614: astore_0
    //   615: goto -41 -> 574
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	paramString1	String
    //   0	618	1	paramString2	String
    //   0	618	2	paramString3	String
    //   67	267	3	i	int
    //   75	3	4	bool	boolean
    //   18	536	5	localObject1	Object
    //   605	1	5	localException	Exception
    //   1	511	6	localEnumeration	java.util.Enumeration
    //   92	331	7	localObject2	Object
    //   131	301	8	localObject3	Object
    //   410	24	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   52	66	459	finally
    //   68	77	459	finally
    //   82	165	459	finally
    //   172	228	459	finally
    //   231	237	459	finally
    //   237	330	459	finally
    //   337	395	459	finally
    //   398	441	459	finally
    //   52	66	463	java/lang/Exception
    //   68	77	463	java/lang/Exception
    //   82	165	463	java/lang/Exception
    //   172	228	463	java/lang/Exception
    //   231	237	463	java/lang/Exception
    //   237	330	463	java/lang/Exception
    //   337	395	463	java/lang/Exception
    //   398	441	463	java/lang/Exception
    //   36	52	467	finally
    //   36	52	473	java/lang/Exception
    //   20	36	479	finally
    //   20	36	487	java/lang/Exception
    //   3	20	495	finally
    //   3	20	506	java/lang/Exception
    //   515	519	547	finally
    //   444	449	582	java/lang/Exception
    //   449	453	586	java/lang/Exception
    //   453	457	590	java/lang/Exception
    //   524	529	593	java/lang/Exception
    //   533	537	597	java/lang/Exception
    //   541	545	601	java/lang/Exception
    //   553	558	605	java/lang/Exception
    //   562	566	610	java/lang/Exception
    //   570	574	614	java/lang/Exception
  }
  
  public static String getDexName(int paramInt)
  {
    if (paramInt == 1) {
      return "classes.dex";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("classes");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".dex");
    return localStringBuilder.toString();
  }
  
  private static void writeZipEntry(JarOutputStream paramJarOutputStream, ZipEntry paramZipEntry, InputStream paramInputStream)
  {
    try
    {
      paramJarOutputStream.putNextEntry(paramZipEntry);
      paramZipEntry = new byte[1024];
      for (;;)
      {
        int i = paramInputStream.read(paramZipEntry);
        if (i == -1)
        {
          paramJarOutputStream.closeEntry();
          return;
        }
        paramJarOutputStream.write(paramZipEntry, 0, i);
      }
      return;
    }
    catch (Exception paramJarOutputStream) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.patch.PatchMergeUtils
 * JD-Core Version:    0.7.0.1
 */