package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.HttpDownloaderParams;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemCover
  extends AbsStructMsgElement
{
  public static int aA = 2;
  public static int aB = 3;
  public static int az = 1;
  public int aC = aB;
  private URLDrawableDownListener.Adapter aD = new StructMsgItemCover.1(this);
  public boolean au = false;
  public String av;
  public String aw;
  public int ax;
  public int ay;
  
  public StructMsgItemCover()
  {
    this.b = "picture";
    this.a = 19;
  }
  
  public StructMsgItemCover(String paramString)
  {
    this();
    this.av = paramString;
  }
  
  public StructMsgItemCover(String paramString1, String paramString2)
  {
    this();
    this.av = paramString1;
    this.aw = paramString2;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    try
    {
      int i = paramDrawable.getIntrinsicWidth();
      if (paramDrawable.getOpacity() != -1) {
        localObject = Bitmap.Config.ARGB_8888;
      } else {
        localObject = Bitmap.Config.RGB_565;
      }
      Object localObject = Bitmap.createBitmap(i, i, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, i);
      paramDrawable.draw(localCanvas);
      paramDrawable = ImageUtil.a((Bitmap)localObject, i, i, i);
      ((Bitmap)localObject).recycle();
      return paramDrawable;
    }
    catch (Exception paramDrawable)
    {
      return null;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      label68:
      break label68;
    }
    QLog.e("StructMsgItemCover", 2, "getRoundedCornerBitmap  OutOfMemoryError");
    return null;
  }
  
  private URLDrawable a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    try
    {
      Object localObject1 = new URL(paramString);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt1;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt2;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = paramDrawable1;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = paramDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = paramBoolean1;
      ((URLDrawable.URLDrawableOptions)localObject2).mGifRoundCorner = 0.0F;
      ((URLDrawable.URLDrawableOptions)localObject2).mNeedCheckNetType = paramBoolean2;
      ((URLDrawable.URLDrawableOptions)localObject2).mRetryCount = 3;
      ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = paramObject;
      paramString = new HttpDownloaderParams();
      paramString.businessType = 1001;
      if (this.as != null)
      {
        paramString.param1 = this.as.mMsgServiceID;
        paramString.param2 = this.as.mMsgTemplateID;
        if (this.as.message != null) {
          paramString.param3 = String.valueOf(this.as.message.istroop);
        }
      }
      ((URLDrawable.URLDrawableOptions)localObject2).mHttpDownloaderParams = paramString;
      localObject2 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      if ("url.cn".equals(((URL)localObject1).getHost()))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramDrawable1;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = paramDrawable2;
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = paramBoolean1;
        ((URLDrawable.URLDrawableOptions)localObject1).mGifRoundCorner = 0.0F;
        ((URLDrawable.URLDrawableOptions)localObject1).mNeedCheckNetType = paramBoolean2;
        ((URLDrawable.URLDrawableOptions)localObject1).mRetryCount = 3;
        ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = paramObject;
        ((URLDrawable.URLDrawableOptions)localObject1).mHttpDownloaderParams = paramString;
        ((URLDrawable)localObject2).setTag(localObject1);
      }
      return localObject2;
    }
    catch (MalformedURLException paramDrawable1)
    {
      label253:
      break label253;
    }
    paramDrawable1 = new StringBuilder();
    paramDrawable1.append("illegal url format: ");
    paramDrawable1.append(paramString);
    throw new IllegalArgumentException(paramDrawable1.toString());
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return a(paramContext, paramView, false, paramBundle);
  }
  
  /* Error */
  public View a(Context paramContext, View paramView, boolean paramBoolean, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_3
    //   2: putfield 29	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:au	Z
    //   5: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +41 -> 49
    //   11: new 225	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   18: astore 11
    //   20: aload 11
    //   22: ldc 250
    //   24: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 11
    //   30: aload_0
    //   31: getfield 52	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:av	Ljava/lang/String;
    //   34: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: ldc 252
    //   40: iconst_2
    //   41: aload 11
    //   43: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload 4
    //   51: ifnull +16 -> 67
    //   54: aload 4
    //   56: ldc_w 257
    //   59: invokevirtual 263	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   62: istore 9
    //   64: goto +6 -> 70
    //   67: iconst_0
    //   68: istore 9
    //   70: aload 4
    //   72: ifnull +16 -> 88
    //   75: aload 4
    //   77: ldc_w 265
    //   80: invokevirtual 263	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   83: istore 8
    //   85: goto +6 -> 91
    //   88: iconst_0
    //   89: istore 8
    //   91: aload_1
    //   92: invokevirtual 271	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   95: astore 14
    //   97: aload 14
    //   99: invokevirtual 277	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   102: getfield 282	android/util/DisplayMetrics:widthPixels	I
    //   105: istore 5
    //   107: invokestatic 287	com/tencent/mobileqq/structmsg/view/ViewCache:a	()Lcom/tencent/mobileqq/structmsg/view/ViewCache;
    //   110: aload 14
    //   112: ldc_w 288
    //   115: invokevirtual 291	com/tencent/mobileqq/structmsg/view/ViewCache:a	(Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;
    //   118: astore 11
    //   120: goto +6 -> 126
    //   123: aconst_null
    //   124: astore 11
    //   126: aload_2
    //   127: ifnull +19 -> 146
    //   130: aload_2
    //   131: instanceof 293
    //   134: ifeq +12 -> 146
    //   137: aload_2
    //   138: checkcast 295	com/tencent/mobileqq/widget/PAHighLightImageView
    //   141: astore 12
    //   143: goto +34 -> 177
    //   146: new 297	com/tencent/mobileqq/widget/FixRatioPAHighLightImageView
    //   149: dup
    //   150: aload_1
    //   151: invokespecial 300	com/tencent/mobileqq/widget/FixRatioPAHighLightImageView:<init>	(Landroid/content/Context;)V
    //   154: astore_2
    //   155: aload_2
    //   156: ldc_w 301
    //   159: invokevirtual 305	com/tencent/mobileqq/widget/PAHighLightImageView:setId	(I)V
    //   162: aload_2
    //   163: aload 14
    //   165: ldc_w 306
    //   168: invokevirtual 309	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   171: invokevirtual 313	com/tencent/mobileqq/widget/PAHighLightImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   174: aload_2
    //   175: astore 12
    //   177: aload 12
    //   179: aload_0
    //   180: invokevirtual 314	com/tencent/mobileqq/widget/PAHighLightImageView:setTag	(Ljava/lang/Object;)V
    //   183: aload_0
    //   184: getfield 52	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:av	Ljava/lang/String;
    //   187: astore 13
    //   189: aload 13
    //   191: invokestatic 320	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: istore 10
    //   196: iload 10
    //   198: ifeq +142 -> 340
    //   201: aload 4
    //   203: ifnull +137 -> 340
    //   206: aload 4
    //   208: ldc_w 322
    //   211: invokevirtual 325	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   214: ifeq +126 -> 340
    //   217: aload 4
    //   219: ldc_w 327
    //   222: iconst_0
    //   223: invokevirtual 331	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   226: sipush 128
    //   229: if_icmpne +111 -> 340
    //   232: aload 4
    //   234: ldc_w 322
    //   237: invokevirtual 334	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   240: astore 4
    //   242: aload 4
    //   244: invokestatic 320	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifne +93 -> 340
    //   250: aload_1
    //   251: instanceof 336
    //   254: ifeq +86 -> 340
    //   257: new 338	org/json/JSONObject
    //   260: dup
    //   261: aload 4
    //   263: invokespecial 339	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   266: astore 4
    //   268: aload 12
    //   270: aload_1
    //   271: checkcast 336	com/tencent/mobileqq/app/BaseActivity
    //   274: getfield 343	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   277: iconst_4
    //   278: aload 4
    //   280: ldc_w 345
    //   283: invokevirtual 348	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   286: invokestatic 354	com/tencent/mobileqq/app/face/FaceDrawable:getFaceDrawable	(Lcom/tencent/common/app/AppInterface;ILjava/lang/String;)Lcom/tencent/mobileqq/app/face/FaceDrawable;
    //   289: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   292: aload 12
    //   294: aconst_null
    //   295: invokevirtual 361	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   298: aload_2
    //   299: areturn
    //   300: astore_1
    //   301: new 225	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   308: astore 4
    //   310: aload 4
    //   312: ldc_w 363
    //   315: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 4
    //   321: aload_1
    //   322: invokevirtual 366	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   325: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: ldc 107
    //   331: iconst_1
    //   332: aload 4
    //   334: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload 13
    //   342: invokestatic 320	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   345: ifeq +90 -> 435
    //   348: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq +36 -> 387
    //   354: new 225	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   361: astore_1
    //   362: aload_1
    //   363: ldc_w 368
    //   366: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_1
    //   371: aload 13
    //   373: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: ldc 252
    //   379: iconst_2
    //   380: aload_1
    //   381: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: aload 12
    //   389: aload 11
    //   391: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   394: aload 12
    //   396: getstatic 374	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   399: invokevirtual 378	com/tencent/mobileqq/widget/PAHighLightImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   402: iload 8
    //   404: ifeq +17 -> 421
    //   407: aload 12
    //   409: ldc_w 380
    //   412: invokestatic 386	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   415: invokevirtual 389	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundColor	(I)V
    //   418: goto +14 -> 432
    //   421: aload 12
    //   423: ldc_w 391
    //   426: invokestatic 386	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   429: invokevirtual 389	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundColor	(I)V
    //   432: goto +1691 -> 2123
    //   435: aload 13
    //   437: ldc_w 393
    //   440: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   443: istore 10
    //   445: iload 10
    //   447: ifne +1745 -> 2192
    //   450: aload 13
    //   452: ldc_w 398
    //   455: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   458: ifne +1734 -> 2192
    //   461: aload 13
    //   463: ldc_w 400
    //   466: iconst_0
    //   467: bipush 73
    //   469: invokevirtual 404	java/lang/String:substring	(II)Ljava/lang/String;
    //   472: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   475: istore 10
    //   477: iload 10
    //   479: ifne +589 -> 1068
    //   482: aload 13
    //   484: ldc_w 406
    //   487: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   490: ifeq +385 -> 875
    //   493: aload 13
    //   495: ldc_w 408
    //   498: invokevirtual 411	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   501: istore 5
    //   503: iload 5
    //   505: iconst_m1
    //   506: if_icmpne +28 -> 534
    //   509: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +12 -> 524
    //   515: ldc 107
    //   517: iconst_2
    //   518: ldc_w 413
    //   521: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: aload 12
    //   526: invokestatic 417	com/tencent/mobileqq/utils/ImageUtil:m	()Landroid/graphics/drawable/Drawable;
    //   529: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   532: aload_2
    //   533: areturn
    //   534: aload 13
    //   536: iload 5
    //   538: iconst_5
    //   539: iadd
    //   540: invokevirtual 419	java/lang/String:substring	(I)Ljava/lang/String;
    //   543: astore_1
    //   544: aload_1
    //   545: ldc_w 421
    //   548: invokevirtual 411	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   551: istore 5
    //   553: aload_1
    //   554: astore 4
    //   556: iload 5
    //   558: iconst_m1
    //   559: if_icmpeq +12 -> 571
    //   562: aload_1
    //   563: iconst_0
    //   564: iload 5
    //   566: invokevirtual 404	java/lang/String:substring	(II)Ljava/lang/String;
    //   569: astore 4
    //   571: aload_2
    //   572: ifnull +293 -> 865
    //   575: aload_2
    //   576: invokevirtual 427	android/view/View:getContext	()Landroid/content/Context;
    //   579: astore 14
    //   581: aload 14
    //   583: instanceof 336
    //   586: ifeq +279 -> 865
    //   589: aload 12
    //   591: ldc_w 429
    //   594: putfield 432	com/tencent/mobileqq/widget/PAHighLightImageView:G	Ljava/lang/String;
    //   597: aload 14
    //   599: checkcast 336	com/tencent/mobileqq/app/BaseActivity
    //   602: getfield 343	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   605: astore 15
    //   607: invokestatic 417	com/tencent/mobileqq/utils/ImageUtil:m	()Landroid/graphics/drawable/Drawable;
    //   610: astore_1
    //   611: aload 13
    //   613: ldc_w 434
    //   616: invokevirtual 437	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   619: iconst_m1
    //   620: if_icmple +225 -> 845
    //   623: aload 13
    //   625: ldc_w 439
    //   628: invokevirtual 437	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   631: istore 5
    //   633: iload 5
    //   635: iconst_m1
    //   636: if_icmpeq +1543 -> 2179
    //   639: aload 13
    //   641: ldc_w 421
    //   644: iload 5
    //   646: iconst_1
    //   647: iadd
    //   648: invokevirtual 441	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   651: istore 6
    //   653: iload 6
    //   655: iconst_m1
    //   656: if_icmpne +17 -> 673
    //   659: aload 13
    //   661: iload 5
    //   663: bipush 10
    //   665: iadd
    //   666: invokevirtual 419	java/lang/String:substring	(I)Ljava/lang/String;
    //   669: astore_1
    //   670: goto +19 -> 689
    //   673: aload 13
    //   675: iload 5
    //   677: bipush 10
    //   679: iadd
    //   680: iload 6
    //   682: invokevirtual 404	java/lang/String:substring	(II)Ljava/lang/String;
    //   685: astore_1
    //   686: goto +3 -> 689
    //   689: aload_1
    //   690: invokestatic 446	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   693: astore_1
    //   694: aload_1
    //   695: invokevirtual 449	java/lang/String:trim	()Ljava/lang/String;
    //   698: invokestatic 320	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   701: ifne +111 -> 812
    //   704: iload 9
    //   706: ifeq +42 -> 748
    //   709: aload_1
    //   710: invokestatic 453	com/tencent/mobileqq/utils/ContactUtils:a	(Ljava/lang/String;)Z
    //   713: ifeq +19 -> 732
    //   716: aload 14
    //   718: invokevirtual 271	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   721: ldc_w 454
    //   724: invokevirtual 458	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   727: istore 5
    //   729: goto +55 -> 784
    //   732: aload 14
    //   734: invokevirtual 271	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   737: ldc_w 459
    //   740: invokevirtual 458	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   743: istore 5
    //   745: goto +39 -> 784
    //   748: aload_1
    //   749: invokestatic 453	com/tencent/mobileqq/utils/ContactUtils:a	(Ljava/lang/String;)Z
    //   752: ifeq +19 -> 771
    //   755: aload 14
    //   757: invokevirtual 271	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   760: ldc_w 460
    //   763: invokevirtual 458	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   766: istore 5
    //   768: goto +16 -> 784
    //   771: aload 14
    //   773: invokevirtual 271	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   776: ldc_w 461
    //   779: invokevirtual 458	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   782: istore 5
    //   784: aload 12
    //   786: iload 5
    //   788: invokevirtual 464	com/tencent/mobileqq/widget/PAHighLightImageView:setTextSize	(I)V
    //   791: aload 12
    //   793: aload_1
    //   794: putfield 432	com/tencent/mobileqq/widget/PAHighLightImageView:G	Ljava/lang/String;
    //   797: aload 14
    //   799: invokevirtual 271	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   802: ldc_w 465
    //   805: invokevirtual 468	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   808: astore_1
    //   809: goto +48 -> 857
    //   812: aload 4
    //   814: ldc_w 470
    //   817: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   820: ifeq +15 -> 835
    //   823: aload 15
    //   825: aload 4
    //   827: iconst_3
    //   828: invokestatic 474	com/tencent/mobileqq/app/face/FaceDrawable:getMobileFaceDrawable	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;B)Lcom/tencent/mobileqq/app/face/FaceDrawable;
    //   831: astore_1
    //   832: goto +25 -> 857
    //   835: bipush 11
    //   837: iconst_3
    //   838: invokestatic 478	com/tencent/mobileqq/app/face/FaceDrawable:getDefaultDrawable	(II)Landroid/graphics/drawable/Drawable;
    //   841: astore_1
    //   842: goto +15 -> 857
    //   845: aload 15
    //   847: iconst_1
    //   848: aload 4
    //   850: iconst_3
    //   851: aload_1
    //   852: aload_1
    //   853: invokestatic 481	com/tencent/mobileqq/app/face/FaceDrawable:getFaceDrawable	(Lcom/tencent/common/app/AppInterface;ILjava/lang/String;ILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/mobileqq/app/face/FaceDrawable;
    //   856: astore_1
    //   857: aload 12
    //   859: aload_1
    //   860: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   863: aload_2
    //   864: areturn
    //   865: aload 12
    //   867: invokestatic 417	com/tencent/mobileqq/utils/ImageUtil:m	()Landroid/graphics/drawable/Drawable;
    //   870: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   873: aload_2
    //   874: areturn
    //   875: aload 13
    //   877: ldc_w 483
    //   880: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   883: ifeq +13 -> 896
    //   886: aload 12
    //   888: ldc_w 484
    //   891: invokevirtual 487	com/tencent/mobileqq/widget/PAHighLightImageView:setImageResource	(I)V
    //   894: aload_2
    //   895: areturn
    //   896: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   899: ifeq +12 -> 911
    //   902: ldc 252
    //   904: iconst_2
    //   905: ldc_w 489
    //   908: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   911: new 491	java/io/File
    //   914: dup
    //   915: aload 13
    //   917: invokespecial 492	java/io/File:<init>	(Ljava/lang/String;)V
    //   920: invokevirtual 496	java/io/File:toURL	()Ljava/net/URL;
    //   923: invokevirtual 497	java/net/URL:toString	()Ljava/lang/String;
    //   926: astore_1
    //   927: aload_0
    //   928: getfield 33	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aC	I
    //   931: getstatic 499	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:az	I
    //   934: if_icmpne +20 -> 954
    //   937: ldc_w 500
    //   940: aload 14
    //   942: invokestatic 505	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   945: istore 6
    //   947: iload 6
    //   949: istore 5
    //   951: goto +1235 -> 2186
    //   954: aload_0
    //   955: getfield 33	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aC	I
    //   958: getstatic 507	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aA	I
    //   961: if_icmpne +20 -> 981
    //   964: ldc_w 508
    //   967: aload 14
    //   969: invokestatic 505	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   972: istore 6
    //   974: iload 6
    //   976: istore 5
    //   978: goto +1208 -> 2186
    //   981: aload_1
    //   982: iload 5
    //   984: iload 5
    //   986: aload 11
    //   988: aload 11
    //   990: iconst_1
    //   991: invokestatic 511	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Z)Lcom/tencent/image/URLDrawable;
    //   994: astore_1
    //   995: goto +1194 -> 2189
    //   998: astore_1
    //   999: goto +11 -> 1010
    //   1002: astore_1
    //   1003: goto +7 -> 1010
    //   1006: astore_1
    //   1007: iconst_0
    //   1008: istore 5
    //   1010: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1013: ifeq +42 -> 1055
    //   1016: new 225	java/lang/StringBuilder
    //   1019: dup
    //   1020: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   1023: astore 4
    //   1025: aload 4
    //   1027: ldc_w 513
    //   1030: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: pop
    //   1034: aload 4
    //   1036: aload_1
    //   1037: invokevirtual 514	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   1040: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: pop
    //   1044: ldc 107
    //   1046: iconst_2
    //   1047: aload 4
    //   1049: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1052: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1055: aload 12
    //   1057: invokestatic 417	com/tencent/mobileqq/utils/ImageUtil:m	()Landroid/graphics/drawable/Drawable;
    //   1060: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1063: aconst_null
    //   1064: astore_1
    //   1065: goto +1124 -> 2189
    //   1068: aload 13
    //   1070: ldc_w 516
    //   1073: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1076: ifeq +94 -> 1170
    //   1079: aload 13
    //   1081: aload 13
    //   1083: ldc_w 518
    //   1086: invokevirtual 411	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1089: iconst_3
    //   1090: iadd
    //   1091: invokevirtual 419	java/lang/String:substring	(I)Ljava/lang/String;
    //   1094: ldc_w 520
    //   1097: invokevirtual 524	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1100: iconst_0
    //   1101: aaload
    //   1102: astore_1
    //   1103: aload_1
    //   1104: invokestatic 320	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1107: ifne +517 -> 1624
    //   1110: aload_2
    //   1111: invokevirtual 427	android/view/View:getContext	()Landroid/content/Context;
    //   1114: astore 4
    //   1116: aload 4
    //   1118: instanceof 336
    //   1121: ifeq +39 -> 1160
    //   1124: aload 4
    //   1126: checkcast 336	com/tencent/mobileqq/app/BaseActivity
    //   1129: getfield 343	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1132: astore 4
    //   1134: iconst_4
    //   1135: iconst_3
    //   1136: invokestatic 478	com/tencent/mobileqq/app/face/FaceDrawable:getDefaultDrawable	(II)Landroid/graphics/drawable/Drawable;
    //   1139: astore 13
    //   1141: aload 12
    //   1143: aload 4
    //   1145: iconst_4
    //   1146: aload_1
    //   1147: iconst_3
    //   1148: aload 13
    //   1150: aload 13
    //   1152: invokestatic 481	com/tencent/mobileqq/app/face/FaceDrawable:getFaceDrawable	(Lcom/tencent/common/app/AppInterface;ILjava/lang/String;ILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/mobileqq/app/face/FaceDrawable;
    //   1155: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1158: aload_2
    //   1159: areturn
    //   1160: aload 12
    //   1162: invokestatic 417	com/tencent/mobileqq/utils/ImageUtil:m	()Landroid/graphics/drawable/Drawable;
    //   1165: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1168: aload_2
    //   1169: areturn
    //   1170: aload 13
    //   1172: getstatic 527	com/tencent/biz/troopbar/ShareActionSheet:b	Ljava/lang/String;
    //   1175: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1178: ifne +797 -> 1975
    //   1181: aload 13
    //   1183: getstatic 530	com/tencent/biz/troopbar/ShareActionSheet:c	Ljava/lang/String;
    //   1186: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1189: istore 9
    //   1191: iload 9
    //   1193: ifne +782 -> 1975
    //   1196: aload 13
    //   1198: getstatic 532	com/tencent/biz/troopbar/ShareActionSheet:d	Ljava/lang/String;
    //   1201: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1204: ifeq +6 -> 1210
    //   1207: goto +768 -> 1975
    //   1210: aload 13
    //   1212: ldc_w 400
    //   1215: iconst_0
    //   1216: bipush 73
    //   1218: invokevirtual 404	java/lang/String:substring	(II)Ljava/lang/String;
    //   1221: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1224: istore 9
    //   1226: iload 9
    //   1228: ifeq +26 -> 1254
    //   1231: new 534	android/graphics/drawable/ColorDrawable
    //   1234: dup
    //   1235: iconst_0
    //   1236: invokespecial 536	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   1239: astore_1
    //   1240: aload 12
    //   1242: aload 13
    //   1244: aload_1
    //   1245: aload_1
    //   1246: invokestatic 539	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/image/URLDrawable;
    //   1249: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1252: aload_2
    //   1253: areturn
    //   1254: aload 13
    //   1256: ldc_w 541
    //   1259: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1262: istore 9
    //   1264: iload 9
    //   1266: ifne +367 -> 1633
    //   1269: aload 13
    //   1271: getstatic 544	com/tencent/biz/subscribe/widget/SubscribeShareHelper:b	Ljava/lang/String;
    //   1274: invokevirtual 547	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1277: ifeq +6 -> 1283
    //   1280: goto +353 -> 1633
    //   1283: aload_0
    //   1284: getfield 55	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aw	Ljava/lang/String;
    //   1287: ifnull +24 -> 1311
    //   1290: aload_0
    //   1291: getfield 55	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aw	Ljava/lang/String;
    //   1294: ldc_w 549
    //   1297: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1300: ifeq +11 -> 1311
    //   1303: aload_0
    //   1304: iconst_1
    //   1305: putfield 29	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:au	Z
    //   1308: goto +887 -> 2195
    //   1311: aload 13
    //   1313: ldc_w 551
    //   1316: invokevirtual 396	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1319: istore 9
    //   1321: iload 9
    //   1323: ifeq +253 -> 1576
    //   1326: aload 13
    //   1328: astore 4
    //   1330: new 120	java/net/URL
    //   1333: dup
    //   1334: aload 13
    //   1336: invokespecial 122	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1339: invokevirtual 554	java/net/URL:getQuery	()Ljava/lang/String;
    //   1342: ifnull +49 -> 1391
    //   1345: ldc_w 556
    //   1348: astore_1
    //   1349: aload 13
    //   1351: astore 4
    //   1353: aload_0
    //   1354: getfield 33	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aC	I
    //   1357: getstatic 499	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:az	I
    //   1360: if_icmpne +10 -> 1370
    //   1363: ldc_w 558
    //   1366: astore_1
    //   1367: goto +67 -> 1434
    //   1370: aload 13
    //   1372: astore 4
    //   1374: aload_0
    //   1375: getfield 33	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aC	I
    //   1378: getstatic 507	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aA	I
    //   1381: if_icmpne +53 -> 1434
    //   1384: ldc_w 560
    //   1387: astore_1
    //   1388: goto +46 -> 1434
    //   1391: ldc_w 562
    //   1394: astore_1
    //   1395: aload 13
    //   1397: astore 4
    //   1399: aload_0
    //   1400: getfield 33	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aC	I
    //   1403: getstatic 499	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:az	I
    //   1406: if_icmpne +10 -> 1416
    //   1409: ldc_w 564
    //   1412: astore_1
    //   1413: goto +21 -> 1434
    //   1416: aload 13
    //   1418: astore 4
    //   1420: aload_0
    //   1421: getfield 33	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aC	I
    //   1424: getstatic 507	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aA	I
    //   1427: if_icmpne +7 -> 1434
    //   1430: ldc_w 566
    //   1433: astore_1
    //   1434: aload 13
    //   1436: astore 4
    //   1438: new 193	java/lang/String
    //   1441: dup
    //   1442: aload 13
    //   1444: invokespecial 567	java/lang/String:<init>	(Ljava/lang/String;)V
    //   1447: pop
    //   1448: aload 13
    //   1450: astore 4
    //   1452: new 225	java/lang/StringBuilder
    //   1455: dup
    //   1456: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   1459: astore 15
    //   1461: aload 13
    //   1463: astore 4
    //   1465: aload 15
    //   1467: aload 13
    //   1469: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: pop
    //   1473: aload 13
    //   1475: astore 4
    //   1477: aload 15
    //   1479: aload_1
    //   1480: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: pop
    //   1484: aload 13
    //   1486: astore 4
    //   1488: aload 15
    //   1490: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1493: astore_1
    //   1494: aload_1
    //   1495: astore 4
    //   1497: aload_0
    //   1498: getfield 168	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1501: ifnull +35 -> 1536
    //   1504: aload_1
    //   1505: astore 4
    //   1507: aload_0
    //   1508: getfield 168	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1511: getfield 186	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1514: ifnull +22 -> 1536
    //   1517: aload_1
    //   1518: astore 4
    //   1520: aload_0
    //   1521: getfield 168	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1524: getfield 186	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1527: astore 13
    //   1529: aload 13
    //   1531: astore 4
    //   1533: goto +6 -> 1539
    //   1536: aconst_null
    //   1537: astore 4
    //   1539: goto +102 -> 1641
    //   1542: new 225	java/lang/StringBuilder
    //   1545: dup
    //   1546: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   1549: astore_1
    //   1550: aload_1
    //   1551: ldc 228
    //   1553: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: pop
    //   1557: aload_1
    //   1558: aload 4
    //   1560: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: pop
    //   1564: new 234	java/lang/IllegalArgumentException
    //   1567: dup
    //   1568: aload_1
    //   1569: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1572: invokespecial 238	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1575: athrow
    //   1576: aload_0
    //   1577: getfield 168	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1580: ifnull +44 -> 1624
    //   1583: aload_0
    //   1584: getfield 168	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1587: getfield 186	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1590: ifnull +34 -> 1624
    //   1593: aload_0
    //   1594: getfield 168	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1597: getfield 186	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1600: getfield 191	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1603: sipush 1008
    //   1606: if_icmpne +18 -> 1624
    //   1609: aload_0
    //   1610: getfield 168	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:as	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1613: getfield 186	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1616: astore 4
    //   1618: aload 13
    //   1620: astore_1
    //   1621: goto +20 -> 1641
    //   1624: aload 13
    //   1626: astore_1
    //   1627: aconst_null
    //   1628: astore 4
    //   1630: goto +11 -> 1641
    //   1633: aload_0
    //   1634: iconst_1
    //   1635: putfield 29	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:au	Z
    //   1638: goto +557 -> 2195
    //   1641: aload_0
    //   1642: getfield 33	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aC	I
    //   1645: istore 6
    //   1647: getstatic 499	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:az	I
    //   1650: istore 7
    //   1652: iload 6
    //   1654: iload 7
    //   1656: if_icmpne +24 -> 1680
    //   1659: aload 12
    //   1661: getstatic 374	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   1664: invokevirtual 378	com/tencent/mobileqq/widget/PAHighLightImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1667: ldc_w 500
    //   1670: aload 14
    //   1672: invokestatic 505	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   1675: istore 5
    //   1677: goto +50 -> 1727
    //   1680: aload_0
    //   1681: getfield 33	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aC	I
    //   1684: istore 6
    //   1686: getstatic 507	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aA	I
    //   1689: istore 7
    //   1691: iload 6
    //   1693: iload 7
    //   1695: if_icmpne +24 -> 1719
    //   1698: aload 12
    //   1700: getstatic 570	android/widget/ImageView$ScaleType:CENTER	Landroid/widget/ImageView$ScaleType;
    //   1703: invokevirtual 378	com/tencent/mobileqq/widget/PAHighLightImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1706: ldc_w 508
    //   1709: aload 14
    //   1711: invokestatic 505	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   1714: istore 5
    //   1716: goto -39 -> 1677
    //   1719: aload 12
    //   1721: getstatic 570	android/widget/ImageView$ScaleType:CENTER	Landroid/widget/ImageView$ScaleType;
    //   1724: invokevirtual 378	com/tencent/mobileqq/widget/PAHighLightImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1727: iload 8
    //   1729: ifeq +17 -> 1746
    //   1732: aload 12
    //   1734: ldc_w 380
    //   1737: invokestatic 386	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1740: invokevirtual 389	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundColor	(I)V
    //   1743: goto +14 -> 1757
    //   1746: aload 12
    //   1748: ldc_w 391
    //   1751: invokestatic 386	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1754: invokevirtual 389	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundColor	(I)V
    //   1757: aload_0
    //   1758: aload_1
    //   1759: iload 5
    //   1761: iload 5
    //   1763: aload 11
    //   1765: aload 11
    //   1767: iconst_1
    //   1768: iconst_1
    //   1769: aload 4
    //   1771: invokespecial 572	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:a	(Ljava/lang/String;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;ZZLjava/lang/Object;)Lcom/tencent/image/URLDrawable;
    //   1774: astore_1
    //   1775: aload_1
    //   1776: invokevirtual 576	com/tencent/image/URLDrawable:getTag	()Ljava/lang/Object;
    //   1779: ifnonnull +11 -> 1790
    //   1782: aload_1
    //   1783: iconst_0
    //   1784: invokestatic 581	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1787: invokevirtual 223	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   1790: aload_1
    //   1791: iconst_1
    //   1792: invokevirtual 585	com/tencent/image/URLDrawable:setAutoDownload	(Z)V
    //   1795: aload_1
    //   1796: invokevirtual 588	com/tencent/image/URLDrawable:getStatus	()I
    //   1799: iconst_2
    //   1800: if_icmpne +400 -> 2200
    //   1803: aload_1
    //   1804: invokevirtual 591	com/tencent/image/URLDrawable:restartDownload	()V
    //   1807: goto +393 -> 2200
    //   1810: aload 12
    //   1812: astore 4
    //   1814: aload_1
    //   1815: ifnull +37 -> 1852
    //   1818: aload_1
    //   1819: invokevirtual 588	com/tencent/image/URLDrawable:getStatus	()I
    //   1822: iconst_1
    //   1823: if_icmpne +29 -> 1852
    //   1826: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1829: ifeq +12 -> 1841
    //   1832: ldc 252
    //   1834: iconst_2
    //   1835: ldc_w 593
    //   1838: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1841: aload 4
    //   1843: getstatic 374	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   1846: invokevirtual 378	com/tencent/mobileqq/widget/PAHighLightImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1849: goto +27 -> 1876
    //   1852: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1855: ifeq +12 -> 1867
    //   1858: ldc 252
    //   1860: iconst_2
    //   1861: ldc_w 595
    //   1864: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1867: aload 4
    //   1869: aload_0
    //   1870: getfield 40	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:aD	Lcom/tencent/image/URLDrawableDownListener$Adapter;
    //   1873: invokevirtual 599	com/tencent/mobileqq/widget/PAHighLightImageView:setURLDrawableDownListener	(Lcom/tencent/image/URLDrawableDownListener;)V
    //   1876: iload_3
    //   1877: ifeq +9 -> 1886
    //   1880: aload 4
    //   1882: aconst_null
    //   1883: invokevirtual 361	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1886: aload_1
    //   1887: ifnull +63 -> 1950
    //   1890: iload_3
    //   1891: ifeq +59 -> 1950
    //   1894: iload 5
    //   1896: istore 6
    //   1898: iload 5
    //   1900: ifne +9 -> 1909
    //   1903: aload_1
    //   1904: invokevirtual 600	com/tencent/image/URLDrawable:getIntrinsicWidth	()I
    //   1907: istore 6
    //   1909: aload_1
    //   1910: iload 6
    //   1912: iload 6
    //   1914: iload 6
    //   1916: invokestatic 605	com/tencent/mobileqq/urldrawable/URLDrawableDecodeHandler:b	(III)[I
    //   1919: invokevirtual 223	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   1922: aload_1
    //   1923: getstatic 609	com/tencent/mobileqq/urldrawable/URLDrawableDecodeHandler:j	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   1926: invokevirtual 613	com/tencent/image/URLDrawable:setDecodeHandler	(Lcom/tencent/image/DownloadParams$DecodeHandler;)V
    //   1929: aload 4
    //   1931: aload_1
    //   1932: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1935: aload_1
    //   1936: invokevirtual 588	com/tencent/image/URLDrawable:getStatus	()I
    //   1939: iconst_1
    //   1940: if_icmpeq +16 -> 1956
    //   1943: aload_1
    //   1944: invokevirtual 591	com/tencent/image/URLDrawable:restartDownload	()V
    //   1947: goto +9 -> 1956
    //   1950: aload 4
    //   1952: aload_1
    //   1953: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1956: goto +167 -> 2123
    //   1959: astore_1
    //   1960: aload 11
    //   1962: astore 4
    //   1964: goto +94 -> 2058
    //   1967: astore_1
    //   1968: aload 11
    //   1970: astore 4
    //   1972: goto +86 -> 2058
    //   1975: aload 11
    //   1977: astore 4
    //   1979: aload 12
    //   1981: astore_1
    //   1982: aload_1
    //   1983: aconst_null
    //   1984: invokevirtual 361	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1987: aload 13
    //   1989: aload 13
    //   1991: ldc_w 408
    //   1994: invokevirtual 411	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1997: iconst_5
    //   1998: iadd
    //   1999: invokevirtual 419	java/lang/String:substring	(I)Ljava/lang/String;
    //   2002: astore 11
    //   2004: aload_2
    //   2005: invokevirtual 427	android/view/View:getContext	()Landroid/content/Context;
    //   2008: astore 13
    //   2010: aload 13
    //   2012: instanceof 336
    //   2015: ifeq +25 -> 2040
    //   2018: aload_1
    //   2019: aload 13
    //   2021: checkcast 336	com/tencent/mobileqq/app/BaseActivity
    //   2024: getfield 343	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2027: aload 11
    //   2029: iconst_0
    //   2030: iconst_4
    //   2031: invokevirtual 618	com/tencent/mobileqq/app/QQAppInterface:getFaceDrawable	(Ljava/lang/String;ZB)Landroid/graphics/drawable/Drawable;
    //   2034: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2037: goto +10 -> 2047
    //   2040: aload_1
    //   2041: invokestatic 417	com/tencent/mobileqq/utils/ImageUtil:m	()Landroid/graphics/drawable/Drawable;
    //   2044: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2047: aload_2
    //   2048: areturn
    //   2049: astore_1
    //   2050: goto +8 -> 2058
    //   2053: astore_1
    //   2054: aload 11
    //   2056: astore 4
    //   2058: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2061: ifeq +55 -> 2116
    //   2064: new 225	java/lang/StringBuilder
    //   2067: dup
    //   2068: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   2071: astore 11
    //   2073: aload 11
    //   2075: ldc_w 620
    //   2078: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2081: pop
    //   2082: aload 11
    //   2084: aload_1
    //   2085: invokevirtual 623	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2088: pop
    //   2089: aload 11
    //   2091: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2094: ifnull +11 -> 2105
    //   2097: aload_1
    //   2098: invokevirtual 624	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2101: astore_1
    //   2102: goto +7 -> 2109
    //   2105: ldc_w 626
    //   2108: astore_1
    //   2109: ldc 107
    //   2111: iconst_2
    //   2112: aload_1
    //   2113: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2116: aload 12
    //   2118: aload 4
    //   2120: invokevirtual 358	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2123: aload_0
    //   2124: getfield 628	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:e	Ljava/lang/String;
    //   2127: ifnull +26 -> 2153
    //   2130: aload_0
    //   2131: getfield 628	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:e	Ljava/lang/String;
    //   2134: ldc_w 429
    //   2137: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2140: ifne +13 -> 2153
    //   2143: aload_2
    //   2144: iconst_1
    //   2145: invokevirtual 631	android/view/View:setClickable	(Z)V
    //   2148: aload_2
    //   2149: aload_0
    //   2150: invokevirtual 635	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2153: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2156: ifeq +12 -> 2168
    //   2159: ldc 252
    //   2161: iconst_2
    //   2162: ldc_w 637
    //   2165: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2168: aload_2
    //   2169: areturn
    //   2170: astore 11
    //   2172: goto -2049 -> 123
    //   2175: astore_1
    //   2176: goto -634 -> 1542
    //   2179: ldc_w 429
    //   2182: astore_1
    //   2183: goto -1494 -> 689
    //   2186: goto -1205 -> 981
    //   2189: goto -379 -> 1810
    //   2192: goto -1124 -> 1068
    //   2195: iconst_1
    //   2196: istore_3
    //   2197: goto -573 -> 1624
    //   2200: goto -390 -> 1810
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2203	0	this	StructMsgItemCover
    //   0	2203	1	paramContext	Context
    //   0	2203	2	paramView	View
    //   0	2203	3	paramBoolean	boolean
    //   0	2203	4	paramBundle	Bundle
    //   105	1794	5	i	int
    //   651	1264	6	j	int
    //   1650	46	7	k	int
    //   83	1645	8	bool1	boolean
    //   62	1260	9	bool2	boolean
    //   194	284	10	bool3	boolean
    //   18	2072	11	localObject1	Object
    //   2170	1	11	localOutOfMemoryError	OutOfMemoryError
    //   141	1976	12	localObject2	Object
    //   187	1833	13	localObject3	Object
    //   95	1615	14	localObject4	Object
    //   605	884	15	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   250	298	300	java/lang/Throwable
    //   981	995	998	java/net/MalformedURLException
    //   927	947	1002	java/net/MalformedURLException
    //   954	974	1002	java/net/MalformedURLException
    //   482	503	1006	java/net/MalformedURLException
    //   509	524	1006	java/net/MalformedURLException
    //   524	532	1006	java/net/MalformedURLException
    //   534	553	1006	java/net/MalformedURLException
    //   562	571	1006	java/net/MalformedURLException
    //   575	633	1006	java/net/MalformedURLException
    //   639	653	1006	java/net/MalformedURLException
    //   659	670	1006	java/net/MalformedURLException
    //   673	686	1006	java/net/MalformedURLException
    //   689	704	1006	java/net/MalformedURLException
    //   709	729	1006	java/net/MalformedURLException
    //   732	745	1006	java/net/MalformedURLException
    //   748	768	1006	java/net/MalformedURLException
    //   771	784	1006	java/net/MalformedURLException
    //   784	809	1006	java/net/MalformedURLException
    //   812	832	1006	java/net/MalformedURLException
    //   835	842	1006	java/net/MalformedURLException
    //   845	857	1006	java/net/MalformedURLException
    //   857	863	1006	java/net/MalformedURLException
    //   865	873	1006	java/net/MalformedURLException
    //   875	894	1006	java/net/MalformedURLException
    //   896	911	1006	java/net/MalformedURLException
    //   911	927	1006	java/net/MalformedURLException
    //   1757	1790	1959	java/lang/Exception
    //   1790	1807	1959	java/lang/Exception
    //   1818	1841	1959	java/lang/Exception
    //   1841	1849	1959	java/lang/Exception
    //   1852	1867	1959	java/lang/Exception
    //   1867	1876	1959	java/lang/Exception
    //   1880	1886	1959	java/lang/Exception
    //   1903	1909	1959	java/lang/Exception
    //   1909	1947	1959	java/lang/Exception
    //   1950	1956	1959	java/lang/Exception
    //   1196	1207	1967	java/lang/Exception
    //   1210	1226	1967	java/lang/Exception
    //   1254	1264	1967	java/lang/Exception
    //   1633	1638	1967	java/lang/Exception
    //   1641	1652	1967	java/lang/Exception
    //   1680	1691	1967	java/lang/Exception
    //   1719	1727	1967	java/lang/Exception
    //   1746	1757	1967	java/lang/Exception
    //   1982	2037	2049	java/lang/Exception
    //   2040	2047	2049	java/lang/Exception
    //   435	445	2053	java/lang/Exception
    //   450	477	2053	java/lang/Exception
    //   482	503	2053	java/lang/Exception
    //   509	524	2053	java/lang/Exception
    //   524	532	2053	java/lang/Exception
    //   534	553	2053	java/lang/Exception
    //   562	571	2053	java/lang/Exception
    //   575	633	2053	java/lang/Exception
    //   639	653	2053	java/lang/Exception
    //   659	670	2053	java/lang/Exception
    //   673	686	2053	java/lang/Exception
    //   689	704	2053	java/lang/Exception
    //   709	729	2053	java/lang/Exception
    //   732	745	2053	java/lang/Exception
    //   748	768	2053	java/lang/Exception
    //   771	784	2053	java/lang/Exception
    //   784	809	2053	java/lang/Exception
    //   812	832	2053	java/lang/Exception
    //   835	842	2053	java/lang/Exception
    //   845	857	2053	java/lang/Exception
    //   857	863	2053	java/lang/Exception
    //   865	873	2053	java/lang/Exception
    //   875	894	2053	java/lang/Exception
    //   896	911	2053	java/lang/Exception
    //   911	927	2053	java/lang/Exception
    //   927	947	2053	java/lang/Exception
    //   954	974	2053	java/lang/Exception
    //   981	995	2053	java/lang/Exception
    //   1010	1055	2053	java/lang/Exception
    //   1055	1063	2053	java/lang/Exception
    //   1068	1158	2053	java/lang/Exception
    //   1160	1168	2053	java/lang/Exception
    //   1170	1191	2053	java/lang/Exception
    //   1231	1252	2053	java/lang/Exception
    //   1269	1280	2053	java/lang/Exception
    //   1283	1308	2053	java/lang/Exception
    //   1311	1321	2053	java/lang/Exception
    //   1330	1345	2053	java/lang/Exception
    //   1353	1363	2053	java/lang/Exception
    //   1374	1384	2053	java/lang/Exception
    //   1399	1409	2053	java/lang/Exception
    //   1420	1430	2053	java/lang/Exception
    //   1438	1448	2053	java/lang/Exception
    //   1452	1461	2053	java/lang/Exception
    //   1465	1473	2053	java/lang/Exception
    //   1477	1484	2053	java/lang/Exception
    //   1488	1494	2053	java/lang/Exception
    //   1497	1504	2053	java/lang/Exception
    //   1507	1517	2053	java/lang/Exception
    //   1520	1529	2053	java/lang/Exception
    //   1542	1576	2053	java/lang/Exception
    //   1576	1618	2053	java/lang/Exception
    //   1659	1677	2053	java/lang/Exception
    //   1698	1716	2053	java/lang/Exception
    //   1732	1743	2053	java/lang/Exception
    //   107	120	2170	java/lang/OutOfMemoryError
    //   1330	1345	2175	java/net/MalformedURLException
    //   1353	1363	2175	java/net/MalformedURLException
    //   1374	1384	2175	java/net/MalformedURLException
    //   1399	1409	2175	java/net/MalformedURLException
    //   1420	1430	2175	java/net/MalformedURLException
    //   1438	1448	2175	java/net/MalformedURLException
    //   1452	1461	2175	java/net/MalformedURLException
    //   1465	1473	2175	java/net/MalformedURLException
    //   1477	1484	2175	java/net/MalformedURLException
    //   1488	1494	2175	java/net/MalformedURLException
    //   1497	1504	2175	java/net/MalformedURLException
    //   1507	1517	2175	java/net/MalformedURLException
    //   1520	1529	2175	java/net/MalformedURLException
  }
  
  StructMsgForGeneralShare a(View paramView)
  {
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131446476) {
        return (StructMsgForGeneralShare)paramView.getTag(2131446476);
      }
    }
    return null;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    try
    {
      localObject1 = AIOUtils.a(paramView);
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject1;
      label12:
      Object localObject3;
      String str;
      break label12;
    }
    localObject1 = null;
    if (localObject1 == null) {
      return;
    }
    localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (this.av.endsWith("gif")))
    {
      str = "0";
      localObject1 = ((BaseActivity)paramView.getContext()).getChatFragment();
      if (localObject1 == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = ((ChatFragment)localObject1).j();
      }
    }
    label150:
    try
    {
      localObject3 = new JSONObject((String)localObject3);
      localObject2 = str;
      if (!((JSONObject)localObject3).has("ad_id")) {
        break label150;
      }
      localObject2 = ((JSONObject)localObject3).getString("ad_id");
    }
    catch (Exception localException)
    {
      label127:
      break label127;
    }
    localObject2 = str;
    if (QLog.isColorLevel())
    {
      QLog.e("StructMsgItemCover", 2, "parse ad_id error");
      localObject2 = str;
    }
    paramView = a(paramView);
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgItemCover", 2, "StructMsgForGeneralShare == NULL");
      }
      return;
    }
    ReportController.b((AppRuntime)localObject1, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, (String)localObject2, String.valueOf(paramView.msgId), "1", "");
    return;
  }
  
  public void a(AbsShareMsg paramAbsShareMsg)
  {
    paramAbsShareMsg.mContentCover = this.av;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.av = paramObjectInput.readUTF();
    if (this.a <= 3) {
      return;
    }
    this.e = paramObjectInput.readUTF();
    this.d = paramObjectInput.readUTF();
    if (this.a <= 5) {
      return;
    }
    this.l = paramObjectInput.readUTF();
    this.m = paramObjectInput.readUTF();
    this.n = paramObjectInput.readUTF();
    this.ax = paramObjectInput.readInt();
    this.ay = paramObjectInput.readInt();
    if (this.a <= 8) {
      return;
    }
    this.aw = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str2 = this.av;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    if (this.a <= 3) {
      return;
    }
    if (this.e == null) {
      str1 = "";
    } else {
      str1 = this.e;
    }
    paramObjectOutput.writeUTF(str1);
    if (this.d == null) {
      str1 = "";
    } else {
      str1 = this.d;
    }
    paramObjectOutput.writeUTF(str1);
    if (this.a <= 5) {
      return;
    }
    if (this.l == null) {
      str1 = "";
    } else {
      str1 = this.l;
    }
    paramObjectOutput.writeUTF(str1);
    if (this.m == null) {
      str1 = "";
    } else {
      str1 = this.m;
    }
    paramObjectOutput.writeUTF(str1);
    if (this.n == null) {
      str1 = "";
    } else {
      str1 = this.n;
    }
    paramObjectOutput.writeUTF(str1);
    paramObjectOutput.writeInt(this.ax);
    paramObjectOutput.writeInt(this.ay);
    if (this.a <= 8) {
      return;
    }
    str2 = this.aw;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "picture");
    String str2 = this.av;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializer.attribute(null, "cover", str1);
    if (this.a > 3)
    {
      if (!TextUtils.isEmpty(this.e)) {
        paramXmlSerializer.attribute(null, "action", this.e);
      }
      if (!TextUtils.isEmpty(this.d)) {
        paramXmlSerializer.attribute(null, "url", this.d);
      }
      if (this.a > 5)
      {
        if (!TextUtils.isEmpty(this.l)) {
          paramXmlSerializer.attribute(null, "index", this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
          paramXmlSerializer.attribute(null, "index_name", this.m);
        }
        if (!TextUtils.isEmpty(this.n)) {
          paramXmlSerializer.attribute(null, "index_type", this.n);
        }
        paramXmlSerializer.attribute(null, "w", String.valueOf(this.ax));
        paramXmlSerializer.attribute(null, "h", String.valueOf(this.ay));
        if ((this.a > 8) && (!TextUtils.isEmpty(this.aw))) {
          paramXmlSerializer.attribute(null, "needRoundView", this.aw);
        }
      }
    }
    paramXmlSerializer.endTag(null, "picture");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    String str = paramStructMsgNode.a("cover");
    if (str == null) {
      str = "";
    }
    this.av = str;
    if (this.a > 3)
    {
      this.e = paramStructMsgNode.a("action");
      this.d = paramStructMsgNode.a("url");
      if (this.a > 5)
      {
        this.l = paramStructMsgNode.a("index");
        this.m = paramStructMsgNode.a("index_name");
        this.n = paramStructMsgNode.a("index_type");
      }
    }
    try
    {
      str = paramStructMsgNode.a("w");
      int i;
      if (str == null) {
        i = 0;
      } else {
        i = Integer.parseInt(str);
      }
      this.ax = i;
      str = paramStructMsgNode.a("h");
      if (str == null) {
        i = 0;
      } else {
        i = Integer.parseInt(str);
      }
      this.ay = i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label158:
      break label158;
    }
    this.ax = 0;
    this.ay = 0;
    if (this.a > 8) {
      this.aw = paramStructMsgNode.a("needRoundView");
    }
    return true;
  }
  
  public String b()
  {
    return "Cover";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemCover
 * JD-Core Version:    0.7.0.1
 */