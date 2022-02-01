package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import java.util.List;

class FastWebActivity$30
  implements Runnable
{
  FastWebActivity$30(FastWebActivity paramFastWebActivity, BaseData paramBaseData) {}
  
  public void run()
  {
    int j = FastWebActivity.a(this.this$0).size();
    int i = 0;
    while (i < j)
    {
      BaseData localBaseData = (BaseData)FastWebActivity.a(this.this$0).get(i);
      if (((localBaseData.u == 10) || (localBaseData.u == 17) || (localBaseData.u == 22) || (localBaseData.u == 9)) && (localBaseData == this.a))
      {
        FastWebActivity.a(this.this$0).remove(i);
        break label107;
      }
      i += 1;
    }
    i = -1;
    label107:
    if (i >= 0) {
      FastWebActivity.a(this.this$0).a(i, j);
    }
    FastWebActivity.e(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.30
 * JD-Core Version:    0.7.0.1
 */