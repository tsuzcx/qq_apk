package com.tencent.mobileqq.search.fragment;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.Arrays;
import java.util.List;

class ActiveEntitySearchFragment$1
  extends UnifySearchObserver
{
  ActiveEntitySearchFragment$1(ActiveEntitySearchFragment paramActiveEntitySearchFragment) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (!this.a.isAdded())
    {
      paramArrayOfLong = ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unify handleTabSearchError, fragment is detached ..., reqKeyword=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" isFirstReq=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" reqTime=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" resultCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" errorMsg=");
      localStringBuilder.append(paramString3);
      QLog.e(paramArrayOfLong, 1, localStringBuilder.toString());
      return;
    }
    if (!TextUtils.equals(paramString2, this.a.jdField_d_of_type_JavaLangString)) {
      return;
    }
    if (ActiveEntitySearchFragment.a(this.a.jdField_a_of_type_ArrayOfLong, paramArrayOfLong))
    {
      if (!this.a.jdField_b_of_type_JavaLangString.equals(paramString1)) {
        return;
      }
      this.a.jdField_e_of_type_AndroidViewView.setVisibility(8);
      paramString2 = this.a;
      paramString2.jdField_e_of_type_Boolean = false;
      paramString2.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (!this.a.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ActiveEntitySearchFragment.1.3(this));
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.a.g.setVisibility(0);
        if (this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          try
          {
            this.a.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.a.getResources(), 2130842420);
            this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.a.jdField_a_of_type_AndroidGraphicsBitmap);
          }
          catch (OutOfMemoryError paramString2)
          {
            QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 1, paramString2, new Object[0]);
          }
        }
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131699994));
        this.a.g.setOnClickListener(new ActiveEntitySearchFragment.1.2(this));
      }
      if (QLog.isColorLevel())
      {
        paramString2 = ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString;
        paramString3 = new StringBuilder();
        paramString3.append("Unify handleTabSearchError code=");
        paramString3.append(paramInt);
        paramString3.append(" mask;");
        paramString3.append(Arrays.toString(paramArrayOfLong));
        paramString3.append(" key=");
        paramString3.append(paramString1);
        paramString3.append(" name=");
        paramString3.append(this.a.jdField_e_of_type_JavaLangString);
        QLog.w(paramString2, 2, paramString3.toString());
      }
    }
  }
  
  /* Error */
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<com.tencent.mobileqq.search.model.ISearchResultGroupModel> paramList, long[] paramArrayOfLong, String paramString3, List<tencent.im.oidb.search.DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   4: invokevirtual 23	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:isAdded	()Z
    //   7: ifne +117 -> 124
    //   10: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   13: astore 4
    //   15: new 28	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   22: astore 6
    //   24: aload 6
    //   26: ldc 198
    //   28: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 6
    //   34: aload_1
    //   35: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 6
    //   41: ldc 200
    //   43: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 6
    //   49: aload_0
    //   50: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   53: getfield 77	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 6
    //   62: ldc 42
    //   64: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 6
    //   70: aload_3
    //   71: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 6
    //   77: ldc 202
    //   79: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 6
    //   85: aload_0
    //   86: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   89: getfield 62	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   92: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 6
    //   98: ldc 204
    //   100: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 6
    //   106: iload 5
    //   108: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 4
    //   114: iconst_1
    //   115: aload 6
    //   117: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: return
    //   124: aload_3
    //   125: aload_0
    //   126: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   129: getfield 62	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   132: invokestatic 68	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   135: ifne +117 -> 252
    //   138: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   141: astore 4
    //   143: new 28	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   150: astore 6
    //   152: aload 6
    //   154: ldc 206
    //   156: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 6
    //   162: aload_1
    //   163: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 6
    //   169: ldc 200
    //   171: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 6
    //   177: aload_0
    //   178: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   181: getfield 77	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   184: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 6
    //   190: ldc 42
    //   192: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 6
    //   198: aload_3
    //   199: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 6
    //   205: ldc 202
    //   207: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 6
    //   213: aload_0
    //   214: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   217: getfield 62	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   220: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 6
    //   226: ldc 204
    //   228: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 6
    //   234: iload 5
    //   236: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 4
    //   242: iconst_2
    //   243: aload 6
    //   245: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: return
    //   252: aload_0
    //   253: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   256: getfield 71	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   259: aload 7
    //   261: invokestatic 74	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	([J[J)Z
    //   264: ifeq +3482 -> 3746
    //   267: aload_1
    //   268: aload_0
    //   269: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   272: getfield 77	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   275: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifne +6 -> 284
    //   281: goto +3465 -> 3746
    //   284: aload 6
    //   286: ifnonnull +63 -> 349
    //   289: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +44 -> 336
    //   295: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   298: astore 4
    //   300: new 28	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   307: astore 8
    //   309: aload 8
    //   311: ldc 210
    //   313: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 8
    //   319: aload 6
    //   321: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 4
    //   327: iconst_2
    //   328: aload 8
    //   330: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload_0
    //   337: aload_1
    //   338: iload_2
    //   339: aload_3
    //   340: iconst_m1
    //   341: ldc 218
    //   343: aload 7
    //   345: invokevirtual 220	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	(Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;[J)V
    //   348: return
    //   349: iload 12
    //   351: iconst_2
    //   352: if_icmpne +166 -> 518
    //   355: aload_0
    //   356: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   359: getfield 85	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   362: bipush 8
    //   364: invokevirtual 91	android/view/View:setVisibility	(I)V
    //   367: aload_0
    //   368: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   371: astore_1
    //   372: aload_1
    //   373: iconst_0
    //   374: putfield 94	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_Boolean	Z
    //   377: aload_1
    //   378: getfield 96	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   381: bipush 8
    //   383: invokevirtual 91	android/view/View:setVisibility	(I)V
    //   386: aload_0
    //   387: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   390: getfield 222	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   393: bipush 8
    //   395: invokevirtual 125	com/tencent/widget/XListView:setVisibility	(I)V
    //   398: aload_0
    //   399: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   402: getfield 225	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   405: bipush 8
    //   407: invokevirtual 228	android/widget/Button:setVisibility	(I)V
    //   410: aload_0
    //   411: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   414: getfield 231	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:c	Landroid/widget/TextView;
    //   417: bipush 8
    //   419: invokevirtual 110	android/widget/TextView:setVisibility	(I)V
    //   422: aload_0
    //   423: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   426: getfield 128	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Landroid/view/View;
    //   429: iconst_0
    //   430: invokevirtual 91	android/view/View:setVisibility	(I)V
    //   433: aload_0
    //   434: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   437: invokevirtual 23	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:isAdded	()Z
    //   440: ifeq +41 -> 481
    //   443: aload_0
    //   444: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   447: getfield 145	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   450: aload_0
    //   451: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   454: invokevirtual 135	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   457: ldc 232
    //   459: invokestatic 142	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   462: invokevirtual 151	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   465: goto +16 -> 481
    //   468: astore_1
    //   469: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   472: iconst_1
    //   473: aload_1
    //   474: iconst_0
    //   475: anewarray 153	java/lang/Object
    //   478: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   481: iconst_2
    //   482: iload 12
    //   484: if_icmpne +16 -> 500
    //   487: aload_0
    //   488: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   491: ldc 233
    //   493: invokevirtual 236	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getString	(I)Ljava/lang/String;
    //   496: astore_1
    //   497: goto +9 -> 506
    //   500: ldc 237
    //   502: invokestatic 164	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   505: astore_1
    //   506: aload_0
    //   507: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   510: getfield 158	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   513: aload_1
    //   514: invokevirtual 168	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   517: return
    //   518: new 239	java/util/HashSet
    //   521: dup
    //   522: invokespecial 240	java/util/HashSet:<init>	()V
    //   525: astore_3
    //   526: aload 6
    //   528: invokeinterface 244 1 0
    //   533: astore 27
    //   535: ldc2_w 245
    //   538: lstore 19
    //   540: lload 19
    //   542: lstore 21
    //   544: iconst_0
    //   545: istore 12
    //   547: aload 27
    //   549: invokeinterface 251 1 0
    //   554: ifeq +351 -> 905
    //   557: aload 27
    //   559: invokeinterface 255 1 0
    //   564: checkcast 257	com/tencent/mobileqq/search/model/ISearchResultGroupModel
    //   567: astore 28
    //   569: iload 12
    //   571: istore 13
    //   573: lload 19
    //   575: lstore 25
    //   577: lload 21
    //   579: lstore 23
    //   581: aload 28
    //   583: invokeinterface 260 1 0
    //   588: ifnull +302 -> 890
    //   591: aload 28
    //   593: instanceof 262
    //   596: ifeq +269 -> 865
    //   599: aload 28
    //   601: checkcast 262	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel
    //   604: astore 29
    //   606: aload 29
    //   608: invokevirtual 263	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	()Ljava/util/List;
    //   611: astore 30
    //   613: aload 30
    //   615: invokeinterface 244 1 0
    //   620: astore 31
    //   622: aload 31
    //   624: invokeinterface 251 1 0
    //   629: ifeq +61 -> 690
    //   632: aload 31
    //   634: invokeinterface 255 1 0
    //   639: checkcast 265	com/tencent/mobileqq/search/model/ISearchResultModel
    //   642: astore 32
    //   644: aload 32
    //   646: instanceof 267
    //   649: ifeq +38 -> 687
    //   652: aload 32
    //   654: checkcast 267	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem
    //   657: astore 32
    //   659: getstatic 271	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:b	Z
    //   662: ifeq +9 -> 671
    //   665: aload 32
    //   667: iconst_1
    //   668: putfield 275	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:o	I
    //   671: aload_3
    //   672: aload 32
    //   674: invokevirtual 278	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:d	()I
    //   677: i2l
    //   678: invokestatic 284	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   681: invokeinterface 289 2 0
    //   686: pop
    //   687: goto -65 -> 622
    //   690: lload 19
    //   692: lstore 21
    //   694: lload 19
    //   696: ldc2_w 245
    //   699: lcmp
    //   700: ifne +10 -> 710
    //   703: aload 29
    //   705: getfield 292	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   708: lstore 21
    //   710: aload 29
    //   712: getfield 292	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   715: lstore 25
    //   717: aload 30
    //   719: invokeinterface 295 1 0
    //   724: ifle +59 -> 783
    //   727: aload 29
    //   729: getfield 292	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   732: ldc2_w 296
    //   735: lcmp
    //   736: ifne +47 -> 783
    //   739: aconst_null
    //   740: ldc_w 299
    //   743: ldc_w 301
    //   746: ldc_w 301
    //   749: ldc_w 303
    //   752: ldc_w 303
    //   755: iconst_1
    //   756: iconst_0
    //   757: ldc_w 301
    //   760: ldc_w 301
    //   763: ldc_w 301
    //   766: ldc_w 301
    //   769: invokestatic 308	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   772: lload 25
    //   774: lstore 23
    //   776: lload 21
    //   778: lstore 19
    //   780: goto +89 -> 869
    //   783: lload 25
    //   785: lstore 23
    //   787: lload 21
    //   789: lstore 19
    //   791: aload 30
    //   793: invokeinterface 295 1 0
    //   798: ifle +71 -> 869
    //   801: lload 25
    //   803: lstore 23
    //   805: lload 21
    //   807: lstore 19
    //   809: aload 29
    //   811: getfield 292	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   814: ldc2_w 309
    //   817: lcmp
    //   818: ifne +51 -> 869
    //   821: aconst_null
    //   822: ldc_w 299
    //   825: ldc_w 301
    //   828: ldc_w 301
    //   831: ldc_w 303
    //   834: ldc_w 303
    //   837: iconst_2
    //   838: iconst_0
    //   839: ldc_w 301
    //   842: ldc_w 301
    //   845: ldc_w 301
    //   848: ldc_w 301
    //   851: invokestatic 308	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   854: lload 25
    //   856: lstore 23
    //   858: lload 21
    //   860: lstore 19
    //   862: goto +7 -> 869
    //   865: lload 21
    //   867: lstore 23
    //   869: iload 12
    //   871: aload 28
    //   873: invokeinterface 260 1 0
    //   878: invokeinterface 295 1 0
    //   883: iadd
    //   884: istore 13
    //   886: lload 19
    //   888: lstore 25
    //   890: iload 13
    //   892: istore 12
    //   894: lload 25
    //   896: lstore 19
    //   898: lload 23
    //   900: lstore 21
    //   902: goto -355 -> 547
    //   905: aload_0
    //   906: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   909: getfield 312	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   912: aload_3
    //   913: invokeinterface 316 2 0
    //   918: pop
    //   919: aload_0
    //   920: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   923: aload 8
    //   925: invokestatic 319	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;Ljava/lang/String;)Ljava/lang/String;
    //   928: pop
    //   929: aload_0
    //   930: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   933: aload 9
    //   935: invokestatic 322	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;Ljava/util/List;)Ljava/util/List;
    //   938: pop
    //   939: ldc_w 301
    //   942: astore 27
    //   944: iload_2
    //   945: ifne +77 -> 1022
    //   948: new 324	java/util/ArrayList
    //   951: dup
    //   952: invokespecial 325	java/util/ArrayList:<init>	()V
    //   955: astore 8
    //   957: aload 8
    //   959: aload_3
    //   960: invokeinterface 316 2 0
    //   965: pop
    //   966: ldc_w 327
    //   969: ldc_w 329
    //   972: iconst_4
    //   973: anewarray 79	java/lang/String
    //   976: dup
    //   977: iconst_0
    //   978: aload_0
    //   979: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   982: getfield 77	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   985: aastore
    //   986: dup
    //   987: iconst_1
    //   988: aload 8
    //   990: invokestatic 334	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/List;)Ljava/lang/String;
    //   993: aastore
    //   994: dup
    //   995: iconst_2
    //   996: ldc_w 301
    //   999: aastore
    //   1000: dup
    //   1001: iconst_3
    //   1002: ldc_w 336
    //   1005: aload_0
    //   1006: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1009: getfield 71	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   1012: invokestatic 339	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1015: aastore
    //   1016: invokestatic 342	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1019: goto +3 -> 1022
    //   1022: aload_0
    //   1023: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1026: getfield 99	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1029: astore_3
    //   1030: aload_0
    //   1031: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1034: getfield 71	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   1037: astore 8
    //   1039: aload_0
    //   1040: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1043: getfield 190	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1046: astore 9
    //   1048: aload_0
    //   1049: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1052: getfield 77	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1055: astore 28
    //   1057: aload_3
    //   1058: aload 6
    //   1060: iload_2
    //   1061: iconst_1
    //   1062: ixor
    //   1063: aload 8
    //   1065: aload 9
    //   1067: aload 28
    //   1069: invokestatic 347	com/tencent/mobileqq/search/util/ReportUtil:a	(Ljava/util/List;Ljava/util/List;Z[JLjava/lang/String;Ljava/lang/String;)V
    //   1072: iload 12
    //   1074: ifne +163 -> 1237
    //   1077: aload_0
    //   1078: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1081: invokevirtual 351	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1084: instanceof 353
    //   1087: ifeq +147 -> 1234
    //   1090: aload_0
    //   1091: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1094: invokevirtual 351	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1097: checkcast 353	com/tencent/mobileqq/search/base/api/SearchInfoInterface
    //   1100: invokeinterface 355 1 0
    //   1105: istore 13
    //   1107: iload 13
    //   1109: iconst_1
    //   1110: if_icmpeq +68 -> 1178
    //   1113: iload 13
    //   1115: iconst_3
    //   1116: if_icmpeq +6 -> 1122
    //   1119: goto +115 -> 1234
    //   1122: ldc_w 327
    //   1125: ldc_w 357
    //   1128: iconst_4
    //   1129: anewarray 79	java/lang/String
    //   1132: dup
    //   1133: iconst_0
    //   1134: aload_0
    //   1135: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1138: getfield 77	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1141: aastore
    //   1142: dup
    //   1143: iconst_1
    //   1144: aload_0
    //   1145: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1148: getfield 71	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   1151: invokestatic 359	com/tencent/mobileqq/search/util/SearchUtils:a	([J)Ljava/lang/String;
    //   1154: aastore
    //   1155: dup
    //   1156: iconst_2
    //   1157: ldc_w 301
    //   1160: aastore
    //   1161: dup
    //   1162: iconst_3
    //   1163: ldc_w 336
    //   1166: aload 7
    //   1168: invokestatic 339	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1171: aastore
    //   1172: invokestatic 342	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1175: goto +235 -> 1410
    //   1178: ldc_w 361
    //   1181: ldc_w 363
    //   1184: iconst_4
    //   1185: anewarray 79	java/lang/String
    //   1188: dup
    //   1189: iconst_0
    //   1190: aload_0
    //   1191: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1194: getfield 77	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1197: aastore
    //   1198: dup
    //   1199: iconst_1
    //   1200: aload_0
    //   1201: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1204: getfield 71	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   1207: invokestatic 359	com/tencent/mobileqq/search/util/SearchUtils:a	([J)Ljava/lang/String;
    //   1210: aastore
    //   1211: dup
    //   1212: iconst_2
    //   1213: ldc_w 301
    //   1216: aastore
    //   1217: dup
    //   1218: iconst_3
    //   1219: ldc_w 336
    //   1222: aload 7
    //   1224: invokestatic 339	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1227: aastore
    //   1228: invokestatic 342	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1231: goto +179 -> 1410
    //   1234: goto +176 -> 1410
    //   1237: aload_0
    //   1238: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1241: getfield 366	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfByte	[B
    //   1244: ifnonnull +166 -> 1410
    //   1247: aload_0
    //   1248: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1251: invokevirtual 351	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1254: instanceof 353
    //   1257: ifeq +153 -> 1410
    //   1260: aload_0
    //   1261: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1264: invokevirtual 351	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1267: checkcast 353	com/tencent/mobileqq/search/base/api/SearchInfoInterface
    //   1270: astore_3
    //   1271: aload_3
    //   1272: invokeinterface 355 1 0
    //   1277: istore 13
    //   1279: iload 13
    //   1281: iconst_1
    //   1282: if_icmpeq +71 -> 1353
    //   1285: iload 13
    //   1287: iconst_3
    //   1288: if_icmpeq +6 -> 1294
    //   1291: goto +119 -> 1410
    //   1294: ldc_w 327
    //   1297: ldc_w 368
    //   1300: iconst_4
    //   1301: anewarray 79	java/lang/String
    //   1304: dup
    //   1305: iconst_0
    //   1306: aload_3
    //   1307: invokeinterface 370 1 0
    //   1312: aastore
    //   1313: dup
    //   1314: iconst_1
    //   1315: aload_0
    //   1316: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1319: getfield 312	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1322: invokestatic 334	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/List;)Ljava/lang/String;
    //   1325: aastore
    //   1326: dup
    //   1327: iconst_2
    //   1328: ldc_w 301
    //   1331: aastore
    //   1332: dup
    //   1333: iconst_3
    //   1334: ldc_w 336
    //   1337: aload_3
    //   1338: invokeinterface 373 1 0
    //   1343: invokestatic 339	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1346: aastore
    //   1347: invokestatic 342	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1350: goto +60 -> 1410
    //   1353: ldc_w 361
    //   1356: ldc_w 375
    //   1359: iconst_4
    //   1360: anewarray 79	java/lang/String
    //   1363: dup
    //   1364: iconst_0
    //   1365: aload_0
    //   1366: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1369: getfield 77	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1372: aastore
    //   1373: dup
    //   1374: iconst_1
    //   1375: aload_0
    //   1376: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1379: getfield 312	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1382: invokestatic 334	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/List;)Ljava/lang/String;
    //   1385: aastore
    //   1386: dup
    //   1387: iconst_2
    //   1388: ldc_w 301
    //   1391: aastore
    //   1392: dup
    //   1393: iconst_3
    //   1394: ldc_w 377
    //   1397: aload_3
    //   1398: invokeinterface 373 1 0
    //   1403: invokestatic 339	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1406: aastore
    //   1407: invokestatic 342	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1410: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1413: ifeq +103 -> 1516
    //   1416: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1419: astore_3
    //   1420: new 28	java/lang/StringBuilder
    //   1423: dup
    //   1424: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1427: astore 8
    //   1429: aload 8
    //   1431: ldc_w 379
    //   1434: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: pop
    //   1438: aload 8
    //   1440: iload_2
    //   1441: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1444: pop
    //   1445: aload 8
    //   1447: ldc_w 381
    //   1450: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1453: pop
    //   1454: aload 8
    //   1456: aload_0
    //   1457: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1460: getfield 383	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Int	I
    //   1463: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1466: pop
    //   1467: aload 8
    //   1469: ldc_w 385
    //   1472: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: pop
    //   1476: aload 8
    //   1478: aload_0
    //   1479: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1482: getfield 387	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Int	I
    //   1485: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1488: pop
    //   1489: aload 8
    //   1491: ldc_w 389
    //   1494: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: pop
    //   1498: aload 8
    //   1500: iload 12
    //   1502: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1505: pop
    //   1506: aload_3
    //   1507: iconst_2
    //   1508: aload 8
    //   1510: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1513: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1516: aload_0
    //   1517: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1520: getfield 85	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1523: bipush 8
    //   1525: invokevirtual 91	android/view/View:setVisibility	(I)V
    //   1528: aload_0
    //   1529: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1532: getfield 392	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   1535: bipush 8
    //   1537: invokevirtual 91	android/view/View:setVisibility	(I)V
    //   1540: aload_0
    //   1541: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1544: getfield 122	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   1547: iconst_0
    //   1548: invokevirtual 125	com/tencent/widget/XListView:setVisibility	(I)V
    //   1551: aload_0
    //   1552: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1555: getfield 96	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1558: bipush 8
    //   1560: invokevirtual 91	android/view/View:setVisibility	(I)V
    //   1563: aload_0
    //   1564: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1567: astore_3
    //   1568: aload_3
    //   1569: iconst_0
    //   1570: putfield 94	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_Boolean	Z
    //   1573: aload_3
    //   1574: aload 4
    //   1576: putfield 366	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfByte	[B
    //   1579: aload_3
    //   1580: iload 5
    //   1582: putfield 394	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Boolean	Z
    //   1585: aload 11
    //   1587: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1590: ifne +156 -> 1746
    //   1593: new 399	org/json/JSONObject
    //   1596: dup
    //   1597: aload 11
    //   1599: invokespecial 402	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1602: astore 4
    //   1604: aload 4
    //   1606: ldc_w 404
    //   1609: invokevirtual 408	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1612: istore 17
    //   1614: aload 4
    //   1616: ldc_w 410
    //   1619: invokevirtual 414	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1622: astore_3
    //   1623: aload 4
    //   1625: ldc_w 416
    //   1628: invokevirtual 414	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1631: astore 9
    //   1633: aload_3
    //   1634: astore 8
    //   1636: iload 17
    //   1638: istore 18
    //   1640: goto +99 -> 1739
    //   1643: astore 4
    //   1645: goto +21 -> 1666
    //   1648: astore 4
    //   1650: ldc_w 301
    //   1653: astore_3
    //   1654: goto +12 -> 1666
    //   1657: astore 4
    //   1659: ldc_w 301
    //   1662: astore_3
    //   1663: iconst_0
    //   1664: istore 17
    //   1666: aload_3
    //   1667: astore 8
    //   1669: iload 17
    //   1671: istore 18
    //   1673: aload 27
    //   1675: astore 9
    //   1677: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1680: ifeq +59 -> 1739
    //   1683: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1686: astore 8
    //   1688: new 28	java/lang/StringBuilder
    //   1691: dup
    //   1692: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1695: astore 9
    //   1697: aload 9
    //   1699: ldc_w 418
    //   1702: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: pop
    //   1706: aload 9
    //   1708: aload 4
    //   1710: invokestatic 422	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1713: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1716: pop
    //   1717: aload 8
    //   1719: iconst_2
    //   1720: aload 9
    //   1722: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1725: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1728: aload 27
    //   1730: astore 9
    //   1732: iload 17
    //   1734: istore 18
    //   1736: aload_3
    //   1737: astore 8
    //   1739: aload 9
    //   1741: astore 4
    //   1743: goto +31 -> 1774
    //   1746: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1749: ifeq +13 -> 1762
    //   1752: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1755: iconst_2
    //   1756: ldc_w 424
    //   1759: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1762: ldc_w 301
    //   1765: astore 8
    //   1767: aload 8
    //   1769: astore 4
    //   1771: iconst_0
    //   1772: istore 18
    //   1774: iload 5
    //   1776: ifeq +134 -> 1910
    //   1779: aload_0
    //   1780: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1783: getfield 231	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:c	Landroid/widget/TextView;
    //   1786: iconst_0
    //   1787: invokevirtual 110	android/widget/TextView:setVisibility	(I)V
    //   1790: aload_0
    //   1791: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1794: getfield 71	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   1797: ifnull +113 -> 1910
    //   1800: aload_0
    //   1801: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1804: getfield 71	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   1807: arraylength
    //   1808: iconst_2
    //   1809: if_icmpne +101 -> 1910
    //   1812: new 324	java/util/ArrayList
    //   1815: dup
    //   1816: invokespecial 325	java/util/ArrayList:<init>	()V
    //   1819: astore_3
    //   1820: aload_0
    //   1821: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1824: getfield 71	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   1827: astore 9
    //   1829: aload 9
    //   1831: arraylength
    //   1832: istore 14
    //   1834: iconst_0
    //   1835: istore 13
    //   1837: iload 13
    //   1839: iload 14
    //   1841: if_icmpge +27 -> 1868
    //   1844: aload_3
    //   1845: aload 9
    //   1847: iload 13
    //   1849: laload
    //   1850: invokestatic 284	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1853: invokeinterface 425 2 0
    //   1858: pop
    //   1859: iload 13
    //   1861: iconst_1
    //   1862: iadd
    //   1863: istore 13
    //   1865: goto -28 -> 1837
    //   1868: aload_3
    //   1869: ldc2_w 296
    //   1872: invokestatic 284	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1875: invokeinterface 428 2 0
    //   1880: ifeq +30 -> 1910
    //   1883: aload_3
    //   1884: ldc2_w 309
    //   1887: invokestatic 284	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1890: invokeinterface 428 2 0
    //   1895: ifeq +15 -> 1910
    //   1898: aload_0
    //   1899: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1902: getfield 231	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:c	Landroid/widget/TextView;
    //   1905: bipush 8
    //   1907: invokevirtual 110	android/widget/TextView:setVisibility	(I)V
    //   1910: aload_0
    //   1911: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1914: invokestatic 431	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/lang/String;
    //   1917: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1920: ifne +507 -> 2427
    //   1923: aload_0
    //   1924: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1927: invokestatic 434	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/util/List;
    //   1930: invokeinterface 295 1 0
    //   1935: ifle +492 -> 2427
    //   1938: aload_0
    //   1939: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1942: getfield 436	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1945: aload_0
    //   1946: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1949: invokestatic 431	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/lang/String;
    //   1952: invokevirtual 168	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1955: aload_0
    //   1956: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1959: getfield 439	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1962: invokevirtual 444	android/widget/LinearLayout:removeAllViews	()V
    //   1965: aload_0
    //   1966: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1969: invokevirtual 351	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1972: astore 9
    //   1974: aload 9
    //   1976: ifnull +434 -> 2410
    //   1979: aload 9
    //   1981: invokevirtual 449	com/tencent/mobileqq/app/BaseActivity:isFinishing	()Z
    //   1984: ifeq +6 -> 1990
    //   1987: goto +423 -> 2410
    //   1990: aload 9
    //   1992: ldc_w 450
    //   1995: invokestatic 455	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1998: istore 14
    //   2000: aload 9
    //   2002: ldc_w 456
    //   2005: invokestatic 455	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   2008: istore 15
    //   2010: aload 9
    //   2012: fconst_2
    //   2013: invokestatic 455	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   2016: istore 16
    //   2018: new 458	android/graphics/drawable/GradientDrawable
    //   2021: dup
    //   2022: invokespecial 459	android/graphics/drawable/GradientDrawable:<init>	()V
    //   2025: astore 11
    //   2027: aload 11
    //   2029: aload_0
    //   2030: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2033: invokevirtual 351	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2036: ldc_w 460
    //   2039: invokestatic 455	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   2042: i2f
    //   2043: invokevirtual 464	android/graphics/drawable/GradientDrawable:setCornerRadius	(F)V
    //   2046: ldc_w 466
    //   2049: invokestatic 472	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   2052: istore 13
    //   2054: invokestatic 478	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2057: invokevirtual 482	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   2060: invokestatic 488	com/tencent/mobileqq/vas/theme/api/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   2063: istore 17
    //   2065: iload 17
    //   2067: ifeq +11 -> 2078
    //   2070: ldc_w 490
    //   2073: invokestatic 472	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   2076: istore 13
    //   2078: aload 11
    //   2080: iconst_1
    //   2081: iload 13
    //   2083: invokevirtual 494	android/graphics/drawable/GradientDrawable:setStroke	(II)V
    //   2086: aload_0
    //   2087: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2090: invokestatic 434	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/util/List;
    //   2093: invokeinterface 244 1 0
    //   2098: astore_3
    //   2099: aload_3
    //   2100: invokeinterface 251 1 0
    //   2105: ifeq +207 -> 2312
    //   2108: aload_3
    //   2109: invokeinterface 255 1 0
    //   2114: checkcast 496	tencent/im/oidb/search/DynamicTabSearch$SubHotWord
    //   2117: astore 27
    //   2119: aload 27
    //   2121: getfield 500	tencent/im/oidb/search/DynamicTabSearch$SubHotWord:show_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2124: invokevirtual 506	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2127: invokevirtual 511	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2130: astore 28
    //   2132: aload 28
    //   2134: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2137: ifeq +6 -> 2143
    //   2140: goto -41 -> 2099
    //   2143: new 109	android/widget/TextView
    //   2146: dup
    //   2147: aload 9
    //   2149: invokespecial 514	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2152: astore 29
    //   2154: new 516	android/widget/LinearLayout$LayoutParams
    //   2157: dup
    //   2158: bipush 254
    //   2160: bipush 254
    //   2162: invokespecial 518	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   2165: astore 30
    //   2167: aload 30
    //   2169: iload 14
    //   2171: putfield 521	android/widget/LinearLayout$LayoutParams:rightMargin	I
    //   2174: aload 29
    //   2176: iload 15
    //   2178: iload 16
    //   2180: iload 15
    //   2182: iload 16
    //   2184: invokevirtual 525	android/widget/TextView:setPadding	(IIII)V
    //   2187: ldc_w 527
    //   2190: invokestatic 472	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   2193: istore 13
    //   2195: iload 17
    //   2197: ifeq +11 -> 2208
    //   2200: ldc_w 490
    //   2203: invokestatic 472	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   2206: istore 13
    //   2208: aload 29
    //   2210: iload 13
    //   2212: invokevirtual 530	android/widget/TextView:setTextColor	(I)V
    //   2215: getstatic 535	android/os/Build$VERSION:SDK_INT	I
    //   2218: bipush 16
    //   2220: if_icmpge +16 -> 2236
    //   2223: aload 29
    //   2225: aload 11
    //   2227: invokevirtual 541	android/graphics/drawable/Drawable:mutate	()Landroid/graphics/drawable/Drawable;
    //   2230: invokevirtual 545	android/widget/TextView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2233: goto +13 -> 2246
    //   2236: aload 29
    //   2238: aload 11
    //   2240: invokevirtual 541	android/graphics/drawable/Drawable:mutate	()Landroid/graphics/drawable/Drawable;
    //   2243: invokevirtual 548	android/widget/TextView:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   2246: aload 29
    //   2248: aload 28
    //   2250: invokevirtual 168	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2253: aload 29
    //   2255: bipush 17
    //   2257: invokevirtual 551	android/widget/TextView:setGravity	(I)V
    //   2260: aload 29
    //   2262: iconst_1
    //   2263: ldc_w 552
    //   2266: invokevirtual 556	android/widget/TextView:setTextSize	(IF)V
    //   2269: aload 29
    //   2271: aload 28
    //   2273: invokevirtual 559	android/widget/TextView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2276: aload 29
    //   2278: aload_0
    //   2279: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2282: invokevirtual 119	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2285: aload 29
    //   2287: ldc_w 560
    //   2290: aload 27
    //   2292: invokevirtual 564	android/widget/TextView:setTag	(ILjava/lang/Object;)V
    //   2295: aload_0
    //   2296: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2299: getfield 439	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2302: aload 29
    //   2304: aload 30
    //   2306: invokevirtual 568	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2309: goto -210 -> 2099
    //   2312: aload_0
    //   2313: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2316: getfield 439	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2319: invokevirtual 571	android/widget/LinearLayout:getChildCount	()I
    //   2322: ifne +22 -> 2344
    //   2325: aload_0
    //   2326: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2329: getfield 573	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   2332: bipush 8
    //   2334: invokevirtual 91	android/view/View:setVisibility	(I)V
    //   2337: iload 12
    //   2339: istore 14
    //   2341: goto +102 -> 2443
    //   2344: aload_0
    //   2345: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2348: getfield 99	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2351: ifnull +18 -> 2369
    //   2354: aload_0
    //   2355: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2358: getfield 99	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2361: invokeinterface 104 1 0
    //   2366: ifeq +26 -> 2392
    //   2369: iload 12
    //   2371: istore 14
    //   2373: aload 6
    //   2375: ifnull +68 -> 2443
    //   2378: iload 12
    //   2380: istore 14
    //   2382: aload 6
    //   2384: invokeinterface 104 1 0
    //   2389: ifne +54 -> 2443
    //   2392: aload_0
    //   2393: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2396: getfield 573	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   2399: iconst_0
    //   2400: invokevirtual 91	android/view/View:setVisibility	(I)V
    //   2403: iload 12
    //   2405: istore 14
    //   2407: goto +36 -> 2443
    //   2410: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2413: ifeq +13 -> 2426
    //   2416: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2419: iconst_2
    //   2420: ldc_w 575
    //   2423: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2426: return
    //   2427: aload_0
    //   2428: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2431: getfield 573	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   2434: bipush 8
    //   2436: invokevirtual 91	android/view/View:setVisibility	(I)V
    //   2439: iload 12
    //   2441: istore 14
    //   2443: aload_0
    //   2444: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2447: getfield 99	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2450: ifnull +308 -> 2758
    //   2453: aload_0
    //   2454: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2457: getfield 99	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2460: invokeinterface 104 1 0
    //   2465: ifne +293 -> 2758
    //   2468: aload 6
    //   2470: iload_2
    //   2471: aload_0
    //   2472: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2475: getfield 577	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_Boolean	Z
    //   2478: invokestatic 582	com/tencent/mobileqq/search/SearchUtil:a	(Ljava/util/List;ZZ)Ljava/util/List;
    //   2481: astore_3
    //   2482: iload_2
    //   2483: ifne +233 -> 2716
    //   2486: lload 19
    //   2488: aload_0
    //   2489: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2492: invokestatic 585	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)J
    //   2495: lcmp
    //   2496: ifne +220 -> 2716
    //   2499: iload 10
    //   2501: ifne +215 -> 2716
    //   2504: aload_3
    //   2505: ifnull +211 -> 2716
    //   2508: aload_3
    //   2509: invokeinterface 295 1 0
    //   2514: ifle +202 -> 2716
    //   2517: aload_0
    //   2518: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2521: getfield 99	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2524: aload_0
    //   2525: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2528: getfield 99	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2531: invokeinterface 295 1 0
    //   2536: iconst_1
    //   2537: isub
    //   2538: invokeinterface 588 2 0
    //   2543: checkcast 590	com/tencent/mobileqq/search/model/IModel
    //   2546: astore 4
    //   2548: aload_3
    //   2549: iconst_0
    //   2550: invokeinterface 593 2 0
    //   2555: pop
    //   2556: iconst_0
    //   2557: istore 12
    //   2559: iconst_0
    //   2560: istore 13
    //   2562: iload 13
    //   2564: aload_3
    //   2565: invokeinterface 295 1 0
    //   2570: if_icmpge +40 -> 2610
    //   2573: aload_3
    //   2574: iload 13
    //   2576: invokeinterface 588 2 0
    //   2581: checkcast 590	com/tencent/mobileqq/search/model/IModel
    //   2584: instanceof 595
    //   2587: ifeq +6 -> 2593
    //   2590: goto +24 -> 2614
    //   2593: iload 13
    //   2595: iconst_1
    //   2596: iadd
    //   2597: istore 15
    //   2599: iload 13
    //   2601: istore 12
    //   2603: iload 15
    //   2605: istore 13
    //   2607: goto -45 -> 2562
    //   2610: iload 12
    //   2612: istore 13
    //   2614: aload 4
    //   2616: instanceof 265
    //   2619: ifeq +36 -> 2655
    //   2622: aload 4
    //   2624: checkcast 265	com/tencent/mobileqq/search/model/ISearchResultModel
    //   2627: astore 4
    //   2629: aload 4
    //   2631: invokeinterface 597 1 0
    //   2636: istore 12
    //   2638: aload 4
    //   2640: iload 12
    //   2642: iload 13
    //   2644: iadd
    //   2645: iload 12
    //   2647: iconst_1
    //   2648: isub
    //   2649: invokestatic 602	com/tencent/mobileqq/search/base/util/SearchViewUtils:a	(Lcom/tencent/mobileqq/search/model/ISearchResultModel;II)V
    //   2652: goto +6 -> 2658
    //   2655: iconst_0
    //   2656: istore 12
    //   2658: iconst_0
    //   2659: istore 15
    //   2661: iload 15
    //   2663: iload 13
    //   2665: if_icmpge +51 -> 2716
    //   2668: aload_3
    //   2669: iload 15
    //   2671: invokeinterface 588 2 0
    //   2676: checkcast 590	com/tencent/mobileqq/search/model/IModel
    //   2679: astore 4
    //   2681: aload 4
    //   2683: instanceof 265
    //   2686: ifeq +21 -> 2707
    //   2689: aload 4
    //   2691: checkcast 265	com/tencent/mobileqq/search/model/ISearchResultModel
    //   2694: iload 12
    //   2696: iload 13
    //   2698: iadd
    //   2699: iload 12
    //   2701: iload 15
    //   2703: iadd
    //   2704: invokestatic 602	com/tencent/mobileqq/search/base/util/SearchViewUtils:a	(Lcom/tencent/mobileqq/search/model/ISearchResultModel;II)V
    //   2707: iload 15
    //   2709: iconst_1
    //   2710: iadd
    //   2711: istore 15
    //   2713: goto -52 -> 2661
    //   2716: aload_0
    //   2717: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2720: aload_3
    //   2721: invokevirtual 605	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Ljava/util/List;)V
    //   2724: aload_0
    //   2725: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2728: getfield 99	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2731: aload_3
    //   2732: invokeinterface 316 2 0
    //   2737: pop
    //   2738: aload_0
    //   2739: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2742: getfield 608	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter	Lcom/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter;
    //   2745: aload_0
    //   2746: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2749: getfield 99	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2752: invokevirtual 611	com/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter:a	(Ljava/util/List;)V
    //   2755: goto +642 -> 3397
    //   2758: aload 6
    //   2760: ifnull +31 -> 2791
    //   2763: aload 6
    //   2765: invokeinterface 104 1 0
    //   2770: ifeq +6 -> 2776
    //   2773: goto +18 -> 2791
    //   2776: aload_0
    //   2777: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2780: getfield 128	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Landroid/view/View;
    //   2783: bipush 8
    //   2785: invokevirtual 91	android/view/View:setVisibility	(I)V
    //   2788: goto +560 -> 3348
    //   2791: aload_0
    //   2792: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2795: getfield 128	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Landroid/view/View;
    //   2798: iconst_0
    //   2799: invokevirtual 91	android/view/View:setVisibility	(I)V
    //   2802: aload_0
    //   2803: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2806: getfield 614	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2809: getstatic 619	com/tencent/mobileqq/app/QQManagerFactory:MAYKNOW_RECOMMEND_MANAGER	I
    //   2812: invokevirtual 625	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2815: checkcast 627	com/tencent/mobileqq/app/MayknowRecommendManager
    //   2818: astore_3
    //   2819: iload 18
    //   2821: ifne +316 -> 3137
    //   2824: aload_3
    //   2825: getfield 628	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_d_of_type_Boolean	Z
    //   2828: ifeq +309 -> 3137
    //   2831: aload_0
    //   2832: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2835: getfield 631	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2838: ifnonnull +275 -> 3113
    //   2841: aload_0
    //   2842: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2845: astore_3
    //   2846: aload_3
    //   2847: new 633	com/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopListWrapperForSearchEmpty
    //   2850: dup
    //   2851: aload_3
    //   2852: getfield 614	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2855: aload_0
    //   2856: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2859: invokevirtual 351	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2862: aload_0
    //   2863: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2866: getfield 222	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   2869: aconst_null
    //   2870: invokespecial 636	com/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopListWrapperForSearchEmpty:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/widget/XListView;Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper$RecommendTroopListWrapperCallback;)V
    //   2873: putfield 631	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2876: aload_0
    //   2877: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2880: getfield 631	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2883: invokevirtual 641	com/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper:a	()Lcom/tencent/widget/XListView;
    //   2886: astore_3
    //   2887: new 109	android/widget/TextView
    //   2890: dup
    //   2891: aload_0
    //   2892: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2895: invokevirtual 351	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2898: invokespecial 514	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2901: astore 4
    //   2903: aload 4
    //   2905: bipush 17
    //   2907: invokevirtual 551	android/widget/TextView:setGravity	(I)V
    //   2910: aload 4
    //   2912: new 643	com/tencent/widget/AbsListView$LayoutParams
    //   2915: dup
    //   2916: iconst_m1
    //   2917: ldc_w 644
    //   2920: aload_0
    //   2921: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2924: invokevirtual 135	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2927: invokestatic 649	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   2930: invokespecial 650	com/tencent/widget/AbsListView$LayoutParams:<init>	(II)V
    //   2933: invokevirtual 654	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2936: aload 4
    //   2938: aload_0
    //   2939: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2942: invokevirtual 135	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2945: ldc_w 655
    //   2948: invokevirtual 661	android/content/res/Resources:getColor	(I)I
    //   2951: invokevirtual 530	android/widget/TextView:setTextColor	(I)V
    //   2954: aload 4
    //   2956: iconst_1
    //   2957: ldc_w 662
    //   2960: invokevirtual 556	android/widget/TextView:setTextSize	(IF)V
    //   2963: aload 4
    //   2965: ldc_w 663
    //   2968: invokestatic 164	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   2971: invokevirtual 168	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2974: aload 4
    //   2976: ldc_w 664
    //   2979: invokevirtual 667	android/widget/TextView:setBackgroundResource	(I)V
    //   2982: aload_3
    //   2983: aload 4
    //   2985: invokevirtual 673	com/tencent/widget/ListView:addHeaderView	(Landroid/view/View;)V
    //   2988: new 109	android/widget/TextView
    //   2991: dup
    //   2992: aload_0
    //   2993: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2996: invokevirtual 351	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2999: invokespecial 514	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   3002: astore 4
    //   3004: aload 4
    //   3006: aload_0
    //   3007: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3010: invokevirtual 135	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   3013: ldc_w 655
    //   3016: invokevirtual 661	android/content/res/Resources:getColor	(I)I
    //   3019: invokevirtual 530	android/widget/TextView:setTextColor	(I)V
    //   3022: aload 4
    //   3024: iconst_1
    //   3025: ldc_w 552
    //   3028: invokevirtual 556	android/widget/TextView:setTextSize	(IF)V
    //   3031: aload 4
    //   3033: bipush 16
    //   3035: invokevirtual 551	android/widget/TextView:setGravity	(I)V
    //   3038: aload 4
    //   3040: ldc_w 460
    //   3043: aload_0
    //   3044: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3047: invokevirtual 135	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   3050: invokestatic 649	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   3053: iconst_0
    //   3054: iconst_0
    //   3055: iconst_0
    //   3056: invokevirtual 525	android/widget/TextView:setPadding	(IIII)V
    //   3059: aload 4
    //   3061: new 643	com/tencent/widget/AbsListView$LayoutParams
    //   3064: dup
    //   3065: iconst_m1
    //   3066: ldc_w 674
    //   3069: aload_0
    //   3070: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3073: invokevirtual 135	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   3076: invokestatic 649	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   3079: invokespecial 650	com/tencent/widget/AbsListView$LayoutParams:<init>	(II)V
    //   3082: invokevirtual 654	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   3085: aload 4
    //   3087: ldc_w 675
    //   3090: invokestatic 164	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3093: invokevirtual 168	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3096: aload 4
    //   3098: ldc_w 664
    //   3101: invokevirtual 667	android/widget/TextView:setBackgroundResource	(I)V
    //   3104: aload_3
    //   3105: aload 4
    //   3107: invokevirtual 673	com/tencent/widget/ListView:addHeaderView	(Landroid/view/View;)V
    //   3110: goto +13 -> 3123
    //   3113: aload_0
    //   3114: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3117: getfield 631	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   3120: invokevirtual 677	com/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper:d	()V
    //   3123: aload_0
    //   3124: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3127: getfield 222	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   3130: iconst_0
    //   3131: invokevirtual 125	com/tencent/widget/XListView:setVisibility	(I)V
    //   3134: goto +187 -> 3321
    //   3137: aload_0
    //   3138: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3141: getfield 222	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   3144: bipush 8
    //   3146: invokevirtual 125	com/tencent/widget/XListView:setVisibility	(I)V
    //   3149: aload_0
    //   3150: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3153: getfield 131	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   3156: ifnonnull +65 -> 3221
    //   3159: aload_0
    //   3160: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3163: invokevirtual 23	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:isAdded	()Z
    //   3166: ifeq +55 -> 3221
    //   3169: aload_0
    //   3170: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3173: aload_0
    //   3174: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3177: invokevirtual 135	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   3180: ldc 136
    //   3182: invokestatic 142	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   3185: putfield 131	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   3188: aload_0
    //   3189: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3192: getfield 145	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   3195: aload_0
    //   3196: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3199: getfield 131	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   3202: invokevirtual 151	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   3205: goto +16 -> 3221
    //   3208: astore_3
    //   3209: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3212: iconst_1
    //   3213: aload_3
    //   3214: iconst_0
    //   3215: anewarray 153	java/lang/Object
    //   3218: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3221: aload_0
    //   3222: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3225: getfield 158	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   3228: ldc 237
    //   3230: invokestatic 164	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3233: invokevirtual 168	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3236: iload 18
    //   3238: ifeq +86 -> 3324
    //   3241: aload_0
    //   3242: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3245: getfield 225	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3248: iconst_0
    //   3249: invokevirtual 228	android/widget/Button:setVisibility	(I)V
    //   3252: aload_0
    //   3253: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3256: getfield 225	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3259: new 679	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1$1
    //   3262: dup
    //   3263: aload_0
    //   3264: aload 4
    //   3266: invokespecial 682	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1$1:<init>	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1;Ljava/lang/String;)V
    //   3269: invokevirtual 683	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3272: aload 8
    //   3274: invokestatic 397	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3277: ifne +44 -> 3321
    //   3280: aload_0
    //   3281: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3284: getfield 225	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3287: aload 8
    //   3289: invokevirtual 684	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   3292: aload_0
    //   3293: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3296: getfield 158	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   3299: iconst_0
    //   3300: aload_0
    //   3301: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3304: getfield 158	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   3307: invokevirtual 688	android/widget/TextView:getContext	()Landroid/content/Context;
    //   3310: ldc_w 460
    //   3313: invokestatic 455	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   3316: iconst_0
    //   3317: iconst_0
    //   3318: invokevirtual 525	android/widget/TextView:setPadding	(IIII)V
    //   3321: goto +15 -> 3336
    //   3324: aload_0
    //   3325: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3328: getfield 225	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3331: bipush 8
    //   3333: invokevirtual 228	android/widget/Button:setVisibility	(I)V
    //   3336: aload_0
    //   3337: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3340: getfield 231	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:c	Landroid/widget/TextView;
    //   3343: bipush 8
    //   3345: invokevirtual 110	android/widget/TextView:setVisibility	(I)V
    //   3348: aload 6
    //   3350: iload_2
    //   3351: aload_0
    //   3352: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3355: getfield 577	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_Boolean	Z
    //   3358: invokestatic 582	com/tencent/mobileqq/search/SearchUtil:a	(Ljava/util/List;ZZ)Ljava/util/List;
    //   3361: astore_3
    //   3362: aload_0
    //   3363: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3366: aload_3
    //   3367: invokevirtual 605	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Ljava/util/List;)V
    //   3370: aload_0
    //   3371: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3374: astore 4
    //   3376: aload 4
    //   3378: aload_3
    //   3379: putfield 99	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3382: aload 4
    //   3384: getfield 608	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter	Lcom/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter;
    //   3387: aload_0
    //   3388: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3391: getfield 99	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3394: invokevirtual 611	com/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter:a	(Ljava/util/List;)V
    //   3397: aload_0
    //   3398: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3401: lload 21
    //   3403: invokestatic 691	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;J)J
    //   3406: pop2
    //   3407: aload_0
    //   3408: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3411: getfield 394	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Boolean	Z
    //   3414: ifne +99 -> 3513
    //   3417: aload_0
    //   3418: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3421: astore_3
    //   3422: aload_3
    //   3423: aload_3
    //   3424: getfield 383	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Int	I
    //   3427: iload 14
    //   3429: iadd
    //   3430: putfield 383	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Int	I
    //   3433: aload_0
    //   3434: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3437: astore_3
    //   3438: aload_3
    //   3439: aload_3
    //   3440: getfield 387	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Int	I
    //   3443: iconst_1
    //   3444: iadd
    //   3445: putfield 387	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Int	I
    //   3448: aload_0
    //   3449: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3452: getfield 383	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Int	I
    //   3455: bipush 10
    //   3457: if_icmple +21 -> 3478
    //   3460: aload_0
    //   3461: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3464: astore_3
    //   3465: aload_3
    //   3466: iconst_0
    //   3467: putfield 387	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Int	I
    //   3470: aload_3
    //   3471: iconst_0
    //   3472: putfield 383	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Int	I
    //   3475: goto +38 -> 3513
    //   3478: aload_0
    //   3479: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3482: getfield 387	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Int	I
    //   3485: iconst_3
    //   3486: if_icmplt +14 -> 3500
    //   3489: aload_0
    //   3490: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3493: iconst_1
    //   3494: putfield 394	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Boolean	Z
    //   3497: goto +16 -> 3513
    //   3500: aload_0
    //   3501: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3504: astore_3
    //   3505: aload_3
    //   3506: aload_3
    //   3507: getfield 77	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3510: invokevirtual 693	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	(Ljava/lang/String;)V
    //   3513: iload 5
    //   3515: ifeq +116 -> 3631
    //   3518: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3521: ifeq +220 -> 3741
    //   3524: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3527: astore_3
    //   3528: new 28	java/lang/StringBuilder
    //   3531: dup
    //   3532: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   3535: astore 4
    //   3537: aload 4
    //   3539: ldc_w 695
    //   3542: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3545: pop
    //   3546: aload 4
    //   3548: aload 7
    //   3550: invokestatic 184	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3553: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3556: pop
    //   3557: aload 4
    //   3559: ldc 186
    //   3561: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3564: pop
    //   3565: aload 4
    //   3567: aload_1
    //   3568: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3571: pop
    //   3572: aload 4
    //   3574: ldc 188
    //   3576: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3579: pop
    //   3580: aload 4
    //   3582: aload_0
    //   3583: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3586: getfield 190	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3589: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3592: pop
    //   3593: aload 4
    //   3595: ldc_w 697
    //   3598: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3601: pop
    //   3602: aload 4
    //   3604: aload_0
    //   3605: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3608: getfield 71	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   3611: invokestatic 184	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3614: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3617: pop
    //   3618: aload_3
    //   3619: iconst_2
    //   3620: aload 4
    //   3622: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3625: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3628: goto +113 -> 3741
    //   3631: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3634: ifeq +107 -> 3741
    //   3637: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3640: astore_3
    //   3641: new 28	java/lang/StringBuilder
    //   3644: dup
    //   3645: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   3648: astore 4
    //   3650: aload 4
    //   3652: ldc_w 699
    //   3655: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3658: pop
    //   3659: aload 4
    //   3661: aload 7
    //   3663: invokestatic 184	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3666: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3669: pop
    //   3670: aload 4
    //   3672: ldc 186
    //   3674: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3677: pop
    //   3678: aload 4
    //   3680: aload_1
    //   3681: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3684: pop
    //   3685: aload 4
    //   3687: ldc 188
    //   3689: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3692: pop
    //   3693: aload 4
    //   3695: aload_0
    //   3696: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3699: getfield 190	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3702: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3705: pop
    //   3706: aload 4
    //   3708: ldc_w 697
    //   3711: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3714: pop
    //   3715: aload 4
    //   3717: aload_0
    //   3718: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3721: getfield 71	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   3724: invokestatic 184	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3727: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3730: pop
    //   3731: aload_3
    //   3732: iconst_2
    //   3733: aload 4
    //   3735: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3738: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3741: iconst_1
    //   3742: putstatic 701	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:a	Z
    //   3745: return
    //   3746: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3749: astore_3
    //   3750: new 28	java/lang/StringBuilder
    //   3753: dup
    //   3754: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   3757: astore 4
    //   3759: aload 4
    //   3761: ldc_w 703
    //   3764: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3767: pop
    //   3768: aload 4
    //   3770: aload_0
    //   3771: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3774: getfield 71	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   3777: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3780: pop
    //   3781: aload 4
    //   3783: ldc_w 705
    //   3786: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3789: pop
    //   3790: aload 4
    //   3792: aload 7
    //   3794: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3797: pop
    //   3798: aload 4
    //   3800: ldc_w 707
    //   3803: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3806: pop
    //   3807: aload 4
    //   3809: aload_1
    //   3810: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3813: pop
    //   3814: aload 4
    //   3816: ldc 200
    //   3818: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3821: pop
    //   3822: aload 4
    //   3824: aload_0
    //   3825: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3828: getfield 77	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3831: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3834: pop
    //   3835: aload 4
    //   3837: ldc 204
    //   3839: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3842: pop
    //   3843: aload 4
    //   3845: iload 5
    //   3847: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3850: pop
    //   3851: aload_3
    //   3852: iconst_2
    //   3853: aload 4
    //   3855: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3858: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3861: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3862	0	this	1
    //   0	3862	1	paramString1	String
    //   0	3862	2	paramBoolean1	boolean
    //   0	3862	3	paramString2	String
    //   0	3862	4	paramArrayOfByte	byte[]
    //   0	3862	5	paramBoolean2	boolean
    //   0	3862	6	paramList	List<com.tencent.mobileqq.search.model.ISearchResultGroupModel>
    //   0	3862	7	paramArrayOfLong	long[]
    //   0	3862	8	paramString3	String
    //   0	3862	9	paramList1	List<tencent.im.oidb.search.DynamicTabSearch.SubHotWord>
    //   0	3862	10	paramBoolean3	boolean
    //   0	3862	11	paramString4	String
    //   0	3862	12	paramInt	int
    //   571	2128	13	i	int
    //   1832	1598	14	j	int
    //   2008	704	15	k	int
    //   2016	167	16	m	int
    //   1612	584	17	bool1	boolean
    //   1638	1599	18	bool2	boolean
    //   538	1949	19	l1	long
    //   542	2860	21	l2	long
    //   579	320	23	l3	long
    //   575	320	25	l4	long
    //   533	1758	27	localObject1	Object
    //   567	1705	28	localObject2	Object
    //   604	1699	29	localObject3	Object
    //   611	1694	30	localObject4	Object
    //   620	13	31	localIterator	java.util.Iterator
    //   642	31	32	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   433	465	468	java/lang/OutOfMemoryError
    //   1623	1633	1643	org/json/JSONException
    //   1614	1623	1648	org/json/JSONException
    //   1593	1614	1657	org/json/JSONException
    //   3159	3205	3208	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment.1
 * JD-Core Version:    0.7.0.1
 */