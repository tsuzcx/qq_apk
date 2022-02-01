package com.tencent.mobileqq.kandian.glue.baseconfig;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.repo.account.RIJUserInfoUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/baseconfig/RIJUserInfoAladdinConfig;", "", "()V", "expiredTimeSecond", "", "getExpiredTimeSecond", "init", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJUserInfoAladdinConfig
{
  private static long a;
  public static final RIJUserInfoAladdinConfig a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianGlueBaseconfigRIJUserInfoAladdinConfig = new RIJUserInfoAladdinConfig();
    jdField_a_of_type_Long = 9223372036854775807L;
  }
  
  public final long a()
  {
    return jdField_a_of_type_Long;
  }
  
  public final void a()
  {
    Object localObject = Aladdin.getConfig(396);
    boolean bool = false;
    int i;
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("realtimeSwitch", 0);
    } else {
      i = 0;
    }
    if (i == 1) {
      bool = true;
    }
    long l = 9223372036854775807L;
    if (localObject != null) {
      l = ((AladdinConfig)localObject).getLongFromString("expiredTime", 9223372036854775807L);
    }
    jdField_a_of_type_Long = l;
    RIJUserInfoUtil.a.a(bool, jdField_a_of_type_Long);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[init] realtimeSwitch = ");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(", expiredTimeSecond = ");
    ((StringBuilder)localObject).append(jdField_a_of_type_Long);
    QLog.i("RIJUserInfoUtil", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.baseconfig.RIJUserInfoAladdinConfig
 * JD-Core Version:    0.7.0.1
 */