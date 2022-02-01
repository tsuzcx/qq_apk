package com.tencent.mobileqq.kandian.biz.ugc;

import android.app.Activity;
import com.tencent.mobileqq.kandian.repo.ugc.RIJUGCAccountCreateModule.UGCAccountStatusCallback;
import com.tencent.util.UiThreadUtil;
import java.lang.ref.WeakReference;

public class RIJUgcUtils$RIJUGCAccountStatusCheckCallback
  implements RIJUGCAccountCreateModule.UGCAccountStatusCallback
{
  private WeakReference<Activity> a;
  private int b = 0;
  
  public RIJUgcUtils$RIJUGCAccountStatusCheckCallback(Activity paramActivity, int paramInt)
  {
    this.a = new WeakReference(paramActivity);
    this.b = paramInt;
  }
  
  public void a(int paramInt)
  {
    UiThreadUtil.a(new RIJUgcUtils.RIJUGCAccountStatusCheckCallback.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.RIJUGCAccountStatusCheckCallback
 * JD-Core Version:    0.7.0.1
 */