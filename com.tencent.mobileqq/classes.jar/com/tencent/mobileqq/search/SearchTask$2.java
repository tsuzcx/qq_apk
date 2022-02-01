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
    Object localObject = SearchTask.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask).subList(this.jdField_a_of_type_Int, this.b);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      ISearchable localISearchable;
      while (((Iterator)localObject).hasNext())
      {
        localISearchable = (ISearchable)((Iterator)localObject).next();
        if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.isCancelled()) {
          break;
        }
        localISearchable.a(SearchTask.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask));
        if (localISearchable.c() != -9223372036854775808L)
        {
          int i = localArrayList.indexOf(localISearchable);
          if (-1 == i) {
            localArrayList.add(localISearchable);
          } else if (((ISearchable)localArrayList.get(i)).c() < localISearchable.c()) {
            localArrayList.set(i, localISearchable);
          }
        }
      }
      if (!SearchTask.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask).equals(SearchTask.b(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask)))
      {
        localObject = localArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localISearchable = (ISearchable)((Iterator)localObject).next();
          if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask.isCancelled()) {
            return localArrayList;
          }
          long l = localISearchable.c();
          localISearchable.a(SearchTask.b(this.jdField_a_of_type_ComTencentMobileqqSearchSearchTask));
          if (localISearchable.c() == -9223372036854775808L) {
            localISearchable.a(l);
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchTask.2
 * JD-Core Version:    0.7.0.1
 */