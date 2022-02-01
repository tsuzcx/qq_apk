import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask$Transaction;", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask$ITransaction;", "task", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;", "(Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;)V", "recordTimeInMs", "", "Ljava/lang/Integer;", "commit", "", "key", "", "updateRecordTimeInMs", "timeInMs", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rju
  implements rjt
{
  private final RIJRewardTask jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTask;
  private Integer jdField_a_of_type_JavaLangInteger;
  
  public rju(@NotNull RIJRewardTask paramRIJRewardTask)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTask = paramRIJRewardTask;
  }
  
  @NotNull
  public rjt a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTask.a(paramInt);
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return (rjt)this;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    rlr.a(paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rju
 * JD-Core Version:    0.7.0.1
 */