package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentHelper
{
  public static int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 10) {
      i = 1;
    }
    return i;
  }
  
  public static boolean a()
  {
    long l = ((Long)RIJSPUtils.b("family_comment_card_hide_timestamp", Long.valueOf(-1L))).longValue();
    if (l == -1L)
    {
      QLog.d("ReadInJoyCommentHelper", 1, "shoudHideCommentView | false cuz never click hide btn ");
      return false;
    }
    Object localObject = Aladdin.getConfig(243);
    double d = 3.0D;
    if (localObject != null)
    {
      d = ((AladdinConfig)localObject).getIntegerFromString("family_comment_card_hide_interval", 3);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shoudHideCommentView | comment hide interval  ");
      ((StringBuilder)localObject).append(d);
      ((StringBuilder)localObject).append(" 天");
      QLog.d("ReadInJoyCommentHelper", 1, ((StringBuilder)localObject).toString());
    }
    if (System.currentTimeMillis() - l <= d * 24.0D * 60.0D * 60.0D * 1000.0D)
    {
      QLog.d("ReadInJoyCommentHelper", 1, "shoudHideCommentView | true ");
      return true;
    }
    QLog.d("ReadInJoyCommentHelper", 1, "shoudHideCommentView | false ");
    return false;
  }
  
  public static String b()
  {
    Object localObject = Aladdin.getConfig(243);
    double d;
    if (localObject != null)
    {
      d = ((AladdinConfig)localObject).getIntegerFromString("family_comment_card_hide_interval", 3);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shoudHideCommentView | comment hide interval  ");
      ((StringBuilder)localObject).append(d);
      ((StringBuilder)localObject).append(" 天");
      QLog.d("ReadInJoyCommentHelper", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      d = 3.0D;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("确定");
    ((StringBuilder)localObject).append((int)d);
    ((StringBuilder)localObject).append("天内不再展示家族占领入口？");
    return ((StringBuilder)localObject).toString();
  }
  
  /* Error */
  public android.os.Bundle a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 103
    //   3: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 12
    //   8: aload_1
    //   9: ldc 111
    //   11: iconst_3
    //   12: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   15: istore_2
    //   16: aload_1
    //   17: ldc 116
    //   19: ldc 118
    //   21: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 16
    //   26: aload_1
    //   27: ldc 123
    //   29: iconst_m1
    //   30: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   33: istore_3
    //   34: aload_1
    //   35: ldc 125
    //   37: iconst_m1
    //   38: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   41: istore 4
    //   43: aload_1
    //   44: ldc 127
    //   46: ldc 118
    //   48: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 13
    //   53: aload_1
    //   54: ldc 129
    //   56: ldc 118
    //   58: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: astore 17
    //   63: aload_1
    //   64: ldc 131
    //   66: ldc 118
    //   68: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 14
    //   73: aload_1
    //   74: ldc 133
    //   76: ldc2_w 15
    //   79: invokevirtual 137	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   82: lstore 7
    //   84: aload_1
    //   85: ldc 139
    //   87: ldc 118
    //   89: invokevirtual 121	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 18
    //   94: aload_1
    //   95: ldc 141
    //   97: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 10
    //   102: aload_1
    //   103: ldc 143
    //   105: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore 11
    //   110: aload_1
    //   111: ldc 145
    //   113: invokevirtual 149	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   116: istore 9
    //   118: aload_1
    //   119: ldc 151
    //   121: invokevirtual 154	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   124: istore 5
    //   126: aload_1
    //   127: ldc 156
    //   129: iconst_5
    //   130: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   133: istore 6
    //   135: new 60	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   142: astore_1
    //   143: aload_1
    //   144: ldc 158
    //   146: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_1
    //   151: aload 12
    //   153: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: ldc 160
    //   160: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_1
    //   165: iload_2
    //   166: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: ldc 162
    //   173: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: aload 16
    //   180: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_1
    //   185: ldc 164
    //   187: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: iload_3
    //   193: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_1
    //   198: ldc 166
    //   200: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: iload 4
    //   207: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_1
    //   212: ldc 168
    //   214: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_1
    //   219: aload 13
    //   221: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_1
    //   226: ldc 170
    //   228: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_1
    //   233: aload 17
    //   235: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_1
    //   240: ldc 172
    //   242: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_1
    //   247: aload 14
    //   249: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_1
    //   254: ldc 174
    //   256: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_1
    //   261: lload 7
    //   263: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: ldc 179
    //   270: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_1
    //   275: aload 18
    //   277: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_1
    //   282: ldc 181
    //   284: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_1
    //   289: iload 6
    //   291: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_1
    //   296: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: astore 15
    //   301: ldc 34
    //   303: astore_1
    //   304: aload_1
    //   305: iconst_1
    //   306: aload 15
    //   308: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: new 183	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData
    //   314: dup
    //   315: invokespecial 184	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:<init>	()V
    //   318: astore 15
    //   320: aload 15
    //   322: aload 10
    //   324: putfield 187	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:a	Ljava/lang/String;
    //   327: aload 15
    //   329: aload 11
    //   331: putfield 189	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:b	Ljava/lang/String;
    //   334: aload 15
    //   336: iload 9
    //   338: putfield 193	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:c	Z
    //   341: new 195	com/tencent/mobileqq/kandian/biz/comment/entity/CommonCommentData
    //   344: dup
    //   345: aload 18
    //   347: iload_3
    //   348: aload 16
    //   350: iload 4
    //   352: aload 13
    //   354: aload 17
    //   356: aload 14
    //   358: lload 7
    //   360: invokespecial 198	com/tencent/mobileqq/kandian/biz/comment/entity/CommonCommentData:<init>	(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   363: astore 16
    //   365: new 60	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   372: astore 17
    //   374: aload 17
    //   376: ldc 200
    //   378: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 17
    //   384: aload 16
    //   386: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 17
    //   392: ldc 205
    //   394: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 17
    //   400: aload 15
    //   402: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_1
    //   407: iconst_1
    //   408: aload 17
    //   410: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: new 207	com/tencent/mobileqq/kandian/repo/db/struct/BaseArticleInfo
    //   419: dup
    //   420: invokespecial 208	com/tencent/mobileqq/kandian/repo/db/struct/BaseArticleInfo:<init>	()V
    //   423: astore 17
    //   425: aload 17
    //   427: aload 12
    //   429: putfield 213	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   432: aload 17
    //   434: aload 13
    //   436: putfield 216	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   439: aload 17
    //   441: ldc 118
    //   443: putfield 219	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSummary	Ljava/lang/String;
    //   446: aload 17
    //   448: aload 14
    //   450: putfield 222	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   453: aload 16
    //   455: invokevirtual 225	com/tencent/mobileqq/kandian/biz/comment/entity/CommonCommentData:getArticleId	()Ljava/lang/String;
    //   458: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   461: ifne +16 -> 477
    //   464: aload 17
    //   466: aload 16
    //   468: invokevirtual 225	com/tencent/mobileqq/kandian/biz/comment/entity/CommonCommentData:getArticleId	()Ljava/lang/String;
    //   471: invokestatic 235	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   474: putfield 239	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleID	J
    //   477: aload 16
    //   479: invokevirtual 242	com/tencent/mobileqq/kandian/biz/comment/entity/CommonCommentData:getFeedsId	()Ljava/lang/String;
    //   482: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   485: ifne +23 -> 508
    //   488: aload 17
    //   490: new 244	java/math/BigInteger
    //   493: dup
    //   494: aload 16
    //   496: invokevirtual 242	com/tencent/mobileqq/kandian/biz/comment/entity/CommonCommentData:getFeedsId	()Ljava/lang/String;
    //   499: invokespecial 247	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   502: invokevirtual 248	java/math/BigInteger:longValue	()J
    //   505: putfield 251	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedId	J
    //   508: aload 16
    //   510: invokevirtual 255	com/tencent/mobileqq/kandian/biz/comment/entity/CommonCommentData:getFeedsType	()I
    //   513: iconst_m1
    //   514: if_icmpeq +13 -> 527
    //   517: aload 17
    //   519: aload 16
    //   521: invokevirtual 255	com/tencent/mobileqq/kandian/biz/comment/entity/CommonCommentData:getFeedsType	()I
    //   524: putfield 259	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedType	I
    //   527: new 60	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   534: astore 12
    //   536: aload 12
    //   538: ldc_w 261
    //   541: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 12
    //   547: aload 17
    //   549: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload_1
    //   554: iconst_1
    //   555: aload 12
    //   557: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: new 263	android/os/Bundle
    //   566: dup
    //   567: invokespecial 264	android/os/Bundle:<init>	()V
    //   570: astore 12
    //   572: aload 12
    //   574: ldc_w 266
    //   577: aload 16
    //   579: invokevirtual 270	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   582: aload 12
    //   584: ldc_w 272
    //   587: aload 15
    //   589: invokevirtual 276	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   592: aload 12
    //   594: ldc_w 278
    //   597: aload 17
    //   599: invokevirtual 276	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   602: aload 12
    //   604: ldc 111
    //   606: iload_2
    //   607: invokevirtual 282	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   610: aload 12
    //   612: ldc_w 284
    //   615: aload 10
    //   617: invokevirtual 288	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: aload 12
    //   622: ldc_w 290
    //   625: aload 11
    //   627: invokevirtual 288	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: aload 12
    //   632: ldc 145
    //   634: iload 9
    //   636: invokevirtual 294	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   639: aload 12
    //   641: ldc 151
    //   643: iload 5
    //   645: invokevirtual 282	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   648: aload 12
    //   650: ldc_w 296
    //   653: iconst_1
    //   654: invokevirtual 294	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   657: aload 12
    //   659: ldc 156
    //   661: iload 6
    //   663: invokevirtual 282	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   666: new 60	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   673: astore 10
    //   675: aload 10
    //   677: ldc_w 298
    //   680: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload 10
    //   686: aload 12
    //   688: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload_1
    //   693: iconst_1
    //   694: aload 10
    //   696: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: aload 12
    //   704: areturn
    //   705: astore_1
    //   706: goto +8 -> 714
    //   709: astore_1
    //   710: goto +4 -> 714
    //   713: astore_1
    //   714: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   717: ifeq +13 -> 730
    //   720: ldc 34
    //   722: iconst_2
    //   723: aload_1
    //   724: invokestatic 305	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   727: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: new 263	android/os/Bundle
    //   733: dup
    //   734: invokespecial 264	android/os/Bundle:<init>	()V
    //   737: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	738	0	this	ReadInJoyCommentHelper
    //   0	738	1	paramJSONObject	JSONObject
    //   15	592	2	i	int
    //   33	315	3	j	int
    //   41	310	4	k	int
    //   124	520	5	m	int
    //   133	529	6	n	int
    //   82	277	7	l	long
    //   116	519	9	bool	boolean
    //   100	595	10	localObject1	Object
    //   108	518	11	str1	String
    //   6	697	12	localObject2	Object
    //   51	384	13	str2	String
    //   71	378	14	str3	String
    //   299	289	15	localObject3	Object
    //   24	554	16	localObject4	Object
    //   61	537	17	localObject5	Object
    //   92	254	18	str4	String
    // Exception table:
    //   from	to	target	type
    //   304	477	705	java/lang/Exception
    //   477	508	705	java/lang/Exception
    //   508	527	705	java/lang/Exception
    //   527	702	705	java/lang/Exception
    //   73	301	709	java/lang/Exception
    //   0	73	713	java/lang/Exception
  }
  
  public ReadInJoyCommentListFragment a(String paramString, ReadInJoyCommentListFragment.OnCreateViewListener paramOnCreateViewListener, ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener paramOnScrollYOffsetListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("buildCommentFragment | configJsonStr : ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ReadInJoyCommentHelper", 1, ((StringBuilder)localObject).toString());
    try
    {
      paramString = new JSONObject(paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buildCommentFragment | paramJsonStr ");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.d("ReadInJoyCommentHelper", 2, ((StringBuilder)localObject).toString());
      paramString = a(paramString);
      localObject = new ReadInJoyCommentListFragment();
      ((ReadInJoyCommentListFragment)localObject).setArguments(paramString);
      ((ReadInJoyCommentListFragment)localObject).a(paramOnCreateViewListener);
      ((ReadInJoyCommentListFragment)localObject).a(paramOnScrollYOffsetListener);
      return localObject;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentHelper
 * JD-Core Version:    0.7.0.1
 */