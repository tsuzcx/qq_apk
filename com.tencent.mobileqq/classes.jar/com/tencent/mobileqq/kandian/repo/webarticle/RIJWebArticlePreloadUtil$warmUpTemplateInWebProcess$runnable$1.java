package com.tencent.mobileqq.kandian.repo.webarticle;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJWebArticlePreloadUtil$warmUpTemplateInWebProcess$runnable$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    try
    {
      RIJWebResourceUtil.a.a();
      RIJWebResourceUtil.a(RIJWebResourceUtil.a, false, 1, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[warmUpTemplateInWebProcess] error, t = ");
      localStringBuilder.append(localThrowable);
      QLog.e("RIJWebArticlePreloadUtil", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticlePreloadUtil.warmUpTemplateInWebProcess.runnable.1
 * JD-Core Version:    0.7.0.1
 */