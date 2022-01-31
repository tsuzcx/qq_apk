import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public class nap
{
  protected static int a;
  protected static String a;
  protected static int b;
  protected static String b;
  
  static
  {
    jdField_a_of_type_Int = 7;
    jdField_b_of_type_Int = 10;
    jdField_b_of_type_JavaLangString = "ImageUtil";
  }
  
  public static final int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = b(paramOptions, paramInt1, paramInt2);
    if (i <= 8)
    {
      paramInt1 = 1;
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= i) {
          break;
        }
        paramInt1 <<= 1;
      }
    }
    paramInt2 = (i + 7) / 8 * 8;
    return paramInt2;
  }
  
  public static final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject1;
    if (paramBitmap == null)
    {
      localObject1 = null;
      return localObject1;
    }
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    if ((j <= 0) || (k <= 0)) {
      return null;
    }
    int i;
    if (j > k) {
      i = j;
    }
    for (;;)
    {
      localObject1 = paramBitmap;
      if (i <= paramInt) {
        break;
      }
      float f = paramInt / i;
      localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(f, f);
      try
      {
        localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, j, k, (Matrix)localObject1, true);
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          paramBitmap.recycle();
        }
        return localObject1;
        i = k;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_b_of_type_JavaLangString, 2, "scaleBitmap, exp=", localThrowable);
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  /* Error */
  public static final Bitmap a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +7 -> 11
    //   7: aconst_null
    //   8: astore_0
    //   9: aload_0
    //   10: areturn
    //   11: new 78	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 79	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore 6
    //   20: aload 6
    //   22: iconst_1
    //   23: putfield 83	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   26: aload_0
    //   27: aload 6
    //   29: invokestatic 89	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   32: pop
    //   33: aload 6
    //   35: getfield 92	android/graphics/BitmapFactory$Options:outWidth	I
    //   38: istore_2
    //   39: aload 6
    //   41: getfield 95	android/graphics/BitmapFactory$Options:outHeight	I
    //   44: istore_3
    //   45: aload 6
    //   47: getfield 98	android/graphics/BitmapFactory$Options:mCancel	Z
    //   50: ifne +21 -> 71
    //   53: aload 6
    //   55: getfield 92	android/graphics/BitmapFactory$Options:outWidth	I
    //   58: iconst_m1
    //   59: if_icmpeq +12 -> 71
    //   62: aload 6
    //   64: getfield 95	android/graphics/BitmapFactory$Options:outHeight	I
    //   67: iconst_m1
    //   68: if_icmpne +5 -> 73
    //   71: aconst_null
    //   72: areturn
    //   73: iload_2
    //   74: iload_3
    //   75: if_icmple +108 -> 183
    //   78: aload 6
    //   80: getstatic 104	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   83: putfield 107	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   86: iload_2
    //   87: iload_1
    //   88: if_icmple +17 -> 105
    //   91: aload 6
    //   93: aload 6
    //   95: iconst_m1
    //   96: iload_1
    //   97: iload_1
    //   98: imul
    //   99: invokestatic 109	nap:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   102: putfield 112	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   105: aload 6
    //   107: iconst_0
    //   108: putfield 83	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   111: new 114	java/io/BufferedInputStream
    //   114: dup
    //   115: new 116	java/io/FileInputStream
    //   118: dup
    //   119: aload_0
    //   120: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   123: invokespecial 122	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   126: astore_0
    //   127: aload_0
    //   128: astore 4
    //   130: aload_0
    //   131: aconst_null
    //   132: aload 6
    //   134: invokestatic 126	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   137: astore 5
    //   139: aload 5
    //   141: astore 4
    //   143: aload_0
    //   144: ifnull +7 -> 151
    //   147: aload_0
    //   148: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   151: aload 6
    //   153: getfield 92	android/graphics/BitmapFactory$Options:outWidth	I
    //   156: istore_2
    //   157: aload 6
    //   159: getfield 95	android/graphics/BitmapFactory$Options:outHeight	I
    //   162: istore_3
    //   163: iload_2
    //   164: iload_3
    //   165: if_icmple +186 -> 351
    //   168: aload 4
    //   170: astore_0
    //   171: iload_2
    //   172: iload_1
    //   173: if_icmple -164 -> 9
    //   176: aload 4
    //   178: iload_1
    //   179: invokestatic 131	nap:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   182: areturn
    //   183: iload_3
    //   184: istore_2
    //   185: goto -107 -> 78
    //   188: astore_0
    //   189: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -41 -> 151
    //   195: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   198: iconst_2
    //   199: ldc 133
    //   201: aload_0
    //   202: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: goto -54 -> 151
    //   208: astore_0
    //   209: aconst_null
    //   210: astore_0
    //   211: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +12 -> 226
    //   217: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   220: iconst_2
    //   221: ldc 135
    //   223: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload_0
    //   227: ifnull +7 -> 234
    //   230: aload_0
    //   231: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   234: aconst_null
    //   235: areturn
    //   236: astore_0
    //   237: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq -6 -> 234
    //   243: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   246: iconst_2
    //   247: ldc 133
    //   249: aload_0
    //   250: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: goto -19 -> 234
    //   256: astore 5
    //   258: aconst_null
    //   259: astore_0
    //   260: aload_0
    //   261: astore 4
    //   263: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +17 -> 283
    //   269: aload_0
    //   270: astore 4
    //   272: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   275: iconst_2
    //   276: ldc 140
    //   278: aload 5
    //   280: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: aload_0
    //   284: ifnull +7 -> 291
    //   287: aload_0
    //   288: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   291: aconst_null
    //   292: areturn
    //   293: astore_0
    //   294: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq -6 -> 291
    //   300: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   303: iconst_2
    //   304: ldc 133
    //   306: aload_0
    //   307: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   310: goto -19 -> 291
    //   313: astore_0
    //   314: aconst_null
    //   315: astore 4
    //   317: aload 4
    //   319: ifnull +8 -> 327
    //   322: aload 4
    //   324: invokevirtual 129	java/io/BufferedInputStream:close	()V
    //   327: aload_0
    //   328: athrow
    //   329: astore 4
    //   331: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq -7 -> 327
    //   337: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   340: iconst_2
    //   341: ldc 133
    //   343: aload 4
    //   345: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   348: goto -21 -> 327
    //   351: iload_3
    //   352: istore_2
    //   353: goto -185 -> 168
    //   356: astore_0
    //   357: goto -40 -> 317
    //   360: astore 5
    //   362: aload_0
    //   363: astore 4
    //   365: aload 5
    //   367: astore_0
    //   368: goto -51 -> 317
    //   371: astore 5
    //   373: goto -113 -> 260
    //   376: astore 4
    //   378: goto -167 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	paramString	String
    //   0	381	1	paramInt	int
    //   38	315	2	i	int
    //   44	308	3	j	int
    //   128	195	4	localObject1	Object
    //   329	15	4	localException1	java.lang.Exception
    //   363	1	4	str	String
    //   376	1	4	localOutOfMemoryError	OutOfMemoryError
    //   137	3	5	localBitmap	Bitmap
    //   256	23	5	localException2	java.lang.Exception
    //   360	6	5	localObject2	Object
    //   371	1	5	localException3	java.lang.Exception
    //   18	140	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   147	151	188	java/lang/Exception
    //   111	127	208	java/lang/OutOfMemoryError
    //   230	234	236	java/lang/Exception
    //   111	127	256	java/lang/Exception
    //   287	291	293	java/lang/Exception
    //   111	127	313	finally
    //   322	327	329	java/lang/Exception
    //   130	139	356	finally
    //   263	269	356	finally
    //   272	283	356	finally
    //   211	226	360	finally
    //   130	139	371	java/lang/Exception
    //   130	139	376	java/lang/OutOfMemoryError
  }
  
  public static Drawable a(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {
      return null;
    }
    paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
    paramDrawable.setColorFilter(new LightingColorFilter(0, paramInt));
    return paramDrawable;
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, String paramString, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: ldc 170
    //   7: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +20 -> 30
    //   13: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +12 -> 28
    //   19: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   22: iconst_2
    //   23: ldc 178
    //   25: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aconst_null
    //   29: areturn
    //   30: new 183	java/io/File
    //   33: dup
    //   34: getstatic 188	ajsf:bn	Ljava/lang/String;
    //   37: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore 4
    //   42: aload 4
    //   44: invokevirtual 192	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: aload 4
    //   50: invokevirtual 195	java/io/File:canWrite	()Z
    //   53: ifne +20 -> 73
    //   56: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq -31 -> 28
    //   62: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   65: iconst_2
    //   66: ldc 197
    //   68: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: aconst_null
    //   72: areturn
    //   73: new 199	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   80: getstatic 188	ajsf:bn	Ljava/lang/String;
    //   83: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokestatic 210	ayog:c	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore 4
    //   98: new 183	java/io/File
    //   101: dup
    //   102: aload 4
    //   104: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: astore 5
    //   109: aload 5
    //   111: invokevirtual 217	java/io/File:exists	()Z
    //   114: ifeq +6 -> 120
    //   117: aload 4
    //   119: areturn
    //   120: aload_1
    //   121: ldc 219
    //   123: invokevirtual 223	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   126: ifeq +99 -> 225
    //   129: aload_1
    //   130: bipush 44
    //   132: invokevirtual 227	java/lang/String:indexOf	(I)I
    //   135: istore_3
    //   136: iload_3
    //   137: ifle +206 -> 343
    //   140: aload_1
    //   141: iconst_0
    //   142: iload_3
    //   143: invokevirtual 231	java/lang/String:substring	(II)Ljava/lang/String;
    //   146: ldc 233
    //   148: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   151: ifeq +192 -> 343
    //   154: aload_1
    //   155: iload_3
    //   156: invokevirtual 239	java/lang/String:substring	(I)Ljava/lang/String;
    //   159: iconst_0
    //   160: invokestatic 245	bbca:decode	(Ljava/lang/String;I)[B
    //   163: astore_0
    //   164: aload_0
    //   165: astore_1
    //   166: aload_1
    //   167: ifnonnull +77 -> 244
    //   170: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq -145 -> 28
    //   176: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: iconst_2
    //   180: ldc 247
    //   182: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aconst_null
    //   186: areturn
    //   187: astore_0
    //   188: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq -163 -> 28
    //   194: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   197: iconst_2
    //   198: new 199	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   205: ldc 249
    //   207: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_0
    //   211: invokevirtual 250	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   214: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aconst_null
    //   224: areturn
    //   225: aload_0
    //   226: aload_1
    //   227: ldc 252
    //   229: aconst_null
    //   230: aload_2
    //   231: invokestatic 257	nam:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)[B
    //   234: astore_0
    //   235: goto -71 -> 164
    //   238: astore_0
    //   239: aconst_null
    //   240: astore_1
    //   241: goto -75 -> 166
    //   244: new 259	java/io/FileOutputStream
    //   247: dup
    //   248: aload 5
    //   250: invokespecial 262	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   253: astore_2
    //   254: aload_2
    //   255: astore_0
    //   256: aload_2
    //   257: aload_1
    //   258: invokevirtual 266	java/io/FileOutputStream:write	([B)V
    //   261: aload_2
    //   262: ifnull +7 -> 269
    //   265: aload_2
    //   266: invokevirtual 267	java/io/FileOutputStream:close	()V
    //   269: aload 4
    //   271: areturn
    //   272: astore_0
    //   273: aconst_null
    //   274: astore_1
    //   275: aload_1
    //   276: astore_0
    //   277: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +15 -> 295
    //   283: aload_1
    //   284: astore_0
    //   285: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   288: iconst_2
    //   289: ldc_w 269
    //   292: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload_1
    //   296: ifnull -268 -> 28
    //   299: aload_1
    //   300: invokevirtual 267	java/io/FileOutputStream:close	()V
    //   303: aconst_null
    //   304: areturn
    //   305: astore_0
    //   306: aconst_null
    //   307: areturn
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_1
    //   311: aload_1
    //   312: ifnull +7 -> 319
    //   315: aload_1
    //   316: invokevirtual 267	java/io/FileOutputStream:close	()V
    //   319: aload_0
    //   320: athrow
    //   321: astore_0
    //   322: goto -53 -> 269
    //   325: astore_1
    //   326: goto -7 -> 319
    //   329: astore_2
    //   330: aload_0
    //   331: astore_1
    //   332: aload_2
    //   333: astore_0
    //   334: goto -23 -> 311
    //   337: astore_0
    //   338: aload_2
    //   339: astore_1
    //   340: goto -65 -> 275
    //   343: aconst_null
    //   344: astore_0
    //   345: goto -181 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramContext	android.content.Context
    //   0	348	1	paramString	String
    //   0	348	2	paramBundle	android.os.Bundle
    //   135	21	3	i	int
    //   40	230	4	localObject	Object
    //   107	142	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   120	136	187	java/lang/OutOfMemoryError
    //   140	164	187	java/lang/OutOfMemoryError
    //   170	185	187	java/lang/OutOfMemoryError
    //   225	235	187	java/lang/OutOfMemoryError
    //   265	269	187	java/lang/OutOfMemoryError
    //   299	303	187	java/lang/OutOfMemoryError
    //   315	319	187	java/lang/OutOfMemoryError
    //   319	321	187	java/lang/OutOfMemoryError
    //   120	136	238	java/lang/Exception
    //   140	164	238	java/lang/Exception
    //   225	235	238	java/lang/Exception
    //   244	254	272	java/io/IOException
    //   299	303	305	java/io/IOException
    //   244	254	308	finally
    //   265	269	321	java/io/IOException
    //   315	319	325	java/io/IOException
    //   256	261	329	finally
    //   277	283	329	finally
    //   285	295	329	finally
    //   256	261	337	java/io/IOException
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: getstatic 272	nap:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +12 -> 18
    //   9: invokestatic 278	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   12: invokevirtual 279	java/io/File:toString	()Ljava/lang/String;
    //   15: putstatic 272	nap:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: new 199	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   25: getstatic 272	nap:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   28: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 281
    //   34: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore 4
    //   42: aconst_null
    //   43: astore_2
    //   44: aconst_null
    //   45: astore_3
    //   46: aload_2
    //   47: astore_1
    //   48: new 183	java/io/File
    //   51: dup
    //   52: aload 4
    //   54: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore 5
    //   59: aload_2
    //   60: astore_1
    //   61: aload 5
    //   63: invokevirtual 217	java/io/File:exists	()Z
    //   66: ifne +11 -> 77
    //   69: aload_2
    //   70: astore_1
    //   71: aload 5
    //   73: invokevirtual 284	java/io/File:mkdir	()Z
    //   76: pop
    //   77: aload_2
    //   78: astore_1
    //   79: aload_0
    //   80: invokestatic 287	nap:a	(Landroid/graphics/Bitmap;)[B
    //   83: invokestatic 293	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   86: astore 5
    //   88: aload_2
    //   89: astore_1
    //   90: new 199	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 295
    //   100: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload 5
    //   105: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc_w 297
    //   111: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: astore 5
    //   119: aload_2
    //   120: astore_1
    //   121: new 199	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   128: aload 4
    //   130: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 5
    //   135: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: astore 4
    //   143: aload_2
    //   144: astore_1
    //   145: new 183	java/io/File
    //   148: dup
    //   149: aload 4
    //   151: invokespecial 189	java/io/File:<init>	(Ljava/lang/String;)V
    //   154: astore 5
    //   156: aload_2
    //   157: astore_1
    //   158: aload 5
    //   160: invokevirtual 217	java/io/File:exists	()Z
    //   163: ifeq +105 -> 268
    //   166: aload_2
    //   167: astore_1
    //   168: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +15 -> 186
    //   174: aload_2
    //   175: astore_1
    //   176: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: iconst_2
    //   180: ldc_w 299
    //   183: invokestatic 302	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload_2
    //   187: astore_1
    //   188: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +36 -> 227
    //   194: aload_2
    //   195: astore_1
    //   196: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   199: iconst_2
    //   200: new 199	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 304
    //   210: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 5
    //   215: invokevirtual 308	java/io/File:length	()J
    //   218: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 302	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload 4
    //   229: astore_1
    //   230: iconst_0
    //   231: ifeq +11 -> 242
    //   234: new 313	java/lang/NullPointerException
    //   237: dup
    //   238: invokespecial 314	java/lang/NullPointerException:<init>	()V
    //   241: athrow
    //   242: aload_1
    //   243: areturn
    //   244: astore_0
    //   245: aload 4
    //   247: astore_1
    //   248: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq -9 -> 242
    //   254: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   257: iconst_2
    //   258: ldc_w 316
    //   261: aload_0
    //   262: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   265: aload 4
    //   267: areturn
    //   268: aload_2
    //   269: astore_1
    //   270: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +15 -> 288
    //   276: aload_2
    //   277: astore_1
    //   278: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   281: iconst_2
    //   282: ldc_w 318
    //   285: invokestatic 302	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_2
    //   289: astore_1
    //   290: new 320	java/io/BufferedOutputStream
    //   293: dup
    //   294: new 259	java/io/FileOutputStream
    //   297: dup
    //   298: aload 5
    //   300: invokespecial 262	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   303: invokespecial 323	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   306: astore_2
    //   307: aload_0
    //   308: getstatic 329	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   311: bipush 100
    //   313: aload_2
    //   314: invokevirtual 333	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   317: pop
    //   318: aload_2
    //   319: invokevirtual 336	java/io/BufferedOutputStream:flush	()V
    //   322: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +34 -> 359
    //   328: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   331: iconst_2
    //   332: new 199	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   339: ldc_w 304
    //   342: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 5
    //   347: invokevirtual 308	java/io/File:length	()J
    //   350: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   353: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 302	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aload 4
    //   361: astore_1
    //   362: aload_2
    //   363: ifnull -121 -> 242
    //   366: aload_2
    //   367: invokevirtual 337	java/io/BufferedOutputStream:close	()V
    //   370: aload 4
    //   372: areturn
    //   373: astore_0
    //   374: aload 4
    //   376: astore_1
    //   377: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq -138 -> 242
    //   383: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   386: iconst_2
    //   387: ldc_w 316
    //   390: aload_0
    //   391: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   394: aload 4
    //   396: areturn
    //   397: astore_2
    //   398: aload_3
    //   399: astore_0
    //   400: aload_0
    //   401: astore_1
    //   402: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq +16 -> 421
    //   408: aload_0
    //   409: astore_1
    //   410: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   413: iconst_2
    //   414: ldc_w 339
    //   417: aload_2
    //   418: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   421: ldc 170
    //   423: astore_2
    //   424: aload_2
    //   425: astore_1
    //   426: aload_0
    //   427: ifnull -185 -> 242
    //   430: aload_0
    //   431: invokevirtual 337	java/io/BufferedOutputStream:close	()V
    //   434: ldc 170
    //   436: areturn
    //   437: astore_0
    //   438: aload_2
    //   439: astore_1
    //   440: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   443: ifeq -201 -> 242
    //   446: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   449: iconst_2
    //   450: ldc_w 316
    //   453: aload_0
    //   454: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   457: ldc 170
    //   459: areturn
    //   460: astore_0
    //   461: aload_1
    //   462: ifnull +7 -> 469
    //   465: aload_1
    //   466: invokevirtual 337	java/io/BufferedOutputStream:close	()V
    //   469: aload_0
    //   470: athrow
    //   471: astore_1
    //   472: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq -6 -> 469
    //   478: getstatic 18	nap:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   481: iconst_2
    //   482: ldc_w 316
    //   485: aload_1
    //   486: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   489: goto -20 -> 469
    //   492: astore_0
    //   493: aload_2
    //   494: astore_1
    //   495: goto -34 -> 461
    //   498: astore_1
    //   499: aload_2
    //   500: astore_0
    //   501: aload_1
    //   502: astore_2
    //   503: goto -103 -> 400
    //   506: astore_1
    //   507: goto -489 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	paramBitmap	Bitmap
    //   47	419	1	localObject1	Object
    //   471	15	1	localException1	java.lang.Exception
    //   494	1	1	localObject2	Object
    //   498	4	1	localIOException1	java.io.IOException
    //   506	1	1	localException2	java.lang.Exception
    //   43	324	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   397	21	2	localIOException2	java.io.IOException
    //   423	80	2	localObject3	Object
    //   45	354	3	localObject4	Object
    //   40	355	4	str	String
    //   57	289	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   234	242	244	java/lang/Exception
    //   366	370	373	java/lang/Exception
    //   48	59	397	java/io/IOException
    //   61	69	397	java/io/IOException
    //   71	77	397	java/io/IOException
    //   79	88	397	java/io/IOException
    //   90	119	397	java/io/IOException
    //   121	143	397	java/io/IOException
    //   145	156	397	java/io/IOException
    //   158	166	397	java/io/IOException
    //   168	174	397	java/io/IOException
    //   176	186	397	java/io/IOException
    //   188	194	397	java/io/IOException
    //   196	227	397	java/io/IOException
    //   270	276	397	java/io/IOException
    //   278	288	397	java/io/IOException
    //   290	307	397	java/io/IOException
    //   430	434	437	java/lang/Exception
    //   48	59	460	finally
    //   61	69	460	finally
    //   71	77	460	finally
    //   79	88	460	finally
    //   90	119	460	finally
    //   121	143	460	finally
    //   145	156	460	finally
    //   158	166	460	finally
    //   168	174	460	finally
    //   176	186	460	finally
    //   188	194	460	finally
    //   196	227	460	finally
    //   270	276	460	finally
    //   278	288	460	finally
    //   290	307	460	finally
    //   402	408	460	finally
    //   410	421	460	finally
    //   465	469	471	java/lang/Exception
    //   307	359	492	finally
    //   307	359	498	java/io/IOException
    //   9	18	506	java/lang/Exception
  }
  
  public static byte[] a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i;
    int j;
    if (paramInt2 == -1)
    {
      i = 1;
      if (paramInt1 != -1) {
        break label60;
      }
      j = 128;
      label31:
      if (j >= i) {
        break label84;
      }
    }
    label60:
    label84:
    do
    {
      return i;
      i = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      j = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label31;
      if ((paramInt2 == -1) && (paramInt1 == -1)) {
        return 1;
      }
    } while (paramInt1 == -1);
    return j;
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt)
  {
    int i = 0;
    if (paramBitmap == null) {
      return paramBitmap;
    }
    int k = paramBitmap.getHeight();
    int m = paramBitmap.getWidth();
    int j;
    if (k > m) {
      j = m;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        paramInt = 0;
      }
      try
      {
        for (;;)
        {
          paramBitmap = Bitmap.createBitmap(paramBitmap, i, paramInt, j, j);
          return paramBitmap;
          j = k;
          break;
          if (k > m)
          {
            paramInt = k / 2 - m / 2;
          }
          else
          {
            i = m / 2 - k / 2;
            paramInt = 0;
            continue;
            paramInt = 0;
            continue;
            if (k > m)
            {
              paramInt = k - m;
            }
            else
            {
              i = m - k;
              paramInt = 0;
            }
          }
        }
      }
      catch (OutOfMemoryError paramBitmap)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w(jdField_b_of_type_JavaLangString, 2, "cutSquareBitmap OOM, e:" + paramBitmap);
          }
          paramBitmap = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     nap
 * JD-Core Version:    0.7.0.1
 */