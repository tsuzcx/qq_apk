package com.tencent.tkd.topicsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.tkd.comment.panel.bridge.emoji.IEmoJiEmotionBridge;
import com.tencent.tkd.comment.panel.emoji.EmoJiEmotionPanelManager;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.framework.Account;
import com.tencent.tkd.topicsdk.framework.BizConfig;
import com.tencent.tkd.topicsdk.framework.DataTransferManager;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManager;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEventObserver;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.BaseReportEvent;
import com.tencent.tkd.topicsdk.interfaces.IStorageConfig;
import com.tencent.tkd.topicsdk.managetopic.CreateTopicPage;
import com.tencent.tkd.topicsdk.managetopic.EditTopicPage;
import com.tencent.tkd.topicsdk.managetopic.TopicEventDispatcher;
import java.io.File;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/TopicSDK;", "", "()V", "hasInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mTopicSDKConfig", "Lcom/tencent/tkd/topicsdk/TopicSDKConfig;", "topicSDKConfig", "getTopicSDKConfig", "()Lcom/tencent/tkd/topicsdk/TopicSDKConfig;", "addBaseReportListener", "", "clazz", "Ljava/lang/Class;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/BaseReportEvent;", "observer", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEventObserver;", "addCreateTopicListener", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errorCode", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "topicInfo", "Lcom/tencent/tkd/topicsdk/managetopic/CreateTopicListener;", "addEditTopicListener", "Lcom/tencent/tkd/topicsdk/managetopic/EditTopicListener;", "addPublishArticleListener", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager$IPublishArticleListener;", "assertInited", "checkDir", "", "initEmotionSDK", "initial", "openCreateTopicPage", "context", "Landroid/content/Context;", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "openCreateTopicPageForResult", "activity", "Landroid/app/Activity;", "requestCode", "openEditTopicPage", "openEditTopicPageForResult", "release", "removeBaseReportListener", "removeCreateTopicListener", "removeEditTopicListener", "removePublishArticleListener", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class TopicSDK
{
  public static final TopicSDK.Companion a;
  private static final TopicSDK jdField_a_of_type_ComTencentTkdTopicsdkTopicSDK = new TopicSDK();
  private TopicSDKConfig jdField_a_of_type_ComTencentTkdTopicsdkTopicSDKConfig;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkTopicSDK$Companion = new TopicSDK.Companion(null);
  }
  
  @JvmStatic
  @NotNull
  public static final TopicSDK b()
  {
    return jdField_a_of_type_ComTencentTkdTopicsdkTopicSDK$Companion.a();
  }
  
  private final void b(TopicSDKConfig paramTopicSDKConfig)
  {
    paramTopicSDKConfig = (IEmoJiEmotionBridge)new TopicSDK.initEmotionSDK.emotionBridge.1(new TopicSDK.initEmotionSDK.emoJiEmotionImpl.1(paramTopicSDKConfig));
    EmoJiEmotionPanelManager.a().a(paramTopicSDKConfig);
  }
  
  private final void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkTopicSDKConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTopicSDKConfig");
    }
    localObject = new File(((TopicSDKConfig)localObject).a().b());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkTopicSDKConfig;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTopicSDKConfig");
    }
    localObject = new File(((TopicSDKConfig)localObject).a().c());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
  }
  
  @NotNull
  public final TopicSDKConfig a()
  {
    TopicSDKConfig localTopicSDKConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkTopicSDKConfig;
    if (localTopicSDKConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTopicSDKConfig");
    }
    return localTopicSDKConfig;
  }
  
  public final void a()
  {
    TopicSDKConfig localTopicSDKConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkTopicSDKConfig;
    if (localTopicSDKConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTopicSDKConfig");
    }
    localTopicSDKConfig.a();
  }
  
  public final void a(@NotNull Activity paramActivity, int paramInt, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    b();
    TopicSDKHelperKt.a(paramActivity, CreateTopicPage.class, paramInt, paramBundle1, paramBundle2, null, 32, null);
  }
  
  public final void a(@NotNull Context paramContext, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    b();
    TopicSDKHelperKt.a(paramContext, CreateTopicPage.class, paramBundle1, paramBundle2, null, 16, null);
  }
  
  public final void a(@NotNull TopicSDKConfig paramTopicSDKConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicSDKConfig, "topicSDKConfig");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      System.out.println("TopicSDK::initial 不允许重复调用");
      return;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkTopicSDKConfig = paramTopicSDKConfig;
    BizConfig.a.a(paramTopicSDKConfig.a());
    TLog.a.a(paramTopicSDKConfig.a());
    Account.a.a(paramTopicSDKConfig.a());
    StorageManager.a.a(paramTopicSDKConfig.a());
    DataTransferManager.a.a(paramTopicSDKConfig.a());
    ThreadManager.a.a(paramTopicSDKConfig.a());
    c();
    b(paramTopicSDKConfig);
  }
  
  public final void a(@NotNull Class<? extends BaseReportEvent> paramClass, @NotNull IEventObserver<? extends BaseReportEvent> paramIEventObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    Intrinsics.checkParameterIsNotNull(paramIEventObserver, "observer");
    DispatchManager.a.a(paramClass, paramIEventObserver);
  }
  
  public final void a(@NotNull Function2<? super Integer, ? super TopicInfo, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "listener");
    TopicEventDispatcher.a.a(paramFunction2);
  }
  
  public final void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  public final void b(@NotNull Context paramContext, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    b();
    TopicSDKHelperKt.a(paramContext, EditTopicPage.class, paramBundle1, paramBundle2, null, 16, null);
  }
  
  public final void b(@NotNull Function2<? super Integer, ? super TopicInfo, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "listener");
    TopicEventDispatcher.a.b(paramFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.TopicSDK
 * JD-Core Version:    0.7.0.1
 */