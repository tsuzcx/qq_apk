package com.tencent.mobileqq.utils.abtest;

import com.tencent.mtt.abtestsdk.ABTestApi;
import com.tencent.mtt.abtestsdk.listener.ExpInitListener;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class ABTestController$1
  implements ExpInitListener
{
  ABTestController$1(ABTestController paramABTestController, String paramString) {}
  
  public void expInitFailed()
  {
    ABTestUtil.a("ABTestController", "ExpInitListener#expInitFailed");
    ABTestController.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAbtestABTestController).set(false);
  }
  
  public void expInitSuccess()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExpInitListener#expInitSuccess. cacheSize:");
    ((StringBuilder)localObject).append(ABTestController.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAbtestABTestController).size());
    ABTestUtil.a("ABTestController", ((StringBuilder)localObject).toString());
    ABTestController.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAbtestABTestController).set(true);
    if (ABTestController.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAbtestABTestController).isEmpty()) {
      return;
    }
    localObject = ABTestController.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAbtestABTestController);
    ABTestController.b(this.jdField_a_of_type_ComTencentMobileqqUtilsAbtestABTestController).set(true);
    ABTestApi.switchAccountId(this.jdField_a_of_type_JavaLangString, (GetExperimentListener)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ABTestController.1
 * JD-Core Version:    0.7.0.1
 */