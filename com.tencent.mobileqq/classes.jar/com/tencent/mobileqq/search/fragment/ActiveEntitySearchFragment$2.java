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
      paramArrayOfLong = ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString;
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
        this.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ActiveEntitySearchFragment.2.3(this));
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
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131699997));
        this.a.g.setOnClickListener(new ActiveEntitySearchFragment.2.2(this));
      }
      if (QLog.isColorLevel())
      {
        paramString2 = ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString;
        paramString3 = new StringBuilder();
        paramString3.append("handleTabSearchError code=");
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
  public void handleTabSearchResult(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<com.tencent.mobileqq.search.model.ISearchResultGroupModel> paramList, long[] paramArrayOfLong, String paramString3, List<tencent.im.oidb.search.DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   4: invokevirtual 24	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:isAdded	()Z
    //   7: ifne +117 -> 124
    //   10: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   13: astore 4
    //   15: new 29	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   22: astore 6
    //   24: aload 6
    //   26: ldc 200
    //   28: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 6
    //   34: aload_1
    //   35: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 6
    //   41: ldc 202
    //   43: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 6
    //   49: aload_0
    //   50: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   53: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   77: ldc 204
    //   79: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 6
    //   85: aload_0
    //   86: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   89: getfield 63	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   92: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 6
    //   98: ldc 206
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
    //   129: getfield 63	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   132: invokestatic 69	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   135: ifne +117 -> 252
    //   138: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   141: astore 4
    //   143: new 29	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   150: astore 6
    //   152: aload 6
    //   154: ldc 208
    //   156: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 6
    //   162: aload_1
    //   163: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 6
    //   169: ldc 202
    //   171: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 6
    //   177: aload_0
    //   178: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   181: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
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
    //   205: ldc 204
    //   207: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 6
    //   213: aload_0
    //   214: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   217: getfield 63	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   220: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 6
    //   226: ldc 206
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
    //   248: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: return
    //   252: aload_0
    //   253: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   256: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   259: aload 7
    //   261: invokestatic 75	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	([J[J)Z
    //   264: ifeq +3290 -> 3554
    //   267: aload_1
    //   268: aload_0
    //   269: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   272: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   275: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifne +6 -> 284
    //   281: goto +3273 -> 3554
    //   284: aload 6
    //   286: ifnonnull +63 -> 349
    //   289: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +44 -> 336
    //   295: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   298: astore 4
    //   300: new 29	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   307: astore 8
    //   309: aload 8
    //   311: ldc 212
    //   313: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 8
    //   319: aload 6
    //   321: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 4
    //   327: iconst_2
    //   328: aload 8
    //   330: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload_0
    //   337: aload_1
    //   338: iload_2
    //   339: aload_3
    //   340: iconst_m1
    //   341: ldc 220
    //   343: aload 7
    //   345: invokevirtual 222	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:handleTabSearchError	(Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;[J)V
    //   348: return
    //   349: new 224	java/util/HashSet
    //   352: dup
    //   353: invokespecial 225	java/util/HashSet:<init>	()V
    //   356: astore_3
    //   357: aload 6
    //   359: invokeinterface 229 1 0
    //   364: astore 27
    //   366: ldc2_w 230
    //   369: lstore 21
    //   371: iconst_0
    //   372: istore 14
    //   374: ldc2_w 230
    //   377: lstore 19
    //   379: aload 27
    //   381: invokeinterface 236 1 0
    //   386: ifeq +351 -> 737
    //   389: aload 27
    //   391: invokeinterface 240 1 0
    //   396: checkcast 242	com/tencent/mobileqq/search/model/ISearchResultGroupModel
    //   399: astore 28
    //   401: lload 21
    //   403: lstore 25
    //   405: iload 14
    //   407: istore 12
    //   409: lload 19
    //   411: lstore 23
    //   413: aload 28
    //   415: invokeinterface 245 1 0
    //   420: ifnull +302 -> 722
    //   423: aload 28
    //   425: instanceof 247
    //   428: ifeq +269 -> 697
    //   431: aload 28
    //   433: checkcast 247	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel
    //   436: astore 29
    //   438: aload 29
    //   440: invokevirtual 248	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	()Ljava/util/List;
    //   443: astore 30
    //   445: aload 30
    //   447: invokeinterface 229 1 0
    //   452: astore 31
    //   454: aload 31
    //   456: invokeinterface 236 1 0
    //   461: ifeq +61 -> 522
    //   464: aload 31
    //   466: invokeinterface 240 1 0
    //   471: checkcast 250	com/tencent/mobileqq/search/model/ISearchResultModel
    //   474: astore 32
    //   476: aload 32
    //   478: instanceof 252
    //   481: ifeq -27 -> 454
    //   484: aload 32
    //   486: checkcast 252	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem
    //   489: astore 32
    //   491: getstatic 256	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:b	Z
    //   494: ifeq +9 -> 503
    //   497: aload 32
    //   499: iconst_1
    //   500: putfield 260	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:o	I
    //   503: aload_3
    //   504: aload 32
    //   506: invokevirtual 263	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:d	()I
    //   509: i2l
    //   510: invokestatic 269	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   513: invokeinterface 274 2 0
    //   518: pop
    //   519: goto -65 -> 454
    //   522: lload 19
    //   524: lstore 23
    //   526: lload 19
    //   528: ldc2_w 230
    //   531: lcmp
    //   532: ifne +10 -> 542
    //   535: aload 29
    //   537: getfield 277	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   540: lstore 23
    //   542: aload 29
    //   544: getfield 277	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   547: lstore 25
    //   549: aload 30
    //   551: invokeinterface 280 1 0
    //   556: ifle +59 -> 615
    //   559: lload 25
    //   561: lstore 21
    //   563: aload 29
    //   565: getfield 277	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   568: ldc2_w 281
    //   571: lcmp
    //   572: ifne +43 -> 615
    //   575: aconst_null
    //   576: ldc_w 284
    //   579: ldc_w 286
    //   582: ldc_w 286
    //   585: ldc_w 288
    //   588: ldc_w 288
    //   591: iconst_1
    //   592: iconst_0
    //   593: ldc_w 286
    //   596: ldc_w 286
    //   599: ldc_w 286
    //   602: ldc_w 286
    //   605: invokestatic 293	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   608: lload 23
    //   610: lstore 19
    //   612: goto +85 -> 697
    //   615: lload 23
    //   617: lstore 19
    //   619: lload 25
    //   621: lstore 21
    //   623: aload 30
    //   625: invokeinterface 280 1 0
    //   630: ifle +67 -> 697
    //   633: lload 23
    //   635: lstore 19
    //   637: lload 25
    //   639: lstore 21
    //   641: aload 29
    //   643: getfield 277	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	J
    //   646: ldc2_w 294
    //   649: lcmp
    //   650: ifne +47 -> 697
    //   653: aconst_null
    //   654: ldc_w 284
    //   657: ldc_w 286
    //   660: ldc_w 286
    //   663: ldc_w 288
    //   666: ldc_w 288
    //   669: iconst_2
    //   670: iconst_0
    //   671: ldc_w 286
    //   674: ldc_w 286
    //   677: ldc_w 286
    //   680: ldc_w 286
    //   683: invokestatic 293	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   686: lload 23
    //   688: lstore 19
    //   690: lload 25
    //   692: lstore 21
    //   694: goto +3 -> 697
    //   697: iload 14
    //   699: aload 28
    //   701: invokeinterface 245 1 0
    //   706: invokeinterface 280 1 0
    //   711: iadd
    //   712: istore 12
    //   714: lload 19
    //   716: lstore 23
    //   718: lload 21
    //   720: lstore 25
    //   722: lload 25
    //   724: lstore 21
    //   726: iload 12
    //   728: istore 14
    //   730: lload 23
    //   732: lstore 19
    //   734: goto -355 -> 379
    //   737: aload_0
    //   738: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   741: getfield 297	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   744: aload_3
    //   745: invokeinterface 301 2 0
    //   750: pop
    //   751: aload_0
    //   752: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   755: aload 8
    //   757: invokestatic 304	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;Ljava/lang/String;)Ljava/lang/String;
    //   760: pop
    //   761: aload_0
    //   762: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   765: aload 9
    //   767: invokestatic 307	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;Ljava/util/List;)Ljava/util/List;
    //   770: pop
    //   771: ldc_w 286
    //   774: astore 27
    //   776: iload_2
    //   777: ifne +77 -> 854
    //   780: new 309	java/util/ArrayList
    //   783: dup
    //   784: invokespecial 310	java/util/ArrayList:<init>	()V
    //   787: astore 8
    //   789: aload 8
    //   791: aload_3
    //   792: invokeinterface 301 2 0
    //   797: pop
    //   798: ldc_w 312
    //   801: ldc_w 314
    //   804: iconst_4
    //   805: anewarray 80	java/lang/String
    //   808: dup
    //   809: iconst_0
    //   810: aload_0
    //   811: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   814: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   817: aastore
    //   818: dup
    //   819: iconst_1
    //   820: aload 8
    //   822: invokestatic 319	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/List;)Ljava/lang/String;
    //   825: aastore
    //   826: dup
    //   827: iconst_2
    //   828: ldc_w 286
    //   831: aastore
    //   832: dup
    //   833: iconst_3
    //   834: ldc_w 321
    //   837: aload_0
    //   838: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   841: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   844: invokestatic 324	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   847: aastore
    //   848: invokestatic 327	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   851: goto +3 -> 854
    //   854: aload_0
    //   855: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   858: getfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   861: aload 6
    //   863: iload_2
    //   864: iconst_1
    //   865: ixor
    //   866: aload_0
    //   867: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   870: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   873: aload_0
    //   874: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   877: getfield 191	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   880: aload_0
    //   881: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   884: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   887: invokestatic 332	com/tencent/mobileqq/search/util/ReportUtil:a	(Ljava/util/List;Ljava/util/List;Z[JLjava/lang/String;Ljava/lang/String;)V
    //   890: iload 14
    //   892: ifne +160 -> 1052
    //   895: aload_0
    //   896: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   899: invokevirtual 336	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   902: instanceof 338
    //   905: ifeq +320 -> 1225
    //   908: aload_0
    //   909: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   912: invokevirtual 336	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   915: checkcast 338	com/tencent/mobileqq/search/base/api/SearchInfoInterface
    //   918: invokeinterface 340 1 0
    //   923: istore 12
    //   925: iload 12
    //   927: iconst_1
    //   928: if_icmpeq +68 -> 996
    //   931: iload 12
    //   933: iconst_3
    //   934: if_icmpeq +6 -> 940
    //   937: goto +288 -> 1225
    //   940: ldc_w 312
    //   943: ldc_w 342
    //   946: iconst_4
    //   947: anewarray 80	java/lang/String
    //   950: dup
    //   951: iconst_0
    //   952: aload_0
    //   953: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   956: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   959: aastore
    //   960: dup
    //   961: iconst_1
    //   962: aload_0
    //   963: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   966: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   969: invokestatic 344	com/tencent/mobileqq/search/util/SearchUtils:a	([J)Ljava/lang/String;
    //   972: aastore
    //   973: dup
    //   974: iconst_2
    //   975: ldc_w 286
    //   978: aastore
    //   979: dup
    //   980: iconst_3
    //   981: ldc_w 321
    //   984: aload 7
    //   986: invokestatic 324	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   989: aastore
    //   990: invokestatic 327	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   993: goto +232 -> 1225
    //   996: ldc_w 346
    //   999: ldc_w 348
    //   1002: iconst_4
    //   1003: anewarray 80	java/lang/String
    //   1006: dup
    //   1007: iconst_0
    //   1008: aload_0
    //   1009: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1012: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1015: aastore
    //   1016: dup
    //   1017: iconst_1
    //   1018: aload_0
    //   1019: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1022: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   1025: invokestatic 344	com/tencent/mobileqq/search/util/SearchUtils:a	([J)Ljava/lang/String;
    //   1028: aastore
    //   1029: dup
    //   1030: iconst_2
    //   1031: ldc_w 286
    //   1034: aastore
    //   1035: dup
    //   1036: iconst_3
    //   1037: ldc_w 321
    //   1040: aload 7
    //   1042: invokestatic 324	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1045: aastore
    //   1046: invokestatic 327	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1049: goto +176 -> 1225
    //   1052: aload_0
    //   1053: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1056: getfield 351	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfByte	[B
    //   1059: ifnonnull +166 -> 1225
    //   1062: aload_0
    //   1063: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1066: invokevirtual 336	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1069: instanceof 338
    //   1072: ifeq +153 -> 1225
    //   1075: aload_0
    //   1076: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1079: invokevirtual 336	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1082: checkcast 338	com/tencent/mobileqq/search/base/api/SearchInfoInterface
    //   1085: astore_3
    //   1086: aload_3
    //   1087: invokeinterface 340 1 0
    //   1092: istore 12
    //   1094: iload 12
    //   1096: iconst_1
    //   1097: if_icmpeq +71 -> 1168
    //   1100: iload 12
    //   1102: iconst_3
    //   1103: if_icmpeq +6 -> 1109
    //   1106: goto +119 -> 1225
    //   1109: ldc_w 312
    //   1112: ldc_w 353
    //   1115: iconst_4
    //   1116: anewarray 80	java/lang/String
    //   1119: dup
    //   1120: iconst_0
    //   1121: aload_3
    //   1122: invokeinterface 355 1 0
    //   1127: aastore
    //   1128: dup
    //   1129: iconst_1
    //   1130: aload_0
    //   1131: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1134: getfield 297	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1137: invokestatic 319	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/List;)Ljava/lang/String;
    //   1140: aastore
    //   1141: dup
    //   1142: iconst_2
    //   1143: ldc_w 286
    //   1146: aastore
    //   1147: dup
    //   1148: iconst_3
    //   1149: ldc_w 321
    //   1152: aload_3
    //   1153: invokeinterface 358 1 0
    //   1158: invokestatic 324	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1161: aastore
    //   1162: invokestatic 327	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1165: goto +60 -> 1225
    //   1168: ldc_w 346
    //   1171: ldc_w 360
    //   1174: iconst_4
    //   1175: anewarray 80	java/lang/String
    //   1178: dup
    //   1179: iconst_0
    //   1180: aload_0
    //   1181: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1184: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1187: aastore
    //   1188: dup
    //   1189: iconst_1
    //   1190: aload_0
    //   1191: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1194: getfield 297	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1197: invokestatic 319	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/util/List;)Ljava/lang/String;
    //   1200: aastore
    //   1201: dup
    //   1202: iconst_2
    //   1203: ldc_w 286
    //   1206: aastore
    //   1207: dup
    //   1208: iconst_3
    //   1209: ldc_w 362
    //   1212: aload_3
    //   1213: invokeinterface 358 1 0
    //   1218: invokestatic 324	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;[J)Ljava/lang/String;
    //   1221: aastore
    //   1222: invokestatic 327	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    //   1225: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1228: ifeq +103 -> 1331
    //   1231: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1234: astore_3
    //   1235: new 29	java/lang/StringBuilder
    //   1238: dup
    //   1239: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1242: astore 8
    //   1244: aload 8
    //   1246: ldc_w 364
    //   1249: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: pop
    //   1253: aload 8
    //   1255: iload_2
    //   1256: invokevirtual 41	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1259: pop
    //   1260: aload 8
    //   1262: ldc_w 366
    //   1265: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: pop
    //   1269: aload 8
    //   1271: aload_0
    //   1272: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1275: getfield 368	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Int	I
    //   1278: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1281: pop
    //   1282: aload 8
    //   1284: ldc_w 370
    //   1287: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: aload 8
    //   1293: aload_0
    //   1294: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1297: getfield 372	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Int	I
    //   1300: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1303: pop
    //   1304: aload 8
    //   1306: ldc_w 374
    //   1309: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: pop
    //   1313: aload 8
    //   1315: iload 14
    //   1317: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1320: pop
    //   1321: aload_3
    //   1322: iconst_2
    //   1323: aload 8
    //   1325: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1328: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1331: aload_0
    //   1332: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1335: getfield 86	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1338: bipush 8
    //   1340: invokevirtual 92	android/view/View:setVisibility	(I)V
    //   1343: aload_0
    //   1344: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1347: getfield 377	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   1350: bipush 8
    //   1352: invokevirtual 92	android/view/View:setVisibility	(I)V
    //   1355: aload_0
    //   1356: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1359: getfield 123	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   1362: iconst_0
    //   1363: invokevirtual 126	com/tencent/widget/XListView:setVisibility	(I)V
    //   1366: aload_0
    //   1367: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1370: getfield 97	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1373: bipush 8
    //   1375: invokevirtual 92	android/view/View:setVisibility	(I)V
    //   1378: aload_0
    //   1379: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1382: astore_3
    //   1383: aload_3
    //   1384: iconst_0
    //   1385: putfield 95	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_Boolean	Z
    //   1388: aload_3
    //   1389: aload 4
    //   1391: putfield 351	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfByte	[B
    //   1394: aload_3
    //   1395: iload 5
    //   1397: putfield 379	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Boolean	Z
    //   1400: aload 11
    //   1402: invokestatic 382	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1405: ifne +156 -> 1561
    //   1408: new 384	org/json/JSONObject
    //   1411: dup
    //   1412: aload 11
    //   1414: invokespecial 387	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1417: astore 4
    //   1419: aload 4
    //   1421: ldc_w 389
    //   1424: invokevirtual 393	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1427: istore 17
    //   1429: aload 4
    //   1431: ldc_w 395
    //   1434: invokevirtual 399	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1437: astore_3
    //   1438: aload 4
    //   1440: ldc_w 401
    //   1443: invokevirtual 399	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1446: astore 9
    //   1448: iload 17
    //   1450: istore 18
    //   1452: aload_3
    //   1453: astore 8
    //   1455: goto +99 -> 1554
    //   1458: astore 4
    //   1460: goto +21 -> 1481
    //   1463: astore 4
    //   1465: ldc_w 286
    //   1468: astore_3
    //   1469: goto +12 -> 1481
    //   1472: astore 4
    //   1474: ldc_w 286
    //   1477: astore_3
    //   1478: iconst_0
    //   1479: istore 17
    //   1481: iload 17
    //   1483: istore 18
    //   1485: aload_3
    //   1486: astore 8
    //   1488: aload 27
    //   1490: astore 9
    //   1492: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1495: ifeq +59 -> 1554
    //   1498: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1501: astore 8
    //   1503: new 29	java/lang/StringBuilder
    //   1506: dup
    //   1507: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1510: astore 9
    //   1512: aload 9
    //   1514: ldc_w 403
    //   1517: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1520: pop
    //   1521: aload 9
    //   1523: aload 4
    //   1525: invokestatic 407	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1528: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: pop
    //   1532: aload 8
    //   1534: iconst_2
    //   1535: aload 9
    //   1537: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1540: invokestatic 60	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1543: aload 27
    //   1545: astore 9
    //   1547: aload_3
    //   1548: astore 8
    //   1550: iload 17
    //   1552: istore 18
    //   1554: iload 18
    //   1556: istore 17
    //   1558: goto +31 -> 1589
    //   1561: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1564: ifeq +13 -> 1577
    //   1567: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1570: iconst_2
    //   1571: ldc_w 409
    //   1574: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1577: ldc_w 286
    //   1580: astore 9
    //   1582: aload 9
    //   1584: astore 8
    //   1586: iconst_0
    //   1587: istore 17
    //   1589: iload 5
    //   1591: ifeq +134 -> 1725
    //   1594: aload_0
    //   1595: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1598: getfield 412	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:c	Landroid/widget/TextView;
    //   1601: iconst_0
    //   1602: invokevirtual 111	android/widget/TextView:setVisibility	(I)V
    //   1605: aload_0
    //   1606: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1609: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   1612: ifnull +113 -> 1725
    //   1615: aload_0
    //   1616: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1619: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   1622: arraylength
    //   1623: iconst_2
    //   1624: if_icmpne +101 -> 1725
    //   1627: new 309	java/util/ArrayList
    //   1630: dup
    //   1631: invokespecial 310	java/util/ArrayList:<init>	()V
    //   1634: astore_3
    //   1635: aload_0
    //   1636: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1639: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   1642: astore 4
    //   1644: aload 4
    //   1646: arraylength
    //   1647: istore 13
    //   1649: iconst_0
    //   1650: istore 12
    //   1652: iload 12
    //   1654: iload 13
    //   1656: if_icmpge +27 -> 1683
    //   1659: aload_3
    //   1660: aload 4
    //   1662: iload 12
    //   1664: laload
    //   1665: invokestatic 269	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1668: invokeinterface 413 2 0
    //   1673: pop
    //   1674: iload 12
    //   1676: iconst_1
    //   1677: iadd
    //   1678: istore 12
    //   1680: goto -28 -> 1652
    //   1683: aload_3
    //   1684: ldc2_w 281
    //   1687: invokestatic 269	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1690: invokeinterface 416 2 0
    //   1695: ifeq +30 -> 1725
    //   1698: aload_3
    //   1699: ldc2_w 294
    //   1702: invokestatic 269	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1705: invokeinterface 416 2 0
    //   1710: ifeq +15 -> 1725
    //   1713: aload_0
    //   1714: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1717: getfield 412	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:c	Landroid/widget/TextView;
    //   1720: bipush 8
    //   1722: invokevirtual 111	android/widget/TextView:setVisibility	(I)V
    //   1725: aload_0
    //   1726: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1729: invokestatic 419	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/lang/String;
    //   1732: invokestatic 382	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1735: ifne +493 -> 2228
    //   1738: aload_0
    //   1739: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1742: invokestatic 422	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/util/List;
    //   1745: invokeinterface 280 1 0
    //   1750: ifle +478 -> 2228
    //   1753: aload_0
    //   1754: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1757: getfield 424	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1760: aload_0
    //   1761: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1764: invokestatic 419	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/lang/String;
    //   1767: invokevirtual 169	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1770: aload_0
    //   1771: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1774: getfield 427	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1777: invokevirtual 432	android/widget/LinearLayout:removeAllViews	()V
    //   1780: aload_0
    //   1781: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1784: invokevirtual 336	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1787: astore_3
    //   1788: aload_3
    //   1789: ifnull +422 -> 2211
    //   1792: aload_3
    //   1793: invokevirtual 437	com/tencent/mobileqq/app/BaseActivity:isFinishing	()Z
    //   1796: ifeq +6 -> 1802
    //   1799: goto +412 -> 2211
    //   1802: aload_3
    //   1803: ldc_w 438
    //   1806: invokestatic 443	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1809: istore 13
    //   1811: aload_3
    //   1812: ldc_w 444
    //   1815: invokestatic 443	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1818: istore 15
    //   1820: aload_3
    //   1821: fconst_2
    //   1822: invokestatic 443	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1825: istore 16
    //   1827: new 446	android/graphics/drawable/GradientDrawable
    //   1830: dup
    //   1831: invokespecial 447	android/graphics/drawable/GradientDrawable:<init>	()V
    //   1834: astore 11
    //   1836: aload 11
    //   1838: aload_0
    //   1839: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1842: invokevirtual 336	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   1845: ldc_w 448
    //   1848: invokestatic 443	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   1851: i2f
    //   1852: invokevirtual 452	android/graphics/drawable/GradientDrawable:setCornerRadius	(F)V
    //   1855: ldc_w 454
    //   1858: invokestatic 460	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1861: istore 12
    //   1863: invokestatic 466	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1866: invokevirtual 470	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1869: invokestatic 476	com/tencent/mobileqq/vas/theme/api/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   1872: istore 18
    //   1874: iload 18
    //   1876: ifeq +11 -> 1887
    //   1879: ldc_w 478
    //   1882: invokestatic 460	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1885: istore 12
    //   1887: aload 11
    //   1889: iconst_1
    //   1890: iload 12
    //   1892: invokevirtual 482	android/graphics/drawable/GradientDrawable:setStroke	(II)V
    //   1895: aload_0
    //   1896: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   1899: invokestatic 422	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)Ljava/util/List;
    //   1902: invokeinterface 229 1 0
    //   1907: astore 4
    //   1909: aload 4
    //   1911: invokeinterface 236 1 0
    //   1916: ifeq +207 -> 2123
    //   1919: aload 4
    //   1921: invokeinterface 240 1 0
    //   1926: checkcast 484	tencent/im/oidb/search/DynamicTabSearch$SubHotWord
    //   1929: astore 27
    //   1931: aload 27
    //   1933: getfield 488	tencent/im/oidb/search/DynamicTabSearch$SubHotWord:show_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1936: invokevirtual 494	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1939: invokevirtual 499	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1942: astore 28
    //   1944: aload 28
    //   1946: invokestatic 382	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1949: ifeq +6 -> 1955
    //   1952: goto -43 -> 1909
    //   1955: new 110	android/widget/TextView
    //   1958: dup
    //   1959: aload_3
    //   1960: invokespecial 502	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   1963: astore 29
    //   1965: new 504	android/widget/LinearLayout$LayoutParams
    //   1968: dup
    //   1969: bipush 254
    //   1971: bipush 254
    //   1973: invokespecial 506	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   1976: astore 30
    //   1978: aload 30
    //   1980: iload 13
    //   1982: putfield 509	android/widget/LinearLayout$LayoutParams:rightMargin	I
    //   1985: aload 29
    //   1987: iload 15
    //   1989: iload 16
    //   1991: iload 15
    //   1993: iload 16
    //   1995: invokevirtual 513	android/widget/TextView:setPadding	(IIII)V
    //   1998: ldc_w 515
    //   2001: invokestatic 460	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   2004: istore 12
    //   2006: iload 18
    //   2008: ifeq +11 -> 2019
    //   2011: ldc_w 478
    //   2014: invokestatic 460	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   2017: istore 12
    //   2019: aload 29
    //   2021: iload 12
    //   2023: invokevirtual 518	android/widget/TextView:setTextColor	(I)V
    //   2026: getstatic 523	android/os/Build$VERSION:SDK_INT	I
    //   2029: bipush 16
    //   2031: if_icmpge +16 -> 2047
    //   2034: aload 29
    //   2036: aload 11
    //   2038: invokevirtual 529	android/graphics/drawable/Drawable:mutate	()Landroid/graphics/drawable/Drawable;
    //   2041: invokevirtual 533	android/widget/TextView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2044: goto +13 -> 2057
    //   2047: aload 29
    //   2049: aload 11
    //   2051: invokevirtual 529	android/graphics/drawable/Drawable:mutate	()Landroid/graphics/drawable/Drawable;
    //   2054: invokevirtual 536	android/widget/TextView:setBackground	(Landroid/graphics/drawable/Drawable;)V
    //   2057: aload 29
    //   2059: aload 28
    //   2061: invokevirtual 169	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2064: aload 29
    //   2066: bipush 17
    //   2068: invokevirtual 539	android/widget/TextView:setGravity	(I)V
    //   2071: aload 29
    //   2073: iconst_1
    //   2074: ldc_w 540
    //   2077: invokevirtual 544	android/widget/TextView:setTextSize	(IF)V
    //   2080: aload 29
    //   2082: aload 28
    //   2084: invokevirtual 547	android/widget/TextView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2087: aload 29
    //   2089: aload_0
    //   2090: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2093: invokevirtual 120	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2096: aload 29
    //   2098: ldc_w 548
    //   2101: aload 27
    //   2103: invokevirtual 552	android/widget/TextView:setTag	(ILjava/lang/Object;)V
    //   2106: aload_0
    //   2107: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2110: getfield 427	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2113: aload 29
    //   2115: aload 30
    //   2117: invokevirtual 556	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2120: goto -168 -> 1952
    //   2123: aload_0
    //   2124: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2127: getfield 427	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2130: invokevirtual 559	android/widget/LinearLayout:getChildCount	()I
    //   2133: ifne +18 -> 2151
    //   2136: aload_0
    //   2137: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2140: getfield 561	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   2143: bipush 8
    //   2145: invokevirtual 92	android/view/View:setVisibility	(I)V
    //   2148: goto +92 -> 2240
    //   2151: aload_0
    //   2152: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2155: getfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2158: ifnull +24 -> 2182
    //   2161: aload_0
    //   2162: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2165: getfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2168: invokeinterface 105 1 0
    //   2173: ifeq +6 -> 2179
    //   2176: goto +6 -> 2182
    //   2179: goto +18 -> 2197
    //   2182: aload 6
    //   2184: ifnull +56 -> 2240
    //   2187: aload 6
    //   2189: invokeinterface 105 1 0
    //   2194: ifne +46 -> 2240
    //   2197: aload_0
    //   2198: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2201: getfield 561	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   2204: iconst_0
    //   2205: invokevirtual 92	android/view/View:setVisibility	(I)V
    //   2208: goto +32 -> 2240
    //   2211: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2214: ifeq +13 -> 2227
    //   2217: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2220: iconst_2
    //   2221: ldc_w 563
    //   2224: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2227: return
    //   2228: aload_0
    //   2229: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2232: getfield 561	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   2235: bipush 8
    //   2237: invokevirtual 92	android/view/View:setVisibility	(I)V
    //   2240: aload 6
    //   2242: astore_3
    //   2243: aload_0
    //   2244: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2247: getfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2250: ifnull +307 -> 2557
    //   2253: aload_0
    //   2254: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2257: getfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2260: invokeinterface 105 1 0
    //   2265: ifne +292 -> 2557
    //   2268: aload_3
    //   2269: iload_2
    //   2270: aload_0
    //   2271: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2274: getfield 565	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_Boolean	Z
    //   2277: invokestatic 570	com/tencent/mobileqq/search/SearchUtil:a	(Ljava/util/List;ZZ)Ljava/util/List;
    //   2280: astore_3
    //   2281: iload_2
    //   2282: ifne +233 -> 2515
    //   2285: lload 19
    //   2287: aload_0
    //   2288: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2291: invokestatic 573	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)J
    //   2294: lcmp
    //   2295: ifne +220 -> 2515
    //   2298: iload 10
    //   2300: ifne +215 -> 2515
    //   2303: aload_3
    //   2304: ifnull +211 -> 2515
    //   2307: aload_3
    //   2308: invokeinterface 280 1 0
    //   2313: ifle +202 -> 2515
    //   2316: aload_0
    //   2317: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2320: getfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2323: aload_0
    //   2324: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2327: getfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2330: invokeinterface 280 1 0
    //   2335: iconst_1
    //   2336: isub
    //   2337: invokeinterface 576 2 0
    //   2342: checkcast 578	com/tencent/mobileqq/search/model/IModel
    //   2345: astore 4
    //   2347: aload_3
    //   2348: iconst_0
    //   2349: invokeinterface 581 2 0
    //   2354: pop
    //   2355: iconst_0
    //   2356: istore 12
    //   2358: iconst_0
    //   2359: istore 13
    //   2361: iload 13
    //   2363: aload_3
    //   2364: invokeinterface 280 1 0
    //   2369: if_icmpge +44 -> 2413
    //   2372: aload_3
    //   2373: iload 13
    //   2375: invokeinterface 576 2 0
    //   2380: checkcast 578	com/tencent/mobileqq/search/model/IModel
    //   2383: instanceof 583
    //   2386: ifeq +10 -> 2396
    //   2389: iload 13
    //   2391: istore 12
    //   2393: goto +20 -> 2413
    //   2396: iload 13
    //   2398: iconst_1
    //   2399: iadd
    //   2400: istore 15
    //   2402: iload 13
    //   2404: istore 12
    //   2406: iload 15
    //   2408: istore 13
    //   2410: goto -49 -> 2361
    //   2413: aload 4
    //   2415: instanceof 250
    //   2418: ifeq +36 -> 2454
    //   2421: aload 4
    //   2423: checkcast 250	com/tencent/mobileqq/search/model/ISearchResultModel
    //   2426: astore 4
    //   2428: aload 4
    //   2430: invokeinterface 585 1 0
    //   2435: istore 13
    //   2437: aload 4
    //   2439: iload 13
    //   2441: iload 12
    //   2443: iadd
    //   2444: iload 13
    //   2446: iconst_1
    //   2447: isub
    //   2448: invokestatic 590	com/tencent/mobileqq/search/base/util/SearchViewUtils:a	(Lcom/tencent/mobileqq/search/model/ISearchResultModel;II)V
    //   2451: goto +6 -> 2457
    //   2454: iconst_0
    //   2455: istore 13
    //   2457: iconst_0
    //   2458: istore 15
    //   2460: iload 15
    //   2462: iload 12
    //   2464: if_icmpge +51 -> 2515
    //   2467: aload_3
    //   2468: iload 15
    //   2470: invokeinterface 576 2 0
    //   2475: checkcast 578	com/tencent/mobileqq/search/model/IModel
    //   2478: astore 4
    //   2480: aload 4
    //   2482: instanceof 250
    //   2485: ifeq +21 -> 2506
    //   2488: aload 4
    //   2490: checkcast 250	com/tencent/mobileqq/search/model/ISearchResultModel
    //   2493: iload 13
    //   2495: iload 12
    //   2497: iadd
    //   2498: iload 13
    //   2500: iload 15
    //   2502: iadd
    //   2503: invokestatic 590	com/tencent/mobileqq/search/base/util/SearchViewUtils:a	(Lcom/tencent/mobileqq/search/model/ISearchResultModel;II)V
    //   2506: iload 15
    //   2508: iconst_1
    //   2509: iadd
    //   2510: istore 15
    //   2512: goto -52 -> 2460
    //   2515: aload_0
    //   2516: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2519: aload_3
    //   2520: invokevirtual 593	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Ljava/util/List;)V
    //   2523: aload_0
    //   2524: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2527: getfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2530: aload_3
    //   2531: invokeinterface 301 2 0
    //   2536: pop
    //   2537: aload_0
    //   2538: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2541: getfield 596	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter	Lcom/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter;
    //   2544: aload_0
    //   2545: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2548: getfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2551: invokevirtual 599	com/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter:a	(Ljava/util/List;)V
    //   2554: goto +651 -> 3205
    //   2557: aload_3
    //   2558: ifnull +31 -> 2589
    //   2561: aload 6
    //   2563: invokeinterface 105 1 0
    //   2568: ifeq +6 -> 2574
    //   2571: goto +18 -> 2589
    //   2574: aload_0
    //   2575: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2578: getfield 129	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Landroid/view/View;
    //   2581: bipush 8
    //   2583: invokevirtual 92	android/view/View:setVisibility	(I)V
    //   2586: goto +571 -> 3157
    //   2589: aload_0
    //   2590: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2593: getfield 129	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:g	Landroid/view/View;
    //   2596: iconst_0
    //   2597: invokevirtual 92	android/view/View:setVisibility	(I)V
    //   2600: aload_0
    //   2601: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2604: getfield 602	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2607: getstatic 607	com/tencent/mobileqq/app/QQManagerFactory:MAYKNOW_RECOMMEND_MANAGER	I
    //   2610: invokevirtual 613	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2613: checkcast 615	com/tencent/mobileqq/app/MayknowRecommendManager
    //   2616: astore 4
    //   2618: iload 17
    //   2620: ifne +323 -> 2943
    //   2623: aload 4
    //   2625: getfield 616	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_d_of_type_Boolean	Z
    //   2628: ifeq +315 -> 2943
    //   2631: aload_0
    //   2632: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2635: getfield 619	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2638: ifnonnull +281 -> 2919
    //   2641: aload_0
    //   2642: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2645: astore 4
    //   2647: aload 4
    //   2649: new 621	com/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopListWrapperForSearchEmpty
    //   2652: dup
    //   2653: aload 4
    //   2655: getfield 602	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2658: aload_0
    //   2659: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2662: invokevirtual 336	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2665: aload_0
    //   2666: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2669: getfield 623	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   2672: aconst_null
    //   2673: invokespecial 626	com/tencent/mobileqq/activity/contact/recommendtroop/RecommendTroopListWrapperForSearchEmpty:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/widget/XListView;Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper$RecommendTroopListWrapperCallback;)V
    //   2676: putfield 619	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2679: aload_0
    //   2680: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2683: getfield 619	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2686: invokevirtual 631	com/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper:a	()Lcom/tencent/widget/XListView;
    //   2689: astore 4
    //   2691: new 110	android/widget/TextView
    //   2694: dup
    //   2695: aload_0
    //   2696: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2699: invokevirtual 336	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2702: invokespecial 502	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2705: astore 6
    //   2707: aload 6
    //   2709: bipush 17
    //   2711: invokevirtual 539	android/widget/TextView:setGravity	(I)V
    //   2714: aload 6
    //   2716: new 633	com/tencent/widget/AbsListView$LayoutParams
    //   2719: dup
    //   2720: iconst_m1
    //   2721: ldc_w 634
    //   2724: aload_0
    //   2725: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2728: invokevirtual 136	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2731: invokestatic 639	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   2734: invokespecial 640	com/tencent/widget/AbsListView$LayoutParams:<init>	(II)V
    //   2737: invokevirtual 644	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2740: aload 6
    //   2742: aload_0
    //   2743: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2746: invokevirtual 136	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2749: ldc_w 645
    //   2752: invokevirtual 651	android/content/res/Resources:getColor	(I)I
    //   2755: invokevirtual 518	android/widget/TextView:setTextColor	(I)V
    //   2758: aload 6
    //   2760: iconst_1
    //   2761: ldc_w 652
    //   2764: invokevirtual 544	android/widget/TextView:setTextSize	(IF)V
    //   2767: aload 6
    //   2769: ldc_w 653
    //   2772: invokestatic 165	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   2775: invokevirtual 169	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2778: aload 6
    //   2780: ldc_w 654
    //   2783: invokevirtual 657	android/widget/TextView:setBackgroundResource	(I)V
    //   2786: aload 4
    //   2788: aload 6
    //   2790: invokevirtual 663	com/tencent/widget/ListView:addHeaderView	(Landroid/view/View;)V
    //   2793: new 110	android/widget/TextView
    //   2796: dup
    //   2797: aload_0
    //   2798: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2801: invokevirtual 336	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   2804: invokespecial 502	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   2807: astore 6
    //   2809: aload 6
    //   2811: aload_0
    //   2812: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2815: invokevirtual 136	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2818: ldc_w 645
    //   2821: invokevirtual 651	android/content/res/Resources:getColor	(I)I
    //   2824: invokevirtual 518	android/widget/TextView:setTextColor	(I)V
    //   2827: aload 6
    //   2829: iconst_1
    //   2830: ldc_w 540
    //   2833: invokevirtual 544	android/widget/TextView:setTextSize	(IF)V
    //   2836: aload 6
    //   2838: bipush 16
    //   2840: invokevirtual 539	android/widget/TextView:setGravity	(I)V
    //   2843: aload 6
    //   2845: ldc_w 448
    //   2848: aload_0
    //   2849: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2852: invokevirtual 136	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2855: invokestatic 639	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   2858: iconst_0
    //   2859: iconst_0
    //   2860: iconst_0
    //   2861: invokevirtual 513	android/widget/TextView:setPadding	(IIII)V
    //   2864: aload 6
    //   2866: new 633	com/tencent/widget/AbsListView$LayoutParams
    //   2869: dup
    //   2870: iconst_m1
    //   2871: ldc_w 664
    //   2874: aload_0
    //   2875: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2878: invokevirtual 136	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2881: invokestatic 639	com/tencent/mobileqq/activity/aio/AIOUtils:b	(FLandroid/content/res/Resources;)I
    //   2884: invokespecial 640	com/tencent/widget/AbsListView$LayoutParams:<init>	(II)V
    //   2887: invokevirtual 644	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2890: aload 6
    //   2892: ldc_w 665
    //   2895: invokestatic 165	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   2898: invokevirtual 169	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2901: aload 6
    //   2903: ldc_w 654
    //   2906: invokevirtual 657	android/widget/TextView:setBackgroundResource	(I)V
    //   2909: aload 4
    //   2911: aload 6
    //   2913: invokevirtual 663	com/tencent/widget/ListView:addHeaderView	(Landroid/view/View;)V
    //   2916: goto +13 -> 2929
    //   2919: aload_0
    //   2920: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2923: getfield 619	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper	Lcom/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper;
    //   2926: invokevirtual 667	com/tencent/mobileqq/troop/recommend/RecommendTroopListWrapper:d	()V
    //   2929: aload_0
    //   2930: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2933: getfield 623	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   2936: iconst_0
    //   2937: invokevirtual 126	com/tencent/widget/XListView:setVisibility	(I)V
    //   2940: goto +190 -> 3130
    //   2943: aload_0
    //   2944: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2947: getfield 623	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   2950: bipush 8
    //   2952: invokevirtual 126	com/tencent/widget/XListView:setVisibility	(I)V
    //   2955: aload_0
    //   2956: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2959: getfield 132	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2962: ifnonnull +67 -> 3029
    //   2965: aload_0
    //   2966: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2969: invokevirtual 24	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:isAdded	()Z
    //   2972: ifeq +57 -> 3029
    //   2975: aload_0
    //   2976: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2979: aload_0
    //   2980: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2983: invokevirtual 136	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getResources	()Landroid/content/res/Resources;
    //   2986: ldc 137
    //   2988: invokestatic 143	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2991: putfield 132	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   2994: aload_0
    //   2995: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   2998: getfield 146	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   3001: aload_0
    //   3002: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3005: getfield 132	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   3008: invokevirtual 152	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   3011: goto +18 -> 3029
    //   3014: astore 4
    //   3016: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3019: iconst_1
    //   3020: aload 4
    //   3022: iconst_0
    //   3023: anewarray 154	java/lang/Object
    //   3026: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   3029: aload_0
    //   3030: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3033: getfield 159	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   3036: ldc_w 668
    //   3039: invokestatic 165	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3042: invokevirtual 169	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   3045: iload 17
    //   3047: ifeq +86 -> 3133
    //   3050: aload_0
    //   3051: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3054: getfield 671	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3057: iconst_0
    //   3058: invokevirtual 674	android/widget/Button:setVisibility	(I)V
    //   3061: aload_0
    //   3062: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3065: getfield 671	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3068: new 676	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2$1
    //   3071: dup
    //   3072: aload_0
    //   3073: aload 9
    //   3075: invokespecial 679	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2$1:<init>	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2;Ljava/lang/String;)V
    //   3078: invokevirtual 680	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3081: aload 8
    //   3083: invokestatic 382	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3086: ifne +44 -> 3130
    //   3089: aload_0
    //   3090: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3093: getfield 671	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3096: aload 8
    //   3098: invokevirtual 681	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   3101: aload_0
    //   3102: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3105: getfield 159	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   3108: iconst_0
    //   3109: aload_0
    //   3110: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3113: getfield 159	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   3116: invokevirtual 685	android/widget/TextView:getContext	()Landroid/content/Context;
    //   3119: ldc_w 448
    //   3122: invokestatic 443	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   3125: iconst_0
    //   3126: iconst_0
    //   3127: invokevirtual 513	android/widget/TextView:setPadding	(IIII)V
    //   3130: goto +15 -> 3145
    //   3133: aload_0
    //   3134: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3137: getfield 671	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3140: bipush 8
    //   3142: invokevirtual 674	android/widget/Button:setVisibility	(I)V
    //   3145: aload_0
    //   3146: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3149: getfield 412	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:c	Landroid/widget/TextView;
    //   3152: bipush 8
    //   3154: invokevirtual 111	android/widget/TextView:setVisibility	(I)V
    //   3157: aload_3
    //   3158: iload_2
    //   3159: aload_0
    //   3160: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3163: getfield 565	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_Boolean	Z
    //   3166: invokestatic 570	com/tencent/mobileqq/search/SearchUtil:a	(Ljava/util/List;ZZ)Ljava/util/List;
    //   3169: astore_3
    //   3170: aload_0
    //   3171: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3174: aload_3
    //   3175: invokevirtual 593	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Ljava/util/List;)V
    //   3178: aload_0
    //   3179: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3182: astore 4
    //   3184: aload 4
    //   3186: aload_3
    //   3187: putfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3190: aload 4
    //   3192: getfield 596	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter	Lcom/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter;
    //   3195: aload_0
    //   3196: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3199: getfield 100	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   3202: invokevirtual 599	com/tencent/mobileqq/search/adapter/SubBusinessSearchAdapter:a	(Ljava/util/List;)V
    //   3205: aload_0
    //   3206: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3209: lload 21
    //   3211: invokestatic 688	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;J)J
    //   3214: pop2
    //   3215: aload_0
    //   3216: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3219: getfield 379	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Boolean	Z
    //   3222: ifne +99 -> 3321
    //   3225: aload_0
    //   3226: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3229: astore_3
    //   3230: aload_3
    //   3231: aload_3
    //   3232: getfield 368	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Int	I
    //   3235: iload 14
    //   3237: iadd
    //   3238: putfield 368	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Int	I
    //   3241: aload_0
    //   3242: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3245: astore_3
    //   3246: aload_3
    //   3247: aload_3
    //   3248: getfield 372	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Int	I
    //   3251: iconst_1
    //   3252: iadd
    //   3253: putfield 372	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Int	I
    //   3256: aload_0
    //   3257: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3260: getfield 368	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Int	I
    //   3263: bipush 10
    //   3265: if_icmple +21 -> 3286
    //   3268: aload_0
    //   3269: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3272: astore_3
    //   3273: aload_3
    //   3274: iconst_0
    //   3275: putfield 372	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Int	I
    //   3278: aload_3
    //   3279: iconst_0
    //   3280: putfield 368	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Int	I
    //   3283: goto +38 -> 3321
    //   3286: aload_0
    //   3287: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3290: getfield 372	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Int	I
    //   3293: iconst_3
    //   3294: if_icmplt +14 -> 3308
    //   3297: aload_0
    //   3298: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3301: iconst_1
    //   3302: putfield 379	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Boolean	Z
    //   3305: goto +16 -> 3321
    //   3308: aload_0
    //   3309: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3312: astore_3
    //   3313: aload_3
    //   3314: aload_3
    //   3315: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3318: invokevirtual 690	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	(Ljava/lang/String;)V
    //   3321: iload 5
    //   3323: ifeq +116 -> 3439
    //   3326: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3329: ifeq +220 -> 3549
    //   3332: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3335: astore_3
    //   3336: new 29	java/lang/StringBuilder
    //   3339: dup
    //   3340: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   3343: astore 4
    //   3345: aload 4
    //   3347: ldc_w 692
    //   3350: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3353: pop
    //   3354: aload 4
    //   3356: aload 7
    //   3358: invokestatic 185	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3361: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3364: pop
    //   3365: aload 4
    //   3367: ldc 187
    //   3369: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3372: pop
    //   3373: aload 4
    //   3375: aload_1
    //   3376: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3379: pop
    //   3380: aload 4
    //   3382: ldc 189
    //   3384: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3387: pop
    //   3388: aload 4
    //   3390: aload_0
    //   3391: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3394: getfield 191	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3397: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3400: pop
    //   3401: aload 4
    //   3403: ldc_w 694
    //   3406: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3409: pop
    //   3410: aload 4
    //   3412: aload_0
    //   3413: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3416: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   3419: invokestatic 185	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3422: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3425: pop
    //   3426: aload_3
    //   3427: iconst_2
    //   3428: aload 4
    //   3430: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3433: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3436: goto +113 -> 3549
    //   3439: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3442: ifeq +107 -> 3549
    //   3445: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3448: astore_3
    //   3449: new 29	java/lang/StringBuilder
    //   3452: dup
    //   3453: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   3456: astore 4
    //   3458: aload 4
    //   3460: ldc_w 696
    //   3463: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3466: pop
    //   3467: aload 4
    //   3469: aload 7
    //   3471: invokestatic 185	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3474: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3477: pop
    //   3478: aload 4
    //   3480: ldc 187
    //   3482: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3485: pop
    //   3486: aload 4
    //   3488: aload_1
    //   3489: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3492: pop
    //   3493: aload 4
    //   3495: ldc 189
    //   3497: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3500: pop
    //   3501: aload 4
    //   3503: aload_0
    //   3504: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3507: getfield 191	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3510: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3513: pop
    //   3514: aload 4
    //   3516: ldc_w 694
    //   3519: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3522: pop
    //   3523: aload 4
    //   3525: aload_0
    //   3526: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3529: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   3532: invokestatic 185	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   3535: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3538: pop
    //   3539: aload_3
    //   3540: iconst_2
    //   3541: aload 4
    //   3543: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3546: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3549: iconst_1
    //   3550: putstatic 698	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:a	Z
    //   3553: return
    //   3554: getstatic 27	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3557: astore_3
    //   3558: new 29	java/lang/StringBuilder
    //   3561: dup
    //   3562: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   3565: astore 4
    //   3567: aload 4
    //   3569: ldc_w 700
    //   3572: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3575: pop
    //   3576: aload 4
    //   3578: aload_0
    //   3579: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3582: getfield 72	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   3585: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3588: pop
    //   3589: aload 4
    //   3591: ldc_w 702
    //   3594: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3597: pop
    //   3598: aload 4
    //   3600: aload 7
    //   3602: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3605: pop
    //   3606: aload 4
    //   3608: ldc_w 704
    //   3611: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3614: pop
    //   3615: aload 4
    //   3617: aload_1
    //   3618: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3621: pop
    //   3622: aload 4
    //   3624: ldc 202
    //   3626: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3629: pop
    //   3630: aload 4
    //   3632: aload_0
    //   3633: getfield 10	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment$2:a	Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;
    //   3636: getfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3639: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3642: pop
    //   3643: aload 4
    //   3645: ldc 206
    //   3647: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3650: pop
    //   3651: aload 4
    //   3653: iload 5
    //   3655: invokevirtual 41	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3658: pop
    //   3659: aload_3
    //   3660: iconst_2
    //   3661: aload 4
    //   3663: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3666: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3669: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3670	0	this	2
    //   0	3670	1	paramString1	String
    //   0	3670	2	paramBoolean1	boolean
    //   0	3670	3	paramString2	String
    //   0	3670	4	paramArrayOfByte	byte[]
    //   0	3670	5	paramBoolean2	boolean
    //   0	3670	6	paramList	List<com.tencent.mobileqq.search.model.ISearchResultGroupModel>
    //   0	3670	7	paramArrayOfLong	long[]
    //   0	3670	8	paramString3	String
    //   0	3670	9	paramList1	List<tencent.im.oidb.search.DynamicTabSearch.SubHotWord>
    //   0	3670	10	paramBoolean3	boolean
    //   0	3670	11	paramString4	String
    //   0	3670	12	paramInt	int
    //   1647	856	13	i	int
    //   372	2866	14	j	int
    //   1818	693	15	k	int
    //   1825	169	16	m	int
    //   1427	1619	17	bool1	boolean
    //   1450	557	18	bool2	boolean
    //   377	1909	19	l1	long
    //   369	2841	21	l2	long
    //   411	320	23	l3	long
    //   403	320	25	l4	long
    //   364	1738	27	localObject1	Object
    //   399	1684	28	localObject2	Object
    //   436	1678	29	localObject3	Object
    //   443	1673	30	localObject4	Object
    //   452	13	31	localIterator	java.util.Iterator
    //   474	31	32	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   1438	1448	1458	org/json/JSONException
    //   1429	1438	1463	org/json/JSONException
    //   1408	1429	1472	org/json/JSONException
    //   2965	3011	3014	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment.2
 * JD-Core Version:    0.7.0.1
 */