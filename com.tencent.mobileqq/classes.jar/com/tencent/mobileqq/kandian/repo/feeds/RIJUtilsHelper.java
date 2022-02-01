package com.tencent.mobileqq.kandian.repo.feeds;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.IconWordingInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.WendaInfo;
import com.tencent.mobileqq.kandian.repo.pts.ProteusReportUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/RIJUtilsHelper;", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)V", "articleFeedsTypeToFeedsTypeMap", "", "", "itemTypeToFeedsTypeMap", "longContentCardTypeToFeedsTypeMap", "subscribeTypeToFeedsTypeMap", "getBigFeedsType", "article", "getBigVideoFeedsType", "getBiuAnswerAnswerCardFeedsType", "getFeedsTypeWithArticleFeedsType", "articleFeedsType", "defaultValue", "getFeedsTypeWithArticleInfo", "getFeedsTypeWithArticleInfoInternal", "getFeedsTypeWithItemType", "itemType", "getFeedsTypeWithLongContentCardType", "longContentCardType", "getFeedsTypeWithSubscribeType", "getGalleryFeedsType", "getGalleryTripleFeedsType", "getMultiFeedsType", "getReportType", "getSmallFeedsType", "getSmallVideoFeedsType", "getSocialAnswerCardFeedsType", "getTopicRecommendFeedsType", "getTopicRecommendUgcFeedsType", "getUgcSocialInnerAppCard", "getUgcSocialVideoFeedsType", "ArticleFeedsType", "FeedsType", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJUtilsHelper
{
  @JvmField
  @NotNull
  public AbsBaseArticleInfo a;
  private final Map<Integer, Integer> b;
  private final Map<Integer, Integer> c;
  private final Map<Integer, Integer> d;
  private final Map<Integer, Integer> e;
  
  public RIJUtilsHelper(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.a = paramAbsBaseArticleInfo;
    paramAbsBaseArticleInfo = Integer.valueOf(2);
    Pair localPair1 = TuplesKt.to(paramAbsBaseArticleInfo, Integer.valueOf(b(this.a)));
    Pair localPair2 = TuplesKt.to(Integer.valueOf(39), Integer.valueOf(b(this.a)));
    Pair localPair3 = TuplesKt.to(Integer.valueOf(116), Integer.valueOf(b(this.a)));
    Pair localPair4 = TuplesKt.to(Integer.valueOf(3), Integer.valueOf(c(this.a)));
    Pair localPair5 = TuplesKt.to(Integer.valueOf(105), Integer.valueOf(c(this.a)));
    Integer localInteger1 = Integer.valueOf(4);
    Pair localPair6 = TuplesKt.to(Integer.valueOf(106), Integer.valueOf(d(this.a)));
    Pair localPair7 = TuplesKt.to(Integer.valueOf(104), Integer.valueOf(d(this.a)));
    Pair localPair8 = TuplesKt.to(Integer.valueOf(1), Integer.valueOf(d(this.a)));
    Pair localPair9 = TuplesKt.to(Integer.valueOf(0), localInteger1);
    Pair localPair10 = TuplesKt.to(localInteger1, Integer.valueOf(e(this.a)));
    Pair localPair11 = TuplesKt.to(Integer.valueOf(6), Integer.valueOf(e(this.a)));
    Integer localInteger2 = Integer.valueOf(10);
    Pair localPair12 = TuplesKt.to(Integer.valueOf(126), Integer.valueOf(e(this.a)));
    Pair localPair13 = TuplesKt.to(Integer.valueOf(66), Integer.valueOf(e(this.a)));
    Pair localPair14 = TuplesKt.to(Integer.valueOf(115), Integer.valueOf(e(this.a)));
    Pair localPair15 = TuplesKt.to(Integer.valueOf(5), Integer.valueOf(f(this.a)));
    Pair localPair16 = TuplesKt.to(Integer.valueOf(9), Integer.valueOf(7));
    Pair localPair17 = TuplesKt.to(Integer.valueOf(8), Integer.valueOf(8));
    Pair localPair18 = TuplesKt.to(Integer.valueOf(7), Integer.valueOf(9));
    Pair localPair19 = TuplesKt.to(localInteger2, localInteger2);
    Pair localPair20 = TuplesKt.to(Integer.valueOf(12), localInteger2);
    Pair localPair21 = TuplesKt.to(Integer.valueOf(11), Integer.valueOf(11));
    Pair localPair22 = TuplesKt.to(Integer.valueOf(27), Integer.valueOf(19));
    Object localObject = Integer.valueOf(28);
    Pair localPair23 = TuplesKt.to(localObject, Integer.valueOf(20));
    Pair localPair24 = TuplesKt.to(Integer.valueOf(14), Integer.valueOf(18));
    Pair localPair25 = TuplesKt.to(Integer.valueOf(15), Integer.valueOf(101));
    Pair localPair26 = TuplesKt.to(Integer.valueOf(22), Integer.valueOf(22));
    Pair localPair27 = TuplesKt.to(Integer.valueOf(21), Integer.valueOf(21));
    Pair localPair28 = TuplesKt.to(Integer.valueOf(120), Integer.valueOf(2005));
    Pair localPair29 = TuplesKt.to(Integer.valueOf(23), Integer.valueOf(23));
    Pair localPair30 = TuplesKt.to(Integer.valueOf(71), Integer.valueOf(23));
    Integer localInteger3 = Integer.valueOf(29);
    Pair localPair31 = TuplesKt.to(Integer.valueOf(25), Integer.valueOf(30));
    Pair localPair32 = TuplesKt.to(Integer.valueOf(24), localInteger3);
    Pair localPair33 = TuplesKt.to(Integer.valueOf(26), Integer.valueOf(g(this.a)));
    Pair localPair34 = TuplesKt.to(Integer.valueOf(18), Integer.valueOf(24));
    Pair localPair35 = TuplesKt.to(Integer.valueOf(19), Integer.valueOf(26));
    Pair localPair36 = TuplesKt.to(Integer.valueOf(20), Integer.valueOf(32));
    Pair localPair37 = TuplesKt.to(localInteger3, Integer.valueOf(33));
    Pair localPair38 = TuplesKt.to(Integer.valueOf(30), Integer.valueOf(34));
    Pair localPair39 = TuplesKt.to(Integer.valueOf(16), Integer.valueOf(25));
    Pair localPair40 = TuplesKt.to(Integer.valueOf(17), Integer.valueOf(27));
    Pair localPair41 = TuplesKt.to(Integer.valueOf(31), localObject);
    Pair localPair42 = TuplesKt.to(Integer.valueOf(32), localObject);
    Pair localPair43 = TuplesKt.to(Integer.valueOf(83), localObject);
    Pair localPair44 = TuplesKt.to(Integer.valueOf(84), localObject);
    Pair localPair45 = TuplesKt.to(Integer.valueOf(85), localObject);
    localObject = TuplesKt.to(Integer.valueOf(86), localObject);
    Pair localPair46 = TuplesKt.to(Integer.valueOf(33), Integer.valueOf(35));
    Pair localPair47 = TuplesKt.to(Integer.valueOf(34), Integer.valueOf(36));
    Integer localInteger4 = Integer.valueOf(47);
    Pair localPair48 = TuplesKt.to(Integer.valueOf(35), Integer.valueOf(37));
    Pair localPair49 = TuplesKt.to(Integer.valueOf(36), Integer.valueOf(38));
    Pair localPair50 = TuplesKt.to(Integer.valueOf(37), Integer.valueOf(39));
    Pair localPair51 = TuplesKt.to(Integer.valueOf(38), Integer.valueOf(40));
    Pair localPair52 = TuplesKt.to(Integer.valueOf(40), Integer.valueOf(h(this.a)));
    Pair localPair53 = TuplesKt.to(Integer.valueOf(42), Integer.valueOf(h(this.a)));
    Pair localPair54 = TuplesKt.to(Integer.valueOf(41), Integer.valueOf(h(this.a)));
    Integer localInteger5 = Integer.valueOf(54);
    this.b = MapsKt.mapOf(new Pair[] { localPair1, localPair2, localPair3, localPair4, localPair5, localPair6, localPair7, localPair8, localPair9, localPair10, localPair11, localPair12, localPair13, localPair14, localPair15, localPair16, localPair17, localPair18, localPair19, localPair20, localPair21, localPair22, localPair23, localPair24, localPair25, localPair26, localPair27, localPair28, localPair29, localPair30, localPair31, localPair32, localPair33, localPair34, localPair35, localPair36, localPair37, localPair38, localPair39, localPair40, localPair41, localPair42, localPair43, localPair44, localPair45, localObject, localPair46, localPair47, localPair48, localPair49, localPair50, localPair51, localPair52, localPair53, localPair54, TuplesKt.to(Integer.valueOf(44), localInteger2), TuplesKt.to(Integer.valueOf(43), Integer.valueOf(19)), TuplesKt.to(Integer.valueOf(45), Integer.valueOf(37)), TuplesKt.to(Integer.valueOf(46), Integer.valueOf(43)), TuplesKt.to(localInteger5, Integer.valueOf(i(this.a))), TuplesKt.to(Integer.valueOf(55), Integer.valueOf(i(this.a))), TuplesKt.to(Integer.valueOf(56), Integer.valueOf(i(this.a))), TuplesKt.to(Integer.valueOf(57), localInteger3), TuplesKt.to(Integer.valueOf(58), Integer.valueOf(30)), TuplesKt.to(Integer.valueOf(59), Integer.valueOf(31)), TuplesKt.to(Integer.valueOf(53), localInteger4), TuplesKt.to(Integer.valueOf(50), localInteger4), TuplesKt.to(Integer.valueOf(51), localInteger4), TuplesKt.to(Integer.valueOf(52), localInteger4), TuplesKt.to(localInteger4, Integer.valueOf(j(this.a))), TuplesKt.to(Integer.valueOf(48), Integer.valueOf(j(this.a))), TuplesKt.to(Integer.valueOf(101), Integer.valueOf(1005)), TuplesKt.to(Integer.valueOf(102), Integer.valueOf(1006)), TuplesKt.to(Integer.valueOf(103), Integer.valueOf(1007)), TuplesKt.to(Integer.valueOf(60), Integer.valueOf(k(this.a))), TuplesKt.to(Integer.valueOf(64), Integer.valueOf(k(this.a))), TuplesKt.to(Integer.valueOf(96), Integer.valueOf(80)), TuplesKt.to(Integer.valueOf(61), Integer.valueOf(50)), TuplesKt.to(Integer.valueOf(65), Integer.valueOf(50)), TuplesKt.to(Integer.valueOf(49), Integer.valueOf(51)), TuplesKt.to(Integer.valueOf(62), Integer.valueOf(52)), TuplesKt.to(Integer.valueOf(63), Integer.valueOf(53)), TuplesKt.to(Integer.valueOf(68), localInteger5), TuplesKt.to(Integer.valueOf(69), localInteger5), TuplesKt.to(Integer.valueOf(67), localInteger5), TuplesKt.to(Integer.valueOf(72), Integer.valueOf(l(this.a))), TuplesKt.to(Integer.valueOf(73), Integer.valueOf(m(this.a))), TuplesKt.to(Integer.valueOf(74), Integer.valueOf(65)), TuplesKt.to(Integer.valueOf(75), Integer.valueOf(66)), TuplesKt.to(Integer.valueOf(82), Integer.valueOf(70)), TuplesKt.to(Integer.valueOf(87), Integer.valueOf(73)), TuplesKt.to(Integer.valueOf(88), Integer.valueOf(74)), TuplesKt.to(Integer.valueOf(90), Integer.valueOf(72)), TuplesKt.to(Integer.valueOf(91), Integer.valueOf(71)), TuplesKt.to(Integer.valueOf(80), Integer.valueOf(n(this.a))), TuplesKt.to(Integer.valueOf(81), Integer.valueOf(n(this.a))), TuplesKt.to(Integer.valueOf(89), Integer.valueOf(75)), TuplesKt.to(Integer.valueOf(92), Integer.valueOf(75)), TuplesKt.to(Integer.valueOf(93), Integer.valueOf(77)), TuplesKt.to(Integer.valueOf(107), Integer.valueOf(999)), TuplesKt.to(Integer.valueOf(108), Integer.valueOf(998)), TuplesKt.to(Integer.valueOf(109), Integer.valueOf(1023)), TuplesKt.to(Integer.valueOf(112), Integer.valueOf(1023)), TuplesKt.to(Integer.valueOf(110), Integer.valueOf(1024)), TuplesKt.to(Integer.valueOf(113), Integer.valueOf(1024)), TuplesKt.to(Integer.valueOf(111), Integer.valueOf(1025)), TuplesKt.to(Integer.valueOf(114), Integer.valueOf(1025)), TuplesKt.to(Integer.valueOf(118), Integer.valueOf(1028)), TuplesKt.to(Integer.valueOf(124), Integer.valueOf(1032)), TuplesKt.to(Integer.valueOf(125), Integer.valueOf(1033)), TuplesKt.to(Integer.valueOf(123), Integer.valueOf(1034)), TuplesKt.to(Integer.valueOf(128), Integer.valueOf(1035)), TuplesKt.to(Integer.valueOf(129), Integer.valueOf(2004)), TuplesKt.to(Integer.valueOf(137), Integer.valueOf(1043)), TuplesKt.to(Integer.valueOf(139), Integer.valueOf(1043)), TuplesKt.to(Integer.valueOf(138), Integer.valueOf(1043)) });
    this.c = MapsKt.mapOf(new Pair[] { TuplesKt.to(paramAbsBaseArticleInfo, Integer.valueOf(12)), TuplesKt.to(Integer.valueOf(3), Integer.valueOf(13)), TuplesKt.to(Integer.valueOf(1), Integer.valueOf(14)), TuplesKt.to(Integer.valueOf(0), Integer.valueOf(15)), TuplesKt.to(localInteger1, Integer.valueOf(16)), TuplesKt.to(Integer.valueOf(8), Integer.valueOf(17)), TuplesKt.to(Integer.valueOf(7), Integer.valueOf(17)) });
    this.d = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(1), Integer.valueOf(1038)), TuplesKt.to(Integer.valueOf(3), Integer.valueOf(1040)), TuplesKt.to(localInteger1, Integer.valueOf(1041)), TuplesKt.to(paramAbsBaseArticleInfo, Integer.valueOf(1039)), TuplesKt.to(Integer.valueOf(19191924), Integer.valueOf(1042)) });
    this.e = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(33), Integer.valueOf(1031)), TuplesKt.to(localInteger3, Integer.valueOf(o(this.a))), TuplesKt.to(Integer.valueOf(58), Integer.valueOf(1056)) });
  }
  
  private final int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJFeedsType.J(paramAbsBaseArticleInfo)) {
      return 67;
    }
    if (RIJFeedsType.M(paramAbsBaseArticleInfo)) {
      return 82;
    }
    if (RIJFeedsType.L(paramAbsBaseArticleInfo)) {
      return 83;
    }
    return 68;
  }
  
  private final int b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return 55;
    }
    return 1;
  }
  
  private final int c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return 57;
    }
    return 2;
  }
  
  private final int d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return 58;
    }
    return 3;
  }
  
  private final int e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return 56;
    }
    return 5;
  }
  
  private final int f(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return 59;
    }
    return 6;
  }
  
  private final int g(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJFeedsType.ac(paramAbsBaseArticleInfo) == 32) {
      return 2006;
    }
    return 31;
  }
  
  private final int h(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJFeedsType.p(paramAbsBaseArticleInfo)) {
      return 41;
    }
    return 42;
  }
  
  private final int i(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJFeedsType.s(paramAbsBaseArticleInfo)) {
      return 45;
    }
    return 46;
  }
  
  private final int j(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.mArticleSubscriptText)) {
      return 79;
    }
    return 48;
  }
  
  private final int k(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.mArticleSubscriptText)) {
      return 78;
    }
    return 49;
  }
  
  private final int l(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.x != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.x.a)) {
      return 62;
    }
    return 61;
  }
  
  private final int m(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.x != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.x.a)) {
      return 64;
    }
    return 63;
  }
  
  private final int n(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.z != null)) {
      return paramAbsBaseArticleInfo.mSocialFeedInfo.z.a;
    }
    return 0;
  }
  
  private final int o(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.mProteusTemplateBean != null) {
      return ProteusReportUtil.b(paramAbsBaseArticleInfo.mProteusTemplateBean);
    }
    return 0;
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.b.get(Integer.valueOf(paramInt1));
    if ((localInteger != null) && (localInteger.intValue() == 0)) {
      return paramInt2;
    }
    if (localInteger != null) {
      paramInt2 = localInteger.intValue();
    }
    return paramInt2;
  }
  
  public final int a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "article");
    if (RIJFeedsType.l(paramAbsBaseArticleInfo)) {
      return a(paramAbsBaseArticleInfo);
    }
    if (RIJFeedsType.I(paramAbsBaseArticleInfo)) {
      return 54;
    }
    if (RIJFeedsType.F(paramAbsBaseArticleInfo)) {
      paramInt = 47;
    }
    return paramInt;
  }
  
  public final int b(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.c.get(Integer.valueOf(paramInt1));
    if ((localInteger != null) && (localInteger.intValue() == 0)) {
      return paramInt2;
    }
    if (localInteger != null) {
      paramInt2 = localInteger.intValue();
    }
    return paramInt2;
  }
  
  public final int c(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.d.get(Integer.valueOf(paramInt1));
    if ((localInteger != null) && (localInteger.intValue() == 0)) {
      return paramInt2;
    }
    if (localInteger != null) {
      paramInt2 = localInteger.intValue();
    }
    return paramInt2;
  }
  
  public final int d(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.e.get(Integer.valueOf(paramInt1));
    if ((localInteger != null) && (localInteger.intValue() == 0)) {
      return paramInt2;
    }
    if (localInteger != null) {
      paramInt2 = localInteger.intValue();
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJUtilsHelper
 * JD-Core Version:    0.7.0.1
 */