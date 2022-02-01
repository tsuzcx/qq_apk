package com.tencent.qg.sdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.ETC1Util.ETC1Texture;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qg.sdk.base64.Base64;
import com.tencent.qg.sdk.base64.Base64Utils;
import java.util.HashMap;

public class QGBitmapLoader
{
  public static final String TAG = "QGBitmapLoader";
  public static HashMap<String, ETC1Util.ETC1Texture> etc1TextureHashMap;
  private static QGBitmapLoader.QGBitmapLoaderImpl mLoaderInstance;
  
  /* Error */
  public static int[] hasCompressFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 12
    //   9: aconst_null
    //   10: astore 9
    //   12: aload_0
    //   13: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 34	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   28: aload_0
    //   29: iconst_0
    //   30: aload_0
    //   31: ldc 37
    //   33: invokevirtual 43	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   36: invokevirtual 47	java/lang/String:substring	(II)Ljava/lang/String;
    //   39: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 53
    //   44: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 7
    //   52: new 59	java/io/File
    //   55: dup
    //   56: aload 7
    //   58: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: invokevirtual 66	java/io/File:exists	()Z
    //   64: ifeq +223 -> 287
    //   67: new 68	java/io/FileInputStream
    //   70: dup
    //   71: aload 7
    //   73: invokespecial 69	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   76: astore 7
    //   78: aload 7
    //   80: astore 9
    //   82: aload 8
    //   84: astore 10
    //   86: aload 12
    //   88: astore 11
    //   90: aload 7
    //   92: invokestatic 75	android/opengl/ETC1Util:createTexture	(Ljava/io/InputStream;)Landroid/opengl/ETC1Util$ETC1Texture;
    //   95: astore 13
    //   97: aload 7
    //   99: astore 9
    //   101: aload 8
    //   103: astore 10
    //   105: aload 12
    //   107: astore 11
    //   109: iconst_3
    //   110: newarray int
    //   112: astore 8
    //   114: aload 7
    //   116: astore 9
    //   118: aload 8
    //   120: astore 10
    //   122: aload 8
    //   124: astore 11
    //   126: aload 13
    //   128: invokevirtual 81	android/opengl/ETC1Util$ETC1Texture:getWidth	()I
    //   131: istore_3
    //   132: aload 7
    //   134: astore 9
    //   136: aload 13
    //   138: invokevirtual 84	android/opengl/ETC1Util$ETC1Texture:getHeight	()I
    //   141: istore_2
    //   142: aload 7
    //   144: astore 9
    //   146: iload_3
    //   147: iload_2
    //   148: invokestatic 90	android/opengl/ETC1:getEncodedDataSize	(II)I
    //   151: istore_1
    //   152: aload 8
    //   154: iconst_0
    //   155: iload_3
    //   156: iastore
    //   157: aload 8
    //   159: iconst_1
    //   160: iload_2
    //   161: iastore
    //   162: aload 8
    //   164: iconst_2
    //   165: iload_1
    //   166: iastore
    //   167: aload 7
    //   169: astore 9
    //   171: getstatic 92	com/tencent/qg/sdk/QGBitmapLoader:etc1TextureHashMap	Ljava/util/HashMap;
    //   174: ifnonnull +17 -> 191
    //   177: aload 7
    //   179: astore 9
    //   181: new 94	java/util/HashMap
    //   184: dup
    //   185: invokespecial 95	java/util/HashMap:<init>	()V
    //   188: putstatic 92	com/tencent/qg/sdk/QGBitmapLoader:etc1TextureHashMap	Ljava/util/HashMap;
    //   191: aload 7
    //   193: astore 9
    //   195: getstatic 92	com/tencent/qg/sdk/QGBitmapLoader:etc1TextureHashMap	Ljava/util/HashMap;
    //   198: aload_0
    //   199: aload 13
    //   201: invokevirtual 99	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   204: pop
    //   205: iload_1
    //   206: istore 4
    //   208: iload_2
    //   209: istore 5
    //   211: iload_3
    //   212: istore 6
    //   214: aload 8
    //   216: astore_0
    //   217: aload 7
    //   219: ifnull +20 -> 239
    //   222: aload 7
    //   224: invokevirtual 104	java/io/InputStream:close	()V
    //   227: aload 8
    //   229: astore_0
    //   230: iload_3
    //   231: istore 6
    //   233: iload_2
    //   234: istore 5
    //   236: iload_1
    //   237: istore 4
    //   239: ldc 8
    //   241: new 34	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   248: ldc 106
    //   250: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload 4
    //   255: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: ldc 111
    //   260: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: iload 6
    //   265: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: ldc 113
    //   270: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload 5
    //   275: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 119	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   284: pop
    //   285: aload_0
    //   286: areturn
    //   287: getstatic 125	com/tencent/qg/sdk/QGRenderer:assetManager	Landroid/content/res/AssetManager;
    //   290: aload 7
    //   292: invokevirtual 131	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   295: astore 7
    //   297: goto -219 -> 78
    //   300: astore_0
    //   301: ldc 8
    //   303: ldc 133
    //   305: aload_0
    //   306: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   309: pop
    //   310: iload_1
    //   311: istore 4
    //   313: iload_2
    //   314: istore 5
    //   316: iload_3
    //   317: istore 6
    //   319: aload 8
    //   321: astore_0
    //   322: goto -83 -> 239
    //   325: astore_0
    //   326: aconst_null
    //   327: astore 7
    //   329: iconst_0
    //   330: istore_2
    //   331: iconst_0
    //   332: istore_3
    //   333: iconst_0
    //   334: istore_1
    //   335: aload 9
    //   337: astore 8
    //   339: aload 7
    //   341: astore 9
    //   343: ldc 8
    //   345: ldc 138
    //   347: aload_0
    //   348: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   351: pop
    //   352: iload_1
    //   353: istore 4
    //   355: iload_2
    //   356: istore 5
    //   358: iload_3
    //   359: istore 6
    //   361: aload 8
    //   363: astore_0
    //   364: aload 7
    //   366: ifnull -127 -> 239
    //   369: aload 7
    //   371: invokevirtual 104	java/io/InputStream:close	()V
    //   374: iload_1
    //   375: istore 4
    //   377: iload_2
    //   378: istore 5
    //   380: iload_3
    //   381: istore 6
    //   383: aload 8
    //   385: astore_0
    //   386: goto -147 -> 239
    //   389: astore_0
    //   390: ldc 8
    //   392: ldc 133
    //   394: aload_0
    //   395: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   398: pop
    //   399: iload_1
    //   400: istore 4
    //   402: iload_2
    //   403: istore 5
    //   405: iload_3
    //   406: istore 6
    //   408: aload 8
    //   410: astore_0
    //   411: goto -172 -> 239
    //   414: astore_0
    //   415: aconst_null
    //   416: astore 7
    //   418: iconst_0
    //   419: istore_2
    //   420: iconst_0
    //   421: istore_3
    //   422: iconst_0
    //   423: istore_1
    //   424: aload 10
    //   426: astore 8
    //   428: aload 7
    //   430: astore 9
    //   432: ldc 8
    //   434: ldc 138
    //   436: aload_0
    //   437: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   440: pop
    //   441: iload_1
    //   442: istore 4
    //   444: iload_2
    //   445: istore 5
    //   447: iload_3
    //   448: istore 6
    //   450: aload 8
    //   452: astore_0
    //   453: aload 7
    //   455: ifnull -216 -> 239
    //   458: aload 7
    //   460: invokevirtual 104	java/io/InputStream:close	()V
    //   463: iload_1
    //   464: istore 4
    //   466: iload_2
    //   467: istore 5
    //   469: iload_3
    //   470: istore 6
    //   472: aload 8
    //   474: astore_0
    //   475: goto -236 -> 239
    //   478: astore_0
    //   479: ldc 8
    //   481: ldc 133
    //   483: aload_0
    //   484: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   487: pop
    //   488: iload_1
    //   489: istore 4
    //   491: iload_2
    //   492: istore 5
    //   494: iload_3
    //   495: istore 6
    //   497: aload 8
    //   499: astore_0
    //   500: goto -261 -> 239
    //   503: astore_0
    //   504: aconst_null
    //   505: astore 9
    //   507: aload 9
    //   509: ifnull +8 -> 517
    //   512: aload 9
    //   514: invokevirtual 104	java/io/InputStream:close	()V
    //   517: aload_0
    //   518: athrow
    //   519: astore 7
    //   521: ldc 8
    //   523: ldc 133
    //   525: aload 7
    //   527: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   530: pop
    //   531: goto -14 -> 517
    //   534: astore_0
    //   535: goto -28 -> 507
    //   538: astore_0
    //   539: iconst_0
    //   540: istore_2
    //   541: iconst_0
    //   542: istore_3
    //   543: iconst_0
    //   544: istore_1
    //   545: aload 10
    //   547: astore 8
    //   549: goto -121 -> 428
    //   552: astore_0
    //   553: iconst_0
    //   554: istore_2
    //   555: iconst_0
    //   556: istore_1
    //   557: goto -129 -> 428
    //   560: astore_0
    //   561: iconst_0
    //   562: istore_1
    //   563: goto -135 -> 428
    //   566: astore_0
    //   567: goto -139 -> 428
    //   570: astore_0
    //   571: iconst_0
    //   572: istore_2
    //   573: iconst_0
    //   574: istore_3
    //   575: iconst_0
    //   576: istore_1
    //   577: aload 11
    //   579: astore 8
    //   581: goto -242 -> 339
    //   584: astore_0
    //   585: iconst_0
    //   586: istore_2
    //   587: iconst_0
    //   588: istore_1
    //   589: goto -250 -> 339
    //   592: astore_0
    //   593: iconst_0
    //   594: istore_1
    //   595: goto -256 -> 339
    //   598: astore_0
    //   599: goto -260 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	602	0	paramString	String
    //   151	444	1	i	int
    //   141	446	2	j	int
    //   131	444	3	k	int
    //   206	284	4	m	int
    //   209	284	5	n	int
    //   212	284	6	i1	int
    //   50	409	7	localObject1	Object
    //   519	7	7	localIOException	java.io.IOException
    //   4	576	8	localObject2	Object
    //   10	503	9	localObject3	Object
    //   1	545	10	localObject4	Object
    //   88	490	11	localObject5	Object
    //   7	99	12	localObject6	Object
    //   95	105	13	localETC1Texture	ETC1Util.ETC1Texture
    // Exception table:
    //   from	to	target	type
    //   222	227	300	java/io/IOException
    //   67	78	325	java/io/FileNotFoundException
    //   287	297	325	java/io/FileNotFoundException
    //   369	374	389	java/io/IOException
    //   67	78	414	java/lang/Exception
    //   287	297	414	java/lang/Exception
    //   458	463	478	java/io/IOException
    //   67	78	503	finally
    //   287	297	503	finally
    //   512	517	519	java/io/IOException
    //   90	97	534	finally
    //   109	114	534	finally
    //   126	132	534	finally
    //   136	142	534	finally
    //   146	152	534	finally
    //   171	177	534	finally
    //   181	191	534	finally
    //   195	205	534	finally
    //   343	352	534	finally
    //   432	441	534	finally
    //   90	97	538	java/lang/Exception
    //   109	114	538	java/lang/Exception
    //   126	132	538	java/lang/Exception
    //   136	142	552	java/lang/Exception
    //   146	152	560	java/lang/Exception
    //   171	177	566	java/lang/Exception
    //   181	191	566	java/lang/Exception
    //   195	205	566	java/lang/Exception
    //   90	97	570	java/io/FileNotFoundException
    //   109	114	570	java/io/FileNotFoundException
    //   126	132	570	java/io/FileNotFoundException
    //   136	142	584	java/io/FileNotFoundException
    //   146	152	592	java/io/FileNotFoundException
    //   171	177	598	java/io/FileNotFoundException
    //   181	191	598	java/io/FileNotFoundException
    //   195	205	598	java/io/FileNotFoundException
  }
  
  /* Error */
  public static Bitmap load(String paramString)
  {
    // Byte code:
    //   0: getstatic 146	com/tencent/qg/sdk/QGBitmapLoader:mLoaderInstance	Lcom/tencent/qg/sdk/QGBitmapLoader$QGBitmapLoaderImpl;
    //   3: ifnull +13 -> 16
    //   6: getstatic 146	com/tencent/qg/sdk/QGBitmapLoader:mLoaderInstance	Lcom/tencent/qg/sdk/QGBitmapLoader$QGBitmapLoaderImpl;
    //   9: aload_0
    //   10: invokeinterface 150 2 0
    //   15: areturn
    //   16: aload_0
    //   17: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +13 -> 33
    //   23: ldc 8
    //   25: ldc 152
    //   27: invokestatic 154	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   30: pop
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: ldc 156
    //   36: invokevirtual 160	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   39: ifeq +66 -> 105
    //   42: new 162	java/net/URL
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 163	java/net/URL:<init>	(Ljava/lang/String;)V
    //   50: invokevirtual 167	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   53: checkcast 169	java/net/HttpURLConnection
    //   56: astore_0
    //   57: aload_0
    //   58: iconst_1
    //   59: invokevirtual 173	java/net/HttpURLConnection:setDoInput	(Z)V
    //   62: aload_0
    //   63: invokevirtual 176	java/net/HttpURLConnection:connect	()V
    //   66: aload_0
    //   67: invokevirtual 180	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   70: astore 6
    //   72: aload 6
    //   74: invokestatic 186	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   77: astore_0
    //   78: aload_0
    //   79: astore_3
    //   80: aload_0
    //   81: astore 4
    //   83: aload_0
    //   84: astore 5
    //   86: aload 6
    //   88: invokevirtual 104	java/io/InputStream:close	()V
    //   91: aload_0
    //   92: areturn
    //   93: astore_0
    //   94: ldc 8
    //   96: ldc 188
    //   98: aload_0
    //   99: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   102: pop
    //   103: aload_3
    //   104: areturn
    //   105: invokestatic 194	java/lang/System:currentTimeMillis	()J
    //   108: lstore_1
    //   109: new 59	java/io/File
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: invokevirtual 66	java/io/File:exists	()Z
    //   120: ifeq +95 -> 215
    //   123: aload_0
    //   124: invokestatic 197	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   127: astore_0
    //   128: aload_0
    //   129: astore_3
    //   130: aload_0
    //   131: astore 4
    //   133: aload_0
    //   134: astore 5
    //   136: ldc 199
    //   138: new 34	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   145: ldc 201
    //   147: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokestatic 194	java/lang/System:currentTimeMillis	()J
    //   153: lload_1
    //   154: lsub
    //   155: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   158: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 119	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   164: pop
    //   165: aload_0
    //   166: astore_3
    //   167: aload_0
    //   168: astore 4
    //   170: aload_0
    //   171: astore 5
    //   173: ldc 199
    //   175: new 34	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   182: ldc 206
    //   184: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_0
    //   188: invokevirtual 211	android/graphics/Bitmap:getAllocationByteCount	()I
    //   191: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 119	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   200: pop
    //   201: aload_0
    //   202: areturn
    //   203: astore_0
    //   204: ldc 8
    //   206: ldc 213
    //   208: aload_0
    //   209: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   212: pop
    //   213: aload_0
    //   214: athrow
    //   215: getstatic 125	com/tencent/qg/sdk/QGRenderer:assetManager	Landroid/content/res/AssetManager;
    //   218: aload_0
    //   219: invokevirtual 131	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   222: invokestatic 186	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   225: astore_0
    //   226: goto -98 -> 128
    //   229: astore_0
    //   230: aconst_null
    //   231: astore 5
    //   233: ldc 8
    //   235: ldc 215
    //   237: aload_0
    //   238: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   241: pop
    //   242: aload 5
    //   244: areturn
    //   245: astore_0
    //   246: aconst_null
    //   247: astore 4
    //   249: ldc 8
    //   251: ldc 217
    //   253: aload_0
    //   254: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   257: pop
    //   258: aload_0
    //   259: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   262: aload 4
    //   264: areturn
    //   265: astore_0
    //   266: goto -17 -> 249
    //   269: astore_0
    //   270: goto -37 -> 233
    //   273: astore_0
    //   274: aconst_null
    //   275: astore_3
    //   276: goto -182 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramString	String
    //   108	46	1	l	long
    //   79	197	3	str1	String
    //   81	182	4	str2	String
    //   84	159	5	str3	String
    //   70	17	6	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   86	91	93	java/net/MalformedURLException
    //   136	165	93	java/net/MalformedURLException
    //   173	201	93	java/net/MalformedURLException
    //   33	78	203	java/lang/OutOfMemoryError
    //   86	91	203	java/lang/OutOfMemoryError
    //   105	128	203	java/lang/OutOfMemoryError
    //   136	165	203	java/lang/OutOfMemoryError
    //   173	201	203	java/lang/OutOfMemoryError
    //   215	226	203	java/lang/OutOfMemoryError
    //   33	78	229	java/io/FileNotFoundException
    //   105	128	229	java/io/FileNotFoundException
    //   215	226	229	java/io/FileNotFoundException
    //   33	78	245	java/io/IOException
    //   105	128	245	java/io/IOException
    //   215	226	245	java/io/IOException
    //   86	91	265	java/io/IOException
    //   136	165	265	java/io/IOException
    //   173	201	265	java/io/IOException
    //   86	91	269	java/io/FileNotFoundException
    //   136	165	269	java/io/FileNotFoundException
    //   173	201	269	java/io/FileNotFoundException
    //   33	78	273	java/net/MalformedURLException
    //   105	128	273	java/net/MalformedURLException
    //   215	226	273	java/net/MalformedURLException
  }
  
  /* Error */
  public static java.nio.ByteBuffer loadETC1Texture(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 8
    //   9: ldc 8
    //   11: new 34	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   18: ldc 224
    //   20: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 119	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   33: pop
    //   34: aload_0
    //   35: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifne +12 -> 50
    //   41: aload_0
    //   42: ldc 156
    //   44: invokevirtual 160	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   47: ifeq +5 -> 52
    //   50: aconst_null
    //   51: areturn
    //   52: getstatic 92	com/tencent/qg/sdk/QGBitmapLoader:etc1TextureHashMap	Ljava/util/HashMap;
    //   55: ifnull +27 -> 82
    //   58: getstatic 92	com/tencent/qg/sdk/QGBitmapLoader:etc1TextureHashMap	Ljava/util/HashMap;
    //   61: aload_0
    //   62: invokevirtual 228	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   65: ifeq +17 -> 82
    //   68: getstatic 92	com/tencent/qg/sdk/QGBitmapLoader:etc1TextureHashMap	Ljava/util/HashMap;
    //   71: aload_0
    //   72: invokevirtual 232	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast 77	android/opengl/ETC1Util$ETC1Texture
    //   78: invokevirtual 236	android/opengl/ETC1Util$ETC1Texture:getData	()Ljava/nio/ByteBuffer;
    //   81: areturn
    //   82: aload 8
    //   84: astore 4
    //   86: aload 9
    //   88: astore 5
    //   90: aload 10
    //   92: astore 6
    //   94: new 34	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   101: aload_0
    //   102: iconst_0
    //   103: aload_0
    //   104: ldc 37
    //   106: invokevirtual 43	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   109: invokevirtual 47	java/lang/String:substring	(II)Ljava/lang/String;
    //   112: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 53
    //   117: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore 11
    //   125: new 68	java/io/FileInputStream
    //   128: dup
    //   129: new 59	java/io/File
    //   132: dup
    //   133: aload 11
    //   135: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   138: invokespecial 239	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   141: astore 7
    //   143: aload 7
    //   145: invokestatic 75	android/opengl/ETC1Util:createTexture	(Ljava/io/InputStream;)Landroid/opengl/ETC1Util$ETC1Texture;
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 81	android/opengl/ETC1Util$ETC1Texture:getWidth	()I
    //   153: istore_1
    //   154: aload_0
    //   155: invokevirtual 84	android/opengl/ETC1Util$ETC1Texture:getHeight	()I
    //   158: istore_2
    //   159: iload_1
    //   160: iload_2
    //   161: invokestatic 90	android/opengl/ETC1:getEncodedDataSize	(II)I
    //   164: istore_3
    //   165: ldc 199
    //   167: new 34	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   174: ldc 241
    //   176: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload_3
    //   180: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc 111
    //   185: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: iload_1
    //   189: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: ldc 113
    //   194: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: iload_2
    //   198: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 119	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   207: pop
    //   208: aload_0
    //   209: invokevirtual 236	android/opengl/ETC1Util$ETC1Texture:getData	()Ljava/nio/ByteBuffer;
    //   212: astore_0
    //   213: aload 7
    //   215: ifnull +17 -> 232
    //   218: aload_0
    //   219: astore 4
    //   221: aload_0
    //   222: astore 5
    //   224: aload_0
    //   225: astore 6
    //   227: aload 7
    //   229: invokevirtual 104	java/io/InputStream:close	()V
    //   232: aload_0
    //   233: astore 4
    //   235: aload_0
    //   236: astore 5
    //   238: aload_0
    //   239: astore 6
    //   241: ldc 8
    //   243: new 34	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   250: ldc 243
    //   252: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: iconst_1
    //   256: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   259: ldc 248
    //   261: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 11
    //   266: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 119	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   275: pop
    //   276: aload_0
    //   277: areturn
    //   278: astore_0
    //   279: ldc 8
    //   281: ldc 188
    //   283: aload_0
    //   284: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   287: pop
    //   288: aload 4
    //   290: areturn
    //   291: astore_0
    //   292: aconst_null
    //   293: astore 7
    //   295: aload 7
    //   297: ifnull +20 -> 317
    //   300: aload 8
    //   302: astore 4
    //   304: aload 9
    //   306: astore 5
    //   308: aload 10
    //   310: astore 6
    //   312: aload 7
    //   314: invokevirtual 104	java/io/InputStream:close	()V
    //   317: aload 8
    //   319: astore 4
    //   321: aload 9
    //   323: astore 5
    //   325: aload 10
    //   327: astore 6
    //   329: aload_0
    //   330: athrow
    //   331: astore_0
    //   332: ldc 8
    //   334: ldc 213
    //   336: aload_0
    //   337: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   340: pop
    //   341: aload_0
    //   342: athrow
    //   343: astore_0
    //   344: ldc 8
    //   346: ldc 215
    //   348: aload_0
    //   349: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   352: pop
    //   353: aload 5
    //   355: areturn
    //   356: astore_0
    //   357: ldc 8
    //   359: ldc 217
    //   361: aload_0
    //   362: invokestatic 137	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   365: pop
    //   366: aload_0
    //   367: invokevirtual 220	java/io/IOException:printStackTrace	()V
    //   370: aload 6
    //   372: areturn
    //   373: astore_0
    //   374: goto -79 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	paramString	String
    //   153	36	1	i	int
    //   158	40	2	j	int
    //   164	16	3	k	int
    //   84	236	4	localObject1	Object
    //   88	266	5	localObject2	Object
    //   92	279	6	localObject3	Object
    //   141	172	7	localFileInputStream	java.io.FileInputStream
    //   7	311	8	localObject4	Object
    //   1	321	9	localObject5	Object
    //   4	322	10	localObject6	Object
    //   123	142	11	str	String
    // Exception table:
    //   from	to	target	type
    //   94	125	278	java/net/MalformedURLException
    //   227	232	278	java/net/MalformedURLException
    //   241	276	278	java/net/MalformedURLException
    //   312	317	278	java/net/MalformedURLException
    //   329	331	278	java/net/MalformedURLException
    //   125	143	291	finally
    //   94	125	331	java/lang/OutOfMemoryError
    //   227	232	331	java/lang/OutOfMemoryError
    //   241	276	331	java/lang/OutOfMemoryError
    //   312	317	331	java/lang/OutOfMemoryError
    //   329	331	331	java/lang/OutOfMemoryError
    //   94	125	343	java/io/FileNotFoundException
    //   227	232	343	java/io/FileNotFoundException
    //   241	276	343	java/io/FileNotFoundException
    //   312	317	343	java/io/FileNotFoundException
    //   329	331	343	java/io/FileNotFoundException
    //   94	125	356	java/io/IOException
    //   227	232	356	java/io/IOException
    //   241	276	356	java/io/IOException
    //   312	317	356	java/io/IOException
    //   329	331	356	java/io/IOException
    //   143	213	373	finally
  }
  
  public static Bitmap readDataUrl(String paramString)
  {
    Log.d("QGBitmapLoader", "stevcao readDataUrl url = " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Base64.decode(Base64Utils.getBase64StrFromDataUrl(paramString), 2);
    return BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
  }
  
  public static void setBitmapLoader(QGBitmapLoader.QGBitmapLoaderImpl paramQGBitmapLoaderImpl)
  {
    mLoaderInstance = paramQGBitmapLoaderImpl;
  }
  
  public static final String toDataUrl(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    return toDataUrl(paramInt1, paramString, paramInt2, paramInt3, false);
  }
  
  /* Error */
  public static final String toDataUrl(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 277
    //   3: new 34	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 279
    //   13: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: iload_0
    //   17: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc_w 281
    //   23: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 283
    //   33: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload_2
    //   37: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: ldc_w 285
    //   43: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload_3
    //   47: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc_w 287
    //   53: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload 4
    //   58: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 119	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   67: pop
    //   68: aconst_null
    //   69: astore 8
    //   71: iload_0
    //   72: ifeq +140 -> 212
    //   75: iload_0
    //   76: iload_2
    //   77: iload_3
    //   78: iload 4
    //   80: invokestatic 293	com/tencent/qg/sdk/Utils:readTextureToBitmap	(IIIZ)Landroid/graphics/Bitmap;
    //   83: astore 7
    //   85: new 295	java/io/ByteArrayOutputStream
    //   88: dup
    //   89: sipush 4096
    //   92: invokespecial 298	java/io/ByteArrayOutputStream:<init>	(I)V
    //   95: astore 6
    //   97: ldc_w 300
    //   100: aload_1
    //   101: invokevirtual 303	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   104: ifne +23 -> 127
    //   107: ldc_w 305
    //   110: aload_1
    //   111: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: ifne +13 -> 127
    //   117: ldc_w 310
    //   120: aload_1
    //   121: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   124: ifeq +100 -> 224
    //   127: new 34	java/lang/StringBuilder
    //   130: dup
    //   131: ldc_w 312
    //   134: invokespecial 313	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: astore_1
    //   138: aload 7
    //   140: getstatic 319	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   143: bipush 100
    //   145: aload 6
    //   147: invokevirtual 323	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   150: pop
    //   151: aload_1
    //   152: aload 6
    //   154: invokevirtual 327	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   157: iconst_2
    //   158: invokestatic 331	com/tencent/qg/sdk/base64/Base64:encodeToString	([BI)Ljava/lang/String;
    //   161: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: astore_1
    //   170: ldc_w 277
    //   173: new 34	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 333
    //   183: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: invokevirtual 336	java/lang/String:length	()I
    //   190: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 119	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   199: pop
    //   200: aload 6
    //   202: ifnull +8 -> 210
    //   205: aload 6
    //   207: invokevirtual 337	java/io/ByteArrayOutputStream:close	()V
    //   210: aload_1
    //   211: areturn
    //   212: iload_2
    //   213: iload_3
    //   214: iload 4
    //   216: invokestatic 341	com/tencent/qg/sdk/Utils:readPixesToBitmap	(IIZ)Landroid/graphics/Bitmap;
    //   219: astore 7
    //   221: goto -136 -> 85
    //   224: new 34	java/lang/StringBuilder
    //   227: dup
    //   228: ldc_w 343
    //   231: invokespecial 313	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   234: astore_1
    //   235: bipush 80
    //   237: istore 5
    //   239: iload 5
    //   241: istore_0
    //   242: iload_2
    //   243: sipush 256
    //   246: if_icmpgt +16 -> 262
    //   249: iload 5
    //   251: istore_0
    //   252: iload_3
    //   253: sipush 256
    //   256: if_icmpgt +6 -> 262
    //   259: bipush 100
    //   261: istore_0
    //   262: aload 7
    //   264: getstatic 346	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   267: iload_0
    //   268: aload 6
    //   270: invokevirtual 323	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   273: pop
    //   274: goto -123 -> 151
    //   277: astore 7
    //   279: aload 6
    //   281: astore_1
    //   282: aload 7
    //   284: astore 6
    //   286: aload 6
    //   288: invokevirtual 347	java/lang/Throwable:printStackTrace	()V
    //   291: aload_1
    //   292: ifnull +7 -> 299
    //   295: aload_1
    //   296: invokevirtual 337	java/io/ByteArrayOutputStream:close	()V
    //   299: ldc_w 349
    //   302: areturn
    //   303: astore 6
    //   305: aload 6
    //   307: invokevirtual 350	java/lang/Exception:printStackTrace	()V
    //   310: aload_1
    //   311: areturn
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual 350	java/lang/Exception:printStackTrace	()V
    //   317: goto -18 -> 299
    //   320: astore_1
    //   321: aconst_null
    //   322: astore 6
    //   324: aload 6
    //   326: ifnull +8 -> 334
    //   329: aload 6
    //   331: invokevirtual 337	java/io/ByteArrayOutputStream:close	()V
    //   334: aload_1
    //   335: athrow
    //   336: astore 6
    //   338: aload 6
    //   340: invokevirtual 350	java/lang/Exception:printStackTrace	()V
    //   343: goto -9 -> 334
    //   346: astore_1
    //   347: goto -23 -> 324
    //   350: astore 7
    //   352: aload_1
    //   353: astore 6
    //   355: aload 7
    //   357: astore_1
    //   358: goto -34 -> 324
    //   361: astore 6
    //   363: aload 8
    //   365: astore_1
    //   366: goto -80 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	paramInt1	int
    //   0	369	1	paramString	String
    //   0	369	2	paramInt2	int
    //   0	369	3	paramInt3	int
    //   0	369	4	paramBoolean	boolean
    //   237	13	5	i	int
    //   95	192	6	localObject1	Object
    //   303	3	6	localException1	java.lang.Exception
    //   322	8	6	localObject2	Object
    //   336	3	6	localException2	java.lang.Exception
    //   353	1	6	str	String
    //   361	1	6	localThrowable1	java.lang.Throwable
    //   83	180	7	localBitmap	Bitmap
    //   277	6	7	localThrowable2	java.lang.Throwable
    //   350	6	7	localObject3	Object
    //   69	295	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   97	127	277	java/lang/Throwable
    //   127	151	277	java/lang/Throwable
    //   151	200	277	java/lang/Throwable
    //   224	235	277	java/lang/Throwable
    //   262	274	277	java/lang/Throwable
    //   205	210	303	java/lang/Exception
    //   295	299	312	java/lang/Exception
    //   75	85	320	finally
    //   85	97	320	finally
    //   212	221	320	finally
    //   329	334	336	java/lang/Exception
    //   97	127	346	finally
    //   127	151	346	finally
    //   151	200	346	finally
    //   224	235	346	finally
    //   262	274	346	finally
    //   286	291	350	finally
    //   75	85	361	java/lang/Throwable
    //   85	97	361	java/lang/Throwable
    //   212	221	361	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.sdk.QGBitmapLoader
 * JD-Core Version:    0.7.0.1
 */