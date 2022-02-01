package com.tencent.securitysdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;

public class Verify
{
  /* Error */
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 18	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()Ljava/lang/String;
    //   3: astore 6
    //   5: ldc 20
    //   7: astore 5
    //   9: aload 6
    //   11: astore 4
    //   13: aload 6
    //   15: ifnonnull +7 -> 22
    //   18: ldc 20
    //   20: astore 4
    //   22: new 22	MAAccessClient/AcCode
    //   25: dup
    //   26: aload 4
    //   28: invokestatic 27	com/tencent/common/config/AppSetting:a	()I
    //   31: invokestatic 33	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   34: invokestatic 39	android/os/SystemClock:uptimeMillis	()J
    //   37: invokestatic 42	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: getstatic 48	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   43: invokestatic 53	com/tencent/mobileqq/cooperation/ApkUtils:a	(Landroid/content/Context;)I
    //   46: invokespecial 56	MAAccessClient/AcCode:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   49: invokevirtual 60	MAAccessClient/AcCode:toByteArray	()[B
    //   52: astore 7
    //   54: aload_0
    //   55: invokevirtual 65	android/content/Context:getPackageName	()Ljava/lang/String;
    //   58: astore 6
    //   60: aload 6
    //   62: invokevirtual 68	java/lang/String:length	()I
    //   65: istore_2
    //   66: bipush 16
    //   68: iload_2
    //   69: idiv
    //   70: istore_1
    //   71: bipush 16
    //   73: iload_2
    //   74: irem
    //   75: istore_2
    //   76: aload 5
    //   78: astore 4
    //   80: iload_1
    //   81: ifle +42 -> 123
    //   84: new 70	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   91: astore 5
    //   93: aload 5
    //   95: aload 4
    //   97: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 5
    //   103: aload 6
    //   105: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 5
    //   111: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore 4
    //   116: iload_1
    //   117: iconst_1
    //   118: isub
    //   119: istore_1
    //   120: goto -40 -> 80
    //   123: iconst_0
    //   124: istore_3
    //   125: aload 4
    //   127: astore 5
    //   129: iload_2
    //   130: ifle +40 -> 170
    //   133: new 70	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   140: astore 5
    //   142: aload 5
    //   144: aload 4
    //   146: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 5
    //   152: aload 6
    //   154: iconst_0
    //   155: iload_2
    //   156: invokevirtual 82	java/lang/String:substring	(II)Ljava/lang/String;
    //   159: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 5
    //   165: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: astore 5
    //   170: aload 5
    //   172: invokevirtual 85	java/lang/String:getBytes	()[B
    //   175: astore 4
    //   177: aconst_null
    //   178: astore 6
    //   180: aconst_null
    //   181: astore 5
    //   183: new 87	com/tencent/qphone/base/util/Cryptor
    //   186: dup
    //   187: invokespecial 88	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   190: aload 7
    //   192: aload 4
    //   194: invokevirtual 92	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   197: astore 4
    //   199: goto +6 -> 205
    //   202: aconst_null
    //   203: astore 4
    //   205: aload 4
    //   207: ifnull +152 -> 359
    //   210: aload_0
    //   211: invokestatic 98	com/tencent/commonsdk/soload/SoLoadCore:getAppWorkPath	(Landroid/content/Context;)Ljava/lang/String;
    //   214: astore_0
    //   215: new 70	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   222: astore 7
    //   224: aload 7
    //   226: aload_0
    //   227: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 7
    //   233: ldc 100
    //   235: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: new 102	java/io/File
    //   242: dup
    //   243: aload 7
    //   245: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   251: astore_0
    //   252: aload_0
    //   253: invokevirtual 109	java/io/File:getParentFile	()Ljava/io/File;
    //   256: astore 7
    //   258: aload 7
    //   260: invokevirtual 113	java/io/File:exists	()Z
    //   263: ifeq +11 -> 274
    //   266: aload 7
    //   268: invokevirtual 116	java/io/File:isDirectory	()Z
    //   271: ifne +9 -> 280
    //   274: aload 7
    //   276: invokevirtual 119	java/io/File:mkdirs	()Z
    //   279: pop
    //   280: aload_0
    //   281: invokevirtual 113	java/io/File:exists	()Z
    //   284: ifeq +8 -> 292
    //   287: aload_0
    //   288: invokevirtual 122	java/io/File:delete	()Z
    //   291: pop
    //   292: aload_0
    //   293: invokevirtual 125	java/io/File:createNewFile	()Z
    //   296: pop
    //   297: new 127	java/io/FileOutputStream
    //   300: dup
    //   301: aload_0
    //   302: invokespecial 130	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   305: astore_0
    //   306: aload_0
    //   307: aload 4
    //   309: invokevirtual 134	java/io/FileOutputStream:write	([B)V
    //   312: iconst_1
    //   313: istore_3
    //   314: aload_0
    //   315: invokevirtual 137	java/io/FileOutputStream:close	()V
    //   318: iconst_1
    //   319: ireturn
    //   320: astore 5
    //   322: aload_0
    //   323: astore 4
    //   325: aload 5
    //   327: astore_0
    //   328: goto +11 -> 339
    //   331: goto +20 -> 351
    //   334: astore_0
    //   335: aload 5
    //   337: astore 4
    //   339: aload 4
    //   341: ifnull +8 -> 349
    //   344: aload 4
    //   346: invokevirtual 137	java/io/FileOutputStream:close	()V
    //   349: aload_0
    //   350: athrow
    //   351: aload_0
    //   352: ifnull +7 -> 359
    //   355: aload_0
    //   356: invokevirtual 137	java/io/FileOutputStream:close	()V
    //   359: iconst_0
    //   360: ireturn
    //   361: astore 4
    //   363: goto -161 -> 202
    //   366: astore_0
    //   367: aload 6
    //   369: astore_0
    //   370: goto -19 -> 351
    //   373: astore 4
    //   375: goto -44 -> 331
    //   378: astore_0
    //   379: iload_3
    //   380: ireturn
    //   381: astore 4
    //   383: goto -34 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramContext	Context
    //   70	50	1	i	int
    //   65	91	2	j	int
    //   124	256	3	bool	boolean
    //   11	334	4	localObject1	Object
    //   361	1	4	localException1	Exception
    //   373	1	4	localException2	Exception
    //   381	1	4	localException3	Exception
    //   7	175	5	localObject2	Object
    //   320	16	5	localObject3	Object
    //   3	365	6	str	String
    //   52	223	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   306	312	320	finally
    //   292	306	334	finally
    //   183	199	361	java/lang/Exception
    //   292	306	366	java/lang/Exception
    //   306	312	373	java/lang/Exception
    //   314	318	378	java/lang/Exception
    //   355	359	378	java/lang/Exception
    //   344	349	381	java/lang/Exception
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageInfo(paramString1, 64);
      if (((PackageInfo)localObject).signatures.length >= 1) {
        localObject = MD5.a(localObject.signatures[(localObject.signatures.length - 1)].toCharsString());
      } else {
        localObject = "";
      }
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        bool1 = bool2;
        if (((String)localObject).equals(paramString2))
        {
          int i = ApkInfoParser.a(paramContext, paramString1);
          bool1 = bool2;
          if (i < paramInt) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  /* Error */
  public static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 98	com/tencent/commonsdk/soload/SoLoadCore:getAppWorkPath	(Landroid/content/Context;)Ljava/lang/String;
    //   4: astore 6
    //   6: new 70	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   13: astore 7
    //   15: aload 7
    //   17: aload 6
    //   19: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 7
    //   25: ldc 100
    //   27: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: new 102	java/io/File
    //   34: dup
    //   35: aload 7
    //   37: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore 6
    //   45: aload 6
    //   47: invokevirtual 113	java/io/File:exists	()Z
    //   50: istore 5
    //   52: iconst_0
    //   53: istore 4
    //   55: iload 4
    //   57: istore_3
    //   58: iload 5
    //   60: ifeq +432 -> 492
    //   63: iload 4
    //   65: istore_3
    //   66: aload 6
    //   68: invokevirtual 183	java/io/File:isFile	()Z
    //   71: ifeq +421 -> 492
    //   74: aconst_null
    //   75: astore 8
    //   77: new 185	java/io/FileInputStream
    //   80: dup
    //   81: aload 6
    //   83: invokespecial 186	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: astore 7
    //   88: new 188	java/io/ByteArrayOutputStream
    //   91: dup
    //   92: sipush 128
    //   95: invokespecial 191	java/io/ByteArrayOutputStream:<init>	(I)V
    //   98: astore 6
    //   100: sipush 128
    //   103: newarray byte
    //   105: astore 9
    //   107: aload 7
    //   109: aload 9
    //   111: invokevirtual 195	java/io/FileInputStream:read	([B)I
    //   114: istore_1
    //   115: iload_1
    //   116: ifle +23 -> 139
    //   119: aload 6
    //   121: aload 9
    //   123: iconst_0
    //   124: iload_1
    //   125: invokevirtual 198	java/io/ByteArrayOutputStream:write	([BII)V
    //   128: aload 7
    //   130: aload 9
    //   132: invokevirtual 195	java/io/FileInputStream:read	([B)I
    //   135: istore_1
    //   136: goto -21 -> 115
    //   139: aload 6
    //   141: invokevirtual 199	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   144: astore 9
    //   146: aload 6
    //   148: invokevirtual 200	java/io/ByteArrayOutputStream:close	()V
    //   151: aload 7
    //   153: invokevirtual 201	java/io/FileInputStream:close	()V
    //   156: aload 9
    //   158: astore 6
    //   160: goto +89 -> 249
    //   163: astore_0
    //   164: goto +27 -> 191
    //   167: goto +56 -> 223
    //   170: astore_0
    //   171: aconst_null
    //   172: astore 6
    //   174: goto +17 -> 191
    //   177: aconst_null
    //   178: astore 6
    //   180: goto +43 -> 223
    //   183: astore_0
    //   184: aconst_null
    //   185: astore 6
    //   187: aload 6
    //   189: astore 7
    //   191: aload 6
    //   193: ifnull +11 -> 204
    //   196: aload 6
    //   198: invokevirtual 200	java/io/ByteArrayOutputStream:close	()V
    //   201: goto +3 -> 204
    //   204: aload 7
    //   206: ifnull +8 -> 214
    //   209: aload 7
    //   211: invokevirtual 201	java/io/FileInputStream:close	()V
    //   214: aload_0
    //   215: athrow
    //   216: aconst_null
    //   217: astore 6
    //   219: aload 6
    //   221: astore 7
    //   223: aload 6
    //   225: ifnull +11 -> 236
    //   228: aload 6
    //   230: invokevirtual 200	java/io/ByteArrayOutputStream:close	()V
    //   233: goto +3 -> 236
    //   236: aload 7
    //   238: ifnull +8 -> 246
    //   241: aload 7
    //   243: invokevirtual 201	java/io/FileInputStream:close	()V
    //   246: aconst_null
    //   247: astore 6
    //   249: aload_0
    //   250: invokevirtual 65	android/content/Context:getPackageName	()Ljava/lang/String;
    //   253: astore 9
    //   255: aload 9
    //   257: invokevirtual 68	java/lang/String:length	()I
    //   260: istore_2
    //   261: bipush 16
    //   263: iload_2
    //   264: idiv
    //   265: istore_1
    //   266: bipush 16
    //   268: iload_2
    //   269: irem
    //   270: istore_2
    //   271: ldc 20
    //   273: astore_0
    //   274: iload_1
    //   275: ifle +40 -> 315
    //   278: new 70	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   285: astore 7
    //   287: aload 7
    //   289: aload_0
    //   290: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 7
    //   296: aload 9
    //   298: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 7
    //   304: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: astore_0
    //   308: iload_1
    //   309: iconst_1
    //   310: isub
    //   311: istore_1
    //   312: goto -38 -> 274
    //   315: aload_0
    //   316: astore 7
    //   318: iload_2
    //   319: ifle +39 -> 358
    //   322: new 70	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   329: astore 7
    //   331: aload 7
    //   333: aload_0
    //   334: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 7
    //   340: aload 9
    //   342: iconst_0
    //   343: iload_2
    //   344: invokevirtual 82	java/lang/String:substring	(II)Ljava/lang/String;
    //   347: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 7
    //   353: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: astore 7
    //   358: aload 7
    //   360: invokevirtual 85	java/lang/String:getBytes	()[B
    //   363: astore_0
    //   364: new 87	com/tencent/qphone/base/util/Cryptor
    //   367: dup
    //   368: invokespecial 88	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   371: aload 6
    //   373: aload_0
    //   374: invokevirtual 204	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   377: astore_0
    //   378: goto +5 -> 383
    //   381: aconst_null
    //   382: astore_0
    //   383: aload 8
    //   385: astore 6
    //   387: aload_0
    //   388: ifnull +30 -> 418
    //   391: new 206	com/qq/taf/jce/JceInputStream
    //   394: dup
    //   395: aload_0
    //   396: invokespecial 208	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   399: astore_0
    //   400: new 22	MAAccessClient/AcCode
    //   403: dup
    //   404: invokespecial 209	MAAccessClient/AcCode:<init>	()V
    //   407: astore 6
    //   409: aload 6
    //   411: aload_0
    //   412: invokevirtual 213	MAAccessClient/AcCode:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   415: goto +3 -> 418
    //   418: getstatic 48	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   421: invokestatic 53	com/tencent/mobileqq/cooperation/ApkUtils:a	(Landroid/content/Context;)I
    //   424: istore_1
    //   425: iload 4
    //   427: istore_3
    //   428: aload 6
    //   430: ifnull +62 -> 492
    //   433: aload 6
    //   435: getfield 217	MAAccessClient/AcCode:imei	Ljava/lang/String;
    //   438: ifnull +20 -> 458
    //   441: iload 4
    //   443: istore_3
    //   444: aload 6
    //   446: getfield 217	MAAccessClient/AcCode:imei	Ljava/lang/String;
    //   449: invokestatic 18	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()Ljava/lang/String;
    //   452: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   455: ifeq +37 -> 492
    //   458: iload 4
    //   460: istore_3
    //   461: invokestatic 27	com/tencent/common/config/AppSetting:a	()I
    //   464: invokestatic 33	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   467: aload 6
    //   469: getfield 220	MAAccessClient/AcCode:appid	Ljava/lang/String;
    //   472: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   475: ifeq +17 -> 492
    //   478: iload 4
    //   480: istore_3
    //   481: iload_1
    //   482: aload 6
    //   484: getfield 224	MAAccessClient/AcCode:versionCode	I
    //   487: if_icmpne +5 -> 492
    //   490: iconst_1
    //   491: istore_3
    //   492: iload_3
    //   493: ireturn
    //   494: astore 6
    //   496: goto -280 -> 216
    //   499: astore 6
    //   501: goto -324 -> 177
    //   504: astore 9
    //   506: goto -339 -> 167
    //   509: astore 6
    //   511: goto -360 -> 151
    //   514: astore 6
    //   516: aload 9
    //   518: astore 6
    //   520: goto -271 -> 249
    //   523: astore 6
    //   525: goto -321 -> 204
    //   528: astore 6
    //   530: goto -316 -> 214
    //   533: astore 6
    //   535: goto -299 -> 236
    //   538: astore 6
    //   540: goto -294 -> 246
    //   543: astore_0
    //   544: goto -163 -> 381
    //   547: astore_0
    //   548: aload 8
    //   550: astore 6
    //   552: goto -134 -> 418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	555	0	paramContext	Context
    //   114	374	1	i	int
    //   260	84	2	j	int
    //   57	436	3	bool1	boolean
    //   53	426	4	bool2	boolean
    //   50	9	5	bool3	boolean
    //   4	479	6	localObject1	Object
    //   494	1	6	localException1	Exception
    //   499	1	6	localException2	Exception
    //   509	1	6	localException3	Exception
    //   514	1	6	localException4	Exception
    //   518	1	6	localObject2	Object
    //   523	1	6	localException5	Exception
    //   528	1	6	localException6	Exception
    //   533	1	6	localException7	Exception
    //   538	1	6	localException8	Exception
    //   550	1	6	localObject3	Object
    //   13	346	7	localObject4	Object
    //   75	474	8	localObject5	Object
    //   105	236	9	localObject6	Object
    //   504	13	9	localException9	Exception
    // Exception table:
    //   from	to	target	type
    //   100	115	163	finally
    //   119	136	163	finally
    //   139	146	163	finally
    //   88	100	170	finally
    //   77	88	183	finally
    //   77	88	494	java/lang/Exception
    //   88	100	499	java/lang/Exception
    //   100	115	504	java/lang/Exception
    //   119	136	504	java/lang/Exception
    //   139	146	504	java/lang/Exception
    //   146	151	509	java/lang/Exception
    //   151	156	514	java/lang/Exception
    //   196	201	523	java/lang/Exception
    //   209	214	528	java/lang/Exception
    //   228	233	533	java/lang/Exception
    //   241	246	538	java/lang/Exception
    //   364	378	543	java/lang/Exception
    //   391	415	547	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securitysdk.utils.Verify
 * JD-Core Version:    0.7.0.1
 */