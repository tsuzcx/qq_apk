package com.tencent.mobileqq.kandian.biz.reward;

import com.tencent.mobileqq.kandian.biz.reward.utils.RIJRewardTaskPrefHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask$Transaction;", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask$ITransaction;", "task", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask;", "(Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask;)V", "recordTimeInMs", "", "Ljava/lang/Integer;", "commit", "", "key", "", "updateRecordTimeInMs", "timeInMs", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTask$Transaction
  implements RIJRewardTask.ITransaction
{
  private final RIJRewardTask jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTask;
  private Integer jdField_a_of_type_JavaLangInteger;
  
  public RIJRewardTask$Transaction(@NotNull RIJRewardTask paramRIJRewardTask)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTask = paramRIJRewardTask;
  }
  
  @NotNull
  public RIJRewardTask.ITransaction a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTask.a(paramInt);
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return (RIJRewardTask.ITransaction)this;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    RIJRewardTaskPrefHelper.a(paramString, this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask.Transaction
 * JD-Core Version:    0.7.0.1
 */