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
  public static int q = 1;
  public static int r = 2;
  public static int s = 3;
  private URLDrawableDownListener.Adapter a;
  public boolean a;
  public String ac;
  public String ad;
  public int o;
  public int p;
  public int t = s;
  
  public StructMsgItemCover()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new StructMsgItemCover.1(this);
    this.jdField_a_of_type_JavaLangString = "picture";
    this.jdField_a_of_type_Int = 19;
  }
  
  public StructMsgItemCover(String paramString)
  {
    this();
    this.ac = paramString;
  }
  
  public StructMsgItemCover(String paramString1, String paramString2)
  {
    this();
    this.ac = paramString1;
    this.ad = paramString2;
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
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
      {
        paramString.param1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID;
        paramString.param2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgTemplateID;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) {
          paramString.param3 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.istroop);
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
    //   2: putfield 28	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:jdField_a_of_type_Boolean	Z
    //   5: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +41 -> 49
    //   11: new 221	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   18: astore 11
    //   20: aload 11
    //   22: ldc 246
    //   24: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 11
    //   30: aload_0
    //   31: getfield 49	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:ac	Ljava/lang/String;
    //   34: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: ldc 248
    //   40: iconst_2
    //   41: aload 11
    //   43: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload 4
    //   51: ifnull +15 -> 66
    //   54: aload 4
    //   56: ldc 253
    //   58: invokevirtual 259	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   61: istore 9
    //   63: goto +6 -> 69
    //   66: iconst_0
    //   67: istore 9
    //   69: aload 4
    //   71: ifnull +16 -> 87
    //   74: aload 4
    //   76: ldc_w 261
    //   79: invokevirtual 259	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   82: istore 8
    //   84: goto +6 -> 90
    //   87: iconst_0
    //   88: istore 8
    //   90: aload_1
    //   91: invokevirtual 267	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   94: astore 14
    //   96: aload 14
    //   98: invokevirtual 273	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   101: getfield 278	android/util/DisplayMetrics:widthPixels	I
    //   104: istore 5
    //   106: invokestatic 283	com/tencent/mobileqq/structmsg/view/ViewCache:a	()Lcom/tencent/mobileqq/structmsg/view/ViewCache;
    //   109: aload 14
    //   111: ldc_w 284
    //   114: invokevirtual 287	com/tencent/mobileqq/structmsg/view/ViewCache:a	(Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;
    //   117: astore 11
    //   119: goto +6 -> 125
    //   122: aconst_null
    //   123: astore 11
    //   125: aload_2
    //   126: ifnull +19 -> 145
    //   129: aload_2
    //   130: instanceof 289
    //   133: ifeq +12 -> 145
    //   136: aload_2
    //   137: checkcast 291	com/tencent/mobileqq/widget/PAHighLightImageView
    //   140: astore 12
    //   142: goto +34 -> 176
    //   145: new 293	com/tencent/mobileqq/widget/FixRatioPAHighLightImageView
    //   148: dup
    //   149: aload_1
    //   150: invokespecial 296	com/tencent/mobileqq/widget/FixRatioPAHighLightImageView:<init>	(Landroid/content/Context;)V
    //   153: astore_2
    //   154: aload_2
    //   155: ldc_w 297
    //   158: invokevirtual 301	com/tencent/mobileqq/widget/PAHighLightImageView:setId	(I)V
    //   161: aload_2
    //   162: aload 14
    //   164: ldc_w 302
    //   167: invokevirtual 305	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   170: invokevirtual 309	com/tencent/mobileqq/widget/PAHighLightImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   173: aload_2
    //   174: astore 12
    //   176: aload 12
    //   178: aload_0
    //   179: invokevirtual 310	com/tencent/mobileqq/widget/PAHighLightImageView:setTag	(Ljava/lang/Object;)V
    //   182: aload_0
    //   183: getfield 49	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:ac	Ljava/lang/String;
    //   186: astore 13
    //   188: aload 13
    //   190: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   193: istore 10
    //   195: iload 10
    //   197: ifeq +142 -> 339
    //   200: aload 4
    //   202: ifnull +137 -> 339
    //   205: aload 4
    //   207: ldc_w 318
    //   210: invokevirtual 321	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   213: ifeq +126 -> 339
    //   216: aload 4
    //   218: ldc_w 323
    //   221: iconst_0
    //   222: invokevirtual 327	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   225: sipush 128
    //   228: if_icmpne +111 -> 339
    //   231: aload 4
    //   233: ldc_w 318
    //   236: invokevirtual 330	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   239: astore 4
    //   241: aload 4
    //   243: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   246: ifne +93 -> 339
    //   249: aload_1
    //   250: instanceof 332
    //   253: ifeq +86 -> 339
    //   256: new 334	org/json/JSONObject
    //   259: dup
    //   260: aload 4
    //   262: invokespecial 335	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   265: astore 4
    //   267: aload 12
    //   269: aload_1
    //   270: checkcast 332	com/tencent/mobileqq/app/BaseActivity
    //   273: getfield 339	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   276: iconst_4
    //   277: aload 4
    //   279: ldc_w 341
    //   282: invokevirtual 344	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: invokestatic 350	com/tencent/mobileqq/app/face/FaceDrawable:getFaceDrawable	(Lcom/tencent/common/app/AppInterface;ILjava/lang/String;)Lcom/tencent/mobileqq/app/face/FaceDrawable;
    //   288: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   291: aload 12
    //   293: aconst_null
    //   294: invokevirtual 357	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   297: aload_2
    //   298: areturn
    //   299: astore_1
    //   300: new 221	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   307: astore 4
    //   309: aload 4
    //   311: ldc_w 359
    //   314: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 4
    //   320: aload_1
    //   321: invokevirtual 362	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   324: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: ldc 104
    //   330: iconst_1
    //   331: aload 4
    //   333: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: aload 13
    //   341: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   344: ifeq +90 -> 434
    //   347: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq +36 -> 386
    //   353: new 221	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   360: astore_1
    //   361: aload_1
    //   362: ldc_w 364
    //   365: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload_1
    //   370: aload 13
    //   372: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: ldc 248
    //   378: iconst_2
    //   379: aload_1
    //   380: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aload 12
    //   388: aload 11
    //   390: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   393: aload 12
    //   395: getstatic 370	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   398: invokevirtual 374	com/tencent/mobileqq/widget/PAHighLightImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   401: iload 8
    //   403: ifeq +17 -> 420
    //   406: aload 12
    //   408: ldc_w 376
    //   411: invokestatic 382	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   414: invokevirtual 385	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundColor	(I)V
    //   417: goto +14 -> 431
    //   420: aload 12
    //   422: ldc_w 387
    //   425: invokestatic 382	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   428: invokevirtual 385	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundColor	(I)V
    //   431: goto +1691 -> 2122
    //   434: aload 13
    //   436: ldc_w 389
    //   439: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   442: istore 10
    //   444: iload 10
    //   446: ifne +1745 -> 2191
    //   449: aload 13
    //   451: ldc_w 394
    //   454: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   457: ifne +1734 -> 2191
    //   460: aload 13
    //   462: ldc_w 396
    //   465: iconst_0
    //   466: bipush 73
    //   468: invokevirtual 400	java/lang/String:substring	(II)Ljava/lang/String;
    //   471: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   474: istore 10
    //   476: iload 10
    //   478: ifne +589 -> 1067
    //   481: aload 13
    //   483: ldc_w 402
    //   486: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   489: ifeq +385 -> 874
    //   492: aload 13
    //   494: ldc_w 404
    //   497: invokevirtual 407	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   500: istore 5
    //   502: iload 5
    //   504: iconst_m1
    //   505: if_icmpne +28 -> 533
    //   508: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +12 -> 523
    //   514: ldc 104
    //   516: iconst_2
    //   517: ldc_w 409
    //   520: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aload 12
    //   525: invokestatic 413	com/tencent/mobileqq/utils/ImageUtil:f	()Landroid/graphics/drawable/Drawable;
    //   528: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   531: aload_2
    //   532: areturn
    //   533: aload 13
    //   535: iload 5
    //   537: iconst_5
    //   538: iadd
    //   539: invokevirtual 415	java/lang/String:substring	(I)Ljava/lang/String;
    //   542: astore_1
    //   543: aload_1
    //   544: ldc_w 417
    //   547: invokevirtual 407	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   550: istore 5
    //   552: aload_1
    //   553: astore 4
    //   555: iload 5
    //   557: iconst_m1
    //   558: if_icmpeq +12 -> 570
    //   561: aload_1
    //   562: iconst_0
    //   563: iload 5
    //   565: invokevirtual 400	java/lang/String:substring	(II)Ljava/lang/String;
    //   568: astore 4
    //   570: aload_2
    //   571: ifnull +293 -> 864
    //   574: aload_2
    //   575: invokevirtual 423	android/view/View:getContext	()Landroid/content/Context;
    //   578: astore 14
    //   580: aload 14
    //   582: instanceof 332
    //   585: ifeq +279 -> 864
    //   588: aload 12
    //   590: ldc_w 425
    //   593: putfield 427	com/tencent/mobileqq/widget/PAHighLightImageView:e	Ljava/lang/String;
    //   596: aload 14
    //   598: checkcast 332	com/tencent/mobileqq/app/BaseActivity
    //   601: getfield 339	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   604: astore 15
    //   606: invokestatic 413	com/tencent/mobileqq/utils/ImageUtil:f	()Landroid/graphics/drawable/Drawable;
    //   609: astore_1
    //   610: aload 13
    //   612: ldc_w 429
    //   615: invokevirtual 432	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   618: iconst_m1
    //   619: if_icmple +225 -> 844
    //   622: aload 13
    //   624: ldc_w 434
    //   627: invokevirtual 432	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   630: istore 5
    //   632: iload 5
    //   634: iconst_m1
    //   635: if_icmpeq +1543 -> 2178
    //   638: aload 13
    //   640: ldc_w 417
    //   643: iload 5
    //   645: iconst_1
    //   646: iadd
    //   647: invokevirtual 436	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   650: istore 6
    //   652: iload 6
    //   654: iconst_m1
    //   655: if_icmpne +17 -> 672
    //   658: aload 13
    //   660: iload 5
    //   662: bipush 10
    //   664: iadd
    //   665: invokevirtual 415	java/lang/String:substring	(I)Ljava/lang/String;
    //   668: astore_1
    //   669: goto +19 -> 688
    //   672: aload 13
    //   674: iload 5
    //   676: bipush 10
    //   678: iadd
    //   679: iload 6
    //   681: invokevirtual 400	java/lang/String:substring	(II)Ljava/lang/String;
    //   684: astore_1
    //   685: goto +3 -> 688
    //   688: aload_1
    //   689: invokestatic 441	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   692: astore_1
    //   693: aload_1
    //   694: invokevirtual 444	java/lang/String:trim	()Ljava/lang/String;
    //   697: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   700: ifne +111 -> 811
    //   703: iload 9
    //   705: ifeq +42 -> 747
    //   708: aload_1
    //   709: invokestatic 448	com/tencent/mobileqq/utils/ContactUtils:a	(Ljava/lang/String;)Z
    //   712: ifeq +19 -> 731
    //   715: aload 14
    //   717: invokevirtual 267	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   720: ldc_w 449
    //   723: invokevirtual 453	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   726: istore 5
    //   728: goto +55 -> 783
    //   731: aload 14
    //   733: invokevirtual 267	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   736: ldc_w 454
    //   739: invokevirtual 453	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   742: istore 5
    //   744: goto +39 -> 783
    //   747: aload_1
    //   748: invokestatic 448	com/tencent/mobileqq/utils/ContactUtils:a	(Ljava/lang/String;)Z
    //   751: ifeq +19 -> 770
    //   754: aload 14
    //   756: invokevirtual 267	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   759: ldc_w 455
    //   762: invokevirtual 453	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   765: istore 5
    //   767: goto +16 -> 783
    //   770: aload 14
    //   772: invokevirtual 267	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   775: ldc_w 456
    //   778: invokevirtual 453	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   781: istore 5
    //   783: aload 12
    //   785: iload 5
    //   787: invokevirtual 459	com/tencent/mobileqq/widget/PAHighLightImageView:setTextSize	(I)V
    //   790: aload 12
    //   792: aload_1
    //   793: putfield 427	com/tencent/mobileqq/widget/PAHighLightImageView:e	Ljava/lang/String;
    //   796: aload 14
    //   798: invokevirtual 267	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   801: ldc_w 460
    //   804: invokevirtual 463	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   807: astore_1
    //   808: goto +48 -> 856
    //   811: aload 4
    //   813: ldc_w 465
    //   816: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   819: ifeq +15 -> 834
    //   822: aload 15
    //   824: aload 4
    //   826: iconst_3
    //   827: invokestatic 469	com/tencent/mobileqq/app/face/FaceDrawable:getMobileFaceDrawable	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;B)Lcom/tencent/mobileqq/app/face/FaceDrawable;
    //   830: astore_1
    //   831: goto +25 -> 856
    //   834: bipush 11
    //   836: iconst_3
    //   837: invokestatic 473	com/tencent/mobileqq/app/face/FaceDrawable:getDefaultDrawable	(II)Landroid/graphics/drawable/Drawable;
    //   840: astore_1
    //   841: goto +15 -> 856
    //   844: aload 15
    //   846: iconst_1
    //   847: aload 4
    //   849: iconst_3
    //   850: aload_1
    //   851: aload_1
    //   852: invokestatic 476	com/tencent/mobileqq/app/face/FaceDrawable:getFaceDrawable	(Lcom/tencent/common/app/AppInterface;ILjava/lang/String;ILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/mobileqq/app/face/FaceDrawable;
    //   855: astore_1
    //   856: aload 12
    //   858: aload_1
    //   859: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   862: aload_2
    //   863: areturn
    //   864: aload 12
    //   866: invokestatic 413	com/tencent/mobileqq/utils/ImageUtil:f	()Landroid/graphics/drawable/Drawable;
    //   869: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   872: aload_2
    //   873: areturn
    //   874: aload 13
    //   876: ldc_w 478
    //   879: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   882: ifeq +13 -> 895
    //   885: aload 12
    //   887: ldc_w 479
    //   890: invokevirtual 482	com/tencent/mobileqq/widget/PAHighLightImageView:setImageResource	(I)V
    //   893: aload_2
    //   894: areturn
    //   895: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   898: ifeq +12 -> 910
    //   901: ldc 248
    //   903: iconst_2
    //   904: ldc_w 484
    //   907: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: new 486	java/io/File
    //   913: dup
    //   914: aload 13
    //   916: invokespecial 487	java/io/File:<init>	(Ljava/lang/String;)V
    //   919: invokevirtual 491	java/io/File:toURL	()Ljava/net/URL;
    //   922: invokevirtual 492	java/net/URL:toString	()Ljava/lang/String;
    //   925: astore_1
    //   926: aload_0
    //   927: getfield 32	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:t	I
    //   930: getstatic 494	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:q	I
    //   933: if_icmpne +20 -> 953
    //   936: ldc_w 495
    //   939: aload 14
    //   941: invokestatic 501	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   944: istore 6
    //   946: iload 6
    //   948: istore 5
    //   950: goto +1235 -> 2185
    //   953: aload_0
    //   954: getfield 32	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:t	I
    //   957: getstatic 503	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:r	I
    //   960: if_icmpne +20 -> 980
    //   963: ldc_w 504
    //   966: aload 14
    //   968: invokestatic 501	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   971: istore 6
    //   973: iload 6
    //   975: istore 5
    //   977: goto +1208 -> 2185
    //   980: aload_1
    //   981: iload 5
    //   983: iload 5
    //   985: aload 11
    //   987: aload 11
    //   989: iconst_1
    //   990: invokestatic 507	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Z)Lcom/tencent/image/URLDrawable;
    //   993: astore_1
    //   994: goto +1194 -> 2188
    //   997: astore_1
    //   998: goto +11 -> 1009
    //   1001: astore_1
    //   1002: goto +7 -> 1009
    //   1005: astore_1
    //   1006: iconst_0
    //   1007: istore 5
    //   1009: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1012: ifeq +42 -> 1054
    //   1015: new 221	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1022: astore 4
    //   1024: aload 4
    //   1026: ldc_w 509
    //   1029: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload 4
    //   1035: aload_1
    //   1036: invokevirtual 510	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   1039: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: pop
    //   1043: ldc 104
    //   1045: iconst_2
    //   1046: aload 4
    //   1048: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1054: aload 12
    //   1056: invokestatic 413	com/tencent/mobileqq/utils/ImageUtil:f	()Landroid/graphics/drawable/Drawable;
    //   1059: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1062: aconst_null
    //   1063: astore_1
    //   1064: goto +1124 -> 2188
    //   1067: aload 13
    //   1069: ldc_w 512
    //   1072: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1075: ifeq +94 -> 1169
    //   1078: aload 13
    //   1080: aload 13
    //   1082: ldc_w 514
    //   1085: invokevirtual 407	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1088: iconst_3
    //   1089: iadd
    //   1090: invokevirtual 415	java/lang/String:substring	(I)Ljava/lang/String;
    //   1093: ldc_w 516
    //   1096: invokevirtual 520	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1099: iconst_0
    //   1100: aaload
    //   1101: astore_1
    //   1102: aload_1
    //   1103: invokestatic 316	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1106: ifne +517 -> 1623
    //   1109: aload_2
    //   1110: invokevirtual 423	android/view/View:getContext	()Landroid/content/Context;
    //   1113: astore 4
    //   1115: aload 4
    //   1117: instanceof 332
    //   1120: ifeq +39 -> 1159
    //   1123: aload 4
    //   1125: checkcast 332	com/tencent/mobileqq/app/BaseActivity
    //   1128: getfield 339	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1131: astore 4
    //   1133: iconst_4
    //   1134: iconst_3
    //   1135: invokestatic 473	com/tencent/mobileqq/app/face/FaceDrawable:getDefaultDrawable	(II)Landroid/graphics/drawable/Drawable;
    //   1138: astore 13
    //   1140: aload 12
    //   1142: aload 4
    //   1144: iconst_4
    //   1145: aload_1
    //   1146: iconst_3
    //   1147: aload 13
    //   1149: aload 13
    //   1151: invokestatic 476	com/tencent/mobileqq/app/face/FaceDrawable:getFaceDrawable	(Lcom/tencent/common/app/AppInterface;ILjava/lang/String;ILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/mobileqq/app/face/FaceDrawable;
    //   1154: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1157: aload_2
    //   1158: areturn
    //   1159: aload 12
    //   1161: invokestatic 413	com/tencent/mobileqq/utils/ImageUtil:f	()Landroid/graphics/drawable/Drawable;
    //   1164: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1167: aload_2
    //   1168: areturn
    //   1169: aload 13
    //   1171: getstatic 524	com/tencent/biz/troopbar/ShareActionSheet:b	Ljava/lang/String;
    //   1174: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1177: ifne +797 -> 1974
    //   1180: aload 13
    //   1182: getstatic 527	com/tencent/biz/troopbar/ShareActionSheet:c	Ljava/lang/String;
    //   1185: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1188: istore 9
    //   1190: iload 9
    //   1192: ifne +782 -> 1974
    //   1195: aload 13
    //   1197: getstatic 529	com/tencent/biz/troopbar/ShareActionSheet:d	Ljava/lang/String;
    //   1200: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1203: ifeq +6 -> 1209
    //   1206: goto +768 -> 1974
    //   1209: aload 13
    //   1211: ldc_w 396
    //   1214: iconst_0
    //   1215: bipush 73
    //   1217: invokevirtual 400	java/lang/String:substring	(II)Ljava/lang/String;
    //   1220: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1223: istore 9
    //   1225: iload 9
    //   1227: ifeq +26 -> 1253
    //   1230: new 531	android/graphics/drawable/ColorDrawable
    //   1233: dup
    //   1234: iconst_0
    //   1235: invokespecial 533	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   1238: astore_1
    //   1239: aload 12
    //   1241: aload 13
    //   1243: aload_1
    //   1244: aload_1
    //   1245: invokestatic 536	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/image/URLDrawable;
    //   1248: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1251: aload_2
    //   1252: areturn
    //   1253: aload 13
    //   1255: ldc_w 538
    //   1258: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1261: istore 9
    //   1263: iload 9
    //   1265: ifne +367 -> 1632
    //   1268: aload 13
    //   1270: getstatic 541	com/tencent/biz/subscribe/widget/SubscribeShareHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1273: invokevirtual 544	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1276: ifeq +6 -> 1282
    //   1279: goto +353 -> 1632
    //   1282: aload_0
    //   1283: getfield 52	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:ad	Ljava/lang/String;
    //   1286: ifnull +24 -> 1310
    //   1289: aload_0
    //   1290: getfield 52	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:ad	Ljava/lang/String;
    //   1293: ldc_w 546
    //   1296: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1299: ifeq +11 -> 1310
    //   1302: aload_0
    //   1303: iconst_1
    //   1304: putfield 28	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:jdField_a_of_type_Boolean	Z
    //   1307: goto +887 -> 2194
    //   1310: aload 13
    //   1312: ldc_w 548
    //   1315: invokevirtual 392	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1318: istore 9
    //   1320: iload 9
    //   1322: ifeq +253 -> 1575
    //   1325: aload 13
    //   1327: astore 4
    //   1329: new 117	java/net/URL
    //   1332: dup
    //   1333: aload 13
    //   1335: invokespecial 119	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1338: invokevirtual 551	java/net/URL:getQuery	()Ljava/lang/String;
    //   1341: ifnull +49 -> 1390
    //   1344: ldc_w 553
    //   1347: astore_1
    //   1348: aload 13
    //   1350: astore 4
    //   1352: aload_0
    //   1353: getfield 32	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:t	I
    //   1356: getstatic 494	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:q	I
    //   1359: if_icmpne +10 -> 1369
    //   1362: ldc_w 555
    //   1365: astore_1
    //   1366: goto +67 -> 1433
    //   1369: aload 13
    //   1371: astore 4
    //   1373: aload_0
    //   1374: getfield 32	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:t	I
    //   1377: getstatic 503	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:r	I
    //   1380: if_icmpne +53 -> 1433
    //   1383: ldc_w 557
    //   1386: astore_1
    //   1387: goto +46 -> 1433
    //   1390: ldc_w 559
    //   1393: astore_1
    //   1394: aload 13
    //   1396: astore 4
    //   1398: aload_0
    //   1399: getfield 32	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:t	I
    //   1402: getstatic 494	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:q	I
    //   1405: if_icmpne +10 -> 1415
    //   1408: ldc_w 561
    //   1411: astore_1
    //   1412: goto +21 -> 1433
    //   1415: aload 13
    //   1417: astore 4
    //   1419: aload_0
    //   1420: getfield 32	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:t	I
    //   1423: getstatic 503	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:r	I
    //   1426: if_icmpne +7 -> 1433
    //   1429: ldc_w 563
    //   1432: astore_1
    //   1433: aload 13
    //   1435: astore 4
    //   1437: new 189	java/lang/String
    //   1440: dup
    //   1441: aload 13
    //   1443: invokespecial 564	java/lang/String:<init>	(Ljava/lang/String;)V
    //   1446: pop
    //   1447: aload 13
    //   1449: astore 4
    //   1451: new 221	java/lang/StringBuilder
    //   1454: dup
    //   1455: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1458: astore 15
    //   1460: aload 13
    //   1462: astore 4
    //   1464: aload 15
    //   1466: aload 13
    //   1468: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: pop
    //   1472: aload 13
    //   1474: astore 4
    //   1476: aload 15
    //   1478: aload_1
    //   1479: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1482: pop
    //   1483: aload 13
    //   1485: astore 4
    //   1487: aload 15
    //   1489: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1492: astore_1
    //   1493: aload_1
    //   1494: astore 4
    //   1496: aload_0
    //   1497: getfield 164	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1500: ifnull +35 -> 1535
    //   1503: aload_1
    //   1504: astore 4
    //   1506: aload_0
    //   1507: getfield 164	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1510: getfield 182	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1513: ifnull +22 -> 1535
    //   1516: aload_1
    //   1517: astore 4
    //   1519: aload_0
    //   1520: getfield 164	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1523: getfield 182	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1526: astore 13
    //   1528: aload 13
    //   1530: astore 4
    //   1532: goto +6 -> 1538
    //   1535: aconst_null
    //   1536: astore 4
    //   1538: goto +102 -> 1640
    //   1541: new 221	java/lang/StringBuilder
    //   1544: dup
    //   1545: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   1548: astore_1
    //   1549: aload_1
    //   1550: ldc 224
    //   1552: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: pop
    //   1556: aload_1
    //   1557: aload 4
    //   1559: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: pop
    //   1563: new 230	java/lang/IllegalArgumentException
    //   1566: dup
    //   1567: aload_1
    //   1568: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1571: invokespecial 234	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1574: athrow
    //   1575: aload_0
    //   1576: getfield 164	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1579: ifnull +44 -> 1623
    //   1582: aload_0
    //   1583: getfield 164	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1586: getfield 182	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1589: ifnull +34 -> 1623
    //   1592: aload_0
    //   1593: getfield 164	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1596: getfield 182	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1599: getfield 187	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1602: sipush 1008
    //   1605: if_icmpne +18 -> 1623
    //   1608: aload_0
    //   1609: getfield 164	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1612: getfield 182	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   1615: astore 4
    //   1617: aload 13
    //   1619: astore_1
    //   1620: goto +20 -> 1640
    //   1623: aload 13
    //   1625: astore_1
    //   1626: aconst_null
    //   1627: astore 4
    //   1629: goto +11 -> 1640
    //   1632: aload_0
    //   1633: iconst_1
    //   1634: putfield 28	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:jdField_a_of_type_Boolean	Z
    //   1637: goto +557 -> 2194
    //   1640: aload_0
    //   1641: getfield 32	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:t	I
    //   1644: istore 6
    //   1646: getstatic 494	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:q	I
    //   1649: istore 7
    //   1651: iload 6
    //   1653: iload 7
    //   1655: if_icmpne +24 -> 1679
    //   1658: aload 12
    //   1660: getstatic 370	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   1663: invokevirtual 374	com/tencent/mobileqq/widget/PAHighLightImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1666: ldc_w 495
    //   1669: aload 14
    //   1671: invokestatic 501	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   1674: istore 5
    //   1676: goto +50 -> 1726
    //   1679: aload_0
    //   1680: getfield 32	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:t	I
    //   1683: istore 6
    //   1685: getstatic 503	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:r	I
    //   1688: istore 7
    //   1690: iload 6
    //   1692: iload 7
    //   1694: if_icmpne +24 -> 1718
    //   1697: aload 12
    //   1699: getstatic 567	android/widget/ImageView$ScaleType:CENTER	Landroid/widget/ImageView$ScaleType;
    //   1702: invokevirtual 374	com/tencent/mobileqq/widget/PAHighLightImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1705: ldc_w 504
    //   1708: aload 14
    //   1710: invokestatic 501	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   1713: istore 5
    //   1715: goto -39 -> 1676
    //   1718: aload 12
    //   1720: getstatic 567	android/widget/ImageView$ScaleType:CENTER	Landroid/widget/ImageView$ScaleType;
    //   1723: invokevirtual 374	com/tencent/mobileqq/widget/PAHighLightImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1726: iload 8
    //   1728: ifeq +17 -> 1745
    //   1731: aload 12
    //   1733: ldc_w 376
    //   1736: invokestatic 382	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1739: invokevirtual 385	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundColor	(I)V
    //   1742: goto +14 -> 1756
    //   1745: aload 12
    //   1747: ldc_w 387
    //   1750: invokestatic 382	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1753: invokevirtual 385	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundColor	(I)V
    //   1756: aload_0
    //   1757: aload_1
    //   1758: iload 5
    //   1760: iload 5
    //   1762: aload 11
    //   1764: aload 11
    //   1766: iconst_1
    //   1767: iconst_1
    //   1768: aload 4
    //   1770: invokespecial 569	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:a	(Ljava/lang/String;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;ZZLjava/lang/Object;)Lcom/tencent/image/URLDrawable;
    //   1773: astore_1
    //   1774: aload_1
    //   1775: invokevirtual 573	com/tencent/image/URLDrawable:getTag	()Ljava/lang/Object;
    //   1778: ifnonnull +11 -> 1789
    //   1781: aload_1
    //   1782: iconst_0
    //   1783: invokestatic 578	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1786: invokevirtual 219	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   1789: aload_1
    //   1790: iconst_1
    //   1791: invokevirtual 582	com/tencent/image/URLDrawable:setAutoDownload	(Z)V
    //   1794: aload_1
    //   1795: invokevirtual 585	com/tencent/image/URLDrawable:getStatus	()I
    //   1798: iconst_2
    //   1799: if_icmpne +400 -> 2199
    //   1802: aload_1
    //   1803: invokevirtual 588	com/tencent/image/URLDrawable:restartDownload	()V
    //   1806: goto +393 -> 2199
    //   1809: aload 12
    //   1811: astore 4
    //   1813: aload_1
    //   1814: ifnull +37 -> 1851
    //   1817: aload_1
    //   1818: invokevirtual 585	com/tencent/image/URLDrawable:getStatus	()I
    //   1821: iconst_1
    //   1822: if_icmpne +29 -> 1851
    //   1825: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1828: ifeq +12 -> 1840
    //   1831: ldc 248
    //   1833: iconst_2
    //   1834: ldc_w 590
    //   1837: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1840: aload 4
    //   1842: getstatic 370	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   1845: invokevirtual 374	com/tencent/mobileqq/widget/PAHighLightImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   1848: goto +27 -> 1875
    //   1851: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1854: ifeq +12 -> 1866
    //   1857: ldc 248
    //   1859: iconst_2
    //   1860: ldc_w 592
    //   1863: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1866: aload 4
    //   1868: aload_0
    //   1869: getfield 39	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter	Lcom/tencent/image/URLDrawableDownListener$Adapter;
    //   1872: invokevirtual 596	com/tencent/mobileqq/widget/PAHighLightImageView:setURLDrawableDownListener	(Lcom/tencent/image/URLDrawableDownListener;)V
    //   1875: iload_3
    //   1876: ifeq +9 -> 1885
    //   1879: aload 4
    //   1881: aconst_null
    //   1882: invokevirtual 357	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1885: aload_1
    //   1886: ifnull +63 -> 1949
    //   1889: iload_3
    //   1890: ifeq +59 -> 1949
    //   1893: iload 5
    //   1895: istore 6
    //   1897: iload 5
    //   1899: ifne +9 -> 1908
    //   1902: aload_1
    //   1903: invokevirtual 597	com/tencent/image/URLDrawable:getIntrinsicWidth	()I
    //   1906: istore 6
    //   1908: aload_1
    //   1909: iload 6
    //   1911: iload 6
    //   1913: iload 6
    //   1915: invokestatic 602	com/tencent/mobileqq/urldrawable/URLDrawableDecodeHandler:b	(III)[I
    //   1918: invokevirtual 219	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   1921: aload_1
    //   1922: getstatic 606	com/tencent/mobileqq/urldrawable/URLDrawableDecodeHandler:i	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   1925: invokevirtual 610	com/tencent/image/URLDrawable:setDecodeHandler	(Lcom/tencent/image/DownloadParams$DecodeHandler;)V
    //   1928: aload 4
    //   1930: aload_1
    //   1931: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1934: aload_1
    //   1935: invokevirtual 585	com/tencent/image/URLDrawable:getStatus	()I
    //   1938: iconst_1
    //   1939: if_icmpeq +16 -> 1955
    //   1942: aload_1
    //   1943: invokevirtual 588	com/tencent/image/URLDrawable:restartDownload	()V
    //   1946: goto +9 -> 1955
    //   1949: aload 4
    //   1951: aload_1
    //   1952: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1955: goto +167 -> 2122
    //   1958: astore_1
    //   1959: aload 11
    //   1961: astore 4
    //   1963: goto +94 -> 2057
    //   1966: astore_1
    //   1967: aload 11
    //   1969: astore 4
    //   1971: goto +86 -> 2057
    //   1974: aload 11
    //   1976: astore 4
    //   1978: aload 12
    //   1980: astore_1
    //   1981: aload_1
    //   1982: aconst_null
    //   1983: invokevirtual 357	com/tencent/mobileqq/widget/PAHighLightImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1986: aload 13
    //   1988: aload 13
    //   1990: ldc_w 404
    //   1993: invokevirtual 407	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1996: iconst_5
    //   1997: iadd
    //   1998: invokevirtual 415	java/lang/String:substring	(I)Ljava/lang/String;
    //   2001: astore 11
    //   2003: aload_2
    //   2004: invokevirtual 423	android/view/View:getContext	()Landroid/content/Context;
    //   2007: astore 13
    //   2009: aload 13
    //   2011: instanceof 332
    //   2014: ifeq +25 -> 2039
    //   2017: aload_1
    //   2018: aload 13
    //   2020: checkcast 332	com/tencent/mobileqq/app/BaseActivity
    //   2023: getfield 339	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2026: aload 11
    //   2028: iconst_0
    //   2029: iconst_4
    //   2030: invokevirtual 615	com/tencent/mobileqq/app/QQAppInterface:getFaceDrawable	(Ljava/lang/String;ZB)Landroid/graphics/drawable/Drawable;
    //   2033: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2036: goto +10 -> 2046
    //   2039: aload_1
    //   2040: invokestatic 413	com/tencent/mobileqq/utils/ImageUtil:f	()Landroid/graphics/drawable/Drawable;
    //   2043: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2046: aload_2
    //   2047: areturn
    //   2048: astore_1
    //   2049: goto +8 -> 2057
    //   2052: astore_1
    //   2053: aload 11
    //   2055: astore 4
    //   2057: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2060: ifeq +55 -> 2115
    //   2063: new 221	java/lang/StringBuilder
    //   2066: dup
    //   2067: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   2070: astore 11
    //   2072: aload 11
    //   2074: ldc_w 617
    //   2077: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2080: pop
    //   2081: aload 11
    //   2083: aload_1
    //   2084: invokevirtual 620	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2087: pop
    //   2088: aload 11
    //   2090: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2093: ifnull +11 -> 2104
    //   2096: aload_1
    //   2097: invokevirtual 621	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2100: astore_1
    //   2101: goto +7 -> 2108
    //   2104: ldc_w 623
    //   2107: astore_1
    //   2108: ldc 104
    //   2110: iconst_2
    //   2111: aload_1
    //   2112: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2115: aload 12
    //   2117: aload 4
    //   2119: invokevirtual 354	com/tencent/mobileqq/widget/PAHighLightImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2122: aload_0
    //   2123: getfield 624	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:c	Ljava/lang/String;
    //   2126: ifnull +26 -> 2152
    //   2129: aload_0
    //   2130: getfield 624	com/tencent/mobileqq/structmsg/view/StructMsgItemCover:c	Ljava/lang/String;
    //   2133: ldc_w 425
    //   2136: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2139: ifne +13 -> 2152
    //   2142: aload_2
    //   2143: iconst_1
    //   2144: invokevirtual 627	android/view/View:setClickable	(Z)V
    //   2147: aload_2
    //   2148: aload_0
    //   2149: invokevirtual 631	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2152: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2155: ifeq +12 -> 2167
    //   2158: ldc 248
    //   2160: iconst_2
    //   2161: ldc_w 633
    //   2164: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2167: aload_2
    //   2168: areturn
    //   2169: astore 11
    //   2171: goto -2049 -> 122
    //   2174: astore_1
    //   2175: goto -634 -> 1541
    //   2178: ldc_w 425
    //   2181: astore_1
    //   2182: goto -1494 -> 688
    //   2185: goto -1205 -> 980
    //   2188: goto -379 -> 1809
    //   2191: goto -1124 -> 1067
    //   2194: iconst_1
    //   2195: istore_3
    //   2196: goto -573 -> 1623
    //   2199: goto -390 -> 1809
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2202	0	this	StructMsgItemCover
    //   0	2202	1	paramContext	Context
    //   0	2202	2	paramView	View
    //   0	2202	3	paramBoolean	boolean
    //   0	2202	4	paramBundle	Bundle
    //   104	1794	5	i	int
    //   650	1264	6	j	int
    //   1649	46	7	k	int
    //   82	1645	8	bool1	boolean
    //   61	1260	9	bool2	boolean
    //   193	284	10	bool3	boolean
    //   18	2071	11	localObject1	Object
    //   2169	1	11	localOutOfMemoryError	OutOfMemoryError
    //   140	1976	12	localObject2	Object
    //   186	1833	13	localObject3	Object
    //   94	1615	14	localObject4	Object
    //   604	884	15	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   249	297	299	java/lang/Throwable
    //   980	994	997	java/net/MalformedURLException
    //   926	946	1001	java/net/MalformedURLException
    //   953	973	1001	java/net/MalformedURLException
    //   481	502	1005	java/net/MalformedURLException
    //   508	523	1005	java/net/MalformedURLException
    //   523	531	1005	java/net/MalformedURLException
    //   533	552	1005	java/net/MalformedURLException
    //   561	570	1005	java/net/MalformedURLException
    //   574	632	1005	java/net/MalformedURLException
    //   638	652	1005	java/net/MalformedURLException
    //   658	669	1005	java/net/MalformedURLException
    //   672	685	1005	java/net/MalformedURLException
    //   688	703	1005	java/net/MalformedURLException
    //   708	728	1005	java/net/MalformedURLException
    //   731	744	1005	java/net/MalformedURLException
    //   747	767	1005	java/net/MalformedURLException
    //   770	783	1005	java/net/MalformedURLException
    //   783	808	1005	java/net/MalformedURLException
    //   811	831	1005	java/net/MalformedURLException
    //   834	841	1005	java/net/MalformedURLException
    //   844	856	1005	java/net/MalformedURLException
    //   856	862	1005	java/net/MalformedURLException
    //   864	872	1005	java/net/MalformedURLException
    //   874	893	1005	java/net/MalformedURLException
    //   895	910	1005	java/net/MalformedURLException
    //   910	926	1005	java/net/MalformedURLException
    //   1756	1789	1958	java/lang/Exception
    //   1789	1806	1958	java/lang/Exception
    //   1817	1840	1958	java/lang/Exception
    //   1840	1848	1958	java/lang/Exception
    //   1851	1866	1958	java/lang/Exception
    //   1866	1875	1958	java/lang/Exception
    //   1879	1885	1958	java/lang/Exception
    //   1902	1908	1958	java/lang/Exception
    //   1908	1946	1958	java/lang/Exception
    //   1949	1955	1958	java/lang/Exception
    //   1195	1206	1966	java/lang/Exception
    //   1209	1225	1966	java/lang/Exception
    //   1253	1263	1966	java/lang/Exception
    //   1632	1637	1966	java/lang/Exception
    //   1640	1651	1966	java/lang/Exception
    //   1679	1690	1966	java/lang/Exception
    //   1718	1726	1966	java/lang/Exception
    //   1745	1756	1966	java/lang/Exception
    //   1981	2036	2048	java/lang/Exception
    //   2039	2046	2048	java/lang/Exception
    //   434	444	2052	java/lang/Exception
    //   449	476	2052	java/lang/Exception
    //   481	502	2052	java/lang/Exception
    //   508	523	2052	java/lang/Exception
    //   523	531	2052	java/lang/Exception
    //   533	552	2052	java/lang/Exception
    //   561	570	2052	java/lang/Exception
    //   574	632	2052	java/lang/Exception
    //   638	652	2052	java/lang/Exception
    //   658	669	2052	java/lang/Exception
    //   672	685	2052	java/lang/Exception
    //   688	703	2052	java/lang/Exception
    //   708	728	2052	java/lang/Exception
    //   731	744	2052	java/lang/Exception
    //   747	767	2052	java/lang/Exception
    //   770	783	2052	java/lang/Exception
    //   783	808	2052	java/lang/Exception
    //   811	831	2052	java/lang/Exception
    //   834	841	2052	java/lang/Exception
    //   844	856	2052	java/lang/Exception
    //   856	862	2052	java/lang/Exception
    //   864	872	2052	java/lang/Exception
    //   874	893	2052	java/lang/Exception
    //   895	910	2052	java/lang/Exception
    //   910	926	2052	java/lang/Exception
    //   926	946	2052	java/lang/Exception
    //   953	973	2052	java/lang/Exception
    //   980	994	2052	java/lang/Exception
    //   1009	1054	2052	java/lang/Exception
    //   1054	1062	2052	java/lang/Exception
    //   1067	1157	2052	java/lang/Exception
    //   1159	1167	2052	java/lang/Exception
    //   1169	1190	2052	java/lang/Exception
    //   1230	1251	2052	java/lang/Exception
    //   1268	1279	2052	java/lang/Exception
    //   1282	1307	2052	java/lang/Exception
    //   1310	1320	2052	java/lang/Exception
    //   1329	1344	2052	java/lang/Exception
    //   1352	1362	2052	java/lang/Exception
    //   1373	1383	2052	java/lang/Exception
    //   1398	1408	2052	java/lang/Exception
    //   1419	1429	2052	java/lang/Exception
    //   1437	1447	2052	java/lang/Exception
    //   1451	1460	2052	java/lang/Exception
    //   1464	1472	2052	java/lang/Exception
    //   1476	1483	2052	java/lang/Exception
    //   1487	1493	2052	java/lang/Exception
    //   1496	1503	2052	java/lang/Exception
    //   1506	1516	2052	java/lang/Exception
    //   1519	1528	2052	java/lang/Exception
    //   1541	1575	2052	java/lang/Exception
    //   1575	1617	2052	java/lang/Exception
    //   1658	1676	2052	java/lang/Exception
    //   1697	1715	2052	java/lang/Exception
    //   1731	1742	2052	java/lang/Exception
    //   106	119	2169	java/lang/OutOfMemoryError
    //   1329	1344	2174	java/net/MalformedURLException
    //   1352	1362	2174	java/net/MalformedURLException
    //   1373	1383	2174	java/net/MalformedURLException
    //   1398	1408	2174	java/net/MalformedURLException
    //   1419	1429	2174	java/net/MalformedURLException
    //   1437	1447	2174	java/net/MalformedURLException
    //   1451	1460	2174	java/net/MalformedURLException
    //   1464	1472	2174	java/net/MalformedURLException
    //   1476	1483	2174	java/net/MalformedURLException
    //   1487	1493	2174	java/net/MalformedURLException
    //   1496	1503	2174	java/net/MalformedURLException
    //   1506	1516	2174	java/net/MalformedURLException
    //   1519	1528	2174	java/net/MalformedURLException
  }
  
  StructMsgForGeneralShare a(View paramView)
  {
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131377989) {
        return (StructMsgForGeneralShare)paramView.getTag(2131377989);
      }
    }
    return null;
  }
  
  public String a()
  {
    return "Cover";
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
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (this.ac.endsWith("gif")))
    {
      str = "0";
      localObject1 = ((BaseActivity)paramView.getContext()).getChatFragment();
      if (localObject1 == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = ((ChatFragment)localObject1).a();
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
    paramAbsShareMsg.mContentCover = this.ac;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ac = paramObjectInput.readUTF();
    if (this.jdField_a_of_type_Int <= 3) {
      return;
    }
    this.c = paramObjectInput.readUTF();
    this.b = paramObjectInput.readUTF();
    if (this.jdField_a_of_type_Int <= 5) {
      return;
    }
    this.j = paramObjectInput.readUTF();
    this.k = paramObjectInput.readUTF();
    this.l = paramObjectInput.readUTF();
    this.o = paramObjectInput.readInt();
    this.p = paramObjectInput.readInt();
    if (this.jdField_a_of_type_Int <= 8) {
      return;
    }
    this.ad = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str2 = this.ac;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    if (this.jdField_a_of_type_Int <= 3) {
      return;
    }
    if (this.c == null) {
      str1 = "";
    } else {
      str1 = this.c;
    }
    paramObjectOutput.writeUTF(str1);
    if (this.b == null) {
      str1 = "";
    } else {
      str1 = this.b;
    }
    paramObjectOutput.writeUTF(str1);
    if (this.jdField_a_of_type_Int <= 5) {
      return;
    }
    if (this.j == null) {
      str1 = "";
    } else {
      str1 = this.j;
    }
    paramObjectOutput.writeUTF(str1);
    if (this.k == null) {
      str1 = "";
    } else {
      str1 = this.k;
    }
    paramObjectOutput.writeUTF(str1);
    if (this.l == null) {
      str1 = "";
    } else {
      str1 = this.l;
    }
    paramObjectOutput.writeUTF(str1);
    paramObjectOutput.writeInt(this.o);
    paramObjectOutput.writeInt(this.p);
    if (this.jdField_a_of_type_Int <= 8) {
      return;
    }
    str2 = this.ad;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "picture");
    String str2 = this.ac;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializer.attribute(null, "cover", str1);
    if (this.jdField_a_of_type_Int > 3)
    {
      if (!TextUtils.isEmpty(this.c)) {
        paramXmlSerializer.attribute(null, "action", this.c);
      }
      if (!TextUtils.isEmpty(this.b)) {
        paramXmlSerializer.attribute(null, "url", this.b);
      }
      if (this.jdField_a_of_type_Int > 5)
      {
        if (!TextUtils.isEmpty(this.j)) {
          paramXmlSerializer.attribute(null, "index", this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
          paramXmlSerializer.attribute(null, "index_name", this.k);
        }
        if (!TextUtils.isEmpty(this.l)) {
          paramXmlSerializer.attribute(null, "index_type", this.l);
        }
        paramXmlSerializer.attribute(null, "w", String.valueOf(this.o));
        paramXmlSerializer.attribute(null, "h", String.valueOf(this.p));
        if ((this.jdField_a_of_type_Int > 8) && (!TextUtils.isEmpty(this.ad))) {
          paramXmlSerializer.attribute(null, "needRoundView", this.ad);
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
    this.ac = str;
    if (this.jdField_a_of_type_Int > 3)
    {
      this.c = paramStructMsgNode.a("action");
      this.b = paramStructMsgNode.a("url");
      if (this.jdField_a_of_type_Int > 5)
      {
        this.j = paramStructMsgNode.a("index");
        this.k = paramStructMsgNode.a("index_name");
        this.l = paramStructMsgNode.a("index_type");
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
      this.o = i;
      str = paramStructMsgNode.a("h");
      if (str == null) {
        i = 0;
      } else {
        i = Integer.parseInt(str);
      }
      this.p = i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label158:
      break label158;
    }
    this.o = 0;
    this.p = 0;
    if (this.jdField_a_of_type_Int > 8) {
      this.ad = paramStructMsgNode.a("needRoundView");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemCover
 * JD-Core Version:    0.7.0.1
 */