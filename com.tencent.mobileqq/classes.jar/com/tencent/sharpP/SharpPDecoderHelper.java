package com.tencent.sharpP;

import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class SharpPDecoderHelper
{
  public static final String TAG = "SharpPDecoderHelper";
  SharpPPathDecoder mDecoder;
  
  public SharpPDecoderHelper(String paramString)
  {
    this.mDecoder = new SharpPPathDecoder(paramString);
  }
  
  public void closeDecoder()
  {
    this.mDecoder.closeDecoder();
  }
  
  public void closeDecoder(long paramLong)
  {
    this.mDecoder.closeDecoder(paramLong);
  }
  
  public long createDecoder()
  {
    try
    {
      long l = this.mDecoder.createDecoder();
      return l;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ILog localILog = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createDecoder catch a UnsatisfiedLinkError:");
      localStringBuilder.append(Log.getStackTraceString(localUnsatisfiedLinkError));
      localILog.e("SharpPDecoderHelper", new Object[] { localStringBuilder.toString() });
    }
    return -1L;
  }
  
  /* Error */
  public android.graphics.Bitmap decodeSharpP(int paramInt1, int paramInt2, android.graphics.Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iload_1
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   10: iload_1
    //   11: iload_2
    //   12: aload_3
    //   13: invokevirtual 73	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   16: astore 7
    //   18: aload 7
    //   20: astore 6
    //   22: aload 7
    //   24: ifnonnull +102 -> 126
    //   27: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   30: ldc 8
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc 75
    //   40: aastore
    //   41: invokeinterface 65 3 0
    //   46: aload_0
    //   47: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   50: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   53: aload_0
    //   54: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   57: iload_1
    //   58: iload_2
    //   59: aload_3
    //   60: invokevirtual 73	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   63: astore 6
    //   65: goto +61 -> 126
    //   68: astore_3
    //   69: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   72: astore 6
    //   74: new 42	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   81: astore 8
    //   83: aload 8
    //   85: ldc 77
    //   87: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 8
    //   93: aload_3
    //   94: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   97: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 6
    //   103: ldc 8
    //   105: iconst_1
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload 8
    //   113: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: aastore
    //   117: invokeinterface 65 3 0
    //   122: aload 7
    //   124: astore 6
    //   126: aload_0
    //   127: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   130: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   133: aload 6
    //   135: areturn
    //   136: astore 6
    //   138: goto +215 -> 353
    //   141: astore 7
    //   143: iload_1
    //   144: istore 4
    //   146: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   149: astore 8
    //   151: iload_1
    //   152: istore 4
    //   154: new 42	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   161: astore 9
    //   163: iload_1
    //   164: istore 4
    //   166: aload 9
    //   168: ldc 79
    //   170: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: iload_1
    //   175: istore 4
    //   177: aload 9
    //   179: aload 7
    //   181: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   184: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: iload_1
    //   189: istore 4
    //   191: aload 8
    //   193: ldc 8
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload 9
    //   203: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: aastore
    //   207: invokeinterface 65 3 0
    //   212: goto -86 -> 126
    //   215: iload_1
    //   216: istore 4
    //   218: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   221: ldc 8
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: ldc 81
    //   231: aastore
    //   232: invokeinterface 65 3 0
    //   237: iload_1
    //   238: istore 4
    //   240: iload_1
    //   241: iconst_2
    //   242: idiv
    //   243: istore_1
    //   244: iload_1
    //   245: istore 4
    //   247: iload_2
    //   248: iconst_2
    //   249: idiv
    //   250: istore 5
    //   252: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   255: ldc 8
    //   257: iconst_1
    //   258: anewarray 4	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: ldc 75
    //   265: aastore
    //   266: invokeinterface 65 3 0
    //   271: aload_0
    //   272: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   275: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   278: aload_0
    //   279: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   282: iload_1
    //   283: iload 5
    //   285: aload_3
    //   286: invokevirtual 73	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   289: astore_3
    //   290: aload_3
    //   291: astore 6
    //   293: goto -167 -> 126
    //   296: astore_3
    //   297: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   300: astore 7
    //   302: new 42	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   309: astore 8
    //   311: aload 8
    //   313: ldc 77
    //   315: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 8
    //   321: aload_3
    //   322: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   325: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 7
    //   331: ldc 8
    //   333: iconst_1
    //   334: anewarray 4	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: aload 8
    //   341: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: aastore
    //   345: invokeinterface 65 3 0
    //   350: goto -224 -> 126
    //   353: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   356: ldc 8
    //   358: iconst_1
    //   359: anewarray 4	java/lang/Object
    //   362: dup
    //   363: iconst_0
    //   364: ldc 75
    //   366: aastore
    //   367: invokeinterface 65 3 0
    //   372: aload_0
    //   373: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   376: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   379: aload_0
    //   380: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   383: iload 4
    //   385: iload_2
    //   386: aload_3
    //   387: invokevirtual 73	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   390: pop
    //   391: goto +57 -> 448
    //   394: astore_3
    //   395: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   398: astore 7
    //   400: new 42	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   407: astore 8
    //   409: aload 8
    //   411: ldc 77
    //   413: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload 8
    //   419: aload_3
    //   420: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   423: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 7
    //   429: ldc 8
    //   431: iconst_1
    //   432: anewarray 4	java/lang/Object
    //   435: dup
    //   436: iconst_0
    //   437: aload 8
    //   439: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: aastore
    //   443: invokeinterface 65 3 0
    //   448: aload_0
    //   449: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   452: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   455: goto +6 -> 461
    //   458: aload 6
    //   460: athrow
    //   461: goto -3 -> 458
    //   464: astore 7
    //   466: goto -251 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	this	SharpPDecoderHelper
    //   0	469	1	paramInt1	int
    //   0	469	2	paramInt2	int
    //   0	469	3	paramConfig	android.graphics.Bitmap.Config
    //   4	380	4	i	int
    //   250	34	5	j	int
    //   1	133	6	localObject1	Object
    //   136	1	6	localObject2	Object
    //   291	168	6	localConfig	android.graphics.Bitmap.Config
    //   16	107	7	localBitmap	android.graphics.Bitmap
    //   141	39	7	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   300	128	7	localILog	ILog
    //   464	1	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   81	357	8	localObject3	Object
    //   161	41	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	65	68	java/lang/OutOfMemoryError
    //   6	18	136	finally
    //   146	151	136	finally
    //   154	163	136	finally
    //   166	174	136	finally
    //   177	188	136	finally
    //   191	212	136	finally
    //   218	237	136	finally
    //   240	244	136	finally
    //   247	252	136	finally
    //   6	18	141	java/lang/UnsatisfiedLinkError
    //   271	290	296	java/lang/OutOfMemoryError
    //   372	391	394	java/lang/OutOfMemoryError
    //   6	18	464	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public android.graphics.Bitmap decodeSharpP2GifFrame(long paramLong, int paramInt1, int paramInt2, int paramInt3, SharpPDecoderWrapper.WriteableInteger paramWriteableInteger, android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   4: lload_1
    //   5: iload_3
    //   6: iload 4
    //   8: iload 5
    //   10: aload 6
    //   12: aload 7
    //   14: invokevirtual 85	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP2GifFrame	(JIIILcom/tencent/sharpP/SharpPDecoderWrapper$WriteableInteger;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   17: astore 10
    //   19: aload 10
    //   21: astore 7
    //   23: aload 10
    //   25: ifnonnull +29 -> 54
    //   28: aload_0
    //   29: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   32: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   35: aload_0
    //   36: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   39: lload_1
    //   40: iload_3
    //   41: iload 4
    //   43: iload 5
    //   45: aload 6
    //   47: aload 10
    //   49: invokevirtual 85	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP2GifFrame	(JIIILcom/tencent/sharpP/SharpPDecoderWrapper$WriteableInteger;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   52: astore 7
    //   54: aload_0
    //   55: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   58: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   61: aload 7
    //   63: areturn
    //   64: astore 10
    //   66: goto +203 -> 269
    //   69: astore 10
    //   71: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   74: astore 11
    //   76: new 42	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   83: astore 12
    //   85: aload 12
    //   87: ldc 87
    //   89: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 12
    //   95: aload 10
    //   97: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   100: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 11
    //   106: ldc 8
    //   108: iconst_1
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload 12
    //   116: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: aastore
    //   120: invokeinterface 65 3 0
    //   125: aload 7
    //   127: ifnonnull +36 -> 163
    //   130: aload_0
    //   131: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   134: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   137: aload_0
    //   138: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   141: astore 10
    //   143: aload 10
    //   145: lload_1
    //   146: iload_3
    //   147: iload 4
    //   149: iload 5
    //   151: aload 6
    //   153: aload 7
    //   155: invokevirtual 85	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP2GifFrame	(JIIILcom/tencent/sharpP/SharpPDecoderWrapper$WriteableInteger;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   158: astore 7
    //   160: goto -106 -> 54
    //   163: goto -109 -> 54
    //   166: astore 10
    //   168: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   171: astore 11
    //   173: new 42	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   180: astore 12
    //   182: aload 12
    //   184: ldc 89
    //   186: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 12
    //   192: aload 10
    //   194: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   197: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 11
    //   203: ldc 8
    //   205: iconst_1
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload 12
    //   213: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: aastore
    //   217: invokeinterface 65 3 0
    //   222: iload 4
    //   224: iconst_2
    //   225: idiv
    //   226: istore 8
    //   228: iload 5
    //   230: iconst_2
    //   231: idiv
    //   232: istore 9
    //   234: aload 7
    //   236: ifnonnull -73 -> 163
    //   239: aload_0
    //   240: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   243: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   246: aload_0
    //   247: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   250: astore 10
    //   252: iload 8
    //   254: istore 4
    //   256: iload 9
    //   258: istore 5
    //   260: goto -117 -> 143
    //   263: astore 10
    //   265: iload 8
    //   267: istore 4
    //   269: aload 7
    //   271: ifnonnull +28 -> 299
    //   274: aload_0
    //   275: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   278: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   281: aload_0
    //   282: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   285: lload_1
    //   286: iload_3
    //   287: iload 4
    //   289: iload 5
    //   291: aload 6
    //   293: aload 7
    //   295: invokevirtual 85	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP2GifFrame	(JIIILcom/tencent/sharpP/SharpPDecoderWrapper$WriteableInteger;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   298: pop
    //   299: aload_0
    //   300: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   303: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   306: goto +6 -> 312
    //   309: aload 10
    //   311: athrow
    //   312: goto -3 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	SharpPDecoderHelper
    //   0	315	1	paramLong	long
    //   0	315	3	paramInt1	int
    //   0	315	4	paramInt2	int
    //   0	315	5	paramInt3	int
    //   0	315	6	paramWriteableInteger	SharpPDecoderWrapper.WriteableInteger
    //   0	315	7	paramBitmap	android.graphics.Bitmap
    //   226	40	8	i	int
    //   232	25	9	j	int
    //   17	31	10	localBitmap	android.graphics.Bitmap
    //   64	1	10	localObject1	Object
    //   69	27	10	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   141	3	10	localSharpPPathDecoder1	SharpPPathDecoder
    //   166	27	10	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   250	1	10	localSharpPPathDecoder2	SharpPPathDecoder
    //   263	47	10	localObject2	Object
    //   74	128	11	localILog	ILog
    //   83	129	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	19	64	finally
    //   71	125	64	finally
    //   168	228	64	finally
    //   0	19	69	java/lang/UnsatisfiedLinkError
    //   0	19	166	java/lang/OutOfMemoryError
    //   228	234	263	finally
  }
  
  /* Error */
  public android.graphics.Bitmap decodeSharpP2JPG(int paramInt1, int paramInt2, android.graphics.Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iload_1
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   10: iload_1
    //   11: iload_2
    //   12: aload_3
    //   13: invokevirtual 92	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP2JPG	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   16: astore 7
    //   18: aload 7
    //   20: astore 6
    //   22: aload 7
    //   24: ifnonnull +102 -> 126
    //   27: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   30: ldc 8
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc 94
    //   40: aastore
    //   41: invokeinterface 65 3 0
    //   46: aload_0
    //   47: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   50: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   53: aload_0
    //   54: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   57: iload_1
    //   58: iload_2
    //   59: aload_3
    //   60: invokevirtual 92	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP2JPG	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   63: astore 6
    //   65: goto +61 -> 126
    //   68: astore_3
    //   69: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   72: astore 6
    //   74: new 42	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   81: astore 8
    //   83: aload 8
    //   85: ldc 96
    //   87: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 8
    //   93: aload_3
    //   94: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   97: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 6
    //   103: ldc 8
    //   105: iconst_1
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload 8
    //   113: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: aastore
    //   117: invokeinterface 65 3 0
    //   122: aload 7
    //   124: astore 6
    //   126: aload_0
    //   127: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   130: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   133: aload 6
    //   135: areturn
    //   136: astore 6
    //   138: goto +264 -> 402
    //   141: astore 7
    //   143: iload_1
    //   144: istore 4
    //   146: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   149: astore 8
    //   151: iload_1
    //   152: istore 4
    //   154: new 42	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   161: astore 9
    //   163: iload_1
    //   164: istore 4
    //   166: aload 9
    //   168: ldc 98
    //   170: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: iload_1
    //   175: istore 4
    //   177: aload 9
    //   179: aload 7
    //   181: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   184: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: iload_1
    //   189: istore 4
    //   191: aload 8
    //   193: ldc 8
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload 9
    //   203: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: aastore
    //   207: invokeinterface 65 3 0
    //   212: goto -86 -> 126
    //   215: astore 7
    //   217: iload_1
    //   218: istore 4
    //   220: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   223: astore 8
    //   225: iload_1
    //   226: istore 4
    //   228: new 42	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   235: astore 9
    //   237: iload_1
    //   238: istore 4
    //   240: aload 9
    //   242: ldc 100
    //   244: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: iload_1
    //   249: istore 4
    //   251: aload 9
    //   253: aload 7
    //   255: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   258: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: iload_1
    //   263: istore 4
    //   265: aload 8
    //   267: ldc 8
    //   269: iconst_1
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload 9
    //   277: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: aastore
    //   281: invokeinterface 65 3 0
    //   286: iload_1
    //   287: istore 4
    //   289: iload_1
    //   290: iconst_2
    //   291: idiv
    //   292: istore_1
    //   293: iload_1
    //   294: istore 4
    //   296: iload_2
    //   297: iconst_2
    //   298: idiv
    //   299: istore 5
    //   301: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   304: ldc 8
    //   306: iconst_1
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: ldc 94
    //   314: aastore
    //   315: invokeinterface 65 3 0
    //   320: aload_0
    //   321: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   324: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   327: aload_0
    //   328: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   331: iload_1
    //   332: iload 5
    //   334: aload_3
    //   335: invokevirtual 92	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP2JPG	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   338: astore_3
    //   339: aload_3
    //   340: astore 6
    //   342: goto -216 -> 126
    //   345: astore_3
    //   346: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   349: astore 7
    //   351: new 42	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   358: astore 8
    //   360: aload 8
    //   362: ldc 96
    //   364: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 8
    //   370: aload_3
    //   371: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   374: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 7
    //   380: ldc 8
    //   382: iconst_1
    //   383: anewarray 4	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload 8
    //   390: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: aastore
    //   394: invokeinterface 65 3 0
    //   399: goto -273 -> 126
    //   402: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   405: ldc 8
    //   407: iconst_1
    //   408: anewarray 4	java/lang/Object
    //   411: dup
    //   412: iconst_0
    //   413: ldc 94
    //   415: aastore
    //   416: invokeinterface 65 3 0
    //   421: aload_0
    //   422: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   425: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   428: aload_0
    //   429: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   432: iload 4
    //   434: iload_2
    //   435: aload_3
    //   436: invokevirtual 92	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP2JPG	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   439: pop
    //   440: goto +57 -> 497
    //   443: astore_3
    //   444: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   447: astore 7
    //   449: new 42	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   456: astore 8
    //   458: aload 8
    //   460: ldc 96
    //   462: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 8
    //   468: aload_3
    //   469: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   472: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 7
    //   478: ldc 8
    //   480: iconst_1
    //   481: anewarray 4	java/lang/Object
    //   484: dup
    //   485: iconst_0
    //   486: aload 8
    //   488: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: aastore
    //   492: invokeinterface 65 3 0
    //   497: aload_0
    //   498: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   501: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   504: goto +6 -> 510
    //   507: aload 6
    //   509: athrow
    //   510: goto -3 -> 507
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	this	SharpPDecoderHelper
    //   0	513	1	paramInt1	int
    //   0	513	2	paramInt2	int
    //   0	513	3	paramConfig	android.graphics.Bitmap.Config
    //   4	429	4	i	int
    //   299	34	5	j	int
    //   1	133	6	localObject1	Object
    //   136	1	6	localObject2	Object
    //   340	168	6	localConfig	android.graphics.Bitmap.Config
    //   16	107	7	localBitmap	android.graphics.Bitmap
    //   141	39	7	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   215	39	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   349	128	7	localILog	ILog
    //   81	406	8	localObject3	Object
    //   161	115	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	65	68	java/lang/OutOfMemoryError
    //   6	18	136	finally
    //   146	151	136	finally
    //   154	163	136	finally
    //   166	174	136	finally
    //   177	188	136	finally
    //   191	212	136	finally
    //   220	225	136	finally
    //   228	237	136	finally
    //   240	248	136	finally
    //   251	262	136	finally
    //   265	286	136	finally
    //   289	293	136	finally
    //   296	301	136	finally
    //   6	18	141	java/lang/UnsatisfiedLinkError
    //   6	18	215	java/lang/OutOfMemoryError
    //   320	339	345	java/lang/OutOfMemoryError
    //   421	440	443	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public android.graphics.Bitmap decodeSharpP2PNG(int paramInt1, int paramInt2, android.graphics.Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iload_1
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   10: iload_1
    //   11: iload_2
    //   12: aload_3
    //   13: invokevirtual 103	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP2PNG	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   16: astore 7
    //   18: aload 7
    //   20: astore 6
    //   22: aload 7
    //   24: ifnonnull +102 -> 126
    //   27: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   30: ldc 8
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc 105
    //   40: aastore
    //   41: invokeinterface 65 3 0
    //   46: aload_0
    //   47: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   50: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   53: aload_0
    //   54: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   57: iload_1
    //   58: iload_2
    //   59: aload_3
    //   60: invokevirtual 103	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP2PNG	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   63: astore 6
    //   65: goto +61 -> 126
    //   68: astore_3
    //   69: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   72: astore 6
    //   74: new 42	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   81: astore 8
    //   83: aload 8
    //   85: ldc 96
    //   87: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 8
    //   93: aload_3
    //   94: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   97: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 6
    //   103: ldc 8
    //   105: iconst_1
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload 8
    //   113: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: aastore
    //   117: invokeinterface 65 3 0
    //   122: aload 7
    //   124: astore 6
    //   126: aload_0
    //   127: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   130: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   133: aload 6
    //   135: areturn
    //   136: astore 6
    //   138: goto +264 -> 402
    //   141: astore 7
    //   143: iload_1
    //   144: istore 4
    //   146: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   149: astore 8
    //   151: iload_1
    //   152: istore 4
    //   154: new 42	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   161: astore 9
    //   163: iload_1
    //   164: istore 4
    //   166: aload 9
    //   168: ldc 107
    //   170: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: iload_1
    //   175: istore 4
    //   177: aload 9
    //   179: aload 7
    //   181: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   184: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: iload_1
    //   189: istore 4
    //   191: aload 8
    //   193: ldc 8
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload 9
    //   203: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: aastore
    //   207: invokeinterface 65 3 0
    //   212: goto -86 -> 126
    //   215: astore 7
    //   217: iload_1
    //   218: istore 4
    //   220: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   223: astore 8
    //   225: iload_1
    //   226: istore 4
    //   228: new 42	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   235: astore 9
    //   237: iload_1
    //   238: istore 4
    //   240: aload 9
    //   242: ldc 109
    //   244: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: iload_1
    //   249: istore 4
    //   251: aload 9
    //   253: aload 7
    //   255: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   258: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: iload_1
    //   263: istore 4
    //   265: aload 8
    //   267: ldc 8
    //   269: iconst_1
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload 9
    //   277: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: aastore
    //   281: invokeinterface 65 3 0
    //   286: iload_1
    //   287: istore 4
    //   289: iload_1
    //   290: iconst_2
    //   291: idiv
    //   292: istore_1
    //   293: iload_1
    //   294: istore 4
    //   296: iload_2
    //   297: iconst_2
    //   298: idiv
    //   299: istore 5
    //   301: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   304: ldc 8
    //   306: iconst_1
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: ldc 105
    //   314: aastore
    //   315: invokeinterface 65 3 0
    //   320: aload_0
    //   321: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   324: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   327: aload_0
    //   328: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   331: iload_1
    //   332: iload 5
    //   334: aload_3
    //   335: invokevirtual 103	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP2PNG	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   338: astore_3
    //   339: aload_3
    //   340: astore 6
    //   342: goto -216 -> 126
    //   345: astore_3
    //   346: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   349: astore 7
    //   351: new 42	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   358: astore 8
    //   360: aload 8
    //   362: ldc 96
    //   364: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 8
    //   370: aload_3
    //   371: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   374: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 7
    //   380: ldc 8
    //   382: iconst_1
    //   383: anewarray 4	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload 8
    //   390: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: aastore
    //   394: invokeinterface 65 3 0
    //   399: goto -273 -> 126
    //   402: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   405: ldc 8
    //   407: iconst_1
    //   408: anewarray 4	java/lang/Object
    //   411: dup
    //   412: iconst_0
    //   413: ldc 105
    //   415: aastore
    //   416: invokeinterface 65 3 0
    //   421: aload_0
    //   422: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   425: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   428: aload_0
    //   429: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   432: iload 4
    //   434: iload_2
    //   435: aload_3
    //   436: invokevirtual 103	com/tencent/sharpP/SharpPPathDecoder:decodeSharpP2PNG	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   439: pop
    //   440: goto +57 -> 497
    //   443: astore_3
    //   444: invokestatic 40	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   447: astore 7
    //   449: new 42	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   456: astore 8
    //   458: aload 8
    //   460: ldc 96
    //   462: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 8
    //   468: aload_3
    //   469: invokestatic 55	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   472: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 7
    //   478: ldc 8
    //   480: iconst_1
    //   481: anewarray 4	java/lang/Object
    //   484: dup
    //   485: iconst_0
    //   486: aload 8
    //   488: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: aastore
    //   492: invokeinterface 65 3 0
    //   497: aload_0
    //   498: getfield 21	com/tencent/sharpP/SharpPDecoderHelper:mDecoder	Lcom/tencent/sharpP/SharpPPathDecoder;
    //   501: invokevirtual 25	com/tencent/sharpP/SharpPPathDecoder:closeDecoder	()V
    //   504: goto +6 -> 510
    //   507: aload 6
    //   509: athrow
    //   510: goto -3 -> 507
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	this	SharpPDecoderHelper
    //   0	513	1	paramInt1	int
    //   0	513	2	paramInt2	int
    //   0	513	3	paramConfig	android.graphics.Bitmap.Config
    //   4	429	4	i	int
    //   299	34	5	j	int
    //   1	133	6	localObject1	Object
    //   136	1	6	localObject2	Object
    //   340	168	6	localConfig	android.graphics.Bitmap.Config
    //   16	107	7	localBitmap	android.graphics.Bitmap
    //   141	39	7	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   215	39	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   349	128	7	localILog	ILog
    //   81	406	8	localObject3	Object
    //   161	115	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	65	68	java/lang/OutOfMemoryError
    //   6	18	136	finally
    //   146	151	136	finally
    //   154	163	136	finally
    //   166	174	136	finally
    //   177	188	136	finally
    //   191	212	136	finally
    //   220	225	136	finally
    //   228	237	136	finally
    //   240	248	136	finally
    //   251	262	136	finally
    //   265	286	136	finally
    //   289	293	136	finally
    //   296	301	136	finally
    //   6	18	141	java/lang/UnsatisfiedLinkError
    //   6	18	215	java/lang/OutOfMemoryError
    //   320	339	345	java/lang/OutOfMemoryError
    //   421	440	443	java/lang/OutOfMemoryError
  }
  
  public int getAllocationByteCount()
  {
    return this.mDecoder.getAllocationByteCount();
  }
  
  public SharpPDecoderWrapper.SharpPFeatureWrapper getFeatureInfo()
  {
    return this.mDecoder.getFeatureInfo();
  }
  
  public String getMimeType()
  {
    return this.mDecoder.getMimeType();
  }
  
  public int parseHeader()
  {
    try
    {
      int i = this.mDecoder.parseHeader();
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ILog localILog = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseHeader catch a UnsatisfiedLinkError:");
      localStringBuilder.append(Log.getStackTraceString(localUnsatisfiedLinkError));
      localILog.e("SharpPDecoderHelper", new Object[] { localStringBuilder.toString() });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sharpP.SharpPDecoderHelper
 * JD-Core Version:    0.7.0.1
 */