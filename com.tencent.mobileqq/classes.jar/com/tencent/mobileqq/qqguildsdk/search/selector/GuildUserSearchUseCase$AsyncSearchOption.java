package com.tencent.mobileqq.qqguildsdk.search.selector;

import androidx.annotation.NonNull;
import com.tencent.gprosdk.GProUser;
import java.util.concurrent.Executor;

public class GuildUserSearchUseCase$AsyncSearchOption
{
  private final AsyncDataSource<GProUser> a;
  private final Executor b;
  
  public GuildUserSearchUseCase$AsyncSearchOption(@NonNull AsyncDataSource<GProUser> paramAsyncDataSource, @NonNull Executor paramExecutor)
  {
    this.a = paramAsyncDataSource;
    this.b = paramExecutor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.GuildUserSearchUseCase.AsyncSearchOption
 * JD-Core Version:    0.7.0.1
 */