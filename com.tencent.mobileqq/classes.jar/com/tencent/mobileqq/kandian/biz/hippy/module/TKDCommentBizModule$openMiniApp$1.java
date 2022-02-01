package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$openMiniApp$1
  implements Runnable
{
  TKDCommentBizModule$openMiniApp$1(TKDCommentBizModule paramTKDCommentBizModule, HippyMap paramHippyMap) {}
  
  public final void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openMiniApp --> params:");
    ((StringBuilder)localObject).append(this.$params);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject).toString());
    localObject = TKDCommentBizModule.access$getActivity(this.this$0);
    if (localObject != null)
    {
      String str = this.$params.getString("miniAppUrl");
      if (!TextUtils.isEmpty((CharSequence)str))
      {
        ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToMiniApp((Context)localObject, str, 2106, null);
        return;
      }
      QLog.e("TKDCommentBizModule", 1, "openMiniApp --> scheme is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule.openMiniApp.1
 * JD-Core Version:    0.7.0.1
 */