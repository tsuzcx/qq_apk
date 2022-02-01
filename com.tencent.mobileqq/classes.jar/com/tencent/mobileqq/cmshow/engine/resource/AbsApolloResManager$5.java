package com.tencent.mobileqq.cmshow.engine.resource;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import java.util.concurrent.atomic.AtomicInteger;

class AbsApolloResManager$5
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  AbsApolloResManager$5(AbsApolloResManager paramAbsApolloResManager, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AppInterface paramAppInterface, AtomicInteger paramAtomicInteger3, String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      this.a.getAndIncrement();
    }
    this.b.getAndIncrement();
    IApolloDaoManagerService localIApolloDaoManagerService = (IApolloDaoManagerService)this.c.getRuntimeService(IApolloDaoManagerService.class, "all");
    AbsApolloResManager.a(this.g, this.b, this.d, this.a, localIApolloDaoManagerService, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.5
 * JD-Core Version:    0.7.0.1
 */