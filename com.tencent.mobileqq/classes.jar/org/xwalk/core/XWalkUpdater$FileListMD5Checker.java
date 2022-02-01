package org.xwalk.core;

import com.tencent.xweb.util.d;
import java.io.File;

public class XWalkUpdater$FileListMD5Checker
{
  /* Error */
  public static boolean checkFileListMd5(int paramInt, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aconst_null
    //   7: astore 5
    //   9: new 15	java/io/FileInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 18	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 4
    //   19: new 20	java/io/InputStreamReader
    //   22: dup
    //   23: aload 4
    //   25: invokespecial 23	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   28: astore_3
    //   29: new 25	java/io/BufferedReader
    //   32: dup
    //   33: aload_3
    //   34: invokespecial 28	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 32	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +174 -> 218
    //   47: aload_2
    //   48: ifnull -10 -> 38
    //   51: aload_2
    //   52: invokevirtual 38	java/lang/String:isEmpty	()Z
    //   55: ifeq +6 -> 61
    //   58: goto -20 -> 38
    //   61: aload_2
    //   62: ldc 40
    //   64: invokevirtual 44	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   67: astore_2
    //   68: aload_2
    //   69: ifnull -31 -> 38
    //   72: aload_2
    //   73: arraylength
    //   74: iconst_2
    //   75: if_icmpne -37 -> 38
    //   78: aload_2
    //   79: iconst_0
    //   80: aaload
    //   81: ifnull -43 -> 38
    //   84: aload_2
    //   85: iconst_0
    //   86: aaload
    //   87: invokevirtual 38	java/lang/String:isEmpty	()Z
    //   90: ifne -52 -> 38
    //   93: aload_2
    //   94: iconst_1
    //   95: aaload
    //   96: ifnull -58 -> 38
    //   99: aload_2
    //   100: iconst_1
    //   101: aaload
    //   102: invokevirtual 38	java/lang/String:isEmpty	()Z
    //   105: ifne -67 -> 38
    //   108: iload_0
    //   109: aload_2
    //   110: iconst_0
    //   111: aaload
    //   112: aload_2
    //   113: iconst_1
    //   114: aaload
    //   115: invokestatic 48	org/xwalk/core/XWalkUpdater$FileListMD5Checker:checkFileMd5	(ILjava/lang/String;Ljava/lang/String;)Z
    //   118: ifne -80 -> 38
    //   121: new 50	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   128: astore 5
    //   130: aload 5
    //   132: ldc 53
    //   134: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 5
    //   140: aload_2
    //   141: iconst_0
    //   142: aaload
    //   143: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 5
    //   149: ldc 59
    //   151: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 5
    //   157: aload_2
    //   158: iconst_1
    //   159: aaload
    //   160: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 61
    //   166: aload 5
    //   168: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload 4
    //   176: invokevirtual 73	java/io/FileInputStream:close	()V
    //   179: goto +10 -> 189
    //   182: ldc 61
    //   184: ldc 75
    //   186: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_3
    //   190: invokevirtual 76	java/io/InputStreamReader:close	()V
    //   193: goto +10 -> 203
    //   196: ldc 61
    //   198: ldc 78
    //   200: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_1
    //   204: invokevirtual 79	java/io/BufferedReader:close	()V
    //   207: iconst_0
    //   208: ireturn
    //   209: ldc 61
    //   211: ldc 81
    //   213: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: iconst_0
    //   217: ireturn
    //   218: aload 4
    //   220: invokevirtual 73	java/io/FileInputStream:close	()V
    //   223: goto +10 -> 233
    //   226: ldc 61
    //   228: ldc 75
    //   230: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_3
    //   234: invokevirtual 76	java/io/InputStreamReader:close	()V
    //   237: goto +10 -> 247
    //   240: ldc 61
    //   242: ldc 78
    //   244: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload_1
    //   248: invokevirtual 79	java/io/BufferedReader:close	()V
    //   251: iconst_1
    //   252: ireturn
    //   253: ldc 61
    //   255: ldc 81
    //   257: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: iconst_1
    //   261: ireturn
    //   262: astore_2
    //   263: goto +151 -> 414
    //   266: astore_2
    //   267: goto +28 -> 295
    //   270: astore_2
    //   271: aconst_null
    //   272: astore_1
    //   273: goto +141 -> 414
    //   276: astore_2
    //   277: aconst_null
    //   278: astore_1
    //   279: goto +16 -> 295
    //   282: astore_2
    //   283: aconst_null
    //   284: astore_3
    //   285: aload_3
    //   286: astore_1
    //   287: goto +127 -> 414
    //   290: astore_2
    //   291: aconst_null
    //   292: astore_3
    //   293: aload_3
    //   294: astore_1
    //   295: goto +24 -> 319
    //   298: astore_2
    //   299: aconst_null
    //   300: astore_3
    //   301: aload_3
    //   302: astore 4
    //   304: aload 4
    //   306: astore_1
    //   307: goto +107 -> 414
    //   310: astore_2
    //   311: aconst_null
    //   312: astore_3
    //   313: aload_3
    //   314: astore_1
    //   315: aload 5
    //   317: astore 4
    //   319: new 50	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   326: astore 5
    //   328: aload 5
    //   330: ldc 83
    //   332: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 5
    //   338: aload_2
    //   339: invokevirtual 86	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   342: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: ldc 61
    //   348: aload 5
    //   350: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload 4
    //   358: ifnull +18 -> 376
    //   361: aload 4
    //   363: invokevirtual 73	java/io/FileInputStream:close	()V
    //   366: goto +10 -> 376
    //   369: ldc 61
    //   371: ldc 75
    //   373: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload_3
    //   377: ifnull +17 -> 394
    //   380: aload_3
    //   381: invokevirtual 76	java/io/InputStreamReader:close	()V
    //   384: goto +10 -> 394
    //   387: ldc 61
    //   389: ldc 78
    //   391: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload_1
    //   395: ifnull +16 -> 411
    //   398: aload_1
    //   399: invokevirtual 79	java/io/BufferedReader:close	()V
    //   402: iconst_0
    //   403: ireturn
    //   404: ldc 61
    //   406: ldc 81
    //   408: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: iconst_0
    //   412: ireturn
    //   413: astore_2
    //   414: aload 4
    //   416: ifnull +18 -> 434
    //   419: aload 4
    //   421: invokevirtual 73	java/io/FileInputStream:close	()V
    //   424: goto +10 -> 434
    //   427: ldc 61
    //   429: ldc 75
    //   431: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: aload_3
    //   435: ifnull +17 -> 452
    //   438: aload_3
    //   439: invokevirtual 76	java/io/InputStreamReader:close	()V
    //   442: goto +10 -> 452
    //   445: ldc 61
    //   447: ldc 78
    //   449: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: aload_1
    //   453: ifnull +17 -> 470
    //   456: aload_1
    //   457: invokevirtual 79	java/io/BufferedReader:close	()V
    //   460: goto +10 -> 470
    //   463: ldc 61
    //   465: ldc 81
    //   467: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: goto +5 -> 475
    //   473: aload_2
    //   474: athrow
    //   475: goto -2 -> 473
    //   478: astore_2
    //   479: goto -297 -> 182
    //   482: astore_2
    //   483: goto -287 -> 196
    //   486: astore_1
    //   487: goto -278 -> 209
    //   490: astore_2
    //   491: goto -265 -> 226
    //   494: astore_2
    //   495: goto -255 -> 240
    //   498: astore_1
    //   499: goto -246 -> 253
    //   502: astore_2
    //   503: goto -134 -> 369
    //   506: astore_2
    //   507: goto -120 -> 387
    //   510: astore_1
    //   511: goto -107 -> 404
    //   514: astore 4
    //   516: goto -89 -> 427
    //   519: astore_3
    //   520: goto -75 -> 445
    //   523: astore_1
    //   524: goto -61 -> 463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	527	0	paramInt	int
    //   0	527	1	paramFile	File
    //   42	116	2	localObject1	Object
    //   262	1	2	localObject2	Object
    //   266	1	2	localException1	Exception
    //   270	1	2	localObject3	Object
    //   276	1	2	localException2	Exception
    //   282	1	2	localObject4	Object
    //   290	1	2	localException3	Exception
    //   298	1	2	localObject5	Object
    //   310	29	2	localException4	Exception
    //   413	61	2	localObject6	Object
    //   478	1	2	localException5	Exception
    //   482	1	2	localException6	Exception
    //   490	1	2	localException7	Exception
    //   494	1	2	localException8	Exception
    //   502	1	2	localException9	Exception
    //   506	1	2	localException10	Exception
    //   28	411	3	localInputStreamReader	java.io.InputStreamReader
    //   519	1	3	localException11	Exception
    //   17	403	4	localObject7	Object
    //   514	1	4	localException12	Exception
    //   7	342	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	43	262	finally
    //   51	58	262	finally
    //   61	68	262	finally
    //   72	78	262	finally
    //   84	93	262	finally
    //   99	174	262	finally
    //   38	43	266	java/lang/Exception
    //   51	58	266	java/lang/Exception
    //   61	68	266	java/lang/Exception
    //   72	78	266	java/lang/Exception
    //   84	93	266	java/lang/Exception
    //   99	174	266	java/lang/Exception
    //   29	38	270	finally
    //   29	38	276	java/lang/Exception
    //   19	29	282	finally
    //   19	29	290	java/lang/Exception
    //   9	19	298	finally
    //   9	19	310	java/lang/Exception
    //   319	356	413	finally
    //   174	179	478	java/lang/Exception
    //   189	193	482	java/lang/Exception
    //   203	207	486	java/lang/Exception
    //   218	223	490	java/lang/Exception
    //   233	237	494	java/lang/Exception
    //   247	251	498	java/lang/Exception
    //   361	366	502	java/lang/Exception
    //   380	384	506	java/lang/Exception
    //   398	402	510	java/lang/Exception
    //   419	424	514	java/lang/Exception
    //   438	442	519	java/lang/Exception
    //   456	460	523	java/lang/Exception
  }
  
  public static boolean checkFileListMd5(int paramInt, String paramString)
  {
    try
    {
      boolean bool = checkFileListMd5(paramInt, new File(paramString));
      return bool;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkFileListMd5 error:");
      localStringBuilder.append(paramString.getMessage());
      Log.e("XWalkLib", localStringBuilder.toString());
    }
    return false;
  }
  
  private static boolean checkFileMd5(int paramInt, String paramString1, String paramString2)
  {
    if ("base.apk".equals(paramString1)) {
      paramString1 = XWalkEnvironment.getDownloadApkPath(paramInt);
    } else {
      paramString1 = XWalkEnvironment.getExtractedCoreFile(paramInt, paramString1);
    }
    if (d.a(paramString1, paramString2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("checkFileMd5 successful path:");
      paramString2.append(paramString1);
      Log.i("XWalkLib", paramString2.toString());
      return true;
    }
    paramString2 = new StringBuilder();
    paramString2.append("checkFileMd5 error path:");
    paramString2.append(paramString1);
    Log.e("XWalkLib", paramString2.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.FileListMD5Checker
 * JD-Core Version:    0.7.0.1
 */