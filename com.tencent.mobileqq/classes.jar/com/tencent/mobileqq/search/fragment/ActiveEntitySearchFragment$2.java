package com.tencent.mobileqq.search.fragment;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.Arrays;
import java.util.List;

class ActiveEntitySearchFragment$2
  extends UniteSearchObserver
{
  ActiveEntitySearchFragment$2(ActiveEntitySearchFragment paramActiveEntitySearchFragment) {}
  
  public void handleTabSearchError(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (!this.a.isAdded())
    {
      paramArrayOfLong = ActiveEntitySearchFragment.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTabSearchError, fragment is detached ..., reqKeyword=");
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
        this.a.P.setOnClickListener(new ActiveEntitySearchFragment.2.3(this));
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
        this.a.B.setText(HardCodeUtil.a(2131898044));
        this.a.x.setOnClickListener(new ActiveEntitySearchFragment.2.2(this));
      }
      if (QLog.isColorLevel())
      {
        paramString2 = ActiveEntitySearchFragment.a;
        paramString3 = new StringBuilder();
        paramString3.append("handleTabSearchError code=");
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
  public void handleTabSearchResult(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<com.tencent.mobileqq.search.model.ISearchResultGroupModel> paramList, long[] paramArrayOfLong, String paramString3, List<tencent.im.oidb.search.DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   4: invokevirtual 24	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:isAdded	()Z
    //   7: ifne +117 -> 124
    //   10: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   13: astore 4
    //   15: new 29	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   22: astore 6
    //   24: aload 6
    //   26: ldc 211
    //   28: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 6
    //   34: aload_1
    //   35: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 6
    //   41: ldc 213
    //   43: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 6
    //   49: aload_0
    //   50: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   53: getfield 79	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   56: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 6
    //   62: ldc 43
    //   64: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 6
    //   70: aload_3
    //   71: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 6
    //   77: ldc 215
    //   79: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 6
    //   85: aload_0
    //   86: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   89: getfield 63	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:D	Ljava/lang/String;
    //   92: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 6
    //   98: ldc 217
    //   100: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 6
    //   106: iload 5
    //   108: invokevirtual 41	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 4
    //   114: iconst_1
    //   115: aload 6
    //   117: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: return
    //   124: aload_3
    //   125: aload_0
    //   126: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   129: getfield 63	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:D	Ljava/lang/String;
    //   132: invokestatic 69	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   135: ifne +117 -> 252
    //   138: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   141: astore 4
    //   143: new 29	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   150: astore 6
    //   152: aload 6
    //   154: ldc 219
    //   156: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 6
    //   162: aload_1
    //   163: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 6
    //   169: ldc 213
    //   171: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 6
    //   177: aload_0
    //   178: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   181: getfield 79	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   184: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 6
    //   190: ldc 43
    //   192: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 6
    //   198: aload_3
    //   199: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 6
    //   205: ldc 215
    //   207: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 6
    //   213: aload_0
    //   214: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   217: getfield 63	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:D	Ljava/lang/String;
    //   220: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 6
    //   226: ldc 217
    //   228: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 6
    //   234: iload 5
    //   236: invokevirtual 41	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 4
    //   242: iconst_2
    //   243: aload 6
    //   245: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: return
    //   252: aload_0
    //   253: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   256: getfield 73	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   259: aload 7
    //   261: invokestatic 76	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	([J[J)Z
    //   264: ifeq +3284 -> 3548
    //   267: aload_1
    //   268: aload_0
    //   269: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   272: getfield 79	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   275: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifne +6 -> 284
    //   281: goto +3267 -> 3548
    //   284: aload 6
    //   286: ifnonnull +63 -> 349
    //   289: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +44 -> 336
    //   295: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   298: astore 4
    //   300: new 29	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   307: astore 8
    //   309: aload 8
    //   311: ldc 224
    //   313: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 8
    //   319: aload 6
    //   321: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 4
    //   327: iconst_2
    //   328: aload 8
    //   330: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 229	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload_0
    //   337: aload_1
    //   338: iload_2
    //   339: aload_3
    //   340: iconst_m1
    //   341: ldc 231
    //   343: aload 7
    //   345: invokevirtual 233	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:handleTabSearchError	(Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;[J)V
    //   348: return
    //   349: new 235	java/util/HashSet
    //   352: dup
    //   353: invokespecial 236	java/util/HashSet:<init>	()V
    //   356: astore_3
    //   357: aload 6
    //   359: invokeinterface 240 1 0
    //   364: astore 27
    //   366: ldc2_w 241
    //   369: lstore 21
    //   371: iconst_0
    //   372: istore 14
    //   374: ldc2_w 241
    //   377: lstore 19
    //   379: aload 27
    //   381: invokeinterface 247 1 0
    //   386: ifeq +347 -> 733
    //   389: aload 27
    //   391: invokeinterface 251 1 0
    //   396: checkcast 253	com/tencent/mobileqq/search/model/ISearchResultGroupModel
    //   399: astore 28
    //   401: lload 21
    //   403: lstore 25
    //   405: iload 14
    //   407: istore 12
    //   409: lload 19
    //   411: lstore 23
    //   413: aload 28
    //   415: invokevirtual 256	com/tencent/mobileqq/search/model/ISearchResultGroupModel:b	()Ljava/util/List;
    //   418: ifnull +300 -> 718
    //   421: aload 28
    //   423: instanceof 258
    //   426: ifeq +269 -> 695
    //   429: aload 28
    //   431: checkcast 258	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel
    //   434: astore 29
    //   436: aload 29
    //   438: invokevirtual 259	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:b	()Ljava/util/List;
    //   441: astore 30
    //   443: aload 30
    //   445: invokeinterface 240 1 0
    //   450: astore 31
    //   452: aload 31
    //   454: invokeinterface 247 1 0
    //   459: ifeq +61 -> 520
    //   462: aload 31
    //   464: invokeinterface 251 1 0
    //   469: checkcast 261	com/tencent/mobileqq/search/model/ISearchResultModel
    //   472: astore 32
    //   474: aload 32
    //   476: instanceof 263
    //   479: ifeq -27 -> 452
    //   482: aload 32
    //   484: checkcast 263	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem
    //   487: astore 32
    //   489: getstatic 268	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:s	Z
    //   492: ifeq +9 -> 501
    //   495: aload 32
    //   497: iconst_1
    //   498: putfield 272	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:Y	I
    //   501: aload_3
    //   502: aload 32
    //   504: invokevirtual 276	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:j	()I
    //   507: i2l
    //   508: invokestatic 282	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   511: invokeinterface 287 2 0
    //   516: pop
    //   517: goto -65 -> 452
    //   520: lload 19
    //   522: lstore 23
    //   524: lload 19
    //   526: ldc2_w 241
    //   529: lcmp
    //   530: ifne +10 -> 540
    //   533: aload 29
    //   535: getfield 290	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   538: lstore 23
    //   540: aload 29
    //   542: getfield 290	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   545: lstore 25
    //   547: aload 30
    //   549: invokeinterface 293 1 0
    //   554: ifle +59 -> 613
    //   557: lload 25
    //   559: lstore 21
    //   561: aload 29
    //   563: getfield 290	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   566: ldc2_w 294
    //   569: lcmp
    //   570: ifne +43 -> 613
    //   573: aconst_null
    //   574: ldc_w 297
    //   577: ldc_w 299
    //   580: ldc_w 299
    //   583: ldc_w 301
    //   586: ldc_w 301
    //   589: iconst_1
    //   590: iconst_0
    //   591: ldc_w 299
    //   594: ldc_w 299
    //   597: ldc_w 299
    //   600: ldc_w 299
    //   603: invokestatic 306	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   606: lload 23
    //   608: lstore 19
    //   610: goto +85 -> 695
    //   613: lload 23
    //   615: lstore 19
    //   617: lload 25
    //   619: lstore 21
    //   621: aload 30
    //   623: invokeinterface 293 1 0
    //   628: ifle +67 -> 695
    //   631: lload 23
    //   633: lstore 19
    //   635: lload 25
    //   637: lstore 21
    //   639: aload 29
    //   641: getfield 290	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   644: ldc2_w 307
    //   647: lcmp
    //   648: ifne +47 -> 695
    //   651: aconst_null
    //   652: ldc_w 297
    //   655: ldc_w 299
    //   658: ldc_w 299
    //   661: ldc_w 301
    //   664: ldc_w 301
    //   667: iconst_2
    //   668: iconst_0
    //   669: ldc_w 299
    //   672: ldc_w 299
    //   675: ldc_w 299
    //   678: ldc_w 299
    //   681: invokestatic 306	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   684: lload 23
    //   686: lstore 19
    //   688: lload 25
    //   690: lstore 21
    //   692: goto +3 -> 695
    //   695: iload 14
    //   697: aload 28
    //   699: invokevirtual 256	com/tencent/mobileqq/search/model/ISearchResultGroupModel:b	()Ljava/util/List;
    //   702: invokeinterface 293 1 0
    //   707: iadd
    //   708: istore 12
    //   710: lload 19
    //   712: lstore 23
    //   714: lload 21
    //   716: lstore 25
    //   718: lload 25
    //   720: lstore 21
    //   722: iload 12
    //   724: istore 14
    //   726: lload 23
    //   728: lstore 19
    //   730: goto -351 -> 379
    //   733: aload_0
    //   734: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   737: getfield 311	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:G	Ljava/util/List;
    //   740: aload_3
    //   741: invokeinterface 315 2 0
    //   746: pop
    //   747: aload_0
    //   748: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   751: aload 8
    //   753: invokestatic 318	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;Ljava/lang/String;)Ljava/lang/String;
    //   756: pop
    //   757: aload_0
    //   758: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   761: aload 9
    //   763: invokestatic 321	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;Ljava/util/List;)Ljava/util/List;
    //   766: pop
    //   767: ldc_w 299
    //   770: astore 27
    //   772: iload_2
    //   773: ifne +77 -> 850
    //   776: new 323	java/util/ArrayList
    //   779: dup
    //   780: invokespecial 324	java/util/ArrayList:<init>	()V
    //   783: astore 8
    //   785: aload 8
    //   787: aload_3
    //   788: invokeinterface 315 2 0
    //   793: pop
    //   794: ldc_w 326
    //   797: ldc_w 328
    //   800: iconst_4
    //   801: anewarray 81	java/lang/String
    //   804: dup
    //   805: iconst_0
    //   806: aload_0
    //   807: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   810: getfield 79	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   813: aastore
    //   814: dup
    //   815: iconst_1
    //   816: aload 8
    //   818: invokestatic 333	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/List;)Ljava/lang/String;
    //   821: aastore
    //   822: dup
    //   823: iconst_2
    //   824: ldc_w 299
    //   827: aastore
    //   828: dup
    //   829: iconst_3
    //   830: ldc_w 335
    //   833: aload_0
    //   834: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   837: getfield 73	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   840: invokestatic 338	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   843: aastore
    //   844: invokestatic 341	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   847: goto +3 -> 850
    //   850: aload_0
    //   851: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   854: getfield 105	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   857: aload 6
    //   859: iload_2
    //   860: iconst_1
    //   861: ixor
    //   862: aload_0
    //   863: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   866: getfield 73	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   869: aload_0
    //   870: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   873: getfield 202	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:N	Ljava/lang/String;
    //   876: aload_0
    //   877: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   880: getfield 79	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   883: invokestatic 346	com/tencent/mobileqq/search/util/ReportUtil:a	(Ljava/util/List;Ljava/util/List;Z[JLjava/lang/String;Ljava/lang/String;)V
    //   886: iload 14
    //   888: ifne +160 -> 1048
    //   891: aload_0
    //   892: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   895: invokevirtual 350	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   898: instanceof 352
    //   901: ifeq +320 -> 1221
    //   904: aload_0
    //   905: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   908: invokevirtual 350	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   911: checkcast 352	com/tencent/mobileqq/search/base/api/SearchInfoInterface
    //   914: invokeinterface 354 1 0
    //   919: istore 12
    //   921: iload 12
    //   923: iconst_1
    //   924: if_icmpeq +68 -> 992
    //   927: iload 12
    //   929: iconst_3
    //   930: if_icmpeq +6 -> 936
    //   933: goto +288 -> 1221
    //   936: ldc_w 326
    //   939: ldc_w 356
    //   942: iconst_4
    //   943: anewarray 81	java/lang/String
    //   946: dup
    //   947: iconst_0
    //   948: aload_0
    //   949: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   952: getfield 79	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   955: aastore
    //   956: dup
    //   957: iconst_1
    //   958: aload_0
    //   959: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   962: getfield 73	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   965: invokestatic 358	com/tencent/mobileqq/search/util/SearchUtils:a	([J)Ljava/lang/String;
    //   968: aastore
    //   969: dup
    //   970: iconst_2
    //   971: ldc_w 299
    //   974: aastore
    //   975: dup
    //   976: iconst_3
    //   977: ldc_w 335
    //   980: aload 7
    //   982: invokestatic 338	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   985: aastore
    //   986: invokestatic 341	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   989: goto +232 -> 1221
    //   992: ldc_w 360
    //   995: ldc_w 362
    //   998: iconst_4
    //   999: anewarray 81	java/lang/String
    //   1002: dup
    //   1003: iconst_0
    //   1004: aload_0
    //   1005: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1008: getfield 79	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   1011: aastore
    //   1012: dup
    //   1013: iconst_1
    //   1014: aload_0
    //   1015: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1018: getfield 73	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   1021: invokestatic 358	com/tencent/mobileqq/search/util/SearchUtils:a	([J)Ljava/lang/String;
    //   1024: aastore
    //   1025: dup
    //   1026: iconst_2
    //   1027: ldc_w 299
    //   1030: aastore
    //   1031: dup
    //   1032: iconst_3
    //   1033: ldc_w 335
    //   1036: aload 7
    //   1038: invokestatic 338	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1041: aastore
    //   1042: invokestatic 341	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1045: goto +176 -> 1221
    //   1048: aload_0
    //   1049: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1052: getfield 366	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:o	[B
    //   1055: ifnonnull +166 -> 1221
    //   1058: aload_0
    //   1059: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1062: invokevirtual 350	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1065: instanceof 352
    //   1068: ifeq +153 -> 1221
    //   1071: aload_0
    //   1072: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1075: invokevirtual 350	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1078: checkcast 352	com/tencent/mobileqq/search/base/api/SearchInfoInterface
    //   1081: astore_3
    //   1082: aload_3
    //   1083: invokeinterface 354 1 0
    //   1088: istore 12
    //   1090: iload 12
    //   1092: iconst_1
    //   1093: if_icmpeq +71 -> 1164
    //   1096: iload 12
    //   1098: iconst_3
    //   1099: if_icmpeq +6 -> 1105
    //   1102: goto +119 -> 1221
    //   1105: ldc_w 326
    //   1108: ldc_w 368
    //   1111: iconst_4
    //   1112: anewarray 81	java/lang/String
    //   1115: dup
    //   1116: iconst_0
    //   1117: aload_3
    //   1118: invokeinterface 371 1 0
    //   1123: aastore
    //   1124: dup
    //   1125: iconst_1
    //   1126: aload_0
    //   1127: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1130: getfield 311	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:G	Ljava/util/List;
    //   1133: invokestatic 333	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/List;)Ljava/lang/String;
    //   1136: aastore
    //   1137: dup
    //   1138: iconst_2
    //   1139: ldc_w 299
    //   1142: aastore
    //   1143: dup
    //   1144: iconst_3
    //   1145: ldc_w 335
    //   1148: aload_3
    //   1149: invokeinterface 374 1 0
    //   1154: invokestatic 338	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1157: aastore
    //   1158: invokestatic 341	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1161: goto +60 -> 1221
    //   1164: ldc_w 360
    //   1167: ldc_w 376
    //   1170: iconst_4
    //   1171: anewarray 81	java/lang/String
    //   1174: dup
    //   1175: iconst_0
    //   1176: aload_0
    //   1177: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1180: getfield 79	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   1183: aastore
    //   1184: dup
    //   1185: iconst_1
    //   1186: aload_0
    //   1187: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1190: getfield 311	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:G	Ljava/util/List;
    //   1193: invokestatic 333	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/List;)Ljava/lang/String;
    //   1196: aastore
    //   1197: dup
    //   1198: iconst_2
    //   1199: ldc_w 299
    //   1202: aastore
    //   1203: dup
    //   1204: iconst_3
    //   1205: ldc_w 378
    //   1208: aload_3
    //   1209: invokeinterface 374 1 0
    //   1214: invokestatic 338	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1217: aastore
    //   1218: invokestatic 341	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1221: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1224: ifeq +103 -> 1327
    //   1227: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   1230: astore_3
    //   1231: new 29	java/lang/StringBuilder
    //   1234: dup
    //   1235: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1238: astore 8
    //   1240: aload 8
    //   1242: ldc_w 380
    //   1245: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: pop
    //   1249: aload 8
    //   1251: iload_2
    //   1252: invokevirtual 41	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1255: pop
    //   1256: aload 8
    //   1258: ldc_w 382
    //   1261: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: pop
    //   1265: aload 8
    //   1267: aload_0
    //   1268: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1271: getfield 385	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:K	I
    //   1274: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: aload 8
    //   1280: ldc_w 387
    //   1283: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1286: pop
    //   1287: aload 8
    //   1289: aload_0
    //   1290: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1293: getfield 389	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:J	I
    //   1296: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1299: pop
    //   1300: aload 8
    //   1302: ldc_w 391
    //   1305: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: pop
    //   1309: aload 8
    //   1311: iload 14
    //   1313: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1316: pop
    //   1317: aload_3
    //   1318: iconst_2
    //   1319: aload 8
    //   1321: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1324: invokestatic 229	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1327: aload_0
    //   1328: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1331: getfield 88	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:v	Landroid/view/View;
    //   1334: bipush 8
    //   1336: invokevirtual 94	android/view/View:setVisibility	(I)V
    //   1339: aload_0
    //   1340: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1343: getfield 393	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:w	Landroid/view/View;
    //   1346: bipush 8
    //   1348: invokevirtual 94	android/view/View:setVisibility	(I)V
    //   1351: aload_0
    //   1352: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1355: getfield 130	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:i	Lcom/tencent/widget/XListView;
    //   1358: iconst_0
    //   1359: invokevirtual 133	com/tencent/widget/XListView:setVisibility	(I)V
    //   1362: aload_0
    //   1363: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1366: getfield 101	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:q	Landroid/view/View;
    //   1369: bipush 8
    //   1371: invokevirtual 94	android/view/View:setVisibility	(I)V
    //   1374: aload_0
    //   1375: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1378: astore_3
    //   1379: aload_3
    //   1380: iconst_0
    //   1381: putfield 98	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:E	Z
    //   1384: aload_3
    //   1385: aload 4
    //   1387: putfield 366	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:o	[B
    //   1390: aload_3
    //   1391: iload 5
    //   1393: putfield 396	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:p	Z
    //   1396: aload 11
    //   1398: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1401: ifne +156 -> 1557
    //   1404: new 401	org/json/JSONObject
    //   1407: dup
    //   1408: aload 11
    //   1410: invokespecial 404	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1413: astore 4
    //   1415: aload 4
    //   1417: ldc_w 406
    //   1420: invokevirtual 410	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1423: istore 17
    //   1425: aload 4
    //   1427: ldc_w 412
    //   1430: invokevirtual 416	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1433: astore_3
    //   1434: aload 4
    //   1436: ldc_w 418
    //   1439: invokevirtual 416	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1442: astore 9
    //   1444: iload 17
    //   1446: istore 18
    //   1448: aload_3
    //   1449: astore 8
    //   1451: goto +99 -> 1550
    //   1454: astore 4
    //   1456: goto +21 -> 1477
    //   1459: astore 4
    //   1461: ldc_w 299
    //   1464: astore_3
    //   1465: goto +12 -> 1477
    //   1468: astore 4
    //   1470: ldc_w 299
    //   1473: astore_3
    //   1474: iconst_0
    //   1475: istore 17
    //   1477: iload 17
    //   1479: istore 18
    //   1481: aload_3
    //   1482: astore 8
    //   1484: aload 27
    //   1486: astore 9
    //   1488: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1491: ifeq +59 -> 1550
    //   1494: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   1497: astore 8
    //   1499: new 29	java/lang/StringBuilder
    //   1502: dup
    //   1503: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1506: astore 9
    //   1508: aload 9
    //   1510: ldc_w 420
    //   1513: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: pop
    //   1517: aload 9
    //   1519: aload 4
    //   1521: invokestatic 424	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1524: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: pop
    //   1528: aload 8
    //   1530: iconst_2
    //   1531: aload 9
    //   1533: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1536: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1539: aload 27
    //   1541: astore 9
    //   1543: aload_3
    //   1544: astore 8
    //   1546: iload 17
    //   1548: istore 18
    //   1550: iload 18
    //   1552: istore 17
    //   1554: goto +31 -> 1585
    //   1557: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1560: ifeq +13 -> 1573
    //   1563: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   1566: iconst_2
    //   1567: ldc_w 426
    //   1570: invokestatic 229	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1573: ldc_w 299
    //   1576: astore 9
    //   1578: aload 9
    //   1580: astore 8
    //   1582: iconst_0
    //   1583: istore 17
    //   1585: iload 5
    //   1587: ifeq +134 -> 1721
    //   1590: aload_0
    //   1591: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1594: getfield 429	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:O	Landroid/widget/TextView;
    //   1597: iconst_0
    //   1598: invokevirtual 117	android/widget/TextView:setVisibility	(I)V
    //   1601: aload_0
    //   1602: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1605: getfield 73	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   1608: ifnull +113 -> 1721
    //   1611: aload_0
    //   1612: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1615: getfield 73	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   1618: arraylength
    //   1619: iconst_2
    //   1620: if_icmpne +101 -> 1721
    //   1623: new 323	java/util/ArrayList
    //   1626: dup
    //   1627: invokespecial 324	java/util/ArrayList:<init>	()V
    //   1630: astore_3
    //   1631: aload_0
    //   1632: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1635: getfield 73	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   1638: astore 4
    //   1640: aload 4
    //   1642: arraylength
    //   1643: istore 13
    //   1645: iconst_0
    //   1646: istore 12
    //   1648: iload 12
    //   1650: iload 13
    //   1652: if_icmpge +27 -> 1679
    //   1655: aload_3
    //   1656: aload 4
    //   1658: iload 12
    //   1660: laload
    //   1661: invokestatic 282	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1664: invokeinterface 430 2 0
    //   1669: pop
    //   1670: iload 12
    //   1672: iconst_1
    //   1673: iadd
    //   1674: istore 12
    //   1676: goto -28 -> 1648
    //   1679: aload_3
    //   1680: ldc2_w 294
    //   1683: invokestatic 282	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1686: invokeinterface 433 2 0
    //   1691: ifeq +30 -> 1721
    //   1694: aload_3
    //   1695: ldc2_w 307
    //   1698: invokestatic 282	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1701: invokeinterface 433 2 0
    //   1706: ifeq +15 -> 1721
    //   1709: aload_0
    //   1710: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1713: getfield 429	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:O	Landroid/widget/TextView;
    //   1716: bipush 8
    //   1718: invokevirtual 117	android/widget/TextView:setVisibility	(I)V
    //   1721: aload_0
    //   1722: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1725: invokestatic 436	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/lang/String;
    //   1728: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1731: ifne +493 -> 2224
    //   1734: aload_0
    //   1735: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1738: invokestatic 440	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:c	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/util/List;
    //   1741: invokeinterface 293 1 0
    //   1746: ifle +478 -> 2224
    //   1749: aload_0
    //   1750: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1753: getfield 443	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:t	Landroid/widget/TextView;
    //   1756: aload_0
    //   1757: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1760: invokestatic 436	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/lang/String;
    //   1763: invokevirtual 179	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1766: aload_0
    //   1767: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1770: getfield 447	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:u	Landroid/widget/LinearLayout;
    //   1773: invokevirtual 452	android/widget/LinearLayout:removeAllViews	()V
    //   1776: aload_0
    //   1777: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1780: invokevirtual 350	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1783: astore_3
    //   1784: aload_3
    //   1785: ifnull +422 -> 2207
    //   1788: aload_3
    //   1789: invokevirtual 457	com/tencent/mobileqq/app/BaseActivity:isFinishing	()Z
    //   1792: ifeq +6 -> 1798
    //   1795: goto +412 -> 2207
    //   1798: aload_3
    //   1799: ldc_w 458
    //   1802: invokestatic 463	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1805: istore 13
    //   1807: aload_3
    //   1808: ldc_w 464
    //   1811: invokestatic 463	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1814: istore 15
    //   1816: aload_3
    //   1817: fconst_2
    //   1818: invokestatic 463	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1821: istore 16
    //   1823: new 466	android/graphics/drawable/GradientDrawable
    //   1826: dup
    //   1827: invokespecial 467	android/graphics/drawable/GradientDrawable:<init>	()V
    //   1830: astore 11
    //   1832: aload 11
    //   1834: aload_0
    //   1835: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1838: invokevirtual 350	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1841: ldc_w 468
    //   1844: invokestatic 463	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1847: i2f
    //   1848: invokevirtual 472	android/graphics/drawable/GradientDrawable:setCornerRadius	(F)V
    //   1851: ldc_w 474
    //   1854: invokestatic 480	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1857: istore 12
    //   1859: invokestatic 486	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1862: invokevirtual 490	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1865: invokestatic 496	com/tencent/mobileqq/vas/theme/api/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   1868: istore 18
    //   1870: iload 18
    //   1872: ifeq +11 -> 1883
    //   1875: ldc_w 498
    //   1878: invokestatic 480	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1881: istore 12
    //   1883: aload 11
    //   1885: iconst_1
    //   1886: iload 12
    //   1888: invokevirtual 502	android/graphics/drawable/GradientDrawable:setStroke	(II)V
    //   1891: aload_0
    //   1892: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1895: invokestatic 440	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:c	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/util/List;
    //   1898: invokeinterface 240 1 0
    //   1903: astore 4
    //   1905: aload 4
    //   1907: invokeinterface 247 1 0
    //   1912: ifeq +207 -> 2119
    //   1915: aload 4
    //   1917: invokeinterface 251 1 0
    //   1922: checkcast 504	tencent/im/oidb/search/DynamicTabSearch$SubHotWord
    //   1925: astore 27
    //   1927: aload 27
    //   1929: getfield 508	tencent/im/oidb/search/DynamicTabSearch$SubHotWord:show_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1932: invokevirtual 514	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1935: invokevirtual 519	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1938: astore 28
    //   1940: aload 28
    //   1942: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1945: ifeq +6 -> 1951
    //   1948: goto -43 -> 1905
    //   1951: new 116	android/widget/TextView
    //   1954: dup
    //   1955: aload_3
    //   1956: invokespecial 522	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   1959: astore 29
    //   1961: new 524	android/widget/LinearLayout$LayoutParams
    //   1964: dup
    //   1965: bipush 254
    //   1967: bipush 254
    //   1969: invokespecial 526	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   1972: astore 30
    //   1974: aload 30
    //   1976: iload 13
    //   1978: putfield 529	android/widget/LinearLayout$LayoutParams:rightMargin	I
    //   1981: aload 29
    //   1983: iload 15
    //   1985: iload 16
    //   1987: iload 15
    //   1989: iload 16
    //   1991: invokevirtual 533	android/widget/TextView:setPadding	(IIII)V
    //   1994: ldc_w 535
    //   1997: invokestatic 480	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   2000: istore 12
    //   2002: iload 18
    //   2004: ifeq +11 -> 2015
    //   2007: ldc_w 498
    //   2010: invokestatic 480	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   2013: istore 12
    //   2015: aload 29
    //   2017: iload 12
    //   2019: invokevirtual 538	android/widget/TextView:setTextColor	(I)V
    //   2022: getstatic 543	android/os/Build$VERSION:SDK_INT	I
    //   2025: bipush 16
    //   2027: if_icmpge +16 -> 2043
    //   2030: aload 29
    //   2032: aload 11
    //   2034: invokevirtual 549	android/graphics/drawable/Drawable:mutate	()Landroid/graphics/drawable/Drawable;
    //   2037: invokevirtual 553	android/widget/TextView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2040: goto +13 -> 2053
    //   2043: aload 29
    //   2045: aload 11
    //   2047: invokevirtual 549	android/graphics/drawable/Drawable:mutate	()Landroid/graphics/drawable/Drawable;
    //   2050: invokevirtual 556	android/widget/TextView:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   2053: aload 29
    //   2055: aload 28
    //   2057: invokevirtual 179	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2060: aload 29
    //   2062: bipush 17
    //   2064: invokevirtual 559	android/widget/TextView:setGravity	(I)V
    //   2067: aload 29
    //   2069: iconst_1
    //   2070: ldc_w 560
    //   2073: invokevirtual 564	android/widget/TextView:setTextSize	(IF)V
    //   2076: aload 29
    //   2078: aload 28
    //   2080: invokevirtual 567	android/widget/TextView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2083: aload 29
    //   2085: aload_0
    //   2086: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2089: invokevirtual 126	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2092: aload 29
    //   2094: ldc_w 568
    //   2097: aload 27
    //   2099: invokevirtual 572	android/widget/TextView:setTag	(ILjava/lang/Object;)V
    //   2102: aload_0
    //   2103: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2106: getfield 447	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:u	Landroid/widget/LinearLayout;
    //   2109: aload 29
    //   2111: aload 30
    //   2113: invokevirtual 576	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2116: goto -168 -> 1948
    //   2119: aload_0
    //   2120: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2123: getfield 447	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:u	Landroid/widget/LinearLayout;
    //   2126: invokevirtual 579	android/widget/LinearLayout:getChildCount	()I
    //   2129: ifne +18 -> 2147
    //   2132: aload_0
    //   2133: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2136: getfield 581	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:s	Landroid/view/View;
    //   2139: bipush 8
    //   2141: invokevirtual 94	android/view/View:setVisibility	(I)V
    //   2144: goto +92 -> 2236
    //   2147: aload_0
    //   2148: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2151: getfield 105	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2154: ifnull +24 -> 2178
    //   2157: aload_0
    //   2158: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2161: getfield 105	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2164: invokeinterface 110 1 0
    //   2169: ifeq +6 -> 2175
    //   2172: goto +6 -> 2178
    //   2175: goto +18 -> 2193
    //   2178: aload 6
    //   2180: ifnull +56 -> 2236
    //   2183: aload 6
    //   2185: invokeinterface 110 1 0
    //   2190: ifne +46 -> 2236
    //   2193: aload_0
    //   2194: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2197: getfield 581	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:s	Landroid/view/View;
    //   2200: iconst_0
    //   2201: invokevirtual 94	android/view/View:setVisibility	(I)V
    //   2204: goto +32 -> 2236
    //   2207: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2210: ifeq +13 -> 2223
    //   2213: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   2216: iconst_2
    //   2217: ldc_w 583
    //   2220: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2223: return
    //   2224: aload_0
    //   2225: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2228: getfield 581	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:s	Landroid/view/View;
    //   2231: bipush 8
    //   2233: invokevirtual 94	android/view/View:setVisibility	(I)V
    //   2236: aload 6
    //   2238: astore_3
    //   2239: aload_0
    //   2240: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2243: getfield 105	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2246: ifnull +305 -> 2551
    //   2249: aload_0
    //   2250: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2253: getfield 105	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2256: invokeinterface 110 1 0
    //   2261: ifne +290 -> 2551
    //   2264: aload_3
    //   2265: iload_2
    //   2266: aload_0
    //   2267: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2270: getfield 586	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:H	Z
    //   2273: invokestatic 591	com/tencent/mobileqq/search/SearchUtil:a	(Ljava/util/List;ZZ)Ljava/util/List;
    //   2276: astore_3
    //   2277: iload_2
    //   2278: ifne +231 -> 2509
    //   2281: lload 19
    //   2283: aload_0
    //   2284: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2287: invokestatic 594	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:d	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)J
    //   2290: lcmp
    //   2291: ifne +218 -> 2509
    //   2294: iload 10
    //   2296: ifne +213 -> 2509
    //   2299: aload_3
    //   2300: ifnull +209 -> 2509
    //   2303: aload_3
    //   2304: invokeinterface 293 1 0
    //   2309: ifle +200 -> 2509
    //   2312: aload_0
    //   2313: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2316: getfield 105	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2319: aload_0
    //   2320: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2323: getfield 105	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2326: invokeinterface 293 1 0
    //   2331: iconst_1
    //   2332: isub
    //   2333: invokeinterface 597 2 0
    //   2338: checkcast 599	com/tencent/mobileqq/search/model/IModel
    //   2341: astore 4
    //   2343: aload_3
    //   2344: iconst_0
    //   2345: invokeinterface 602 2 0
    //   2350: pop
    //   2351: iconst_0
    //   2352: istore 12
    //   2354: iconst_0
    //   2355: istore 13
    //   2357: iload 13
    //   2359: aload_3
    //   2360: invokeinterface 293 1 0
    //   2365: if_icmpge +44 -> 2409
    //   2368: aload_3
    //   2369: iload 13
    //   2371: invokeinterface 597 2 0
    //   2376: checkcast 599	com/tencent/mobileqq/search/model/IModel
    //   2379: instanceof 604
    //   2382: ifeq +10 -> 2392
    //   2385: iload 13
    //   2387: istore 12
    //   2389: goto +20 -> 2409
    //   2392: iload 13
    //   2394: iconst_1
    //   2395: iadd
    //   2396: istore 15
    //   2398: iload 13
    //   2400: istore 12
    //   2402: iload 15
    //   2404: istore 13
    //   2406: goto -49 -> 2357
    //   2409: aload 4
    //   2411: instanceof 261
    //   2414: ifeq +34 -> 2448
    //   2417: aload 4
    //   2419: checkcast 261	com/tencent/mobileqq/search/model/ISearchResultModel
    //   2422: astore 4
    //   2424: aload 4
    //   2426: invokevirtual 607	com/tencent/mobileqq/search/model/ISearchResultModel:ck_	()I
    //   2429: istore 13
    //   2431: aload 4
    //   2433: iload 13
    //   2435: iload 12
    //   2437: iadd
    //   2438: iload 13
    //   2440: iconst_1
    //   2441: isub
    //   2442: invokestatic 612	com/tencent/mobileqq/search/base/util/SearchViewUtils:a	(Lcom/tencent/mobileqq/search/model/ISearchResultModel;II)V
    //   2445: goto +6 -> 2451
    //   2448: iconst_0
    //   2449: istore 13
    //   2451: iconst_0
    //   2452: istore 15
    //   2454: iload 15
    //   2456: iload 12
    //   2458: if_icmpge +51 -> 2509
    //   2461: aload_3
    //   2462: iload 15
    //   2464: invokeinterface 597 2 0
    //   2469: checkcast 599	com/tencent/mobileqq/search/model/IModel
    //   2472: astore 4
    //   2474: aload 4
    //   2476: instanceof 261
    //   2479: ifeq +21 -> 2500
    //   2482: aload 4
    //   2484: checkcast 261	com/tencent/mobileqq/search/model/ISearchResultModel
    //   2487: iload 13
    //   2489: iload 12
    //   2491: iadd
    //   2492: iload 13
    //   2494: iload 15
    //   2496: iadd
    //   2497: invokestatic 612	com/tencent/mobileqq/search/base/util/SearchViewUtils:a	(Lcom/tencent/mobileqq/search/model/ISearchResultModel;II)V
    //   2500: iload 15
    //   2502: iconst_1
    //   2503: iadd
    //   2504: istore 15
    //   2506: goto -52 -> 2454
    //   2509: aload_0
    //   2510: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2513: aload_3
    //   2514: invokevirtual 615	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Ljava/util/List;)V
    //   2517: aload_0
    //   2518: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2521: getfield 105	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2524: aload_3
    //   2525: invokeinterface 315 2 0
    //   2530: pop
    //   2531: aload_0
    //   2532: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2535: getfield 618	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:j	Lcom/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter;
    //   2538: aload_0
    //   2539: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2542: getfield 105	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   2545: invokevirtual 621	com/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter:a	(Ljava/util/List;)V
    //   2548: goto +651 -> 3199
    //   2551: aload_3
    //   2552: ifnull +31 -> 2583
    //   2555: aload 6
    //   2557: invokeinterface 110 1 0
    //   2562: ifeq +6 -> 2568
    //   2565: goto +18 -> 2583
    //   2568: aload_0
    //   2569: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2572: getfield 136	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:x	Landroid/view/View;
    //   2575: bipush 8
    //   2577: invokevirtual 94	android/view/View:setVisibility	(I)V
    //   2580: goto +571 -> 3151
    //   2583: aload_0
    //   2584: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2587: getfield 136	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:x	Landroid/view/View;
    //   2590: iconst_0
    //   2591: invokevirtual 94	android/view/View:setVisibility	(I)V
    //   2594: aload_0
    //   2595: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2598: getfield 625	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:l	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2601: getstatic 630	com/tencent/mobileqq/app/QQManagerFactory:MAYKNOW_RECOMMEND_MANAGER	I
    //   2604: invokevirtual 636	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2607: checkcast 638	com/tencent/mobileqq/app/MayknowRecommendManager
    //   2610: astore 4
    //   2612: iload 17
    //   2614: ifne +323 -> 2937
    //   2617: aload 4
    //   2619: getfield 640	com/tencent/mobileqq/app/MayknowRecommendManager:j	Z
    //   2622: ifeq +315 -> 2937
    //   2625: aload_0
    //   2626: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2629: getfield 643	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:I	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2632: ifnonnull +281 -> 2913
    //   2635: aload_0
    //   2636: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2639: astore 4
    //   2641: aload 4
    //   2643: new 645	com/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopListWrapperForSearchEmpty
    //   2646: dup
    //   2647: aload 4
    //   2649: getfield 625	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:l	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2652: aload_0
    //   2653: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2656: invokevirtual 350	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2659: aload_0
    //   2660: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2663: getfield 648	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:y	Lcom/tencent/widget/XListView;
    //   2666: aconst_null
    //   2667: invokespecial 651	com/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopListWrapperForSearchEmpty:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/widget/XListView;Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper$RecommendTroopListWrapperCallback;)V
    //   2670: putfield 643	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:I	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2673: aload_0
    //   2674: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2677: getfield 643	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:I	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2680: invokevirtual 656	com/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper:g	()Lcom/tencent/widget/XListView;
    //   2683: astore 4
    //   2685: new 116	android/widget/TextView
    //   2688: dup
    //   2689: aload_0
    //   2690: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2693: invokevirtual 350	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2696: invokespecial 522	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2699: astore 6
    //   2701: aload 6
    //   2703: bipush 17
    //   2705: invokevirtual 559	android/widget/TextView:setGravity	(I)V
    //   2708: aload 6
    //   2710: new 658	com/tencent/widget/AbsListView$LayoutParams
    //   2713: dup
    //   2714: iconst_m1
    //   2715: ldc_w 659
    //   2718: aload_0
    //   2719: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2722: invokevirtual 144	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2725: invokestatic 664	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   2728: invokespecial 665	com/tencent/widget/AbsListView$LayoutParams:<init>	(II)V
    //   2731: invokevirtual 669	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2734: aload 6
    //   2736: aload_0
    //   2737: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2740: invokevirtual 144	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2743: ldc_w 670
    //   2746: invokevirtual 676	android/content/res/Resources:getColor	(I)I
    //   2749: invokevirtual 538	android/widget/TextView:setTextColor	(I)V
    //   2752: aload 6
    //   2754: iconst_1
    //   2755: ldc_w 677
    //   2758: invokevirtual 564	android/widget/TextView:setTextSize	(IF)V
    //   2761: aload 6
    //   2763: ldc_w 678
    //   2766: invokestatic 175	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   2769: invokevirtual 179	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2772: aload 6
    //   2774: ldc_w 679
    //   2777: invokevirtual 682	android/widget/TextView:setBackgroundResource	(I)V
    //   2780: aload 4
    //   2782: aload 6
    //   2784: invokevirtual 688	com/tencent/widget/ListView:addHeaderView	(Landroid/view/View;)V
    //   2787: new 116	android/widget/TextView
    //   2790: dup
    //   2791: aload_0
    //   2792: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2795: invokevirtual 350	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2798: invokespecial 522	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2801: astore 6
    //   2803: aload 6
    //   2805: aload_0
    //   2806: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2809: invokevirtual 144	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2812: ldc_w 670
    //   2815: invokevirtual 676	android/content/res/Resources:getColor	(I)I
    //   2818: invokevirtual 538	android/widget/TextView:setTextColor	(I)V
    //   2821: aload 6
    //   2823: iconst_1
    //   2824: ldc_w 560
    //   2827: invokevirtual 564	android/widget/TextView:setTextSize	(IF)V
    //   2830: aload 6
    //   2832: bipush 16
    //   2834: invokevirtual 559	android/widget/TextView:setGravity	(I)V
    //   2837: aload 6
    //   2839: ldc_w 468
    //   2842: aload_0
    //   2843: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2846: invokevirtual 144	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2849: invokestatic 664	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   2852: iconst_0
    //   2853: iconst_0
    //   2854: iconst_0
    //   2855: invokevirtual 533	android/widget/TextView:setPadding	(IIII)V
    //   2858: aload 6
    //   2860: new 658	com/tencent/widget/AbsListView$LayoutParams
    //   2863: dup
    //   2864: iconst_m1
    //   2865: ldc_w 689
    //   2868: aload_0
    //   2869: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2872: invokevirtual 144	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2875: invokestatic 664	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   2878: invokespecial 665	com/tencent/widget/AbsListView$LayoutParams:<init>	(II)V
    //   2881: invokevirtual 669	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2884: aload 6
    //   2886: ldc_w 690
    //   2889: invokestatic 175	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   2892: invokevirtual 179	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2895: aload 6
    //   2897: ldc_w 679
    //   2900: invokevirtual 682	android/widget/TextView:setBackgroundResource	(I)V
    //   2903: aload 4
    //   2905: aload 6
    //   2907: invokevirtual 688	com/tencent/widget/ListView:addHeaderView	(Landroid/view/View;)V
    //   2910: goto +13 -> 2923
    //   2913: aload_0
    //   2914: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2917: getfield 643	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:I	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2920: invokevirtual 693	com/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper:f	()V
    //   2923: aload_0
    //   2924: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2927: getfield 648	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:y	Lcom/tencent/widget/XListView;
    //   2930: iconst_0
    //   2931: invokevirtual 133	com/tencent/widget/XListView:setVisibility	(I)V
    //   2934: goto +190 -> 3124
    //   2937: aload_0
    //   2938: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2941: getfield 648	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:y	Lcom/tencent/widget/XListView;
    //   2944: bipush 8
    //   2946: invokevirtual 133	com/tencent/widget/XListView:setVisibility	(I)V
    //   2949: aload_0
    //   2950: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2953: getfield 140	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:A	Landroid/graphics/Bitmap;
    //   2956: ifnonnull +67 -> 3023
    //   2959: aload_0
    //   2960: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2963: invokevirtual 24	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:isAdded	()Z
    //   2966: ifeq +57 -> 3023
    //   2969: aload_0
    //   2970: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2973: aload_0
    //   2974: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2977: invokevirtual 144	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2980: ldc 145
    //   2982: invokestatic 151	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2985: putfield 140	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:A	Landroid/graphics/Bitmap;
    //   2988: aload_0
    //   2989: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2992: getfield 155	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:z	Landroid/widget/ImageView;
    //   2995: aload_0
    //   2996: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2999: getfield 140	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:A	Landroid/graphics/Bitmap;
    //   3002: invokevirtual 161	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   3005: goto +18 -> 3023
    //   3008: astore 4
    //   3010: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   3013: iconst_1
    //   3014: aload 4
    //   3016: iconst_0
    //   3017: anewarray 163	java/lang/Object
    //   3020: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3023: aload_0
    //   3024: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3027: getfield 169	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:B	Landroid/widget/TextView;
    //   3030: ldc_w 694
    //   3033: invokestatic 175	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3036: invokevirtual 179	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3039: iload 17
    //   3041: ifeq +86 -> 3127
    //   3044: aload_0
    //   3045: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3048: getfield 698	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:C	Landroid/widget/Button;
    //   3051: iconst_0
    //   3052: invokevirtual 701	android/widget/Button:setVisibility	(I)V
    //   3055: aload_0
    //   3056: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3059: getfield 698	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:C	Landroid/widget/Button;
    //   3062: new 703	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2$1
    //   3065: dup
    //   3066: aload_0
    //   3067: aload 9
    //   3069: invokespecial 706	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2$1:<init>	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2;Ljava/lang/String;)V
    //   3072: invokevirtual 707	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3075: aload 8
    //   3077: invokestatic 399	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3080: ifne +44 -> 3124
    //   3083: aload_0
    //   3084: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3087: getfield 698	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:C	Landroid/widget/Button;
    //   3090: aload 8
    //   3092: invokevirtual 708	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   3095: aload_0
    //   3096: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3099: getfield 169	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:B	Landroid/widget/TextView;
    //   3102: iconst_0
    //   3103: aload_0
    //   3104: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3107: getfield 169	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:B	Landroid/widget/TextView;
    //   3110: invokevirtual 712	android/widget/TextView:getContext	()Landroid/content/Context;
    //   3113: ldc_w 468
    //   3116: invokestatic 463	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   3119: iconst_0
    //   3120: iconst_0
    //   3121: invokevirtual 533	android/widget/TextView:setPadding	(IIII)V
    //   3124: goto +15 -> 3139
    //   3127: aload_0
    //   3128: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3131: getfield 698	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:C	Landroid/widget/Button;
    //   3134: bipush 8
    //   3136: invokevirtual 701	android/widget/Button:setVisibility	(I)V
    //   3139: aload_0
    //   3140: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3143: getfield 429	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:O	Landroid/widget/TextView;
    //   3146: bipush 8
    //   3148: invokevirtual 117	android/widget/TextView:setVisibility	(I)V
    //   3151: aload_3
    //   3152: iload_2
    //   3153: aload_0
    //   3154: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3157: getfield 586	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:H	Z
    //   3160: invokestatic 591	com/tencent/mobileqq/search/SearchUtil:a	(Ljava/util/List;ZZ)Ljava/util/List;
    //   3163: astore_3
    //   3164: aload_0
    //   3165: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3168: aload_3
    //   3169: invokevirtual 615	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Ljava/util/List;)V
    //   3172: aload_0
    //   3173: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3176: astore 4
    //   3178: aload 4
    //   3180: aload_3
    //   3181: putfield 105	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   3184: aload 4
    //   3186: getfield 618	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:j	Lcom/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter;
    //   3189: aload_0
    //   3190: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3193: getfield 105	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Ljava/util/List;
    //   3196: invokevirtual 621	com/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter:a	(Ljava/util/List;)V
    //   3199: aload_0
    //   3200: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3203: lload 21
    //   3205: invokestatic 715	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;J)J
    //   3208: pop2
    //   3209: aload_0
    //   3210: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3213: getfield 396	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:p	Z
    //   3216: ifne +99 -> 3315
    //   3219: aload_0
    //   3220: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3223: astore_3
    //   3224: aload_3
    //   3225: aload_3
    //   3226: getfield 385	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:K	I
    //   3229: iload 14
    //   3231: iadd
    //   3232: putfield 385	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:K	I
    //   3235: aload_0
    //   3236: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3239: astore_3
    //   3240: aload_3
    //   3241: aload_3
    //   3242: getfield 389	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:J	I
    //   3245: iconst_1
    //   3246: iadd
    //   3247: putfield 389	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:J	I
    //   3250: aload_0
    //   3251: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3254: getfield 385	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:K	I
    //   3257: bipush 10
    //   3259: if_icmple +21 -> 3280
    //   3262: aload_0
    //   3263: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3266: astore_3
    //   3267: aload_3
    //   3268: iconst_0
    //   3269: putfield 389	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:J	I
    //   3272: aload_3
    //   3273: iconst_0
    //   3274: putfield 385	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:K	I
    //   3277: goto +38 -> 3315
    //   3280: aload_0
    //   3281: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3284: getfield 389	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:J	I
    //   3287: iconst_3
    //   3288: if_icmplt +14 -> 3302
    //   3291: aload_0
    //   3292: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3295: iconst_1
    //   3296: putfield 396	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:p	Z
    //   3299: goto +16 -> 3315
    //   3302: aload_0
    //   3303: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3306: astore_3
    //   3307: aload_3
    //   3308: aload_3
    //   3309: getfield 79	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   3312: invokevirtual 717	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	(Ljava/lang/String;)V
    //   3315: iload 5
    //   3317: ifeq +116 -> 3433
    //   3320: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3323: ifeq +220 -> 3543
    //   3326: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   3329: astore_3
    //   3330: new 29	java/lang/StringBuilder
    //   3333: dup
    //   3334: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   3337: astore 4
    //   3339: aload 4
    //   3341: ldc_w 719
    //   3344: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3347: pop
    //   3348: aload 4
    //   3350: aload 7
    //   3352: invokestatic 195	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3355: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3358: pop
    //   3359: aload 4
    //   3361: ldc 197
    //   3363: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3366: pop
    //   3367: aload 4
    //   3369: aload_1
    //   3370: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3373: pop
    //   3374: aload 4
    //   3376: ldc 199
    //   3378: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3381: pop
    //   3382: aload 4
    //   3384: aload_0
    //   3385: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3388: getfield 202	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:N	Ljava/lang/String;
    //   3391: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3394: pop
    //   3395: aload 4
    //   3397: ldc_w 721
    //   3400: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3403: pop
    //   3404: aload 4
    //   3406: aload_0
    //   3407: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3410: getfield 73	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   3413: invokestatic 195	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3416: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3419: pop
    //   3420: aload_3
    //   3421: iconst_2
    //   3422: aload 4
    //   3424: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3427: invokestatic 229	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3430: goto +113 -> 3543
    //   3433: invokestatic 186	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3436: ifeq +107 -> 3543
    //   3439: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   3442: astore_3
    //   3443: new 29	java/lang/StringBuilder
    //   3446: dup
    //   3447: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   3450: astore 4
    //   3452: aload 4
    //   3454: ldc_w 723
    //   3457: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3460: pop
    //   3461: aload 4
    //   3463: aload 7
    //   3465: invokestatic 195	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3468: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3471: pop
    //   3472: aload 4
    //   3474: ldc 197
    //   3476: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3479: pop
    //   3480: aload 4
    //   3482: aload_1
    //   3483: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3486: pop
    //   3487: aload 4
    //   3489: ldc 199
    //   3491: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3494: pop
    //   3495: aload 4
    //   3497: aload_0
    //   3498: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3501: getfield 202	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:N	Ljava/lang/String;
    //   3504: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3507: pop
    //   3508: aload 4
    //   3510: ldc_w 721
    //   3513: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3516: pop
    //   3517: aload 4
    //   3519: aload_0
    //   3520: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3523: getfield 73	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   3526: invokestatic 195	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3529: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3532: pop
    //   3533: aload_3
    //   3534: iconst_2
    //   3535: aload 4
    //   3537: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3540: invokestatic 229	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3543: iconst_1
    //   3544: putstatic 725	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:q	Z
    //   3547: return
    //   3548: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	Ljava/lang/String;
    //   3551: astore_3
    //   3552: new 29	java/lang/StringBuilder
    //   3555: dup
    //   3556: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   3559: astore 4
    //   3561: aload 4
    //   3563: ldc_w 727
    //   3566: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3569: pop
    //   3570: aload 4
    //   3572: aload_0
    //   3573: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3576: getfield 73	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:F	[J
    //   3579: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3582: pop
    //   3583: aload 4
    //   3585: ldc_w 729
    //   3588: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3591: pop
    //   3592: aload 4
    //   3594: aload 7
    //   3596: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3599: pop
    //   3600: aload 4
    //   3602: ldc_w 731
    //   3605: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3608: pop
    //   3609: aload 4
    //   3611: aload_1
    //   3612: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3615: pop
    //   3616: aload 4
    //   3618: ldc 213
    //   3620: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3623: pop
    //   3624: aload 4
    //   3626: aload_0
    //   3627: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3630: getfield 79	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	Ljava/lang/String;
    //   3633: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3636: pop
    //   3637: aload 4
    //   3639: ldc 217
    //   3641: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3644: pop
    //   3645: aload 4
    //   3647: iload 5
    //   3649: invokevirtual 41	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3652: pop
    //   3653: aload_3
    //   3654: iconst_2
    //   3655: aload 4
    //   3657: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3660: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3663: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3664	0	this	2
    //   0	3664	1	paramString1	String
    //   0	3664	2	paramBoolean1	boolean
    //   0	3664	3	paramString2	String
    //   0	3664	4	paramArrayOfByte	byte[]
    //   0	3664	5	paramBoolean2	boolean
    //   0	3664	6	paramList	List<com.tencent.mobileqq.search.model.ISearchResultGroupModel>
    //   0	3664	7	paramArrayOfLong	long[]
    //   0	3664	8	paramString3	String
    //   0	3664	9	paramList1	List<tencent.im.oidb.search.DynamicTabSearch.SubHotWord>
    //   0	3664	10	paramBoolean3	boolean
    //   0	3664	11	paramString4	String
    //   0	3664	12	paramInt	int
    //   1643	854	13	i	int
    //   372	2860	14	j	int
    //   1814	691	15	k	int
    //   1821	169	16	m	int
    //   1423	1617	17	bool1	boolean
    //   1446	557	18	bool2	boolean
    //   377	1905	19	l1	long
    //   369	2835	21	l2	long
    //   411	316	23	l3	long
    //   403	316	25	l4	long
    //   364	1734	27	localObject1	Object
    //   399	1680	28	localObject2	Object
    //   434	1676	29	localObject3	Object
    //   441	1671	30	localObject4	Object
    //   450	13	31	localIterator	java.util.Iterator
    //   472	31	32	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   1434	1444	1454	org/json/JSONException
    //   1425	1434	1459	org/json/JSONException
    //   1404	1425	1468	org/json/JSONException
    //   2959	3005	3008	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment.2
 * JD-Core Version:    0.7.0.1
 */