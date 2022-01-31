package com.tencent.mobileqq.mini.launch;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MiniAppStartUtils
{
  public static final String FOLDER = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini_intent/";
  private static final String TAG = "miniapp-start-File";
  
  /* Error */
  public static String convertMiniAppInfoToString(com.tencent.mobileqq.mini.apkg.MiniAppConfig paramMiniAppConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 55	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_1
    //   6: aload_1
    //   7: astore_2
    //   8: aload_1
    //   9: aload_0
    //   10: iconst_0
    //   11: invokevirtual 59	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   14: aload_1
    //   15: astore_2
    //   16: aload_1
    //   17: invokevirtual 63	android/os/Parcel:marshall	()[B
    //   20: iconst_0
    //   21: invokestatic 69	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   24: astore_0
    //   25: aload_0
    //   26: astore_2
    //   27: aload_2
    //   28: astore_0
    //   29: aload_1
    //   30: ifnull +9 -> 39
    //   33: aload_1
    //   34: invokevirtual 72	android/os/Parcel:recycle	()V
    //   37: aload_2
    //   38: astore_0
    //   39: aload_0
    //   40: areturn
    //   41: astore_0
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_1
    //   45: astore_2
    //   46: ldc 9
    //   48: iconst_1
    //   49: ldc 74
    //   51: aload_0
    //   52: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   55: aload_3
    //   56: astore_0
    //   57: aload_1
    //   58: ifnull -19 -> 39
    //   61: aload_1
    //   62: invokevirtual 72	android/os/Parcel:recycle	()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: ifnull +7 -> 78
    //   74: aload_2
    //   75: invokevirtual 72	android/os/Parcel:recycle	()V
    //   78: aload_0
    //   79: athrow
    //   80: astore_0
    //   81: goto -11 -> 70
    //   84: astore_0
    //   85: goto -41 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramMiniAppConfig	com.tencent.mobileqq.mini.apkg.MiniAppConfig
    //   5	57	1	localParcel	android.os.Parcel
    //   7	68	2	localObject1	Object
    //   1	55	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	41	java/lang/Throwable
    //   2	6	67	finally
    //   8	14	80	finally
    //   16	25	80	finally
    //   46	55	80	finally
    //   8	14	84	java/lang/Throwable
    //   16	25	84	java/lang/Throwable
  }
  
  public static String getFilePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      if (paramString.contains(":")) {}
      for (String str = paramString.substring(paramString.indexOf(":") + 1);; str = "main")
      {
        str = FOLDER + str;
        QLog.i("miniapp-start-File", 1, "processName file path:" + str + " processName:" + paramString);
        return str;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-start-File", 1, "getFilePath exception! processName:" + paramString, localThrowable);
    }
  }
  
  /* Error */
  public static com.tencent.mobileqq.mini.apkg.MiniAppConfig loadMiniAppInfoFromFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +7 -> 11
    //   7: aconst_null
    //   8: astore_0
    //   9: aload_0
    //   10: areturn
    //   11: aload_0
    //   12: invokestatic 119	com/tencent/mobileqq/mini/launch/MiniAppStartUtils:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_0
    //   16: aload_0
    //   17: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: istore_2
    //   21: iload_2
    //   22: ifeq +29 -> 51
    //   25: iconst_0
    //   26: ifeq +11 -> 37
    //   29: new 121	java/lang/NullPointerException
    //   32: dup
    //   33: invokespecial 122	java/lang/NullPointerException:<init>	()V
    //   36: athrow
    //   37: aconst_null
    //   38: areturn
    //   39: astore_0
    //   40: ldc 9
    //   42: ldc 124
    //   44: aload_0
    //   45: invokestatic 129	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   48: goto -11 -> 37
    //   51: new 28	java/io/File
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 136	java/io/File:exists	()Z
    //   64: istore_2
    //   65: iload_2
    //   66: ifne +29 -> 95
    //   69: iconst_0
    //   70: ifeq +11 -> 81
    //   73: new 121	java/lang/NullPointerException
    //   76: dup
    //   77: invokespecial 122	java/lang/NullPointerException:<init>	()V
    //   80: athrow
    //   81: aconst_null
    //   82: areturn
    //   83: astore_0
    //   84: ldc 9
    //   86: ldc 124
    //   88: aload_0
    //   89: invokestatic 129	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   92: goto -11 -> 81
    //   95: new 138	java/io/FileInputStream
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   103: astore 4
    //   105: aload 4
    //   107: invokevirtual 145	java/io/FileInputStream:available	()I
    //   110: istore_1
    //   111: iload_1
    //   112: newarray byte
    //   114: astore_0
    //   115: aload 4
    //   117: aload_0
    //   118: iconst_0
    //   119: iload_1
    //   120: invokevirtual 149	java/io/FileInputStream:read	([BII)I
    //   123: pop
    //   124: aload_0
    //   125: invokestatic 155	com/tencent/component/network/downloader/common/Utils:unmarshall	([B)Landroid/os/Parcel;
    //   128: astore_3
    //   129: aload_3
    //   130: astore_0
    //   131: aload_3
    //   132: ldc 157
    //   134: invokevirtual 163	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   137: invokevirtual 167	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   140: checkcast 157	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   143: astore 5
    //   145: aload_3
    //   146: ifnull +7 -> 153
    //   149: aload_3
    //   150: invokevirtual 72	android/os/Parcel:recycle	()V
    //   153: aload 5
    //   155: astore_0
    //   156: aload 4
    //   158: ifnull -149 -> 9
    //   161: aload 4
    //   163: invokevirtual 170	java/io/FileInputStream:close	()V
    //   166: aload 5
    //   168: areturn
    //   169: astore_0
    //   170: ldc 9
    //   172: ldc 124
    //   174: aload_0
    //   175: invokestatic 129	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   178: aload 5
    //   180: areturn
    //   181: astore 5
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_3
    //   186: astore_0
    //   187: ldc 9
    //   189: ldc 124
    //   191: aload 5
    //   193: invokestatic 129	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 72	android/os/Parcel:recycle	()V
    //   204: aload 4
    //   206: ifnull +8 -> 214
    //   209: aload 4
    //   211: invokevirtual 170	java/io/FileInputStream:close	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_3
    //   217: aconst_null
    //   218: astore_0
    //   219: aload_0
    //   220: ifnull +7 -> 227
    //   223: aload_0
    //   224: invokevirtual 72	android/os/Parcel:recycle	()V
    //   227: aload_3
    //   228: athrow
    //   229: astore_3
    //   230: aload 4
    //   232: astore_0
    //   233: ldc 9
    //   235: ldc 124
    //   237: aload_3
    //   238: invokestatic 129	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload_0
    //   242: ifnull -28 -> 214
    //   245: aload_0
    //   246: invokevirtual 170	java/io/FileInputStream:close	()V
    //   249: goto -35 -> 214
    //   252: astore_0
    //   253: ldc 9
    //   255: ldc 124
    //   257: aload_0
    //   258: invokestatic 129	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   261: goto -47 -> 214
    //   264: astore_0
    //   265: ldc 9
    //   267: ldc 124
    //   269: aload_0
    //   270: invokestatic 129	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   273: goto -59 -> 214
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_3
    //   279: aload_3
    //   280: ifnull +7 -> 287
    //   283: aload_3
    //   284: invokevirtual 170	java/io/FileInputStream:close	()V
    //   287: aload_0
    //   288: athrow
    //   289: astore_3
    //   290: ldc 9
    //   292: ldc 124
    //   294: aload_3
    //   295: invokestatic 129	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   298: goto -11 -> 287
    //   301: astore_0
    //   302: aload 4
    //   304: astore_3
    //   305: goto -26 -> 279
    //   308: astore 4
    //   310: aload_0
    //   311: astore_3
    //   312: aload 4
    //   314: astore_0
    //   315: goto -36 -> 279
    //   318: astore_3
    //   319: aconst_null
    //   320: astore_0
    //   321: goto -88 -> 233
    //   324: astore_3
    //   325: goto -106 -> 219
    //   328: astore 5
    //   330: goto -145 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramString	String
    //   110	10	1	i	int
    //   20	46	2	bool	boolean
    //   128	73	3	localParcel	android.os.Parcel
    //   216	12	3	localObject1	Object
    //   229	9	3	localThrowable1	Throwable
    //   278	6	3	localObject2	Object
    //   289	6	3	localThrowable2	Throwable
    //   304	8	3	localObject3	Object
    //   318	1	3	localThrowable3	Throwable
    //   324	1	3	localObject4	Object
    //   103	200	4	localFileInputStream	java.io.FileInputStream
    //   308	5	4	localObject5	Object
    //   143	36	5	localMiniAppConfig	com.tencent.mobileqq.mini.apkg.MiniAppConfig
    //   181	11	5	localThrowable4	Throwable
    //   328	1	5	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   29	37	39	java/lang/Throwable
    //   73	81	83	java/lang/Throwable
    //   161	166	169	java/lang/Throwable
    //   124	129	181	java/lang/Throwable
    //   124	129	216	finally
    //   105	124	229	java/lang/Throwable
    //   149	153	229	java/lang/Throwable
    //   200	204	229	java/lang/Throwable
    //   223	227	229	java/lang/Throwable
    //   227	229	229	java/lang/Throwable
    //   245	249	252	java/lang/Throwable
    //   209	214	264	java/lang/Throwable
    //   11	21	276	finally
    //   51	65	276	finally
    //   95	105	276	finally
    //   283	287	289	java/lang/Throwable
    //   105	124	301	finally
    //   149	153	301	finally
    //   200	204	301	finally
    //   223	227	301	finally
    //   227	229	301	finally
    //   233	241	308	finally
    //   11	21	318	java/lang/Throwable
    //   51	65	318	java/lang/Throwable
    //   95	105	318	java/lang/Throwable
    //   131	145	324	finally
    //   187	196	324	finally
    //   131	145	328	java/lang/Throwable
  }
  
  /* Error */
  public static com.tencent.mobileqq.mini.apkg.MiniAppConfig parserStringToMiniAppInfo(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +7 -> 11
    //   7: aconst_null
    //   8: astore_0
    //   9: aload_0
    //   10: areturn
    //   11: aload_0
    //   12: iconst_0
    //   13: invokestatic 175	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   16: invokestatic 155	com/tencent/component/network/downloader/common/Utils:unmarshall	([B)Landroid/os/Parcel;
    //   19: astore_1
    //   20: aload_1
    //   21: astore_0
    //   22: aload_1
    //   23: ldc 157
    //   25: invokevirtual 163	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   28: invokevirtual 167	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   31: checkcast 157	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   34: astore_2
    //   35: aload_2
    //   36: astore_0
    //   37: aload_1
    //   38: ifnull -29 -> 9
    //   41: aload_1
    //   42: invokevirtual 72	android/os/Parcel:recycle	()V
    //   45: aload_2
    //   46: areturn
    //   47: astore_2
    //   48: aconst_null
    //   49: astore_1
    //   50: aload_1
    //   51: astore_0
    //   52: ldc 9
    //   54: ldc 177
    //   56: aload_2
    //   57: invokestatic 129	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 72	android/os/Parcel:recycle	()V
    //   68: aconst_null
    //   69: areturn
    //   70: astore_1
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 72	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: goto -11 -> 73
    //   87: astore_2
    //   88: goto -38 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramString	String
    //   19	46	1	localParcel	android.os.Parcel
    //   70	12	1	localObject1	Object
    //   83	1	1	localObject2	Object
    //   34	12	2	localMiniAppConfig	com.tencent.mobileqq.mini.apkg.MiniAppConfig
    //   47	10	2	localThrowable1	Throwable
    //   87	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   11	20	47	java/lang/Throwable
    //   11	20	70	finally
    //   22	35	83	finally
    //   52	60	83	finally
    //   22	35	87	java/lang/Throwable
  }
  
  /* Error */
  public static boolean saveMiniAppInfoToFile(com.tencent.mobileqq.mini.apkg.MiniAppConfig paramMiniAppConfig, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_0
    //   9: ifnull +10 -> 19
    //   12: aload_1
    //   13: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +5 -> 21
    //   19: iconst_0
    //   20: ireturn
    //   21: invokestatic 55	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   24: astore 6
    //   26: aload 6
    //   28: astore_3
    //   29: aload_3
    //   30: aload_0
    //   31: iconst_0
    //   32: invokevirtual 59	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   35: aload_3
    //   36: invokevirtual 63	android/os/Parcel:marshall	()[B
    //   39: astore 6
    //   41: aload 5
    //   43: astore_0
    //   44: aload_1
    //   45: invokestatic 119	com/tencent/mobileqq/mini/launch/MiniAppStartUtils:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 7
    //   50: aload 5
    //   52: astore_0
    //   53: aload 7
    //   55: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: istore_2
    //   59: iload_2
    //   60: ifeq +60 -> 120
    //   63: iconst_0
    //   64: ifeq +11 -> 75
    //   67: new 121	java/lang/NullPointerException
    //   70: dup
    //   71: invokespecial 122	java/lang/NullPointerException:<init>	()V
    //   74: athrow
    //   75: aload_3
    //   76: ifnull -57 -> 19
    //   79: aload_3
    //   80: invokevirtual 72	android/os/Parcel:recycle	()V
    //   83: iconst_0
    //   84: ireturn
    //   85: astore_0
    //   86: ldc 9
    //   88: iconst_1
    //   89: ldc 181
    //   91: aload_0
    //   92: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   95: goto -20 -> 75
    //   98: astore_1
    //   99: aload_3
    //   100: astore_0
    //   101: ldc 9
    //   103: iconst_1
    //   104: ldc 181
    //   106: aload_1
    //   107: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload_0
    //   111: ifnull -92 -> 19
    //   114: aload_0
    //   115: invokevirtual 72	android/os/Parcel:recycle	()V
    //   118: iconst_0
    //   119: ireturn
    //   120: aload 5
    //   122: astore_0
    //   123: new 28	java/io/File
    //   126: dup
    //   127: aload 7
    //   129: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   132: astore 8
    //   134: aload 5
    //   136: astore_0
    //   137: new 28	java/io/File
    //   140: dup
    //   141: getstatic 43	com/tencent/mobileqq/mini/launch/MiniAppStartUtils:FOLDER	Ljava/lang/String;
    //   144: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   147: astore_1
    //   148: aload 5
    //   150: astore_0
    //   151: aload_1
    //   152: invokevirtual 136	java/io/File:exists	()Z
    //   155: ifeq +13 -> 168
    //   158: aload 5
    //   160: astore_0
    //   161: aload_1
    //   162: invokevirtual 184	java/io/File:isDirectory	()Z
    //   165: ifne +11 -> 176
    //   168: aload 5
    //   170: astore_0
    //   171: aload_1
    //   172: invokevirtual 187	java/io/File:mkdirs	()Z
    //   175: pop
    //   176: aload 5
    //   178: astore_0
    //   179: aload 8
    //   181: invokevirtual 136	java/io/File:exists	()Z
    //   184: ifeq +14 -> 198
    //   187: aload 5
    //   189: astore_0
    //   190: aload 8
    //   192: invokevirtual 190	java/io/File:isFile	()Z
    //   195: ifne +12 -> 207
    //   198: aload 5
    //   200: astore_0
    //   201: aload 8
    //   203: invokevirtual 193	java/io/File:createNewFile	()Z
    //   206: pop
    //   207: aload 5
    //   209: astore_0
    //   210: new 195	java/io/FileOutputStream
    //   213: dup
    //   214: aload 8
    //   216: iconst_0
    //   217: invokespecial 198	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   220: astore_1
    //   221: aload_1
    //   222: aload 6
    //   224: invokevirtual 202	java/io/FileOutputStream:write	([B)V
    //   227: aload_1
    //   228: invokevirtual 205	java/io/FileOutputStream:flush	()V
    //   231: ldc 9
    //   233: iconst_1
    //   234: new 13	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   241: ldc 207
    //   243: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 7
    //   248: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 208	java/io/FileOutputStream:close	()V
    //   265: aload_3
    //   266: ifnull +7 -> 273
    //   269: aload_3
    //   270: invokevirtual 72	android/os/Parcel:recycle	()V
    //   273: iconst_1
    //   274: ireturn
    //   275: astore_0
    //   276: ldc 9
    //   278: iconst_1
    //   279: ldc 181
    //   281: aload_0
    //   282: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: goto -20 -> 265
    //   288: astore_0
    //   289: aload_3
    //   290: ifnull +7 -> 297
    //   293: aload_3
    //   294: invokevirtual 72	android/os/Parcel:recycle	()V
    //   297: aload_0
    //   298: athrow
    //   299: astore_0
    //   300: aload 4
    //   302: astore_1
    //   303: aload_0
    //   304: astore 4
    //   306: aload_1
    //   307: astore_0
    //   308: ldc 9
    //   310: iconst_1
    //   311: ldc 181
    //   313: aload 4
    //   315: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   318: aload_1
    //   319: ifnull +7 -> 326
    //   322: aload_1
    //   323: invokevirtual 208	java/io/FileOutputStream:close	()V
    //   326: aload_3
    //   327: ifnull -308 -> 19
    //   330: aload_3
    //   331: invokevirtual 72	android/os/Parcel:recycle	()V
    //   334: iconst_0
    //   335: ireturn
    //   336: astore_0
    //   337: ldc 9
    //   339: iconst_1
    //   340: ldc 181
    //   342: aload_0
    //   343: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   346: goto -20 -> 326
    //   349: astore 4
    //   351: aload_0
    //   352: astore_1
    //   353: aload 4
    //   355: astore_0
    //   356: aload_1
    //   357: ifnull +7 -> 364
    //   360: aload_1
    //   361: invokevirtual 208	java/io/FileOutputStream:close	()V
    //   364: aload_0
    //   365: athrow
    //   366: astore_1
    //   367: ldc 9
    //   369: iconst_1
    //   370: ldc 181
    //   372: aload_1
    //   373: invokestatic 80	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   376: goto -12 -> 364
    //   379: astore_0
    //   380: aconst_null
    //   381: astore_3
    //   382: goto -93 -> 289
    //   385: astore_1
    //   386: aload_0
    //   387: astore_3
    //   388: aload_1
    //   389: astore_0
    //   390: goto -101 -> 289
    //   393: astore_1
    //   394: aload_3
    //   395: astore_0
    //   396: goto -295 -> 101
    //   399: astore_0
    //   400: goto -44 -> 356
    //   403: astore 4
    //   405: goto -99 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	paramMiniAppConfig	com.tencent.mobileqq.mini.apkg.MiniAppConfig
    //   0	408	1	paramString	String
    //   58	2	2	bool	boolean
    //   7	388	3	localObject1	Object
    //   1	313	4	localMiniAppConfig	com.tencent.mobileqq.mini.apkg.MiniAppConfig
    //   349	5	4	localObject2	Object
    //   403	1	4	localThrowable	Throwable
    //   4	204	5	localObject3	Object
    //   24	199	6	localObject4	Object
    //   48	199	7	str	String
    //   132	83	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   67	75	85	java/lang/Throwable
    //   29	41	98	java/lang/Throwable
    //   86	95	98	java/lang/Throwable
    //   276	285	98	java/lang/Throwable
    //   337	346	98	java/lang/Throwable
    //   364	366	98	java/lang/Throwable
    //   367	376	98	java/lang/Throwable
    //   261	265	275	java/lang/Throwable
    //   29	41	288	finally
    //   67	75	288	finally
    //   86	95	288	finally
    //   261	265	288	finally
    //   276	285	288	finally
    //   322	326	288	finally
    //   337	346	288	finally
    //   360	364	288	finally
    //   364	366	288	finally
    //   367	376	288	finally
    //   44	50	299	java/lang/Throwable
    //   53	59	299	java/lang/Throwable
    //   123	134	299	java/lang/Throwable
    //   137	148	299	java/lang/Throwable
    //   151	158	299	java/lang/Throwable
    //   161	168	299	java/lang/Throwable
    //   171	176	299	java/lang/Throwable
    //   179	187	299	java/lang/Throwable
    //   190	198	299	java/lang/Throwable
    //   201	207	299	java/lang/Throwable
    //   210	221	299	java/lang/Throwable
    //   322	326	336	java/lang/Throwable
    //   44	50	349	finally
    //   53	59	349	finally
    //   123	134	349	finally
    //   137	148	349	finally
    //   151	158	349	finally
    //   161	168	349	finally
    //   171	176	349	finally
    //   179	187	349	finally
    //   190	198	349	finally
    //   201	207	349	finally
    //   210	221	349	finally
    //   308	318	349	finally
    //   360	364	366	java/lang/Throwable
    //   21	26	379	finally
    //   101	110	385	finally
    //   21	26	393	java/lang/Throwable
    //   221	257	399	finally
    //   221	257	403	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniAppStartUtils
 * JD-Core Version:    0.7.0.1
 */