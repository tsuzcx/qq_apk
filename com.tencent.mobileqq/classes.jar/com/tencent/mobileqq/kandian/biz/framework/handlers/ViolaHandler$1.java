package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.glue.viola.RIJViolaUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.viola.core.ViolaSDKManager;

class ViolaHandler$1
  implements Runnable
{
  ViolaHandler$1(ViolaHandler paramViolaHandler, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void run()
  {
    Object localObject2 = RIJFeedsType.a(this.a);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = RIJViolaUtils.a(this.a);
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = RIJViolaUtils.b(this.a);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ViolaSDKManager.getInstance().postOnUiThread(new ViolaHandler.1.1(this, (String)localObject2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.ViolaHandler.1
 * JD-Core Version:    0.7.0.1
 */