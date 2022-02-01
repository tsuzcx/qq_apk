import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdater;", "", "()V", "feedsInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;", "getFeedsInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;", "setFeedsInfo", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;)V", "info", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "getInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "setInfo", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V", "longContentInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$LongContentInfo;", "getLongContentInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$LongContentInfo;", "setLongContentInfo", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$LongContentInfo;)V", "pgcFeedsInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCFeedsInfo;", "getPgcFeedsInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCFeedsInfo;", "setPgcFeedsInfo", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$PGCFeedsInfo;)V", "process", "", "update", "articleInfo", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class qva
{
  private static final Map<Integer, qva> jdField_a_of_type_JavaUtilMap = (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to(Integer.valueOf(1), new qvc()), TuplesKt.to(Integer.valueOf(3), new qvg()), TuplesKt.to(Integer.valueOf(4), new qve()), TuplesKt.to(Integer.valueOf(2), new qvf()), TuplesKt.to(Integer.valueOf(5), new qvd()) });
  public static final qvb a;
  @NotNull
  protected BaseArticleInfo a;
  @Nullable
  private SocializeFeedsInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
  @Nullable
  private qxz jdField_a_of_type_Qxz;
  @Nullable
  private qyg jdField_a_of_type_Qyg;
  
  static
  {
    jdField_a_of_type_Qvb = new qvb(null);
  }
  
  @JvmStatic
  @Nullable
  public static final qva a(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    return jdField_a_of_type_Qvb.a(paramBaseArticleInfo);
  }
  
  @NotNull
  protected final BaseArticleInfo a()
  {
    BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if (localBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("info");
    }
    return localBaseArticleInfo;
  }
  
  @Nullable
  protected final SocializeFeedsInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
  }
  
  @Nullable
  protected final qxz a()
  {
    return this.jdField_a_of_type_Qxz;
  }
  
  @Nullable
  protected final qyg a()
  {
    return this.jdField_a_of_type_Qyg;
  }
  
  protected abstract void a();
  
  public final void a(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = null;
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if (paramBaseArticleInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("info");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
    paramBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
    if (paramBaseArticleInfo != null) {}
    for (paramBaseArticleInfo = paramBaseArticleInfo.jdField_a_of_type_Qxz; paramBaseArticleInfo == null; paramBaseArticleInfo = null) {
      return;
    }
    paramBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
    if (paramBaseArticleInfo != null) {}
    for (paramBaseArticleInfo = paramBaseArticleInfo.jdField_a_of_type_Qxz;; paramBaseArticleInfo = null)
    {
      this.jdField_a_of_type_Qxz = paramBaseArticleInfo;
      SocializeFeedsInfo localSocializeFeedsInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
      paramBaseArticleInfo = localObject;
      if (localSocializeFeedsInfo != null) {
        paramBaseArticleInfo = localSocializeFeedsInfo.jdField_a_of_type_Qyg;
      }
      this.jdField_a_of_type_Qyg = paramBaseArticleInfo;
      a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qva
 * JD-Core Version:    0.7.0.1
 */