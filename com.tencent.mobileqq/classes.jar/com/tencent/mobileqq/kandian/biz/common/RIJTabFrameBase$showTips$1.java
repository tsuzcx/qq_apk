package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.mobileqq.kandian.biz.ugc.account.RIJUGCTipsUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJTabFrameBase$showTips$1
  implements Runnable
{
  RIJTabFrameBase$showTips$1(RIJTabFrameBase paramRIJTabFrameBase) {}
  
  public final void run()
  {
    this.this$0.m();
    if ((RIJUgcUtils.l()) && (RIJTabFrameBase.d.a()))
    {
      RIJUGCTipsUtils.a((Activity)this.this$0.P());
      RIJUGCAddAccountFragment.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase.showTips.1
 * JD-Core Version:    0.7.0.1
 */