package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController.IWatchInfoCallback;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoDynamicInsertController$requestControllInfo$1$1", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertController$IWatchInfoCallback;", "getWatchInfo", "", "rowKey", "", "action", "Lcom/tencent/mobileqq/kandian/repo/feeds/RIJFeedsInsertAction;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoDynamicInsertController$requestControllInfo$1$1
  implements RIJFeedsDynamicInsertController.IWatchInfoCallback
{
  public void a(@Nullable String paramString, @NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "action");
    Object localObject = this.a.this$0.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getWatchInfo rowKey: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", action: ");
    localStringBuilder.append(paramRIJFeedsInsertAction);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    if (paramRIJFeedsInsertAction.a() == ActionType.ACTION_VIDEO_PLAY_PROGRESS)
    {
      localObject = this.a.this$0.a();
      if (localObject != null)
      {
        localObject = ((VideoPlayController)localObject).a();
        if (localObject != null)
        {
          localObject = ((AbsBaseArticleInfo)localObject).innerUniqueID;
          break label110;
        }
      }
      localObject = null;
      label110:
      if (Intrinsics.areEqual(paramString, localObject))
      {
        paramString = this.a.this$0.a();
        if (paramString != null)
        {
          paramString = paramString.a();
          if (paramString != null)
          {
            paramString = paramString.innerUniqueID;
            if (paramString != null) {
              paramString = (Integer)this.a.this$0.a().put(paramString, Integer.valueOf(paramRIJFeedsInsertAction.a()));
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoDynamicInsertController.requestControllInfo.1.1
 * JD-Core Version:    0.7.0.1
 */