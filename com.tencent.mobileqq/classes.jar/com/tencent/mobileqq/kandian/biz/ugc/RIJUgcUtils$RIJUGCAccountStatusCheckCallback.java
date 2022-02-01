package com.tencent.mobileqq.kandian.biz.ugc;

import android.app.Activity;
import com.tencent.mobileqq.kandian.repo.ugc.RIJUGCAccountCreateModule.UGCAccountStatusCallback;
import com.tencent.util.UiThreadUtil;
import java.lang.ref.WeakReference;

public class RIJUgcUtils$RIJUGCAccountStatusCheckCallback
  implements RIJUGCAccountCreateModule.UGCAccountStatusCallback
{
  private int jdField_a_of_type_Int = 0;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public RIJUgcUtils$RIJUGCAccountStatusCheckCallback(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt)
  {
    UiThreadUtil.a(new RIJUgcUtils.RIJUGCAccountStatusCheckCallback.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.RIJUGCAccountStatusCheckCallback
 * JD-Core Version:    0.7.0.1
 */