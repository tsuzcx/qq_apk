public class nid
{
  private static String a = "QrCodeUtil";
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3, android.graphics.Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_0
    //   7: invokestatic 24	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +7 -> 17
    //   13: iload_1
    //   14: ifge +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: new 26	java/util/HashMap
    //   22: dup
    //   23: invokespecial 29	java/util/HashMap:<init>	()V
    //   26: astore 11
    //   28: aload 11
    //   30: getstatic 35	com/google/zxing/EncodeHintType:CHARACTER_SET	Lcom/google/zxing/EncodeHintType;
    //   33: ldc 37
    //   35: invokeinterface 43 3 0
    //   40: pop
    //   41: aload 11
    //   43: getstatic 46	com/google/zxing/EncodeHintType:MARGIN	Lcom/google/zxing/EncodeHintType;
    //   46: iconst_0
    //   47: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: invokeinterface 43 3 0
    //   55: pop
    //   56: aload 11
    //   58: getstatic 55	com/google/zxing/EncodeHintType:ERROR_CORRECTION	Lcom/google/zxing/EncodeHintType;
    //   61: getstatic 61	com/google/zxing/qrcode/decoder/ErrorCorrectionLevel:L	Lcom/google/zxing/qrcode/decoder/ErrorCorrectionLevel;
    //   64: invokeinterface 43 3 0
    //   69: pop
    //   70: new 63	gx
    //   73: dup
    //   74: invokespecial 64	gx:<init>	()V
    //   77: aload_0
    //   78: iconst_0
    //   79: iconst_0
    //   80: aload 11
    //   82: invokevirtual 67	gx:a	(Ljava/lang/String;IILjava/util/Map;)Lgt;
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull -70 -> 17
    //   90: aload_0
    //   91: invokevirtual 72	gt:a	()I
    //   94: istore 7
    //   96: aload_0
    //   97: invokevirtual 75	gt:b	()I
    //   100: istore 8
    //   102: iload 7
    //   104: iload 8
    //   106: imul
    //   107: newarray int
    //   109: astore 11
    //   111: iconst_0
    //   112: istore 5
    //   114: goto +209 -> 323
    //   117: iload 6
    //   119: iload 7
    //   121: if_icmpge +78 -> 199
    //   124: aload_0
    //   125: iload 6
    //   127: iload 5
    //   129: invokevirtual 78	gt:a	(II)Z
    //   132: ifeq +18 -> 150
    //   135: aload 11
    //   137: iload 5
    //   139: iload 7
    //   141: imul
    //   142: iload 6
    //   144: iadd
    //   145: iload_2
    //   146: iastore
    //   147: goto +189 -> 336
    //   150: aload 11
    //   152: iload 5
    //   154: iload 7
    //   156: imul
    //   157: iload 6
    //   159: iadd
    //   160: iload_3
    //   161: iastore
    //   162: goto +174 -> 336
    //   165: astore 4
    //   167: aload 9
    //   169: astore_0
    //   170: getstatic 12	nid:a	Ljava/lang/String;
    //   173: iconst_1
    //   174: new 80	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   181: ldc 83
    //   183: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 4
    //   188: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_0
    //   198: areturn
    //   199: iload 5
    //   201: iconst_1
    //   202: iadd
    //   203: istore 5
    //   205: goto +118 -> 323
    //   208: aload 11
    //   210: iload 7
    //   212: iload 8
    //   214: aload 4
    //   216: invokestatic 106	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   219: astore_0
    //   220: aload_0
    //   221: ifnull +100 -> 321
    //   224: iload_1
    //   225: iload_1
    //   226: getstatic 112	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   229: invokestatic 115	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   232: astore 4
    //   234: new 117	android/graphics/Canvas
    //   237: dup
    //   238: aload 4
    //   240: invokespecial 120	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   243: astore 9
    //   245: aload 9
    //   247: aload_0
    //   248: new 122	android/graphics/Rect
    //   251: dup
    //   252: iconst_0
    //   253: iconst_0
    //   254: iload 7
    //   256: iload 8
    //   258: invokespecial 125	android/graphics/Rect:<init>	(IIII)V
    //   261: new 122	android/graphics/Rect
    //   264: dup
    //   265: iconst_0
    //   266: iconst_0
    //   267: iload_1
    //   268: iload_1
    //   269: invokespecial 125	android/graphics/Rect:<init>	(IIII)V
    //   272: aconst_null
    //   273: invokevirtual 129	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   276: aload 9
    //   278: new 131	android/graphics/PaintFlagsDrawFilter
    //   281: dup
    //   282: iconst_0
    //   283: iconst_3
    //   284: invokespecial 134	android/graphics/PaintFlagsDrawFilter:<init>	(II)V
    //   287: invokevirtual 138	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   290: aload 4
    //   292: areturn
    //   293: astore 4
    //   295: goto -125 -> 170
    //   298: astore 4
    //   300: aload 10
    //   302: astore_0
    //   303: getstatic 12	nid:a	Ljava/lang/String;
    //   306: iconst_1
    //   307: ldc 140
    //   309: aload 4
    //   311: invokestatic 143	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   314: aload_0
    //   315: areturn
    //   316: astore 4
    //   318: goto -15 -> 303
    //   321: aload_0
    //   322: areturn
    //   323: iload 5
    //   325: iload 8
    //   327: if_icmpge -119 -> 208
    //   330: iconst_0
    //   331: istore 6
    //   333: goto -216 -> 117
    //   336: iload 6
    //   338: iconst_1
    //   339: iadd
    //   340: istore 6
    //   342: goto -225 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramString	String
    //   0	345	1	paramInt1	int
    //   0	345	2	paramInt2	int
    //   0	345	3	paramInt3	int
    //   0	345	4	paramConfig	android.graphics.Bitmap.Config
    //   112	216	5	i	int
    //   117	224	6	j	int
    //   94	161	7	k	int
    //   100	228	8	m	int
    //   4	273	9	localCanvas	android.graphics.Canvas
    //   1	300	10	localObject1	Object
    //   26	183	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   70	86	165	java/lang/OutOfMemoryError
    //   90	111	165	java/lang/OutOfMemoryError
    //   124	135	165	java/lang/OutOfMemoryError
    //   208	220	165	java/lang/OutOfMemoryError
    //   224	290	293	java/lang/OutOfMemoryError
    //   70	86	298	com/google/zxing/WriterException
    //   90	111	298	com/google/zxing/WriterException
    //   124	135	298	com/google/zxing/WriterException
    //   208	220	298	com/google/zxing/WriterException
    //   224	290	316	com/google/zxing/WriterException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nid
 * JD-Core Version:    0.7.0.1
 */