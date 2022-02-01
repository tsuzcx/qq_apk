package com.tencent.mobileqq.scribble;

import com.qq.taf.jce.HexUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;

public class ScribbleUtils
{
  /* Error */
  public static java.lang.Boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 19	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   4: ifeq +8 -> 12
    //   7: aload_1
    //   8: invokestatic 22	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   11: pop
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 6
    //   18: new 24	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 27	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokevirtual 31	java/io/File:exists	()Z
    //   29: ifeq +114 -> 143
    //   32: new 33	java/io/FileInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 34	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   40: astore 5
    //   42: new 36	java/io/FileOutputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 37	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   50: astore_1
    //   51: sipush 1444
    //   54: newarray byte
    //   56: astore_0
    //   57: iconst_0
    //   58: istore_2
    //   59: aload 5
    //   61: aload_0
    //   62: invokevirtual 43	java/io/InputStream:read	([B)I
    //   65: istore_3
    //   66: iload_3
    //   67: iconst_m1
    //   68: if_icmpeq +24 -> 92
    //   71: iload_2
    //   72: iload_3
    //   73: iadd
    //   74: istore_2
    //   75: getstatic 49	java/lang/System:out	Ljava/io/PrintStream;
    //   78: iload_2
    //   79: invokevirtual 55	java/io/PrintStream:println	(I)V
    //   82: aload_1
    //   83: aload_0
    //   84: iconst_0
    //   85: iload_3
    //   86: invokevirtual 59	java/io/FileOutputStream:write	([BII)V
    //   89: goto -30 -> 59
    //   92: aload 5
    //   94: invokevirtual 62	java/io/InputStream:close	()V
    //   97: aload_1
    //   98: invokevirtual 65	java/io/FileOutputStream:flush	()V
    //   101: aload_1
    //   102: invokevirtual 66	java/io/FileOutputStream:close	()V
    //   105: goto +46 -> 151
    //   108: astore_0
    //   109: aload_1
    //   110: astore 4
    //   112: goto +12 -> 124
    //   115: astore 4
    //   117: goto +20 -> 137
    //   120: astore_0
    //   121: aconst_null
    //   122: astore 4
    //   124: aload 5
    //   126: astore_1
    //   127: aload_0
    //   128: astore 5
    //   130: goto +91 -> 221
    //   133: astore 4
    //   135: aconst_null
    //   136: astore_1
    //   137: aload 5
    //   139: astore_0
    //   140: goto +36 -> 176
    //   143: ldc 68
    //   145: iconst_1
    //   146: ldc 70
    //   148: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: iconst_1
    //   152: invokestatic 82	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   155: areturn
    //   156: astore 5
    //   158: aconst_null
    //   159: astore_0
    //   160: aload 4
    //   162: astore_1
    //   163: aload_0
    //   164: astore 4
    //   166: goto +55 -> 221
    //   169: astore 4
    //   171: aconst_null
    //   172: astore_1
    //   173: aload 6
    //   175: astore_0
    //   176: ldc 68
    //   178: iconst_1
    //   179: ldc 84
    //   181: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 4
    //   186: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   189: iconst_0
    //   190: invokestatic 82	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   193: astore 4
    //   195: aload_0
    //   196: ifnull +7 -> 203
    //   199: aload_0
    //   200: invokevirtual 62	java/io/InputStream:close	()V
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 66	java/io/FileOutputStream:close	()V
    //   211: aload 4
    //   213: areturn
    //   214: astore 5
    //   216: aload_1
    //   217: astore 4
    //   219: aload_0
    //   220: astore_1
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 62	java/io/InputStream:close	()V
    //   229: aload 4
    //   231: ifnull +8 -> 239
    //   234: aload 4
    //   236: invokevirtual 66	java/io/FileOutputStream:close	()V
    //   239: goto +6 -> 245
    //   242: aload 5
    //   244: athrow
    //   245: goto -3 -> 242
    //   248: astore_0
    //   249: aload 4
    //   251: areturn
    //   252: astore_0
    //   253: goto -14 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramString1	String
    //   0	256	1	paramString2	String
    //   58	21	2	i	int
    //   65	21	3	j	int
    //   13	98	4	str1	String
    //   115	1	4	localException1	java.lang.Exception
    //   122	1	4	localObject1	Object
    //   133	28	4	localException2	java.lang.Exception
    //   164	1	4	str2	String
    //   169	16	4	localException3	java.lang.Exception
    //   193	57	4	localObject2	Object
    //   40	98	5	localObject3	Object
    //   156	1	5	localObject4	Object
    //   214	29	5	localObject5	Object
    //   16	158	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   51	57	108	finally
    //   59	66	108	finally
    //   75	89	108	finally
    //   92	105	108	finally
    //   51	57	115	java/lang/Exception
    //   59	66	115	java/lang/Exception
    //   75	89	115	java/lang/Exception
    //   92	105	115	java/lang/Exception
    //   42	51	120	finally
    //   42	51	133	java/lang/Exception
    //   18	42	156	finally
    //   143	151	156	finally
    //   18	42	169	java/lang/Exception
    //   143	151	169	java/lang/Exception
    //   176	195	214	finally
    //   199	203	248	java/lang/Exception
    //   207	211	248	java/lang/Exception
    //   225	229	252	java/lang/Exception
    //   234	239	252	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 24	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 27	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 31	java/io/File:exists	()Z
    //   13: ifeq +389 -> 402
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 6
    //   22: new 33	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 93	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_0
    //   31: sipush 1024
    //   34: newarray byte
    //   36: astore 6
    //   38: iconst_0
    //   39: istore_3
    //   40: iload_3
    //   41: sipush 1024
    //   44: iadd
    //   45: istore 4
    //   47: iload 4
    //   49: iload_1
    //   50: if_icmpge +16 -> 66
    //   53: aload_0
    //   54: aload 6
    //   56: invokevirtual 94	java/io/FileInputStream:read	([B)I
    //   59: pop
    //   60: iload 4
    //   62: istore_3
    //   63: goto -23 -> 40
    //   66: iload_1
    //   67: iload_3
    //   68: isub
    //   69: istore_1
    //   70: iload_1
    //   71: ifgt +27 -> 98
    //   74: aload_0
    //   75: invokevirtual 95	java/io/FileInputStream:close	()V
    //   78: iconst_0
    //   79: ireturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   85: ldc 68
    //   87: iconst_1
    //   88: aload_0
    //   89: iconst_0
    //   90: anewarray 4	java/lang/Object
    //   93: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   96: iconst_0
    //   97: ireturn
    //   98: aload_0
    //   99: iload_1
    //   100: newarray byte
    //   102: invokevirtual 94	java/io/FileInputStream:read	([B)I
    //   105: pop
    //   106: new 24	java/io/File
    //   109: dup
    //   110: aload_2
    //   111: invokespecial 27	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore_2
    //   115: aload_2
    //   116: invokevirtual 103	java/io/File:getParentFile	()Ljava/io/File;
    //   119: invokevirtual 31	java/io/File:exists	()Z
    //   122: ifne +11 -> 133
    //   125: aload_2
    //   126: invokevirtual 103	java/io/File:getParentFile	()Ljava/io/File;
    //   129: invokevirtual 106	java/io/File:mkdirs	()Z
    //   132: pop
    //   133: new 36	java/io/FileOutputStream
    //   136: dup
    //   137: aload_2
    //   138: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   141: astore 6
    //   143: sipush 4096
    //   146: newarray byte
    //   148: astore_2
    //   149: aload_0
    //   150: aload_2
    //   151: invokevirtual 94	java/io/FileInputStream:read	([B)I
    //   154: istore_1
    //   155: iload_1
    //   156: iconst_m1
    //   157: if_icmpeq +14 -> 171
    //   160: aload 6
    //   162: aload_2
    //   163: iconst_0
    //   164: iload_1
    //   165: invokevirtual 59	java/io/FileOutputStream:write	([BII)V
    //   168: goto -19 -> 149
    //   171: aload 6
    //   173: invokevirtual 65	java/io/FileOutputStream:flush	()V
    //   176: aload_0
    //   177: invokevirtual 95	java/io/FileInputStream:close	()V
    //   180: goto +19 -> 199
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   188: ldc 68
    //   190: iconst_1
    //   191: aload_0
    //   192: iconst_0
    //   193: anewarray 4	java/lang/Object
    //   196: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   199: aload 6
    //   201: invokevirtual 66	java/io/FileOutputStream:close	()V
    //   204: goto +19 -> 223
    //   207: astore_0
    //   208: aload_0
    //   209: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   212: ldc 68
    //   214: iconst_1
    //   215: aload_0
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   223: iconst_1
    //   224: ireturn
    //   225: astore_2
    //   226: aload 6
    //   228: astore 5
    //   230: goto +114 -> 344
    //   233: astore 5
    //   235: aload 6
    //   237: astore_2
    //   238: goto +11 -> 249
    //   241: astore_2
    //   242: goto +102 -> 344
    //   245: astore 5
    //   247: aconst_null
    //   248: astore_2
    //   249: aload_0
    //   250: astore 6
    //   252: aload_2
    //   253: astore_0
    //   254: goto +13 -> 267
    //   257: astore_2
    //   258: aconst_null
    //   259: astore_0
    //   260: goto +84 -> 344
    //   263: astore 5
    //   265: aconst_null
    //   266: astore_0
    //   267: ldc 68
    //   269: iconst_1
    //   270: ldc 109
    //   272: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload 5
    //   277: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   280: aload 6
    //   282: ifnull +27 -> 309
    //   285: aload 6
    //   287: invokevirtual 95	java/io/FileInputStream:close	()V
    //   290: goto +19 -> 309
    //   293: astore_2
    //   294: aload_2
    //   295: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   298: ldc 68
    //   300: iconst_1
    //   301: aload_2
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   309: aload_0
    //   310: ifnull +100 -> 410
    //   313: aload_0
    //   314: invokevirtual 66	java/io/FileOutputStream:close	()V
    //   317: iconst_0
    //   318: ireturn
    //   319: astore_0
    //   320: aload_0
    //   321: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   324: ldc 68
    //   326: iconst_1
    //   327: aload_0
    //   328: iconst_0
    //   329: anewarray 4	java/lang/Object
    //   332: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   335: iconst_0
    //   336: ireturn
    //   337: astore_2
    //   338: aload_0
    //   339: astore 5
    //   341: aload 6
    //   343: astore_0
    //   344: aload_0
    //   345: ifnull +26 -> 371
    //   348: aload_0
    //   349: invokevirtual 95	java/io/FileInputStream:close	()V
    //   352: goto +19 -> 371
    //   355: astore_0
    //   356: aload_0
    //   357: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   360: ldc 68
    //   362: iconst_1
    //   363: aload_0
    //   364: iconst_0
    //   365: anewarray 4	java/lang/Object
    //   368: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   371: aload 5
    //   373: ifnull +27 -> 400
    //   376: aload 5
    //   378: invokevirtual 66	java/io/FileOutputStream:close	()V
    //   381: goto +19 -> 400
    //   384: astore_0
    //   385: aload_0
    //   386: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   389: ldc 68
    //   391: iconst_1
    //   392: aload_0
    //   393: iconst_0
    //   394: anewarray 4	java/lang/Object
    //   397: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   400: aload_2
    //   401: athrow
    //   402: ldc 68
    //   404: iconst_1
    //   405: ldc 111
    //   407: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: iconst_0
    //   411: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	paramString1	String
    //   0	412	1	paramInt	int
    //   0	412	2	paramString2	String
    //   39	30	3	i	int
    //   45	16	4	j	int
    //   17	212	5	localObject1	Object
    //   233	1	5	localException1	java.lang.Exception
    //   245	1	5	localException2	java.lang.Exception
    //   263	13	5	localException3	java.lang.Exception
    //   339	38	5	str	String
    //   20	322	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   74	78	80	java/io/IOException
    //   176	180	183	java/io/IOException
    //   199	204	207	java/io/IOException
    //   143	149	225	finally
    //   149	155	225	finally
    //   160	168	225	finally
    //   171	176	225	finally
    //   143	149	233	java/lang/Exception
    //   149	155	233	java/lang/Exception
    //   160	168	233	java/lang/Exception
    //   171	176	233	java/lang/Exception
    //   31	38	241	finally
    //   53	60	241	finally
    //   98	133	241	finally
    //   133	143	241	finally
    //   31	38	245	java/lang/Exception
    //   53	60	245	java/lang/Exception
    //   98	133	245	java/lang/Exception
    //   133	143	245	java/lang/Exception
    //   22	31	257	finally
    //   22	31	263	java/lang/Exception
    //   285	290	293	java/io/IOException
    //   313	317	319	java/io/IOException
    //   267	280	337	finally
    //   348	352	355	java/io/IOException
    //   376	381	384	java/io/IOException
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 6
    //   12: new 36	java/io/FileOutputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 37	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload 8
    //   23: astore 5
    //   25: aload_2
    //   26: astore 4
    //   28: aload_2
    //   29: aload_0
    //   30: iconst_0
    //   31: aload_0
    //   32: arraylength
    //   33: invokevirtual 59	java/io/FileOutputStream:write	([BII)V
    //   36: aload 8
    //   38: astore 5
    //   40: aload_2
    //   41: astore 4
    //   43: new 33	java/io/FileInputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 34	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   51: astore_0
    //   52: sipush 4096
    //   55: newarray byte
    //   57: astore_1
    //   58: aload_0
    //   59: aload_1
    //   60: invokevirtual 94	java/io/FileInputStream:read	([B)I
    //   63: istore_3
    //   64: iload_3
    //   65: iconst_m1
    //   66: if_icmpeq +13 -> 79
    //   69: aload_2
    //   70: aload_1
    //   71: iconst_0
    //   72: iload_3
    //   73: invokevirtual 59	java/io/FileOutputStream:write	([BII)V
    //   76: goto -18 -> 58
    //   79: aload_0
    //   80: invokevirtual 95	java/io/FileInputStream:close	()V
    //   83: aload_2
    //   84: invokevirtual 66	java/io/FileOutputStream:close	()V
    //   87: iconst_1
    //   88: ireturn
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   94: ldc 68
    //   96: iconst_1
    //   97: aload_0
    //   98: iconst_0
    //   99: anewarray 4	java/lang/Object
    //   102: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: aload_0
    //   108: astore 5
    //   110: goto +192 -> 302
    //   113: astore_1
    //   114: goto +32 -> 146
    //   117: astore_1
    //   118: goto +109 -> 227
    //   121: astore_1
    //   122: aload 6
    //   124: astore_0
    //   125: goto +21 -> 146
    //   128: astore_1
    //   129: aload 7
    //   131: astore_0
    //   132: goto +95 -> 227
    //   135: aconst_null
    //   136: astore_2
    //   137: goto +165 -> 302
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_2
    //   143: aload 6
    //   145: astore_0
    //   146: aload_0
    //   147: astore 5
    //   149: aload_2
    //   150: astore 4
    //   152: aload_1
    //   153: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   156: aload_0
    //   157: astore 5
    //   159: aload_2
    //   160: astore 4
    //   162: ldc 68
    //   164: iconst_1
    //   165: aload_1
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   173: aload_0
    //   174: ifnull +10 -> 184
    //   177: aload_0
    //   178: invokevirtual 95	java/io/FileInputStream:close	()V
    //   181: goto +3 -> 184
    //   184: aload_2
    //   185: ifnull +9 -> 194
    //   188: aload_2
    //   189: invokevirtual 66	java/io/FileOutputStream:close	()V
    //   192: iconst_1
    //   193: ireturn
    //   194: ldc 68
    //   196: iconst_1
    //   197: ldc 116
    //   199: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: iconst_0
    //   203: ireturn
    //   204: aload_0
    //   205: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   208: ldc 68
    //   210: iconst_1
    //   211: aload_0
    //   212: iconst_0
    //   213: anewarray 4	java/lang/Object
    //   216: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_2
    //   224: aload 7
    //   226: astore_0
    //   227: aload_0
    //   228: astore 5
    //   230: aload_2
    //   231: astore 4
    //   233: aload_1
    //   234: invokevirtual 117	java/io/FileNotFoundException:printStackTrace	()V
    //   237: aload_0
    //   238: astore 5
    //   240: aload_2
    //   241: astore 4
    //   243: ldc 68
    //   245: iconst_1
    //   246: aload_1
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   254: aload_0
    //   255: ifnull +10 -> 265
    //   258: aload_0
    //   259: invokevirtual 95	java/io/FileInputStream:close	()V
    //   262: goto +3 -> 265
    //   265: aload_2
    //   266: ifnull +9 -> 275
    //   269: aload_2
    //   270: invokevirtual 66	java/io/FileOutputStream:close	()V
    //   273: iconst_1
    //   274: ireturn
    //   275: ldc 68
    //   277: iconst_1
    //   278: ldc 116
    //   280: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: iconst_0
    //   284: ireturn
    //   285: aload_0
    //   286: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   289: ldc 68
    //   291: iconst_1
    //   292: aload_0
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   300: iconst_0
    //   301: ireturn
    //   302: aload 5
    //   304: ifnull +11 -> 315
    //   307: aload 5
    //   309: invokevirtual 95	java/io/FileInputStream:close	()V
    //   312: goto +3 -> 315
    //   315: aload_2
    //   316: ifnull +9 -> 325
    //   319: aload_2
    //   320: invokevirtual 66	java/io/FileOutputStream:close	()V
    //   323: iconst_1
    //   324: ireturn
    //   325: ldc 68
    //   327: iconst_1
    //   328: ldc 116
    //   330: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: iconst_0
    //   334: ireturn
    //   335: aload_0
    //   336: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   339: ldc 68
    //   341: iconst_1
    //   342: aload_0
    //   343: iconst_0
    //   344: anewarray 4	java/lang/Object
    //   347: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   350: iconst_0
    //   351: ireturn
    //   352: astore_0
    //   353: goto -218 -> 135
    //   356: astore_0
    //   357: aload 4
    //   359: astore_2
    //   360: goto -58 -> 302
    //   363: astore_1
    //   364: goto -257 -> 107
    //   367: astore_0
    //   368: goto -164 -> 204
    //   371: astore_0
    //   372: goto -87 -> 285
    //   375: astore_0
    //   376: goto -41 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramArrayOfByte	byte[]
    //   0	379	1	paramString1	String
    //   0	379	2	paramString2	String
    //   63	10	3	i	int
    //   26	332	4	str	String
    //   4	304	5	localObject1	Object
    //   10	134	6	localObject2	Object
    //   1	224	7	localObject3	Object
    //   7	30	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   79	87	89	java/io/IOException
    //   52	58	113	java/io/IOException
    //   58	64	113	java/io/IOException
    //   69	76	113	java/io/IOException
    //   52	58	117	java/io/FileNotFoundException
    //   58	64	117	java/io/FileNotFoundException
    //   69	76	117	java/io/FileNotFoundException
    //   28	36	121	java/io/IOException
    //   43	52	121	java/io/IOException
    //   28	36	128	java/io/FileNotFoundException
    //   43	52	128	java/io/FileNotFoundException
    //   12	21	140	java/io/IOException
    //   12	21	221	java/io/FileNotFoundException
    //   12	21	352	finally
    //   28	36	356	finally
    //   43	52	356	finally
    //   152	156	356	finally
    //   162	173	356	finally
    //   233	237	356	finally
    //   243	254	356	finally
    //   52	58	363	finally
    //   58	64	363	finally
    //   69	76	363	finally
    //   177	181	367	java/io/IOException
    //   188	192	367	java/io/IOException
    //   194	202	367	java/io/IOException
    //   258	262	371	java/io/IOException
    //   269	273	371	java/io/IOException
    //   275	283	371	java/io/IOException
    //   307	312	375	java/io/IOException
    //   319	323	375	java/io/IOException
    //   325	333	375	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 120	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 121	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: new 33	java/io/FileInputStream
    //   11: dup
    //   12: new 24	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 27	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: invokespecial 93	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_2
    //   24: aload_2
    //   25: astore_0
    //   26: sipush 1024
    //   29: newarray byte
    //   31: astore 4
    //   33: aload_2
    //   34: astore_0
    //   35: aload_2
    //   36: aload 4
    //   38: invokevirtual 94	java/io/FileInputStream:read	([B)I
    //   41: istore_1
    //   42: iload_1
    //   43: iconst_m1
    //   44: if_icmpeq +16 -> 60
    //   47: aload_2
    //   48: astore_0
    //   49: aload_3
    //   50: aload 4
    //   52: iconst_0
    //   53: iload_1
    //   54: invokevirtual 122	java/io/ByteArrayOutputStream:write	([BII)V
    //   57: goto -24 -> 33
    //   60: aload_2
    //   61: astore_0
    //   62: aload_3
    //   63: invokevirtual 126	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   66: astore_3
    //   67: aload_2
    //   68: invokevirtual 95	java/io/FileInputStream:close	()V
    //   71: aload_3
    //   72: areturn
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   78: ldc 68
    //   80: iconst_1
    //   81: aload_0
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   89: aload_3
    //   90: areturn
    //   91: astore_3
    //   92: goto +15 -> 107
    //   95: astore_3
    //   96: goto +61 -> 157
    //   99: aconst_null
    //   100: astore_0
    //   101: goto +103 -> 204
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: astore_0
    //   109: aload_3
    //   110: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   113: aload_2
    //   114: astore_0
    //   115: ldc 68
    //   117: iconst_1
    //   118: aload_3
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   126: aload_2
    //   127: ifnull +25 -> 152
    //   130: aload_2
    //   131: invokevirtual 95	java/io/FileInputStream:close	()V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   141: ldc 68
    //   143: iconst_1
    //   144: aload_0
    //   145: iconst_0
    //   146: anewarray 4	java/lang/Object
    //   149: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_2
    //   158: astore_0
    //   159: aload_3
    //   160: invokevirtual 117	java/io/FileNotFoundException:printStackTrace	()V
    //   163: aload_2
    //   164: astore_0
    //   165: ldc 68
    //   167: iconst_1
    //   168: aload_3
    //   169: iconst_0
    //   170: anewarray 4	java/lang/Object
    //   173: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   176: aload_2
    //   177: ifnull +25 -> 202
    //   180: aload_2
    //   181: invokevirtual 95	java/io/FileInputStream:close	()V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   191: ldc 68
    //   193: iconst_1
    //   194: aload_0
    //   195: iconst_0
    //   196: anewarray 4	java/lang/Object
    //   199: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   202: aconst_null
    //   203: areturn
    //   204: aload_0
    //   205: ifnull +25 -> 230
    //   208: aload_0
    //   209: invokevirtual 95	java/io/FileInputStream:close	()V
    //   212: aconst_null
    //   213: areturn
    //   214: astore_0
    //   215: aload_0
    //   216: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   219: ldc 68
    //   221: iconst_1
    //   222: aload_0
    //   223: iconst_0
    //   224: anewarray 4	java/lang/Object
    //   227: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   230: aconst_null
    //   231: areturn
    //   232: astore_0
    //   233: goto -134 -> 99
    //   236: astore_2
    //   237: goto -33 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   41	13	1	i	int
    //   23	158	2	localFileInputStream	java.io.FileInputStream
    //   236	1	2	localObject1	Object
    //   7	83	3	localObject2	Object
    //   91	1	3	localIOException1	IOException
    //   95	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   104	15	3	localIOException2	IOException
    //   154	15	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   31	20	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   67	71	73	java/io/IOException
    //   26	33	91	java/io/IOException
    //   35	42	91	java/io/IOException
    //   49	57	91	java/io/IOException
    //   62	67	91	java/io/IOException
    //   26	33	95	java/io/FileNotFoundException
    //   35	42	95	java/io/FileNotFoundException
    //   49	57	95	java/io/FileNotFoundException
    //   62	67	95	java/io/FileNotFoundException
    //   8	24	104	java/io/IOException
    //   130	134	136	java/io/IOException
    //   8	24	154	java/io/FileNotFoundException
    //   180	184	186	java/io/IOException
    //   208	212	214	java/io/IOException
    //   8	24	232	finally
    //   26	33	236	finally
    //   35	42	236	finally
    //   49	57	236	finally
    //   62	67	236	finally
    //   109	113	236	finally
    //   115	126	236	finally
    //   159	163	236	finally
    //   165	176	236	finally
  }
  
  public static String b(String paramString)
  {
    localObject1 = "";
    try
    {
      try
      {
        localObject2 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
        paramString = (String)localObject2;
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        paramString = (String)localObject1;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Object localObject2;
      label26:
      break label26;
    }
    localObject2 = new File(paramString);
    paramString = (String)localObject1;
    if (((File)localObject2).exists()) {}
    try
    {
      paramString = MD5FileUtil.a((File)localObject2);
      if (paramString == null) {
        paramString = "";
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString = (String)localObject1;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("calcMD5 md5:");
    ((StringBuilder)localObject1).append(paramString);
    QLog.i("ScribbleUtils", 1, ((StringBuilder)localObject1).toString());
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleUtils
 * JD-Core Version:    0.7.0.1
 */