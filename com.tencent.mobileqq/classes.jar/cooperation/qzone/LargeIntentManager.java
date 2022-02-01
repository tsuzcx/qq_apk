package cooperation.qzone;

import android.content.Context;
import cooperation.qzone.cache.CacheManager;
import java.io.File;

public class LargeIntentManager
{
  public static final String TAG = "LargeIntentManager";
  private static final String TEMP_FILE_FILENAME = "tmp.dat";
  private static final String TEMP_FILE_FOLDERNAME = "largeIntentTmp";
  private static final String TEMP_FILE_PATH = CacheManager.getCacheDir("largeIntentTmp");
  
  private static File getBundleSaveFile(Context paramContext)
  {
    return new File(TEMP_FILE_PATH, "tmp.dat");
  }
  
  /* Error */
  public static android.content.Intent readSavedIntent(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore_1
    //   7: aconst_null
    //   8: astore 4
    //   10: aload_0
    //   11: invokestatic 44	cooperation/qzone/LargeIntentManager:getBundleSaveFile	(Landroid/content/Context;)Ljava/io/File;
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 48	java/io/File:exists	()Z
    //   19: ifne +11 -> 30
    //   22: new 50	android/content/Intent
    //   25: dup
    //   26: invokespecial 51	android/content/Intent:<init>	()V
    //   29: areturn
    //   30: new 53	java/io/BufferedInputStream
    //   33: dup
    //   34: new 55	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 58	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 61	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_3
    //   46: aload 4
    //   48: astore_2
    //   49: aload 5
    //   51: astore_0
    //   52: aload_3
    //   53: astore_1
    //   54: aload_3
    //   55: invokevirtual 67	java/io/InputStream:available	()I
    //   58: newarray byte
    //   60: astore 6
    //   62: aload 4
    //   64: astore_2
    //   65: aload 5
    //   67: astore_0
    //   68: aload_3
    //   69: astore_1
    //   70: aload_3
    //   71: aload 6
    //   73: invokevirtual 71	java/io/InputStream:read	([B)I
    //   76: pop
    //   77: aload 4
    //   79: astore_2
    //   80: aload 5
    //   82: astore_0
    //   83: aload_3
    //   84: astore_1
    //   85: invokestatic 77	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   88: astore 4
    //   90: aload 4
    //   92: astore_2
    //   93: aload 4
    //   95: astore_0
    //   96: aload_3
    //   97: astore_1
    //   98: aload 4
    //   100: aload 6
    //   102: iconst_0
    //   103: aload 6
    //   105: arraylength
    //   106: invokevirtual 81	android/os/Parcel:unmarshall	([BII)V
    //   109: aload 4
    //   111: astore_2
    //   112: aload 4
    //   114: astore_0
    //   115: aload_3
    //   116: astore_1
    //   117: aload 4
    //   119: iconst_0
    //   120: invokevirtual 85	android/os/Parcel:setDataPosition	(I)V
    //   123: aload 4
    //   125: astore_2
    //   126: aload 4
    //   128: astore_0
    //   129: aload_3
    //   130: astore_1
    //   131: new 50	android/content/Intent
    //   134: dup
    //   135: invokespecial 51	android/content/Intent:<init>	()V
    //   138: astore 5
    //   140: aload 4
    //   142: astore_2
    //   143: aload 4
    //   145: astore_0
    //   146: aload_3
    //   147: astore_1
    //   148: new 87	android/os/Bundle
    //   151: dup
    //   152: invokespecial 88	android/os/Bundle:<init>	()V
    //   155: astore 6
    //   157: aload 4
    //   159: astore_2
    //   160: aload 4
    //   162: astore_0
    //   163: aload_3
    //   164: astore_1
    //   165: aload 6
    //   167: aload 4
    //   169: invokevirtual 92	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
    //   172: aload 4
    //   174: astore_2
    //   175: aload 4
    //   177: astore_0
    //   178: aload_3
    //   179: astore_1
    //   180: aload 5
    //   182: aload 6
    //   184: invokevirtual 96	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   187: pop
    //   188: aload 4
    //   190: ifnull +11 -> 201
    //   193: aload 4
    //   195: invokevirtual 99	android/os/Parcel:recycle	()V
    //   198: goto +3 -> 201
    //   201: aload_3
    //   202: invokevirtual 102	java/io/InputStream:close	()V
    //   205: aload 5
    //   207: areturn
    //   208: ldc 8
    //   210: iconst_2
    //   211: iconst_2
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: ldc 104
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload_0
    //   223: aastore
    //   224: invokestatic 110	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   227: aload 5
    //   229: areturn
    //   230: astore 4
    //   232: goto +17 -> 249
    //   235: astore_2
    //   236: aconst_null
    //   237: astore_3
    //   238: aload_1
    //   239: astore_0
    //   240: aload_3
    //   241: astore_1
    //   242: goto +89 -> 331
    //   245: astore 4
    //   247: aconst_null
    //   248: astore_3
    //   249: aload_2
    //   250: astore_0
    //   251: aload_3
    //   252: astore_1
    //   253: ldc 8
    //   255: iconst_2
    //   256: iconst_2
    //   257: anewarray 4	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: ldc 104
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: aload 4
    //   269: aastore
    //   270: invokestatic 110	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   273: aload_2
    //   274: astore_0
    //   275: aload_3
    //   276: astore_1
    //   277: new 50	android/content/Intent
    //   280: dup
    //   281: invokespecial 51	android/content/Intent:<init>	()V
    //   284: astore 4
    //   286: aload_2
    //   287: ifnull +10 -> 297
    //   290: aload_2
    //   291: invokevirtual 99	android/os/Parcel:recycle	()V
    //   294: goto +3 -> 297
    //   297: aload_3
    //   298: ifnull +29 -> 327
    //   301: aload_3
    //   302: invokevirtual 102	java/io/InputStream:close	()V
    //   305: aload 4
    //   307: areturn
    //   308: ldc 8
    //   310: iconst_2
    //   311: iconst_2
    //   312: anewarray 4	java/lang/Object
    //   315: dup
    //   316: iconst_0
    //   317: ldc 104
    //   319: aastore
    //   320: dup
    //   321: iconst_1
    //   322: aload_0
    //   323: aastore
    //   324: invokestatic 110	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   327: aload 4
    //   329: areturn
    //   330: astore_2
    //   331: aload_0
    //   332: ifnull +10 -> 342
    //   335: aload_0
    //   336: invokevirtual 99	android/os/Parcel:recycle	()V
    //   339: goto +3 -> 342
    //   342: aload_1
    //   343: ifnull +29 -> 372
    //   346: aload_1
    //   347: invokevirtual 102	java/io/InputStream:close	()V
    //   350: goto +22 -> 372
    //   353: ldc 8
    //   355: iconst_2
    //   356: iconst_2
    //   357: anewarray 4	java/lang/Object
    //   360: dup
    //   361: iconst_0
    //   362: ldc 104
    //   364: aastore
    //   365: dup
    //   366: iconst_1
    //   367: aload_0
    //   368: aastore
    //   369: invokestatic 110	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   372: aload_2
    //   373: athrow
    //   374: astore_0
    //   375: goto -167 -> 208
    //   378: astore_0
    //   379: goto -71 -> 308
    //   382: astore_0
    //   383: goto -30 -> 353
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramContext	Context
    //   6	341	1	localObject1	Object
    //   1	174	2	localObject2	Object
    //   235	56	2	localObject3	Object
    //   330	43	2	localObject4	Object
    //   45	257	3	localBufferedInputStream	java.io.BufferedInputStream
    //   8	186	4	localParcel	android.os.Parcel
    //   230	1	4	localException1	java.lang.Exception
    //   245	23	4	localException2	java.lang.Exception
    //   284	44	4	localIntent1	android.content.Intent
    //   3	225	5	localIntent2	android.content.Intent
    //   60	123	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   54	62	230	java/lang/Exception
    //   70	77	230	java/lang/Exception
    //   85	90	230	java/lang/Exception
    //   98	109	230	java/lang/Exception
    //   117	123	230	java/lang/Exception
    //   131	140	230	java/lang/Exception
    //   148	157	230	java/lang/Exception
    //   165	172	230	java/lang/Exception
    //   180	188	230	java/lang/Exception
    //   10	30	235	finally
    //   30	46	235	finally
    //   10	30	245	java/lang/Exception
    //   30	46	245	java/lang/Exception
    //   54	62	330	finally
    //   70	77	330	finally
    //   85	90	330	finally
    //   98	109	330	finally
    //   117	123	330	finally
    //   131	140	330	finally
    //   148	157	330	finally
    //   165	172	330	finally
    //   180	188	330	finally
    //   253	273	330	finally
    //   277	286	330	finally
    //   193	198	374	java/io/IOException
    //   201	205	374	java/io/IOException
    //   290	294	378	java/io/IOException
    //   301	305	378	java/io/IOException
    //   335	339	382	java/io/IOException
    //   346	350	382	java/io/IOException
  }
  
  public static void removeSavedIntent(Context paramContext)
  {
    paramContext = getBundleSaveFile(paramContext);
    if (paramContext.exists()) {
      paramContext.delete();
    }
  }
  
  /* Error */
  public static void saveIntent(android.content.Intent paramIntent, Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 77	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: aload_0
    //   6: invokevirtual 120	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: aload 4
    //   17: iconst_0
    //   18: invokevirtual 124	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   21: aload 4
    //   23: invokevirtual 128	android/os/Parcel:marshall	()[B
    //   26: astore_2
    //   27: aload_1
    //   28: invokestatic 44	cooperation/qzone/LargeIntentManager:getBundleSaveFile	(Landroid/content/Context;)Ljava/io/File;
    //   31: astore 5
    //   33: aconst_null
    //   34: astore_3
    //   35: aconst_null
    //   36: astore_1
    //   37: aload_1
    //   38: astore_0
    //   39: aload 5
    //   41: invokevirtual 48	java/io/File:exists	()Z
    //   44: ifeq +11 -> 55
    //   47: aload_1
    //   48: astore_0
    //   49: aload 5
    //   51: invokevirtual 115	java/io/File:delete	()Z
    //   54: pop
    //   55: aload_1
    //   56: astore_0
    //   57: aload 5
    //   59: invokevirtual 132	java/io/File:getParentFile	()Ljava/io/File;
    //   62: invokevirtual 135	java/io/File:mkdirs	()Z
    //   65: pop
    //   66: aload_1
    //   67: astore_0
    //   68: aload 5
    //   70: invokevirtual 138	java/io/File:createNewFile	()Z
    //   73: pop
    //   74: aload_1
    //   75: astore_0
    //   76: new 140	java/io/BufferedOutputStream
    //   79: dup
    //   80: new 142	java/io/FileOutputStream
    //   83: dup
    //   84: aload 5
    //   86: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 146	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   92: astore_1
    //   93: aload_1
    //   94: aload_2
    //   95: invokevirtual 152	java/io/OutputStream:write	([B)V
    //   98: aload 4
    //   100: invokevirtual 99	android/os/Parcel:recycle	()V
    //   103: aload_1
    //   104: invokevirtual 153	java/io/OutputStream:close	()V
    //   107: return
    //   108: astore_0
    //   109: ldc 8
    //   111: iconst_2
    //   112: iconst_2
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: ldc 104
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload_0
    //   124: aastore
    //   125: invokestatic 110	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   128: return
    //   129: astore_2
    //   130: aload_1
    //   131: astore_0
    //   132: aload_2
    //   133: astore_1
    //   134: goto +70 -> 204
    //   137: astore_2
    //   138: goto +10 -> 148
    //   141: astore_1
    //   142: goto +62 -> 204
    //   145: astore_2
    //   146: aload_3
    //   147: astore_1
    //   148: aload_1
    //   149: astore_0
    //   150: ldc 8
    //   152: iconst_2
    //   153: iconst_2
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: ldc 104
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: aload_2
    //   165: aastore
    //   166: invokestatic 110	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   169: aload 4
    //   171: invokevirtual 99	android/os/Parcel:recycle	()V
    //   174: aload_1
    //   175: ifnull +28 -> 203
    //   178: aload_1
    //   179: invokevirtual 153	java/io/OutputStream:close	()V
    //   182: return
    //   183: astore_0
    //   184: ldc 8
    //   186: iconst_2
    //   187: iconst_2
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: ldc 104
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: aload_0
    //   199: aastore
    //   200: invokestatic 110	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   203: return
    //   204: aload 4
    //   206: invokevirtual 99	android/os/Parcel:recycle	()V
    //   209: aload_0
    //   210: ifnull +30 -> 240
    //   213: aload_0
    //   214: invokevirtual 153	java/io/OutputStream:close	()V
    //   217: goto +23 -> 240
    //   220: astore_0
    //   221: ldc 8
    //   223: iconst_2
    //   224: iconst_2
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: ldc 104
    //   232: aastore
    //   233: dup
    //   234: iconst_1
    //   235: aload_0
    //   236: aastore
    //   237: invokestatic 110	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   240: aload_1
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramIntent	android.content.Intent
    //   0	242	1	paramContext	Context
    //   26	69	2	arrayOfByte	byte[]
    //   129	4	2	localObject1	Object
    //   137	1	2	localException1	java.lang.Exception
    //   145	20	2	localException2	java.lang.Exception
    //   34	113	3	localObject2	Object
    //   3	202	4	localParcel	android.os.Parcel
    //   31	54	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   103	107	108	java/io/IOException
    //   93	98	129	finally
    //   93	98	137	java/lang/Exception
    //   39	47	141	finally
    //   49	55	141	finally
    //   57	66	141	finally
    //   68	74	141	finally
    //   76	93	141	finally
    //   150	169	141	finally
    //   39	47	145	java/lang/Exception
    //   49	55	145	java/lang/Exception
    //   57	66	145	java/lang/Exception
    //   68	74	145	java/lang/Exception
    //   76	93	145	java/lang/Exception
    //   178	182	183	java/io/IOException
    //   213	217	220	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.LargeIntentManager
 * JD-Core Version:    0.7.0.1
 */