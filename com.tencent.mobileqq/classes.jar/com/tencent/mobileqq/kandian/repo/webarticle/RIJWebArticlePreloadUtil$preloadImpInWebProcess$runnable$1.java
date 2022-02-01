package com.tencent.mobileqq.kandian.repo.webarticle;

import android.text.TextUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicRuntime;
import com.tencent.sonic.sdk.SonicSessionConfig;
import com.tencent.sonic.sdk.SonicSessionConfig.Builder;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJWebArticlePreloadUtil$preloadImpInWebProcess$runnable$1
  implements Runnable
{
  RIJWebArticlePreloadUtil$preloadImpInWebProcess$runnable$1(String paramString) {}
  
  public final void run()
  {
    if (TextUtils.isEmpty((CharSequence)this.a))
    {
      QLog.i("RIJWebArticlePreloadUtil", 1, "[preloadImpInWebProcess] url is empty.");
      return;
    }
    Object localObject1 = new SonicSessionConfig.Builder().setSessionMode(1).setSupportLocalServer(true).build();
    SonicEngine localSonicEngine = WebAccelerateHelper.getSonicEngine();
    if (localSonicEngine == null)
    {
      QLog.i("RIJWebArticlePreloadUtil", 1, "[preloadImpInWebProcess] sonicEngine is null.");
      return;
    }
    Object localObject2 = localSonicEngine.getRuntime();
    if ((localObject2 != null) && (((SonicRuntime)localObject2).isSonicUrl(this.a) == true))
    {
      if (RIJWebArticlePreloadUtil.a(RIJWebArticlePreloadUtil.a, this.a))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[preloadImpInWebProcess] is already in preload list, url = ");
        ((StringBuilder)localObject1).append(this.a);
        QLog.i("RIJWebArticlePreloadUtil", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      localObject2 = this.a;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      boolean bool2 = localSonicEngine.preCreateSession((String)localObject2, (SonicSessionConfig)localObject1);
      boolean bool1 = bool2;
      if (!bool2)
      {
        localObject2 = (RIJWebArticlePreloadUtil.PreloadData)RIJWebArticlePreloadUtil.a(RIJWebArticlePreloadUtil.a).poll();
        bool1 = bool2;
        if (localObject2 != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty((CharSequence)((RIJWebArticlePreloadUtil.PreloadData)localObject2).b()))
          {
            Object localObject3 = ((RIJWebArticlePreloadUtil.PreloadData)localObject2).b();
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            bool1 = localSonicEngine.removeSessionCache((String)localObject3);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[preloadImpInWebProcess] removeRes = ");
            ((StringBuilder)localObject3).append(bool1);
            ((StringBuilder)localObject3).append(", url = ");
            ((StringBuilder)localObject3).append(this.a);
            ((StringBuilder)localObject3).append(", firstPreloadData url = ");
            ((StringBuilder)localObject3).append(((RIJWebArticlePreloadUtil.PreloadData)localObject2).a());
            QLog.i("RIJWebArticlePreloadUtil", 1, ((StringBuilder)localObject3).toString());
            bool1 = localSonicEngine.preCreateSession(this.a, (SonicSessionConfig)localObject1);
          }
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[preloadImpInWebProcess] preloadRes = ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(", url = ");
      ((StringBuilder)localObject1).append(this.a);
      QLog.i("RIJWebArticlePreloadUtil", 1, ((StringBuilder)localObject1).toString());
      localObject1 = this.a;
      localObject1 = new RIJWebArticlePreloadUtil.PreloadData((String)localObject1, SonicEngine.makeSessionId((String)localObject1, true));
      if (bool1) {
        RIJWebArticlePreloadUtil.a(RIJWebArticlePreloadUtil.a).add(localObject1);
      }
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[preloadImpInWebProcess] not sonic url, url = ");
    ((StringBuilder)localObject1).append(this.a);
    QLog.i("RIJWebArticlePreloadUtil", 1, ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticlePreloadUtil.preloadImpInWebProcess.runnable.1
 * JD-Core Version:    0.7.0.1
 */