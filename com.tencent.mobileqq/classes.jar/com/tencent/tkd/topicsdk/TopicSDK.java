package com.tencent.tkd.topicsdk;

import com.tencent.tkd.comment.panel.bridge.emoji.IEmoJiEmotionBridge;
import com.tencent.tkd.comment.panel.emoji.EmoJiEmotionPanelManager;
import com.tencent.tkd.topicsdk.framework.Account;
import com.tencent.tkd.topicsdk.framework.BizConfig;
import com.tencent.tkd.topicsdk.framework.DataTransferManager;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.BaseReportEvent;
import com.tencent.tkd.topicsdk.interfaces.IStorageConfig;
import com.tencent.tkd.topicsdk.network.NetWorkManager;
import java.io.File;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/TopicSDK;", "", "()V", "hasInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mTopicSDKConfig", "Lcom/tencent/tkd/topicsdk/TopicSDKConfig;", "topicSDKConfig", "getTopicSDKConfig", "()Lcom/tencent/tkd/topicsdk/TopicSDKConfig;", "addBaseReportListener", "", "clazz", "Ljava/lang/Class;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/BaseReportEvent;", "observer", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEventObserver;", "addPublishArticleListener", "listener", "Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$IPublishArticleListener;", "assertInited", "checkDir", "", "initEmotionSDK", "initial", "release", "removeBaseReportListener", "removePublishArticleListener", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class TopicSDK
{
  public static final TopicSDK.Companion a = new TopicSDK.Companion(null);
  private static final TopicSDK d = new TopicSDK();
  private TopicSDKConfig b;
  private final AtomicBoolean c = new AtomicBoolean(false);
  
  private final void b(TopicSDKConfig paramTopicSDKConfig)
  {
    paramTopicSDKConfig = (IEmoJiEmotionBridge)new TopicSDK.initEmotionSDK.emotionBridge.1(new TopicSDK.initEmotionSDK.emoJiEmotionImpl.1(paramTopicSDKConfig));
    EmoJiEmotionPanelManager.a().a(paramTopicSDKConfig);
  }
  
  @JvmStatic
  @NotNull
  public static final TopicSDK d()
  {
    return a.a();
  }
  
  private final void e()
  {
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTopicSDKConfig");
    }
    localObject = new File(((TopicSDKConfig)localObject).q().a());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTopicSDKConfig");
    }
    localObject = new File(((TopicSDKConfig)localObject).q().b());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
  }
  
  public final void a()
  {
    TopicSDKConfig localTopicSDKConfig = this.b;
    if (localTopicSDKConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTopicSDKConfig");
    }
    localTopicSDKConfig.a();
  }
  
  public final void a(@NotNull TopicSDKConfig paramTopicSDKConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicSDKConfig, "topicSDKConfig");
    if (this.c.getAndSet(true))
    {
      System.out.println("TopicSDK::initial 不允许重复调用");
      return;
    }
    this.b = paramTopicSDKConfig;
    BizConfig.a.a(paramTopicSDKConfig.c());
    TLog.a.a(paramTopicSDKConfig.e());
    Account.a.a(paramTopicSDKConfig.f());
    StorageManager.b.a(paramTopicSDKConfig.b());
    DataTransferManager.a.a(paramTopicSDKConfig.g());
    ThreadManager.b.a(paramTopicSDKConfig.i());
    e();
    b(paramTopicSDKConfig);
    NetWorkManager.a.a(paramTopicSDKConfig.b());
  }
  
  public final void a(@NotNull Class<? extends BaseReportEvent> paramClass, @NotNull IEventObserver<? extends BaseReportEvent> paramIEventObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    Intrinsics.checkParameterIsNotNull(paramIEventObserver, "observer");
    DispatchManager.a.a(paramClass, paramIEventObserver);
  }
  
  @NotNull
  public final TopicSDKConfig b()
  {
    TopicSDKConfig localTopicSDKConfig = this.b;
    if (localTopicSDKConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTopicSDKConfig");
    }
    return localTopicSDKConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.TopicSDK
 * JD-Core Version:    0.7.0.1
 */