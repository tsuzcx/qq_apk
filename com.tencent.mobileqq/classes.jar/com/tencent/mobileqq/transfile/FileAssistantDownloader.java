package com.tencent.mobileqq.transfile;

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
import auds;
import auea;
import aues;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class FileAssistantDownloader
  extends AbsDownloader
  implements ProtocolDownloaderConstants
{
  public static final int RADIUS = 16;
  private static final String TAG = "FileAssistantDownloader";
  protected BaseApplicationImpl application;
  
  public FileAssistantDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.application = paramBaseApplicationImpl;
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_4444);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  /* Error */
  private Object internalDecodeFile(DownloadParams paramDownloadParams, FileAssistantDownloader.PhotoInfo paramPhotoInfo)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 8
    //   5: aconst_null
    //   6: astore 7
    //   8: aload_2
    //   9: getfield 82	com/tencent/mobileqq/transfile/FileAssistantDownloader$PhotoInfo:path	Ljava/lang/String;
    //   12: astore 10
    //   14: aload 10
    //   16: ifnonnull +8 -> 24
    //   19: aload 7
    //   21: astore_2
    //   22: aload_2
    //   23: areturn
    //   24: new 84	java/io/File
    //   27: dup
    //   28: aload 10
    //   30: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 11
    //   35: aload 11
    //   37: invokestatic 93	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   40: ifeq +63 -> 103
    //   43: aload_2
    //   44: getfield 97	com/tencent/mobileqq/transfile/FileAssistantDownloader$PhotoInfo:isRaw	Z
    //   47: ifeq +56 -> 103
    //   50: aload 7
    //   52: astore_2
    //   53: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq -34 -> 22
    //   59: ldc 13
    //   61: iconst_2
    //   62: new 105	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   69: ldc 108
    //   71: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 11
    //   76: invokevirtual 116	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   79: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 118
    //   84: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 10
    //   89: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_1
    //   101: aload_1
    //   102: athrow
    //   103: new 127	android/graphics/BitmapFactory$Options
    //   106: dup
    //   107: invokespecial 128	android/graphics/BitmapFactory$Options:<init>	()V
    //   110: astore 12
    //   112: aload 12
    //   114: getstatic 133	com/tencent/mobileqq/transfile/URLDrawableHelper:mConfig	Landroid/graphics/Bitmap$Config;
    //   117: putfield 136	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   120: aload 12
    //   122: sipush 160
    //   125: putfield 139	android/graphics/BitmapFactory$Options:inDensity	I
    //   128: aload 12
    //   130: sipush 160
    //   133: putfield 142	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   136: aload 12
    //   138: sipush 160
    //   141: putfield 145	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   144: aload_1
    //   145: aload 10
    //   147: invokestatic 151	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   150: putfield 156	com/tencent/image/DownloadParams:outOrientation	I
    //   153: aload 12
    //   155: iconst_1
    //   156: putfield 159	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   159: new 161	java/io/FileInputStream
    //   162: dup
    //   163: aload 11
    //   165: invokevirtual 116	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   168: invokespecial 162	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   171: astore 7
    //   173: new 164	java/io/BufferedInputStream
    //   176: dup
    //   177: aload 7
    //   179: invokespecial 167	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   182: astore_2
    //   183: iconst_2
    //   184: newarray byte
    //   186: astore 9
    //   188: aload_2
    //   189: aload 9
    //   191: invokevirtual 171	java/io/BufferedInputStream:read	([B)I
    //   194: pop
    //   195: aload 9
    //   197: iconst_0
    //   198: baload
    //   199: bipush 66
    //   201: if_icmpeq +77 -> 278
    //   204: aload 9
    //   206: iconst_1
    //   207: baload
    //   208: istore 4
    //   210: iload 4
    //   212: bipush 77
    //   214: if_icmpeq +64 -> 278
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   225: aload 7
    //   227: ifnull +8 -> 235
    //   230: aload 7
    //   232: invokevirtual 175	java/io/FileInputStream:close	()V
    //   235: aload 12
    //   237: iconst_1
    //   238: putfield 159	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   241: aload 11
    //   243: invokevirtual 116	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   246: aload 12
    //   248: invokestatic 181	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   251: pop
    //   252: aload 12
    //   254: getfield 184	android/graphics/BitmapFactory$Options:outHeight	I
    //   257: ifeq +11 -> 268
    //   260: aload 12
    //   262: getfield 187	android/graphics/BitmapFactory$Options:outWidth	I
    //   265: ifne +169 -> 434
    //   268: new 189	java/io/IOException
    //   271: dup
    //   272: ldc 191
    //   274: invokespecial 192	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   277: athrow
    //   278: aload_2
    //   279: iconst_4
    //   280: newarray byte
    //   282: invokevirtual 171	java/io/BufferedInputStream:read	([B)I
    //   285: pop
    //   286: aload_2
    //   287: ldc2_w 193
    //   290: invokevirtual 198	java/io/BufferedInputStream:skip	(J)J
    //   293: pop2
    //   294: iconst_4
    //   295: newarray byte
    //   297: astore 9
    //   299: aload_2
    //   300: aload 9
    //   302: invokevirtual 171	java/io/BufferedInputStream:read	([B)I
    //   305: pop
    //   306: aload_0
    //   307: aload 9
    //   309: invokevirtual 201	com/tencent/mobileqq/transfile/FileAssistantDownloader:byte2Int	([B)I
    //   312: istore 4
    //   314: iconst_4
    //   315: newarray byte
    //   317: astore 9
    //   319: aload_2
    //   320: aload 9
    //   322: invokevirtual 171	java/io/BufferedInputStream:read	([B)I
    //   325: pop
    //   326: aload_0
    //   327: aload 9
    //   329: invokevirtual 201	com/tencent/mobileqq/transfile/FileAssistantDownloader:byte2Int	([B)I
    //   332: invokestatic 207	java/lang/Math:abs	(I)I
    //   335: istore 5
    //   337: iload 4
    //   339: iflt +13 -> 352
    //   342: iload 4
    //   344: iload 5
    //   346: imul
    //   347: ldc 208
    //   349: if_icmple -132 -> 217
    //   352: invokestatic 214	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   355: invokevirtual 220	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   358: ldc 221
    //   360: invokevirtual 227	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   363: invokestatic 229	com/tencent/mobileqq/transfile/FileAssistantDownloader:drawableToBitmap	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   366: astore 9
    //   368: aload 9
    //   370: astore_1
    //   371: aload_2
    //   372: ifnull +7 -> 379
    //   375: aload_2
    //   376: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   379: aload_1
    //   380: astore_2
    //   381: aload 7
    //   383: ifnull -361 -> 22
    //   386: aload 7
    //   388: invokevirtual 175	java/io/FileInputStream:close	()V
    //   391: aload_1
    //   392: areturn
    //   393: aload_2
    //   394: ifnull +7 -> 401
    //   397: aload_2
    //   398: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   401: aload 7
    //   403: ifnull -168 -> 235
    //   406: aload 7
    //   408: invokevirtual 175	java/io/FileInputStream:close	()V
    //   411: goto -176 -> 235
    //   414: aload_2
    //   415: ifnull +7 -> 422
    //   418: aload_2
    //   419: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   422: aload 7
    //   424: ifnull +8 -> 432
    //   427: aload 7
    //   429: invokevirtual 175	java/io/FileInputStream:close	()V
    //   432: aload_1
    //   433: athrow
    //   434: aload 12
    //   436: aload 12
    //   438: aload_1
    //   439: getfield 232	com/tencent/image/DownloadParams:reqWidth	I
    //   442: aload_1
    //   443: getfield 235	com/tencent/image/DownloadParams:reqHeight	I
    //   446: invokestatic 241	com/tencent/mobileqq/transfile/AbstractImageDownloader:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   449: putfield 244	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   452: aload 12
    //   454: getfield 184	android/graphics/BitmapFactory$Options:outHeight	I
    //   457: aload 12
    //   459: getfield 187	android/graphics/BitmapFactory$Options:outWidth	I
    //   462: imul
    //   463: ldc 245
    //   465: if_icmple +52 -> 517
    //   468: ldc 13
    //   470: iconst_1
    //   471: new 105	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   478: ldc 247
    //   480: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload 12
    //   485: getfield 184	android/graphics/BitmapFactory$Options:outHeight	I
    //   488: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: ldc 252
    //   493: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload 12
    //   498: getfield 187	android/graphics/BitmapFactory$Options:outWidth	I
    //   501: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   504: ldc 254
    //   506: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 257	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: aconst_null
    //   516: areturn
    //   517: aload 12
    //   519: getfield 187	android/graphics/BitmapFactory$Options:outWidth	I
    //   522: istore 4
    //   524: aload 12
    //   526: getfield 184	android/graphics/BitmapFactory$Options:outHeight	I
    //   529: istore 4
    //   531: aload 12
    //   533: iconst_0
    //   534: putfield 159	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   537: aconst_null
    //   538: astore_2
    //   539: aload 8
    //   541: astore_1
    //   542: iload_3
    //   543: iconst_3
    //   544: if_icmpgt +219 -> 763
    //   547: aload_2
    //   548: astore_1
    //   549: aload 11
    //   551: invokevirtual 116	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   554: aload 12
    //   556: invokestatic 181	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   559: astore_2
    //   560: aload_2
    //   561: ifnonnull +177 -> 738
    //   564: aload_2
    //   565: astore_1
    //   566: new 77	java/lang/OutOfMemoryError
    //   569: dup
    //   570: new 105	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 259
    //   580: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 10
    //   585: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: ldc_w 261
    //   591: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: iload_3
    //   595: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   598: ldc_w 263
    //   601: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: aload 11
    //   606: invokevirtual 116	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   609: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokespecial 264	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   618: athrow
    //   619: astore_2
    //   620: aload_1
    //   621: ifnull +7 -> 628
    //   624: aload_1
    //   625: invokevirtual 267	android/graphics/Bitmap:recycle	()V
    //   628: aload_2
    //   629: ifnull +151 -> 780
    //   632: aload_2
    //   633: invokevirtual 270	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   636: astore_2
    //   637: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   640: ifeq +77 -> 717
    //   643: ldc 13
    //   645: iconst_2
    //   646: new 105	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   653: ldc_w 272
    //   656: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: iload_3
    //   660: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   663: ldc_w 274
    //   666: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: aload 12
    //   671: getfield 244	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   674: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   677: ldc_w 276
    //   680: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: aload 11
    //   685: invokevirtual 116	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   688: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: ldc 118
    //   693: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: aload 10
    //   698: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: ldc_w 278
    //   704: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: aload_2
    //   708: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   717: aload 12
    //   719: aload 12
    //   721: getfield 244	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   724: iconst_2
    //   725: imul
    //   726: putfield 244	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   729: iload_3
    //   730: iconst_1
    //   731: iadd
    //   732: istore_3
    //   733: aload_1
    //   734: astore_2
    //   735: goto -196 -> 539
    //   738: aload_2
    //   739: astore_1
    //   740: getstatic 283	android/os/Build$VERSION:SDK_INT	I
    //   743: bipush 11
    //   745: if_icmplt +16 -> 761
    //   748: aload_2
    //   749: astore_1
    //   750: aload_2
    //   751: invokestatic 289	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   754: istore 6
    //   756: iload 6
    //   758: ifeq +3 -> 761
    //   761: aload_2
    //   762: astore_1
    //   763: aload_1
    //   764: astore_2
    //   765: aload_1
    //   766: ifnonnull -744 -> 22
    //   769: new 189	java/io/IOException
    //   772: dup
    //   773: ldc_w 291
    //   776: invokespecial 192	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   779: athrow
    //   780: aconst_null
    //   781: astore_2
    //   782: goto -145 -> 637
    //   785: astore_1
    //   786: aconst_null
    //   787: astore_2
    //   788: goto -374 -> 414
    //   791: astore_1
    //   792: goto -378 -> 414
    //   795: astore_2
    //   796: aconst_null
    //   797: astore_2
    //   798: goto -405 -> 393
    //   801: astore 9
    //   803: goto -410 -> 393
    //   806: astore_2
    //   807: aconst_null
    //   808: astore_2
    //   809: aconst_null
    //   810: astore 7
    //   812: goto -419 -> 393
    //   815: astore_1
    //   816: aconst_null
    //   817: astore 7
    //   819: aconst_null
    //   820: astore_2
    //   821: goto -407 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	824	0	this	FileAssistantDownloader
    //   0	824	1	paramDownloadParams	DownloadParams
    //   0	824	2	paramPhotoInfo	FileAssistantDownloader.PhotoInfo
    //   1	732	3	i	int
    //   208	322	4	j	int
    //   335	12	5	k	int
    //   754	3	6	bool	boolean
    //   6	812	7	localFileInputStream	java.io.FileInputStream
    //   3	537	8	localObject1	Object
    //   186	183	9	localObject2	Object
    //   801	1	9	localException	Exception
    //   12	685	10	str	String
    //   33	651	11	localFile	File
    //   110	610	12	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   35	50	100	java/lang/Exception
    //   53	98	100	java/lang/Exception
    //   103	159	100	java/lang/Exception
    //   221	225	100	java/lang/Exception
    //   230	235	100	java/lang/Exception
    //   235	268	100	java/lang/Exception
    //   268	278	100	java/lang/Exception
    //   375	379	100	java/lang/Exception
    //   386	391	100	java/lang/Exception
    //   397	401	100	java/lang/Exception
    //   406	411	100	java/lang/Exception
    //   418	422	100	java/lang/Exception
    //   427	432	100	java/lang/Exception
    //   432	434	100	java/lang/Exception
    //   434	515	100	java/lang/Exception
    //   517	537	100	java/lang/Exception
    //   549	560	100	java/lang/Exception
    //   566	619	100	java/lang/Exception
    //   624	628	100	java/lang/Exception
    //   632	637	100	java/lang/Exception
    //   637	717	100	java/lang/Exception
    //   717	729	100	java/lang/Exception
    //   740	748	100	java/lang/Exception
    //   750	756	100	java/lang/Exception
    //   769	780	100	java/lang/Exception
    //   549	560	619	java/lang/OutOfMemoryError
    //   566	619	619	java/lang/OutOfMemoryError
    //   740	748	619	java/lang/OutOfMemoryError
    //   750	756	619	java/lang/OutOfMemoryError
    //   173	183	785	finally
    //   183	195	791	finally
    //   278	337	791	finally
    //   352	368	791	finally
    //   173	183	795	java/lang/Exception
    //   183	195	801	java/lang/Exception
    //   278	337	801	java/lang/Exception
    //   352	368	801	java/lang/Exception
    //   159	173	806	java/lang/Exception
    //   159	173	815	finally
  }
  
  private RoundRectBitmap resizeAndClipBitmap(Bitmap paramBitmap)
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
        f3 = this.application.getResources().getDisplayMetrics().density;
        int m = this.application.getResources().getDisplayMetrics().densityDpi;
        j = aues.c;
        i = aues.a;
        n = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        Paint localPaint = new Paint(1);
        localPaint.setColor(-16777216);
        i1 = aues.e;
        int i2 = aues.f;
        if ((n >= i2) && (k >= i2)) {
          break label346;
        }
        if (n < k)
        {
          k = (int)(j / n * k + 0.5F);
          if (k <= i) {
            break label317;
          }
          Bitmap localBitmap = Bitmap.createBitmap(j, i, URLDrawableHelper.mThumbConfig);
          localBitmap.setDensity(m);
          new Canvas(localBitmap).drawBitmap(paramBitmap, null, new Rect(0, 0, j, i), localPaint);
          return new RoundRectBitmap(localBitmap, 14.0F * f3);
        }
        k = (int)(j / k * n + 0.5F);
        if (k <= i) {
          break label339;
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
      label317:
      int i = k;
      continue;
      for (;;)
      {
        k = i;
        i = j;
        j = k;
        break;
        label339:
        i = k;
      }
      label346:
      if ((n < i1) && (k < i1))
      {
        j = (int)(n * f3 + 0.5F);
        i = (int)(k * f3 + 0.5F);
      }
    }
  }
  
  int byte2Int(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[1] & 0xFF) << 8 | paramArrayOfByte[0] & 0xFF;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = AlbumThumbManager.getInstance(BaseApplicationImpl.getContext());
    paramURLDrawableHandler = parseUrl(paramDownloadParams.url);
    if (paramURLDrawableHandler == null) {
      paramFile = null;
    }
    label107:
    do
    {
      int i;
      do
      {
        return paramFile;
        if (auea.a(paramURLDrawableHandler.path) == 2) {}
        for (i = 1;; i = 0)
        {
          if ((!paramURLDrawableHandler.isRaw) || (paramURLDrawableHandler.isApkIcon) || (i != 0)) {
            break label107;
          }
          if (!paramURLDrawableHandler.isAIOFilePic) {
            break;
          }
          return internalDecodeAIOFilePic(paramDownloadParams, paramURLDrawableHandler);
        }
        paramDownloadParams = (Bitmap)internalDecodeFile(paramDownloadParams, paramURLDrawableHandler);
        paramFile = paramDownloadParams;
      } while (!paramURLDrawableHandler.isRound);
      return auea.a(this.application, paramDownloadParams, 16);
      if (paramURLDrawableHandler.isApkIcon)
      {
        paramFile = auds.a(this.application, paramURLDrawableHandler.path);
        if (paramFile != null) {
          paramFile = drawableToBitmap(paramFile);
        }
      }
      for (;;)
      {
        paramDownloadParams = paramFile;
        if (paramFile == null)
        {
          paramFile = BaseApplicationImpl.getContext();
          i = auea.a(paramURLDrawableHandler.path);
          paramDownloadParams = drawableToBitmap(paramFile.getResources().getDrawable(auea.a(i)));
        }
        if (paramDownloadParams != null) {
          break;
        }
        return null;
        paramFile = drawableToBitmap(BaseApplicationImpl.getContext().getResources().getDrawable(2130844229));
        continue;
        paramFile = paramFile.getThumb(paramDownloadParams.url, new FileAssistantDownloader.VideoBitmapCreator(this));
      }
      paramFile = paramDownloadParams;
    } while (!paramURLDrawableHandler.isRound);
    return auea.a(this.application, paramDownloadParams, 16);
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = parseUrl(paramDownloadParams.url);
    if ((paramOutputStream == null) || (paramOutputStream.path == null)) {
      return new File(AppConstants.SDCARD_ROOT);
    }
    return new File(paramOutputStream.path);
  }
  
  public Object internalDecodeAIOFilePic(DownloadParams paramDownloadParams, FileAssistantDownloader.PhotoInfo paramPhotoInfo)
  {
    paramDownloadParams = paramPhotoInfo.path;
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
        paramDownloadParams.inPreferredConfig = URLDrawableHelper.mThumbConfig;
        paramDownloadParams.inDensity = 160;
        paramDownloadParams.inTargetDensity = 160;
        paramDownloadParams.inScreenDensity = 160;
        paramDownloadParams.inJustDecodeBounds = false;
        paramPhotoInfo = SafeBitmapFactory.decodeFile(localFile.getAbsolutePath(), paramDownloadParams);
        paramDownloadParams = paramPhotoInfo;
        if (paramPhotoInfo == null) {
          continue;
        }
        paramDownloadParams = resizeAndClipBitmap(paramPhotoInfo);
        if (!paramPhotoInfo.equals(paramDownloadParams.mBitmap)) {
          paramPhotoInfo.recycle();
        }
        paramPhotoInfo = new RoundRectBitmap(new ExifBitmapCreator(localFile.getAbsolutePath()).creatBitmap(paramDownloadParams.mBitmap), paramDownloadParams.mCornerRadius, paramDownloadParams.mBoardColor, paramDownloadParams.mBorderWidth);
        paramDownloadParams = paramPhotoInfo;
        if (this.application == null) {
          continue;
        }
        paramPhotoInfo.mDisplayWidth = this.application.getResources().getDisplayMetrics().widthPixels;
        paramPhotoInfo.mDisplayHeight = this.application.getResources().getDisplayMetrics().heightPixels;
        return paramPhotoInfo;
      }
      catch (Exception paramDownloadParams)
      {
        throw paramDownloadParams;
      }
    }
  }
  
  public FileAssistantDownloader.PhotoInfo parseUrl(URL paramURL)
  {
    boolean bool2 = true;
    try
    {
      paramURL = paramURL.getFile().split("\\|");
      FileAssistantDownloader.PhotoInfo localPhotoInfo = new FileAssistantDownloader.PhotoInfo(this);
      localPhotoInfo.path = paramURL[0];
      localPhotoInfo.thumbWidth = Integer.parseInt(paramURL[1]);
      localPhotoInfo.thumbHeight = Integer.parseInt(paramURL[2]);
      localPhotoInfo.modifiedDate = Long.parseLong(paramURL[3]);
      if (paramURL.length > 4)
      {
        if (Integer.parseInt(paramURL[4]) == 1)
        {
          bool1 = true;
          localPhotoInfo.isRaw = bool1;
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
          localPhotoInfo.isRound = bool1;
        }
        if (paramURL.length > 6)
        {
          if (Integer.parseInt(paramURL[6]) != 1) {
            break label177;
          }
          bool1 = true;
          label132:
          localPhotoInfo.isApkIcon = bool1;
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
        localPhotoInfo.isAIOFilePic = bool1;
        return localPhotoInfo;
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
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileAssistantDownloader
 * JD-Core Version:    0.7.0.1
 */