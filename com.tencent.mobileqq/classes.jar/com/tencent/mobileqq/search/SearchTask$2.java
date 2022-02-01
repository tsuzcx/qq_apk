package com.tencent.mobileqq.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

class SearchTask$2
  implements Callable<List<ISearchable>>
{
  SearchTask$2(SearchTask paramSearchTask, int paramInt1, int paramInt2) {}
  
  public List<ISearchable> a()
  {
    Object localObject = SearchTask.a(this.c).subList(this.a, this.b);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      ISearchable localISearchable;
      while (((Iterator)localObject).hasNext())
      {
        localISearchable = (ISearchable)((Iterator)localObject).next();
        if (this.c.isCancelled()) {
          break;
        }
        localISearchable.a(SearchTask.b(this.c));
        if (localISearchable.o() != -9223372036854775808L)
        {
          int i = localArrayList.indexOf(localISearchable);
          if (-1 == i) {
            localArrayList.add(localISearchable);
          } else if (((ISearchable)localArrayList.get(i)).o() < localISearchable.o()) {
            localArrayList.set(i, localISearchable);
          }
        }
      }
      if (!SearchTask.b(this.c).equals(SearchTask.c(this.c)))
      {
        localObject = localArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localISearchable = (ISearchable)((Iterator)localObject).next();
          if (this.c.isCancelled()) {
            return localArrayList;
          }
          long l = localISearchable.o();
          localISearchable.a(SearchTask.c(this.c));
          if (localISearchable.o() == -9223372036854775808L) {
            localISearchable.a(l);
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchTask.2
 * JD-Core Version:    0.7.0.1
 */