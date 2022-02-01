package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.List;

public class CGILoader
  extends BaseCGILoader
{
  private static WeakReference<String> a;
  private static WeakReference<String[]> b;
  
  public static int a(int paramInt)
  {
    if (paramInt == 3000) {
      return 2;
    }
    if (paramInt == 1) {
      return 3;
    }
    return 1;
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 23
    //   2: iconst_2
    //   3: anewarray 25	java/lang/Object
    //   6: dup
    //   7: iconst_0
    //   8: aload_1
    //   9: aastore
    //   10: dup
    //   11: iconst_1
    //   12: aload_2
    //   13: invokestatic 31	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   16: aastore
    //   17: invokestatic 37	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   20: astore 6
    //   22: ldc 39
    //   24: astore_1
    //   25: aload_1
    //   26: astore_3
    //   27: aload_1
    //   28: astore 4
    //   30: aload_1
    //   31: astore 5
    //   33: aload_0
    //   34: aload 6
    //   36: aconst_null
    //   37: ldc 41
    //   39: aconst_null
    //   40: aconst_null
    //   41: sipush 10000
    //   44: sipush 10000
    //   47: invokestatic 47	com/tencent/biz/common/util/HttpUtil:openRequest	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;II)Lorg/apache/http/HttpResponse;
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull +443 -> 495
    //   55: aload_1
    //   56: astore_3
    //   57: aload_1
    //   58: astore 4
    //   60: aload_1
    //   61: astore 5
    //   63: aload_0
    //   64: invokeinterface 53 1 0
    //   69: invokeinterface 59 1 0
    //   74: sipush 200
    //   77: if_icmpne +418 -> 495
    //   80: aload_1
    //   81: astore_3
    //   82: aload_1
    //   83: astore 4
    //   85: aload_1
    //   86: astore 5
    //   88: aload_0
    //   89: invokestatic 63	com/tencent/biz/common/util/HttpUtil:readHttpResponse	(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   92: astore_0
    //   93: goto +3 -> 96
    //   96: aload_1
    //   97: astore_3
    //   98: aload_1
    //   99: astore 4
    //   101: aload_1
    //   102: astore 5
    //   104: aload_0
    //   105: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +173 -> 281
    //   111: aload_1
    //   112: astore_3
    //   113: aload_1
    //   114: astore 4
    //   116: aload_1
    //   117: astore 5
    //   119: new 71	org/json/JSONObject
    //   122: dup
    //   123: aload_0
    //   124: invokespecial 74	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   127: ldc 76
    //   129: invokevirtual 79	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: astore_0
    //   133: aload_0
    //   134: astore_3
    //   135: aload_0
    //   136: astore 4
    //   138: aload_0
    //   139: astore 5
    //   141: aload_0
    //   142: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifeq +85 -> 230
    //   148: aload_0
    //   149: astore_3
    //   150: aload_0
    //   151: astore 4
    //   153: aload_0
    //   154: astore 5
    //   156: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +71 -> 230
    //   162: aload_0
    //   163: astore_3
    //   164: aload_0
    //   165: astore 4
    //   167: aload_0
    //   168: astore 5
    //   170: new 87	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   177: astore 6
    //   179: aload_0
    //   180: astore_3
    //   181: aload_0
    //   182: astore 4
    //   184: aload_0
    //   185: astore 5
    //   187: aload 6
    //   189: ldc 90
    //   191: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_0
    //   196: astore_3
    //   197: aload_0
    //   198: astore 4
    //   200: aload_0
    //   201: astore_1
    //   202: aload 6
    //   204: aload_2
    //   205: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_0
    //   210: astore_3
    //   211: aload_0
    //   212: astore 4
    //   214: aload_0
    //   215: astore_1
    //   216: ldc 96
    //   218: iconst_2
    //   219: aload 6
    //   221: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: goto +3 -> 230
    //   230: aload_2
    //   231: invokestatic 106	com/tencent/mobileqq/structmsg/CGILoader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   234: astore_2
    //   235: aload_0
    //   236: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   239: ifeq +9 -> 248
    //   242: ldc 108
    //   244: astore_1
    //   245: goto +6 -> 251
    //   248: ldc 110
    //   250: astore_1
    //   251: aload_2
    //   252: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   255: ifne +24 -> 279
    //   258: aconst_null
    //   259: ldc 112
    //   261: ldc 39
    //   263: ldc 39
    //   265: aload_1
    //   266: aload_1
    //   267: iconst_0
    //   268: iconst_0
    //   269: ldc 39
    //   271: ldc 39
    //   273: aload_2
    //   274: ldc 39
    //   276: invokestatic 117	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload_0
    //   280: areturn
    //   281: aload_1
    //   282: astore_3
    //   283: aload_1
    //   284: astore 4
    //   286: new 19	java/io/IOException
    //   289: dup
    //   290: invokespecial 118	java/io/IOException:<init>	()V
    //   293: athrow
    //   294: astore_0
    //   295: goto +17 -> 312
    //   298: astore_0
    //   299: goto +80 -> 379
    //   302: astore_0
    //   303: aload_3
    //   304: astore_1
    //   305: goto +139 -> 444
    //   308: astore_0
    //   309: aload 4
    //   311: astore_3
    //   312: aload_3
    //   313: astore_1
    //   314: ldc 96
    //   316: iconst_1
    //   317: ldc 120
    //   319: aload_0
    //   320: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   323: aload_2
    //   324: invokestatic 106	com/tencent/mobileqq/structmsg/CGILoader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   327: astore_1
    //   328: aload_3
    //   329: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   332: ifeq +9 -> 341
    //   335: ldc 108
    //   337: astore_0
    //   338: goto +6 -> 344
    //   341: ldc 110
    //   343: astore_0
    //   344: aload_1
    //   345: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   348: ifne +24 -> 372
    //   351: aconst_null
    //   352: ldc 112
    //   354: ldc 39
    //   356: ldc 39
    //   358: aload_0
    //   359: aload_0
    //   360: iconst_0
    //   361: iconst_0
    //   362: ldc 39
    //   364: ldc 39
    //   366: aload_1
    //   367: ldc 39
    //   369: invokestatic 117	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   372: aconst_null
    //   373: areturn
    //   374: astore_0
    //   375: aload 5
    //   377: astore 4
    //   379: aload 4
    //   381: astore_1
    //   382: ldc 96
    //   384: iconst_1
    //   385: ldc 125
    //   387: aload_0
    //   388: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   391: aload_2
    //   392: invokestatic 106	com/tencent/mobileqq/structmsg/CGILoader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   395: astore_1
    //   396: aload 4
    //   398: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   401: ifeq +9 -> 410
    //   404: ldc 108
    //   406: astore_0
    //   407: goto +6 -> 413
    //   410: ldc 110
    //   412: astore_0
    //   413: aload_1
    //   414: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   417: ifne +24 -> 441
    //   420: aconst_null
    //   421: ldc 112
    //   423: ldc 39
    //   425: ldc 39
    //   427: aload_0
    //   428: aload_0
    //   429: iconst_0
    //   430: iconst_0
    //   431: ldc 39
    //   433: ldc 39
    //   435: aload_1
    //   436: ldc 39
    //   438: invokestatic 117	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   441: aconst_null
    //   442: areturn
    //   443: astore_0
    //   444: aload_2
    //   445: invokestatic 106	com/tencent/mobileqq/structmsg/CGILoader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   448: astore_2
    //   449: aload_1
    //   450: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   453: ifeq +9 -> 462
    //   456: ldc 108
    //   458: astore_1
    //   459: goto +6 -> 465
    //   462: ldc 110
    //   464: astore_1
    //   465: aload_2
    //   466: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   469: ifne +24 -> 493
    //   472: aconst_null
    //   473: ldc 112
    //   475: ldc 39
    //   477: ldc 39
    //   479: aload_1
    //   480: aload_1
    //   481: iconst_0
    //   482: iconst_0
    //   483: ldc 39
    //   485: ldc 39
    //   487: aload_2
    //   488: ldc 39
    //   490: invokestatic 117	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload_0
    //   494: athrow
    //   495: aconst_null
    //   496: astore_0
    //   497: goto -401 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	paramContext	android.content.Context
    //   0	500	1	paramString1	String
    //   0	500	2	paramString2	String
    //   26	303	3	localObject1	Object
    //   28	369	4	localObject2	Object
    //   31	345	5	localObject3	Object
    //   20	200	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   202	209	294	org/json/JSONException
    //   216	227	294	org/json/JSONException
    //   286	294	294	org/json/JSONException
    //   202	209	298	java/io/IOException
    //   216	227	298	java/io/IOException
    //   286	294	298	java/io/IOException
    //   33	51	302	finally
    //   63	80	302	finally
    //   88	93	302	finally
    //   104	111	302	finally
    //   119	133	302	finally
    //   141	148	302	finally
    //   156	162	302	finally
    //   170	179	302	finally
    //   187	195	302	finally
    //   33	51	308	org/json/JSONException
    //   63	80	308	org/json/JSONException
    //   88	93	308	org/json/JSONException
    //   104	111	308	org/json/JSONException
    //   119	133	308	org/json/JSONException
    //   141	148	308	org/json/JSONException
    //   156	162	308	org/json/JSONException
    //   170	179	308	org/json/JSONException
    //   187	195	308	org/json/JSONException
    //   33	51	374	java/io/IOException
    //   63	80	374	java/io/IOException
    //   88	93	374	java/io/IOException
    //   104	111	374	java/io/IOException
    //   119	133	374	java/io/IOException
    //   141	148	374	java/io/IOException
    //   156	162	374	java/io/IOException
    //   170	179	374	java/io/IOException
    //   187	195	374	java/io/IOException
    //   202	209	443	finally
    //   216	227	443	finally
    //   286	294	443	finally
    //   314	323	443	finally
    //   382	391	443	finally
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = new URL(paramString).getHost().split("\\.");
      StringBuilder localStringBuilder = new StringBuilder(paramString[(paramString.length - 2)]);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString[(paramString.length - 1)]);
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      label56:
      break label56;
    }
    return "";
  }
  
  public static boolean a(AbsShareMsg paramAbsShareMsg)
  {
    if ((paramAbsShareMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsShareMsg = ((StructMsgForGeneralShare)paramAbsShareMsg).getStructMsgItemLists();
      if (paramAbsShareMsg != null)
      {
        int i = 0;
        while (i < paramAbsShareMsg.size())
        {
          Object localObject = (AbsStructMsgElement)paramAbsShareMsg.get(i);
          if ((localObject instanceof StructMsgItemLayout5))
          {
            localObject = ((StructMsgItemLayout5)localObject).a;
            if (localObject != null)
            {
              int j = 0;
              while (j < ((List)localObject).size())
              {
                if (((AbsStructMsgElement)((List)localObject).get(j) instanceof StructMsgItemVideo)) {
                  return true;
                }
                j += 1;
              }
            }
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.CGILoader
 * JD-Core Version:    0.7.0.1
 */