package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.comment.ui.RIJCommentBubbleView.SheetItemClickProcessor;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2.BaseSheetItemClickProcessor;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$shareComment$1
  implements Runnable
{
  TKDCommentBizModule$shareComment$1(TKDCommentBizModule paramTKDCommentBizModule, HippyMap paramHippyMap) {}
  
  public final void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onShareComment() --> params:");
    ((StringBuilder)localObject1).append(this.$params);
    QLog.d("TKDCommentBizModule", 1, ((StringBuilder)localObject1).toString());
    if (TKDCommentBizModule.access$getActivity(this.this$0) == null)
    {
      QLog.e("TKDCommentBizModule", 1, "onShareComment() --> activity is null");
      return;
    }
    localObject1 = this.$params.getString("content");
    if (localObject1 == null) {
      localObject1 = "";
    }
    String str1 = this.$params.getString("shareUrl");
    if (str1 == null) {
      str1 = "";
    }
    String str2 = this.$params.getString("firstPagePicUrl");
    if (str2 == null) {
      str2 = "";
    }
    boolean bool = TextUtils.isEmpty((CharSequence)this.$params.getString("firstCommentId"));
    Object localObject2 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication()");
    localObject2 = ((BaseApplicationImpl)localObject2).getRuntime();
    if (localObject2 != null)
    {
      localObject2 = (QQAppInterface)localObject2;
      Activity localActivity = TKDCommentBizModule.access$getActivity(this.this$0);
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity");
      localObject1 = new ReadInJoyShareHelperV2(localActivity, (AppInterface)localObject2, (ReadInJoyShareHelperV2.BaseSheetItemClickProcessor)new RIJCommentBubbleView.SheetItemClickProcessor((String)localObject1, str1, str2, new WeakReference(TKDCommentBizModule.access$getActivity(this.this$0))));
      ((ReadInJoyShareHelperV2)localObject1).a(TKDCommentBizModule.access$getShareLine(this.this$0, bool), 29, "");
      ((ReadInJoyShareHelperV2)localObject1).a().setRowVisibility(8, 0, 0);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDCommentBizModule.shareComment.1
 * JD-Core Version:    0.7.0.1
 */