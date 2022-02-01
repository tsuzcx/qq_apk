package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$openQQGroup$1
  implements Runnable
{
  TKDCommentBizModule$openQQGroup$1(TKDCommentBizModule paramTKDCommentBizModule, HippyMap paramHippyMap, Ref.ObjectRef paramObjectRef, String paramString) {}
  
  public final void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openQQGroup --> params:");
    localStringBuilder.append(this.$params);
    QLog.d("TKDCommentBizModule", 1, localStringBuilder.toString());
    if (TKDCommentBizModule.access$getActivity(this.this$0) != null)
    {
      if (!TextUtils.isEmpty((CharSequence)this.$scheme.element))
      {
        ReadInJoyCommentUtils.a((Context)TKDCommentBizModule.access$getActivity(this.this$0), (String)this.$scheme.element, this.$feedType);
        return;
      }
      QLog.e("TKDCommentBizModule", 1, "openQQGroup --> scheme is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule.openQQGroup.1
 * JD-Core Version:    0.7.0.1
 */