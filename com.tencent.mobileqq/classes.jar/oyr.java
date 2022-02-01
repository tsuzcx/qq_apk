import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJUtilsHelper;", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V", "articleFeedsTypeToFeedsTypeMap", "", "", "itemTypeToFeedsTypeMap", "longContentCardTypeToFeedsTypeMap", "subscribeTypeToFeedsTypeMap", "getBigFeedsType", "article", "getBigVideoFeedsType", "getBiuAnswerAnswerCardFeedsType", "getFeedsTypeWithArticleFeedsType", "articleFeedsType", "defaultValue", "getFeedsTypeWithArticleInfo", "getFeedsTypeWithArticleInfoInternal", "getFeedsTypeWithItemType", "itemType", "getFeedsTypeWithLongContentCardType", "longContentCardType", "getFeedsTypeWithSubscribeType", "getGalleryFeedsType", "getGalleryTripleFeedsType", "getMultiFeedsType", "getReportType", "getSmallFeedsType", "getSmallVideoFeedsType", "getSocialAnswerCardFeedsType", "getTopicRecommendFeedsType", "getTopicRecommendUgcFeedsType", "getUgcSocialInnerAppCard", "getUgcSocialVideoFeedsType", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oyr
{
  @JvmField
  @NotNull
  public BaseArticleInfo a;
  private final Map<Integer, Integer> a;
  private final Map<Integer, Integer> b;
  private final Map<Integer, Integer> c;
  private final Map<Integer, Integer> d;
  
  public oyr(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_JavaUtilMap = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(2), Integer.valueOf(b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(39), Integer.valueOf(b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(116), Integer.valueOf(b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(117), Integer.valueOf(b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(3), Integer.valueOf(c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(105), Integer.valueOf(c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(106), Integer.valueOf(d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(104), Integer.valueOf(d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(1), Integer.valueOf(d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(0), Integer.valueOf(4)), TuplesKt.to(Integer.valueOf(4), Integer.valueOf(e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(6), Integer.valueOf(e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(126), Integer.valueOf(e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(66), Integer.valueOf(e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(115), Integer.valueOf(e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(5), Integer.valueOf(f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(9), Integer.valueOf(7)), TuplesKt.to(Integer.valueOf(8), Integer.valueOf(8)), TuplesKt.to(Integer.valueOf(7), Integer.valueOf(9)), TuplesKt.to(Integer.valueOf(10), Integer.valueOf(10)), TuplesKt.to(Integer.valueOf(12), Integer.valueOf(10)), TuplesKt.to(Integer.valueOf(11), Integer.valueOf(11)), TuplesKt.to(Integer.valueOf(27), Integer.valueOf(19)), TuplesKt.to(Integer.valueOf(28), Integer.valueOf(20)), TuplesKt.to(Integer.valueOf(14), Integer.valueOf(18)), TuplesKt.to(Integer.valueOf(15), Integer.valueOf(101)), TuplesKt.to(Integer.valueOf(22), Integer.valueOf(22)), TuplesKt.to(Integer.valueOf(21), Integer.valueOf(21)), TuplesKt.to(Integer.valueOf(120), Integer.valueOf(2005)), TuplesKt.to(Integer.valueOf(23), Integer.valueOf(23)), TuplesKt.to(Integer.valueOf(71), Integer.valueOf(23)), TuplesKt.to(Integer.valueOf(25), Integer.valueOf(30)), TuplesKt.to(Integer.valueOf(24), Integer.valueOf(29)), TuplesKt.to(Integer.valueOf(26), Integer.valueOf(g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(18), Integer.valueOf(24)), TuplesKt.to(Integer.valueOf(19), Integer.valueOf(26)), TuplesKt.to(Integer.valueOf(20), Integer.valueOf(32)), TuplesKt.to(Integer.valueOf(29), Integer.valueOf(33)), TuplesKt.to(Integer.valueOf(30), Integer.valueOf(34)), TuplesKt.to(Integer.valueOf(16), Integer.valueOf(25)), TuplesKt.to(Integer.valueOf(17), Integer.valueOf(27)), TuplesKt.to(Integer.valueOf(31), Integer.valueOf(28)), TuplesKt.to(Integer.valueOf(32), Integer.valueOf(28)), TuplesKt.to(Integer.valueOf(83), Integer.valueOf(28)), TuplesKt.to(Integer.valueOf(84), Integer.valueOf(28)), TuplesKt.to(Integer.valueOf(85), Integer.valueOf(28)), TuplesKt.to(Integer.valueOf(86), Integer.valueOf(28)), TuplesKt.to(Integer.valueOf(33), Integer.valueOf(35)), TuplesKt.to(Integer.valueOf(34), Integer.valueOf(36)), TuplesKt.to(Integer.valueOf(35), Integer.valueOf(37)), TuplesKt.to(Integer.valueOf(36), Integer.valueOf(38)), TuplesKt.to(Integer.valueOf(37), Integer.valueOf(39)), TuplesKt.to(Integer.valueOf(38), Integer.valueOf(40)), TuplesKt.to(Integer.valueOf(40), Integer.valueOf(h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(42), Integer.valueOf(h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(41), Integer.valueOf(h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(44), Integer.valueOf(10)), TuplesKt.to(Integer.valueOf(43), Integer.valueOf(19)), TuplesKt.to(Integer.valueOf(45), Integer.valueOf(37)), TuplesKt.to(Integer.valueOf(46), Integer.valueOf(43)), TuplesKt.to(Integer.valueOf(54), Integer.valueOf(i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(55), Integer.valueOf(i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(56), Integer.valueOf(i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(57), Integer.valueOf(29)), TuplesKt.to(Integer.valueOf(58), Integer.valueOf(30)), TuplesKt.to(Integer.valueOf(59), Integer.valueOf(31)), TuplesKt.to(Integer.valueOf(53), Integer.valueOf(47)), TuplesKt.to(Integer.valueOf(50), Integer.valueOf(47)), TuplesKt.to(Integer.valueOf(51), Integer.valueOf(47)), TuplesKt.to(Integer.valueOf(52), Integer.valueOf(47)), TuplesKt.to(Integer.valueOf(47), Integer.valueOf(j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(48), Integer.valueOf(j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(101), Integer.valueOf(1005)), TuplesKt.to(Integer.valueOf(102), Integer.valueOf(1006)), TuplesKt.to(Integer.valueOf(103), Integer.valueOf(1007)), TuplesKt.to(Integer.valueOf(60), Integer.valueOf(k(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(64), Integer.valueOf(k(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(96), Integer.valueOf(80)), TuplesKt.to(Integer.valueOf(61), Integer.valueOf(50)), TuplesKt.to(Integer.valueOf(65), Integer.valueOf(50)), TuplesKt.to(Integer.valueOf(49), Integer.valueOf(51)), TuplesKt.to(Integer.valueOf(62), Integer.valueOf(52)), TuplesKt.to(Integer.valueOf(63), Integer.valueOf(53)), TuplesKt.to(Integer.valueOf(68), Integer.valueOf(54)), TuplesKt.to(Integer.valueOf(69), Integer.valueOf(54)), TuplesKt.to(Integer.valueOf(67), Integer.valueOf(54)), TuplesKt.to(Integer.valueOf(72), Integer.valueOf(l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(73), Integer.valueOf(m(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(74), Integer.valueOf(65)), TuplesKt.to(Integer.valueOf(75), Integer.valueOf(66)), TuplesKt.to(Integer.valueOf(82), Integer.valueOf(70)), TuplesKt.to(Integer.valueOf(87), Integer.valueOf(73)), TuplesKt.to(Integer.valueOf(88), Integer.valueOf(74)), TuplesKt.to(Integer.valueOf(90), Integer.valueOf(72)), TuplesKt.to(Integer.valueOf(91), Integer.valueOf(71)), TuplesKt.to(Integer.valueOf(80), Integer.valueOf(n(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(81), Integer.valueOf(n(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))), TuplesKt.to(Integer.valueOf(89), Integer.valueOf(75)), TuplesKt.to(Integer.valueOf(92), Integer.valueOf(75)), TuplesKt.to(Integer.valueOf(93), Integer.valueOf(77)), TuplesKt.to(Integer.valueOf(107), Integer.valueOf(999)), TuplesKt.to(Integer.valueOf(108), Integer.valueOf(998)), TuplesKt.to(Integer.valueOf(109), Integer.valueOf(1023)), TuplesKt.to(Integer.valueOf(112), Integer.valueOf(1023)), TuplesKt.to(Integer.valueOf(110), Integer.valueOf(1024)), TuplesKt.to(Integer.valueOf(113), Integer.valueOf(1024)), TuplesKt.to(Integer.valueOf(111), Integer.valueOf(1025)), TuplesKt.to(Integer.valueOf(114), Integer.valueOf(1025)), TuplesKt.to(Integer.valueOf(118), Integer.valueOf(1028)), TuplesKt.to(Integer.valueOf(124), Integer.valueOf(1032)), TuplesKt.to(Integer.valueOf(125), Integer.valueOf(1033)), TuplesKt.to(Integer.valueOf(123), Integer.valueOf(1034)), TuplesKt.to(Integer.valueOf(128), Integer.valueOf(1035)), TuplesKt.to(Integer.valueOf(129), Integer.valueOf(2004)), TuplesKt.to(Integer.valueOf(137), Integer.valueOf(1043)), TuplesKt.to(Integer.valueOf(139), Integer.valueOf(1043)), TuplesKt.to(Integer.valueOf(138), Integer.valueOf(1043)) });
    this.b = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(2), Integer.valueOf(12)), TuplesKt.to(Integer.valueOf(3), Integer.valueOf(13)), TuplesKt.to(Integer.valueOf(1), Integer.valueOf(14)), TuplesKt.to(Integer.valueOf(0), Integer.valueOf(15)), TuplesKt.to(Integer.valueOf(4), Integer.valueOf(16)), TuplesKt.to(Integer.valueOf(8), Integer.valueOf(17)), TuplesKt.to(Integer.valueOf(7), Integer.valueOf(17)) });
    this.c = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(1), Integer.valueOf(1038)), TuplesKt.to(Integer.valueOf(3), Integer.valueOf(1040)), TuplesKt.to(Integer.valueOf(4), Integer.valueOf(1041)), TuplesKt.to(Integer.valueOf(2), Integer.valueOf(1039)), TuplesKt.to(Integer.valueOf(19191924), Integer.valueOf(1042)) });
    this.d = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(33), Integer.valueOf(1031)), TuplesKt.to(Integer.valueOf(29), Integer.valueOf(o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))) });
  }
  
  private final int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (ozs.m(paramBaseArticleInfo)) {
      return 67;
    }
    if (ozs.p(paramBaseArticleInfo)) {
      return 82;
    }
    if (ozs.o(paramBaseArticleInfo)) {
      return 83;
    }
    return 68;
  }
  
  private final int b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return 55;
    }
    return 1;
  }
  
  private final int c(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return 57;
    }
    return 2;
  }
  
  private final int d(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return 58;
    }
    return 3;
  }
  
  private final int e(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return 56;
    }
    return 5;
  }
  
  private final int f(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo instanceof AdvertisementInfo)) {
      return 59;
    }
    return 6;
  }
  
  private final int g(BaseArticleInfo paramBaseArticleInfo)
  {
    if (pab.a(paramBaseArticleInfo) == 32) {
      return 2006;
    }
    return 31;
  }
  
  private final int h(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo");
    }
    if (ozs.b((ArticleInfo)paramBaseArticleInfo)) {
      return 41;
    }
    return 42;
  }
  
  private final int i(BaseArticleInfo paramBaseArticleInfo)
  {
    if (ozs.e((ArticleInfo)paramBaseArticleInfo)) {
      return 45;
    }
    return 46;
  }
  
  private final int j(BaseArticleInfo paramBaseArticleInfo)
  {
    if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!TextUtils.isEmpty((CharSequence)paramBaseArticleInfo.mArticleSubscriptText))) {
      return 79;
    }
    return 48;
  }
  
  private final int k(BaseArticleInfo paramBaseArticleInfo)
  {
    if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!TextUtils.isEmpty((CharSequence)paramBaseArticleInfo.mArticleSubscriptText))) {
      return 78;
    }
    return 49;
  }
  
  private final int l(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyp != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyp.a)) {
      return 62;
    }
    return 61;
  }
  
  private final int m(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyp != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyp.a)) {
      return 64;
    }
    return 63;
  }
  
  private final int n(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxw != null)) {
      return paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxw.a;
    }
    return 0;
  }
  
  private final int o(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mProteusTemplateBean != null) {
      return qai.a(paramBaseArticleInfo.mProteusTemplateBean);
    }
    return 0;
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if (localInteger == null) {}
    while (localInteger.intValue() != 0)
    {
      if (localInteger != null) {
        paramInt2 = localInteger.intValue();
      }
      return paramInt2;
    }
    return paramInt2;
  }
  
  public final int a(@NotNull BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "article");
    if (ozs.s(paramBaseArticleInfo)) {
      paramInt = a(paramBaseArticleInfo);
    }
    do
    {
      return paramInt;
      if (ozs.l(paramBaseArticleInfo)) {
        return 54;
      }
    } while (!ozs.i(paramBaseArticleInfo));
    return 47;
  }
  
  public final int b(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.b.get(Integer.valueOf(paramInt1));
    if (localInteger == null) {}
    while (localInteger.intValue() != 0)
    {
      if (localInteger != null) {
        paramInt2 = localInteger.intValue();
      }
      return paramInt2;
    }
    return paramInt2;
  }
  
  public final int c(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.c.get(Integer.valueOf(paramInt1));
    if (localInteger == null) {}
    while (localInteger.intValue() != 0)
    {
      if (localInteger != null) {
        paramInt2 = localInteger.intValue();
      }
      return paramInt2;
    }
    return paramInt2;
  }
  
  public final int d(int paramInt1, int paramInt2)
  {
    Integer localInteger = (Integer)this.d.get(Integer.valueOf(paramInt1));
    if (localInteger == null) {}
    while (localInteger.intValue() != 0)
    {
      if (localInteger != null) {
        paramInt2 = localInteger.intValue();
      }
      return paramInt2;
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyr
 * JD-Core Version:    0.7.0.1
 */