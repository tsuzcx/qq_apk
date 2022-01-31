package com.tencent.mobileqq.transfile;

import aisa;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AppRuntime;

public class VasExtensionDownloader
  extends AbsDownloader
{
  protected BaseApplicationImpl a;
  
  public VasExtensionDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    return a(paramBitmap, false);
  }
  
  private Bitmap a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((paramBitmap == null) || (this.a == null)) {
      return null;
    }
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    float f1;
    float f5;
    float f6;
    float f4;
    float f3;
    float f2;
    if (j <= i)
    {
      f1 = j / 2;
      f5 = j;
      f6 = j;
      f4 = j;
      f3 = j;
      i = j;
      f2 = 0.0F;
    }
    for (;;)
    {
      if (paramBoolean) {
        f1 = 5.0F * this.a.getResources().getDisplayMetrics().density + 0.5F;
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect((int)f2, (int)0.0F, (int)f6, (int)f5);
      Rect localRect2 = new Rect((int)0.0F, (int)0.0F, (int)f4, (int)f3);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
      f1 = i / 2;
      f6 = (j - i) / 2;
      float f7 = j;
      f5 = i;
      f4 = i;
      f3 = i;
      f2 = f6;
      f6 = f7 - f6;
      j = i;
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams == null) || (paramDownloadParams.url == null)) {}
    String str;
    Object localObject1;
    do
    {
      return null;
      str = paramDownloadParams.url.getHost();
      localObject1 = paramDownloadParams.url.getFile();
      if (QLog.isColorLevel()) {
        QLog.d("VasExtensionDownloader", 2, "downloadImage, host = " + str + ", epId = " + (String)localObject1);
      }
      if (!"EMOTICON_TAB".equals(str)) {
        break;
      }
    } while ((paramDownloadParams.mExtraInfo == null) || (localObject1 == null));
    if (((String)localObject1).startsWith("/")) {}
    for (paramOutputStream = ((String)localObject1).substring(1, ((String)localObject1).length());; paramOutputStream = (OutputStream)localObject1)
    {
      paramURLDrawableHandler = paramOutputStream.split("_");
      paramOutputStream = paramURLDrawableHandler[0];
      localObject1 = (Boolean)paramDownloadParams.mExtraInfo;
      boolean bool1 = Boolean.valueOf(paramURLDrawableHandler[1]).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("VasExtensionDownloader", 2, "downloadImage, completed = " + bool1 + ", epId = " + paramOutputStream);
      }
      label200:
      Object localObject2;
      if (bool1)
      {
        paramURLDrawableHandler = EmosmUtils.a(3, paramOutputStream);
        localObject2 = new File(paramURLDrawableHandler);
      }
      for (;;)
      {
        try
        {
          boolean bool2 = ((File)localObject2).exists();
          if (bool2)
          {
            return localObject2;
            paramURLDrawableHandler = EmosmUtils.a(4, paramOutputStream);
            break label200;
          }
          if (!bool1) {
            continue;
          }
          if (((Boolean)localObject1).booleanValue()) {
            continue;
          }
          paramOutputStream = EmosmUtils.b(3, paramOutputStream);
        }
        catch (OutOfMemoryError paramOutputStream)
        {
          label261:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("EmoticonTabAdapter", 2, "getTabDrawable OOM return null");
          paramOutputStream = null;
          continue;
        }
        localObject1 = paramURLDrawableHandler;
        paramURLDrawableHandler = paramOutputStream;
        paramOutputStream = (OutputStream)localObject1;
        if (paramURLDrawableHandler == null) {
          break label1178;
        }
        if (!"FAVORITE_PANEL_THUMB".equals(str)) {
          paramDownloadParams.url = new URL(paramURLDrawableHandler);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VasExtensionDownloader", 2, "downloadImage : " + paramURLDrawableHandler + " -> " + paramOutputStream);
        }
        localObject1 = new File(paramOutputStream);
        if (DownloaderFactory.a(new DownloadTask(paramURLDrawableHandler, (File)localObject1), null) != 0) {
          break;
        }
        if (((paramDownloadParams.mExtraInfo instanceof FavoriteEmoticonInfo)) && ("FAVORITE_PANEL_THUMB".equals(str))) {
          a((FavoriteEmoticonInfo)paramDownloadParams.mExtraInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("VasExtensionDownloader", 2, "download sucessful " + paramURLDrawableHandler + " to path " + paramOutputStream);
        }
        return localObject1;
        paramOutputStream = EmosmUtils.b(17, paramOutputStream);
        continue;
        if (!((Boolean)localObject1).booleanValue()) {
          paramOutputStream = EmosmUtils.b(4, paramOutputStream);
        } else {
          paramOutputStream = EmosmUtils.b(18, paramOutputStream);
        }
      }
      if ("FAVOROTE_PANEL_DYNAMIC".equals(str))
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        paramOutputStream = new File((String)localObject1);
        if (!paramOutputStream.exists()) {
          break;
        }
        return paramOutputStream;
      }
      if ("FAVORITE_PANEL_THUMB".equals(str))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramOutputStream = new File((String)localObject1);
          if (paramOutputStream.exists()) {
            return paramOutputStream;
          }
        }
        if (!(paramDownloadParams.mExtraInfo instanceof FavoriteEmoticonInfo)) {
          break label1180;
        }
        localObject2 = ((FavoriteEmoticonInfo)paramDownloadParams.mExtraInfo).e;
        paramOutputStream = (OutputStream)localObject2;
        paramURLDrawableHandler = (URLDrawableHandler)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { localObject1, localObject2 }));
          paramURLDrawableHandler = (URLDrawableHandler)localObject1;
        }
      }
      for (paramOutputStream = (OutputStream)localObject2;; paramOutputStream = null)
      {
        localObject1 = paramOutputStream;
        paramOutputStream = paramURLDrawableHandler;
        paramURLDrawableHandler = (URLDrawableHandler)localObject1;
        break label261;
        if ("RESOURCE_IMG".equals(str)) {
          break;
        }
        if ("EMOTICON_DIY".equals(str)) {
          return new File(AppConstants.aJ);
        }
        if ("REDPACKET_SEND_PIC".equals(str))
        {
          paramOutputStream = BaseApplicationImpl.sApplication.getRuntime().getAccount();
          try
          {
            paramOutputStream = (AppInterface)this.a.getAppRuntime(paramOutputStream);
            if ((paramOutputStream == null) || (!(paramOutputStream instanceof QQAppInterface)))
            {
              QLog.e("VasExtensionDownloader", 2, "downloadImage redpacket send img app ==null or app not instanceof qqapp");
              return null;
            }
          }
          catch (Throwable paramOutputStream)
          {
            for (;;)
            {
              QLog.d("VasExtensionDownloader", 2, "exception:" + paramOutputStream.getMessage());
              paramOutputStream = null;
            }
            paramOutputStream = (IndividualRedPacketManager)paramOutputStream.getManager(130);
          }
          if (paramOutputStream == null) {
            break;
          }
          paramOutputStream = paramOutputStream.a();
          if (QLog.isColorLevel()) {
            QLog.d("VasExtensionDownloader", 2, "downloadImage redpacket send img filename = " + paramOutputStream);
          }
          if (TextUtils.isEmpty(paramOutputStream)) {
            break;
          }
          return new File(paramOutputStream);
        }
        if (("COMMERCIAL_DRAINAGE".equals(str)) || ("IP_SITE_IMAGE".equals(str)))
        {
          if ((paramDownloadParams.url == null) || (TextUtils.isEmpty(paramDownloadParams.url.getFile()))) {
            break;
          }
          paramOutputStream = ((String)localObject1).split("_");
          paramURLDrawableHandler = paramOutputStream[1];
          paramOutputStream = paramOutputStream[0].substring(1);
          if ("COMMERCIAL_DRAINAGE".equals(str)) {}
          for (int i = 22;; i = 23)
          {
            paramDownloadParams = EmosmUtils.a(i, paramURLDrawableHandler, MD5.toMD5(paramDownloadParams.url.getFile()));
            if (QLog.isColorLevel()) {
              QLog.d("VasExtensionDownloader", 2, "emotion save local filePath: " + paramDownloadParams);
            }
            paramDownloadParams = new File(paramDownloadParams);
            if (!paramDownloadParams.exists()) {
              break;
            }
            return paramDownloadParams;
          }
          if (DownloaderFactory.a(new DownloadTask(paramOutputStream, paramDownloadParams), null) != 0) {
            break;
          }
          return paramDownloadParams;
        }
        if (("COMIC_IP_SITE_ROUND_IMAGE".equals(str)) || ("COMIC_IPSITE_GAME_IMAGE".equals(str)))
        {
          if ((paramDownloadParams.url == null) || (TextUtils.isEmpty(paramDownloadParams.url.getFile()))) {
            break;
          }
          paramDownloadParams = paramDownloadParams.url.getFile();
          paramOutputStream = paramDownloadParams;
          if (paramDownloadParams.startsWith("/")) {
            paramOutputStream = paramDownloadParams.substring(1, paramDownloadParams.length());
          }
          paramDownloadParams = MD5.toMD5(paramOutputStream);
          paramDownloadParams = AppConstants.aJ + ".comicIPSite" + File.separator + paramDownloadParams;
          if (QLog.isColorLevel()) {
            QLog.d("VasExtensionDownloader", 2, "emotion save local filePath: " + paramDownloadParams);
          }
          paramDownloadParams = new File(paramDownloadParams);
          if (paramDownloadParams.exists()) {
            return paramDownloadParams;
          }
          if (DownloaderFactory.a(new DownloadTask(paramOutputStream, paramDownloadParams), null) != 0) {
            break;
          }
          return paramDownloadParams;
        }
        paramOutputStream = null;
        paramURLDrawableHandler = null;
        break label261;
        label1178:
        break;
        label1180:
        paramURLDrawableHandler = null;
      }
    }
  }
  
  public void a(FavoriteEmoticonInfo paramFavoriteEmoticonInfo)
  {
    if (paramFavoriteEmoticonInfo == null) {
      return;
    }
    ThreadManager.post(new aisa(this, paramFavoriteEmoticonInfo), 5, null, false);
  }
  
  public boolean a()
  {
    return false;
  }
  
  /* Error */
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: getfield 121	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   8: ifnonnull +7 -> 15
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +32 -> 50
    //   21: ldc 138
    //   23: iconst_2
    //   24: new 140	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 375
    //   34: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_2
    //   38: getfield 121	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   41: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_2
    //   51: getfield 121	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   54: invokevirtual 127	java/net/URL:getHost	()Ljava/lang/String;
    //   57: astore_3
    //   58: ldc_w 275
    //   61: aload_3
    //   62: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifeq +160 -> 225
    //   68: aload_2
    //   69: getfield 121	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   72: invokevirtual 130	java/net/URL:getFile	()Ljava/lang/String;
    //   75: astore_2
    //   76: aload_2
    //   77: astore_1
    //   78: aload_2
    //   79: ldc 170
    //   81: invokevirtual 174	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   84: ifeq +13 -> 97
    //   87: aload_2
    //   88: iconst_1
    //   89: aload_2
    //   90: invokevirtual 177	java/lang/String:length	()I
    //   93: invokevirtual 181	java/lang/String:substring	(II)Ljava/lang/String;
    //   96: astore_1
    //   97: aload_1
    //   98: invokestatic 261	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +14 -> 115
    //   104: ldc 138
    //   106: iconst_1
    //   107: ldc_w 380
    //   110: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aconst_null
    //   114: areturn
    //   115: aload_1
    //   116: invokestatic 385	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   119: invokevirtual 388	java/lang/Integer:intValue	()I
    //   122: istore 4
    //   124: invokestatic 392	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   127: invokevirtual 34	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   130: iload 4
    //   132: invokestatic 398	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   135: astore_2
    //   136: aload_2
    //   137: areturn
    //   138: astore_2
    //   139: ldc 138
    //   141: iconst_1
    //   142: new 140	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 400
    //   152: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aconst_null
    //   166: areturn
    //   167: astore_2
    //   168: ldc 138
    //   170: iconst_1
    //   171: new 140	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 402
    //   181: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aconst_null
    //   195: areturn
    //   196: astore_2
    //   197: ldc 138
    //   199: iconst_1
    //   200: new 140	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 404
    //   210: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_1
    //   214: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aconst_null
    //   224: areturn
    //   225: ldc_w 277
    //   228: aload_3
    //   229: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   232: ifeq +227 -> 459
    //   235: aload_2
    //   236: getfield 121	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   239: invokevirtual 130	java/net/URL:getFile	()Ljava/lang/String;
    //   242: astore_3
    //   243: aload_3
    //   244: invokestatic 406	com/tencent/mobileqq/emosm/EmosmUtils:b	(Ljava/lang/String;)Z
    //   247: ifeq +52 -> 299
    //   250: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +29 -> 282
    //   256: ldc 138
    //   258: iconst_2
    //   259: new 140	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   266: ldc_w 408
    //   269: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_3
    //   273: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: new 208	java/io/File
    //   285: dup
    //   286: aload_3
    //   287: invokespecial 211	java/io/File:<init>	(Ljava/lang/String;)V
    //   290: iconst_1
    //   291: iconst_1
    //   292: iconst_0
    //   293: iconst_0
    //   294: fconst_0
    //   295: invokestatic 414	com/tencent/image/NativeGifFactory:getNativeGifObject	(Ljava/io/File;ZZIIF)Lcom/tencent/image/AbstractGifImage;
    //   298: areturn
    //   299: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +29 -> 331
    //   305: ldc 138
    //   307: iconst_2
    //   308: new 140	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 416
    //   318: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_3
    //   322: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aload_3
    //   332: invokestatic 419	com/tencent/mobileqq/emosm/EmosmUtils:b	(Ljava/lang/String;)[B
    //   335: astore_1
    //   336: aload_1
    //   337: ifnull +92 -> 429
    //   340: aconst_null
    //   341: astore_2
    //   342: aload_1
    //   343: iconst_0
    //   344: aload_1
    //   345: arraylength
    //   346: aconst_null
    //   347: invokestatic 423	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   350: astore_1
    //   351: aload_1
    //   352: astore_2
    //   353: aload_2
    //   354: astore_1
    //   355: aload_2
    //   356: ifnonnull -343 -> 13
    //   359: ldc 138
    //   361: iconst_2
    //   362: new 140	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 425
    //   372: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_3
    //   376: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: aconst_null
    //   386: areturn
    //   387: astore_1
    //   388: ldc_w 427
    //   391: iconst_1
    //   392: new 140	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 429
    //   402: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_3
    //   406: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: goto -62 -> 353
    //   418: astore_1
    //   419: ldc 138
    //   421: iconst_1
    //   422: ldc_w 431
    //   425: aload_1
    //   426: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: aconst_null
    //   430: areturn
    //   431: astore_1
    //   432: ldc 138
    //   434: iconst_1
    //   435: ldc_w 431
    //   438: aload_1
    //   439: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: goto -13 -> 429
    //   445: astore_1
    //   446: ldc 138
    //   448: iconst_1
    //   449: ldc_w 431
    //   452: aload_1
    //   453: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   456: goto -27 -> 429
    //   459: ldc_w 284
    //   462: aload_3
    //   463: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: ifeq +146 -> 612
    //   469: aload_1
    //   470: ifnonnull +14 -> 484
    //   473: ldc 138
    //   475: iconst_1
    //   476: ldc_w 436
    //   479: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: aconst_null
    //   483: areturn
    //   484: aload_1
    //   485: invokevirtual 439	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   488: astore_1
    //   489: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq +29 -> 521
    //   495: ldc 138
    //   497: iconst_2
    //   498: new 140	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 441
    //   508: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: new 443	java/io/FileInputStream
    //   524: dup
    //   525: aload_1
    //   526: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   529: astore_2
    //   530: new 446	java/io/BufferedInputStream
    //   533: dup
    //   534: aload_2
    //   535: invokespecial 449	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   538: invokestatic 455	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   541: astore_1
    //   542: aload_2
    //   543: invokevirtual 458	java/io/FileInputStream:close	()V
    //   546: aload_1
    //   547: areturn
    //   548: astore_2
    //   549: ldc 138
    //   551: iconst_1
    //   552: new 140	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   559: ldc_w 460
    //   562: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload_2
    //   566: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   569: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: aload_1
    //   579: areturn
    //   580: astore_1
    //   581: ldc 138
    //   583: iconst_1
    //   584: new 140	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 463
    //   594: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload_1
    //   598: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   601: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: aconst_null
    //   611: areturn
    //   612: ldc 219
    //   614: aload_3
    //   615: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   618: ifeq +496 -> 1114
    //   621: aload_2
    //   622: getfield 466	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   625: instanceof 468
    //   628: ifne +34 -> 662
    //   631: ldc 138
    //   633: iconst_1
    //   634: new 140	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   641: ldc_w 470
    //   644: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: aload_2
    //   648: getfield 121	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   651: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   654: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   660: aconst_null
    //   661: areturn
    //   662: aload_2
    //   663: getfield 466	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   666: checkcast 468	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   669: astore_1
    //   670: aload_1
    //   671: ifnull +412 -> 1083
    //   674: aload_1
    //   675: getfield 473	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   678: astore_3
    //   679: new 208	java/io/File
    //   682: dup
    //   683: aload_3
    //   684: invokespecial 211	java/io/File:<init>	(Ljava/lang/String;)V
    //   687: astore 6
    //   689: aload 6
    //   691: invokestatic 479	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   694: ifeq +86 -> 780
    //   697: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   700: ifeq +29 -> 729
    //   703: ldc 138
    //   705: iconst_2
    //   706: new 140	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   713: ldc_w 408
    //   716: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload_3
    //   720: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   729: new 481	com/tencent/mobileqq/transfile/VasExtensionDownloader$ThumbGifImage
    //   732: dup
    //   733: aload_0
    //   734: aload 6
    //   736: iconst_1
    //   737: aload_2
    //   738: getfield 484	com/tencent/image/DownloadParams:mGifRoundCorner	F
    //   741: invokespecial 487	com/tencent/mobileqq/transfile/VasExtensionDownloader$ThumbGifImage:<init>	(Lcom/tencent/mobileqq/transfile/VasExtensionDownloader;Ljava/io/File;ZF)V
    //   744: astore_1
    //   745: aload_1
    //   746: areturn
    //   747: astore_1
    //   748: ldc 138
    //   750: iconst_2
    //   751: new 140	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   758: ldc_w 489
    //   761: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload_2
    //   765: getfield 121	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   768: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: aload_1
    //   775: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   778: aconst_null
    //   779: areturn
    //   780: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   783: ifeq +29 -> 812
    //   786: ldc 138
    //   788: iconst_2
    //   789: new 140	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   796: ldc_w 491
    //   799: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload_3
    //   803: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: new 493	android/graphics/BitmapFactory$Options
    //   815: dup
    //   816: invokespecial 494	android/graphics/BitmapFactory$Options:<init>	()V
    //   819: astore 6
    //   821: aload 6
    //   823: iconst_1
    //   824: putfield 498	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   827: aload_1
    //   828: getfield 473	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   831: aload 6
    //   833: invokestatic 501	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   836: pop
    //   837: aload 6
    //   839: aload 6
    //   841: aload_1
    //   842: getfield 505	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   845: aload_1
    //   846: getfield 508	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   849: invokestatic 513	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   852: putfield 516	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   855: aload 6
    //   857: iconst_0
    //   858: putfield 498	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   861: new 443	java/io/FileInputStream
    //   864: dup
    //   865: aload_3
    //   866: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   869: astore 7
    //   871: new 446	java/io/BufferedInputStream
    //   874: dup
    //   875: aload 7
    //   877: invokespecial 449	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   880: aconst_null
    //   881: aload 6
    //   883: invokestatic 519	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   886: astore_3
    //   887: aload 7
    //   889: invokevirtual 458	java/io/FileInputStream:close	()V
    //   892: aload_3
    //   893: ifnonnull +34 -> 927
    //   896: ldc 138
    //   898: iconst_2
    //   899: new 140	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   906: ldc_w 521
    //   909: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload_2
    //   913: getfield 121	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   916: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   919: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   925: aconst_null
    //   926: areturn
    //   927: aload_3
    //   928: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   931: istore 4
    //   933: aload_3
    //   934: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   937: istore 5
    //   939: new 67	android/graphics/Rect
    //   942: dup
    //   943: invokespecial 522	android/graphics/Rect:<init>	()V
    //   946: astore 6
    //   948: new 72	android/graphics/RectF
    //   951: dup
    //   952: fconst_0
    //   953: fconst_0
    //   954: aload_1
    //   955: getfield 505	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   958: i2f
    //   959: aload_1
    //   960: getfield 505	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   963: i2f
    //   964: invokespecial 525	android/graphics/RectF:<init>	(FFFF)V
    //   967: astore 7
    //   969: iload 4
    //   971: iload 5
    //   973: if_icmple +79 -> 1052
    //   976: iload 4
    //   978: iload 5
    //   980: isub
    //   981: iconst_2
    //   982: idiv
    //   983: istore 4
    //   985: aload 6
    //   987: iload 4
    //   989: iconst_0
    //   990: iload 4
    //   992: iload 5
    //   994: iadd
    //   995: iload 5
    //   997: iconst_0
    //   998: iadd
    //   999: invokevirtual 528	android/graphics/Rect:set	(IIII)V
    //   1002: aload_1
    //   1003: getfield 505	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1006: aload_1
    //   1007: getfield 505	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   1010: getstatic 53	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1013: invokestatic 57	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1016: astore_1
    //   1017: aload_1
    //   1018: ifnull +63 -> 1081
    //   1021: new 59	android/graphics/Canvas
    //   1024: dup
    //   1025: aload_1
    //   1026: invokespecial 62	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   1029: aload_3
    //   1030: aload 6
    //   1032: aload 7
    //   1034: new 64	android/graphics/Paint
    //   1037: dup
    //   1038: bipush 6
    //   1040: invokespecial 530	android/graphics/Paint:<init>	(I)V
    //   1043: invokevirtual 533	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   1046: aload_3
    //   1047: invokevirtual 536	android/graphics/Bitmap:recycle	()V
    //   1050: aload_1
    //   1051: areturn
    //   1052: iload 5
    //   1054: iload 4
    //   1056: isub
    //   1057: iconst_2
    //   1058: idiv
    //   1059: istore 5
    //   1061: aload 6
    //   1063: iconst_0
    //   1064: iload 5
    //   1066: iconst_0
    //   1067: iload 4
    //   1069: iadd
    //   1070: iload 4
    //   1072: iload 5
    //   1074: iadd
    //   1075: invokevirtual 528	android/graphics/Rect:set	(IIII)V
    //   1078: goto -76 -> 1002
    //   1081: aload_3
    //   1082: areturn
    //   1083: ldc 138
    //   1085: iconst_1
    //   1086: new 140	java/lang/StringBuilder
    //   1089: dup
    //   1090: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1093: ldc_w 538
    //   1096: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: aload_2
    //   1100: getfield 121	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1103: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1106: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1109: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1112: aconst_null
    //   1113: areturn
    //   1114: ldc_w 325
    //   1117: aload_3
    //   1118: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1121: ifeq +316 -> 1437
    //   1124: aload_1
    //   1125: ifnonnull +14 -> 1139
    //   1128: ldc 138
    //   1130: iconst_1
    //   1131: ldc_w 540
    //   1134: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1137: aconst_null
    //   1138: areturn
    //   1139: aload_1
    //   1140: invokevirtual 439	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1143: astore_1
    //   1144: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1147: ifeq +29 -> 1176
    //   1150: ldc 138
    //   1152: iconst_2
    //   1153: new 140	java/lang/StringBuilder
    //   1156: dup
    //   1157: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1160: ldc_w 542
    //   1163: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: aload_1
    //   1167: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1173: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1176: new 443	java/io/FileInputStream
    //   1179: dup
    //   1180: aload_1
    //   1181: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1184: astore_2
    //   1185: new 446	java/io/BufferedInputStream
    //   1188: dup
    //   1189: aload_2
    //   1190: invokespecial 449	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1193: invokestatic 455	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1196: astore_1
    //   1197: aload_2
    //   1198: invokevirtual 458	java/io/FileInputStream:close	()V
    //   1201: aload_1
    //   1202: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1205: aload_1
    //   1206: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1209: getstatic 53	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1212: invokestatic 57	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1215: astore_2
    //   1216: new 59	android/graphics/Canvas
    //   1219: dup
    //   1220: aload_2
    //   1221: invokespecial 62	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   1224: astore_3
    //   1225: new 64	android/graphics/Paint
    //   1228: dup
    //   1229: invokespecial 65	android/graphics/Paint:<init>	()V
    //   1232: astore 6
    //   1234: new 67	android/graphics/Rect
    //   1237: dup
    //   1238: iconst_0
    //   1239: iconst_0
    //   1240: aload_1
    //   1241: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1244: aload_1
    //   1245: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1248: invokespecial 70	android/graphics/Rect:<init>	(IIII)V
    //   1251: astore 7
    //   1253: new 72	android/graphics/RectF
    //   1256: dup
    //   1257: new 67	android/graphics/Rect
    //   1260: dup
    //   1261: iconst_0
    //   1262: iconst_0
    //   1263: aload_1
    //   1264: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1267: aload_1
    //   1268: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1271: invokespecial 70	android/graphics/Rect:<init>	(IIII)V
    //   1274: invokespecial 75	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   1277: astore 8
    //   1279: aload 6
    //   1281: iconst_1
    //   1282: invokevirtual 79	android/graphics/Paint:setAntiAlias	(Z)V
    //   1285: aload_3
    //   1286: iconst_0
    //   1287: iconst_0
    //   1288: iconst_0
    //   1289: iconst_0
    //   1290: invokevirtual 82	android/graphics/Canvas:drawARGB	(IIII)V
    //   1293: aload 6
    //   1295: ldc_w 543
    //   1298: invokevirtual 87	android/graphics/Paint:setColor	(I)V
    //   1301: aload_3
    //   1302: aload 8
    //   1304: ldc_w 544
    //   1307: ldc_w 544
    //   1310: aload 6
    //   1312: invokevirtual 91	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   1315: aload 6
    //   1317: new 93	android/graphics/PorterDuffXfermode
    //   1320: dup
    //   1321: getstatic 99	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   1324: invokespecial 102	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   1327: invokevirtual 106	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   1330: pop
    //   1331: aload_3
    //   1332: aload_1
    //   1333: new 67	android/graphics/Rect
    //   1336: dup
    //   1337: iconst_0
    //   1338: iconst_0
    //   1339: aload_1
    //   1340: invokevirtual 24	android/graphics/Bitmap:getWidth	()I
    //   1343: aload_1
    //   1344: invokevirtual 27	android/graphics/Bitmap:getHeight	()I
    //   1347: invokespecial 70	android/graphics/Rect:<init>	(IIII)V
    //   1350: aload 7
    //   1352: aload 6
    //   1354: invokevirtual 110	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1357: aload_2
    //   1358: areturn
    //   1359: astore_2
    //   1360: ldc 138
    //   1362: iconst_1
    //   1363: ldc_w 546
    //   1366: aload_2
    //   1367: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1370: aload_1
    //   1371: areturn
    //   1372: astore_1
    //   1373: ldc 138
    //   1375: iconst_1
    //   1376: new 140	java/lang/StringBuilder
    //   1379: dup
    //   1380: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1383: ldc_w 548
    //   1386: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: aload_1
    //   1390: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1393: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1399: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1402: aconst_null
    //   1403: areturn
    //   1404: astore_2
    //   1405: ldc 138
    //   1407: iconst_1
    //   1408: new 140	java/lang/StringBuilder
    //   1411: dup
    //   1412: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1415: ldc_w 550
    //   1418: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: aload_2
    //   1422: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1425: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1431: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1434: goto -233 -> 1201
    //   1437: ldc_w 343
    //   1440: aload_3
    //   1441: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1444: ifne +13 -> 1457
    //   1447: ldc_w 345
    //   1450: aload_3
    //   1451: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1454: ifeq -676 -> 778
    //   1457: aload_1
    //   1458: ifnonnull +14 -> 1472
    //   1461: ldc 138
    //   1463: iconst_1
    //   1464: ldc_w 552
    //   1467: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1470: aconst_null
    //   1471: areturn
    //   1472: aload_1
    //   1473: invokevirtual 439	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1476: astore_1
    //   1477: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1480: ifeq +29 -> 1509
    //   1483: ldc 138
    //   1485: iconst_2
    //   1486: new 140	java/lang/StringBuilder
    //   1489: dup
    //   1490: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1493: ldc_w 554
    //   1496: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: aload_1
    //   1500: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1506: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1509: new 443	java/io/FileInputStream
    //   1512: dup
    //   1513: aload_1
    //   1514: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1517: astore_1
    //   1518: new 446	java/io/BufferedInputStream
    //   1521: dup
    //   1522: aload_1
    //   1523: invokespecial 449	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1526: invokestatic 455	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1529: astore_2
    //   1530: aload_1
    //   1531: invokevirtual 458	java/io/FileInputStream:close	()V
    //   1534: ldc_w 343
    //   1537: aload_3
    //   1538: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1541: ifeq +74 -> 1615
    //   1544: aload_0
    //   1545: aload_2
    //   1546: invokespecial 556	com/tencent/mobileqq/transfile/VasExtensionDownloader:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   1549: areturn
    //   1550: astore_1
    //   1551: ldc 138
    //   1553: iconst_1
    //   1554: new 140	java/lang/StringBuilder
    //   1557: dup
    //   1558: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1561: ldc_w 558
    //   1564: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: aload_1
    //   1568: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1571: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1577: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1580: aconst_null
    //   1581: areturn
    //   1582: astore_1
    //   1583: ldc 138
    //   1585: iconst_1
    //   1586: new 140	java/lang/StringBuilder
    //   1589: dup
    //   1590: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   1593: ldc_w 560
    //   1596: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1599: aload_1
    //   1600: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1603: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1606: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1609: invokestatic 308	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1612: goto -78 -> 1534
    //   1615: aload_2
    //   1616: astore_1
    //   1617: ldc_w 345
    //   1620: aload_3
    //   1621: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1624: ifeq -1611 -> 13
    //   1627: aload_0
    //   1628: aload_2
    //   1629: iconst_1
    //   1630: invokespecial 18	com/tencent/mobileqq/transfile/VasExtensionDownloader:a	(Landroid/graphics/Bitmap;Z)Landroid/graphics/Bitmap;
    //   1633: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1634	0	this	VasExtensionDownloader
    //   0	1634	1	paramFile	File
    //   0	1634	2	paramDownloadParams	DownloadParams
    //   0	1634	3	paramURLDrawableHandler	URLDrawableHandler
    //   122	953	4	i	int
    //   937	138	5	j	int
    //   687	666	6	localObject1	Object
    //   869	482	7	localObject2	Object
    //   1277	26	8	localRectF	RectF
    // Exception table:
    //   from	to	target	type
    //   115	136	138	java/lang/NumberFormatException
    //   115	136	167	android/content/res/Resources$NotFoundException
    //   115	136	196	java/lang/OutOfMemoryError
    //   342	351	387	java/lang/OutOfMemoryError
    //   235	282	418	java/io/FileNotFoundException
    //   282	299	418	java/io/FileNotFoundException
    //   299	331	418	java/io/FileNotFoundException
    //   331	336	418	java/io/FileNotFoundException
    //   342	351	418	java/io/FileNotFoundException
    //   359	385	418	java/io/FileNotFoundException
    //   388	415	418	java/io/FileNotFoundException
    //   235	282	431	java/io/IOException
    //   282	299	431	java/io/IOException
    //   299	331	431	java/io/IOException
    //   331	336	431	java/io/IOException
    //   342	351	431	java/io/IOException
    //   359	385	431	java/io/IOException
    //   388	415	431	java/io/IOException
    //   235	282	445	java/lang/Exception
    //   282	299	445	java/lang/Exception
    //   299	331	445	java/lang/Exception
    //   331	336	445	java/lang/Exception
    //   342	351	445	java/lang/Exception
    //   359	385	445	java/lang/Exception
    //   388	415	445	java/lang/Exception
    //   542	546	548	java/lang/Exception
    //   530	542	580	java/lang/Exception
    //   689	729	747	java/lang/Exception
    //   729	745	747	java/lang/Exception
    //   780	812	747	java/lang/Exception
    //   812	892	747	java/lang/Exception
    //   896	925	747	java/lang/Exception
    //   927	969	747	java/lang/Exception
    //   976	1002	747	java/lang/Exception
    //   1002	1017	747	java/lang/Exception
    //   1021	1050	747	java/lang/Exception
    //   1052	1078	747	java/lang/Exception
    //   1201	1357	1359	java/lang/Exception
    //   1185	1197	1372	java/lang/Exception
    //   1197	1201	1404	java/lang/Exception
    //   1518	1530	1550	java/lang/Exception
    //   1530	1534	1582	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VasExtensionDownloader
 * JD-Core Version:    0.7.0.1
 */