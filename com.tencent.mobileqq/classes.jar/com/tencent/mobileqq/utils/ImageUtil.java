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
import android.media.ExifInterface;
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
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExifInfoSwitch;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
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
import org.json.JSONObject;

public class ImageUtil
  extends BaseImageUtil
{
  public static Bitmap a(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramInt == 0) || (paramInt == 2))
    {
      localObject2 = localObject1;
      if (GlobalImageCache.a != null) {
        localObject2 = (Bitmap)GlobalImageCache.a.get("static://DefaultQQStoryRoundFace");
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = c(BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130846815), 10.0F, 70, 70);
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
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject1;
            localObject1 = localObject3;
          } while (paramInt != 1);
          if (GlobalImageCache.a != null) {
            localObject2 = (Bitmap)GlobalImageCache.a.get("static://DefaultQQStoryFace");
          }
          localObject1 = localObject2;
        } while (localObject2 != null);
        localObject2 = c(BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130846815), 70, 70);
        localObject1 = localObject2;
      } while (localObject2 == null);
      localObject1 = localObject2;
    } while (GlobalImageCache.a == null);
    GlobalImageCache.a.put("static://DefaultQQStoryFace", localObject2);
    return localObject2;
  }
  
  private static Bitmap a(int paramInt1, Context paramContext, File paramFile, int paramInt2, ImageInfo paramImageInfo)
  {
    Object localObject2 = null;
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    BitmapFactory.Options localOptions2 = a(localOptions1, paramFile.getPath(), paramInt2);
    if ((localOptions1.outWidth > 960) || (localOptions1.outHeight > 960)) {
      a("report_sendphoto_not_larger_960", paramContext, true);
    }
    for (;;)
    {
      paramInt2 = 1;
      paramInt1 = 0;
      Bitmap localBitmap = null;
      for (;;)
      {
        if (((localBitmap != null) || (localOptions2.inSampleSize <= 0) || (localOptions2.inSampleSize > 4)) && (paramInt2 == 0)) {
          break label290;
        }
        if (paramInt2 == 0) {
          localOptions2.inSampleSize *= 2;
        }
        try
        {
          localBitmap = SafeBitmapFactory.decodeFile(paramFile.getPath(), localOptions2);
          paramInt2 = 0;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          a("compress : compressNoLargePhoto  getBitmap  OOM " + localOptions2.inSampleSize);
          paramInt1 = localOptions1.outWidth * localOptions1.outHeight;
          if ((paramInt1 > URLDrawableHelper.smallSize) || (paramInt1 <= 0)) {
            break label195;
          }
          ImageTestUtil.a(((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getCurrentAccountUin());
          if (!NetworkUtil.h(paramContext)) {
            break label280;
          }
        }
      }
      a("report_sendphoto_not_larger_960", paramContext, false);
    }
    label195:
    paramImageInfo.jdField_i_of_type_Int = 1;
    paramImageInfo.g = true;
    if (paramImageInfo.jdField_c_of_type_Int == 0)
    {
      paramImageInfo.jdField_h_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ImageUtil", 2, "WIFI oom ,c2c send srcfile by raw");
      }
      label242:
      paramInt1 = 1;
    }
    label280:
    Object localObject1;
    label290:
    for (paramContext = localObject2;; paramContext = localObject1)
    {
      if ((paramContext == null) && (paramInt1 != 0)) {
        paramImageInfo.g = true;
      }
      return paramContext;
      if (!QLog.isColorLevel()) {
        break label242;
      }
      QLog.d("ImageUtil", 2, "WIFI oom ,not c2c send srcfile by nor");
      break label242;
      paramInt2 = 0;
      paramInt1 = 1;
      localObject1 = null;
      break;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, File paramFile)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = new Matrix();
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      int k = Math.max(i, j);
      float f = a / (k * 1.0F);
      k = c(paramFile.getPath());
      if (f < 1.0F) {}
      try
      {
        ((Matrix)localObject).postScale(f, f);
        if ((k != 0) && (k % 90 == 0)) {
          ((Matrix)localObject).postRotate(k, i / 2.0F, j / 2.0F);
        }
        paramFile = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, true);
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          a("compress : " + paramFile.getMessage());
          paramFile = null;
        }
      }
      catch (OutOfMemoryError paramFile)
      {
        for (;;)
        {
          a("compress :  scaleBitmap OOM");
          paramFile = null;
        }
      }
      localObject = paramBitmap;
    } while (paramFile == null);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!paramBitmap.equals(paramFile))) {
      paramBitmap.recycle();
    }
    return paramFile;
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
    if ((paramInt1 < 0) || (paramInt1 > 7) || (paramInt2 < 0) || (paramInt2 > 9)) {
      return;
    }
    String str2 = null;
    String str1 = str2;
    if (paramContext != null) {
      str1 = str2;
    }
    try
    {
      if ((paramContext instanceof BaseActivity)) {
        str1 = ((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getCurrentAccountUin();
      }
      localHashMap = new HashMap();
      if (paramBoolean) {
        break label229;
      }
      String str3 = String.valueOf(paramInt2 * 10 + paramInt1 + 88100);
      localHashMap.put("param_FailCode", str3);
      str2 = paramString2;
      if (paramString2 == null) {
        str2 = BaseTransProcessor.getExceptionMessage(new RuntimeException(str3));
      }
      if (!(paramContext instanceof Activity)) {
        break label211;
      }
      paramContext = ((Activity)paramContext).getCallingActivity();
      if (paramContext == null) {
        break label211;
      }
      localHashMap.put("param_callingActivity", paramContext.getClassName());
    }
    catch (Exception paramContext)
    {
      HashMap localHashMap;
      return;
    }
    localHashMap.put("param_sdCardSize", Long.toString(com.tencent.mobileqq.util.Utils.b()));
    label168:
    localHashMap.put("param_failMsg", str2);
    for (;;)
    {
      label182:
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str1, paramContext, paramBoolean, 0L, 0L, localHashMap, "");
      return;
      label211:
      label229:
      do
      {
        paramContext = paramString1;
        break label182;
        if ((paramInt2 == 9) || (paramInt2 == 0)) {
          break;
        }
        if (paramInt2 != 5) {
          break label168;
        }
        break;
      } while (paramString1 != null);
      paramContext = "report_sendphoto_file_error";
    }
  }
  
  /* Error */
  private static void a(int paramInt1, Context paramContext, File paramFile1, File paramFile2, ImageInfo paramImageInfo, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload 4
    //   2: ldc_w 307
    //   5: new 95	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 309
    //   15: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload 7
    //   20: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: ldc_w 311
    //   26: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 6
    //   31: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   40: iload 8
    //   42: ifeq +103 -> 145
    //   45: aload_1
    //   46: invokestatic 316	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)Z
    //   49: ifeq +89 -> 138
    //   52: bipush 80
    //   54: istore 6
    //   56: iconst_0
    //   57: istore 7
    //   59: aload 4
    //   61: getfield 149	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Int	I
    //   64: ifne +8 -> 72
    //   67: sipush 960
    //   70: istore 7
    //   72: aconst_null
    //   73: astore 14
    //   75: aconst_null
    //   76: astore 13
    //   78: iload_0
    //   79: aload_1
    //   80: aload_2
    //   81: iload 7
    //   83: aload 4
    //   85: invokestatic 318	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;ILcom/tencent/mobileqq/activity/photo/ImageInfo;)Landroid/graphics/Bitmap;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnonnull +62 -> 152
    //   93: aload 4
    //   95: iconst_0
    //   96: putfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   99: aload_3
    //   100: invokevirtual 323	java/io/File:delete	()Z
    //   103: pop
    //   104: ldc_w 325
    //   107: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   110: iconst_0
    //   111: ifeq +11 -> 122
    //   114: new 327	java/lang/NullPointerException
    //   117: dup
    //   118: invokespecial 328	java/lang/NullPointerException:<init>	()V
    //   121: athrow
    //   122: aload_1
    //   123: ifnull +14 -> 137
    //   126: aload_1
    //   127: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   130: ifne +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   137: return
    //   138: bipush 70
    //   140: istore 6
    //   142: goto -86 -> 56
    //   145: bipush 80
    //   147: istore 6
    //   149: goto -93 -> 56
    //   152: aload 4
    //   154: iconst_1
    //   155: putfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   158: iload 9
    //   160: ifne +102 -> 262
    //   163: aload_1
    //   164: invokevirtual 175	android/graphics/Bitmap:getWidth	()I
    //   167: istore_0
    //   168: aload_1
    //   169: invokevirtual 178	android/graphics/Bitmap:getHeight	()I
    //   172: istore 10
    //   174: iload_0
    //   175: iload 7
    //   177: if_icmpgt +13 -> 190
    //   180: aload_1
    //   181: astore 13
    //   183: iload 10
    //   185: iload 7
    //   187: if_icmple +11 -> 198
    //   190: aload_1
    //   191: iload 7
    //   193: invokestatic 331	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   196: astore 13
    //   198: aload 13
    //   200: astore_1
    //   201: aload_1
    //   202: ifnonnull +73 -> 275
    //   205: aload_1
    //   206: astore 13
    //   208: aload_1
    //   209: astore 14
    //   211: aload 4
    //   213: ldc_w 307
    //   216: ldc_w 333
    //   219: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_1
    //   223: astore 13
    //   225: aload_1
    //   226: astore 14
    //   228: aload 4
    //   230: iconst_1
    //   231: putfield 336	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   234: iconst_0
    //   235: ifeq +11 -> 246
    //   238: new 327	java/lang/NullPointerException
    //   241: dup
    //   242: invokespecial 328	java/lang/NullPointerException:<init>	()V
    //   245: athrow
    //   246: aload_1
    //   247: ifnull -110 -> 137
    //   250: aload_1
    //   251: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   254: ifne -117 -> 137
    //   257: aload_1
    //   258: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   261: return
    //   262: aload_1
    //   263: aload_2
    //   264: invokestatic 338	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)Landroid/graphics/Bitmap;
    //   267: astore 13
    //   269: aload 13
    //   271: astore_1
    //   272: goto -71 -> 201
    //   275: new 340	java/io/FileOutputStream
    //   278: dup
    //   279: aload_3
    //   280: invokespecial 343	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   283: astore 16
    //   285: aload 16
    //   287: astore 13
    //   289: aload 4
    //   291: aload_1
    //   292: getstatic 349	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   295: iload 6
    //   297: aload 16
    //   299: invokevirtual 352	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   302: putfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   305: aload 16
    //   307: astore 13
    //   309: aload 4
    //   311: iconst_1
    //   312: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   315: aload 16
    //   317: astore 13
    //   319: aload 4
    //   321: getfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   324: ifeq +12 -> 336
    //   327: aload 16
    //   329: astore 13
    //   331: aload 16
    //   333: invokestatic 361	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/FileOutputStream;)V
    //   336: aload 16
    //   338: astore 13
    //   340: new 95	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 363
    //   350: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 4
    //   355: getfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   358: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   361: ldc_w 368
    //   364: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_3
    //   368: invokevirtual 371	java/io/File:length	()J
    //   371: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   374: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   380: aload 16
    //   382: astore 13
    //   384: aload 16
    //   386: ifnull +26 -> 412
    //   389: aload 16
    //   391: astore 15
    //   393: aload_1
    //   394: astore 21
    //   396: aload 16
    //   398: astore 14
    //   400: aload_1
    //   401: astore 18
    //   403: aload 16
    //   405: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   408: aload 16
    //   410: astore 13
    //   412: iload 5
    //   414: iconst_1
    //   415: if_icmpeq +34 -> 449
    //   418: iload 5
    //   420: sipush 1001
    //   423: if_icmpeq +26 -> 449
    //   426: iload 5
    //   428: sipush 10002
    //   431: if_icmpeq +18 -> 449
    //   434: aload 13
    //   436: astore 19
    //   438: aload_1
    //   439: astore 20
    //   441: iload 5
    //   443: sipush 3000
    //   446: if_icmpne +843 -> 1289
    //   449: iload 5
    //   451: sipush 1001
    //   454: if_icmpeq +11 -> 465
    //   457: iload 5
    //   459: sipush 10002
    //   462: if_icmpne +574 -> 1036
    //   465: aload 13
    //   467: astore 15
    //   469: aload_1
    //   470: astore 21
    //   472: aload 13
    //   474: astore 14
    //   476: aload_1
    //   477: astore 18
    //   479: getstatic 380	com/tencent/common/config/AppSetting:jdField_c_of_type_Int	I
    //   482: i2l
    //   483: lstore 11
    //   485: lload 11
    //   487: l2i
    //   488: istore 10
    //   490: aload 13
    //   492: astore 15
    //   494: aload_1
    //   495: astore 21
    //   497: aload 13
    //   499: astore 14
    //   501: aload_1
    //   502: astore 18
    //   504: new 95	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 382
    //   514: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: iload 10
    //   519: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   522: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   528: aload 13
    //   530: astore 15
    //   532: aload_1
    //   533: astore 21
    //   535: aload 13
    //   537: astore 14
    //   539: aload_1
    //   540: astore 18
    //   542: new 95	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 384
    //   552: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_3
    //   556: invokevirtual 371	java/io/File:length	()J
    //   559: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   562: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   568: aload 13
    //   570: astore 17
    //   572: aload_1
    //   573: astore 16
    //   575: aload_3
    //   576: invokevirtual 371	java/io/File:length	()J
    //   579: iload 10
    //   581: i2l
    //   582: lcmp
    //   583: ifle +606 -> 1189
    //   586: aload 13
    //   588: astore 17
    //   590: aload_1
    //   591: astore 16
    //   593: aload_2
    //   594: invokestatic 390	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   597: ifne +592 -> 1189
    //   600: aload 4
    //   602: ldc_w 307
    //   605: ldc_w 392
    //   608: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   611: aload 13
    //   613: astore 17
    //   615: aload_1
    //   616: astore 16
    //   618: aload_3
    //   619: invokevirtual 323	java/io/File:delete	()Z
    //   622: ifeq +567 -> 1189
    //   625: aload_3
    //   626: invokevirtual 395	java/io/File:createNewFile	()Z
    //   629: istore 8
    //   631: aload 13
    //   633: astore 17
    //   635: aload_1
    //   636: astore 16
    //   638: iload 8
    //   640: ifeq +549 -> 1189
    //   643: iconst_1
    //   644: istore 5
    //   646: iload 7
    //   648: istore_0
    //   649: iload 5
    //   651: iconst_1
    //   652: iadd
    //   653: istore 7
    //   655: iload 5
    //   657: iconst_4
    //   658: if_icmpge +501 -> 1159
    //   661: aload_1
    //   662: astore 14
    //   664: aload_1
    //   665: astore 15
    //   667: aload_3
    //   668: invokevirtual 371	java/io/File:length	()J
    //   671: iload 10
    //   673: i2l
    //   674: lcmp
    //   675: ifle +484 -> 1159
    //   678: aload_1
    //   679: astore 14
    //   681: aload_1
    //   682: astore 15
    //   684: new 95	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   691: ldc_w 397
    //   694: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: iload 7
    //   699: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   702: ldc_w 399
    //   705: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: aload_3
    //   709: invokevirtual 371	java/io/File:length	()J
    //   712: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   715: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   721: iload_0
    //   722: iconst_1
    //   723: ishr
    //   724: istore_0
    //   725: iload_0
    //   726: ifne +1054 -> 1780
    //   729: iconst_1
    //   730: istore_0
    //   731: aload_1
    //   732: astore 14
    //   734: aload_1
    //   735: astore 15
    //   737: aload_1
    //   738: iload_0
    //   739: invokestatic 331	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   742: astore_1
    //   743: aload_1
    //   744: ifnonnull +363 -> 1107
    //   747: aload_1
    //   748: astore 14
    //   750: aload_1
    //   751: astore 15
    //   753: aload 4
    //   755: iconst_1
    //   756: putfield 336	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   759: aload 13
    //   761: ifnull +21 -> 782
    //   764: aload_1
    //   765: astore_3
    //   766: aload 13
    //   768: astore 15
    //   770: aload_1
    //   771: astore 16
    //   773: aload 13
    //   775: astore 14
    //   777: aload 13
    //   779: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   782: aload_1
    //   783: ifnull +40 -> 823
    //   786: aload_1
    //   787: astore_3
    //   788: aload 13
    //   790: astore 15
    //   792: aload_1
    //   793: astore 16
    //   795: aload 13
    //   797: astore 14
    //   799: aload_1
    //   800: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   803: ifne +20 -> 823
    //   806: aload_1
    //   807: astore_3
    //   808: aload 13
    //   810: astore 15
    //   812: aload_1
    //   813: astore 16
    //   815: aload 13
    //   817: astore 14
    //   819: aload_1
    //   820: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   823: aload 13
    //   825: ifnull +8 -> 833
    //   828: aload 13
    //   830: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   833: aload_1
    //   834: ifnull -697 -> 137
    //   837: aload_1
    //   838: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   841: ifne -704 -> 137
    //   844: aload_1
    //   845: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   848: return
    //   849: astore 13
    //   851: aconst_null
    //   852: astore 16
    //   854: aload 16
    //   856: astore 13
    //   858: aload 4
    //   860: iconst_0
    //   861: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   864: aload 16
    //   866: astore 13
    //   868: aload 4
    //   870: invokestatic 401	com/tencent/mobileqq/utils/ImageUtil:a	()Z
    //   873: putfield 404	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   876: aload 16
    //   878: astore 13
    //   880: ldc_w 406
    //   883: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   886: aload 16
    //   888: astore 13
    //   890: aload 16
    //   892: ifnull -480 -> 412
    //   895: aload 16
    //   897: astore 15
    //   899: aload_1
    //   900: astore 21
    //   902: aload 16
    //   904: astore 14
    //   906: aload_1
    //   907: astore 18
    //   909: aload 16
    //   911: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   914: aload 16
    //   916: astore 13
    //   918: goto -506 -> 412
    //   921: astore 13
    //   923: aload 16
    //   925: astore 13
    //   927: goto -515 -> 412
    //   930: astore_3
    //   931: aconst_null
    //   932: astore_2
    //   933: aload_2
    //   934: ifnull +19 -> 953
    //   937: aload_2
    //   938: astore 15
    //   940: aload_1
    //   941: astore 21
    //   943: aload_2
    //   944: astore 14
    //   946: aload_1
    //   947: astore 18
    //   949: aload_2
    //   950: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   953: aload_2
    //   954: astore 15
    //   956: aload_1
    //   957: astore 21
    //   959: aload_2
    //   960: astore 14
    //   962: aload_1
    //   963: astore 18
    //   965: aload_3
    //   966: athrow
    //   967: astore_1
    //   968: aload 21
    //   970: astore_1
    //   971: aload 15
    //   973: astore 14
    //   975: aload_1
    //   976: astore 18
    //   978: aload 4
    //   980: iconst_0
    //   981: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   984: aload 15
    //   986: astore 14
    //   988: aload_1
    //   989: astore 18
    //   991: aload 4
    //   993: iconst_1
    //   994: putfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   997: aload 15
    //   999: astore 14
    //   1001: aload_1
    //   1002: astore 18
    //   1004: ldc_w 408
    //   1007: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1010: aload 15
    //   1012: ifnull +8 -> 1020
    //   1015: aload 15
    //   1017: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   1020: aload_1
    //   1021: ifnull -884 -> 137
    //   1024: aload_1
    //   1025: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   1028: ifne -891 -> 137
    //   1031: aload_1
    //   1032: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   1035: return
    //   1036: aload 13
    //   1038: astore 15
    //   1040: aload_1
    //   1041: astore 21
    //   1043: aload 13
    //   1045: astore 14
    //   1047: aload_1
    //   1048: astore 18
    //   1050: invokestatic 413	com/tencent/mobileqq/transfile/chatpic/PicUploadFileSizeLimit:getLimitGroup	()J
    //   1053: lstore 11
    //   1055: goto -570 -> 485
    //   1058: astore_2
    //   1059: aload_1
    //   1060: astore_3
    //   1061: aload 13
    //   1063: astore 15
    //   1065: aload_1
    //   1066: astore 16
    //   1068: aload 13
    //   1070: astore 14
    //   1072: new 95	java/lang/StringBuilder
    //   1075: dup
    //   1076: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1079: ldc_w 415
    //   1082: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: aload_2
    //   1086: invokevirtual 416	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1089: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1095: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1098: goto -316 -> 782
    //   1101: astore_1
    //   1102: aload_3
    //   1103: astore_1
    //   1104: goto -133 -> 971
    //   1107: aload_1
    //   1108: astore 14
    //   1110: aload_1
    //   1111: astore 15
    //   1113: new 340	java/io/FileOutputStream
    //   1116: dup
    //   1117: aload_3
    //   1118: invokespecial 343	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1121: astore_2
    //   1122: aload 4
    //   1124: aload_1
    //   1125: getstatic 349	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1128: iload 6
    //   1130: aload_2
    //   1131: invokevirtual 352	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   1134: putfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   1137: aload 4
    //   1139: getfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   1142: ifeq +628 -> 1770
    //   1145: aload_2
    //   1146: invokestatic 361	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/FileOutputStream;)V
    //   1149: iload 7
    //   1151: istore 5
    //   1153: aload_2
    //   1154: astore 13
    //   1156: goto -507 -> 649
    //   1159: iload 7
    //   1161: iconst_4
    //   1162: if_icmplt +20 -> 1182
    //   1165: aload_1
    //   1166: astore 14
    //   1168: aload_1
    //   1169: astore 15
    //   1171: aload 4
    //   1173: ldc_w 307
    //   1176: ldc_w 418
    //   1179: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1182: aload_1
    //   1183: astore 16
    //   1185: aload 13
    //   1187: astore 17
    //   1189: aload 17
    //   1191: ifnull +24 -> 1215
    //   1194: aload 17
    //   1196: astore 15
    //   1198: aload 16
    //   1200: astore 21
    //   1202: aload 17
    //   1204: astore 14
    //   1206: aload 16
    //   1208: astore 18
    //   1210: aload 17
    //   1212: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   1215: aload 17
    //   1217: astore 19
    //   1219: aload 16
    //   1221: astore 20
    //   1223: aload 16
    //   1225: ifnull +64 -> 1289
    //   1228: aload 17
    //   1230: astore 15
    //   1232: aload 16
    //   1234: astore 21
    //   1236: aload 17
    //   1238: astore 19
    //   1240: aload 16
    //   1242: astore 20
    //   1244: aload 17
    //   1246: astore 14
    //   1248: aload 16
    //   1250: astore 18
    //   1252: aload 16
    //   1254: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   1257: ifne +32 -> 1289
    //   1260: aload 17
    //   1262: astore 15
    //   1264: aload 16
    //   1266: astore 21
    //   1268: aload 17
    //   1270: astore 14
    //   1272: aload 16
    //   1274: astore 18
    //   1276: aload 16
    //   1278: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   1281: aload 16
    //   1283: astore 20
    //   1285: aload 17
    //   1287: astore 19
    //   1289: aload 19
    //   1291: ifnull +8 -> 1299
    //   1294: aload 19
    //   1296: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   1299: aload 20
    //   1301: ifnull -1164 -> 137
    //   1304: aload 20
    //   1306: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   1309: ifne -1172 -> 137
    //   1312: aload 20
    //   1314: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   1317: return
    //   1318: astore_1
    //   1319: aload 17
    //   1321: astore 15
    //   1323: aload 16
    //   1325: astore 21
    //   1327: aload 17
    //   1329: astore 14
    //   1331: aload 16
    //   1333: astore 18
    //   1335: new 95	java/lang/StringBuilder
    //   1338: dup
    //   1339: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1342: ldc_w 415
    //   1345: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: aload_1
    //   1349: invokevirtual 416	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1352: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1358: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1361: goto -146 -> 1215
    //   1364: astore_1
    //   1365: aload 18
    //   1367: astore_2
    //   1368: aload 14
    //   1370: ifnull +8 -> 1378
    //   1373: aload 14
    //   1375: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   1378: aload_2
    //   1379: ifnull +14 -> 1393
    //   1382: aload_2
    //   1383: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   1386: ifne +7 -> 1393
    //   1389: aload_2
    //   1390: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   1393: aload_1
    //   1394: athrow
    //   1395: astore_2
    //   1396: aload_1
    //   1397: astore_2
    //   1398: aload 13
    //   1400: astore_1
    //   1401: aload 4
    //   1403: iconst_0
    //   1404: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1407: aload 4
    //   1409: invokestatic 401	com/tencent/mobileqq/utils/ImageUtil:a	()Z
    //   1412: putfield 404	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1415: ldc_w 420
    //   1418: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1421: aload_1
    //   1422: ifnull +7 -> 1429
    //   1425: aload_1
    //   1426: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   1429: aload_2
    //   1430: ifnull +331 -> 1761
    //   1433: aload_2
    //   1434: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   1437: ifne +324 -> 1761
    //   1440: aload_2
    //   1441: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   1444: aload_1
    //   1445: astore 19
    //   1447: aload_2
    //   1448: astore 20
    //   1450: goto -161 -> 1289
    //   1453: astore_3
    //   1454: new 95	java/lang/StringBuilder
    //   1457: dup
    //   1458: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1461: ldc_w 415
    //   1464: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: aload_3
    //   1468: invokevirtual 416	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1471: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1477: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1480: goto -51 -> 1429
    //   1483: astore_3
    //   1484: aload_1
    //   1485: astore 15
    //   1487: aload_2
    //   1488: astore_1
    //   1489: goto -518 -> 971
    //   1492: astore_2
    //   1493: aload 13
    //   1495: ifnull +21 -> 1516
    //   1498: aload_1
    //   1499: astore_3
    //   1500: aload 13
    //   1502: astore 15
    //   1504: aload_1
    //   1505: astore 16
    //   1507: aload 13
    //   1509: astore 14
    //   1511: aload 13
    //   1513: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   1516: aload_1
    //   1517: ifnull +40 -> 1557
    //   1520: aload_1
    //   1521: astore_3
    //   1522: aload 13
    //   1524: astore 15
    //   1526: aload_1
    //   1527: astore 16
    //   1529: aload 13
    //   1531: astore 14
    //   1533: aload_1
    //   1534: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   1537: ifne +20 -> 1557
    //   1540: aload_1
    //   1541: astore_3
    //   1542: aload 13
    //   1544: astore 15
    //   1546: aload_1
    //   1547: astore 16
    //   1549: aload 13
    //   1551: astore 14
    //   1553: aload_1
    //   1554: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   1557: aload_1
    //   1558: astore_3
    //   1559: aload 13
    //   1561: astore 15
    //   1563: aload_1
    //   1564: astore 16
    //   1566: aload 13
    //   1568: astore 14
    //   1570: aload_2
    //   1571: athrow
    //   1572: astore 17
    //   1574: aload_1
    //   1575: astore_3
    //   1576: aload 13
    //   1578: astore 15
    //   1580: aload_1
    //   1581: astore 16
    //   1583: aload 13
    //   1585: astore 14
    //   1587: new 95	java/lang/StringBuilder
    //   1590: dup
    //   1591: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1594: ldc_w 415
    //   1597: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: aload 17
    //   1602: invokevirtual 416	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1605: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1611: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1614: goto -98 -> 1516
    //   1617: astore_2
    //   1618: goto -1496 -> 122
    //   1621: astore_2
    //   1622: goto -1376 -> 246
    //   1625: astore 13
    //   1627: aload 16
    //   1629: astore 13
    //   1631: goto -1219 -> 412
    //   1634: astore 13
    //   1636: goto -683 -> 953
    //   1639: astore_2
    //   1640: goto -807 -> 833
    //   1643: astore_1
    //   1644: goto -345 -> 1299
    //   1647: astore_2
    //   1648: goto -628 -> 1020
    //   1651: astore_3
    //   1652: goto -274 -> 1378
    //   1655: astore_1
    //   1656: aconst_null
    //   1657: astore 14
    //   1659: aload 13
    //   1661: astore_2
    //   1662: goto -294 -> 1368
    //   1665: astore_3
    //   1666: aload_1
    //   1667: astore_2
    //   1668: aconst_null
    //   1669: astore 14
    //   1671: aload_3
    //   1672: astore_1
    //   1673: goto -305 -> 1368
    //   1676: astore_3
    //   1677: aload_1
    //   1678: astore 14
    //   1680: aload_3
    //   1681: astore_1
    //   1682: goto -314 -> 1368
    //   1685: astore_1
    //   1686: aconst_null
    //   1687: astore 15
    //   1689: aload 14
    //   1691: astore_1
    //   1692: goto -721 -> 971
    //   1695: astore_2
    //   1696: aconst_null
    //   1697: astore 15
    //   1699: goto -728 -> 971
    //   1702: astore_2
    //   1703: aload 14
    //   1705: astore_1
    //   1706: goto -213 -> 1493
    //   1709: astore_3
    //   1710: aload_2
    //   1711: astore 13
    //   1713: aload_3
    //   1714: astore_2
    //   1715: goto -222 -> 1493
    //   1718: astore_3
    //   1719: aload_1
    //   1720: astore 13
    //   1722: aload_2
    //   1723: astore_1
    //   1724: aload_3
    //   1725: astore_2
    //   1726: goto -233 -> 1493
    //   1729: astore_1
    //   1730: aload 15
    //   1732: astore_2
    //   1733: aload 13
    //   1735: astore_1
    //   1736: goto -335 -> 1401
    //   1739: astore_3
    //   1740: aload_1
    //   1741: astore_3
    //   1742: aload_2
    //   1743: astore_1
    //   1744: aload_3
    //   1745: astore_2
    //   1746: goto -345 -> 1401
    //   1749: astore_3
    //   1750: aload 13
    //   1752: astore_2
    //   1753: goto -820 -> 933
    //   1756: astore 13
    //   1758: goto -904 -> 854
    //   1761: aload_1
    //   1762: astore 19
    //   1764: aload_2
    //   1765: astore 20
    //   1767: goto -478 -> 1289
    //   1770: iload 7
    //   1772: istore 5
    //   1774: aload_2
    //   1775: astore 13
    //   1777: goto -1128 -> 649
    //   1780: goto -1049 -> 731
    //   1783: astore_1
    //   1784: aload 16
    //   1786: astore_2
    //   1787: goto -419 -> 1368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1790	0	paramInt1	int
    //   0	1790	1	paramContext	Context
    //   0	1790	2	paramFile1	File
    //   0	1790	3	paramFile2	File
    //   0	1790	4	paramImageInfo	ImageInfo
    //   0	1790	5	paramInt2	int
    //   0	1790	6	paramInt3	int
    //   0	1790	7	paramInt4	int
    //   0	1790	8	paramBoolean1	boolean
    //   0	1790	9	paramBoolean2	boolean
    //   172	500	10	i	int
    //   483	571	11	l	long
    //   76	753	13	localObject1	Object
    //   849	1	13	localIOException1	java.io.IOException
    //   856	61	13	localObject2	Object
    //   921	1	13	localIOException2	java.io.IOException
    //   925	659	13	localObject3	Object
    //   1625	1	13	localIOException3	java.io.IOException
    //   1629	1	13	localObject4	Object
    //   1634	26	13	localIOException4	java.io.IOException
    //   1711	40	13	localObject5	Object
    //   1756	1	13	localIOException5	java.io.IOException
    //   1775	1	13	localFile	File
    //   73	1631	14	localObject6	Object
    //   391	1340	15	localObject7	Object
    //   283	1502	16	localObject8	Object
    //   570	758	17	localObject9	Object
    //   1572	29	17	localIOException6	java.io.IOException
    //   401	965	18	localObject10	Object
    //   436	1327	19	localObject11	Object
    //   439	1327	20	localObject12	Object
    //   394	932	21	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   275	285	849	java/io/IOException
    //   909	914	921	java/io/IOException
    //   275	285	930	finally
    //   403	408	967	java/lang/OutOfMemoryError
    //   479	485	967	java/lang/OutOfMemoryError
    //   504	528	967	java/lang/OutOfMemoryError
    //   542	568	967	java/lang/OutOfMemoryError
    //   909	914	967	java/lang/OutOfMemoryError
    //   949	953	967	java/lang/OutOfMemoryError
    //   965	967	967	java/lang/OutOfMemoryError
    //   1050	1055	967	java/lang/OutOfMemoryError
    //   1210	1215	967	java/lang/OutOfMemoryError
    //   1252	1260	967	java/lang/OutOfMemoryError
    //   1276	1281	967	java/lang/OutOfMemoryError
    //   1335	1361	967	java/lang/OutOfMemoryError
    //   777	782	1058	java/io/IOException
    //   777	782	1101	java/lang/OutOfMemoryError
    //   799	806	1101	java/lang/OutOfMemoryError
    //   819	823	1101	java/lang/OutOfMemoryError
    //   1072	1098	1101	java/lang/OutOfMemoryError
    //   1511	1516	1101	java/lang/OutOfMemoryError
    //   1533	1540	1101	java/lang/OutOfMemoryError
    //   1553	1557	1101	java/lang/OutOfMemoryError
    //   1570	1572	1101	java/lang/OutOfMemoryError
    //   1587	1614	1101	java/lang/OutOfMemoryError
    //   1210	1215	1318	java/io/IOException
    //   403	408	1364	finally
    //   479	485	1364	finally
    //   504	528	1364	finally
    //   542	568	1364	finally
    //   909	914	1364	finally
    //   949	953	1364	finally
    //   965	967	1364	finally
    //   978	984	1364	finally
    //   991	997	1364	finally
    //   1004	1010	1364	finally
    //   1050	1055	1364	finally
    //   1210	1215	1364	finally
    //   1252	1260	1364	finally
    //   1276	1281	1364	finally
    //   1335	1361	1364	finally
    //   575	586	1395	java/io/IOException
    //   593	611	1395	java/io/IOException
    //   618	631	1395	java/io/IOException
    //   1425	1429	1453	java/io/IOException
    //   1425	1429	1483	java/lang/OutOfMemoryError
    //   1433	1444	1483	java/lang/OutOfMemoryError
    //   1454	1480	1483	java/lang/OutOfMemoryError
    //   575	586	1492	finally
    //   593	611	1492	finally
    //   618	631	1492	finally
    //   1511	1516	1572	java/io/IOException
    //   114	122	1617	java/io/IOException
    //   238	246	1621	java/io/IOException
    //   403	408	1625	java/io/IOException
    //   949	953	1634	java/io/IOException
    //   828	833	1639	java/io/IOException
    //   1294	1299	1643	java/io/IOException
    //   1015	1020	1647	java/io/IOException
    //   1373	1378	1651	java/io/IOException
    //   78	89	1655	finally
    //   211	222	1655	finally
    //   228	234	1655	finally
    //   93	110	1665	finally
    //   152	158	1665	finally
    //   163	174	1665	finally
    //   190	198	1665	finally
    //   262	269	1665	finally
    //   1425	1429	1676	finally
    //   1433	1444	1676	finally
    //   1454	1480	1676	finally
    //   78	89	1685	java/lang/OutOfMemoryError
    //   211	222	1685	java/lang/OutOfMemoryError
    //   228	234	1685	java/lang/OutOfMemoryError
    //   93	110	1695	java/lang/OutOfMemoryError
    //   152	158	1695	java/lang/OutOfMemoryError
    //   163	174	1695	java/lang/OutOfMemoryError
    //   190	198	1695	java/lang/OutOfMemoryError
    //   262	269	1695	java/lang/OutOfMemoryError
    //   667	678	1702	finally
    //   684	721	1702	finally
    //   737	743	1702	finally
    //   753	759	1702	finally
    //   1113	1122	1702	finally
    //   1171	1182	1702	finally
    //   1122	1149	1709	finally
    //   1401	1421	1718	finally
    //   667	678	1729	java/io/IOException
    //   684	721	1729	java/io/IOException
    //   737	743	1729	java/io/IOException
    //   753	759	1729	java/io/IOException
    //   1113	1122	1729	java/io/IOException
    //   1171	1182	1729	java/io/IOException
    //   1122	1149	1739	java/io/IOException
    //   289	305	1749	finally
    //   309	315	1749	finally
    //   319	327	1749	finally
    //   331	336	1749	finally
    //   340	380	1749	finally
    //   858	864	1749	finally
    //   868	876	1749	finally
    //   880	886	1749	finally
    //   289	305	1756	java/io/IOException
    //   309	315	1756	java/io/IOException
    //   319	327	1756	java/io/IOException
    //   331	336	1756	java/io/IOException
    //   340	380	1756	java/io/IOException
    //   777	782	1783	finally
    //   799	806	1783	finally
    //   819	823	1783	finally
    //   1072	1098	1783	finally
    //   1511	1516	1783	finally
    //   1533	1540	1783	finally
    //   1553	1557	1783	finally
    //   1570	1572	1783	finally
    //   1587	1614	1783	finally
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
    if ((paramContext == null) || (paramList == null)) {}
    int i;
    label18:
    ImageInfo localImageInfo;
    do
    {
      return;
      paramList = paramList.iterator();
      i = 0;
      if (!paramList.hasNext()) {
        break;
      }
      localImageInfo = (ImageInfo)paramList.next();
    } while ((localImageInfo == null) || (localImageInfo.b == null));
    File localFile = new File(localImageInfo.b);
    long l = PicUploadFileSizeLimit.getLimitC2C();
    switch (paramInt)
    {
    default: 
      label120:
      if ((localFile.length() > l) && (!localImageInfo.q)) {
        i = 1;
      }
      break;
    }
    for (;;)
    {
      break label18;
      l = PicUploadFileSizeLimit.getLimitC2C();
      break label120;
      l = PicUploadFileSizeLimit.getLimitGroup();
      break label120;
      if ((paramContext != null) && ((paramContext instanceof BaseActivity)))
      {
        if (!((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).isLBSFriendNewClient(localImageInfo.jdField_c_of_type_JavaLangString)) {
          break label120;
        }
        l = PicUploadFileSizeLimit.getLimitC2C();
        break label120;
      }
      l = AppSetting.jdField_c_of_type_Int;
      break label120;
      if ((localImageInfo.g) && (!NetworkUtil.h(paramContext)))
      {
        i = 1;
        continue;
        if (i == 0) {
          break;
        }
        QQToast.a(paramContext, HardCodeUtil.a(2131705759), 0).b(paramContext.getResources().getDimensionPixelSize(2131299166));
        return;
      }
    }
  }
  
  public static void a(ImageInfo paramImageInfo, String paramString1, String paramString2)
  {
    if (paramImageInfo == null)
    {
      a(-1L, -1, true, paramString1, "@ImageUtil.log ImageInfo is null@ " + paramString2);
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
    boolean bool = false;
    File localFile;
    if (FileUtils.a(paramString2))
    {
      localFile = new File(paramString2);
      if (!a(paramString2)) {
        localFile.delete();
      }
    }
    else
    {
      if (paramInt1 != 8) {
        break label193;
      }
    }
    label193:
    for (bool = true;; bool = false)
    {
      paramBoolean = a(paramInt1, paramContext, paramString1, paramString2, paramBoolean, paramImageInfo, paramInt2, bool);
      if ((paramBoolean) && (!bool)) {
        a(paramString1, paramString2);
      }
      return paramBoolean;
      paramImageInfo.b = localFile.getPath();
      paramImageInfo.a = localFile.length();
      paramImageInfo.o = true;
      paramImageInfo.jdField_h_of_type_Boolean = true;
      if (paramImageInfo.jdField_j_of_type_Int > 0)
      {
        a("compress succ with retry : " + paramImageInfo.jdField_j_of_type_Int);
        a(paramInt1, 8, paramContext, false, null);
      }
      for (;;)
      {
        paramBoolean = bool;
        if (paramImageInfo.jdField_j_of_type_Int > 0) {
          paramBoolean = true;
        }
        RichMediaUtil.stopReport("compressPic", paramBoolean, "compressPic");
        return true;
        a(paramInt1, 0, paramContext, true, null);
      }
    }
  }
  
  /* Error */
  private static boolean a(int paramInt1, Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, ImageInfo paramImageInfo, int paramInt2, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 537
    //   3: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   6: aload_3
    //   7: ifnull +16 -> 23
    //   10: aload_2
    //   11: ifnull +12 -> 23
    //   14: aload 5
    //   16: ifnull +7 -> 23
    //   19: aload_1
    //   20: ifnonnull +5 -> 25
    //   23: iconst_0
    //   24: ireturn
    //   25: new 65	java/io/File
    //   28: dup
    //   29: new 95	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   36: getstatic 542	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   39: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 544
    //   45: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 452	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore 14
    //   56: aload 14
    //   58: invokevirtual 547	java/io/File:exists	()Z
    //   61: ifne +23 -> 84
    //   64: ldc_w 549
    //   67: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   70: aload 14
    //   72: invokevirtual 552	java/io/File:mkdirs	()Z
    //   75: ifne +9 -> 84
    //   78: ldc_w 554
    //   81: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   84: new 65	java/io/File
    //   87: dup
    //   88: aload_3
    //   89: invokespecial 452	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: astore 16
    //   94: new 65	java/io/File
    //   97: dup
    //   98: aload_2
    //   99: invokespecial 452	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: astore 17
    //   104: aload 5
    //   106: ldc_w 556
    //   109: new 95	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 558
    //   119: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 5
    //   124: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   127: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc_w 560
    //   133: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload 5
    //   138: getfield 149	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Int	I
    //   141: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_2
    //   151: invokestatic 513	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   154: ifne +13 -> 167
    //   157: iload_0
    //   158: iconst_1
    //   159: aload_1
    //   160: iconst_0
    //   161: aconst_null
    //   162: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   165: iconst_0
    //   166: ireturn
    //   167: aload_2
    //   168: invokestatic 562	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   171: ifne +13 -> 184
    //   174: iload_0
    //   175: iconst_2
    //   176: aload_1
    //   177: iconst_0
    //   178: aconst_null
    //   179: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   182: iconst_0
    //   183: ireturn
    //   184: aload_2
    //   185: invokestatic 514	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Z
    //   188: ifne +13 -> 201
    //   191: iload_0
    //   192: iconst_4
    //   193: aload_1
    //   194: iconst_0
    //   195: aconst_null
    //   196: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   199: iconst_0
    //   200: ireturn
    //   201: aload 5
    //   203: aload 17
    //   205: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   208: putfield 451	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   211: aload 5
    //   213: aload 17
    //   215: invokevirtual 371	java/io/File:length	()J
    //   218: putfield 522	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   221: aload 17
    //   223: invokestatic 565	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   226: astore 14
    //   228: new 95	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 567
    //   238: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 17
    //   243: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: ldc_w 572
    //   249: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 17
    //   254: invokevirtual 371	java/io/File:length	()J
    //   257: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   260: ldc_w 574
    //   263: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 14
    //   268: getfield 76	android/graphics/BitmapFactory$Options:outWidth	I
    //   271: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: ldc_w 576
    //   277: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 14
    //   282: getfield 79	android/graphics/BitmapFactory$Options:outHeight	I
    //   285: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   288: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   294: aload_3
    //   295: invokestatic 513	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   298: ifeq +16 -> 314
    //   301: aload_3
    //   302: invokestatic 514	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)Z
    //   305: ifne +490 -> 795
    //   308: aload 16
    //   310: invokevirtual 323	java/io/File:delete	()Z
    //   313: pop
    //   314: aload 17
    //   316: invokestatic 390	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   319: istore 11
    //   321: aload 5
    //   323: iload 11
    //   325: putfield 458	com/tencent/mobileqq/activity/photo/ImageInfo:q	Z
    //   328: iload 11
    //   330: ifne +155 -> 485
    //   333: aload 16
    //   335: invokevirtual 395	java/io/File:createNewFile	()Z
    //   338: ifeq +147 -> 485
    //   341: ldc_w 578
    //   344: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   347: new 62	android/graphics/BitmapFactory$Options
    //   350: dup
    //   351: invokespecial 63	android/graphics/BitmapFactory$Options:<init>	()V
    //   354: astore 14
    //   356: aload 14
    //   358: iconst_1
    //   359: putfield 581	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   362: new 583	java/io/BufferedInputStream
    //   365: dup
    //   366: new 585	java/io/FileInputStream
    //   369: dup
    //   370: aload 17
    //   372: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   375: invokespecial 586	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   378: invokespecial 589	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   381: astore 15
    //   383: aload 15
    //   385: aconst_null
    //   386: aload 14
    //   388: invokestatic 595	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   391: pop
    //   392: aload 15
    //   394: ifnull +8 -> 402
    //   397: aload 15
    //   399: invokevirtual 598	java/io/InputStream:close	()V
    //   402: aload 14
    //   404: getfield 79	android/graphics/BitmapFactory$Options:outHeight	I
    //   407: istore 8
    //   409: aload 14
    //   411: getfield 76	android/graphics/BitmapFactory$Options:outWidth	I
    //   414: istore 9
    //   416: iload 8
    //   418: iconst_m1
    //   419: if_icmpeq +66 -> 485
    //   422: iload 9
    //   424: iconst_m1
    //   425: if_icmpeq +60 -> 485
    //   428: iload 7
    //   430: ifne +1556 -> 1986
    //   433: iload 4
    //   435: ifeq +1551 -> 1986
    //   438: iload 8
    //   440: iload 9
    //   442: iconst_3
    //   443: imul
    //   444: if_icmpgt +12 -> 456
    //   447: iload 9
    //   449: iload 8
    //   451: iconst_3
    //   452: imul
    //   453: if_icmple +1533 -> 1986
    //   456: iload_0
    //   457: aload_1
    //   458: aload 17
    //   460: aload 16
    //   462: aload 5
    //   464: iload 6
    //   466: iload 8
    //   468: iload 9
    //   470: iload 4
    //   472: iload 7
    //   474: invokestatic 600	com/tencent/mobileqq/utils/ImageUtil:b	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   477: ldc_w 602
    //   480: aload_1
    //   481: iconst_1
    //   482: invokestatic 84	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   485: aload 5
    //   487: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   490: iconst_1
    //   491: if_icmpeq +12 -> 503
    //   494: aload 5
    //   496: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   499: iconst_1
    //   500: if_icmpne +1839 -> 2339
    //   503: iconst_1
    //   504: istore 10
    //   506: aload_3
    //   507: invokestatic 562	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   510: istore 12
    //   512: aload 5
    //   514: ldc_w 604
    //   517: new 95	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 606
    //   527: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload 5
    //   532: getfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   535: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   538: ldc_w 608
    //   541: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 5
    //   546: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   549: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   552: ldc_w 610
    //   555: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: iload 12
    //   560: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   563: ldc_w 612
    //   566: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: iload 10
    //   571: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   574: ldc_w 614
    //   577: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: aload 5
    //   582: getfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   585: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   588: ldc_w 616
    //   591: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload 5
    //   596: getfield 404	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   599: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   602: ldc_w 618
    //   605: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokestatic 275	com/tencent/mobileqq/util/Utils:b	()J
    //   611: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   614: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   620: aload 5
    //   622: getfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   625: ifne +1731 -> 2356
    //   628: aload 5
    //   630: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   633: ifeq +1712 -> 2345
    //   636: iload_0
    //   637: iconst_3
    //   638: aload_1
    //   639: iconst_0
    //   640: aconst_null
    //   641: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   644: iload 12
    //   646: ifeq +27 -> 673
    //   649: aload 16
    //   651: invokevirtual 371	java/io/File:length	()J
    //   654: aload 17
    //   656: invokevirtual 371	java/io/File:length	()J
    //   659: lcmp
    //   660: ifgt +13 -> 673
    //   663: iload 10
    //   665: ifne +8 -> 673
    //   668: iload 11
    //   670: ifeq +2010 -> 2680
    //   673: aload 5
    //   675: aload 17
    //   677: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   680: putfield 451	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   683: aload 5
    //   685: aload 17
    //   687: invokevirtual 371	java/io/File:length	()J
    //   690: putfield 522	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   693: aload 5
    //   695: iconst_0
    //   696: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   699: aload 5
    //   701: iconst_0
    //   702: putfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   705: aload 16
    //   707: ifnull +17 -> 724
    //   710: aload 16
    //   712: invokevirtual 547	java/io/File:exists	()Z
    //   715: ifeq +9 -> 724
    //   718: aload 16
    //   720: invokevirtual 323	java/io/File:delete	()Z
    //   723: pop
    //   724: iload 10
    //   726: ifne +8 -> 734
    //   729: iload 11
    //   731: ifeq +1788 -> 2519
    //   734: new 95	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   741: ldc_w 620
    //   744: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: aload 17
    //   749: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   752: ldc_w 572
    //   755: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload 17
    //   760: invokevirtual 371	java/io/File:length	()J
    //   763: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   766: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   772: ldc_w 531
    //   775: iconst_0
    //   776: ldc_w 531
    //   779: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   782: aload 5
    //   784: ldc_w 622
    //   787: ldc_w 624
    //   790: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   793: iconst_0
    //   794: ireturn
    //   795: aload 5
    //   797: ldc_w 307
    //   800: ldc_w 626
    //   803: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   806: aload 5
    //   808: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   811: iconst_1
    //   812: if_icmpeq +12 -> 824
    //   815: aload 5
    //   817: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   820: iconst_1
    //   821: if_icmpne +380 -> 1201
    //   824: iconst_1
    //   825: istore 10
    //   827: aload_3
    //   828: invokestatic 562	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   831: istore 11
    //   833: aload 5
    //   835: ldc_w 604
    //   838: new 95	java/lang/StringBuilder
    //   841: dup
    //   842: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   845: ldc_w 606
    //   848: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: aload 5
    //   853: getfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   856: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   859: ldc_w 608
    //   862: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: aload 5
    //   867: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   870: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   873: ldc_w 610
    //   876: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: iload 11
    //   881: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   884: ldc_w 612
    //   887: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: iload 10
    //   892: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   895: ldc_w 614
    //   898: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: aload 5
    //   903: getfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   906: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   909: ldc_w 616
    //   912: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: aload 5
    //   917: getfield 404	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   920: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   923: ldc_w 618
    //   926: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: invokestatic 275	com/tencent/mobileqq/util/Utils:b	()J
    //   932: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   935: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   941: aload 5
    //   943: getfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   946: ifne +272 -> 1218
    //   949: aload 5
    //   951: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   954: ifeq +253 -> 1207
    //   957: iload_0
    //   958: iconst_3
    //   959: aload_1
    //   960: iconst_0
    //   961: aconst_null
    //   962: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   965: iload 11
    //   967: ifeq +409 -> 1376
    //   970: aload 16
    //   972: invokevirtual 371	java/io/File:length	()J
    //   975: aload 17
    //   977: invokevirtual 371	java/io/File:length	()J
    //   980: lcmp
    //   981: ifgt +395 -> 1376
    //   984: iload 10
    //   986: ifne +390 -> 1376
    //   989: aload 5
    //   991: aload 16
    //   993: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   996: putfield 451	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   999: aload 5
    //   1001: aload 16
    //   1003: invokevirtual 371	java/io/File:length	()J
    //   1006: putfield 522	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   1009: aload 5
    //   1011: iconst_1
    //   1012: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1015: aload 5
    //   1017: iconst_1
    //   1018: putfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   1021: aload 16
    //   1023: invokestatic 565	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   1026: astore_2
    //   1027: new 95	java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1034: ldc_w 628
    //   1037: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: aload 17
    //   1042: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1045: ldc_w 630
    //   1048: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: aload_3
    //   1052: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: ldc_w 572
    //   1058: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: aload 16
    //   1063: invokevirtual 371	java/io/File:length	()J
    //   1066: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1069: ldc_w 574
    //   1072: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: aload_2
    //   1076: getfield 76	android/graphics/BitmapFactory$Options:outWidth	I
    //   1079: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1082: ldc_w 576
    //   1085: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: aload_2
    //   1089: getfield 79	android/graphics/BitmapFactory$Options:outHeight	I
    //   1092: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1095: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1098: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1101: aload 5
    //   1103: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1106: ifle +548 -> 1654
    //   1109: new 95	java/lang/StringBuilder
    //   1112: dup
    //   1113: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1116: ldc_w 527
    //   1119: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: aload 5
    //   1124: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1127: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1130: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1133: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1136: iload_0
    //   1137: bipush 8
    //   1139: aload_1
    //   1140: iconst_0
    //   1141: aconst_null
    //   1142: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1145: aload 5
    //   1147: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1150: ifle +515 -> 1665
    //   1153: iconst_1
    //   1154: istore 4
    //   1156: ldc_w 531
    //   1159: iload 4
    //   1161: ldc_w 531
    //   1164: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1167: aload 5
    //   1169: ldc_w 622
    //   1172: new 95	java/lang/StringBuilder
    //   1175: dup
    //   1176: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1179: ldc_w 632
    //   1182: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: aload 5
    //   1187: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1190: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1193: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1196: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1199: iconst_1
    //   1200: ireturn
    //   1201: iconst_0
    //   1202: istore 10
    //   1204: goto -377 -> 827
    //   1207: iload_0
    //   1208: iconst_4
    //   1209: aload_1
    //   1210: iconst_0
    //   1211: aconst_null
    //   1212: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1215: goto -250 -> 965
    //   1218: iload 11
    //   1220: ifne -255 -> 965
    //   1223: iload 10
    //   1225: ifne -260 -> 965
    //   1228: aload 5
    //   1230: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1233: istore 8
    //   1235: aload 5
    //   1237: iload 8
    //   1239: iconst_1
    //   1240: iadd
    //   1241: putfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   1244: iload 8
    //   1246: iconst_2
    //   1247: if_icmpge +33 -> 1280
    //   1250: aload 5
    //   1252: iconst_1
    //   1253: putfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   1256: ldc_w 634
    //   1259: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1262: iload_0
    //   1263: aload_1
    //   1264: aload_2
    //   1265: aload_3
    //   1266: iload 4
    //   1268: aload 5
    //   1270: iload 6
    //   1272: iload 7
    //   1274: invokestatic 517	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   1277: pop
    //   1278: iconst_0
    //   1279: ireturn
    //   1280: aload 5
    //   1282: getfield 336	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   1285: ifeq +15 -> 1300
    //   1288: iload_0
    //   1289: bipush 6
    //   1291: aload_1
    //   1292: iconst_0
    //   1293: aconst_null
    //   1294: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1297: goto -332 -> 965
    //   1300: aload 5
    //   1302: getfield 636	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   1305: ifeq +15 -> 1320
    //   1308: iload_0
    //   1309: bipush 7
    //   1311: aload_1
    //   1312: iconst_0
    //   1313: aconst_null
    //   1314: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1317: goto -352 -> 965
    //   1320: aload 5
    //   1322: getfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   1325: ifne +15 -> 1340
    //   1328: iload_0
    //   1329: bipush 9
    //   1331: aload_1
    //   1332: iconst_0
    //   1333: aconst_null
    //   1334: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1337: goto -372 -> 965
    //   1340: aload 5
    //   1342: getfield 404	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1345: ifeq +14 -> 1359
    //   1348: iload_0
    //   1349: iconst_0
    //   1350: aload_1
    //   1351: iconst_0
    //   1352: aconst_null
    //   1353: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1356: goto -391 -> 965
    //   1359: ldc_w 638
    //   1362: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1365: iload_0
    //   1366: iconst_5
    //   1367: aload_1
    //   1368: iconst_0
    //   1369: aconst_null
    //   1370: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1373: goto -408 -> 965
    //   1376: aload 5
    //   1378: aload 17
    //   1380: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   1383: putfield 451	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   1386: aload 5
    //   1388: aload 17
    //   1390: invokevirtual 371	java/io/File:length	()J
    //   1393: putfield 522	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   1396: aload 5
    //   1398: iconst_0
    //   1399: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1402: aload 5
    //   1404: iconst_0
    //   1405: putfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   1408: aload 16
    //   1410: ifnull +17 -> 1427
    //   1413: aload 16
    //   1415: invokevirtual 547	java/io/File:exists	()Z
    //   1418: ifeq +9 -> 1427
    //   1421: aload 16
    //   1423: invokevirtual 323	java/io/File:delete	()Z
    //   1426: pop
    //   1427: iload 10
    //   1429: ifne +155 -> 1584
    //   1432: new 95	java/lang/StringBuilder
    //   1435: dup
    //   1436: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1439: ldc_w 640
    //   1442: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1445: aload_3
    //   1446: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: ldc_w 572
    //   1452: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: aload 16
    //   1457: invokevirtual 371	java/io/File:length	()J
    //   1460: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1463: ldc_w 642
    //   1466: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: aload 17
    //   1471: invokevirtual 371	java/io/File:length	()J
    //   1474: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1477: ldc_w 644
    //   1480: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: iload 10
    //   1485: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1488: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1491: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1494: new 95	java/lang/StringBuilder
    //   1497: dup
    //   1498: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1501: ldc_w 646
    //   1504: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: iconst_0
    //   1508: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1511: ldc_w 648
    //   1514: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1517: aload_3
    //   1518: invokestatic 513	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   1521: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1524: ldc_w 650
    //   1527: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: astore_1
    //   1531: aload 16
    //   1533: invokevirtual 371	java/io/File:length	()J
    //   1536: lconst_0
    //   1537: lcmp
    //   1538: ifgt +97 -> 1635
    //   1541: iconst_1
    //   1542: istore 4
    //   1544: aload_1
    //   1545: iload 4
    //   1547: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1550: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1553: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1556: iload 11
    //   1558: ifne +83 -> 1641
    //   1561: ldc_w 531
    //   1564: iconst_1
    //   1565: ldc_w 531
    //   1568: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1571: aload 5
    //   1573: ldc_w 622
    //   1576: ldc_w 624
    //   1579: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1582: iconst_1
    //   1583: ireturn
    //   1584: new 95	java/lang/StringBuilder
    //   1587: dup
    //   1588: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1591: ldc_w 620
    //   1594: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1597: aload 17
    //   1599: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1602: ldc_w 572
    //   1605: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: aload 17
    //   1610: invokevirtual 371	java/io/File:length	()J
    //   1613: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1616: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1619: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1622: ldc_w 531
    //   1625: iconst_0
    //   1626: ldc_w 531
    //   1629: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1632: goto -61 -> 1571
    //   1635: iconst_0
    //   1636: istore 4
    //   1638: goto -94 -> 1544
    //   1641: ldc_w 531
    //   1644: iconst_0
    //   1645: ldc_w 531
    //   1648: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1651: goto -80 -> 1571
    //   1654: iload_0
    //   1655: iconst_0
    //   1656: aload_1
    //   1657: iconst_1
    //   1658: aconst_null
    //   1659: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1662: goto -517 -> 1145
    //   1665: iconst_0
    //   1666: istore 4
    //   1668: goto -512 -> 1156
    //   1671: astore 14
    //   1673: aconst_null
    //   1674: astore 15
    //   1676: aload 15
    //   1678: ifnull +8 -> 1686
    //   1681: aload 15
    //   1683: invokevirtual 598	java/io/InputStream:close	()V
    //   1686: aload 14
    //   1688: athrow
    //   1689: astore 14
    //   1691: iload 11
    //   1693: istore 10
    //   1695: iconst_1
    //   1696: istore 12
    //   1698: ldc_w 652
    //   1701: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1704: aload 5
    //   1706: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   1709: iconst_1
    //   1710: if_icmpeq +12 -> 1722
    //   1713: aload 5
    //   1715: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   1718: iconst_1
    //   1719: if_icmpne +1190 -> 2909
    //   1722: iconst_1
    //   1723: istore 11
    //   1725: aload_3
    //   1726: invokestatic 562	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   1729: istore 12
    //   1731: aload 5
    //   1733: ldc_w 604
    //   1736: new 95	java/lang/StringBuilder
    //   1739: dup
    //   1740: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1743: ldc_w 606
    //   1746: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: aload 5
    //   1751: getfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   1754: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1757: ldc_w 608
    //   1760: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: aload 5
    //   1765: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   1768: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1771: ldc_w 610
    //   1774: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: iload 12
    //   1779: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1782: ldc_w 612
    //   1785: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: iload 11
    //   1790: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1793: ldc_w 614
    //   1796: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: aload 5
    //   1801: getfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   1804: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1807: ldc_w 616
    //   1810: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1813: aload 5
    //   1815: getfield 404	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   1818: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1821: ldc_w 618
    //   1824: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1827: invokestatic 275	com/tencent/mobileqq/util/Utils:b	()J
    //   1830: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1833: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1836: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1839: aload 5
    //   1841: getfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   1844: ifne +1082 -> 2926
    //   1847: aload 5
    //   1849: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   1852: ifeq +1063 -> 2915
    //   1855: iload_0
    //   1856: iconst_3
    //   1857: aload_1
    //   1858: iconst_0
    //   1859: aconst_null
    //   1860: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   1863: aload 5
    //   1865: aload 17
    //   1867: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   1870: putfield 451	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   1873: aload 5
    //   1875: aload 17
    //   1877: invokevirtual 371	java/io/File:length	()J
    //   1880: putfield 522	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   1883: aload 5
    //   1885: iconst_0
    //   1886: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   1889: aload 5
    //   1891: iconst_0
    //   1892: putfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   1895: aload 16
    //   1897: ifnull +17 -> 1914
    //   1900: aload 16
    //   1902: invokevirtual 547	java/io/File:exists	()Z
    //   1905: ifeq +9 -> 1914
    //   1908: aload 16
    //   1910: invokevirtual 323	java/io/File:delete	()Z
    //   1913: pop
    //   1914: iload 11
    //   1916: ifne +8 -> 1924
    //   1919: iload 10
    //   1921: ifeq +1168 -> 3089
    //   1924: new 95	java/lang/StringBuilder
    //   1927: dup
    //   1928: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1931: ldc_w 620
    //   1934: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1937: aload 17
    //   1939: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1942: ldc_w 572
    //   1945: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: aload 17
    //   1950: invokevirtual 371	java/io/File:length	()J
    //   1953: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1956: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1959: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1962: ldc_w 531
    //   1965: iconst_0
    //   1966: ldc_w 531
    //   1969: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1972: aload 5
    //   1974: ldc_w 622
    //   1977: ldc_w 624
    //   1980: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   1983: goto -1190 -> 793
    //   1986: iload_0
    //   1987: aload_1
    //   1988: aload 17
    //   1990: aload 16
    //   1992: aload 5
    //   1994: iload 6
    //   1996: iload 8
    //   1998: iload 9
    //   2000: iload 4
    //   2002: iload 7
    //   2004: invokestatic 654	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   2007: ldc_w 602
    //   2010: aload_1
    //   2011: iconst_0
    //   2012: invokestatic 84	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   2015: goto -1530 -> 485
    //   2018: astore 14
    //   2020: iconst_0
    //   2021: istore 10
    //   2023: aload 5
    //   2025: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   2028: iconst_1
    //   2029: if_icmpeq +12 -> 2041
    //   2032: aload 5
    //   2034: getfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   2037: iconst_1
    //   2038: if_icmpne +1194 -> 3232
    //   2041: iconst_1
    //   2042: istore 12
    //   2044: aload_3
    //   2045: invokestatic 562	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   2048: istore 13
    //   2050: aload 5
    //   2052: ldc_w 604
    //   2055: new 95	java/lang/StringBuilder
    //   2058: dup
    //   2059: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2062: ldc_w 606
    //   2065: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2068: aload 5
    //   2070: getfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   2073: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2076: ldc_w 608
    //   2079: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: aload 5
    //   2084: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   2087: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2090: ldc_w 610
    //   2093: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2096: iload 13
    //   2098: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2101: ldc_w 612
    //   2104: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: iload 12
    //   2109: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2112: ldc_w 614
    //   2115: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2118: aload 5
    //   2120: getfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   2123: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2126: ldc_w 616
    //   2129: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: aload 5
    //   2134: getfield 404	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   2137: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2140: ldc_w 618
    //   2143: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2146: invokestatic 275	com/tencent/mobileqq/util/Utils:b	()J
    //   2149: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2152: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2155: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   2158: aload 5
    //   2160: getfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   2163: ifne +1086 -> 3249
    //   2166: aload 5
    //   2168: getfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   2171: ifeq +1067 -> 3238
    //   2174: iload_0
    //   2175: iconst_3
    //   2176: aload_1
    //   2177: iconst_0
    //   2178: aconst_null
    //   2179: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2182: iload 10
    //   2184: ifne +32 -> 2216
    //   2187: iload 13
    //   2189: ifeq +27 -> 2216
    //   2192: aload 16
    //   2194: invokevirtual 371	java/io/File:length	()J
    //   2197: aload 17
    //   2199: invokevirtual 371	java/io/File:length	()J
    //   2202: lcmp
    //   2203: ifgt +13 -> 2216
    //   2206: iload 12
    //   2208: ifne +8 -> 2216
    //   2211: iload 11
    //   2213: ifeq +1366 -> 3579
    //   2216: aload 5
    //   2218: aload 17
    //   2220: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   2223: putfield 451	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   2226: aload 5
    //   2228: aload 17
    //   2230: invokevirtual 371	java/io/File:length	()J
    //   2233: putfield 522	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   2236: aload 5
    //   2238: iconst_0
    //   2239: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   2242: aload 5
    //   2244: iconst_0
    //   2245: putfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   2248: aload 16
    //   2250: ifnull +17 -> 2267
    //   2253: aload 16
    //   2255: invokevirtual 547	java/io/File:exists	()Z
    //   2258: ifeq +9 -> 2267
    //   2261: aload 16
    //   2263: invokevirtual 323	java/io/File:delete	()Z
    //   2266: pop
    //   2267: iload 12
    //   2269: ifne +8 -> 2277
    //   2272: iload 11
    //   2274: ifeq +1138 -> 3412
    //   2277: new 95	java/lang/StringBuilder
    //   2280: dup
    //   2281: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2284: ldc_w 620
    //   2287: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2290: aload 17
    //   2292: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2295: ldc_w 572
    //   2298: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2301: aload 17
    //   2303: invokevirtual 371	java/io/File:length	()J
    //   2306: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2309: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2312: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2315: ldc_w 531
    //   2318: iconst_0
    //   2319: ldc_w 531
    //   2322: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2325: aload 5
    //   2327: ldc_w 622
    //   2330: ldc_w 624
    //   2333: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   2336: aload 14
    //   2338: athrow
    //   2339: iconst_0
    //   2340: istore 10
    //   2342: goto -1836 -> 506
    //   2345: iload_0
    //   2346: iconst_4
    //   2347: aload_1
    //   2348: iconst_0
    //   2349: aconst_null
    //   2350: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2353: goto -1709 -> 644
    //   2356: iload 12
    //   2358: ifne -1714 -> 644
    //   2361: iload 10
    //   2363: ifne -1719 -> 644
    //   2366: iload 11
    //   2368: ifne -1724 -> 644
    //   2371: aload 5
    //   2373: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2376: istore 8
    //   2378: aload 5
    //   2380: iload 8
    //   2382: iconst_1
    //   2383: iadd
    //   2384: putfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2387: iload 8
    //   2389: iconst_2
    //   2390: if_icmpge +33 -> 2423
    //   2393: aload 5
    //   2395: iconst_1
    //   2396: putfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   2399: ldc_w 634
    //   2402: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2405: iload_0
    //   2406: aload_1
    //   2407: aload_2
    //   2408: aload_3
    //   2409: iload 4
    //   2411: aload 5
    //   2413: iload 6
    //   2415: iload 7
    //   2417: invokestatic 517	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   2420: pop
    //   2421: iconst_0
    //   2422: ireturn
    //   2423: aload 5
    //   2425: getfield 336	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   2428: ifeq +15 -> 2443
    //   2431: iload_0
    //   2432: bipush 6
    //   2434: aload_1
    //   2435: iconst_0
    //   2436: aconst_null
    //   2437: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2440: goto -1796 -> 644
    //   2443: aload 5
    //   2445: getfield 636	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   2448: ifeq +15 -> 2463
    //   2451: iload_0
    //   2452: bipush 7
    //   2454: aload_1
    //   2455: iconst_0
    //   2456: aconst_null
    //   2457: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2460: goto -1816 -> 644
    //   2463: aload 5
    //   2465: getfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   2468: ifne +15 -> 2483
    //   2471: iload_0
    //   2472: bipush 9
    //   2474: aload_1
    //   2475: iconst_0
    //   2476: aconst_null
    //   2477: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2480: goto -1836 -> 644
    //   2483: aload 5
    //   2485: getfield 404	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   2488: ifeq +14 -> 2502
    //   2491: iload_0
    //   2492: iconst_0
    //   2493: aload_1
    //   2494: iconst_0
    //   2495: aconst_null
    //   2496: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2499: goto -1855 -> 644
    //   2502: ldc_w 638
    //   2505: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2508: iload_0
    //   2509: iconst_5
    //   2510: aload_1
    //   2511: iconst_0
    //   2512: aconst_null
    //   2513: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2516: goto -1872 -> 644
    //   2519: new 95	java/lang/StringBuilder
    //   2522: dup
    //   2523: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2526: ldc_w 640
    //   2529: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2532: aload_3
    //   2533: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2536: ldc_w 572
    //   2539: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2542: aload 16
    //   2544: invokevirtual 371	java/io/File:length	()J
    //   2547: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2550: ldc_w 642
    //   2553: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2556: aload 17
    //   2558: invokevirtual 371	java/io/File:length	()J
    //   2561: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2564: ldc_w 644
    //   2567: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2570: iload 10
    //   2572: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2575: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2578: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2581: new 95	java/lang/StringBuilder
    //   2584: dup
    //   2585: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2588: ldc_w 646
    //   2591: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2594: iconst_0
    //   2595: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2598: ldc_w 648
    //   2601: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2604: aload_3
    //   2605: invokestatic 513	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   2608: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2611: ldc_w 650
    //   2614: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2617: astore_1
    //   2618: aload 16
    //   2620: invokevirtual 371	java/io/File:length	()J
    //   2623: lconst_0
    //   2624: lcmp
    //   2625: ifgt +36 -> 2661
    //   2628: iconst_1
    //   2629: istore 4
    //   2631: aload_1
    //   2632: iload 4
    //   2634: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2637: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2640: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2643: iload 12
    //   2645: ifne +22 -> 2667
    //   2648: ldc_w 531
    //   2651: iconst_1
    //   2652: ldc_w 531
    //   2655: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2658: goto -1876 -> 782
    //   2661: iconst_0
    //   2662: istore 4
    //   2664: goto -33 -> 2631
    //   2667: ldc_w 531
    //   2670: iconst_0
    //   2671: ldc_w 531
    //   2674: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2677: goto -1895 -> 782
    //   2680: aload 5
    //   2682: aload 16
    //   2684: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   2687: putfield 451	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   2690: aload 5
    //   2692: aload 16
    //   2694: invokevirtual 371	java/io/File:length	()J
    //   2697: putfield 522	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   2700: aload 5
    //   2702: iconst_1
    //   2703: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   2706: aload 5
    //   2708: iconst_1
    //   2709: putfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   2712: aload 16
    //   2714: invokestatic 565	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   2717: astore_2
    //   2718: new 95	java/lang/StringBuilder
    //   2721: dup
    //   2722: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2725: ldc_w 628
    //   2728: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2731: aload 17
    //   2733: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2736: ldc_w 630
    //   2739: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2742: aload_3
    //   2743: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2746: ldc_w 572
    //   2749: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2752: aload 16
    //   2754: invokevirtual 371	java/io/File:length	()J
    //   2757: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2760: ldc_w 574
    //   2763: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2766: aload_2
    //   2767: getfield 76	android/graphics/BitmapFactory$Options:outWidth	I
    //   2770: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2773: ldc_w 576
    //   2776: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2779: aload_2
    //   2780: getfield 79	android/graphics/BitmapFactory$Options:outHeight	I
    //   2783: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2786: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2789: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2792: aload 5
    //   2794: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2797: ifle +95 -> 2892
    //   2800: new 95	java/lang/StringBuilder
    //   2803: dup
    //   2804: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2807: ldc_w 527
    //   2810: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2813: aload 5
    //   2815: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2818: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2821: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2824: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2827: iload_0
    //   2828: bipush 8
    //   2830: aload_1
    //   2831: iconst_0
    //   2832: aconst_null
    //   2833: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2836: aload 5
    //   2838: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2841: ifle +62 -> 2903
    //   2844: iconst_1
    //   2845: istore 4
    //   2847: ldc_w 531
    //   2850: iload 4
    //   2852: ldc_w 531
    //   2855: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2858: aload 5
    //   2860: ldc_w 622
    //   2863: new 95	java/lang/StringBuilder
    //   2866: dup
    //   2867: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2870: ldc_w 632
    //   2873: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2876: aload 5
    //   2878: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2881: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2884: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2887: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   2890: iconst_1
    //   2891: ireturn
    //   2892: iload_0
    //   2893: iconst_0
    //   2894: aload_1
    //   2895: iconst_1
    //   2896: aconst_null
    //   2897: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2900: goto -64 -> 2836
    //   2903: iconst_0
    //   2904: istore 4
    //   2906: goto -59 -> 2847
    //   2909: iconst_0
    //   2910: istore 11
    //   2912: goto -1187 -> 1725
    //   2915: iload_0
    //   2916: iconst_4
    //   2917: aload_1
    //   2918: iconst_0
    //   2919: aconst_null
    //   2920: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   2923: goto -1060 -> 1863
    //   2926: iload 12
    //   2928: ifne -1065 -> 1863
    //   2931: iload 11
    //   2933: ifne -1070 -> 1863
    //   2936: iload 10
    //   2938: ifne -1075 -> 1863
    //   2941: aload 5
    //   2943: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2946: istore 8
    //   2948: aload 5
    //   2950: iload 8
    //   2952: iconst_1
    //   2953: iadd
    //   2954: putfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   2957: iload 8
    //   2959: iconst_2
    //   2960: if_icmpge +33 -> 2993
    //   2963: aload 5
    //   2965: iconst_1
    //   2966: putfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   2969: ldc_w 634
    //   2972: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   2975: iload_0
    //   2976: aload_1
    //   2977: aload_2
    //   2978: aload_3
    //   2979: iload 4
    //   2981: aload 5
    //   2983: iload 6
    //   2985: iload 7
    //   2987: invokestatic 517	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   2990: pop
    //   2991: iconst_0
    //   2992: ireturn
    //   2993: aload 5
    //   2995: getfield 336	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   2998: ifeq +15 -> 3013
    //   3001: iload_0
    //   3002: bipush 6
    //   3004: aload_1
    //   3005: iconst_0
    //   3006: aconst_null
    //   3007: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3010: goto -1147 -> 1863
    //   3013: aload 5
    //   3015: getfield 636	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   3018: ifeq +15 -> 3033
    //   3021: iload_0
    //   3022: bipush 7
    //   3024: aload_1
    //   3025: iconst_0
    //   3026: aconst_null
    //   3027: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3030: goto -1167 -> 1863
    //   3033: aload 5
    //   3035: getfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   3038: ifne +15 -> 3053
    //   3041: iload_0
    //   3042: bipush 9
    //   3044: aload_1
    //   3045: iconst_0
    //   3046: aconst_null
    //   3047: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3050: goto -1187 -> 1863
    //   3053: aload 5
    //   3055: getfield 404	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   3058: ifeq +14 -> 3072
    //   3061: iload_0
    //   3062: iconst_0
    //   3063: aload_1
    //   3064: iconst_0
    //   3065: aconst_null
    //   3066: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3069: goto -1206 -> 1863
    //   3072: ldc_w 638
    //   3075: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3078: iload_0
    //   3079: iconst_5
    //   3080: aload_1
    //   3081: iconst_0
    //   3082: aconst_null
    //   3083: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3086: goto -1223 -> 1863
    //   3089: new 95	java/lang/StringBuilder
    //   3092: dup
    //   3093: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3096: ldc_w 640
    //   3099: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3102: aload_3
    //   3103: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3106: ldc_w 572
    //   3109: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3112: aload 16
    //   3114: invokevirtual 371	java/io/File:length	()J
    //   3117: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3120: ldc_w 642
    //   3123: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3126: aload 17
    //   3128: invokevirtual 371	java/io/File:length	()J
    //   3131: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3134: ldc_w 644
    //   3137: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3140: iload 11
    //   3142: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3145: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3148: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3151: new 95	java/lang/StringBuilder
    //   3154: dup
    //   3155: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3158: ldc_w 646
    //   3161: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3164: iconst_1
    //   3165: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3168: ldc_w 648
    //   3171: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3174: aload_3
    //   3175: invokestatic 513	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   3178: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3181: ldc_w 650
    //   3184: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3187: astore_1
    //   3188: aload 16
    //   3190: invokevirtual 371	java/io/File:length	()J
    //   3193: lconst_0
    //   3194: lcmp
    //   3195: ifgt +31 -> 3226
    //   3198: iconst_1
    //   3199: istore 4
    //   3201: aload_1
    //   3202: iload 4
    //   3204: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3207: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3210: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3213: ldc_w 531
    //   3216: iconst_1
    //   3217: ldc_w 531
    //   3220: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3223: goto -1251 -> 1972
    //   3226: iconst_0
    //   3227: istore 4
    //   3229: goto -28 -> 3201
    //   3232: iconst_0
    //   3233: istore 12
    //   3235: goto -1191 -> 2044
    //   3238: iload_0
    //   3239: iconst_4
    //   3240: aload_1
    //   3241: iconst_0
    //   3242: aconst_null
    //   3243: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3246: goto -1064 -> 2182
    //   3249: iload 13
    //   3251: ifne -1069 -> 2182
    //   3254: iload 12
    //   3256: ifne -1074 -> 2182
    //   3259: iload 11
    //   3261: ifne -1079 -> 2182
    //   3264: aload 5
    //   3266: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3269: istore 8
    //   3271: aload 5
    //   3273: iload 8
    //   3275: iconst_1
    //   3276: iadd
    //   3277: putfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3280: iload 8
    //   3282: iconst_2
    //   3283: if_icmpge +33 -> 3316
    //   3286: aload 5
    //   3288: iconst_1
    //   3289: putfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   3292: ldc_w 634
    //   3295: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3298: iload_0
    //   3299: aload_1
    //   3300: aload_2
    //   3301: aload_3
    //   3302: iload 4
    //   3304: aload 5
    //   3306: iload 6
    //   3308: iload 7
    //   3310: invokestatic 517	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/activity/photo/ImageInfo;IZ)Z
    //   3313: pop
    //   3314: iconst_0
    //   3315: ireturn
    //   3316: aload 5
    //   3318: getfield 336	com/tencent/mobileqq/activity/photo/ImageInfo:k	Z
    //   3321: ifeq +15 -> 3336
    //   3324: iload_0
    //   3325: bipush 6
    //   3327: aload_1
    //   3328: iconst_0
    //   3329: aconst_null
    //   3330: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3333: goto -1151 -> 2182
    //   3336: aload 5
    //   3338: getfield 636	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Boolean	Z
    //   3341: ifeq +15 -> 3356
    //   3344: iload_0
    //   3345: bipush 7
    //   3347: aload_1
    //   3348: iconst_0
    //   3349: aconst_null
    //   3350: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3353: goto -1171 -> 2182
    //   3356: aload 5
    //   3358: getfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   3361: ifne +15 -> 3376
    //   3364: iload_0
    //   3365: bipush 9
    //   3367: aload_1
    //   3368: iconst_0
    //   3369: aconst_null
    //   3370: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3373: goto -1191 -> 2182
    //   3376: aload 5
    //   3378: getfield 404	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   3381: ifeq +14 -> 3395
    //   3384: iload_0
    //   3385: iconst_0
    //   3386: aload_1
    //   3387: iconst_0
    //   3388: aconst_null
    //   3389: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3392: goto -1210 -> 2182
    //   3395: ldc_w 638
    //   3398: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3401: iload_0
    //   3402: iconst_5
    //   3403: aload_1
    //   3404: iconst_0
    //   3405: aconst_null
    //   3406: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3409: goto -1227 -> 2182
    //   3412: new 95	java/lang/StringBuilder
    //   3415: dup
    //   3416: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3419: ldc_w 640
    //   3422: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3425: aload_3
    //   3426: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3429: ldc_w 572
    //   3432: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3435: aload 16
    //   3437: invokevirtual 371	java/io/File:length	()J
    //   3440: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3443: ldc_w 642
    //   3446: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3449: aload 17
    //   3451: invokevirtual 371	java/io/File:length	()J
    //   3454: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3457: ldc_w 644
    //   3460: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3463: iload 12
    //   3465: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3468: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3471: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3474: new 95	java/lang/StringBuilder
    //   3477: dup
    //   3478: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3481: ldc_w 646
    //   3484: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3487: iload 10
    //   3489: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3492: ldc_w 648
    //   3495: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3498: aload_3
    //   3499: invokestatic 513	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   3502: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3505: ldc_w 650
    //   3508: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3511: astore_1
    //   3512: aload 16
    //   3514: invokevirtual 371	java/io/File:length	()J
    //   3517: lconst_0
    //   3518: lcmp
    //   3519: ifgt +41 -> 3560
    //   3522: iconst_1
    //   3523: istore 4
    //   3525: aload_1
    //   3526: iload 4
    //   3528: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3531: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3534: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3537: iload 10
    //   3539: ifne +8 -> 3547
    //   3542: iload 13
    //   3544: ifne +22 -> 3566
    //   3547: ldc_w 531
    //   3550: iconst_1
    //   3551: ldc_w 531
    //   3554: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3557: goto -1232 -> 2325
    //   3560: iconst_0
    //   3561: istore 4
    //   3563: goto -38 -> 3525
    //   3566: ldc_w 531
    //   3569: iconst_0
    //   3570: ldc_w 531
    //   3573: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3576: goto -1251 -> 2325
    //   3579: aload 5
    //   3581: aload 16
    //   3583: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   3586: putfield 451	com/tencent/mobileqq/activity/photo/ImageInfo:b	Ljava/lang/String;
    //   3589: aload 5
    //   3591: aload 16
    //   3593: invokevirtual 371	java/io/File:length	()J
    //   3596: putfield 522	com/tencent/mobileqq/activity/photo/ImageInfo:a	J
    //   3599: aload 5
    //   3601: iconst_1
    //   3602: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   3605: aload 5
    //   3607: iconst_1
    //   3608: putfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   3611: aload 16
    //   3613: invokestatic 565	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/File;)Landroid/graphics/BitmapFactory$Options;
    //   3616: astore_2
    //   3617: new 95	java/lang/StringBuilder
    //   3620: dup
    //   3621: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3624: ldc_w 628
    //   3627: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3630: aload 17
    //   3632: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3635: ldc_w 630
    //   3638: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3641: aload_3
    //   3642: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3645: ldc_w 572
    //   3648: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3651: aload 16
    //   3653: invokevirtual 371	java/io/File:length	()J
    //   3656: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3659: ldc_w 574
    //   3662: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3665: aload_2
    //   3666: getfield 76	android/graphics/BitmapFactory$Options:outWidth	I
    //   3669: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3672: ldc_w 576
    //   3675: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3678: aload_2
    //   3679: getfield 79	android/graphics/BitmapFactory$Options:outHeight	I
    //   3682: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3685: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3688: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3691: aload 5
    //   3693: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3696: ifle +95 -> 3791
    //   3699: new 95	java/lang/StringBuilder
    //   3702: dup
    //   3703: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3706: ldc_w 527
    //   3709: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3712: aload 5
    //   3714: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3717: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3720: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3723: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   3726: iload_0
    //   3727: bipush 8
    //   3729: aload_1
    //   3730: iconst_0
    //   3731: aconst_null
    //   3732: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3735: aload 5
    //   3737: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3740: ifle +62 -> 3802
    //   3743: iconst_1
    //   3744: istore 4
    //   3746: ldc_w 531
    //   3749: iload 4
    //   3751: ldc_w 531
    //   3754: invokestatic 535	com/tencent/mobileqq/transfile/RichMediaUtil:stopReport	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3757: aload 5
    //   3759: ldc_w 622
    //   3762: new 95	java/lang/StringBuilder
    //   3765: dup
    //   3766: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3769: ldc_w 632
    //   3772: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3775: aload 5
    //   3777: getfield 525	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_j_of_type_Int	I
    //   3780: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3783: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3786: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   3789: iconst_1
    //   3790: ireturn
    //   3791: iload_0
    //   3792: iconst_0
    //   3793: aload_1
    //   3794: iconst_1
    //   3795: aconst_null
    //   3796: invokestatic 529	com/tencent/mobileqq/utils/ImageUtil:a	(IILandroid/content/Context;ZLjava/lang/String;)V
    //   3799: goto -64 -> 3735
    //   3802: iconst_0
    //   3803: istore 4
    //   3805: goto -59 -> 3746
    //   3808: astore 15
    //   3810: goto -3408 -> 402
    //   3813: astore 15
    //   3815: goto -2129 -> 1686
    //   3818: astore 14
    //   3820: iconst_0
    //   3821: istore 11
    //   3823: iconst_0
    //   3824: istore 10
    //   3826: goto -1803 -> 2023
    //   3829: astore 14
    //   3831: iload 10
    //   3833: istore 11
    //   3835: iload 12
    //   3837: istore 10
    //   3839: goto -1816 -> 2023
    //   3842: astore 14
    //   3844: iconst_0
    //   3845: istore 10
    //   3847: goto -2152 -> 1695
    //   3850: astore 14
    //   3852: goto -2176 -> 1676
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3855	0	paramInt1	int
    //   0	3855	1	paramContext	Context
    //   0	3855	2	paramString1	String
    //   0	3855	3	paramString2	String
    //   0	3855	4	paramBoolean1	boolean
    //   0	3855	5	paramImageInfo	ImageInfo
    //   0	3855	6	paramInt2	int
    //   0	3855	7	paramBoolean2	boolean
    //   407	2877	8	i	int
    //   414	1585	9	j	int
    //   504	3342	10	bool1	boolean
    //   319	3515	11	bool2	boolean
    //   510	3326	12	bool3	boolean
    //   2048	1495	13	bool4	boolean
    //   54	356	14	localObject1	Object
    //   1671	16	14	localObject2	Object
    //   1689	1	14	localIOException1	java.io.IOException
    //   2018	319	14	localObject3	Object
    //   3818	1	14	localObject4	Object
    //   3829	1	14	localObject5	Object
    //   3842	1	14	localIOException2	java.io.IOException
    //   3850	1	14	localObject6	Object
    //   381	1301	15	localBufferedInputStream	java.io.BufferedInputStream
    //   3808	1	15	localIOException3	java.io.IOException
    //   3813	1	15	localIOException4	java.io.IOException
    //   92	3560	16	localFile1	File
    //   102	3529	17	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   362	383	1671	finally
    //   321	328	1689	java/io/IOException
    //   333	362	1689	java/io/IOException
    //   402	416	1689	java/io/IOException
    //   456	485	1689	java/io/IOException
    //   1686	1689	1689	java/io/IOException
    //   1986	2015	1689	java/io/IOException
    //   321	328	2018	finally
    //   333	362	2018	finally
    //   397	402	2018	finally
    //   402	416	2018	finally
    //   456	485	2018	finally
    //   1681	1686	2018	finally
    //   1686	1689	2018	finally
    //   1986	2015	2018	finally
    //   397	402	3808	java/io/IOException
    //   1681	1686	3813	java/io/IOException
    //   201	314	3818	finally
    //   314	321	3818	finally
    //   795	806	3818	finally
    //   1698	1704	3829	finally
    //   201	314	3842	java/io/IOException
    //   314	321	3842	java/io/IOException
    //   795	806	3842	java/io/IOException
    //   383	392	3850	finally
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "image_upload";
    }
    if (!FileUtils.b(paramString1)) {
      try
      {
        if (!FileUtils.a(paramString1))
        {
          if (QLog.isColorLevel()) {
            QLog.e(str, 2, paramString3 + ",filePath not exist,filePath=" + paramString1);
          }
          throw new RuntimeException(paramString3 + " file not exists,path=" + paramString1);
        }
      }
      catch (Exception paramString2)
      {
        paramString2 = BaseTransProcessor.getExceptionMessage(paramString2);
        if (!FileUtils.a(paramString1))
        {
          a(paramInt, 1, paramContext, false, "report_sendphoto_file_error", paramString2);
          return false;
          if (QLog.isColorLevel()) {
            QLog.e(str, 2, paramString3 + ",filePath size is 0,filePath=" + paramString1);
          }
          throw new RuntimeException(paramString3 + " file size==0,path=" + paramString1);
        }
        a(paramInt, 2, paramContext, false, "report_sendphoto_file_error", paramString2);
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(str, 2, paramString3 + ",filePath not exist,filePath=" + paramString1);
    }
    a(paramInt, 0, paramContext, true, "report_sendphoto_file_error");
    return true;
  }
  
  public static boolean a(ExifInterface paramExifInterface1, ExifInterface paramExifInterface2)
  {
    return a(paramExifInterface1, paramExifInterface2, true);
  }
  
  public static boolean a(ExifInterface paramExifInterface1, ExifInterface paramExifInterface2, boolean paramBoolean)
  {
    if ((paramExifInterface1 == null) || (paramExifInterface2 == null)) {
      return false;
    }
    paramBoolean = PicUploadExifInfoSwitch.getSwitch();
    String str3 = paramExifInterface1.getAttribute("DateTime");
    String str4 = paramExifInterface1.getAttribute("Flash");
    String str5 = paramExifInterface1.getAttribute("FocalLength");
    String str6 = paramExifInterface1.getAttribute("GPSAltitude");
    String str7 = paramExifInterface1.getAttribute("GPSAltitudeRef");
    String str8 = paramExifInterface1.getAttribute("GPSDateStamp");
    String str9 = paramExifInterface1.getAttribute("GPSLatitude");
    String str10 = paramExifInterface1.getAttribute("GPSLatitudeRef");
    String str11 = paramExifInterface1.getAttribute("GPSLongitude");
    String str12 = paramExifInterface1.getAttribute("GPSLongitudeRef");
    String str13 = paramExifInterface1.getAttribute("GPSProcessingMethod");
    String str14 = paramExifInterface1.getAttribute("GPSTimeStamp");
    String str1 = paramExifInterface1.getAttribute("ImageLength");
    String str2 = paramExifInterface1.getAttribute("ImageWidth");
    String str15 = paramExifInterface1.getAttribute("ISOSpeedRatings");
    String str16 = paramExifInterface1.getAttribute("Make");
    String str17 = paramExifInterface1.getAttribute("Model");
    String str18 = paramExifInterface1.getAttribute("WhiteBalance");
    String str19 = paramExifInterface1.getAttribute("UserComment");
    paramExifInterface1 = paramExifInterface1.getAttribute("ImageDescription");
    if ((paramExifInterface1 != null) && (QLog.isColorLevel())) {
      QLog.d("ImageUtil", 2, "E D = " + paramExifInterface1);
    }
    if ((str3 != null) && (paramBoolean)) {
      paramExifInterface2.setAttribute("DateTime", str3);
    }
    for (;;)
    {
      if (str4 != null) {
        paramExifInterface2.setAttribute("Flash", str4);
      }
      if (str5 != null) {
        paramExifInterface2.setAttribute("FocalLength", str5);
      }
      if ((str6 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSAltitude", str6);
      }
      if ((str7 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSAltitudeRef", str7);
      }
      if ((str8 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSDateStamp", str8);
      }
      if ((str9 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSLatitude", str9);
      }
      if ((str10 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSLatitudeRef", str10);
      }
      if ((str11 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSLongitude", str11);
      }
      if ((str12 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSLongitudeRef", str12);
      }
      if ((str13 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSProcessingMethod", str13);
      }
      if ((str14 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("GPSTimeStamp", str14);
      }
      if (str1 != null) {
        paramExifInterface2.setAttribute("ImageLength", str1);
      }
      if (str2 != null) {
        paramExifInterface2.setAttribute("ImageWidth", str2);
      }
      if (str15 != null) {
        paramExifInterface2.setAttribute("ISOSpeedRatings", str15);
      }
      if ((str16 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("Make", str16);
      }
      if ((str17 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("Model", str17);
      }
      if (str18 != null) {
        paramExifInterface2.setAttribute("WhiteBalance", str18);
      }
      if ((str19 != null) && (paramBoolean)) {
        paramExifInterface2.setAttribute("UserComment", str19);
      }
      if (ZhuoXusManager.a().g()) {}
      try
      {
        paramExifInterface1 = new JSONObject();
        if (str1 != null) {
          paramExifInterface1.put("ImageLength", str1);
        }
        if (str2 != null) {
          paramExifInterface1.put("ImageWidth", str2);
        }
        paramExifInterface2.setAttribute("ImageDescription", paramExifInterface1.toString());
        if (QLog.isColorLevel()) {
          QLog.d("ImageUtil", 2, "s E D = " + paramExifInterface1.toString());
        }
      }
      catch (Throwable paramExifInterface1)
      {
        for (;;)
        {
          a("F s d " + paramExifInterface1.getMessage());
        }
      }
      try
      {
        paramExifInterface2.saveAttributes();
        return true;
      }
      catch (Exception paramExifInterface1)
      {
        a("Failed to save EXIF. " + paramExifInterface1.getMessage());
      }
      paramExifInterface2.setAttribute("DateTime", "");
    }
    return false;
  }
  
  public static Bitmap b(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
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
        localObject2 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130844376);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (GlobalImageCache.a != null)
          {
            GlobalImageCache.a.put("static://DefaultDataLineFace", localObject2, (byte)0);
            localObject1 = localObject2;
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject1;
            localObject1 = localObject3;
          } while (paramInt != 107);
          if (GlobalImageCache.a != null) {
            localObject2 = (Bitmap)GlobalImageCache.a.get("static://DefaultDataLineFaceIpad");
          }
          localObject1 = localObject2;
        } while (localObject2 != null);
        localObject2 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130844371);
        localObject1 = localObject2;
      } while (localObject2 == null);
      localObject1 = localObject2;
    } while (GlobalImageCache.a == null);
    GlobalImageCache.a.put("static://DefaultDataLineFaceIpad", localObject2, (byte)0);
    return localObject2;
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
    //   0: aload 4
    //   2: ldc_w 307
    //   5: new 95	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 772
    //   15: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload 7
    //   20: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: ldc_w 311
    //   26: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 6
    //   31: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload 4
    //   42: iconst_1
    //   43: putfield 774	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Boolean	Z
    //   46: aload_2
    //   47: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
    //   50: invokestatic 777	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   53: astore 20
    //   55: getstatic 380	com/tencent/common/config/AppSetting:jdField_c_of_type_Int	I
    //   58: i2l
    //   59: lstore 14
    //   61: aload 4
    //   63: getfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   66: ifeq +8 -> 74
    //   69: aload 20
    //   71: ifnonnull +395 -> 466
    //   74: aload 4
    //   76: ldc_w 307
    //   79: ldc_w 779
    //   82: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   85: iload 5
    //   87: sipush 1001
    //   90: if_icmpeq +15 -> 105
    //   93: lload 14
    //   95: lstore 16
    //   97: iload 5
    //   99: sipush 10002
    //   102: if_icmpne +52 -> 154
    //   105: lload 14
    //   107: lstore 16
    //   109: aload_1
    //   110: ifnull +44 -> 154
    //   113: lload 14
    //   115: lstore 16
    //   117: aload_1
    //   118: instanceof 118
    //   121: ifeq +33 -> 154
    //   124: lload 14
    //   126: lstore 16
    //   128: aload_1
    //   129: checkcast 118	com/tencent/mobileqq/app/BaseActivity
    //   132: invokevirtual 122	com/tencent/mobileqq/app/BaseActivity:getAppRuntime	()Lmqq/app/AppRuntime;
    //   135: checkcast 124	com/tencent/mobileqq/app/QQAppInterface
    //   138: aload 4
    //   140: getfield 460	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   143: invokevirtual 464	com/tencent/mobileqq/app/QQAppInterface:isLBSFriendNewClient	(Ljava/lang/String;)Z
    //   146: ifeq +8 -> 154
    //   149: invokestatic 455	com/tencent/mobileqq/transfile/chatpic/PicUploadFileSizeLimit:getLimitC2C	()J
    //   152: lstore 16
    //   154: iload 5
    //   156: ifne +240 -> 396
    //   159: aload_2
    //   160: invokevirtual 371	java/io/File:length	()J
    //   163: invokestatic 455	com/tencent/mobileqq/transfile/chatpic/PicUploadFileSizeLimit:getLimitC2C	()J
    //   166: lcmp
    //   167: ifle +229 -> 396
    //   170: iconst_1
    //   171: istore 11
    //   173: iload 5
    //   175: sipush 1001
    //   178: if_icmpeq +11 -> 189
    //   181: iload 5
    //   183: sipush 10002
    //   186: if_icmpne +216 -> 402
    //   189: aload_2
    //   190: invokevirtual 371	java/io/File:length	()J
    //   193: lload 16
    //   195: lcmp
    //   196: ifle +206 -> 402
    //   199: iconst_1
    //   200: istore 12
    //   202: iload 5
    //   204: iconst_1
    //   205: if_icmpeq +11 -> 216
    //   208: iload 5
    //   210: sipush 3000
    //   213: if_icmpne +195 -> 408
    //   216: aload_2
    //   217: invokevirtual 371	java/io/File:length	()J
    //   220: invokestatic 413	com/tencent/mobileqq/transfile/chatpic/PicUploadFileSizeLimit:getLimitGroup	()J
    //   223: lcmp
    //   224: ifle +184 -> 408
    //   227: iconst_1
    //   228: istore 13
    //   230: iload 11
    //   232: ifne +13 -> 245
    //   235: iload 12
    //   237: ifne +8 -> 245
    //   240: iload 13
    //   242: ifeq +172 -> 414
    //   245: aload 4
    //   247: ldc_w 307
    //   250: new 95	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   257: ldc_w 781
    //   260: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_2
    //   264: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   267: ldc_w 783
    //   270: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload 11
    //   275: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   278: ldc_w 785
    //   281: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: iload 12
    //   286: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: ldc_w 787
    //   292: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload 13
    //   297: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   300: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   306: iload_0
    //   307: aload_1
    //   308: aload_2
    //   309: aload_3
    //   310: aload 4
    //   312: iload 5
    //   314: iload 6
    //   316: iload 7
    //   318: iload 8
    //   320: iload 9
    //   322: invokestatic 654	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   325: return
    //   326: astore 18
    //   328: new 95	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 789
    //   338: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_2
    //   342: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   351: aconst_null
    //   352: astore 20
    //   354: aload_1
    //   355: invokestatic 316	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)Z
    //   358: ifeq +18 -> 376
    //   361: aload 4
    //   363: iconst_1
    //   364: putfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   367: aload 4
    //   369: iconst_0
    //   370: putfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   373: goto -318 -> 55
    //   376: iload_0
    //   377: aload_1
    //   378: aload_2
    //   379: aload_3
    //   380: aload 4
    //   382: iload 5
    //   384: iload 6
    //   386: iload 7
    //   388: iload 8
    //   390: iload 9
    //   392: invokestatic 654	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   395: return
    //   396: iconst_0
    //   397: istore 11
    //   399: goto -226 -> 173
    //   402: iconst_0
    //   403: istore 12
    //   405: goto -203 -> 202
    //   408: iconst_0
    //   409: istore 13
    //   411: goto -181 -> 230
    //   414: aload 4
    //   416: iconst_1
    //   417: putfield 141	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_i_of_type_Int	I
    //   420: aload 4
    //   422: iconst_0
    //   423: putfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   426: iload 5
    //   428: ifne +9 -> 437
    //   431: aload 4
    //   433: iconst_2
    //   434: putfield 149	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Int	I
    //   437: aload 4
    //   439: ldc_w 307
    //   442: new 95	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 791
    //   452: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload_2
    //   456: invokevirtual 570	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   465: return
    //   466: aload_1
    //   467: invokestatic 316	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)Z
    //   470: ifeq +279 -> 749
    //   473: bipush 80
    //   475: istore 10
    //   477: aconst_null
    //   478: astore 19
    //   480: new 340	java/io/FileOutputStream
    //   483: dup
    //   484: aload_3
    //   485: invokespecial 343	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   488: astore 18
    //   490: aload 18
    //   492: astore 19
    //   494: aload 4
    //   496: aload 20
    //   498: getstatic 349	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   501: iload 10
    //   503: aload 18
    //   505: invokevirtual 352	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   508: putfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   511: aload 18
    //   513: astore 19
    //   515: aload 4
    //   517: iconst_1
    //   518: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   521: aload 18
    //   523: astore 19
    //   525: aload 4
    //   527: getfield 355	com/tencent/mobileqq/activity/photo/ImageInfo:l	Z
    //   530: ifeq +607 -> 1137
    //   533: aload 18
    //   535: astore 19
    //   537: aload 18
    //   539: invokestatic 361	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/FileOutputStream;)V
    //   542: goto +595 -> 1137
    //   545: lload 16
    //   547: l2i
    //   548: istore 10
    //   550: aload 18
    //   552: astore 19
    //   554: ldc_w 793
    //   557: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   560: aload 18
    //   562: astore 19
    //   564: aload_3
    //   565: invokevirtual 371	java/io/File:length	()J
    //   568: iload 10
    //   570: i2l
    //   571: lcmp
    //   572: ifle +559 -> 1131
    //   575: aload 18
    //   577: astore 19
    //   579: aload_2
    //   580: invokestatic 390	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   583: istore 11
    //   585: iload 11
    //   587: ifne +544 -> 1131
    //   590: iconst_1
    //   591: istore 10
    //   593: aload 18
    //   595: ifnull +8 -> 603
    //   598: aload 18
    //   600: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   603: aload 20
    //   605: ifnull +523 -> 1128
    //   608: aload 20
    //   610: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   613: ifne +515 -> 1128
    //   616: aload 20
    //   618: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   621: iload 10
    //   623: ifeq -298 -> 325
    //   626: aload_3
    //   627: invokevirtual 547	java/io/File:exists	()Z
    //   630: ifeq +449 -> 1079
    //   633: aload_3
    //   634: invokevirtual 323	java/io/File:delete	()Z
    //   637: ifeq +442 -> 1079
    //   640: aload_3
    //   641: invokevirtual 395	java/io/File:createNewFile	()Z
    //   644: ifeq +435 -> 1079
    //   647: iconst_1
    //   648: istore 11
    //   650: aload 4
    //   652: ldc_w 307
    //   655: new 95	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   662: ldc_w 795
    //   665: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_3
    //   669: invokevirtual 371	java/io/File:length	()J
    //   672: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   675: ldc_w 797
    //   678: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: iload 11
    //   683: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   686: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 314	com/tencent/mobileqq/utils/ImageUtil:a	(Lcom/tencent/mobileqq/activity/photo/ImageInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   692: iload 11
    //   694: ifeq -369 -> 325
    //   697: aload 4
    //   699: iconst_0
    //   700: putfield 320	com/tencent/mobileqq/activity/photo/ImageInfo:jdField_h_of_type_Boolean	Z
    //   703: aload 4
    //   705: iconst_0
    //   706: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   709: aload 4
    //   711: iconst_0
    //   712: putfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   715: iload_0
    //   716: aload_1
    //   717: aload_2
    //   718: aload_3
    //   719: aload 4
    //   721: iload 5
    //   723: iload 6
    //   725: iload 7
    //   727: iload 8
    //   729: iload 9
    //   731: invokestatic 654	com/tencent/mobileqq/utils/ImageUtil:a	(ILandroid/content/Context;Ljava/io/File;Ljava/io/File;Lcom/tencent/mobileqq/activity/photo/ImageInfo;IIIZZ)V
    //   734: return
    //   735: astore_1
    //   736: ldc_w 799
    //   739: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   742: aload 4
    //   744: iconst_0
    //   745: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   748: return
    //   749: bipush 70
    //   751: istore 10
    //   753: goto -276 -> 477
    //   756: aload 18
    //   758: astore 19
    //   760: invokestatic 413	com/tencent/mobileqq/transfile/chatpic/PicUploadFileSizeLimit:getLimitGroup	()J
    //   763: lstore 16
    //   765: goto -220 -> 545
    //   768: astore 18
    //   770: new 95	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   777: ldc_w 801
    //   780: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload 18
    //   785: invokevirtual 416	java/io/IOException:getMessage	()Ljava/lang/String;
    //   788: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   797: goto -194 -> 603
    //   800: astore 18
    //   802: aconst_null
    //   803: astore 18
    //   805: ldc_w 803
    //   808: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   811: aload 4
    //   813: iconst_0
    //   814: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   817: aload 4
    //   819: invokestatic 401	com/tencent/mobileqq/utils/ImageUtil:a	()Z
    //   822: putfield 404	com/tencent/mobileqq/activity/photo/ImageInfo:m	Z
    //   825: aload 18
    //   827: ifnull +8 -> 835
    //   830: aload 18
    //   832: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   835: aload_3
    //   836: ifnull +8 -> 844
    //   839: aload_3
    //   840: invokevirtual 323	java/io/File:delete	()Z
    //   843: pop
    //   844: aload 20
    //   846: ifnull +276 -> 1122
    //   849: aload 20
    //   851: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   854: ifne +268 -> 1122
    //   857: aload 20
    //   859: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   862: iconst_0
    //   863: istore 10
    //   865: goto -244 -> 621
    //   868: astore 18
    //   870: new 95	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   877: ldc_w 801
    //   880: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload 18
    //   885: invokevirtual 416	java/io/IOException:getMessage	()Ljava/lang/String;
    //   888: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   894: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   897: goto -62 -> 835
    //   900: astore 18
    //   902: aconst_null
    //   903: astore 18
    //   905: aload 18
    //   907: astore 19
    //   909: ldc_w 805
    //   912: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   915: aload 4
    //   917: iconst_1
    //   918: putfield 145	com/tencent/mobileqq/activity/photo/ImageInfo:g	Z
    //   921: aload 4
    //   923: iconst_0
    //   924: putfield 358	com/tencent/mobileqq/activity/photo/ImageInfo:o	Z
    //   927: aload 18
    //   929: ifnull +8 -> 937
    //   932: aload 18
    //   934: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   937: aload_3
    //   938: ifnull +8 -> 946
    //   941: aload_3
    //   942: invokevirtual 323	java/io/File:delete	()Z
    //   945: pop
    //   946: aload 20
    //   948: ifnull +174 -> 1122
    //   951: aload 20
    //   953: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   956: ifne +166 -> 1122
    //   959: aload 20
    //   961: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   964: iconst_0
    //   965: istore 10
    //   967: goto -346 -> 621
    //   970: astore 18
    //   972: new 95	java/lang/StringBuilder
    //   975: dup
    //   976: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   979: ldc_w 801
    //   982: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: aload 18
    //   987: invokevirtual 416	java/io/IOException:getMessage	()Ljava/lang/String;
    //   990: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   996: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   999: goto -62 -> 937
    //   1002: astore_1
    //   1003: iconst_0
    //   1004: istore_0
    //   1005: aload 19
    //   1007: astore_2
    //   1008: aload_2
    //   1009: ifnull +7 -> 1016
    //   1012: aload_2
    //   1013: invokevirtual 377	java/io/FileOutputStream:close	()V
    //   1016: iload_0
    //   1017: ifeq +12 -> 1029
    //   1020: aload_3
    //   1021: ifnull +8 -> 1029
    //   1024: aload_3
    //   1025: invokevirtual 323	java/io/File:delete	()Z
    //   1028: pop
    //   1029: aload 20
    //   1031: ifnull +16 -> 1047
    //   1034: aload 20
    //   1036: invokevirtual 204	android/graphics/Bitmap:isRecycled	()Z
    //   1039: ifne +8 -> 1047
    //   1042: aload 20
    //   1044: invokevirtual 213	android/graphics/Bitmap:recycle	()V
    //   1047: aload_1
    //   1048: athrow
    //   1049: astore_2
    //   1050: new 95	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1057: ldc_w 801
    //   1060: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: aload_2
    //   1064: invokevirtual 416	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1067: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1073: invokestatic 111	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)V
    //   1076: goto -60 -> 1016
    //   1079: iconst_0
    //   1080: istore 11
    //   1082: goto -432 -> 650
    //   1085: astore_1
    //   1086: aload 19
    //   1088: astore_2
    //   1089: iconst_0
    //   1090: istore_0
    //   1091: goto -83 -> 1008
    //   1094: astore_1
    //   1095: aload 18
    //   1097: astore_2
    //   1098: iconst_0
    //   1099: istore_0
    //   1100: goto -92 -> 1008
    //   1103: astore_1
    //   1104: aload 18
    //   1106: astore_2
    //   1107: iconst_1
    //   1108: istore_0
    //   1109: goto -101 -> 1008
    //   1112: astore 19
    //   1114: goto -209 -> 905
    //   1117: astore 19
    //   1119: goto -314 -> 805
    //   1122: iconst_0
    //   1123: istore 10
    //   1125: goto -504 -> 621
    //   1128: goto -507 -> 621
    //   1131: iconst_0
    //   1132: istore 10
    //   1134: goto -541 -> 593
    //   1137: iload 5
    //   1139: iconst_1
    //   1140: if_icmpeq +27 -> 1167
    //   1143: iload 5
    //   1145: sipush 1001
    //   1148: if_icmpeq +19 -> 1167
    //   1151: iload 5
    //   1153: sipush 10002
    //   1156: if_icmpeq +11 -> 1167
    //   1159: iload 5
    //   1161: sipush 3000
    //   1164: if_icmpne -33 -> 1131
    //   1167: lload 14
    //   1169: lstore 16
    //   1171: iload 5
    //   1173: sipush 1001
    //   1176: if_icmpeq -631 -> 545
    //   1179: iload 5
    //   1181: sipush 10002
    //   1184: if_icmpne -428 -> 756
    //   1187: lload 14
    //   1189: lstore 16
    //   1191: goto -646 -> 545
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1194	0	paramInt1	int
    //   0	1194	1	paramContext	Context
    //   0	1194	2	paramFile1	File
    //   0	1194	3	paramFile2	File
    //   0	1194	4	paramImageInfo	ImageInfo
    //   0	1194	5	paramInt2	int
    //   0	1194	6	paramInt3	int
    //   0	1194	7	paramInt4	int
    //   0	1194	8	paramBoolean1	boolean
    //   0	1194	9	paramBoolean2	boolean
    //   475	658	10	i	int
    //   171	910	11	bool1	boolean
    //   200	204	12	bool2	boolean
    //   228	182	13	bool3	boolean
    //   59	1129	14	l1	long
    //   95	1095	16	l2	long
    //   326	1	18	localOutOfMemoryError1	OutOfMemoryError
    //   488	269	18	localFileOutputStream	java.io.FileOutputStream
    //   768	16	18	localIOException1	java.io.IOException
    //   800	1	18	localException1	Exception
    //   803	28	18	localObject1	Object
    //   868	16	18	localIOException2	java.io.IOException
    //   900	1	18	localOutOfMemoryError2	OutOfMemoryError
    //   903	30	18	localObject2	Object
    //   970	135	18	localIOException3	java.io.IOException
    //   478	609	19	localObject3	Object
    //   1112	1	19	localOutOfMemoryError3	OutOfMemoryError
    //   1117	1	19	localException2	Exception
    //   53	990	20	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   46	55	326	java/lang/OutOfMemoryError
    //   626	647	735	java/io/IOException
    //   650	692	735	java/io/IOException
    //   697	734	735	java/io/IOException
    //   598	603	768	java/io/IOException
    //   480	490	800	java/lang/Exception
    //   830	835	868	java/io/IOException
    //   480	490	900	java/lang/OutOfMemoryError
    //   932	937	970	java/io/IOException
    //   480	490	1002	finally
    //   1012	1016	1049	java/io/IOException
    //   494	511	1085	finally
    //   515	521	1085	finally
    //   525	533	1085	finally
    //   537	542	1085	finally
    //   554	560	1085	finally
    //   564	575	1085	finally
    //   579	585	1085	finally
    //   760	765	1085	finally
    //   909	915	1085	finally
    //   805	825	1094	finally
    //   915	927	1103	finally
    //   494	511	1112	java/lang/OutOfMemoryError
    //   515	521	1112	java/lang/OutOfMemoryError
    //   525	533	1112	java/lang/OutOfMemoryError
    //   537	542	1112	java/lang/OutOfMemoryError
    //   554	560	1112	java/lang/OutOfMemoryError
    //   564	575	1112	java/lang/OutOfMemoryError
    //   579	585	1112	java/lang/OutOfMemoryError
    //   760	765	1112	java/lang/OutOfMemoryError
    //   494	511	1117	java/lang/Exception
    //   515	521	1117	java/lang/Exception
    //   525	533	1117	java/lang/Exception
    //   537	542	1117	java/lang/Exception
    //   554	560	1117	java/lang/Exception
    //   564	575	1117	java/lang/Exception
    //   579	585	1117	java/lang/Exception
    //   760	765	1117	java/lang/Exception
  }
  
  public static int c(String paramString)
  {
    if (PhotoIncompatibleBase.b(paramString))
    {
      switch (com.tencent.image.Utils.getHeifOrientation(paramString))
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    return JpegExifReader.getRotationDegree(paramString);
  }
  
  public static int d(String paramString)
  {
    if (PhotoIncompatibleBase.b(paramString)) {
      return com.tencent.image.Utils.getHeifOrientation(paramString);
    }
    return JpegExifReader.readOrientation(paramString);
  }
  
  public static Drawable d()
  {
    return new BitmapDrawable(f());
  }
  
  public static int e(String paramString)
  {
    int i = 3;
    int j = JpegExifReader.readOrientation(paramString);
    if (j == 6) {
      i = 1;
    }
    do
    {
      return i;
      if (j == 3) {
        return 2;
      }
    } while (j == 8);
    return 0;
  }
  
  public static Bitmap e()
  {
    String str;
    if (QQTheme.e()) {
      str = "static://DefaultPhoneContactFace_square";
    }
    for (int i = 2130840540;; i = 2130840539)
    {
      if (GlobalImageCache.a != null) {}
      for (Bitmap localBitmap1 = (Bitmap)GlobalImageCache.a.get(str);; localBitmap1 = null)
      {
        Bitmap localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap1 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), i);
          if ((localBitmap1 != null) && (GlobalImageCache.a != null)) {
            GlobalImageCache.a.put(str, localBitmap1);
          }
          localBitmap2 = localBitmap1;
          if (QLog.isColorLevel())
          {
            QLog.d("ImageUtil", 2, "getDefaultPhoneContactBitmap, bitmap=" + localBitmap1);
            localBitmap2 = localBitmap1;
          }
        }
        return localBitmap2;
      }
      str = "static://DefaultPhoneContactFace";
    }
  }
  
  public static Drawable e()
  {
    return new BitmapDrawable(i());
  }
  
  public static Bitmap f()
  {
    String str;
    if (QQTheme.e()) {
      str = "static://DefaultFace140_140_square";
    }
    for (int i = 2130840455;; i = 2130840454)
    {
      if (GlobalImageCache.a != null) {}
      for (Bitmap localBitmap1 = (Bitmap)GlobalImageCache.a.get(str);; localBitmap1 = null)
      {
        Bitmap localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap1 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), i);
          if ((localBitmap1 != null) && (GlobalImageCache.a != null)) {
            GlobalImageCache.a.put(str, localBitmap1);
          }
          localBitmap2 = localBitmap1;
          if (QLog.isColorLevel())
          {
            QLog.d("ImageUtil", 2, "getDefaultFaceBitmap140_140, bitmap=" + localBitmap1);
            localBitmap2 = localBitmap1;
          }
        }
        return localBitmap2;
      }
      str = "static://DefaultFace140_140";
    }
  }
  
  public static Drawable f()
  {
    return new BitmapDrawable(j());
  }
  
  public static Bitmap g()
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
  
  public static Bitmap h()
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
  
  public static Bitmap i()
  {
    Bitmap localBitmap1 = null;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get("static://DefaultTroopFaceNew");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = c(BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130840708), 50, 50);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.a != null)
        {
          GlobalImageCache.a.put("static://DefaultTroopFaceNew", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static Bitmap j()
  {
    Bitmap localBitmap1 = null;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get("static://DefaultSubAccountFace");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), 2130840558);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.a != null)
        {
          GlobalImageCache.a.put("static://DefaultSubAccountFace", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ImageUtil
 * JD-Core Version:    0.7.0.1
 */