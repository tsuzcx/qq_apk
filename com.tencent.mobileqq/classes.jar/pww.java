import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertModule$ReqParams;", "", "()V", "channelId", "", "getChannelId", "()J", "setChannelId", "(J)V", "followPuin", "", "getFollowPuin", "()Ljava/lang/String;", "setFollowPuin", "(Ljava/lang/String;)V", "lastClickArticleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "getLastClickArticleInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "setLastClickArticleInfo", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V", "reqRecommendFlag", "", "getReqRecommendFlag", "()I", "setReqRecommendFlag", "(I)V", "updateTimes", "getUpdateTimes", "setUpdateTimes", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pww
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  @Nullable
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  private int b = 1;
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final BaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final void a(@Nullable BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("channelId = ").append(this.jdField_a_of_type_Long).append(", followPuin = ").append(this.jdField_a_of_type_JavaLangString).append(", updateTimes = ").append(this.jdField_a_of_type_Int).append(", reqRecommendFlag = ").append(this.b).append(", lastClickArticleInfo = ");
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if (localObject != null) {}
    for (localObject = pwx.a.a((BaseArticleInfo)localObject);; localObject = null) {
      return (String)localObject + ' ';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pww
 * JD-Core Version:    0.7.0.1
 */