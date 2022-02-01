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
  private static Comparator<ISearchable> jdField_a_of_type_JavaUtilComparator = new SearchTask.3();
  private static final ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(0, 3, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new SearchTask.1());
  private static Comparator<ISearchable> jdField_b_of_type_JavaUtilComparator = new SearchTask.4();
  private final int jdField_a_of_type_Int = 300;
  private SearchTask.SearchTaskCallBack jdField_a_of_type_ComTencentMobileqqSearchSearchTask$SearchTaskCallBack;
  private String jdField_a_of_type_JavaLangString;
  private List<? extends ISearchable> jdField_a_of_type_JavaUtilList;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private List<Future<List<ISearchable>>> jdField_b_of_type_JavaUtilList;
  private List<ISearchable> c;
  
  public SearchTask(String paramString1, String paramString2, List<? extends ISearchable> paramList, SearchTask.SearchTaskCallBack paramSearchTaskCallBack)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask$SearchTaskCallBack = paramSearchTaskCallBack;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(20);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
  }
  
  private void a(List<ISearchable> paramList, String paramString)
  {
    int j = paramList.size();
    int i = 20;
    if (j <= 20) {
      i = paramList.size();
    }
    j = 0;
    while (j < i)
    {
      paramString = (IContactSearchable)paramList.get(j);
      QLog.isColorLevel();
      j += 1;
    }
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("Start doInBackground , keyword = ");
        paramVarArgs.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("SearchTask", 2, paramVarArgs.toString());
      }
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int n = k / 300;
      int i = 0;
      int j;
      while (i < n + 1)
      {
        int i1 = i * 300;
        int m = i1 + 300;
        j = m;
        if (m > k) {
          j = k;
        }
        if ((isCancelled()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
          break;
        }
        paramVarArgs = this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(new SearchTask.2(this, i1, j));
        this.jdField_b_of_type_JavaUtilList.add(paramVarArgs);
        i += 1;
      }
      try
      {
        this.c.clear();
        long l1 = System.currentTimeMillis();
        i = 0;
        while ((i < this.jdField_b_of_type_JavaUtilList.size()) && (!isCancelled()))
        {
          paramVarArgs = (List)((Future)this.jdField_b_of_type_JavaUtilList.get(i)).get();
          if (i == 0)
          {
            this.c.addAll(paramVarArgs);
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
              j = this.c.indexOf(localISearchable);
              if (-1 == j) {
                this.c.add(localISearchable);
              } else if (((ISearchable)this.c.get(j)).c() < localISearchable.c()) {
                this.c.set(j, localISearchable);
              }
            }
          }
          paramVarArgs.clear();
          i += 1;
        }
        this.jdField_b_of_type_JavaUtilList.clear();
        if (isCancelled()) {
          return null;
        }
        a(this.c);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("SearchTask ======= doInBackground time = ");
          paramVarArgs.append(l2 - l1);
          paramVarArgs.append(" , keyword = ");
          paramVarArgs.append(this.jdField_a_of_type_JavaLangString);
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
          paramVarArgs.append(this.jdField_a_of_type_JavaLangString);
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
          paramVarArgs.append(this.jdField_a_of_type_JavaLangString);
          paramVarArgs.append(" : ");
          QLog.d("SearchTask", 2, paramVarArgs.toString());
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return null;
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("SearchTask", 2, "doInBackground:: inputSet is null.");
    }
    return null;
  }
  
  @TargetApi(11)
  public void a()
  {
    executeOnExecutor(jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, new Void[0]);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Start execute , keyword = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("SearchTask", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(Void paramVoid)
  {
    if (isCancelled())
    {
      this.c.clear();
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
      if (QLog.isColorLevel()) {
        QLog.d("SearchTask", 2, "onPostExecute:: isCancelled.");
      }
      return;
    }
    paramVoid = this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask$SearchTaskCallBack;
    if (paramVoid != null)
    {
      paramVoid.a(this.jdField_a_of_type_Boolean ^ true, this.c);
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
    }
  }
  
  protected void a(List<ISearchable> paramList)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start sortResultSet(), keyword = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("SearchTask", 2, ((StringBuilder)localObject).toString());
    }
    Collections.sort(paramList, jdField_a_of_type_JavaUtilComparator);
    int i = Math.min(paramList.size(), 30);
    Object localObject = paramList.subList(0, i);
    Collections.sort((List)localObject, jdField_b_of_type_JavaUtilComparator);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)localObject);
    localArrayList.addAll(paramList.subList(i, paramList.size()));
    a(paramList, "after sort ");
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("sortResultSet() time = ");
      paramList.append(System.currentTimeMillis() - l);
      paramList.append(" , keyword = ");
      paramList.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("SearchTask", 2, paramList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchTask
 * JD-Core Version:    0.7.0.1
 */