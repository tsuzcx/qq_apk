package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.detail.web.RecommendAndAdCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import java.lang.ref.WeakReference;
import java.util.List;

class FastWebActivity$RecommendAndAdCallback
  implements RecommendAndAdCallback
{
  private WeakReference<FastWebActivity> a;
  
  public FastWebActivity$RecommendAndAdCallback(FastWebActivity paramFastWebActivity)
  {
    this.a = new WeakReference(paramFastWebActivity);
  }
  
  public void a(boolean paramBoolean1, String paramString, List<BaseData> paramList1, List<BaseData> paramList2, int paramInt, boolean paramBoolean2)
  {
    FastWebActivity localFastWebActivity = (FastWebActivity)this.a.get();
    if (localFastWebActivity == null) {
      return;
    }
    localFastWebActivity.runOnUiThread(new FastWebActivity.RecommendAndAdCallback.1(this, paramList1, paramList2, localFastWebActivity, paramBoolean1, paramString, paramInt, paramBoolean2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.RecommendAndAdCallback
 * JD-Core Version:    0.7.0.1
 */