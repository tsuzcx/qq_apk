package com.tencent.mobileqq.kandian.biz.framework;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class RIJCreateArticleInfoForBiu
{
  public static Intent a(Intent paramIntent, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2, int paramInt3)
  {
    if (paramIntent == null) {
      return paramIntent;
    }
    new BaseArticleInfo();
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramAbsBaseArticleInfo.clone();
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null) {
      localAbsBaseArticleInfo.mSocialFeedInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.a();
    }
    if (localAbsBaseArticleInfo.mSocialFeedInfo == null) {
      localAbsBaseArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
    }
    if (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo == null) {
      localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo = new BiuInfo();
    }
    localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramAbsBaseArticleInfo = new BiuCommentInfo();
    paramAbsBaseArticleInfo.mUin = Long.valueOf(paramLong);
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString1)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(": ");
      localStringBuilder.append(paramString1);
      paramAbsBaseArticleInfo.mOrigBiuComment = localStringBuilder.toString();
    }
    ReadInJoyUserInfoModule.a(paramLong, paramString2);
    paramAbsBaseArticleInfo.mFeedsType = localAbsBaseArticleInfo.mFeedType;
    paramAbsBaseArticleInfo.mOpType = paramInt2;
    paramAbsBaseArticleInfo.mFeedId = Long.valueOf(localAbsBaseArticleInfo.mFeedId);
    paramString1 = new StringBuilder();
    paramString1.append("biuCommentInfo ");
    paramString1.append(paramAbsBaseArticleInfo.toString());
    QLog.d("RIJCreateArticleInfoForBiu", 2, paramString1.toString());
    localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.add(paramAbsBaseArticleInfo);
    paramIntent.putExtra("arg_article_info", localAbsBaseArticleInfo);
    paramIntent.putExtra("biu_rowkey", localAbsBaseArticleInfo.innerUniqueID);
    paramIntent.putExtra("feedsType", localAbsBaseArticleInfo.mFeedType);
    paramIntent.putExtra("arg_from_type", paramInt3);
    paramIntent.putExtra("biu_src", paramInt1);
    paramIntent.putExtra("feed_id", localAbsBaseArticleInfo.mFeedId);
    paramIntent.putExtra("feedsType", localAbsBaseArticleInfo.mFeedType);
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("readytoJump  biuType: ");
    paramAbsBaseArticleInfo.append(paramInt1);
    paramAbsBaseArticleInfo.append("feed_id : ");
    paramAbsBaseArticleInfo.append(localAbsBaseArticleInfo.mFeedId);
    paramAbsBaseArticleInfo.append("feeds_type : ");
    paramAbsBaseArticleInfo.append(localAbsBaseArticleInfo.mFeedType);
    paramAbsBaseArticleInfo.append("articleID : ");
    paramAbsBaseArticleInfo.append(localAbsBaseArticleInfo.mArticleID);
    QLog.d("RIJCreateArticleInfoForBiu", 2, paramAbsBaseArticleInfo.toString());
    return paramIntent;
  }
  
  /* Error */
  public static AbsBaseArticleInfo a(String paramString)
  {
    // Byte code:
    //   0: new 13	com/tencent/mobileqq/kandian/repo/db/struct/BaseArticleInfo
    //   3: dup
    //   4: invokespecial 14	com/tencent/mobileqq/kandian/repo/db/struct/BaseArticleInfo:<init>	()V
    //   7: astore 23
    //   9: new 168	org/json/JSONObject
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 171	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore 24
    //   19: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +38 -> 60
    //   25: new 63	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   32: astore_0
    //   33: aload_0
    //   34: ldc 177
    //   36: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_0
    //   41: aload 24
    //   43: invokevirtual 178	org/json/JSONObject:toString	()Ljava/lang/String;
    //   46: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: ldc 104
    //   52: iconst_2
    //   53: aload_0
    //   54: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload 24
    //   62: ldc 183
    //   64: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 20
    //   69: aload 24
    //   71: ldc 189
    //   73: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 21
    //   78: lconst_0
    //   79: lstore 17
    //   81: new 191	java/lang/String
    //   84: dup
    //   85: aload 20
    //   87: iconst_0
    //   88: invokestatic 197	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   91: invokespecial 200	java/lang/String:<init>	([B)V
    //   94: astore_0
    //   95: new 191	java/lang/String
    //   98: dup
    //   99: aload 21
    //   101: iconst_0
    //   102: invokestatic 197	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   105: invokespecial 200	java/lang/String:<init>	([B)V
    //   108: astore 19
    //   110: aload 24
    //   112: ldc 202
    //   114: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 20
    //   119: aload 20
    //   121: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   124: ifne +19 -> 143
    //   127: new 204	java/math/BigInteger
    //   130: dup
    //   131: aload 20
    //   133: invokespecial 205	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   136: invokevirtual 209	java/math/BigInteger:longValue	()J
    //   139: lstore_3
    //   140: goto +5 -> 145
    //   143: lconst_0
    //   144: lstore_3
    //   145: aload 24
    //   147: ldc 211
    //   149: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   152: astore 20
    //   154: aload 20
    //   156: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne +20 -> 179
    //   162: new 204	java/math/BigInteger
    //   165: dup
    //   166: aload 20
    //   168: invokespecial 205	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   171: invokevirtual 209	java/math/BigInteger:longValue	()J
    //   174: lstore 5
    //   176: goto +6 -> 182
    //   179: lconst_0
    //   180: lstore 5
    //   182: aload 24
    //   184: ldc 213
    //   186: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 20
    //   191: aload 20
    //   193: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifne +20 -> 216
    //   199: new 204	java/math/BigInteger
    //   202: dup
    //   203: aload 20
    //   205: invokespecial 205	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   208: invokevirtual 209	java/math/BigInteger:longValue	()J
    //   211: lstore 7
    //   213: goto +6 -> 219
    //   216: lconst_0
    //   217: lstore 7
    //   219: aload 24
    //   221: ldc 215
    //   223: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 22
    //   228: aload 19
    //   230: astore 21
    //   232: lload 17
    //   234: lstore 13
    //   236: aload_0
    //   237: astore 20
    //   239: lload_3
    //   240: lstore 15
    //   242: lload 5
    //   244: lstore 11
    //   246: lload 7
    //   248: lstore 9
    //   250: aload 22
    //   252: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   255: ifne +118 -> 373
    //   258: new 204	java/math/BigInteger
    //   261: dup
    //   262: aload 22
    //   264: invokespecial 205	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   267: invokevirtual 209	java/math/BigInteger:longValue	()J
    //   270: lstore 13
    //   272: aload 19
    //   274: astore 21
    //   276: aload_0
    //   277: astore 20
    //   279: lload_3
    //   280: lstore 15
    //   282: lload 5
    //   284: lstore 11
    //   286: lload 7
    //   288: lstore 9
    //   290: goto +83 -> 373
    //   293: astore 20
    //   295: goto +51 -> 346
    //   298: astore 20
    //   300: lconst_0
    //   301: lstore 7
    //   303: goto +43 -> 346
    //   306: astore 20
    //   308: goto +32 -> 340
    //   311: astore 20
    //   313: aload 19
    //   315: astore 21
    //   317: goto +17 -> 334
    //   320: astore 19
    //   322: goto +8 -> 330
    //   325: astore 19
    //   327: aload 20
    //   329: astore_0
    //   330: aload 19
    //   332: astore 20
    //   334: lconst_0
    //   335: lstore_3
    //   336: aload 21
    //   338: astore 19
    //   340: lconst_0
    //   341: lstore 5
    //   343: lconst_0
    //   344: lstore 7
    //   346: aload 20
    //   348: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   351: lload 7
    //   353: lstore 9
    //   355: lload 5
    //   357: lstore 11
    //   359: lload_3
    //   360: lstore 15
    //   362: aload_0
    //   363: astore 20
    //   365: lload 17
    //   367: lstore 13
    //   369: aload 19
    //   371: astore 21
    //   373: aload 24
    //   375: ldc 220
    //   377: lconst_1
    //   378: invokevirtual 224	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   381: lstore_3
    //   382: aload 24
    //   384: ldc 226
    //   386: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   389: astore 19
    //   391: aload 24
    //   393: ldc 228
    //   395: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   398: istore_1
    //   399: aload 24
    //   401: ldc 234
    //   403: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   406: pop
    //   407: aload 24
    //   409: ldc 236
    //   411: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   414: astore 22
    //   416: ldc 202
    //   418: astore_0
    //   419: new 191	java/lang/String
    //   422: dup
    //   423: aload 22
    //   425: iconst_0
    //   426: invokestatic 197	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   429: invokespecial 200	java/lang/String:<init>	([B)V
    //   432: astore 22
    //   434: aload 24
    //   436: ldc 134
    //   438: iconst_1
    //   439: invokevirtual 239	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   442: istore_2
    //   443: aload 23
    //   445: lload 11
    //   447: putfield 163	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleID	J
    //   450: aload 23
    //   452: aload 20
    //   454: putfield 242	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   457: aload 23
    //   459: aload 21
    //   461: putfield 245	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   464: aload 23
    //   466: aload 19
    //   468: putfield 248	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   471: aload 23
    //   473: iload_1
    //   474: putfield 251	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mVideoDuration	I
    //   477: aload 23
    //   479: lload 15
    //   481: putfield 97	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedId	J
    //   484: aload 23
    //   486: iload_2
    //   487: putfield 87	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedType	I
    //   490: aload 23
    //   492: aload 22
    //   494: putfield 254	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSummary	Ljava/lang/String;
    //   497: aload 23
    //   499: lload 13
    //   501: putfield 256	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:businessId	J
    //   504: aload 24
    //   506: ldc_w 258
    //   509: invokevirtual 262	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   512: astore 25
    //   514: aload 23
    //   516: new 26	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo
    //   519: dup
    //   520: invokespecial 30	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:<init>	()V
    //   523: putfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   526: aload 23
    //   528: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   531: new 35	com/tencent/mobileqq/kandian/repo/handler/BiuInfo
    //   534: dup
    //   535: invokespecial 36	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:<init>	()V
    //   538: putfield 33	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   541: aload 23
    //   543: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   546: getfield 33	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   549: lload 9
    //   551: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   554: putfield 264	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   557: aload 23
    //   559: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   562: getfield 33	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   565: lload_3
    //   566: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   569: putfield 267	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:b	Ljava/lang/Long;
    //   572: aload 23
    //   574: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   577: getfield 33	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   580: new 38	java/util/ArrayList
    //   583: dup
    //   584: invokespecial 39	java/util/ArrayList:<init>	()V
    //   587: putfield 42	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   590: ldc_w 269
    //   593: astore 21
    //   595: ldc_w 271
    //   598: astore 22
    //   600: aload_0
    //   601: astore 19
    //   603: aload 25
    //   605: ifnull +206 -> 811
    //   608: iconst_0
    //   609: istore_1
    //   610: aload_0
    //   611: astore 19
    //   613: iload_1
    //   614: aload 25
    //   616: invokevirtual 277	org/json/JSONArray:length	()I
    //   619: if_icmpge +192 -> 811
    //   622: new 44	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo
    //   625: dup
    //   626: invokespecial 45	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:<init>	()V
    //   629: astore 19
    //   631: aload 25
    //   633: iload_1
    //   634: invokevirtual 281	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   637: astore 26
    //   639: aload 19
    //   641: aload 26
    //   643: ldc_w 271
    //   646: invokevirtual 284	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   649: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   652: putfield 55	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mUin	Ljava/lang/Long;
    //   655: aload 19
    //   657: aload 26
    //   659: ldc_w 286
    //   662: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   665: putfield 78	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   668: aload 19
    //   670: aload 26
    //   672: ldc_w 269
    //   675: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   678: putfield 289	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mBiuTime	I
    //   681: aload 19
    //   683: aload 26
    //   685: ldc_w 291
    //   688: iconst_1
    //   689: invokevirtual 239	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   692: putfield 90	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mFeedsType	I
    //   695: aload 19
    //   697: aload 26
    //   699: ldc_w 293
    //   702: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   705: putfield 93	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOpType	I
    //   708: aload 26
    //   710: aload_0
    //   711: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   714: astore 26
    //   716: aload 26
    //   718: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   721: ifne +23 -> 744
    //   724: aload 19
    //   726: new 204	java/math/BigInteger
    //   729: dup
    //   730: aload 26
    //   732: invokespecial 205	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   735: invokevirtual 209	java/math/BigInteger:longValue	()J
    //   738: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   741: putfield 99	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mFeedId	Ljava/lang/Long;
    //   744: aload 19
    //   746: new 191	java/lang/String
    //   749: dup
    //   750: aload 19
    //   752: getfield 78	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   755: iconst_0
    //   756: invokestatic 197	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   759: invokespecial 200	java/lang/String:<init>	([B)V
    //   762: putfield 78	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   765: aload 19
    //   767: aload 19
    //   769: getfield 78	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   772: putfield 296	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mBiuComment	Ljava/lang/String;
    //   775: goto +10 -> 785
    //   778: astore 26
    //   780: aload 26
    //   782: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   785: aload 23
    //   787: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   790: getfield 33	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   793: getfield 42	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   796: aload 19
    //   798: invokeinterface 116 2 0
    //   803: pop
    //   804: iload_1
    //   805: iconst_1
    //   806: iadd
    //   807: istore_1
    //   808: goto -198 -> 610
    //   811: aload 24
    //   813: ldc_w 298
    //   816: invokevirtual 302	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   819: astore 24
    //   821: aload 24
    //   823: ifnull +582 -> 1405
    //   826: iload_2
    //   827: iconst_4
    //   828: if_icmpeq +29 -> 857
    //   831: iload_2
    //   832: iconst_5
    //   833: if_icmpeq +24 -> 857
    //   836: iload_2
    //   837: iconst_1
    //   838: if_icmpne +567 -> 1405
    //   841: lload_3
    //   842: ldc2_w 303
    //   845: lcmp
    //   846: ifeq +11 -> 857
    //   849: lload_3
    //   850: ldc2_w 305
    //   853: lcmp
    //   854: ifne +551 -> 1405
    //   857: aload 23
    //   859: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   862: new 308	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo
    //   865: dup
    //   866: invokespecial 309	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:<init>	()V
    //   869: putfield 312	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   872: aload 24
    //   874: ldc_w 314
    //   877: iconst_0
    //   878: invokevirtual 239	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   881: istore_2
    //   882: aload 24
    //   884: ldc_w 316
    //   887: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   890: astore 25
    //   892: aload 24
    //   894: ldc_w 318
    //   897: invokevirtual 321	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   900: astore 26
    //   902: aload 26
    //   904: ifnull +246 -> 1150
    //   907: aload 23
    //   909: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   912: getfield 312	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   915: new 35	com/tencent/mobileqq/kandian/repo/handler/BiuInfo
    //   918: dup
    //   919: invokespecial 36	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:<init>	()V
    //   922: putfield 322	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   925: aload 23
    //   927: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   930: getfield 312	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   933: getfield 322	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   936: new 38	java/util/ArrayList
    //   939: dup
    //   940: invokespecial 39	java/util/ArrayList:<init>	()V
    //   943: putfield 42	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   946: iconst_0
    //   947: istore_1
    //   948: aload 22
    //   950: astore_0
    //   951: iload_1
    //   952: aload 26
    //   954: invokevirtual 277	org/json/JSONArray:length	()I
    //   957: if_icmpge +193 -> 1150
    //   960: new 44	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo
    //   963: dup
    //   964: invokespecial 45	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:<init>	()V
    //   967: astore 22
    //   969: aload 26
    //   971: iload_1
    //   972: invokevirtual 281	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   975: astore 27
    //   977: aload 22
    //   979: aload 27
    //   981: aload_0
    //   982: invokevirtual 284	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   985: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   988: putfield 55	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mUin	Ljava/lang/Long;
    //   991: aload 22
    //   993: aload 27
    //   995: ldc_w 286
    //   998: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1001: putfield 78	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   1004: aload 22
    //   1006: aload 27
    //   1008: aload 21
    //   1010: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1013: putfield 289	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mBiuTime	I
    //   1016: aload 22
    //   1018: aload 27
    //   1020: ldc_w 291
    //   1023: iconst_1
    //   1024: invokevirtual 239	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1027: putfield 90	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mFeedsType	I
    //   1030: aload 22
    //   1032: aload 27
    //   1034: ldc_w 293
    //   1037: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1040: putfield 93	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOpType	I
    //   1043: aload 27
    //   1045: aload 19
    //   1047: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1050: astore 27
    //   1052: aload 27
    //   1054: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1057: ifne +23 -> 1080
    //   1060: aload 22
    //   1062: new 204	java/math/BigInteger
    //   1065: dup
    //   1066: aload 27
    //   1068: invokespecial 205	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   1071: invokevirtual 209	java/math/BigInteger:longValue	()J
    //   1074: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1077: putfield 99	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mFeedId	Ljava/lang/Long;
    //   1080: aload 22
    //   1082: new 191	java/lang/String
    //   1085: dup
    //   1086: aload 22
    //   1088: getfield 78	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   1091: iconst_0
    //   1092: invokestatic 197	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   1095: invokespecial 200	java/lang/String:<init>	([B)V
    //   1098: putfield 78	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   1101: aload 22
    //   1103: aload 22
    //   1105: getfield 78	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mOrigBiuComment	Ljava/lang/String;
    //   1108: putfield 296	com/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo:mBiuComment	Ljava/lang/String;
    //   1111: goto +10 -> 1121
    //   1114: astore 27
    //   1116: aload 27
    //   1118: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   1121: aload 23
    //   1123: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   1126: getfield 312	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   1129: getfield 322	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo	Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;
    //   1132: getfield 42	com/tencent/mobileqq/kandian/repo/handler/BiuInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1135: aload 22
    //   1137: invokeinterface 116 2 0
    //   1142: pop
    //   1143: iload_1
    //   1144: iconst_1
    //   1145: iadd
    //   1146: istore_1
    //   1147: goto -196 -> 951
    //   1150: aload 23
    //   1152: new 191	java/lang/String
    //   1155: dup
    //   1156: aload 25
    //   1158: iconst_0
    //   1159: invokestatic 197	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   1162: invokespecial 200	java/lang/String:<init>	([B)V
    //   1165: putfield 242	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   1168: aload 23
    //   1170: ldc_w 324
    //   1173: putfield 254	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSummary	Ljava/lang/String;
    //   1176: iload_2
    //   1177: iconst_3
    //   1178: if_icmpeq +118 -> 1296
    //   1181: iload_2
    //   1182: iconst_2
    //   1183: if_icmpne +311 -> 1494
    //   1186: goto +110 -> 1296
    //   1189: iload_2
    //   1190: iconst_1
    //   1191: if_icmpne +186 -> 1377
    //   1194: aload 23
    //   1196: ldc_w 324
    //   1199: putfield 248	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   1202: goto +175 -> 1377
    //   1205: aload 23
    //   1207: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   1210: getfield 312	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   1213: new 38	java/util/ArrayList
    //   1216: dup
    //   1217: invokespecial 39	java/util/ArrayList:<init>	()V
    //   1220: putfield 327	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:b	Ljava/util/ArrayList;
    //   1223: new 329	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo
    //   1226: dup
    //   1227: invokespecial 330	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo:<init>	()V
    //   1230: astore_0
    //   1231: aload 24
    //   1233: ldc_w 332
    //   1236: invokevirtual 302	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1239: astore 19
    //   1241: aload 19
    //   1243: ifnull +134 -> 1377
    //   1246: aload_0
    //   1247: aload 19
    //   1249: ldc_w 334
    //   1252: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1255: putfield 336	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo:d	Ljava/lang/String;
    //   1258: aload_0
    //   1259: aload 19
    //   1261: ldc_w 338
    //   1264: invokevirtual 232	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1267: i2l
    //   1268: putfield 340	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo:a	J
    //   1271: aload_0
    //   1272: aload 20
    //   1274: putfield 343	com/tencent/mobileqq/kandian/repo/video/entity/UGCVideoInfo:e	Ljava/lang/String;
    //   1277: aload 23
    //   1279: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   1282: getfield 312	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   1285: getfield 327	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:b	Ljava/util/ArrayList;
    //   1288: aload_0
    //   1289: invokevirtual 344	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1292: pop
    //   1293: goto +84 -> 1377
    //   1296: aload 23
    //   1298: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   1301: getfield 312	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   1304: new 38	java/util/ArrayList
    //   1307: dup
    //   1308: invokespecial 39	java/util/ArrayList:<init>	()V
    //   1311: putfield 346	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1314: new 348	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCPicInfo
    //   1317: dup
    //   1318: invokespecial 349	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCPicInfo:<init>	()V
    //   1321: astore_0
    //   1322: aload 24
    //   1324: ldc_w 351
    //   1327: invokevirtual 321	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1330: astore 19
    //   1332: aload 19
    //   1334: ifnull +43 -> 1377
    //   1337: aload 19
    //   1339: invokevirtual 277	org/json/JSONArray:length	()I
    //   1342: ifle +35 -> 1377
    //   1345: aload_0
    //   1346: aload 19
    //   1348: iconst_0
    //   1349: invokevirtual 281	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1352: ldc_w 353
    //   1355: invokevirtual 187	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1358: putfield 356	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCPicInfo:c	Ljava/lang/String;
    //   1361: aload 23
    //   1363: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   1366: getfield 312	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   1369: getfield 346	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1372: aload_0
    //   1373: invokevirtual 344	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1376: pop
    //   1377: aload 23
    //   1379: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   1382: getfield 312	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   1385: iload_2
    //   1386: putfield 358	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:jdField_a_of_type_Int	I
    //   1389: aload 23
    //   1391: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   1394: getfield 312	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo;
    //   1397: aload 23
    //   1399: getfield 242	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mTitle	Ljava/lang/String;
    //   1402: putfield 360	com/tencent/mobileqq/kandian/repo/feeds/entity/UGCFeedsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1405: aload 23
    //   1407: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   1410: ldc_w 324
    //   1413: putfield 361	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1416: aload 23
    //   1418: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   1421: ldc_w 324
    //   1424: putfield 362	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:c	Ljava/lang/String;
    //   1427: aload 23
    //   1429: getfield 24	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mSocialFeedInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo;
    //   1432: ldc_w 324
    //   1435: putfield 364	com/tencent/mobileqq/kandian/repo/feeds/entity/SocializeFeedsInfo:b	Ljava/lang/String;
    //   1438: aload 23
    //   1440: areturn
    //   1441: astore_0
    //   1442: goto +4 -> 1446
    //   1445: astore_0
    //   1446: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1449: ifeq +42 -> 1491
    //   1452: new 63	java/lang/StringBuilder
    //   1455: dup
    //   1456: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   1459: astore 19
    //   1461: aload 19
    //   1463: ldc_w 366
    //   1466: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: pop
    //   1470: aload 19
    //   1472: aload_0
    //   1473: invokevirtual 369	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1476: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: pop
    //   1480: ldc 104
    //   1482: iconst_2
    //   1483: aload 19
    //   1485: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1488: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1491: aload 23
    //   1493: areturn
    //   1494: iload_2
    //   1495: iconst_4
    //   1496: if_icmpeq -291 -> 1205
    //   1499: iload_2
    //   1500: iconst_5
    //   1501: if_icmpne -312 -> 1189
    //   1504: goto -299 -> 1205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1507	0	paramString	String
    //   398	749	1	i	int
    //   442	1060	2	j	int
    //   139	711	3	l1	long
    //   174	182	5	l2	long
    //   211	141	7	l3	long
    //   248	302	9	l4	long
    //   244	202	11	l5	long
    //   234	266	13	l6	long
    //   240	240	15	l7	long
    //   79	287	17	l8	long
    //   108	206	19	str1	String
    //   320	1	19	localException1	java.lang.Exception
    //   325	6	19	localException2	java.lang.Exception
    //   338	1146	19	localObject1	Object
    //   67	211	20	str2	String
    //   293	1	20	localException3	java.lang.Exception
    //   298	1	20	localException4	java.lang.Exception
    //   306	1	20	localException5	java.lang.Exception
    //   311	17	20	localException6	java.lang.Exception
    //   332	941	20	localObject2	Object
    //   76	933	21	localObject3	Object
    //   226	910	22	localObject4	Object
    //   7	1485	23	localBaseArticleInfo	BaseArticleInfo
    //   17	1306	24	localJSONObject	org.json.JSONObject
    //   512	645	25	localObject5	Object
    //   637	94	26	localObject6	Object
    //   778	3	26	localException7	java.lang.Exception
    //   900	70	26	localJSONArray	org.json.JSONArray
    //   975	92	27	localObject7	Object
    //   1114	3	27	localException8	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   219	228	293	java/lang/Exception
    //   250	272	293	java/lang/Exception
    //   182	213	298	java/lang/Exception
    //   145	176	306	java/lang/Exception
    //   110	140	311	java/lang/Exception
    //   95	110	320	java/lang/Exception
    //   81	95	325	java/lang/Exception
    //   708	744	778	java/lang/Exception
    //   744	775	778	java/lang/Exception
    //   1043	1080	1114	java/lang/Exception
    //   1080	1111	1114	java/lang/Exception
    //   399	416	1441	java/lang/Exception
    //   419	590	1441	java/lang/Exception
    //   613	708	1441	java/lang/Exception
    //   780	785	1441	java/lang/Exception
    //   785	804	1441	java/lang/Exception
    //   811	821	1441	java/lang/Exception
    //   857	902	1441	java/lang/Exception
    //   907	946	1441	java/lang/Exception
    //   951	1043	1441	java/lang/Exception
    //   1116	1121	1441	java/lang/Exception
    //   1121	1143	1441	java/lang/Exception
    //   1150	1176	1441	java/lang/Exception
    //   1194	1202	1441	java/lang/Exception
    //   1205	1241	1441	java/lang/Exception
    //   1246	1293	1441	java/lang/Exception
    //   1296	1332	1441	java/lang/Exception
    //   1337	1377	1441	java/lang/Exception
    //   1377	1405	1441	java/lang/Exception
    //   1405	1438	1441	java/lang/Exception
    //   9	60	1445	java/lang/Exception
    //   60	78	1445	java/lang/Exception
    //   346	351	1445	java/lang/Exception
    //   373	399	1445	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJCreateArticleInfoForBiu
 * JD-Core Version:    0.7.0.1
 */