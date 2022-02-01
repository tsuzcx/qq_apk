package com.tencent.mobileqq.cmshow.engine.resource;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import java.util.concurrent.atomic.AtomicInteger;

class AbsApolloResManager$4
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  AbsApolloResManager$4(AbsApolloResManager paramAbsApolloResManager, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AppInterface paramAppInterface, AtomicInteger paramAtomicInteger3, String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean) {
      this.a.getAndIncrement();
    }
    this.b.getAndIncrement();
    paramString = (IApolloDaoManagerService)this.c.getRuntimeService(IApolloDaoManagerService.class, "all");
    AbsApolloResManager.a(this.g, this.b, this.d, this.a, paramString, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.4
 * JD-Core Version:    0.7.0.1
 */