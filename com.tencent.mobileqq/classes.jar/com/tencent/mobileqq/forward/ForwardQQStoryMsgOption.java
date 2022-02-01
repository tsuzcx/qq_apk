package com.tencent.mobileqq.forward;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ForwardQQStoryMsgOption
  extends ForwardStructingMsgOption
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  protected ScrollView a;
  
  public ForwardQQStoryMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a()
  {
    int i = c();
    String str = "";
    if (i != 0) {
      str = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", str);
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      a("clk_send", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgAction, this.jdField_a_of_type_AndroidAppActivity);
    }
    super.a();
  }
  
  protected void a(String paramString1, String paramString2, Context paramContext)
  {
    int i = 3;
    try
    {
      paramString2 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramString2);
      paramContext = "";
      str = "";
      for (;;)
      {
        try
        {
          j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
          if (j != 0) {
            break label242;
          }
          i = 1;
          if (paramString2 == null) {
            continue;
          }
          paramContext = paramString2.b("unionid");
          str = paramString2.b("storyid");
        }
        catch (Exception paramString1)
        {
          if (!QLog.isColorLevel()) {
            break label236;
          }
          QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramString1);
          return;
          j = -1;
          paramString2 = str;
          continue;
        }
        try
        {
          j = Integer.valueOf(paramString2.b("contentType")).intValue();
          paramString2 = str;
        }
        catch (Exception paramString2)
        {
          paramString2.printStackTrace();
          paramString2 = str;
          j = -1;
        }
      }
      StoryReportor.a("share", paramString1, i, j, new String[] { paramContext, paramString2, "", "" });
      if (QLog.isColorLevel())
      {
        QLog.d("ForwardOption.ForwardQQStoryMsgOption", 2, "reportClickEvent: opName=" + paramString1 + ", fromType=" + i + ", result=" + j + ", extra1=" + paramContext + ", extra2=" + paramString2);
        return;
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        String str;
        int j;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.qqstory.share", 2, "report exp:", paramString2);
          break label237;
          label236:
          return;
        }
        label237:
        paramString2 = null;
        continue;
        label242:
        if (j == 1) {
          i = 2;
        } else if (j != 3000) {
          i = -1;
        }
      }
    }
  }
  
  /* Error */
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 162	com/tencent/mobileqq/utils/QQCustomDialog:getWindow	()Landroid/view/Window;
    //   4: bipush 19
    //   6: invokevirtual 168	android/view/Window:setSoftInputMode	(I)V
    //   9: aload_0
    //   10: getfield 46	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   13: ifnull +647 -> 660
    //   16: aload_0
    //   17: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   20: ldc 169
    //   22: invokestatic 174	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   25: istore_2
    //   26: aload_0
    //   27: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   30: ldc 175
    //   32: invokestatic 174	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   35: istore_3
    //   36: aload_0
    //   37: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   40: ldc 176
    //   42: invokestatic 174	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   45: istore 4
    //   47: aload_0
    //   48: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   51: ldc 177
    //   53: invokestatic 174	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   56: istore 5
    //   58: aload_0
    //   59: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   62: ldc 178
    //   64: invokestatic 174	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   67: istore 6
    //   69: ldc 180
    //   71: invokestatic 185	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   74: istore 7
    //   76: new 187	android/widget/LinearLayout
    //   79: dup
    //   80: aload_0
    //   81: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   84: invokespecial 190	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   87: astore 8
    //   89: aload 8
    //   91: iconst_1
    //   92: invokevirtual 193	android/widget/LinearLayout:setOrientation	(I)V
    //   95: new 195	android/widget/LinearLayout$LayoutParams
    //   98: dup
    //   99: bipush 254
    //   101: bipush 254
    //   103: invokespecial 198	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   106: astore 9
    //   108: aload 9
    //   110: iconst_1
    //   111: putfield 202	android/widget/LinearLayout$LayoutParams:gravity	I
    //   114: new 204	android/widget/RelativeLayout
    //   117: dup
    //   118: aload_0
    //   119: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   122: invokespecial 205	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   125: astore 10
    //   127: new 195	android/widget/LinearLayout$LayoutParams
    //   130: dup
    //   131: iload_3
    //   132: iload 4
    //   134: invokespecial 198	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   137: astore 11
    //   139: new 207	com/tencent/image/URLImageView
    //   142: dup
    //   143: aload_0
    //   144: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   147: invokespecial 208	com/tencent/image/URLImageView:<init>	(Landroid/content/Context;)V
    //   150: astore 14
    //   152: aload 14
    //   154: getstatic 214	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   157: invokevirtual 218	com/tencent/image/URLImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   160: new 220	android/widget/RelativeLayout$LayoutParams
    //   163: dup
    //   164: iconst_m1
    //   165: iconst_m1
    //   166: invokespecial 221	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   169: astore 12
    //   171: new 207	com/tencent/image/URLImageView
    //   174: dup
    //   175: aload_0
    //   176: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   179: invokespecial 208	com/tencent/image/URLImageView:<init>	(Landroid/content/Context;)V
    //   182: astore 13
    //   184: aload 13
    //   186: getstatic 224	android/widget/ImageView$ScaleType:FIT_START	Landroid/widget/ImageView$ScaleType;
    //   189: invokevirtual 218	com/tencent/image/URLImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   192: new 220	android/widget/RelativeLayout$LayoutParams
    //   195: dup
    //   196: iload 5
    //   198: iload 6
    //   200: invokespecial 221	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   203: astore 15
    //   205: aload 15
    //   207: bipush 9
    //   209: invokevirtual 227	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   212: aload 15
    //   214: bipush 10
    //   216: invokevirtual 227	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   219: aload 15
    //   221: iload_2
    //   222: putfield 230	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   225: aload 15
    //   227: aload_0
    //   228: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   231: ldc 231
    //   233: invokestatic 174	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   236: putfield 234	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   239: new 236	android/widget/TextView
    //   242: dup
    //   243: aload_0
    //   244: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   247: invokespecial 237	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   250: astore 16
    //   252: aload 16
    //   254: ldc 238
    //   256: invokevirtual 241	android/widget/TextView:setTextColor	(I)V
    //   259: aload 16
    //   261: iconst_1
    //   262: ldc 169
    //   264: invokevirtual 245	android/widget/TextView:setTextSize	(IF)V
    //   267: new 195	android/widget/LinearLayout$LayoutParams
    //   270: dup
    //   271: bipush 254
    //   273: bipush 254
    //   275: invokespecial 198	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   278: astore 17
    //   280: aload 17
    //   282: aload_0
    //   283: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   286: ldc 246
    //   288: invokestatic 174	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   291: putfield 247	android/widget/LinearLayout$LayoutParams:topMargin	I
    //   294: aload 17
    //   296: iconst_3
    //   297: putfield 202	android/widget/LinearLayout$LayoutParams:gravity	I
    //   300: aload 10
    //   302: aload 14
    //   304: aload 12
    //   306: invokevirtual 251	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   309: aload 10
    //   311: aload 13
    //   313: aload 15
    //   315: invokevirtual 251	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   318: aload 8
    //   320: aload 10
    //   322: aload 11
    //   324: invokevirtual 252	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   327: aload 8
    //   329: aload 16
    //   331: aload 17
    //   333: invokevirtual 252	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   336: aload_1
    //   337: aload 8
    //   339: aload 9
    //   341: invokevirtual 255	com/tencent/mobileqq/utils/QQCustomDialog:addView	(Landroid/view/View;Landroid/widget/LinearLayout$LayoutParams;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   344: pop
    //   345: aload 16
    //   347: aload_0
    //   348: getfield 46	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   351: getfield 258	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceName	Ljava/lang/String;
    //   354: invokevirtual 262	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   357: ldc 20
    //   359: astore 12
    //   361: new 264	org/json/JSONObject
    //   364: dup
    //   365: aload_0
    //   366: getfield 46	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   369: getfield 267	com/tencent/mobileqq/structmsg/AbsShareMsg:mQQStoryExtra	Ljava/lang/String;
    //   372: invokespecial 270	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   375: astore 9
    //   377: aload 9
    //   379: ldc_w 272
    //   382: invokevirtual 275	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   385: astore 8
    //   387: aload 9
    //   389: ldc_w 277
    //   392: invokevirtual 275	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   395: astore 9
    //   397: aload 8
    //   399: astore 10
    //   401: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +35 -> 439
    //   407: ldc 146
    //   409: iconst_2
    //   410: new 118	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 279
    //   420: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_0
    //   424: getfield 46	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   427: getfield 267	com/tencent/mobileqq/structmsg/AbsShareMsg:mQQStoryExtra	Ljava/lang/String;
    //   430: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: new 281	android/graphics/drawable/ColorDrawable
    //   442: dup
    //   443: iload 7
    //   445: invokespecial 283	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   448: astore 8
    //   450: aload 14
    //   452: aload 8
    //   454: invokevirtual 287	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   457: invokestatic 293	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   460: astore 11
    //   462: aload 11
    //   464: aload 8
    //   466: putfield 297	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   469: aload 11
    //   471: aload 8
    //   473: putfield 300	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   476: aload 11
    //   478: iload_3
    //   479: putfield 303	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   482: aload 11
    //   484: iload 4
    //   486: putfield 306	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   489: aload 10
    //   491: aload 11
    //   493: invokestatic 312	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   496: astore 8
    //   498: aload 8
    //   500: invokevirtual 315	com/tencent/image/URLDrawable:getStatus	()I
    //   503: iconst_2
    //   504: if_icmpne +8 -> 512
    //   507: aload 8
    //   509: invokevirtual 318	com/tencent/image/URLDrawable:restartDownload	()V
    //   512: aload 14
    //   514: aload 8
    //   516: invokevirtual 287	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   519: new 281	android/graphics/drawable/ColorDrawable
    //   522: dup
    //   523: ldc_w 320
    //   526: invokestatic 185	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   529: invokespecial 283	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   532: astore 8
    //   534: aload 13
    //   536: aload 8
    //   538: invokevirtual 287	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   541: invokestatic 293	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   544: astore 10
    //   546: aload 10
    //   548: aload 8
    //   550: putfield 297	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   553: aload 10
    //   555: aload 8
    //   557: putfield 300	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   560: aload 10
    //   562: iload 5
    //   564: putfield 303	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   567: aload 10
    //   569: iload 6
    //   571: putfield 306	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   574: aload 9
    //   576: aload 10
    //   578: invokestatic 312	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   581: astore 8
    //   583: aload 8
    //   585: invokevirtual 315	com/tencent/image/URLDrawable:getStatus	()I
    //   588: iconst_2
    //   589: if_icmpne +8 -> 597
    //   592: aload 8
    //   594: invokevirtual 318	com/tencent/image/URLDrawable:restartDownload	()V
    //   597: aload 13
    //   599: aload 8
    //   601: invokevirtual 287	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   604: aload_0
    //   605: aload_1
    //   606: invokevirtual 162	com/tencent/mobileqq/utils/QQCustomDialog:getWindow	()Landroid/view/Window;
    //   609: invokevirtual 324	android/view/Window:getDecorView	()Landroid/view/View;
    //   612: ldc_w 325
    //   615: invokevirtual 331	android/view/View:findViewById	(I)Landroid/view/View;
    //   618: checkcast 333	android/widget/ScrollView
    //   621: putfield 335	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidWidgetScrollView	Landroid/widget/ScrollView;
    //   624: aload_0
    //   625: getfield 335	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidWidgetScrollView	Landroid/widget/ScrollView;
    //   628: ifnull +14 -> 642
    //   631: aload_0
    //   632: getfield 335	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidWidgetScrollView	Landroid/widget/ScrollView;
    //   635: invokevirtual 339	android/widget/ScrollView:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   638: aload_0
    //   639: invokevirtual 345	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   642: aload_0
    //   643: ldc_w 347
    //   646: aload_0
    //   647: getfield 46	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   650: getfield 54	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgAction	Ljava/lang/String;
    //   653: aload_0
    //   654: getfield 57	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   657: invokevirtual 60	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   660: iconst_1
    //   661: ireturn
    //   662: astore 11
    //   664: ldc 20
    //   666: astore 8
    //   668: aload 12
    //   670: astore 9
    //   672: aload 8
    //   674: astore 10
    //   676: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   679: ifeq -278 -> 401
    //   682: ldc 146
    //   684: iconst_2
    //   685: ldc_w 279
    //   688: aload 11
    //   690: invokestatic 152	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   693: aload 12
    //   695: astore 9
    //   697: aload 8
    //   699: astore 10
    //   701: goto -300 -> 401
    //   704: astore 8
    //   706: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   709: ifeq -190 -> 519
    //   712: ldc 146
    //   714: iconst_2
    //   715: ldc_w 279
    //   718: aload 8
    //   720: invokestatic 152	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   723: goto -204 -> 519
    //   726: astore 8
    //   728: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   731: ifeq -127 -> 604
    //   734: ldc 146
    //   736: iconst_2
    //   737: ldc_w 279
    //   740: aload 8
    //   742: invokestatic 152	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   745: goto -141 -> 604
    //   748: astore_1
    //   749: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq -110 -> 642
    //   755: ldc 146
    //   757: iconst_2
    //   758: new 118	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   765: ldc_w 279
    //   768: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload_1
    //   772: invokevirtual 348	java/lang/Exception:toString	()Ljava/lang/String;
    //   775: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: invokestatic 350	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   784: goto -142 -> 642
    //   787: astore 11
    //   789: goto -121 -> 668
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	792	0	this	ForwardQQStoryMsgOption
    //   0	792	1	paramQQCustomDialog	QQCustomDialog
    //   25	197	2	i	int
    //   35	444	3	j	int
    //   45	440	4	k	int
    //   56	507	5	m	int
    //   67	503	6	n	int
    //   74	370	7	i1	int
    //   87	611	8	localObject1	java.lang.Object
    //   704	15	8	localException1	Exception
    //   726	15	8	localException2	Exception
    //   106	590	9	localObject2	java.lang.Object
    //   125	575	10	localObject3	java.lang.Object
    //   137	355	11	localObject4	java.lang.Object
    //   662	27	11	localException3	Exception
    //   787	1	11	localException4	Exception
    //   169	525	12	localObject5	java.lang.Object
    //   182	416	13	localURLImageView1	com.tencent.image.URLImageView
    //   150	363	14	localURLImageView2	com.tencent.image.URLImageView
    //   203	111	15	localLayoutParams	android.widget.RelativeLayout.LayoutParams
    //   250	96	16	localTextView	android.widget.TextView
    //   278	54	17	localLayoutParams1	android.widget.LinearLayout.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   361	387	662	java/lang/Exception
    //   439	512	704	java/lang/Exception
    //   512	519	704	java/lang/Exception
    //   519	597	726	java/lang/Exception
    //   597	604	726	java/lang/Exception
    //   604	642	748	java/lang/Exception
    //   387	397	787	java/lang/Exception
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetScrollView != null) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetScrollView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "removeLayoutListener:", localException);
    }
  }
  
  protected boolean m()
  {
    return false;
  }
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_AndroidWidgetScrollView != null) {
      this.jdField_a_of_type_AndroidWidgetScrollView.post(new ForwardQQStoryMsgOption.1(this));
    }
  }
  
  protected void s()
  {
    super.s();
    e();
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      a("cancel", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgAction, this.jdField_a_of_type_AndroidAppActivity);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "forwardOnCancel");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQQStoryMsgOption
 * JD-Core Version:    0.7.0.1
 */