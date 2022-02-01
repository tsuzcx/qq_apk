package com.tencent.mqq.shared_file_accessor;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;

public class Utils
{
  private static final int BUF_SIZE = 12288;
  private static final String CP_URI_BASE = "content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/save";
  private static final String LOG_TAG = "Utils";
  private static final Uri SAVE_CMD_URI = Uri.parse("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/save");
  private static SoftReference<ByteArrayOutputStream> mBuffer = null;
  static String sCurrentProcessName = "";
  static boolean sIsSameProcessAsCP = false;
  
  private static ByteArrayOutputStream ensureBuffer()
  {
    Object localObject = mBuffer;
    if (localObject != null)
    {
      localObject = (ByteArrayOutputStream)((SoftReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    try
    {
      localObject = new ByteArrayOutputStream(12288);
      mBuffer = new SoftReference(localObject);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label46:
      break label46;
    }
    return null;
  }
  
  static Utils.StackInfo getMiniStackInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i1 = arrayOfStackTraceElement.length;
    int k = 0;
    Object localObject2 = "";
    Object localObject1 = localObject2;
    int m = 0;
    int i = 0;
    while (k < i1)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[k];
      String str = localStackTraceElement.getClassName();
      int n = m;
      int j = i;
      Object localObject4 = localObject2;
      Object localObject3 = localObject1;
      if (!str.contains("SPStatInspector"))
      {
        n = m;
        j = i;
        localObject4 = localObject2;
        localObject3 = localObject1;
        if (!str.startsWith("com.tencent.mqq.shared_file_accessor."))
        {
          n = m;
          j = i;
          localObject4 = localObject2;
          localObject3 = localObject1;
          if (!str.startsWith("android."))
          {
            n = m;
            j = i;
            localObject4 = localObject2;
            localObject3 = localObject1;
            if (!str.startsWith("java."))
            {
              n = m;
              j = i;
              localObject4 = localObject2;
              localObject3 = localObject1;
              if (!str.startsWith("com.android."))
              {
                n = m;
                j = i;
                localObject4 = localObject2;
                localObject3 = localObject1;
                if (!str.startsWith("org.chromium.")) {
                  if (str.startsWith("dalvik."))
                  {
                    n = m;
                    j = i;
                    localObject4 = localObject2;
                    localObject3 = localObject1;
                  }
                  else
                  {
                    n = m + 1;
                    if (n >= 8) {
                      break;
                    }
                    j = i;
                    if (i == 0)
                    {
                      localObject2 = localStackTraceElement.getClassName();
                      localObject1 = localStackTraceElement.getMethodName();
                      j = 1;
                    }
                    localStringBuilder.append(localStackTraceElement.toString());
                    localStringBuilder.append(",");
                    localStringBuilder.append("\n");
                    localObject3 = localObject1;
                    localObject4 = localObject2;
                  }
                }
              }
            }
          }
        }
      }
      k += 1;
      m = n;
      i = j;
      localObject2 = localObject4;
      localObject1 = localObject3;
    }
    return new Utils.StackInfo((String)localObject2, (String)localObject1, localStringBuilder.toString());
  }
  
  /* Error */
  private static String getProcessName(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 137	android/os/Process:myPid	()I
    //   3: istore_1
    //   4: aload_0
    //   5: ldc 139
    //   7: invokevirtual 145	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   10: checkcast 147	android/app/ActivityManager
    //   13: invokevirtual 151	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +45 -> 63
    //   21: aload_0
    //   22: invokeinterface 157 1 0
    //   27: astore_0
    //   28: aload_0
    //   29: invokeinterface 163 1 0
    //   34: ifeq +29 -> 63
    //   37: aload_0
    //   38: invokeinterface 166 1 0
    //   43: checkcast 168	android/app/ActivityManager$RunningAppProcessInfo
    //   46: astore_2
    //   47: aload_2
    //   48: getfield 171	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   51: iload_1
    //   52: if_icmpne -24 -> 28
    //   55: aload_2
    //   56: getfield 174	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   59: astore_0
    //   60: goto +6 -> 66
    //   63: ldc 34
    //   65: astore_0
    //   66: aload_0
    //   67: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   70: ifeq +181 -> 251
    //   73: ldc 181
    //   75: ldc 183
    //   77: invokestatic 189	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   80: pop
    //   81: aconst_null
    //   82: astore 4
    //   84: aconst_null
    //   85: astore_3
    //   86: aload_3
    //   87: astore_2
    //   88: new 66	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   95: astore 5
    //   97: aload_3
    //   98: astore_2
    //   99: aload 5
    //   101: ldc 191
    //   103: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_3
    //   108: astore_2
    //   109: aload 5
    //   111: iload_1
    //   112: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_3
    //   117: astore_2
    //   118: aload 5
    //   120: ldc 196
    //   122: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_3
    //   127: astore_2
    //   128: new 198	java/io/FileReader
    //   131: dup
    //   132: aload 5
    //   134: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 201	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   140: astore_3
    //   141: sipush 512
    //   144: newarray char
    //   146: astore_2
    //   147: aload_3
    //   148: aload_2
    //   149: invokevirtual 205	java/io/FileReader:read	([C)I
    //   152: pop
    //   153: iconst_0
    //   154: istore_1
    //   155: iload_1
    //   156: aload_2
    //   157: arraylength
    //   158: if_icmpge +12 -> 170
    //   161: aload_2
    //   162: iload_1
    //   163: caload
    //   164: ifne +96 -> 260
    //   167: goto +3 -> 170
    //   170: new 87	java/lang/String
    //   173: dup
    //   174: aload_2
    //   175: invokespecial 208	java/lang/String:<init>	([C)V
    //   178: iconst_0
    //   179: iload_1
    //   180: invokevirtual 212	java/lang/String:substring	(II)Ljava/lang/String;
    //   183: astore 4
    //   185: aload 4
    //   187: astore_2
    //   188: aload_3
    //   189: invokevirtual 215	java/io/FileReader:close	()V
    //   192: aload 4
    //   194: areturn
    //   195: astore_0
    //   196: aload_3
    //   197: astore_2
    //   198: goto +43 -> 241
    //   201: astore 4
    //   203: goto +14 -> 217
    //   206: astore_0
    //   207: goto +34 -> 241
    //   210: astore_2
    //   211: aload 4
    //   213: astore_3
    //   214: aload_2
    //   215: astore 4
    //   217: aload_3
    //   218: astore_2
    //   219: ldc 181
    //   221: ldc 217
    //   223: aload 4
    //   225: invokestatic 220	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   228: pop
    //   229: aload_3
    //   230: ifnull +21 -> 251
    //   233: aload_0
    //   234: astore_2
    //   235: aload_3
    //   236: invokevirtual 215	java/io/FileReader:close	()V
    //   239: aload_0
    //   240: areturn
    //   241: aload_2
    //   242: ifnull +7 -> 249
    //   245: aload_2
    //   246: invokevirtual 215	java/io/FileReader:close	()V
    //   249: aload_0
    //   250: athrow
    //   251: aload_0
    //   252: areturn
    //   253: astore_0
    //   254: aload_2
    //   255: areturn
    //   256: astore_2
    //   257: goto -8 -> 249
    //   260: iload_1
    //   261: iconst_1
    //   262: iadd
    //   263: istore_1
    //   264: goto -109 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramContext	Context
    //   3	261	1	i	int
    //   46	152	2	localObject1	Object
    //   210	5	2	localThrowable1	java.lang.Throwable
    //   218	37	2	localObject2	Object
    //   256	1	2	localThrowable2	java.lang.Throwable
    //   85	151	3	localObject3	Object
    //   82	111	4	str	String
    //   201	11	4	localThrowable3	java.lang.Throwable
    //   215	9	4	localThrowable4	java.lang.Throwable
    //   95	38	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   141	153	195	finally
    //   155	161	195	finally
    //   170	185	195	finally
    //   141	153	201	java/lang/Throwable
    //   155	161	201	java/lang/Throwable
    //   170	185	201	java/lang/Throwable
    //   88	97	206	finally
    //   99	107	206	finally
    //   109	116	206	finally
    //   118	126	206	finally
    //   128	141	206	finally
    //   219	229	206	finally
    //   88	97	210	java/lang/Throwable
    //   99	107	210	java/lang/Throwable
    //   109	116	210	java/lang/Throwable
    //   118	126	210	java/lang/Throwable
    //   128	141	210	java/lang/Throwable
    //   188	192	253	java/lang/Throwable
    //   235	239	253	java/lang/Throwable
    //   245	249	256	java/lang/Throwable
  }
  
  static SharedPreferences getSystemSp(Context paramContext, String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().adapter.getSystemSharedPreferences(paramString, paramInt);
  }
  
  public static void initCurrentProcessName(Context paramContext)
  {
    String str = sCurrentProcessName;
    if ((str != null) && (str.length() != 0)) {
      return;
    }
    if (paramContext == null) {
      return;
    }
    sCurrentProcessName = getProcessName(paramContext);
    if (TextUtils.isEmpty(sCurrentProcessName))
    {
      Log.e("SpLib", "getProcessName fail");
      return;
    }
    sIsSameProcessAsCP = TextUtils.equals(paramContext.getPackageName(), sCurrentProcessName);
  }
  
  /* Error */
  public static java.io.Serializable loadData(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 4
    //   15: new 266	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 267	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: new 269	java/io/ObjectInputStream
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 272	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 275	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   37: checkcast 277	java/io/Serializable
    //   40: astore_3
    //   41: aload_2
    //   42: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   45: aload_1
    //   46: invokevirtual 279	java/io/FileInputStream:close	()V
    //   49: new 281	java/io/File
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 282	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_0
    //   58: goto +303 -> 361
    //   61: astore_3
    //   62: goto +79 -> 141
    //   65: aconst_null
    //   66: astore_3
    //   67: goto +114 -> 181
    //   70: aconst_null
    //   71: astore_3
    //   72: goto +147 -> 219
    //   75: aconst_null
    //   76: astore_3
    //   77: goto +180 -> 257
    //   80: aconst_null
    //   81: astore_3
    //   82: goto +213 -> 295
    //   85: aconst_null
    //   86: astore_3
    //   87: goto +246 -> 333
    //   90: astore_3
    //   91: aconst_null
    //   92: astore_2
    //   93: goto +48 -> 141
    //   96: aconst_null
    //   97: astore_3
    //   98: aload 4
    //   100: astore_2
    //   101: goto +80 -> 181
    //   104: aconst_null
    //   105: astore_3
    //   106: aload 5
    //   108: astore_2
    //   109: goto +110 -> 219
    //   112: aconst_null
    //   113: astore_3
    //   114: aload 6
    //   116: astore_2
    //   117: goto +140 -> 257
    //   120: aconst_null
    //   121: astore_3
    //   122: aload 7
    //   124: astore_2
    //   125: goto +170 -> 295
    //   128: aconst_null
    //   129: astore_3
    //   130: aload 8
    //   132: astore_2
    //   133: goto +200 -> 333
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_2
    //   139: aload_2
    //   140: astore_1
    //   141: aload_2
    //   142: ifnull +10 -> 152
    //   145: aload_2
    //   146: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   149: goto +3 -> 152
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 279	java/io/FileInputStream:close	()V
    //   160: new 281	java/io/File
    //   163: dup
    //   164: aload_0
    //   165: invokespecial 282	java/io/File:<init>	(Ljava/lang/String;)V
    //   168: invokevirtual 285	java/io/File:delete	()Z
    //   171: pop
    //   172: aload_3
    //   173: athrow
    //   174: aconst_null
    //   175: astore_1
    //   176: aload_1
    //   177: astore_3
    //   178: aload 4
    //   180: astore_2
    //   181: aload_2
    //   182: ifnull +10 -> 192
    //   185: aload_2
    //   186: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   189: goto +3 -> 192
    //   192: aload_1
    //   193: ifnull +7 -> 200
    //   196: aload_1
    //   197: invokevirtual 279	java/io/FileInputStream:close	()V
    //   200: new 281	java/io/File
    //   203: dup
    //   204: aload_0
    //   205: invokespecial 282	java/io/File:<init>	(Ljava/lang/String;)V
    //   208: astore_0
    //   209: goto +152 -> 361
    //   212: aconst_null
    //   213: astore_1
    //   214: aload_1
    //   215: astore_3
    //   216: aload 5
    //   218: astore_2
    //   219: aload_2
    //   220: ifnull +10 -> 230
    //   223: aload_2
    //   224: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   227: goto +3 -> 230
    //   230: aload_1
    //   231: ifnull +7 -> 238
    //   234: aload_1
    //   235: invokevirtual 279	java/io/FileInputStream:close	()V
    //   238: new 281	java/io/File
    //   241: dup
    //   242: aload_0
    //   243: invokespecial 282	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: astore_0
    //   247: goto +114 -> 361
    //   250: aconst_null
    //   251: astore_1
    //   252: aload_1
    //   253: astore_3
    //   254: aload 6
    //   256: astore_2
    //   257: aload_2
    //   258: ifnull +10 -> 268
    //   261: aload_2
    //   262: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   265: goto +3 -> 268
    //   268: aload_1
    //   269: ifnull +7 -> 276
    //   272: aload_1
    //   273: invokevirtual 279	java/io/FileInputStream:close	()V
    //   276: new 281	java/io/File
    //   279: dup
    //   280: aload_0
    //   281: invokespecial 282	java/io/File:<init>	(Ljava/lang/String;)V
    //   284: astore_0
    //   285: goto +76 -> 361
    //   288: aconst_null
    //   289: astore_1
    //   290: aload_1
    //   291: astore_3
    //   292: aload 7
    //   294: astore_2
    //   295: aload_2
    //   296: ifnull +10 -> 306
    //   299: aload_2
    //   300: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   303: goto +3 -> 306
    //   306: aload_1
    //   307: ifnull +7 -> 314
    //   310: aload_1
    //   311: invokevirtual 279	java/io/FileInputStream:close	()V
    //   314: new 281	java/io/File
    //   317: dup
    //   318: aload_0
    //   319: invokespecial 282	java/io/File:<init>	(Ljava/lang/String;)V
    //   322: astore_0
    //   323: goto +38 -> 361
    //   326: aconst_null
    //   327: astore_1
    //   328: aload_1
    //   329: astore_3
    //   330: aload 8
    //   332: astore_2
    //   333: aload_2
    //   334: ifnull +10 -> 344
    //   337: aload_2
    //   338: invokevirtual 278	java/io/ObjectInputStream:close	()V
    //   341: goto +3 -> 344
    //   344: aload_1
    //   345: ifnull +7 -> 352
    //   348: aload_1
    //   349: invokevirtual 279	java/io/FileInputStream:close	()V
    //   352: new 281	java/io/File
    //   355: dup
    //   356: aload_0
    //   357: invokespecial 282	java/io/File:<init>	(Ljava/lang/String;)V
    //   360: astore_0
    //   361: aload_0
    //   362: invokevirtual 285	java/io/File:delete	()Z
    //   365: pop
    //   366: aload_3
    //   367: areturn
    //   368: astore_1
    //   369: goto -43 -> 326
    //   372: astore_1
    //   373: goto -85 -> 288
    //   376: astore_1
    //   377: goto -127 -> 250
    //   380: astore_1
    //   381: goto -169 -> 212
    //   384: astore_1
    //   385: goto -211 -> 174
    //   388: astore_2
    //   389: goto -261 -> 128
    //   392: astore_2
    //   393: goto -273 -> 120
    //   396: astore_2
    //   397: goto -285 -> 112
    //   400: astore_2
    //   401: goto -297 -> 104
    //   404: astore_2
    //   405: goto -309 -> 96
    //   408: astore_3
    //   409: goto -324 -> 85
    //   412: astore_3
    //   413: goto -333 -> 80
    //   416: astore_3
    //   417: goto -342 -> 75
    //   420: astore_3
    //   421: goto -351 -> 70
    //   424: astore_3
    //   425: goto -360 -> 65
    //   428: astore 4
    //   430: goto -343 -> 87
    //   433: astore 4
    //   435: goto -353 -> 82
    //   438: astore 4
    //   440: goto -363 -> 77
    //   443: astore 4
    //   445: goto -373 -> 72
    //   448: astore 4
    //   450: goto -383 -> 67
    //   453: astore_2
    //   454: goto -302 -> 152
    //   457: astore_1
    //   458: goto -298 -> 160
    //   461: astore_2
    //   462: goto -270 -> 192
    //   465: astore_1
    //   466: goto -266 -> 200
    //   469: astore_2
    //   470: goto -240 -> 230
    //   473: astore_1
    //   474: goto -236 -> 238
    //   477: astore_2
    //   478: goto -210 -> 268
    //   481: astore_1
    //   482: goto -206 -> 276
    //   485: astore_2
    //   486: goto -180 -> 306
    //   489: astore_1
    //   490: goto -176 -> 314
    //   493: astore_2
    //   494: goto -150 -> 344
    //   497: astore_1
    //   498: goto -146 -> 352
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	paramString	String
    //   23	326	1	localObject1	Object
    //   368	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   372	1	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   376	1	1	localIOException1	IOException
    //   380	1	1	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   384	1	1	localThrowable1	java.lang.Throwable
    //   457	1	1	localIOException2	IOException
    //   465	1	1	localIOException3	IOException
    //   473	1	1	localIOException4	IOException
    //   481	1	1	localIOException5	IOException
    //   489	1	1	localIOException6	IOException
    //   497	1	1	localIOException7	IOException
    //   32	306	2	localObject2	Object
    //   388	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   392	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   396	1	2	localIOException8	IOException
    //   400	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   404	1	2	localThrowable2	java.lang.Throwable
    //   453	1	2	localIOException9	IOException
    //   461	1	2	localIOException10	IOException
    //   469	1	2	localIOException11	IOException
    //   477	1	2	localIOException12	IOException
    //   485	1	2	localIOException13	IOException
    //   493	1	2	localIOException14	IOException
    //   40	1	3	localSerializable	java.io.Serializable
    //   61	1	3	localObject3	Object
    //   66	21	3	localObject4	Object
    //   90	1	3	localObject5	Object
    //   97	33	3	localObject6	Object
    //   136	37	3	localObject7	Object
    //   177	190	3	localObject8	Object
    //   408	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   412	1	3	localStreamCorruptedException3	java.io.StreamCorruptedException
    //   416	1	3	localIOException15	IOException
    //   420	1	3	localClassNotFoundException3	java.lang.ClassNotFoundException
    //   424	1	3	localThrowable3	java.lang.Throwable
    //   13	166	4	localObject9	Object
    //   428	1	4	localFileNotFoundException4	java.io.FileNotFoundException
    //   433	1	4	localStreamCorruptedException4	java.io.StreamCorruptedException
    //   438	1	4	localIOException16	IOException
    //   443	1	4	localClassNotFoundException4	java.lang.ClassNotFoundException
    //   448	1	4	localThrowable4	java.lang.Throwable
    //   1	216	5	localObject10	Object
    //   4	251	6	localObject11	Object
    //   7	286	7	localObject12	Object
    //   10	321	8	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   33	41	61	finally
    //   41	49	61	finally
    //   24	33	90	finally
    //   15	24	136	finally
    //   15	24	368	java/io/FileNotFoundException
    //   15	24	372	java/io/StreamCorruptedException
    //   15	24	376	java/io/IOException
    //   15	24	380	java/lang/ClassNotFoundException
    //   15	24	384	java/lang/Throwable
    //   24	33	388	java/io/FileNotFoundException
    //   24	33	392	java/io/StreamCorruptedException
    //   24	33	396	java/io/IOException
    //   24	33	400	java/lang/ClassNotFoundException
    //   24	33	404	java/lang/Throwable
    //   33	41	408	java/io/FileNotFoundException
    //   33	41	412	java/io/StreamCorruptedException
    //   33	41	416	java/io/IOException
    //   33	41	420	java/lang/ClassNotFoundException
    //   33	41	424	java/lang/Throwable
    //   41	49	428	java/io/FileNotFoundException
    //   41	49	433	java/io/StreamCorruptedException
    //   41	49	438	java/io/IOException
    //   41	49	443	java/lang/ClassNotFoundException
    //   41	49	448	java/lang/Throwable
    //   145	149	453	java/io/IOException
    //   156	160	457	java/io/IOException
    //   185	189	461	java/io/IOException
    //   196	200	465	java/io/IOException
    //   223	227	469	java/io/IOException
    //   234	238	473	java/io/IOException
    //   261	265	477	java/io/IOException
    //   272	276	481	java/io/IOException
    //   299	303	485	java/io/IOException
    //   310	314	489	java/io/IOException
    //   337	341	493	java/io/IOException
    //   348	352	497	java/io/IOException
  }
  
  public static void notifySave(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext.getContentResolver().update(SAVE_CMD_URI, new ContentValues(0), null, null);
  }
  
  private static final void onGetSystemSpException(Exception paramException)
  {
    paramException.printStackTrace();
    if (SharedPreferencesProxyManager.sSystemSpExceptionMsg == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      localStringBuilder.append(paramException.getMessage());
      localStringBuilder.append(Log.getStackTraceString(paramException));
      SharedPreferencesProxyManager.sSystemSpExceptionMsg = localStringBuilder.toString();
    }
  }
  
  static boolean readGivenLenOrFail(byte[] paramArrayOfByte, int paramInt1, int paramInt2, InputStream paramInputStream)
  {
    if (paramInt2 == 0) {
      return true;
    }
    int j = 0;
    int k = 0;
    int i = paramInt2;
    paramInt2 = k;
    for (;;)
    {
      if ((i > 0) && (j >= 0)) {}
      try
      {
        j = paramInputStream.read(paramArrayOfByte, paramInt1 + paramInt2, i);
        i -= j;
        paramInt2 += j;
      }
      catch (IOException paramArrayOfByte) {}
    }
    return i == 0;
    return false;
  }
  
  public static boolean renameFile(String paramString1, String paramString2)
  {
    return new File(paramString1).renameTo(new File(paramString2));
  }
  
  /* Error */
  public static boolean saveData(java.io.Serializable paramSerializable, String paramString)
  {
    // Byte code:
    //   0: invokestatic 334	com/tencent/mqq/shared_file_accessor/Utils:ensureBuffer	()Ljava/io/ByteArrayOutputStream;
    //   3: astore 8
    //   5: aload 8
    //   7: ifnonnull +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore 5
    //   18: aconst_null
    //   19: astore 6
    //   21: aconst_null
    //   22: astore 7
    //   24: aconst_null
    //   25: astore_3
    //   26: aload 8
    //   28: invokevirtual 337	java/io/ByteArrayOutputStream:reset	()V
    //   31: new 339	java/io/ObjectOutputStream
    //   34: dup
    //   35: aload 8
    //   37: invokespecial 342	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   40: astore_2
    //   41: aload_2
    //   42: aload_0
    //   43: invokevirtual 345	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   46: aload_2
    //   47: invokevirtual 348	java/io/ObjectOutputStream:flush	()V
    //   50: aload_2
    //   51: invokevirtual 349	java/io/ObjectOutputStream:close	()V
    //   54: new 351	java/io/FileOutputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 352	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   62: astore_0
    //   63: aload 8
    //   65: aload_0
    //   66: invokevirtual 355	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   69: aload 8
    //   71: invokevirtual 356	java/io/ByteArrayOutputStream:flush	()V
    //   74: aload 8
    //   76: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   79: aload_0
    //   80: invokevirtual 358	java/io/FileOutputStream:flush	()V
    //   83: aload_0
    //   84: invokevirtual 359	java/io/FileOutputStream:close	()V
    //   87: iconst_1
    //   88: ireturn
    //   89: astore_3
    //   90: aload_0
    //   91: astore_1
    //   92: aload_3
    //   93: astore_0
    //   94: goto +50 -> 144
    //   97: goto +73 -> 170
    //   100: goto +96 -> 196
    //   103: goto +116 -> 219
    //   106: goto +136 -> 242
    //   109: astore_0
    //   110: aload_3
    //   111: astore_1
    //   112: goto +32 -> 144
    //   115: aload 4
    //   117: astore_0
    //   118: goto +52 -> 170
    //   121: aload 5
    //   123: astore_0
    //   124: goto +72 -> 196
    //   127: aload 6
    //   129: astore_0
    //   130: goto +89 -> 219
    //   133: aload 7
    //   135: astore_0
    //   136: goto +106 -> 242
    //   139: astore_0
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_3
    //   143: astore_1
    //   144: aload_2
    //   145: ifnull +10 -> 155
    //   148: aload_2
    //   149: invokevirtual 349	java/io/ObjectOutputStream:close	()V
    //   152: goto +3 -> 155
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 359	java/io/FileOutputStream:close	()V
    //   163: aload_0
    //   164: athrow
    //   165: aconst_null
    //   166: astore_2
    //   167: aload 4
    //   169: astore_0
    //   170: aload_2
    //   171: ifnull +10 -> 181
    //   174: aload_2
    //   175: invokevirtual 349	java/io/ObjectOutputStream:close	()V
    //   178: goto +3 -> 181
    //   181: aload_0
    //   182: ifnull +78 -> 260
    //   185: aload_0
    //   186: invokevirtual 359	java/io/FileOutputStream:close	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: aconst_null
    //   192: astore_2
    //   193: aload 5
    //   195: astore_0
    //   196: aload_2
    //   197: ifnull +10 -> 207
    //   200: aload_2
    //   201: invokevirtual 349	java/io/ObjectOutputStream:close	()V
    //   204: goto +3 -> 207
    //   207: aload_0
    //   208: ifnull +52 -> 260
    //   211: goto -26 -> 185
    //   214: aconst_null
    //   215: astore_2
    //   216: aload 6
    //   218: astore_0
    //   219: aload_2
    //   220: ifnull +10 -> 230
    //   223: aload_2
    //   224: invokevirtual 349	java/io/ObjectOutputStream:close	()V
    //   227: goto +3 -> 230
    //   230: aload_0
    //   231: ifnull +29 -> 260
    //   234: goto -49 -> 185
    //   237: aconst_null
    //   238: astore_2
    //   239: aload 7
    //   241: astore_0
    //   242: aload_2
    //   243: ifnull +10 -> 253
    //   246: aload_2
    //   247: invokevirtual 349	java/io/ObjectOutputStream:close	()V
    //   250: goto +3 -> 253
    //   253: aload_0
    //   254: ifnull +6 -> 260
    //   257: goto -72 -> 185
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_0
    //   263: goto -26 -> 237
    //   266: astore_0
    //   267: goto -53 -> 214
    //   270: astore_0
    //   271: goto -80 -> 191
    //   274: astore_0
    //   275: goto -110 -> 165
    //   278: astore_0
    //   279: goto -146 -> 133
    //   282: astore_0
    //   283: goto -156 -> 127
    //   286: astore_0
    //   287: goto -166 -> 121
    //   290: astore_0
    //   291: goto -176 -> 115
    //   294: astore_1
    //   295: goto -189 -> 106
    //   298: astore_1
    //   299: goto -196 -> 103
    //   302: astore_1
    //   303: goto -203 -> 100
    //   306: astore_1
    //   307: goto -210 -> 97
    //   310: astore_2
    //   311: goto -156 -> 155
    //   314: astore_1
    //   315: goto -152 -> 163
    //   318: astore_1
    //   319: goto -138 -> 181
    //   322: astore_0
    //   323: iconst_0
    //   324: ireturn
    //   325: astore_1
    //   326: goto -119 -> 207
    //   329: astore_1
    //   330: goto -100 -> 230
    //   333: astore_1
    //   334: goto -81 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	paramSerializable	java.io.Serializable
    //   0	337	1	paramString	String
    //   40	207	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   310	1	2	localIOException	IOException
    //   25	1	3	localObject1	Object
    //   89	54	3	localObject2	Object
    //   13	155	4	localObject3	Object
    //   16	178	5	localObject4	Object
    //   19	198	6	localObject5	Object
    //   22	218	7	localObject6	Object
    //   3	72	8	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   63	87	89	finally
    //   41	63	109	finally
    //   26	41	139	finally
    //   26	41	262	java/io/FileNotFoundException
    //   26	41	266	java/io/IOException
    //   26	41	270	java/lang/OutOfMemoryError
    //   26	41	274	java/lang/Throwable
    //   41	63	278	java/io/FileNotFoundException
    //   41	63	282	java/io/IOException
    //   41	63	286	java/lang/OutOfMemoryError
    //   41	63	290	java/lang/Throwable
    //   63	87	294	java/io/FileNotFoundException
    //   63	87	298	java/io/IOException
    //   63	87	302	java/lang/OutOfMemoryError
    //   63	87	306	java/lang/Throwable
    //   148	152	310	java/io/IOException
    //   159	163	314	java/io/IOException
    //   174	178	318	java/io/IOException
    //   185	189	322	java/io/IOException
    //   200	204	325	java/io/IOException
    //   223	227	329	java/io/IOException
    //   246	250	333	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.Utils
 * JD-Core Version:    0.7.0.1
 */