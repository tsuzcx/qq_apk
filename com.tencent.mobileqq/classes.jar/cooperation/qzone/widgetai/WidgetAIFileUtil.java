package cooperation.qzone.widgetai;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Environment;
import java.io.File;

public class WidgetAIFileUtil
{
  public static final String a = Environment.getExternalStorageDirectory() + File.separator;
  public static final String b = a + "Pictures" + File.separator + "QzonePet";
  
  public static Bitmap a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    int i = 0;
    while (i < paramInt2)
    {
      int j = 0;
      while (j < paramInt1)
      {
        arrayOfInt[(i * paramInt1 + j)] = -1;
        j += 1;
      }
      i += 1;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localBitmap.setPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap;
    if (paramBitmap1 == null) {
      localBitmap = null;
    }
    do
    {
      return localBitmap;
      localBitmap = paramBitmap1;
    } while (paramBitmap2 == null);
    int i;
    if (paramInt3 == 0) {
      i = paramBitmap1.getWidth();
    }
    for (paramInt3 = paramBitmap1.getHeight() + paramBitmap2.getHeight();; paramInt3 = Math.max(paramBitmap1.getHeight(), paramBitmap2.getHeight()))
    {
      localBitmap = Bitmap.createBitmap(i, paramInt3, paramBitmap1.getConfig());
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap(paramBitmap1, new Matrix(), null);
      localCanvas.drawBitmap(paramBitmap2, paramInt1, paramInt2, null);
      return localBitmap;
      i = Math.max(paramBitmap1.getWidth(), paramBitmap2.getWidth());
    }
  }
  
  /* Error */
  public static String a(String paramString, Bitmap paramBitmap, android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +14 -> 15
    //   4: aload_2
    //   5: ifnull +10 -> 15
    //   8: aload_0
    //   9: invokestatic 107	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: ldc 109
    //   19: ldc 111
    //   21: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: new 26	java/io/File
    //   28: dup
    //   29: getstatic 44	cooperation/qzone/widgetai/WidgetAIFileUtil:b	Ljava/lang/String;
    //   32: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 124	java/io/File:exists	()Z
    //   42: ifne +168 -> 210
    //   45: aload 5
    //   47: invokevirtual 127	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: new 26	java/io/File
    //   54: dup
    //   55: new 11	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   62: getstatic 44	cooperation/qzone/widgetai/WidgetAIFileUtil:b	Ljava/lang/String;
    //   65: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 29	java/io/File:separator	Ljava/lang/String;
    //   71: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: astore 7
    //   86: aload 7
    //   88: invokevirtual 124	java/io/File:exists	()Z
    //   91: ifeq +9 -> 100
    //   94: aload 7
    //   96: invokevirtual 130	java/io/File:delete	()Z
    //   99: pop
    //   100: iconst_0
    //   101: istore 4
    //   103: new 132	java/io/FileOutputStream
    //   106: dup
    //   107: aload 7
    //   109: invokespecial 135	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   112: astore 6
    //   114: aload 6
    //   116: astore 5
    //   118: aload_1
    //   119: getstatic 141	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   122: bipush 100
    //   124: aload 6
    //   126: invokevirtual 145	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   129: pop
    //   130: aload 6
    //   132: astore 5
    //   134: aload 6
    //   136: invokevirtual 148	java/io/FileOutputStream:flush	()V
    //   139: aload 6
    //   141: astore 5
    //   143: ldc 109
    //   145: ldc 150
    //   147: invokestatic 153	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   150: pop
    //   151: iload 4
    //   153: istore_3
    //   154: aload 6
    //   156: ifnull +11 -> 167
    //   159: aload 6
    //   161: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   164: iload 4
    //   166: istore_3
    //   167: iload_3
    //   168: ifne -153 -> 15
    //   171: aload_2
    //   172: invokevirtual 162	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   175: aload 7
    //   177: invokevirtual 165	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: aload_0
    //   181: aconst_null
    //   182: invokestatic 171	android/provider/MediaStore$Images$Media:insertImage	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   185: pop
    //   186: aload_2
    //   187: new 173	android/content/Intent
    //   190: dup
    //   191: ldc 175
    //   193: aload 7
    //   195: invokestatic 181	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   198: invokespecial 184	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   201: invokevirtual 188	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   204: aload 7
    //   206: invokevirtual 165	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   209: areturn
    //   210: aload 5
    //   212: invokevirtual 191	java/io/File:isDirectory	()Z
    //   215: ifne -164 -> 51
    //   218: aload 5
    //   220: invokevirtual 130	java/io/File:delete	()Z
    //   223: pop
    //   224: aload 5
    //   226: invokevirtual 127	java/io/File:mkdirs	()Z
    //   229: pop
    //   230: goto -179 -> 51
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   238: iload 4
    //   240: istore_3
    //   241: goto -74 -> 167
    //   244: astore_1
    //   245: aconst_null
    //   246: astore 6
    //   248: aload 6
    //   250: astore 5
    //   252: aload_1
    //   253: invokevirtual 195	java/io/FileNotFoundException:printStackTrace	()V
    //   256: aload 6
    //   258: ifnull +104 -> 362
    //   261: aload 6
    //   263: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   266: iconst_1
    //   267: istore_3
    //   268: goto -101 -> 167
    //   271: astore_1
    //   272: aload_1
    //   273: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   276: iconst_1
    //   277: istore_3
    //   278: goto -111 -> 167
    //   281: astore_1
    //   282: aconst_null
    //   283: astore 6
    //   285: aload 6
    //   287: astore 5
    //   289: aload_1
    //   290: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   293: aload 6
    //   295: ifnull +67 -> 362
    //   298: aload 6
    //   300: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   303: iconst_1
    //   304: istore_3
    //   305: goto -138 -> 167
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   313: iconst_1
    //   314: istore_3
    //   315: goto -148 -> 167
    //   318: astore_0
    //   319: aconst_null
    //   320: astore 5
    //   322: aload 5
    //   324: ifnull +8 -> 332
    //   327: aload 5
    //   329: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   332: aload_0
    //   333: athrow
    //   334: astore_1
    //   335: aload_1
    //   336: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   339: goto -7 -> 332
    //   342: astore_0
    //   343: aload_0
    //   344: invokevirtual 195	java/io/FileNotFoundException:printStackTrace	()V
    //   347: goto -161 -> 186
    //   350: astore_0
    //   351: goto -29 -> 322
    //   354: astore_1
    //   355: goto -70 -> 285
    //   358: astore_1
    //   359: goto -111 -> 248
    //   362: iconst_1
    //   363: istore_3
    //   364: goto -197 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	paramString	String
    //   0	367	1	paramBitmap	Bitmap
    //   0	367	2	paramContext	android.content.Context
    //   153	211	3	i	int
    //   101	138	4	j	int
    //   35	293	5	localObject	Object
    //   112	187	6	localFileOutputStream	java.io.FileOutputStream
    //   84	121	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   159	164	233	java/io/IOException
    //   103	114	244	java/io/FileNotFoundException
    //   261	266	271	java/io/IOException
    //   103	114	281	java/io/IOException
    //   298	303	308	java/io/IOException
    //   103	114	318	finally
    //   327	332	334	java/io/IOException
    //   171	186	342	java/io/FileNotFoundException
    //   118	130	350	finally
    //   134	139	350	finally
    //   143	151	350	finally
    //   252	256	350	finally
    //   289	293	350	finally
    //   118	130	354	java/io/IOException
    //   134	139	354	java/io/IOException
    //   143	151	354	java/io/IOException
    //   118	130	358	java/io/FileNotFoundException
    //   134	139	358	java/io/FileNotFoundException
    //   143	151	358	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widgetai.WidgetAIFileUtil
 * JD-Core Version:    0.7.0.1
 */