package com.tencent.mobileqq.qqguildsdk.search.selector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class GuildUserSearchUseCase$AsyncSearchTask$2
  implements Runnable
{
  GuildUserSearchUseCase$AsyncSearchTask$2(GuildUserSearchUseCase.AsyncSearchTask paramAsyncSearchTask, ArrayList paramArrayList, List paramList) {}
  
  public void run()
  {
    boolean bool = GuildUserSearchUseCase.AsyncSearchTask.a(this.this$0).compareAndSet(1, 2);
    GuildUserSearchUseCase.AsyncSearchTask.a(this.this$0, bool);
    this.a.addAll(GuildUserSearchUseCase.a(this.b, GuildUserSearchUseCase.AsyncSearchTask.c(this.this$0)));
    if (GuildUserSearchUseCase.AsyncSearchTask.d(this.this$0).decrementAndGet() == 0) {
      GuildUserSearchUseCase.AsyncSearchTask.e(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.GuildUserSearchUseCase.AsyncSearchTask.2
 * JD-Core Version:    0.7.0.1
 */