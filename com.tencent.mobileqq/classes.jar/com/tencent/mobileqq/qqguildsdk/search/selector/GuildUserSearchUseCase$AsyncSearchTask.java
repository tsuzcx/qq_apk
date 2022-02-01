package com.tencent.mobileqq.qqguildsdk.search.selector;

import com.tencent.gprosdk.GProUser;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class GuildUserSearchUseCase$AsyncSearchTask
  implements AsyncDataSource.DataSourceHandler<GProUser>, GuildUserSearchUseCase.ISearchTask
{
  private static final AtomicInteger a = new AtomicInteger(0);
  private static final String b = String.format(Locale.PRC, "AsyncSearchTask-%04d", new Object[] { Integer.valueOf(a.incrementAndGet()) });
  private final GuildUserSearchUseCase.AsyncSearchOption c;
  private final String d;
  private final List<List<IGProUserInfo>> e = Collections.synchronizedList(new ArrayList());
  private final ISearchSink<IGProUserInfo> f;
  private final AtomicInteger g = new AtomicInteger(0);
  private final AtomicInteger h = new AtomicInteger(0);
  private final AtomicInteger i = new AtomicInteger(0);
  private volatile boolean j = false;
  
  public GuildUserSearchUseCase$AsyncSearchTask(GuildUserSearchUseCase.AsyncSearchOption paramAsyncSearchOption, String paramString, ISearchSink<IGProUserInfo> paramISearchSink)
  {
    this.c = paramAsyncSearchOption;
    this.d = paramString;
    this.f = paramISearchSink;
  }
  
  private void a(List<GProUser> paramList, ArrayList<IGProUserInfo> paramArrayList)
  {
    this.g.incrementAndGet();
    this.h.incrementAndGet();
    GuildUserSearchUseCase.AsyncSearchOption.b(this.c).execute(new GuildUserSearchUseCase.AsyncSearchTask.2(this, paramArrayList, paramList));
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str;
      if (paramBoolean) {
        str = String.format(Locale.getDefault(), "submitSearchJob(): LOADING_DATA -> SEARCH_DATA, (%d/%d)", new Object[] { Integer.valueOf(this.g.get()), Integer.valueOf(this.h.get()) });
      } else {
        str = String.format(Locale.getDefault(), "submitSearchJob(): %s, (%d/%d)", new Object[] { GuildUserSearchUseCase.a(this.i.get()), Integer.valueOf(this.g.get()), Integer.valueOf(this.h.get()) });
      }
      QLog.d(b, 2, str);
    }
  }
  
  private ArrayList<IGProUserInfo> c()
  {
    ArrayList localArrayList = new ArrayList();
    this.e.add(localArrayList);
    return localArrayList;
  }
  
  private void d()
  {
    int k;
    if ((this.j) && (this.g.get() == 0)) {
      k = 1;
    } else {
      k = 0;
    }
    if ((k != 0) && (this.i.compareAndSet(2, 3))) {
      e();
    }
  }
  
  private void e()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.addAll((List)((Iterator)localObject).next());
    }
    localObject = new GuildUserSearchUseCase.ResultModel(this.d, localArrayList);
    QLog.i(b, 2, String.format(Locale.PRC, "dispatchCallback(): dispatch callback for keyword: %s, result.size=%d", new Object[] { this.d, Integer.valueOf(localArrayList.size()) }));
    this.f.onSearchResult(0, "", Collections.singletonList(localObject), false);
  }
  
  public void a()
  {
    if (this.i.compareAndSet(0, 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "start(): TASK_INIT -> LOADING_DATA");
      }
      GuildUserSearchUseCase.AsyncSearchOption.b(this.c).execute(new GuildUserSearchUseCase.AsyncSearchTask.1(this));
    }
  }
  
  public final void a(List<GProUser> paramList, boolean paramBoolean)
  {
    if (this.i.get() == 4)
    {
      QLog.i(b, 2, "onData(): task canceled, SEARCH_CANCEL");
      return;
    }
    a(paramList, c());
    if (paramBoolean)
    {
      this.j = true;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.GuildUserSearchUseCase.AsyncSearchTask
 * JD-Core Version:    0.7.0.1
 */