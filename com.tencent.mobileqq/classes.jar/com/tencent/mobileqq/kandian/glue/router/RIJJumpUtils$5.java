package com.tencent.mobileqq.kandian.glue.router;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

final class RIJJumpUtils$5
  implements Runnable
{
  RIJJumpUtils$5(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt) {}
  
  public void run()
  {
    try
    {
      RIJJumpUtils.a(this.a, this.b, this.c, this.d);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[reportDataInSubThread] e = ");
      localStringBuilder.append(localException);
      QLog.e("RIJJumpUtils", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.5
 * JD-Core Version:    0.7.0.1
 */