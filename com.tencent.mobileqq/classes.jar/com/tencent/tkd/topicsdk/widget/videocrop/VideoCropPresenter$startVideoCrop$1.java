package com.tencent.tkd.topicsdk.widget.videocrop;

import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.merge.VideoTrimmer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoCropPresenter$startVideoCrop$1
  extends Lambda
  implements Function0<Unit>
{
  VideoCropPresenter$startVideoCrop$1(VideoCropPresenter paramVideoCropPresenter, DisplayItem paramDisplayItem, long paramLong)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TopicSDKHelperKt.c());
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append("-audio.mp4");
    String str = ((StringBuilder)localObject).toString();
    localObject = VideoCropPresenter.a(this.this$0);
    if (localObject != null) {
      localObject = Boolean.valueOf(((VideoTrimmer)localObject).a(this.this$0.a(), str, this.$item.getStartMergeTime(), this.$item.getEndMergeTime(), true, true));
    } else {
      localObject = null;
    }
    ThreadManagerKt.a((Function0)new VideoCropPresenter.startVideoCrop.1.1(this, (Boolean)localObject, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPresenter.startVideoCrop.1
 * JD-Core Version:    0.7.0.1
 */