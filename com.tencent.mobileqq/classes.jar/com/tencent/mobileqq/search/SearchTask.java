package com.tencent.mobileqq.search;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SearchTask
  extends AsyncTask<Void, Void, Void>
{
  private static final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 3, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new SearchTask.1());
  private static Comparator<ISearchable> k = new SearchTask.3();
  private static Comparator<ISearchable> l = new SearchTask.4();
  boolean a = false;
  private final int c = 300;
  private String d;
  private String e;
  private List<? extends ISearchable> f;
  private List<Future<List<ISearchable>>> g;
  private List<ISearchable> h;
  private SearchTask.SearchTaskCallBack i;
  private ExecutorService j;
  
  public SearchTask(String paramString1, String paramString2, List<? extends ISearchable> paramList, SearchTask.SearchTaskCallBack paramSearchTaskCallBack)
  {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramList;
    this.i = paramSearchTaskCallBack;
    this.j = Executors.newFixedThreadPool(20);
    this.g = new ArrayList();
    this.h = new ArrayList();
  }
  
  private void a(List<ISearchable> paramList, String paramString)
  {
    int n = paramList.size();
    int m = 20;
    if (n <= 20) {
      m = paramList.size();
    }
    n = 0;
    while (n < m)
    {
      paramString = (IContactSearchable)paramList.get(n);
      QLog.isColorLevel();
      n += 1;
    }
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (this.f != null)
    {
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("Start doInBackground , keyword = ");
        paramVarArgs.append(this.d);
        QLog.d("SearchTask", 2, paramVarArgs.toString());
      }
      int i1 = this.f.size();
      int i3 = i1 / 300;
      int m = 0;
      int n;
      while (m < i3 + 1)
      {
        int i4 = m * 300;
        int i2 = i4 + 300;
        n = i2;
        if (i2 > i1) {
          n = i1;
        }
        if ((isCancelled()) || (this.j.isShutdown())) {
          break;
        }
        paramVarArgs = this.j.submit(new SearchTask.2(this, i4, n));
        this.g.add(paramVarArgs);
        m += 1;
      }
      try
      {
        this.h.clear();
        long l1 = System.currentTimeMillis();
        m = 0;
        while ((m < this.g.size()) && (!isCancelled()))
        {
          paramVarArgs = (List)((Future)this.g.get(m)).get();
          if (m == 0)
          {
            this.h.addAll(paramVarArgs);
          }
          else
          {
            Iterator localIterator = paramVarArgs.iterator();
            while (localIterator.hasNext())
            {
              ISearchable localISearchable = (ISearchable)localIterator.next();
              if (isCancelled()) {
                break;
              }
              n = this.h.indexOf(localISearchable);
              if (-1 == n) {
                this.h.add(localISearchable);
              } else if (((ISearchable)this.h.get(n)).o() < localISearchable.o()) {
                this.h.set(n, localISearchable);
              }
            }
          }
          paramVarArgs.clear();
          m += 1;
        }
        this.g.clear();
        if (isCancelled()) {
          return null;
        }
        a(this.h);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("SearchTask ======= doInBackground time = ");
          paramVarArgs.append(l2 - l1);
          paramVarArgs.append(" , keyword = ");
          paramVarArgs.append(this.d);
          QLog.d("SearchTask", 2, paramVarArgs.toString());
        }
      }
      catch (ExecutionException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("InterruptedException happens, keyword = ");
          paramVarArgs.append(this.d);
          paramVarArgs.append(" : ");
          QLog.d("SearchTask", 2, paramVarArgs.toString());
        }
      }
      catch (InterruptedException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("InterruptedException happens, keyword = ");
          paramVarArgs.append(this.d);
          paramVarArgs.append(" : ");
          QLog.d("SearchTask", 2, paramVarArgs.toString());
        }
      }
      this.a = false;
      return null;
    }
    this.a = true;
    if (QLog.isColorLevel()) {
      QLog.d("SearchTask", 2, "doInBackground:: inputSet is null.");
    }
    return null;
  }
  
  @TargetApi(11)
  public void a()
  {
    executeOnExecutor(b, new Void[0]);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Start execute , keyword = ");
      localStringBuilder.append(this.d);
      QLog.d("SearchTask", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(Void paramVoid)
  {
    if (isCancelled())
    {
      this.h.clear();
      this.j.shutdown();
      if (QLog.isColorLevel()) {
        QLog.d("SearchTask", 2, "onPostExecute:: isCancelled.");
      }
      return;
    }
    paramVoid = this.i;
    if (paramVoid != null)
    {
      paramVoid.a(this.a ^ true, this.h);
      this.j.shutdown();
    }
  }
  
  protected void a(List<ISearchable> paramList)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start sortResultSet(), keyword = ");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("SearchTask", 2, ((StringBuilder)localObject).toString());
    }
    Collections.sort(paramList, k);
    int m = Math.min(paramList.size(), 30);
    Object localObject = paramList.subList(0, m);
    Collections.sort((List)localObject, l);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)localObject);
    localArrayList.addAll(paramList.subList(m, paramList.size()));
    a(paramList, "after sort ");
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("sortResultSet() time = ");
      paramList.append(System.currentTimeMillis() - l1);
      paramList.append(" , keyword = ");
      paramList.append(this.d);
      QLog.d("SearchTask", 2, paramList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchTask
 * JD-Core Version:    0.7.0.1
 */