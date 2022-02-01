package com.tencent.mobileqq.kandian.biz.fastweb;

import java.util.ArrayList;
import java.util.List;

class FastWebActivity$RecommendAndAdCallback$1
  implements Runnable
{
  FastWebActivity$RecommendAndAdCallback$1(FastWebActivity.RecommendAndAdCallback paramRecommendAndAdCallback, List paramList1, List paramList2, FastWebActivity paramFastWebActivity, boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    Object localObject2 = this.a;
    List localList = this.b;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = localList;
    if (localList == null) {
      localObject2 = new ArrayList();
    }
    FastWebActivity.a(this.c, this.d, this.e, (List)localObject1, (List)localObject2, this.f, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.RecommendAndAdCallback.1
 * JD-Core Version:    0.7.0.1
 */