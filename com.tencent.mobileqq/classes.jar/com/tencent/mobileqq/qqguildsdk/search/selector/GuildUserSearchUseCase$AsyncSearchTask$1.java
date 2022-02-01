package com.tencent.mobileqq.qqguildsdk.search.selector;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class GuildUserSearchUseCase$AsyncSearchTask$1
  implements Runnable
{
  GuildUserSearchUseCase$AsyncSearchTask$1(GuildUserSearchUseCase.AsyncSearchTask paramAsyncSearchTask) {}
  
  public void run()
  {
    int i = GuildUserSearchUseCase.AsyncSearchTask.a(this.this$0).get();
    if (i != 1)
    {
      String str = GuildUserSearchUseCase.AsyncSearchTask.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start(): task canceled, will not load: ");
      localStringBuilder.append(GuildUserSearchUseCase.a(i));
      QLog.i(str, 2, localStringBuilder.toString());
      return;
    }
    GuildUserSearchUseCase.AsyncSearchOption.a(GuildUserSearchUseCase.AsyncSearchTask.b(this.this$0)).a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.GuildUserSearchUseCase.AsyncSearchTask.1
 * JD-Core Version:    0.7.0.1
 */