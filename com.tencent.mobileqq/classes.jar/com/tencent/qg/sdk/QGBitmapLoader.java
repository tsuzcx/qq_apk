package com.tencent.qg.sdk;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.ETC1Util.ETC1Texture;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qg.sdk.base64.Base64;
import com.tencent.qg.sdk.base64.Base64Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
    //   0: aload_0
    //   1: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 7
    //   6: aconst_null
    //   7: astore 13
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 11
    //   18: aconst_null
    //   19: astore 12
    //   21: iload 7
    //   23: ifeq +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: new 34	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   35: astore 10
    //   37: aload 10
    //   39: aload_0
    //   40: iconst_0
    //   41: aload_0
    //   42: ldc 37
    //   44: invokevirtual 43	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   47: invokevirtual 47	java/lang/String:substring	(II)Ljava/lang/String;
    //   50: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 10
    //   56: ldc 53
    //   58: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 10
    //   64: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 10
    //   69: new 59	java/io/File
    //   72: dup
    //   73: aload 10
    //   75: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 66	java/io/File:exists	()Z
    //   81: ifeq +21 -> 102
    //   84: new 68	java/io/FileInputStream
    //   87: dup
    //   88: aload 10
    //   90: invokespecial 69	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   93: astore 10
    //   95: aload 10
    //   97: astore 9
    //   99: goto +17 -> 116
    //   102: getstatic 75	com/tencent/qg/sdk/QGRenderer:assetManager	Landroid/content/res/AssetManager;
    //   105: aload 10
    //   107: invokevirtual 81	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   110: astore 10
    //   112: aload 10
    //   114: astore 9
    //   116: aload 12
    //   118: astore 10
    //   120: aload 13
    //   122: astore 11
    //   124: aload 9
    //   126: invokestatic 87	android/opengl/ETC1Util:createTexture	(Ljava/io/InputStream;)Landroid/opengl/ETC1Util$ETC1Texture;
    //   129: astore 14
    //   131: aload 12
    //   133: astore 10
    //   135: aload 13
    //   137: astore 11
    //   139: iconst_3
    //   140: newarray int
    //   142: astore 8
    //   144: aload 8
    //   146: astore 10
    //   148: aload 8
    //   150: astore 11
    //   152: aload 14
    //   154: invokevirtual 93	android/opengl/ETC1Util$ETC1Texture:getWidth	()I
    //   157: istore_1
    //   158: aload 14
    //   160: invokevirtual 96	android/opengl/ETC1Util$ETC1Texture:getHeight	()I
    //   163: istore_2
    //   164: iload_1
    //   165: iload_2
    //   166: invokestatic 102	android/opengl/ETC1:getEncodedDataSize	(II)I
    //   169: istore 6
    //   171: aload 8
    //   173: iconst_0
    //   174: iload_1
    //   175: iastore
    //   176: aload 8
    //   178: iconst_1
    //   179: iload_2
    //   180: iastore
    //   181: aload 8
    //   183: iconst_2
    //   184: iload 6
    //   186: iastore
    //   187: getstatic 104	com/tencent/qg/sdk/QGBitmapLoader:etc1TextureHashMap	Ljava/util/HashMap;
    //   190: ifnonnull +13 -> 203
    //   193: new 106	java/util/HashMap
    //   196: dup
    //   197: invokespecial 107	java/util/HashMap:<init>	()V
    //   200: putstatic 104	com/tencent/qg/sdk/QGBitmapLoader:etc1TextureHashMap	Ljava/util/HashMap;
    //   203: getstatic 104	com/tencent/qg/sdk/QGBitmapLoader:etc1TextureHashMap	Ljava/util/HashMap;
    //   206: aload_0
    //   207: aload 14
    //   209: invokevirtual 111	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: aload 9
    //   215: ifnull +21 -> 236
    //   218: aload 9
    //   220: invokevirtual 116	java/io/InputStream:close	()V
    //   223: goto +13 -> 236
    //   226: astore_0
    //   227: ldc 8
    //   229: ldc 118
    //   231: aload_0
    //   232: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   235: pop
    //   236: iload_2
    //   237: istore 5
    //   239: goto +303 -> 542
    //   242: astore 10
    //   244: aload 8
    //   246: astore_0
    //   247: iload_2
    //   248: istore_3
    //   249: iload 6
    //   251: istore 4
    //   253: aload 10
    //   255: astore 8
    //   257: goto +73 -> 330
    //   260: astore 10
    //   262: aload 8
    //   264: astore_0
    //   265: iload_2
    //   266: istore_3
    //   267: iload 6
    //   269: istore 4
    //   271: aload 10
    //   273: astore 8
    //   275: goto +88 -> 363
    //   278: astore 10
    //   280: aload 8
    //   282: astore_0
    //   283: goto +38 -> 321
    //   286: astore 10
    //   288: aload 8
    //   290: astore_0
    //   291: goto +63 -> 354
    //   294: astore_0
    //   295: goto +18 -> 313
    //   298: astore_0
    //   299: goto +47 -> 346
    //   302: astore_0
    //   303: goto +301 -> 604
    //   306: astore_0
    //   307: iconst_0
    //   308: istore_1
    //   309: aload 10
    //   311: astore 8
    //   313: iconst_0
    //   314: istore_2
    //   315: aload_0
    //   316: astore 10
    //   318: aload 8
    //   320: astore_0
    //   321: iconst_0
    //   322: istore 4
    //   324: aload 10
    //   326: astore 8
    //   328: iload_2
    //   329: istore_3
    //   330: iload_1
    //   331: istore_2
    //   332: aload 8
    //   334: astore 10
    //   336: goto +55 -> 391
    //   339: astore_0
    //   340: iconst_0
    //   341: istore_1
    //   342: aload 11
    //   344: astore 8
    //   346: iconst_0
    //   347: istore_2
    //   348: aload_0
    //   349: astore 10
    //   351: aload 8
    //   353: astore_0
    //   354: iconst_0
    //   355: istore 4
    //   357: aload 10
    //   359: astore 8
    //   361: iload_2
    //   362: istore_3
    //   363: iload_1
    //   364: istore_2
    //   365: aload 8
    //   367: astore 10
    //   369: goto +113 -> 482
    //   372: astore_0
    //   373: aload 8
    //   375: astore 9
    //   377: goto +227 -> 604
    //   380: astore 10
    //   382: aconst_null
    //   383: astore_0
    //   384: iconst_0
    //   385: istore_2
    //   386: iconst_0
    //   387: istore_3
    //   388: iconst_0
    //   389: istore 4
    //   391: aload 9
    //   393: astore 8
    //   395: ldc 8
    //   397: ldc 125
    //   399: aload 10
    //   401: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   404: pop
    //   405: aload_0
    //   406: astore 8
    //   408: iload_2
    //   409: istore_1
    //   410: iload_3
    //   411: istore 5
    //   413: iload 4
    //   415: istore 6
    //   417: aload 9
    //   419: ifnull +123 -> 542
    //   422: aload_0
    //   423: astore 8
    //   425: iload_2
    //   426: istore_1
    //   427: iload_3
    //   428: istore 5
    //   430: iload 4
    //   432: istore 6
    //   434: aload 9
    //   436: invokevirtual 116	java/io/InputStream:close	()V
    //   439: aload_0
    //   440: astore 8
    //   442: iload_2
    //   443: istore_1
    //   444: iload_3
    //   445: istore 5
    //   447: iload 4
    //   449: istore 6
    //   451: goto +91 -> 542
    //   454: astore_0
    //   455: ldc 8
    //   457: ldc 118
    //   459: aload_0
    //   460: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   463: pop
    //   464: goto +78 -> 542
    //   467: astore 10
    //   469: aconst_null
    //   470: astore_0
    //   471: iconst_0
    //   472: istore_2
    //   473: iconst_0
    //   474: istore_3
    //   475: iconst_0
    //   476: istore 4
    //   478: aload 11
    //   480: astore 9
    //   482: aload 9
    //   484: astore 8
    //   486: ldc 8
    //   488: ldc 125
    //   490: aload 10
    //   492: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   495: pop
    //   496: aload_0
    //   497: astore 8
    //   499: iload_2
    //   500: istore_1
    //   501: iload_3
    //   502: istore 5
    //   504: iload 4
    //   506: istore 6
    //   508: aload 9
    //   510: ifnull +32 -> 542
    //   513: aload_0
    //   514: astore 8
    //   516: iload_2
    //   517: istore_1
    //   518: iload_3
    //   519: istore 5
    //   521: iload 4
    //   523: istore 6
    //   525: aload 9
    //   527: invokevirtual 116	java/io/InputStream:close	()V
    //   530: iload 4
    //   532: istore 6
    //   534: iload_3
    //   535: istore 5
    //   537: iload_2
    //   538: istore_1
    //   539: aload_0
    //   540: astore 8
    //   542: new 34	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   549: astore_0
    //   550: aload_0
    //   551: ldc 127
    //   553: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload_0
    //   558: iload 6
    //   560: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload_0
    //   565: ldc 132
    //   567: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload_0
    //   572: iload_1
    //   573: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload_0
    //   578: ldc 134
    //   580: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload_0
    //   585: iload 5
    //   587: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: ldc 8
    //   593: aload_0
    //   594: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 138	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   600: pop
    //   601: aload 8
    //   603: areturn
    //   604: aload 9
    //   606: ifnull +23 -> 629
    //   609: aload 9
    //   611: invokevirtual 116	java/io/InputStream:close	()V
    //   614: goto +15 -> 629
    //   617: astore 8
    //   619: ldc 8
    //   621: ldc 118
    //   623: aload 8
    //   625: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   628: pop
    //   629: aload_0
    //   630: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	paramString	String
    //   157	416	1	i	int
    //   163	375	2	j	int
    //   248	287	3	k	int
    //   251	280	4	m	int
    //   237	349	5	n	int
    //   169	390	6	i1	int
    //   4	18	7	bool	boolean
    //   10	592	8	localObject1	Object
    //   617	7	8	localIOException	IOException
    //   13	597	9	localObject2	Object
    //   35	112	10	localObject3	Object
    //   242	12	10	localException1	java.lang.Exception
    //   260	12	10	localFileNotFoundException1	FileNotFoundException
    //   278	1	10	localException2	java.lang.Exception
    //   286	24	10	localFileNotFoundException2	FileNotFoundException
    //   316	52	10	localObject4	Object
    //   380	20	10	localException3	java.lang.Exception
    //   467	24	10	localFileNotFoundException3	FileNotFoundException
    //   16	463	11	localObject5	Object
    //   19	113	12	localObject6	Object
    //   7	129	13	localObject7	Object
    //   129	79	14	localETC1Texture	ETC1Util.ETC1Texture
    // Exception table:
    //   from	to	target	type
    //   218	223	226	java/io/IOException
    //   187	203	242	java/lang/Exception
    //   203	213	242	java/lang/Exception
    //   187	203	260	java/io/FileNotFoundException
    //   203	213	260	java/io/FileNotFoundException
    //   164	171	278	java/lang/Exception
    //   164	171	286	java/io/FileNotFoundException
    //   158	164	294	java/lang/Exception
    //   158	164	298	java/io/FileNotFoundException
    //   124	131	302	finally
    //   139	144	302	finally
    //   152	158	302	finally
    //   158	164	302	finally
    //   164	171	302	finally
    //   187	203	302	finally
    //   203	213	302	finally
    //   124	131	306	java/lang/Exception
    //   139	144	306	java/lang/Exception
    //   152	158	306	java/lang/Exception
    //   124	131	339	java/io/FileNotFoundException
    //   139	144	339	java/io/FileNotFoundException
    //   152	158	339	java/io/FileNotFoundException
    //   84	95	372	finally
    //   102	112	372	finally
    //   395	405	372	finally
    //   486	496	372	finally
    //   84	95	380	java/lang/Exception
    //   102	112	380	java/lang/Exception
    //   434	439	454	java/io/IOException
    //   525	530	454	java/io/IOException
    //   84	95	467	java/io/FileNotFoundException
    //   102	112	467	java/io/FileNotFoundException
    //   609	614	617	java/io/IOException
  }
  
  public static Bitmap load(String paramString)
  {
    Object localObject1 = mLoaderInstance;
    if (localObject1 != null) {
      return ((QGBitmapLoader.QGBitmapLoaderImpl)localObject1).load(paramString);
    }
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject4 = null;
    Object localObject5 = null;
    StringBuilder localStringBuilder = null;
    if (bool)
    {
      Log.e("QGBitmapLoader", "load filepath is null");
      return null;
    }
    localObject1 = localStringBuilder;
    Object localObject2 = localObject4;
    Object localObject3 = localObject5;
    for (;;)
    {
      try
      {
        if (paramString.startsWith("http"))
        {
          localObject1 = localStringBuilder;
          localObject2 = localObject4;
          localObject3 = localObject5;
          paramString = (HttpURLConnection)new URL(paramString).openConnection();
          localObject1 = localStringBuilder;
          localObject2 = localObject4;
          localObject3 = localObject5;
          paramString.setDoInput(true);
          localObject1 = localStringBuilder;
          localObject2 = localObject4;
          localObject3 = localObject5;
          paramString.connect();
          localObject1 = localStringBuilder;
          localObject2 = localObject4;
          localObject3 = localObject5;
          InputStream localInputStream = paramString.getInputStream();
          localObject1 = localStringBuilder;
          localObject2 = localObject4;
          localObject3 = localObject5;
          paramString = BitmapFactory.decodeStream(localInputStream);
          localObject1 = paramString;
          localObject2 = paramString;
          localObject3 = paramString;
          localInputStream.close();
          return paramString;
        }
        localObject1 = localStringBuilder;
        localObject2 = localObject4;
        localObject3 = localObject5;
        l = System.currentTimeMillis();
        localObject1 = localStringBuilder;
        localObject2 = localObject4;
        localObject3 = localObject5;
        if (new File(paramString).exists())
        {
          localObject1 = localStringBuilder;
          localObject2 = localObject4;
          localObject3 = localObject5;
          paramString = BitmapFactory.decodeFile(paramString);
        }
        else
        {
          localObject1 = localStringBuilder;
          localObject2 = localObject4;
          localObject3 = localObject5;
          paramString = BitmapFactory.decodeStream(QGRenderer.assetManager.open(paramString));
        }
      }
      catch (IOException paramString)
      {
        long l;
        Log.e("QGBitmapLoader", "decodeFile IOException", paramString);
        paramString.printStackTrace();
        return localObject1;
      }
      catch (FileNotFoundException paramString)
      {
        Log.e("QGBitmapLoader", "decodeFile FileNotFoundException", paramString);
        return localObject2;
      }
      catch (OutOfMemoryError paramString)
      {
        Log.e("QGBitmapLoader", "decodeFile failed", paramString);
        throw paramString;
      }
      catch (MalformedURLException paramString)
      {
        Log.e("QGBitmapLoader", "MalformedURLException failed", paramString);
        return localObject3;
      }
      localObject1 = paramString;
      localObject2 = paramString;
      localObject3 = paramString;
      localStringBuilder = new StringBuilder();
      localObject1 = paramString;
      localObject2 = paramString;
      localObject3 = paramString;
      localStringBuilder.append("PNG==> io&bitmap Cost:");
      localObject1 = paramString;
      localObject2 = paramString;
      localObject3 = paramString;
      localStringBuilder.append(System.currentTimeMillis() - l);
      localObject1 = paramString;
      localObject2 = paramString;
      localObject3 = paramString;
      Log.d("yellow", localStringBuilder.toString());
      localObject1 = paramString;
      localObject2 = paramString;
      localObject3 = paramString;
      localStringBuilder = new StringBuilder();
      localObject1 = paramString;
      localObject2 = paramString;
      localObject3 = paramString;
      localStringBuilder.append("PNG==> size:");
      localObject1 = paramString;
      localObject2 = paramString;
      localObject3 = paramString;
      localStringBuilder.append(paramString.getAllocationByteCount());
      localObject1 = paramString;
      localObject2 = paramString;
      localObject3 = paramString;
      Log.d("yellow", localStringBuilder.toString());
      return paramString;
    }
  }
  
  /* Error */
  public static java.nio.ByteBuffer loadETC1Texture(String paramString)
  {
    // Byte code:
    //   0: new 34	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc 224
    //   13: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 5
    //   19: aload_0
    //   20: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 8
    //   26: aload 5
    //   28: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 138	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   34: pop
    //   35: aload_0
    //   36: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: istore 4
    //   41: aconst_null
    //   42: astore 10
    //   44: aconst_null
    //   45: astore 11
    //   47: aconst_null
    //   48: astore 5
    //   50: aconst_null
    //   51: astore 9
    //   53: iload 4
    //   55: ifne +454 -> 509
    //   58: aload_0
    //   59: ldc 156
    //   61: invokevirtual 160	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifeq +5 -> 69
    //   67: aconst_null
    //   68: areturn
    //   69: getstatic 104	com/tencent/qg/sdk/QGBitmapLoader:etc1TextureHashMap	Ljava/util/HashMap;
    //   72: astore 5
    //   74: aload 5
    //   76: ifnull +26 -> 102
    //   79: aload 5
    //   81: aload_0
    //   82: invokevirtual 228	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   85: ifeq +17 -> 102
    //   88: getstatic 104	com/tencent/qg/sdk/QGBitmapLoader:etc1TextureHashMap	Ljava/util/HashMap;
    //   91: aload_0
    //   92: invokevirtual 232	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 89	android/opengl/ETC1Util$ETC1Texture
    //   98: invokevirtual 236	android/opengl/ETC1Util$ETC1Texture:getData	()Ljava/nio/ByteBuffer;
    //   101: areturn
    //   102: aload 9
    //   104: astore 6
    //   106: aload 10
    //   108: astore 7
    //   110: aload 11
    //   112: astore 5
    //   114: new 34	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   121: astore 8
    //   123: aload 9
    //   125: astore 6
    //   127: aload 10
    //   129: astore 7
    //   131: aload 11
    //   133: astore 5
    //   135: aload 8
    //   137: aload_0
    //   138: iconst_0
    //   139: aload_0
    //   140: ldc 37
    //   142: invokevirtual 43	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   145: invokevirtual 47	java/lang/String:substring	(II)Ljava/lang/String;
    //   148: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 9
    //   154: astore 6
    //   156: aload 10
    //   158: astore 7
    //   160: aload 11
    //   162: astore 5
    //   164: aload 8
    //   166: ldc 53
    //   168: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 9
    //   174: astore 6
    //   176: aload 10
    //   178: astore 7
    //   180: aload 11
    //   182: astore 5
    //   184: aload 8
    //   186: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: astore 12
    //   191: new 68	java/io/FileInputStream
    //   194: dup
    //   195: new 59	java/io/File
    //   198: dup
    //   199: aload 12
    //   201: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: invokespecial 239	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   207: astore 8
    //   209: aload 8
    //   211: invokestatic 87	android/opengl/ETC1Util:createTexture	(Ljava/io/InputStream;)Landroid/opengl/ETC1Util$ETC1Texture;
    //   214: astore_0
    //   215: aload_0
    //   216: invokevirtual 93	android/opengl/ETC1Util$ETC1Texture:getWidth	()I
    //   219: istore_1
    //   220: aload_0
    //   221: invokevirtual 96	android/opengl/ETC1Util$ETC1Texture:getHeight	()I
    //   224: istore_2
    //   225: iload_1
    //   226: iload_2
    //   227: invokestatic 102	android/opengl/ETC1:getEncodedDataSize	(II)I
    //   230: istore_3
    //   231: new 34	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   238: astore 5
    //   240: aload 5
    //   242: ldc 241
    //   244: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 5
    //   250: iload_3
    //   251: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 5
    //   257: ldc 132
    //   259: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 5
    //   265: iload_1
    //   266: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 5
    //   272: ldc 134
    //   274: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 5
    //   280: iload_2
    //   281: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: ldc 202
    //   287: aload 5
    //   289: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 138	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   295: pop
    //   296: aload_0
    //   297: invokevirtual 236	android/opengl/ETC1Util$ETC1Texture:getData	()Ljava/nio/ByteBuffer;
    //   300: astore_0
    //   301: aload_0
    //   302: astore 6
    //   304: aload_0
    //   305: astore 7
    //   307: aload_0
    //   308: astore 5
    //   310: aload 8
    //   312: invokevirtual 116	java/io/InputStream:close	()V
    //   315: aload_0
    //   316: astore 6
    //   318: aload_0
    //   319: astore 7
    //   321: aload_0
    //   322: astore 5
    //   324: new 34	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   331: astore 8
    //   333: aload_0
    //   334: astore 6
    //   336: aload_0
    //   337: astore 7
    //   339: aload_0
    //   340: astore 5
    //   342: aload 8
    //   344: ldc 243
    //   346: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_0
    //   351: astore 6
    //   353: aload_0
    //   354: astore 7
    //   356: aload_0
    //   357: astore 5
    //   359: aload 8
    //   361: iconst_1
    //   362: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_0
    //   367: astore 6
    //   369: aload_0
    //   370: astore 7
    //   372: aload_0
    //   373: astore 5
    //   375: aload 8
    //   377: ldc 248
    //   379: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_0
    //   384: astore 6
    //   386: aload_0
    //   387: astore 7
    //   389: aload_0
    //   390: astore 5
    //   392: aload 8
    //   394: aload 12
    //   396: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload_0
    //   401: astore 6
    //   403: aload_0
    //   404: astore 7
    //   406: aload_0
    //   407: astore 5
    //   409: ldc 8
    //   411: aload 8
    //   413: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 138	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   419: pop
    //   420: aload_0
    //   421: areturn
    //   422: aload_0
    //   423: ifnull +19 -> 442
    //   426: aload 9
    //   428: astore 6
    //   430: aload 10
    //   432: astore 7
    //   434: aload 11
    //   436: astore 5
    //   438: aload_0
    //   439: invokevirtual 116	java/io/InputStream:close	()V
    //   442: aload 9
    //   444: astore 6
    //   446: aload 10
    //   448: astore 7
    //   450: aload 11
    //   452: astore 5
    //   454: aload 8
    //   456: athrow
    //   457: astore_0
    //   458: ldc 8
    //   460: ldc 211
    //   462: aload_0
    //   463: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   466: pop
    //   467: aload_0
    //   468: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   471: aload 6
    //   473: areturn
    //   474: astore_0
    //   475: ldc 8
    //   477: ldc 216
    //   479: aload_0
    //   480: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   483: pop
    //   484: aload 7
    //   486: areturn
    //   487: astore_0
    //   488: ldc 8
    //   490: ldc 218
    //   492: aload_0
    //   493: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   496: pop
    //   497: aload_0
    //   498: athrow
    //   499: astore_0
    //   500: ldc 8
    //   502: ldc 220
    //   504: aload_0
    //   505: invokestatic 124	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   508: pop
    //   509: aload 5
    //   511: areturn
    //   512: astore 5
    //   514: aload 8
    //   516: astore_0
    //   517: aload 5
    //   519: astore 8
    //   521: goto -99 -> 422
    //   524: astore 8
    //   526: aconst_null
    //   527: astore_0
    //   528: goto -106 -> 422
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	paramString	String
    //   219	47	1	i	int
    //   224	57	2	j	int
    //   230	21	3	k	int
    //   39	15	4	bool	boolean
    //   7	503	5	localObject1	Object
    //   512	6	5	localObject2	Object
    //   104	368	6	localObject3	Object
    //   108	377	7	localObject4	Object
    //   121	399	8	localObject5	Object
    //   524	1	8	localObject6	Object
    //   51	392	9	localObject7	Object
    //   42	405	10	localObject8	Object
    //   45	406	11	localObject9	Object
    //   189	206	12	str	String
    // Exception table:
    //   from	to	target	type
    //   114	123	457	java/io/IOException
    //   135	152	457	java/io/IOException
    //   164	172	457	java/io/IOException
    //   184	191	457	java/io/IOException
    //   310	315	457	java/io/IOException
    //   324	333	457	java/io/IOException
    //   342	350	457	java/io/IOException
    //   359	366	457	java/io/IOException
    //   375	383	457	java/io/IOException
    //   392	400	457	java/io/IOException
    //   409	420	457	java/io/IOException
    //   438	442	457	java/io/IOException
    //   454	457	457	java/io/IOException
    //   114	123	474	java/io/FileNotFoundException
    //   135	152	474	java/io/FileNotFoundException
    //   164	172	474	java/io/FileNotFoundException
    //   184	191	474	java/io/FileNotFoundException
    //   310	315	474	java/io/FileNotFoundException
    //   324	333	474	java/io/FileNotFoundException
    //   342	350	474	java/io/FileNotFoundException
    //   359	366	474	java/io/FileNotFoundException
    //   375	383	474	java/io/FileNotFoundException
    //   392	400	474	java/io/FileNotFoundException
    //   409	420	474	java/io/FileNotFoundException
    //   438	442	474	java/io/FileNotFoundException
    //   454	457	474	java/io/FileNotFoundException
    //   114	123	487	java/lang/OutOfMemoryError
    //   135	152	487	java/lang/OutOfMemoryError
    //   164	172	487	java/lang/OutOfMemoryError
    //   184	191	487	java/lang/OutOfMemoryError
    //   310	315	487	java/lang/OutOfMemoryError
    //   324	333	487	java/lang/OutOfMemoryError
    //   342	350	487	java/lang/OutOfMemoryError
    //   359	366	487	java/lang/OutOfMemoryError
    //   375	383	487	java/lang/OutOfMemoryError
    //   392	400	487	java/lang/OutOfMemoryError
    //   409	420	487	java/lang/OutOfMemoryError
    //   438	442	487	java/lang/OutOfMemoryError
    //   454	457	487	java/lang/OutOfMemoryError
    //   114	123	499	java/net/MalformedURLException
    //   135	152	499	java/net/MalformedURLException
    //   164	172	499	java/net/MalformedURLException
    //   184	191	499	java/net/MalformedURLException
    //   310	315	499	java/net/MalformedURLException
    //   324	333	499	java/net/MalformedURLException
    //   342	350	499	java/net/MalformedURLException
    //   359	366	499	java/net/MalformedURLException
    //   375	383	499	java/net/MalformedURLException
    //   392	400	499	java/net/MalformedURLException
    //   409	420	499	java/net/MalformedURLException
    //   438	442	499	java/net/MalformedURLException
    //   454	457	499	java/net/MalformedURLException
    //   209	301	512	finally
    //   191	209	524	finally
  }
  
  public static Bitmap readDataUrl(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stevcao readDataUrl url = ");
    localStringBuilder.append(paramString);
    Log.d("QGBitmapLoader", localStringBuilder.toString());
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
    //   0: new 34	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 278
    //   14: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 6
    //   20: iload_0
    //   21: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 6
    //   27: ldc_w 280
    //   30: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 6
    //   36: aload_1
    //   37: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 6
    //   43: ldc_w 282
    //   46: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 6
    //   52: iload_2
    //   53: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 6
    //   59: ldc_w 284
    //   62: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 6
    //   68: iload_3
    //   69: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 6
    //   75: ldc_w 286
    //   78: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 6
    //   84: iload 4
    //   86: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: ldc_w 287
    //   93: aload 6
    //   95: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 138	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   101: pop
    //   102: aconst_null
    //   103: astore 9
    //   105: aconst_null
    //   106: astore 7
    //   108: iload_0
    //   109: ifeq +20 -> 129
    //   112: aload 7
    //   114: astore 6
    //   116: iload_0
    //   117: iload_2
    //   118: iload_3
    //   119: iload 4
    //   121: invokestatic 293	com/tencent/qg/sdk/Utils:readTextureToBitmap	(IIIZ)Landroid/graphics/Bitmap;
    //   124: astore 8
    //   126: goto +16 -> 142
    //   129: aload 7
    //   131: astore 6
    //   133: iload_2
    //   134: iload_3
    //   135: iload 4
    //   137: invokestatic 297	com/tencent/qg/sdk/Utils:readPixesToBitmap	(IIZ)Landroid/graphics/Bitmap;
    //   140: astore 8
    //   142: aload 7
    //   144: astore 6
    //   146: new 299	java/io/ByteArrayOutputStream
    //   149: dup
    //   150: sipush 4096
    //   153: invokespecial 302	java/io/ByteArrayOutputStream:<init>	(I)V
    //   156: astore 7
    //   158: ldc_w 304
    //   161: aload_1
    //   162: invokevirtual 307	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   165: ifne +79 -> 244
    //   168: ldc_w 309
    //   171: aload_1
    //   172: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   175: ifne +69 -> 244
    //   178: ldc_w 314
    //   181: aload_1
    //   182: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   185: ifeq +6 -> 191
    //   188: goto +56 -> 244
    //   191: new 34	java/lang/StringBuilder
    //   194: dup
    //   195: ldc_w 316
    //   198: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   201: astore_1
    //   202: bipush 80
    //   204: istore 5
    //   206: iload 5
    //   208: istore_0
    //   209: iload_2
    //   210: sipush 256
    //   213: if_icmpgt +16 -> 229
    //   216: iload 5
    //   218: istore_0
    //   219: iload_3
    //   220: sipush 256
    //   223: if_icmpgt +6 -> 229
    //   226: bipush 100
    //   228: istore_0
    //   229: aload 8
    //   231: getstatic 323	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   234: iload_0
    //   235: aload 7
    //   237: invokevirtual 327	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   240: pop
    //   241: goto +27 -> 268
    //   244: new 34	java/lang/StringBuilder
    //   247: dup
    //   248: ldc_w 329
    //   251: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: astore_1
    //   255: aload 8
    //   257: getstatic 332	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   260: bipush 100
    //   262: aload 7
    //   264: invokevirtual 327	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   267: pop
    //   268: aload_1
    //   269: aload 7
    //   271: invokevirtual 336	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   274: iconst_2
    //   275: invokestatic 340	com/tencent/qg/sdk/base64/Base64:encodeToString	([BI)Ljava/lang/String;
    //   278: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_1
    //   283: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: astore_1
    //   287: new 34	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   294: astore 6
    //   296: aload 6
    //   298: ldc_w 342
    //   301: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 6
    //   307: aload_1
    //   308: invokevirtual 345	java/lang/String:length	()I
    //   311: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc_w 287
    //   318: aload 6
    //   320: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 138	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   326: pop
    //   327: aload 7
    //   329: invokevirtual 346	java/io/ByteArrayOutputStream:close	()V
    //   332: aload_1
    //   333: areturn
    //   334: astore 6
    //   336: aload 6
    //   338: invokevirtual 347	java/lang/Exception:printStackTrace	()V
    //   341: aload_1
    //   342: areturn
    //   343: astore_1
    //   344: aload 7
    //   346: astore 6
    //   348: goto +52 -> 400
    //   351: astore 6
    //   353: aload 7
    //   355: astore_1
    //   356: aload 6
    //   358: astore 7
    //   360: goto +12 -> 372
    //   363: astore_1
    //   364: goto +36 -> 400
    //   367: astore 7
    //   369: aload 9
    //   371: astore_1
    //   372: aload_1
    //   373: astore 6
    //   375: aload 7
    //   377: invokevirtual 348	java/lang/Throwable:printStackTrace	()V
    //   380: aload_1
    //   381: ifnull +15 -> 396
    //   384: aload_1
    //   385: invokevirtual 346	java/io/ByteArrayOutputStream:close	()V
    //   388: goto +8 -> 396
    //   391: astore_1
    //   392: aload_1
    //   393: invokevirtual 347	java/lang/Exception:printStackTrace	()V
    //   396: ldc_w 350
    //   399: areturn
    //   400: aload 6
    //   402: ifnull +18 -> 420
    //   405: aload 6
    //   407: invokevirtual 346	java/io/ByteArrayOutputStream:close	()V
    //   410: goto +10 -> 420
    //   413: astore 6
    //   415: aload 6
    //   417: invokevirtual 347	java/lang/Exception:printStackTrace	()V
    //   420: aload_1
    //   421: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	paramInt1	int
    //   0	422	1	paramString	String
    //   0	422	2	paramInt2	int
    //   0	422	3	paramInt3	int
    //   0	422	4	paramBoolean	boolean
    //   204	13	5	i	int
    //   7	312	6	localObject1	Object
    //   334	3	6	localException1	java.lang.Exception
    //   346	1	6	localObject2	Object
    //   351	6	6	localThrowable1	java.lang.Throwable
    //   373	33	6	str	String
    //   413	3	6	localException2	java.lang.Exception
    //   106	253	7	localObject3	Object
    //   367	9	7	localThrowable2	java.lang.Throwable
    //   124	132	8	localBitmap	Bitmap
    //   103	267	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   327	332	334	java/lang/Exception
    //   158	188	343	finally
    //   191	202	343	finally
    //   229	241	343	finally
    //   244	268	343	finally
    //   268	327	343	finally
    //   158	188	351	java/lang/Throwable
    //   191	202	351	java/lang/Throwable
    //   229	241	351	java/lang/Throwable
    //   244	268	351	java/lang/Throwable
    //   268	327	351	java/lang/Throwable
    //   116	126	363	finally
    //   133	142	363	finally
    //   146	158	363	finally
    //   375	380	363	finally
    //   116	126	367	java/lang/Throwable
    //   133	142	367	java/lang/Throwable
    //   146	158	367	java/lang/Throwable
    //   384	388	391	java/lang/Exception
    //   405	410	413	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.QGBitmapLoader
 * JD-Core Version:    0.7.0.1
 */