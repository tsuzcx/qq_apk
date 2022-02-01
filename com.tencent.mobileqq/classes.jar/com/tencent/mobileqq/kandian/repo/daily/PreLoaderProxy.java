package com.tencent.mobileqq.kandian.repo.daily;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/daily/PreLoaderProxy;", "", "()V", "isConfigNeedPreload", "", "()Z", "setConfigNeedPreload", "(Z)V", "isDebugChange", "getDebugChange", "setNeedPreload", "", "needPreload", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class PreLoaderProxy
{
  public static final PreLoaderProxy a = new PreLoaderProxy();
  private static boolean b;
  private static boolean c;
  
  public final void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public final boolean a()
  {
    return b;
  }
  
  public final boolean b()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.daily.PreLoaderProxy
 * JD-Core Version:    0.7.0.1
 */