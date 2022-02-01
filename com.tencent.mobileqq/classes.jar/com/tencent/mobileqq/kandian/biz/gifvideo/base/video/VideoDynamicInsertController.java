package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertConfig;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoDynamicInsertController;", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController$OnStateChangeListener;", "videoPlayController", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "requestInsertSet", "", "getRequestInsertSet", "()Ljava/util/Set;", "setRequestInsertSet", "(Ljava/util/Set;)V", "getVideoPlayController", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "setVideoPlayController", "watchInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getWatchInfoMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getWatchProgressByRowkey", "rowKey", "hasRequestInsertCard", "", "onStateChanged", "", "oldState", "newState", "requestControllInfo", "delayTime", "updateProgress", "progress", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoDynamicInsertController
  implements VideoPlayController.OnStateChangeListener
{
  @NotNull
  private String a;
  @NotNull
  private final ConcurrentHashMap<String, Integer> b;
  @NotNull
  private Set<String> c;
  @Nullable
  private VideoPlayController d;
  
  public VideoDynamicInsertController(@Nullable VideoPlayController paramVideoPlayController)
  {
    this.d = paramVideoPlayController;
    this.a = "VideoDynamicInsertController";
    this.b = new ConcurrentHashMap();
    this.c = SetsKt.emptySet();
    paramVideoPlayController = this.d;
    if (paramVideoPlayController != null) {
      paramVideoPlayController.a((VideoPlayController.OnStateChangeListener)this);
    }
  }
  
  private final int a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    paramString = (Integer)this.b.get(paramString);
    if (paramString == null) {
      paramString = Integer.valueOf(-1);
    }
    return paramString.intValue();
  }
  
  private final void b(int paramInt)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestControllInfo delayTime:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", rowKey: ");
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((VideoPlayController)localObject).k();
      if (localObject != null)
      {
        localObject = ((AbsBaseArticleInfo)localObject).innerUniqueID;
        break label65;
      }
    }
    localObject = null;
    label65:
    localStringBuilder.append((String)localObject);
    QLog.d(str, 1, localStringBuilder.toString());
    ThreadManager.a().postDelayed((Runnable)new VideoDynamicInsertController.requestControllInfo.1(this), paramInt);
  }
  
  private final boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.c.contains(paramString);
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    Object localObject1 = this.d;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject1 = ((VideoPlayController)localObject1).k();
      if (localObject1 != null)
      {
        localObject1 = ((AbsBaseArticleInfo)localObject1).innerUniqueID;
        break label31;
      }
    }
    localObject1 = null;
    label31:
    int i = a((String)localObject1);
    if ((localObject1 != null) && (i != -1) && (paramInt >= i) && (!b((String)localObject1)))
    {
      Object localObject3 = this.a;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("updateProgress: ");
      ((StringBuilder)localObject4).append(paramInt);
      ((StringBuilder)localObject4).append(", actionProgress: ");
      ((StringBuilder)localObject4).append(i);
      QLog.d((String)localObject3, 1, ((StringBuilder)localObject4).toString());
      this.c = SetsKt.plus(this.c, localObject1);
      localObject3 = RIJFeedsDynamicInsertController.INSTANCE;
      localObject4 = this.d;
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = ((VideoPlayController)localObject4).k();
      }
      ((RIJFeedsDynamicInsertController)localObject3).requestDynamicInsertInTL((AbsBaseArticleInfo)localObject1, new RIJFeedsInsertAction(ActionType.ACTION_VIDEO_PLAY_PROGRESS, paramInt, 0, 0, 12, null));
    }
  }
  
  @NotNull
  public final ConcurrentHashMap<String, Integer> b()
  {
    return this.b;
  }
  
  @Nullable
  public final VideoPlayController c()
  {
    return this.d;
  }
  
  public void onStateChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 7) {
      return;
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((VideoPlayController)localObject).k();
      if ((localObject != null) && ((int)((AbsBaseArticleInfo)localObject).mChannelID == 0))
      {
        localObject = this.d;
        if (localObject != null)
        {
          localObject = ((VideoPlayController)localObject).k();
          if (localObject != null)
          {
            localObject = ((AbsBaseArticleInfo)localObject).innerUniqueID;
            break label61;
          }
        }
        localObject = null;
        label61:
        if (a((String)localObject) == -1) {
          b(RIJFeedsDynamicInsertConfig.a.a(1));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoDynamicInsertController
 * JD-Core Version:    0.7.0.1
 */