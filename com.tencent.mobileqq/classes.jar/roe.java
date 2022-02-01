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
public abstract class roe
{
  private static final Map<Integer, roe> jdField_a_of_type_JavaUtilMap = (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to(Integer.valueOf(1), new rog()), TuplesKt.to(Integer.valueOf(3), new rok()), TuplesKt.to(Integer.valueOf(4), new roi()), TuplesKt.to(Integer.valueOf(2), new roj()), TuplesKt.to(Integer.valueOf(5), new roh()) });
  public static final rof a;
  @NotNull
  protected BaseArticleInfo a;
  @Nullable
  private SocializeFeedsInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
  @Nullable
  private rre jdField_a_of_type_Rre;
  @Nullable
  private rrl jdField_a_of_type_Rrl;
  
  static
  {
    jdField_a_of_type_Rof = new rof(null);
  }
  
  @JvmStatic
  @Nullable
  public static final roe a(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    return jdField_a_of_type_Rof.a(paramBaseArticleInfo);
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
  protected final rre a()
  {
    return this.jdField_a_of_type_Rre;
  }
  
  @Nullable
  protected final rrl a()
  {
    return this.jdField_a_of_type_Rrl;
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
    for (paramBaseArticleInfo = paramBaseArticleInfo.jdField_a_of_type_Rre; paramBaseArticleInfo == null; paramBaseArticleInfo = null) {
      return;
    }
    paramBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
    if (paramBaseArticleInfo != null) {}
    for (paramBaseArticleInfo = paramBaseArticleInfo.jdField_a_of_type_Rre;; paramBaseArticleInfo = null)
    {
      this.jdField_a_of_type_Rre = paramBaseArticleInfo;
      SocializeFeedsInfo localSocializeFeedsInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo;
      paramBaseArticleInfo = localObject;
      if (localSocializeFeedsInfo != null) {
        paramBaseArticleInfo = localSocializeFeedsInfo.jdField_a_of_type_Rrl;
      }
      this.jdField_a_of_type_Rrl = paramBaseArticleInfo;
      a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     roe
 * JD-Core Version:    0.7.0.1
 */