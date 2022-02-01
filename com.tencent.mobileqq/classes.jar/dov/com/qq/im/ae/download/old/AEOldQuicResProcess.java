package dov.com.qq.im.ae.download.old;

import android.os.Build;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AEOldQuicResProcess
{
  private static final ReentrantLock a = new ReentrantLock();
  
  public static int a(AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    int i;
    if (paramSVConfigItem.versionCode >= 3) {
      i = 0;
    } else {
      i = -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[checkResourceLowLimitVersion]limitVer=3 downVer=");
    localStringBuilder.append(paramSVConfigItem.versionCode);
    localStringBuilder.append(" errCode=");
    localStringBuilder.append(i);
    VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", localStringBuilder.toString(), null);
    return i;
  }
  
  private static void a()
  {
    File localFile = new File(AEOldQuicResDownload.a());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(AEOldQuicResDownload.b());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString).listFiles();
    if ((paramString != null) && (paramString.length > 0))
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        StringBuilder localStringBuilder = paramString[i];
        if ((localStringBuilder.isFile()) && (localStringBuilder.exists()))
        {
          String str = localStringBuilder.getName();
          boolean bool = localStringBuilder.delete();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[cleanDirector] delete filename=");
          localStringBuilder.append(str);
          localStringBuilder.append(" ret=");
          localStringBuilder.append(bool);
          VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", localStringBuilder.toString(), null);
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    int i = AEOldQuicResDownload.d();
    Object localObject = AEOldQuicResDownload.c();
    String str = Build.CPU_ABI;
    boolean bool1 = true;
    if ((str != null) && (str.contains("armeabi-v7a")))
    {
      if (i >= paramSVConfigItem.versionCode)
      {
        try
        {
          if (a.tryLock(3000L, TimeUnit.MILLISECONDS))
          {
            boolean bool2 = a(paramAppInterface, (String)localObject, paramSVConfigItem.versionCode);
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("[userCheckNeedDownload][checkUncompressedResourceIsOK]Before Uncompresses checkOK=");
            paramAppInterface.append(bool2);
            VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", paramAppInterface.toString(), null);
            if (bool2)
            {
              i = 1;
            }
            else
            {
              i = 2;
              break label172;
            }
          }
          else
          {
            i = 3;
          }
        }
        catch (Exception paramAppInterface)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("userCheckNeedDownload ");
          ((StringBuilder)localObject).append(paramAppInterface.getMessage());
          VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", ((StringBuilder)localObject).toString(), paramAppInterface);
          i = 4;
        }
      }
      else
      {
        i = 5;
        break label172;
      }
    }
    else {
      i = 6;
    }
    bool1 = false;
    label172:
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("userCheckNeedDownload arm_url=");
    paramAppInterface.append(paramSVConfigItem.arm_url);
    paramAppInterface.append(" ");
    paramAppInterface.append(paramSVConfigItem.armv7a_url);
    paramAppInterface.append(" reason=");
    paramAppInterface.append(i);
    paramAppInterface.append(" needDownload=");
    paramAppInterface.append(bool1);
    VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", paramAppInterface.toString(), null);
    return bool1;
  }
  
  /* Error */
  private static boolean a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 26	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   7: astore_0
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: pop
    //   14: aload_0
    //   15: ldc 151
    //   17: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: new 52	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 6
    //   34: aload 6
    //   36: invokevirtual 63	java/io/File:exists	()Z
    //   39: ifne +5 -> 44
    //   42: iconst_0
    //   43: ireturn
    //   44: new 153	java/util/Properties
    //   47: dup
    //   48: invokespecial 154	java/util/Properties:<init>	()V
    //   51: astore 8
    //   53: aconst_null
    //   54: astore 7
    //   56: aconst_null
    //   57: astore_0
    //   58: new 156	java/io/FileInputStream
    //   61: dup
    //   62: aload 6
    //   64: invokespecial 159	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: astore 6
    //   69: aload 8
    //   71: aload 6
    //   73: invokevirtual 163	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   76: aload 6
    //   78: invokevirtual 166	java/io/FileInputStream:close	()V
    //   81: aload 8
    //   83: ldc 168
    //   85: invokevirtual 172	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: checkcast 109	java/lang/String
    //   91: invokestatic 178	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   94: istore_3
    //   95: aload 8
    //   97: ldc 180
    //   99: invokevirtual 172	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 109	java/lang/String
    //   105: invokestatic 178	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: istore 4
    //   110: new 26	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   117: astore_0
    //   118: aload_0
    //   119: aload_1
    //   120: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_0
    //   125: ldc 180
    //   127: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_0
    //   132: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_0
    //   136: aload 8
    //   138: ldc 182
    //   140: invokevirtual 172	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   143: checkcast 109	java/lang/String
    //   146: invokestatic 178	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   149: istore 5
    //   151: new 26	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   158: astore 6
    //   160: aload 6
    //   162: aload_1
    //   163: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 6
    //   169: ldc 182
    //   171: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 6
    //   177: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore_1
    //   181: iload_3
    //   182: iload_2
    //   183: if_icmpge +52 -> 235
    //   186: new 26	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   193: astore_0
    //   194: aload_0
    //   195: ldc 184
    //   197: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_0
    //   202: iload_3
    //   203: invokestatic 188	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   206: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_0
    //   211: ldc 193
    //   213: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_0
    //   218: iload_2
    //   219: invokevirtual 36	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: ldc 40
    //   225: aload_0
    //   226: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: aconst_null
    //   230: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   233: iconst_0
    //   234: ireturn
    //   235: iload 4
    //   237: ifle +96 -> 333
    //   240: new 52	java/io/File
    //   243: dup
    //   244: aload_0
    //   245: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   248: astore_0
    //   249: aload_0
    //   250: invokevirtual 63	java/io/File:exists	()Z
    //   253: ifeq +14 -> 267
    //   256: aload_0
    //   257: invokevirtual 197	java/io/File:length	()J
    //   260: iload 4
    //   262: i2l
    //   263: lcmp
    //   264: ifeq +69 -> 333
    //   267: new 26	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   274: astore_1
    //   275: aload_1
    //   276: ldc 199
    //   278: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_1
    //   283: iload 4
    //   285: invokevirtual 36	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_1
    //   290: ldc 201
    //   292: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_1
    //   297: aload_0
    //   298: invokevirtual 197	java/io/File:length	()J
    //   301: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_1
    //   306: ldc 206
    //   308: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_1
    //   313: aload_0
    //   314: invokevirtual 209	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   317: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: ldc 40
    //   323: aload_1
    //   324: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: aconst_null
    //   328: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   331: iconst_0
    //   332: ireturn
    //   333: iload 5
    //   335: ifle +96 -> 431
    //   338: new 52	java/io/File
    //   341: dup
    //   342: aload_1
    //   343: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   346: astore_0
    //   347: aload_0
    //   348: invokevirtual 63	java/io/File:exists	()Z
    //   351: ifeq +14 -> 365
    //   354: aload_0
    //   355: invokevirtual 197	java/io/File:length	()J
    //   358: iload 5
    //   360: i2l
    //   361: lcmp
    //   362: ifeq +69 -> 431
    //   365: new 26	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   372: astore_1
    //   373: aload_1
    //   374: ldc 199
    //   376: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_1
    //   381: iload 5
    //   383: invokevirtual 36	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_1
    //   388: ldc 201
    //   390: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload_1
    //   395: aload_0
    //   396: invokevirtual 197	java/io/File:length	()J
    //   399: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_1
    //   404: ldc 206
    //   406: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_1
    //   411: aload_0
    //   412: invokevirtual 209	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   415: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: ldc 40
    //   421: aload_1
    //   422: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: aconst_null
    //   426: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   429: iconst_0
    //   430: ireturn
    //   431: iconst_1
    //   432: ireturn
    //   433: astore_0
    //   434: new 26	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   441: astore_1
    //   442: aload_1
    //   443: ldc 211
    //   445: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_1
    //   450: aload_0
    //   451: invokevirtual 135	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   454: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: ldc 40
    //   460: aload_1
    //   461: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: aload_0
    //   465: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   468: iconst_0
    //   469: ireturn
    //   470: astore_1
    //   471: aload 6
    //   473: astore_0
    //   474: goto +39 -> 513
    //   477: astore_0
    //   478: aload 6
    //   480: astore_1
    //   481: aload_0
    //   482: astore 6
    //   484: goto +12 -> 496
    //   487: astore_1
    //   488: goto +25 -> 513
    //   491: astore 6
    //   493: aload 7
    //   495: astore_1
    //   496: aload_1
    //   497: astore_0
    //   498: ldc 40
    //   500: ldc 213
    //   502: aload 6
    //   504: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   507: aload_1
    //   508: invokevirtual 166	java/io/FileInputStream:close	()V
    //   511: iconst_0
    //   512: ireturn
    //   513: aload_0
    //   514: invokevirtual 166	java/io/FileInputStream:close	()V
    //   517: aload_1
    //   518: athrow
    //   519: astore_0
    //   520: goto -439 -> 81
    //   523: astore_0
    //   524: iconst_0
    //   525: ireturn
    //   526: astore_0
    //   527: goto -10 -> 517
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	paramAppInterface	AppInterface
    //   0	530	1	paramString	String
    //   0	530	2	paramInt	int
    //   94	109	3	i	int
    //   108	176	4	j	int
    //   149	233	5	k	int
    //   32	451	6	localObject1	Object
    //   491	12	6	localException	Exception
    //   54	440	7	localObject2	Object
    //   51	86	8	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   81	181	433	java/lang/Exception
    //   186	233	433	java/lang/Exception
    //   240	267	433	java/lang/Exception
    //   267	331	433	java/lang/Exception
    //   338	365	433	java/lang/Exception
    //   365	429	433	java/lang/Exception
    //   69	76	470	finally
    //   69	76	477	java/lang/Exception
    //   58	69	487	finally
    //   498	507	487	finally
    //   58	69	491	java/lang/Exception
    //   76	81	519	java/lang/Exception
    //   507	511	523	java/lang/Exception
    //   513	517	526	java/lang/Exception
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    int i = AEOldQuicResDownload.d();
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("isFilterSoExist confVer=");
    paramQQAppInterface.append(i);
    VideoEnvironment.LogDownLoad("AEOldQuicDownProcess", paramQQAppInterface.toString(), null);
    return i >= 3;
  }
  
  /* Error */
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 96	dov/com/qq/im/ae/download/old/AEOldQuicResDownload:d	()I
    //   3: istore 4
    //   5: invokestatic 99	dov/com/qq/im/ae/download/old/AEOldQuicResDownload:c	()Ljava/lang/String;
    //   8: astore 7
    //   10: aload 7
    //   12: invokestatic 56	dov/com/qq/im/ae/download/old/AEOldQuicResDownload:a	()Ljava/lang/String;
    //   15: invokevirtual 221	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +10 -> 28
    //   21: invokestatic 69	dov/com/qq/im/ae/download/old/AEOldQuicResDownload:b	()Ljava/lang/String;
    //   24: astore_1
    //   25: goto +24 -> 49
    //   28: aload 7
    //   30: invokestatic 69	dov/com/qq/im/ae/download/old/AEOldQuicResDownload:b	()Ljava/lang/String;
    //   33: invokevirtual 221	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +10 -> 46
    //   39: invokestatic 56	dov/com/qq/im/ae/download/old/AEOldQuicResDownload:a	()Ljava/lang/String;
    //   42: astore_1
    //   43: goto +6 -> 49
    //   46: ldc 223
    //   48: astore_1
    //   49: new 26	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   56: astore 8
    //   58: aload 8
    //   60: ldc 225
    //   62: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 8
    //   68: aload 7
    //   70: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 8
    //   76: ldc 227
    //   78: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 8
    //   84: aload_1
    //   85: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 8
    //   91: ldc 229
    //   93: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 8
    //   99: iload 4
    //   101: invokevirtual 36	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 8
    //   107: ldc 193
    //   109: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 8
    //   115: iload_3
    //   116: invokevirtual 36	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc 40
    //   122: aload 8
    //   124: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: aconst_null
    //   128: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   131: iconst_0
    //   132: istore 5
    //   134: iload_3
    //   135: iload 4
    //   137: if_icmpgt +5 -> 142
    //   140: iconst_0
    //   141: ireturn
    //   142: getstatic 15	dov/com/qq/im/ae/download/old/AEOldQuicResProcess:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   145: invokevirtual 231	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   148: ifeq +212 -> 360
    //   151: invokestatic 233	dov/com/qq/im/ae/download/old/AEOldQuicResProcess:a	()V
    //   154: aload_0
    //   155: aload_1
    //   156: iload_3
    //   157: invokestatic 128	dov/com/qq/im/ae/download/old/AEOldQuicResProcess:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;I)Z
    //   160: istore 6
    //   162: new 26	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   169: astore 8
    //   171: aload 8
    //   173: ldc 235
    //   175: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 8
    //   181: iload 6
    //   183: invokevirtual 89	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: ldc 40
    //   189: aload 8
    //   191: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: aconst_null
    //   195: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   198: iload 6
    //   200: ifeq +11 -> 211
    //   203: getstatic 15	dov/com/qq/im/ae/download/old/AEOldQuicResProcess:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   206: invokevirtual 238	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   209: iconst_0
    //   210: ireturn
    //   211: new 26	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   218: astore 8
    //   220: aload 8
    //   222: ldc 240
    //   224: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 8
    //   230: aload_1
    //   231: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: ldc 40
    //   237: aload 8
    //   239: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: aconst_null
    //   243: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: aload_1
    //   247: invokestatic 242	dov/com/qq/im/ae/download/old/AEOldQuicResProcess:a	(Ljava/lang/String;)V
    //   250: aload_2
    //   251: aload_1
    //   252: iconst_0
    //   253: invokestatic 248	com/tencent/mobileqq/utils/FileUtils:uncompressZip	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   256: aload_0
    //   257: aload_1
    //   258: iload_3
    //   259: invokestatic 128	dov/com/qq/im/ae/download/old/AEOldQuicResProcess:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;I)Z
    //   262: istore 6
    //   264: new 26	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   271: astore_0
    //   272: aload_0
    //   273: ldc 250
    //   275: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload_0
    //   280: iload 6
    //   282: invokevirtual 89	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: ldc 40
    //   288: aload_0
    //   289: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: aconst_null
    //   293: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   296: iload 6
    //   298: ifeq +17 -> 315
    //   301: aload_1
    //   302: iload_3
    //   303: invokestatic 253	dov/com/qq/im/ae/download/old/AEOldQuicResDownload:a	(Ljava/lang/String;I)Z
    //   306: pop
    //   307: aload 7
    //   309: invokestatic 242	dov/com/qq/im/ae/download/old/AEOldQuicResProcess:a	(Ljava/lang/String;)V
    //   312: goto +31 -> 343
    //   315: aload_1
    //   316: invokestatic 242	dov/com/qq/im/ae/download/old/AEOldQuicResProcess:a	(Ljava/lang/String;)V
    //   319: goto +24 -> 343
    //   322: astore_0
    //   323: goto +29 -> 352
    //   326: astore_0
    //   327: aload_0
    //   328: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   331: ldc 40
    //   333: ldc_w 258
    //   336: aload_0
    //   337: invokestatic 50	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: iconst_1
    //   341: istore 5
    //   343: getstatic 15	dov/com/qq/im/ae/download/old/AEOldQuicResProcess:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   346: invokevirtual 238	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   349: iload 5
    //   351: ireturn
    //   352: getstatic 15	dov/com/qq/im/ae/download/old/AEOldQuicResProcess:a	Ljava/util/concurrent/locks/ReentrantLock;
    //   355: invokevirtual 238	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   358: aload_0
    //   359: athrow
    //   360: iconst_0
    //   361: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	paramQQAppInterface	QQAppInterface
    //   0	362	1	paramString1	String
    //   0	362	2	paramString2	String
    //   0	362	3	paramInt	int
    //   3	135	4	i	int
    //   132	218	5	bool1	boolean
    //   160	137	6	bool2	boolean
    //   8	300	7	str	String
    //   56	182	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   151	198	322	finally
    //   211	296	322	finally
    //   301	312	322	finally
    //   315	319	322	finally
    //   327	340	322	finally
    //   151	198	326	java/lang/Exception
    //   211	296	326	java/lang/Exception
    //   301	312	326	java/lang/Exception
    //   315	319	326	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldQuicResProcess
 * JD-Core Version:    0.7.0.1
 */