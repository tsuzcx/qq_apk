package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBase;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.ImageTestUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ImageUtil
  extends BaseImageUtil
{
  public static Bitmap a(int paramInt)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    if ((paramInt != 0) && (paramInt != 2))
    {
      localObject1 = localObject3;
      if (paramInt == 1)
      {
        if (GlobalImageCache.a != null) {
          localObject2 = (Bitmap)GlobalImageCache.a.get("static://DefaultQQStoryFace");
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = c(BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130846695), 70, 70);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (GlobalImageCache.a != null)
            {
              GlobalImageCache.a.put("static://DefaultQQStoryFace", localObject2);
              return localObject2;
            }
          }
        }
      }
    }
    else
    {
      localObject2 = localObject1;
      if (GlobalImageCache.a != null) {
        localObject2 = (Bitmap)GlobalImageCache.a.get("static://DefaultQQStoryRoundFace");
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = c(BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130846695), 10.0F, 70, 70);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (GlobalImageCache.a != null)
          {
            GlobalImageCache.a.put("static://DefaultQQStoryRoundFace", localObject2);
            localObject1 = localObject2;
          }
        }
      }
    }
    return localObject1;
  }
  
  private static Bitmap a(int paramInt1, Context paramContext, File paramFile, int paramInt2, ImageInfo paramImageInfo)
  {
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    BitmapFactory.Options localOptions2 = a(localOptions1, paramFile.getPath(), paramInt2);
    if ((localOptions1.outWidth <= 960) && (localOptions1.outHeight <= 960)) {
      a("report_sendphoto_not_larger_960", paramContext, false);
    } else {
      a("report_sendphoto_not_larger_960", paramContext, true);
    }
    Object localObject2 = null;
    Object localObject1 = null;
    paramInt2 = 1;
    for (paramInt1 = 0; ((localObject1 == null) && (localOptions2.inSampleSize > 0) && (localOptions2.inSampleSize <= 4)) || (paramInt2 != 0); paramInt1 = 1)
    {
      for (;;)
      {
        if (paramInt2 == 0) {
          localOptions2.inSampleSize *= 2;
        }
        try
        {
          localObject1 = SafeBitmapFactory.decodeFile(paramFile.getPath(), localOptions2);
          paramInt2 = 0;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          label131:
          break label131;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("compress : compressNoLargePhoto  getBitmap  OOM ");
      ((StringBuilder)localObject1).append(localOptions2.inSampleSize);
      a(((StringBuilder)localObject1).toString());
      paramInt1 = localOptions1.outWidth * localOptions1.outHeight;
      if ((paramInt1 <= URLDrawableHelper.smallSize) && (paramInt1 > 0)) {
        ImageTestUtil.a(((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getCurrentAccountUin());
      }
      if (NetworkUtil.isWifiConnected(paramContext))
      {
        paramImageInfo.jdField_i_of_type_Int = 1;
        paramImageInfo.g = true;
        if (paramImageInfo.jdField_c_of_type_Int == 0)
        {
          paramImageInfo.jdField_h_of_type_Int = 2;
          if (QLog.isColorLevel()) {
            QLog.d("ImageUtil", 2, "WIFI oom ,c2c send srcfile by raw");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ImageUtil", 2, "WIFI oom ,not c2c send srcfile by nor");
        }
        paramInt1 = 1;
        localObject1 = localObject2;
        break;
      }
      localObject1 = null;
      paramInt2 = 0;
    }
    if ((localObject1 == null) && (paramInt1 != 0)) {
      paramImageInfo.g = true;
    }
    return localObject1;
  }
  
  public static Bitmap a(Bitmap paramBitmap, File paramFile)
  {
    Object localObject = null;
    if (paramBitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = Math.max(i, j);
    float f = a / (k * 1.0F);
    k = c(paramFile.getPath());
    if (f < 1.0F) {}
    try
    {
      localMatrix.postScale(f, f);
      if ((k != 0) && (k % 90 == 0)) {
        localMatrix.postRotate(k, i / 2.0F, j / 2.0F);
      }
      paramFile = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
    }
    catch (OutOfMemoryError paramFile)
    {
      label132:
      label167:
      break label121;
    }
    catch (Exception localException)
    {
      label121:
      break label132;
    }
    a("compress :  scaleBitmap OOM");
    paramFile = localObject;
    break label167;
    paramFile = new StringBuilder();
    paramFile.append("compress : ");
    paramFile.append(localMatrix.getMessage());
    a(paramFile.toString());
    paramFile = localObject;
    if (paramFile != null)
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!paramBitmap.equals(paramFile))) {
        paramBitmap.recycle();
      }
      return paramFile;
    }
    return paramBitmap;
  }
  
  public static Drawable a(int paramInt)
  {
    return new BitmapDrawable(a(paramInt));
  }
  
  private static void a(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean, String paramString)
  {
    a(paramInt1, paramInt2, paramContext, paramBoolean, null, paramString);
  }
  
  private static void a(int paramInt1, int paramInt2, Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    HashMap localHashMap;
    Object localObject;
    if ((paramInt1 >= 0) && (paramInt1 <= 7) && (paramInt2 >= 0))
    {
      if (paramInt2 > 9) {
        return;
      }
      localHashMap = null;
      localObject = localHashMap;
      if (paramContext != null) {
        localObject = localHashMap;
      }
    }
    try
    {
      if ((paramContext instanceof BaseActivity)) {
        localObject = ((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getCurrentAccountUin();
      }
      localHashMap = new HashMap();
      if (paramBoolean) {
        break label225;
      }
      String str = String.valueOf(paramInt2 * 10 + paramInt1 + 88100);
      localHashMap.put("param_FailCode", str);
      if (paramString2 != null) {
        break label204;
      }
      paramString2 = ProcessorReport.getExceptionMessage(new RuntimeException(str));
      if (!(paramContext instanceof Activity)) {
        break label207;
      }
      paramContext = ((Activity)paramContext).getCallingActivity();
      if (paramContext == null) {
        break label207;
      }
      localHashMap.put("param_callingActivity", paramContext.getClassName());
    }
    catch (Exception paramContext)
    {
      label152:
      label167:
      return;
    }
    localHashMap.put("param_sdCardSize", Long.toString(com.tencent.mobileqq.util.Utils.b()));
    localHashMap.put("param_failMsg", paramString2);
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String)localObject, paramContext, paramBoolean, 0L, 0L, localHashMap, "");
      return;
      label204:
      break;
      label207:
      if ((paramInt2 == 9) || (paramInt2 == 0)) {
        break label152;
      }
      if (paramInt2 != 5) {
        break label167;
      }
      break label152;
      label225:
      if (paramString1 == null) {
        paramContext = "report_sendphoto_file_error";
      } else {
        paramContext = paramString1;
      }
    }
  }
  
  /* Error */
  private static void a(int paramInt1, Context paramContext, File paramFile1, File paramFile2, ImageInfo paramImageInfo, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: new 95	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   7: astore 15
    //   9: aload 15
    //   11: ldc_w 308
    //   14: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 15
    //   20: iload 7
    //   22: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 15
    //   28: ldc_w 310
    //   31: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 15
    //   37: iload 6
    //   39: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 4
    //   45: ldc_w 312
    //   48: aload 15
    //   50: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   56: bipush 80
    //   58: istore 6
    //   60: iload 6
    //   62: istore 7
    //   64: iload 8
    //   66: ifeq +21 -> 87
    //   69: aload_1
    //   70: invokestatic 318	com/tencent/mobileqq/utils/NetworkUtil:isWifiEnabled	(Landroid/content/Context;)Z
    //   73: ifeq +10 -> 83
    //   76: iload 6
    //   78: istore 7
    //   80: goto +7 -> 87
    //   83: bipush 70
    //   85: istore 7
    //   87: aload 4
    //   89: getfield 150	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Int	I
    //   92: ifne +11 -> 103
    //   95: sipush 960
    //   98: istore 6
    //   100: goto +6 -> 106
    //   103: iconst_0
    //   104: istore 6
    //   106: aconst_null
    //   107: astore 20
    //   109: aconst_null
    //   110: astore 16
    //   112: aconst_null
    //   113: astore 22
    //   115: aconst_null
    //   116: astore 15
    //   118: aconst_null
    //   119: astore 23
    //   121: aconst_null
    //   122: astore 21
    //   124: iload_0
    //   125: aload_1
    //   126: aload_2
    //   127: iload 6
    //   129: aload 4
    //   131: invokestatic 320	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;ILcom/tencent/mobileqq/activity/photo/ImageInfo;)Landroid/graphics/Bitmap;
    //   134: astore 18
    //   136: aload 18
    //   138: ifnonnull +87 -> 225
    //   141: aload 22
    //   143: astore 15
    //   145: aload 18
    //   147: astore 17
    //   149: aload 23
    //   151: astore 16
    //   153: aload 18
    //   155: astore 19
    //   157: aload 4
    //   159: iconst_0
    //   160: putfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   163: aload 22
    //   165: astore 15
    //   167: aload 18
    //   169: astore 17
    //   171: aload 23
    //   173: astore 16
    //   175: aload 18
    //   177: astore 19
    //   179: aload_3
    //   180: invokevirtual 325	java/io/File:delete	()Z
    //   183: pop
    //   184: aload 22
    //   186: astore 15
    //   188: aload 18
    //   190: astore 17
    //   192: aload 23
    //   194: astore 16
    //   196: aload 18
    //   198: astore 19
    //   200: ldc_w 327
    //   203: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   206: aload 18
    //   208: ifnull +16 -> 224
    //   211: aload 18
    //   213: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   216: ifne +8 -> 224
    //   219: aload 18
    //   221: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   224: return
    //   225: aload 22
    //   227: astore 15
    //   229: aload 18
    //   231: astore 17
    //   233: aload 23
    //   235: astore 16
    //   237: aload 18
    //   239: astore 19
    //   241: aload 4
    //   243: iconst_1
    //   244: putfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   247: iload 9
    //   249: ifne +91 -> 340
    //   252: aload 22
    //   254: astore 15
    //   256: aload 18
    //   258: astore 17
    //   260: aload 23
    //   262: astore 16
    //   264: aload 18
    //   266: astore 19
    //   268: aload 18
    //   270: invokevirtual 176	android/graphics/Bitmap:getWidth	()I
    //   273: istore_0
    //   274: aload 22
    //   276: astore 15
    //   278: aload 18
    //   280: astore 17
    //   282: aload 23
    //   284: astore 16
    //   286: aload 18
    //   288: astore 19
    //   290: aload 18
    //   292: invokevirtual 179	android/graphics/Bitmap:getHeight	()I
    //   295: istore 10
    //   297: iload_0
    //   298: iload 6
    //   300: if_icmpgt +13 -> 313
    //   303: aload 18
    //   305: astore_1
    //   306: iload 10
    //   308: iload 6
    //   310: if_icmple +53 -> 363
    //   313: aload 22
    //   315: astore 15
    //   317: aload 18
    //   319: astore 17
    //   321: aload 23
    //   323: astore 16
    //   325: aload 18
    //   327: astore 19
    //   329: aload 18
    //   331: iload 6
    //   333: invokestatic 330	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   336: astore_1
    //   337: goto +26 -> 363
    //   340: aload 22
    //   342: astore 15
    //   344: aload 18
    //   346: astore 17
    //   348: aload 23
    //   350: astore 16
    //   352: aload 18
    //   354: astore 19
    //   356: aload 18
    //   358: aload_2
    //   359: invokestatic 332	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)Landroid/graphics/Bitmap;
    //   362: astore_1
    //   363: aload_1
    //   364: ifnonnull +64 -> 428
    //   367: aload 22
    //   369: astore 15
    //   371: aload_1
    //   372: astore 17
    //   374: aload 23
    //   376: astore 16
    //   378: aload_1
    //   379: astore 19
    //   381: aload 4
    //   383: ldc_w 312
    //   386: ldc_w 334
    //   389: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload 22
    //   394: astore 15
    //   396: aload_1
    //   397: astore 17
    //   399: aload 23
    //   401: astore 16
    //   403: aload_1
    //   404: astore 19
    //   406: aload 4
    //   408: iconst_1
    //   409: putfield 337	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   412: aload_1
    //   413: ifnull +14 -> 427
    //   416: aload_1
    //   417: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   420: ifne +7 -> 427
    //   423: aload_1
    //   424: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   427: return
    //   428: aload 21
    //   430: astore 16
    //   432: new 339	java/io/FileOutputStream
    //   435: dup
    //   436: aload_3
    //   437: invokespecial 342	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   440: astore 15
    //   442: aload 4
    //   444: aload_1
    //   445: getstatic 348	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   448: iload 7
    //   450: aload 15
    //   452: invokevirtual 351	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   455: putfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   458: aload 4
    //   460: iconst_1
    //   461: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   464: aload 4
    //   466: getfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   469: ifeq +8 -> 477
    //   472: aload 15
    //   474: invokestatic 360	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/FileOutputStream;)V
    //   477: new 95	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   484: astore 16
    //   486: aload 16
    //   488: ldc_w 362
    //   491: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 16
    //   497: aload 4
    //   499: getfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   502: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 16
    //   508: ldc_w 367
    //   511: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 16
    //   517: aload_3
    //   518: invokevirtual 370	java/io/File:length	()J
    //   521: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload 16
    //   527: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   533: aload 15
    //   535: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   538: goto +14 -> 552
    //   541: astore_2
    //   542: goto +1783 -> 2325
    //   545: aload 15
    //   547: astore 16
    //   549: goto +1704 -> 2253
    //   552: aload 15
    //   554: astore 18
    //   556: goto +88 -> 644
    //   559: astore_3
    //   560: aload 15
    //   562: astore_2
    //   563: goto +1648 -> 2211
    //   566: aload 15
    //   568: astore 20
    //   570: goto +10 -> 580
    //   573: astore_3
    //   574: aload 16
    //   576: astore_2
    //   577: goto +1634 -> 2211
    //   580: aload 20
    //   582: astore 16
    //   584: aload 4
    //   586: iconst_0
    //   587: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   590: aload 20
    //   592: astore 16
    //   594: aload 4
    //   596: invokestatic 378	com/tencent/mobileqq/utils/ImageUtil:a	()Z
    //   599: putfield 381	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   602: aload 20
    //   604: astore 16
    //   606: ldc_w 383
    //   609: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   612: aload 20
    //   614: astore 18
    //   616: aload 20
    //   618: ifnull +26 -> 644
    //   621: aload 20
    //   623: astore 15
    //   625: aload_1
    //   626: astore 17
    //   628: aload 20
    //   630: astore 16
    //   632: aload_1
    //   633: astore 19
    //   635: aload 20
    //   637: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   640: aload 20
    //   642: astore 18
    //   644: iload 5
    //   646: iconst_1
    //   647: if_icmpeq +34 -> 681
    //   650: iload 5
    //   652: sipush 1001
    //   655: if_icmpeq +26 -> 681
    //   658: iload 5
    //   660: sipush 10002
    //   663: if_icmpeq +18 -> 681
    //   666: aload 18
    //   668: astore 23
    //   670: aload_1
    //   671: astore 22
    //   673: iload 5
    //   675: sipush 3000
    //   678: if_icmpne +1338 -> 2016
    //   681: iload 5
    //   683: sipush 1001
    //   686: if_icmpeq +47 -> 733
    //   689: iload 5
    //   691: sipush 10002
    //   694: if_icmpne +6 -> 700
    //   697: goto +36 -> 733
    //   700: aload 18
    //   702: astore 15
    //   704: aload_1
    //   705: astore 17
    //   707: aload 18
    //   709: astore 16
    //   711: aload_1
    //   712: astore 19
    //   714: ldc_w 385
    //   717: invokestatic 391	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   720: checkcast 385	com/tencent/mobileqq/pic/api/IPicBus
    //   723: invokeinterface 394 1 0
    //   728: lstore 11
    //   730: goto +23 -> 753
    //   733: aload 18
    //   735: astore 15
    //   737: aload_1
    //   738: astore 17
    //   740: aload 18
    //   742: astore 16
    //   744: aload_1
    //   745: astore 19
    //   747: getstatic 397	com/tencent/common/config/AppSetting:jdField_c_of_type_Int	I
    //   750: i2l
    //   751: lstore 11
    //   753: lload 11
    //   755: l2i
    //   756: istore_0
    //   757: aload 18
    //   759: astore 15
    //   761: aload_1
    //   762: astore 17
    //   764: aload 18
    //   766: astore 16
    //   768: aload_1
    //   769: astore 19
    //   771: new 95	java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   778: astore 20
    //   780: aload 18
    //   782: astore 15
    //   784: aload_1
    //   785: astore 17
    //   787: aload 18
    //   789: astore 16
    //   791: aload_1
    //   792: astore 19
    //   794: aload 20
    //   796: ldc_w 399
    //   799: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload 18
    //   805: astore 15
    //   807: aload_1
    //   808: astore 17
    //   810: aload 18
    //   812: astore 16
    //   814: aload_1
    //   815: astore 19
    //   817: aload 20
    //   819: iload_0
    //   820: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload 18
    //   826: astore 15
    //   828: aload_1
    //   829: astore 17
    //   831: aload 18
    //   833: astore 16
    //   835: aload_1
    //   836: astore 19
    //   838: aload 20
    //   840: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   846: aload 18
    //   848: astore 15
    //   850: aload_1
    //   851: astore 17
    //   853: aload 18
    //   855: astore 16
    //   857: aload_1
    //   858: astore 19
    //   860: new 95	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   867: astore 20
    //   869: aload 18
    //   871: astore 15
    //   873: aload_1
    //   874: astore 17
    //   876: aload 18
    //   878: astore 16
    //   880: aload_1
    //   881: astore 19
    //   883: aload 20
    //   885: ldc_w 401
    //   888: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload 18
    //   894: astore 15
    //   896: aload_1
    //   897: astore 17
    //   899: aload 18
    //   901: astore 16
    //   903: aload_1
    //   904: astore 19
    //   906: aload 20
    //   908: aload_3
    //   909: invokevirtual 370	java/io/File:length	()J
    //   912: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   915: pop
    //   916: aload 18
    //   918: astore 15
    //   920: aload_1
    //   921: astore 17
    //   923: aload 18
    //   925: astore 16
    //   927: aload_1
    //   928: astore 19
    //   930: aload 20
    //   932: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   935: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   938: aload 18
    //   940: astore 16
    //   942: aload_1
    //   943: astore 15
    //   945: aload 18
    //   947: astore 19
    //   949: aload_1
    //   950: astore 17
    //   952: aload_3
    //   953: invokevirtual 370	java/io/File:length	()J
    //   956: lstore 11
    //   958: iload_0
    //   959: i2l
    //   960: lstore 13
    //   962: aload 18
    //   964: astore 20
    //   966: aload_1
    //   967: astore 21
    //   969: lload 11
    //   971: lload 13
    //   973: lcmp
    //   974: ifle +642 -> 1616
    //   977: aload 18
    //   979: astore 20
    //   981: aload_1
    //   982: astore 21
    //   984: aload 18
    //   986: astore 16
    //   988: aload_1
    //   989: astore 15
    //   991: aload 18
    //   993: astore 19
    //   995: aload_1
    //   996: astore 17
    //   998: aload_2
    //   999: invokestatic 407	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   1002: ifne +614 -> 1616
    //   1005: aload 18
    //   1007: astore 16
    //   1009: aload_1
    //   1010: astore 15
    //   1012: aload 18
    //   1014: astore 19
    //   1016: aload_1
    //   1017: astore 17
    //   1019: aload 4
    //   1021: ldc_w 312
    //   1024: ldc_w 409
    //   1027: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1030: aload 18
    //   1032: astore 20
    //   1034: aload_1
    //   1035: astore 21
    //   1037: aload 18
    //   1039: astore 16
    //   1041: aload_1
    //   1042: astore 15
    //   1044: aload 18
    //   1046: astore 19
    //   1048: aload_1
    //   1049: astore 17
    //   1051: aload_3
    //   1052: invokevirtual 325	java/io/File:delete	()Z
    //   1055: ifeq +561 -> 1616
    //   1058: aload 18
    //   1060: astore 20
    //   1062: aload_1
    //   1063: astore 21
    //   1065: aload 18
    //   1067: astore 16
    //   1069: aload_1
    //   1070: astore 15
    //   1072: aload 18
    //   1074: astore 19
    //   1076: aload_1
    //   1077: astore 17
    //   1079: aload_3
    //   1080: invokevirtual 412	java/io/File:createNewFile	()Z
    //   1083: ifeq +533 -> 1616
    //   1086: iconst_1
    //   1087: istore 5
    //   1089: iload 6
    //   1091: istore_0
    //   1092: iload 5
    //   1094: iconst_1
    //   1095: iadd
    //   1096: istore 6
    //   1098: iload 5
    //   1100: iconst_4
    //   1101: if_icmpge +470 -> 1571
    //   1104: aload 18
    //   1106: astore 16
    //   1108: aload_1
    //   1109: astore 15
    //   1111: aload 18
    //   1113: astore 19
    //   1115: aload_1
    //   1116: astore 17
    //   1118: aload_3
    //   1119: invokevirtual 370	java/io/File:length	()J
    //   1122: lload 13
    //   1124: lcmp
    //   1125: ifle +446 -> 1571
    //   1128: aload 18
    //   1130: astore 16
    //   1132: aload_1
    //   1133: astore 15
    //   1135: aload 18
    //   1137: astore 19
    //   1139: aload_1
    //   1140: astore 17
    //   1142: new 95	java/lang/StringBuilder
    //   1145: dup
    //   1146: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1149: astore_2
    //   1150: aload 18
    //   1152: astore 16
    //   1154: aload_1
    //   1155: astore 15
    //   1157: aload 18
    //   1159: astore 19
    //   1161: aload_1
    //   1162: astore 17
    //   1164: aload_2
    //   1165: ldc_w 414
    //   1168: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: pop
    //   1172: aload 18
    //   1174: astore 16
    //   1176: aload_1
    //   1177: astore 15
    //   1179: aload 18
    //   1181: astore 19
    //   1183: aload_1
    //   1184: astore 17
    //   1186: aload_2
    //   1187: iload 6
    //   1189: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1192: pop
    //   1193: aload 18
    //   1195: astore 16
    //   1197: aload_1
    //   1198: astore 15
    //   1200: aload 18
    //   1202: astore 19
    //   1204: aload_1
    //   1205: astore 17
    //   1207: aload_2
    //   1208: ldc_w 416
    //   1211: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: pop
    //   1215: aload 18
    //   1217: astore 16
    //   1219: aload_1
    //   1220: astore 15
    //   1222: aload 18
    //   1224: astore 19
    //   1226: aload_1
    //   1227: astore 17
    //   1229: aload_2
    //   1230: aload_3
    //   1231: invokevirtual 370	java/io/File:length	()J
    //   1234: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1237: pop
    //   1238: aload 18
    //   1240: astore 16
    //   1242: aload_1
    //   1243: astore 15
    //   1245: aload 18
    //   1247: astore 19
    //   1249: aload_1
    //   1250: astore 17
    //   1252: aload_2
    //   1253: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1256: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1259: iload_0
    //   1260: iconst_1
    //   1261: ishr
    //   1262: istore_0
    //   1263: iload_0
    //   1264: ifne +1171 -> 2435
    //   1267: iconst_1
    //   1268: istore_0
    //   1269: goto +3 -> 1272
    //   1272: aload 18
    //   1274: astore 16
    //   1276: aload_1
    //   1277: astore 15
    //   1279: aload 18
    //   1281: astore 19
    //   1283: aload_1
    //   1284: astore 17
    //   1286: aload_1
    //   1287: iload_0
    //   1288: invokestatic 330	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   1291: astore_1
    //   1292: aload_1
    //   1293: ifnonnull +211 -> 1504
    //   1296: aload 18
    //   1298: astore 16
    //   1300: aload_1
    //   1301: astore 15
    //   1303: aload 18
    //   1305: astore 19
    //   1307: aload_1
    //   1308: astore 17
    //   1310: aload 4
    //   1312: iconst_1
    //   1313: putfield 337	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   1316: aload 18
    //   1318: ifnull +114 -> 1432
    //   1321: aload 18
    //   1323: astore 15
    //   1325: aload_1
    //   1326: astore 17
    //   1328: aload 18
    //   1330: astore 16
    //   1332: aload_1
    //   1333: astore 19
    //   1335: aload 18
    //   1337: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   1340: goto +92 -> 1432
    //   1343: astore_2
    //   1344: aload 18
    //   1346: astore 15
    //   1348: aload_1
    //   1349: astore 17
    //   1351: aload 18
    //   1353: astore 16
    //   1355: aload_1
    //   1356: astore 19
    //   1358: new 95	java/lang/StringBuilder
    //   1361: dup
    //   1362: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1365: astore_3
    //   1366: aload 18
    //   1368: astore 15
    //   1370: aload_1
    //   1371: astore 17
    //   1373: aload 18
    //   1375: astore 16
    //   1377: aload_1
    //   1378: astore 19
    //   1380: aload_3
    //   1381: ldc_w 418
    //   1384: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: pop
    //   1388: aload 18
    //   1390: astore 15
    //   1392: aload_1
    //   1393: astore 17
    //   1395: aload 18
    //   1397: astore 16
    //   1399: aload_1
    //   1400: astore 19
    //   1402: aload_3
    //   1403: aload_2
    //   1404: invokevirtual 419	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1407: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: pop
    //   1411: aload 18
    //   1413: astore 15
    //   1415: aload_1
    //   1416: astore 17
    //   1418: aload 18
    //   1420: astore 16
    //   1422: aload_1
    //   1423: astore 19
    //   1425: aload_3
    //   1426: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1429: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1432: aload_1
    //   1433: ifnull +42 -> 1475
    //   1436: aload 18
    //   1438: astore 15
    //   1440: aload_1
    //   1441: astore 17
    //   1443: aload 18
    //   1445: astore 16
    //   1447: aload_1
    //   1448: astore 19
    //   1450: aload_1
    //   1451: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   1454: ifne +21 -> 1475
    //   1457: aload 18
    //   1459: astore 15
    //   1461: aload_1
    //   1462: astore 17
    //   1464: aload 18
    //   1466: astore 16
    //   1468: aload_1
    //   1469: astore 19
    //   1471: aload_1
    //   1472: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   1475: aload 18
    //   1477: ifnull +11 -> 1488
    //   1480: aload 18
    //   1482: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   1485: goto +3 -> 1488
    //   1488: aload_1
    //   1489: ifnull +14 -> 1503
    //   1492: aload_1
    //   1493: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   1496: ifne +7 -> 1503
    //   1499: aload_1
    //   1500: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   1503: return
    //   1504: aload 18
    //   1506: astore 16
    //   1508: aload_1
    //   1509: astore 15
    //   1511: aload 18
    //   1513: astore 19
    //   1515: aload_1
    //   1516: astore 17
    //   1518: new 339	java/io/FileOutputStream
    //   1521: dup
    //   1522: aload_3
    //   1523: invokespecial 342	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1526: astore_2
    //   1527: aload 4
    //   1529: aload_1
    //   1530: getstatic 348	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1533: iload 7
    //   1535: aload_2
    //   1536: invokevirtual 351	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   1539: putfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   1542: aload 4
    //   1544: getfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   1547: ifeq +7 -> 1554
    //   1550: aload_2
    //   1551: invokestatic 360	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/FileOutputStream;)V
    //   1554: iload 6
    //   1556: istore 5
    //   1558: aload_2
    //   1559: astore 18
    //   1561: goto -469 -> 1092
    //   1564: astore_3
    //   1565: goto +483 -> 2048
    //   1568: goto +260 -> 1828
    //   1571: aload 18
    //   1573: astore 20
    //   1575: aload_1
    //   1576: astore 21
    //   1578: iload 6
    //   1580: iconst_4
    //   1581: if_icmplt +35 -> 1616
    //   1584: aload 18
    //   1586: astore 16
    //   1588: aload_1
    //   1589: astore 15
    //   1591: aload 18
    //   1593: astore 19
    //   1595: aload_1
    //   1596: astore 17
    //   1598: aload 4
    //   1600: ldc_w 312
    //   1603: ldc_w 421
    //   1606: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1609: aload_1
    //   1610: astore 21
    //   1612: aload 18
    //   1614: astore 20
    //   1616: aload 20
    //   1618: ifnull +124 -> 1742
    //   1621: aload 20
    //   1623: astore 15
    //   1625: aload 21
    //   1627: astore 17
    //   1629: aload 20
    //   1631: astore 16
    //   1633: aload 21
    //   1635: astore 19
    //   1637: aload 20
    //   1639: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   1642: goto +100 -> 1742
    //   1645: astore_1
    //   1646: aload 20
    //   1648: astore 15
    //   1650: aload 21
    //   1652: astore 17
    //   1654: aload 20
    //   1656: astore 16
    //   1658: aload 21
    //   1660: astore 19
    //   1662: new 95	java/lang/StringBuilder
    //   1665: dup
    //   1666: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1669: astore_2
    //   1670: aload 20
    //   1672: astore 15
    //   1674: aload 21
    //   1676: astore 17
    //   1678: aload 20
    //   1680: astore 16
    //   1682: aload 21
    //   1684: astore 19
    //   1686: aload_2
    //   1687: ldc_w 418
    //   1690: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1693: pop
    //   1694: aload 20
    //   1696: astore 15
    //   1698: aload 21
    //   1700: astore 17
    //   1702: aload 20
    //   1704: astore 16
    //   1706: aload 21
    //   1708: astore 19
    //   1710: aload_2
    //   1711: aload_1
    //   1712: invokevirtual 419	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1715: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1718: pop
    //   1719: aload 20
    //   1721: astore 15
    //   1723: aload 21
    //   1725: astore 17
    //   1727: aload 20
    //   1729: astore 16
    //   1731: aload 21
    //   1733: astore 19
    //   1735: aload_2
    //   1736: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1739: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1742: aload 20
    //   1744: astore 23
    //   1746: aload 21
    //   1748: astore 22
    //   1750: aload 21
    //   1752: ifnull +264 -> 2016
    //   1755: aload 20
    //   1757: astore 23
    //   1759: aload 21
    //   1761: astore 22
    //   1763: aload 20
    //   1765: astore 15
    //   1767: aload 21
    //   1769: astore 17
    //   1771: aload 20
    //   1773: astore 16
    //   1775: aload 21
    //   1777: astore 19
    //   1779: aload 21
    //   1781: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   1784: ifne +232 -> 2016
    //   1787: aload 21
    //   1789: astore_1
    //   1790: aload 20
    //   1792: astore_2
    //   1793: aload_2
    //   1794: astore 15
    //   1796: aload_1
    //   1797: astore 17
    //   1799: aload_2
    //   1800: astore 16
    //   1802: aload_1
    //   1803: astore 19
    //   1805: aload_1
    //   1806: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   1809: aload_2
    //   1810: astore 23
    //   1812: aload_1
    //   1813: astore 22
    //   1815: goto +201 -> 2016
    //   1818: astore_3
    //   1819: aload 16
    //   1821: astore_2
    //   1822: aload 15
    //   1824: astore_1
    //   1825: goto +223 -> 2048
    //   1828: aload_2
    //   1829: astore 16
    //   1831: aload_1
    //   1832: astore 15
    //   1834: aload 4
    //   1836: iconst_0
    //   1837: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1840: aload_2
    //   1841: astore 16
    //   1843: aload_1
    //   1844: astore 15
    //   1846: aload 4
    //   1848: invokestatic 378	com/tencent/mobileqq/utils/ImageUtil:a	()Z
    //   1851: putfield 381	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1854: aload_2
    //   1855: astore 16
    //   1857: aload_1
    //   1858: astore 15
    //   1860: ldc_w 423
    //   1863: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1866: aload_2
    //   1867: ifnull +107 -> 1974
    //   1870: aload_2
    //   1871: astore 15
    //   1873: aload_1
    //   1874: astore 17
    //   1876: aload_2
    //   1877: astore 16
    //   1879: aload_1
    //   1880: astore 19
    //   1882: aload_2
    //   1883: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   1886: goto +88 -> 1974
    //   1889: astore_3
    //   1890: aload_2
    //   1891: astore 15
    //   1893: aload_1
    //   1894: astore 17
    //   1896: aload_2
    //   1897: astore 16
    //   1899: aload_1
    //   1900: astore 19
    //   1902: new 95	java/lang/StringBuilder
    //   1905: dup
    //   1906: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1909: astore 18
    //   1911: aload_2
    //   1912: astore 15
    //   1914: aload_1
    //   1915: astore 17
    //   1917: aload_2
    //   1918: astore 16
    //   1920: aload_1
    //   1921: astore 19
    //   1923: aload 18
    //   1925: ldc_w 418
    //   1928: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1931: pop
    //   1932: aload_2
    //   1933: astore 15
    //   1935: aload_1
    //   1936: astore 17
    //   1938: aload_2
    //   1939: astore 16
    //   1941: aload_1
    //   1942: astore 19
    //   1944: aload 18
    //   1946: aload_3
    //   1947: invokevirtual 419	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1950: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: pop
    //   1954: aload_2
    //   1955: astore 15
    //   1957: aload_1
    //   1958: astore 17
    //   1960: aload_2
    //   1961: astore 16
    //   1963: aload_1
    //   1964: astore 19
    //   1966: aload 18
    //   1968: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1971: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1974: aload_2
    //   1975: astore 23
    //   1977: aload_1
    //   1978: astore 22
    //   1980: aload_1
    //   1981: ifnull +35 -> 2016
    //   1984: aload_2
    //   1985: astore 15
    //   1987: aload_1
    //   1988: astore 17
    //   1990: aload_2
    //   1991: astore 16
    //   1993: aload_1
    //   1994: astore 19
    //   1996: aload_1
    //   1997: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   2000: istore 8
    //   2002: aload_2
    //   2003: astore 23
    //   2005: aload_1
    //   2006: astore 22
    //   2008: iload 8
    //   2010: ifne +6 -> 2016
    //   2013: goto -220 -> 1793
    //   2016: aload 23
    //   2018: ifnull +11 -> 2029
    //   2021: aload 23
    //   2023: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   2026: goto +3 -> 2029
    //   2029: aload 22
    //   2031: ifnull +289 -> 2320
    //   2034: aload 22
    //   2036: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   2039: ifne +281 -> 2320
    //   2042: aload 22
    //   2044: astore_1
    //   2045: goto +271 -> 2316
    //   2048: aload_2
    //   2049: ifnull +109 -> 2158
    //   2052: aload_2
    //   2053: astore 15
    //   2055: aload_1
    //   2056: astore 17
    //   2058: aload_2
    //   2059: astore 16
    //   2061: aload_1
    //   2062: astore 19
    //   2064: aload_2
    //   2065: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   2068: goto +90 -> 2158
    //   2071: astore 18
    //   2073: aload_2
    //   2074: astore 15
    //   2076: aload_1
    //   2077: astore 17
    //   2079: aload_2
    //   2080: astore 16
    //   2082: aload_1
    //   2083: astore 19
    //   2085: new 95	java/lang/StringBuilder
    //   2088: dup
    //   2089: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2092: astore 20
    //   2094: aload_2
    //   2095: astore 15
    //   2097: aload_1
    //   2098: astore 17
    //   2100: aload_2
    //   2101: astore 16
    //   2103: aload_1
    //   2104: astore 19
    //   2106: aload 20
    //   2108: ldc_w 418
    //   2111: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2114: pop
    //   2115: aload_2
    //   2116: astore 15
    //   2118: aload_1
    //   2119: astore 17
    //   2121: aload_2
    //   2122: astore 16
    //   2124: aload_1
    //   2125: astore 19
    //   2127: aload 20
    //   2129: aload 18
    //   2131: invokevirtual 419	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2134: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2137: pop
    //   2138: aload_2
    //   2139: astore 15
    //   2141: aload_1
    //   2142: astore 17
    //   2144: aload_2
    //   2145: astore 16
    //   2147: aload_1
    //   2148: astore 19
    //   2150: aload 20
    //   2152: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2155: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2158: aload_1
    //   2159: ifnull +38 -> 2197
    //   2162: aload_2
    //   2163: astore 15
    //   2165: aload_1
    //   2166: astore 17
    //   2168: aload_2
    //   2169: astore 16
    //   2171: aload_1
    //   2172: astore 19
    //   2174: aload_1
    //   2175: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   2178: ifne +19 -> 2197
    //   2181: aload_2
    //   2182: astore 15
    //   2184: aload_1
    //   2185: astore 17
    //   2187: aload_2
    //   2188: astore 16
    //   2190: aload_1
    //   2191: astore 19
    //   2193: aload_1
    //   2194: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   2197: aload_2
    //   2198: astore 15
    //   2200: aload_1
    //   2201: astore 17
    //   2203: aload_2
    //   2204: astore 16
    //   2206: aload_1
    //   2207: astore 19
    //   2209: aload_3
    //   2210: athrow
    //   2211: aload_2
    //   2212: ifnull +19 -> 2231
    //   2215: aload_2
    //   2216: astore 15
    //   2218: aload_1
    //   2219: astore 17
    //   2221: aload_2
    //   2222: astore 16
    //   2224: aload_1
    //   2225: astore 19
    //   2227: aload_2
    //   2228: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   2231: aload_2
    //   2232: astore 15
    //   2234: aload_1
    //   2235: astore 17
    //   2237: aload_2
    //   2238: astore 16
    //   2240: aload_1
    //   2241: astore 19
    //   2243: aload_3
    //   2244: athrow
    //   2245: astore_2
    //   2246: aconst_null
    //   2247: astore_1
    //   2248: goto +77 -> 2325
    //   2251: aconst_null
    //   2252: astore_1
    //   2253: aload 16
    //   2255: astore 15
    //   2257: aload_1
    //   2258: astore 17
    //   2260: aload 4
    //   2262: iconst_0
    //   2263: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   2266: aload 16
    //   2268: astore 15
    //   2270: aload_1
    //   2271: astore 17
    //   2273: aload 4
    //   2275: iconst_1
    //   2276: putfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   2279: aload 16
    //   2281: astore 15
    //   2283: aload_1
    //   2284: astore 17
    //   2286: ldc_w 425
    //   2289: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2292: aload 16
    //   2294: ifnull +11 -> 2305
    //   2297: aload 16
    //   2299: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   2302: goto +3 -> 2305
    //   2305: aload_1
    //   2306: ifnull +14 -> 2320
    //   2309: aload_1
    //   2310: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   2313: ifne +7 -> 2320
    //   2316: aload_1
    //   2317: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   2320: return
    //   2321: astore_2
    //   2322: aload 17
    //   2324: astore_1
    //   2325: aload 15
    //   2327: ifnull +11 -> 2338
    //   2330: aload 15
    //   2332: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   2335: goto +3 -> 2338
    //   2338: aload_1
    //   2339: ifnull +14 -> 2353
    //   2342: aload_1
    //   2343: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   2346: ifne +7 -> 2353
    //   2349: aload_1
    //   2350: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   2353: goto +5 -> 2358
    //   2356: aload_2
    //   2357: athrow
    //   2358: goto -2 -> 2356
    //   2361: astore_1
    //   2362: goto -111 -> 2251
    //   2365: astore_1
    //   2366: aload 19
    //   2368: astore_1
    //   2369: goto -116 -> 2253
    //   2372: astore 15
    //   2374: goto -1794 -> 580
    //   2377: astore 16
    //   2379: goto -1813 -> 566
    //   2382: astore 16
    //   2384: goto -1832 -> 552
    //   2387: astore_2
    //   2388: goto -1843 -> 545
    //   2391: astore 15
    //   2393: aload 20
    //   2395: astore 18
    //   2397: goto -1753 -> 644
    //   2400: astore_1
    //   2401: aload 19
    //   2403: astore_2
    //   2404: aload 17
    //   2406: astore_1
    //   2407: goto -579 -> 1828
    //   2410: astore_2
    //   2411: goto -923 -> 1488
    //   2414: astore_3
    //   2415: goto -847 -> 1568
    //   2418: astore_1
    //   2419: goto -390 -> 2029
    //   2422: astore 15
    //   2424: goto -193 -> 2231
    //   2427: astore_2
    //   2428: goto -123 -> 2305
    //   2431: astore_3
    //   2432: goto -94 -> 2338
    //   2435: goto -1163 -> 1272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2438	0	paramInt1	int
    //   0	2438	1	paramContext	Context
    //   0	2438	2	paramFile1	File
    //   0	2438	3	paramFile2	File
    //   0	2438	4	paramImageInfo	ImageInfo
    //   0	2438	5	paramInt2	int
    //   0	2438	6	paramInt3	int
    //   0	2438	7	paramInt4	int
    //   0	2438	8	paramBoolean1	boolean
    //   0	2438	9	paramBoolean2	boolean
    //   295	16	10	i	int
    //   728	242	11	l1	long
    //   960	163	13	l2	long
    //   7	2324	15	localObject1	Object
    //   2372	1	15	localIOException1	java.io.IOException
    //   2391	1	15	localIOException2	java.io.IOException
    //   2422	1	15	localIOException3	java.io.IOException
    //   110	2188	16	localObject2	Object
    //   2377	1	16	localIOException4	java.io.IOException
    //   2382	1	16	localIOException5	java.io.IOException
    //   147	2258	17	localObject3	Object
    //   134	1833	18	localObject4	Object
    //   2071	59	18	localIOException6	java.io.IOException
    //   2395	1	18	localObject5	Object
    //   155	2247	19	localObject6	Object
    //   107	2287	20	localObject7	Object
    //   122	1666	21	localContext	Context
    //   113	1930	22	localObject8	Object
    //   119	1903	23	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   533	538	541	finally
    //   442	477	559	finally
    //   477	533	559	finally
    //   432	442	573	finally
    //   584	590	573	finally
    //   594	602	573	finally
    //   606	612	573	finally
    //   1335	1340	1343	java/io/IOException
    //   1527	1554	1564	finally
    //   1637	1642	1645	java/io/IOException
    //   952	958	1818	finally
    //   998	1005	1818	finally
    //   1019	1030	1818	finally
    //   1051	1058	1818	finally
    //   1079	1086	1818	finally
    //   1118	1128	1818	finally
    //   1142	1150	1818	finally
    //   1164	1172	1818	finally
    //   1186	1193	1818	finally
    //   1207	1215	1818	finally
    //   1229	1238	1818	finally
    //   1252	1259	1818	finally
    //   1286	1292	1818	finally
    //   1310	1316	1818	finally
    //   1518	1527	1818	finally
    //   1598	1609	1818	finally
    //   1834	1840	1818	finally
    //   1846	1854	1818	finally
    //   1860	1866	1818	finally
    //   1882	1886	1889	java/io/IOException
    //   2064	2068	2071	java/io/IOException
    //   124	136	2245	finally
    //   157	163	2321	finally
    //   179	184	2321	finally
    //   200	206	2321	finally
    //   241	247	2321	finally
    //   268	274	2321	finally
    //   290	297	2321	finally
    //   329	337	2321	finally
    //   356	363	2321	finally
    //   381	392	2321	finally
    //   406	412	2321	finally
    //   635	640	2321	finally
    //   714	730	2321	finally
    //   747	753	2321	finally
    //   771	780	2321	finally
    //   794	803	2321	finally
    //   817	824	2321	finally
    //   838	846	2321	finally
    //   860	869	2321	finally
    //   883	892	2321	finally
    //   906	916	2321	finally
    //   930	938	2321	finally
    //   1335	1340	2321	finally
    //   1358	1366	2321	finally
    //   1380	1388	2321	finally
    //   1402	1411	2321	finally
    //   1425	1432	2321	finally
    //   1450	1457	2321	finally
    //   1471	1475	2321	finally
    //   1637	1642	2321	finally
    //   1662	1670	2321	finally
    //   1686	1694	2321	finally
    //   1710	1719	2321	finally
    //   1735	1742	2321	finally
    //   1779	1787	2321	finally
    //   1805	1809	2321	finally
    //   1882	1886	2321	finally
    //   1902	1911	2321	finally
    //   1923	1932	2321	finally
    //   1944	1954	2321	finally
    //   1966	1974	2321	finally
    //   1996	2002	2321	finally
    //   2064	2068	2321	finally
    //   2085	2094	2321	finally
    //   2106	2115	2321	finally
    //   2127	2138	2321	finally
    //   2150	2158	2321	finally
    //   2174	2181	2321	finally
    //   2193	2197	2321	finally
    //   2209	2211	2321	finally
    //   2227	2231	2321	finally
    //   2243	2245	2321	finally
    //   2260	2266	2321	finally
    //   2273	2279	2321	finally
    //   2286	2292	2321	finally
    //   124	136	2361	java/lang/OutOfMemoryError
    //   157	163	2365	java/lang/OutOfMemoryError
    //   179	184	2365	java/lang/OutOfMemoryError
    //   200	206	2365	java/lang/OutOfMemoryError
    //   241	247	2365	java/lang/OutOfMemoryError
    //   268	274	2365	java/lang/OutOfMemoryError
    //   290	297	2365	java/lang/OutOfMemoryError
    //   329	337	2365	java/lang/OutOfMemoryError
    //   356	363	2365	java/lang/OutOfMemoryError
    //   381	392	2365	java/lang/OutOfMemoryError
    //   406	412	2365	java/lang/OutOfMemoryError
    //   635	640	2365	java/lang/OutOfMemoryError
    //   714	730	2365	java/lang/OutOfMemoryError
    //   747	753	2365	java/lang/OutOfMemoryError
    //   771	780	2365	java/lang/OutOfMemoryError
    //   794	803	2365	java/lang/OutOfMemoryError
    //   817	824	2365	java/lang/OutOfMemoryError
    //   838	846	2365	java/lang/OutOfMemoryError
    //   860	869	2365	java/lang/OutOfMemoryError
    //   883	892	2365	java/lang/OutOfMemoryError
    //   906	916	2365	java/lang/OutOfMemoryError
    //   930	938	2365	java/lang/OutOfMemoryError
    //   1335	1340	2365	java/lang/OutOfMemoryError
    //   1358	1366	2365	java/lang/OutOfMemoryError
    //   1380	1388	2365	java/lang/OutOfMemoryError
    //   1402	1411	2365	java/lang/OutOfMemoryError
    //   1425	1432	2365	java/lang/OutOfMemoryError
    //   1450	1457	2365	java/lang/OutOfMemoryError
    //   1471	1475	2365	java/lang/OutOfMemoryError
    //   1637	1642	2365	java/lang/OutOfMemoryError
    //   1662	1670	2365	java/lang/OutOfMemoryError
    //   1686	1694	2365	java/lang/OutOfMemoryError
    //   1710	1719	2365	java/lang/OutOfMemoryError
    //   1735	1742	2365	java/lang/OutOfMemoryError
    //   1779	1787	2365	java/lang/OutOfMemoryError
    //   1805	1809	2365	java/lang/OutOfMemoryError
    //   1882	1886	2365	java/lang/OutOfMemoryError
    //   1902	1911	2365	java/lang/OutOfMemoryError
    //   1923	1932	2365	java/lang/OutOfMemoryError
    //   1944	1954	2365	java/lang/OutOfMemoryError
    //   1966	1974	2365	java/lang/OutOfMemoryError
    //   1996	2002	2365	java/lang/OutOfMemoryError
    //   2064	2068	2365	java/lang/OutOfMemoryError
    //   2085	2094	2365	java/lang/OutOfMemoryError
    //   2106	2115	2365	java/lang/OutOfMemoryError
    //   2127	2138	2365	java/lang/OutOfMemoryError
    //   2150	2158	2365	java/lang/OutOfMemoryError
    //   2174	2181	2365	java/lang/OutOfMemoryError
    //   2193	2197	2365	java/lang/OutOfMemoryError
    //   2209	2211	2365	java/lang/OutOfMemoryError
    //   2227	2231	2365	java/lang/OutOfMemoryError
    //   2243	2245	2365	java/lang/OutOfMemoryError
    //   432	442	2372	java/io/IOException
    //   442	477	2377	java/io/IOException
    //   477	533	2377	java/io/IOException
    //   533	538	2382	java/io/IOException
    //   533	538	2387	java/lang/OutOfMemoryError
    //   635	640	2391	java/io/IOException
    //   952	958	2400	java/io/IOException
    //   998	1005	2400	java/io/IOException
    //   1019	1030	2400	java/io/IOException
    //   1051	1058	2400	java/io/IOException
    //   1079	1086	2400	java/io/IOException
    //   1118	1128	2400	java/io/IOException
    //   1142	1150	2400	java/io/IOException
    //   1164	1172	2400	java/io/IOException
    //   1186	1193	2400	java/io/IOException
    //   1207	1215	2400	java/io/IOException
    //   1229	1238	2400	java/io/IOException
    //   1252	1259	2400	java/io/IOException
    //   1286	1292	2400	java/io/IOException
    //   1310	1316	2400	java/io/IOException
    //   1518	1527	2400	java/io/IOException
    //   1598	1609	2400	java/io/IOException
    //   1480	1485	2410	java/io/IOException
    //   1527	1554	2414	java/io/IOException
    //   2021	2026	2418	java/io/IOException
    //   2227	2231	2422	java/io/IOException
    //   2297	2302	2427	java/io/IOException
    //   2330	2335	2431	java/io/IOException
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2)
  {
    RichMediaUtil.logUI(paramInt1, paramBoolean, paramInt2, String.valueOf(paramLong), paramString1, paramString2);
  }
  
  public static void a(long paramLong, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramLong, paramInt, 1, paramBoolean, paramString1, paramString2);
  }
  
  public static void a(Context paramContext, List<ImageInfo> paramList, int paramInt)
  {
    if (paramContext != null)
    {
      if (paramList == null) {
        return;
      }
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        ImageInfo localImageInfo = (ImageInfo)paramList.next();
        if (localImageInfo != null)
        {
          if (localImageInfo.b == null) {
            return;
          }
          File localFile = new File(localImageInfo.b);
          long l = ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
          if (paramInt != 0)
          {
            if (paramInt != 1) {
              if (paramInt != 1001)
              {
                if (paramInt != 3000) {
                  if (paramInt != 10002) {
                    break label210;
                  }
                }
              }
              else
              {
                if ((paramContext != null) && ((paramContext instanceof BaseActivity)))
                {
                  if (!((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).isLBSFriendNewClient(localImageInfo.jdField_c_of_type_JavaLangString)) {
                    break label210;
                  }
                  l = ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
                  break label210;
                }
                l = AppSetting.jdField_c_of_type_Int;
                break label210;
              }
            }
            l = ((IPicBus)QRoute.api(IPicBus.class)).getGroupPicSizeLimit();
          }
          else
          {
            l = ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
          }
          label210:
          if ((localFile.length() > l) && (!localImageInfo.q)) {}
          for (;;)
          {
            i = 1;
            break;
            if ((!localImageInfo.g) || (NetworkUtil.isWifiConnected(paramContext))) {
              break;
            }
          }
        }
        return;
      }
      if (i != 0) {
        QQToast.a(paramContext, HardCodeUtil.a(2131705820), 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
      }
    }
  }
  
  public static void a(ImageInfo paramImageInfo, String paramString1, String paramString2)
  {
    if (paramImageInfo == null)
    {
      paramImageInfo = new StringBuilder();
      paramImageInfo.append("@ImageUtil.log ImageInfo is null@ ");
      paramImageInfo.append(paramString2);
      a(-1L, -1, true, paramString1, paramImageInfo.toString());
      return;
    }
    boolean bool = MessageRecordInfo.b(paramImageInfo.jdField_d_of_type_Int);
    if (paramImageInfo.jdField_h_of_type_Int == 2)
    {
      a(paramImageInfo.jdField_d_of_type_Long, paramImageInfo.jdField_c_of_type_Int, 131075, bool, paramString1, paramString2);
      return;
    }
    a(paramImageInfo.jdField_d_of_type_Long, paramImageInfo.jdField_c_of_type_Int, bool, paramString1, paramString2);
  }
  
  private static boolean a()
  {
    return com.tencent.mobileqq.util.Utils.b() >> 20 < 2L;
  }
  
  public static boolean a(int paramInt1, Context paramContext, String paramString1, String paramString2, boolean paramBoolean, ImageInfo paramImageInfo, int paramInt2)
  {
    boolean bool2 = FileUtils.fileExists(paramString2);
    boolean bool1 = false;
    if (bool2)
    {
      File localFile = new File(paramString2);
      if (!a(paramString2))
      {
        localFile.delete();
      }
      else
      {
        paramImageInfo.b = localFile.getPath();
        paramImageInfo.a = localFile.length();
        paramImageInfo.o = true;
        paramImageInfo.jdField_h_of_type_Boolean = true;
        if (paramImageInfo.jdField_j_of_type_Int > 0)
        {
          paramString1 = new StringBuilder();
          paramString1.append("compress succ with retry : ");
          paramString1.append(paramImageInfo.jdField_j_of_type_Int);
          a(paramString1.toString());
          a(paramInt1, 8, paramContext, false, null);
        }
        else
        {
          a(paramInt1, 0, paramContext, true, null);
        }
        paramBoolean = bool1;
        if (paramImageInfo.jdField_j_of_type_Int > 0) {
          paramBoolean = true;
        }
        RichMediaUtil.stopReport("compressPic", paramBoolean, "compressPic");
        return true;
      }
    }
    if (paramInt1 == 8) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramBoolean = a(paramInt1, paramContext, paramString1, paramString2, paramBoolean, paramImageInfo, paramInt2, bool1);
    if ((paramBoolean) && (!bool1)) {
      a(paramString1, paramString2);
    }
    return paramBoolean;
  }
  
  /* Error */
  private static boolean a(int paramInt1, Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, ImageInfo paramImageInfo, int paramInt2, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 544
    //   3: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   6: aload_3
    //   7: ifnull +4913 -> 4920
    //   10: aload_2
    //   11: ifnull +4909 -> 4920
    //   14: aload 5
    //   16: ifnull +4904 -> 4920
    //   19: aload_1
    //   20: ifnonnull +6 -> 26
    //   23: goto +4897 -> 4920
    //   26: new 95	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   33: astore 14
    //   35: aload 14
    //   37: getstatic 549	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   40: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 14
    //   46: ldc_w 551
    //   49: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: new 65	java/io/File
    //   56: dup
    //   57: aload 14
    //   59: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokespecial 457	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore 14
    //   67: aload 14
    //   69: invokevirtual 554	java/io/File:exists	()Z
    //   72: ifne +23 -> 95
    //   75: ldc_w 556
    //   78: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   81: aload 14
    //   83: invokevirtual 559	java/io/File:mkdirs	()Z
    //   86: ifne +9 -> 95
    //   89: ldc_w 561
    //   92: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   95: new 65	java/io/File
    //   98: dup
    //   99: aload_3
    //   100: invokespecial 457	java/io/File:<init>	(Ljava/lang/String;)V
    //   103: astore 26
    //   105: new 65	java/io/File
    //   108: dup
    //   109: aload_2
    //   110: invokespecial 457	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: astore 14
    //   115: new 95	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   122: astore 15
    //   124: aload 15
    //   126: ldc_w 563
    //   129: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 15
    //   135: aload 5
    //   137: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   140: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 15
    //   146: ldc_w 565
    //   149: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 15
    //   155: aload 5
    //   157: getfield 150	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Int	I
    //   160: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 5
    //   166: ldc_w 567
    //   169: aload 15
    //   171: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_2
    //   178: invokestatic 519	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   181: ifne +13 -> 194
    //   184: iload_0
    //   185: iconst_1
    //   186: aload_1
    //   187: iconst_0
    //   188: aconst_null
    //   189: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   192: iconst_0
    //   193: ireturn
    //   194: aload_2
    //   195: invokestatic 570	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   198: ifne +13 -> 211
    //   201: iload_0
    //   202: iconst_2
    //   203: aload_1
    //   204: iconst_0
    //   205: aconst_null
    //   206: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   209: iconst_0
    //   210: ireturn
    //   211: aload_2
    //   212: invokestatic 521	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Z
    //   215: ifne +13 -> 228
    //   218: iload_0
    //   219: iconst_4
    //   220: aload_1
    //   221: iconst_0
    //   222: aconst_null
    //   223: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   226: iconst_0
    //   227: ireturn
    //   228: aload 5
    //   230: aload 14
    //   232: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   235: putfield 456	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   238: aload 5
    //   240: aload 14
    //   242: invokevirtual 370	java/io/File:length	()J
    //   245: putfield 523	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   248: aload 14
    //   250: invokestatic 573	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   253: astore 15
    //   255: new 95	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   262: astore 16
    //   264: aload 16
    //   266: ldc_w 575
    //   269: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 16
    //   275: aload 14
    //   277: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 16
    //   283: ldc_w 580
    //   286: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 16
    //   292: aload 14
    //   294: invokevirtual 370	java/io/File:length	()J
    //   297: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 16
    //   303: ldc_w 582
    //   306: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 16
    //   312: aload 15
    //   314: getfield 76	android/graphics/BitmapFactory$Options:outWidth	I
    //   317: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 16
    //   323: ldc_w 584
    //   326: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 16
    //   332: aload 15
    //   334: getfield 79	android/graphics/BitmapFactory$Options:outHeight	I
    //   337: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 16
    //   343: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   349: aload_3
    //   350: invokestatic 519	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   353: istore 10
    //   355: iload 10
    //   357: ifeq +1161 -> 1518
    //   360: aload_3
    //   361: invokestatic 521	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Z
    //   364: istore 10
    //   366: iload 10
    //   368: ifne +17 -> 385
    //   371: aload 26
    //   373: invokevirtual 325	java/io/File:delete	()Z
    //   376: pop
    //   377: goto +1141 -> 1518
    //   380: astore 16
    //   382: goto +1011 -> 1393
    //   385: aload 5
    //   387: ldc_w 312
    //   390: ldc_w 586
    //   393: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload 5
    //   398: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   401: iconst_1
    //   402: if_icmpeq +21 -> 423
    //   405: aload 5
    //   407: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   410: iconst_1
    //   411: if_icmpne +6 -> 417
    //   414: goto +9 -> 423
    //   417: iconst_0
    //   418: istore 10
    //   420: goto +6 -> 426
    //   423: iconst_1
    //   424: istore 10
    //   426: aload_3
    //   427: invokestatic 570	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   430: istore 11
    //   432: new 95	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   439: astore 15
    //   441: aload 15
    //   443: ldc_w 588
    //   446: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 15
    //   452: aload 5
    //   454: getfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   457: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 15
    //   463: ldc_w 590
    //   466: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 15
    //   472: aload 5
    //   474: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   477: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 15
    //   483: ldc_w 592
    //   486: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload 15
    //   492: iload 11
    //   494: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 15
    //   500: ldc_w 594
    //   503: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload 15
    //   509: iload 10
    //   511: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 15
    //   517: ldc_w 596
    //   520: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 15
    //   526: aload 5
    //   528: getfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   531: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload 15
    //   537: ldc_w 598
    //   540: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload 15
    //   546: aload 5
    //   548: getfield 381	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   551: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 15
    //   557: ldc_w 600
    //   560: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 15
    //   566: invokestatic 276	com/tencent/mobileqq/util/Utils:b	()J
    //   569: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 5
    //   575: ldc_w 602
    //   578: aload 15
    //   580: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   586: aload 5
    //   588: getfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   591: ifne +33 -> 624
    //   594: aload 5
    //   596: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   599: ifeq +14 -> 613
    //   602: iload_0
    //   603: iconst_3
    //   604: aload_1
    //   605: iconst_0
    //   606: aconst_null
    //   607: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   610: goto +169 -> 779
    //   613: iload_0
    //   614: iconst_4
    //   615: aload_1
    //   616: iconst_0
    //   617: aconst_null
    //   618: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   621: goto +158 -> 779
    //   624: iload 11
    //   626: ifne +153 -> 779
    //   629: iload 10
    //   631: ifne +148 -> 779
    //   634: aload 5
    //   636: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   639: istore 8
    //   641: aload 5
    //   643: iload 8
    //   645: iconst_1
    //   646: iadd
    //   647: putfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   650: iload 8
    //   652: iconst_2
    //   653: if_icmpge +33 -> 686
    //   656: aload 5
    //   658: iconst_1
    //   659: putfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   662: ldc_w 604
    //   665: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   668: iload_0
    //   669: aload_1
    //   670: aload_2
    //   671: aload_3
    //   672: iload 4
    //   674: aload 5
    //   676: iload 6
    //   678: iload 7
    //   680: invokestatic 539	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   683: pop
    //   684: iconst_0
    //   685: ireturn
    //   686: aload 5
    //   688: getfield 337	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   691: ifeq +15 -> 706
    //   694: iload_0
    //   695: bipush 6
    //   697: aload_1
    //   698: iconst_0
    //   699: aconst_null
    //   700: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   703: goto +76 -> 779
    //   706: aload 5
    //   708: getfield 606	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   711: ifeq +15 -> 726
    //   714: iload_0
    //   715: bipush 7
    //   717: aload_1
    //   718: iconst_0
    //   719: aconst_null
    //   720: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   723: goto +56 -> 779
    //   726: aload 5
    //   728: getfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   731: ifne +15 -> 746
    //   734: iload_0
    //   735: bipush 9
    //   737: aload_1
    //   738: iconst_0
    //   739: aconst_null
    //   740: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   743: goto +36 -> 779
    //   746: aload 5
    //   748: getfield 381	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   751: ifeq +14 -> 765
    //   754: iload_0
    //   755: iconst_0
    //   756: aload_1
    //   757: iconst_0
    //   758: aconst_null
    //   759: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   762: goto +17 -> 779
    //   765: ldc_w 608
    //   768: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   771: iload_0
    //   772: iconst_5
    //   773: aload_1
    //   774: iconst_0
    //   775: aconst_null
    //   776: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   779: iload 11
    //   781: ifeq +297 -> 1078
    //   784: aload 26
    //   786: invokevirtual 370	java/io/File:length	()J
    //   789: aload 14
    //   791: invokevirtual 370	java/io/File:length	()J
    //   794: lcmp
    //   795: ifgt +283 -> 1078
    //   798: iload 10
    //   800: ifne +278 -> 1078
    //   803: aload 5
    //   805: aload 26
    //   807: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   810: putfield 456	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   813: aload 5
    //   815: aload 26
    //   817: invokevirtual 370	java/io/File:length	()J
    //   820: putfield 523	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   823: aload 5
    //   825: iconst_1
    //   826: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   829: aload 5
    //   831: iconst_1
    //   832: putfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   835: aload 26
    //   837: invokestatic 573	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   840: astore_2
    //   841: new 95	java/lang/StringBuilder
    //   844: dup
    //   845: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   848: astore 15
    //   850: aload 15
    //   852: ldc_w 610
    //   855: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: pop
    //   859: aload 15
    //   861: aload 14
    //   863: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   866: pop
    //   867: aload 15
    //   869: ldc_w 612
    //   872: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: pop
    //   876: aload 15
    //   878: aload_3
    //   879: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: aload 15
    //   885: ldc_w 580
    //   888: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload 15
    //   894: aload 26
    //   896: invokevirtual 370	java/io/File:length	()J
    //   899: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: aload 15
    //   905: ldc_w 582
    //   908: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: pop
    //   912: aload 15
    //   914: aload_2
    //   915: getfield 76	android/graphics/BitmapFactory$Options:outWidth	I
    //   918: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 15
    //   924: ldc_w 584
    //   927: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: aload 15
    //   933: aload_2
    //   934: getfield 79	android/graphics/BitmapFactory$Options:outHeight	I
    //   937: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   940: pop
    //   941: aload 15
    //   943: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   946: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   949: aload 5
    //   951: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   954: ifle +48 -> 1002
    //   957: new 95	java/lang/StringBuilder
    //   960: dup
    //   961: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   964: astore_2
    //   965: aload_2
    //   966: ldc_w 528
    //   969: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: pop
    //   973: aload_2
    //   974: aload 5
    //   976: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   979: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   982: pop
    //   983: aload_2
    //   984: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   990: iload_0
    //   991: bipush 8
    //   993: aload_1
    //   994: iconst_0
    //   995: aconst_null
    //   996: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   999: goto +11 -> 1010
    //   1002: iload_0
    //   1003: iconst_0
    //   1004: aload_1
    //   1005: iconst_1
    //   1006: aconst_null
    //   1007: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1010: aload 5
    //   1012: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1015: ifle +9 -> 1024
    //   1018: iconst_1
    //   1019: istore 4
    //   1021: goto +6 -> 1027
    //   1024: iconst_0
    //   1025: istore 4
    //   1027: ldc_w 532
    //   1030: iload 4
    //   1032: ldc_w 532
    //   1035: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1038: new 95	java/lang/StringBuilder
    //   1041: dup
    //   1042: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1045: astore_1
    //   1046: aload_1
    //   1047: ldc_w 614
    //   1050: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: pop
    //   1054: aload_1
    //   1055: aload 5
    //   1057: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1060: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: aload 5
    //   1066: ldc_w 616
    //   1069: aload_1
    //   1070: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1073: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1076: iconst_1
    //   1077: ireturn
    //   1078: aload 5
    //   1080: aload 14
    //   1082: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   1085: putfield 456	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   1088: aload 5
    //   1090: aload 14
    //   1092: invokevirtual 370	java/io/File:length	()J
    //   1095: putfield 523	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   1098: aload 5
    //   1100: iconst_0
    //   1101: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1104: aload 5
    //   1106: iconst_0
    //   1107: putfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   1110: aload 26
    //   1112: invokevirtual 554	java/io/File:exists	()Z
    //   1115: ifeq +9 -> 1124
    //   1118: aload 26
    //   1120: invokevirtual 325	java/io/File:delete	()Z
    //   1123: pop
    //   1124: iload 10
    //   1126: ifne +194 -> 1320
    //   1129: new 95	java/lang/StringBuilder
    //   1132: dup
    //   1133: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1136: astore_1
    //   1137: aload_1
    //   1138: ldc_w 618
    //   1141: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: pop
    //   1145: aload_1
    //   1146: aload_3
    //   1147: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: pop
    //   1151: aload_1
    //   1152: ldc_w 580
    //   1155: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: pop
    //   1159: aload_1
    //   1160: aload 26
    //   1162: invokevirtual 370	java/io/File:length	()J
    //   1165: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1168: pop
    //   1169: aload_1
    //   1170: ldc_w 620
    //   1173: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: aload_1
    //   1178: aload 14
    //   1180: invokevirtual 370	java/io/File:length	()J
    //   1183: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1186: pop
    //   1187: aload_1
    //   1188: ldc_w 622
    //   1191: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: pop
    //   1195: aload_1
    //   1196: iload 10
    //   1198: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1201: pop
    //   1202: aload_1
    //   1203: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1209: new 95	java/lang/StringBuilder
    //   1212: dup
    //   1213: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1216: astore_1
    //   1217: aload_1
    //   1218: ldc_w 624
    //   1221: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: pop
    //   1225: aload_1
    //   1226: iconst_0
    //   1227: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1230: pop
    //   1231: aload_1
    //   1232: ldc_w 626
    //   1235: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: pop
    //   1239: aload_1
    //   1240: aload_3
    //   1241: invokestatic 519	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   1244: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: aload_1
    //   1249: ldc_w 628
    //   1252: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: pop
    //   1256: aload 26
    //   1258: invokevirtual 370	java/io/File:length	()J
    //   1261: lconst_0
    //   1262: lcmp
    //   1263: ifgt +9 -> 1272
    //   1266: iconst_1
    //   1267: istore 4
    //   1269: goto +6 -> 1275
    //   1272: iconst_0
    //   1273: istore 4
    //   1275: aload_1
    //   1276: iload 4
    //   1278: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1281: pop
    //   1282: aload_1
    //   1283: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1289: iload 11
    //   1291: ifne +16 -> 1307
    //   1294: ldc_w 532
    //   1297: iconst_1
    //   1298: ldc_w 532
    //   1301: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1304: goto +74 -> 1378
    //   1307: ldc_w 532
    //   1310: iconst_0
    //   1311: ldc_w 532
    //   1314: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1317: goto +61 -> 1378
    //   1320: new 95	java/lang/StringBuilder
    //   1323: dup
    //   1324: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1327: astore_1
    //   1328: aload_1
    //   1329: ldc_w 630
    //   1332: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: pop
    //   1336: aload_1
    //   1337: aload 14
    //   1339: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1342: pop
    //   1343: aload_1
    //   1344: ldc_w 580
    //   1347: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: pop
    //   1351: aload_1
    //   1352: aload 14
    //   1354: invokevirtual 370	java/io/File:length	()J
    //   1357: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1360: pop
    //   1361: aload_1
    //   1362: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1365: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1368: ldc_w 532
    //   1371: iconst_0
    //   1372: ldc_w 532
    //   1375: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1378: aload 5
    //   1380: ldc_w 616
    //   1383: ldc_w 632
    //   1386: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1389: iconst_1
    //   1390: ireturn
    //   1391: astore 16
    //   1393: ldc_w 580
    //   1396: astore 15
    //   1398: iconst_0
    //   1399: istore 10
    //   1401: ldc_w 616
    //   1404: astore 24
    //   1406: ldc_w 532
    //   1409: astore 23
    //   1411: ldc_w 596
    //   1414: astore 20
    //   1416: ldc_w 592
    //   1419: astore 18
    //   1421: ldc_w 588
    //   1424: astore 17
    //   1426: aload 14
    //   1428: astore 25
    //   1430: iconst_0
    //   1431: istore 11
    //   1433: ldc_w 602
    //   1436: astore 21
    //   1438: ldc_w 590
    //   1441: astore 22
    //   1443: ldc_w 594
    //   1446: astore 19
    //   1448: aload 16
    //   1450: astore 14
    //   1452: aload 17
    //   1454: astore 16
    //   1456: aload 22
    //   1458: astore 17
    //   1460: aload 15
    //   1462: astore 22
    //   1464: goto +2454 -> 3918
    //   1467: ldc_w 580
    //   1470: astore 23
    //   1472: iconst_0
    //   1473: istore 10
    //   1475: ldc_w 616
    //   1478: astore 22
    //   1480: ldc_w 532
    //   1483: astore 21
    //   1485: ldc_w 596
    //   1488: astore 19
    //   1490: ldc_w 592
    //   1493: astore 17
    //   1495: ldc_w 588
    //   1498: astore 15
    //   1500: ldc_w 602
    //   1503: astore 20
    //   1505: ldc_w 590
    //   1508: astore 16
    //   1510: ldc_w 594
    //   1513: astore 18
    //   1515: goto +1662 -> 3177
    //   1518: aload 14
    //   1520: invokestatic 407	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   1523: istore 10
    //   1525: aload 5
    //   1527: iload 10
    //   1529: putfield 469	com/tencent/mobileqq/activity/photo/ImageInfo:q	Z
    //   1532: iload 10
    //   1534: ifne +425 -> 1959
    //   1537: aload 26
    //   1539: invokevirtual 412	java/io/File:createNewFile	()Z
    //   1542: ifeq +417 -> 1959
    //   1545: ldc_w 634
    //   1548: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1551: new 62	android/graphics/BitmapFactory$Options
    //   1554: dup
    //   1555: invokespecial 63	android/graphics/BitmapFactory$Options:<init>	()V
    //   1558: astore 15
    //   1560: aload 15
    //   1562: iconst_1
    //   1563: putfield 637	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1566: new 639	java/io/BufferedInputStream
    //   1569: dup
    //   1570: new 641	java/io/FileInputStream
    //   1573: dup
    //   1574: aload 14
    //   1576: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   1579: invokespecial 642	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1582: invokespecial 645	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1585: astore 16
    //   1587: aload 16
    //   1589: aconst_null
    //   1590: aload 15
    //   1592: invokestatic 651	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1595: pop
    //   1596: aload 16
    //   1598: invokevirtual 654	java/io/InputStream:close	()V
    //   1601: goto +13 -> 1614
    //   1604: astore 16
    //   1606: ldc_w 580
    //   1609: astore 15
    //   1611: goto -210 -> 1401
    //   1614: aload 15
    //   1616: getfield 79	android/graphics/BitmapFactory$Options:outHeight	I
    //   1619: istore 8
    //   1621: aload 15
    //   1623: getfield 76	android/graphics/BitmapFactory$Options:outWidth	I
    //   1626: istore 9
    //   1628: iload 8
    //   1630: iconst_m1
    //   1631: if_icmpeq +157 -> 1788
    //   1634: iload 9
    //   1636: iconst_m1
    //   1637: if_icmpeq +151 -> 1788
    //   1640: iload 7
    //   1642: ifne +106 -> 1748
    //   1645: iload 4
    //   1647: ifeq +101 -> 1748
    //   1650: iload 8
    //   1652: iload 9
    //   1654: iconst_3
    //   1655: imul
    //   1656: if_icmpgt +12 -> 1668
    //   1659: iload 9
    //   1661: iload 8
    //   1663: iconst_3
    //   1664: imul
    //   1665: if_icmple +83 -> 1748
    //   1668: iload_0
    //   1669: aload_1
    //   1670: aload 14
    //   1672: aload 26
    //   1674: aload 5
    //   1676: iload 6
    //   1678: iload 8
    //   1680: iload 9
    //   1682: iload 4
    //   1684: iload 7
    //   1686: invokestatic 656	com/tencent/mobileqq/utils/ImageUtil:b	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   1689: ldc_w 658
    //   1692: aload_1
    //   1693: iconst_1
    //   1694: invokestatic 84	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   1697: goto +262 -> 1959
    //   1700: ldc_w 532
    //   1703: astore 21
    //   1705: ldc_w 580
    //   1708: astore 23
    //   1710: ldc_w 616
    //   1713: astore 22
    //   1715: ldc_w 602
    //   1718: astore 20
    //   1720: ldc_w 588
    //   1723: astore 15
    //   1725: ldc_w 590
    //   1728: astore 16
    //   1730: ldc_w 592
    //   1733: astore 17
    //   1735: ldc_w 594
    //   1738: astore 18
    //   1740: ldc_w 596
    //   1743: astore 19
    //   1745: goto +193 -> 1938
    //   1748: iload_0
    //   1749: aload_1
    //   1750: aload 14
    //   1752: aload 26
    //   1754: aload 5
    //   1756: iload 6
    //   1758: iload 8
    //   1760: iload 9
    //   1762: iload 4
    //   1764: iload 7
    //   1766: invokestatic 660	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   1769: ldc_w 658
    //   1772: aload_1
    //   1773: iconst_0
    //   1774: invokestatic 84	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   1777: goto +182 -> 1959
    //   1780: astore 15
    //   1782: goto +47 -> 1829
    //   1785: goto +108 -> 1893
    //   1788: goto +171 -> 1959
    //   1791: astore 16
    //   1793: goto +150 -> 1943
    //   1796: goto +155 -> 1951
    //   1799: astore 15
    //   1801: goto +13 -> 1814
    //   1804: astore 15
    //   1806: goto +5 -> 1811
    //   1809: astore 16
    //   1811: aconst_null
    //   1812: astore 16
    //   1814: aload 16
    //   1816: ifnull +8 -> 1824
    //   1819: aload 16
    //   1821: invokevirtual 654	java/io/InputStream:close	()V
    //   1824: aload 15
    //   1826: athrow
    //   1827: astore 15
    //   1829: aload 14
    //   1831: astore 16
    //   1833: ldc_w 532
    //   1836: astore 23
    //   1838: ldc_w 580
    //   1841: astore 22
    //   1843: ldc_w 616
    //   1846: astore 24
    //   1848: ldc_w 602
    //   1851: astore 21
    //   1853: ldc_w 588
    //   1856: astore 25
    //   1858: ldc_w 590
    //   1861: astore 17
    //   1863: ldc_w 592
    //   1866: astore 18
    //   1868: ldc_w 594
    //   1871: astore 19
    //   1873: ldc_w 596
    //   1876: astore 20
    //   1878: aload 15
    //   1880: astore 14
    //   1882: aload 16
    //   1884: astore 15
    //   1886: aload 25
    //   1888: astore 16
    //   1890: goto +1229 -> 3119
    //   1893: ldc_w 532
    //   1896: astore 21
    //   1898: ldc_w 580
    //   1901: astore 23
    //   1903: ldc_w 616
    //   1906: astore 22
    //   1908: ldc_w 602
    //   1911: astore 20
    //   1913: ldc_w 588
    //   1916: astore 15
    //   1918: ldc_w 590
    //   1921: astore 16
    //   1923: ldc_w 592
    //   1926: astore 17
    //   1928: ldc_w 594
    //   1931: astore 18
    //   1933: ldc_w 596
    //   1936: astore 19
    //   1938: goto +1239 -> 3177
    //   1941: astore 16
    //   1943: ldc_w 580
    //   1946: astore 15
    //   1948: goto -547 -> 1401
    //   1951: ldc_w 580
    //   1954: astore 23
    //   1956: goto -481 -> 1475
    //   1959: iconst_0
    //   1960: istore 12
    //   1962: aload 5
    //   1964: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   1967: iconst_1
    //   1968: if_icmpeq +21 -> 1989
    //   1971: aload 5
    //   1973: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   1976: iconst_1
    //   1977: if_icmpne +6 -> 1983
    //   1980: goto +9 -> 1989
    //   1983: iconst_0
    //   1984: istore 11
    //   1986: goto +6 -> 1992
    //   1989: iconst_1
    //   1990: istore 11
    //   1992: aload_3
    //   1993: invokestatic 570	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   1996: istore 13
    //   1998: new 95	java/lang/StringBuilder
    //   2001: dup
    //   2002: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2005: astore 15
    //   2007: aload 15
    //   2009: ldc_w 588
    //   2012: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2015: pop
    //   2016: aload 15
    //   2018: aload 5
    //   2020: getfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   2023: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2026: pop
    //   2027: aload 15
    //   2029: ldc_w 590
    //   2032: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2035: pop
    //   2036: aload 15
    //   2038: aload 5
    //   2040: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   2043: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2046: pop
    //   2047: aload 15
    //   2049: ldc_w 592
    //   2052: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2055: pop
    //   2056: aload 15
    //   2058: iload 13
    //   2060: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2063: pop
    //   2064: aload 15
    //   2066: ldc_w 594
    //   2069: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2072: pop
    //   2073: aload 15
    //   2075: iload 11
    //   2077: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2080: pop
    //   2081: aload 15
    //   2083: ldc_w 596
    //   2086: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: pop
    //   2090: aload 15
    //   2092: aload 5
    //   2094: getfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   2097: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2100: pop
    //   2101: aload 15
    //   2103: ldc_w 598
    //   2106: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2109: pop
    //   2110: aload 15
    //   2112: aload 5
    //   2114: getfield 381	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   2117: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2120: pop
    //   2121: aload 15
    //   2123: ldc_w 600
    //   2126: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: pop
    //   2130: aload 15
    //   2132: invokestatic 276	com/tencent/mobileqq/util/Utils:b	()J
    //   2135: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2138: pop
    //   2139: aload 5
    //   2141: ldc_w 602
    //   2144: aload 15
    //   2146: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2149: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   2152: aload 5
    //   2154: getfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   2157: ifne +33 -> 2190
    //   2160: aload 5
    //   2162: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   2165: ifeq +14 -> 2179
    //   2168: iload_0
    //   2169: iconst_3
    //   2170: aload_1
    //   2171: iconst_0
    //   2172: aconst_null
    //   2173: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2176: goto +174 -> 2350
    //   2179: iload_0
    //   2180: iconst_4
    //   2181: aload_1
    //   2182: iconst_0
    //   2183: aconst_null
    //   2184: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2187: goto +163 -> 2350
    //   2190: iload 13
    //   2192: ifne +158 -> 2350
    //   2195: iload 11
    //   2197: ifne +153 -> 2350
    //   2200: iload 10
    //   2202: ifne +148 -> 2350
    //   2205: aload 5
    //   2207: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2210: istore 8
    //   2212: aload 5
    //   2214: iload 8
    //   2216: iconst_1
    //   2217: iadd
    //   2218: putfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2221: iload 8
    //   2223: iconst_2
    //   2224: if_icmpge +33 -> 2257
    //   2227: aload 5
    //   2229: iconst_1
    //   2230: putfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   2233: ldc_w 604
    //   2236: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2239: iload_0
    //   2240: aload_1
    //   2241: aload_2
    //   2242: aload_3
    //   2243: iload 4
    //   2245: aload 5
    //   2247: iload 6
    //   2249: iload 7
    //   2251: invokestatic 539	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   2254: pop
    //   2255: iconst_0
    //   2256: ireturn
    //   2257: aload 5
    //   2259: getfield 337	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   2262: ifeq +15 -> 2277
    //   2265: iload_0
    //   2266: bipush 6
    //   2268: aload_1
    //   2269: iconst_0
    //   2270: aconst_null
    //   2271: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2274: goto +76 -> 2350
    //   2277: aload 5
    //   2279: getfield 606	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   2282: ifeq +15 -> 2297
    //   2285: iload_0
    //   2286: bipush 7
    //   2288: aload_1
    //   2289: iconst_0
    //   2290: aconst_null
    //   2291: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2294: goto +56 -> 2350
    //   2297: aload 5
    //   2299: getfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   2302: ifne +15 -> 2317
    //   2305: iload_0
    //   2306: bipush 9
    //   2308: aload_1
    //   2309: iconst_0
    //   2310: aconst_null
    //   2311: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2314: goto +36 -> 2350
    //   2317: aload 5
    //   2319: getfield 381	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   2322: ifeq +14 -> 2336
    //   2325: iload_0
    //   2326: iconst_0
    //   2327: aload_1
    //   2328: iconst_0
    //   2329: aconst_null
    //   2330: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2333: goto +17 -> 2350
    //   2336: ldc_w 608
    //   2339: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2342: iload_0
    //   2343: iconst_5
    //   2344: aload_1
    //   2345: iconst_0
    //   2346: aconst_null
    //   2347: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2350: iload 13
    //   2352: ifeq +306 -> 2658
    //   2355: aload 26
    //   2357: invokevirtual 370	java/io/File:length	()J
    //   2360: aload 14
    //   2362: invokevirtual 370	java/io/File:length	()J
    //   2365: lcmp
    //   2366: ifgt +292 -> 2658
    //   2369: iload 11
    //   2371: ifne +287 -> 2658
    //   2374: iload 10
    //   2376: ifeq +6 -> 2382
    //   2379: goto +279 -> 2658
    //   2382: aload 5
    //   2384: aload 26
    //   2386: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   2389: putfield 456	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   2392: aload 5
    //   2394: aload 26
    //   2396: invokevirtual 370	java/io/File:length	()J
    //   2399: putfield 523	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   2402: aload 5
    //   2404: iconst_1
    //   2405: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   2408: aload 5
    //   2410: iconst_1
    //   2411: putfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   2414: aload 26
    //   2416: invokestatic 573	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   2419: astore_2
    //   2420: new 95	java/lang/StringBuilder
    //   2423: dup
    //   2424: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2427: astore 15
    //   2429: aload 15
    //   2431: ldc_w 610
    //   2434: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2437: pop
    //   2438: aload 15
    //   2440: aload 14
    //   2442: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2445: pop
    //   2446: aload 15
    //   2448: ldc_w 612
    //   2451: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2454: pop
    //   2455: aload 15
    //   2457: aload_3
    //   2458: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2461: pop
    //   2462: aload 15
    //   2464: ldc_w 580
    //   2467: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2470: pop
    //   2471: aload 15
    //   2473: aload 26
    //   2475: invokevirtual 370	java/io/File:length	()J
    //   2478: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2481: pop
    //   2482: aload 15
    //   2484: ldc_w 582
    //   2487: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2490: pop
    //   2491: aload 15
    //   2493: aload_2
    //   2494: getfield 76	android/graphics/BitmapFactory$Options:outWidth	I
    //   2497: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2500: pop
    //   2501: aload 15
    //   2503: ldc_w 584
    //   2506: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2509: pop
    //   2510: aload 15
    //   2512: aload_2
    //   2513: getfield 79	android/graphics/BitmapFactory$Options:outHeight	I
    //   2516: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2519: pop
    //   2520: aload 15
    //   2522: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2525: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2528: aload 5
    //   2530: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2533: ifle +48 -> 2581
    //   2536: new 95	java/lang/StringBuilder
    //   2539: dup
    //   2540: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2543: astore_2
    //   2544: aload_2
    //   2545: ldc_w 528
    //   2548: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2551: pop
    //   2552: aload_2
    //   2553: aload 5
    //   2555: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2558: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2561: pop
    //   2562: aload_2
    //   2563: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2566: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2569: iload_0
    //   2570: bipush 8
    //   2572: aload_1
    //   2573: iconst_0
    //   2574: aconst_null
    //   2575: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2578: goto +11 -> 2589
    //   2581: iload_0
    //   2582: iconst_0
    //   2583: aload_1
    //   2584: iconst_1
    //   2585: aconst_null
    //   2586: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2589: aload 5
    //   2591: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2594: ifle +9 -> 2603
    //   2597: iconst_1
    //   2598: istore 4
    //   2600: goto +7 -> 2607
    //   2603: iload 12
    //   2605: istore 4
    //   2607: ldc_w 532
    //   2610: astore_1
    //   2611: aload_1
    //   2612: iload 4
    //   2614: aload_1
    //   2615: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2618: new 95	java/lang/StringBuilder
    //   2621: dup
    //   2622: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2625: astore_1
    //   2626: aload_1
    //   2627: ldc_w 614
    //   2630: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2633: pop
    //   2634: aload_1
    //   2635: aload 5
    //   2637: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2640: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2643: pop
    //   2644: aload 5
    //   2646: ldc_w 616
    //   2649: aload_1
    //   2650: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2653: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   2656: iconst_1
    //   2657: ireturn
    //   2658: aload 5
    //   2660: aload 14
    //   2662: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   2665: putfield 456	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   2668: aload 5
    //   2670: aload 14
    //   2672: invokevirtual 370	java/io/File:length	()J
    //   2675: putfield 523	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   2678: aload 5
    //   2680: iconst_0
    //   2681: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   2684: aload 5
    //   2686: iconst_0
    //   2687: putfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   2690: aload 26
    //   2692: invokevirtual 554	java/io/File:exists	()Z
    //   2695: ifeq +9 -> 2704
    //   2698: aload 26
    //   2700: invokevirtual 325	java/io/File:delete	()Z
    //   2703: pop
    //   2704: iload 11
    //   2706: ifne +202 -> 2908
    //   2709: iload 10
    //   2711: ifeq +6 -> 2717
    //   2714: goto +194 -> 2908
    //   2717: new 95	java/lang/StringBuilder
    //   2720: dup
    //   2721: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2724: astore_1
    //   2725: aload_1
    //   2726: ldc_w 618
    //   2729: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2732: pop
    //   2733: aload_1
    //   2734: aload_3
    //   2735: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2738: pop
    //   2739: aload_1
    //   2740: ldc_w 580
    //   2743: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2746: pop
    //   2747: aload_1
    //   2748: aload 26
    //   2750: invokevirtual 370	java/io/File:length	()J
    //   2753: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2756: pop
    //   2757: aload_1
    //   2758: ldc_w 620
    //   2761: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2764: pop
    //   2765: aload_1
    //   2766: aload 14
    //   2768: invokevirtual 370	java/io/File:length	()J
    //   2771: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2774: pop
    //   2775: aload_1
    //   2776: ldc_w 622
    //   2779: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2782: pop
    //   2783: aload_1
    //   2784: iload 11
    //   2786: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2789: pop
    //   2790: aload_1
    //   2791: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2794: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2797: new 95	java/lang/StringBuilder
    //   2800: dup
    //   2801: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2804: astore_1
    //   2805: aload_1
    //   2806: ldc_w 624
    //   2809: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2812: pop
    //   2813: aload_1
    //   2814: iconst_0
    //   2815: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2818: pop
    //   2819: aload_1
    //   2820: ldc_w 626
    //   2823: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2826: pop
    //   2827: aload_1
    //   2828: aload_3
    //   2829: invokestatic 519	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   2832: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2835: pop
    //   2836: aload_1
    //   2837: ldc_w 628
    //   2840: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2843: pop
    //   2844: aload 26
    //   2846: invokevirtual 370	java/io/File:length	()J
    //   2849: lconst_0
    //   2850: lcmp
    //   2851: ifgt +9 -> 2860
    //   2854: iconst_1
    //   2855: istore 4
    //   2857: goto +6 -> 2863
    //   2860: iconst_0
    //   2861: istore 4
    //   2863: aload_1
    //   2864: iload 4
    //   2866: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2869: pop
    //   2870: aload_1
    //   2871: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2874: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2877: iload 13
    //   2879: ifne +16 -> 2895
    //   2882: ldc_w 532
    //   2885: iconst_1
    //   2886: ldc_w 532
    //   2889: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2892: goto +74 -> 2966
    //   2895: ldc_w 532
    //   2898: iconst_0
    //   2899: ldc_w 532
    //   2902: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2905: goto +61 -> 2966
    //   2908: new 95	java/lang/StringBuilder
    //   2911: dup
    //   2912: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2915: astore_1
    //   2916: aload_1
    //   2917: ldc_w 630
    //   2920: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2923: pop
    //   2924: aload_1
    //   2925: aload 14
    //   2927: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2930: pop
    //   2931: aload_1
    //   2932: ldc_w 580
    //   2935: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2938: pop
    //   2939: aload_1
    //   2940: aload 14
    //   2942: invokevirtual 370	java/io/File:length	()J
    //   2945: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2948: pop
    //   2949: aload_1
    //   2950: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2953: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2956: ldc_w 532
    //   2959: iconst_0
    //   2960: ldc_w 532
    //   2963: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2966: aload 5
    //   2968: ldc_w 616
    //   2971: ldc_w 632
    //   2974: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   2977: iconst_0
    //   2978: ireturn
    //   2979: astore 25
    //   2981: aload 14
    //   2983: astore 15
    //   2985: ldc_w 588
    //   2988: astore 16
    //   2990: ldc_w 592
    //   2993: astore 18
    //   2995: ldc_w 596
    //   2998: astore 20
    //   3000: ldc_w 602
    //   3003: astore 21
    //   3005: ldc_w 590
    //   3008: astore 17
    //   3010: ldc_w 594
    //   3013: astore 19
    //   3015: ldc_w 532
    //   3018: astore 23
    //   3020: ldc_w 616
    //   3023: astore 24
    //   3025: ldc_w 580
    //   3028: astore 22
    //   3030: aload 25
    //   3032: astore 14
    //   3034: goto +85 -> 3119
    //   3037: ldc_w 580
    //   3040: astore 23
    //   3042: goto -1567 -> 1475
    //   3045: astore 25
    //   3047: goto +16 -> 3063
    //   3050: goto +79 -> 3129
    //   3053: astore 25
    //   3055: goto +8 -> 3063
    //   3058: goto +71 -> 3129
    //   3061: astore 25
    //   3063: ldc_w 616
    //   3066: astore 24
    //   3068: ldc_w 532
    //   3071: astore 23
    //   3073: ldc_w 580
    //   3076: astore 22
    //   3078: ldc_w 602
    //   3081: astore 21
    //   3083: ldc_w 596
    //   3086: astore 20
    //   3088: ldc_w 594
    //   3091: astore 19
    //   3093: ldc_w 592
    //   3096: astore 18
    //   3098: ldc_w 590
    //   3101: astore 17
    //   3103: ldc_w 588
    //   3106: astore 16
    //   3108: iconst_0
    //   3109: istore 10
    //   3111: aload 14
    //   3113: astore 15
    //   3115: aload 25
    //   3117: astore 14
    //   3119: iconst_0
    //   3120: istore 11
    //   3122: aload 15
    //   3124: astore 25
    //   3126: goto +792 -> 3918
    //   3129: ldc_w 616
    //   3132: astore 22
    //   3134: ldc_w 580
    //   3137: astore 23
    //   3139: ldc_w 532
    //   3142: astore 21
    //   3144: ldc_w 596
    //   3147: astore 19
    //   3149: ldc_w 592
    //   3152: astore 17
    //   3154: ldc_w 588
    //   3157: astore 15
    //   3159: ldc_w 602
    //   3162: astore 20
    //   3164: ldc_w 590
    //   3167: astore 16
    //   3169: ldc_w 594
    //   3172: astore 18
    //   3174: iconst_0
    //   3175: istore 10
    //   3177: aload 26
    //   3179: astore 24
    //   3181: ldc_w 662
    //   3184: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3187: aload 5
    //   3189: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   3192: iconst_1
    //   3193: if_icmpeq +21 -> 3214
    //   3196: aload 5
    //   3198: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   3201: iconst_1
    //   3202: if_icmpne +6 -> 3208
    //   3205: goto +9 -> 3214
    //   3208: iconst_0
    //   3209: istore 11
    //   3211: goto +6 -> 3217
    //   3214: iconst_1
    //   3215: istore 11
    //   3217: aload_3
    //   3218: invokestatic 570	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   3221: istore 12
    //   3223: new 95	java/lang/StringBuilder
    //   3226: dup
    //   3227: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3230: astore 25
    //   3232: aload 25
    //   3234: aload 15
    //   3236: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3239: pop
    //   3240: aload 25
    //   3242: aload 5
    //   3244: getfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   3247: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3250: pop
    //   3251: aload 25
    //   3253: aload 16
    //   3255: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3258: pop
    //   3259: aload 25
    //   3261: aload 5
    //   3263: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   3266: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3269: pop
    //   3270: aload 25
    //   3272: aload 17
    //   3274: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3277: pop
    //   3278: aload 25
    //   3280: iload 12
    //   3282: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3285: pop
    //   3286: aload 25
    //   3288: aload 18
    //   3290: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3293: pop
    //   3294: aload 25
    //   3296: iload 11
    //   3298: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3301: pop
    //   3302: aload 25
    //   3304: aload 19
    //   3306: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3309: pop
    //   3310: aload 25
    //   3312: aload 5
    //   3314: getfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   3317: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3320: pop
    //   3321: aload 25
    //   3323: ldc_w 598
    //   3326: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3329: pop
    //   3330: aload 25
    //   3332: aload 5
    //   3334: getfield 381	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   3337: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3340: pop
    //   3341: aload 25
    //   3343: ldc_w 600
    //   3346: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3349: pop
    //   3350: aload 25
    //   3352: invokestatic 276	com/tencent/mobileqq/util/Utils:b	()J
    //   3355: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3358: pop
    //   3359: aload 5
    //   3361: aload 20
    //   3363: aload 25
    //   3365: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3368: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   3371: aload 5
    //   3373: getfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   3376: ifne +33 -> 3409
    //   3379: aload 5
    //   3381: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   3384: ifeq +14 -> 3398
    //   3387: iload_0
    //   3388: iconst_3
    //   3389: aload_1
    //   3390: iconst_0
    //   3391: aconst_null
    //   3392: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3395: goto +174 -> 3569
    //   3398: iload_0
    //   3399: iconst_4
    //   3400: aload_1
    //   3401: iconst_0
    //   3402: aconst_null
    //   3403: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3406: goto +163 -> 3569
    //   3409: iload 12
    //   3411: ifne +158 -> 3569
    //   3414: iload 11
    //   3416: ifne +153 -> 3569
    //   3419: iload 10
    //   3421: ifne +148 -> 3569
    //   3424: aload 5
    //   3426: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3429: istore 8
    //   3431: aload 5
    //   3433: iload 8
    //   3435: iconst_1
    //   3436: iadd
    //   3437: putfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3440: iload 8
    //   3442: iconst_2
    //   3443: if_icmpge +33 -> 3476
    //   3446: aload 5
    //   3448: iconst_1
    //   3449: putfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   3452: ldc_w 604
    //   3455: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3458: iload_0
    //   3459: aload_1
    //   3460: aload_2
    //   3461: aload_3
    //   3462: iload 4
    //   3464: aload 5
    //   3466: iload 6
    //   3468: iload 7
    //   3470: invokestatic 539	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   3473: pop
    //   3474: iconst_0
    //   3475: ireturn
    //   3476: aload 5
    //   3478: getfield 337	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   3481: ifeq +15 -> 3496
    //   3484: iload_0
    //   3485: bipush 6
    //   3487: aload_1
    //   3488: iconst_0
    //   3489: aconst_null
    //   3490: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3493: goto +76 -> 3569
    //   3496: aload 5
    //   3498: getfield 606	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   3501: ifeq +15 -> 3516
    //   3504: iload_0
    //   3505: bipush 7
    //   3507: aload_1
    //   3508: iconst_0
    //   3509: aconst_null
    //   3510: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3513: goto +56 -> 3569
    //   3516: aload 5
    //   3518: getfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   3521: ifne +15 -> 3536
    //   3524: iload_0
    //   3525: bipush 9
    //   3527: aload_1
    //   3528: iconst_0
    //   3529: aconst_null
    //   3530: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3533: goto +36 -> 3569
    //   3536: aload 5
    //   3538: getfield 381	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   3541: ifeq +14 -> 3555
    //   3544: iload_0
    //   3545: iconst_0
    //   3546: aload_1
    //   3547: iconst_0
    //   3548: aconst_null
    //   3549: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3552: goto +17 -> 3569
    //   3555: ldc_w 608
    //   3558: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3561: iload_0
    //   3562: iconst_5
    //   3563: aload_1
    //   3564: iconst_0
    //   3565: aconst_null
    //   3566: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3569: aload 5
    //   3571: aload 14
    //   3573: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   3576: putfield 456	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   3579: aload 5
    //   3581: aload 14
    //   3583: invokevirtual 370	java/io/File:length	()J
    //   3586: putfield 523	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   3589: aload 5
    //   3591: iconst_0
    //   3592: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   3595: aload 5
    //   3597: iconst_0
    //   3598: putfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   3601: aload 24
    //   3603: invokevirtual 554	java/io/File:exists	()Z
    //   3606: ifeq +9 -> 3615
    //   3609: aload 24
    //   3611: invokevirtual 325	java/io/File:delete	()Z
    //   3614: pop
    //   3615: iload 11
    //   3617: ifne +181 -> 3798
    //   3620: iload 10
    //   3622: ifeq +6 -> 3628
    //   3625: goto +173 -> 3798
    //   3628: new 95	java/lang/StringBuilder
    //   3631: dup
    //   3632: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3635: astore_1
    //   3636: aload_1
    //   3637: ldc_w 618
    //   3640: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3643: pop
    //   3644: aload_1
    //   3645: aload_3
    //   3646: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3649: pop
    //   3650: aload_1
    //   3651: aload 23
    //   3653: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3656: pop
    //   3657: aload_1
    //   3658: aload 24
    //   3660: invokevirtual 370	java/io/File:length	()J
    //   3663: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3666: pop
    //   3667: aload_1
    //   3668: ldc_w 620
    //   3671: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3674: pop
    //   3675: aload_1
    //   3676: aload 14
    //   3678: invokevirtual 370	java/io/File:length	()J
    //   3681: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3684: pop
    //   3685: aload_1
    //   3686: ldc_w 622
    //   3689: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3692: pop
    //   3693: aload_1
    //   3694: iload 11
    //   3696: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3699: pop
    //   3700: aload_1
    //   3701: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3704: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3707: new 95	java/lang/StringBuilder
    //   3710: dup
    //   3711: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3714: astore_1
    //   3715: aload_1
    //   3716: ldc_w 624
    //   3719: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3722: pop
    //   3723: aload_1
    //   3724: iconst_1
    //   3725: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3728: pop
    //   3729: aload_1
    //   3730: ldc_w 626
    //   3733: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3736: pop
    //   3737: aload_1
    //   3738: aload_3
    //   3739: invokestatic 519	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   3742: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3745: pop
    //   3746: aload_1
    //   3747: ldc_w 628
    //   3750: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3753: pop
    //   3754: aload 24
    //   3756: invokevirtual 370	java/io/File:length	()J
    //   3759: lconst_0
    //   3760: lcmp
    //   3761: ifgt +9 -> 3770
    //   3764: iconst_1
    //   3765: istore 4
    //   3767: goto +6 -> 3773
    //   3770: iconst_0
    //   3771: istore 4
    //   3773: aload_1
    //   3774: iload 4
    //   3776: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3779: pop
    //   3780: aload_1
    //   3781: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3784: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3787: aload 21
    //   3789: iconst_1
    //   3790: aload 21
    //   3792: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3795: goto +58 -> 3853
    //   3798: new 95	java/lang/StringBuilder
    //   3801: dup
    //   3802: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3805: astore_1
    //   3806: aload_1
    //   3807: ldc_w 630
    //   3810: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3813: pop
    //   3814: aload_1
    //   3815: aload 14
    //   3817: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3820: pop
    //   3821: aload_1
    //   3822: aload 23
    //   3824: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3827: pop
    //   3828: aload_1
    //   3829: aload 14
    //   3831: invokevirtual 370	java/io/File:length	()J
    //   3834: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3837: pop
    //   3838: aload_1
    //   3839: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3842: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3845: aload 21
    //   3847: iconst_0
    //   3848: aload 21
    //   3850: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3853: aload 5
    //   3855: aload 22
    //   3857: ldc_w 632
    //   3860: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   3863: iconst_0
    //   3864: ireturn
    //   3865: astore 27
    //   3867: aload 23
    //   3869: astore 25
    //   3871: iconst_1
    //   3872: istore 11
    //   3874: aload 22
    //   3876: astore 24
    //   3878: aload 21
    //   3880: astore 23
    //   3882: aload 25
    //   3884: astore 22
    //   3886: aload 20
    //   3888: astore 21
    //   3890: aload 19
    //   3892: astore 20
    //   3894: aload 18
    //   3896: astore 19
    //   3898: aload 17
    //   3900: astore 18
    //   3902: aload 16
    //   3904: astore 17
    //   3906: aload 15
    //   3908: astore 16
    //   3910: aload 14
    //   3912: astore 25
    //   3914: aload 27
    //   3916: astore 14
    //   3918: aload_3
    //   3919: astore 15
    //   3921: aload 5
    //   3923: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   3926: iconst_1
    //   3927: if_icmpeq +21 -> 3948
    //   3930: aload 5
    //   3932: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   3935: iconst_1
    //   3936: if_icmpne +6 -> 3942
    //   3939: goto +9 -> 3948
    //   3942: iconst_0
    //   3943: istore 12
    //   3945: goto +6 -> 3951
    //   3948: iconst_1
    //   3949: istore 12
    //   3951: aload_3
    //   3952: invokestatic 570	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   3955: istore 13
    //   3957: new 95	java/lang/StringBuilder
    //   3960: dup
    //   3961: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3964: astore 27
    //   3966: aload 27
    //   3968: aload 16
    //   3970: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3973: pop
    //   3974: aload 27
    //   3976: aload 5
    //   3978: getfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   3981: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3984: pop
    //   3985: aload 27
    //   3987: aload 17
    //   3989: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3992: pop
    //   3993: aload 27
    //   3995: aload 5
    //   3997: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   4000: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4003: pop
    //   4004: aload 27
    //   4006: aload 18
    //   4008: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4011: pop
    //   4012: aload 27
    //   4014: iload 13
    //   4016: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4019: pop
    //   4020: aload 27
    //   4022: aload 19
    //   4024: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4027: pop
    //   4028: aload 27
    //   4030: iload 12
    //   4032: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4035: pop
    //   4036: aload 27
    //   4038: aload 20
    //   4040: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4043: pop
    //   4044: aload 27
    //   4046: aload 5
    //   4048: getfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   4051: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4054: pop
    //   4055: aload 27
    //   4057: ldc_w 598
    //   4060: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4063: pop
    //   4064: aload 27
    //   4066: aload 5
    //   4068: getfield 381	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   4071: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4074: pop
    //   4075: aload 27
    //   4077: ldc_w 600
    //   4080: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4083: pop
    //   4084: aload 27
    //   4086: invokestatic 276	com/tencent/mobileqq/util/Utils:b	()J
    //   4089: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4092: pop
    //   4093: aload 5
    //   4095: aload 21
    //   4097: aload 27
    //   4099: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4102: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   4105: aload 5
    //   4107: getfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   4110: ifne +33 -> 4143
    //   4113: aload 5
    //   4115: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   4118: ifeq +14 -> 4132
    //   4121: iload_0
    //   4122: iconst_3
    //   4123: aload_1
    //   4124: iconst_0
    //   4125: aconst_null
    //   4126: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   4129: goto +174 -> 4303
    //   4132: iload_0
    //   4133: iconst_4
    //   4134: aload_1
    //   4135: iconst_0
    //   4136: aconst_null
    //   4137: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   4140: goto +163 -> 4303
    //   4143: iload 13
    //   4145: ifne +158 -> 4303
    //   4148: iload 12
    //   4150: ifne +153 -> 4303
    //   4153: iload 10
    //   4155: ifne +148 -> 4303
    //   4158: aload 5
    //   4160: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   4163: istore 8
    //   4165: aload 5
    //   4167: iload 8
    //   4169: iconst_1
    //   4170: iadd
    //   4171: putfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   4174: iload 8
    //   4176: iconst_2
    //   4177: if_icmpge +33 -> 4210
    //   4180: aload 5
    //   4182: iconst_1
    //   4183: putfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   4186: ldc_w 604
    //   4189: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   4192: iload_0
    //   4193: aload_1
    //   4194: aload_2
    //   4195: aload_3
    //   4196: iload 4
    //   4198: aload 5
    //   4200: iload 6
    //   4202: iload 7
    //   4204: invokestatic 539	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   4207: pop
    //   4208: iconst_0
    //   4209: ireturn
    //   4210: aload 5
    //   4212: getfield 337	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   4215: ifeq +15 -> 4230
    //   4218: iload_0
    //   4219: bipush 6
    //   4221: aload_1
    //   4222: iconst_0
    //   4223: aconst_null
    //   4224: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   4227: goto +76 -> 4303
    //   4230: aload 5
    //   4232: getfield 606	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   4235: ifeq +15 -> 4250
    //   4238: iload_0
    //   4239: bipush 7
    //   4241: aload_1
    //   4242: iconst_0
    //   4243: aconst_null
    //   4244: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   4247: goto +56 -> 4303
    //   4250: aload 5
    //   4252: getfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   4255: ifne +15 -> 4270
    //   4258: iload_0
    //   4259: bipush 9
    //   4261: aload_1
    //   4262: iconst_0
    //   4263: aconst_null
    //   4264: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   4267: goto +36 -> 4303
    //   4270: aload 5
    //   4272: getfield 381	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   4275: ifeq +14 -> 4289
    //   4278: iload_0
    //   4279: iconst_0
    //   4280: aload_1
    //   4281: iconst_0
    //   4282: aconst_null
    //   4283: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   4286: goto +17 -> 4303
    //   4289: ldc_w 608
    //   4292: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   4295: iload_0
    //   4296: iconst_5
    //   4297: aload_1
    //   4298: iconst_0
    //   4299: aconst_null
    //   4300: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   4303: iload 11
    //   4305: ifne +295 -> 4600
    //   4308: iload 13
    //   4310: ifeq +290 -> 4600
    //   4313: aload 26
    //   4315: invokevirtual 370	java/io/File:length	()J
    //   4318: aload 25
    //   4320: invokevirtual 370	java/io/File:length	()J
    //   4323: lcmp
    //   4324: ifgt +276 -> 4600
    //   4327: iload 12
    //   4329: ifne +271 -> 4600
    //   4332: iload 10
    //   4334: ifeq +6 -> 4340
    //   4337: goto +263 -> 4600
    //   4340: aload 5
    //   4342: aload 26
    //   4344: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   4347: putfield 456	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   4350: aload 5
    //   4352: aload 26
    //   4354: invokevirtual 370	java/io/File:length	()J
    //   4357: putfield 523	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   4360: aload 5
    //   4362: iconst_1
    //   4363: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   4366: aload 5
    //   4368: iconst_1
    //   4369: putfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   4372: aload 26
    //   4374: invokestatic 573	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   4377: astore_2
    //   4378: new 95	java/lang/StringBuilder
    //   4381: dup
    //   4382: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4385: astore_3
    //   4386: aload_3
    //   4387: ldc_w 610
    //   4390: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4393: pop
    //   4394: aload_3
    //   4395: aload 25
    //   4397: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4400: pop
    //   4401: aload_3
    //   4402: ldc_w 612
    //   4405: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4408: pop
    //   4409: aload_3
    //   4410: aload 15
    //   4412: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4415: pop
    //   4416: aload_3
    //   4417: aload 22
    //   4419: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4422: pop
    //   4423: aload_3
    //   4424: aload 26
    //   4426: invokevirtual 370	java/io/File:length	()J
    //   4429: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4432: pop
    //   4433: aload_3
    //   4434: ldc_w 582
    //   4437: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4440: pop
    //   4441: aload_3
    //   4442: aload_2
    //   4443: getfield 76	android/graphics/BitmapFactory$Options:outWidth	I
    //   4446: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4449: pop
    //   4450: aload_3
    //   4451: ldc_w 584
    //   4454: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4457: pop
    //   4458: aload_3
    //   4459: aload_2
    //   4460: getfield 79	android/graphics/BitmapFactory$Options:outHeight	I
    //   4463: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4466: pop
    //   4467: aload_3
    //   4468: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4471: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   4474: aload 5
    //   4476: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   4479: ifle +48 -> 4527
    //   4482: new 95	java/lang/StringBuilder
    //   4485: dup
    //   4486: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4489: astore_2
    //   4490: aload_2
    //   4491: ldc_w 528
    //   4494: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4497: pop
    //   4498: aload_2
    //   4499: aload 5
    //   4501: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   4504: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4507: pop
    //   4508: aload_2
    //   4509: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4512: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   4515: iload_0
    //   4516: bipush 8
    //   4518: aload_1
    //   4519: iconst_0
    //   4520: aconst_null
    //   4521: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   4524: goto +11 -> 4535
    //   4527: iload_0
    //   4528: iconst_0
    //   4529: aload_1
    //   4530: iconst_1
    //   4531: aconst_null
    //   4532: invokestatic 530	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   4535: aload 5
    //   4537: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   4540: ifle +9 -> 4549
    //   4543: iconst_1
    //   4544: istore 4
    //   4546: goto +6 -> 4552
    //   4549: iconst_0
    //   4550: istore 4
    //   4552: aload 23
    //   4554: iload 4
    //   4556: aload 23
    //   4558: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   4561: new 95	java/lang/StringBuilder
    //   4564: dup
    //   4565: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4568: astore_1
    //   4569: aload_1
    //   4570: ldc_w 614
    //   4573: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4576: pop
    //   4577: aload_1
    //   4578: aload 5
    //   4580: getfield 526	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   4583: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4586: pop
    //   4587: aload 5
    //   4589: aload 24
    //   4591: aload_1
    //   4592: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4595: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   4598: iconst_1
    //   4599: ireturn
    //   4600: aload 5
    //   4602: aload 25
    //   4604: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   4607: putfield 456	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   4610: aload 5
    //   4612: aload 25
    //   4614: invokevirtual 370	java/io/File:length	()J
    //   4617: putfield 523	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   4620: aload 5
    //   4622: iconst_0
    //   4623: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   4626: aload 5
    //   4628: iconst_0
    //   4629: putfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   4632: aload 26
    //   4634: invokevirtual 554	java/io/File:exists	()Z
    //   4637: ifeq +9 -> 4646
    //   4640: aload 26
    //   4642: invokevirtual 325	java/io/File:delete	()Z
    //   4645: pop
    //   4646: iload 12
    //   4648: ifne +204 -> 4852
    //   4651: iload 10
    //   4653: ifne +199 -> 4852
    //   4656: new 95	java/lang/StringBuilder
    //   4659: dup
    //   4660: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4663: astore_1
    //   4664: aload_1
    //   4665: ldc_w 618
    //   4668: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4671: pop
    //   4672: aload_1
    //   4673: aload 15
    //   4675: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4678: pop
    //   4679: aload_1
    //   4680: aload 22
    //   4682: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4685: pop
    //   4686: aload_1
    //   4687: aload 26
    //   4689: invokevirtual 370	java/io/File:length	()J
    //   4692: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4695: pop
    //   4696: aload_1
    //   4697: ldc_w 620
    //   4700: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4703: pop
    //   4704: aload_1
    //   4705: aload 25
    //   4707: invokevirtual 370	java/io/File:length	()J
    //   4710: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4713: pop
    //   4714: aload_1
    //   4715: ldc_w 622
    //   4718: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4721: pop
    //   4722: aload_1
    //   4723: iload 12
    //   4725: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4728: pop
    //   4729: aload_1
    //   4730: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4733: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   4736: new 95	java/lang/StringBuilder
    //   4739: dup
    //   4740: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4743: astore_1
    //   4744: aload_1
    //   4745: ldc_w 624
    //   4748: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4751: pop
    //   4752: aload_1
    //   4753: iload 11
    //   4755: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4758: pop
    //   4759: aload_1
    //   4760: ldc_w 626
    //   4763: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4766: pop
    //   4767: aload_1
    //   4768: aload_3
    //   4769: invokestatic 519	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   4772: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4775: pop
    //   4776: aload_1
    //   4777: ldc_w 628
    //   4780: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4783: pop
    //   4784: aload 26
    //   4786: invokevirtual 370	java/io/File:length	()J
    //   4789: lconst_0
    //   4790: lcmp
    //   4791: ifgt +9 -> 4800
    //   4794: iconst_1
    //   4795: istore 4
    //   4797: goto +6 -> 4803
    //   4800: iconst_0
    //   4801: istore 4
    //   4803: aload_1
    //   4804: iload 4
    //   4806: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4809: pop
    //   4810: aload_1
    //   4811: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4814: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   4817: iload 11
    //   4819: ifne +22 -> 4841
    //   4822: iload 13
    //   4824: ifne +6 -> 4830
    //   4827: goto +14 -> 4841
    //   4830: aload 23
    //   4832: iconst_0
    //   4833: aload 23
    //   4835: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   4838: goto +69 -> 4907
    //   4841: aload 23
    //   4843: iconst_1
    //   4844: aload 23
    //   4846: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   4849: goto +58 -> 4907
    //   4852: new 95	java/lang/StringBuilder
    //   4855: dup
    //   4856: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4859: astore_1
    //   4860: aload_1
    //   4861: ldc_w 630
    //   4864: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4867: pop
    //   4868: aload_1
    //   4869: aload 25
    //   4871: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4874: pop
    //   4875: aload_1
    //   4876: aload 22
    //   4878: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4881: pop
    //   4882: aload_1
    //   4883: aload 25
    //   4885: invokevirtual 370	java/io/File:length	()J
    //   4888: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4891: pop
    //   4892: aload_1
    //   4893: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4896: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   4899: aload 23
    //   4901: iconst_0
    //   4902: aload 23
    //   4904: invokestatic 536	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   4907: aload 5
    //   4909: aload 24
    //   4911: ldc_w 632
    //   4914: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   4917: aload 14
    //   4919: athrow
    //   4920: iconst_0
    //   4921: ireturn
    //   4922: astore 15
    //   4924: goto -1795 -> 3129
    //   4927: astore 15
    //   4929: goto -1871 -> 3058
    //   4932: astore 15
    //   4934: goto -3467 -> 1467
    //   4937: astore 15
    //   4939: goto -3472 -> 1467
    //   4942: astore 15
    //   4944: goto -1894 -> 3050
    //   4947: astore 15
    //   4949: goto -1912 -> 3037
    //   4952: astore 15
    //   4954: goto -3003 -> 1951
    //   4957: astore 16
    //   4959: goto -3345 -> 1614
    //   4962: astore 15
    //   4964: goto -3168 -> 1796
    //   4967: astore 15
    //   4969: goto -3269 -> 1700
    //   4972: astore 15
    //   4974: goto -3189 -> 1785
    //   4977: astore 15
    //   4979: goto -3086 -> 1893
    //   4982: astore 16
    //   4984: goto -3160 -> 1824
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4987	0	paramInt1	int
    //   0	4987	1	paramContext	Context
    //   0	4987	2	paramString1	String
    //   0	4987	3	paramString2	String
    //   0	4987	4	paramBoolean1	boolean
    //   0	4987	5	paramImageInfo	ImageInfo
    //   0	4987	6	paramInt2	int
    //   0	4987	7	paramBoolean2	boolean
    //   639	1120	8	i	int
    //   1626	135	9	j	int
    //   353	1180	10	bool1	boolean
    //   430	1002	11	bool2	boolean
    //   33	1718	14	localObject1	Object
    //   122	1602	15	localObject2	Object
    //   1780	1	15	localObject3	Object
    //   1799	1	15	localObject4	Object
    //   1804	1	15	localObject5	Object
    //   262	80	16	localStringBuilder	StringBuilder
    //   380	1	16	localObject6	Object
    //   1391	58	16	localObject7	Object
    //   1454	143	16	localObject8	Object
    //   1604	1	16	localObject9	Object
    //   1728	1	16	str1	String
    //   1791	1	16	localObject10	Object
    //   1424	310	17	localObject11	Object
    //   1419	320	18	str2	String
    //   1446	298	19	str3	String
    //   1414	305	20	str4	String
    //   1436	268	21	str5	String
    //   1441	273	22	localObject12	Object
    //   1409	300	23	str6	String
    //   1404	1	24	str7	String
    //   1428	1	25	localObject13	Object
    //   103	1650	26	localFile	File
    // Exception table:
    //   from	to	target	type
    //   371	377	380	finally
    //   360	366	1391	finally
    //   385	396	1391	finally
    //   1596	1601	1604	finally
    //   1748	1769	1780	finally
    //   1614	1628	1791	finally
    //   1587	1596	1799	finally
    //   1566	1587	1804	finally
    //   1668	1697	1827	finally
    //   1769	1777	1827	finally
    //   1819	1824	1827	finally
    //   1824	1827	1827	finally
    //   1537	1566	1941	finally
    //   1525	1532	2979	finally
    //   1518	1525	3045	finally
    //   290	355	3053	finally
    //   228	290	3061	finally
    //   3181	3187	3865	finally
    //   228	290	4922	java/io/IOException
    //   290	355	4927	java/io/IOException
    //   360	366	4932	java/io/IOException
    //   385	396	4932	java/io/IOException
    //   371	377	4937	java/io/IOException
    //   1518	1525	4942	java/io/IOException
    //   1525	1532	4947	java/io/IOException
    //   1537	1566	4952	java/io/IOException
    //   1596	1601	4957	java/io/IOException
    //   1614	1628	4962	java/io/IOException
    //   1668	1697	4967	java/io/IOException
    //   1748	1769	4972	java/io/IOException
    //   1769	1777	4977	java/io/IOException
    //   1824	1827	4977	java/io/IOException
    //   1819	1824	4982	java/io/IOException
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "image_upload";
    }
    if (!FileUtils.fileExistsAndNotEmpty(paramString1)) {
      try
      {
        if (!FileUtils.fileExists(paramString1))
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append(paramString3);
            paramString2.append(",filePath not exist,filePath=");
            paramString2.append(paramString1);
            QLog.e(str, 2, paramString2.toString());
          }
          paramString2 = new StringBuilder();
          paramString2.append(paramString3);
          paramString2.append(" file not exists,path=");
          paramString2.append(paramString1);
          throw new RuntimeException(paramString2.toString());
        }
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append(paramString3);
          paramString2.append(",filePath size is 0,filePath=");
          paramString2.append(paramString1);
          QLog.e(str, 2, paramString2.toString());
        }
        paramString2 = new StringBuilder();
        paramString2.append(paramString3);
        paramString2.append(" file size==0,path=");
        paramString2.append(paramString1);
        throw new RuntimeException(paramString2.toString());
      }
      catch (Exception paramString2)
      {
        paramString2 = ProcessorReport.getExceptionMessage(paramString2);
        if (!FileUtils.fileExists(paramString1))
        {
          a(paramInt, 1, paramContext, false, "report_sendphoto_file_error", paramString2);
          return false;
        }
        a(paramInt, 2, paramContext, false, "report_sendphoto_file_error", paramString2);
        return false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString3);
      paramString2.append(",filePath not exist,filePath=");
      paramString2.append(paramString1);
      QLog.e(str, 2, paramString2.toString());
    }
    a(paramInt, 0, paramContext, true, "report_sendphoto_file_error");
    return true;
  }
  
  public static Bitmap b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    if (paramInt == 102)
    {
      localObject2 = localObject1;
      if (GlobalImageCache.a != null) {
        localObject2 = (Bitmap)GlobalImageCache.a.get("static://DefaultDataLineFace");
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130844282);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (GlobalImageCache.a != null)
          {
            GlobalImageCache.a.put("static://DefaultDataLineFace", localObject2, (byte)0);
            return localObject2;
          }
        }
      }
    }
    else
    {
      localObject1 = localObject3;
      if (paramInt == 107)
      {
        if (GlobalImageCache.a != null) {
          localObject2 = (Bitmap)GlobalImageCache.a.get("static://DefaultDataLineFaceIpad");
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130844277);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (GlobalImageCache.a != null)
            {
              GlobalImageCache.a.put("static://DefaultDataLineFaceIpad", localObject2, (byte)0);
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public static Drawable b(int paramInt)
  {
    return new BitmapDrawable(b(paramInt));
  }
  
  public static String b(Context paramContext, String paramString, int paramInt)
  {
    return a(paramContext, paramString, paramInt, 0);
  }
  
  /* Error */
  private static void b(int paramInt1, Context paramContext, File paramFile1, File paramFile2, ImageInfo paramImageInfo, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: new 95	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   7: astore 19
    //   9: aload 19
    //   11: ldc_w 693
    //   14: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 19
    //   20: iload 7
    //   22: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 19
    //   28: ldc_w 310
    //   31: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 19
    //   37: iload 6
    //   39: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 4
    //   45: ldc_w 312
    //   48: aload 19
    //   50: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload 4
    //   58: iconst_1
    //   59: putfield 695	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Boolean	Z
    //   62: aload_2
    //   63: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   66: invokestatic 698	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   69: astore 21
    //   71: goto +58 -> 129
    //   74: new 95	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   81: astore 19
    //   83: aload 19
    //   85: ldc_w 700
    //   88: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 19
    //   94: aload_2
    //   95: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 19
    //   101: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   107: aload_1
    //   108: invokestatic 318	com/tencent/mobileqq/utils/NetworkUtil:isWifiEnabled	(Landroid/content/Context;)Z
    //   111: ifeq +1123 -> 1234
    //   114: aload 4
    //   116: iconst_1
    //   117: putfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   120: aload 4
    //   122: iconst_0
    //   123: putfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   126: aconst_null
    //   127: astore 21
    //   129: getstatic 397	com/tencent/common/config/AppSetting:jdField_c_of_type_Int	I
    //   132: i2l
    //   133: lstore 15
    //   135: aload 4
    //   137: getfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   140: ifeq +702 -> 842
    //   143: aload 21
    //   145: ifnonnull +6 -> 151
    //   148: goto +694 -> 842
    //   151: aload_1
    //   152: invokestatic 318	com/tencent/mobileqq/utils/NetworkUtil:isWifiEnabled	(Landroid/content/Context;)Z
    //   155: ifeq +10 -> 165
    //   158: bipush 80
    //   160: istore 10
    //   162: goto +7 -> 169
    //   165: bipush 70
    //   167: istore 10
    //   169: new 339	java/io/FileOutputStream
    //   172: dup
    //   173: aload_3
    //   174: invokespecial 342	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   177: astore 19
    //   179: aload 4
    //   181: aload 21
    //   183: getstatic 348	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   186: iload 10
    //   188: aload 19
    //   190: invokevirtual 351	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   193: putfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   196: aload 4
    //   198: iconst_1
    //   199: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   202: aload 4
    //   204: getfield 354	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   207: ifeq +1076 -> 1283
    //   210: aload 19
    //   212: invokestatic 360	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/FileOutputStream;)V
    //   215: goto +1068 -> 1283
    //   218: ldc_w 385
    //   221: invokestatic 391	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   224: checkcast 385	com/tencent/mobileqq/pic/api/IPicBus
    //   227: invokeinterface 394 1 0
    //   232: lstore 17
    //   234: lload 17
    //   236: l2i
    //   237: istore 10
    //   239: ldc_w 702
    //   242: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   245: aload_3
    //   246: invokevirtual 370	java/io/File:length	()J
    //   249: iload 10
    //   251: i2l
    //   252: lcmp
    //   253: ifle +20 -> 273
    //   256: aload_2
    //   257: invokestatic 407	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   260: istore 12
    //   262: iload 12
    //   264: ifne +9 -> 273
    //   267: iconst_1
    //   268: istore 10
    //   270: goto +6 -> 276
    //   273: iconst_0
    //   274: istore 10
    //   276: aload 19
    //   278: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   281: goto +42 -> 323
    //   284: astore 19
    //   286: new 95	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   293: astore 20
    //   295: aload 20
    //   297: ldc_w 704
    //   300: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 20
    //   306: aload 19
    //   308: invokevirtual 419	java/io/IOException:getMessage	()Ljava/lang/String;
    //   311: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 20
    //   317: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   323: iload 10
    //   325: istore 11
    //   327: aload 21
    //   329: ifnull +279 -> 608
    //   332: iload 10
    //   334: istore 11
    //   336: aload 21
    //   338: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   341: ifne +267 -> 608
    //   344: aload 21
    //   346: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   349: iload 10
    //   351: istore 11
    //   353: goto +255 -> 608
    //   356: astore_1
    //   357: aload 19
    //   359: astore_2
    //   360: goto +12 -> 372
    //   363: goto +17 -> 380
    //   366: goto +130 -> 496
    //   369: astore_1
    //   370: aconst_null
    //   371: astore_2
    //   372: iconst_0
    //   373: istore_0
    //   374: goto +387 -> 761
    //   377: aconst_null
    //   378: astore 19
    //   380: aload 19
    //   382: astore 20
    //   384: ldc_w 706
    //   387: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   390: aload 4
    //   392: iconst_1
    //   393: putfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   396: aload 4
    //   398: iconst_0
    //   399: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   402: aload 19
    //   404: ifnull +50 -> 454
    //   407: aload 19
    //   409: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   412: goto +42 -> 454
    //   415: astore 19
    //   417: new 95	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   424: astore 20
    //   426: aload 20
    //   428: ldc_w 704
    //   431: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 20
    //   437: aload 19
    //   439: invokevirtual 419	java/io/IOException:getMessage	()Ljava/lang/String;
    //   442: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 20
    //   448: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   454: aload_3
    //   455: ifnull +8 -> 463
    //   458: aload_3
    //   459: invokevirtual 325	java/io/File:delete	()Z
    //   462: pop
    //   463: aload 21
    //   465: ifnull +140 -> 605
    //   468: aload 21
    //   470: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   473: ifne +132 -> 605
    //   476: aload 21
    //   478: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   481: goto +124 -> 605
    //   484: astore_1
    //   485: iconst_1
    //   486: istore_0
    //   487: aload 19
    //   489: astore_2
    //   490: goto +271 -> 761
    //   493: aconst_null
    //   494: astore 19
    //   496: aload 19
    //   498: astore 20
    //   500: ldc_w 708
    //   503: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   506: aload 19
    //   508: astore 20
    //   510: aload 4
    //   512: iconst_0
    //   513: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   516: aload 19
    //   518: astore 20
    //   520: aload 4
    //   522: invokestatic 378	com/tencent/mobileqq/utils/ImageUtil:a	()Z
    //   525: putfield 381	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   528: aload 19
    //   530: ifnull +50 -> 580
    //   533: aload 19
    //   535: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   538: goto +42 -> 580
    //   541: astore 19
    //   543: new 95	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   550: astore 20
    //   552: aload 20
    //   554: ldc_w 704
    //   557: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 20
    //   563: aload 19
    //   565: invokevirtual 419	java/io/IOException:getMessage	()Ljava/lang/String;
    //   568: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 20
    //   574: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   580: aload_3
    //   581: ifnull +8 -> 589
    //   584: aload_3
    //   585: invokevirtual 325	java/io/File:delete	()Z
    //   588: pop
    //   589: aload 21
    //   591: ifnull +14 -> 605
    //   594: aload 21
    //   596: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   599: ifne +6 -> 605
    //   602: goto -126 -> 476
    //   605: iconst_0
    //   606: istore 11
    //   608: iload 11
    //   610: ifeq +514 -> 1124
    //   613: aload_3
    //   614: invokevirtual 554	java/io/File:exists	()Z
    //   617: ifeq +726 -> 1343
    //   620: aload_3
    //   621: invokevirtual 325	java/io/File:delete	()Z
    //   624: ifeq +719 -> 1343
    //   627: aload_3
    //   628: invokevirtual 412	java/io/File:createNewFile	()Z
    //   631: ifeq +712 -> 1343
    //   634: iconst_1
    //   635: istore 12
    //   637: goto +3 -> 640
    //   640: new 95	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   647: astore 19
    //   649: aload 19
    //   651: ldc_w 710
    //   654: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: aload 19
    //   660: aload_3
    //   661: invokevirtual 370	java/io/File:length	()J
    //   664: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 19
    //   670: ldc_w 712
    //   673: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 19
    //   679: iload 12
    //   681: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload 4
    //   687: ldc_w 312
    //   690: aload 19
    //   692: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   698: iload 12
    //   700: ifeq +424 -> 1124
    //   703: aload 4
    //   705: iconst_0
    //   706: putfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   709: aload 4
    //   711: iconst_0
    //   712: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   715: aload 4
    //   717: iconst_0
    //   718: putfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   721: iload_0
    //   722: aload_1
    //   723: aload_2
    //   724: aload_3
    //   725: aload 4
    //   727: iload 5
    //   729: iload 6
    //   731: iload 7
    //   733: iload 8
    //   735: iload 9
    //   737: invokestatic 660	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   740: return
    //   741: ldc_w 714
    //   744: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   747: aload 4
    //   749: iconst_0
    //   750: putfield 357	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   753: return
    //   754: astore_1
    //   755: aload 20
    //   757: astore_2
    //   758: goto -386 -> 372
    //   761: aload_2
    //   762: ifnull +47 -> 809
    //   765: aload_2
    //   766: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   769: goto +40 -> 809
    //   772: astore_2
    //   773: new 95	java/lang/StringBuilder
    //   776: dup
    //   777: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   780: astore 4
    //   782: aload 4
    //   784: ldc_w 704
    //   787: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload 4
    //   793: aload_2
    //   794: invokevirtual 419	java/io/IOException:getMessage	()Ljava/lang/String;
    //   797: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: pop
    //   801: aload 4
    //   803: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   806: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   809: iload_0
    //   810: ifeq +12 -> 822
    //   813: aload_3
    //   814: ifnull +8 -> 822
    //   817: aload_3
    //   818: invokevirtual 325	java/io/File:delete	()Z
    //   821: pop
    //   822: aload 21
    //   824: ifnull +16 -> 840
    //   827: aload 21
    //   829: invokevirtual 212	android/graphics/Bitmap:isRecycled	()Z
    //   832: ifne +8 -> 840
    //   835: aload 21
    //   837: invokevirtual 221	android/graphics/Bitmap:recycle	()V
    //   840: aload_1
    //   841: athrow
    //   842: aload 4
    //   844: ldc_w 312
    //   847: ldc_w 716
    //   850: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   853: iload 5
    //   855: sipush 1001
    //   858: if_icmpeq +15 -> 873
    //   861: lload 15
    //   863: lstore 17
    //   865: iload 5
    //   867: sipush 10002
    //   870: if_icmpne +63 -> 933
    //   873: lload 15
    //   875: lstore 17
    //   877: aload_1
    //   878: ifnull +55 -> 933
    //   881: lload 15
    //   883: lstore 17
    //   885: aload_1
    //   886: instanceof 118
    //   889: ifeq +44 -> 933
    //   892: lload 15
    //   894: lstore 17
    //   896: aload_1
    //   897: checkcast 118	com/tencent/mobileqq/app/BaseActivity
    //   900: invokevirtual 122	com/tencent/mobileqq/app/BaseActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   903: checkcast 124	com/tencent/mobileqq/app/QQAppInterface
    //   906: aload 4
    //   908: getfield 462	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   911: invokevirtual 466	com/tencent/mobileqq/app/QQAppInterface:isLBSFriendNewClient	(Ljava/lang/String;)Z
    //   914: ifeq +19 -> 933
    //   917: ldc_w 385
    //   920: invokestatic 391	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   923: checkcast 385	com/tencent/mobileqq/pic/api/IPicBus
    //   926: invokeinterface 460 1 0
    //   931: lstore 17
    //   933: iload 5
    //   935: ifne +31 -> 966
    //   938: aload_2
    //   939: invokevirtual 370	java/io/File:length	()J
    //   942: ldc_w 385
    //   945: invokestatic 391	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   948: checkcast 385	com/tencent/mobileqq/pic/api/IPicBus
    //   951: invokeinterface 460 1 0
    //   956: lcmp
    //   957: ifle +9 -> 966
    //   960: iconst_1
    //   961: istore 12
    //   963: goto +6 -> 969
    //   966: iconst_0
    //   967: istore 12
    //   969: iload 5
    //   971: sipush 1001
    //   974: if_icmpeq +11 -> 985
    //   977: iload 5
    //   979: sipush 10002
    //   982: if_icmpne +19 -> 1001
    //   985: aload_2
    //   986: invokevirtual 370	java/io/File:length	()J
    //   989: lload 17
    //   991: lcmp
    //   992: ifle +9 -> 1001
    //   995: iconst_1
    //   996: istore 13
    //   998: goto +6 -> 1004
    //   1001: iconst_0
    //   1002: istore 13
    //   1004: iload 5
    //   1006: iconst_1
    //   1007: if_icmpeq +11 -> 1018
    //   1010: iload 5
    //   1012: sipush 3000
    //   1015: if_icmpne +31 -> 1046
    //   1018: aload_2
    //   1019: invokevirtual 370	java/io/File:length	()J
    //   1022: ldc_w 385
    //   1025: invokestatic 391	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1028: checkcast 385	com/tencent/mobileqq/pic/api/IPicBus
    //   1031: invokeinterface 394 1 0
    //   1036: lcmp
    //   1037: ifle +9 -> 1046
    //   1040: iconst_1
    //   1041: istore 14
    //   1043: goto +6 -> 1049
    //   1046: iconst_0
    //   1047: istore 14
    //   1049: iload 12
    //   1051: ifne +74 -> 1125
    //   1054: iload 13
    //   1056: ifne +69 -> 1125
    //   1059: iload 14
    //   1061: ifeq +6 -> 1067
    //   1064: goto +61 -> 1125
    //   1067: aload 4
    //   1069: iconst_1
    //   1070: putfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   1073: aload 4
    //   1075: iconst_0
    //   1076: putfield 322	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   1079: iload 5
    //   1081: ifne +9 -> 1090
    //   1084: aload 4
    //   1086: iconst_2
    //   1087: putfield 150	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Int	I
    //   1090: new 95	java/lang/StringBuilder
    //   1093: dup
    //   1094: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1097: astore_1
    //   1098: aload_1
    //   1099: ldc_w 718
    //   1102: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: pop
    //   1106: aload_1
    //   1107: aload_2
    //   1108: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1111: pop
    //   1112: aload 4
    //   1114: ldc_w 312
    //   1117: aload_1
    //   1118: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1124: return
    //   1125: new 95	java/lang/StringBuilder
    //   1128: dup
    //   1129: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1132: astore 19
    //   1134: aload 19
    //   1136: ldc_w 720
    //   1139: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: pop
    //   1143: aload 19
    //   1145: aload_2
    //   1146: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1149: pop
    //   1150: aload 19
    //   1152: ldc_w 722
    //   1155: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: pop
    //   1159: aload 19
    //   1161: iload 12
    //   1163: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: aload 19
    //   1169: ldc_w 724
    //   1172: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: pop
    //   1176: aload 19
    //   1178: iload 13
    //   1180: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1183: pop
    //   1184: aload 19
    //   1186: ldc_w 726
    //   1189: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1192: pop
    //   1193: aload 19
    //   1195: iload 14
    //   1197: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1200: pop
    //   1201: aload 4
    //   1203: ldc_w 312
    //   1206: aload 19
    //   1208: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1211: invokestatic 315	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1214: iload_0
    //   1215: aload_1
    //   1216: aload_2
    //   1217: aload_3
    //   1218: aload 4
    //   1220: iload 5
    //   1222: iload 6
    //   1224: iload 7
    //   1226: iload 8
    //   1228: iload 9
    //   1230: invokestatic 660	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   1233: return
    //   1234: iload_0
    //   1235: aload_1
    //   1236: aload_2
    //   1237: aload_3
    //   1238: aload 4
    //   1240: iload 5
    //   1242: iload 6
    //   1244: iload 7
    //   1246: iload 8
    //   1248: iload 9
    //   1250: invokestatic 660	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   1253: return
    //   1254: astore 19
    //   1256: goto -1182 -> 74
    //   1259: astore 19
    //   1261: goto -768 -> 493
    //   1264: astore 19
    //   1266: goto -889 -> 377
    //   1269: astore 20
    //   1271: goto -905 -> 366
    //   1274: astore 20
    //   1276: goto -913 -> 363
    //   1279: astore_1
    //   1280: goto -539 -> 741
    //   1283: iload 5
    //   1285: iconst_1
    //   1286: if_icmpeq +30 -> 1316
    //   1289: iload 5
    //   1291: sipush 1001
    //   1294: if_icmpeq +22 -> 1316
    //   1297: iload 5
    //   1299: sipush 10002
    //   1302: if_icmpeq +14 -> 1316
    //   1305: iload 5
    //   1307: sipush 3000
    //   1310: if_icmpne -1037 -> 273
    //   1313: goto +3 -> 1316
    //   1316: lload 15
    //   1318: lstore 17
    //   1320: iload 5
    //   1322: sipush 1001
    //   1325: if_icmpeq -1091 -> 234
    //   1328: iload 5
    //   1330: sipush 10002
    //   1333: if_icmpne -1115 -> 218
    //   1336: lload 15
    //   1338: lstore 17
    //   1340: goto -1106 -> 234
    //   1343: iconst_0
    //   1344: istore 12
    //   1346: goto -706 -> 640
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1349	0	paramInt1	int
    //   0	1349	1	paramContext	Context
    //   0	1349	2	paramFile1	File
    //   0	1349	3	paramFile2	File
    //   0	1349	4	paramImageInfo	ImageInfo
    //   0	1349	5	paramInt2	int
    //   0	1349	6	paramInt3	int
    //   0	1349	7	paramInt4	int
    //   0	1349	8	paramBoolean1	boolean
    //   0	1349	9	paramBoolean2	boolean
    //   160	190	10	i	int
    //   325	284	11	j	int
    //   260	1085	12	bool1	boolean
    //   996	183	13	bool2	boolean
    //   1041	155	14	bool3	boolean
    //   133	1204	15	l1	long
    //   232	1107	17	l2	long
    //   7	270	19	localObject1	Object
    //   284	74	19	localIOException1	java.io.IOException
    //   378	30	19	localObject2	Object
    //   415	73	19	localIOException2	java.io.IOException
    //   494	40	19	localObject3	Object
    //   541	23	19	localIOException3	java.io.IOException
    //   647	560	19	localStringBuilder	StringBuilder
    //   1254	1	19	localOutOfMemoryError1	OutOfMemoryError
    //   1259	1	19	localException1	Exception
    //   1264	1	19	localOutOfMemoryError2	OutOfMemoryError
    //   293	463	20	localObject4	Object
    //   1269	1	20	localException2	Exception
    //   1274	1	20	localOutOfMemoryError3	OutOfMemoryError
    //   69	767	21	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   276	281	284	java/io/IOException
    //   179	215	356	finally
    //   218	234	356	finally
    //   239	262	356	finally
    //   169	179	369	finally
    //   407	412	415	java/io/IOException
    //   390	402	484	finally
    //   533	538	541	java/io/IOException
    //   384	390	754	finally
    //   500	506	754	finally
    //   510	516	754	finally
    //   520	528	754	finally
    //   765	769	772	java/io/IOException
    //   62	71	1254	java/lang/OutOfMemoryError
    //   169	179	1259	java/lang/Exception
    //   169	179	1264	java/lang/OutOfMemoryError
    //   179	215	1269	java/lang/Exception
    //   218	234	1269	java/lang/Exception
    //   239	262	1269	java/lang/Exception
    //   179	215	1274	java/lang/OutOfMemoryError
    //   218	234	1274	java/lang/OutOfMemoryError
    //   239	262	1274	java/lang/OutOfMemoryError
    //   613	634	1279	java/io/IOException
    //   640	698	1279	java/io/IOException
    //   703	740	1279	java/io/IOException
  }
  
  public static int d(String paramString)
  {
    if (PhotoIncompatibleBase.b(paramString)) {
      return com.tencent.image.Utils.getHeifOrientation(paramString);
    }
    return JpegExifReader.readOrientation(paramString);
  }
  
  public static int e(String paramString)
  {
    int i = JpegExifReader.readOrientation(paramString);
    if (i == 6) {
      return 1;
    }
    if (i == 3) {
      return 2;
    }
    if (i == 8) {
      return 3;
    }
    return 0;
  }
  
  public static Bitmap i()
  {
    Object localObject = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), BaseApplicationImpl.sApplication, 2);
    if ((localObject != null) && (((IPublicAccountConfigUtil.PublicAccountConfigFolder)localObject).a() != null))
    {
      localObject = ((IPublicAccountConfigUtil.PublicAccountConfigFolder)localObject).a();
      if ((localObject instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localObject).getBitmap();
      }
      return ((BitmapDrawable)localObject).getBitmap();
    }
    localObject = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplicationImpl.context, 2);
    if ((localObject instanceof SkinnableBitmapDrawable)) {
      return ((SkinnableBitmapDrawable)localObject).getBitmap();
    }
    return ((BitmapDrawable)localObject).getBitmap();
  }
  
  public static Bitmap j()
  {
    Object localObject = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), BaseApplicationImpl.sApplication, 3);
    if ((localObject != null) && (((IPublicAccountConfigUtil.PublicAccountConfigFolder)localObject).a() != null))
    {
      localObject = ((IPublicAccountConfigUtil.PublicAccountConfigFolder)localObject).a();
      if ((localObject instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localObject).getBitmap();
      }
      return ((BitmapDrawable)localObject).getBitmap();
    }
    localObject = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplicationImpl.context, 3);
    if ((localObject instanceof SkinnableBitmapDrawable)) {
      return ((SkinnableBitmapDrawable)localObject).getBitmap();
    }
    return ((BitmapDrawable)localObject).getBitmap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ImageUtil
 * JD-Core Version:    0.7.0.1
 */