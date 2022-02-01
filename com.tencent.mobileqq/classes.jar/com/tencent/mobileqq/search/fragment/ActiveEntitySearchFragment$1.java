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
      paramArrayOfLong = ActiveEntitySearchFragment.a;
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
    if (!TextUtils.equals(paramString2, this.a.D)) {
      return;
    }
    if (ActiveEntitySearchFragment.a(this.a.F, paramArrayOfLong))
    {
      if (!this.a.b.equals(paramString1)) {
        return;
      }
      this.a.v.setVisibility(8);
      paramString2 = this.a;
      paramString2.E = false;
      paramString2.q.setVisibility(8);
      if ((this.a.g != null) && (!this.a.g.isEmpty()))
      {
        this.a.P.setVisibility(0);
        this.a.P.setOnClickListener(new ActiveEntitySearchFragment.1.3(this));
      }
      else
      {
        this.a.i.setVisibility(8);
        this.a.x.setVisibility(0);
        if (this.a.A == null) {
          try
          {
            this.a.A = BitmapFactory.decodeResource(this.a.getResources(), 2130843373);
            this.a.z.setImageBitmap(this.a.A);
          }
          catch (OutOfMemoryError paramString2)
          {
            QLog.e(ActiveEntitySearchFragment.a, 1, paramString2, new Object[0]);
          }
        }
        this.a.B.setText(HardCodeUtil.a(2131898040));
        this.a.x.setOnClickListener(new ActiveEntitySearchFragment.1.2(this));
      }
      if (QLog.isColorLevel())
      {
        paramString2 = ActiveEntitySearchFragment.a;
        paramString3 = new StringBuilder();
        paramString3.append("Unify handleTabSearchError code=");
        paramString3.append(paramInt);
        paramString3.append(" mask;");
        paramString3.append(Arrays.toString(paramArrayOfLong));
        paramString3.append(" key=");
        paramString3.append(paramString1);
        paramString3.append(" name=");
        paramString3.append(this.a.N);
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
    //   10: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   13: astore 4
    //   15: new 28	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   22: astore 6
    //   24: aload 6
    //   26: ldc 209
    //   28: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 6
    //   34: aload_1
    //   35: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 6
    //   41: ldc 211
    //   43: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 6
    //   49: aload_0
    //   50: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   53: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
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
    //   77: ldc 213
    //   79: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 6
    //   85: aload_0
    //   86: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   89: getfield 62	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:D	Ljava/lang/String;
    //   92: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 6
    //   98: ldc 215
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
    //   129: getfield 62	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:D	Ljava/lang/String;
    //   132: invokestatic 68	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   135: ifne +117 -> 252
    //   138: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   141: astore 4
    //   143: new 28	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   150: astore 6
    //   152: aload 6
    //   154: ldc 217
    //   156: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 6
    //   162: aload_1
    //   163: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 6
    //   169: ldc 211
    //   171: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 6
    //   177: aload_0
    //   178: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   181: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
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
    //   205: ldc 213
    //   207: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 6
    //   213: aload_0
    //   214: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   217: getfield 62	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:D	Ljava/lang/String;
    //   220: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 6
    //   226: ldc 215
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
    //   248: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: return
    //   252: aload_0
    //   253: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   256: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   259: aload 7
    //   261: invokestatic 75	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	([J[J)Z
    //   264: ifeq +3495 -> 3759
    //   267: aload_1
    //   268: aload_0
    //   269: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   272: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   275: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifne +6 -> 284
    //   281: goto +3478 -> 3759
    //   284: aload 6
    //   286: ifnonnull +63 -> 349
    //   289: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +44 -> 336
    //   295: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   298: astore 4
    //   300: new 28	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   307: astore 8
    //   309: aload 8
    //   311: ldc 222
    //   313: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 8
    //   319: aload 6
    //   321: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 4
    //   327: iconst_2
    //   328: aload 8
    //   330: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload_0
    //   337: aload_1
    //   338: iload_2
    //   339: aload_3
    //   340: iconst_m1
    //   341: ldc 229
    //   343: aload 7
    //   345: invokevirtual 231	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	(Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;[J)V
    //   348: return
    //   349: iload 12
    //   351: iconst_2
    //   352: if_icmpne +166 -> 518
    //   355: aload_0
    //   356: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   359: getfield 87	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:v	Landroid/view/View;
    //   362: bipush 8
    //   364: invokevirtual 93	android/view/View:setVisibility	(I)V
    //   367: aload_0
    //   368: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   371: astore_1
    //   372: aload_1
    //   373: iconst_0
    //   374: putfield 97	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:E	Z
    //   377: aload_1
    //   378: getfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:q	Landroid/view/View;
    //   381: bipush 8
    //   383: invokevirtual 93	android/view/View:setVisibility	(I)V
    //   386: aload_0
    //   387: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   390: getfield 234	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:y	Lcom/tencent/widget/XListView;
    //   393: bipush 8
    //   395: invokevirtual 132	com/tencent/widget/XListView:setVisibility	(I)V
    //   398: aload_0
    //   399: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   402: getfield 238	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:C	Landroid/widget/Button;
    //   405: bipush 8
    //   407: invokevirtual 241	android/widget/Button:setVisibility	(I)V
    //   410: aload_0
    //   411: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   414: getfield 244	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:O	Landroid/widget/TextView;
    //   417: bipush 8
    //   419: invokevirtual 116	android/widget/TextView:setVisibility	(I)V
    //   422: aload_0
    //   423: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   426: getfield 135	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:x	Landroid/view/View;
    //   429: iconst_0
    //   430: invokevirtual 93	android/view/View:setVisibility	(I)V
    //   433: aload_0
    //   434: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   437: invokevirtual 23	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:isAdded	()Z
    //   440: ifeq +41 -> 481
    //   443: aload_0
    //   444: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   447: getfield 154	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:z	Landroid/widget/ImageView;
    //   450: aload_0
    //   451: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   454: invokevirtual 143	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   457: ldc 245
    //   459: invokestatic 150	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   462: invokevirtual 160	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   465: goto +16 -> 481
    //   468: astore_1
    //   469: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   472: iconst_1
    //   473: aload_1
    //   474: iconst_0
    //   475: anewarray 162	java/lang/Object
    //   478: invokestatic 165	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   481: iconst_2
    //   482: iload 12
    //   484: if_icmpne +16 -> 500
    //   487: aload_0
    //   488: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   491: ldc 246
    //   493: invokevirtual 249	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getString	(I)Ljava/lang/String;
    //   496: astore_1
    //   497: goto +9 -> 506
    //   500: ldc 250
    //   502: invokestatic 174	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   505: astore_1
    //   506: aload_0
    //   507: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   510: getfield 168	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:B	Landroid/widget/TextView;
    //   513: aload_1
    //   514: invokevirtual 178	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   517: return
    //   518: new 252	java/util/HashSet
    //   521: dup
    //   522: invokespecial 253	java/util/HashSet:<init>	()V
    //   525: astore_3
    //   526: aload 6
    //   528: invokeinterface 257 1 0
    //   533: astore 27
    //   535: ldc2_w 258
    //   538: lstore 19
    //   540: lload 19
    //   542: lstore 21
    //   544: iconst_0
    //   545: istore 12
    //   547: aload 27
    //   549: invokeinterface 264 1 0
    //   554: ifeq +347 -> 901
    //   557: aload 27
    //   559: invokeinterface 268 1 0
    //   564: checkcast 270	com/tencent/mobileqq/search/model/ISearchResultGroupModel
    //   567: astore 28
    //   569: iload 12
    //   571: istore 13
    //   573: lload 19
    //   575: lstore 25
    //   577: lload 21
    //   579: lstore 23
    //   581: aload 28
    //   583: invokevirtual 273	com/tencent/mobileqq/search/model/ISearchResultGroupModel:b	()Ljava/util/List;
    //   586: ifnull +300 -> 886
    //   589: aload 28
    //   591: instanceof 275
    //   594: ifeq +269 -> 863
    //   597: aload 28
    //   599: checkcast 275	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel
    //   602: astore 29
    //   604: aload 29
    //   606: invokevirtual 276	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:b	()Ljava/util/List;
    //   609: astore 30
    //   611: aload 30
    //   613: invokeinterface 257 1 0
    //   618: astore 31
    //   620: aload 31
    //   622: invokeinterface 264 1 0
    //   627: ifeq +61 -> 688
    //   630: aload 31
    //   632: invokeinterface 268 1 0
    //   637: checkcast 278	com/tencent/mobileqq/search/model/ISearchResultModel
    //   640: astore 32
    //   642: aload 32
    //   644: instanceof 280
    //   647: ifeq +38 -> 685
    //   650: aload 32
    //   652: checkcast 280	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem
    //   655: astore 32
    //   657: getstatic 285	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:s	Z
    //   660: ifeq +9 -> 669
    //   663: aload 32
    //   665: iconst_1
    //   666: putfield 289	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:Y	I
    //   669: aload_3
    //   670: aload 32
    //   672: invokevirtual 293	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:j	()I
    //   675: i2l
    //   676: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   679: invokeinterface 304 2 0
    //   684: pop
    //   685: goto -65 -> 620
    //   688: lload 19
    //   690: lstore 21
    //   692: lload 19
    //   694: ldc2_w 258
    //   697: lcmp
    //   698: ifne +10 -> 708
    //   701: aload 29
    //   703: getfield 307	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   706: lstore 21
    //   708: aload 29
    //   710: getfield 307	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   713: lstore 25
    //   715: aload 30
    //   717: invokeinterface 310 1 0
    //   722: ifle +59 -> 781
    //   725: aload 29
    //   727: getfield 307	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   730: ldc2_w 311
    //   733: lcmp
    //   734: ifne +47 -> 781
    //   737: aconst_null
    //   738: ldc_w 314
    //   741: ldc_w 316
    //   744: ldc_w 316
    //   747: ldc_w 318
    //   750: ldc_w 318
    //   753: iconst_1
    //   754: iconst_0
    //   755: ldc_w 316
    //   758: ldc_w 316
    //   761: ldc_w 316
    //   764: ldc_w 316
    //   767: invokestatic 323	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   770: lload 25
    //   772: lstore 23
    //   774: lload 21
    //   776: lstore 19
    //   778: goto +89 -> 867
    //   781: lload 25
    //   783: lstore 23
    //   785: lload 21
    //   787: lstore 19
    //   789: aload 30
    //   791: invokeinterface 310 1 0
    //   796: ifle +71 -> 867
    //   799: lload 25
    //   801: lstore 23
    //   803: lload 21
    //   805: lstore 19
    //   807: aload 29
    //   809: getfield 307	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   812: ldc2_w 324
    //   815: lcmp
    //   816: ifne +51 -> 867
    //   819: aconst_null
    //   820: ldc_w 314
    //   823: ldc_w 316
    //   826: ldc_w 316
    //   829: ldc_w 318
    //   832: ldc_w 318
    //   835: iconst_2
    //   836: iconst_0
    //   837: ldc_w 316
    //   840: ldc_w 316
    //   843: ldc_w 316
    //   846: ldc_w 316
    //   849: invokestatic 323	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   852: lload 25
    //   854: lstore 23
    //   856: lload 21
    //   858: lstore 19
    //   860: goto +7 -> 867
    //   863: lload 21
    //   865: lstore 23
    //   867: iload 12
    //   869: aload 28
    //   871: invokevirtual 273	com/tencent/mobileqq/search/model/ISearchResultGroupModel:b	()Ljava/util/List;
    //   874: invokeinterface 310 1 0
    //   879: iadd
    //   880: istore 13
    //   882: lload 19
    //   884: lstore 25
    //   886: iload 13
    //   888: istore 12
    //   890: lload 25
    //   892: lstore 19
    //   894: lload 23
    //   896: lstore 21
    //   898: goto -351 -> 547
    //   901: aload_0
    //   902: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   905: getfield 328	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:G	Ljava/util/List;
    //   908: aload_3
    //   909: invokeinterface 332 2 0
    //   914: pop
    //   915: aload_0
    //   916: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   919: aload 8
    //   921: invokestatic 335	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;Ljava/lang/String;)Ljava/lang/String;
    //   924: pop
    //   925: aload_0
    //   926: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   929: aload 9
    //   931: invokestatic 338	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;Ljava/util/List;)Ljava/util/List;
    //   934: pop
    //   935: ldc_w 316
    //   938: astore 27
    //   940: iload_2
    //   941: ifne +77 -> 1018
    //   944: new 340	java/util/ArrayList
    //   947: dup
    //   948: invokespecial 341	java/util/ArrayList:<init>	()V
    //   951: astore 8
    //   953: aload 8
    //   955: aload_3
    //   956: invokeinterface 332 2 0
    //   961: pop
    //   962: ldc_w 343
    //   965: ldc_w 345
    //   968: iconst_4
    //   969: anewarray 80	java/lang/String
    //   972: dup
    //   973: iconst_0
    //   974: aload_0
    //   975: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   978: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   981: aastore
    //   982: dup
    //   983: iconst_1
    //   984: aload 8
    //   986: invokestatic 350	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/List;)Ljava/lang/String;
    //   989: aastore
    //   990: dup
    //   991: iconst_2
    //   992: ldc_w 316
    //   995: aastore
    //   996: dup
    //   997: iconst_3
    //   998: ldc_w 352
    //   1001: aload_0
    //   1002: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1005: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   1008: invokestatic 355	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1011: aastore
    //   1012: invokestatic 358	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1015: goto +3 -> 1018
    //   1018: aload_0
    //   1019: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1022: getfield 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   1025: astore_3
    //   1026: aload_0
    //   1027: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1030: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   1033: astore 8
    //   1035: aload_0
    //   1036: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1039: getfield 201	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:N	Ljava/lang/String;
    //   1042: astore 9
    //   1044: aload_0
    //   1045: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1048: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   1051: astore 28
    //   1053: aload_3
    //   1054: aload 6
    //   1056: iload_2
    //   1057: iconst_1
    //   1058: ixor
    //   1059: aload 8
    //   1061: aload 9
    //   1063: aload 28
    //   1065: invokestatic 363	com/tencent/mobileqq/search/util/ReportUtil:a	(Ljava/util/List;Ljava/util/List;Z[JLjava/lang/String;Ljava/lang/String;)V
    //   1068: aload 6
    //   1070: aload_0
    //   1071: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1074: invokestatic 366	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)I
    //   1077: aload_0
    //   1078: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1081: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   1084: invokestatic 369	com/tencent/mobileqq/search/util/ReportUtil:a	(Ljava/util/List;ILjava/lang/String;)V
    //   1087: iload 12
    //   1089: ifne +163 -> 1252
    //   1092: aload_0
    //   1093: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1096: invokevirtual 373	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1099: instanceof 375
    //   1102: ifeq +147 -> 1249
    //   1105: aload_0
    //   1106: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1109: invokevirtual 373	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1112: checkcast 375	com/tencent/mobileqq/search/base/api/SearchInfoInterface
    //   1115: invokeinterface 377 1 0
    //   1120: istore 13
    //   1122: iload 13
    //   1124: iconst_1
    //   1125: if_icmpeq +68 -> 1193
    //   1128: iload 13
    //   1130: iconst_3
    //   1131: if_icmpeq +6 -> 1137
    //   1134: goto +115 -> 1249
    //   1137: ldc_w 343
    //   1140: ldc_w 379
    //   1143: iconst_4
    //   1144: anewarray 80	java/lang/String
    //   1147: dup
    //   1148: iconst_0
    //   1149: aload_0
    //   1150: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1153: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   1156: aastore
    //   1157: dup
    //   1158: iconst_1
    //   1159: aload_0
    //   1160: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1163: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   1166: invokestatic 381	com/tencent/mobileqq/search/util/SearchUtils:a	([J)Ljava/lang/String;
    //   1169: aastore
    //   1170: dup
    //   1171: iconst_2
    //   1172: ldc_w 316
    //   1175: aastore
    //   1176: dup
    //   1177: iconst_3
    //   1178: ldc_w 352
    //   1181: aload 7
    //   1183: invokestatic 355	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1186: aastore
    //   1187: invokestatic 358	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1190: goto +235 -> 1425
    //   1193: ldc_w 383
    //   1196: ldc_w 385
    //   1199: iconst_4
    //   1200: anewarray 80	java/lang/String
    //   1203: dup
    //   1204: iconst_0
    //   1205: aload_0
    //   1206: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1209: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   1212: aastore
    //   1213: dup
    //   1214: iconst_1
    //   1215: aload_0
    //   1216: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1219: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   1222: invokestatic 381	com/tencent/mobileqq/search/util/SearchUtils:a	([J)Ljava/lang/String;
    //   1225: aastore
    //   1226: dup
    //   1227: iconst_2
    //   1228: ldc_w 316
    //   1231: aastore
    //   1232: dup
    //   1233: iconst_3
    //   1234: ldc_w 352
    //   1237: aload 7
    //   1239: invokestatic 355	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1242: aastore
    //   1243: invokestatic 358	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1246: goto +179 -> 1425
    //   1249: goto +176 -> 1425
    //   1252: aload_0
    //   1253: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1256: getfield 389	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:o	[B
    //   1259: ifnonnull +166 -> 1425
    //   1262: aload_0
    //   1263: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1266: invokevirtual 373	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1269: instanceof 375
    //   1272: ifeq +153 -> 1425
    //   1275: aload_0
    //   1276: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1279: invokevirtual 373	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1282: checkcast 375	com/tencent/mobileqq/search/base/api/SearchInfoInterface
    //   1285: astore_3
    //   1286: aload_3
    //   1287: invokeinterface 377 1 0
    //   1292: istore 13
    //   1294: iload 13
    //   1296: iconst_1
    //   1297: if_icmpeq +71 -> 1368
    //   1300: iload 13
    //   1302: iconst_3
    //   1303: if_icmpeq +6 -> 1309
    //   1306: goto +119 -> 1425
    //   1309: ldc_w 343
    //   1312: ldc_w 391
    //   1315: iconst_4
    //   1316: anewarray 80	java/lang/String
    //   1319: dup
    //   1320: iconst_0
    //   1321: aload_3
    //   1322: invokeinterface 394 1 0
    //   1327: aastore
    //   1328: dup
    //   1329: iconst_1
    //   1330: aload_0
    //   1331: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1334: getfield 328	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:G	Ljava/util/List;
    //   1337: invokestatic 350	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/List;)Ljava/lang/String;
    //   1340: aastore
    //   1341: dup
    //   1342: iconst_2
    //   1343: ldc_w 316
    //   1346: aastore
    //   1347: dup
    //   1348: iconst_3
    //   1349: ldc_w 352
    //   1352: aload_3
    //   1353: invokeinterface 397 1 0
    //   1358: invokestatic 355	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1361: aastore
    //   1362: invokestatic 358	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1365: goto +60 -> 1425
    //   1368: ldc_w 383
    //   1371: ldc_w 399
    //   1374: iconst_4
    //   1375: anewarray 80	java/lang/String
    //   1378: dup
    //   1379: iconst_0
    //   1380: aload_0
    //   1381: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1384: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   1387: aastore
    //   1388: dup
    //   1389: iconst_1
    //   1390: aload_0
    //   1391: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1394: getfield 328	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:G	Ljava/util/List;
    //   1397: invokestatic 350	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/List;)Ljava/lang/String;
    //   1400: aastore
    //   1401: dup
    //   1402: iconst_2
    //   1403: ldc_w 316
    //   1406: aastore
    //   1407: dup
    //   1408: iconst_3
    //   1409: ldc_w 401
    //   1412: aload_3
    //   1413: invokeinterface 397 1 0
    //   1418: invokestatic 355	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1421: aastore
    //   1422: invokestatic 358	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1425: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1428: ifeq +103 -> 1531
    //   1431: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   1434: astore_3
    //   1435: new 28	java/lang/StringBuilder
    //   1438: dup
    //   1439: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1442: astore 8
    //   1444: aload 8
    //   1446: ldc_w 403
    //   1449: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: pop
    //   1453: aload 8
    //   1455: iload_2
    //   1456: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: aload 8
    //   1462: ldc_w 405
    //   1465: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: pop
    //   1469: aload 8
    //   1471: aload_0
    //   1472: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1475: getfield 408	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:K	I
    //   1478: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1481: pop
    //   1482: aload 8
    //   1484: ldc_w 410
    //   1487: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: pop
    //   1491: aload 8
    //   1493: aload_0
    //   1494: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1497: getfield 412	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:J	I
    //   1500: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1503: pop
    //   1504: aload 8
    //   1506: ldc_w 414
    //   1509: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: pop
    //   1513: aload 8
    //   1515: iload 12
    //   1517: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1520: pop
    //   1521: aload_3
    //   1522: iconst_2
    //   1523: aload 8
    //   1525: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1528: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1531: aload_0
    //   1532: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1535: getfield 87	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:v	Landroid/view/View;
    //   1538: bipush 8
    //   1540: invokevirtual 93	android/view/View:setVisibility	(I)V
    //   1543: aload_0
    //   1544: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1547: getfield 416	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:w	Landroid/view/View;
    //   1550: bipush 8
    //   1552: invokevirtual 93	android/view/View:setVisibility	(I)V
    //   1555: aload_0
    //   1556: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1559: getfield 129	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:i	Lcom/tencent/widget/XListView;
    //   1562: iconst_0
    //   1563: invokevirtual 132	com/tencent/widget/XListView:setVisibility	(I)V
    //   1566: aload_0
    //   1567: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1570: getfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:q	Landroid/view/View;
    //   1573: bipush 8
    //   1575: invokevirtual 93	android/view/View:setVisibility	(I)V
    //   1578: aload_0
    //   1579: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1582: astore_3
    //   1583: aload_3
    //   1584: iconst_0
    //   1585: putfield 97	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:E	Z
    //   1588: aload_3
    //   1589: aload 4
    //   1591: putfield 389	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:o	[B
    //   1594: aload_3
    //   1595: iload 5
    //   1597: putfield 419	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:p	Z
    //   1600: aload 11
    //   1602: invokestatic 422	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1605: ifne +156 -> 1761
    //   1608: new 424	org/json/JSONObject
    //   1611: dup
    //   1612: aload 11
    //   1614: invokespecial 427	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1617: astore 4
    //   1619: aload 4
    //   1621: ldc_w 429
    //   1624: invokevirtual 433	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1627: istore 17
    //   1629: aload 4
    //   1631: ldc_w 435
    //   1634: invokevirtual 439	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1637: astore_3
    //   1638: aload 4
    //   1640: ldc_w 441
    //   1643: invokevirtual 439	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1646: astore 9
    //   1648: aload_3
    //   1649: astore 8
    //   1651: iload 17
    //   1653: istore 18
    //   1655: goto +99 -> 1754
    //   1658: astore 4
    //   1660: goto +21 -> 1681
    //   1663: astore 4
    //   1665: ldc_w 316
    //   1668: astore_3
    //   1669: goto +12 -> 1681
    //   1672: astore 4
    //   1674: ldc_w 316
    //   1677: astore_3
    //   1678: iconst_0
    //   1679: istore 17
    //   1681: aload_3
    //   1682: astore 8
    //   1684: iload 17
    //   1686: istore 18
    //   1688: aload 27
    //   1690: astore 9
    //   1692: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1695: ifeq +59 -> 1754
    //   1698: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   1701: astore 8
    //   1703: new 28	java/lang/StringBuilder
    //   1706: dup
    //   1707: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1710: astore 9
    //   1712: aload 9
    //   1714: ldc_w 443
    //   1717: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1720: pop
    //   1721: aload 9
    //   1723: aload 4
    //   1725: invokestatic 447	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1728: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: pop
    //   1732: aload 8
    //   1734: iconst_2
    //   1735: aload 9
    //   1737: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1740: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1743: aload 27
    //   1745: astore 9
    //   1747: iload 17
    //   1749: istore 18
    //   1751: aload_3
    //   1752: astore 8
    //   1754: aload 9
    //   1756: astore 4
    //   1758: goto +31 -> 1789
    //   1761: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1764: ifeq +13 -> 1777
    //   1767: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   1770: iconst_2
    //   1771: ldc_w 449
    //   1774: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1777: ldc_w 316
    //   1780: astore 8
    //   1782: aload 8
    //   1784: astore 4
    //   1786: iconst_0
    //   1787: istore 18
    //   1789: iload 5
    //   1791: ifeq +134 -> 1925
    //   1794: aload_0
    //   1795: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1798: getfield 244	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:O	Landroid/widget/TextView;
    //   1801: iconst_0
    //   1802: invokevirtual 116	android/widget/TextView:setVisibility	(I)V
    //   1805: aload_0
    //   1806: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1809: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   1812: ifnull +113 -> 1925
    //   1815: aload_0
    //   1816: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1819: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   1822: arraylength
    //   1823: iconst_2
    //   1824: if_icmpne +101 -> 1925
    //   1827: new 340	java/util/ArrayList
    //   1830: dup
    //   1831: invokespecial 341	java/util/ArrayList:<init>	()V
    //   1834: astore_3
    //   1835: aload_0
    //   1836: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1839: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   1842: astore 9
    //   1844: aload 9
    //   1846: arraylength
    //   1847: istore 14
    //   1849: iconst_0
    //   1850: istore 13
    //   1852: iload 13
    //   1854: iload 14
    //   1856: if_icmpge +27 -> 1883
    //   1859: aload_3
    //   1860: aload 9
    //   1862: iload 13
    //   1864: laload
    //   1865: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1868: invokeinterface 450 2 0
    //   1873: pop
    //   1874: iload 13
    //   1876: iconst_1
    //   1877: iadd
    //   1878: istore 13
    //   1880: goto -28 -> 1852
    //   1883: aload_3
    //   1884: ldc2_w 311
    //   1887: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1890: invokeinterface 453 2 0
    //   1895: ifeq +30 -> 1925
    //   1898: aload_3
    //   1899: ldc2_w 324
    //   1902: invokestatic 299	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1905: invokeinterface 453 2 0
    //   1910: ifeq +15 -> 1925
    //   1913: aload_0
    //   1914: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1917: getfield 244	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:O	Landroid/widget/TextView;
    //   1920: bipush 8
    //   1922: invokevirtual 116	android/widget/TextView:setVisibility	(I)V
    //   1925: aload_0
    //   1926: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1929: invokestatic 456	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/lang/String;
    //   1932: invokestatic 422	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1935: ifne +507 -> 2442
    //   1938: aload_0
    //   1939: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1942: invokestatic 460	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:c	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/util/List;
    //   1945: invokeinterface 310 1 0
    //   1950: ifle +492 -> 2442
    //   1953: aload_0
    //   1954: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1957: getfield 463	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:t	Landroid/widget/TextView;
    //   1960: aload_0
    //   1961: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1964: invokestatic 456	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/lang/String;
    //   1967: invokevirtual 178	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1970: aload_0
    //   1971: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1974: getfield 467	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:u	Landroid/widget/LinearLayout;
    //   1977: invokevirtual 472	android/widget/LinearLayout:removeAllViews	()V
    //   1980: aload_0
    //   1981: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1984: invokevirtual 373	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1987: astore 9
    //   1989: aload 9
    //   1991: ifnull +434 -> 2425
    //   1994: aload 9
    //   1996: invokevirtual 477	com/tencent/mobileqq/app/BaseActivity:isFinishing	()Z
    //   1999: ifeq +6 -> 2005
    //   2002: goto +423 -> 2425
    //   2005: aload 9
    //   2007: ldc_w 478
    //   2010: invokestatic 483	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   2013: istore 14
    //   2015: aload 9
    //   2017: ldc_w 484
    //   2020: invokestatic 483	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   2023: istore 15
    //   2025: aload 9
    //   2027: fconst_2
    //   2028: invokestatic 483	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   2031: istore 16
    //   2033: new 486	android/graphics/drawable/GradientDrawable
    //   2036: dup
    //   2037: invokespecial 487	android/graphics/drawable/GradientDrawable:<init>	()V
    //   2040: astore 11
    //   2042: aload 11
    //   2044: aload_0
    //   2045: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2048: invokevirtual 373	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2051: ldc_w 488
    //   2054: invokestatic 483	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   2057: i2f
    //   2058: invokevirtual 492	android/graphics/drawable/GradientDrawable:setCornerRadius	(F)V
    //   2061: ldc_w 494
    //   2064: invokestatic 500	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   2067: istore 13
    //   2069: invokestatic 506	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2072: invokevirtual 510	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   2075: invokestatic 516	com/tencent/mobileqq/vas/theme/api/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   2078: istore 17
    //   2080: iload 17
    //   2082: ifeq +11 -> 2093
    //   2085: ldc_w 518
    //   2088: invokestatic 500	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   2091: istore 13
    //   2093: aload 11
    //   2095: iconst_1
    //   2096: iload 13
    //   2098: invokevirtual 522	android/graphics/drawable/GradientDrawable:setStroke	(II)V
    //   2101: aload_0
    //   2102: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2105: invokestatic 460	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:c	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/util/List;
    //   2108: invokeinterface 257 1 0
    //   2113: astore_3
    //   2114: aload_3
    //   2115: invokeinterface 264 1 0
    //   2120: ifeq +207 -> 2327
    //   2123: aload_3
    //   2124: invokeinterface 268 1 0
    //   2129: checkcast 524	tencent/im/oidb/search/DynamicTabSearch$SubHotWord
    //   2132: astore 27
    //   2134: aload 27
    //   2136: getfield 528	tencent/im/oidb/search/DynamicTabSearch$SubHotWord:show_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2139: invokevirtual 534	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2142: invokevirtual 539	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2145: astore 28
    //   2147: aload 28
    //   2149: invokestatic 422	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2152: ifeq +6 -> 2158
    //   2155: goto -41 -> 2114
    //   2158: new 115	android/widget/TextView
    //   2161: dup
    //   2162: aload 9
    //   2164: invokespecial 542	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2167: astore 29
    //   2169: new 544	android/widget/LinearLayout$LayoutParams
    //   2172: dup
    //   2173: bipush 254
    //   2175: bipush 254
    //   2177: invokespecial 546	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   2180: astore 30
    //   2182: aload 30
    //   2184: iload 14
    //   2186: putfield 549	android/widget/LinearLayout$LayoutParams:rightMargin	I
    //   2189: aload 29
    //   2191: iload 15
    //   2193: iload 16
    //   2195: iload 15
    //   2197: iload 16
    //   2199: invokevirtual 553	android/widget/TextView:setPadding	(IIII)V
    //   2202: ldc_w 555
    //   2205: invokestatic 500	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   2208: istore 13
    //   2210: iload 17
    //   2212: ifeq +11 -> 2223
    //   2215: ldc_w 518
    //   2218: invokestatic 500	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   2221: istore 13
    //   2223: aload 29
    //   2225: iload 13
    //   2227: invokevirtual 558	android/widget/TextView:setTextColor	(I)V
    //   2230: getstatic 563	android/os/Build$VERSION:SDK_INT	I
    //   2233: bipush 16
    //   2235: if_icmpge +16 -> 2251
    //   2238: aload 29
    //   2240: aload 11
    //   2242: invokevirtual 569	android/graphics/drawable/Drawable:mutate	()Landroid/graphics/drawable/Drawable;
    //   2245: invokevirtual 573	android/widget/TextView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2248: goto +13 -> 2261
    //   2251: aload 29
    //   2253: aload 11
    //   2255: invokevirtual 569	android/graphics/drawable/Drawable:mutate	()Landroid/graphics/drawable/Drawable;
    //   2258: invokevirtual 576	android/widget/TextView:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   2261: aload 29
    //   2263: aload 28
    //   2265: invokevirtual 178	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2268: aload 29
    //   2270: bipush 17
    //   2272: invokevirtual 579	android/widget/TextView:setGravity	(I)V
    //   2275: aload 29
    //   2277: iconst_1
    //   2278: ldc_w 580
    //   2281: invokevirtual 584	android/widget/TextView:setTextSize	(IF)V
    //   2284: aload 29
    //   2286: aload 28
    //   2288: invokevirtual 587	android/widget/TextView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2291: aload 29
    //   2293: aload_0
    //   2294: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2297: invokevirtual 125	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2300: aload 29
    //   2302: ldc_w 588
    //   2305: aload 27
    //   2307: invokevirtual 592	android/widget/TextView:setTag	(ILjava/lang/Object;)V
    //   2310: aload_0
    //   2311: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2314: getfield 467	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:u	Landroid/widget/LinearLayout;
    //   2317: aload 29
    //   2319: aload 30
    //   2321: invokevirtual 596	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2324: goto -210 -> 2114
    //   2327: aload_0
    //   2328: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2331: getfield 467	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:u	Landroid/widget/LinearLayout;
    //   2334: invokevirtual 599	android/widget/LinearLayout:getChildCount	()I
    //   2337: ifne +22 -> 2359
    //   2340: aload_0
    //   2341: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2344: getfield 601	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:s	Landroid/view/View;
    //   2347: bipush 8
    //   2349: invokevirtual 93	android/view/View:setVisibility	(I)V
    //   2352: iload 12
    //   2354: istore 14
    //   2356: goto +102 -> 2458
    //   2359: aload_0
    //   2360: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2363: getfield 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2366: ifnull +18 -> 2384
    //   2369: aload_0
    //   2370: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2373: getfield 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2376: invokeinterface 109 1 0
    //   2381: ifeq +26 -> 2407
    //   2384: iload 12
    //   2386: istore 14
    //   2388: aload 6
    //   2390: ifnull +68 -> 2458
    //   2393: iload 12
    //   2395: istore 14
    //   2397: aload 6
    //   2399: invokeinterface 109 1 0
    //   2404: ifne +54 -> 2458
    //   2407: aload_0
    //   2408: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2411: getfield 601	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:s	Landroid/view/View;
    //   2414: iconst_0
    //   2415: invokevirtual 93	android/view/View:setVisibility	(I)V
    //   2418: iload 12
    //   2420: istore 14
    //   2422: goto +36 -> 2458
    //   2425: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2428: ifeq +13 -> 2441
    //   2431: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   2434: iconst_2
    //   2435: ldc_w 603
    //   2438: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2441: return
    //   2442: aload_0
    //   2443: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2446: getfield 601	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:s	Landroid/view/View;
    //   2449: bipush 8
    //   2451: invokevirtual 93	android/view/View:setVisibility	(I)V
    //   2454: iload 12
    //   2456: istore 14
    //   2458: aload_0
    //   2459: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2462: getfield 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2465: ifnull +306 -> 2771
    //   2468: aload_0
    //   2469: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2472: getfield 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2475: invokeinterface 109 1 0
    //   2480: ifne +291 -> 2771
    //   2483: aload 6
    //   2485: iload_2
    //   2486: aload_0
    //   2487: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2490: getfield 606	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:H	Z
    //   2493: invokestatic 611	com/tencent/mobileqq/search/SearchUtil:a	(Ljava/util/List;ZZ)Ljava/util/List;
    //   2496: astore_3
    //   2497: iload_2
    //   2498: ifne +231 -> 2729
    //   2501: lload 19
    //   2503: aload_0
    //   2504: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2507: invokestatic 614	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:d	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)J
    //   2510: lcmp
    //   2511: ifne +218 -> 2729
    //   2514: iload 10
    //   2516: ifne +213 -> 2729
    //   2519: aload_3
    //   2520: ifnull +209 -> 2729
    //   2523: aload_3
    //   2524: invokeinterface 310 1 0
    //   2529: ifle +200 -> 2729
    //   2532: aload_0
    //   2533: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2536: getfield 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2539: aload_0
    //   2540: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2543: getfield 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2546: invokeinterface 310 1 0
    //   2551: iconst_1
    //   2552: isub
    //   2553: invokeinterface 617 2 0
    //   2558: checkcast 619	com/tencent/mobileqq/search/model/IModel
    //   2561: astore 4
    //   2563: aload_3
    //   2564: iconst_0
    //   2565: invokeinterface 622 2 0
    //   2570: pop
    //   2571: iconst_0
    //   2572: istore 12
    //   2574: iconst_0
    //   2575: istore 13
    //   2577: iload 13
    //   2579: aload_3
    //   2580: invokeinterface 310 1 0
    //   2585: if_icmpge +40 -> 2625
    //   2588: aload_3
    //   2589: iload 13
    //   2591: invokeinterface 617 2 0
    //   2596: checkcast 619	com/tencent/mobileqq/search/model/IModel
    //   2599: instanceof 624
    //   2602: ifeq +6 -> 2608
    //   2605: goto +24 -> 2629
    //   2608: iload 13
    //   2610: iconst_1
    //   2611: iadd
    //   2612: istore 15
    //   2614: iload 13
    //   2616: istore 12
    //   2618: iload 15
    //   2620: istore 13
    //   2622: goto -45 -> 2577
    //   2625: iload 12
    //   2627: istore 13
    //   2629: aload 4
    //   2631: instanceof 278
    //   2634: ifeq +34 -> 2668
    //   2637: aload 4
    //   2639: checkcast 278	com/tencent/mobileqq/search/model/ISearchResultModel
    //   2642: astore 4
    //   2644: aload 4
    //   2646: invokevirtual 627	com/tencent/mobileqq/search/model/ISearchResultModel:ck_	()I
    //   2649: istore 12
    //   2651: aload 4
    //   2653: iload 12
    //   2655: iload 13
    //   2657: iadd
    //   2658: iload 12
    //   2660: iconst_1
    //   2661: isub
    //   2662: invokestatic 632	com/tencent/mobileqq/search/base/util/SearchViewUtils:a	(Lcom/tencent/mobileqq/search/model/ISearchResultModel;II)V
    //   2665: goto +6 -> 2671
    //   2668: iconst_0
    //   2669: istore 12
    //   2671: iconst_0
    //   2672: istore 15
    //   2674: iload 15
    //   2676: iload 13
    //   2678: if_icmpge +51 -> 2729
    //   2681: aload_3
    //   2682: iload 15
    //   2684: invokeinterface 617 2 0
    //   2689: checkcast 619	com/tencent/mobileqq/search/model/IModel
    //   2692: astore 4
    //   2694: aload 4
    //   2696: instanceof 278
    //   2699: ifeq +21 -> 2720
    //   2702: aload 4
    //   2704: checkcast 278	com/tencent/mobileqq/search/model/ISearchResultModel
    //   2707: iload 12
    //   2709: iload 13
    //   2711: iadd
    //   2712: iload 12
    //   2714: iload 15
    //   2716: iadd
    //   2717: invokestatic 632	com/tencent/mobileqq/search/base/util/SearchViewUtils:a	(Lcom/tencent/mobileqq/search/model/ISearchResultModel;II)V
    //   2720: iload 15
    //   2722: iconst_1
    //   2723: iadd
    //   2724: istore 15
    //   2726: goto -52 -> 2674
    //   2729: aload_0
    //   2730: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2733: aload_3
    //   2734: invokevirtual 635	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Ljava/util/List;)V
    //   2737: aload_0
    //   2738: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2741: getfield 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2744: aload_3
    //   2745: invokeinterface 332 2 0
    //   2750: pop
    //   2751: aload_0
    //   2752: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2755: getfield 638	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:j	Lcom/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter;
    //   2758: aload_0
    //   2759: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2762: getfield 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2765: invokevirtual 641	com/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter:a	(Ljava/util/List;)V
    //   2768: goto +642 -> 3410
    //   2771: aload 6
    //   2773: ifnull +31 -> 2804
    //   2776: aload 6
    //   2778: invokeinterface 109 1 0
    //   2783: ifeq +6 -> 2789
    //   2786: goto +18 -> 2804
    //   2789: aload_0
    //   2790: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2793: getfield 135	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:x	Landroid/view/View;
    //   2796: bipush 8
    //   2798: invokevirtual 93	android/view/View:setVisibility	(I)V
    //   2801: goto +560 -> 3361
    //   2804: aload_0
    //   2805: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2808: getfield 135	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:x	Landroid/view/View;
    //   2811: iconst_0
    //   2812: invokevirtual 93	android/view/View:setVisibility	(I)V
    //   2815: aload_0
    //   2816: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2819: getfield 645	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:l	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2822: getstatic 650	com/tencent/mobileqq/app/QQManagerFactory:MAYKNOW_RECOMMEND_MANAGER	I
    //   2825: invokevirtual 656	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2828: checkcast 658	com/tencent/mobileqq/app/MayknowRecommendManager
    //   2831: astore_3
    //   2832: iload 18
    //   2834: ifne +316 -> 3150
    //   2837: aload_3
    //   2838: getfield 660	com/tencent/mobileqq/app/MayknowRecommendManager:j	Z
    //   2841: ifeq +309 -> 3150
    //   2844: aload_0
    //   2845: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2848: getfield 663	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:I	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2851: ifnonnull +275 -> 3126
    //   2854: aload_0
    //   2855: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2858: astore_3
    //   2859: aload_3
    //   2860: new 665	com/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopListWrapperForSearchEmpty
    //   2863: dup
    //   2864: aload_3
    //   2865: getfield 645	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:l	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2868: aload_0
    //   2869: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2872: invokevirtual 373	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2875: aload_0
    //   2876: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2879: getfield 234	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:y	Lcom/tencent/widget/XListView;
    //   2882: aconst_null
    //   2883: invokespecial 668	com/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopListWrapperForSearchEmpty:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/widget/XListView;Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper$RecommendTroopListWrapperCallback;)V
    //   2886: putfield 663	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:I	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2889: aload_0
    //   2890: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2893: getfield 663	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:I	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2896: invokevirtual 673	com/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper:g	()Lcom/tencent/widget/XListView;
    //   2899: astore_3
    //   2900: new 115	android/widget/TextView
    //   2903: dup
    //   2904: aload_0
    //   2905: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2908: invokevirtual 373	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2911: invokespecial 542	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2914: astore 4
    //   2916: aload 4
    //   2918: bipush 17
    //   2920: invokevirtual 579	android/widget/TextView:setGravity	(I)V
    //   2923: aload 4
    //   2925: new 675	com/tencent/widget/AbsListView$LayoutParams
    //   2928: dup
    //   2929: iconst_m1
    //   2930: ldc_w 676
    //   2933: aload_0
    //   2934: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2937: invokevirtual 143	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2940: invokestatic 681	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   2943: invokespecial 682	com/tencent/widget/AbsListView$LayoutParams:<init>	(II)V
    //   2946: invokevirtual 686	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2949: aload 4
    //   2951: aload_0
    //   2952: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2955: invokevirtual 143	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2958: ldc_w 687
    //   2961: invokevirtual 693	android/content/res/Resources:getColor	(I)I
    //   2964: invokevirtual 558	android/widget/TextView:setTextColor	(I)V
    //   2967: aload 4
    //   2969: iconst_1
    //   2970: ldc_w 694
    //   2973: invokevirtual 584	android/widget/TextView:setTextSize	(IF)V
    //   2976: aload 4
    //   2978: ldc_w 695
    //   2981: invokestatic 174	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   2984: invokevirtual 178	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2987: aload 4
    //   2989: ldc_w 696
    //   2992: invokevirtual 699	android/widget/TextView:setBackgroundResource	(I)V
    //   2995: aload_3
    //   2996: aload 4
    //   2998: invokevirtual 705	com/tencent/widget/ListView:addHeaderView	(Landroid/view/View;)V
    //   3001: new 115	android/widget/TextView
    //   3004: dup
    //   3005: aload_0
    //   3006: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3009: invokevirtual 373	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   3012: invokespecial 542	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   3015: astore 4
    //   3017: aload 4
    //   3019: aload_0
    //   3020: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3023: invokevirtual 143	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   3026: ldc_w 687
    //   3029: invokevirtual 693	android/content/res/Resources:getColor	(I)I
    //   3032: invokevirtual 558	android/widget/TextView:setTextColor	(I)V
    //   3035: aload 4
    //   3037: iconst_1
    //   3038: ldc_w 580
    //   3041: invokevirtual 584	android/widget/TextView:setTextSize	(IF)V
    //   3044: aload 4
    //   3046: bipush 16
    //   3048: invokevirtual 579	android/widget/TextView:setGravity	(I)V
    //   3051: aload 4
    //   3053: ldc_w 488
    //   3056: aload_0
    //   3057: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3060: invokevirtual 143	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   3063: invokestatic 681	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   3066: iconst_0
    //   3067: iconst_0
    //   3068: iconst_0
    //   3069: invokevirtual 553	android/widget/TextView:setPadding	(IIII)V
    //   3072: aload 4
    //   3074: new 675	com/tencent/widget/AbsListView$LayoutParams
    //   3077: dup
    //   3078: iconst_m1
    //   3079: ldc_w 706
    //   3082: aload_0
    //   3083: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3086: invokevirtual 143	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   3089: invokestatic 681	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   3092: invokespecial 682	com/tencent/widget/AbsListView$LayoutParams:<init>	(II)V
    //   3095: invokevirtual 686	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   3098: aload 4
    //   3100: ldc_w 707
    //   3103: invokestatic 174	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3106: invokevirtual 178	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3109: aload 4
    //   3111: ldc_w 696
    //   3114: invokevirtual 699	android/widget/TextView:setBackgroundResource	(I)V
    //   3117: aload_3
    //   3118: aload 4
    //   3120: invokevirtual 705	com/tencent/widget/ListView:addHeaderView	(Landroid/view/View;)V
    //   3123: goto +13 -> 3136
    //   3126: aload_0
    //   3127: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3130: getfield 663	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:I	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   3133: invokevirtual 710	com/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper:f	()V
    //   3136: aload_0
    //   3137: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3140: getfield 234	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:y	Lcom/tencent/widget/XListView;
    //   3143: iconst_0
    //   3144: invokevirtual 132	com/tencent/widget/XListView:setVisibility	(I)V
    //   3147: goto +187 -> 3334
    //   3150: aload_0
    //   3151: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3154: getfield 234	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:y	Lcom/tencent/widget/XListView;
    //   3157: bipush 8
    //   3159: invokevirtual 132	com/tencent/widget/XListView:setVisibility	(I)V
    //   3162: aload_0
    //   3163: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3166: getfield 139	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:A	Landroid/graphics/Bitmap;
    //   3169: ifnonnull +65 -> 3234
    //   3172: aload_0
    //   3173: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3176: invokevirtual 23	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:isAdded	()Z
    //   3179: ifeq +55 -> 3234
    //   3182: aload_0
    //   3183: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3186: aload_0
    //   3187: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3190: invokevirtual 143	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   3193: ldc 144
    //   3195: invokestatic 150	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   3198: putfield 139	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:A	Landroid/graphics/Bitmap;
    //   3201: aload_0
    //   3202: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3205: getfield 154	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:z	Landroid/widget/ImageView;
    //   3208: aload_0
    //   3209: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3212: getfield 139	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:A	Landroid/graphics/Bitmap;
    //   3215: invokevirtual 160	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   3218: goto +16 -> 3234
    //   3221: astore_3
    //   3222: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   3225: iconst_1
    //   3226: aload_3
    //   3227: iconst_0
    //   3228: anewarray 162	java/lang/Object
    //   3231: invokestatic 165	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3234: aload_0
    //   3235: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3238: getfield 168	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:B	Landroid/widget/TextView;
    //   3241: ldc 250
    //   3243: invokestatic 174	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3246: invokevirtual 178	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3249: iload 18
    //   3251: ifeq +86 -> 3337
    //   3254: aload_0
    //   3255: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3258: getfield 238	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:C	Landroid/widget/Button;
    //   3261: iconst_0
    //   3262: invokevirtual 241	android/widget/Button:setVisibility	(I)V
    //   3265: aload_0
    //   3266: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3269: getfield 238	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:C	Landroid/widget/Button;
    //   3272: new 712	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1$1
    //   3275: dup
    //   3276: aload_0
    //   3277: aload 4
    //   3279: invokespecial 715	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1$1:<init>	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1;Ljava/lang/String;)V
    //   3282: invokevirtual 716	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3285: aload 8
    //   3287: invokestatic 422	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3290: ifne +44 -> 3334
    //   3293: aload_0
    //   3294: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3297: getfield 238	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:C	Landroid/widget/Button;
    //   3300: aload 8
    //   3302: invokevirtual 717	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   3305: aload_0
    //   3306: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3309: getfield 168	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:B	Landroid/widget/TextView;
    //   3312: iconst_0
    //   3313: aload_0
    //   3314: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3317: getfield 168	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:B	Landroid/widget/TextView;
    //   3320: invokevirtual 721	android/widget/TextView:getContext	()Landroid/content/Context;
    //   3323: ldc_w 488
    //   3326: invokestatic 483	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   3329: iconst_0
    //   3330: iconst_0
    //   3331: invokevirtual 553	android/widget/TextView:setPadding	(IIII)V
    //   3334: goto +15 -> 3349
    //   3337: aload_0
    //   3338: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3341: getfield 238	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:C	Landroid/widget/Button;
    //   3344: bipush 8
    //   3346: invokevirtual 241	android/widget/Button:setVisibility	(I)V
    //   3349: aload_0
    //   3350: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3353: getfield 244	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:O	Landroid/widget/TextView;
    //   3356: bipush 8
    //   3358: invokevirtual 116	android/widget/TextView:setVisibility	(I)V
    //   3361: aload 6
    //   3363: iload_2
    //   3364: aload_0
    //   3365: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3368: getfield 606	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:H	Z
    //   3371: invokestatic 611	com/tencent/mobileqq/search/SearchUtil:a	(Ljava/util/List;ZZ)Ljava/util/List;
    //   3374: astore_3
    //   3375: aload_0
    //   3376: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3379: aload_3
    //   3380: invokevirtual 635	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Ljava/util/List;)V
    //   3383: aload_0
    //   3384: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3387: astore 4
    //   3389: aload 4
    //   3391: aload_3
    //   3392: putfield 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   3395: aload 4
    //   3397: getfield 638	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:j	Lcom/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter;
    //   3400: aload_0
    //   3401: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3404: getfield 104	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   3407: invokevirtual 641	com/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter:a	(Ljava/util/List;)V
    //   3410: aload_0
    //   3411: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3414: lload 21
    //   3416: invokestatic 724	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;J)J
    //   3419: pop2
    //   3420: aload_0
    //   3421: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3424: getfield 419	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:p	Z
    //   3427: ifne +99 -> 3526
    //   3430: aload_0
    //   3431: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3434: astore_3
    //   3435: aload_3
    //   3436: aload_3
    //   3437: getfield 408	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:K	I
    //   3440: iload 14
    //   3442: iadd
    //   3443: putfield 408	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:K	I
    //   3446: aload_0
    //   3447: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3450: astore_3
    //   3451: aload_3
    //   3452: aload_3
    //   3453: getfield 412	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:J	I
    //   3456: iconst_1
    //   3457: iadd
    //   3458: putfield 412	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:J	I
    //   3461: aload_0
    //   3462: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3465: getfield 408	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:K	I
    //   3468: bipush 10
    //   3470: if_icmple +21 -> 3491
    //   3473: aload_0
    //   3474: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3477: astore_3
    //   3478: aload_3
    //   3479: iconst_0
    //   3480: putfield 412	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:J	I
    //   3483: aload_3
    //   3484: iconst_0
    //   3485: putfield 408	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:K	I
    //   3488: goto +38 -> 3526
    //   3491: aload_0
    //   3492: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3495: getfield 412	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:J	I
    //   3498: iconst_3
    //   3499: if_icmplt +14 -> 3513
    //   3502: aload_0
    //   3503: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3506: iconst_1
    //   3507: putfield 419	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:p	Z
    //   3510: goto +16 -> 3526
    //   3513: aload_0
    //   3514: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3517: astore_3
    //   3518: aload_3
    //   3519: aload_3
    //   3520: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   3523: invokevirtual 726	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	(Ljava/lang/String;)V
    //   3526: iload 5
    //   3528: ifeq +116 -> 3644
    //   3531: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3534: ifeq +220 -> 3754
    //   3537: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   3540: astore_3
    //   3541: new 28	java/lang/StringBuilder
    //   3544: dup
    //   3545: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   3548: astore 4
    //   3550: aload 4
    //   3552: ldc_w 728
    //   3555: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3558: pop
    //   3559: aload 4
    //   3561: aload 7
    //   3563: invokestatic 194	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3566: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3569: pop
    //   3570: aload 4
    //   3572: ldc 196
    //   3574: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3577: pop
    //   3578: aload 4
    //   3580: aload_1
    //   3581: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3584: pop
    //   3585: aload 4
    //   3587: ldc 198
    //   3589: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3592: pop
    //   3593: aload 4
    //   3595: aload_0
    //   3596: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3599: getfield 201	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:N	Ljava/lang/String;
    //   3602: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3605: pop
    //   3606: aload 4
    //   3608: ldc_w 730
    //   3611: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3614: pop
    //   3615: aload 4
    //   3617: aload_0
    //   3618: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3621: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   3624: invokestatic 194	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3627: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3630: pop
    //   3631: aload_3
    //   3632: iconst_2
    //   3633: aload 4
    //   3635: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3638: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3641: goto +113 -> 3754
    //   3644: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3647: ifeq +107 -> 3754
    //   3650: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   3653: astore_3
    //   3654: new 28	java/lang/StringBuilder
    //   3657: dup
    //   3658: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   3661: astore 4
    //   3663: aload 4
    //   3665: ldc_w 732
    //   3668: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3671: pop
    //   3672: aload 4
    //   3674: aload 7
    //   3676: invokestatic 194	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3679: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3682: pop
    //   3683: aload 4
    //   3685: ldc 196
    //   3687: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3690: pop
    //   3691: aload 4
    //   3693: aload_1
    //   3694: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3697: pop
    //   3698: aload 4
    //   3700: ldc 198
    //   3702: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3705: pop
    //   3706: aload 4
    //   3708: aload_0
    //   3709: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3712: getfield 201	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:N	Ljava/lang/String;
    //   3715: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3718: pop
    //   3719: aload 4
    //   3721: ldc_w 730
    //   3724: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3727: pop
    //   3728: aload 4
    //   3730: aload_0
    //   3731: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3734: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   3737: invokestatic 194	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3740: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3743: pop
    //   3744: aload_3
    //   3745: iconst_2
    //   3746: aload 4
    //   3748: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3751: invokestatic 227	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3754: iconst_1
    //   3755: putstatic 734	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:q	Z
    //   3758: return
    //   3759: getstatic 26	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   3762: astore_3
    //   3763: new 28	java/lang/StringBuilder
    //   3766: dup
    //   3767: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   3770: astore 4
    //   3772: aload 4
    //   3774: ldc_w 736
    //   3777: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3780: pop
    //   3781: aload 4
    //   3783: aload_0
    //   3784: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3787: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   3790: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3793: pop
    //   3794: aload 4
    //   3796: ldc_w 738
    //   3799: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3802: pop
    //   3803: aload 4
    //   3805: aload 7
    //   3807: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3810: pop
    //   3811: aload 4
    //   3813: ldc_w 740
    //   3816: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3819: pop
    //   3820: aload 4
    //   3822: aload_1
    //   3823: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3826: pop
    //   3827: aload 4
    //   3829: ldc 211
    //   3831: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3834: pop
    //   3835: aload 4
    //   3837: aload_0
    //   3838: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$1:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3841: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   3844: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3847: pop
    //   3848: aload 4
    //   3850: ldc 215
    //   3852: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3855: pop
    //   3856: aload 4
    //   3858: iload 5
    //   3860: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3863: pop
    //   3864: aload_3
    //   3865: iconst_2
    //   3866: aload 4
    //   3868: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3871: invokestatic 220	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3874: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3875	0	this	1
    //   0	3875	1	paramString1	String
    //   0	3875	2	paramBoolean1	boolean
    //   0	3875	3	paramString2	String
    //   0	3875	4	paramArrayOfByte	byte[]
    //   0	3875	5	paramBoolean2	boolean
    //   0	3875	6	paramList	List<com.tencent.mobileqq.search.model.ISearchResultGroupModel>
    //   0	3875	7	paramArrayOfLong	long[]
    //   0	3875	8	paramString3	String
    //   0	3875	9	paramList1	List<tencent.im.oidb.search.DynamicTabSearch.SubHotWord>
    //   0	3875	10	paramBoolean3	boolean
    //   0	3875	11	paramString4	String
    //   0	3875	12	paramInt	int
    //   571	2141	13	i	int
    //   1847	1596	14	j	int
    //   2023	702	15	k	int
    //   2031	167	16	m	int
    //   1627	584	17	bool1	boolean
    //   1653	1597	18	bool2	boolean
    //   538	1964	19	l1	long
    //   542	2873	21	l2	long
    //   579	316	23	l3	long
    //   575	316	25	l4	long
    //   533	1773	27	localObject1	Object
    //   567	1720	28	localObject2	Object
    //   602	1716	29	localObject3	Object
    //   609	1711	30	localObject4	Object
    //   618	13	31	localIterator	java.util.Iterator
    //   640	31	32	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   433	465	468	java/lang/OutOfMemoryError
    //   1638	1648	1658	org/json/JSONException
    //   1629	1638	1663	org/json/JSONException
    //   1608	1629	1672	org/json/JSONException
    //   3172	3218	3221	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment.1
 * JD-Core Version:    0.7.0.1
 */