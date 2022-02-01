package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import java.util.concurrent.CopyOnWriteArrayList;

class FastWebActivity$30
  implements Runnable
{
  FastWebActivity$30(FastWebActivity paramFastWebActivity, BaseData paramBaseData) {}
  
  public void run()
  {
    int j = FastWebActivity.m(this.this$0).size();
    int i = 0;
    while (i < j)
    {
      BaseData localBaseData = (BaseData)FastWebActivity.m(this.this$0).get(i);
      if (((localBaseData.aP == 10) || (localBaseData.aP == 17) || (localBaseData.aP == 22) || (localBaseData.aP == 9)) && (localBaseData == this.a))
      {
        FastWebActivity.m(this.this$0).remove(i);
        break label101;
      }
      i += 1;
    }
    i = -1;
    label101:
    if (i >= 0) {
      FastWebActivity.v(this.this$0).a(i, j);
    }
    FastWebActivity.n(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.30
 * JD-Core Version:    0.7.0.1
 */