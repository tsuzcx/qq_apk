package com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper;

import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView;

class ProteusPagerSnapHelper$1
  implements Runnable
{
  ProteusPagerSnapHelper$1(ProteusPagerSnapHelper paramProteusPagerSnapHelper) {}
  
  public void run()
  {
    if (!ProteusPagerSnapHelper.a(this.this$0)) {
      return;
    }
    ProteusPagerSnapHelper localProteusPagerSnapHelper = this.this$0;
    localProteusPagerSnapHelper.a(localProteusPagerSnapHelper.b() + 1);
    ProteusPagerSnapHelper.a(this.this$0).postDelayed(this.this$0.a, ProteusPagerSnapHelper.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.ProteusPagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */