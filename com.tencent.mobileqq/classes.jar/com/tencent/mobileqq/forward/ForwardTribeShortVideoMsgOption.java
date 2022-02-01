package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ForwardTribeShortVideoMsgOption
  extends ForwardStructingMsgOption
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  protected ScrollView a;
  protected String i;
  
  public ForwardTribeShortVideoMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected void a()
  {
    int j = c();
    String str = "";
    if (j != 0) {
      str = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", str);
    e();
    super.a();
  }
  
  public boolean a()
  {
    super.a();
    this.i = this.jdField_a_of_type_AndroidOsBundle.getString("qqtribeVideoInfoExtra ");
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("stuctmsg_bytes"));
    if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof AbsShareMsg))) {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localAbsStructMsg);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 3);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mTribeShortVideoExtra = this.i;
    }
    return true;
  }
  
  /* Error */
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 90	com/tencent/mobileqq/utils/QQCustomDialog:getWindow	()Landroid/view/Window;
    //   4: bipush 19
    //   6: invokevirtual 96	android/view/Window:setSoftInputMode	(I)V
    //   9: aload_0
    //   10: getfield 74	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   13: ifnull +478 -> 491
    //   16: aload_0
    //   17: getfield 99	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   20: ldc 100
    //   22: invokestatic 105	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   25: istore_2
    //   26: aload_0
    //   27: getfield 99	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   30: ldc 106
    //   32: invokestatic 105	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   35: istore_3
    //   36: aload_0
    //   37: getfield 99	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   40: ldc 107
    //   42: invokestatic 105	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   45: istore 4
    //   47: aload_0
    //   48: getfield 99	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   51: ldc 108
    //   53: invokestatic 105	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   56: istore 5
    //   58: aload_0
    //   59: getfield 99	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   62: ldc 109
    //   64: invokestatic 105	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   67: istore 6
    //   69: ldc 111
    //   71: invokestatic 117	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   74: istore 7
    //   76: new 119	android/widget/LinearLayout
    //   79: dup
    //   80: aload_0
    //   81: getfield 99	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   84: invokespecial 122	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   87: astore 9
    //   89: aload 9
    //   91: iconst_1
    //   92: invokevirtual 125	android/widget/LinearLayout:setOrientation	(I)V
    //   95: new 127	android/widget/LinearLayout$LayoutParams
    //   98: dup
    //   99: bipush 254
    //   101: bipush 254
    //   103: invokespecial 130	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   106: astore 10
    //   108: aload 10
    //   110: iconst_1
    //   111: putfield 134	android/widget/LinearLayout$LayoutParams:gravity	I
    //   114: new 136	android/widget/RelativeLayout
    //   117: dup
    //   118: aload_0
    //   119: getfield 99	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   122: invokespecial 137	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   125: astore 11
    //   127: new 127	android/widget/LinearLayout$LayoutParams
    //   130: dup
    //   131: iload_3
    //   132: iload 4
    //   134: invokespecial 130	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   137: astore 12
    //   139: new 139	com/tencent/image/URLImageView
    //   142: dup
    //   143: aload_0
    //   144: getfield 99	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   147: invokespecial 140	com/tencent/image/URLImageView:<init>	(Landroid/content/Context;)V
    //   150: astore 8
    //   152: aload 8
    //   154: getstatic 146	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   157: invokevirtual 150	com/tencent/image/URLImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   160: new 152	android/widget/RelativeLayout$LayoutParams
    //   163: dup
    //   164: iconst_m1
    //   165: iconst_m1
    //   166: invokespecial 153	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   169: astore 13
    //   171: new 152	android/widget/RelativeLayout$LayoutParams
    //   174: dup
    //   175: iload 5
    //   177: iload 6
    //   179: invokespecial 153	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   182: astore 14
    //   184: aload 14
    //   186: bipush 9
    //   188: invokevirtual 156	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   191: aload 14
    //   193: bipush 10
    //   195: invokevirtual 156	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   198: aload 14
    //   200: iload_2
    //   201: putfield 159	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   204: aload 14
    //   206: aload_0
    //   207: getfield 99	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   210: ldc 160
    //   212: invokestatic 105	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   215: putfield 163	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   218: new 165	android/widget/TextView
    //   221: dup
    //   222: aload_0
    //   223: getfield 99	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   226: invokespecial 166	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   229: astore 14
    //   231: aload 14
    //   233: ldc 167
    //   235: invokevirtual 170	android/widget/TextView:setTextColor	(I)V
    //   238: aload 14
    //   240: iconst_1
    //   241: ldc 100
    //   243: invokevirtual 174	android/widget/TextView:setTextSize	(IF)V
    //   246: new 127	android/widget/LinearLayout$LayoutParams
    //   249: dup
    //   250: bipush 254
    //   252: bipush 254
    //   254: invokespecial 130	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   257: astore 15
    //   259: aload 15
    //   261: aload_0
    //   262: getfield 99	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   265: ldc 175
    //   267: invokestatic 105	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   270: putfield 176	android/widget/LinearLayout$LayoutParams:topMargin	I
    //   273: aload 15
    //   275: iconst_3
    //   276: putfield 134	android/widget/LinearLayout$LayoutParams:gravity	I
    //   279: aload 11
    //   281: aload 8
    //   283: aload 13
    //   285: invokevirtual 180	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   288: aload 9
    //   290: aload 11
    //   292: aload 12
    //   294: invokevirtual 181	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   297: aload 9
    //   299: aload 14
    //   301: aload 15
    //   303: invokevirtual 181	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   306: aload_1
    //   307: aload 9
    //   309: aload 10
    //   311: invokevirtual 184	com/tencent/mobileqq/utils/QQCustomDialog:addView	(Landroid/view/View;Landroid/widget/LinearLayout$LayoutParams;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   314: pop
    //   315: aload 14
    //   317: aload_0
    //   318: getfield 74	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   321: getfield 187	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceName	Ljava/lang/String;
    //   324: invokevirtual 191	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   327: aload_0
    //   328: getfield 74	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   331: getfield 194	com/tencent/mobileqq/structmsg/AbsShareMsg:mContentCover	Ljava/lang/String;
    //   334: astore 9
    //   336: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +34 -> 373
    //   342: ldc 201
    //   344: iconst_2
    //   345: new 203	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   352: ldc 207
    //   354: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_0
    //   358: getfield 74	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   361: getfield 83	com/tencent/mobileqq/structmsg/AbsShareMsg:mTribeShortVideoExtra	Ljava/lang/String;
    //   364: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: new 220	android/graphics/drawable/ColorDrawable
    //   376: dup
    //   377: iload 7
    //   379: invokespecial 222	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   382: astore 10
    //   384: aload 8
    //   386: aload 10
    //   388: invokevirtual 226	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   391: invokestatic 232	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   394: astore 11
    //   396: aload 11
    //   398: aload 10
    //   400: putfield 236	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   403: aload 11
    //   405: aload 10
    //   407: putfield 239	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   410: aload 11
    //   412: iload_3
    //   413: putfield 242	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   416: aload 11
    //   418: iload 4
    //   420: putfield 245	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   423: aload 9
    //   425: aload 11
    //   427: invokestatic 251	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   430: astore 9
    //   432: aload 9
    //   434: invokevirtual 254	com/tencent/image/URLDrawable:getStatus	()I
    //   437: iconst_2
    //   438: if_icmpne +8 -> 446
    //   441: aload 9
    //   443: invokevirtual 257	com/tencent/image/URLDrawable:restartDownload	()V
    //   446: aload 8
    //   448: aload 9
    //   450: invokevirtual 226	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   453: aload_0
    //   454: aload_1
    //   455: invokevirtual 90	com/tencent/mobileqq/utils/QQCustomDialog:getWindow	()Landroid/view/Window;
    //   458: invokevirtual 261	android/view/Window:getDecorView	()Landroid/view/View;
    //   461: ldc_w 262
    //   464: invokevirtual 268	android/view/View:findViewById	(I)Landroid/view/View;
    //   467: checkcast 270	android/widget/ScrollView
    //   470: putfield 272	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidWidgetScrollView	Landroid/widget/ScrollView;
    //   473: aload_0
    //   474: getfield 272	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidWidgetScrollView	Landroid/widget/ScrollView;
    //   477: ifnull +14 -> 491
    //   480: aload_0
    //   481: getfield 272	com/tencent/mobileqq/forward/ForwardTribeShortVideoMsgOption:jdField_a_of_type_AndroidWidgetScrollView	Landroid/widget/ScrollView;
    //   484: invokevirtual 276	android/widget/ScrollView:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   487: aload_0
    //   488: invokevirtual 282	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   491: iconst_1
    //   492: ireturn
    //   493: astore 8
    //   495: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   498: ifeq -45 -> 453
    //   501: ldc_w 284
    //   504: iconst_2
    //   505: ldc 207
    //   507: aload 8
    //   509: invokestatic 288	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   512: goto -59 -> 453
    //   515: astore_1
    //   516: invokestatic 199	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq -28 -> 491
    //   522: ldc_w 284
    //   525: iconst_2
    //   526: new 203	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   533: ldc 207
    //   535: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_1
    //   539: invokevirtual 289	java/lang/Exception:toString	()Ljava/lang/String;
    //   542: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 291	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: goto -60 -> 491
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	this	ForwardTribeShortVideoMsgOption
    //   0	554	1	paramQQCustomDialog	QQCustomDialog
    //   25	176	2	j	int
    //   35	378	3	k	int
    //   45	374	4	m	int
    //   56	120	5	n	int
    //   67	111	6	i1	int
    //   74	304	7	i2	int
    //   150	297	8	localURLImageView	com.tencent.image.URLImageView
    //   493	15	8	localException	Exception
    //   87	362	9	localObject1	java.lang.Object
    //   106	300	10	localObject2	java.lang.Object
    //   125	301	11	localObject3	java.lang.Object
    //   137	156	12	localLayoutParams1	android.widget.LinearLayout.LayoutParams
    //   169	115	13	localLayoutParams	android.widget.RelativeLayout.LayoutParams
    //   182	134	14	localObject4	java.lang.Object
    //   257	45	15	localLayoutParams2	android.widget.LinearLayout.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   373	446	493	java/lang/Exception
    //   446	453	493	java/lang/Exception
    //   453	491	515	java/lang/Exception
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
      this.jdField_a_of_type_AndroidWidgetScrollView.post(new ForwardTribeShortVideoMsgOption.1(this));
    }
  }
  
  protected void s()
  {
    super.s();
    e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "forwardOnCancel");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTribeShortVideoMsgOption
 * JD-Core Version:    0.7.0.1
 */