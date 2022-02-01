package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.flutter.api.IQFlutterInstallService;
import com.tencent.mobileqq.flutter.download.InstallCallback;
import kotlin.Metadata;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/qqgamepub/api/impl/QQGameFlutterApiImpl$preloadFlutter$1$1"}, k=3, mv={1, 1, 16})
final class QQGameFlutterApiImpl$preloadFlutter$$inlined$let$lambda$1
  implements Runnable
{
  QQGameFlutterApiImpl$preloadFlutter$$inlined$let$lambda$1(AppRuntime paramAppRuntime, QQGameFlutterApiImpl paramQQGameFlutterApiImpl) {}
  
  public final void run()
  {
    ((IQFlutterInstallService)this.a.getRuntimeService(IQFlutterInstallService.class, "all")).install((InstallCallback)this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameFlutterApiImpl.preloadFlutter..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */