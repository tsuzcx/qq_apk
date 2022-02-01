package com.tencent.mobileqq.kandian.biz.fastweb;

import java.util.ArrayList;
import java.util.List;

class FastWebActivity$RecommendAndAdCallback$1
  implements Runnable
{
  FastWebActivity$RecommendAndAdCallback$1(FastWebActivity.RecommendAndAdCallback paramRecommendAndAdCallback, List paramList1, List paramList2, FastWebActivity paramFastWebActivity, boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    List localList = this.jdField_b_of_type_JavaUtilList;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = localList;
    if (localList == null) {
      localObject2 = new ArrayList();
    }
    FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, (List)localObject1, (List)localObject2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.RecommendAndAdCallback.1
 * JD-Core Version:    0.7.0.1
 */