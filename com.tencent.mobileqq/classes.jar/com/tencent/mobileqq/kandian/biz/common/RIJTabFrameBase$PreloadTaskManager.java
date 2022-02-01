package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;
import com.tencent.mobileqq.kandian.biz.flutter.RIJFlutterUtils;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenCommentUtil;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenHippyEngineManager;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.InitWebProcessRunnable;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJWebPreloadAladdinConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase$PreloadTaskManager;", "", "()V", "preLoadUnreadMsgBoxTime", "", "loadWebRenderSo", "", "preDownloadAdMaskRes", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "preDownloadEmotion", "preLoadMsgBoxIfNecessary", "preRequestUserLevelInfo", "preStartAchilles", "preloadAll", "tabFrameBase", "Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase;", "preloadTKDTuWenHippyEngine", "preloadWebviewProcess", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJTabFrameBase$PreloadTaskManager
{
  private long a;
  
  private final void a()
  {
    ThreadManager.executeOnSubThread((Runnable)RIJTabFrameBase.PreloadTaskManager.loadWebRenderSo.1.a);
  }
  
  private final void a(QQAppInterface paramQQAppInterface)
  {
    Manager localManager = paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (localManager != null)
    {
      if ((((KandianMergeManager)localManager).P()) && (System.currentTimeMillis() - this.a > 180000L))
      {
        ReadInJoyWebDataManager.a().a(paramQQAppInterface.getCurrentAccountUin(), 1);
        this.a = System.currentTimeMillis();
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
  }
  
  private final void b()
  {
    ThreadManager.getFileThreadHandler().postDelayed((Runnable)RIJTabFrameBase.PreloadTaskManager.preStartAchilles.1.a, 20000L);
  }
  
  private final void b(QQAppInterface paramQQAppInterface)
  {
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).checkAdMaterialRefresh(paramQQAppInterface);
  }
  
  private final void c()
  {
    RIJUserLevelModule.getInstance().preRequestUserLevel();
  }
  
  private final void d() {}
  
  private final void e()
  {
    if (TKDTuWenCommentUtil.isTuWenHippyEngineReuseSwitchOn()) {
      TKDTuWenHippyEngineManager.preloadUseTopActivity();
    }
  }
  
  public final void a(@NotNull RIJTabFrameBase paramRIJTabFrameBase)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJTabFrameBase, "tabFrameBase");
    if (!RIJWebPreloadAladdinConfig.a()) {
      return;
    }
    ReadinjoyTabFrame.InitWebProcessRunnable localInitWebProcessRunnable = new ReadinjoyTabFrame.InitWebProcessRunnable();
    localInitWebProcessRunnable.a(paramRIJTabFrameBase);
    ThreadManager.executeOnSubThread((Runnable)localInitWebProcessRunnable);
  }
  
  public final void a(@NotNull RIJTabFrameBase paramRIJTabFrameBase, @NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJTabFrameBase, "tabFrameBase");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    QLog.d("RIJTabFrameBase", 1, "start preload task");
    a();
    a(paramQQAppInterface);
    b();
    a(paramRIJTabFrameBase);
    c();
    b(paramQQAppInterface);
    RIJFlutterUtils.a.a();
    d();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase.PreloadTaskManager
 * JD-Core Version:    0.7.0.1
 */