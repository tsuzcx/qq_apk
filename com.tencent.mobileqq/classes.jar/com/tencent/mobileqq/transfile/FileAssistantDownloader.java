package com.tencent.mobileqq.transfile;

import aiph;
import aipi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class FileAssistantDownloader
  extends AbsDownloader
  implements ProtocolDownloaderConstants
{
  protected BaseApplicationImpl a;
  
  public FileAssistantDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private RoundRectBitmap a(Bitmap paramBitmap)
  {
    for (;;)
    {
      float f3;
      int j;
      int n;
      int k;
      int i1;
      try
      {
        f3 = this.a.getResources().getDisplayMetrics().density;
        int m = this.a.getResources().getDisplayMetrics().densityDpi;
        j = FilePicURLDrawlableHelper.c;
        i = FilePicURLDrawlableHelper.jdField_a_of_type_Int;
        n = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        Paint localPaint = new Paint(1);
        localPaint.setColor(-16777216);
        i1 = FilePicURLDrawlableHelper.e;
        int i2 = FilePicURLDrawlableHelper.f;
        if ((n >= i2) && (k >= i2)) {
          break label339;
        }
        if (n < k)
        {
          k = (int)(j / n * k + 0.5F);
          if (k <= i) {
            break label310;
          }
          Bitmap localBitmap = Bitmap.createBitmap(j, i, URLDrawableHelper.b);
          localBitmap.setDensity(m);
          new Canvas(localBitmap).drawBitmap(paramBitmap, null, new Rect(0, 0, j, i), localPaint);
          return new RoundRectBitmap(localBitmap, 14.0F * f3);
        }
        k = (int)(j / k * n + 0.5F);
        if (k <= i) {
          break label332;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        float f1;
        float f2;
        return new RoundRectBitmap(paramBitmap, 8.0F);
      }
      if (n > k)
      {
        f1 = i / n;
        if (n > k)
        {
          f2 = j / k;
          f1 = Math.max(f1, f2);
          j = (int)(n * f1 + 0.5F);
          i = (int)(f1 * k + 0.5F);
        }
      }
      else
      {
        f1 = i / k;
        continue;
      }
      f2 = j / n;
      continue;
      label310:
      int i = k;
      continue;
      for (;;)
      {
        k = i;
        i = j;
        j = k;
        break;
        label332:
        i = k;
      }
      label339:
      if ((n < i1) && (k < i1))
      {
        j = (int)(n * f3 + 0.5F);
        i = (int)(k * f3 + 0.5F);
      }
    }
  }
  
  /* Error */
  private Object b(DownloadParams paramDownloadParams, aiph paramaiph)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 8
    //   5: aconst_null
    //   6: astore 7
    //   8: aload_2
    //   9: getfield 150	aiph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: astore 10
    //   14: aload 10
    //   16: ifnonnull +8 -> 24
    //   19: aload 7
    //   21: astore_2
    //   22: aload_2
    //   23: areturn
    //   24: new 152	java/io/File
    //   27: dup
    //   28: aload 10
    //   30: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 11
    //   35: aload 11
    //   37: invokestatic 161	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   40: ifeq +63 -> 103
    //   43: aload_2
    //   44: getfield 164	aiph:jdField_a_of_type_Boolean	Z
    //   47: ifeq +56 -> 103
    //   50: aload 7
    //   52: astore_2
    //   53: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq -34 -> 22
    //   59: ldc 172
    //   61: iconst_2
    //   62: new 174	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   69: ldc 177
    //   71: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 11
    //   76: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   79: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 187
    //   84: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 10
    //   89: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_1
    //   101: aload_1
    //   102: athrow
    //   103: new 196	android/graphics/BitmapFactory$Options
    //   106: dup
    //   107: invokespecial 197	android/graphics/BitmapFactory$Options:<init>	()V
    //   110: astore 12
    //   112: aload 12
    //   114: getstatic 199	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Landroid/graphics/Bitmap$Config;
    //   117: putfield 202	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   120: aload 12
    //   122: sipush 160
    //   125: putfield 205	android/graphics/BitmapFactory$Options:inDensity	I
    //   128: aload 12
    //   130: sipush 160
    //   133: putfield 208	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   136: aload 12
    //   138: sipush 160
    //   141: putfield 211	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   144: aload_1
    //   145: aload 10
    //   147: invokestatic 217	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   150: putfield 222	com/tencent/image/DownloadParams:outOrientation	I
    //   153: aload 12
    //   155: iconst_1
    //   156: putfield 225	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   159: new 227	java/io/FileInputStream
    //   162: dup
    //   163: aload 11
    //   165: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   168: invokespecial 228	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   171: astore 7
    //   173: new 230	java/io/BufferedInputStream
    //   176: dup
    //   177: aload 7
    //   179: invokespecial 233	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   182: astore_2
    //   183: iconst_2
    //   184: newarray byte
    //   186: astore 9
    //   188: aload_2
    //   189: aload 9
    //   191: invokevirtual 237	java/io/BufferedInputStream:read	([B)I
    //   194: pop
    //   195: aload 9
    //   197: iconst_0
    //   198: baload
    //   199: bipush 66
    //   201: if_icmpeq +78 -> 279
    //   204: aload 9
    //   206: iconst_1
    //   207: baload
    //   208: istore 4
    //   210: iload 4
    //   212: bipush 77
    //   214: if_icmpeq +65 -> 279
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   225: aload 7
    //   227: ifnull +8 -> 235
    //   230: aload 7
    //   232: invokevirtual 241	java/io/FileInputStream:close	()V
    //   235: aload 12
    //   237: iconst_1
    //   238: putfield 225	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   241: aload 11
    //   243: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   246: aload 12
    //   248: invokestatic 247	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   251: pop
    //   252: aload 12
    //   254: getfield 250	android/graphics/BitmapFactory$Options:outHeight	I
    //   257: ifeq +11 -> 268
    //   260: aload 12
    //   262: getfield 253	android/graphics/BitmapFactory$Options:outWidth	I
    //   265: ifne +172 -> 437
    //   268: new 255	java/io/IOException
    //   271: dup
    //   272: ldc_w 257
    //   275: invokespecial 258	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   278: athrow
    //   279: aload_2
    //   280: iconst_4
    //   281: newarray byte
    //   283: invokevirtual 237	java/io/BufferedInputStream:read	([B)I
    //   286: pop
    //   287: aload_2
    //   288: ldc2_w 259
    //   291: invokevirtual 264	java/io/BufferedInputStream:skip	(J)J
    //   294: pop2
    //   295: iconst_4
    //   296: newarray byte
    //   298: astore 9
    //   300: aload_2
    //   301: aload 9
    //   303: invokevirtual 237	java/io/BufferedInputStream:read	([B)I
    //   306: pop
    //   307: aload_0
    //   308: aload 9
    //   310: invokevirtual 266	com/tencent/mobileqq/transfile/FileAssistantDownloader:a	([B)I
    //   313: istore 4
    //   315: iconst_4
    //   316: newarray byte
    //   318: astore 9
    //   320: aload_2
    //   321: aload 9
    //   323: invokevirtual 237	java/io/BufferedInputStream:read	([B)I
    //   326: pop
    //   327: aload_0
    //   328: aload 9
    //   330: invokevirtual 266	com/tencent/mobileqq/transfile/FileAssistantDownloader:a	([B)I
    //   333: invokestatic 270	java/lang/Math:abs	(I)I
    //   336: istore 5
    //   338: iload 4
    //   340: iflt +14 -> 354
    //   343: iload 4
    //   345: iload 5
    //   347: imul
    //   348: ldc_w 271
    //   351: if_icmple -134 -> 217
    //   354: invokestatic 275	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   357: invokevirtual 278	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   360: ldc_w 279
    //   363: invokevirtual 283	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   366: invokestatic 285	com/tencent/mobileqq/transfile/FileAssistantDownloader:a	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   369: astore 9
    //   371: aload 9
    //   373: astore_1
    //   374: aload_2
    //   375: ifnull +7 -> 382
    //   378: aload_2
    //   379: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   382: aload_1
    //   383: astore_2
    //   384: aload 7
    //   386: ifnull -364 -> 22
    //   389: aload 7
    //   391: invokevirtual 241	java/io/FileInputStream:close	()V
    //   394: aload_1
    //   395: areturn
    //   396: aload_2
    //   397: ifnull +7 -> 404
    //   400: aload_2
    //   401: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   404: aload 7
    //   406: ifnull -171 -> 235
    //   409: aload 7
    //   411: invokevirtual 241	java/io/FileInputStream:close	()V
    //   414: goto -179 -> 235
    //   417: aload_2
    //   418: ifnull +7 -> 425
    //   421: aload_2
    //   422: invokevirtual 240	java/io/BufferedInputStream:close	()V
    //   425: aload 7
    //   427: ifnull +8 -> 435
    //   430: aload 7
    //   432: invokevirtual 241	java/io/FileInputStream:close	()V
    //   435: aload_1
    //   436: athrow
    //   437: aload 12
    //   439: aload 12
    //   441: aload_1
    //   442: getfield 288	com/tencent/image/DownloadParams:reqWidth	I
    //   445: aload_1
    //   446: getfield 291	com/tencent/image/DownloadParams:reqHeight	I
    //   449: invokestatic 296	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   452: putfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   455: aload 12
    //   457: getfield 253	android/graphics/BitmapFactory$Options:outWidth	I
    //   460: istore 4
    //   462: aload 12
    //   464: getfield 250	android/graphics/BitmapFactory$Options:outHeight	I
    //   467: istore 4
    //   469: aload 12
    //   471: iconst_0
    //   472: putfield 225	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   475: aconst_null
    //   476: astore_2
    //   477: aload 8
    //   479: astore_1
    //   480: iload_3
    //   481: iconst_3
    //   482: if_icmpgt +219 -> 701
    //   485: aload_2
    //   486: astore_1
    //   487: aload 11
    //   489: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   492: aload 12
    //   494: invokestatic 247	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   497: astore_2
    //   498: aload_2
    //   499: ifnonnull +177 -> 676
    //   502: aload_2
    //   503: astore_1
    //   504: new 66	java/lang/OutOfMemoryError
    //   507: dup
    //   508: new 174	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   515: ldc_w 301
    //   518: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload 10
    //   523: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: ldc_w 303
    //   529: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: iload_3
    //   533: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: ldc_w 308
    //   539: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload 11
    //   544: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   547: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokespecial 309	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   556: athrow
    //   557: astore_2
    //   558: aload_1
    //   559: ifnull +7 -> 566
    //   562: aload_1
    //   563: invokevirtual 312	android/graphics/Bitmap:recycle	()V
    //   566: aload_2
    //   567: ifnull +151 -> 718
    //   570: aload_2
    //   571: invokevirtual 315	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   574: astore_2
    //   575: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   578: ifeq +77 -> 655
    //   581: ldc 172
    //   583: iconst_2
    //   584: new 174	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 317
    //   594: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: iload_3
    //   598: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: ldc_w 319
    //   604: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload 12
    //   609: getfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   612: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   615: ldc_w 321
    //   618: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload 11
    //   623: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   626: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: ldc 187
    //   631: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload 10
    //   636: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 323
    //   642: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload_2
    //   646: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   655: aload 12
    //   657: aload 12
    //   659: getfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   662: iconst_2
    //   663: imul
    //   664: putfield 299	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   667: iload_3
    //   668: iconst_1
    //   669: iadd
    //   670: istore_3
    //   671: aload_1
    //   672: astore_2
    //   673: goto -196 -> 477
    //   676: aload_2
    //   677: astore_1
    //   678: getstatic 328	android/os/Build$VERSION:SDK_INT	I
    //   681: bipush 11
    //   683: if_icmplt +16 -> 699
    //   686: aload_2
    //   687: astore_1
    //   688: aload_2
    //   689: invokestatic 334	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   692: istore 6
    //   694: iload 6
    //   696: ifeq +3 -> 699
    //   699: aload_2
    //   700: astore_1
    //   701: aload_1
    //   702: astore_2
    //   703: aload_1
    //   704: ifnonnull -682 -> 22
    //   707: new 255	java/io/IOException
    //   710: dup
    //   711: ldc_w 336
    //   714: invokespecial 258	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   717: athrow
    //   718: aconst_null
    //   719: astore_2
    //   720: goto -145 -> 575
    //   723: astore_1
    //   724: aconst_null
    //   725: astore_2
    //   726: goto -309 -> 417
    //   729: astore_1
    //   730: goto -313 -> 417
    //   733: astore_2
    //   734: aconst_null
    //   735: astore_2
    //   736: goto -340 -> 396
    //   739: astore 9
    //   741: goto -345 -> 396
    //   744: astore_2
    //   745: aconst_null
    //   746: astore_2
    //   747: aconst_null
    //   748: astore 7
    //   750: goto -354 -> 396
    //   753: astore_1
    //   754: aconst_null
    //   755: astore 7
    //   757: aconst_null
    //   758: astore_2
    //   759: goto -342 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	762	0	this	FileAssistantDownloader
    //   0	762	1	paramDownloadParams	DownloadParams
    //   0	762	2	paramaiph	aiph
    //   1	670	3	i	int
    //   208	260	4	j	int
    //   336	12	5	k	int
    //   692	3	6	bool	boolean
    //   6	750	7	localFileInputStream	java.io.FileInputStream
    //   3	475	8	localObject1	Object
    //   186	186	9	localObject2	Object
    //   739	1	9	localException	Exception
    //   12	623	10	str	String
    //   33	589	11	localFile	File
    //   110	548	12	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   35	50	100	java/lang/Exception
    //   53	98	100	java/lang/Exception
    //   103	159	100	java/lang/Exception
    //   221	225	100	java/lang/Exception
    //   230	235	100	java/lang/Exception
    //   235	268	100	java/lang/Exception
    //   268	279	100	java/lang/Exception
    //   378	382	100	java/lang/Exception
    //   389	394	100	java/lang/Exception
    //   400	404	100	java/lang/Exception
    //   409	414	100	java/lang/Exception
    //   421	425	100	java/lang/Exception
    //   430	435	100	java/lang/Exception
    //   435	437	100	java/lang/Exception
    //   437	475	100	java/lang/Exception
    //   487	498	100	java/lang/Exception
    //   504	557	100	java/lang/Exception
    //   562	566	100	java/lang/Exception
    //   570	575	100	java/lang/Exception
    //   575	655	100	java/lang/Exception
    //   655	667	100	java/lang/Exception
    //   678	686	100	java/lang/Exception
    //   688	694	100	java/lang/Exception
    //   707	718	100	java/lang/Exception
    //   487	498	557	java/lang/OutOfMemoryError
    //   504	557	557	java/lang/OutOfMemoryError
    //   678	686	557	java/lang/OutOfMemoryError
    //   688	694	557	java/lang/OutOfMemoryError
    //   173	183	723	finally
    //   183	195	729	finally
    //   279	338	729	finally
    //   354	371	729	finally
    //   173	183	733	java/lang/Exception
    //   183	195	739	java/lang/Exception
    //   279	338	739	java/lang/Exception
    //   354	371	739	java/lang/Exception
    //   159	173	744	java/lang/Exception
    //   159	173	753	finally
  }
  
  int a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[1] & 0xFF) << 8 | paramArrayOfByte[0] & 0xFF;
  }
  
  public aiph a(URL paramURL)
  {
    boolean bool2 = true;
    try
    {
      paramURL = paramURL.getFile().split("\\|");
      aiph localaiph = new aiph(this);
      localaiph.jdField_a_of_type_JavaLangString = paramURL[0];
      localaiph.jdField_a_of_type_Int = Integer.parseInt(paramURL[1]);
      localaiph.jdField_b_of_type_Int = Integer.parseInt(paramURL[2]);
      localaiph.jdField_a_of_type_Long = Long.parseLong(paramURL[3]);
      if (paramURL.length > 4)
      {
        if (Integer.parseInt(paramURL[4]) == 1)
        {
          bool1 = true;
          localaiph.jdField_a_of_type_Boolean = bool1;
        }
      }
      else
      {
        if (paramURL.length > 5)
        {
          if (Integer.parseInt(paramURL[5]) != 1) {
            break label172;
          }
          bool1 = true;
          label106:
          localaiph.jdField_b_of_type_Boolean = bool1;
        }
        if (paramURL.length > 6)
        {
          if (Integer.parseInt(paramURL[6]) != 1) {
            break label177;
          }
          bool1 = true;
          label132:
          localaiph.c = bool1;
        }
        if (paramURL.length > 7) {
          if (Integer.parseInt(paramURL[7]) != 1) {
            break label182;
          }
        }
      }
      label172:
      label177:
      label182:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localaiph.d = bool1;
        return localaiph;
        bool1 = false;
        break;
        bool1 = false;
        break label106;
        bool1 = false;
        break label132;
      }
      return null;
    }
    catch (Exception paramURL) {}
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f = this.a.getResources().getDisplayMetrics().density;
    paramInt1 = (int)(paramInt1 * f);
    paramInt2 = (int)(f * paramInt2);
    return ImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = a(paramDownloadParams.url);
    if ((paramOutputStream == null) || (paramOutputStream.jdField_a_of_type_JavaLangString == null)) {
      return new File(AppConstants.aI);
    }
    return new File(paramOutputStream.jdField_a_of_type_JavaLangString);
  }
  
  public Object a(DownloadParams paramDownloadParams, aiph paramaiph)
  {
    paramDownloadParams = paramaiph.jdField_a_of_type_JavaLangString;
    if (paramDownloadParams == null) {
      paramDownloadParams = null;
    }
    for (;;)
    {
      return paramDownloadParams;
      File localFile = new File(paramDownloadParams);
      try
      {
        paramDownloadParams = new BitmapFactory.Options();
        paramDownloadParams.inPreferredConfig = URLDrawableHelper.b;
        paramDownloadParams.inDensity = 160;
        paramDownloadParams.inTargetDensity = 160;
        paramDownloadParams.inScreenDensity = 160;
        paramDownloadParams.inJustDecodeBounds = false;
        paramaiph = SafeBitmapFactory.decodeFile(localFile.getAbsolutePath(), paramDownloadParams);
        paramDownloadParams = paramaiph;
        if (paramaiph == null) {
          continue;
        }
        paramDownloadParams = a(paramaiph);
        if (!paramaiph.equals(paramDownloadParams.mBitmap)) {
          paramaiph.recycle();
        }
        paramaiph = new RoundRectBitmap(new ExifBitmapCreator(localFile.getAbsolutePath()).a(paramDownloadParams.mBitmap), paramDownloadParams.mCornerRadius, paramDownloadParams.mBoardColor, paramDownloadParams.mBorderWidth);
        paramDownloadParams = paramaiph;
        if (this.a == null) {
          continue;
        }
        paramaiph.mDisplayWidth = this.a.getResources().getDisplayMetrics().widthPixels;
        paramaiph.mDisplayHeight = this.a.getResources().getDisplayMetrics().heightPixels;
        return paramaiph;
      }
      catch (Exception paramDownloadParams)
      {
        throw paramDownloadParams;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = AlbumThumbManager.a(BaseApplicationImpl.getContext());
    paramURLDrawableHandler = a(paramDownloadParams.url);
    if (paramURLDrawableHandler == null) {
      paramDownloadParams = null;
    }
    do
    {
      return paramDownloadParams;
      int i;
      if (FileManagerUtil.a(paramURLDrawableHandler.jdField_a_of_type_JavaLangString) == 2) {
        i = 1;
      }
      while ((paramURLDrawableHandler.jdField_a_of_type_Boolean) && (!paramURLDrawableHandler.jdField_b_of_type_Boolean) && (!paramURLDrawableHandler.c) && (i == 0)) {
        if (paramURLDrawableHandler.d)
        {
          return a(paramDownloadParams, paramURLDrawableHandler);
          i = 0;
        }
        else
        {
          return b(paramDownloadParams, paramURLDrawableHandler);
        }
      }
      if (paramURLDrawableHandler.c)
      {
        paramFile = FileCategoryUtil.a(this.a, paramURLDrawableHandler.jdField_a_of_type_JavaLangString);
        if (paramFile != null) {
          paramFile = a(paramFile);
        }
      }
      while (paramFile == null)
      {
        return null;
        paramFile = a(BaseApplicationImpl.getContext().getResources().getDrawable(2130841601));
        continue;
        paramFile = paramFile.a(paramDownloadParams.url, new aipi(this));
      }
      paramDownloadParams = paramFile;
    } while (!paramURLDrawableHandler.jdField_b_of_type_Boolean);
    return a(paramFile, paramFile.getWidth(), paramFile.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileAssistantDownloader
 * JD-Core Version:    0.7.0.1
 */