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
    if (VideoCropPresenter.a(this.this$0.this$0)) {
      return;
    }
    VideoCropContract.IView localIView;
    if ((FileUtils.a.a(this.$targetPath)) && (Intrinsics.areEqual(this.$result, Boolean.valueOf(true))))
    {
      localIView = VideoCropPresenter.a(this.this$0.this$0);
      if (localIView != null) {
        localIView.a(this.this$0.this$0.a(), this.$targetPath);
      }
      if (TopicSDKHelperKt.a())
      {
        int i = this.this$0.$item.getEndMergeTime();
        int j = this.this$0.$item.getStartMergeTime();
        long l1 = System.currentTimeMillis();
        long l2 = this.this$0.$startMergeTime;
        TopicSDKHelperKt.a("视频裁剪，视频长度: " + (i - j) + "ms, 耗时: " + (l1 - l2) + "ms", true, null, 4, null);
      }
    }
    for (;;)
    {
      localIView = VideoCropPresenter.a(this.this$0.this$0);
      if (localIView == null) {
        break;
      }
      localIView.a(false);
      return;
      localIView = VideoCropPresenter.a(this.this$0.this$0);
      if (localIView != null) {
        localIView.aI_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPresenter.startVideoCrop.1.1
 * JD-Core Version:    0.7.0.1
 */