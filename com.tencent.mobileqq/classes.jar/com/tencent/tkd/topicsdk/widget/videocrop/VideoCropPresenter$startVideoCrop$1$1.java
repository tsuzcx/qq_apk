package com.tencent.tkd.topicsdk.widget.videocrop;

import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.common.FileUtils;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoCropPresenter$startVideoCrop$1$1
  extends Lambda
  implements Function0<Unit>
{
  VideoCropPresenter$startVideoCrop$1$1(VideoCropPresenter.startVideoCrop.1 param1, Boolean paramBoolean, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (VideoCropPresenter.b(this.this$0.this$0)) {
      return;
    }
    if ((FileUtils.a.a(this.$targetPath)) && (Intrinsics.areEqual(this.$result, Boolean.valueOf(true))))
    {
      localObject = VideoCropPresenter.c(this.this$0.this$0);
      if (localObject != null) {
        ((VideoCropContract.IView)localObject).a(this.this$0.this$0.g(), this.$targetPath);
      }
      int i = this.this$0.$item.getEndMergeTime();
      int j = this.this$0.$item.getStartMergeTime();
      long l1 = System.currentTimeMillis();
      long l2 = this.this$0.$startMergeTime;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("视频裁剪，视频长度: ");
      ((StringBuilder)localObject).append(i - j);
      ((StringBuilder)localObject).append("ms, 耗时: ");
      ((StringBuilder)localObject).append(l1 - l2);
      ((StringBuilder)localObject).append("ms");
      TopicSDKHelperKt.a(((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = VideoCropPresenter.c(this.this$0.this$0);
      if (localObject != null) {
        ((VideoCropContract.IView)localObject).dP_();
      }
    }
    Object localObject = VideoCropPresenter.c(this.this$0.this$0);
    if (localObject != null) {
      ((VideoCropContract.IView)localObject).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPresenter.startVideoCrop.1.1
 * JD-Core Version:    0.7.0.1
 */