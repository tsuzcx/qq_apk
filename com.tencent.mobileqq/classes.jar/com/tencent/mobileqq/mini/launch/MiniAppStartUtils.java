package com.tencent.mobileqq.mini.launch;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;

public class MiniAppStartUtils
{
  private static final String APPID_WHITELIST = QzoneConfig.getInstance().getConfig("qqminiapp", "study_mode_appid_whitelist", "1109048181,1109907872");
  public static final String FOLDER;
  private static final String SCENE_WHITELIST;
  private static final String TAG = "miniapp-start-File";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/mini_intent/");
    FOLDER = localStringBuilder.toString();
    SCENE_WHITELIST = QzoneConfig.getInstance().getConfig("qqminiapp", "study_mode_scene_whitelist", "1173");
  }
  
  /* Error */
  public static String convertMiniAppInfoToString(com.tencent.mobileqq.mini.apkg.MiniAppConfig paramMiniAppConfig)
  {
    // Byte code:
    //   0: invokestatic 81	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: astore_1
    //   6: aload_2
    //   7: aload_0
    //   8: iconst_0
    //   9: invokevirtual 85	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   12: aload_2
    //   13: astore_1
    //   14: aload_2
    //   15: invokevirtual 89	android/os/Parcel:marshall	()[B
    //   18: iconst_0
    //   19: invokestatic 95	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   22: astore_0
    //   23: aload_2
    //   24: ifnull +7 -> 31
    //   27: aload_2
    //   28: invokevirtual 98	android/os/Parcel:recycle	()V
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: goto +41 -> 75
    //   37: astore_1
    //   38: aload_2
    //   39: astore_0
    //   40: aload_1
    //   41: astore_2
    //   42: goto +12 -> 54
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_1
    //   48: goto +27 -> 75
    //   51: astore_2
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: astore_1
    //   56: ldc 11
    //   58: iconst_1
    //   59: ldc 100
    //   61: aload_2
    //   62: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   65: aload_0
    //   66: ifnull +7 -> 73
    //   69: aload_0
    //   70: invokevirtual 98	android/os/Parcel:recycle	()V
    //   73: aconst_null
    //   74: areturn
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokevirtual 98	android/os/Parcel:recycle	()V
    //   83: aload_0
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramMiniAppConfig	com.tencent.mobileqq.mini.apkg.MiniAppConfig
    //   5	9	1	localObject1	Object
    //   37	4	1	localThrowable1	Throwable
    //   47	33	1	localMiniAppConfig	com.tencent.mobileqq.mini.apkg.MiniAppConfig
    //   3	39	2	localObject2	Object
    //   51	11	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   6	12	33	finally
    //   14	23	33	finally
    //   56	65	33	finally
    //   6	12	37	java/lang/Throwable
    //   14	23	37	java/lang/Throwable
    //   0	4	45	finally
    //   0	4	51	java/lang/Throwable
  }
  
  public static String getFilePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        if (paramString.contains(":"))
        {
          String str1 = paramString.substring(paramString.indexOf(":") + 1);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(FOLDER);
          localStringBuilder.append(str1);
          str1 = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("processName file path:");
          localStringBuilder.append(str1);
          localStringBuilder.append(" processName:");
          localStringBuilder.append(paramString);
          QLog.i("miniapp-start-File", 1, localStringBuilder.toString());
          return str1;
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFilePath exception! processName:");
        localStringBuilder.append(paramString);
        QLog.e("miniapp-start-File", 1, localStringBuilder.toString(), localThrowable);
        return null;
      }
      String str2 = "main";
    }
  }
  
  /* Error */
  public static com.tencent.mobileqq.mini.apkg.MiniAppConfig loadMiniAppInfoFromFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokestatic 145	com/tencent/mobileqq/mini/launch/MiniAppStartUtils:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_0
    //   14: aload_0
    //   15: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: new 30	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 152	java/io/File:exists	()Z
    //   36: ifne +5 -> 41
    //   39: aconst_null
    //   40: areturn
    //   41: new 154	java/io/FileInputStream
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 157	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: astore_3
    //   50: aload_3
    //   51: astore_0
    //   52: aload_3
    //   53: invokevirtual 161	java/io/FileInputStream:available	()I
    //   56: istore_1
    //   57: aload_3
    //   58: astore_0
    //   59: iload_1
    //   60: newarray byte
    //   62: astore_2
    //   63: aload_3
    //   64: astore_0
    //   65: aload_3
    //   66: aload_2
    //   67: iconst_0
    //   68: iload_1
    //   69: invokevirtual 165	java/io/FileInputStream:read	([BII)I
    //   72: pop
    //   73: aload_2
    //   74: invokestatic 171	com/tencent/component/network/downloader/common/Utils:unmarshall	([B)Landroid/os/Parcel;
    //   77: astore_2
    //   78: aload_2
    //   79: astore_0
    //   80: aload_2
    //   81: ldc 173
    //   83: invokevirtual 179	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   86: invokevirtual 183	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   89: checkcast 173	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   92: astore 4
    //   94: aload_2
    //   95: ifnull +9 -> 104
    //   98: aload_3
    //   99: astore_0
    //   100: aload_2
    //   101: invokevirtual 98	android/os/Parcel:recycle	()V
    //   104: aload_3
    //   105: invokevirtual 186	java/io/FileInputStream:close	()V
    //   108: aload 4
    //   110: areturn
    //   111: astore_0
    //   112: ldc 11
    //   114: ldc 188
    //   116: aload_0
    //   117: invokestatic 193	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload 4
    //   122: areturn
    //   123: astore 4
    //   125: aload_0
    //   126: astore_2
    //   127: goto +46 -> 173
    //   130: astore 4
    //   132: goto +14 -> 146
    //   135: astore 4
    //   137: aconst_null
    //   138: astore_2
    //   139: goto +34 -> 173
    //   142: astore 4
    //   144: aconst_null
    //   145: astore_2
    //   146: aload_2
    //   147: astore_0
    //   148: ldc 11
    //   150: ldc 188
    //   152: aload 4
    //   154: invokestatic 193	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   157: aload_2
    //   158: ifnull +9 -> 167
    //   161: aload_3
    //   162: astore_0
    //   163: aload_2
    //   164: invokevirtual 98	android/os/Parcel:recycle	()V
    //   167: aload_3
    //   168: invokevirtual 186	java/io/FileInputStream:close	()V
    //   171: aconst_null
    //   172: areturn
    //   173: aload_2
    //   174: ifnull +9 -> 183
    //   177: aload_3
    //   178: astore_0
    //   179: aload_2
    //   180: invokevirtual 98	android/os/Parcel:recycle	()V
    //   183: aload_3
    //   184: astore_0
    //   185: aload 4
    //   187: athrow
    //   188: astore 4
    //   190: aload_3
    //   191: astore_2
    //   192: goto +13 -> 205
    //   195: astore_0
    //   196: aconst_null
    //   197: astore_2
    //   198: goto +44 -> 242
    //   201: astore 4
    //   203: aconst_null
    //   204: astore_2
    //   205: aload_2
    //   206: astore_0
    //   207: ldc 11
    //   209: ldc 188
    //   211: aload 4
    //   213: invokestatic 193	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: aload_2
    //   217: ifnull +18 -> 235
    //   220: aload_2
    //   221: invokevirtual 186	java/io/FileInputStream:close	()V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_0
    //   227: ldc 11
    //   229: ldc 188
    //   231: aload_0
    //   232: invokestatic 193	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_3
    //   238: aload_0
    //   239: astore_2
    //   240: aload_3
    //   241: astore_0
    //   242: aload_2
    //   243: ifnull +19 -> 262
    //   246: aload_2
    //   247: invokevirtual 186	java/io/FileInputStream:close	()V
    //   250: goto +12 -> 262
    //   253: astore_2
    //   254: ldc 11
    //   256: ldc 188
    //   258: aload_2
    //   259: invokestatic 193	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   262: aload_0
    //   263: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramString	String
    //   56	13	1	i	int
    //   62	185	2	localObject1	Object
    //   253	6	2	localThrowable1	Throwable
    //   49	142	3	localFileInputStream	java.io.FileInputStream
    //   237	4	3	localObject2	Object
    //   92	29	4	localMiniAppConfig	com.tencent.mobileqq.mini.apkg.MiniAppConfig
    //   123	1	4	localObject3	Object
    //   130	1	4	localThrowable2	Throwable
    //   135	1	4	localObject4	Object
    //   142	44	4	localThrowable3	Throwable
    //   188	1	4	localThrowable4	Throwable
    //   201	11	4	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   104	108	111	java/lang/Throwable
    //   80	94	123	finally
    //   148	157	123	finally
    //   80	94	130	java/lang/Throwable
    //   73	78	135	finally
    //   73	78	142	java/lang/Throwable
    //   52	57	188	java/lang/Throwable
    //   59	63	188	java/lang/Throwable
    //   65	73	188	java/lang/Throwable
    //   100	104	188	java/lang/Throwable
    //   163	167	188	java/lang/Throwable
    //   179	183	188	java/lang/Throwable
    //   185	188	188	java/lang/Throwable
    //   9	21	195	finally
    //   23	39	195	finally
    //   41	50	195	finally
    //   9	21	201	java/lang/Throwable
    //   23	39	201	java/lang/Throwable
    //   41	50	201	java/lang/Throwable
    //   167	171	226	java/lang/Throwable
    //   220	224	226	java/lang/Throwable
    //   52	57	237	finally
    //   59	63	237	finally
    //   65	73	237	finally
    //   100	104	237	finally
    //   163	167	237	finally
    //   179	183	237	finally
    //   185	188	237	finally
    //   207	216	237	finally
    //   246	250	253	java/lang/Throwable
  }
  
  /* Error */
  public static com.tencent.mobileqq.mini.apkg.MiniAppConfig parserStringToMiniAppInfo(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: iconst_0
    //   11: invokestatic 198	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   14: invokestatic 171	com/tencent/component/network/downloader/common/Utils:unmarshall	([B)Landroid/os/Parcel;
    //   17: astore_1
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: ldc 173
    //   23: invokevirtual 179	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   26: invokevirtual 183	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   29: checkcast 173	com/tencent/mobileqq/mini/apkg/MiniAppConfig
    //   32: astore_2
    //   33: aload_1
    //   34: ifnull +7 -> 41
    //   37: aload_1
    //   38: invokevirtual 98	android/os/Parcel:recycle	()V
    //   41: aload_2
    //   42: areturn
    //   43: astore_2
    //   44: goto +12 -> 56
    //   47: astore_0
    //   48: aconst_null
    //   49: astore_1
    //   50: goto +31 -> 81
    //   53: astore_2
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_1
    //   57: astore_0
    //   58: ldc 11
    //   60: ldc 200
    //   62: aload_2
    //   63: invokestatic 193	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 98	android/os/Parcel:recycle	()V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_2
    //   77: aload_0
    //   78: astore_1
    //   79: aload_2
    //   80: astore_0
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 98	android/os/Parcel:recycle	()V
    //   89: aload_0
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramString	String
    //   17	69	1	localObject1	Object
    //   32	10	2	localMiniAppConfig	com.tencent.mobileqq.mini.apkg.MiniAppConfig
    //   43	1	2	localThrowable1	Throwable
    //   53	10	2	localThrowable2	Throwable
    //   76	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	33	43	java/lang/Throwable
    //   9	18	47	finally
    //   9	18	53	java/lang/Throwable
    //   20	33	76	finally
    //   58	66	76	finally
  }
  
  /* Error */
  public static boolean saveMiniAppInfoToFile(com.tencent.mobileqq.mini.apkg.MiniAppConfig paramMiniAppConfig, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +387 -> 388
    //   4: aload_1
    //   5: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aconst_null
    //   14: astore 5
    //   16: aconst_null
    //   17: astore_3
    //   18: aconst_null
    //   19: astore 7
    //   21: aconst_null
    //   22: astore 6
    //   24: invokestatic 81	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   27: astore 4
    //   29: aload 4
    //   31: aload_0
    //   32: iconst_0
    //   33: invokevirtual 85	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   36: aload 4
    //   38: invokevirtual 89	android/os/Parcel:marshall	()[B
    //   41: astore_3
    //   42: aload 6
    //   44: astore_0
    //   45: aload_1
    //   46: invokestatic 145	com/tencent/mobileqq/mini/launch/MiniAppStartUtils:getFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 7
    //   51: aload 6
    //   53: astore_0
    //   54: aload 7
    //   56: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: istore_2
    //   60: iload_2
    //   61: ifeq +15 -> 76
    //   64: aload 4
    //   66: ifnull +8 -> 74
    //   69: aload 4
    //   71: invokevirtual 98	android/os/Parcel:recycle	()V
    //   74: iconst_0
    //   75: ireturn
    //   76: aload 6
    //   78: astore_0
    //   79: new 30	java/io/File
    //   82: dup
    //   83: aload 7
    //   85: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: astore_1
    //   89: aload 6
    //   91: astore_0
    //   92: new 30	java/io/File
    //   95: dup
    //   96: getstatic 45	com/tencent/mobileqq/mini/launch/MiniAppStartUtils:FOLDER	Ljava/lang/String;
    //   99: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: astore 8
    //   104: aload 6
    //   106: astore_0
    //   107: aload 8
    //   109: invokevirtual 152	java/io/File:exists	()Z
    //   112: ifeq +14 -> 126
    //   115: aload 6
    //   117: astore_0
    //   118: aload 8
    //   120: invokevirtual 205	java/io/File:isDirectory	()Z
    //   123: ifne +12 -> 135
    //   126: aload 6
    //   128: astore_0
    //   129: aload 8
    //   131: invokevirtual 208	java/io/File:mkdirs	()Z
    //   134: pop
    //   135: aload 6
    //   137: astore_0
    //   138: aload_1
    //   139: invokevirtual 152	java/io/File:exists	()Z
    //   142: ifeq +13 -> 155
    //   145: aload 6
    //   147: astore_0
    //   148: aload_1
    //   149: invokevirtual 211	java/io/File:isFile	()Z
    //   152: ifne +11 -> 163
    //   155: aload 6
    //   157: astore_0
    //   158: aload_1
    //   159: invokevirtual 214	java/io/File:createNewFile	()Z
    //   162: pop
    //   163: aload 6
    //   165: astore_0
    //   166: new 216	java/io/FileOutputStream
    //   169: dup
    //   170: aload_1
    //   171: iconst_0
    //   172: invokespecial 219	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   175: astore_1
    //   176: aload_1
    //   177: aload_3
    //   178: invokevirtual 223	java/io/FileOutputStream:write	([B)V
    //   181: aload_1
    //   182: invokevirtual 226	java/io/FileOutputStream:flush	()V
    //   185: new 15	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   192: astore_0
    //   193: aload_0
    //   194: ldc 228
    //   196: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_0
    //   201: aload 7
    //   203: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: ldc 11
    //   209: iconst_1
    //   210: aload_0
    //   211: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 137	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_1
    //   218: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   221: goto +13 -> 234
    //   224: astore_0
    //   225: ldc 11
    //   227: iconst_1
    //   228: ldc 231
    //   230: aload_0
    //   231: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: aload 4
    //   236: ifnull +8 -> 244
    //   239: aload 4
    //   241: invokevirtual 98	android/os/Parcel:recycle	()V
    //   244: iconst_1
    //   245: ireturn
    //   246: astore_3
    //   247: aload_1
    //   248: astore_0
    //   249: aload_3
    //   250: astore_1
    //   251: goto +59 -> 310
    //   254: astore_3
    //   255: goto +11 -> 266
    //   258: astore_1
    //   259: goto +51 -> 310
    //   262: astore_3
    //   263: aload 5
    //   265: astore_1
    //   266: aload_1
    //   267: astore_0
    //   268: ldc 11
    //   270: iconst_1
    //   271: ldc 231
    //   273: aload_3
    //   274: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   277: aload_1
    //   278: ifnull +20 -> 298
    //   281: aload_1
    //   282: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   285: goto +13 -> 298
    //   288: astore_0
    //   289: ldc 11
    //   291: iconst_1
    //   292: ldc 231
    //   294: aload_0
    //   295: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   298: aload 4
    //   300: ifnull +74 -> 374
    //   303: aload 4
    //   305: invokevirtual 98	android/os/Parcel:recycle	()V
    //   308: iconst_0
    //   309: ireturn
    //   310: aload_0
    //   311: ifnull +20 -> 331
    //   314: aload_0
    //   315: invokevirtual 229	java/io/FileOutputStream:close	()V
    //   318: goto +13 -> 331
    //   321: astore_0
    //   322: ldc 11
    //   324: iconst_1
    //   325: ldc 231
    //   327: aload_0
    //   328: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   331: aload_1
    //   332: athrow
    //   333: astore_0
    //   334: goto +42 -> 376
    //   337: astore_1
    //   338: aload 4
    //   340: astore_0
    //   341: goto +14 -> 355
    //   344: astore_0
    //   345: aload_3
    //   346: astore 4
    //   348: goto +28 -> 376
    //   351: astore_1
    //   352: aload 7
    //   354: astore_0
    //   355: aload_0
    //   356: astore_3
    //   357: ldc 11
    //   359: iconst_1
    //   360: ldc 231
    //   362: aload_1
    //   363: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   366: aload_0
    //   367: ifnull +7 -> 374
    //   370: aload_0
    //   371: invokevirtual 98	android/os/Parcel:recycle	()V
    //   374: iconst_0
    //   375: ireturn
    //   376: aload 4
    //   378: ifnull +8 -> 386
    //   381: aload 4
    //   383: invokevirtual 98	android/os/Parcel:recycle	()V
    //   386: aload_0
    //   387: athrow
    //   388: iconst_0
    //   389: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramMiniAppConfig	com.tencent.mobileqq.mini.apkg.MiniAppConfig
    //   0	390	1	paramString	String
    //   59	2	2	bool	boolean
    //   17	161	3	arrayOfByte	byte[]
    //   246	4	3	localObject1	Object
    //   254	1	3	localThrowable1	Throwable
    //   262	84	3	localThrowable2	Throwable
    //   356	1	3	localMiniAppConfig	com.tencent.mobileqq.mini.apkg.MiniAppConfig
    //   27	355	4	localObject2	Object
    //   14	250	5	localObject3	Object
    //   22	142	6	localObject4	Object
    //   19	334	7	str	String
    //   102	28	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   217	221	224	java/lang/Throwable
    //   176	217	246	finally
    //   176	217	254	java/lang/Throwable
    //   45	51	258	finally
    //   54	60	258	finally
    //   79	89	258	finally
    //   92	104	258	finally
    //   107	115	258	finally
    //   118	126	258	finally
    //   129	135	258	finally
    //   138	145	258	finally
    //   148	155	258	finally
    //   158	163	258	finally
    //   166	176	258	finally
    //   268	277	258	finally
    //   45	51	262	java/lang/Throwable
    //   54	60	262	java/lang/Throwable
    //   79	89	262	java/lang/Throwable
    //   92	104	262	java/lang/Throwable
    //   107	115	262	java/lang/Throwable
    //   118	126	262	java/lang/Throwable
    //   129	135	262	java/lang/Throwable
    //   138	145	262	java/lang/Throwable
    //   148	155	262	java/lang/Throwable
    //   158	163	262	java/lang/Throwable
    //   166	176	262	java/lang/Throwable
    //   281	285	288	java/lang/Throwable
    //   314	318	321	java/lang/Throwable
    //   29	42	333	finally
    //   217	221	333	finally
    //   225	234	333	finally
    //   281	285	333	finally
    //   289	298	333	finally
    //   314	318	333	finally
    //   322	331	333	finally
    //   331	333	333	finally
    //   29	42	337	java/lang/Throwable
    //   225	234	337	java/lang/Throwable
    //   289	298	337	java/lang/Throwable
    //   322	331	337	java/lang/Throwable
    //   331	333	337	java/lang/Throwable
    //   24	29	344	finally
    //   357	366	344	finally
    //   24	29	351	java/lang/Throwable
  }
  
  public static boolean shouldInterceptStartMiniApp(String paramString1, String paramString2)
  {
    if (!StudyModeManager.h()) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scene=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", appid=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", scene list=");
    localStringBuilder.append(SCENE_WHITELIST);
    localStringBuilder.append("; appid list=");
    localStringBuilder.append(APPID_WHITELIST);
    QLog.i("miniapp-start-File", 1, localStringBuilder.toString());
    if (APPID_WHITELIST.contains(paramString1)) {
      return false;
    }
    return SCENE_WHITELIST.contains(paramString2) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniAppStartUtils
 * JD-Core Version:    0.7.0.1
 */